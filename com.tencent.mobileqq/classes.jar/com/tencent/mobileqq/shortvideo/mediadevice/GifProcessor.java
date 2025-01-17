package com.tencent.mobileqq.shortvideo.mediadevice;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.text.TextUtils;
import com.tencent.maxvideo.common.GlobalInit;
import com.tencent.maxvideo.trim.TrimNative;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.utils.ThumbnailUtils;
import com.tencent.mobileqq.activity.richmedia.view.CameraFilterGLView;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.cover.RecordThumbnailUtils;
import com.tencent.mobileqq.shortvideo.hwcodec.VideoSourceHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.video.decode.ShortVideoSoLoad;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.GifCoder;
import cooperation.qzone.video.QZoneVideoCompressor;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class GifProcessor
{
  private static int jdField_a_of_type_Int;
  private static boolean jdField_a_of_type_Boolean;
  private static int b;
  private static int c;
  private static int d;
  private static int e;
  private static int f;
  
  public static int a(String paramString1, int paramInt1, int paramInt2, long paramLong, String paramString2)
  {
    return c(paramString1, paramInt1, paramInt2, paramLong, paramString2);
  }
  
  public static int a(String paramString1, String paramString2)
  {
    return b(paramString1, paramString2);
  }
  
  public static int a(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    int i = 0;
    QLog.i("GifProcessor", 1, "generateGifFromVFile vfPath=" + paramString1 + " output=" + paramString3);
    a();
    GifCoder localGifCoder = new GifCoder();
    localGifCoder.c(true);
    localGifCoder.a(jdField_a_of_type_Int);
    boolean bool;
    int k;
    int j;
    VideoSourceHelper localVideoSourceHelper;
    Bitmap localBitmap;
    if (b == 1)
    {
      bool = true;
      localGifCoder.a(bool);
      k = CodecParam.z * 1000 / CodecParam.y / c;
      j = k;
      if (k <= 0) {
        j = 1;
      }
      localVideoSourceHelper = new VideoSourceHelper(paramString1, paramString2);
      localVideoSourceHelper.initHelperParam();
      paramString1 = localVideoSourceHelper.getSourceVideoParam();
      localBitmap = Bitmap.createBitmap(paramString1[0], paramString1[1], Bitmap.Config.RGB_565);
      k = 0;
    }
    for (;;)
    {
      if (k < CodecParam.z)
      {
        i = localVideoSourceHelper.getVideoFrameByIndex(localBitmap, k);
        if (QLog.isColorLevel()) {
          QLog.d("GifProcessor", 2, "getVideoFrameByIndex from vffile. index=" + k + " ret=" + i);
        }
        if (i == 0) {
          break label229;
        }
      }
      for (;;)
      {
        localGifCoder.b();
        return i;
        bool = false;
        break;
        label229:
        paramString2 = localBitmap.copy(Bitmap.Config.ARGB_8888, true);
        paramString1 = paramString2;
        if (paramInt != 0)
        {
          paramString1 = paramString2;
          if (!CameraFilterGLView.a(paramInt)) {
            paramString1 = RecordThumbnailUtils.a(paramString2, paramInt);
          }
        }
        if (localGifCoder.a(paramString1, paramString3, d, true)) {
          break label280;
        }
        i = -1;
      }
      label280:
      k += j;
    }
  }
  
  private static void a()
  {
    jdField_a_of_type_Int = QzoneConfig.getInstance().getConfig("MiniVideo", "VideoToGifSize", 720);
    b = QzoneConfig.getInstance().getConfig("MiniVideo", "VideoToGifSizeForLongEdge", 0);
    c = QzoneConfig.getInstance().getConfig("MiniVideo", "VideoToGifFps", 5);
    d = QzoneConfig.getInstance().getConfig("MiniVideo", "VideoToGifTimePerFrame", 200);
    e = QzoneConfig.getInstance().getConfig("MiniVideo", "VideoToGifMaxFrame", 10);
    f = QzoneConfig.getInstance().getConfig("MiniVideo", "VideoToGifFirstNSecond", 10);
  }
  
  private static boolean a()
  {
    if (jdField_a_of_type_Boolean) {
      return true;
    }
    try
    {
      String str2 = ShortVideoSoLoad.getShortVideoSoPath(BaseApplication.getContext());
      String str1 = VideoEnvironment.a();
      str2 = str2 + str1;
      File localFile = new File(str2);
      if ((str1 != null) && (localFile.exists()))
      {
        GlobalInit.loadLibraryWithFullPath(str2);
        jdField_a_of_type_Boolean = true;
        return true;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.w("GifProcessor", 1, "loadLibrary error", localThrowable);
      return false;
    }
    return false;
  }
  
  public static int b(String paramString1, int paramInt1, int paramInt2, long paramLong, String paramString2)
  {
    QLog.i("GifProcessor", 1, "getFramesFromVideo input=" + paramString1 + " width=" + paramInt1 + " height=" + paramInt2 + " duration=" + paramLong + " output=" + paramString2);
    if (!a()) {
      return -110;
    }
    if (TrimNative.detect(paramString1) != 0) {
      return -111;
    }
    a();
    Object localObject = null;
    try
    {
      String str = TrimNative.getRealProperties(paramString1, jdField_a_of_type_Int, b);
      localObject = str;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("GifProcessor", 1, "getRealProperties error:", localThrowable);
      }
      localObject = ((String)localObject).split(",");
      if ((localObject.length >= 4) && (localObject[0].equals("0"))) {
        break label160;
      }
      return -12;
      i = Integer.valueOf(localObject[3]).intValue();
      paramInt2 = Integer.valueOf(localObject[1]).intValue();
      paramInt1 = Integer.valueOf(localObject[2]).intValue();
      if (i == 1) {
        break label206;
      }
    }
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return -11;
    }
    label160:
    int i;
    if (i == 3)
    {
      label206:
      i = paramInt2;
      paramInt2 = paramInt1;
    }
    for (;;)
    {
      if (ThumbnailUtils.a(paramString1, paramInt2, i, 0, 0, paramInt2, i) != 0) {
        return -112;
      }
      long l1;
      if (paramLong > f * 1000) {
        l1 = f * 1000;
      }
      for (;;)
      {
        long l3 = 0L;
        long l2 = 1000L / c;
        long l4 = l1 / e;
        label282:
        label316:
        long l6;
        long l5;
        if (l2 > l4)
        {
          paramString1 = new File(paramString2);
          if (paramString1.exists())
          {
            if (!paramString1.isDirectory()) {
              break label511;
            }
            FileUtils.a(paramString2);
          }
          paramString1.mkdir();
          if (l3 > l1) {
            break label527;
          }
          l6 = System.currentTimeMillis();
          l5 = l3 + l2;
          l4 = l5;
          if (l5 >= l1) {
            l4 = l1;
          }
          paramString1 = ThumbnailUtils.b(l3, l4);
          l4 = System.currentTimeMillis();
          if (paramString1 == null) {}
        }
        try
        {
          ImageUtil.a(paramString1, new File(paramString2 + File.separator + l3 + ".jpg"));
          l5 = System.currentTimeMillis();
          if (QLog.isColorLevel()) {
            QLog.d("GifProcessor", 2, "getFramesFromVideo currentTime=" + l3 + " duration=" + paramLong + " retrieve frame cost=" + (l4 - l6) + " encode frame cost=" + (l5 - l4));
          }
          l3 += l2;
          break label316;
          l1 = paramLong;
          continue;
          l2 = l4;
          break label282;
          label511:
          paramString1.delete();
        }
        catch (IOException paramString1)
        {
          for (;;)
          {
            paramString1.printStackTrace();
          }
        }
      }
      label527:
      return 0;
      i = paramInt1;
    }
  }
  
  private static int b(String paramString1, String paramString2)
  {
    if (!a()) {
      return -110;
    }
    a();
    String str1 = String.format("fps=%d", new Object[] { Integer.valueOf(c) });
    Object localObject1 = null;
    try
    {
      String str2 = TrimNative.getRealProperties(paramString1, jdField_a_of_type_Int, b);
      localObject1 = str2;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("GifProcessor", 1, "getRealProperties error:", localThrowable);
      }
      localObject1 = ((String)localObject1).split(",");
      if ((localObject1.length >= 4) && (localObject1[0].equals("0"))) {
        break label109;
      }
      return -12;
      switch (Integer.valueOf(localObject1[3]).intValue())
      {
      default: 
        localObject1 = str1;
      }
    }
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      return -11;
    }
    label109:
    str1 = new File(paramString2).getParent();
    str1 = str1 + File.separator + "tempPics";
    Object localObject2 = new File(str1);
    label222:
    int i;
    long l2;
    if (((File)localObject2).exists())
    {
      if (((File)localObject2).isDirectory()) {
        FileUtils.a(str1);
      }
    }
    else
    {
      ((File)localObject2).mkdir();
      String str3 = str1 + File.separator + "%03d.jpg";
      long l1 = System.currentTimeMillis();
      i = QZoneVideoCompressor.a(new String[] { "-i", paramString1, "-vf", localObject1, "-y", str3 });
      l2 = System.currentTimeMillis();
      QLog.i("GifProcessor", 1, "convertVideoToGifForRecord generate temp pics input=" + paramString1 + " output=" + paramString2 + " cost=" + (l2 - l1) + " ret=" + i);
      if (i != 0) {
        break label663;
      }
      localObject2 = ((File)localObject2).listFiles();
      if ((localObject2 != null) && (localObject2.length != 0)) {
        break label486;
      }
      i = -233;
    }
    label660:
    label663:
    for (;;)
    {
      FileUtils.a(str1);
      return i;
      localObject1 = str1 + ",transpose=1";
      break;
      localObject1 = str1 + ",vflip,hflip";
      break;
      localObject1 = str1 + ",transpose=2";
      break;
      ((File)localObject2).delete();
      break label222;
      label486:
      localObject1 = new ArrayList();
      int k = localObject2.length;
      int j = 0;
      while (j < k)
      {
        ((ArrayList)localObject1).add(localObject2[j].getAbsolutePath());
        j += 1;
      }
      localObject2 = new GifCoder();
      ((GifCoder)localObject2).c(true);
      ((GifCoder)localObject2).a(jdField_a_of_type_Int);
      boolean bool;
      if (b == 1)
      {
        bool = true;
        label561:
        ((GifCoder)localObject2).a(bool);
        if (((GifCoder)localObject2).a(paramString2, (ArrayList)localObject1, d, true)) {
          break label660;
        }
        i = -234;
      }
      for (;;)
      {
        ((GifCoder)localObject2).b();
        QLog.i("GifProcessor", 1, "convertVideoToGifForRecord generate gif input=" + paramString1 + " output=" + paramString2 + " cost=" + (System.currentTimeMillis() - l2) + " ret=" + i);
        break;
        bool = false;
        break label561;
      }
    }
  }
  
  private static int c(String paramString1, int paramInt1, int paramInt2, long paramLong, String paramString2)
  {
    QLog.i("GifProcessor", 1, "convertByFrameFatcher input=" + paramString1 + " width=" + paramInt1 + " height=" + paramInt2 + " duration=" + paramLong + " output=" + paramString2);
    if (!a()) {
      return -110;
    }
    a();
    Object localObject1 = null;
    try
    {
      String str = TrimNative.getRealProperties(paramString1, jdField_a_of_type_Int, b);
      localObject1 = str;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("GifProcessor", 1, "getRealProperties error:", localThrowable);
      }
      localObject1 = ((String)localObject1).split(",");
      if ((localObject1.length >= 4) && (localObject1[0].equals("0"))) {
        break label151;
      }
      return -12;
      label151:
      i = Integer.valueOf(localObject1[3]).intValue();
      paramInt2 = Integer.valueOf(localObject1[1]).intValue();
      paramInt1 = Integer.valueOf(localObject1[2]).intValue();
      if (i == 1) {
        break label197;
      }
    }
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      return -11;
    }
    int i;
    if (i == 3)
    {
      label197:
      i = paramInt2;
      paramInt2 = paramInt1;
    }
    for (;;)
    {
      ThumbnailUtils.a(paramString1, paramInt2, i, 0, 0, paramInt2, i);
      long l1;
      long l3;
      long l2;
      long l4;
      label281:
      Object localObject2;
      if (paramLong > f * 1000)
      {
        l1 = f * 1000;
        paramString1 = new GifCoder();
        paramString1.b(true);
        l3 = 0L;
        l2 = 1000L / c;
        l4 = l1 / e;
        if (l2 <= l4) {
          break label429;
        }
        localObject1 = new File(paramString2).getParent();
        localObject1 = (String)localObject1 + File.separator + "tempPics";
        localObject2 = new File((String)localObject1);
        if (((File)localObject2).exists())
        {
          if (!((File)localObject2).isDirectory()) {
            break label436;
          }
          FileUtils.a((String)localObject1);
        }
        label356:
        ((File)localObject2).mkdir();
        localObject2 = new ArrayList();
      }
      for (;;)
      {
        if (l3 <= l1)
        {
          l4 = System.currentTimeMillis();
          l5 = l3 + l2;
          if (l5 < l1) {}
        }
        else
        {
          paramString1.a(paramString2, (ArrayList)localObject2, d, true);
          paramString1.b();
          FileUtils.a((String)localObject1);
          return 0;
          l1 = paramLong;
          break;
          label429:
          l2 = l4;
          break label281;
          label436:
          ((File)localObject2).delete();
          break label356;
        }
        Bitmap localBitmap = ThumbnailUtils.b(l3, l5);
        long l5 = System.currentTimeMillis();
        if (localBitmap != null) {}
        try
        {
          ImageUtil.a(localBitmap, new File((String)localObject1 + File.separator + l3 + ".jpg"));
          ((ArrayList)localObject2).add((String)localObject1 + File.separator + l3 + ".jpg");
          long l6 = System.currentTimeMillis();
          if (QLog.isColorLevel()) {
            QLog.d("GifProcessor", 2, "convertByFrameFatcher currentTime=" + l3 + " duration=" + paramLong + " retrieve frame cost=" + (l5 - l4) + " encode frame cost=" + (l6 - l5));
          }
          l3 += l2;
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            localIOException.printStackTrace();
          }
        }
      }
      i = paramInt1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.mediadevice.GifProcessor
 * JD-Core Version:    0.7.0.1
 */