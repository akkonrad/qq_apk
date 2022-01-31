package com.tencent.mobileqq.transfile;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.GifDrawable;
import com.tencent.image.SliceBitmap;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.activity.photo.AlbumThumbManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.filemanager.util.FileCategoryUtil;
import com.tencent.mobileqq.transfile.bitmapcreator.ExifBitmapCreator;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import egv;
import egw;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;

public class FileAssistantDownloader
  extends AbsDownloader
  implements ProtocolDownloaderConstants
{
  private static final String a = "FileAssistantDownloader";
  protected BaseApplicationImpl a;
  
  public FileAssistantDownloader(BaseApplicationImpl paramBaseApplicationImpl)
  {
    this.a = paramBaseApplicationImpl;
  }
  
  public static Bitmap a(Drawable paramDrawable)
  {
    if ((paramDrawable instanceof BitmapDrawable)) {
      return ((BitmapDrawable)paramDrawable).getBitmap();
    }
    Bitmap localBitmap = Bitmap.createBitmap(paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight(), Bitmap.Config.RGB_565);
    Canvas localCanvas = new Canvas(localBitmap);
    paramDrawable.setBounds(0, 0, localCanvas.getWidth(), localCanvas.getHeight());
    paramDrawable.draw(localCanvas);
    return localBitmap;
  }
  
  private Bitmap a(egv paramegv)
  {
    Bitmap localBitmap = null;
    int i = paramegv.jdField_a_of_type_Int;
    int j = paramegv.jdField_b_of_type_Int;
    try
    {
      Object localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inPreferredConfig = Bitmap.Config.RGB_565;
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
      BitmapFactory.decodeFile(paramegv.jdField_a_of_type_JavaLangString, (BitmapFactory.Options)localObject);
      ((BitmapFactory.Options)localObject).inSampleSize = ImageUtil.b((BitmapFactory.Options)localObject, i, j);
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
      localObject = BitmapFactory.decodeFile(paramegv.jdField_a_of_type_JavaLangString, (BitmapFactory.Options)localObject);
      if (localObject != null) {
        localBitmap = new ExifBitmapCreator(paramegv.jdField_a_of_type_JavaLangString).a((Bitmap)localObject);
      }
      return localBitmap;
    }
    catch (Throwable paramegv)
    {
      QLog.d("AlbumThumbManager", 2, "make Thumb", paramegv);
    }
    return null;
  }
  
  public Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    float f = this.a.getResources().getDisplayMetrics().density;
    paramInt1 = (int)(paramInt1 * f);
    paramInt2 = (int)(f * paramInt2);
    return ImageUtil.a(paramBitmap, paramInt1, paramInt1, paramInt2);
  }
  
  public egv a(URL paramURL)
  {
    boolean bool2 = true;
    try
    {
      paramURL = paramURL.getFile().split("\\|");
      egv localegv = new egv(this);
      localegv.jdField_a_of_type_JavaLangString = paramURL[0];
      localegv.jdField_a_of_type_Int = Integer.parseInt(paramURL[1]);
      localegv.jdField_b_of_type_Int = Integer.parseInt(paramURL[2]);
      localegv.jdField_b_of_type_Long = Long.parseLong(paramURL[3]);
      if (paramURL.length > 4)
      {
        if (Integer.parseInt(paramURL[4]) == 1)
        {
          bool1 = true;
          localegv.jdField_a_of_type_Boolean = bool1;
        }
      }
      else
      {
        if (paramURL.length > 5)
        {
          if (Integer.parseInt(paramURL[5]) != 1) {
            break label145;
          }
          bool1 = true;
          label105:
          localegv.jdField_b_of_type_Boolean = bool1;
        }
        if (paramURL.length > 6) {
          if (Integer.parseInt(paramURL[6]) != 1) {
            break label150;
          }
        }
      }
      label145:
      label150:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        localegv.c = bool1;
        return localegv;
        bool1 = false;
        break;
        bool1 = false;
        break label105;
      }
      return null;
    }
    catch (Exception paramURL) {}
  }
  
  public File a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    paramOutputStream = a(paramDownloadParams.url);
    if (paramOutputStream.jdField_a_of_type_JavaLangString == null) {
      return new File(AppConstants.aq);
    }
    return new File(paramOutputStream.jdField_a_of_type_JavaLangString);
  }
  
  public Object a(DownloadParams paramDownloadParams, egv paramegv)
  {
    Object localObject = null;
    paramDownloadParams = null;
    String str = paramegv.jdField_a_of_type_JavaLangString;
    if (str == null) {
      paramegv = paramDownloadParams;
    }
    File localFile;
    for (;;)
    {
      return paramegv;
      localFile = new File(str);
      try
      {
        if ((GifDrawable.isGifFile(localFile)) && (paramegv.jdField_a_of_type_Boolean))
        {
          paramegv = paramDownloadParams;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("FileAssistantDownloader", 2, "DecodeFile END,GIF image,cacheFile=" + localFile.getAbsolutePath() + ",url=" + str);
          return null;
        }
      }
      catch (Exception paramDownloadParams)
      {
        throw paramDownloadParams;
      }
    }
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inPreferredConfig = URLDrawableHelper.a;
    localOptions.inDensity = 160;
    localOptions.inTargetDensity = 160;
    localOptions.inScreenDensity = 160;
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(localFile.getAbsolutePath(), localOptions);
    if ((localOptions.outHeight == 0) || (localOptions.outWidth == 0)) {
      throw new IOException("step:decode bounds error, not valid pic");
    }
    localOptions.inSampleSize = AbstractImageDownloader.a(localOptions, paramegv.jdField_a_of_type_Int, paramegv.jdField_b_of_type_Int);
    int i = localOptions.outWidth;
    i = localOptions.outHeight;
    localOptions.inJustDecodeBounds = false;
    i = 1;
    paramegv = null;
    label223:
    paramDownloadParams = localObject;
    if (i <= 3)
    {
      paramDownloadParams = paramegv;
      try
      {
        paramegv = BitmapFactory.decodeFile(localFile.getAbsolutePath(), localOptions);
        if (paramegv == null)
        {
          paramDownloadParams = paramegv;
          throw new OutOfMemoryError("DecodeFile Failed,bitmap == null, url:" + str + " ,retry count: " + i + ",path:" + localFile.getAbsolutePath());
        }
      }
      catch (OutOfMemoryError paramegv)
      {
        if (paramDownloadParams != null) {
          paramDownloadParams.recycle();
        }
        if (paramegv == null) {}
      }
    }
    for (paramegv = paramegv.getMessage();; paramegv = null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FileAssistantDownloader", 2, "DecodeFile ERROR,oom retryCount=" + i + ",options.inSampleSize=" + localOptions.inSampleSize + ",cacheFile=" + localFile.getAbsolutePath() + ",url=" + str + ",oom.msg:" + paramegv);
      }
      localOptions.inSampleSize *= 2;
      i += 1;
      paramegv = paramDownloadParams;
      break label223;
      paramDownloadParams = paramegv;
      if (Build.VERSION.SDK_INT >= 11)
      {
        paramDownloadParams = paramegv;
        boolean bool = SliceBitmap.needSlice(paramegv);
        if (!bool) {}
      }
      paramDownloadParams = paramegv;
      paramegv = paramDownloadParams;
      if (paramDownloadParams != null) {
        break;
      }
      throw new IOException("decode image failed");
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    paramURLDrawableHandler = null;
    paramFile = AlbumThumbManager.a(BaseApplicationImpl.getContext());
    egv localegv = a(paramDownloadParams.url);
    if ((localegv.jdField_a_of_type_Boolean) && (!localegv.jdField_b_of_type_Boolean) && (!localegv.c))
    {
      paramDownloadParams = a(paramDownloadParams, localegv);
      return paramDownloadParams;
    }
    if (localegv.c)
    {
      paramFile = FileCategoryUtil.b(this.a, localegv.jdField_a_of_type_JavaLangString);
      if (paramFile == null) {
        break label133;
      }
      paramFile = a(paramFile);
    }
    for (;;)
    {
      paramDownloadParams = paramURLDrawableHandler;
      if (paramFile == null) {
        break;
      }
      if (localegv.jdField_b_of_type_Boolean)
      {
        return a(paramFile, paramFile.getWidth(), paramFile.getHeight());
        paramFile = paramFile.a(paramDownloadParams.url, new egw(this));
      }
      else
      {
        return paramFile;
        label133:
        paramFile = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.FileAssistantDownloader
 * JD-Core Version:    0.7.0.1
 */