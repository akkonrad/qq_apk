package com.tencent.mobileqq.msf.sdk;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.tencent.mobileqq.msf.core.e;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class n
{
  private static AtomicBoolean A;
  private static int B = 0;
  private static long C = 0L;
  private static AtomicBoolean D;
  private static final int[] E;
  private static AtomicInteger F;
  private static Handler G;
  private static volatile Context H;
  private static String I = "";
  private static final String J = "MSF.D.QLogImpl";
  private static final String K = "QLog";
  private static final String L = "";
  protected static int a = 1;
  protected static final boolean b = false;
  protected static boolean c = false;
  protected static Object d;
  public static final String e = "LOGLEVEL_";
  public static final String f = "LOGLEVELTIME";
  public static final String g = "LOGSAVETIME";
  static k h;
  static final ReentrantLock i;
  public static Runnable j;
  static String k = "";
  static long l = 0L;
  static Thread m = new q();
  public static final String n = "D";
  public static final String o = "W";
  public static final String p = "E";
  static HashSet q = new HashSet();
  static long r = 0L;
  private static final String s = "appMemory";
  private static int t = a;
  private static String u;
  private static long v;
  private static long w;
  private static String x;
  private static String y;
  private static FileWriter z;
  
  static
  {
    c = true;
    d = new Object();
    u = "";
    x = "";
    y = "";
    h = new k(15000);
    i = new ReentrantLock();
    A = new AtomicBoolean(false);
    C = 0L;
    D = new AtomicBoolean(false);
    E = new int[] { 1, 2, 4, 8, 16, 29 };
    F = new AtomicInteger(0);
    G = new Handler(Looper.getMainLooper());
    H = null;
    j = new o();
  }
  
  public static String a()
  {
    int i1 = x.indexOf(":");
    if (i1 > 0) {
      return x.substring(0, i1);
    }
    return x;
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    case 3: 
    default: 
      return "E";
    case 2: 
      return "W";
    case 4: 
      return "D";
    }
    return "E";
  }
  
  public static String a(String paramString)
  {
    return x.replace(":", "_") + "." + paramString + ".log";
  }
  
  public static void a(int paramInt, String paramString1, String paramString2)
  {
    int i1 = 0;
    Object localObject = BaseApplication.getContext().getSharedPreferences("QLog", 0);
    long l1 = ((SharedPreferences)localObject).getLong("", -1L);
    if ((l1 == -1L) || (System.currentTimeMillis() - l1 > 3600000L))
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putLong("", System.currentTimeMillis());
      ((SharedPreferences.Editor)localObject).commit();
      i1 = 1;
    }
    if (i1 != 0)
    {
      paramString1 = new r(paramInt, paramString1, paramString2);
      paramString1.setName("doReportLogSelfThread");
      paramString1.start();
    }
  }
  
  public static void a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    String str = paramString1 + ".zip";
    File localFile = new File(str);
    localFile.delete();
    try
    {
      localFile.createNewFile();
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new File(paramString1));
      e.a(localArrayList, str);
      e.a(paramInt, str, paramString2, paramString3);
      localFile.delete();
      return;
    }
    catch (IOException paramString1)
    {
      paramString1.printStackTrace();
      QLog.d("MSF.D.QLogImpl", 1, "doReportLogSelf error " + paramString1);
    }
  }
  
  static void a(long paramLong)
    throws IOException
  {
    for (;;)
    {
      Object localObject3;
      File localFile;
      try
      {
        u = Environment.getExternalStorageDirectory().getPath() + "/tencent/" + y.replace(".", "/") + "/";
        localObject3 = new File(u);
        if (!((File)localObject3).exists()) {
          ((File)localObject3).mkdirs();
        }
        k = u + a(b(paramLong));
      }
      finally {}
      try
      {
        localFile = new File(k);
        try
        {
          if (!localFile.exists())
          {
            boolean bool = localFile.createNewFile();
            o();
            localObject3 = localFile;
            if (z != null)
            {
              z.write(I + "|" + x + "|D|" + "MSF.D.QLogImpl" + "|" + Build.MODEL + " " + Build.VERSION.RELEASE + " create newLogFile " + localFile.getName() + " " + bool + "\n");
              z.flush();
              localObject3 = localFile;
            }
            z = new FileWriter((File)localObject3, true);
            o();
            return;
          }
          o();
          localObject3 = localFile;
          if (z == null) {
            continue;
          }
          z.write(I + "|" + x + "|E|" + "MSF.D.QLogImpl" + "|" + Build.MODEL + " " + Build.VERSION.RELEASE + "|newLogFile " + localFile.getName() + " is existed.\n");
          z.flush();
          localObject3 = localFile;
          continue;
          localThrowable1.printStackTrace();
        }
        catch (Throwable localThrowable1) {}
      }
      catch (Throwable localThrowable2)
      {
        Object localObject2 = localObject4;
        localObject4 = localThrowable2;
        continue;
      }
      localObject4 = localFile;
    }
  }
  
  public static void a(Context paramContext)
  {
    H = paramContext.getApplicationContext();
    j.run();
  }
  
  public static void a(String paramString1, int paramInt, String paramString2)
  {
    a(paramString1, paramInt, paramString2, null);
  }
  
  public static void a(String paramString1, int paramInt, String paramString2, Throwable paramThrowable)
  {
    if ((t >= paramInt) || (q.contains(paramString1)))
    {
      if (paramThrowable != null) {
        break label67;
      }
      Log.e(paramString1, "[" + a(paramInt) + "]" + paramString2);
    }
    for (;;)
    {
      e(paramString1, paramInt, paramString2, paramThrowable);
      return;
      label67:
      Log.e(paramString1, "[" + a(paramInt) + "]" + paramString2, paramThrowable);
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    Log.d("MSF.D.QLogImpl", "[s]" + paramString2);
  }
  
  private static void a(Calendar paramCalendar)
  {
    paramCalendar.add(11, 1);
    paramCalendar.set(12, 0);
    paramCalendar.set(13, 0);
    v = paramCalendar.getTimeInMillis();
  }
  
  public static void a(boolean paramBoolean)
  {
    c = paramBoolean;
    j.run();
  }
  
  public static void a(String[] paramArrayOfString)
  {
    r = System.currentTimeMillis();
    int i2 = paramArrayOfString.length;
    int i1 = 0;
    while (i1 < i2)
    {
      String str = paramArrayOfString[i1];
      q.add(str);
      i1 += 1;
    }
  }
  
  public static void a(String[] paramArrayOfString, int paramInt, boolean paramBoolean, String paramString)
  {
    int i2 = paramArrayOfString.length;
    int i1 = 0;
    while (i1 < i2)
    {
      String str = paramArrayOfString[i1];
      q.remove(str);
      i1 += 1;
    }
    if (paramBoolean) {
      a(paramInt, "mobileqq", paramString);
    }
  }
  
  public static String b()
  {
    return u;
  }
  
  private static String b(long paramLong)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong);
    Object localObject = new SimpleDateFormat("yy.MM.dd.HH");
    I = new SimpleDateFormat("yy-MM-dd HH:mm:ss").format(Long.valueOf(paramLong));
    localObject = ((SimpleDateFormat)localObject).format(localCalendar.getTime());
    b(localCalendar);
    a(localCalendar);
    return localObject;
  }
  
  public static void b(int paramInt)
  {
    t = paramInt;
    QLog.d("MSF.D.QLogImpl", 1, "set UIN_REPORTLOG_LEVEL " + d());
  }
  
  public static void b(String paramString1, int paramInt, String paramString2)
  {
    b(paramString1, paramInt, paramString2, null);
  }
  
  public static void b(String paramString1, int paramInt, String paramString2, Throwable paramThrowable)
  {
    if ((t >= paramInt) || (q.contains(paramString1)))
    {
      if (paramThrowable != null) {
        break label67;
      }
      Log.w(paramString1, "[" + a(paramInt) + "]" + paramString2);
    }
    for (;;)
    {
      e(paramString1, paramInt, paramString2, paramThrowable);
      return;
      label67:
      Log.w(paramString1, "[" + a(paramInt) + "]" + paramString2, paramThrowable);
    }
  }
  
  private static void b(Calendar paramCalendar)
  {
    paramCalendar.set(14, 0);
    w = paramCalendar.getTimeInMillis() + 1000L;
  }
  
  public static SimpleDateFormat c()
  {
    return new SimpleDateFormat("yy.MM.dd.HH");
  }
  
  /* Error */
  private static void c(long paramLong)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: lload_0
    //   4: getstatic 491	com/tencent/mobileqq/msf/sdk/n:w	J
    //   7: lcmp
    //   8: ifle +34 -> 42
    //   11: getstatic 92	com/tencent/mobileqq/msf/sdk/n:d	Ljava/lang/Object;
    //   14: astore_2
    //   15: aload_2
    //   16: monitorenter
    //   17: getstatic 501	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:timeFormatter	Ljava/text/SimpleDateFormat;
    //   20: lload_0
    //   21: invokestatic 458	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   24: invokevirtual 462	java/text/SimpleDateFormat:format	(Ljava/lang/Object;)Ljava/lang/String;
    //   27: putstatic 150	com/tencent/mobileqq/msf/sdk/n:I	Ljava/lang/String;
    //   30: getstatic 491	com/tencent/mobileqq/msf/sdk/n:w	J
    //   33: ldc2_w 488
    //   36: ladd
    //   37: putstatic 491	com/tencent/mobileqq/msf/sdk/n:w	J
    //   40: aload_2
    //   41: monitorexit
    //   42: ldc 2
    //   44: monitorexit
    //   45: return
    //   46: astore_3
    //   47: aload_2
    //   48: monitorexit
    //   49: aload_3
    //   50: athrow
    //   51: astore_2
    //   52: ldc 2
    //   54: monitorexit
    //   55: aload_2
    //   56: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	paramLong	long
    //   51	5	2	localObject2	Object
    //   46	4	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   17	42	46	finally
    //   47	49	46	finally
    //   3	17	51	finally
    //   49	51	51	finally
  }
  
  public static void c(String paramString1, int paramInt, String paramString2)
  {
    c(paramString1, paramInt, paramString2, null);
  }
  
  public static void c(String paramString1, int paramInt, String paramString2, Throwable paramThrowable)
  {
    if ((t >= paramInt) || (q.contains(paramString1)))
    {
      if (paramThrowable != null) {
        break label67;
      }
      Log.i(paramString1, "[" + a(paramInt) + "]" + paramString2);
    }
    for (;;)
    {
      e(paramString1, paramInt, paramString2, paramThrowable);
      return;
      label67:
      Log.i(paramString1, "[" + a(paramInt) + "]" + paramString2, paramThrowable);
    }
  }
  
  public static int d()
  {
    return t;
  }
  
  public static void d(String paramString1, int paramInt, String paramString2)
  {
    d(paramString1, paramInt, paramString2, null);
  }
  
  public static void d(String paramString1, int paramInt, String paramString2, Throwable paramThrowable)
  {
    if ((t >= paramInt) || (q.contains(paramString1)))
    {
      if (paramThrowable != null) {
        break label67;
      }
      Log.d(paramString1, "[" + a(paramInt) + "]" + paramString2);
    }
    for (;;)
    {
      e(paramString1, paramInt, paramString2, paramThrowable);
      return;
      label67:
      Log.d(paramString1, "[" + a(paramInt) + "]" + paramString2, paramThrowable);
    }
  }
  
  public static String e()
  {
    return x;
  }
  
  private static void e(String paramString1, int paramInt, String paramString2, Throwable paramThrowable)
  {
    if (!c) {}
    do
    {
      return;
      long l1 = System.currentTimeMillis();
      if (l1 >= w) {
        c(l1);
      }
      if ((r != 0L) && (l1 - r > 1800000L))
      {
        r = 0L;
        q.clear();
      }
      String str = a(paramInt);
      l1 = Thread.currentThread().getId();
      paramString2 = I + "|" + x + "[" + B + "]|" + String.valueOf(l1) + "|" + str + "|" + paramString1 + "|" + paramString2 + "\n";
      paramString1 = paramString2;
      if (paramThrowable != null) {
        paramString1 = paramString2 + "\n" + Log.getStackTraceString(paramThrowable) + "\n";
      }
      if (!f(paramString1))
      {
        Log.d("QLogImpl", "addLogToCache failed!");
        return;
      }
    } while ((BaseApplication.getContext() == null) || (System.currentTimeMillis() - C <= 180000L));
    C = System.currentTimeMillis();
    p();
  }
  
  public static boolean f()
  {
    return t > 1;
  }
  
  private static boolean f(String paramString)
  {
    try
    {
      h.add(paramString);
      return true;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  public static boolean g()
  {
    return t >= 4;
  }
  
  private static boolean g(String paramString)
  {
    try
    {
      h.a(paramString);
      return true;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  private static void h(String paramString)
  {
    try
    {
      if (!c) {
        return;
      }
      if (!"mounted".equals(Environment.getExternalStorageState())) {
        return;
      }
      if (z != null) {
        break label132;
      }
      System.out.println("can not write log.");
      l1 = System.currentTimeMillis();
      if (l != 0L) {
        break label97;
      }
      l = l1;
    }
    catch (Throwable paramString)
    {
      long l1;
      while (((paramString instanceof IOException)) && (paramString.getMessage().contains("ENOSPC")))
      {
        if (!D.compareAndSet(false, true)) {
          return;
        }
        paramString.printStackTrace();
        return;
        label97:
        long l2 = l;
        if (l1 - l2 > 60000L)
        {
          try
          {
            a(System.currentTimeMillis());
            l = l1;
          }
          catch (IOException paramString)
          {
            for (;;)
            {
              paramString.printStackTrace();
            }
          }
          label132:
          l1 = System.currentTimeMillis();
          if (l1 > v) {
            a(l1);
          }
          boolean bool = i.tryLock();
          if (bool) {}
          try
          {
            z.write(paramString);
            z.flush();
            i.unlock();
          }
          finally
          {
            i.unlock();
          }
          Log.d("QLogImpl", "insertLogToCacheHead failed!");
        }
      }
      D.compareAndSet(true, false);
      paramString.printStackTrace();
      try
      {
        a(System.currentTimeMillis());
        return;
      }
      catch (Throwable paramString)
      {
        paramString.printStackTrace();
      }
    }
    D.compareAndSet(true, false);
    return;
  }
  
  private static void o()
    throws IOException
  {
    if ((z != null) && (!"".equals(QLog.sBuildNumber)))
    {
      z.write(I + "|" + x + "|D|" + "|QQ_Version: " + QLog.sBuildNumber + "\r\n");
      z.flush();
    }
  }
  
  private static void p()
  {
    try
    {
      ActivityManager localActivityManager = (ActivityManager)BaseApplication.getContext().getSystemService("activity");
      ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
      localActivityManager.getMemoryInfo(localMemoryInfo);
      if (QLog.isColorLevel()) {
        d("appMemory", 2, "availMem:" + localMemoryInfo.availMem / 1024L / 1024L + "M" + " lowThreshold:" + localMemoryInfo.threshold / 1024L / 1024L + "M");
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      d("appMemory", 2, "printMemError " + localException, localException);
    }
  }
  
  protected static class a
  {
    String a;
    String b;
    String c;
    Throwable d;
    
    public a(String paramString1, String paramString2, String paramString3, Throwable paramThrowable)
    {
      this.a = paramString1;
      this.b = paramString2;
      this.c = paramString3;
      this.d = paramThrowable;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.n
 * JD-Core Version:    0.7.0.1
 */