import android.app.Activity;
import android.os.AsyncTask;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.shortvideo.util.AudioEncoder;
import com.tencent.mobileqq.shortvideo.util.AudioEncoder.AudioData;
import com.tencent.mobileqq.transfile.QIMWebVideoUploader.IQIMWebVideoUpCallback;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import dov.com.tencent.mobileqq.richmedia.capture.activity.EditWebDanceMachineVideoActivity;
import dov.com.tencent.mobileqq.shortvideo.util.HwVideoMerge;
import java.io.File;
import java.lang.ref.WeakReference;

public class aoli
  extends AsyncTask
{
  int jdField_a_of_type_Int;
  Activity jdField_a_of_type_AndroidAppActivity;
  QIMWebVideoUploader.IQIMWebVideoUpCallback jdField_a_of_type_ComTencentMobileqqTransfileQIMWebVideoUploader$IQIMWebVideoUpCallback;
  String jdField_a_of_type_JavaLangString;
  public WeakReference a;
  String b;
  
  public aoli(EditWebDanceMachineVideoActivity paramEditWebDanceMachineVideoActivity, Activity paramActivity, String paramString1, String paramString2, int paramInt, AppInterface paramAppInterface, QIMWebVideoUploader.IQIMWebVideoUpCallback paramIQIMWebVideoUpCallback)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.b = paramString1;
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqTransfileQIMWebVideoUploader$IQIMWebVideoUpCallback = paramIQIMWebVideoUpCallback;
  }
  
  private int a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if ((paramString2 == null) || ("".equals(paramString2))) {
      return 0;
    }
    if ((paramString1 == null) || ("".equals(paramString1))) {
      return -1;
    }
    paramString4 = paramString1 + File.separator + paramString4 + "_target.mp4";
    paramString1 = paramString1 + File.separator + "mc_audio.mp4";
    Object localObject = new File(paramString1);
    if (((File)localObject).exists()) {
      ((File)localObject).delete();
    }
    localObject = AudioEncoder.a(null, null, 0);
    ((AudioEncoder.AudioData)localObject).b = paramString1;
    ((AudioEncoder.AudioData)localObject).jdField_a_of_type_JavaLangString = paramString2;
    int i = AudioEncoder.a(paramString2);
    if (i != 0) {
      a("checkSourceAudioIsOK: errcode=" + i, null);
    }
    for (;;)
    {
      return 0;
      long l = System.currentTimeMillis();
      i = AudioEncoder.a((AudioEncoder.AudioData)localObject);
      a("AudioEncoder.encodeSafely:time=" + (System.currentTimeMillis() - l) / 1000.0D, null);
      if (i != 0)
      {
        a("AudioEncoder.encodeSafely: errcode=" + i, null);
        return i;
      }
      paramString2 = new File(paramString1);
      if (!paramString2.exists())
      {
        a("AudioEncoder.encodeSafely: exists = false", null);
      }
      else
      {
        i = HwVideoMerge.a(paramString3, paramString1, paramString4, 0);
        paramString2.delete();
        if (i != 0)
        {
          a("HwVideoMerge.merge: errcode=" + i, null);
          return i;
        }
        this.jdField_a_of_type_JavaLangString = paramString4;
      }
    }
  }
  
  private void a(String paramString, Throwable paramThrowable)
  {
    if (QLog.isColorLevel())
    {
      if (paramThrowable != null) {
        QLog.e("DANCE_MACHINE_SHARE_TAG", 2, "[@] " + paramString, paramThrowable);
      }
    }
    else {
      return;
    }
    QLog.d("DANCE_MACHINE_SHARE_TAG", 2, "[@] " + paramString);
  }
  
  /* Error */
  protected Integer a(java.lang.Void... paramVarArgs)
  {
    // Byte code:
    //   0: new 55	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: getfield 25	aoli:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   8: invokespecial 69	java/io/File:<init>	(Ljava/lang/String;)V
    //   11: astore 8
    //   13: aload 8
    //   15: invokevirtual 154	java/io/File:getParent	()Ljava/lang/String;
    //   18: astore_1
    //   19: aload 8
    //   21: invokevirtual 157	java/io/File:getName	()Ljava/lang/String;
    //   24: astore 8
    //   26: aload_0
    //   27: aload_1
    //   28: aload_0
    //   29: getfield 23	aoli:b	Ljava/lang/String;
    //   32: aload_0
    //   33: getfield 25	aoli:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   36: aload 8
    //   38: invokespecial 159	aoli:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    //   41: istore_2
    //   42: iload_2
    //   43: ifeq +12 -> 55
    //   46: iload_2
    //   47: invokestatic 165	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   50: astore 8
    //   52: aload 8
    //   54: areturn
    //   55: aload_0
    //   56: getfield 25	aoli:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   59: astore 10
    //   61: aload 10
    //   63: invokestatic 170	com/tencent/mobileqq/utils/FileUtils:b	(Ljava/lang/String;)Z
    //   66: ifne +22 -> 88
    //   69: invokestatic 128	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   72: ifeq +11 -> 83
    //   75: ldc 130
    //   77: iconst_2
    //   78: ldc 172
    //   80: invokestatic 174	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   83: iconst_m1
    //   84: invokestatic 165	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   87: areturn
    //   88: new 55	java/io/File
    //   91: dup
    //   92: aload 10
    //   94: invokespecial 69	java/io/File:<init>	(Ljava/lang/String;)V
    //   97: astore_1
    //   98: aload_1
    //   99: invokevirtual 177	java/io/File:length	()J
    //   102: lstore_3
    //   103: lload_3
    //   104: lconst_0
    //   105: lcmp
    //   106: ifne +22 -> 128
    //   109: invokestatic 128	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   112: ifeq +11 -> 123
    //   115: ldc 130
    //   117: iconst_2
    //   118: ldc 179
    //   120: invokestatic 174	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   123: iconst_m1
    //   124: invokestatic 165	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   127: areturn
    //   128: new 181	java/io/FileInputStream
    //   131: dup
    //   132: aload_1
    //   133: invokespecial 184	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   136: astore_1
    //   137: aload_1
    //   138: astore 8
    //   140: aload_1
    //   141: lload_3
    //   142: invokestatic 190	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   145: astore 12
    //   147: aload_1
    //   148: astore 8
    //   150: aload 12
    //   152: invokestatic 195	com/tencent/mobileqq/utils/HexUtil:a	([B)Ljava/lang/String;
    //   155: astore 11
    //   157: aload_1
    //   158: astore 8
    //   160: aload 11
    //   162: invokestatic 201	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   165: ifeq +70 -> 235
    //   168: aload_1
    //   169: astore 8
    //   171: invokestatic 128	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   174: ifeq +32 -> 206
    //   177: aload_1
    //   178: astore 8
    //   180: ldc 130
    //   182: iconst_2
    //   183: new 48	java/lang/StringBuilder
    //   186: dup
    //   187: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   190: ldc 203
    //   192: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: aload 11
    //   197: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   203: invokestatic 174	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   206: iconst_m1
    //   207: invokestatic 165	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   210: astore 9
    //   212: aload 9
    //   214: astore 8
    //   216: aload_1
    //   217: ifnull -165 -> 52
    //   220: aload_1
    //   221: invokevirtual 206	java/io/FileInputStream:close	()V
    //   224: aload 9
    //   226: areturn
    //   227: astore_1
    //   228: aload_1
    //   229: invokevirtual 209	java/io/IOException:printStackTrace	()V
    //   232: aload 9
    //   234: areturn
    //   235: aload_1
    //   236: ifnull +7 -> 243
    //   239: aload_1
    //   240: invokevirtual 206	java/io/FileInputStream:close	()V
    //   243: new 211	android/media/MediaMetadataRetriever
    //   246: dup
    //   247: invokespecial 212	android/media/MediaMetadataRetriever:<init>	()V
    //   250: astore 9
    //   252: aload 9
    //   254: aload 10
    //   256: invokevirtual 215	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   259: lconst_0
    //   260: lstore 5
    //   262: aload 9
    //   264: bipush 9
    //   266: invokevirtual 219	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   269: astore 8
    //   271: aload 8
    //   273: ifnull +13 -> 286
    //   276: aload 8
    //   278: invokestatic 224	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   281: invokevirtual 227	java/lang/Long:longValue	()J
    //   284: lstore 5
    //   286: lload 5
    //   288: lstore_3
    //   289: aload_0
    //   290: getfield 16	aoli:jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureActivityEditWebDanceMachineVideoActivity	Ldov/com/tencent/mobileqq/richmedia/capture/activity/EditWebDanceMachineVideoActivity;
    //   293: invokestatic 232	dov/com/tencent/mobileqq/richmedia/capture/activity/EditWebDanceMachineVideoActivity:a	(Ldov/com/tencent/mobileqq/richmedia/capture/activity/EditWebDanceMachineVideoActivity;)Z
    //   296: ifne +29 -> 325
    //   299: lload 5
    //   301: lstore_3
    //   302: aload_0
    //   303: getfield 16	aoli:jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureActivityEditWebDanceMachineVideoActivity	Ldov/com/tencent/mobileqq/richmedia/capture/activity/EditWebDanceMachineVideoActivity;
    //   306: invokestatic 234	dov/com/tencent/mobileqq/richmedia/capture/activity/EditWebDanceMachineVideoActivity:b	(Ldov/com/tencent/mobileqq/richmedia/capture/activity/EditWebDanceMachineVideoActivity;)Z
    //   309: ifne +16 -> 325
    //   312: lload 5
    //   314: ldc2_w 235
    //   317: lcmp
    //   318: ifle +193 -> 511
    //   321: ldc2_w 235
    //   324: lstore_3
    //   325: invokestatic 128	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   328: ifeq +38 -> 366
    //   331: ldc 130
    //   333: iconst_2
    //   334: new 48	java/lang/StringBuilder
    //   337: dup
    //   338: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   341: ldc 238
    //   343: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: aload 8
    //   348: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   351: ldc 240
    //   353: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: lload_3
    //   357: invokevirtual 243	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   360: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   363: invokestatic 246	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   366: aload 9
    //   368: lload_3
    //   369: ldc2_w 247
    //   372: lmul
    //   373: invokevirtual 252	android/media/MediaMetadataRetriever:getFrameAtTime	(J)Landroid/graphics/Bitmap;
    //   376: astore 8
    //   378: aload 9
    //   380: invokevirtual 255	android/media/MediaMetadataRetriever:release	()V
    //   383: aload 8
    //   385: ifnonnull +184 -> 569
    //   388: iconst_m1
    //   389: invokestatic 165	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   392: areturn
    //   393: astore 8
    //   395: aload 8
    //   397: invokevirtual 209	java/io/IOException:printStackTrace	()V
    //   400: goto -157 -> 243
    //   403: astore 9
    //   405: aconst_null
    //   406: astore_1
    //   407: aload_1
    //   408: astore 8
    //   410: aload 9
    //   412: invokevirtual 256	java/io/FileNotFoundException:printStackTrace	()V
    //   415: aconst_null
    //   416: astore_1
    //   417: iconst_m1
    //   418: invokestatic 165	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   421: astore_1
    //   422: aload_1
    //   423: astore 8
    //   425: iconst_0
    //   426: ifeq -374 -> 52
    //   429: new 258	java/lang/NullPointerException
    //   432: dup
    //   433: invokespecial 259	java/lang/NullPointerException:<init>	()V
    //   436: athrow
    //   437: astore 8
    //   439: aload 8
    //   441: invokevirtual 209	java/io/IOException:printStackTrace	()V
    //   444: aload_1
    //   445: areturn
    //   446: astore_1
    //   447: aconst_null
    //   448: astore 8
    //   450: aload 8
    //   452: ifnull +8 -> 460
    //   455: aload 8
    //   457: invokevirtual 206	java/io/FileInputStream:close	()V
    //   460: aload_1
    //   461: athrow
    //   462: astore 8
    //   464: aload 8
    //   466: invokevirtual 209	java/io/IOException:printStackTrace	()V
    //   469: goto -9 -> 460
    //   472: astore_1
    //   473: invokestatic 128	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   476: ifeq +30 -> 506
    //   479: ldc 130
    //   481: iconst_2
    //   482: new 48	java/lang/StringBuilder
    //   485: dup
    //   486: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   489: ldc_w 261
    //   492: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   495: aload 10
    //   497: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   500: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   503: invokestatic 174	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   506: iconst_m1
    //   507: invokestatic 165	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   510: areturn
    //   511: lconst_0
    //   512: lstore_3
    //   513: goto -188 -> 325
    //   516: astore_1
    //   517: invokestatic 128	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   520: ifeq +13 -> 533
    //   523: ldc 130
    //   525: iconst_2
    //   526: ldc_w 263
    //   529: aload_1
    //   530: invokestatic 136	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   533: aload 9
    //   535: invokevirtual 255	android/media/MediaMetadataRetriever:release	()V
    //   538: iconst_m1
    //   539: invokestatic 165	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   542: areturn
    //   543: astore 8
    //   545: aload 8
    //   547: invokevirtual 264	java/lang/Exception:printStackTrace	()V
    //   550: aload 9
    //   552: invokevirtual 255	android/media/MediaMetadataRetriever:release	()V
    //   555: aconst_null
    //   556: astore 8
    //   558: goto -175 -> 383
    //   561: astore_1
    //   562: aload 9
    //   564: invokevirtual 255	android/media/MediaMetadataRetriever:release	()V
    //   567: aload_1
    //   568: athrow
    //   569: iconst_2
    //   570: iconst_2
    //   571: invokestatic 268	dov/com/tencent/biz/qqstory/takevideo/publish/PublishFileManager:a	(I)Ljava/lang/String;
    //   574: ldc_w 270
    //   577: invokestatic 273	dov/com/tencent/biz/qqstory/takevideo/publish/PublishFileManager:a	(ILjava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   580: astore 13
    //   582: aload 8
    //   584: getstatic 279	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   587: bipush 100
    //   589: aload 13
    //   591: invokestatic 284	com/tencent/biz/qqstory/utils/BitmapUtils:a	(Landroid/graphics/Bitmap;Landroid/graphics/Bitmap$CompressFormat;ILjava/lang/String;)Z
    //   594: istore 7
    //   596: aload 8
    //   598: invokevirtual 289	android/graphics/Bitmap:recycle	()V
    //   601: iload 7
    //   603: ifne +23 -> 626
    //   606: invokestatic 128	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   609: ifeq +12 -> 621
    //   612: ldc 130
    //   614: iconst_2
    //   615: ldc_w 291
    //   618: invokestatic 140	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   621: iconst_m1
    //   622: invokestatic 165	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   625: areturn
    //   626: new 55	java/io/File
    //   629: dup
    //   630: aload 13
    //   632: invokespecial 69	java/io/File:<init>	(Ljava/lang/String;)V
    //   635: astore 8
    //   637: aload 8
    //   639: invokevirtual 73	java/io/File:exists	()Z
    //   642: ifeq +102 -> 744
    //   645: aload 8
    //   647: invokevirtual 294	java/io/File:isFile	()Z
    //   650: ifeq +94 -> 744
    //   653: invokestatic 128	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   656: ifeq +30 -> 686
    //   659: ldc 130
    //   661: iconst_2
    //   662: new 48	java/lang/StringBuilder
    //   665: dup
    //   666: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   669: ldc_w 296
    //   672: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   675: aload 13
    //   677: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   680: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   683: invokestatic 140	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   686: new 181	java/io/FileInputStream
    //   689: dup
    //   690: aload 13
    //   692: invokespecial 297	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   695: astore 9
    //   697: aload 9
    //   699: astore 8
    //   701: aload 9
    //   703: new 55	java/io/File
    //   706: dup
    //   707: aload 13
    //   709: invokespecial 69	java/io/File:<init>	(Ljava/lang/String;)V
    //   712: invokevirtual 177	java/io/File:length	()J
    //   715: invokestatic 190	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   718: astore_1
    //   719: aload 9
    //   721: ifnull +8 -> 729
    //   724: aload 9
    //   726: invokevirtual 206	java/io/FileInputStream:close	()V
    //   729: aload_0
    //   730: getfield 34	aoli:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   733: invokevirtual 301	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   736: ifnonnull +106 -> 842
    //   739: iconst_m1
    //   740: invokestatic 165	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   743: areturn
    //   744: invokestatic 128	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   747: ifeq +12 -> 759
    //   750: ldc 130
    //   752: iconst_2
    //   753: ldc_w 303
    //   756: invokestatic 140	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   759: iconst_m1
    //   760: invokestatic 165	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   763: areturn
    //   764: astore 8
    //   766: aload 8
    //   768: invokevirtual 209	java/io/IOException:printStackTrace	()V
    //   771: goto -42 -> 729
    //   774: astore 8
    //   776: aload 8
    //   778: invokevirtual 209	java/io/IOException:printStackTrace	()V
    //   781: aconst_null
    //   782: astore_1
    //   783: iconst_m1
    //   784: invokestatic 165	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   787: astore_1
    //   788: aload_1
    //   789: astore 8
    //   791: iconst_0
    //   792: ifeq -740 -> 52
    //   795: new 258	java/lang/NullPointerException
    //   798: dup
    //   799: invokespecial 259	java/lang/NullPointerException:<init>	()V
    //   802: athrow
    //   803: astore 8
    //   805: aload 8
    //   807: invokevirtual 209	java/io/IOException:printStackTrace	()V
    //   810: aload_1
    //   811: areturn
    //   812: astore 9
    //   814: aload_1
    //   815: astore 8
    //   817: aload 9
    //   819: astore_1
    //   820: aload 8
    //   822: ifnull +8 -> 830
    //   825: aload 8
    //   827: invokevirtual 206	java/io/FileInputStream:close	()V
    //   830: aload_1
    //   831: athrow
    //   832: astore 8
    //   834: aload 8
    //   836: invokevirtual 209	java/io/IOException:printStackTrace	()V
    //   839: goto -9 -> 830
    //   842: aload_0
    //   843: getfield 16	aoli:jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureActivityEditWebDanceMachineVideoActivity	Ldov/com/tencent/mobileqq/richmedia/capture/activity/EditWebDanceMachineVideoActivity;
    //   846: aload 11
    //   848: invokestatic 306	dov/com/tencent/mobileqq/richmedia/capture/activity/EditWebDanceMachineVideoActivity:a	(Ldov/com/tencent/mobileqq/richmedia/capture/activity/EditWebDanceMachineVideoActivity;Ljava/lang/String;)Ljava/lang/String;
    //   851: pop
    //   852: aload_0
    //   853: getfield 16	aoli:jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureActivityEditWebDanceMachineVideoActivity	Ldov/com/tencent/mobileqq/richmedia/capture/activity/EditWebDanceMachineVideoActivity;
    //   856: aload_1
    //   857: invokestatic 309	dov/com/tencent/mobileqq/richmedia/capture/activity/EditWebDanceMachineVideoActivity:a	(Ldov/com/tencent/mobileqq/richmedia/capture/activity/EditWebDanceMachineVideoActivity;[B)[B
    //   860: pop
    //   861: aload_0
    //   862: getfield 16	aoli:jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureActivityEditWebDanceMachineVideoActivity	Ldov/com/tencent/mobileqq/richmedia/capture/activity/EditWebDanceMachineVideoActivity;
    //   865: aload 13
    //   867: invokestatic 311	dov/com/tencent/mobileqq/richmedia/capture/activity/EditWebDanceMachineVideoActivity:b	(Ldov/com/tencent/mobileqq/richmedia/capture/activity/EditWebDanceMachineVideoActivity;Ljava/lang/String;)Ljava/lang/String;
    //   870: pop
    //   871: aload_0
    //   872: getfield 16	aoli:jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureActivityEditWebDanceMachineVideoActivity	Ldov/com/tencent/mobileqq/richmedia/capture/activity/EditWebDanceMachineVideoActivity;
    //   875: aload_0
    //   876: getfield 27	aoli:jdField_a_of_type_Int	I
    //   879: invokestatic 314	dov/com/tencent/mobileqq/richmedia/capture/activity/EditWebDanceMachineVideoActivity:a	(Ldov/com/tencent/mobileqq/richmedia/capture/activity/EditWebDanceMachineVideoActivity;I)I
    //   882: pop
    //   883: aload_0
    //   884: getfield 16	aoli:jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureActivityEditWebDanceMachineVideoActivity	Ldov/com/tencent/mobileqq/richmedia/capture/activity/EditWebDanceMachineVideoActivity;
    //   887: invokestatic 317	dov/com/tencent/mobileqq/richmedia/capture/activity/EditWebDanceMachineVideoActivity:a	(Ldov/com/tencent/mobileqq/richmedia/capture/activity/EditWebDanceMachineVideoActivity;)Lcom/tencent/mobileqq/transfile/QIMWebVideoUploader;
    //   890: ifnonnull +40 -> 930
    //   893: aload_0
    //   894: getfield 16	aoli:jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureActivityEditWebDanceMachineVideoActivity	Ldov/com/tencent/mobileqq/richmedia/capture/activity/EditWebDanceMachineVideoActivity;
    //   897: new 319	com/tencent/mobileqq/transfile/QIMWebVideoUploader
    //   900: dup
    //   901: aload_0
    //   902: getfield 34	aoli:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   905: invokevirtual 301	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   908: checkcast 321	com/tencent/common/app/AppInterface
    //   911: aload_0
    //   912: getfield 36	aoli:jdField_a_of_type_ComTencentMobileqqTransfileQIMWebVideoUploader$IQIMWebVideoUpCallback	Lcom/tencent/mobileqq/transfile/QIMWebVideoUploader$IQIMWebVideoUpCallback;
    //   915: aload 10
    //   917: aload 12
    //   919: getstatic 325	com/tencent/mobileqq/activity/richmedia/FlowCameraConstant:b	I
    //   922: iconst_0
    //   923: invokespecial 328	com/tencent/mobileqq/transfile/QIMWebVideoUploader:<init>	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/mobileqq/transfile/QIMWebVideoUploader$IQIMWebVideoUpCallback;Ljava/lang/String;[BIZ)V
    //   926: invokestatic 331	dov/com/tencent/mobileqq/richmedia/capture/activity/EditWebDanceMachineVideoActivity:a	(Ldov/com/tencent/mobileqq/richmedia/capture/activity/EditWebDanceMachineVideoActivity;Lcom/tencent/mobileqq/transfile/QIMWebVideoUploader;)Lcom/tencent/mobileqq/transfile/QIMWebVideoUploader;
    //   929: pop
    //   930: aload_0
    //   931: getfield 16	aoli:jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureActivityEditWebDanceMachineVideoActivity	Ldov/com/tencent/mobileqq/richmedia/capture/activity/EditWebDanceMachineVideoActivity;
    //   934: invokestatic 317	dov/com/tencent/mobileqq/richmedia/capture/activity/EditWebDanceMachineVideoActivity:a	(Ldov/com/tencent/mobileqq/richmedia/capture/activity/EditWebDanceMachineVideoActivity;)Lcom/tencent/mobileqq/transfile/QIMWebVideoUploader;
    //   937: invokevirtual 333	com/tencent/mobileqq/transfile/QIMWebVideoUploader:a	()Z
    //   940: pop
    //   941: aload_0
    //   942: getfield 16	aoli:jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureActivityEditWebDanceMachineVideoActivity	Ldov/com/tencent/mobileqq/richmedia/capture/activity/EditWebDanceMachineVideoActivity;
    //   945: invokestatic 336	dov/com/tencent/mobileqq/richmedia/capture/activity/EditWebDanceMachineVideoActivity:a	(Ldov/com/tencent/mobileqq/richmedia/capture/activity/EditWebDanceMachineVideoActivity;)Lcom/tencent/util/MqqWeakReferenceHandler;
    //   948: iconst_m1
    //   949: ldc2_w 337
    //   952: invokevirtual 344	com/tencent/util/MqqWeakReferenceHandler:sendEmptyMessageDelayed	(IJ)Z
    //   955: pop
    //   956: aload_0
    //   957: getfield 16	aoli:jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureActivityEditWebDanceMachineVideoActivity	Ldov/com/tencent/mobileqq/richmedia/capture/activity/EditWebDanceMachineVideoActivity;
    //   960: invokestatic 349	android/os/SystemClock:elapsedRealtime	()J
    //   963: invokestatic 352	dov/com/tencent/mobileqq/richmedia/capture/activity/EditWebDanceMachineVideoActivity:a	(Ldov/com/tencent/mobileqq/richmedia/capture/activity/EditWebDanceMachineVideoActivity;J)J
    //   966: pop2
    //   967: iconst_0
    //   968: invokestatic 165	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   971: areturn
    //   972: astore_1
    //   973: goto -153 -> 820
    //   976: astore 9
    //   978: aload_1
    //   979: astore 8
    //   981: aload 9
    //   983: astore_1
    //   984: goto -164 -> 820
    //   987: astore 8
    //   989: aload 9
    //   991: astore_1
    //   992: goto -216 -> 776
    //   995: astore_1
    //   996: goto -546 -> 450
    //   999: astore 9
    //   1001: goto -594 -> 407
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1004	0	this	aoli
    //   0	1004	1	paramVarArgs	java.lang.Void[]
    //   41	6	2	i	int
    //   102	411	3	l1	long
    //   260	53	5	l2	long
    //   594	8	7	bool	boolean
    //   11	373	8	localObject1	Object
    //   393	3	8	localIOException1	java.io.IOException
    //   408	16	8	arrayOfVoid1	java.lang.Void[]
    //   437	3	8	localIOException2	java.io.IOException
    //   448	8	8	localObject2	Object
    //   462	3	8	localIOException3	java.io.IOException
    //   543	3	8	localException	java.lang.Exception
    //   556	144	8	localObject3	Object
    //   764	3	8	localIOException4	java.io.IOException
    //   774	3	8	localIOException5	java.io.IOException
    //   789	1	8	arrayOfVoid2	java.lang.Void[]
    //   803	3	8	localIOException6	java.io.IOException
    //   815	11	8	arrayOfVoid3	java.lang.Void[]
    //   832	3	8	localIOException7	java.io.IOException
    //   979	1	8	arrayOfVoid4	java.lang.Void[]
    //   987	1	8	localIOException8	java.io.IOException
    //   210	169	9	localObject4	Object
    //   403	160	9	localFileNotFoundException1	java.io.FileNotFoundException
    //   695	30	9	localFileInputStream	java.io.FileInputStream
    //   812	6	9	localObject5	Object
    //   976	14	9	localObject6	Object
    //   999	1	9	localFileNotFoundException2	java.io.FileNotFoundException
    //   59	857	10	str1	String
    //   155	692	11	str2	String
    //   145	773	12	arrayOfByte	byte[]
    //   580	286	13	str3	String
    // Exception table:
    //   from	to	target	type
    //   220	224	227	java/io/IOException
    //   239	243	393	java/io/IOException
    //   128	137	403	java/io/FileNotFoundException
    //   429	437	437	java/io/IOException
    //   128	137	446	finally
    //   455	460	462	java/io/IOException
    //   252	259	472	java/lang/IllegalArgumentException
    //   276	286	516	java/lang/OutOfMemoryError
    //   289	299	516	java/lang/OutOfMemoryError
    //   302	312	516	java/lang/OutOfMemoryError
    //   325	366	516	java/lang/OutOfMemoryError
    //   366	378	516	java/lang/OutOfMemoryError
    //   276	286	543	java/lang/Exception
    //   289	299	543	java/lang/Exception
    //   302	312	543	java/lang/Exception
    //   325	366	543	java/lang/Exception
    //   366	378	543	java/lang/Exception
    //   276	286	561	finally
    //   289	299	561	finally
    //   302	312	561	finally
    //   325	366	561	finally
    //   366	378	561	finally
    //   517	533	561	finally
    //   545	550	561	finally
    //   724	729	764	java/io/IOException
    //   686	697	774	java/io/IOException
    //   795	803	803	java/io/IOException
    //   686	697	812	finally
    //   825	830	832	java/io/IOException
    //   701	719	972	finally
    //   776	781	976	finally
    //   701	719	987	java/io/IOException
    //   140	147	995	finally
    //   150	157	995	finally
    //   160	168	995	finally
    //   171	177	995	finally
    //   180	206	995	finally
    //   410	415	995	finally
    //   140	147	999	java/io/FileNotFoundException
    //   150	157	999	java/io/FileNotFoundException
    //   160	168	999	java/io/FileNotFoundException
    //   171	177	999	java/io/FileNotFoundException
    //   180	206	999	java/io/FileNotFoundException
  }
  
  protected void a(Integer paramInteger)
  {
    if (paramInteger.intValue() != 0)
    {
      EditWebDanceMachineVideoActivity.a(this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureActivityEditWebDanceMachineVideoActivity);
      EditWebDanceMachineVideoActivity.a(this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureActivityEditWebDanceMachineVideoActivity).removeMessages(-1);
    }
  }
  
  protected void onPreExecute()
  {
    EditWebDanceMachineVideoActivity.a(this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureActivityEditWebDanceMachineVideoActivity, this.jdField_a_of_type_AndroidAppActivity, 2131437032);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aoli
 * JD-Core Version:    0.7.0.1
 */