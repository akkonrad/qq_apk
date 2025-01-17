package com.tencent.mobileqq.msf.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.DetailedState;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.telephony.TelephonyManager;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class a
{
  private static final int A = 11;
  private static final int B = 12;
  private static final int C = 14;
  private static final int D = 15;
  private static int E = 0;
  private static boolean F = false;
  private static long G = 0L;
  private static Uri H = Uri.parse("content://telephony/carriers/preferapn");
  private static final byte I = 0;
  private static final byte J = 1;
  private static final byte K = 2;
  static List a;
  static List b;
  static volatile boolean c = false;
  static a d;
  static Handler e;
  static NetworkInfo f;
  public static boolean g = false;
  public static int h = 0;
  public static String i;
  public static String j;
  public static String k;
  static BroadcastReceiver l = new b();
  private static String m = "MSF.D.AppNetInfoImpl";
  private static final String n = "http://3gimg.qq.com/ping.html";
  private static int o = 0;
  private static AtomicBoolean p = new AtomicBoolean(false);
  private static final int q = 1;
  private static final int r = 2;
  private static final int s = 3;
  private static final int t = 4;
  private static final int u = 5;
  private static final int v = 16;
  private static final int w = 17;
  private static final int x = 18;
  private static final int y = 19;
  private static final int z = 10;
  
  static
  {
    a = new LinkedList();
    b = new LinkedList();
    c = false;
    d = new a("nethandlerthread");
    E = -1;
    F = true;
    h = 0;
    i = "";
    j = "";
    k = "";
  }
  
  private static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "UNKNOWN";
    case 0: 
      return "NONE";
    case 1: 
      return "MOBILE";
    case 2: 
      return "WiFi";
    }
    return "WiFi";
  }
  
  public static void a()
    throws Exception
  {
    Object localObject = (HttpURLConnection)new URL("http://3gimg.qq.com/ping.html").openConnection();
    ((HttpURLConnection)localObject).setDoOutput(true);
    ((HttpURLConnection)localObject).setDoInput(true);
    ((HttpURLConnection)localObject).setRequestMethod("GET");
    ((HttpURLConnection)localObject).setUseCaches(false);
    ((HttpURLConnection)localObject).setInstanceFollowRedirects(false);
    ((HttpURLConnection)localObject).setReadTimeout(60000);
    ((HttpURLConnection)localObject).connect();
    byte[] arrayOfByte = new byte[8];
    ((HttpURLConnection)localObject).getInputStream().read(arrayOfByte);
    ((HttpURLConnection)localObject).getInputStream().close();
    ((HttpURLConnection)localObject).disconnect();
    localObject = new String(arrayOfByte);
    if ("Poduct3G".equals(localObject))
    {
      b(true);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(m, 2, "wifi ping resp content is " + (String)localObject);
    }
    g = true;
  }
  
  public static void a(Context paramContext, NetworkInfo paramNetworkInfo)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    NetworkInfo localNetworkInfo = paramContext.getNetworkInfo(0);
    if (localNetworkInfo != null) {}
    try
    {
      i = localNetworkInfo.getExtraInfo();
      f = paramContext.getActiveNetworkInfo();
      a(f, paramNetworkInfo);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.d(m, 1, "get currentAPN error " + localException);
      }
    }
  }
  
  public static void a(Context paramContext, INetEventHandler paramINetEventHandler)
  {
    if (paramINetEventHandler == null) {
      QLog.w(m, 1, Thread.currentThread().getName() + " registerNetChangeReceiver null");
    }
    h();
    if ((!c) || (e == null)) {
      return;
    }
    paramContext = e.obtainMessage();
    paramContext.what = 2;
    paramContext.obj = paramINetEventHandler;
    e.sendMessage(paramContext);
  }
  
  public static void a(Context paramContext, INetInfoHandler paramINetInfoHandler)
  {
    if (paramINetInfoHandler == null) {
      QLog.w(m, 1, Thread.currentThread().getName() + " registerConnectionChangeReceiver null");
    }
    h();
    if ((!c) || (e == null)) {
      return;
    }
    paramContext = e.obtainMessage();
    paramContext.what = 1;
    paramContext.obj = paramINetInfoHandler;
    e.sendMessage(paramContext);
  }
  
  public static void a(NetworkInfo paramNetworkInfo1, NetworkInfo paramNetworkInfo2)
  {
    String str;
    if (paramNetworkInfo1 != null) {
      str = paramNetworkInfo1.getTypeName();
    }
    do
    {
      do
      {
        try
        {
          j = paramNetworkInfo1.getSubtypeName();
          if (str.toLowerCase().contains("mobile_mms"))
          {
            QLog.d(m, 1, "checkConnInfo current typeName: mobile_mms ignore.");
            return;
          }
        }
        catch (Exception localException)
        {
          do
          {
            for (;;)
            {
              QLog.d(m, 1, "get subtypeName error " + localException);
            }
            QLog.d(m, 1, "currentAPN:" + i + ". received networkInfo: " + paramNetworkInfo1.getDetailedState() + " :" + paramNetworkInfo1 + ". ExtraNetInfo: " + paramNetworkInfo2);
            if (paramNetworkInfo1.getDetailedState() == NetworkInfo.DetailedState.CONNECTED)
            {
              if (1 == paramNetworkInfo1.getType())
              {
                u();
                q();
                return;
              }
              if (a(paramNetworkInfo1))
              {
                u();
                t();
                p();
                return;
              }
              r();
              QLog.d(m, 1, "Unexcepted activeNetInfo type:" + paramNetworkInfo1.getType());
              return;
            }
          } while ((paramNetworkInfo1.getDetailedState() != NetworkInfo.DetailedState.DISCONNECTED) && (paramNetworkInfo1.getDetailedState() != NetworkInfo.DetailedState.FAILED) && (paramNetworkInfo1.getDetailedState() != NetworkInfo.DetailedState.IDLE) && (paramNetworkInfo1.getDetailedState() != NetworkInfo.DetailedState.SUSPENDED));
          if (1 == paramNetworkInfo1.getType())
          {
            t();
            return;
          }
          if (a(paramNetworkInfo1))
          {
            s();
            return;
          }
          u();
          return;
        }
      } while (paramNetworkInfo2 == null);
      QLog.d(m, 1, "currentAPN:" + i + ". ActiveNetInfo: " + paramNetworkInfo1 + ". ExtraNetInfo: " + paramNetworkInfo2);
    } while ((paramNetworkInfo2.getDetailedState() != NetworkInfo.DetailedState.DISCONNECTED) && (paramNetworkInfo2.getDetailedState() != NetworkInfo.DetailedState.FAILED) && (paramNetworkInfo2.getDetailedState() != NetworkInfo.DetailedState.IDLE) && (paramNetworkInfo2.getDetailedState() != NetworkInfo.DetailedState.SUSPENDED));
    if (1 == paramNetworkInfo2.getType())
    {
      s();
      t();
      return;
    }
    if (a(paramNetworkInfo2))
    {
      s();
      return;
    }
    s();
    t();
    u();
  }
  
  public static void a(boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        long l1 = System.currentTimeMillis();
        f = ((ConnectivityManager)BaseApplication.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
        a(f, null);
        if ((e != null) && ((!c) || (f != null))) {
          e.sendEmptyMessage(3);
        }
        if ((paramBoolean) && (f != null) && (f.getDetailedState() == NetworkInfo.DetailedState.CONNECTED))
        {
          localObject = new HashMap();
          ((HashMap)localObject).put("processName", MsfServiceSdk.get().processName);
          ((HashMap)localObject).put("netType", String.valueOf(f.getType()));
          localRdmReq = new RdmReq();
          localRdmReq.eventName = "CheckNetIsValid";
          localRdmReq.elapse = (System.currentTimeMillis() - l1);
          localRdmReq.isSucceed = true;
          localRdmReq.isRealTime = true;
          localRdmReq.params = ((Map)localObject);
        }
      }
      catch (Exception localException2)
      {
        Object localObject;
        RdmReq localRdmReq;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(m, 2, localException2.toString(), localException2);
      }
      try
      {
        localObject = MsfMsgUtil.getRdmReportMsg(MsfServiceSdk.get().getMsfServiceName(), localRdmReq);
        MsfServiceSdk.get().sendMsg((ToServiceMsg)localObject);
        return;
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
        return;
      }
    }
  }
  
  public static boolean a(NetworkInfo paramNetworkInfo)
  {
    return (paramNetworkInfo.getType() == 0) || (50 == paramNetworkInfo.getType());
  }
  
  public static boolean a(INetEventHandler paramINetEventHandler)
  {
    if (paramINetEventHandler == null) {
      QLog.w(m, 1, Thread.currentThread().getName() + " unregisterNetEventHandler null");
    }
    do
    {
      return false;
      h();
    } while ((!c) || (e == null));
    Message localMessage = e.obtainMessage();
    localMessage.what = 5;
    localMessage.obj = paramINetEventHandler;
    e.sendMessage(localMessage);
    return true;
  }
  
  public static boolean a(INetInfoHandler paramINetInfoHandler)
  {
    if (paramINetInfoHandler == null)
    {
      QLog.w(m, 1, Thread.currentThread().getName() + " unregisterNetInfoHandler null");
      return false;
    }
    h();
    if ((!c) || (e == null))
    {
      QLog.w(m, 1, Thread.currentThread().getName() + " unregisterNetInfoHandler initHandler=" + c + " handler=" + e);
      return false;
    }
    Message localMessage = e.obtainMessage();
    localMessage.what = 4;
    localMessage.obj = paramINetInfoHandler;
    e.sendMessage(localMessage);
    return true;
  }
  
  public static boolean a(Runnable paramRunnable)
  {
    if (paramRunnable == null) {
      return false;
    }
    v();
    return e.post(paramRunnable);
  }
  
  private static void b(int paramInt)
  {
    for (;;)
    {
      try
      {
        if (o == paramInt)
        {
          if (QLog.isColorLevel()) {
            QLog.d(m, 2, "found repeat net event , now is " + b() + " now:" + paramInt + " last:" + o);
          }
          return;
        }
        if (paramInt > 0)
        {
          b(true);
          QLog.d(m, 1, "netchange " + a(o) + " to " + a(paramInt));
          E = -1;
          if (paramInt != 1) {
            break;
          }
          if ((o != 0) && (o != -2)) {
            break label171;
          }
          E = 0;
          o = paramInt;
          continue;
        }
        b(false);
      }
      finally {}
      continue;
      label171:
      if ((o == 2) || (o == 3)) {
        E = 1;
      } else if (o <= 7) {
        E = 6;
      }
    }
    for (;;)
    {
      label208:
      if ((o == 0) || (o == -2))
      {
        E = 2;
        break;
      }
      if (o == 1)
      {
        E = 3;
        break;
      }
      if (o > 7) {
        break;
      }
      E = 7;
      break;
      do
      {
        if ((paramInt > 3) && (paramInt <= 7))
        {
          if ((o == 0) || (o == -2))
          {
            E = 8;
            break;
          }
          if (o == 1)
          {
            E = 9;
            break;
          }
          if ((o != 2) && (paramInt != 3)) {
            break;
          }
          E = 10;
          break;
        }
        if (o == 1)
        {
          E = 4;
          break;
        }
        if ((o == 2) || (o == 3))
        {
          E = 5;
          break;
        }
        if (o > 7) {
          break;
        }
        E = 11;
        break;
        if (paramInt == 2) {
          break label208;
        }
      } while (paramInt != 3);
    }
  }
  
  private static void b(boolean paramBoolean)
  {
    p.set(paramBoolean);
  }
  
  public static boolean b()
  {
    return p.get();
  }
  
  public static int c()
  {
    if (e())
    {
      if (g) {
        return 3;
      }
      return 2;
    }
    if (f()) {
      return 1;
    }
    return 0;
  }
  
  public static int d()
  {
    return h;
  }
  
  public static boolean e()
  {
    return (o == 2) || (o == 3);
  }
  
  public static boolean f()
  {
    return o == 1;
  }
  
  public static NetworkInfo g()
  {
    return f;
  }
  
  public static void h()
  {
    try
    {
      
      synchronized (d)
      {
        if ((!c) && (BaseApplication.getContext() != null))
        {
          IntentFilter localIntentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
          BaseApplication.getContext().registerReceiver(l, localIntentFilter);
          a(false);
          c = true;
        }
        long l1;
        do
        {
          do
          {
            return;
          } while ((!c) || (b()));
          l1 = System.currentTimeMillis();
        } while (l1 - G < 5000L);
        G = l1;
        a(true);
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.d(m, 1, "failed to check init ops " + localException.toString());
    }
  }
  
  /* Error */
  private static void n()
  {
    // Byte code:
    //   0: invokestatic 393	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3: ldc 235
    //   5: invokevirtual 394	com/tencent/qphone/base/util/BaseApplication:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   8: checkcast 243	android/net/ConnectivityManager
    //   11: iconst_0
    //   12: invokevirtual 247	android/net/ConnectivityManager:getNetworkInfo	(I)Landroid/net/NetworkInfo;
    //   15: astore_0
    //   16: aload_0
    //   17: ifnull +11 -> 28
    //   20: aload_0
    //   21: invokevirtual 252	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   24: putstatic 112	com/tencent/mobileqq/msf/sdk/a:i	Ljava/lang/String;
    //   27: return
    //   28: invokestatic 393	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   31: invokevirtual 532	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   34: getstatic 126	com/tencent/mobileqq/msf/sdk/a:H	Landroid/net/Uri;
    //   37: aconst_null
    //   38: aconst_null
    //   39: aconst_null
    //   40: aconst_null
    //   41: invokevirtual 538	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   44: astore_1
    //   45: aload_1
    //   46: ifnull +99 -> 145
    //   49: aload_1
    //   50: astore_0
    //   51: aload_1
    //   52: invokeinterface 543 1 0
    //   57: ifeq +88 -> 145
    //   60: aload_1
    //   61: astore_0
    //   62: aload_1
    //   63: aload_1
    //   64: ldc_w 545
    //   67: invokeinterface 549 2 0
    //   72: invokeinterface 552 2 0
    //   77: putstatic 112	com/tencent/mobileqq/msf/sdk/a:i	Ljava/lang/String;
    //   80: goto -35 -> 45
    //   83: astore_2
    //   84: aload_1
    //   85: astore_0
    //   86: aload_2
    //   87: invokevirtual 553	java/lang/Throwable:printStackTrace	()V
    //   90: aload_1
    //   91: ifnull -64 -> 27
    //   94: aload_1
    //   95: invokeinterface 554 1 0
    //   100: return
    //   101: astore_0
    //   102: getstatic 77	com/tencent/mobileqq/msf/sdk/a:m	Ljava/lang/String;
    //   105: iconst_1
    //   106: new 215	java/lang/StringBuilder
    //   109: dup
    //   110: invokespecial 216	java/lang/StringBuilder:<init>	()V
    //   113: ldc_w 263
    //   116: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: aload_0
    //   120: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   123: invokevirtual 226	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: invokestatic 229	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   129: return
    //   130: astore_1
    //   131: aconst_null
    //   132: astore_0
    //   133: aload_0
    //   134: ifnull +9 -> 143
    //   137: aload_0
    //   138: invokeinterface 554 1 0
    //   143: aload_1
    //   144: athrow
    //   145: aload_1
    //   146: ifnull -119 -> 27
    //   149: aload_1
    //   150: invokeinterface 554 1 0
    //   155: return
    //   156: astore_1
    //   157: goto -24 -> 133
    //   160: astore_2
    //   161: aconst_null
    //   162: astore_1
    //   163: goto -79 -> 84
    // Local variable table:
    //   start	length	slot	name	signature
    //   15	71	0	localObject1	Object
    //   101	19	0	localException	Exception
    //   132	6	0	localObject2	Object
    //   44	51	1	localCursor	android.database.Cursor
    //   130	20	1	localObject3	Object
    //   156	1	1	localObject4	Object
    //   162	1	1	localObject5	Object
    //   83	4	2	localThrowable1	java.lang.Throwable
    //   160	1	2	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   51	60	83	java/lang/Throwable
    //   62	80	83	java/lang/Throwable
    //   20	27	101	java/lang/Exception
    //   94	100	101	java/lang/Exception
    //   137	143	101	java/lang/Exception
    //   143	145	101	java/lang/Exception
    //   149	155	101	java/lang/Exception
    //   28	45	130	finally
    //   51	60	156	finally
    //   62	80	156	finally
    //   86	90	156	finally
    //   28	45	160	java/lang/Throwable
  }
  
  private static void o()
  {
    try
    {
      WifiInfo localWifiInfo = ((WifiManager)BaseApplication.getContext().getSystemService("wifi")).getConnectionInfo();
      if (localWifiInfo != null)
      {
        QLog.d(m, 1, "checknetinfo get wifi ssid " + localWifiInfo.getSSID());
        k = localWifiInfo.getSSID();
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.d(m, 1, "failed to get wifi ssid");
    }
  }
  
  private static void p()
  {
    b(o | 0x1);
  }
  
  private static void q()
  {
    b(o | 0x2);
  }
  
  private static void r()
  {
    b(o | 0x4);
  }
  
  private static void s()
  {
    b(o & 0xFFFFFFFE);
  }
  
  private static void t()
  {
    b(o & 0xFFFFFFFD);
  }
  
  private static void u()
  {
    b(o & 0xFFFFFFFB);
  }
  
  private static void v()
  {
    try
    {
      if (e == null) {
        synchronized (d)
        {
          if (e == null)
          {
            if (!d.isAlive())
            {
              QLog.d(m, 1, "PID=" + Process.myPid() + " tid=" + Thread.currentThread().getId() + " AppNetInfoImpl checkInitHandler. looper=" + Looper.myLooper());
              d.start();
            }
            e = new Handler(d.getLooper(), d);
          }
          return;
        }
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.d(m, 1, "initHandler exception " + localException.toString());
    }
  }
  
  static class a
    extends HandlerThread
    implements Handler.Callback
  {
    public a(String paramString)
    {
      super();
    }
    
    public boolean handleMessage(Message paramMessage)
    {
      int i = paramMessage.what;
      int j;
      Object localObject1;
      label437:
      label450:
      label498:
      boolean bool;
      switch (i)
      {
      default: 
      case 1: 
      case 2: 
      case 3: 
        label551:
        do
        {
          do
          {
            do
            {
              for (;;)
              {
                return false;
                try
                {
                  paramMessage = (INetInfoHandler)paramMessage.obj;
                  if (paramMessage != null) {
                    if (!a.a.contains(paramMessage))
                    {
                      a.a.add(paramMessage);
                      QLog.d(a.i(), 1, "register netInfo " + paramMessage + ", total=" + a.a.size());
                      return false;
                    }
                  }
                }
                catch (Exception paramMessage)
                {
                  QLog.d(a.i(), 1, "failed to handle msg " + i);
                  return false;
                }
              }
              QLog.w(a.i(), 1, "register netInfo " + paramMessage + " duplication, total=" + a.a.size());
              return false;
              paramMessage = (INetEventHandler)paramMessage.obj;
            } while (paramMessage == null);
            if (!a.b.contains(paramMessage))
            {
              a.b.add(paramMessage);
              QLog.d(a.i(), 1, "register netEvent " + paramMessage + ", total=" + a.b.size());
              return false;
            }
            QLog.w(a.i(), 1, "register netEvent " + paramMessage + " duplication, total=" + a.b.size());
            return false;
            j = a.j();
            if (j != -1) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.d(a.i(), 2, "no change in connectivity");
          return false;
          if (a.f())
          {
            a.k();
            paramMessage = a.a.iterator();
          }
          for (;;)
          {
            if (!paramMessage.hasNext()) {
              break label498;
            }
            localObject1 = (INetInfoHandler)paramMessage.next();
            if (localObject1 != null)
            {
              if ((j == 0) || (j == 6))
              {
                ((INetInfoHandler)localObject1).onNetNone2Mobile(a.i);
                continue;
                if (!a.e()) {
                  break;
                }
                a.l();
                break;
              }
              if (j != 1) {
                break label1263;
              }
              ((INetInfoHandler)localObject1).onNetWifi2Mobile(a.i);
              continue;
              ((INetInfoHandler)localObject1).onNetNone2Wifi(a.k);
              continue;
              if (j == 3) {
                ((INetInfoHandler)localObject1).onNetMobile2Wifi(a.k);
              } else if (j == 4) {
                ((INetInfoHandler)localObject1).onNetMobile2None();
              } else if (j == 5) {
                ((INetInfoHandler)localObject1).onNetWifi2None();
              }
            }
          }
          paramMessage = a.b.iterator();
          while (paramMessage.hasNext())
          {
            localObject1 = (INetEventHandler)paramMessage.next();
            if (localObject1 != null)
            {
              if ((j == 4) || (j == 5)) {
                break label1277;
              }
              if (j != 11) {
                break label1257;
              }
              break label1277;
              ((INetEventHandler)localObject1).onNetChangeEvent(bool);
            }
          }
        } while (!a.f());
        if ((a.f != null) && (a.f.isAvailable()))
        {
          j = a.f.getType();
          switch (j)
          {
          case 1: 
          case 6: 
          case 7: 
          case 8: 
          case 9: 
          case 13: 
            a.h = -1;
            QLog.d(a.i(), 1, "Unexcepted Mobile Type:" + j);
            return false;
          case 0: 
          case 2: 
          case 3: 
          case 4: 
          case 5: 
          case 10: 
          case 11: 
          case 12: 
          case 14: 
          case 15: 
            label672:
            paramMessage = (TelephonyManager)BaseApplication.getContext().getSystemService("phone");
            j = g.b(paramMessage);
            switch (j)
            {
            }
            break;
          }
        }
        break;
      }
      for (;;)
      {
        a.h = g.a(paramMessage, j);
        QLog.d(a.i(), 1, "Unexcepted networkType:" + j + " ,mobileInfo:" + a.h);
        return false;
        a.h = 3;
        return false;
        a.h = 2;
        return false;
        a.h = 1;
        return false;
        a.h = 0;
        return false;
        paramMessage = (INetInfoHandler)paramMessage.obj;
        Object localObject2;
        if (paramMessage != null)
        {
          localObject1 = a.a.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (INetInfoHandler)((Iterator)localObject1).next();
            if (localObject2 == paramMessage)
            {
              QLog.i(a.i(), 1, "unRegister netInfo " + localObject2);
              ((Iterator)localObject1).remove();
            }
          }
        }
        QLog.d(a.i(), 1, "unRegister netInfo remain=" + a.a.size());
        if (!a.m()) {
          break;
        }
        paramMessage = a.a.iterator();
        while (paramMessage.hasNext())
        {
          localObject1 = (INetInfoHandler)paramMessage.next();
          QLog.i(a.i(), 1, "netInfo " + localObject1);
        }
        paramMessage = (INetEventHandler)paramMessage.obj;
        if (paramMessage != null)
        {
          localObject1 = a.b.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (INetEventHandler)((Iterator)localObject1).next();
            if (localObject2 == paramMessage)
            {
              QLog.i(a.i(), 1, "unRegister netEvent " + localObject2);
              ((Iterator)localObject1).remove();
            }
          }
        }
        QLog.d(a.i(), 1, "unRegister netEvent remain=" + a.b.size());
        if (!a.m()) {
          break;
        }
        paramMessage = a.b.iterator();
        while (paramMessage.hasNext())
        {
          localObject1 = (INetEventHandler)paramMessage.next();
          QLog.i(a.i(), 1, "netEvent " + localObject1);
        }
        label1257:
        bool = true;
        break label551;
        label1263:
        if (j == 2) {
          break label437;
        }
        if (j != 7) {
          break label450;
        }
        break label437;
        label1277:
        bool = false;
        break label551;
        break label672;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.a
 * JD-Core Version:    0.7.0.1
 */