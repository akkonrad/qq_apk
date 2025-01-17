package cooperation.qzone.thread;

import anaj;
import anak;
import anal;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Printer;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.QZLog;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.PriorityBlockingQueue;

public class QzoneThreadMonitor
{
  private static final int MAX_CHECK_THREAD_TIME = 10;
  private static final int MSG_CHECK_THREAD = 1;
  private static final String TAG = "QzoneThreadMonitor";
  private static final long THREAD_CHECK_INTERVAL_NORMAL = 500L;
  private static final long THREAD_CHECK_INTERVAL_REAL_TIME = 250L;
  private static final long THREAD_CHECK_THRESHOLD_NORMAL = 2000L;
  private static final long THREAD_CHECK_THRESHOLD_REAL_TIME = 500L;
  private static final long THREAD_DELAY_WARN_THRESHOLD = 2000L;
  private static final long THREAD_DELAY_WARN_THRESHOLD_REAL_TIME = 500L;
  public static boolean enableMonitor;
  private static QzoneThreadMonitor instance;
  private Printer handlerDumpPrinter = new anak(this);
  private ConcurrentHashMap id2Msg = new ConcurrentHashMap(8, 0.75F, 2);
  private Handler monitorHandler;
  private List realTimeThreadNames = Arrays.asList(new String[] { "RealTime_HandlerThread" });
  private List slowThreadNames = Arrays.asList(new String[] { "Report_HandlerThread" });
  private HashMap thread2Msg = new HashMap();
  
  private QzoneThreadMonitor()
  {
    HandlerThread localHandlerThread = new HandlerThread("qzone_thread_monitor");
    localHandlerThread.start();
    this.monitorHandler = new anaj(this, localHandlerThread.getLooper());
  }
  
  private static String buildStackTraceString(StackTraceElement[] paramArrayOfStackTraceElement, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramArrayOfStackTraceElement != null) && (paramArrayOfStackTraceElement.length > 0))
    {
      int j = paramArrayOfStackTraceElement.length;
      int i = 0;
      while (i < j)
      {
        StackTraceElement localStackTraceElement = paramArrayOfStackTraceElement[i];
        localStringBuilder.append(paramString).append(localStackTraceElement.toString()).append('\n');
        i += 1;
      }
    }
    return localStringBuilder.toString();
  }
  
  public static QzoneThreadMonitor getInstance()
  {
    if (instance == null) {}
    try
    {
      if (instance == null) {
        instance = new QzoneThreadMonitor();
      }
      return instance;
    }
    finally {}
  }
  
  void beginHandle(BaseHandler paramBaseHandler, Message paramMessage, long paramLong)
  {
    if (!enableMonitor) {
      break label6;
    }
    label6:
    String str;
    anal localanal;
    for (;;)
    {
      return;
      if ((paramBaseHandler != null) && (paramMessage != null)) {
        try
        {
          paramBaseHandler = paramBaseHandler.getLooper().getThread().getName();
          if (QzoneHandlerThreadFactory.mHandlerThreadMap.containsKey(paramBaseHandler))
          {
            str = String.valueOf(paramMessage.hashCode()) + paramMessage.getWhen();
            localanal = (anal)this.id2Msg.get(str);
            if (localanal == null)
            {
              QZLog.w("QzoneThreadMonitor", 1, new Object[] { "massage info missing. id=", str });
              return;
            }
          }
        }
        catch (Exception paramBaseHandler)
        {
          QLog.w("QzoneThreadMonitor", 1, "beginHandle exception:", paramBaseHandler);
          return;
        }
      }
    }
    localanal.jdField_b_of_type_Long = paramLong;
    long l = paramLong - localanal.a;
    if (localanal.jdField_b_of_type_Int != 3) {
      if (localanal.jdField_b_of_type_Int != 1) {
        break label385;
      }
    }
    label385:
    for (paramLong = 2000L;; paramLong = 500L)
    {
      if (l > paramLong) {
        QZLog.w("QzoneThreadMonitor", 1, new Object[] { "[begin handle] ", paramBaseHandler, " id=", str + " delay=", Long.valueOf(l), " what=", paramMessage.what + " msg.target=", localanal.jdField_c_of_type_JavaLangString, " msg.callback=", localanal.d });
      }
      paramMessage = (PriorityBlockingQueue)this.thread2Msg.get(paramBaseHandler);
      if (paramMessage == null) {
        break;
      }
      for (paramBaseHandler = (anal)paramMessage.peek(); (paramBaseHandler != null) && (paramBaseHandler.a < localanal.a); paramBaseHandler = (anal)paramMessage.peek()) {
        paramMessage.poll();
      }
      if (localanal.jdField_b_of_type_Int == 3) {
        break;
      }
      paramBaseHandler = Message.obtain(this.monitorHandler, 1, 0, 0, localanal);
      paramMessage = this.monitorHandler;
      if (localanal.jdField_b_of_type_Int == 1) {}
      for (paramLong = 2000L;; paramLong = 500L)
      {
        paramMessage.sendMessageDelayed(paramBaseHandler, paramLong);
        return;
      }
    }
  }
  
  public void dump(BaseHandler paramBaseHandler)
  {
    if (!enableMonitor) {}
    while ((paramBaseHandler == null) || (!QLog.isDevelopLevel())) {
      return;
    }
    QLog.d("QzoneThreadMonitor", 4, "======================================================================================");
    paramBaseHandler.dump(this.handlerDumpPrinter, "|| ");
    QLog.d("QzoneThreadMonitor", 4, "======================================================================================");
  }
  
  void enqueue(BaseHandler paramBaseHandler, Message paramMessage, long paramLong)
  {
    if (!enableMonitor) {}
    while ((paramBaseHandler == null) || (paramMessage == null)) {
      return;
    }
    for (;;)
    {
      String str1;
      int i;
      try
      {
        str1 = paramBaseHandler.getLooper().getThread().getName();
        if (!QzoneHandlerThreadFactory.mHandlerThreadMap.containsKey(str1)) {
          break;
        }
        String str2 = String.valueOf(paramMessage.hashCode()) + paramLong;
        if (paramMessage.getTarget() == null)
        {
          paramBaseHandler = "null";
          if (paramMessage.getCallback() != null) {
            break label213;
          }
          localObject = "null";
          i = 1;
          if (!this.realTimeThreadNames.contains(str1)) {
            break label225;
          }
          i = 2;
          localObject = new anal(this, str2, str1, paramMessage.what, paramBaseHandler, (String)localObject, paramLong, i);
          this.id2Msg.put(str2, localObject);
          paramMessage = (PriorityBlockingQueue)this.thread2Msg.get(str1);
          paramBaseHandler = paramMessage;
          if (paramMessage == null)
          {
            paramBaseHandler = new PriorityBlockingQueue();
            this.thread2Msg.put(str1, paramBaseHandler);
          }
          paramBaseHandler.put(localObject);
          return;
        }
      }
      catch (Exception paramBaseHandler)
      {
        QLog.w("QzoneThreadMonitor", 1, "enqueue exception:", paramBaseHandler);
        return;
      }
      paramBaseHandler = paramMessage.getTarget().toString();
      continue;
      label213:
      Object localObject = paramMessage.getCallback().toString();
      continue;
      label225:
      boolean bool = this.slowThreadNames.contains(str1);
      if (bool) {
        i = 3;
      }
    }
  }
  
  void finishHandle(BaseHandler paramBaseHandler, Message paramMessage, long paramLong)
  {
    if (!enableMonitor) {
      break label6;
    }
    label6:
    String str1;
    String str2;
    for (;;)
    {
      return;
      if ((paramBaseHandler != null) && (paramMessage != null)) {
        try
        {
          str1 = paramBaseHandler.getLooper().getThread().getName();
          if (QzoneHandlerThreadFactory.mHandlerThreadMap.containsKey(str1))
          {
            str2 = String.valueOf(paramMessage.hashCode()) + paramMessage.getWhen();
            paramBaseHandler = (anal)this.id2Msg.remove(str2);
            if (paramBaseHandler == null)
            {
              QZLog.w("QzoneThreadMonitor", 1, new Object[] { "massage info missing. id=", str2 });
              return;
            }
          }
        }
        catch (Exception paramBaseHandler)
        {
          QLog.w("QzoneThreadMonitor", 1, "finishHandle exception:", paramBaseHandler);
          return;
        }
      }
    }
    this.monitorHandler.removeMessages(1, paramBaseHandler);
    paramBaseHandler.jdField_c_of_type_Long = paramLong;
    long l = paramLong - paramBaseHandler.jdField_b_of_type_Long;
    if (paramBaseHandler.jdField_b_of_type_Int != 3) {
      if (paramBaseHandler.jdField_b_of_type_Int != 1) {
        break label304;
      }
    }
    label304:
    for (paramLong = 2000L;; paramLong = 500L)
    {
      if (l > paramLong) {
        QZLog.w("QzoneThreadMonitor", 1, new Object[] { "[finish handle] ", str1, " id=", str2 + " cost=", Long.valueOf(l), " what=", paramMessage.what + " msg.target=", paramBaseHandler.jdField_c_of_type_JavaLangString, " msg.callback=", paramBaseHandler.d });
      }
      paramMessage = (PriorityBlockingQueue)this.thread2Msg.get(str1);
      if (paramMessage == null) {
        break;
      }
      paramMessage.remove(paramBaseHandler);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.thread.QzoneThreadMonitor
 * JD-Core Version:    0.7.0.1
 */