package com.tencent.TMG.logger;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.TMG.ptt.PttManager;
import com.tencent.TMG.utils.CosFileTransfer;
import com.tencent.TMG.utils.CosFileTransfer.UploadCosFileListener;
import com.tencent.TMG.utils.HttpHelper;
import com.tencent.TMG.utils.HttpHelper.HttpRequestListener;
import com.tencent.TMG.wrapper.OpensdkGameWrapper;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.io.File;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public class LogReporter
{
  public static final String TAG = "LogReporter";
  private static final int TIME_INTERVAL = 10800000;
  public static final String URL_LOG_POLLER = "https://console.tim.qq.com:443/v4/opensdk_log_poller/poll?identifier=%s&usersig=%s&sdkappid=%s";
  public static final String URL_REPORT_REQ_RECEIVED = "https://avc.qcloud.com/log/opensdklogApi.php?act=reportReqReceived";
  public static final String URL_REPORT_UPLOAD_FINISHED = "https://avc.qcloud.com/log/opensdklogApi.php?act=reportUploadFinished";
  private static final int appId = 10002868;
  private static final String bucketId = "sdklog";
  private static final String dir = "imsdk";
  private static LogReporter sInstance = null;
  private static final String secretId = "AKIDIsvZoS8DRMqxDPh0wQ5B3sF6SlCINL0G";
  private static final String secretKey = "8whnoADaf5USGpmmio7JATVQWrj5BaSz";
  private static final String uploadRoot = "http://web.file.myqcloud.com/files/v1";
  Handler handler = new Handler(Looper.getMainLooper());
  private String mAppid = null;
  private String mIdentifier = null;
  private HttpHelper.HttpRequestListener mLogPollerListener = new HttpHelper.HttpRequestListener()
  {
    public void onCompleted(String paramAnonymousString, int paramAnonymousInt, byte[] paramAnonymousArrayOfByte, Object paramAnonymousObject)
    {
      if ((paramAnonymousInt != 200) || (paramAnonymousArrayOfByte == null) || (paramAnonymousArrayOfByte.length == 0)) {
        Log.e("LogReporter", String.format("mLogPollerListener|http request error code=%d", new Object[] { Integer.valueOf(paramAnonymousInt) }));
      }
      for (;;)
      {
        return;
        paramAnonymousString = new LogUploadMessage.Resp();
        try
        {
          paramAnonymousString.mergeFrom(paramAnonymousArrayOfByte);
          int i = paramAnonymousString.num_log_uploads.get();
          paramAnonymousInt = 0;
          while ((paramAnonymousInt < i) && (paramAnonymousInt < paramAnonymousString.params.size()))
          {
            LogReporter.this.reprotLogInfo((LogUploadMessage.LogParam)paramAnonymousString.params.get(paramAnonymousInt));
            paramAnonymousInt += 1;
          }
          return;
        }
        catch (InvalidProtocolBufferMicroException paramAnonymousString) {}
      }
    }
  };
  private HttpHelper.HttpRequestListener mReportLogFinishedListener = new HttpHelper.HttpRequestListener()
  {
    public void onCompleted(String paramAnonymousString, int paramAnonymousInt, byte[] paramAnonymousArrayOfByte, Object paramAnonymousObject)
    {
      if ((paramAnonymousInt != 200) || (paramAnonymousArrayOfByte == null) || (paramAnonymousArrayOfByte.length == 0))
      {
        Log.e("LogReporter", String.format("mReportLogFinishedListener|http request error code=%d", new Object[] { Integer.valueOf(paramAnonymousInt) }));
        return;
      }
      Log.i("LogReporter", String.format("mReportLogFinishedListener|upload log finish.req=%s, resp=%s", new Object[] { paramAnonymousObject, new String(paramAnonymousArrayOfByte) }));
    }
  };
  private HttpHelper.HttpRequestListener mReportLogInfoListener = new HttpHelper.HttpRequestListener()
  {
    public void onCompleted(String paramAnonymousString, int paramAnonymousInt, byte[] paramAnonymousArrayOfByte, Object paramAnonymousObject)
    {
      if ((paramAnonymousObject == null) || (!(paramAnonymousObject instanceof LogReporter.LogReprotInfo))) {}
      do
      {
        return;
        paramAnonymousString = (LogReporter.LogReprotInfo)paramAnonymousObject;
      } while (TextUtils.isEmpty(paramAnonymousString.logPath));
      if ((paramAnonymousInt != 200) || (paramAnonymousArrayOfByte == null) || (paramAnonymousArrayOfByte.length == 0))
      {
        Log.e("LogReporter", String.format("mReportLogInfoListener|http request error code=%d", new Object[] { Integer.valueOf(paramAnonymousInt) }));
        return;
      }
      paramAnonymousArrayOfByte = new String(paramAnonymousArrayOfByte);
      try
      {
        int i = new JSONObject(paramAnonymousArrayOfByte).getInt("errorCode");
        if ((i == 0) || (i == 1))
        {
          LogReporter.this.uploadLogFile(paramAnonymousString);
          return;
        }
      }
      catch (JSONException paramAnonymousString)
      {
        paramAnonymousString.printStackTrace();
        Log.e("LogReporter", String.format("mReportLogInfoListener|json=%s", new Object[] { paramAnonymousArrayOfByte }));
        return;
      }
      Log.e("LogReporter", String.format("mReportLogInfoListener|errorcode=%d", new Object[] { Integer.valueOf(paramAnonymousInt) }));
    }
  };
  private String mToken = null;
  private CosFileTransfer.UploadCosFileListener mUploadCosFileListener = new CosFileTransfer.UploadCosFileListener()
  {
    public void onCompleted(int paramAnonymousInt, String paramAnonymousString, Object paramAnonymousObject)
    {
      if ((paramAnonymousObject == null) || (!(paramAnonymousObject instanceof LogReporter.LogReprotInfo))) {
        return;
      }
      paramAnonymousObject = (LogReporter.LogReprotInfo)paramAnonymousObject;
      File localFile = new File(paramAnonymousObject.logPath);
      if (localFile.exists()) {
        localFile.delete();
      }
      if (paramAnonymousInt != 0)
      {
        Log.e("LogReporter", String.format("mUploadCosFileListener| uplaod log file failed. code=%d", new Object[] { Integer.valueOf(paramAnonymousInt) }));
        return;
      }
      LogReporter.this.reportLogFinished(paramAnonymousString, paramAnonymousObject.uploadSeq);
    }
  };
  Runnable runnable = new Runnable()
  {
    public void run()
    {
      LogReporter.this.reportLog();
    }
  };
  
  private void fetchLogReportInfo()
  {
    HttpHelper.httpPostRequest(String.format("https://console.tim.qq.com:443/v4/opensdk_log_poller/poll?identifier=%s&usersig=%s&sdkappid=%s", new Object[] { this.mIdentifier, this.mToken, this.mAppid }), "{}".getBytes(), null, null, this.mLogPollerListener);
  }
  
  public static LogReporter getInstance()
  {
    if (sInstance == null) {}
    try
    {
      if (sInstance == null) {
        sInstance = new LogReporter();
      }
      return sInstance;
    }
    finally {}
  }
  
  private void reportLogFinished(String paramString1, String paramString2)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("seq", paramString2);
      localJSONObject.put("url", paramString1);
      HttpHelper.httpPostRequest("https://avc.qcloud.com/log/opensdklogApi.php?act=reportUploadFinished", localJSONObject.toString().getBytes(), null, localJSONObject.toString(), this.mReportLogFinishedListener);
      return;
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  private void reprotLogInfo(LogUploadMessage.LogParam paramLogParam)
  {
    int j = 0;
    Object localObject = zipLogFile(paramLogParam.begin_at.get(), paramLogParam.end_at.get(), paramLogParam.seq.get() + "");
    int i;
    if (localObject != null) {
      i = PttManager.getFileSize((String)localObject);
    }
    for (;;)
    {
      String str = paramLogParam.seq.get() + "";
      paramLogParam = new JSONObject();
      try
      {
        paramLogParam.put("seq", str);
        if (i == 0) {}
        for (;;)
        {
          paramLogParam.put("exist", j);
          paramLogParam.put("size", i);
          paramLogParam.put("platform", "Android");
          paramLogParam.put("sdkversion", OpensdkGameWrapper.nativeGetSdkVersion());
          paramLogParam.put("appversion", OpensdkGameWrapper.nativeGetAppVersion());
          localObject = new LogReprotInfo((String)localObject, str);
          HttpHelper.httpPostRequest("https://avc.qcloud.com/log/opensdklogApi.php?act=reportReqReceived", paramLogParam.toString().getBytes(), null, localObject, this.mReportLogInfoListener);
          return;
          j = 1;
        }
        i = 0;
      }
      catch (JSONException paramLogParam)
      {
        paramLogParam.printStackTrace();
        return;
      }
    }
  }
  
  private void uploadLogFile(LogReprotInfo paramLogReprotInfo)
  {
    String str1 = UUID.randomUUID().toString();
    String str2 = "/10002868/sdklog/imsdk/" + str1;
    str1 = "http://web.file.myqcloud.com/files/v1" + str2;
    try
    {
      str2 = IMFunc.appSignature(10002868, "AKIDIsvZoS8DRMqxDPh0wQ5B3sF6SlCINL0G", "8whnoADaf5USGpmmio7JATVQWrj5BaSz", 60L, str2, "sdklog");
      CosFileTransfer.uploadFile(paramLogReprotInfo.logPath, str1, str2, 20971520, paramLogReprotInfo, this.mUploadCosFileListener);
      return;
    }
    catch (Exception paramLogReprotInfo)
    {
      Log.e("LogReporter", "get cos signature failed.");
      paramLogReprotInfo.printStackTrace();
    }
  }
  
  /* Error */
  private String zipLogFile(long paramLong1, long paramLong2, String paramString)
  {
    // Byte code:
    //   0: lload_3
    //   1: lload_1
    //   2: lsub
    //   3: lconst_0
    //   4: lcmp
    //   5: ifge +35 -> 40
    //   8: ldc 21
    //   10: ldc_w 276
    //   13: iconst_2
    //   14: anewarray 4	java/lang/Object
    //   17: dup
    //   18: iconst_0
    //   19: lload_1
    //   20: invokestatic 282	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   23: aastore
    //   24: dup
    //   25: iconst_1
    //   26: lload_3
    //   27: invokestatic 282	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   30: aastore
    //   31: invokestatic 134	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   34: invokestatic 271	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   37: pop
    //   38: aconst_null
    //   39: areturn
    //   40: invokestatic 287	com/tencent/TMG/sdk/AVLoggerClient:getLogDir	()Ljava/lang/String;
    //   43: astore 12
    //   45: aload 12
    //   47: invokestatic 293	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   50: ifeq +14 -> 64
    //   53: ldc 21
    //   55: ldc_w 295
    //   58: invokestatic 271	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   61: pop
    //   62: aconst_null
    //   63: areturn
    //   64: aload 12
    //   66: astore 11
    //   68: aload 12
    //   70: bipush 47
    //   72: invokevirtual 299	java/lang/String:lastIndexOf	(I)I
    //   75: aload 12
    //   77: invokevirtual 302	java/lang/String:length	()I
    //   80: iconst_1
    //   81: isub
    //   82: if_icmpne +18 -> 100
    //   85: aload 12
    //   87: iconst_0
    //   88: aload 12
    //   90: invokevirtual 302	java/lang/String:length	()I
    //   93: iconst_1
    //   94: isub
    //   95: invokevirtual 306	java/lang/String:substring	(II)Ljava/lang/String;
    //   98: astore 11
    //   100: bipush 7
    //   102: anewarray 130	java/lang/String
    //   105: astore 14
    //   107: iconst_0
    //   108: istore 6
    //   110: new 308	java/text/SimpleDateFormat
    //   113: dup
    //   114: ldc_w 310
    //   117: invokespecial 313	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;)V
    //   120: astore 15
    //   122: lload_1
    //   123: lstore 9
    //   125: lload 9
    //   127: lload_3
    //   128: lcmp
    //   129: ifgt +118 -> 247
    //   132: lload 9
    //   134: ldc2_w 314
    //   137: lload_1
    //   138: ladd
    //   139: lcmp
    //   140: ifge +107 -> 247
    //   143: ldc_w 317
    //   146: iconst_1
    //   147: anewarray 4	java/lang/Object
    //   150: dup
    //   151: iconst_0
    //   152: aload 15
    //   154: new 319	java/util/Date
    //   157: dup
    //   158: ldc2_w 320
    //   161: lload 9
    //   163: lmul
    //   164: invokespecial 324	java/util/Date:<init>	(J)V
    //   167: invokevirtual 327	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   170: aastore
    //   171: invokestatic 134	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   174: astore 12
    //   176: iload 6
    //   178: istore 7
    //   180: new 329	java/io/File
    //   183: dup
    //   184: new 186	java/lang/StringBuilder
    //   187: dup
    //   188: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   191: aload 11
    //   193: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: ldc_w 331
    //   199: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: aload 12
    //   204: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   210: invokespecial 332	java/io/File:<init>	(Ljava/lang/String;)V
    //   213: invokevirtual 336	java/io/File:exists	()Z
    //   216: ifeq +16 -> 232
    //   219: aload 14
    //   221: iload 6
    //   223: aload 12
    //   225: aastore
    //   226: iload 6
    //   228: iconst_1
    //   229: iadd
    //   230: istore 7
    //   232: lload 9
    //   234: ldc2_w 337
    //   237: ladd
    //   238: lstore 9
    //   240: iload 7
    //   242: istore 6
    //   244: goto -119 -> 125
    //   247: new 319	java/util/Date
    //   250: dup
    //   251: ldc2_w 320
    //   254: lload_1
    //   255: lmul
    //   256: invokespecial 324	java/util/Date:<init>	(J)V
    //   259: astore 16
    //   261: new 319	java/util/Date
    //   264: dup
    //   265: ldc2_w 320
    //   268: lload_3
    //   269: lmul
    //   270: invokespecial 324	java/util/Date:<init>	(J)V
    //   273: astore 12
    //   275: iload 6
    //   277: ifne +46 -> 323
    //   280: ldc 21
    //   282: ldc_w 340
    //   285: iconst_3
    //   286: anewarray 4	java/lang/Object
    //   289: dup
    //   290: iconst_0
    //   291: aload 11
    //   293: aastore
    //   294: dup
    //   295: iconst_1
    //   296: aload 15
    //   298: aload 16
    //   300: invokevirtual 327	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   303: aastore
    //   304: dup
    //   305: iconst_2
    //   306: aload 15
    //   308: aload 12
    //   310: invokevirtual 327	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   313: aastore
    //   314: invokestatic 134	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   317: invokestatic 271	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   320: pop
    //   321: aconst_null
    //   322: areturn
    //   323: aconst_null
    //   324: astore 13
    //   326: aconst_null
    //   327: astore 12
    //   329: ldc_w 342
    //   332: iconst_4
    //   333: anewarray 4	java/lang/Object
    //   336: dup
    //   337: iconst_0
    //   338: aload 11
    //   340: aastore
    //   341: dup
    //   342: iconst_1
    //   343: aload_0
    //   344: getfield 77	com/tencent/TMG/logger/LogReporter:mIdentifier	Ljava/lang/String;
    //   347: aastore
    //   348: dup
    //   349: iconst_2
    //   350: aload 15
    //   352: aload 16
    //   354: invokevirtual 327	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   357: aastore
    //   358: dup
    //   359: iconst_3
    //   360: aload 5
    //   362: aastore
    //   363: invokestatic 134	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   366: astore 15
    //   368: new 344	java/util/zip/ZipOutputStream
    //   371: dup
    //   372: new 346	java/io/FileOutputStream
    //   375: dup
    //   376: new 329	java/io/File
    //   379: dup
    //   380: aload 15
    //   382: invokespecial 332	java/io/File:<init>	(Ljava/lang/String;)V
    //   385: invokespecial 349	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   388: invokespecial 352	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   391: astore 5
    //   393: aload 13
    //   395: astore 12
    //   397: sipush 4096
    //   400: newarray byte
    //   402: astore 16
    //   404: iconst_0
    //   405: istore 7
    //   407: iload 7
    //   409: iload 6
    //   411: if_icmpge +178 -> 589
    //   414: new 354	java/io/FileInputStream
    //   417: dup
    //   418: new 329	java/io/File
    //   421: dup
    //   422: new 186	java/lang/StringBuilder
    //   425: dup
    //   426: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   429: aload 11
    //   431: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: ldc_w 331
    //   437: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   440: aload 14
    //   442: iload 7
    //   444: aaload
    //   445: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   448: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   451: invokespecial 332	java/io/File:<init>	(Ljava/lang/String;)V
    //   454: invokespecial 355	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   457: astore 13
    //   459: aload 13
    //   461: astore 12
    //   463: aload 5
    //   465: new 357	java/util/zip/ZipEntry
    //   468: dup
    //   469: aload 14
    //   471: iload 7
    //   473: aaload
    //   474: invokespecial 358	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   477: invokevirtual 362	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   480: aload 13
    //   482: astore 12
    //   484: aload 13
    //   486: aload 16
    //   488: invokevirtual 366	java/io/FileInputStream:read	([B)I
    //   491: istore 8
    //   493: iload 8
    //   495: iconst_m1
    //   496: if_icmpeq +66 -> 562
    //   499: aload 13
    //   501: astore 12
    //   503: aload 5
    //   505: aload 16
    //   507: iconst_0
    //   508: iload 8
    //   510: invokevirtual 370	java/util/zip/ZipOutputStream:write	([BII)V
    //   513: goto -33 -> 480
    //   516: astore 12
    //   518: aload 5
    //   520: astore 11
    //   522: aload 13
    //   524: astore 5
    //   526: aload 12
    //   528: invokevirtual 371	java/io/IOException:printStackTrace	()V
    //   531: ldc 21
    //   533: ldc_w 373
    //   536: invokestatic 271	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   539: pop
    //   540: aload 11
    //   542: ifnull +8 -> 550
    //   545: aload 11
    //   547: invokevirtual 376	java/util/zip/ZipOutputStream:close	()V
    //   550: aload 5
    //   552: ifnull +219 -> 771
    //   555: aload 5
    //   557: invokevirtual 377	java/io/FileInputStream:close	()V
    //   560: aconst_null
    //   561: areturn
    //   562: aload 13
    //   564: astore 12
    //   566: aload 5
    //   568: invokevirtual 380	java/util/zip/ZipOutputStream:closeEntry	()V
    //   571: aload 13
    //   573: astore 12
    //   575: aload 13
    //   577: invokevirtual 377	java/io/FileInputStream:close	()V
    //   580: iload 7
    //   582: iconst_1
    //   583: iadd
    //   584: istore 7
    //   586: goto -179 -> 407
    //   589: aload 5
    //   591: ifnull +8 -> 599
    //   594: aload 5
    //   596: invokevirtual 376	java/util/zip/ZipOutputStream:close	()V
    //   599: iconst_0
    //   600: ifeq +173 -> 773
    //   603: new 382	java/lang/NullPointerException
    //   606: dup
    //   607: invokespecial 383	java/lang/NullPointerException:<init>	()V
    //   610: athrow
    //   611: astore 5
    //   613: aload 5
    //   615: invokevirtual 371	java/io/IOException:printStackTrace	()V
    //   618: goto -19 -> 599
    //   621: astore 5
    //   623: aload 5
    //   625: invokevirtual 371	java/io/IOException:printStackTrace	()V
    //   628: aload 15
    //   630: areturn
    //   631: astore 11
    //   633: aload 11
    //   635: invokevirtual 371	java/io/IOException:printStackTrace	()V
    //   638: goto -88 -> 550
    //   641: astore 5
    //   643: aload 5
    //   645: invokevirtual 371	java/io/IOException:printStackTrace	()V
    //   648: aconst_null
    //   649: areturn
    //   650: astore 11
    //   652: aconst_null
    //   653: astore 5
    //   655: aload 5
    //   657: ifnull +8 -> 665
    //   660: aload 5
    //   662: invokevirtual 376	java/util/zip/ZipOutputStream:close	()V
    //   665: aload 12
    //   667: ifnull +8 -> 675
    //   670: aload 12
    //   672: invokevirtual 377	java/io/FileInputStream:close	()V
    //   675: aload 11
    //   677: athrow
    //   678: astore 5
    //   680: aload 5
    //   682: invokevirtual 371	java/io/IOException:printStackTrace	()V
    //   685: goto -20 -> 665
    //   688: astore 5
    //   690: aload 5
    //   692: invokevirtual 371	java/io/IOException:printStackTrace	()V
    //   695: goto -20 -> 675
    //   698: astore 11
    //   700: goto -45 -> 655
    //   703: astore 11
    //   705: aconst_null
    //   706: astore 12
    //   708: goto -53 -> 655
    //   711: astore 13
    //   713: aload 5
    //   715: astore 12
    //   717: aload 11
    //   719: astore 5
    //   721: aload 13
    //   723: astore 11
    //   725: goto -70 -> 655
    //   728: astore 12
    //   730: aconst_null
    //   731: astore 5
    //   733: aconst_null
    //   734: astore 11
    //   736: goto -210 -> 526
    //   739: astore 12
    //   741: aconst_null
    //   742: astore 13
    //   744: aload 5
    //   746: astore 11
    //   748: aload 13
    //   750: astore 5
    //   752: goto -226 -> 526
    //   755: astore 12
    //   757: aconst_null
    //   758: astore 13
    //   760: aload 5
    //   762: astore 11
    //   764: aload 13
    //   766: astore 5
    //   768: goto -242 -> 526
    //   771: aconst_null
    //   772: areturn
    //   773: aload 15
    //   775: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	776	0	this	LogReporter
    //   0	776	1	paramLong1	long
    //   0	776	3	paramLong2	long
    //   0	776	5	paramString	String
    //   108	304	6	i	int
    //   178	407	7	j	int
    //   491	18	8	k	int
    //   123	116	9	l	long
    //   66	480	11	localObject1	Object
    //   631	3	11	localIOException1	java.io.IOException
    //   650	26	11	localObject2	Object
    //   698	1	11	localObject3	Object
    //   703	15	11	localObject4	Object
    //   723	40	11	localObject5	Object
    //   43	459	12	localObject6	Object
    //   516	11	12	localIOException2	java.io.IOException
    //   564	152	12	localObject7	Object
    //   728	1	12	localIOException3	java.io.IOException
    //   739	1	12	localIOException4	java.io.IOException
    //   755	1	12	localIOException5	java.io.IOException
    //   324	252	13	localFileInputStream	java.io.FileInputStream
    //   711	11	13	localObject8	Object
    //   742	23	13	localObject9	Object
    //   105	365	14	arrayOfString	String[]
    //   120	654	15	localObject10	Object
    //   259	247	16	localObject11	Object
    // Exception table:
    //   from	to	target	type
    //   463	480	516	java/io/IOException
    //   484	493	516	java/io/IOException
    //   503	513	516	java/io/IOException
    //   566	571	516	java/io/IOException
    //   575	580	516	java/io/IOException
    //   594	599	611	java/io/IOException
    //   603	611	621	java/io/IOException
    //   545	550	631	java/io/IOException
    //   555	560	641	java/io/IOException
    //   329	393	650	finally
    //   660	665	678	java/io/IOException
    //   670	675	688	java/io/IOException
    //   397	404	698	finally
    //   463	480	698	finally
    //   484	493	698	finally
    //   503	513	698	finally
    //   566	571	698	finally
    //   575	580	698	finally
    //   414	459	703	finally
    //   526	540	711	finally
    //   329	393	728	java/io/IOException
    //   397	404	739	java/io/IOException
    //   414	459	755	java/io/IOException
  }
  
  public int reportLog()
  {
    this.handler.removeCallbacks(this.runnable);
    this.handler.postDelayed(this.runnable, 10800000L);
    Log.d("LogReporter", String.format("reportLog|mAppid=%s,mIdentifier=%s,mToken=%s", new Object[] { this.mAppid, this.mIdentifier, this.mToken }));
    if ((this.mAppid == null) || (this.mIdentifier == null)) {
      return 1004;
    }
    fetchLogReportInfo();
    return 0;
  }
  
  public void setAccessToken(String paramString)
  {
    this.mToken = paramString;
  }
  
  public void setAppInfo(String paramString1, String paramString2)
  {
    this.mAppid = paramString1;
    this.mIdentifier = paramString2;
  }
  
  class LogReprotInfo
  {
    String logPath = null;
    String uploadSeq = null;
    
    public LogReprotInfo(String paramString1, String paramString2)
    {
      this.logPath = paramString1;
      this.uploadSeq = paramString2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.TMG.logger.LogReporter
 * JD-Core Version:    0.7.0.1
 */