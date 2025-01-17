package com.tencent.open.base.img;

import android.text.TextUtils;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.appcommon.Common;
import com.tencent.open.base.FileUtils;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.MD5Utils;
import java.io.File;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ImageCache
{
  protected static ImageDbHelper a;
  public static final String a;
  protected static ThreadPoolExecutor a;
  protected static final String b = File.separator + "tencent" + File.separator + "qzone" + File.separator + "ImgCache2" + File.separator;
  
  static
  {
    jdField_a_of_type_JavaLangString = File.separator + "tencent" + File.separator + "qzone" + File.separator + ".AppCenterImgCache" + File.separator;
    try
    {
      File localFile = new File(Common.d() + b);
      if (localFile.exists()) {
        localFile.renameTo(new File(Common.d() + jdField_a_of_type_JavaLangString));
      }
      jdField_a_of_type_ComTencentOpenBaseImgImageDbHelper = new ImageDbHelper(CommonDataAdapter.a().a());
      jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor = new ThreadPoolExecutor(3, 5, 120L, TimeUnit.SECONDS, new ArrayBlockingQueue(100));
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public static String a(String paramString1, String paramString2)
  {
    return Common.d() + jdField_a_of_type_JavaLangString + paramString1 + File.separator + FileUtils.a(paramString2);
  }
  
  protected static void a(ImageCache.UpdateTask paramUpdateTask)
  {
    try
    {
      if (jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor.getQueue().contains(paramUpdateTask)) {
        LogUtility.a("ImageCache", "download task already exist, return. key= " + paramUpdateTask.jdField_a_of_type_JavaLangString + " url=" + paramUpdateTask.c);
      }
      for (;;)
      {
        return;
        LogUtility.a("ImageCache", "add download task to queue. key= " + paramUpdateTask.jdField_a_of_type_JavaLangString + " url=" + paramUpdateTask.c);
        jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor.execute(paramUpdateTask);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        LogUtility.c("ImageCache", "execute>>> ", localException);
        if (paramUpdateTask.jdField_a_of_type_ComTencentOpenBaseImgImageDownCallback != null) {
          paramUpdateTask.jdField_a_of_type_ComTencentOpenBaseImgImageDownCallback.b(paramUpdateTask.jdField_a_of_type_JavaLangString, paramUpdateTask.b, paramUpdateTask.c);
        }
      }
    }
    finally {}
  }
  
  public static void a(String paramString)
  {
    try
    {
      new File(a("app", paramString)).delete();
      return;
    }
    catch (Exception paramString)
    {
      LogUtility.c("ImageCache", "-->delete image file failed.", paramString);
    }
  }
  
  public static void a(String paramString1, String paramString2, ImageDownCallback paramImageDownCallback)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    a(MD5Utils.b(paramString2), paramString1, paramString2, paramImageDownCallback);
  }
  
  protected static void a(String paramString1, String paramString2, String paramString3, ImageDownCallback paramImageDownCallback)
  {
    a(new ImageCache.UpdateTask(paramString1, paramString2, paramString3, paramImageDownCallback));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.open.base.img.ImageCache
 * JD-Core Version:    0.7.0.1
 */