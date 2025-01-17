package com.tencent.mobileqq.utils.httputils;

import akgy;
import akgz;
import akha;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.RichMediaStrategy;
import com.tencent.mobileqq.transfile.RichMediaStrategy.NetPolicy;
import com.tencent.mobileqq.transfile.RichMediaStrategy.OldEngineDPCProfile.TimeoutParam;
import com.tencent.mobileqq.transfile.RichMediaUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.wstt.SSCM.SSCMTimer.SSCMTimerObserver;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import javax.net.ssl.HttpsURLConnection;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

public class HttpCommunicator
  implements SSCMTimer.SSCMTimerObserver
{
  private static long jdField_a_of_type_Long = 1L;
  private int jdField_a_of_type_Int;
  private HttpCommunicator.PriorityQueue jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator$PriorityQueue = new HttpCommunicator.PriorityQueue();
  private Object jdField_a_of_type_JavaLangObject = new ReentrantLock();
  String jdField_a_of_type_JavaLangString = null;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private WeakReference jdField_a_of_type_MqqUtilWeakReference;
  boolean jdField_a_of_type_Boolean = true;
  private akha[] jdField_a_of_type_ArrayOfAkha;
  private final int jdField_b_of_type_Int = 4;
  private volatile boolean jdField_b_of_type_Boolean;
  private final int jdField_c_of_type_Int;
  private volatile boolean jdField_c_of_type_Boolean;
  private int d;
  private int e;
  
  public HttpCommunicator(IHttpCommunicatorFlowCount paramIHttpCommunicatorFlowCount, int paramInt)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramIHttpCommunicatorFlowCount);
    if (QLog.isColorLevel()) {
      QLog.d("Q.richmedia.HttpCommunicator", 2, "construct HTTPcomm");
    }
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_d_of_type_Int = 4;
    this.e = 0;
    if (Integer.parseInt(Build.VERSION.SDK) < 8) {
      System.setProperty("http.keepAlive", "false");
    }
    System.setProperty("http.maxConnections", "2");
  }
  
  private HttpURLConnection a(HttpMsg paramHttpMsg)
  {
    Object localObject1 = paramHttpMsg.a();
    String str1 = (String)paramHttpMsg.jdField_a_of_type_JavaUtilHashMap.remove("mType");
    String str2;
    int i1;
    int k;
    int i;
    label52:
    Object localObject2;
    int j;
    if (str1 != null)
    {
      str1 = MsfSdkUtils.insertMtype(str1, (String)localObject1);
      localObject1 = null;
      str2 = android.net.Proxy.getDefaultHost();
      i1 = android.net.Proxy.getDefaultPort();
      k = 0;
      i = 0;
      if ((i != 0) || (k >= 2)) {
        break label945;
      }
      localObject2 = ((ConnectivityManager)BaseApplication.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
      localObject1 = null;
      if (localObject2 == null) {
        break label954;
      }
      j = ((NetworkInfo)localObject2).getType();
      localObject1 = ((NetworkInfo)localObject2).getExtraInfo();
    }
    for (;;)
    {
      String str3 = PkgTools.b((String)localObject1);
      paramHttpMsg.jdField_f_of_type_Boolean = PkgTools.jdField_d_of_type_JavaLangString.equals(str3);
      if (!str3.equals(this.jdField_a_of_type_JavaLangString))
      {
        if ((j == 1) || (str3.equals(PkgTools.jdField_d_of_type_JavaLangString))) {
          this.jdField_a_of_type_Boolean = false;
        }
      }
      else
      {
        label151:
        if ((j == 1) && (("10.0.0.172".equals(str2)) || ("10.0.0.200".equals(str2)))) {
          this.jdField_a_of_type_Boolean = true;
        }
        if ((str2 == null) || (i1 <= 0)) {
          break label948;
        }
      }
      label285:
      label945:
      label948:
      for (int m = 1;; m = 0)
      {
        int i2;
        Object localObject3;
        int n;
        if ((!this.jdField_a_of_type_Boolean) && (m != 0)) {
          if ((str3.equals(PkgTools.jdField_d_of_type_JavaLangString)) || (str3.equals(PkgTools.jdField_f_of_type_JavaLangString)) || (str3.equals(PkgTools.h))) {
            if (!paramHttpMsg.jdField_g_of_type_Boolean) {
              switch (paramHttpMsg.jdField_h_of_type_Int)
              {
              default: 
                localObject1 = PkgTools.b(str1, str2, i1);
                i = 1;
                a((HttpURLConnection)localObject1, paramHttpMsg);
                paramHttpMsg.jdField_d_of_type_Int = j;
                i2 = NetworkCenter.a().a();
                if (paramHttpMsg.jdField_a_of_type_ComTencentMobileqqTransfileRichMediaStrategy$OldEngineDPCProfile$TimeoutParam == null)
                {
                  localObject3 = RichMediaStrategy.a(i2);
                  n = ((RichMediaStrategy.NetPolicy)localObject3).a();
                  if ("POST".equals(paramHttpMsg.e())) {
                    j = 89500;
                  }
                }
                break;
              }
            }
          }
        }
        for (;;)
        {
          ((HttpURLConnection)localObject1).setConnectTimeout(n);
          ((HttpURLConnection)localObject1).setReadTimeout(j);
          a(paramHttpMsg, "gettingConn", "getConnection type:" + i2 + " activeNetworkInfo: " + localObject2 + " defaultHost:" + str2 + " defaultPort: " + i1 + " last apnType:" + this.jdField_a_of_type_JavaLangString + " forceDirect:" + this.jdField_a_of_type_Boolean + ",connectTimeOut:" + n + ",readTimeout:" + j);
          ((HttpURLConnection)localObject1).setInstanceFollowRedirects(false);
          localObject2 = paramHttpMsg.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (Map.Entry)((Iterator)localObject2).next();
            ((HttpURLConnection)localObject1).setRequestProperty((String)((Map.Entry)localObject3).getKey(), (String)((Map.Entry)localObject3).getValue());
          }
          str1 = MsfSdkUtils.insertMtype("Other", (String)localObject1);
          break;
          this.jdField_a_of_type_Boolean = true;
          break label151;
          localObject1 = (HttpURLConnection)new URL(str1).openConnection(java.net.Proxy.NO_PROXY);
          i = 0;
          break label285;
          localObject1 = PkgTools.a(str1, str2, i1);
          i = 1;
          break label285;
          localObject1 = PkgTools.b(str1, str2, i1);
          i = 1;
          break label285;
          if (str3.equals(PkgTools.b))
          {
            localObject1 = PkgTools.a(str1, str2, i1);
            i = 1;
            break label285;
          }
          localObject1 = PkgTools.a(str1, str2, i1);
          i = 1;
          break label285;
          localObject1 = (HttpURLConnection)new URL(str1).openConnection();
          i = 0;
          break label285;
          j = ((RichMediaStrategy.NetPolicy)localObject3).b();
          continue;
          n = paramHttpMsg.jdField_a_of_type_ComTencentMobileqqTransfileRichMediaStrategy$OldEngineDPCProfile$TimeoutParam.b(i2);
          j = paramHttpMsg.jdField_a_of_type_ComTencentMobileqqTransfileRichMediaStrategy$OldEngineDPCProfile$TimeoutParam.a(i2);
        }
        if (paramHttpMsg.e().equals("POST"))
        {
          ((HttpURLConnection)localObject1).setDoOutput(true);
          if (paramHttpMsg.b() != null) {
            ((HttpURLConnection)localObject1).setFixedLengthStreamingMode(paramHttpMsg.b().length);
          }
        }
        paramHttpMsg.jdField_c_of_type_JavaLangString = ((HttpURLConnection)localObject1).getRequestProperties().toString();
        try
        {
          ((HttpURLConnection)localObject1).connect();
          i = 1;
        }
        catch (Exception localException)
        {
          while (m != 0) {
            if ((i != 0) && (m != 0))
            {
              i = 0;
              this.jdField_a_of_type_Boolean = true;
            }
            else if ((m != 0) && (i == 0))
            {
              i = 0;
              this.jdField_a_of_type_Boolean = false;
            }
            else
            {
              throw localException;
            }
          }
          throw localException;
        }
        catch (AssertionError localAssertionError)
        {
          String str4;
          for (;;)
          {
            str4 = localAssertionError.getMessage();
            if (QLog.isColorLevel()) {
              QLog.d("Q.richmedia.HttpCommunicator", 2, "assertion:" + str4);
            }
            if (m == 0) {
              break;
            }
            if ((i != 0) && (m != 0))
            {
              i = 0;
              this.jdField_a_of_type_Boolean = true;
            }
            else if ((m != 0) && (i == 0))
            {
              i = 0;
              this.jdField_a_of_type_Boolean = false;
            }
            else
            {
              i = 1;
            }
          }
          throw new SocketException("AssertionError : " + str4);
        }
        this.jdField_a_of_type_JavaLangString = str3;
        k += 1;
        break label52;
        return localObject1;
      }
      label954:
      j = -1;
    }
  }
  
  private void a(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2, int paramInt, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SSCM", 2, "msg statuschanged: " + paramInt);
      }
      paramHttpMsg1.a().a(paramHttpMsg1, paramHttpMsg2, paramInt);
    }
  }
  
  private void a(HttpURLConnection paramHttpURLConnection, HttpMsg paramHttpMsg)
  {
    String str;
    akgy localakgy;
    if ((paramHttpMsg.j) && ((paramHttpURLConnection instanceof HttpsURLConnection)))
    {
      paramHttpURLConnection = (HttpsURLConnection)paramHttpURLConnection;
      str = paramHttpMsg.jdField_e_of_type_JavaLangString;
      localakgy = new akgy(this, str, paramHttpMsg);
      if (paramHttpMsg.k)
      {
        paramHttpURLConnection.setRequestProperty("host", str);
        paramHttpURLConnection.setSSLSocketFactory(new SniSSLSocketFactory(str, localakgy));
        paramHttpURLConnection.setHostnameVerifier(localakgy);
      }
    }
    else
    {
      return;
    }
    paramHttpURLConnection.setRequestProperty("host", str);
    paramHttpURLConnection.setHostnameVerifier(localakgy);
  }
  
  public int a(HttpMsg paramHttpMsg)
  {
    int i = -1;
    int k = this.jdField_c_of_type_Int;
    int j = 1;
    if (this.jdField_c_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.richmedia.HttpCommunicator", 2, "sendMsg closed");
      }
      if ((paramHttpMsg != null) && (paramHttpMsg.a() != null))
      {
        paramHttpMsg.a(9366, -1, "close");
        paramHttpMsg.a().b(paramHttpMsg, paramHttpMsg);
        k = i;
        return k;
      }
    }
    Object localObject = this.jdField_a_of_type_JavaLangObject;
    if (paramHttpMsg != null) {}
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator$PriorityQueue.a() < k)
        {
          i = this.jdField_a_of_type_Int + 1;
          this.jdField_a_of_type_Int = i;
          paramHttpMsg.a(i);
          paramHttpMsg.jdField_g_of_type_Long = SystemClock.uptimeMillis();
          this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator$PriorityQueue.a(paramHttpMsg);
          paramHttpMsg.a().a(paramHttpMsg, null, 0);
          i = this.jdField_a_of_type_Int;
          k = i;
          if (j == 0) {
            break;
          }
          a("sendMsg");
          return i;
        }
        if (QLog.isColorLevel()) {
          QLog.e("Q.richmedia.HttpCommunicator", 2, "exceed queue limit");
        }
        if ((paramHttpMsg != null) && (paramHttpMsg.a() != null))
        {
          paramHttpMsg.a(9367, -1, "queen full");
          paramHttpMsg.a().b(paramHttpMsg, paramHttpMsg);
        }
      }
      finally {}
      j = 0;
    }
  }
  
  public void a()
  {
    int i = 0;
    if ((this.jdField_c_of_type_Boolean) || (this.jdField_b_of_type_Boolean)) {
      throw new IllegalStateException("HttpCommunicator already in using or disposed!");
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_b_of_type_Boolean = true;
      this.e = 0;
      this.jdField_a_of_type_MqqOsMqqHandler = ThreadManager.getSubThreadHandler();
      this.jdField_a_of_type_ArrayOfAkha = new akha[4];
      while (i < 4)
      {
        HandlerThread localHandlerThread = ThreadManager.newFreeHandlerThread("httpcommunicator_norm_" + i, 5);
        localHandlerThread.start();
        this.jdField_a_of_type_ArrayOfAkha[i] = new akha(this, localHandlerThread.getLooper());
        this.jdField_a_of_type_ArrayOfAkha[i].jdField_a_of_type_Int = i;
        i += 1;
      }
      i = NetworkCenter.a().a();
      if ((i == 2) || (i == 3))
      {
        this.jdField_d_of_type_Int = 3;
        return;
      }
      this.jdField_d_of_type_Int = 4;
    }
  }
  
  public void a(int paramInt)
  {
    localObject1 = this.jdField_a_of_type_JavaLangObject;
    if (paramInt == 1) {}
    for (;;)
    {
      try
      {
        this.jdField_d_of_type_Int = 4;
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        if (QLog.isColorLevel()) {
          QLog.d("Q.richmedia.HttpCommunicator", 2, "netType:" + paramInt + " concurrent:" + this.jdField_d_of_type_Int);
        }
        a("netChange");
        return;
      }
      finally {}
      this.jdField_d_of_type_Int = 3;
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    }
  }
  
  void a(int paramInt, HttpURLConnection paramHttpURLConnection, HttpMsg paramHttpMsg)
  {
    if ((paramHttpURLConnection == null) || (paramHttpMsg == null)) {
      return;
    }
    paramHttpMsg.c(paramInt);
    paramHttpMsg.b("Content-Type", paramHttpURLConnection.getContentType());
    paramHttpMsg.jdField_d_of_type_JavaLangString = paramHttpURLConnection.getHeaderFields().toString();
    if (paramHttpURLConnection.getHeaderField("User-ReturnCode") != null) {
      paramHttpMsg.b("User-ReturnCode", paramHttpURLConnection.getHeaderField("User-ReturnCode"));
    }
    if (paramHttpURLConnection.getHeaderField("X-User-ReturnCode") != null) {
      paramHttpMsg.b("X-User-ReturnCode", paramHttpURLConnection.getHeaderField("X-User-ReturnCode"));
    }
    if (paramHttpURLConnection.getHeaderField("content-range") != null) {
      paramHttpMsg.b("content-range", paramHttpURLConnection.getHeaderField("content-range"));
    }
    if (paramHttpURLConnection.getHeaderField("Range") != null) {
      paramHttpMsg.b("Range", paramHttpURLConnection.getHeaderField("Range"));
    }
    if (paramHttpURLConnection.getHeaderField("X-Range") != null) {
      paramHttpMsg.b("X-Range", paramHttpURLConnection.getHeaderField("X-Range"));
    }
    if (paramHttpURLConnection.getHeaderField("Content-Encoding") != null) {
      paramHttpMsg.b("Content-Encoding", paramHttpURLConnection.getHeaderField("Content-Encoding"));
    }
    if (paramHttpURLConnection.getHeaderField("Transfer-Encoding") != null) {
      paramHttpMsg.b("Transfer-Encoding", paramHttpURLConnection.getHeaderField("Transfer-Encoding"));
    }
    if (paramHttpURLConnection.getHeaderField("X-RtFlag") != null) {
      paramHttpMsg.b("X-RtFlag", paramHttpURLConnection.getHeaderField("X-RtFlag"));
    }
    if (paramHttpURLConnection.getHeaderField("X-httime") != null) {
      paramHttpMsg.b("X-httime", paramHttpURLConnection.getHeaderField("X-httime"));
    }
    if (paramHttpURLConnection.getHeaderField("X-piccachetime") != null) {
      paramHttpMsg.b("X-piccachetime", paramHttpURLConnection.getHeaderField("X-piccachetime"));
    }
    paramHttpMsg.jdField_a_of_type_Long = -1L;
    String str = paramHttpURLConnection.getHeaderField("content-range");
    int i;
    if (str != null) {
      i = str.lastIndexOf("/");
    }
    for (;;)
    {
      try
      {
        paramHttpMsg.jdField_a_of_type_Long = Long.valueOf(str.substring(i + 1)).longValue();
        paramHttpMsg.jdField_b_of_type_Long = paramHttpURLConnection.getContentLength();
        a(paramHttpMsg, "copyRespHeader", "resultCode:" + paramInt + " totalLen:" + paramHttpMsg.jdField_a_of_type_Long + ",totalBlockLen:" + paramHttpMsg.jdField_b_of_type_Long);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        continue;
      }
      paramHttpMsg.jdField_a_of_type_Long = paramHttpURLConnection.getContentLength();
      paramHttpMsg.jdField_b_of_type_Long = paramHttpMsg.jdField_a_of_type_Long;
    }
  }
  
  void a(long paramLong, int paramInt)
  {
    int i = 4;
    int j = (int)(2L * paramLong / 90000L);
    if (j > 4) {}
    for (;;)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_FailCode", String.valueOf(i + 9400));
      localHashMap.put("param_PostSize", String.valueOf(paramInt));
      StatisticCollector.a(BaseApplication.getContext()).a(null, "LongHttpRespTime", false, paramLong, 0L, localHashMap, "");
      return;
      i = j;
    }
  }
  
  public void a(akha paramakha)
  {
    if (this.jdField_c_of_type_Boolean) {}
    int i;
    do
    {
      do
      {
        return;
      } while (paramakha == null);
      paramakha.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      i = paramakha.jdField_a_of_type_Int;
      if ((i >= 0) && (i < 4))
      {
        ??? = new HandlerThread("httpcommunicator_norm_new_" + i, 5);
        ((HandlerThread)???).start();
        akha localakha = new akha(this, ((HandlerThread)???).getLooper());
        localakha.jdField_a_of_type_Int = i;
        synchronized (this.jdField_a_of_type_JavaLangObject)
        {
          this.jdField_a_of_type_ArrayOfAkha[i] = localakha;
          if (paramakha.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
            this.e -= 1;
          }
          a("replaceNewThread index:" + i);
          return;
        }
      }
    } while (!QLog.isColorLevel());
    QLog.e("Q.richmedia.HttpCommunicator", 2, "replaceNewThread,index error occurs. " + i);
  }
  
  void a(akha paramakha, HttpMsg paramHttpMsg)
  {
    if (!this.jdField_b_of_type_Boolean) {
      throw new IOException("httpcommunicator closed");
    }
    if (paramHttpMsg.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      throw new IOException("request cancelled");
    }
    if ((paramakha != null) && (paramakha.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())) {
      throw new RuntimeException("thread should close");
    }
    if (paramHttpMsg.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      a(paramHttpMsg, "interrupt", "preempted");
      throw new IOException("preempted by higher msg");
    }
  }
  
  public void a(HttpMsg paramHttpMsg)
  {
    if (paramHttpMsg == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator$PriorityQueue.a(paramHttpMsg);
      paramHttpMsg.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      return;
    }
  }
  
  public void a(HttpMsg paramHttpMsg, akha paramakha)
  {
    int i = 0;
    if ((paramHttpMsg != null) && (paramakha != null)) {
      try
      {
        a(paramHttpMsg, "responseTimeout", "");
        if (paramHttpMsg.b() == null) {}
        for (;;)
        {
          a(90000L, i);
          a(paramakha);
          paramHttpMsg.a(9014, 0, "response timeout");
          paramHttpMsg.a().b(paramHttpMsg, paramHttpMsg);
          return;
          i = paramHttpMsg.b().length;
        }
        return;
      }
      catch (Exception paramHttpMsg)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.richmedia.HttpCommunicator", 2, "onResponseTimeout", paramHttpMsg);
        }
      }
    }
  }
  
  /* Error */
  public void a(HttpMsg paramHttpMsg, akha paramakha, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 380	com/tencent/mobileqq/utils/httputils/HttpMsg:a	()Lcom/tencent/mobileqq/utils/httputils/IHttpCommunicatorListener;
    //   4: astore 31
    //   6: aconst_null
    //   7: astore 24
    //   9: aconst_null
    //   10: astore 29
    //   12: aconst_null
    //   13: astore 27
    //   15: aconst_null
    //   16: astore 23
    //   18: aconst_null
    //   19: astore 30
    //   21: aconst_null
    //   22: astore 28
    //   24: iconst_m1
    //   25: istore 4
    //   27: lconst_0
    //   28: lstore 13
    //   30: lconst_0
    //   31: lstore 15
    //   33: iconst_0
    //   34: istore 11
    //   36: iconst_0
    //   37: istore 8
    //   39: iconst_0
    //   40: istore 7
    //   42: aload_0
    //   43: aload_1
    //   44: aconst_null
    //   45: iconst_1
    //   46: iload_3
    //   47: invokespecial 666	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Lcom/tencent/mobileqq/utils/httputils/HttpMsg;IZ)V
    //   50: iconst_0
    //   51: istore 6
    //   53: iconst_0
    //   54: istore 11
    //   56: aconst_null
    //   57: astore 25
    //   59: aload_0
    //   60: aload_1
    //   61: ldc_w 668
    //   64: ldc_w 604
    //   67: invokevirtual 276	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   70: aload_0
    //   71: aload_2
    //   72: aload_1
    //   73: invokevirtual 670	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lakha;Lcom/tencent/mobileqq/utils/httputils/HttpMsg;)V
    //   76: aload_0
    //   77: aload_1
    //   78: invokespecial 672	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;)Ljava/net/HttpURLConnection;
    //   81: astore 26
    //   83: aload 26
    //   85: astore 24
    //   87: aload_1
    //   88: aload 24
    //   90: putfield 675	com/tencent/mobileqq/utils/httputils/HttpMsg:jdField_a_of_type_JavaNetHttpURLConnection	Ljava/net/HttpURLConnection;
    //   93: aload_1
    //   94: invokestatic 442	android/os/SystemClock:uptimeMillis	()J
    //   97: putfield 677	com/tencent/mobileqq/utils/httputils/HttpMsg:jdField_d_of_type_Long	J
    //   100: aload_0
    //   101: aload_1
    //   102: ldc_w 679
    //   105: ldc_w 604
    //   108: invokevirtual 276	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   111: iconst_1
    //   112: istore 11
    //   114: invokestatic 682	java/lang/System:currentTimeMillis	()J
    //   117: pop2
    //   118: aload_1
    //   119: invokevirtual 226	com/tencent/mobileqq/utils/httputils/HttpMsg:e	()Ljava/lang/String;
    //   122: ldc 224
    //   124: invokevirtual 180	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   127: ifeq +5210 -> 5337
    //   130: new 684	akgx
    //   133: dup
    //   134: aload_0
    //   135: aload_1
    //   136: aload_2
    //   137: invokespecial 687	akgx:<init>	(Lcom/tencent/mobileqq/utils/httputils/HttpCommunicator;Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Lakha;)V
    //   140: astore 26
    //   142: aload_0
    //   143: getfield 470	com/tencent/mobileqq/utils/httputils/HttpCommunicator:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   146: aload 26
    //   148: ldc2_w 583
    //   151: invokevirtual 693	mqq/os/MqqHandler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   154: pop
    //   155: aload_1
    //   156: invokevirtual 349	com/tencent/mobileqq/utils/httputils/HttpMsg:b	()[B
    //   159: astore 32
    //   161: aload 24
    //   163: invokevirtual 697	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   166: astore 25
    //   168: aload_0
    //   169: aload_1
    //   170: ldc_w 699
    //   173: new 240	java/lang/StringBuilder
    //   176: dup
    //   177: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   180: ldc_w 701
    //   183: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: aload 32
    //   188: arraylength
    //   189: invokevirtual 250	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   192: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   195: invokevirtual 276	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   198: iconst_0
    //   199: istore 5
    //   201: iload 5
    //   203: aload 32
    //   205: arraylength
    //   206: if_icmpge +46 -> 252
    //   209: aload_0
    //   210: aload_2
    //   211: aload_1
    //   212: invokevirtual 670	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lakha;Lcom/tencent/mobileqq/utils/httputils/HttpMsg;)V
    //   215: aload 25
    //   217: aload 32
    //   219: iload 5
    //   221: sipush 10240
    //   224: aload 32
    //   226: arraylength
    //   227: iload 5
    //   229: isub
    //   230: invokestatic 707	java/lang/Math:min	(II)I
    //   233: invokevirtual 713	java/io/OutputStream:write	([BII)V
    //   236: aload 25
    //   238: invokevirtual 716	java/io/OutputStream:flush	()V
    //   241: iload 5
    //   243: sipush 10240
    //   246: iadd
    //   247: istore 5
    //   249: goto -48 -> 201
    //   252: aload_2
    //   253: ifnull +13 -> 266
    //   256: aload_2
    //   257: getfield 610	akha:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   260: invokevirtual 619	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   263: ifne +14 -> 277
    //   266: aload_0
    //   267: aload_1
    //   268: ldc_w 718
    //   271: ldc_w 604
    //   274: invokevirtual 276	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   277: aload 24
    //   279: invokevirtual 722	java/net/HttpURLConnection:getURL	()Ljava/net/URL;
    //   282: invokevirtual 723	java/net/URL:toString	()Ljava/lang/String;
    //   285: invokevirtual 726	java/lang/String:length	()I
    //   288: i2l
    //   289: lstore 17
    //   291: aload 32
    //   293: arraylength
    //   294: istore 5
    //   296: lload 13
    //   298: iload 5
    //   300: i2l
    //   301: ldc2_w 727
    //   304: lload 17
    //   306: ladd
    //   307: ladd
    //   308: ladd
    //   309: lstore 13
    //   311: aload_0
    //   312: aload_2
    //   313: aload_1
    //   314: invokevirtual 670	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lakha;Lcom/tencent/mobileqq/utils/httputils/HttpMsg;)V
    //   317: aload 24
    //   319: invokevirtual 731	java/net/HttpURLConnection:getResponseCode	()I
    //   322: istore 5
    //   324: aload_0
    //   325: iload 5
    //   327: aload 24
    //   329: aload_1
    //   330: invokevirtual 733	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(ILjava/net/HttpURLConnection;Lcom/tencent/mobileqq/utils/httputils/HttpMsg;)V
    //   333: aload_2
    //   334: ifnull +231 -> 565
    //   337: aload_2
    //   338: getfield 610	akha:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   341: invokevirtual 619	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   344: istore 12
    //   346: iload 12
    //   348: ifeq +217 -> 565
    //   351: iload 5
    //   353: sipush 200
    //   356: if_icmpeq +11 -> 367
    //   359: iload 5
    //   361: sipush 206
    //   364: if_icmpne +31 -> 395
    //   367: aload_0
    //   368: aload_1
    //   369: ldc_w 735
    //   372: new 240	java/lang/StringBuilder
    //   375: dup
    //   376: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   379: ldc_w 737
    //   382: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   385: iconst_0
    //   386: invokevirtual 250	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   389: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   392: invokevirtual 276	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   395: aload_2
    //   396: ifnull +13 -> 409
    //   399: aload_2
    //   400: getfield 610	akha:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   403: invokevirtual 619	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   406: ifne +47 -> 453
    //   409: aload_0
    //   410: aload_1
    //   411: ldc_w 739
    //   414: new 240	java/lang/StringBuilder
    //   417: dup
    //   418: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   421: ldc_w 741
    //   424: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: aload_1
    //   428: invokevirtual 743	com/tencent/mobileqq/utils/httputils/HttpMsg:d	()Ljava/lang/String;
    //   431: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: ldc_w 745
    //   437: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   440: aload_1
    //   441: invokevirtual 747	com/tencent/mobileqq/utils/httputils/HttpMsg:c	()Ljava/lang/String;
    //   444: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   447: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   450: invokevirtual 276	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   453: aload_0
    //   454: getfield 470	com/tencent/mobileqq/utils/httputils/HttpCommunicator:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   457: ifnull +17 -> 474
    //   460: aload 26
    //   462: ifnull +12 -> 474
    //   465: aload_0
    //   466: getfield 470	com/tencent/mobileqq/utils/httputils/HttpCommunicator:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   469: aload 26
    //   471: invokevirtual 751	mqq/os/MqqHandler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   474: lload 13
    //   476: lconst_0
    //   477: ladd
    //   478: lstore 13
    //   480: lload 13
    //   482: lconst_0
    //   483: lcmp
    //   484: ifeq +25 -> 509
    //   487: aload_1
    //   488: invokevirtual 226	com/tencent/mobileqq/utils/httputils/HttpMsg:e	()Ljava/lang/String;
    //   491: ldc 224
    //   493: invokevirtual 180	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   496: ifeq +58 -> 554
    //   499: iconst_1
    //   500: istore_3
    //   501: aload_0
    //   502: aload_1
    //   503: iload_3
    //   504: lload 13
    //   506: invokevirtual 754	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;ZJ)V
    //   509: iconst_0
    //   510: ifeq +11 -> 521
    //   513: new 756	java/lang/NullPointerException
    //   516: dup
    //   517: invokespecial 757	java/lang/NullPointerException:<init>	()V
    //   520: athrow
    //   521: iconst_0
    //   522: ifeq +11 -> 533
    //   525: new 756	java/lang/NullPointerException
    //   528: dup
    //   529: invokespecial 757	java/lang/NullPointerException:<init>	()V
    //   532: athrow
    //   533: aload 25
    //   535: ifnull +8 -> 543
    //   538: aload 25
    //   540: invokevirtual 759	java/io/OutputStream:close	()V
    //   543: aload 24
    //   545: ifnull +8 -> 553
    //   548: aload 24
    //   550: invokevirtual 762	java/net/HttpURLConnection:disconnect	()V
    //   553: return
    //   554: iconst_0
    //   555: istore_3
    //   556: goto -55 -> 501
    //   559: astore_1
    //   560: aload_1
    //   561: invokevirtual 579	java/lang/Exception:printStackTrace	()V
    //   564: return
    //   565: aload_0
    //   566: getfield 470	com/tencent/mobileqq/utils/httputils/HttpCommunicator:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   569: ifnull +17 -> 586
    //   572: aload 26
    //   574: ifnull +12 -> 586
    //   577: aload_0
    //   578: getfield 470	com/tencent/mobileqq/utils/httputils/HttpCommunicator:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   581: aload 26
    //   583: invokevirtual 751	mqq/os/MqqHandler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   586: aload_0
    //   587: aload_1
    //   588: ldc_w 764
    //   591: new 240	java/lang/StringBuilder
    //   594: dup
    //   595: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   598: ldc_w 766
    //   601: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   604: iload 5
    //   606: invokevirtual 250	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   609: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   612: invokevirtual 276	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   615: iload 5
    //   617: sipush 302
    //   620: if_icmpeq +11 -> 631
    //   623: iload 5
    //   625: sipush 301
    //   628: if_icmpne +1584 -> 2212
    //   631: iload 6
    //   633: iconst_5
    //   634: if_icmpge +1289 -> 1923
    //   637: aload_0
    //   638: aload_1
    //   639: ldc_w 768
    //   642: new 240	java/lang/StringBuilder
    //   645: dup
    //   646: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   649: ldc_w 770
    //   652: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   655: aload_1
    //   656: getfield 359	com/tencent/mobileqq/utils/httputils/HttpMsg:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   659: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   662: ldc_w 772
    //   665: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   668: aload_1
    //   669: getfield 516	com/tencent/mobileqq/utils/httputils/HttpMsg:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   672: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   675: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   678: invokevirtual 276	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   681: aload 24
    //   683: ldc_w 774
    //   686: invokevirtual 521	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   689: astore 32
    //   691: aload 32
    //   693: ifnull +758 -> 1451
    //   696: aload 25
    //   698: ifnull +8 -> 706
    //   701: aload 25
    //   703: invokevirtual 759	java/io/OutputStream:close	()V
    //   706: aload 24
    //   708: invokevirtual 762	java/net/HttpURLConnection:disconnect	()V
    //   711: iload 6
    //   713: ifne +377 -> 1090
    //   716: aload_1
    //   717: getfield 777	com/tencent/mobileqq/utils/httputils/HttpMsg:l	Z
    //   720: istore 12
    //   722: iload 12
    //   724: ifeq +366 -> 1090
    //   727: aload_1
    //   728: getfield 779	com/tencent/mobileqq/utils/httputils/HttpMsg:jdField_h_of_type_Boolean	Z
    //   731: ifeq +322 -> 1053
    //   734: aload_1
    //   735: invokevirtual 782	com/tencent/mobileqq/utils/httputils/HttpMsg:a	()Ljava/util/HashMap;
    //   738: ldc_w 402
    //   741: invokevirtual 784	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   744: checkcast 129	java/lang/String
    //   747: astore 23
    //   749: aload 23
    //   751: invokestatic 790	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   754: ifne +336 -> 1090
    //   757: aload 23
    //   759: ldc_w 792
    //   762: invokevirtual 180	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   765: ifeq +325 -> 1090
    //   768: new 314	java/net/URL
    //   771: dup
    //   772: aload 32
    //   774: invokespecial 317	java/net/URL:<init>	(Ljava/lang/String;)V
    //   777: invokevirtual 795	java/net/URL:getHost	()Ljava/lang/String;
    //   780: invokestatic 800	com/tencent/mobileqq/pic/StructMsgPicPreDelegate:a	(Ljava/lang/String;)Z
    //   783: istore 12
    //   785: iload 12
    //   787: ifne +303 -> 1090
    //   790: iload 5
    //   792: sipush 200
    //   795: if_icmpeq +11 -> 806
    //   798: iload 5
    //   800: sipush 206
    //   803: if_icmpne +31 -> 834
    //   806: aload_0
    //   807: aload_1
    //   808: ldc_w 735
    //   811: new 240	java/lang/StringBuilder
    //   814: dup
    //   815: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   818: ldc_w 737
    //   821: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   824: iconst_0
    //   825: invokevirtual 250	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   828: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   831: invokevirtual 276	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   834: aload_2
    //   835: ifnull +13 -> 848
    //   838: aload_2
    //   839: getfield 610	akha:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   842: invokevirtual 619	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   845: ifne +101 -> 946
    //   848: aload_0
    //   849: aload_1
    //   850: ldc_w 739
    //   853: new 240	java/lang/StringBuilder
    //   856: dup
    //   857: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   860: ldc_w 741
    //   863: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   866: aload_1
    //   867: invokevirtual 743	com/tencent/mobileqq/utils/httputils/HttpMsg:d	()Ljava/lang/String;
    //   870: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   873: ldc_w 745
    //   876: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   879: aload_1
    //   880: invokevirtual 747	com/tencent/mobileqq/utils/httputils/HttpMsg:c	()Ljava/lang/String;
    //   883: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   886: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   889: invokevirtual 276	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   892: aload_1
    //   893: getfield 802	com/tencent/mobileqq/utils/httputils/HttpMsg:jdField_f_of_type_Int	I
    //   896: sipush -9527
    //   899: if_icmpne +47 -> 946
    //   902: aload_0
    //   903: aload_1
    //   904: ldc_w 804
    //   907: new 240	java/lang/StringBuilder
    //   910: dup
    //   911: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   914: ldc_w 770
    //   917: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   920: aload_1
    //   921: getfield 359	com/tencent/mobileqq/utils/httputils/HttpMsg:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   924: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   927: ldc_w 772
    //   930: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   933: aload_1
    //   934: getfield 516	com/tencent/mobileqq/utils/httputils/HttpMsg:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   937: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   940: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   943: invokevirtual 276	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   946: aload_0
    //   947: getfield 470	com/tencent/mobileqq/utils/httputils/HttpCommunicator:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   950: ifnull +17 -> 967
    //   953: aload 26
    //   955: ifnull +12 -> 967
    //   958: aload_0
    //   959: getfield 470	com/tencent/mobileqq/utils/httputils/HttpCommunicator:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   962: aload 26
    //   964: invokevirtual 751	mqq/os/MqqHandler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   967: lload 13
    //   969: lconst_0
    //   970: ladd
    //   971: lstore 13
    //   973: lload 13
    //   975: lconst_0
    //   976: lcmp
    //   977: ifeq +25 -> 1002
    //   980: aload_1
    //   981: invokevirtual 226	com/tencent/mobileqq/utils/httputils/HttpMsg:e	()Ljava/lang/String;
    //   984: ldc 224
    //   986: invokevirtual 180	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   989: ifeq +83 -> 1072
    //   992: iconst_1
    //   993: istore_3
    //   994: aload_0
    //   995: aload_1
    //   996: iload_3
    //   997: lload 13
    //   999: invokevirtual 754	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;ZJ)V
    //   1002: iconst_0
    //   1003: ifeq +11 -> 1014
    //   1006: new 756	java/lang/NullPointerException
    //   1009: dup
    //   1010: invokespecial 757	java/lang/NullPointerException:<init>	()V
    //   1013: athrow
    //   1014: iconst_0
    //   1015: ifeq +11 -> 1026
    //   1018: new 756	java/lang/NullPointerException
    //   1021: dup
    //   1022: invokespecial 757	java/lang/NullPointerException:<init>	()V
    //   1025: athrow
    //   1026: aload 25
    //   1028: ifnull +8 -> 1036
    //   1031: aload 25
    //   1033: invokevirtual 759	java/io/OutputStream:close	()V
    //   1036: aload 24
    //   1038: ifnull -485 -> 553
    //   1041: aload 24
    //   1043: invokevirtual 762	java/net/HttpURLConnection:disconnect	()V
    //   1046: return
    //   1047: astore_1
    //   1048: aload_1
    //   1049: invokevirtual 579	java/lang/Exception:printStackTrace	()V
    //   1052: return
    //   1053: new 314	java/net/URL
    //   1056: dup
    //   1057: aload_1
    //   1058: invokevirtual 116	com/tencent/mobileqq/utils/httputils/HttpMsg:a	()Ljava/lang/String;
    //   1061: invokespecial 317	java/net/URL:<init>	(Ljava/lang/String;)V
    //   1064: invokevirtual 795	java/net/URL:getHost	()Ljava/lang/String;
    //   1067: astore 23
    //   1069: goto -320 -> 749
    //   1072: iconst_0
    //   1073: istore_3
    //   1074: goto -80 -> 994
    //   1077: astore 23
    //   1079: aload_0
    //   1080: aload_1
    //   1081: ldc_w 806
    //   1084: ldc_w 808
    //   1087: invokevirtual 276	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   1090: aload_1
    //   1091: invokevirtual 810	com/tencent/mobileqq/utils/httputils/HttpMsg:b	()Z
    //   1094: ifne +226 -> 1320
    //   1097: aload 31
    //   1099: aload 32
    //   1101: invokeinterface 811 2 0
    //   1106: iload 5
    //   1108: sipush 200
    //   1111: if_icmpeq +11 -> 1122
    //   1114: iload 5
    //   1116: sipush 206
    //   1119: if_icmpne +31 -> 1150
    //   1122: aload_0
    //   1123: aload_1
    //   1124: ldc_w 735
    //   1127: new 240	java/lang/StringBuilder
    //   1130: dup
    //   1131: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   1134: ldc_w 737
    //   1137: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1140: iconst_0
    //   1141: invokevirtual 250	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1144: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1147: invokevirtual 276	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   1150: aload_2
    //   1151: ifnull +13 -> 1164
    //   1154: aload_2
    //   1155: getfield 610	akha:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   1158: invokevirtual 619	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   1161: ifne +47 -> 1208
    //   1164: aload_0
    //   1165: aload_1
    //   1166: ldc_w 739
    //   1169: new 240	java/lang/StringBuilder
    //   1172: dup
    //   1173: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   1176: ldc_w 741
    //   1179: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1182: aload_1
    //   1183: invokevirtual 743	com/tencent/mobileqq/utils/httputils/HttpMsg:d	()Ljava/lang/String;
    //   1186: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1189: ldc_w 745
    //   1192: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1195: aload_1
    //   1196: invokevirtual 747	com/tencent/mobileqq/utils/httputils/HttpMsg:c	()Ljava/lang/String;
    //   1199: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1202: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1205: invokevirtual 276	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   1208: aload_0
    //   1209: getfield 470	com/tencent/mobileqq/utils/httputils/HttpCommunicator:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   1212: ifnull +17 -> 1229
    //   1215: aload 26
    //   1217: ifnull +12 -> 1229
    //   1220: aload_0
    //   1221: getfield 470	com/tencent/mobileqq/utils/httputils/HttpCommunicator:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   1224: aload 26
    //   1226: invokevirtual 751	mqq/os/MqqHandler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   1229: lload 13
    //   1231: lconst_0
    //   1232: ladd
    //   1233: lstore 13
    //   1235: lload 13
    //   1237: lconst_0
    //   1238: lcmp
    //   1239: ifeq +25 -> 1264
    //   1242: aload_1
    //   1243: invokevirtual 226	com/tencent/mobileqq/utils/httputils/HttpMsg:e	()Ljava/lang/String;
    //   1246: ldc 224
    //   1248: invokevirtual 180	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1251: ifeq +64 -> 1315
    //   1254: iconst_1
    //   1255: istore_3
    //   1256: aload_0
    //   1257: aload_1
    //   1258: iload_3
    //   1259: lload 13
    //   1261: invokevirtual 754	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;ZJ)V
    //   1264: iconst_0
    //   1265: ifeq +11 -> 1276
    //   1268: new 756	java/lang/NullPointerException
    //   1271: dup
    //   1272: invokespecial 757	java/lang/NullPointerException:<init>	()V
    //   1275: athrow
    //   1276: iconst_0
    //   1277: ifeq +11 -> 1288
    //   1280: new 756	java/lang/NullPointerException
    //   1283: dup
    //   1284: invokespecial 757	java/lang/NullPointerException:<init>	()V
    //   1287: athrow
    //   1288: aload 25
    //   1290: ifnull +8 -> 1298
    //   1293: aload 25
    //   1295: invokevirtual 759	java/io/OutputStream:close	()V
    //   1298: aload 24
    //   1300: ifnull -747 -> 553
    //   1303: aload 24
    //   1305: invokevirtual 762	java/net/HttpURLConnection:disconnect	()V
    //   1308: return
    //   1309: astore_1
    //   1310: aload_1
    //   1311: invokevirtual 579	java/lang/Exception:printStackTrace	()V
    //   1314: return
    //   1315: iconst_0
    //   1316: istore_3
    //   1317: goto -61 -> 1256
    //   1320: aload_1
    //   1321: getfield 812	com/tencent/mobileqq/utils/httputils/HttpMsg:jdField_c_of_type_Boolean	Z
    //   1324: ifeq +12 -> 1336
    //   1327: aload 31
    //   1329: aload 32
    //   1331: invokeinterface 811 2 0
    //   1336: aload_1
    //   1337: getfield 815	com/tencent/mobileqq/utils/httputils/HttpMsg:i	Z
    //   1340: ifne +14 -> 1354
    //   1343: aload_1
    //   1344: ldc_w 817
    //   1347: aload_1
    //   1348: invokevirtual 116	com/tencent/mobileqq/utils/httputils/HttpMsg:a	()Ljava/lang/String;
    //   1351: invokevirtual 819	com/tencent/mobileqq/utils/httputils/HttpMsg:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   1354: aload_1
    //   1355: aload 32
    //   1357: invokevirtual 820	com/tencent/mobileqq/utils/httputils/HttpMsg:a	(Ljava/lang/String;)V
    //   1360: aload_1
    //   1361: getfield 779	com/tencent/mobileqq/utils/httputils/HttpMsg:jdField_h_of_type_Boolean	Z
    //   1364: ifeq +56 -> 1420
    //   1367: aload 32
    //   1369: invokestatic 824	com/tencent/mobileqq/transfile/dns/InnerDns:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1372: astore 23
    //   1374: aload 23
    //   1376: invokestatic 790	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1379: ifne +12 -> 1391
    //   1382: aload_1
    //   1383: ldc_w 402
    //   1386: aload 23
    //   1388: invokevirtual 819	com/tencent/mobileqq/utils/httputils/HttpMsg:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   1391: aload_0
    //   1392: aload_1
    //   1393: ldc_w 768
    //   1396: new 240	java/lang/StringBuilder
    //   1399: dup
    //   1400: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   1403: ldc_w 826
    //   1406: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1409: aload 23
    //   1411: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1414: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1417: invokevirtual 276	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   1420: aload_1
    //   1421: ldc_w 828
    //   1424: invokevirtual 830	com/tencent/mobileqq/utils/httputils/HttpMsg:b	(Ljava/lang/String;)V
    //   1427: iload 6
    //   1429: iconst_1
    //   1430: iadd
    //   1431: istore 6
    //   1433: iload 5
    //   1435: istore 4
    //   1437: aload 25
    //   1439: astore 23
    //   1441: iconst_1
    //   1442: istore 11
    //   1444: aload 26
    //   1446: astore 25
    //   1448: goto -1389 -> 59
    //   1451: new 626	java/io/IOException
    //   1454: dup
    //   1455: ldc_w 832
    //   1458: invokespecial 629	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   1461: athrow
    //   1462: astore 29
    //   1464: aload 26
    //   1466: astore 28
    //   1468: iconst_0
    //   1469: istore 6
    //   1471: iconst_1
    //   1472: istore_3
    //   1473: lconst_0
    //   1474: lstore 17
    //   1476: iload 5
    //   1478: istore 4
    //   1480: aload 24
    //   1482: astore 23
    //   1484: aconst_null
    //   1485: astore 24
    //   1487: aconst_null
    //   1488: astore 27
    //   1490: aload 25
    //   1492: astore 26
    //   1494: aload 24
    //   1496: astore 25
    //   1498: lload 13
    //   1500: lstore 15
    //   1502: lload 17
    //   1504: lstore 13
    //   1506: iload 6
    //   1508: istore 5
    //   1510: aload 28
    //   1512: astore 24
    //   1514: aload 29
    //   1516: astore 28
    //   1518: iconst_1
    //   1519: istore 6
    //   1521: aload 28
    //   1523: instanceof 626
    //   1526: istore 11
    //   1528: iload 11
    //   1530: ifeq +62 -> 1592
    //   1533: aload 23
    //   1535: ifnull +57 -> 1592
    //   1538: aconst_null
    //   1539: astore 30
    //   1541: aload 23
    //   1543: invokevirtual 836	java/net/HttpURLConnection:getErrorStream	()Ljava/io/InputStream;
    //   1546: astore 29
    //   1548: aload 29
    //   1550: astore 30
    //   1552: sipush 10240
    //   1555: newarray byte
    //   1557: astore 32
    //   1559: aload 29
    //   1561: ifnull +21 -> 1582
    //   1564: aload 29
    //   1566: astore 30
    //   1568: aload 29
    //   1570: aload 32
    //   1572: invokevirtual 842	java/io/InputStream:read	([B)I
    //   1575: istore 7
    //   1577: iload 7
    //   1579: ifgt -15 -> 1564
    //   1582: aload 29
    //   1584: ifnull +8 -> 1592
    //   1587: aload 29
    //   1589: invokevirtual 843	java/io/InputStream:close	()V
    //   1592: aload_0
    //   1593: iload_3
    //   1594: iload 4
    //   1596: aload 23
    //   1598: aload_1
    //   1599: aload 28
    //   1601: invokevirtual 846	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(ZILjava/net/HttpURLConnection;Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/Throwable;)V
    //   1604: iload_3
    //   1605: ifeq +48 -> 1653
    //   1608: iload 4
    //   1610: sipush 200
    //   1613: if_icmpeq +11 -> 1624
    //   1616: iload 4
    //   1618: sipush 206
    //   1621: if_icmpne +32 -> 1653
    //   1624: aload_0
    //   1625: aload_1
    //   1626: ldc_w 735
    //   1629: new 240	java/lang/StringBuilder
    //   1632: dup
    //   1633: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   1636: ldc_w 737
    //   1639: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1642: iload 5
    //   1644: invokevirtual 250	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1647: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1650: invokevirtual 276	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   1653: aload_2
    //   1654: ifnull +13 -> 1667
    //   1657: aload_2
    //   1658: getfield 610	akha:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   1661: invokevirtual 619	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   1664: ifne +101 -> 1765
    //   1667: aload_0
    //   1668: aload_1
    //   1669: ldc_w 739
    //   1672: new 240	java/lang/StringBuilder
    //   1675: dup
    //   1676: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   1679: ldc_w 741
    //   1682: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1685: aload_1
    //   1686: invokevirtual 743	com/tencent/mobileqq/utils/httputils/HttpMsg:d	()Ljava/lang/String;
    //   1689: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1692: ldc_w 745
    //   1695: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1698: aload_1
    //   1699: invokevirtual 747	com/tencent/mobileqq/utils/httputils/HttpMsg:c	()Ljava/lang/String;
    //   1702: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1705: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1708: invokevirtual 276	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   1711: aload_1
    //   1712: getfield 802	com/tencent/mobileqq/utils/httputils/HttpMsg:jdField_f_of_type_Int	I
    //   1715: sipush -9527
    //   1718: if_icmpne +47 -> 1765
    //   1721: aload_0
    //   1722: aload_1
    //   1723: ldc_w 804
    //   1726: new 240	java/lang/StringBuilder
    //   1729: dup
    //   1730: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   1733: ldc_w 770
    //   1736: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1739: aload_1
    //   1740: getfield 359	com/tencent/mobileqq/utils/httputils/HttpMsg:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   1743: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1746: ldc_w 772
    //   1749: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1752: aload_1
    //   1753: getfield 516	com/tencent/mobileqq/utils/httputils/HttpMsg:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   1756: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1759: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1762: invokevirtual 276	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   1765: aload_0
    //   1766: getfield 470	com/tencent/mobileqq/utils/httputils/HttpCommunicator:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   1769: ifnull +17 -> 1786
    //   1772: aload 24
    //   1774: ifnull +12 -> 1786
    //   1777: aload_0
    //   1778: getfield 470	com/tencent/mobileqq/utils/httputils/HttpCommunicator:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   1781: aload 24
    //   1783: invokevirtual 751	mqq/os/MqqHandler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   1786: lload 15
    //   1788: lload 13
    //   1790: ladd
    //   1791: lstore 13
    //   1793: lload 13
    //   1795: lconst_0
    //   1796: lcmp
    //   1797: ifeq +25 -> 1822
    //   1800: aload_1
    //   1801: invokevirtual 226	com/tencent/mobileqq/utils/httputils/HttpMsg:e	()Ljava/lang/String;
    //   1804: ldc 224
    //   1806: invokevirtual 180	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1809: ifeq +2545 -> 4354
    //   1812: iconst_1
    //   1813: istore_3
    //   1814: aload_0
    //   1815: aload_1
    //   1816: iload_3
    //   1817: lload 13
    //   1819: invokevirtual 754	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;ZJ)V
    //   1822: aload 25
    //   1824: ifnull +8 -> 1832
    //   1827: aload 25
    //   1829: invokevirtual 849	java/io/ByteArrayOutputStream:close	()V
    //   1832: aload 27
    //   1834: ifnull +8 -> 1842
    //   1837: aload 27
    //   1839: invokevirtual 843	java/io/InputStream:close	()V
    //   1842: aload 26
    //   1844: ifnull +8 -> 1852
    //   1847: aload 26
    //   1849: invokevirtual 759	java/io/OutputStream:close	()V
    //   1852: iload 6
    //   1854: istore 5
    //   1856: aload 23
    //   1858: ifnull +12 -> 1870
    //   1861: aload 23
    //   1863: invokevirtual 762	java/net/HttpURLConnection:disconnect	()V
    //   1866: iload 6
    //   1868: istore 5
    //   1870: aload_2
    //   1871: ifnull +13 -> 1884
    //   1874: aload_2
    //   1875: getfield 610	akha:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   1878: invokevirtual 619	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   1881: ifne -1328 -> 553
    //   1884: aload_1
    //   1885: getfield 630	com/tencent/mobileqq/utils/httputils/HttpMsg:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   1888: invokevirtual 619	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   1891: ifne -1338 -> 553
    //   1894: iload 5
    //   1896: ifeq +2490 -> 4386
    //   1899: aload 31
    //   1901: aload_1
    //   1902: aload_1
    //   1903: invokeinterface 431 3 0
    //   1908: return
    //   1909: astore_2
    //   1910: aload_0
    //   1911: aload_1
    //   1912: ldc_w 851
    //   1915: aload_2
    //   1916: invokestatic 857	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1919: invokevirtual 276	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   1922: return
    //   1923: new 109	java/lang/Exception
    //   1926: dup
    //   1927: ldc_w 859
    //   1930: invokespecial 860	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   1933: athrow
    //   1934: astore 23
    //   1936: iconst_0
    //   1937: istore 4
    //   1939: iload 11
    //   1941: istore_3
    //   1942: iload 7
    //   1944: istore 6
    //   1946: iload_3
    //   1947: ifeq +48 -> 1995
    //   1950: iload 5
    //   1952: sipush 200
    //   1955: if_icmpeq +11 -> 1966
    //   1958: iload 5
    //   1960: sipush 206
    //   1963: if_icmpne +32 -> 1995
    //   1966: aload_0
    //   1967: aload_1
    //   1968: ldc_w 735
    //   1971: new 240	java/lang/StringBuilder
    //   1974: dup
    //   1975: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   1978: ldc_w 737
    //   1981: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1984: iload 6
    //   1986: invokevirtual 250	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1989: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1992: invokevirtual 276	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   1995: aload_2
    //   1996: ifnull +13 -> 2009
    //   1999: aload_2
    //   2000: getfield 610	akha:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   2003: invokevirtual 619	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   2006: ifne +106 -> 2112
    //   2009: aload_0
    //   2010: aload_1
    //   2011: ldc_w 739
    //   2014: new 240	java/lang/StringBuilder
    //   2017: dup
    //   2018: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   2021: ldc_w 741
    //   2024: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2027: aload_1
    //   2028: invokevirtual 743	com/tencent/mobileqq/utils/httputils/HttpMsg:d	()Ljava/lang/String;
    //   2031: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2034: ldc_w 745
    //   2037: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2040: aload_1
    //   2041: invokevirtual 747	com/tencent/mobileqq/utils/httputils/HttpMsg:c	()Ljava/lang/String;
    //   2044: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2047: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2050: invokevirtual 276	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   2053: iload 4
    //   2055: ifeq +57 -> 2112
    //   2058: aload_1
    //   2059: getfield 802	com/tencent/mobileqq/utils/httputils/HttpMsg:jdField_f_of_type_Int	I
    //   2062: sipush -9527
    //   2065: if_icmpne +47 -> 2112
    //   2068: aload_0
    //   2069: aload_1
    //   2070: ldc_w 804
    //   2073: new 240	java/lang/StringBuilder
    //   2076: dup
    //   2077: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   2080: ldc_w 770
    //   2083: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2086: aload_1
    //   2087: getfield 359	com/tencent/mobileqq/utils/httputils/HttpMsg:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   2090: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2093: ldc_w 772
    //   2096: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2099: aload_1
    //   2100: getfield 516	com/tencent/mobileqq/utils/httputils/HttpMsg:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   2103: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2106: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2109: invokevirtual 276	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   2112: aload_0
    //   2113: getfield 470	com/tencent/mobileqq/utils/httputils/HttpCommunicator:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   2116: ifnull +17 -> 2133
    //   2119: aload 26
    //   2121: ifnull +12 -> 2133
    //   2124: aload_0
    //   2125: getfield 470	com/tencent/mobileqq/utils/httputils/HttpCommunicator:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   2128: aload 26
    //   2130: invokevirtual 751	mqq/os/MqqHandler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   2133: lload 13
    //   2135: lload 15
    //   2137: ladd
    //   2138: lstore 13
    //   2140: lload 13
    //   2142: lconst_0
    //   2143: lcmp
    //   2144: ifeq +25 -> 2169
    //   2147: aload_1
    //   2148: invokevirtual 226	com/tencent/mobileqq/utils/httputils/HttpMsg:e	()Ljava/lang/String;
    //   2151: ldc 224
    //   2153: invokevirtual 180	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2156: ifeq +2217 -> 4373
    //   2159: iconst_1
    //   2160: istore_3
    //   2161: aload_0
    //   2162: aload_1
    //   2163: iload_3
    //   2164: lload 13
    //   2166: invokevirtual 754	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;ZJ)V
    //   2169: aload 28
    //   2171: ifnull +8 -> 2179
    //   2174: aload 28
    //   2176: invokevirtual 849	java/io/ByteArrayOutputStream:close	()V
    //   2179: aload 27
    //   2181: ifnull +8 -> 2189
    //   2184: aload 27
    //   2186: invokevirtual 843	java/io/InputStream:close	()V
    //   2189: aload 25
    //   2191: ifnull +8 -> 2199
    //   2194: aload 25
    //   2196: invokevirtual 759	java/io/OutputStream:close	()V
    //   2199: aload 24
    //   2201: ifnull +8 -> 2209
    //   2204: aload 24
    //   2206: invokevirtual 762	java/net/HttpURLConnection:disconnect	()V
    //   2209: aload 23
    //   2211: athrow
    //   2212: aload_0
    //   2213: aload_1
    //   2214: aconst_null
    //   2215: iconst_2
    //   2216: iload_3
    //   2217: invokespecial 666	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Lcom/tencent/mobileqq/utils/httputils/HttpMsg;IZ)V
    //   2220: iload 5
    //   2222: sipush 200
    //   2225: if_icmpeq +11 -> 2236
    //   2228: iload 5
    //   2230: sipush 206
    //   2233: if_icmpne +1685 -> 3918
    //   2236: aload 24
    //   2238: invokevirtual 510	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
    //   2241: astore 23
    //   2243: aload 23
    //   2245: ifnonnull +280 -> 2525
    //   2248: ldc_w 604
    //   2251: astore 23
    //   2253: iload_3
    //   2254: ifne +281 -> 2535
    //   2257: aload_1
    //   2258: getfield 861	com/tencent/mobileqq/utils/httputils/HttpMsg:jdField_b_of_type_Boolean	Z
    //   2261: ifeq +274 -> 2535
    //   2264: aload 23
    //   2266: ldc_w 863
    //   2269: invokevirtual 866	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   2272: iconst_m1
    //   2273: if_icmpne +15 -> 2288
    //   2276: aload 23
    //   2278: ldc_w 868
    //   2281: invokevirtual 866	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   2284: iconst_m1
    //   2285: if_icmpeq +250 -> 2535
    //   2288: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2291: ifeq +18 -> 2309
    //   2294: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2297: ifeq +12 -> 2309
    //   2300: ldc 68
    //   2302: iconst_2
    //   2303: ldc_w 870
    //   2306: invokestatic 423	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2309: aload_0
    //   2310: aload_1
    //   2311: aload_2
    //   2312: iconst_1
    //   2313: invokevirtual 872	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Lakha;Z)V
    //   2316: iload 5
    //   2318: sipush 200
    //   2321: if_icmpeq +11 -> 2332
    //   2324: iload 5
    //   2326: sipush 206
    //   2329: if_icmpne +31 -> 2360
    //   2332: aload_0
    //   2333: aload_1
    //   2334: ldc_w 735
    //   2337: new 240	java/lang/StringBuilder
    //   2340: dup
    //   2341: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   2344: ldc_w 737
    //   2347: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2350: iconst_0
    //   2351: invokevirtual 250	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2354: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2357: invokevirtual 276	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   2360: aload_2
    //   2361: ifnull +13 -> 2374
    //   2364: aload_2
    //   2365: getfield 610	akha:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   2368: invokevirtual 619	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   2371: ifne +47 -> 2418
    //   2374: aload_0
    //   2375: aload_1
    //   2376: ldc_w 739
    //   2379: new 240	java/lang/StringBuilder
    //   2382: dup
    //   2383: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   2386: ldc_w 741
    //   2389: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2392: aload_1
    //   2393: invokevirtual 743	com/tencent/mobileqq/utils/httputils/HttpMsg:d	()Ljava/lang/String;
    //   2396: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2399: ldc_w 745
    //   2402: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2405: aload_1
    //   2406: invokevirtual 747	com/tencent/mobileqq/utils/httputils/HttpMsg:c	()Ljava/lang/String;
    //   2409: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2412: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2415: invokevirtual 276	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   2418: aload_0
    //   2419: getfield 470	com/tencent/mobileqq/utils/httputils/HttpCommunicator:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   2422: ifnull +17 -> 2439
    //   2425: aload 26
    //   2427: ifnull +12 -> 2439
    //   2430: aload_0
    //   2431: getfield 470	com/tencent/mobileqq/utils/httputils/HttpCommunicator:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   2434: aload 26
    //   2436: invokevirtual 751	mqq/os/MqqHandler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   2439: lload 13
    //   2441: lconst_0
    //   2442: ladd
    //   2443: lstore 13
    //   2445: lload 13
    //   2447: lconst_0
    //   2448: lcmp
    //   2449: ifeq +25 -> 2474
    //   2452: aload_1
    //   2453: invokevirtual 226	com/tencent/mobileqq/utils/httputils/HttpMsg:e	()Ljava/lang/String;
    //   2456: ldc 224
    //   2458: invokevirtual 180	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2461: ifeq +2887 -> 5348
    //   2464: iconst_1
    //   2465: istore_3
    //   2466: aload_0
    //   2467: aload_1
    //   2468: iload_3
    //   2469: lload 13
    //   2471: invokevirtual 754	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;ZJ)V
    //   2474: iconst_0
    //   2475: ifeq +11 -> 2486
    //   2478: new 756	java/lang/NullPointerException
    //   2481: dup
    //   2482: invokespecial 757	java/lang/NullPointerException:<init>	()V
    //   2485: athrow
    //   2486: iconst_0
    //   2487: ifeq +11 -> 2498
    //   2490: new 756	java/lang/NullPointerException
    //   2493: dup
    //   2494: invokespecial 757	java/lang/NullPointerException:<init>	()V
    //   2497: athrow
    //   2498: aload 25
    //   2500: ifnull +8 -> 2508
    //   2503: aload 25
    //   2505: invokevirtual 759	java/io/OutputStream:close	()V
    //   2508: aload 24
    //   2510: ifnull -1957 -> 553
    //   2513: aload 24
    //   2515: invokevirtual 762	java/net/HttpURLConnection:disconnect	()V
    //   2518: return
    //   2519: astore_1
    //   2520: aload_1
    //   2521: invokevirtual 579	java/lang/Exception:printStackTrace	()V
    //   2524: return
    //   2525: aload 23
    //   2527: invokevirtual 875	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   2530: astore 23
    //   2532: goto -279 -> 2253
    //   2535: aload_1
    //   2536: getfield 878	com/tencent/mobileqq/utils/httputils/HttpMsg:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   2539: ifnull +224 -> 2763
    //   2542: aload_1
    //   2543: getfield 878	com/tencent/mobileqq/utils/httputils/HttpMsg:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   2546: arraylength
    //   2547: ifle +216 -> 2763
    //   2550: aload 23
    //   2552: invokevirtual 726	java/lang/String:length	()I
    //   2555: ifle +208 -> 2763
    //   2558: iconst_0
    //   2559: istore 8
    //   2561: aload_1
    //   2562: getfield 878	com/tencent/mobileqq/utils/httputils/HttpMsg:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   2565: arraylength
    //   2566: iconst_1
    //   2567: if_icmpne +100 -> 2667
    //   2570: aload_1
    //   2571: getfield 878	com/tencent/mobileqq/utils/httputils/HttpMsg:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   2574: iconst_0
    //   2575: aaload
    //   2576: ifnull +91 -> 2667
    //   2579: aload_1
    //   2580: getfield 878	com/tencent/mobileqq/utils/httputils/HttpMsg:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   2583: iconst_0
    //   2584: aaload
    //   2585: invokevirtual 875	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   2588: ldc_w 880
    //   2591: invokevirtual 180	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2594: ifeq +73 -> 2667
    //   2597: iconst_1
    //   2598: istore 4
    //   2600: iload 4
    //   2602: ifne +161 -> 2763
    //   2605: new 240	java/lang/StringBuilder
    //   2608: dup
    //   2609: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   2612: astore 29
    //   2614: aload_1
    //   2615: getfield 878	com/tencent/mobileqq/utils/httputils/HttpMsg:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   2618: astore 32
    //   2620: aload 32
    //   2622: arraylength
    //   2623: istore 6
    //   2625: iconst_0
    //   2626: istore 4
    //   2628: iload 4
    //   2630: iload 6
    //   2632: if_icmpge +88 -> 2720
    //   2635: aload 32
    //   2637: iload 4
    //   2639: aaload
    //   2640: astore 30
    //   2642: aload 30
    //   2644: ifnull +2709 -> 5353
    //   2647: aload 29
    //   2649: aload 30
    //   2651: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2654: pop
    //   2655: aload 29
    //   2657: ldc_w 882
    //   2660: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2663: pop
    //   2664: goto +2689 -> 5353
    //   2667: aload_1
    //   2668: getfield 878	com/tencent/mobileqq/utils/httputils/HttpMsg:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   2671: astore 30
    //   2673: aload 30
    //   2675: arraylength
    //   2676: istore 9
    //   2678: iconst_0
    //   2679: istore 6
    //   2681: iload 8
    //   2683: istore 4
    //   2685: iload 6
    //   2687: iload 9
    //   2689: if_icmpge -89 -> 2600
    //   2692: aload 30
    //   2694: iload 6
    //   2696: aaload
    //   2697: astore 29
    //   2699: aload 29
    //   2701: ifnull +2661 -> 5362
    //   2704: aload 23
    //   2706: aload 29
    //   2708: invokevirtual 885	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   2711: ifeq +2651 -> 5362
    //   2714: iconst_1
    //   2715: istore 4
    //   2717: goto -117 -> 2600
    //   2720: new 626	java/io/IOException
    //   2723: dup
    //   2724: new 240	java/lang/StringBuilder
    //   2727: dup
    //   2728: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   2731: ldc_w 887
    //   2734: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2737: aload 23
    //   2739: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2742: ldc_w 889
    //   2745: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2748: aload 29
    //   2750: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2753: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2756: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2759: invokespecial 629	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   2762: athrow
    //   2763: aload_1
    //   2764: getfield 542	com/tencent/mobileqq/utils/httputils/HttpMsg:jdField_a_of_type_Long	J
    //   2767: lconst_0
    //   2768: lcmp
    //   2769: ifne +26 -> 2795
    //   2772: aload_1
    //   2773: invokevirtual 226	com/tencent/mobileqq/utils/httputils/HttpMsg:e	()Ljava/lang/String;
    //   2776: ldc 224
    //   2778: invokevirtual 180	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2781: ifne +14 -> 2795
    //   2784: new 626	java/io/IOException
    //   2787: dup
    //   2788: ldc_w 891
    //   2791: invokespecial 629	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   2794: athrow
    //   2795: aload_0
    //   2796: aload_1
    //   2797: ldc_w 893
    //   2800: new 240	java/lang/StringBuilder
    //   2803: dup
    //   2804: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   2807: ldc_w 895
    //   2810: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2813: aload_1
    //   2814: getfield 542	com/tencent/mobileqq/utils/httputils/HttpMsg:jdField_a_of_type_Long	J
    //   2817: invokevirtual 574	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2820: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2823: invokevirtual 276	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   2826: aload_1
    //   2827: getfield 677	com/tencent/mobileqq/utils/httputils/HttpMsg:jdField_d_of_type_Long	J
    //   2830: lconst_0
    //   2831: lcmp
    //   2832: ifeq +15 -> 2847
    //   2835: aload_1
    //   2836: invokestatic 442	android/os/SystemClock:uptimeMillis	()J
    //   2839: aload_1
    //   2840: getfield 677	com/tencent/mobileqq/utils/httputils/HttpMsg:jdField_d_of_type_Long	J
    //   2843: lsub
    //   2844: putfield 897	com/tencent/mobileqq/utils/httputils/HttpMsg:jdField_e_of_type_Long	J
    //   2847: aload 31
    //   2849: aload_1
    //   2850: aload_1
    //   2851: iconst_3
    //   2852: invokeinterface 385 4 0
    //   2857: istore_3
    //   2858: iload_3
    //   2859: ifeq +2463 -> 5322
    //   2862: lconst_0
    //   2863: ldc2_w 727
    //   2866: ladd
    //   2867: lstore 15
    //   2869: aload 24
    //   2871: invokevirtual 900	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   2874: astore 23
    //   2876: invokestatic 906	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   2879: astore 29
    //   2881: invokestatic 909	com/tencent/commonsdk/pool/ByteArrayPool:getMaxBufInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   2884: astore 27
    //   2886: aload_1
    //   2887: getfield 911	com/tencent/mobileqq/utils/httputils/HttpMsg:jdField_e_of_type_Boolean	Z
    //   2890: ifeq +251 -> 3141
    //   2893: aload_1
    //   2894: invokevirtual 913	com/tencent/mobileqq/utils/httputils/HttpMsg:a	()Z
    //   2897: ifne +244 -> 3141
    //   2900: new 915	com/tencent/mobileqq/utils/PoolingByteArrayOutputStream
    //   2903: dup
    //   2904: aload 27
    //   2906: aload_1
    //   2907: getfield 542	com/tencent/mobileqq/utils/httputils/HttpMsg:jdField_a_of_type_Long	J
    //   2910: l2i
    //   2911: invokespecial 918	com/tencent/mobileqq/utils/PoolingByteArrayOutputStream:<init>	(Lcom/tencent/commonsdk/pool/ByteArrayPool;I)V
    //   2914: astore 27
    //   2916: aload_1
    //   2917: getfield 911	com/tencent/mobileqq/utils/httputils/HttpMsg:jdField_e_of_type_Boolean	Z
    //   2920: ifeq +290 -> 3210
    //   2923: aload 29
    //   2925: sipush 10240
    //   2928: invokevirtual 922	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   2931: astore 28
    //   2933: iconst_0
    //   2934: istore 6
    //   2936: iconst_0
    //   2937: istore 4
    //   2939: iload 4
    //   2941: istore 8
    //   2943: lload 15
    //   2945: lstore 17
    //   2947: iload 4
    //   2949: istore 9
    //   2951: lload 15
    //   2953: lstore 21
    //   2955: aload 23
    //   2957: aload 28
    //   2959: iload 6
    //   2961: aload 28
    //   2963: arraylength
    //   2964: iload 6
    //   2966: isub
    //   2967: invokevirtual 925	java/io/InputStream:read	([BII)I
    //   2970: istore 7
    //   2972: iload 7
    //   2974: ifle +283 -> 3257
    //   2977: iload 4
    //   2979: istore 8
    //   2981: lload 15
    //   2983: lstore 17
    //   2985: iload 4
    //   2987: istore 9
    //   2989: lload 15
    //   2991: lstore 21
    //   2993: aload_0
    //   2994: aload_2
    //   2995: aload_1
    //   2996: invokevirtual 670	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lakha;Lcom/tencent/mobileqq/utils/httputils/HttpMsg;)V
    //   2999: lload 15
    //   3001: iload 7
    //   3003: i2l
    //   3004: ladd
    //   3005: lstore 19
    //   3007: iload 6
    //   3009: iload 7
    //   3011: iadd
    //   3012: istore 10
    //   3014: iload 4
    //   3016: iload 7
    //   3018: iadd
    //   3019: istore 7
    //   3021: iload 7
    //   3023: istore 4
    //   3025: lload 19
    //   3027: lstore 15
    //   3029: iload 10
    //   3031: istore 6
    //   3033: iload 7
    //   3035: istore 8
    //   3037: lload 19
    //   3039: lstore 17
    //   3041: iload 7
    //   3043: istore 9
    //   3045: lload 19
    //   3047: lstore 21
    //   3049: iload 10
    //   3051: aload 28
    //   3053: arraylength
    //   3054: if_icmplt -115 -> 2939
    //   3057: iload 7
    //   3059: istore 8
    //   3061: lload 19
    //   3063: lstore 17
    //   3065: iload 7
    //   3067: istore 9
    //   3069: lload 19
    //   3071: lstore 21
    //   3073: aload_1
    //   3074: invokevirtual 913	com/tencent/mobileqq/utils/httputils/HttpMsg:a	()Z
    //   3077: ifeq +143 -> 3220
    //   3080: iload 7
    //   3082: istore 8
    //   3084: lload 19
    //   3086: lstore 17
    //   3088: iload 7
    //   3090: istore 9
    //   3092: lload 19
    //   3094: lstore 21
    //   3096: aload_1
    //   3097: aload 28
    //   3099: invokevirtual 928	com/tencent/mobileqq/utils/httputils/HttpMsg:a	([B)V
    //   3102: iload 7
    //   3104: istore 8
    //   3106: lload 19
    //   3108: lstore 17
    //   3110: iload 7
    //   3112: istore 9
    //   3114: lload 19
    //   3116: lstore 21
    //   3118: aload 31
    //   3120: aload_1
    //   3121: aload_1
    //   3122: invokeinterface 930 3 0
    //   3127: iconst_0
    //   3128: istore 6
    //   3130: iload 7
    //   3132: istore 4
    //   3134: lload 19
    //   3136: lstore 15
    //   3138: goto -199 -> 2939
    //   3141: new 848	java/io/ByteArrayOutputStream
    //   3144: dup
    //   3145: invokespecial 931	java/io/ByteArrayOutputStream:<init>	()V
    //   3148: astore 27
    //   3150: goto -234 -> 2916
    //   3153: astore 28
    //   3155: iconst_0
    //   3156: istore 6
    //   3158: iconst_1
    //   3159: istore_3
    //   3160: aload 23
    //   3162: astore 27
    //   3164: iload 5
    //   3166: istore 4
    //   3168: aconst_null
    //   3169: astore 30
    //   3171: aload 26
    //   3173: astore 29
    //   3175: aload 24
    //   3177: astore 23
    //   3179: lload 13
    //   3181: lstore 17
    //   3183: aload 25
    //   3185: astore 26
    //   3187: aload 29
    //   3189: astore 24
    //   3191: iload 6
    //   3193: istore 5
    //   3195: lload 15
    //   3197: lstore 13
    //   3199: lload 17
    //   3201: lstore 15
    //   3203: aload 30
    //   3205: astore 25
    //   3207: goto -1689 -> 1518
    //   3210: sipush 10240
    //   3213: newarray byte
    //   3215: astore 28
    //   3217: goto -284 -> 2933
    //   3220: iload 7
    //   3222: istore 8
    //   3224: lload 19
    //   3226: lstore 17
    //   3228: iload 7
    //   3230: istore 9
    //   3232: lload 19
    //   3234: lstore 21
    //   3236: aload 27
    //   3238: aload 28
    //   3240: invokevirtual 933	java/io/ByteArrayOutputStream:write	([B)V
    //   3243: iconst_0
    //   3244: istore 6
    //   3246: iload 7
    //   3248: istore 4
    //   3250: lload 19
    //   3252: lstore 15
    //   3254: goto -315 -> 2939
    //   3257: iload 4
    //   3259: istore 8
    //   3261: lload 15
    //   3263: lstore 17
    //   3265: iload 4
    //   3267: istore 9
    //   3269: lload 15
    //   3271: lstore 21
    //   3273: aload_1
    //   3274: invokevirtual 913	com/tencent/mobileqq/utils/httputils/HttpMsg:a	()Z
    //   3277: ifeq +485 -> 3762
    //   3280: iload 6
    //   3282: ifle +99 -> 3381
    //   3285: iload 4
    //   3287: istore 8
    //   3289: lload 15
    //   3291: lstore 17
    //   3293: iload 4
    //   3295: istore 9
    //   3297: lload 15
    //   3299: lstore 21
    //   3301: iload 6
    //   3303: newarray byte
    //   3305: astore 30
    //   3307: iload 4
    //   3309: istore 8
    //   3311: lload 15
    //   3313: lstore 17
    //   3315: iload 4
    //   3317: istore 9
    //   3319: lload 15
    //   3321: lstore 21
    //   3323: aload 28
    //   3325: iconst_0
    //   3326: aload 30
    //   3328: iconst_0
    //   3329: iload 6
    //   3331: invokestatic 937	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   3334: iload 4
    //   3336: istore 8
    //   3338: lload 15
    //   3340: lstore 17
    //   3342: iload 4
    //   3344: istore 9
    //   3346: lload 15
    //   3348: lstore 21
    //   3350: aload_1
    //   3351: aload 30
    //   3353: invokevirtual 928	com/tencent/mobileqq/utils/httputils/HttpMsg:a	([B)V
    //   3356: iload 4
    //   3358: istore 8
    //   3360: lload 15
    //   3362: lstore 17
    //   3364: iload 4
    //   3366: istore 9
    //   3368: lload 15
    //   3370: lstore 21
    //   3372: aload 31
    //   3374: aload_1
    //   3375: aload_1
    //   3376: invokeinterface 930 3 0
    //   3381: iload 4
    //   3383: istore 8
    //   3385: lload 15
    //   3387: lstore 17
    //   3389: iload 4
    //   3391: istore 9
    //   3393: lload 15
    //   3395: lstore 21
    //   3397: aload_1
    //   3398: getfield 911	com/tencent/mobileqq/utils/httputils/HttpMsg:jdField_e_of_type_Boolean	Z
    //   3401: ifeq +26 -> 3427
    //   3404: iload 4
    //   3406: istore 8
    //   3408: lload 15
    //   3410: lstore 17
    //   3412: iload 4
    //   3414: istore 9
    //   3416: lload 15
    //   3418: lstore 21
    //   3420: aload 29
    //   3422: aload 28
    //   3424: invokevirtual 940	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   3427: iload 4
    //   3429: istore 8
    //   3431: lload 15
    //   3433: lstore 17
    //   3435: iload 4
    //   3437: istore 9
    //   3439: lload 15
    //   3441: lstore 21
    //   3443: aload 27
    //   3445: invokevirtual 849	java/io/ByteArrayOutputStream:close	()V
    //   3448: aload 27
    //   3450: astore 28
    //   3452: aload 23
    //   3454: astore 27
    //   3456: aload 28
    //   3458: astore 23
    //   3460: aload 31
    //   3462: aload_1
    //   3463: aload_1
    //   3464: iconst_4
    //   3465: invokeinterface 385 4 0
    //   3470: pop
    //   3471: iload 4
    //   3473: istore 6
    //   3475: iconst_0
    //   3476: istore 4
    //   3478: iload 5
    //   3480: sipush 200
    //   3483: if_icmpeq +11 -> 3494
    //   3486: iload 5
    //   3488: sipush 206
    //   3491: if_icmpne +32 -> 3523
    //   3494: aload_0
    //   3495: aload_1
    //   3496: ldc_w 735
    //   3499: new 240	java/lang/StringBuilder
    //   3502: dup
    //   3503: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   3506: ldc_w 737
    //   3509: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3512: iload 6
    //   3514: invokevirtual 250	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3517: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3520: invokevirtual 276	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   3523: aload_2
    //   3524: ifnull +13 -> 3537
    //   3527: aload_2
    //   3528: getfield 610	akha:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   3531: invokevirtual 619	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   3534: ifne +106 -> 3640
    //   3537: aload_0
    //   3538: aload_1
    //   3539: ldc_w 739
    //   3542: new 240	java/lang/StringBuilder
    //   3545: dup
    //   3546: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   3549: ldc_w 741
    //   3552: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3555: aload_1
    //   3556: invokevirtual 743	com/tencent/mobileqq/utils/httputils/HttpMsg:d	()Ljava/lang/String;
    //   3559: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3562: ldc_w 745
    //   3565: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3568: aload_1
    //   3569: invokevirtual 747	com/tencent/mobileqq/utils/httputils/HttpMsg:c	()Ljava/lang/String;
    //   3572: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3575: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3578: invokevirtual 276	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   3581: iload 4
    //   3583: ifeq +57 -> 3640
    //   3586: aload_1
    //   3587: getfield 802	com/tencent/mobileqq/utils/httputils/HttpMsg:jdField_f_of_type_Int	I
    //   3590: sipush -9527
    //   3593: if_icmpne +47 -> 3640
    //   3596: aload_0
    //   3597: aload_1
    //   3598: ldc_w 804
    //   3601: new 240	java/lang/StringBuilder
    //   3604: dup
    //   3605: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   3608: ldc_w 770
    //   3611: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3614: aload_1
    //   3615: getfield 359	com/tencent/mobileqq/utils/httputils/HttpMsg:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   3618: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3621: ldc_w 772
    //   3624: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3627: aload_1
    //   3628: getfield 516	com/tencent/mobileqq/utils/httputils/HttpMsg:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   3631: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3634: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3637: invokevirtual 276	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   3640: aload_0
    //   3641: getfield 470	com/tencent/mobileqq/utils/httputils/HttpCommunicator:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   3644: ifnull +17 -> 3661
    //   3647: aload 26
    //   3649: ifnull +12 -> 3661
    //   3652: aload_0
    //   3653: getfield 470	com/tencent/mobileqq/utils/httputils/HttpCommunicator:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   3656: aload 26
    //   3658: invokevirtual 751	mqq/os/MqqHandler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   3661: lload 15
    //   3663: lload 13
    //   3665: ladd
    //   3666: lstore 13
    //   3668: lload 13
    //   3670: lconst_0
    //   3671: lcmp
    //   3672: ifeq +25 -> 3697
    //   3675: aload_1
    //   3676: invokevirtual 226	com/tencent/mobileqq/utils/httputils/HttpMsg:e	()Ljava/lang/String;
    //   3679: ldc 224
    //   3681: invokevirtual 180	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3684: ifeq +571 -> 4255
    //   3687: iconst_1
    //   3688: istore_3
    //   3689: aload_0
    //   3690: aload_1
    //   3691: iload_3
    //   3692: lload 13
    //   3694: invokevirtual 754	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;ZJ)V
    //   3697: aload 23
    //   3699: ifnull +8 -> 3707
    //   3702: aload 23
    //   3704: invokevirtual 849	java/io/ByteArrayOutputStream:close	()V
    //   3707: aload 27
    //   3709: ifnull +8 -> 3717
    //   3712: aload 27
    //   3714: invokevirtual 843	java/io/InputStream:close	()V
    //   3717: aload 25
    //   3719: ifnull +8 -> 3727
    //   3722: aload 25
    //   3724: invokevirtual 759	java/io/OutputStream:close	()V
    //   3727: iload 4
    //   3729: istore 5
    //   3731: aload 24
    //   3733: ifnull -1863 -> 1870
    //   3736: aload 24
    //   3738: invokevirtual 762	java/net/HttpURLConnection:disconnect	()V
    //   3741: iload 4
    //   3743: istore 5
    //   3745: goto -1875 -> 1870
    //   3748: astore 23
    //   3750: aload 23
    //   3752: invokevirtual 579	java/lang/Exception:printStackTrace	()V
    //   3755: iload 4
    //   3757: istore 5
    //   3759: goto -1889 -> 1870
    //   3762: iload 6
    //   3764: ifle +29 -> 3793
    //   3767: iload 4
    //   3769: istore 8
    //   3771: lload 15
    //   3773: lstore 17
    //   3775: iload 4
    //   3777: istore 9
    //   3779: lload 15
    //   3781: lstore 21
    //   3783: aload 27
    //   3785: aload 28
    //   3787: iconst_0
    //   3788: iload 6
    //   3790: invokevirtual 941	java/io/ByteArrayOutputStream:write	([BII)V
    //   3793: iload 4
    //   3795: istore 8
    //   3797: lload 15
    //   3799: lstore 17
    //   3801: iload 4
    //   3803: istore 9
    //   3805: lload 15
    //   3807: lstore 21
    //   3809: aload 27
    //   3811: invokevirtual 942	java/io/ByteArrayOutputStream:flush	()V
    //   3814: iload 4
    //   3816: istore 8
    //   3818: lload 15
    //   3820: lstore 17
    //   3822: iload 4
    //   3824: istore 9
    //   3826: lload 15
    //   3828: lstore 21
    //   3830: aload_1
    //   3831: aload 27
    //   3833: invokevirtual 945	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   3836: invokevirtual 928	com/tencent/mobileqq/utils/httputils/HttpMsg:a	([B)V
    //   3839: iload 4
    //   3841: istore 8
    //   3843: lload 15
    //   3845: lstore 17
    //   3847: iload 4
    //   3849: istore 9
    //   3851: lload 15
    //   3853: lstore 21
    //   3855: aload 31
    //   3857: aload_1
    //   3858: aload_1
    //   3859: invokeinterface 930 3 0
    //   3864: goto -483 -> 3381
    //   3867: astore 28
    //   3869: aload 23
    //   3871: astore 29
    //   3873: aload 26
    //   3875: astore 30
    //   3877: iload 5
    //   3879: istore 4
    //   3881: iconst_1
    //   3882: istore_3
    //   3883: aload 24
    //   3885: astore 23
    //   3887: aload 25
    //   3889: astore 26
    //   3891: lload 13
    //   3893: lstore 15
    //   3895: aload 27
    //   3897: astore 25
    //   3899: aload 30
    //   3901: astore 24
    //   3903: iload 8
    //   3905: istore 5
    //   3907: lload 17
    //   3909: lstore 13
    //   3911: aload 29
    //   3913: astore 27
    //   3915: goto -2397 -> 1518
    //   3918: aload_1
    //   3919: getfield 183	com/tencent/mobileqq/utils/httputils/HttpMsg:jdField_f_of_type_Boolean	Z
    //   3922: ifeq +300 -> 4222
    //   3925: aload_1
    //   3926: getfield 197	com/tencent/mobileqq/utils/httputils/HttpMsg:jdField_h_of_type_Int	I
    //   3929: ifeq +293 -> 4222
    //   3932: aload_1
    //   3933: getfield 195	com/tencent/mobileqq/utils/httputils/HttpMsg:jdField_g_of_type_Boolean	Z
    //   3936: ifne +286 -> 4222
    //   3939: aload_0
    //   3940: aload_1
    //   3941: ldc_w 947
    //   3944: ldc_w 949
    //   3947: invokevirtual 276	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   3950: aload_1
    //   3951: iconst_1
    //   3952: putfield 195	com/tencent/mobileqq/utils/httputils/HttpMsg:jdField_g_of_type_Boolean	Z
    //   3955: aload_0
    //   3956: aload_1
    //   3957: aload_2
    //   3958: iconst_0
    //   3959: invokevirtual 872	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Lakha;Z)V
    //   3962: new 123	java/util/HashMap
    //   3965: dup
    //   3966: invokespecial 585	java/util/HashMap:<init>	()V
    //   3969: astore 23
    //   3971: aload 23
    //   3973: ldc_w 587
    //   3976: aload_1
    //   3977: getfield 197	com/tencent/mobileqq/utils/httputils/HttpMsg:jdField_h_of_type_Int	I
    //   3980: invokestatic 589	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   3983: invokevirtual 593	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3986: pop
    //   3987: invokestatic 149	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3990: invokestatic 600	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   3993: aconst_null
    //   3994: ldc_w 951
    //   3997: iconst_0
    //   3998: lconst_0
    //   3999: lconst_0
    //   4000: aload 23
    //   4002: ldc_w 604
    //   4005: invokevirtual 607	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   4008: iload 5
    //   4010: sipush 200
    //   4013: if_icmpeq +11 -> 4024
    //   4016: iload 5
    //   4018: sipush 206
    //   4021: if_icmpne +31 -> 4052
    //   4024: aload_0
    //   4025: aload_1
    //   4026: ldc_w 735
    //   4029: new 240	java/lang/StringBuilder
    //   4032: dup
    //   4033: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   4036: ldc_w 737
    //   4039: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4042: iconst_0
    //   4043: invokevirtual 250	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4046: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4049: invokevirtual 276	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   4052: aload_2
    //   4053: ifnull +13 -> 4066
    //   4056: aload_2
    //   4057: getfield 610	akha:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   4060: invokevirtual 619	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   4063: ifne +47 -> 4110
    //   4066: aload_0
    //   4067: aload_1
    //   4068: ldc_w 739
    //   4071: new 240	java/lang/StringBuilder
    //   4074: dup
    //   4075: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   4078: ldc_w 741
    //   4081: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4084: aload_1
    //   4085: invokevirtual 743	com/tencent/mobileqq/utils/httputils/HttpMsg:d	()Ljava/lang/String;
    //   4088: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4091: ldc_w 745
    //   4094: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4097: aload_1
    //   4098: invokevirtual 747	com/tencent/mobileqq/utils/httputils/HttpMsg:c	()Ljava/lang/String;
    //   4101: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4104: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4107: invokevirtual 276	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   4110: aload_0
    //   4111: getfield 470	com/tencent/mobileqq/utils/httputils/HttpCommunicator:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   4114: ifnull +17 -> 4131
    //   4117: aload 26
    //   4119: ifnull +12 -> 4131
    //   4122: aload_0
    //   4123: getfield 470	com/tencent/mobileqq/utils/httputils/HttpCommunicator:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   4126: aload 26
    //   4128: invokevirtual 751	mqq/os/MqqHandler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   4131: lload 13
    //   4133: lconst_0
    //   4134: ladd
    //   4135: lstore 13
    //   4137: lload 13
    //   4139: lconst_0
    //   4140: lcmp
    //   4141: ifeq +25 -> 4166
    //   4144: aload_1
    //   4145: invokevirtual 226	com/tencent/mobileqq/utils/httputils/HttpMsg:e	()Ljava/lang/String;
    //   4148: ldc 224
    //   4150: invokevirtual 180	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4153: ifeq +64 -> 4217
    //   4156: iconst_1
    //   4157: istore_3
    //   4158: aload_0
    //   4159: aload_1
    //   4160: iload_3
    //   4161: lload 13
    //   4163: invokevirtual 754	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;ZJ)V
    //   4166: iconst_0
    //   4167: ifeq +11 -> 4178
    //   4170: new 756	java/lang/NullPointerException
    //   4173: dup
    //   4174: invokespecial 757	java/lang/NullPointerException:<init>	()V
    //   4177: athrow
    //   4178: iconst_0
    //   4179: ifeq +11 -> 4190
    //   4182: new 756	java/lang/NullPointerException
    //   4185: dup
    //   4186: invokespecial 757	java/lang/NullPointerException:<init>	()V
    //   4189: athrow
    //   4190: aload 25
    //   4192: ifnull +8 -> 4200
    //   4195: aload 25
    //   4197: invokevirtual 759	java/io/OutputStream:close	()V
    //   4200: aload 24
    //   4202: ifnull -3649 -> 553
    //   4205: aload 24
    //   4207: invokevirtual 762	java/net/HttpURLConnection:disconnect	()V
    //   4210: return
    //   4211: astore_1
    //   4212: aload_1
    //   4213: invokevirtual 579	java/lang/Exception:printStackTrace	()V
    //   4216: return
    //   4217: iconst_0
    //   4218: istore_3
    //   4219: goto -61 -> 4158
    //   4222: iconst_1
    //   4223: istore 4
    //   4225: aload_0
    //   4226: iload 5
    //   4228: aload 24
    //   4230: aload_1
    //   4231: invokevirtual 953	com/tencent/mobileqq/utils/httputils/HttpCommunicator:b	(ILjava/net/HttpURLConnection;Lcom/tencent/mobileqq/utils/httputils/HttpMsg;)V
    //   4234: lconst_0
    //   4235: lstore 15
    //   4237: iconst_1
    //   4238: istore 4
    //   4240: iload 8
    //   4242: istore 6
    //   4244: aload 30
    //   4246: astore 23
    //   4248: aload 29
    //   4250: astore 27
    //   4252: goto -774 -> 3478
    //   4255: iconst_0
    //   4256: istore_3
    //   4257: goto -568 -> 3689
    //   4260: astore 29
    //   4262: aload 30
    //   4264: ifnull -2672 -> 1592
    //   4267: aload 30
    //   4269: invokevirtual 843	java/io/InputStream:close	()V
    //   4272: goto -2680 -> 1592
    //   4275: astore 29
    //   4277: goto -2685 -> 1592
    //   4280: astore 28
    //   4282: aconst_null
    //   4283: astore 29
    //   4285: aload 29
    //   4287: ifnull +8 -> 4295
    //   4290: aload 29
    //   4292: invokevirtual 843	java/io/InputStream:close	()V
    //   4295: aload 28
    //   4297: athrow
    //   4298: astore 30
    //   4300: lload 15
    //   4302: lstore 17
    //   4304: aload 25
    //   4306: astore 28
    //   4308: aload 26
    //   4310: astore 25
    //   4312: aload 23
    //   4314: astore 29
    //   4316: iload 4
    //   4318: istore 7
    //   4320: iconst_1
    //   4321: istore 4
    //   4323: aload 30
    //   4325: astore 23
    //   4327: aload 24
    //   4329: astore 26
    //   4331: iload 5
    //   4333: istore 6
    //   4335: iload 7
    //   4337: istore 5
    //   4339: lload 13
    //   4341: lstore 15
    //   4343: lload 17
    //   4345: lstore 13
    //   4347: aload 29
    //   4349: astore 24
    //   4351: goto -2405 -> 1946
    //   4354: iconst_0
    //   4355: istore_3
    //   4356: goto -2542 -> 1814
    //   4359: astore 23
    //   4361: aload 23
    //   4363: invokevirtual 579	java/lang/Exception:printStackTrace	()V
    //   4366: iload 6
    //   4368: istore 5
    //   4370: goto -2500 -> 1870
    //   4373: iconst_0
    //   4374: istore_3
    //   4375: goto -2214 -> 2161
    //   4378: astore_1
    //   4379: aload_1
    //   4380: invokevirtual 579	java/lang/Exception:printStackTrace	()V
    //   4383: goto -2174 -> 2209
    //   4386: aload 31
    //   4388: aload_1
    //   4389: aload_1
    //   4390: iconst_5
    //   4391: invokeinterface 385 4 0
    //   4396: pop
    //   4397: return
    //   4398: astore_1
    //   4399: goto -3878 -> 521
    //   4402: astore_1
    //   4403: goto -3870 -> 533
    //   4406: astore_1
    //   4407: goto -3864 -> 543
    //   4410: astore_1
    //   4411: goto -3397 -> 1014
    //   4414: astore_1
    //   4415: goto -3389 -> 1026
    //   4418: astore_1
    //   4419: goto -3383 -> 1036
    //   4422: astore_1
    //   4423: goto -3147 -> 1276
    //   4426: astore_1
    //   4427: goto -3139 -> 1288
    //   4430: astore_1
    //   4431: goto -3133 -> 1298
    //   4434: astore_1
    //   4435: goto -1949 -> 2486
    //   4438: astore_1
    //   4439: goto -1941 -> 2498
    //   4442: astore_1
    //   4443: goto -1935 -> 2508
    //   4446: astore_1
    //   4447: goto -269 -> 4178
    //   4450: astore_1
    //   4451: goto -261 -> 4190
    //   4454: astore_1
    //   4455: goto -255 -> 4200
    //   4458: astore 23
    //   4460: goto -753 -> 3707
    //   4463: astore 23
    //   4465: goto -748 -> 3717
    //   4468: astore 23
    //   4470: goto -743 -> 3727
    //   4473: astore 29
    //   4475: goto -2883 -> 1592
    //   4478: astore 29
    //   4480: goto -185 -> 4295
    //   4483: astore 24
    //   4485: goto -2653 -> 1832
    //   4488: astore 24
    //   4490: goto -2648 -> 1842
    //   4493: astore 24
    //   4495: goto -2643 -> 1852
    //   4498: astore_1
    //   4499: goto -2320 -> 2179
    //   4502: astore_1
    //   4503: goto -2314 -> 2189
    //   4506: astore_1
    //   4507: goto -2308 -> 2199
    //   4510: astore 23
    //   4512: aconst_null
    //   4513: astore 26
    //   4515: iconst_0
    //   4516: istore_3
    //   4517: lconst_0
    //   4518: lstore 13
    //   4520: iconst_m1
    //   4521: istore 5
    //   4523: aconst_null
    //   4524: astore 25
    //   4526: aconst_null
    //   4527: astore 24
    //   4529: iconst_0
    //   4530: istore 4
    //   4532: iload 7
    //   4534: istore 6
    //   4536: goto -2590 -> 1946
    //   4539: astore 23
    //   4541: iload 4
    //   4543: istore 5
    //   4545: iconst_0
    //   4546: istore 4
    //   4548: iload 7
    //   4550: istore 6
    //   4552: iload 11
    //   4554: istore_3
    //   4555: goto -2609 -> 1946
    //   4558: astore 23
    //   4560: iload 4
    //   4562: istore 5
    //   4564: iconst_0
    //   4565: istore 4
    //   4567: iload 7
    //   4569: istore 6
    //   4571: iload 11
    //   4573: istore_3
    //   4574: goto -2628 -> 1946
    //   4577: astore 29
    //   4579: aload 25
    //   4581: astore 26
    //   4583: iload 11
    //   4585: istore_3
    //   4586: iload 4
    //   4588: istore 5
    //   4590: aload 23
    //   4592: astore 25
    //   4594: aload 29
    //   4596: astore 23
    //   4598: iconst_0
    //   4599: istore 4
    //   4601: iload 7
    //   4603: istore 6
    //   4605: goto -2659 -> 1946
    //   4608: astore 29
    //   4610: aload 25
    //   4612: astore 26
    //   4614: iload 11
    //   4616: istore_3
    //   4617: iload 4
    //   4619: istore 5
    //   4621: aload 23
    //   4623: astore 25
    //   4625: iconst_0
    //   4626: istore 4
    //   4628: aload 29
    //   4630: astore 23
    //   4632: iload 7
    //   4634: istore 6
    //   4636: goto -2690 -> 1946
    //   4639: astore 29
    //   4641: aload 25
    //   4643: astore 26
    //   4645: iload 4
    //   4647: istore 5
    //   4649: aload 23
    //   4651: astore 25
    //   4653: iconst_0
    //   4654: istore 4
    //   4656: aload 29
    //   4658: astore 23
    //   4660: iload 7
    //   4662: istore 6
    //   4664: iload 11
    //   4666: istore_3
    //   4667: goto -2721 -> 1946
    //   4670: astore 29
    //   4672: iload 4
    //   4674: istore 5
    //   4676: aload 23
    //   4678: astore 25
    //   4680: aload 29
    //   4682: astore 23
    //   4684: iconst_0
    //   4685: istore 4
    //   4687: iload 7
    //   4689: istore 6
    //   4691: iload 11
    //   4693: istore_3
    //   4694: goto -2748 -> 1946
    //   4697: astore 23
    //   4699: iconst_0
    //   4700: istore 4
    //   4702: iload 7
    //   4704: istore 6
    //   4706: iload 11
    //   4708: istore_3
    //   4709: goto -2763 -> 1946
    //   4712: astore 29
    //   4714: iconst_0
    //   4715: istore 4
    //   4717: aload 23
    //   4719: astore 27
    //   4721: aload 29
    //   4723: astore 23
    //   4725: iload 7
    //   4727: istore 6
    //   4729: iload 11
    //   4731: istore_3
    //   4732: goto -2786 -> 1946
    //   4735: astore 29
    //   4737: iconst_0
    //   4738: istore 4
    //   4740: aload 27
    //   4742: astore 28
    //   4744: aload 23
    //   4746: astore 27
    //   4748: aload 29
    //   4750: astore 23
    //   4752: iload 7
    //   4754: istore 6
    //   4756: iload 11
    //   4758: istore_3
    //   4759: goto -2813 -> 1946
    //   4762: astore 29
    //   4764: iload 9
    //   4766: istore 6
    //   4768: lload 21
    //   4770: lstore 15
    //   4772: aload 27
    //   4774: astore 28
    //   4776: aload 23
    //   4778: astore 27
    //   4780: iconst_0
    //   4781: istore 4
    //   4783: aload 29
    //   4785: astore 23
    //   4787: iload 11
    //   4789: istore_3
    //   4790: goto -2844 -> 1946
    //   4793: astore 29
    //   4795: iload 4
    //   4797: istore 6
    //   4799: aload 23
    //   4801: astore 28
    //   4803: aload 29
    //   4805: astore 23
    //   4807: iconst_0
    //   4808: istore 4
    //   4810: iload 11
    //   4812: istore_3
    //   4813: goto -2867 -> 1946
    //   4816: astore 23
    //   4818: iload 7
    //   4820: istore 6
    //   4822: iload 11
    //   4824: istore_3
    //   4825: goto -2879 -> 1946
    //   4828: astore 28
    //   4830: goto -545 -> 4285
    //   4833: astore 28
    //   4835: lconst_0
    //   4836: lstore 13
    //   4838: aconst_null
    //   4839: astore 25
    //   4841: aconst_null
    //   4842: astore 26
    //   4844: aconst_null
    //   4845: astore 24
    //   4847: aconst_null
    //   4848: astore 27
    //   4850: lconst_0
    //   4851: lstore 15
    //   4853: iconst_m1
    //   4854: istore 4
    //   4856: aconst_null
    //   4857: astore 23
    //   4859: iconst_0
    //   4860: istore 5
    //   4862: iload 11
    //   4864: istore_3
    //   4865: goto -3347 -> 1518
    //   4868: astore 28
    //   4870: aload 26
    //   4872: astore 27
    //   4874: iconst_0
    //   4875: istore 5
    //   4877: lconst_0
    //   4878: lstore 17
    //   4880: aload 25
    //   4882: astore 26
    //   4884: lload 13
    //   4886: lstore 15
    //   4888: iconst_1
    //   4889: istore_3
    //   4890: aconst_null
    //   4891: astore 29
    //   4893: aconst_null
    //   4894: astore 25
    //   4896: aload 24
    //   4898: astore 23
    //   4900: aload 27
    //   4902: astore 24
    //   4904: lload 17
    //   4906: lstore 13
    //   4908: aload 29
    //   4910: astore 27
    //   4912: goto -3394 -> 1518
    //   4915: astore 28
    //   4917: aload 26
    //   4919: astore 27
    //   4921: iconst_0
    //   4922: istore 5
    //   4924: iconst_1
    //   4925: istore_3
    //   4926: lconst_0
    //   4927: lstore 17
    //   4929: aload 25
    //   4931: astore 26
    //   4933: aload 24
    //   4935: astore 23
    //   4937: lload 13
    //   4939: lstore 15
    //   4941: aconst_null
    //   4942: astore 29
    //   4944: aconst_null
    //   4945: astore 25
    //   4947: aload 27
    //   4949: astore 24
    //   4951: lload 17
    //   4953: lstore 13
    //   4955: aload 29
    //   4957: astore 27
    //   4959: goto -3441 -> 1518
    //   4962: astore 28
    //   4964: lconst_0
    //   4965: lstore 17
    //   4967: aconst_null
    //   4968: astore 27
    //   4970: aload 23
    //   4972: astore 26
    //   4974: aconst_null
    //   4975: astore 29
    //   4977: iload 11
    //   4979: istore_3
    //   4980: lload 13
    //   4982: lstore 15
    //   4984: aload 24
    //   4986: astore 23
    //   4988: iconst_0
    //   4989: istore 5
    //   4991: aload 25
    //   4993: astore 24
    //   4995: lload 17
    //   4997: lstore 13
    //   4999: aload 27
    //   5001: astore 25
    //   5003: aload 29
    //   5005: astore 27
    //   5007: goto -3489 -> 1518
    //   5010: astore 28
    //   5012: iconst_0
    //   5013: istore 5
    //   5015: lconst_0
    //   5016: lstore 17
    //   5018: aconst_null
    //   5019: astore 27
    //   5021: aload 23
    //   5023: astore 26
    //   5025: lload 13
    //   5027: lstore 15
    //   5029: aconst_null
    //   5030: astore 29
    //   5032: iload 11
    //   5034: istore_3
    //   5035: aload 24
    //   5037: astore 23
    //   5039: aload 25
    //   5041: astore 24
    //   5043: lload 17
    //   5045: lstore 13
    //   5047: aload 27
    //   5049: astore 25
    //   5051: aload 29
    //   5053: astore 27
    //   5055: goto -3537 -> 1518
    //   5058: astore 28
    //   5060: iconst_0
    //   5061: istore 5
    //   5063: lconst_0
    //   5064: lstore 17
    //   5066: aload 23
    //   5068: astore 26
    //   5070: lload 13
    //   5072: lstore 15
    //   5074: aconst_null
    //   5075: astore 27
    //   5077: iconst_1
    //   5078: istore_3
    //   5079: aload 24
    //   5081: astore 23
    //   5083: aconst_null
    //   5084: astore 29
    //   5086: aload 25
    //   5088: astore 24
    //   5090: lload 17
    //   5092: lstore 13
    //   5094: aload 29
    //   5096: astore 25
    //   5098: goto -3580 -> 1518
    //   5101: astore 28
    //   5103: iconst_0
    //   5104: istore 5
    //   5106: iconst_1
    //   5107: istore_3
    //   5108: lconst_0
    //   5109: lstore 17
    //   5111: aload 23
    //   5113: astore 27
    //   5115: lload 13
    //   5117: lstore 15
    //   5119: aconst_null
    //   5120: astore 25
    //   5122: aconst_null
    //   5123: astore 29
    //   5125: aload 24
    //   5127: astore 23
    //   5129: aload 26
    //   5131: astore 24
    //   5133: lload 17
    //   5135: lstore 13
    //   5137: aload 27
    //   5139: astore 26
    //   5141: aload 29
    //   5143: astore 27
    //   5145: goto -3627 -> 1518
    //   5148: astore 28
    //   5150: iconst_0
    //   5151: istore 6
    //   5153: iconst_1
    //   5154: istore_3
    //   5155: aconst_null
    //   5156: astore 29
    //   5158: iload 5
    //   5160: istore 4
    //   5162: aconst_null
    //   5163: astore 30
    //   5165: lload 13
    //   5167: lstore 17
    //   5169: aload 24
    //   5171: astore 23
    //   5173: aload 25
    //   5175: astore 27
    //   5177: aload 26
    //   5179: astore 24
    //   5181: iload 6
    //   5183: istore 5
    //   5185: lload 15
    //   5187: lstore 13
    //   5189: lload 17
    //   5191: lstore 15
    //   5193: aload 30
    //   5195: astore 25
    //   5197: aload 27
    //   5199: astore 26
    //   5201: aload 29
    //   5203: astore 27
    //   5205: goto -3687 -> 1518
    //   5208: astore 28
    //   5210: iconst_0
    //   5211: istore 6
    //   5213: iconst_1
    //   5214: istore_3
    //   5215: aload 23
    //   5217: astore 29
    //   5219: iload 5
    //   5221: istore 4
    //   5223: aload 24
    //   5225: astore 23
    //   5227: lload 13
    //   5229: lstore 17
    //   5231: aload 25
    //   5233: astore 30
    //   5235: aload 26
    //   5237: astore 24
    //   5239: iload 6
    //   5241: istore 5
    //   5243: lload 15
    //   5245: lstore 13
    //   5247: lload 17
    //   5249: lstore 15
    //   5251: aload 27
    //   5253: astore 25
    //   5255: aload 30
    //   5257: astore 26
    //   5259: aload 29
    //   5261: astore 27
    //   5263: goto -3745 -> 1518
    //   5266: astore 28
    //   5268: iload 4
    //   5270: istore 6
    //   5272: lload 15
    //   5274: lstore 17
    //   5276: lload 13
    //   5278: lstore 15
    //   5280: iload 5
    //   5282: istore 4
    //   5284: aload 25
    //   5286: astore 29
    //   5288: aload 23
    //   5290: astore 25
    //   5292: iconst_1
    //   5293: istore_3
    //   5294: aload 24
    //   5296: astore 23
    //   5298: aload 26
    //   5300: astore 24
    //   5302: iload 6
    //   5304: istore 5
    //   5306: lload 17
    //   5308: lstore 13
    //   5310: aload 29
    //   5312: astore 26
    //   5314: goto -3796 -> 1518
    //   5317: astore 23
    //   5319: goto -4608 -> 711
    //   5322: iconst_0
    //   5323: istore 4
    //   5325: lconst_0
    //   5326: lstore 15
    //   5328: aconst_null
    //   5329: astore 23
    //   5331: aconst_null
    //   5332: astore 27
    //   5334: goto -1874 -> 3460
    //   5337: aload 25
    //   5339: astore 26
    //   5341: aload 23
    //   5343: astore 25
    //   5345: goto -5034 -> 311
    //   5348: iconst_0
    //   5349: istore_3
    //   5350: goto -2884 -> 2466
    //   5353: iload 4
    //   5355: iconst_1
    //   5356: iadd
    //   5357: istore 4
    //   5359: goto -2731 -> 2628
    //   5362: iload 6
    //   5364: iconst_1
    //   5365: iadd
    //   5366: istore 6
    //   5368: goto -2687 -> 2681
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	5371	0	this	HttpCommunicator
    //   0	5371	1	paramHttpMsg	HttpMsg
    //   0	5371	2	paramakha	akha
    //   0	5371	3	paramBoolean	boolean
    //   25	5333	4	i	int
    //   199	5106	5	j	int
    //   51	5316	6	k	int
    //   40	4779	7	m	int
    //   37	4204	8	n	int
    //   2676	2089	9	i1	int
    //   3012	43	10	i2	int
    //   34	4999	11	bool1	boolean
    //   344	442	12	bool2	boolean
    //   28	5281	13	l1	long
    //   31	5296	15	l2	long
    //   289	5018	17	l3	long
    //   3005	246	19	l4	long
    //   2953	1816	21	l5	long
    //   16	1052	23	str	String
    //   1077	1	23	localException1	Exception
    //   1372	490	23	localObject1	Object
    //   1934	276	23	localObject2	Object
    //   2241	1462	23	localObject3	Object
    //   3748	122	23	localException2	Exception
    //   3885	441	23	localObject4	Object
    //   4359	3	23	localException3	Exception
    //   4458	1	23	localIOException1	IOException
    //   4463	1	23	localIOException2	IOException
    //   4468	1	23	localIOException3	IOException
    //   4510	1	23	localObject5	Object
    //   4539	1	23	localObject6	Object
    //   4558	33	23	localObject7	Object
    //   4596	87	23	localObject8	Object
    //   4697	21	23	localObject9	Object
    //   4723	83	23	localObject10	Object
    //   4816	1	23	localObject11	Object
    //   4857	440	23	localObject12	Object
    //   5317	1	23	localThrowable1	Throwable
    //   5329	13	23	localObject13	Object
    //   7	4343	24	localObject14	Object
    //   4483	1	24	localIOException4	IOException
    //   4488	1	24	localIOException5	IOException
    //   4493	1	24	localIOException6	IOException
    //   4527	774	24	localObject15	Object
    //   57	5287	25	localObject16	Object
    //   81	5259	26	localObject17	Object
    //   13	5320	27	localObject18	Object
    //   22	3076	28	localObject19	Object
    //   3153	1	28	localThrowable2	Throwable
    //   3215	571	28	localObject20	Object
    //   3867	1	28	localThrowable3	Throwable
    //   4280	16	28	localObject21	Object
    //   4306	496	28	localObject22	Object
    //   4828	1	28	localObject23	Object
    //   4833	1	28	localThrowable4	Throwable
    //   4868	1	28	localThrowable5	Throwable
    //   4915	1	28	localThrowable6	Throwable
    //   4962	1	28	localThrowable7	Throwable
    //   5010	1	28	localThrowable8	Throwable
    //   5058	1	28	localThrowable9	Throwable
    //   5101	1	28	localThrowable10	Throwable
    //   5148	1	28	localThrowable11	Throwable
    //   5208	1	28	localThrowable12	Throwable
    //   5266	1	28	localThrowable13	Throwable
    //   10	1	29	localObject24	Object
    //   1462	53	29	localThrowable14	Throwable
    //   1546	2703	29	localObject25	Object
    //   4260	1	29	localException4	Exception
    //   4275	1	29	localIOException7	IOException
    //   4283	65	29	localObject26	Object
    //   4473	1	29	localIOException8	IOException
    //   4478	1	29	localIOException9	IOException
    //   4577	18	29	localObject27	Object
    //   4608	21	29	localObject28	Object
    //   4639	18	29	localObject29	Object
    //   4670	11	29	localObject30	Object
    //   4712	10	29	localObject31	Object
    //   4735	14	29	localObject32	Object
    //   4762	22	29	localObject33	Object
    //   4793	11	29	localObject34	Object
    //   4891	420	29	localObject35	Object
    //   19	4249	30	localObject36	Object
    //   4298	26	30	localObject37	Object
    //   5163	93	30	localObject38	Object
    //   4	4383	31	localIHttpCommunicatorListener	IHttpCommunicatorListener
    //   159	2477	32	localObject39	Object
    // Exception table:
    //   from	to	target	type
    //   453	460	559	java/lang/Exception
    //   465	474	559	java/lang/Exception
    //   487	499	559	java/lang/Exception
    //   501	509	559	java/lang/Exception
    //   513	521	559	java/lang/Exception
    //   525	533	559	java/lang/Exception
    //   538	543	559	java/lang/Exception
    //   548	553	559	java/lang/Exception
    //   946	953	1047	java/lang/Exception
    //   958	967	1047	java/lang/Exception
    //   980	992	1047	java/lang/Exception
    //   994	1002	1047	java/lang/Exception
    //   1006	1014	1047	java/lang/Exception
    //   1018	1026	1047	java/lang/Exception
    //   1031	1036	1047	java/lang/Exception
    //   1041	1046	1047	java/lang/Exception
    //   727	749	1077	java/lang/Exception
    //   749	785	1077	java/lang/Exception
    //   1053	1069	1077	java/lang/Exception
    //   1208	1215	1309	java/lang/Exception
    //   1220	1229	1309	java/lang/Exception
    //   1242	1254	1309	java/lang/Exception
    //   1256	1264	1309	java/lang/Exception
    //   1268	1276	1309	java/lang/Exception
    //   1280	1288	1309	java/lang/Exception
    //   1293	1298	1309	java/lang/Exception
    //   1303	1308	1309	java/lang/Exception
    //   324	333	1462	java/lang/Throwable
    //   337	346	1462	java/lang/Throwable
    //   565	572	1462	java/lang/Throwable
    //   577	586	1462	java/lang/Throwable
    //   586	615	1462	java/lang/Throwable
    //   637	691	1462	java/lang/Throwable
    //   716	722	1462	java/lang/Throwable
    //   727	749	1462	java/lang/Throwable
    //   749	785	1462	java/lang/Throwable
    //   1053	1069	1462	java/lang/Throwable
    //   1079	1090	1462	java/lang/Throwable
    //   1090	1106	1462	java/lang/Throwable
    //   1320	1336	1462	java/lang/Throwable
    //   1336	1354	1462	java/lang/Throwable
    //   1354	1391	1462	java/lang/Throwable
    //   1391	1420	1462	java/lang/Throwable
    //   1420	1427	1462	java/lang/Throwable
    //   1451	1462	1462	java/lang/Throwable
    //   1923	1934	1462	java/lang/Throwable
    //   2212	2220	1462	java/lang/Throwable
    //   2236	2243	1462	java/lang/Throwable
    //   2257	2288	1462	java/lang/Throwable
    //   2288	2309	1462	java/lang/Throwable
    //   2309	2316	1462	java/lang/Throwable
    //   2525	2532	1462	java/lang/Throwable
    //   2535	2558	1462	java/lang/Throwable
    //   2561	2597	1462	java/lang/Throwable
    //   2605	2625	1462	java/lang/Throwable
    //   2647	2664	1462	java/lang/Throwable
    //   2667	2678	1462	java/lang/Throwable
    //   2704	2714	1462	java/lang/Throwable
    //   2720	2763	1462	java/lang/Throwable
    //   2763	2795	1462	java/lang/Throwable
    //   2795	2847	1462	java/lang/Throwable
    //   2847	2858	1462	java/lang/Throwable
    //   3918	4008	1462	java/lang/Throwable
    //   4225	4234	1462	java/lang/Throwable
    //   1899	1908	1909	java/lang/Exception
    //   4386	4397	1909	java/lang/Exception
    //   324	333	1934	finally
    //   337	346	1934	finally
    //   565	572	1934	finally
    //   577	586	1934	finally
    //   586	615	1934	finally
    //   637	691	1934	finally
    //   701	706	1934	finally
    //   706	711	1934	finally
    //   716	722	1934	finally
    //   727	749	1934	finally
    //   749	785	1934	finally
    //   1053	1069	1934	finally
    //   1079	1090	1934	finally
    //   1090	1106	1934	finally
    //   1320	1336	1934	finally
    //   1336	1354	1934	finally
    //   1354	1391	1934	finally
    //   1391	1420	1934	finally
    //   1420	1427	1934	finally
    //   1451	1462	1934	finally
    //   1923	1934	1934	finally
    //   2212	2220	1934	finally
    //   2236	2243	1934	finally
    //   2257	2288	1934	finally
    //   2288	2309	1934	finally
    //   2309	2316	1934	finally
    //   2525	2532	1934	finally
    //   2535	2558	1934	finally
    //   2561	2597	1934	finally
    //   2605	2625	1934	finally
    //   2647	2664	1934	finally
    //   2667	2678	1934	finally
    //   2704	2714	1934	finally
    //   2720	2763	1934	finally
    //   2763	2795	1934	finally
    //   2795	2847	1934	finally
    //   2847	2858	1934	finally
    //   3918	4008	1934	finally
    //   2418	2425	2519	java/lang/Exception
    //   2430	2439	2519	java/lang/Exception
    //   2452	2464	2519	java/lang/Exception
    //   2466	2474	2519	java/lang/Exception
    //   2478	2486	2519	java/lang/Exception
    //   2490	2498	2519	java/lang/Exception
    //   2503	2508	2519	java/lang/Exception
    //   2513	2518	2519	java/lang/Exception
    //   2876	2916	3153	java/lang/Throwable
    //   3141	3150	3153	java/lang/Throwable
    //   3640	3647	3748	java/lang/Exception
    //   3652	3661	3748	java/lang/Exception
    //   3675	3687	3748	java/lang/Exception
    //   3689	3697	3748	java/lang/Exception
    //   3702	3707	3748	java/lang/Exception
    //   3712	3717	3748	java/lang/Exception
    //   3722	3727	3748	java/lang/Exception
    //   3736	3741	3748	java/lang/Exception
    //   2955	2972	3867	java/lang/Throwable
    //   2993	2999	3867	java/lang/Throwable
    //   3049	3057	3867	java/lang/Throwable
    //   3073	3080	3867	java/lang/Throwable
    //   3096	3102	3867	java/lang/Throwable
    //   3118	3127	3867	java/lang/Throwable
    //   3236	3243	3867	java/lang/Throwable
    //   3273	3280	3867	java/lang/Throwable
    //   3301	3307	3867	java/lang/Throwable
    //   3323	3334	3867	java/lang/Throwable
    //   3350	3356	3867	java/lang/Throwable
    //   3372	3381	3867	java/lang/Throwable
    //   3397	3404	3867	java/lang/Throwable
    //   3420	3427	3867	java/lang/Throwable
    //   3443	3448	3867	java/lang/Throwable
    //   3783	3793	3867	java/lang/Throwable
    //   3809	3814	3867	java/lang/Throwable
    //   3830	3839	3867	java/lang/Throwable
    //   3855	3864	3867	java/lang/Throwable
    //   4110	4117	4211	java/lang/Exception
    //   4122	4131	4211	java/lang/Exception
    //   4144	4156	4211	java/lang/Exception
    //   4158	4166	4211	java/lang/Exception
    //   4170	4178	4211	java/lang/Exception
    //   4182	4190	4211	java/lang/Exception
    //   4195	4200	4211	java/lang/Exception
    //   4205	4210	4211	java/lang/Exception
    //   1541	1548	4260	java/lang/Exception
    //   1552	1559	4260	java/lang/Exception
    //   1568	1577	4260	java/lang/Exception
    //   4267	4272	4275	java/io/IOException
    //   1541	1548	4280	finally
    //   1521	1528	4298	finally
    //   1587	1592	4298	finally
    //   1592	1604	4298	finally
    //   4267	4272	4298	finally
    //   4290	4295	4298	finally
    //   4295	4298	4298	finally
    //   1765	1772	4359	java/lang/Exception
    //   1777	1786	4359	java/lang/Exception
    //   1800	1812	4359	java/lang/Exception
    //   1814	1822	4359	java/lang/Exception
    //   1827	1832	4359	java/lang/Exception
    //   1837	1842	4359	java/lang/Exception
    //   1847	1852	4359	java/lang/Exception
    //   1861	1866	4359	java/lang/Exception
    //   2112	2119	4378	java/lang/Exception
    //   2124	2133	4378	java/lang/Exception
    //   2147	2159	4378	java/lang/Exception
    //   2161	2169	4378	java/lang/Exception
    //   2174	2179	4378	java/lang/Exception
    //   2184	2189	4378	java/lang/Exception
    //   2194	2199	4378	java/lang/Exception
    //   2204	2209	4378	java/lang/Exception
    //   513	521	4398	java/io/IOException
    //   525	533	4402	java/io/IOException
    //   538	543	4406	java/io/IOException
    //   1006	1014	4410	java/io/IOException
    //   1018	1026	4414	java/io/IOException
    //   1031	1036	4418	java/io/IOException
    //   1268	1276	4422	java/io/IOException
    //   1280	1288	4426	java/io/IOException
    //   1293	1298	4430	java/io/IOException
    //   2478	2486	4434	java/io/IOException
    //   2490	2498	4438	java/io/IOException
    //   2503	2508	4442	java/io/IOException
    //   4170	4178	4446	java/io/IOException
    //   4182	4190	4450	java/io/IOException
    //   4195	4200	4454	java/io/IOException
    //   3702	3707	4458	java/io/IOException
    //   3712	3717	4463	java/io/IOException
    //   3722	3727	4468	java/io/IOException
    //   1587	1592	4473	java/io/IOException
    //   4290	4295	4478	java/io/IOException
    //   1827	1832	4483	java/io/IOException
    //   1837	1842	4488	java/io/IOException
    //   1847	1852	4493	java/io/IOException
    //   2174	2179	4498	java/io/IOException
    //   2184	2189	4502	java/io/IOException
    //   2194	2199	4506	java/io/IOException
    //   42	50	4510	finally
    //   168	198	4539	finally
    //   201	241	4539	finally
    //   256	266	4539	finally
    //   266	277	4539	finally
    //   277	296	4539	finally
    //   311	324	4558	finally
    //   59	83	4577	finally
    //   87	111	4608	finally
    //   114	142	4639	finally
    //   142	168	4670	finally
    //   2869	2876	4697	finally
    //   2876	2916	4712	finally
    //   3141	3150	4712	finally
    //   2916	2933	4735	finally
    //   3210	3217	4735	finally
    //   2955	2972	4762	finally
    //   2993	2999	4762	finally
    //   3049	3057	4762	finally
    //   3073	3080	4762	finally
    //   3096	3102	4762	finally
    //   3118	3127	4762	finally
    //   3236	3243	4762	finally
    //   3273	3280	4762	finally
    //   3301	3307	4762	finally
    //   3323	3334	4762	finally
    //   3350	3356	4762	finally
    //   3372	3381	4762	finally
    //   3397	3404	4762	finally
    //   3420	3427	4762	finally
    //   3443	3448	4762	finally
    //   3783	3793	4762	finally
    //   3809	3814	4762	finally
    //   3830	3839	4762	finally
    //   3855	3864	4762	finally
    //   3460	3471	4793	finally
    //   4225	4234	4816	finally
    //   1552	1559	4828	finally
    //   1568	1577	4828	finally
    //   42	50	4833	java/lang/Throwable
    //   168	198	4868	java/lang/Throwable
    //   201	241	4868	java/lang/Throwable
    //   256	266	4868	java/lang/Throwable
    //   266	277	4868	java/lang/Throwable
    //   277	296	4868	java/lang/Throwable
    //   311	324	4915	java/lang/Throwable
    //   59	83	4962	java/lang/Throwable
    //   87	111	5010	java/lang/Throwable
    //   114	142	5058	java/lang/Throwable
    //   142	168	5101	java/lang/Throwable
    //   2869	2876	5148	java/lang/Throwable
    //   2916	2933	5208	java/lang/Throwable
    //   3210	3217	5208	java/lang/Throwable
    //   3460	3471	5266	java/lang/Throwable
    //   701	706	5317	java/lang/Throwable
    //   706	711	5317	java/lang/Throwable
  }
  
  public void a(HttpMsg paramHttpMsg, String paramString1, String paramString2)
  {
    RichMediaUtil.a(RichMediaUtil.b(paramHttpMsg.jdField_c_of_type_Int), paramHttpMsg.e().equals("POST"), RichMediaUtil.c(paramHttpMsg.jdField_b_of_type_Int), paramHttpMsg.jdField_a_of_type_JavaLangString, paramString1, paramString2);
  }
  
  protected void a(HttpMsg paramHttpMsg, boolean paramBoolean, long paramLong)
  {
    paramHttpMsg.jdField_g_of_type_Int = ((int)paramLong);
    int i = paramHttpMsg.jdField_b_of_type_Int;
    int j = paramHttpMsg.jdField_c_of_type_Int;
    int k = paramHttpMsg.jdField_d_of_type_Int;
    if (((i == -1) || (j == -1)) && (QLog.isColorLevel())) {
      QLog.e("flowstat", 2, "fileType:" + i + ",busiType:" + j);
    }
    if ((this.jdField_a_of_type_MqqUtilWeakReference != null) && (this.jdField_a_of_type_MqqUtilWeakReference.get() != null)) {
      ((IHttpCommunicatorFlowCount)this.jdField_a_of_type_MqqUtilWeakReference.get()).countFlow(paramBoolean, k, i, j, paramLong);
    }
  }
  
  public void a(String paramString)
  {
    int i = 0;
    if (this.jdField_c_of_type_Boolean) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.richmedia.HttpCommunicator", 2, "queueSize:" + this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator$PriorityQueue.a() + " mConcurrentRunningMsgs:" + this.e + " mConcurrentLimit:" + this.jdField_d_of_type_Int + " reason:" + paramString + " tid:" + Thread.currentThread().getId());
      }
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator$PriorityQueue.a() == 0) {
        return;
      }
    }
    akha[] arrayOfakha;
    int j;
    if (this.e < this.jdField_d_of_type_Int)
    {
      paramString = this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator$PriorityQueue.a(false);
      if (paramString != null)
      {
        arrayOfakha = this.jdField_a_of_type_ArrayOfAkha;
        j = arrayOfakha.length;
      }
    }
    for (;;)
    {
      akha localakha;
      HttpMsg localHttpMsg;
      if (i < j)
      {
        localakha = arrayOfakha[i];
        localHttpMsg = localakha.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg;
        if (localakha.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
          break label268;
        }
        this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator$PriorityQueue.a(paramString);
        paramString.b();
        localakha.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
        localakha.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg = paramString;
        localakha.a(paramString);
        this.e += 1;
        paramString.jdField_h_of_type_Long = (SystemClock.uptimeMillis() - paramString.jdField_g_of_type_Long);
        if (QLog.isColorLevel()) {
          a(paramString, "attach", "");
        }
      }
      for (;;)
      {
        return;
        label268:
        if ((!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) || (!localakha.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) || (localHttpMsg == null) || (localHttpMsg.b() <= paramString.b())) {
          break;
        }
        localakha.a();
      }
      i += 1;
    }
  }
  
  void a(boolean paramBoolean, int paramInt, HttpURLConnection paramHttpURLConnection, HttpMsg paramHttpMsg, Throwable paramThrowable)
  {
    if ((paramThrowable instanceof IllegalArgumentException))
    {
      paramHttpMsg.a(9020, paramInt, paramThrowable.toString());
      return;
    }
    if ((paramThrowable instanceof IllegalStateException))
    {
      paramHttpMsg.a(9057, paramInt, paramThrowable.toString());
      return;
    }
    if ((paramThrowable instanceof IOException))
    {
      if ("request cancelled".equals(paramThrowable.getMessage()))
      {
        paramHttpMsg.a(9037, paramInt, paramThrowable.toString());
        return;
      }
      if ("httpcommunicator closed".equals(paramThrowable.getMessage()))
      {
        paramHttpMsg.a(9366, paramInt, paramThrowable.getMessage());
        return;
      }
      if ("preempted by higher msg".equals(paramThrowable.getMessage()))
      {
        paramHttpMsg.a(9361, paramInt, paramThrowable.toString());
        return;
      }
      if ("content-length zero".equals(paramThrowable.getMessage()))
      {
        paramHttpURLConnection = BaseTransProcessor.a("Q", -9531L);
        paramHttpMsg.b(HttpMsg.jdField_f_of_type_JavaLangString, paramHttpURLConnection);
        paramHttpMsg.a(-9527, paramInt, "content zero");
        return;
      }
      if ((paramThrowable instanceof MalformedURLException))
      {
        paramHttpMsg.a(9048, paramInt, paramThrowable.toString());
        return;
      }
      if ((paramThrowable instanceof InterruptedIOException))
      {
        if ((paramThrowable instanceof SocketTimeoutException))
        {
          if (paramBoolean)
          {
            paramHttpMsg.a(9014, paramInt, paramThrowable.toString());
            return;
          }
          paramHttpMsg.a(9050, paramInt, paramThrowable.toString());
          return;
        }
        paramHttpMsg.a(9049, paramInt, paramThrowable.toString());
        return;
      }
      if ((paramThrowable instanceof SocketException))
      {
        paramHttpURLConnection = paramThrowable.toString();
        if (QLog.isColorLevel())
        {
          paramHttpURLConnection = new StringBuilder();
          StackTraceElement[] arrayOfStackTraceElement = paramThrowable.getStackTrace();
          int j = arrayOfStackTraceElement.length;
          int i = 0;
          while (i < j)
          {
            StackTraceElement localStackTraceElement = arrayOfStackTraceElement[i];
            paramHttpURLConnection.append("\n").append(localStackTraceElement.toString());
            i += 1;
          }
          paramHttpURLConnection = paramHttpURLConnection.toString();
        }
        if ((paramThrowable instanceof ConnectException))
        {
          paramHttpMsg.a(9052, paramInt, paramHttpURLConnection);
          return;
        }
        if ((paramThrowable instanceof NoRouteToHostException))
        {
          paramHttpMsg.a(9053, paramInt, paramHttpURLConnection);
          return;
        }
        if ((paramThrowable instanceof PortUnreachableException))
        {
          paramHttpMsg.a(9054, paramInt, paramHttpURLConnection);
          return;
        }
        paramHttpMsg.a(9051, paramInt, paramHttpURLConnection);
        return;
      }
      if ((paramThrowable instanceof UnknownHostException))
      {
        paramHttpMsg.a(9055, paramInt, paramThrowable.toString());
        return;
      }
      if ((paramThrowable instanceof EOFException))
      {
        paramHttpMsg.a(9056, paramInt, paramThrowable.getMessage());
        return;
      }
      paramThrowable = paramThrowable.toString();
      if (paramThrowable.contains("unreachable)")) {
        paramHttpURLConnection = "N_" + -20005;
      }
      for (;;)
      {
        paramHttpMsg.a(9047, paramInt, paramThrowable);
        paramHttpMsg.b(HttpMsg.jdField_f_of_type_JavaLangString, paramHttpURLConnection);
        return;
        if (paramThrowable.contains("Connection refused"))
        {
          paramHttpURLConnection = "N_" + -20002;
        }
        else if (paramThrowable.contains("No route to host"))
        {
          if (paramThrowable.contains("SocketException")) {
            paramHttpURLConnection = "N_" + -20003;
          } else {
            paramHttpURLConnection = "N_" + -20004;
          }
        }
        else if (paramThrowable.contains("unexpected end of stream"))
        {
          paramHttpURLConnection = "N_" + -20005;
        }
        else if (paramThrowable.contains("Connection timed out"))
        {
          paramHttpURLConnection = "N_" + -20006;
        }
        else
        {
          if (paramThrowable.contains("unaccpet content type"))
          {
            paramHttpMsg.a(9064, paramInt, paramThrowable);
            return;
          }
          paramHttpURLConnection = "N_" + -20007;
        }
      }
    }
    if ((paramThrowable instanceof SecurityException))
    {
      paramHttpMsg.a(9022, paramInt, paramThrowable.toString());
      return;
    }
    paramHttpURLConnection = paramThrowable.getMessage();
    if ((!TextUtils.isEmpty(paramHttpURLConnection)) && (paramHttpURLConnection.contains("FlowDecoderExp")))
    {
      paramHttpMsg.a(9058, paramInt, paramHttpURLConnection);
      return;
    }
    if ((!TextUtils.isEmpty(paramHttpURLConnection)) && (paramHttpURLConnection.contains("DecryptError")))
    {
      paramHttpMsg.a(9059, paramInt, paramHttpURLConnection);
      return;
    }
    paramHttpMsg.a(9322, paramInt, Log.getStackTraceString(paramThrowable));
  }
  
  public int b(HttpMsg paramHttpMsg)
  {
    int i = this.jdField_c_of_type_Int;
    int j = -1;
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if ((!this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator$PriorityQueue.a() < i))
        {
          i = this.jdField_a_of_type_Int + 1;
          this.jdField_a_of_type_Int = i;
          paramHttpMsg.a(i);
          this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator$PriorityQueue.a(paramHttpMsg);
          paramHttpMsg.a().a(paramHttpMsg, null, 0);
          i = this.jdField_a_of_type_Int;
          ??? = new Object();
          paramHttpMsg.jdField_a_of_type_JavaLangObject = ???;
          paramHttpMsg.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
          a("sendMsgSync");
          if (paramHttpMsg.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {}
        }
      }
      try
      {
        ???.wait();
        return i;
        i = j;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("Q.richmedia.HttpCommunicator", 2, "exceed queue limit");
        i = j;
        continue;
        paramHttpMsg = finally;
        throw paramHttpMsg;
      }
      catch (InterruptedException paramHttpMsg)
      {
        for (;;)
        {
          paramHttpMsg.printStackTrace();
        }
      }
      finally {}
    }
  }
  
  public void b()
  {
    if (this.jdField_c_of_type_Boolean) {
      return;
    }
    this.jdField_c_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.d("Q.richmedia.HttpCommunicator", 2, "HttpCommunicator close.async doclose");
    }
    this.jdField_a_of_type_MqqOsMqqHandler.post(new akgz(this));
  }
  
  void b(int paramInt, HttpURLConnection paramHttpURLConnection, HttpMsg paramHttpMsg)
  {
    new StringBuilder().append("Response code: ").append(paramInt).toString();
    long l2 = 0L;
    String str = paramHttpURLConnection.getHeaderField("X-ErrNo");
    if ((str != null) && (!str.equals(""))) {}
    for (;;)
    {
      try
      {
        l1 = Long.parseLong(str);
        paramHttpURLConnection = BaseTransProcessor.a(paramInt, l1);
        paramHttpMsg.b(HttpMsg.jdField_f_of_type_JavaLangString, paramHttpURLConnection);
        paramHttpMsg.a(-9527, paramInt, paramHttpURLConnection);
        return;
      }
      catch (Exception paramHttpURLConnection)
      {
        paramHttpURLConnection.printStackTrace();
        l1 = l2;
        continue;
      }
      paramHttpURLConnection = paramHttpURLConnection.getHeaderField("User-ReturnCode");
      long l1 = l2;
      if (paramHttpURLConnection != null)
      {
        l1 = l2;
        if (!paramHttpURLConnection.equals("")) {
          try
          {
            l1 = Long.parseLong(paramHttpURLConnection);
          }
          catch (Exception paramHttpURLConnection)
          {
            paramHttpURLConnection.printStackTrace();
            l1 = l2;
          }
        }
      }
    }
  }
  
  public void c()
  {
    int i = 0;
    long l;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      l = System.currentTimeMillis();
      HttpMsg localHttpMsg;
      do
      {
        localHttpMsg = this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator$PriorityQueue.a(true);
        if (localHttpMsg == null) {
          break;
        }
      } while ((localHttpMsg == null) || (localHttpMsg.a() == null));
      localHttpMsg.a(9366, -1, "httpcommunicator_close");
      localHttpMsg.a().b(localHttpMsg, localHttpMsg);
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator$PriorityQueue.a();
    akha[] arrayOfakha = this.jdField_a_of_type_ArrayOfAkha;
    int j = arrayOfakha.length;
    while (i < j)
    {
      arrayOfakha[i].sendEmptyMessage(1);
      i += 1;
    }
    this.jdField_a_of_type_ArrayOfAkha = null;
    this.e = 0;
    this.jdField_d_of_type_Int = 0;
    if (QLog.isColorLevel()) {
      QLog.d("Q.richmedia.HttpCommunicator", 2, "HttpCommunicator close_inter.elapse:" + (System.currentTimeMillis() - l));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.httputils.HttpCommunicator
 * JD-Core Version:    0.7.0.1
 */