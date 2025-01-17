package com.tencent.av.business.manager.report;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Process;
import com.tencent.av.AVLog;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.BusinessManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import jgi;
import jgj;
import jgk;
import jgl;
import jgm;
import jgn;
import jgo;
import mqq.app.MobileQQ;

public class VideoNodeReporter
  extends BusinessManager
{
  static String jdField_a_of_type_JavaLangString;
  public int a;
  Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new jgi(this);
  public Handler a;
  HandlerThread jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("VideoNodeReportThread");
  public List a;
  
  public VideoNodeReporter(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
    String[] arrayOfString = BaseApplicationImpl.processName.split(":");
    Object localObject = null;
    paramVideoAppInterface = localObject;
    if (arrayOfString != null)
    {
      paramVideoAppInterface = localObject;
      if (arrayOfString.length == 2) {
        paramVideoAppInterface = arrayOfString[1];
      }
    }
    jdField_a_of_type_JavaLangString = "avideo_node_report_" + paramVideoAppInterface;
    if (QLog.isColorLevel()) {
      QLog.d("VideoNodeReporter", 2, "construct VideoNodeReporter  sSPName = " + jdField_a_of_type_JavaLangString);
    }
  }
  
  public static String a()
  {
    return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(System.currentTimeMillis()));
  }
  
  private String a(long paramLong)
  {
    String str = BaseApplicationImpl.getApplication().getSystemSharedPreferences(jdField_a_of_type_JavaLangString, 0).getString(String.valueOf(paramLong), "");
    QLog.d("VideoNodeReporter", 1, "getSpSessionRecord roomId = " + paramLong + ",result = " + str);
    return str;
  }
  
  private void a(long paramLong, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoNodeReporter", 2, "writeSpSessionRecord,roomId = " + paramLong + ",detail = " + paramString);
    }
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSystemSharedPreferences(jdField_a_of_type_JavaLangString, 0).edit();
    localEditor.putString(String.valueOf(paramLong), paramString);
    localEditor.commit();
  }
  
  private void b(long paramLong1, int paramInt, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoNodeReporter", 2, " reportNode ,node = " + paramInt + ",value = " + paramLong2 + ",roomId = " + paramLong1);
    }
    Object localObject2 = a(paramLong1);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new jgo();
      ((jgo)localObject1).a = paramLong1;
      this.jdField_a_of_type_JavaUtilList.add(localObject1);
    }
    localObject2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a();
    if (((jgo)localObject1).a == localSessionInfo.j) {
      ((jgo)localObject1).a(localSessionInfo, (String)localObject2);
    }
    localObject2 = ((jgo)localObject1).a();
    localObject1 = ((jgo)localObject1).a(paramInt, paramLong2);
    a(paramLong1, (String)localObject2 + (String)localObject1);
  }
  
  private void c()
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSystemSharedPreferences(jdField_a_of_type_JavaLangString, 0);
    Map localMap = localSharedPreferences.getAll();
    if ((localMap != null) && (localMap.size() > 0))
    {
      QLog.d("VideoNodeReporter", 1, "checkAndReportCrashRecord, allContent.size() = " + localMap.size());
      Iterator localIterator = localMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        try
        {
          b(Long.decode((String)localEntry.getKey()).longValue());
        }
        catch (Exception localException)
        {
          QLog.d("VideoNodeReporter", 1, "checkAndReportCrashRecord Exception ", localException);
          localSharedPreferences.edit().remove((String)localEntry.getKey()).commit();
        }
      }
    }
    QLog.d("VideoNodeReporter", 1, "checkAndReportCrashRecord allContent = " + localMap);
  }
  
  private void c(long paramLong)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSystemSharedPreferences(jdField_a_of_type_JavaLangString, 0).edit();
    localEditor.remove(String.valueOf(paramLong));
    localEditor.commit();
    AVLog.d("VideoNodeReporter", "removeSpSessionRecord,roomId = " + paramLong);
  }
  
  jgo a(long paramLong)
  {
    if (this.jdField_a_of_type_JavaUtilList.size() > 0)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        jgo localjgo = (jgo)localIterator.next();
        if (paramLong == localjgo.a) {
          return localjgo;
        }
      }
    }
    return null;
  }
  
  protected void a()
  {
    AVLog.d("VideoNodeReporter", "onCreate ");
    c();
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
  }
  
  public void a(int paramInt)
  {
    QLog.d("VideoNodeReporter", 1, "updateBattery  " + paramInt);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(int paramInt, long paramLong)
  {
    QLog.d("VideoNodeReporter", 1, " report ,node = " + paramInt + ",value = " + paramLong);
    if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) || (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() == null) || (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a() == null))
    {
      AVLog.d("VideoNodeReporter", " report error 0: " + paramInt + "|" + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      return;
    }
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.e)
    {
      AVLog.d("VideoNodeReporter", " report error 1 ,exit has been called,node = " + paramInt);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new jgk(this, paramInt, paramLong));
  }
  
  protected void a(int paramInt, String paramString1, String paramString2)
  {
    AVLog.d("VideoNodeReporter", " onSessionStatusChanged :" + paramInt + ",para = " + paramString2);
    switch (paramInt)
    {
    case 2: 
    case 3: 
    default: 
      return;
    }
    if (this.jdField_a_of_type_JavaUtilList.size() > 0)
    {
      paramString1 = this.jdField_a_of_type_JavaUtilList.iterator();
      while (paramString1.hasNext()) {
        ((jgo)paramString1.next()).b = System.currentTimeMillis();
      }
    }
    a(38, this.jdField_a_of_type_Int);
  }
  
  public void a(long paramLong)
  {
    QLog.d("VideoNodeReporter", 1, "updateCallerRoomId roomId = " + paramLong);
    this.jdField_a_of_type_AndroidOsHandler.post(new jgj(this, paramLong));
  }
  
  public void a(long paramLong1, int paramInt, long paramLong2)
  {
    QLog.d("VideoNodeReporter", 1, " reportByRoomId ,node = " + paramInt + ",value = " + paramLong2);
    if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) || (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() == null) || (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a() == null))
    {
      AVLog.d("VideoNodeReporter", " reportByRoomId error 0: " + paramInt + "|" + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      return;
    }
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.e)
    {
      AVLog.d("VideoNodeReporter", " reportByRoomId error 1 ,exit has been called,node = " + paramInt);
      return;
    }
    if (paramLong1 == 0L)
    {
      QLog.d("VideoNodeReporter", 1, "reportByRoomId rooid is 0", new Throwable("test"));
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new jgl(this, paramLong1, paramInt, paramLong2));
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new jgm(this, paramString));
  }
  
  protected boolean a(String paramString)
  {
    return true;
  }
  
  public void b()
  {
    try
    {
      ActivityManager localActivityManager = (ActivityManager)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().getSystemService("activity");
      ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
      localActivityManager.getMemoryInfo(localMemoryInfo);
      long l1 = DeviceInfoUtil.a(Process.myPid()) / 1024L / 1024L;
      long l2 = localMemoryInfo.availMem / 1024L / 1024L;
      long l3 = localMemoryInfo.threshold / 1024L / 1024L;
      boolean bool = localMemoryInfo.lowMemory;
      QLog.d("VideoNodeReporter", 1, "reportMemoryStatus,availMem = " + l2 + ",threshold = " + l3 + ",isLowMemory = " + bool + ",pss = " + l1);
      a(21, l3);
      a(15, l2);
      a(22, l1);
      return;
    }
    catch (Exception localException)
    {
      QLog.d("VideoNodeReporter", 1, "reportMemoryStatus,Exception ", localException);
    }
  }
  
  public void b(long paramLong)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new jgn(this, paramLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.business.manager.report.VideoNodeReporter
 * JD-Core Version:    0.7.0.1
 */