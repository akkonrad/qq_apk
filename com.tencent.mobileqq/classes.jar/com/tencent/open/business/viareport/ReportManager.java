package com.tencent.open.business.viareport;

import alfw;
import alfx;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.APNUtil;
import com.tencent.open.base.LogUtility;
import com.tencent.open.business.base.MobileInfoUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TimeZone;

public class ReportManager
{
  protected static ReportManager a;
  protected String a;
  protected ArrayList a;
  public volatile boolean a;
  protected ArrayList b = new ArrayList();
  
  protected ReportManager()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public static ReportManager a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentOpenBusinessViareportReportManager == null) {
        jdField_a_of_type_ComTencentOpenBusinessViareportReportManager = new ReportManager();
      }
      ReportManager localReportManager = jdField_a_of_type_ComTencentOpenBusinessViareportReportManager;
      return localReportManager;
    }
    finally {}
  }
  
  protected String a()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_JavaLangString = "http://analy.qq.com/cgi-bin/mapp_apptrace";
    }
    return this.jdField_a_of_type_JavaLangString;
  }
  
  protected String a(ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramArrayList1 != null)
    {
      paramArrayList1 = paramArrayList1.iterator();
      while (paramArrayList1.hasNext())
      {
        BatchReportInfo localBatchReportInfo = (BatchReportInfo)paramArrayList1.next();
        localStringBuilder.append(localBatchReportInfo.jdField_a_of_type_JavaLangString + "_" + localBatchReportInfo.b + "_" + localBatchReportInfo.c + "_" + localBatchReportInfo.a() + "_" + localBatchReportInfo.g);
        if (!TextUtils.isEmpty(localBatchReportInfo.h)) {
          localStringBuilder.append("_" + localBatchReportInfo.h);
        }
        if (!TextUtils.isEmpty(localBatchReportInfo.i)) {
          localStringBuilder.append("_" + localBatchReportInfo.i);
        }
        if (!TextUtils.isEmpty(localBatchReportInfo.j)) {
          localStringBuilder.append("_" + localBatchReportInfo.j);
        }
        if (!TextUtils.isEmpty(localBatchReportInfo.k)) {
          localStringBuilder.append("_" + localBatchReportInfo.k);
        }
        if (!TextUtils.isEmpty(localBatchReportInfo.l)) {
          localStringBuilder.append("_" + localBatchReportInfo.l);
        }
        localStringBuilder.append(",");
      }
    }
    if (paramArrayList2 != null)
    {
      paramArrayList1 = paramArrayList2.iterator();
      while (paramArrayList1.hasNext())
      {
        paramArrayList2 = (BatchReportInfo)paramArrayList1.next();
        localStringBuilder.append(paramArrayList2.jdField_a_of_type_JavaLangString + "_" + paramArrayList2.b + "_" + paramArrayList2.c + "_" + paramArrayList2.a() + "_" + paramArrayList2.g);
        if (!TextUtils.isEmpty(paramArrayList2.h)) {
          localStringBuilder.append("_" + paramArrayList2.h);
        }
        if (!TextUtils.isEmpty(paramArrayList2.i)) {
          localStringBuilder.append("_" + paramArrayList2.i);
        }
        if (!TextUtils.isEmpty(paramArrayList2.j)) {
          localStringBuilder.append("_" + paramArrayList2.j);
        }
        if (!TextUtils.isEmpty(paramArrayList2.k)) {
          localStringBuilder.append("_" + paramArrayList2.k);
        }
        if (!TextUtils.isEmpty(paramArrayList2.l)) {
          localStringBuilder.append("_" + paramArrayList2.l);
        }
        localStringBuilder.append(",");
      }
    }
    paramArrayList2 = localStringBuilder.toString();
    paramArrayList1 = paramArrayList2;
    if (paramArrayList2.endsWith(",")) {
      paramArrayList1 = paramArrayList2.substring(0, paramArrayList2.length() - 1);
    }
    return paramArrayList1;
  }
  
  protected void a()
  {
    String str = String.valueOf(CommonDataAdapter.a().a());
    if (a(str)) {
      ThreadManager.executeOnNetWorkThread(new alfx(this, str));
    }
  }
  
  public void a(BatchReportInfo paramBatchReportInfo, Bundle paramBundle, boolean paramBoolean)
  {
    a(String.valueOf(CommonDataAdapter.a().a()), paramBatchReportInfo, paramBundle, paramBoolean);
  }
  
  public void a(String paramString, Bundle paramBundle, boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    if (paramBoolean)
    {
      if (!a(paramString, localBundle))
      {
        LogUtility.b("viareport", "database empty");
        return;
      }
      this.jdField_a_of_type_Boolean = true;
    }
    localBundle.putString("uin", paramString);
    localBundle.putString("platform", CommonDataAdapter.a().g());
    localBundle.putString("action", "100");
    localBundle.putString("imei", MobileInfoUtil.c());
    localBundle.putString("resolution", MobileInfoUtil.e());
    localBundle.putString("network", APNUtil.a(CommonDataAdapter.a().a()));
    localBundle.putString("wifimac", MobileInfoUtil.a());
    localBundle.putString("mobile_pf", "1");
    localBundle.putString("os_ver", Build.VERSION.RELEASE);
    localBundle.putString("lang", MobileInfoUtil.b());
    localBundle.putString("device", Build.DEVICE);
    localBundle.putString("model_name", Build.MODEL);
    localBundle.putString("sdk_ver", "1.5");
    localBundle.putString("timezone", TimeZone.getDefault().getID());
    localBundle.putString("city", MobileInfoUtil.g());
    localBundle.putString("longitude", MobileInfoUtil.f());
    localBundle.putString("ret_code", "0");
    localBundle.putString("qua", CommonDataAdapter.a().f());
    localBundle.putString("qz_ver", CommonDataAdapter.a().c());
    localBundle.putString("ext", CommonDataAdapter.a().h());
    if (paramBundle != null) {
      localBundle.putAll(paramBundle);
    }
    if (paramBoolean) {}
    for (paramString = "POST";; paramString = "GET")
    {
      a(a(), paramString, localBundle, paramBoolean);
      return;
    }
  }
  
  public void a(String paramString, BatchReportInfo paramBatchReportInfo, Bundle paramBundle, boolean paramBoolean)
  {
    ThreadManager.executeOnNetWorkThread(new alfw(this, paramBoolean, paramBatchReportInfo, paramBundle, paramString));
  }
  
  /* Error */
  protected void a(String paramString1, String paramString2, Bundle paramBundle, boolean paramBoolean)
  {
    // Byte code:
    //   0: invokestatic 293	com/tencent/open/business/viareport/ReportConfig:b	()I
    //   3: istore 8
    //   5: ldc 148
    //   7: new 42	java/lang/StringBuilder
    //   10: dup
    //   11: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   14: ldc_w 295
    //   17: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: iload 8
    //   22: invokevirtual 298	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   25: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: invokestatic 155	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   31: iconst_0
    //   32: istore 6
    //   34: iconst_0
    //   35: istore 5
    //   37: invokestatic 303	android/os/SystemClock:elapsedRealtime	()J
    //   40: lstore 15
    //   42: lconst_0
    //   43: lstore 11
    //   45: lconst_0
    //   46: lstore 17
    //   48: iconst_0
    //   49: istore 9
    //   51: iload 6
    //   53: iconst_1
    //   54: iadd
    //   55: istore 7
    //   57: lload 11
    //   59: lstore 19
    //   61: aload_1
    //   62: aload_2
    //   63: aload_3
    //   64: invokestatic 308	com/tencent/open/base/http/HttpBaseUtil:a	(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)Lcom/tencent/open/base/http/HttpBaseUtil$Statistic;
    //   67: astore 23
    //   69: lload 11
    //   71: lstore 19
    //   73: aload 23
    //   75: getfield 311	com/tencent/open/base/http/HttpBaseUtil$Statistic:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   78: invokestatic 314	com/tencent/open/base/http/HttpBaseUtil:a	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   81: astore 24
    //   83: lload 11
    //   85: lstore 19
    //   87: aload 24
    //   89: ldc_w 316
    //   92: invokevirtual 322	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   95: istore 6
    //   97: iload 6
    //   99: ifeq +22 -> 121
    //   102: lload 11
    //   104: lstore 19
    //   106: aload 23
    //   108: getfield 311	com/tencent/open/base/http/HttpBaseUtil$Statistic:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   111: invokestatic 37	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   114: istore 10
    //   116: iload 10
    //   118: ifne +954 -> 1072
    //   121: iconst_1
    //   122: istore 6
    //   124: iload 8
    //   126: istore 5
    //   128: lload 11
    //   130: lstore 19
    //   132: lload 11
    //   134: lstore 13
    //   136: aload 23
    //   138: getfield 325	com/tencent/open/base/http/HttpBaseUtil$Statistic:jdField_a_of_type_Long	J
    //   141: lstore 11
    //   143: lload 11
    //   145: lstore 19
    //   147: lload 11
    //   149: lstore 13
    //   151: aload 23
    //   153: getfield 327	com/tencent/open/base/http/HttpBaseUtil$Statistic:b	J
    //   156: lstore 21
    //   158: iload 9
    //   160: istore 7
    //   162: lload 21
    //   164: lstore 13
    //   166: iload 5
    //   168: iload 8
    //   170: if_icmplt +879 -> 1049
    //   173: ldc 148
    //   175: new 42	java/lang/StringBuilder
    //   178: dup
    //   179: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   182: ldc_w 329
    //   185: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: lload 15
    //   190: invokevirtual 332	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   193: ldc_w 334
    //   196: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: lload 11
    //   201: invokevirtual 332	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   204: ldc_w 334
    //   207: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: lload 13
    //   212: invokevirtual 332	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   215: ldc_w 334
    //   218: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: iload 7
    //   223: invokevirtual 298	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   226: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   229: invokestatic 336	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   232: aload_0
    //   233: iload 7
    //   235: invokevirtual 339	com/tencent/open/business/viareport/ReportManager:a	(I)Z
    //   238: ifeq +30 -> 268
    //   241: invokestatic 344	com/tencent/open/business/cgireport/ReportManager:a	()Lcom/tencent/open/business/cgireport/ReportManager;
    //   244: ldc_w 346
    //   247: lload 15
    //   249: lload 11
    //   251: lload 13
    //   253: iload 7
    //   255: invokestatic 115	com/tencent/open/adapter/CommonDataAdapter:a	()Lcom/tencent/open/adapter/CommonDataAdapter;
    //   258: invokevirtual 118	com/tencent/open/adapter/CommonDataAdapter:a	()J
    //   261: ldc_w 348
    //   264: aconst_null
    //   265: invokevirtual 351	com/tencent/open/business/cgireport/ReportManager:a	(Ljava/lang/String;JJJIJLjava/lang/String;Ljava/lang/String;)V
    //   268: iload 6
    //   270: iconst_1
    //   271: if_icmpne +710 -> 981
    //   274: ldc_w 353
    //   277: ldc_w 355
    //   280: invokestatic 155	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   283: iload 4
    //   285: ifeq +25 -> 310
    //   288: ldc 148
    //   290: ldc_w 357
    //   293: invokestatic 155	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   296: aload_0
    //   297: iconst_0
    //   298: putfield 157	com/tencent/open/business/viareport/ReportManager:jdField_a_of_type_Boolean	Z
    //   301: iload 6
    //   303: ifeq +7 -> 310
    //   306: aload_0
    //   307: invokevirtual 359	com/tencent/open/business/viareport/ReportManager:a	()V
    //   310: return
    //   311: astore 24
    //   313: bipush 252
    //   315: istore 6
    //   317: goto -220 -> 97
    //   320: astore 23
    //   322: iload 5
    //   324: istore 6
    //   326: iload 7
    //   328: istore 5
    //   330: invokestatic 303	android/os/SystemClock:elapsedRealtime	()J
    //   333: lstore 15
    //   335: lconst_0
    //   336: lstore 11
    //   338: lconst_0
    //   339: lstore 13
    //   341: bipush 249
    //   343: istore 7
    //   345: ldc 148
    //   347: new 42	java/lang/StringBuilder
    //   350: dup
    //   351: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   354: ldc_w 361
    //   357: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   360: aload 23
    //   362: invokevirtual 362	org/apache/http/conn/ConnectTimeoutException:toString	()Ljava/lang/String;
    //   365: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   368: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   371: invokestatic 364	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   374: goto -208 -> 166
    //   377: astore 23
    //   379: iload 5
    //   381: istore 6
    //   383: iload 7
    //   385: istore 5
    //   387: invokestatic 303	android/os/SystemClock:elapsedRealtime	()J
    //   390: lstore 15
    //   392: lconst_0
    //   393: lstore 11
    //   395: lconst_0
    //   396: lstore 13
    //   398: bipush 248
    //   400: istore 7
    //   402: ldc 148
    //   404: new 42	java/lang/StringBuilder
    //   407: dup
    //   408: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   411: ldc_w 361
    //   414: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   417: aload 23
    //   419: invokevirtual 365	java/net/SocketTimeoutException:toString	()Ljava/lang/String;
    //   422: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   425: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   428: invokestatic 364	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   431: goto -265 -> 166
    //   434: astore 23
    //   436: iload 5
    //   438: istore 6
    //   440: iload 7
    //   442: istore 5
    //   444: lconst_0
    //   445: lstore 11
    //   447: lconst_0
    //   448: lstore 13
    //   450: bipush 252
    //   452: istore 7
    //   454: ldc 148
    //   456: new 42	java/lang/StringBuilder
    //   459: dup
    //   460: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   463: ldc_w 361
    //   466: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   469: aload 23
    //   471: invokevirtual 366	org/json/JSONException:toString	()Ljava/lang/String;
    //   474: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   477: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   480: invokestatic 364	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   483: goto -317 -> 166
    //   486: astore_1
    //   487: ldc 148
    //   489: new 42	java/lang/StringBuilder
    //   492: dup
    //   493: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   496: ldc_w 361
    //   499: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   502: aload_1
    //   503: invokevirtual 367	com/tencent/open/base/http/HttpBaseUtil$NetworkUnavailableException:toString	()Ljava/lang/String;
    //   506: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   509: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   512: invokestatic 364	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   515: aload_0
    //   516: iconst_0
    //   517: putfield 157	com/tencent/open/business/viareport/ReportManager:jdField_a_of_type_Boolean	Z
    //   520: return
    //   521: astore_1
    //   522: aload_1
    //   523: invokevirtual 370	com/tencent/open/base/http/HttpBaseUtil$HttpStatusException:getMessage	()Ljava/lang/String;
    //   526: ldc_w 372
    //   529: ldc 16
    //   531: invokevirtual 376	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   534: invokestatic 381	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   537: istore 5
    //   539: aload_0
    //   540: iload 5
    //   542: invokevirtual 339	com/tencent/open/business/viareport/ReportManager:a	(I)Z
    //   545: ifeq +30 -> 575
    //   548: invokestatic 344	com/tencent/open/business/cgireport/ReportManager:a	()Lcom/tencent/open/business/cgireport/ReportManager;
    //   551: ldc_w 346
    //   554: lload 15
    //   556: lload 19
    //   558: lload 17
    //   560: iload 5
    //   562: invokestatic 115	com/tencent/open/adapter/CommonDataAdapter:a	()Lcom/tencent/open/adapter/CommonDataAdapter;
    //   565: invokevirtual 118	com/tencent/open/adapter/CommonDataAdapter:a	()J
    //   568: ldc_w 348
    //   571: aconst_null
    //   572: invokevirtual 351	com/tencent/open/business/cgireport/ReportManager:a	(Ljava/lang/String;JJJIJLjava/lang/String;Ljava/lang/String;)V
    //   575: ldc 148
    //   577: new 42	java/lang/StringBuilder
    //   580: dup
    //   581: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   584: ldc_w 361
    //   587: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   590: aload_1
    //   591: invokevirtual 382	com/tencent/open/base/http/HttpBaseUtil$HttpStatusException:toString	()Ljava/lang/String;
    //   594: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   597: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   600: invokestatic 364	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   603: aload_0
    //   604: iconst_0
    //   605: putfield 157	com/tencent/open/business/viareport/ReportManager:jdField_a_of_type_Boolean	Z
    //   608: return
    //   609: astore_2
    //   610: ldc 148
    //   612: new 42	java/lang/StringBuilder
    //   615: dup
    //   616: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   619: ldc_w 361
    //   622: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   625: aload_1
    //   626: invokevirtual 382	com/tencent/open/base/http/HttpBaseUtil$HttpStatusException:toString	()Ljava/lang/String;
    //   629: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   632: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   635: invokestatic 364	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   638: goto -63 -> 575
    //   641: astore 23
    //   643: iload 5
    //   645: istore 6
    //   647: iload 7
    //   649: istore 5
    //   651: lconst_0
    //   652: lstore 11
    //   654: lconst_0
    //   655: lstore 13
    //   657: aload 23
    //   659: invokestatic 387	com/tencent/open/base/http/HttpCgiAsyncTask:a	(Ljava/io/IOException;)I
    //   662: istore 7
    //   664: ldc 148
    //   666: new 42	java/lang/StringBuilder
    //   669: dup
    //   670: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   673: ldc_w 361
    //   676: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   679: aload 23
    //   681: invokevirtual 388	java/io/IOException:toString	()Ljava/lang/String;
    //   684: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   687: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   690: invokestatic 364	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   693: goto -527 -> 166
    //   696: astore 23
    //   698: iload 5
    //   700: istore 6
    //   702: iload 7
    //   704: istore 5
    //   706: aload 23
    //   708: instanceof 283
    //   711: ifeq +38 -> 749
    //   714: ldc 148
    //   716: new 42	java/lang/StringBuilder
    //   719: dup
    //   720: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   723: ldc_w 361
    //   726: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   729: aload 23
    //   731: invokevirtual 389	java/lang/Exception:toString	()Ljava/lang/String;
    //   734: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   737: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   740: invokestatic 364	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   743: aload_0
    //   744: iconst_0
    //   745: putfield 157	com/tencent/open/business/viareport/ReportManager:jdField_a_of_type_Boolean	Z
    //   748: return
    //   749: aload 23
    //   751: instanceof 285
    //   754: ifeq +125 -> 879
    //   757: aload 23
    //   759: invokevirtual 390	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   762: ldc_w 372
    //   765: ldc 16
    //   767: invokevirtual 376	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   770: invokestatic 381	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   773: istore 5
    //   775: aload_0
    //   776: iload 5
    //   778: invokevirtual 339	com/tencent/open/business/viareport/ReportManager:a	(I)Z
    //   781: ifeq +30 -> 811
    //   784: invokestatic 344	com/tencent/open/business/cgireport/ReportManager:a	()Lcom/tencent/open/business/cgireport/ReportManager;
    //   787: ldc_w 346
    //   790: lload 15
    //   792: lload 11
    //   794: lload 17
    //   796: iload 5
    //   798: invokestatic 115	com/tencent/open/adapter/CommonDataAdapter:a	()Lcom/tencent/open/adapter/CommonDataAdapter;
    //   801: invokevirtual 118	com/tencent/open/adapter/CommonDataAdapter:a	()J
    //   804: ldc_w 348
    //   807: aconst_null
    //   808: invokevirtual 351	com/tencent/open/business/cgireport/ReportManager:a	(Ljava/lang/String;JJJIJLjava/lang/String;Ljava/lang/String;)V
    //   811: ldc 148
    //   813: new 42	java/lang/StringBuilder
    //   816: dup
    //   817: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   820: ldc_w 361
    //   823: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   826: aload 23
    //   828: invokevirtual 389	java/lang/Exception:toString	()Ljava/lang/String;
    //   831: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   834: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   837: invokestatic 364	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   840: aload_0
    //   841: iconst_0
    //   842: putfield 157	com/tencent/open/business/viareport/ReportManager:jdField_a_of_type_Boolean	Z
    //   845: return
    //   846: astore_1
    //   847: ldc 148
    //   849: new 42	java/lang/StringBuilder
    //   852: dup
    //   853: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   856: ldc_w 361
    //   859: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   862: aload 23
    //   864: invokevirtual 389	java/lang/Exception:toString	()Ljava/lang/String;
    //   867: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   870: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   873: invokestatic 364	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   876: goto -65 -> 811
    //   879: aload 23
    //   881: instanceof 287
    //   884: ifeq +51 -> 935
    //   887: lconst_0
    //   888: lstore 11
    //   890: lconst_0
    //   891: lstore 13
    //   893: aload 23
    //   895: checkcast 287	java/io/IOException
    //   898: invokestatic 387	com/tencent/open/base/http/HttpCgiAsyncTask:a	(Ljava/io/IOException;)I
    //   901: istore 7
    //   903: ldc 148
    //   905: new 42	java/lang/StringBuilder
    //   908: dup
    //   909: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   912: ldc_w 361
    //   915: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   918: aload 23
    //   920: invokevirtual 389	java/lang/Exception:toString	()Ljava/lang/String;
    //   923: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   926: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   929: invokestatic 364	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   932: goto -766 -> 166
    //   935: lconst_0
    //   936: lstore 11
    //   938: lconst_0
    //   939: lstore 13
    //   941: bipush 250
    //   943: istore 7
    //   945: ldc 148
    //   947: new 42	java/lang/StringBuilder
    //   950: dup
    //   951: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   954: ldc_w 361
    //   957: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   960: aload 23
    //   962: invokevirtual 389	java/lang/Exception:toString	()Ljava/lang/String;
    //   965: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   968: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   971: invokestatic 364	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   974: iload 8
    //   976: istore 5
    //   978: goto -812 -> 166
    //   981: ldc_w 353
    //   984: ldc_w 392
    //   987: invokestatic 155	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   990: iload 4
    //   992: ifeq -709 -> 283
    //   995: invokestatic 397	com/tencent/open/business/viareport/ReportDbHelper:a	()Lcom/tencent/open/business/viareport/ReportDbHelper;
    //   998: aload_0
    //   999: getfield 25	com/tencent/open/business/viareport/ReportManager:b	Ljava/util/ArrayList;
    //   1002: invokevirtual 400	com/tencent/open/business/viareport/ReportDbHelper:a	(Ljava/util/ArrayList;)I
    //   1005: pop
    //   1006: invokestatic 397	com/tencent/open/business/viareport/ReportDbHelper:a	()Lcom/tencent/open/business/viareport/ReportDbHelper;
    //   1009: aload_0
    //   1010: getfield 23	com/tencent/open/business/viareport/ReportManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1013: invokevirtual 400	com/tencent/open/business/viareport/ReportDbHelper:a	(Ljava/util/ArrayList;)I
    //   1016: pop
    //   1017: goto -734 -> 283
    //   1020: astore 23
    //   1022: lload 13
    //   1024: lstore 11
    //   1026: goto -320 -> 706
    //   1029: astore 23
    //   1031: goto -380 -> 651
    //   1034: astore 23
    //   1036: goto -592 -> 444
    //   1039: astore 23
    //   1041: goto -654 -> 387
    //   1044: astore 23
    //   1046: goto -716 -> 330
    //   1049: iload 5
    //   1051: istore 9
    //   1053: iload 6
    //   1055: istore 5
    //   1057: iload 9
    //   1059: istore 6
    //   1061: lload 13
    //   1063: lstore 17
    //   1065: iload 7
    //   1067: istore 9
    //   1069: goto -1018 -> 51
    //   1072: iload 5
    //   1074: istore 6
    //   1076: iload 7
    //   1078: istore 5
    //   1080: goto -952 -> 128
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1083	0	this	ReportManager
    //   0	1083	1	paramString1	String
    //   0	1083	2	paramString2	String
    //   0	1083	3	paramBundle	Bundle
    //   0	1083	4	paramBoolean	boolean
    //   35	1044	5	i	int
    //   32	1043	6	j	int
    //   55	1022	7	k	int
    //   3	972	8	m	int
    //   49	1019	9	n	int
    //   114	3	10	bool	boolean
    //   43	982	11	l1	long
    //   134	928	13	l2	long
    //   40	751	15	l3	long
    //   46	1018	17	l4	long
    //   59	498	19	l5	long
    //   156	7	21	l6	long
    //   67	85	23	localStatistic	com.tencent.open.base.http.HttpBaseUtil.Statistic
    //   320	41	23	localConnectTimeoutException1	org.apache.http.conn.ConnectTimeoutException
    //   377	41	23	localSocketTimeoutException1	java.net.SocketTimeoutException
    //   434	36	23	localJSONException1	org.json.JSONException
    //   641	39	23	localIOException1	java.io.IOException
    //   696	265	23	localException1	java.lang.Exception
    //   1020	1	23	localException2	java.lang.Exception
    //   1029	1	23	localIOException2	java.io.IOException
    //   1034	1	23	localJSONException2	org.json.JSONException
    //   1039	1	23	localSocketTimeoutException2	java.net.SocketTimeoutException
    //   1044	1	23	localConnectTimeoutException2	org.apache.http.conn.ConnectTimeoutException
    //   81	7	24	localJSONObject	org.json.JSONObject
    //   311	1	24	localJSONException3	org.json.JSONException
    // Exception table:
    //   from	to	target	type
    //   87	97	311	org/json/JSONException
    //   61	69	320	org/apache/http/conn/ConnectTimeoutException
    //   73	83	320	org/apache/http/conn/ConnectTimeoutException
    //   87	97	320	org/apache/http/conn/ConnectTimeoutException
    //   106	116	320	org/apache/http/conn/ConnectTimeoutException
    //   61	69	377	java/net/SocketTimeoutException
    //   73	83	377	java/net/SocketTimeoutException
    //   87	97	377	java/net/SocketTimeoutException
    //   106	116	377	java/net/SocketTimeoutException
    //   61	69	434	org/json/JSONException
    //   73	83	434	org/json/JSONException
    //   106	116	434	org/json/JSONException
    //   61	69	486	com/tencent/open/base/http/HttpBaseUtil$NetworkUnavailableException
    //   73	83	486	com/tencent/open/base/http/HttpBaseUtil$NetworkUnavailableException
    //   87	97	486	com/tencent/open/base/http/HttpBaseUtil$NetworkUnavailableException
    //   106	116	486	com/tencent/open/base/http/HttpBaseUtil$NetworkUnavailableException
    //   136	143	486	com/tencent/open/base/http/HttpBaseUtil$NetworkUnavailableException
    //   151	158	486	com/tencent/open/base/http/HttpBaseUtil$NetworkUnavailableException
    //   61	69	521	com/tencent/open/base/http/HttpBaseUtil$HttpStatusException
    //   73	83	521	com/tencent/open/base/http/HttpBaseUtil$HttpStatusException
    //   87	97	521	com/tencent/open/base/http/HttpBaseUtil$HttpStatusException
    //   106	116	521	com/tencent/open/base/http/HttpBaseUtil$HttpStatusException
    //   136	143	521	com/tencent/open/base/http/HttpBaseUtil$HttpStatusException
    //   151	158	521	com/tencent/open/base/http/HttpBaseUtil$HttpStatusException
    //   522	575	609	java/lang/Exception
    //   61	69	641	java/io/IOException
    //   73	83	641	java/io/IOException
    //   87	97	641	java/io/IOException
    //   106	116	641	java/io/IOException
    //   61	69	696	java/lang/Exception
    //   73	83	696	java/lang/Exception
    //   87	97	696	java/lang/Exception
    //   106	116	696	java/lang/Exception
    //   757	811	846	java/lang/Exception
    //   136	143	1020	java/lang/Exception
    //   151	158	1020	java/lang/Exception
    //   136	143	1029	java/io/IOException
    //   151	158	1029	java/io/IOException
    //   136	143	1034	org/json/JSONException
    //   151	158	1034	org/json/JSONException
    //   136	143	1039	java/net/SocketTimeoutException
    //   151	158	1039	java/net/SocketTimeoutException
    //   136	143	1044	org/apache/http/conn/ConnectTimeoutException
    //   151	158	1044	org/apache/http/conn/ConnectTimeoutException
  }
  
  /* Error */
  public boolean a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 401	com/tencent/open/business/viareport/ReportConfig:a	()J
    //   5: lstore_1
    //   6: invokestatic 406	java/lang/System:currentTimeMillis	()J
    //   9: lstore_3
    //   10: ldc 148
    //   12: new 42	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   19: ldc_w 408
    //   22: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: lload_1
    //   26: invokevirtual 332	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   29: ldc_w 410
    //   32: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: lload_3
    //   36: invokevirtual 332	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   39: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: invokestatic 155	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   45: invokestatic 412	com/tencent/open/business/viareport/ReportConfig:b	()J
    //   48: lstore 5
    //   50: ldc 148
    //   52: new 42	java/lang/StringBuilder
    //   55: dup
    //   56: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   59: ldc_w 414
    //   62: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: lload 5
    //   67: invokevirtual 332	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   70: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: invokestatic 155	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   76: lload_3
    //   77: lload_1
    //   78: lsub
    //   79: lload 5
    //   81: ldc2_w 415
    //   84: lmul
    //   85: lcmp
    //   86: ifge +20 -> 106
    //   89: ldc_w 353
    //   92: ldc_w 418
    //   95: invokestatic 155	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   98: iconst_0
    //   99: istore 7
    //   101: aload_0
    //   102: monitorexit
    //   103: iload 7
    //   105: ireturn
    //   106: lload_3
    //   107: invokestatic 421	com/tencent/open/business/viareport/ReportConfig:a	(J)V
    //   110: ldc_w 353
    //   113: ldc_w 423
    //   116: invokestatic 155	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   119: iconst_1
    //   120: istore 7
    //   122: goto -21 -> 101
    //   125: astore 8
    //   127: aload_0
    //   128: monitorexit
    //   129: aload 8
    //   131: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	132	0	this	ReportManager
    //   5	73	1	l1	long
    //   9	98	3	l2	long
    //   48	32	5	l3	long
    //   99	22	7	bool	boolean
    //   125	5	8	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	76	125	finally
    //   89	98	125	finally
    //   106	119	125	finally
  }
  
  /* Error */
  protected boolean a(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_1
    //   3: invokestatic 426	com/tencent/open/business/viareport/ReportConfig:a	(I)I
    //   6: istore_1
    //   7: ldc 148
    //   9: new 42	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 428
    //   19: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: iload_1
    //   23: invokevirtual 298	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   26: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   29: invokestatic 155	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   32: new 430	java/util/Random
    //   35: dup
    //   36: invokespecial 431	java/util/Random:<init>	()V
    //   39: bipush 100
    //   41: invokevirtual 434	java/util/Random:nextInt	(I)I
    //   44: iload_1
    //   45: if_icmpge +18 -> 63
    //   48: ldc_w 436
    //   51: ldc_w 438
    //   54: invokestatic 155	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   57: iconst_1
    //   58: istore_2
    //   59: aload_0
    //   60: monitorexit
    //   61: iload_2
    //   62: ireturn
    //   63: ldc_w 436
    //   66: ldc_w 440
    //   69: invokestatic 155	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   72: iconst_0
    //   73: istore_2
    //   74: goto -15 -> 59
    //   77: astore_3
    //   78: aload_0
    //   79: monitorexit
    //   80: aload_3
    //   81: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	this	ReportManager
    //   0	82	1	paramInt	int
    //   58	16	2	bool	boolean
    //   77	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	57	77	finally
    //   63	72	77	finally
  }
  
  /* Error */
  public boolean a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 442	com/tencent/open/business/viareport/ReportConfig:a	()I
    //   5: istore_2
    //   6: ldc 148
    //   8: new 42	java/lang/StringBuilder
    //   11: dup
    //   12: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   15: ldc_w 444
    //   18: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: iload_2
    //   22: invokevirtual 298	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   25: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: invokestatic 155	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   31: invokestatic 397	com/tencent/open/business/viareport/ReportDbHelper:a	()Lcom/tencent/open/business/viareport/ReportDbHelper;
    //   34: aload_1
    //   35: invokevirtual 446	com/tencent/open/business/viareport/ReportDbHelper:a	(Ljava/lang/String;)I
    //   38: iload_2
    //   39: if_icmplt +18 -> 57
    //   42: ldc_w 353
    //   45: ldc_w 448
    //   48: invokestatic 155	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   51: iconst_1
    //   52: istore_3
    //   53: aload_0
    //   54: monitorexit
    //   55: iload_3
    //   56: ireturn
    //   57: ldc_w 353
    //   60: ldc_w 450
    //   63: invokestatic 155	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   66: iconst_0
    //   67: istore_3
    //   68: goto -15 -> 53
    //   71: astore_1
    //   72: aload_0
    //   73: monitorexit
    //   74: aload_1
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	ReportManager
    //   0	76	1	paramString	String
    //   5	35	2	i	int
    //   52	16	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	51	71	finally
    //   57	66	71	finally
  }
  
  /* Error */
  protected boolean a(String paramString, Bundle paramBundle)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokestatic 397	com/tencent/open/business/viareport/ReportDbHelper:a	()Lcom/tencent/open/business/viareport/ReportDbHelper;
    //   6: aload_1
    //   7: invokevirtual 453	com/tencent/open/business/viareport/ReportDbHelper:a	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   10: putfield 23	com/tencent/open/business/viareport/ReportManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   13: invokestatic 397	com/tencent/open/business/viareport/ReportDbHelper:a	()Lcom/tencent/open/business/viareport/ReportDbHelper;
    //   16: ldc_w 455
    //   19: aload_1
    //   20: invokevirtual 458	com/tencent/open/business/viareport/ReportDbHelper:a	(Ljava/lang/String;Ljava/lang/String;)I
    //   23: pop
    //   24: aload_0
    //   25: invokestatic 397	com/tencent/open/business/viareport/ReportDbHelper:a	()Lcom/tencent/open/business/viareport/ReportDbHelper;
    //   28: aload_1
    //   29: invokevirtual 460	com/tencent/open/business/viareport/ReportDbHelper:b	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   32: putfield 25	com/tencent/open/business/viareport/ReportManager:b	Ljava/util/ArrayList;
    //   35: invokestatic 397	com/tencent/open/business/viareport/ReportDbHelper:a	()Lcom/tencent/open/business/viareport/ReportDbHelper;
    //   38: ldc_w 462
    //   41: aload_1
    //   42: invokevirtual 458	com/tencent/open/business/viareport/ReportDbHelper:a	(Ljava/lang/String;Ljava/lang/String;)I
    //   45: pop
    //   46: aload_0
    //   47: aload_0
    //   48: getfield 23	com/tencent/open/business/viareport/ReportManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   51: aload_0
    //   52: getfield 25	com/tencent/open/business/viareport/ReportManager:b	Ljava/util/ArrayList;
    //   55: invokevirtual 464	com/tencent/open/business/viareport/ReportManager:a	(Ljava/util/ArrayList;Ljava/util/ArrayList;)Ljava/lang/String;
    //   58: astore_1
    //   59: ldc 148
    //   61: new 42	java/lang/StringBuilder
    //   64: dup
    //   65: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   68: ldc_w 466
    //   71: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: aload_1
    //   75: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   81: invokestatic 155	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   84: aload_2
    //   85: ldc_w 468
    //   88: aload_1
    //   89: invokevirtual 162	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   92: aload_1
    //   93: invokestatic 37	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   96: istore_3
    //   97: iload_3
    //   98: ifeq +9 -> 107
    //   101: iconst_0
    //   102: istore_3
    //   103: aload_0
    //   104: monitorexit
    //   105: iload_3
    //   106: ireturn
    //   107: iconst_1
    //   108: istore_3
    //   109: goto -6 -> 103
    //   112: astore_1
    //   113: aload_0
    //   114: monitorexit
    //   115: aload_1
    //   116: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	this	ReportManager
    //   0	117	1	paramString	String
    //   0	117	2	paramBundle	Bundle
    //   96	13	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	97	112	finally
  }
  
  /* Error */
  public boolean b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 469	com/tencent/open/business/viareport/ReportConfig:a	(Ljava/lang/String;)I
    //   6: istore_2
    //   7: ldc 148
    //   9: new 42	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 471
    //   19: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: iload_2
    //   23: invokevirtual 298	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   26: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   29: invokestatic 155	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   32: new 430	java/util/Random
    //   35: dup
    //   36: invokespecial 431	java/util/Random:<init>	()V
    //   39: bipush 100
    //   41: invokevirtual 434	java/util/Random:nextInt	(I)I
    //   44: iload_2
    //   45: if_icmpge +18 -> 63
    //   48: ldc_w 436
    //   51: ldc_w 473
    //   54: invokestatic 155	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   57: iconst_1
    //   58: istore_3
    //   59: aload_0
    //   60: monitorexit
    //   61: iload_3
    //   62: ireturn
    //   63: ldc_w 436
    //   66: ldc_w 475
    //   69: invokestatic 155	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   72: iconst_0
    //   73: istore_3
    //   74: goto -15 -> 59
    //   77: astore_1
    //   78: aload_0
    //   79: monitorexit
    //   80: aload_1
    //   81: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	this	ReportManager
    //   0	82	1	paramString	String
    //   6	40	2	i	int
    //   58	16	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	57	77	finally
    //   63	72	77	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.open.business.viareport.ReportManager
 * JD-Core Version:    0.7.0.1
 */