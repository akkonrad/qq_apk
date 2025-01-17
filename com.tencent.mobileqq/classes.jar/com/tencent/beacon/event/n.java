package com.tencent.beacon.event;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.SensorManager;
import android.location.LocationManager;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.beacon.a.f;
import com.tencent.beacon.d.a;
import com.tencent.beacon.d.c;
import java.io.File;
import java.io.FileFilter;
import java.util.List;
import java.util.regex.Pattern;

public final class n
{
  private static n a = null;
  private byte[] b = { 57, -16, 34, -64, -79, -74, 14, -78, 99, -60, -123, -111, -19, -95, -113, 96, -7, -35, -112, -117, 91, 86, 10, 68 };
  private String c;
  private String d;
  private String e;
  private String f;
  private String g;
  private String h;
  private String i;
  private String j;
  private String k;
  private String l;
  private String m;
  private String n;
  private String o;
  private String p;
  private String q;
  private String r;
  private String s;
  
  private n(Context paramContext)
  {
    Object localObject = this.b;
    localObject = this.b;
    this.c = "";
    this.d = "";
    this.e = "";
    this.f = "";
    this.g = "";
    this.h = "";
    this.i = "";
    this.j = "";
    this.k = "";
    this.l = "";
    this.m = "";
    this.n = "";
    this.o = "";
    this.p = "";
    this.q = "";
    this.r = "";
    this.s = "";
    if (paramContext == null) {
      a.d(" UADeviceInfo context == null? pls check!", new Object[0]);
    }
    a.b(" start to create UADeviceInfo", new Object[0]);
    long l1 = System.currentTimeMillis();
    f.a(paramContext);
    this.c = f.b();
    new StringBuilder().append(f.c()).toString();
    localObject = f.h(paramContext);
    if (localObject == null)
    {
      localObject = "";
      this.d = ((String)localObject);
      this.e = f.e();
      this.f = "";
      this.g = (f.f() + "m");
      this.h = (f.g() + "m");
      this.i = f.i();
      this.j = f.j();
      this.k = f.j(paramContext);
      this.l = f.k();
      this.m = c(paramContext);
      this.n = (t() + "m");
      this.o = v();
      this.p = s();
      if (!u()) {
        break label701;
      }
      localObject = "Y";
      label606:
      this.q = ((String)localObject);
      this.r = d(paramContext);
      if (!c.a().b()) {
        break label708;
      }
    }
    label701:
    label708:
    for (paramContext = "Y";; paramContext = "N")
    {
      this.s = paramContext;
      a.b(" detail create cost： %d  values:\n %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l1), toString() });
      return;
      localObject = ((DisplayMetrics)localObject).widthPixels + "*" + ((DisplayMetrics)localObject).heightPixels;
      break;
      localObject = "N";
      break label606;
    }
  }
  
  public static n a()
  {
    try
    {
      n localn = a;
      return localn;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static n a(Context paramContext)
  {
    try
    {
      if ((a == null) && (paramContext != null)) {
        a = new n(paramContext);
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  public static String b(Context paramContext)
  {
    paramContext = (LocationManager)paramContext.getSystemService("location");
    if (paramContext == null) {
      return "N";
    }
    paramContext = paramContext.getAllProviders();
    if (paramContext == null) {
      return "N";
    }
    if (paramContext.contains("gps")) {
      return "Y";
    }
    return "N";
  }
  
  private static int c(Context paramContext)
  {
    if (paramContext == null) {
      return 160;
    }
    for (;;)
    {
      try
      {
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
        if (localDisplayMetrics.density == 1.0F) {
          break;
        }
        if (localDisplayMetrics.density <= 0.75D) {
          return 120;
        }
        if (localDisplayMetrics.density == 1.5D) {
          return 240;
        }
        if (localDisplayMetrics.density == 2.0D) {
          return 320;
        }
        float f1 = localDisplayMetrics.density;
        if (f1 == 3.0D)
        {
          i1 = 480;
          return i1;
        }
      }
      catch (Throwable paramContext)
      {
        a.a(paramContext);
        return 160;
      }
      int i1 = 160;
    }
  }
  
  private static String d(Context paramContext)
  {
    if (paramContext == null)
    {
      a.d("getSensor2 but context == null!", new Object[0]);
      return null;
    }
    a.a("getSensor2 start", new Object[0]);
    Object localObject1 = "X";
    Object localObject2 = "X";
    Object localObject3 = "X";
    int i1;
    String str;
    label62:
    Object localObject4;
    Object localObject6;
    Object localObject5;
    if ((WifiManager)paramContext.getSystemService("wifi") == null)
    {
      i1 = 0;
      if (i1 == 0) {
        break label235;
      }
      str = "Y";
      if (Integer.parseInt(Build.VERSION.SDK) < 10) {
        break label292;
      }
      localObject4 = localObject3;
      localObject6 = localObject2;
      localObject5 = localObject1;
    }
    for (;;)
    {
      try
      {
        SensorManager localSensorManager = (SensorManager)paramContext.getSystemService("sensor");
        localObject4 = localObject3;
        localObject6 = localObject2;
        localObject5 = localObject1;
        if (localSensorManager.getDefaultSensor(1) == null) {
          continue;
        }
        localObject1 = "Y";
        localObject4 = localObject3;
        localObject6 = localObject2;
        localObject5 = localObject1;
        if (localSensorManager.getDefaultSensor(5) == null) {
          break label312;
        }
        localObject2 = "Y";
        localObject4 = localObject3;
        localObject6 = localObject2;
        localObject5 = localObject1;
        if (BluetoothAdapter.getDefaultAdapter() != null) {
          break label318;
        }
        localObject3 = "N";
        localObject4 = localObject3;
        localObject6 = localObject2;
        localObject5 = localObject1;
        if (!paramContext.getPackageManager().hasSystemFeature("android.hardware.nfc")) {
          continue;
        }
        localObject4 = "Y";
        paramContext = (Context)localObject3;
        localObject3 = localObject1;
        localObject1 = paramContext;
        paramContext = (Context)localObject4;
      }
      catch (Throwable paramContext)
      {
        label235:
        localObject2 = localObject6;
        localObject3 = localObject5;
        a.d("getSensor2 error!", new Object[0]);
        localObject1 = localObject4;
        paramContext = "X";
        continue;
      }
      return str + (String)localObject3 + (String)localObject2 + (String)localObject1 + paramContext;
      i1 = 1;
      break;
      str = "N";
      break label62;
      localObject1 = "N";
      continue;
      paramContext = "N";
      localObject4 = localObject1;
      localObject1 = localObject3;
      localObject3 = localObject4;
      continue;
      label292:
      paramContext = "X";
      localObject1 = "X";
      localObject2 = "X";
      localObject3 = "X";
      continue;
      label312:
      localObject2 = "N";
      continue;
      label318:
      localObject3 = "Y";
    }
  }
  
  /* Error */
  private static String s()
  {
    // Byte code:
    //   0: ldc 65
    //   2: astore_2
    //   3: new 320	java/io/BufferedReader
    //   6: dup
    //   7: new 322	java/io/InputStreamReader
    //   10: dup
    //   11: invokestatic 328	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   14: iconst_2
    //   15: anewarray 330	java/lang/String
    //   18: dup
    //   19: iconst_0
    //   20: ldc_w 332
    //   23: aastore
    //   24: dup
    //   25: iconst_1
    //   26: ldc_w 334
    //   29: aastore
    //   30: invokevirtual 338	java/lang/Runtime:exec	([Ljava/lang/String;)Ljava/lang/Process;
    //   33: invokevirtual 344	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   36: invokespecial 347	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   39: invokespecial 350	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   42: astore_1
    //   43: aload_1
    //   44: astore_0
    //   45: aload_1
    //   46: invokevirtual 353	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   49: astore_3
    //   50: aload_2
    //   51: astore_0
    //   52: aload_3
    //   53: ifnull +36 -> 89
    //   56: aload_1
    //   57: astore_0
    //   58: aload_3
    //   59: ldc_w 355
    //   62: invokevirtual 358	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   65: ifeq -22 -> 43
    //   68: aload_1
    //   69: astore_0
    //   70: aload_3
    //   71: aload_3
    //   72: ldc_w 360
    //   75: invokevirtual 363	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   78: iconst_1
    //   79: iadd
    //   80: invokevirtual 367	java/lang/String:substring	(I)Ljava/lang/String;
    //   83: invokevirtual 370	java/lang/String:trim	()Ljava/lang/String;
    //   86: astore_3
    //   87: aload_3
    //   88: astore_0
    //   89: aload_1
    //   90: invokevirtual 373	java/io/BufferedReader:close	()V
    //   93: aload_0
    //   94: areturn
    //   95: astore_1
    //   96: aload_1
    //   97: invokestatic 265	com/tencent/beacon/d/a:a	(Ljava/lang/Throwable;)V
    //   100: aload_0
    //   101: areturn
    //   102: astore_3
    //   103: aconst_null
    //   104: astore_1
    //   105: aload_1
    //   106: astore_0
    //   107: aload_3
    //   108: invokestatic 265	com/tencent/beacon/d/a:a	(Ljava/lang/Throwable;)V
    //   111: aload_2
    //   112: astore_0
    //   113: aload_1
    //   114: ifnull -21 -> 93
    //   117: aload_1
    //   118: invokevirtual 373	java/io/BufferedReader:close	()V
    //   121: ldc 65
    //   123: areturn
    //   124: astore_0
    //   125: aload_0
    //   126: invokestatic 265	com/tencent/beacon/d/a:a	(Ljava/lang/Throwable;)V
    //   129: ldc 65
    //   131: areturn
    //   132: astore_3
    //   133: aconst_null
    //   134: astore_1
    //   135: aload_1
    //   136: astore_0
    //   137: aload_3
    //   138: invokestatic 265	com/tencent/beacon/d/a:a	(Ljava/lang/Throwable;)V
    //   141: aload_2
    //   142: astore_0
    //   143: aload_1
    //   144: ifnull -51 -> 93
    //   147: aload_1
    //   148: invokevirtual 373	java/io/BufferedReader:close	()V
    //   151: ldc 65
    //   153: areturn
    //   154: astore_0
    //   155: aload_0
    //   156: invokestatic 265	com/tencent/beacon/d/a:a	(Ljava/lang/Throwable;)V
    //   159: ldc 65
    //   161: areturn
    //   162: astore_1
    //   163: aconst_null
    //   164: astore_0
    //   165: aload_0
    //   166: ifnull +7 -> 173
    //   169: aload_0
    //   170: invokevirtual 373	java/io/BufferedReader:close	()V
    //   173: aload_1
    //   174: athrow
    //   175: astore_0
    //   176: aload_0
    //   177: invokestatic 265	com/tencent/beacon/d/a:a	(Ljava/lang/Throwable;)V
    //   180: goto -7 -> 173
    //   183: astore_1
    //   184: goto -19 -> 165
    //   187: astore_3
    //   188: goto -53 -> 135
    //   191: astore_3
    //   192: goto -87 -> 105
    // Local variable table:
    //   start	length	slot	name	signature
    //   44	69	0	localObject1	Object
    //   124	2	0	localIOException1	java.io.IOException
    //   136	7	0	localObject2	Object
    //   154	2	0	localIOException2	java.io.IOException
    //   164	6	0	localObject3	Object
    //   175	2	0	localIOException3	java.io.IOException
    //   42	48	1	localBufferedReader	java.io.BufferedReader
    //   95	2	1	localIOException4	java.io.IOException
    //   104	44	1	localObject4	Object
    //   162	12	1	localObject5	Object
    //   183	1	1	localObject6	Object
    //   2	140	2	str1	String
    //   49	39	3	str2	String
    //   102	6	3	localIOException5	java.io.IOException
    //   132	6	3	localThrowable1	Throwable
    //   187	1	3	localThrowable2	Throwable
    //   191	1	3	localIOException6	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   89	93	95	java/io/IOException
    //   3	43	102	java/io/IOException
    //   117	121	124	java/io/IOException
    //   3	43	132	java/lang/Throwable
    //   147	151	154	java/io/IOException
    //   3	43	162	finally
    //   169	173	175	java/io/IOException
    //   45	50	183	finally
    //   58	68	183	finally
    //   70	87	183	finally
    //   107	111	183	finally
    //   137	141	183	finally
    //   45	50	187	java/lang/Throwable
    //   58	68	187	java/lang/Throwable
    //   70	87	187	java/lang/Throwable
    //   45	50	191	java/io/IOException
    //   58	68	191	java/io/IOException
    //   70	87	191	java/io/IOException
  }
  
  /* Error */
  private static int t()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: iconst_0
    //   3: istore_0
    //   4: aconst_null
    //   5: astore_3
    //   6: aconst_null
    //   7: astore 4
    //   9: new 320	java/io/BufferedReader
    //   12: dup
    //   13: new 322	java/io/InputStreamReader
    //   16: dup
    //   17: invokestatic 328	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   20: iconst_2
    //   21: anewarray 330	java/lang/String
    //   24: dup
    //   25: iconst_0
    //   26: ldc_w 332
    //   29: aastore
    //   30: dup
    //   31: iconst_1
    //   32: ldc_w 375
    //   35: aastore
    //   36: invokevirtual 338	java/lang/Runtime:exec	([Ljava/lang/String;)Ljava/lang/Process;
    //   39: invokevirtual 344	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   42: invokespecial 347	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   45: invokespecial 350	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   48: astore_2
    //   49: aload_2
    //   50: astore_3
    //   51: aload_2
    //   52: invokevirtual 353	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   55: astore 4
    //   57: aload 4
    //   59: ifnull +18 -> 77
    //   62: aload_2
    //   63: astore_3
    //   64: aload 4
    //   66: invokevirtual 370	java/lang/String:trim	()Ljava/lang/String;
    //   69: invokestatic 288	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   72: sipush 1000
    //   75: idiv
    //   76: istore_0
    //   77: aload_2
    //   78: invokevirtual 373	java/io/BufferedReader:close	()V
    //   81: iload_0
    //   82: ireturn
    //   83: astore_2
    //   84: aload_2
    //   85: invokestatic 265	com/tencent/beacon/d/a:a	(Ljava/lang/Throwable;)V
    //   88: iload_0
    //   89: ireturn
    //   90: astore 4
    //   92: aconst_null
    //   93: astore_2
    //   94: aload_2
    //   95: astore_3
    //   96: aload 4
    //   98: invokestatic 265	com/tencent/beacon/d/a:a	(Ljava/lang/Throwable;)V
    //   101: iload_1
    //   102: istore_0
    //   103: aload_2
    //   104: ifnull -23 -> 81
    //   107: aload_2
    //   108: invokevirtual 373	java/io/BufferedReader:close	()V
    //   111: iconst_0
    //   112: ireturn
    //   113: astore_2
    //   114: aload_2
    //   115: invokestatic 265	com/tencent/beacon/d/a:a	(Ljava/lang/Throwable;)V
    //   118: iconst_0
    //   119: ireturn
    //   120: astore_3
    //   121: aload 4
    //   123: astore_2
    //   124: aload_3
    //   125: astore 4
    //   127: aload_2
    //   128: astore_3
    //   129: aload 4
    //   131: invokestatic 265	com/tencent/beacon/d/a:a	(Ljava/lang/Throwable;)V
    //   134: iload_1
    //   135: istore_0
    //   136: aload_2
    //   137: ifnull -56 -> 81
    //   140: aload_2
    //   141: invokevirtual 373	java/io/BufferedReader:close	()V
    //   144: iconst_0
    //   145: ireturn
    //   146: astore_2
    //   147: aload_2
    //   148: invokestatic 265	com/tencent/beacon/d/a:a	(Ljava/lang/Throwable;)V
    //   151: iconst_0
    //   152: ireturn
    //   153: astore_2
    //   154: aload_3
    //   155: ifnull +7 -> 162
    //   158: aload_3
    //   159: invokevirtual 373	java/io/BufferedReader:close	()V
    //   162: aload_2
    //   163: athrow
    //   164: astore_3
    //   165: aload_3
    //   166: invokestatic 265	com/tencent/beacon/d/a:a	(Ljava/lang/Throwable;)V
    //   169: goto -7 -> 162
    //   172: astore_2
    //   173: goto -19 -> 154
    //   176: astore 4
    //   178: goto -51 -> 127
    //   181: astore 4
    //   183: goto -89 -> 94
    // Local variable table:
    //   start	length	slot	name	signature
    //   3	133	0	i1	int
    //   1	134	1	i2	int
    //   48	30	2	localBufferedReader	java.io.BufferedReader
    //   83	2	2	localIOException1	java.io.IOException
    //   93	15	2	localObject1	Object
    //   113	2	2	localIOException2	java.io.IOException
    //   123	18	2	localIOException3	java.io.IOException
    //   146	2	2	localIOException4	java.io.IOException
    //   153	10	2	localObject2	Object
    //   172	1	2	localObject3	Object
    //   5	91	3	localObject4	Object
    //   120	5	3	localThrowable1	Throwable
    //   128	31	3	localObject5	Object
    //   164	2	3	localIOException5	java.io.IOException
    //   7	58	4	str	String
    //   90	32	4	localIOException6	java.io.IOException
    //   125	5	4	localThrowable2	Throwable
    //   176	1	4	localThrowable3	Throwable
    //   181	1	4	localIOException7	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   77	81	83	java/io/IOException
    //   9	49	90	java/io/IOException
    //   107	111	113	java/io/IOException
    //   9	49	120	java/lang/Throwable
    //   140	144	146	java/io/IOException
    //   9	49	153	finally
    //   129	134	153	finally
    //   158	162	164	java/io/IOException
    //   51	57	172	finally
    //   64	77	172	finally
    //   96	101	172	finally
    //   51	57	176	java/lang/Throwable
    //   64	77	176	java/lang/Throwable
    //   51	57	181	java/io/IOException
    //   64	77	181	java/io/IOException
  }
  
  /* Error */
  private static boolean u()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: iconst_0
    //   3: istore_2
    //   4: aconst_null
    //   5: astore 5
    //   7: aconst_null
    //   8: astore 6
    //   10: new 320	java/io/BufferedReader
    //   13: dup
    //   14: new 322	java/io/InputStreamReader
    //   17: dup
    //   18: invokestatic 328	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   21: iconst_2
    //   22: anewarray 330	java/lang/String
    //   25: dup
    //   26: iconst_0
    //   27: ldc_w 332
    //   30: aastore
    //   31: dup
    //   32: iconst_1
    //   33: ldc_w 334
    //   36: aastore
    //   37: invokevirtual 338	java/lang/Runtime:exec	([Ljava/lang/String;)Ljava/lang/Process;
    //   40: invokevirtual 344	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   43: invokespecial 347	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   46: invokespecial 350	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   49: astore 4
    //   51: aload 4
    //   53: astore 5
    //   55: aload 4
    //   57: invokevirtual 353	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   60: astore 6
    //   62: iload_2
    //   63: istore_1
    //   64: aload 6
    //   66: ifnull +26 -> 92
    //   69: aload 4
    //   71: astore 5
    //   73: aload 6
    //   75: invokevirtual 378	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   78: ldc_w 380
    //   81: invokevirtual 363	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   84: istore_0
    //   85: iconst_m1
    //   86: iload_0
    //   87: if_icmpeq -36 -> 51
    //   90: iconst_1
    //   91: istore_1
    //   92: aload 4
    //   94: invokevirtual 373	java/io/BufferedReader:close	()V
    //   97: iload_1
    //   98: ireturn
    //   99: astore 4
    //   101: aload 4
    //   103: invokestatic 265	com/tencent/beacon/d/a:a	(Ljava/lang/Throwable;)V
    //   106: iload_1
    //   107: ireturn
    //   108: astore 6
    //   110: aconst_null
    //   111: astore 4
    //   113: aload 4
    //   115: astore 5
    //   117: aload 6
    //   119: invokestatic 265	com/tencent/beacon/d/a:a	(Ljava/lang/Throwable;)V
    //   122: iload_3
    //   123: istore_1
    //   124: aload 4
    //   126: ifnull -29 -> 97
    //   129: aload 4
    //   131: invokevirtual 373	java/io/BufferedReader:close	()V
    //   134: iconst_0
    //   135: ireturn
    //   136: astore 4
    //   138: aload 4
    //   140: invokestatic 265	com/tencent/beacon/d/a:a	(Ljava/lang/Throwable;)V
    //   143: iconst_0
    //   144: ireturn
    //   145: astore 5
    //   147: aload 6
    //   149: astore 4
    //   151: aload 5
    //   153: astore 6
    //   155: aload 4
    //   157: astore 5
    //   159: aload 6
    //   161: invokestatic 265	com/tencent/beacon/d/a:a	(Ljava/lang/Throwable;)V
    //   164: iload_3
    //   165: istore_1
    //   166: aload 4
    //   168: ifnull -71 -> 97
    //   171: aload 4
    //   173: invokevirtual 373	java/io/BufferedReader:close	()V
    //   176: iconst_0
    //   177: ireturn
    //   178: astore 4
    //   180: aload 4
    //   182: invokestatic 265	com/tencent/beacon/d/a:a	(Ljava/lang/Throwable;)V
    //   185: iconst_0
    //   186: ireturn
    //   187: astore 4
    //   189: aload 5
    //   191: ifnull +8 -> 199
    //   194: aload 5
    //   196: invokevirtual 373	java/io/BufferedReader:close	()V
    //   199: aload 4
    //   201: athrow
    //   202: astore 5
    //   204: aload 5
    //   206: invokestatic 265	com/tencent/beacon/d/a:a	(Ljava/lang/Throwable;)V
    //   209: goto -10 -> 199
    //   212: astore 4
    //   214: goto -25 -> 189
    //   217: astore 6
    //   219: goto -64 -> 155
    //   222: astore 6
    //   224: goto -111 -> 113
    // Local variable table:
    //   start	length	slot	name	signature
    //   84	4	0	i1	int
    //   63	103	1	bool1	boolean
    //   3	60	2	bool2	boolean
    //   1	164	3	bool3	boolean
    //   49	44	4	localBufferedReader	java.io.BufferedReader
    //   99	3	4	localIOException1	java.io.IOException
    //   111	19	4	localObject1	Object
    //   136	3	4	localIOException2	java.io.IOException
    //   149	23	4	localIOException3	java.io.IOException
    //   178	3	4	localIOException4	java.io.IOException
    //   187	13	4	localObject2	Object
    //   212	1	4	localObject3	Object
    //   5	111	5	localObject4	Object
    //   145	7	5	localThrowable1	Throwable
    //   157	38	5	localObject5	Object
    //   202	3	5	localIOException5	java.io.IOException
    //   8	66	6	str	String
    //   108	40	6	localIOException6	java.io.IOException
    //   153	7	6	localThrowable2	Throwable
    //   217	1	6	localThrowable3	Throwable
    //   222	1	6	localIOException7	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   92	97	99	java/io/IOException
    //   10	51	108	java/io/IOException
    //   129	134	136	java/io/IOException
    //   10	51	145	java/lang/Throwable
    //   171	176	178	java/io/IOException
    //   10	51	187	finally
    //   159	164	187	finally
    //   194	199	202	java/io/IOException
    //   55	62	212	finally
    //   73	85	212	finally
    //   117	122	212	finally
    //   55	62	217	java/lang/Throwable
    //   73	85	217	java/lang/Throwable
    //   55	62	222	java/io/IOException
    //   73	85	222	java/io/IOException
  }
  
  private static int v()
  {
    try
    {
      File[] arrayOfFile = new File("/sys/devices/system/cpu/").listFiles(new a());
      if (arrayOfFile == null) {
        return 1;
      }
      int i1 = arrayOfFile.length;
      return i1;
    }
    catch (Exception localException)
    {
      a.d("CPU Count: Failed.", new Object[0]);
      a.a(localException);
    }
    return 1;
  }
  
  public final String b()
  {
    try
    {
      String str = this.c;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final String c()
  {
    try
    {
      String str = this.d;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final String d()
  {
    try
    {
      String str = this.e;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final String e()
  {
    try
    {
      String str = this.f;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final String f()
  {
    try
    {
      String str = this.g;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final String g()
  {
    try
    {
      String str = this.h;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final String h()
  {
    try
    {
      String str = this.i;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final String i()
  {
    try
    {
      String str = this.j;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final String j()
  {
    try
    {
      String str = this.k;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final String k()
  {
    try
    {
      String str = this.l;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final String l()
  {
    return this.m;
  }
  
  public final String m()
  {
    return this.n;
  }
  
  public final String n()
  {
    return this.o;
  }
  
  public final String o()
  {
    return this.p;
  }
  
  public final String p()
  {
    return this.q;
  }
  
  public final String q()
  {
    return this.r;
  }
  
  public final String r()
  {
    return this.s;
  }
  
  final class a
    implements FileFilter
  {
    public final boolean accept(File paramFile)
    {
      return Pattern.matches("cpu[0-9]", paramFile.getName());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.event.n
 * JD-Core Version:    0.7.0.1
 */