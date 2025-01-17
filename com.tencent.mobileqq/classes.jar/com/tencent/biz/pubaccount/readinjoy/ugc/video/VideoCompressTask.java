package com.tencent.biz.pubaccount.readinjoy.ugc.video;

import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyConstants;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.mediacodec.ShortVideoCodec;
import com.tencent.mobileqq.shortvideo.util.ShortVideoTrimmer;
import com.tencent.mobileqq.shortvideo.util.ShortVideoTrimmer.CompressConfig;
import com.tencent.mobileqq.shortvideo.util.videoconverter.VideoConverter;
import com.tencent.mobileqq.shortvideo.util.videoconverter.VideoConverter.Processor;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.io.File;
import java.util.HashMap;
import lzj;

public class VideoCompressTask
  extends AsyncTask
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  public VideoCompressTask.VideoCompressTaskListener a;
  private Long jdField_a_of_type_JavaLangLong = Long.valueOf(0L);
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private Long jdField_b_of_type_JavaLangLong = Long.valueOf(0L);
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private Long jdField_c_of_type_JavaLangLong = Long.valueOf(0L);
  private String jdField_c_of_type_JavaLangString;
  private Long jdField_d_of_type_JavaLangLong = Long.valueOf(0L);
  private String jdField_d_of_type_JavaLangString;
  
  public VideoCompressTask(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, VideoCompressTask.VideoCompressTaskListener paramVideoCompressTaskListener)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.jdField_b_of_type_Boolean = paramBoolean2;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcVideoVideoCompressTask$VideoCompressTaskListener = paramVideoCompressTaskListener;
  }
  
  private static int a(int paramInt1, int paramInt2)
  {
    int j = 1280;
    int i;
    if (paramInt1 <= paramInt2)
    {
      i = ReadInJoyConstants.c;
      paramInt1 = ReadInJoyHelper.y(BaseApplicationImpl.getApplication().getRuntime());
      if (paramInt1 <= 0) {
        break label80;
      }
      i = paramInt1;
    }
    label80:
    for (;;)
    {
      if (paramInt2 >= 1280) {
        paramInt1 = j;
      }
      for (;;)
      {
        float f = i * 1.0F / 640.0F;
        return (int)(paramInt1 * f);
        paramInt2 = paramInt1;
        break;
        if (paramInt2 >= 960) {
          paramInt1 = 960;
        } else {
          paramInt1 = 640;
        }
      }
    }
  }
  
  private HashMap a(String paramString, Context paramContext)
  {
    HashMap localHashMap = new HashMap();
    String str2 = ShortVideoUtils.c(paramString, paramString.substring(paramString.lastIndexOf(".") + 1));
    ShortVideoTrimmer.CompressConfig localCompressConfig = ShortVideoTrimmer.a(paramString);
    long l1;
    int i;
    if ((localCompressConfig != null) && (localCompressConfig.jdField_a_of_type_Boolean))
    {
      l1 = new File(paramString).length();
      i = a(localCompressConfig.jdField_a_of_type_Int, localCompressConfig.jdField_b_of_type_Int);
      if ((l1 <= 52428800L) && (i > 0) && (localCompressConfig.jdField_b_of_type_Long * 1024L / i < 1.3D))
      {
        localCompressConfig.jdField_a_of_type_Boolean = false;
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyUploadVideoCompressTask", 2, "CompressTask, fileSize:" + l1 + ", no need compress!");
        }
      }
    }
    Object localObject1;
    Object localObject2;
    long l2;
    if ((localCompressConfig != null) && (localCompressConfig.jdField_a_of_type_Boolean)) {
      if (Build.VERSION.SDK_INT >= 18)
      {
        localObject1 = new MediaMetadataRetriever();
        ((MediaMetadataRetriever)localObject1).setDataSource(paramString);
        localObject2 = ((MediaMetadataRetriever)localObject1).extractMetadata(9);
        ((MediaMetadataRetriever)localObject1).release();
        l2 = 0L;
      }
    }
    for (;;)
    {
      try
      {
        l1 = Long.parseLong((String)localObject2);
        i = ShortVideoCodec.b(paramContext);
        if (((i & 0x1) > 0) && ((i & 0x2) > 0))
        {
          bool = true;
          if (QLog.isColorLevel()) {
            QLog.d("ReadInJoyUploadVideoCompressTask", 2, "CompressTask, step: isHWCodecSupported = " + bool);
          }
          if (!bool) {
            break label558;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ReadInJoyUploadVideoCompressTask", 2, "CompressTask, step: Try to compress using MediaCodec");
          }
          localObject1 = new File(paramString);
          localObject2 = new lzj(this, str2, (int)(localCompressConfig.jdField_b_of_type_Long * 1024L), (int)localCompressConfig.jdField_a_of_type_Long, 0L, l1);
          if ((!new VideoConverter().a((File)localObject1, (VideoConverter.Processor)localObject2, true)) || (((lzj)localObject2).a != null)) {
            continue;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ReadInJoyUploadVideoCompressTask", 2, "CompressTask, step: compress completed using MediaCodec");
          }
          j = 0;
          i = j;
          localObject1 = str2;
          if (j != 0)
          {
            i = j;
            localObject1 = str2;
            if (!TextUtils.isEmpty(str2))
            {
              if (QLog.isColorLevel()) {
                QLog.d("ReadInJoyUploadVideoCompressTask", 2, "CompressTask, step: Try to compress using ShortVideoTrimmer.compressVideo");
              }
              i = ShortVideoTrimmer.a(paramContext, paramString, str2);
              localObject1 = str2;
            }
          }
          localHashMap.put("outputPath", localObject1);
          localHashMap.put("ret", String.valueOf(i));
          if (localCompressConfig != null)
          {
            j = 0;
            if ((!"90".equals(localCompressConfig.jdField_a_of_type_JavaLangString)) && (!"270".equals(localCompressConfig.jdField_a_of_type_JavaLangString))) {
              break label585;
            }
            i = 1;
            if (i == 0) {
              break label647;
            }
            localHashMap.put("outWidth", String.valueOf(localCompressConfig.d));
            localHashMap.put("outHeight", String.valueOf(localCompressConfig.c));
          }
          return localHashMap;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        l1 = l2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        localNumberFormatException.printStackTrace();
        l1 = l2;
        continue;
        boolean bool = false;
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyUploadVideoCompressTask", 2, "CompressTask, step: compress failed using MediaCodecr");
        }
      }
      label558:
      int j = -1;
      continue;
      String str1;
      if ((localCompressConfig != null) && (!localCompressConfig.jdField_a_of_type_Boolean))
      {
        i = 0;
        str1 = paramString;
        continue;
        label585:
        i = j;
        if ("0".equals(localCompressConfig.jdField_a_of_type_JavaLangString))
        {
          paramString = ShortVideoTrimmer.a(paramString);
          i = j;
          if (paramString != null)
          {
            i = j;
            if (paramString.length == 5) {
              if (paramString[3] != 90)
              {
                i = j;
                if (paramString[3] != 270) {}
              }
              else
              {
                i = 1;
                continue;
                label647:
                localHashMap.put("outWidth", String.valueOf(localCompressConfig.c));
                localHashMap.put("outHeight", String.valueOf(localCompressConfig.d));
                return localHashMap;
              }
            }
          }
        }
      }
      else
      {
        i = -1;
        str1 = str2;
      }
    }
  }
  
  private void a(int paramInt)
  {
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(paramInt));
    localHashMap.put("video_size_before_compression", this.jdField_a_of_type_JavaLangLong.toString());
    localHashMap.put("source_video_bitrate", this.jdField_c_of_type_JavaLangLong.toString());
    localHashMap.put("target_video_bitrate", this.jdField_d_of_type_JavaLangLong.toString());
    StatisticCollector localStatisticCollector = StatisticCollector.a(this.jdField_a_of_type_AndroidContentContext);
    String str = ReadInJoyUtils.a();
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      localStatisticCollector.a(str, "actReadInJoyDeliverVideoCompressVideo", bool, this.jdField_b_of_type_Long - this.jdField_a_of_type_Long, 0L, localHashMap, "");
      return;
    }
  }
  
  protected Integer a(String... paramVarArgs)
  {
    int j = 1;
    paramVarArgs = paramVarArgs[0];
    if ((TextUtils.isEmpty(paramVarArgs)) || (this.jdField_a_of_type_AndroidContentContext == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyUploadVideoCompressTask", 2, "error params");
      }
      return Integer.valueOf(-1);
    }
    this.jdField_a_of_type_JavaLangString = paramVarArgs;
    File localFile = new File(this.jdField_a_of_type_JavaLangString);
    Object localObject = ShortVideoTrimmer.a(this.jdField_a_of_type_JavaLangString);
    if (localObject != null)
    {
      i = a(((ShortVideoTrimmer.CompressConfig)localObject).jdField_a_of_type_Int, ((ShortVideoTrimmer.CompressConfig)localObject).jdField_b_of_type_Int);
      this.jdField_c_of_type_JavaLangLong = Long.valueOf(((ShortVideoTrimmer.CompressConfig)localObject).jdField_b_of_type_Long);
      this.jdField_d_of_type_JavaLangLong = Long.valueOf(i);
      if ((i <= 0) || (((ShortVideoTrimmer.CompressConfig)localObject).jdField_b_of_type_Long * 1024L / i <= 1.3D)) {}
    }
    for (int i = 1;; i = 0)
    {
      if ((localFile.exists()) && (localFile.length() <= 52428800L) && (i == 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyUploadVideoCompressTask", 2, "file:" + paramVarArgs + ", size:" + localFile.length() + ", no need compress");
        }
        this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
        if (localObject != null)
        {
          i = j;
          if (!"90".equals(((ShortVideoTrimmer.CompressConfig)localObject).jdField_a_of_type_JavaLangString))
          {
            if (!"270".equals(((ShortVideoTrimmer.CompressConfig)localObject).jdField_a_of_type_JavaLangString)) {
              break label279;
            }
            i = j;
          }
          if (i == 0) {
            break label333;
          }
          this.jdField_a_of_type_Int = ((ShortVideoTrimmer.CompressConfig)localObject).jdField_b_of_type_Int;
        }
        for (this.jdField_b_of_type_Int = ((ShortVideoTrimmer.CompressConfig)localObject).jdField_a_of_type_Int;; this.jdField_b_of_type_Int = ((ShortVideoTrimmer.CompressConfig)localObject).jdField_b_of_type_Int)
        {
          return Integer.valueOf(0);
          label279:
          if ("0".equals(((ShortVideoTrimmer.CompressConfig)localObject).jdField_a_of_type_JavaLangString))
          {
            paramVarArgs = ShortVideoTrimmer.a(paramVarArgs);
            if ((paramVarArgs != null) && (paramVarArgs.length == 5))
            {
              i = j;
              if (paramVarArgs[3] == 90) {
                break;
              }
              i = j;
              if (paramVarArgs[3] == 270) {
                break;
              }
            }
          }
          i = 0;
          break;
          label333:
          this.jdField_a_of_type_Int = ((ShortVideoTrimmer.CompressConfig)localObject).jdField_a_of_type_Int;
        }
      }
      localObject = new File(AppConstants.aJ + "shortvideo");
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      long l2 = System.currentTimeMillis();
      if (ShortVideoTrimmer.a(this.jdField_a_of_type_AndroidContentContext, 0, 0))
      {
        i = paramVarArgs.lastIndexOf(".");
        if (i == -1) {
          return Integer.valueOf(-1);
        }
        this.jdField_b_of_type_JavaLangString = ShortVideoUtils.c(paramVarArgs, paramVarArgs.substring(i + 1));
        localObject = a(paramVarArgs, this.jdField_a_of_type_AndroidContentContext);
        i = Integer.parseInt((String)((HashMap)localObject).get("ret"));
        this.jdField_b_of_type_JavaLangString = ((String)((HashMap)localObject).get("outputPath"));
        this.jdField_a_of_type_Int = Integer.parseInt((String)((HashMap)localObject).get("outWidth"));
        this.jdField_b_of_type_Int = Integer.parseInt((String)((HashMap)localObject).get("outHeight"));
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyUploadVideoCompressTask", 2, "Before Compress file:" + paramVarArgs + ", after Compress file:" + this.jdField_b_of_type_JavaLangString);
        }
        long l3 = System.currentTimeMillis();
        long l4 = new File(paramVarArgs).length();
        long l1 = 0L;
        if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
          l1 = new File(this.jdField_b_of_type_JavaLangString).length();
        }
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyUploadVideoCompressTask", 2, "CompressTask，step: ShortVideoTrimmer compress ret = " + i + ", cost:" + (l3 - l2) + "ms, fileSourceSize=" + l4 + ", fileTargetSize=" + l1);
        }
        this.jdField_a_of_type_JavaLangLong = Long.valueOf(l4);
        this.jdField_b_of_type_JavaLangLong = Long.valueOf(l1);
        return Integer.valueOf(i);
      }
      return Integer.valueOf(-1);
    }
  }
  
  protected void a(Integer paramInteger)
  {
    super.onPostExecute(paramInteger);
    if (isCancelled()) {
      return;
    }
    int i;
    if (paramInteger.intValue() != 0) {
      if (!this.jdField_a_of_type_Boolean)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyUploadVideoCompressTask", 2, "CompressTask, not support shortvideo so");
        }
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcVideoVideoCompressTask$VideoCompressTaskListener != null) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcVideoVideoCompressTask$VideoCompressTaskListener.a(1, this.jdField_a_of_type_JavaLangLong.longValue(), this.jdField_b_of_type_JavaLangLong.longValue(), null, null);
        }
        i = 1004;
      }
    }
    for (;;)
    {
      a(i);
      return;
      if (!this.jdField_b_of_type_Boolean)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyUploadVideoCompressTask", 2, "CompressTask, shortvideo so not ready");
        }
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcVideoVideoCompressTask$VideoCompressTaskListener != null) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcVideoVideoCompressTask$VideoCompressTaskListener.a(2, this.jdField_a_of_type_JavaLangLong.longValue(), this.jdField_b_of_type_JavaLangLong.longValue(), null, null);
        }
        i = 1004;
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyUploadVideoCompressTask", 2, "CompressTask, compress failed, errorCode:" + paramInteger);
        }
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcVideoVideoCompressTask$VideoCompressTaskListener != null) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcVideoVideoCompressTask$VideoCompressTaskListener.a(3, this.jdField_a_of_type_JavaLangLong.longValue(), this.jdField_b_of_type_JavaLangLong.longValue(), null, null);
        }
        i = 1004;
        continue;
        if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {}
        for (paramInteger = this.jdField_a_of_type_JavaLangString;; paramInteger = this.jdField_b_of_type_JavaLangString)
        {
          this.jdField_c_of_type_JavaLangString = paramInteger;
          paramInteger = MD5.getFileMd5(this.jdField_c_of_type_JavaLangString);
          if (paramInteger != null) {
            this.jdField_d_of_type_JavaLangString = new String(paramInteger);
          }
          long l = new File(this.jdField_c_of_type_JavaLangString).length();
          if (QLog.isColorLevel()) {
            QLog.d("ReadInJoyUploadVideoCompressTask", 2, "CompressTask, finalSize:" + l);
          }
          if (l <= 157286400L) {
            break label372;
          }
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcVideoVideoCompressTask$VideoCompressTaskListener != null) {
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcVideoVideoCompressTask$VideoCompressTaskListener.a(4, this.jdField_a_of_type_JavaLangLong.longValue(), this.jdField_b_of_type_JavaLangLong.longValue(), this.jdField_c_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString);
          }
          i = 1005;
          break;
        }
        label372:
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcVideoVideoCompressTask$VideoCompressTaskListener != null) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcVideoVideoCompressTask$VideoCompressTaskListener.a(0, this.jdField_a_of_type_JavaLangLong.longValue(), this.jdField_b_of_type_JavaLangLong.longValue(), this.jdField_c_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString);
        }
        i = 0;
      }
    }
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.video.VideoCompressTask
 * JD-Core Version:    0.7.0.1
 */