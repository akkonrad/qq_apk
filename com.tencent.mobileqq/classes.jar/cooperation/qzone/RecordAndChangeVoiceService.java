package cooperation.qzone;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.av.utils.TraeHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.voicechange.IVoiceChangeListener;
import com.tencent.mobileqq.voicechange.VoiceChangeBasicParams;
import com.tencent.mobileqq.voicechange.VoiceChangeManager;
import com.tencent.mobileqq.voicechange.VoiceChangeParams.IOnCompressFinish;
import com.tencent.mobileqq.widget.QQToast;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.webviewplugin.QZonePublishSecretShuoShuoH5Plugin;
import cooperation.qzone.webviewplugin.QZonePublishVoiceShuoShuoH5Plugin;
import eipc.EIPCClient;

public class RecordAndChangeVoiceService
  implements IVoiceChangeListener, VoiceChangeParams.IOnCompressFinish
{
  private static RecordAndChangeVoiceService jdField_a_of_type_CooperationQzoneRecordAndChangeVoiceService;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  public VoiceChangeBasicParams a;
  private String jdField_a_of_type_JavaLangString = TraeHelper.a(BaseApplicationImpl.getContext());
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  private String c;
  
  private RecordAndChangeVoiceService()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      QIPCClientHelper.getInstance().getClient().callServer("QzoneIPCModule", "startDownloadVoicechangeSo", null);
    }
  }
  
  public static RecordAndChangeVoiceService a()
  {
    if (jdField_a_of_type_CooperationQzoneRecordAndChangeVoiceService == null) {}
    try
    {
      if (jdField_a_of_type_CooperationQzoneRecordAndChangeVoiceService == null) {
        jdField_a_of_type_CooperationQzoneRecordAndChangeVoiceService = new RecordAndChangeVoiceService();
      }
      return jdField_a_of_type_CooperationQzoneRecordAndChangeVoiceService;
    }
    finally {}
  }
  
  /* Error */
  public String a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_2
    //   5: new 73	java/io/File
    //   8: dup
    //   9: aload_1
    //   10: invokespecial 76	java/io/File:<init>	(Ljava/lang/String;)V
    //   13: astore 5
    //   15: new 78	java/io/FileInputStream
    //   18: dup
    //   19: aload 5
    //   21: invokespecial 81	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   24: astore_3
    //   25: aload_3
    //   26: astore_1
    //   27: aload 4
    //   29: astore_2
    //   30: aload 5
    //   32: invokevirtual 85	java/io/File:length	()J
    //   35: l2i
    //   36: newarray byte
    //   38: astore 4
    //   40: aload_3
    //   41: astore_1
    //   42: aload 4
    //   44: astore_2
    //   45: aload_3
    //   46: aload 4
    //   48: invokevirtual 89	java/io/FileInputStream:read	([B)I
    //   51: pop
    //   52: aload 4
    //   54: astore_1
    //   55: aload_3
    //   56: ifnull +10 -> 66
    //   59: aload_3
    //   60: invokevirtual 92	java/io/FileInputStream:close	()V
    //   63: aload 4
    //   65: astore_1
    //   66: aload_1
    //   67: ifnull +105 -> 172
    //   70: aload_1
    //   71: iconst_0
    //   72: invokestatic 98	com/tencent/smtt/utils/Base64:encodeToString	([BI)Ljava/lang/String;
    //   75: areturn
    //   76: astore_1
    //   77: ldc 65
    //   79: iconst_1
    //   80: aload_1
    //   81: iconst_0
    //   82: anewarray 4	java/lang/Object
    //   85: invokestatic 104	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   88: aload 4
    //   90: astore_1
    //   91: goto -25 -> 66
    //   94: astore 4
    //   96: aconst_null
    //   97: astore_3
    //   98: aload_3
    //   99: astore_1
    //   100: ldc 65
    //   102: iconst_1
    //   103: aload 4
    //   105: iconst_0
    //   106: anewarray 4	java/lang/Object
    //   109: invokestatic 104	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   112: aload_2
    //   113: astore_1
    //   114: aload_3
    //   115: ifnull -49 -> 66
    //   118: aload_3
    //   119: invokevirtual 92	java/io/FileInputStream:close	()V
    //   122: aload_2
    //   123: astore_1
    //   124: goto -58 -> 66
    //   127: astore_1
    //   128: ldc 65
    //   130: iconst_1
    //   131: aload_1
    //   132: iconst_0
    //   133: anewarray 4	java/lang/Object
    //   136: invokestatic 104	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   139: aload_2
    //   140: astore_1
    //   141: goto -75 -> 66
    //   144: astore_2
    //   145: aconst_null
    //   146: astore_1
    //   147: aload_1
    //   148: ifnull +7 -> 155
    //   151: aload_1
    //   152: invokevirtual 92	java/io/FileInputStream:close	()V
    //   155: aload_2
    //   156: athrow
    //   157: astore_1
    //   158: ldc 65
    //   160: iconst_1
    //   161: aload_1
    //   162: iconst_0
    //   163: anewarray 4	java/lang/Object
    //   166: invokestatic 104	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   169: goto -14 -> 155
    //   172: ldc 106
    //   174: areturn
    //   175: astore_2
    //   176: goto -29 -> 147
    //   179: astore 4
    //   181: goto -83 -> 98
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	184	0	this	RecordAndChangeVoiceService
    //   0	184	1	paramString	String
    //   4	136	2	arrayOfByte1	byte[]
    //   144	12	2	localObject1	Object
    //   175	1	2	localObject2	Object
    //   24	95	3	localFileInputStream	java.io.FileInputStream
    //   1	88	4	arrayOfByte2	byte[]
    //   94	10	4	localThrowable1	java.lang.Throwable
    //   179	1	4	localThrowable2	java.lang.Throwable
    //   13	18	5	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   59	63	76	java/lang/Exception
    //   15	25	94	java/lang/Throwable
    //   118	122	127	java/lang/Exception
    //   15	25	144	finally
    //   151	155	157	java/lang/Exception
    //   30	40	175	finally
    //   45	52	175	finally
    //   100	112	175	finally
    //   30	40	179	java/lang/Throwable
    //   45	52	179	java/lang/Throwable
  }
  
  public void a() {}
  
  public void a(int paramInt)
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_JavaLangString = TraeHelper.a(BaseApplicationImpl.getContext());
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
      {
        QIPCClientHelper.getInstance().getClient().callServer("QzoneIPCModule", "startDownloadVoicechangeSo", null);
        QQToast.a(BaseApplicationImpl.getContext(), "变声功能准备中，请稍后再试", 1);
      }
    }
    while (this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams == null) {
      return;
    }
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams.f = paramInt;
    VoiceChangeManager.b(BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams, this.jdField_a_of_type_JavaLangString, this);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3) {}
  
  public void a(Intent paramIntent, int paramInt)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_b_of_type_JavaLangString = paramIntent.getStringExtra("key_record_path");
    this.jdField_a_of_type_Long = paramIntent.getLongExtra("key_record_time", 0L);
    int i = paramIntent.getIntExtra("key_record_param_sample_rate", 0);
    int j = paramIntent.getIntExtra("key_record_param_bit_rate", 0);
    int k = paramIntent.getIntExtra("key_record_param_audio_type", 0);
    if ((!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (this.jdField_a_of_type_Long > 0L))
    {
      this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams = new VoiceChangeBasicParams(this.jdField_b_of_type_JavaLangString, i, j, k, 0);
      switch (paramInt)
      {
      default: 
        return;
      case 0: 
        QZonePublishSecretShuoShuoH5Plugin.e();
        return;
      }
      QZonePublishVoiceShuoShuoH5Plugin.c();
      return;
    }
    QZonePublishSecretShuoShuoH5Plugin.f();
  }
  
  public void a(String paramString)
  {
    QZLog.d("RecordAndChangeVoiceService", 2, "getMoodVoiceRecordTime");
    if (this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams == null) {
      return;
    }
    if ((this.jdField_a_of_type_Int == 0) || ((this.jdField_a_of_type_Int != 0) && (this.jdField_b_of_type_Long == 0L)))
    {
      l = (this.jdField_a_of_type_Long + 500L) / 1000L;
      QZonePublishSecretShuoShuoH5Plugin.a(paramString, l);
      QZLog.d("RecordAndChangeVoiceService", 2, "onReplyGetMoodVoiceRecordTime: " + l);
      return;
    }
    long l = (this.jdField_b_of_type_Long + 500L) / 1000L;
    QZonePublishSecretShuoShuoH5Plugin.a(paramString, l);
    QZLog.d("RecordAndChangeVoiceService", 2, "onReplyGetMoodVoiceRecordTime: " + l);
  }
  
  public void a(String paramString, int paramInt)
  {
    QZLog.d("RecordAndChangeVoiceService", 2, "playMoodVoice voiceID: " + paramInt);
    if (paramInt == 3) {
      this.jdField_b_of_type_Long = (((float)this.jdField_a_of_type_Long / 0.6F));
    }
    for (;;)
    {
      long l = (this.jdField_b_of_type_Long + 500L) / 1000L;
      QZonePublishSecretShuoShuoH5Plugin.b(paramString, l);
      QZLog.d("RecordAndChangeVoiceService", 2, "onReplyPlayMoodVoice changeVoiceTime=" + this.jdField_b_of_type_Long + ", time = " + l);
      a(paramInt);
      return;
      if (paramInt == 4) {
        this.jdField_b_of_type_Long = (((float)this.jdField_a_of_type_Long * 0.5833333F));
      } else {
        this.jdField_b_of_type_Long = this.jdField_a_of_type_Long;
      }
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder("data:audio/amr;base64,");
      localStringBuilder.append(a(paramString));
      QZLog.d("RecordAndChangeVoiceService", 2, "base64=" + localStringBuilder.toString());
      QZonePublishSecretShuoShuoH5Plugin.a(this.c, localStringBuilder.toString());
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void b() {}
  
  public void b(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_JavaLangString = TraeHelper.a(BaseApplicationImpl.getContext());
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
      {
        QIPCClientHelper.getInstance().getClient().callServer("QzoneIPCModule", "startDownloadVoicechangeSo", null);
        QQToast.a(BaseApplicationImpl.getContext(), "变声功能准备中，请稍后再试", 1);
      }
      return;
    }
    QZLog.d("RecordAndChangeVoiceService", 2, "getMoodVoiceData callback" + paramString + " voiceID " + paramInt);
    this.c = paramString;
    VoiceChangeManager.a(BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams, this.jdField_a_of_type_JavaLangString, this);
    VoiceChangeManager.a(this.jdField_b_of_type_JavaLangString, this);
  }
  
  public void c() {}
  
  public void d()
  {
    QZLog.d("RecordAndChangeVoiceService", 2, "stopPlayingMoodVoice");
    if (this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams != null) {
      VoiceChangeManager.b(this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams);
    }
  }
  
  public void e()
  {
    this.jdField_b_of_type_JavaLangString = null;
    this.c = null;
    this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams = null;
    this.jdField_a_of_type_Long = -1L;
    this.jdField_b_of_type_Long = -1L;
    this.jdField_a_of_type_Int = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.RecordAndChangeVoiceService
 * JD-Core Version:    0.7.0.1
 */