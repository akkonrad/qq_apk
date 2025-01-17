package com.tencent.mobileqq.utils;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.ExifInterface;
import android.net.Uri;
import android.support.v4.util.MQLruCache;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.photo.ImageInfo;
import com.tencent.mobileqq.activity.photopreview.PhotoPreviewConstant;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.AbstractImageDownloader;
import com.tencent.mobileqq.transfile.RichMediaUtil;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.ImageTestUtil;
import evw;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class ImageUtil
{
  private static int A = 88034;
  public static final float a = 2.0F;
  public static final int a = 50;
  public static final String a = "thumb";
  private static String[] a;
  public static final int b = 3;
  public static final String b = "thumb2";
  public static final int c = 1;
  public static final String c = "photo";
  public static final int d = 2;
  public static final String d = "thumb/";
  public static final int e = 3;
  public static final String e = "thumb2/";
  public static final int f = 4;
  public static final String f = "photo/";
  public static final int g = 5;
  public static final String g = "image_upload";
  public static final int h = 6;
  public static final String h = "image_upload_exception_stack";
  public static final int i = 7;
  public static final String i = "actGrpImageuploadInvalid";
  public static final int j = 8;
  public static final String j = "actC2CImageuploadInvalid";
  public static final int k = 1;
  public static final String k = "actPubImageuploadInvalid";
  public static final int l = 2;
  public static final String l = "actAppShareImageuploadInvalid";
  public static final int m = 3;
  public static final String m = "report_sendphoto_iswifi";
  public static final int n = 4;
  public static final String n = "report_sendphoto_not_long_photo";
  public static final int o = 5;
  public static final String o = "report_sendphoto_not_larger_960";
  public static final int p = 6;
  private static final String p = ImageUtil.class.getSimpleName();
  public static final int q = 7;
  public static final int r = 8;
  public static final int s = 9;
  public static final int t = 0;
  private static final int u = 70;
  private static final int v = 80;
  private static final int w = 2;
  private static int x = 1280;
  private static final int y = 960;
  private static int z = 88030;
  
  public static double a(InputStream paramInputStream, int paramInt1, int paramInt2)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeStream(paramInputStream, null, localOptions);
    int i1 = localOptions.outWidth;
    int i2 = localOptions.outHeight;
    double d3 = 1.0D;
    if ((i1 <= paramInt1) && (i2 <= paramInt2)) {
      return d3;
    }
    double d1;
    if (i1 > i2) {
      d1 = i1 / paramInt1;
    }
    for (double d2 = i2 / paramInt2;; d2 = i1 / paramInt2)
    {
      d3 = d1;
      if (d1 > d2) {
        break;
      }
      return d2;
      d1 = i2 / paramInt1;
    }
  }
  
  public static int a(int paramInt)
  {
    float f1 = 1.0F;
    if (paramInt > 150) {
      f1 = paramInt / 100;
    }
    if (BaseChatItemLayout.d <= 1.5D) {
      return (int)(f1 * 9.0F);
    }
    if (BaseChatItemLayout.d <= 2.0D) {
      return (int)(f1 * 9.0F);
    }
    return (int)(f1 * 4.0F);
  }
  
  public static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt2 == 0) || (paramInt2 == paramInt3)) {
      return paramInt1;
    }
    return (paramInt1 * paramInt3 + (paramInt2 >> 1)) / paramInt2;
  }
  
  public static int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int i1 = c(paramOptions, paramInt1, paramInt2);
    if (i1 <= 8)
    {
      paramInt1 = 1;
      for (;;)
      {
        paramInt2 = paramInt1;
        if (paramInt1 >= i1) {
          break;
        }
        paramInt1 <<= 1;
      }
    }
    paramInt2 = (i1 + 7) / 8 * 8;
    return paramInt2;
  }
  
  public static int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if ((paramInt1 == 0) || (paramInt2 == 0) || (paramInt1 == -1) || (paramInt2 == -1)) {
      return 1;
    }
    int i3 = paramOptions.outHeight;
    int i4 = paramOptions.outWidth;
    int i2 = 1;
    if ((i3 > paramInt2) || (i4 > paramInt1))
    {
      int i6 = Math.round(i3 / paramInt2);
      int i5 = Math.round(i4 / paramInt1);
      int i1;
      if (paramBoolean) {
        if (i6 > i5) {
          i1 = i6;
        }
      }
      for (;;)
      {
        if (i1 < 2) {
          break label136;
        }
        i4 /= 2;
        i3 /= 2;
        i2 *= 2;
        break;
        i1 = i5;
        continue;
        i1 = i6;
        if (i6 >= i5) {
          i1 = i5;
        }
      }
    }
    label136:
    return i2;
  }
  
  public static int a(InputStream paramInputStream, int paramInt1, int paramInt2)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeStream(paramInputStream, null, localOptions);
    int i1 = localOptions.outWidth;
    int i2 = localOptions.outHeight;
    paramInt1 = Math.min(i1 / paramInt1, i2 / paramInt2);
    if (paramInt1 < 1) {
      return 1;
    }
    return paramInt1;
  }
  
  public static int a(String paramString)
  {
    try
    {
      paramString = Class.forName("android.media.ExifInterface").getConstructor(new Class[] { String.class }).newInstance(new Object[] { paramString });
      if (paramString == null) {}
    }
    catch (Exception paramString)
    {
      try
      {
        i1 = ((Integer)paramString.getClass().getMethod("getAttributeInt", new Class[] { String.class, Integer.TYPE }).invoke(paramString, new Object[] { "Orientation", Integer.valueOf(-1) })).intValue();
        if (i1 != -1) {}
        switch (i1)
        {
        case 4: 
        case 5: 
        case 7: 
        default: 
          return 0;
          paramString = paramString;
          if (QLog.isColorLevel()) {
            QLog.e("reflection", 2, "e = " + paramString.toString());
          }
          paramString = null;
        }
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("reflection", 2, "e = " + paramString.toString());
          }
          int i1 = 0;
        }
        return 90;
      }
    }
    return 180;
    return 270;
  }
  
  public static long a(InputStream paramInputStream)
  {
    if (paramInputStream == null) {}
    for (;;)
    {
      return -1L;
      try
      {
        int i1 = paramInputStream.read();
        if (i1 == 255)
        {
          if (paramInputStream.read() == 216) {
            return b(paramInputStream);
          }
        }
        else
        {
          int i2;
          int i3;
          if (i1 == 71)
          {
            if ((paramInputStream.read() == 73) && (paramInputStream.read() == 70))
            {
              paramInputStream.skip(3L);
              i1 = paramInputStream.read();
              i2 = paramInputStream.read();
              i3 = paramInputStream.read();
              return (paramInputStream.read() << 8 | i3) * (i1 | i2 << 8);
            }
          }
          else
          {
            long l1;
            if (i1 == 66)
            {
              if (paramInputStream.read() == 77)
              {
                paramInputStream.skip(16L);
                l1 = paramInputStream.read() | paramInputStream.read() << 8 | paramInputStream.read() << 16 | paramInputStream.read() << 24;
                i1 = paramInputStream.read();
                i2 = paramInputStream.read();
                i3 = paramInputStream.read();
                return (paramInputStream.read() << 24 | i1 | i2 << 8 | i3 << 16) * l1;
              }
            }
            else if ((i1 == 137) && (paramInputStream.read() == 80) && (paramInputStream.read() == 78))
            {
              paramInputStream.skip(13L);
              l1 = paramInputStream.read() << 24 | paramInputStream.read() << 16 | paramInputStream.read() << 8 | paramInputStream.read();
              i1 = paramInputStream.read();
              i2 = paramInputStream.read();
              i3 = paramInputStream.read();
              int i4 = paramInputStream.read();
              return (i4 | i1 << 24 | i2 << 16 | i3 << 8) * l1;
            }
          }
        }
      }
      catch (Exception paramInputStream)
      {
        paramInputStream.printStackTrace();
      }
    }
    return -1L;
  }
  
  public static Bitmap a()
  {
    Bitmap localBitmap1 = null;
    if (BaseApplicationImpl.a != null) {
      localBitmap1 = (Bitmap)BaseApplicationImpl.a.get("static://DefaultFace");
    }
    Bitmap localBitmap2 = localBitmap1;
    if (localBitmap1 == null)
    {
      localBitmap1 = BitmapFactory.decodeResource(BaseApplicationImpl.a().getResources(), 2130838055);
      if ((localBitmap1 != null) && (BaseApplicationImpl.a != null)) {
        BaseApplicationImpl.a.put("static://DefaultFace", localBitmap1);
      }
      localBitmap2 = localBitmap1;
      if (QLog.isColorLevel())
      {
        QLog.d(p, 2, "getDefaultFaceBitmap, bitmap=" + localBitmap1);
        localBitmap2 = localBitmap1;
      }
    }
    return localBitmap2;
  }
  
  public static Bitmap a(int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, ArrayList paramArrayList)
  {
    int i2 = paramInt1 * paramInt2;
    int[] arrayOfInt = new int[i2];
    int i1 = 0;
    while (i1 < i2)
    {
      arrayOfInt[i1] = -2631723;
      i1 += 1;
    }
    i1 = (int)(3.0F * paramFloat);
    i2 = (int)(2.0F * paramFloat);
    int i3 = (int)(32.0F * paramFloat);
    return a(paramInt1, paramInt2, paramFloat, arrayOfInt, -2631723, i1, i2, i3, i3, paramInt3, paramInt4, paramArrayList);
  }
  
  private static Bitmap a(int paramInt1, int paramInt2, float paramFloat, int[] paramArrayOfInt, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, ArrayList paramArrayList)
  {
    Bitmap localBitmap2 = null;
    Bitmap localBitmap1 = localBitmap2;
    if (paramArrayList != null)
    {
      localBitmap1 = localBitmap2;
      if (paramArrayList.size() > 0)
      {
        localBitmap2 = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
        localBitmap2.setPixels(paramArrayOfInt, 0, paramInt1, 0, 0, paramInt1, paramInt2);
        paramArrayOfInt = new Canvas(localBitmap2);
        paramArrayList = paramArrayList.iterator();
        paramInt1 = 0;
        localBitmap1 = localBitmap2;
        if (paramArrayList.hasNext())
        {
          localBitmap1 = (Bitmap)paramArrayList.next();
          if (paramInt1 < 2)
          {
            paramInt2 = paramInt4;
            label99:
            if (paramInt1 % 2 != 0) {
              break label148;
            }
          }
          label148:
          for (paramInt9 = paramInt4;; paramInt9 = paramInt6 + paramInt4 + paramInt5)
          {
            a(localBitmap1, paramArrayOfInt, paramInt9, paramInt2, localBitmap1.getWidth() / paramInt8, paramInt3);
            paramInt1 += 1;
            break;
            paramInt2 = paramInt7 + paramInt4 + paramInt5;
            break label99;
          }
        }
      }
    }
    return localBitmap1;
  }
  
  private static Bitmap a(int paramInt1, Context paramContext, File paramFile, int paramInt2, ImageInfo paramImageInfo)
  {
    Object localObject2 = null;
    BitmapFactory.Options localOptions1 = new BitmapFactory.Options();
    BitmapFactory.Options localOptions2 = a(localOptions1, paramFile.getPath(), paramInt2);
    if ((localOptions1.outWidth > 960) || (localOptions1.outHeight > 960)) {
      a("report_sendphoto_not_larger_960", paramContext, true);
    }
    for (;;)
    {
      paramInt2 = 1;
      paramInt1 = 0;
      Bitmap localBitmap = null;
      for (;;)
      {
        if (((localBitmap != null) || (localOptions2.inSampleSize <= 0) || (localOptions2.inSampleSize > 4)) && (paramInt2 == 0)) {
          break label295;
        }
        if (paramInt2 == 0) {
          localOptions2.inSampleSize *= 2;
        }
        try
        {
          localBitmap = BitmapFactory.decodeFile(paramFile.getPath(), localOptions2);
          paramInt2 = 0;
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          a("compress : compressNoLargePhoto  getBitmap  OOM " + localOptions2.inSampleSize);
          paramInt1 = localOptions1.outWidth * localOptions1.outHeight;
          if ((paramInt1 > URLDrawableHelper.b) || (paramInt1 <= 0)) {
            break label196;
          }
          ImageTestUtil.a(((QQAppInterface)((BaseActivity)paramContext).getAppRuntime()).a());
          if (!NetworkUtil.g(paramContext)) {
            break label285;
          }
        }
      }
      a("report_sendphoto_not_larger_960", paramContext, false);
    }
    label196:
    paramImageInfo.jdField_k_of_type_Int = 1;
    paramImageInfo.g = true;
    if (paramImageInfo.d == 0)
    {
      paramImageInfo.jdField_j_of_type_Int = 2;
      if (QLog.isColorLevel()) {
        QLog.d(p, 2, "WIFI oom ,c2c send srcfile by raw");
      }
      label245:
      paramInt1 = 1;
    }
    label285:
    Object localObject1;
    label295:
    for (paramContext = localObject2;; paramContext = localObject1)
    {
      if ((paramContext == null) && (paramInt1 != 0)) {
        paramImageInfo.g = true;
      }
      return paramContext;
      if (!QLog.isColorLevel()) {
        break label245;
      }
      QLog.d(p, 2, "WIFI oom ,not c2c send srcfile by nor");
      break label245;
      paramInt2 = 0;
      paramInt1 = 1;
      localObject1 = null;
      break;
    }
  }
  
  public static final Bitmap a(Bitmap paramBitmap)
  {
    Bitmap localBitmap = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_4444);
    Object localObject = paramBitmap;
    if (localBitmap != null)
    {
      localObject = new Canvas(localBitmap);
      Paint localPaint = new Paint();
      ColorMatrix localColorMatrix = new ColorMatrix();
      localColorMatrix.setSaturation(0.0F);
      localPaint.setColorFilter(new ColorMatrixColorFilter(localColorMatrix));
      ((Canvas)localObject).drawBitmap(paramBitmap, 0.0F, 0.0F, localPaint);
      localObject = localBitmap;
    }
    return localObject;
  }
  
  public static final Bitmap a(Bitmap paramBitmap, float paramFloat)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    if (paramBitmap == null) {}
    do
    {
      return localObject2;
      try
      {
        localObject2 = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
        localObject1 = localObject2;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          Paint localPaint;
          Rect localRect;
          RectF localRectF;
          a("OOM occurred in ImageUtil.round" + localOutOfMemoryError.getMessage());
        }
      }
      localObject2 = localObject1;
    } while (localObject1 == null);
    localObject2 = new Canvas(localObject1);
    localPaint = new Paint();
    localRect = new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
    localRectF = new RectF(localRect);
    localPaint.setAntiAlias(true);
    ((Canvas)localObject2).drawRoundRect(localRectF, paramFloat, paramFloat, localPaint);
    localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    ((Canvas)localObject2).drawBitmap(paramBitmap, localRect, localRect, localPaint);
    return localObject1;
  }
  
  public static Bitmap a(Bitmap paramBitmap, float paramFloat1, float paramFloat2)
  {
    if (paramBitmap != null) {}
    for (;;)
    {
      try
      {
        float f1 = paramBitmap.getWidth();
        float f2 = paramBitmap.getHeight();
        a("cutOurImg() img:[" + f1 + ", " + f2 + "], default: [" + paramFloat1 + ", " + paramFloat2 + "]");
        float f3 = paramFloat1 / f1;
        float f4 = paramFloat2 / f2;
        if (f3 > f4)
        {
          i2 = (int)paramFloat1;
          i1 = (int)(f3 * f2);
          Matrix localMatrix = new Matrix();
          localMatrix.postScale(i2 / f1, i1 / f2);
          localMatrix.postTranslate((paramFloat1 - i2) / 2.0F, (paramFloat2 - i1) / 2.0F);
          Bitmap localBitmap = Bitmap.createBitmap((int)paramFloat1, (int)paramFloat2, Bitmap.Config.RGB_565);
          new Canvas(localBitmap).drawBitmap(paramBitmap, localMatrix, null);
          paramBitmap = localBitmap;
          return paramBitmap;
        }
        int i2 = (int)(f1 * f4);
        int i1 = (int)paramFloat2;
        continue;
        paramBitmap = null;
      }
      catch (OutOfMemoryError paramBitmap)
      {
        return null;
      }
      catch (Exception paramBitmap)
      {
        return null;
      }
    }
  }
  
  public static Bitmap a(Bitmap paramBitmap, float paramFloat, int paramInt1, int paramInt2)
  {
    if (paramBitmap == null) {
      return null;
    }
    for (;;)
    {
      try
      {
        int i2 = paramBitmap.getWidth();
        int i1 = paramBitmap.getHeight();
        if (i2 > i1)
        {
          i4 = (i2 - i1) / 2;
          i3 = 0;
          paramInt1 = paramInt2;
          i2 = i1;
          paramFloat = paramInt1;
          Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
          Canvas localCanvas = new Canvas(localBitmap);
          Paint localPaint = new Paint();
          Rect localRect1 = new Rect(i4, i3, i2 + i4, i1 + i3);
          Rect localRect2 = new Rect(0, 0, paramInt1, paramInt2);
          RectF localRectF = new RectF(localRect2);
          localPaint.setAntiAlias(true);
          localPaint.setDither(true);
          localPaint.setFilterBitmap(true);
          localCanvas.drawARGB(0, 0, 0, 0);
          localPaint.setColor(-12434878);
          localCanvas.drawRoundRect(localRectF, paramFloat, paramFloat, localPaint);
          localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
          localCanvas.drawBitmap(paramBitmap, localRect1, localRect2, localPaint);
          return localBitmap;
        }
        if (i1 > i2)
        {
          i3 = (i1 - i2) / 2;
          int i5 = 0;
          paramInt2 = paramInt1;
          i4 = i2;
          i1 = i2;
          i2 = i4;
          i4 = i5;
          continue;
        }
        int i3 = 0;
      }
      catch (Throwable paramBitmap)
      {
        paramBitmap.printStackTrace();
        return null;
      }
      int i4 = 0;
    }
  }
  
  public static Bitmap a(Bitmap paramBitmap, float paramFloat, ImageUtil.ScalingLogic paramScalingLogic)
  {
    if (paramBitmap == null) {
      return null;
    }
    return a(paramBitmap, (int)(paramBitmap.getWidth() * paramFloat), (int)(paramBitmap.getHeight() * paramFloat), paramScalingLogic);
  }
  
  public static Bitmap a(Bitmap paramBitmap, int paramInt)
  {
    Bitmap localBitmap;
    if ((paramBitmap == null) || (paramInt <= 0)) {
      localBitmap = null;
    }
    int i3;
    int i4;
    do
    {
      do
      {
        return localBitmap;
        i3 = paramBitmap.getWidth();
        i4 = paramBitmap.getHeight();
        localBitmap = paramBitmap;
      } while (i3 <= paramInt);
      localBitmap = paramBitmap;
    } while (i4 <= paramInt);
    int i1 = Math.max(i3, i4) * paramInt / Math.min(i3, i4);
    int i2;
    if (i3 > i4) {
      i2 = i1;
    }
    for (;;)
    {
      if (i3 > i4) {
        i1 = paramInt;
      }
      try
      {
        paramBitmap = Bitmap.createScaledBitmap(paramBitmap, i2, i1, true);
        i2 = (i2 - paramInt) / 2;
        i1 = (i1 - paramInt) / 2;
        try
        {
          localBitmap = Bitmap.createBitmap(paramBitmap, i2, i1, paramInt, paramInt);
          paramBitmap.recycle();
          return localBitmap;
        }
        catch (Exception paramBitmap)
        {
          return null;
        }
        i2 = paramInt;
      }
      catch (Exception paramBitmap) {}
    }
    return null;
  }
  
  public static Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    if (paramBitmap == null) {
      return null;
    }
    float f2 = BaseApplicationImpl.a().getResources().getDisplayMetrics().density;
    int i1 = paramBitmap.getWidth();
    float f1 = f2;
    if (i1 > 0)
    {
      f1 = f2;
      if (i1 < paramInt1 * f2) {
        f1 = i1 / paramInt1;
      }
    }
    i1 = (paramInt1 + paramInt2) / 2;
    if (i1 < 35) {
      i1 = (int)(2.0F * f1);
    }
    for (;;)
    {
      paramInt1 = (int)(paramInt1 * f1);
      paramInt2 = (int)(f1 * paramInt2);
      return a(paramBitmap, i1, paramInt1, paramInt2);
      if (i1 < 50) {
        i1 = (int)(3.0F * f1);
      } else if (i1 < 64) {
        i1 = (int)(5.0F * f1);
      } else {
        i1 = (int)(6.0F * f1);
      }
    }
  }
  
  public static Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2, ImageUtil.ScalingLogic paramScalingLogic)
  {
    if (paramBitmap == null) {
      return null;
    }
    Rect localRect = a(paramBitmap.getWidth(), paramBitmap.getHeight(), paramInt1, paramInt2, paramScalingLogic);
    paramScalingLogic = b(paramBitmap.getWidth(), paramBitmap.getHeight(), paramInt1, paramInt2, paramScalingLogic);
    Bitmap localBitmap = Bitmap.createBitmap(paramScalingLogic.width(), paramScalingLogic.height(), Bitmap.Config.ARGB_8888);
    new Canvas(localBitmap).drawBitmap(paramBitmap, localRect, paramScalingLogic, new Paint(3));
    return localBitmap;
  }
  
  public static Bitmap a(Bitmap paramBitmap, File paramFile)
  {
    Object localObject;
    if (paramBitmap == null) {
      localObject = null;
    }
    do
    {
      return localObject;
      localObject = new Matrix();
      int i1 = paramBitmap.getWidth();
      int i2 = paramBitmap.getHeight();
      int i3 = Math.max(i1, i2);
      float f1 = x / (i3 * 1.0F);
      i3 = b(paramFile.getPath());
      if (f1 < 1.0F) {}
      try
      {
        ((Matrix)localObject).postScale(f1, f1);
        if ((i3 != 0) && (i3 % 90 == 0)) {
          ((Matrix)localObject).postRotate(i3, i1 / 2.0F, i2 / 2.0F);
        }
        paramFile = Bitmap.createBitmap(paramBitmap, 0, 0, i1, i2, (Matrix)localObject, true);
      }
      catch (Exception paramFile)
      {
        for (;;)
        {
          a("compress : " + paramFile.getMessage());
          paramFile = null;
        }
      }
      catch (OutOfMemoryError paramFile)
      {
        for (;;)
        {
          a("compress :  scaleBitmap OOM");
          paramFile = null;
        }
      }
      localObject = paramBitmap;
    } while (paramFile == null);
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()) && (!paramBitmap.equals(paramFile))) {
      paramBitmap.recycle();
    }
    return paramFile;
  }
  
  public static Bitmap a(Drawable paramDrawable)
  {
    if (paramDrawable == null) {}
    int i1;
    int i2;
    do
    {
      return null;
      i1 = paramDrawable.getIntrinsicWidth();
      i2 = paramDrawable.getIntrinsicWidth();
    } while ((i1 <= 0) || (i2 <= 0));
    try
    {
      if (paramDrawable.getOpacity() != -1) {}
      for (Object localObject = Bitmap.Config.ARGB_8888;; localObject = Bitmap.Config.RGB_565)
      {
        localObject = Bitmap.createBitmap(i1, i2, (Bitmap.Config)localObject);
        Canvas localCanvas = new Canvas((Bitmap)localObject);
        paramDrawable.setBounds(0, 0, i1, i2);
        paramDrawable.draw(localCanvas);
        return localObject;
      }
      return null;
    }
    catch (OutOfMemoryError paramDrawable) {}
  }
  
  /* Error */
  public static Bitmap a(File paramFile, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +10 -> 11
    //   4: aload_0
    //   5: invokevirtual 612	java/io/File:exists	()Z
    //   8: ifne +7 -> 15
    //   11: aconst_null
    //   12: astore_0
    //   13: aload_0
    //   14: areturn
    //   15: aconst_null
    //   16: astore 10
    //   18: aload_0
    //   19: iload_1
    //   20: iload_1
    //   21: invokestatic 615	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/io/File;II)Landroid/graphics/BitmapFactory$Options;
    //   24: astore 11
    //   26: new 617	java/io/FileInputStream
    //   29: dup
    //   30: aload_0
    //   31: invokespecial 620	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   34: astore_0
    //   35: aload 11
    //   37: getstatic 306	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   40: putfield 623	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   43: aload_0
    //   44: aconst_null
    //   45: aload 11
    //   47: invokestatic 116	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   50: astore 11
    //   52: new 489	android/graphics/Matrix
    //   55: dup
    //   56: invokespecial 490	android/graphics/Matrix:<init>	()V
    //   59: astore 10
    //   61: aload 11
    //   63: invokevirtual 335	android/graphics/Bitmap:getWidth	()I
    //   66: istore 9
    //   68: aload 11
    //   70: invokevirtual 407	android/graphics/Bitmap:getHeight	()I
    //   73: istore 8
    //   75: fconst_1
    //   76: fstore 4
    //   78: iload 8
    //   80: iload 9
    //   82: if_icmple +144 -> 226
    //   85: iload_1
    //   86: i2f
    //   87: iload 9
    //   89: i2f
    //   90: fconst_1
    //   91: fmul
    //   92: fdiv
    //   93: fstore 5
    //   95: fload 5
    //   97: fstore 4
    //   99: iload 8
    //   101: i2f
    //   102: fload 5
    //   104: fmul
    //   105: iload_2
    //   106: i2f
    //   107: fcmpl
    //   108: ifle +302 -> 410
    //   111: iconst_0
    //   112: iload 8
    //   114: i2f
    //   115: fload 5
    //   117: fmul
    //   118: iload_2
    //   119: i2f
    //   120: fsub
    //   121: fconst_2
    //   122: fdiv
    //   123: f2i
    //   124: invokestatic 529	java/lang/Math:max	(II)I
    //   127: istore 6
    //   129: iconst_0
    //   130: istore 7
    //   132: fload 5
    //   134: fstore 4
    //   136: aload 10
    //   138: fload 4
    //   140: fload 4
    //   142: invokevirtual 494	android/graphics/Matrix:postScale	(FF)Z
    //   145: pop
    //   146: aload 11
    //   148: iconst_0
    //   149: iconst_0
    //   150: iload 9
    //   152: iload 8
    //   154: aload 10
    //   156: iconst_1
    //   157: invokestatic 578	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   160: iload 7
    //   162: iload 6
    //   164: iload_1
    //   165: iload_2
    //   166: invokestatic 536	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIII)Landroid/graphics/Bitmap;
    //   169: astore 11
    //   171: aload 11
    //   173: astore 10
    //   175: iload_3
    //   176: ifeq +23 -> 199
    //   179: aload 11
    //   181: ldc_w 554
    //   184: aload 11
    //   186: invokevirtual 335	android/graphics/Bitmap:getWidth	()I
    //   189: aload 11
    //   191: invokevirtual 407	android/graphics/Bitmap:getHeight	()I
    //   194: invokestatic 553	com/tencent/mobileqq/utils/ImageUtil:a	(Landroid/graphics/Bitmap;FII)Landroid/graphics/Bitmap;
    //   197: astore 10
    //   199: aload_0
    //   200: ifnull +7 -> 207
    //   203: aload_0
    //   204: invokevirtual 626	java/io/InputStream:close	()V
    //   207: aload 10
    //   209: astore_0
    //   210: iconst_0
    //   211: ifeq -198 -> 13
    //   214: new 628	java/lang/NullPointerException
    //   217: dup
    //   218: invokespecial 629	java/lang/NullPointerException:<init>	()V
    //   221: athrow
    //   222: astore_0
    //   223: aload 10
    //   225: areturn
    //   226: iload 8
    //   228: iload 9
    //   230: if_icmpge +180 -> 410
    //   233: iload_2
    //   234: i2f
    //   235: iload 8
    //   237: i2f
    //   238: fconst_1
    //   239: fmul
    //   240: fdiv
    //   241: fstore 5
    //   243: fload 5
    //   245: fstore 4
    //   247: iload 9
    //   249: i2f
    //   250: fload 5
    //   252: fmul
    //   253: iload_1
    //   254: i2f
    //   255: fcmpl
    //   256: ifle +154 -> 410
    //   259: iload 9
    //   261: i2f
    //   262: fload 5
    //   264: fmul
    //   265: iload_1
    //   266: i2f
    //   267: fsub
    //   268: fconst_2
    //   269: fdiv
    //   270: f2i
    //   271: istore 6
    //   273: iconst_0
    //   274: iload 6
    //   276: invokestatic 529	java/lang/Math:max	(II)I
    //   279: istore 7
    //   281: iconst_0
    //   282: istore 6
    //   284: fload 5
    //   286: fstore 4
    //   288: goto -152 -> 136
    //   291: astore_0
    //   292: aload 10
    //   294: astore_0
    //   295: aload_0
    //   296: ifnull +7 -> 303
    //   299: aload_0
    //   300: invokevirtual 626	java/io/InputStream:close	()V
    //   303: iconst_0
    //   304: ifeq +11 -> 315
    //   307: new 628	java/lang/NullPointerException
    //   310: dup
    //   311: invokespecial 629	java/lang/NullPointerException:<init>	()V
    //   314: athrow
    //   315: aconst_null
    //   316: areturn
    //   317: astore_0
    //   318: aconst_null
    //   319: astore_0
    //   320: aload_0
    //   321: ifnull +7 -> 328
    //   324: aload_0
    //   325: invokevirtual 626	java/io/InputStream:close	()V
    //   328: iconst_0
    //   329: ifeq -14 -> 315
    //   332: new 628	java/lang/NullPointerException
    //   335: dup
    //   336: invokespecial 629	java/lang/NullPointerException:<init>	()V
    //   339: athrow
    //   340: astore_0
    //   341: goto -26 -> 315
    //   344: astore 10
    //   346: aconst_null
    //   347: astore_0
    //   348: aload_0
    //   349: ifnull +7 -> 356
    //   352: aload_0
    //   353: invokevirtual 626	java/io/InputStream:close	()V
    //   356: iconst_0
    //   357: ifeq +11 -> 368
    //   360: new 628	java/lang/NullPointerException
    //   363: dup
    //   364: invokespecial 629	java/lang/NullPointerException:<init>	()V
    //   367: athrow
    //   368: aload 10
    //   370: athrow
    //   371: astore_0
    //   372: goto -165 -> 207
    //   375: astore_0
    //   376: goto -73 -> 303
    //   379: astore_0
    //   380: goto -65 -> 315
    //   383: astore_0
    //   384: goto -56 -> 328
    //   387: astore_0
    //   388: goto -32 -> 356
    //   391: astore_0
    //   392: goto -24 -> 368
    //   395: astore 10
    //   397: goto -49 -> 348
    //   400: astore 10
    //   402: goto -82 -> 320
    //   405: astore 10
    //   407: goto -112 -> 295
    //   410: iconst_0
    //   411: istore 6
    //   413: iconst_0
    //   414: istore 7
    //   416: goto -280 -> 136
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	419	0	paramFile	File
    //   0	419	1	paramInt1	int
    //   0	419	2	paramInt2	int
    //   0	419	3	paramBoolean	boolean
    //   76	211	4	f1	float
    //   93	192	5	f2	float
    //   127	285	6	i1	int
    //   130	285	7	i2	int
    //   73	163	8	i3	int
    //   66	194	9	i4	int
    //   16	277	10	localObject1	Object
    //   344	25	10	localObject2	Object
    //   395	1	10	localObject3	Object
    //   400	1	10	localOutOfMemoryError	OutOfMemoryError
    //   405	1	10	localException	Exception
    //   24	166	11	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   214	222	222	java/io/IOException
    //   18	35	291	java/lang/Exception
    //   18	35	317	java/lang/OutOfMemoryError
    //   332	340	340	java/io/IOException
    //   18	35	344	finally
    //   203	207	371	java/io/IOException
    //   299	303	375	java/io/IOException
    //   307	315	379	java/io/IOException
    //   324	328	383	java/io/IOException
    //   352	356	387	java/io/IOException
    //   360	368	391	java/io/IOException
    //   35	75	395	finally
    //   85	95	395	finally
    //   111	129	395	finally
    //   136	171	395	finally
    //   179	199	395	finally
    //   273	281	395	finally
    //   35	75	400	java/lang/OutOfMemoryError
    //   85	95	400	java/lang/OutOfMemoryError
    //   111	129	400	java/lang/OutOfMemoryError
    //   136	171	400	java/lang/OutOfMemoryError
    //   179	199	400	java/lang/OutOfMemoryError
    //   273	281	400	java/lang/OutOfMemoryError
    //   35	75	405	java/lang/Exception
    //   85	95	405	java/lang/Exception
    //   111	129	405	java/lang/Exception
    //   136	171	405	java/lang/Exception
    //   179	199	405	java/lang/Exception
    //   273	281	405	java/lang/Exception
  }
  
  public static Bitmap a(String paramString, int paramInt1, int paramInt2)
  {
    Object localObject = null;
    if (paramString != null) {}
    try
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      localObject = new FileInputStream(paramString);
      BitmapFactory.decodeStream((InputStream)localObject, null, localOptions);
      int i1 = localOptions.outWidth;
      int i2 = localOptions.outHeight;
      localOptions = new BitmapFactory.Options();
      localOptions.inSampleSize = Math.max(i1 / paramInt1, i2 / paramInt2);
      localOptions.inJustDecodeBounds = false;
      localOptions.inPurgeable = true;
      ((InputStream)localObject).close();
      localObject = BitmapFactory.decodeStream(new FileInputStream(paramString), null, localOptions);
      return localObject;
    }
    catch (Throwable paramString) {}
    return null;
  }
  
  public static BitmapFactory.Options a(BitmapFactory.Options paramOptions, String paramString, int paramInt)
  {
    int i4 = 1;
    paramOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, paramOptions);
    int i1 = paramOptions.outHeight;
    int i3 = paramOptions.outWidth;
    int i2 = 1;
    if ((i1 > paramInt) || (i3 > paramInt))
    {
      if (Math.round(Math.max(i1, i3) / (paramInt * 1.0F)) < 2) {
        break label144;
      }
      i3 /= 2;
      i1 /= 2;
      if ((i3 >= paramInt) || (i1 >= paramInt)) {
        break label113;
      }
      paramOptions.inSampleSize = i2;
    }
    label144:
    for (;;)
    {
      paramOptions.inJustDecodeBounds = false;
      paramInt = i4;
      if (paramOptions.inSampleSize >= 1) {
        paramInt = paramOptions.inSampleSize;
      }
      paramOptions.inSampleSize = paramInt;
      return paramOptions;
      label113:
      if ((i3 == paramInt) || (i1 == paramInt))
      {
        paramOptions.inSampleSize = (i2 * 2);
      }
      else
      {
        i2 *= 2;
        break;
        paramOptions.inSampleSize = i2;
      }
    }
  }
  
  private static BitmapFactory.Options a(File paramFile)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramFile.getPath(), localOptions);
    return localOptions;
  }
  
  public static BitmapFactory.Options a(File paramFile, int paramInt1, int paramInt2)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    FileInputStream localFileInputStream = new FileInputStream(paramFile);
    double d1 = a(localFileInputStream, paramInt1, paramInt2);
    localFileInputStream.close();
    localOptions.inSampleSize = ((int)d1);
    localOptions.inJustDecodeBounds = true;
    localFileInputStream = new FileInputStream(paramFile);
    BitmapFactory.decodeStream(localFileInputStream, null, localOptions);
    localFileInputStream.close();
    paramInt2 = 0;
    for (;;)
    {
      if (localOptions.outWidth > paramInt1)
      {
        localOptions.inSampleSize += 1;
        localFileInputStream = new FileInputStream(paramFile);
        BitmapFactory.decodeStream(localFileInputStream, null, localOptions);
        localFileInputStream.close();
        if (paramInt2 <= 3) {}
      }
      else
      {
        localOptions.inJustDecodeBounds = false;
        return localOptions;
      }
      paramInt2 += 1;
    }
  }
  
  public static BitmapFactory.Options a(InputStream paramInputStream)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeStream(paramInputStream, null, localOptions);
    return localOptions;
  }
  
  public static BitmapFactory.Options a(String paramString, int paramInt)
  {
    int i4 = 1;
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions);
    int i1 = localOptions.outHeight;
    int i3 = localOptions.outWidth;
    a("compressAIOThumbImg  org width:" + i3 + ",height:" + i1);
    int i2 = 1;
    if ((i1 > paramInt) && (i3 > paramInt))
    {
      if (Math.min(Math.round(i1 / paramInt), Math.round(i3 / paramInt)) < 2) {
        break label198;
      }
      i3 /= 2;
      i1 /= 2;
      if ((i3 >= paramInt) && (i1 >= paramInt)) {
        break label169;
      }
      localOptions.inSampleSize = i2;
    }
    for (;;)
    {
      localOptions.inJustDecodeBounds = false;
      paramInt = i4;
      if (localOptions.inSampleSize >= 1) {
        paramInt = localOptions.inSampleSize;
      }
      localOptions.inSampleSize = paramInt;
      return localOptions;
      label169:
      if ((i3 == paramInt) || (i1 == paramInt))
      {
        localOptions.inSampleSize = (i2 * 2);
      }
      else
      {
        i2 *= 2;
        break;
        label198:
        localOptions.inSampleSize = i2;
      }
    }
  }
  
  public static Rect a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, ImageUtil.ScalingLogic paramScalingLogic)
  {
    if (paramScalingLogic == ImageUtil.ScalingLogic.CROP)
    {
      float f1 = paramInt1 / paramInt2;
      float f2 = paramInt3 / paramInt4;
      if (f1 > f2)
      {
        paramInt3 = (int)(paramInt2 * f2);
        paramInt1 = (paramInt1 - paramInt3) / 2;
        return new Rect(paramInt1, 0, paramInt3 + paramInt1, paramInt2);
      }
      paramInt3 = (int)(paramInt1 / f2);
      paramInt2 = (paramInt2 - paramInt3) / 2;
      return new Rect(0, paramInt2, paramInt1, paramInt3 + paramInt2);
    }
    return new Rect(0, 0, paramInt1, paramInt2);
  }
  
  public static Rect a(Rect paramRect, int paramInt, float paramFloat)
  {
    if ((paramRect != null) && (paramInt > 0) && (paramFloat > 0.0F))
    {
      int i3 = (int)(paramInt * paramFloat);
      int i1 = paramRect.width();
      int i2 = paramRect.width();
      if (i1 > i2) {}
      for (paramInt = i1; paramInt < i3; paramInt = i2)
      {
        paramRect = new Rect();
        a(paramRect, i1, i2, i3);
        return paramRect;
      }
    }
    return null;
  }
  
  public static Rect a(Drawable paramDrawable, int paramInt, float paramFloat)
  {
    int i3;
    int i1;
    int i2;
    if ((paramDrawable != null) && (paramInt > 0) && (paramFloat > 0.0F))
    {
      i3 = (int)(paramInt * paramFloat);
      i1 = paramDrawable.getIntrinsicWidth();
      i2 = paramDrawable.getIntrinsicHeight();
      if ((i1 != -1) && (i2 != -1)) {
        break label45;
      }
    }
    for (;;)
    {
      return null;
      label45:
      if (i1 > i2) {}
      for (paramInt = i1; paramInt < i3; paramInt = i2)
      {
        paramDrawable = new Rect();
        a(paramDrawable, i1, i2, i3);
        return paramDrawable;
      }
    }
  }
  
  public static Rect a(Drawable paramDrawable, int paramInt1, int paramInt2, float paramFloat)
  {
    Rect localRect = new Rect();
    int i2;
    int i3;
    if ((paramDrawable != null) && (paramInt2 > 0) && (paramInt1 > 0) && (paramInt2 > paramInt1) && (paramFloat > 0.0F))
    {
      i2 = paramDrawable.getIntrinsicWidth();
      i3 = paramDrawable.getIntrinsicHeight();
      if (i2 <= i3) {
        break label78;
      }
    }
    label78:
    for (int i1 = i2; i1 < paramInt1; i1 = i3)
    {
      a(localRect, i2, i3, (int)(paramInt1 * paramFloat));
      return localRect;
    }
    if ((i1 >= paramInt1) && (i1 < paramInt2))
    {
      localRect.set(0, 0, (int)(i2 * paramFloat), (int)(i3 * paramFloat));
      return localRect;
    }
    a(localRect, i2, i3, (int)(paramInt2 * paramFloat));
    return localRect;
  }
  
  public static Drawable a()
  {
    return new BitmapDrawable(b());
  }
  
  public static Drawable a(int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, ArrayList paramArrayList)
  {
    int i2 = paramInt1 * paramInt2;
    int[] arrayOfInt = new int[i2];
    int i1 = 0;
    while (i1 < i2)
    {
      arrayOfInt[i1] = -2631723;
      i1 += 1;
    }
    i1 = (int)(3.0F * paramFloat);
    i2 = (int)(2.0F * paramFloat);
    int i3 = (int)(32.0F * paramFloat);
    return a(paramInt1, paramInt2, paramFloat, arrayOfInt, -2631723, i1, i2, i3, i3, paramInt3, paramInt4, paramArrayList);
  }
  
  public static Drawable a(int paramInt1, int paramInt2, float paramFloat, int[] paramArrayOfInt, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, ArrayList paramArrayList)
  {
    Bitmap localBitmap = null;
    Object localObject = localBitmap;
    if (paramArrayList != null)
    {
      localObject = localBitmap;
      if (paramArrayList.size() > 0)
      {
        localObject = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
        ((Bitmap)localObject).setPixels(paramArrayOfInt, 0, paramInt1, 0, 0, paramInt1, paramInt2);
        paramArrayOfInt = new Canvas((Bitmap)localObject);
        paramArrayList = paramArrayList.iterator();
        paramInt1 = 0;
        if (paramArrayList.hasNext())
        {
          localBitmap = (Bitmap)paramArrayList.next();
          if (paramInt1 < 2)
          {
            paramInt2 = paramInt4;
            label95:
            if (paramInt1 % 2 != 0) {
              break label144;
            }
          }
          label144:
          for (int i1 = paramInt4;; i1 = paramInt6 + paramInt4 + paramInt5)
          {
            a(localBitmap, paramArrayOfInt, i1, paramInt2, localBitmap.getWidth() / paramInt8, paramInt3);
            paramInt1 += 1;
            break;
            paramInt2 = paramInt7 + paramInt4 + paramInt5;
            break label95;
          }
        }
        localObject = new BitmapDrawable(a((Bitmap)localObject, ((Bitmap)localObject).getWidth() / paramInt9));
      }
    }
    return localObject;
  }
  
  public static File a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    File localFile = new File(paramString);
    try
    {
      if (!localFile.exists())
      {
        int i1 = paramString.lastIndexOf('/');
        if ((i1 > 0) && (i1 < paramString.length() - 1))
        {
          paramString = new File(paramString.substring(0, i1));
          if (!paramString.exists()) {
            paramString.mkdirs();
          }
        }
      }
      for (;;)
      {
        localFile.createNewFile();
        return localFile;
        localFile.delete();
      }
      return null;
    }
    catch (IOException paramString) {}
  }
  
  public static String a(Context paramContext, Uri paramUri)
  {
    Object localObject = AppConstants.as + "thumb/";
    if (paramUri == null) {
      paramContext = "";
    }
    do
    {
      do
      {
        return paramContext;
        paramUri = c(paramContext, paramUri);
        paramContext = paramUri;
      } while (paramUri.startsWith((String)localObject));
      paramContext = paramUri.substring(paramUri.lastIndexOf("/") + 1);
      paramUri = (String)localObject + paramUri.hashCode() + paramContext;
      localObject = new File((String)localObject);
      paramContext = paramUri;
    } while (((File)localObject).exists());
    ((File)localObject).mkdirs();
    return paramUri;
  }
  
  public static String a(Context paramContext, String paramString)
  {
    if (paramString == null) {
      paramContext = "";
    }
    Object localObject;
    do
    {
      do
      {
        return paramContext;
        localObject = AppConstants.as + "thumb/";
        paramContext = paramString;
      } while (paramString.startsWith((String)localObject));
      paramContext = paramString.substring(paramString.lastIndexOf("/") + 1);
      paramString = (String)localObject + paramString.hashCode() + paramContext;
      localObject = new File((String)localObject);
      paramContext = paramString;
    } while (((File)localObject).exists());
    ((File)localObject).mkdirs();
    return paramString;
  }
  
  public static String a(Context paramContext, String paramString, int paramInt)
  {
    return a(paramContext, paramString, paramInt, 0);
  }
  
  public static String a(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    int i1 = 1;
    if (paramString == null) {
      return "";
    }
    Object localObject = new File(paramString);
    long l1 = 0L;
    if (((File)localObject).exists()) {
      l1 = ((File)localObject).lastModified();
    }
    localObject = paramString.substring(paramString.lastIndexOf("/") + 1);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(AppConstants.as).append("photo/");
    if (NetworkUtil.b(paramContext)) {
      localStringBuffer.append("WIFI");
    }
    if ((paramInt1 == 1) || (paramInt1 == 1001) || (paramInt1 == 3000))
    {
      paramInt1 = 1;
      if (paramInt1 == 0) {
        break label185;
      }
    }
    label185:
    for (paramInt1 = i1;; paramInt1 = 0)
    {
      localStringBuffer.append(paramInt1);
      localStringBuffer.append("s").append(paramInt2);
      localStringBuffer.append((paramString + l1).hashCode()).append((String)localObject);
      return localStringBuffer.toString();
      paramInt1 = 0;
      break;
    }
  }
  
  /* Error */
  public static String a(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: new 343	java/io/File
    //   3: dup
    //   4: new 212	java/lang/StringBuilder
    //   7: dup
    //   8: invokespecial 213	java/lang/StringBuilder:<init>	()V
    //   11: getstatic 702	com/tencent/mobileqq/app/AppConstants:as	Ljava/lang/String;
    //   14: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: ldc 23
    //   19: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   25: invokespecial 677	java/io/File:<init>	(Ljava/lang/String;)V
    //   28: astore_0
    //   29: aload_0
    //   30: invokevirtual 612	java/io/File:exists	()Z
    //   33: ifne +8 -> 41
    //   36: aload_0
    //   37: invokevirtual 753	java/io/File:mkdir	()Z
    //   40: pop
    //   41: new 343	java/io/File
    //   44: dup
    //   45: aload_2
    //   46: invokespecial 677	java/io/File:<init>	(Ljava/lang/String;)V
    //   49: astore 10
    //   51: new 343	java/io/File
    //   54: dup
    //   55: aload_1
    //   56: invokespecial 677	java/io/File:<init>	(Ljava/lang/String;)V
    //   59: astore 11
    //   61: aload 11
    //   63: invokevirtual 612	java/io/File:exists	()Z
    //   66: ifne +5 -> 71
    //   69: aconst_null
    //   70: areturn
    //   71: aload 10
    //   73: invokevirtual 612	java/io/File:exists	()Z
    //   76: ifne +9 -> 85
    //   79: aload 10
    //   81: invokevirtual 693	java/io/File:createNewFile	()Z
    //   84: pop
    //   85: new 617	java/io/FileInputStream
    //   88: dup
    //   89: aload 11
    //   91: invokespecial 620	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   94: invokestatic 755	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/io/InputStream;)Landroid/graphics/BitmapFactory$Options;
    //   97: astore_0
    //   98: aload_0
    //   99: getfield 122	android/graphics/BitmapFactory$Options:outHeight	I
    //   102: istore 7
    //   104: aload_0
    //   105: getfield 119	android/graphics/BitmapFactory$Options:outWidth	I
    //   108: istore 8
    //   110: iload_3
    //   111: i2f
    //   112: iload 7
    //   114: iload 8
    //   116: invokestatic 529	java/lang/Math:max	(II)I
    //   119: i2f
    //   120: fdiv
    //   121: fstore 5
    //   123: iload 7
    //   125: iload 8
    //   127: invokestatic 529	java/lang/Math:max	(II)I
    //   130: iload_3
    //   131: if_icmpgt +334 -> 465
    //   134: fconst_1
    //   135: fstore 5
    //   137: new 105	android/graphics/BitmapFactory$Options
    //   140: dup
    //   141: invokespecial 106	android/graphics/BitmapFactory$Options:<init>	()V
    //   144: astore_0
    //   145: aload_0
    //   146: iload 7
    //   148: iload 8
    //   150: invokestatic 529	java/lang/Math:max	(II)I
    //   153: iload_3
    //   154: idiv
    //   155: putfield 355	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   158: aload_1
    //   159: aload_0
    //   160: invokestatic 359	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   163: astore_0
    //   164: aload_0
    //   165: ifnull +303 -> 468
    //   168: iload 8
    //   170: i2f
    //   171: fload 5
    //   173: fmul
    //   174: f2i
    //   175: istore_3
    //   176: fload 5
    //   178: iload 7
    //   180: i2f
    //   181: fmul
    //   182: f2i
    //   183: istore 7
    //   185: aload_0
    //   186: iload_3
    //   187: iload 7
    //   189: iconst_0
    //   190: invokestatic 533	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   193: astore_0
    //   194: aload_1
    //   195: invokestatic 757	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)I
    //   198: istore_3
    //   199: aload_0
    //   200: astore 9
    //   202: iload_3
    //   203: ifeq +68 -> 271
    //   206: aload_0
    //   207: astore 9
    //   209: iload_3
    //   210: bipush 90
    //   212: irem
    //   213: ifne +58 -> 271
    //   216: aload_0
    //   217: invokevirtual 335	android/graphics/Bitmap:getWidth	()I
    //   220: i2f
    //   221: fstore 5
    //   223: aload_0
    //   224: invokevirtual 407	android/graphics/Bitmap:getHeight	()I
    //   227: i2f
    //   228: fstore 6
    //   230: new 489	android/graphics/Matrix
    //   233: dup
    //   234: invokespecial 490	android/graphics/Matrix:<init>	()V
    //   237: astore 9
    //   239: aload 9
    //   241: iload_3
    //   242: i2f
    //   243: fload 5
    //   245: fconst_2
    //   246: fdiv
    //   247: fload 6
    //   249: fconst_2
    //   250: fdiv
    //   251: invokevirtual 761	android/graphics/Matrix:setRotate	(FFF)V
    //   254: aload_0
    //   255: iconst_0
    //   256: iconst_0
    //   257: fload 5
    //   259: f2i
    //   260: fload 6
    //   262: f2i
    //   263: aload 9
    //   265: iconst_1
    //   266: invokestatic 578	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   269: astore 9
    //   271: new 763	java/io/FileOutputStream
    //   274: dup
    //   275: aload 10
    //   277: invokespecial 764	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   280: astore_0
    //   281: aload 9
    //   283: getstatic 770	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   286: iload 4
    //   288: aload_0
    //   289: invokevirtual 774	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   292: pop
    //   293: aload_0
    //   294: ifnull +7 -> 301
    //   297: aload_0
    //   298: invokevirtual 777	java/io/OutputStream:close	()V
    //   301: aload_1
    //   302: astore_0
    //   303: aload 10
    //   305: invokevirtual 612	java/io/File:exists	()Z
    //   308: ifeq +162 -> 470
    //   311: aload 10
    //   313: invokevirtual 779	java/io/File:length	()J
    //   316: aload 11
    //   318: invokevirtual 779	java/io/File:length	()J
    //   321: lcmp
    //   322: ifge +123 -> 445
    //   325: aload_2
    //   326: astore_0
    //   327: goto +143 -> 470
    //   330: astore_0
    //   331: aload_0
    //   332: invokevirtual 780	java/io/IOException:toString	()Ljava/lang/String;
    //   335: invokestatic 367	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   338: goto -37 -> 301
    //   341: astore_0
    //   342: aload_0
    //   343: invokevirtual 781	java/io/FileNotFoundException:printStackTrace	()V
    //   346: aconst_null
    //   347: astore_0
    //   348: goto +122 -> 470
    //   351: astore_0
    //   352: aconst_null
    //   353: astore_0
    //   354: aload_0
    //   355: ifnull -54 -> 301
    //   358: aload_0
    //   359: invokevirtual 777	java/io/OutputStream:close	()V
    //   362: goto -61 -> 301
    //   365: astore_0
    //   366: aload_0
    //   367: invokevirtual 780	java/io/IOException:toString	()Ljava/lang/String;
    //   370: invokestatic 367	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   373: goto -72 -> 301
    //   376: astore_0
    //   377: aload_0
    //   378: invokevirtual 782	java/io/IOException:printStackTrace	()V
    //   381: aconst_null
    //   382: astore_0
    //   383: goto +87 -> 470
    //   386: astore_1
    //   387: aconst_null
    //   388: astore_0
    //   389: aload_0
    //   390: ifnull +7 -> 397
    //   393: aload_0
    //   394: invokevirtual 777	java/io/OutputStream:close	()V
    //   397: aload_1
    //   398: athrow
    //   399: astore_0
    //   400: invokestatic 787	java/lang/System:gc	()V
    //   403: new 212	java/lang/StringBuilder
    //   406: dup
    //   407: invokespecial 213	java/lang/StringBuilder:<init>	()V
    //   410: ldc_w 789
    //   413: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   416: aload_0
    //   417: invokevirtual 790	java/lang/OutOfMemoryError:toString	()Ljava/lang/String;
    //   420: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   423: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   426: invokestatic 367	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   429: aconst_null
    //   430: astore_0
    //   431: goto +39 -> 470
    //   434: astore_0
    //   435: aload_0
    //   436: invokevirtual 780	java/io/IOException:toString	()Ljava/lang/String;
    //   439: invokestatic 367	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   442: goto -45 -> 397
    //   445: aload 10
    //   447: invokevirtual 696	java/io/File:delete	()Z
    //   450: pop
    //   451: aload_1
    //   452: astore_0
    //   453: goto +17 -> 470
    //   456: astore_1
    //   457: goto -68 -> 389
    //   460: astore 9
    //   462: goto -108 -> 354
    //   465: goto -328 -> 137
    //   468: aconst_null
    //   469: areturn
    //   470: aload_0
    //   471: areturn
    //   472: astore_0
    //   473: aconst_null
    //   474: astore_0
    //   475: goto -311 -> 164
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	478	0	paramContext	Context
    //   0	478	1	paramString1	String
    //   0	478	2	paramString2	String
    //   0	478	3	paramInt1	int
    //   0	478	4	paramInt2	int
    //   121	137	5	f1	float
    //   228	33	6	f2	float
    //   102	86	7	i1	int
    //   108	61	8	i2	int
    //   200	82	9	localObject	Object
    //   460	1	9	localException	Exception
    //   49	397	10	localFile1	File
    //   59	258	11	localFile2	File
    // Exception table:
    //   from	to	target	type
    //   297	301	330	java/io/IOException
    //   0	41	341	java/io/FileNotFoundException
    //   41	69	341	java/io/FileNotFoundException
    //   71	85	341	java/io/FileNotFoundException
    //   85	134	341	java/io/FileNotFoundException
    //   137	158	341	java/io/FileNotFoundException
    //   158	164	341	java/io/FileNotFoundException
    //   185	199	341	java/io/FileNotFoundException
    //   216	271	341	java/io/FileNotFoundException
    //   297	301	341	java/io/FileNotFoundException
    //   303	325	341	java/io/FileNotFoundException
    //   331	338	341	java/io/FileNotFoundException
    //   358	362	341	java/io/FileNotFoundException
    //   366	373	341	java/io/FileNotFoundException
    //   393	397	341	java/io/FileNotFoundException
    //   397	399	341	java/io/FileNotFoundException
    //   435	442	341	java/io/FileNotFoundException
    //   445	451	341	java/io/FileNotFoundException
    //   271	281	351	java/lang/Exception
    //   358	362	365	java/io/IOException
    //   0	41	376	java/io/IOException
    //   41	69	376	java/io/IOException
    //   71	85	376	java/io/IOException
    //   85	134	376	java/io/IOException
    //   137	158	376	java/io/IOException
    //   158	164	376	java/io/IOException
    //   185	199	376	java/io/IOException
    //   216	271	376	java/io/IOException
    //   303	325	376	java/io/IOException
    //   331	338	376	java/io/IOException
    //   366	373	376	java/io/IOException
    //   397	399	376	java/io/IOException
    //   435	442	376	java/io/IOException
    //   445	451	376	java/io/IOException
    //   271	281	386	finally
    //   0	41	399	java/lang/OutOfMemoryError
    //   41	69	399	java/lang/OutOfMemoryError
    //   71	85	399	java/lang/OutOfMemoryError
    //   85	134	399	java/lang/OutOfMemoryError
    //   137	158	399	java/lang/OutOfMemoryError
    //   185	199	399	java/lang/OutOfMemoryError
    //   216	271	399	java/lang/OutOfMemoryError
    //   297	301	399	java/lang/OutOfMemoryError
    //   303	325	399	java/lang/OutOfMemoryError
    //   331	338	399	java/lang/OutOfMemoryError
    //   358	362	399	java/lang/OutOfMemoryError
    //   366	373	399	java/lang/OutOfMemoryError
    //   393	397	399	java/lang/OutOfMemoryError
    //   397	399	399	java/lang/OutOfMemoryError
    //   435	442	399	java/lang/OutOfMemoryError
    //   445	451	399	java/lang/OutOfMemoryError
    //   393	397	434	java/io/IOException
    //   281	293	456	finally
    //   281	293	460	java/lang/Exception
    //   158	164	472	java/lang/OutOfMemoryError
  }
  
  /* Error */
  public static String a(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: new 343	java/io/File
    //   6: dup
    //   7: aload_1
    //   8: invokespecial 677	java/io/File:<init>	(Ljava/lang/String;)V
    //   11: astore_0
    //   12: aload_0
    //   13: iload_3
    //   14: iload 4
    //   16: invokestatic 615	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/io/File;II)Landroid/graphics/BitmapFactory$Options;
    //   19: astore 7
    //   21: new 617	java/io/FileInputStream
    //   24: dup
    //   25: aload_0
    //   26: invokespecial 620	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   29: astore_1
    //   30: aload_1
    //   31: astore_0
    //   32: aload_1
    //   33: aload 7
    //   35: aload_2
    //   36: bipush 100
    //   38: iload 5
    //   40: invokestatic 149	java/lang/Math:min	(II)I
    //   43: invokestatic 794	com/tencent/mobileqq/utils/ImageUtil:b	(Ljava/io/InputStream;Landroid/graphics/BitmapFactory$Options;Ljava/lang/String;I)Ljava/lang/String;
    //   46: astore_2
    //   47: aload_2
    //   48: astore_0
    //   49: aload_1
    //   50: ifnull +9 -> 59
    //   53: aload_1
    //   54: invokevirtual 626	java/io/InputStream:close	()V
    //   57: aload_2
    //   58: astore_0
    //   59: aload_0
    //   60: areturn
    //   61: astore_1
    //   62: aload_1
    //   63: invokevirtual 782	java/io/IOException:printStackTrace	()V
    //   66: aload_2
    //   67: astore_0
    //   68: invokestatic 208	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   71: ifeq -12 -> 59
    //   74: ldc_w 796
    //   77: iconst_2
    //   78: aload_1
    //   79: invokevirtual 780	java/io/IOException:toString	()Ljava/lang/String;
    //   82: invokestatic 226	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   85: aload_2
    //   86: areturn
    //   87: astore_2
    //   88: aconst_null
    //   89: astore_1
    //   90: aload_1
    //   91: astore_0
    //   92: invokestatic 208	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   95: ifeq +16 -> 111
    //   98: aload_1
    //   99: astore_0
    //   100: ldc_w 796
    //   103: iconst_2
    //   104: ldc_w 798
    //   107: aload_2
    //   108: invokestatic 801	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   111: aload 6
    //   113: astore_0
    //   114: aload_1
    //   115: ifnull -56 -> 59
    //   118: aload_1
    //   119: invokevirtual 626	java/io/InputStream:close	()V
    //   122: aconst_null
    //   123: areturn
    //   124: astore_1
    //   125: aload_1
    //   126: invokevirtual 782	java/io/IOException:printStackTrace	()V
    //   129: aload 6
    //   131: astore_0
    //   132: invokestatic 208	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   135: ifeq -76 -> 59
    //   138: ldc_w 796
    //   141: iconst_2
    //   142: aload_1
    //   143: invokevirtual 780	java/io/IOException:toString	()Ljava/lang/String;
    //   146: invokestatic 226	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   149: aconst_null
    //   150: areturn
    //   151: astore_1
    //   152: aconst_null
    //   153: astore_0
    //   154: aload_0
    //   155: ifnull +7 -> 162
    //   158: aload_0
    //   159: invokevirtual 626	java/io/InputStream:close	()V
    //   162: aload_1
    //   163: athrow
    //   164: astore_0
    //   165: aload_0
    //   166: invokevirtual 782	java/io/IOException:printStackTrace	()V
    //   169: invokestatic 208	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   172: ifeq -10 -> 162
    //   175: ldc_w 796
    //   178: iconst_2
    //   179: aload_0
    //   180: invokevirtual 780	java/io/IOException:toString	()Ljava/lang/String;
    //   183: invokestatic 226	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   186: goto -24 -> 162
    //   189: astore_1
    //   190: goto -36 -> 154
    //   193: astore_2
    //   194: goto -104 -> 90
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	197	0	paramContext	Context
    //   0	197	1	paramString1	String
    //   0	197	2	paramString2	String
    //   0	197	3	paramInt1	int
    //   0	197	4	paramInt2	int
    //   0	197	5	paramInt3	int
    //   1	129	6	localObject	Object
    //   19	15	7	localOptions	BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   53	57	61	java/io/IOException
    //   3	30	87	java/lang/Exception
    //   118	122	124	java/io/IOException
    //   3	30	151	finally
    //   158	162	164	java/io/IOException
    //   32	47	189	finally
    //   92	98	189	finally
    //   100	111	189	finally
    //   32	47	193	java/lang/Exception
  }
  
  public static String a(FileInputStream paramFileInputStream)
  {
    Object localObject = new byte[8];
    try
    {
      paramFileInputStream.read((byte[])localObject, 0, localObject.length);
      localObject = HexUtil.a((byte[])localObject).toUpperCase();
      if (((String)localObject).contains("FFD8FF"))
      {
        paramFileInputStream = "jpg";
        return paramFileInputStream;
      }
    }
    catch (IOException paramFileInputStream)
    {
      do
      {
        for (;;)
        {
          paramFileInputStream.printStackTrace();
        }
        if (((String)localObject).contains("89504E470D0A1A0A")) {
          return "png";
        }
        if (((String)localObject).contains("47494638")) {
          return "gif";
        }
        if (((String)localObject).contains("49492A00")) {
          return "tif";
        }
        if (((String)localObject).contains("424D")) {
          return "bmp";
        }
        if (((String)localObject).contains("0A")) {
          return "pcx";
        }
        if ((((String)localObject).contains("4D4D")) || (((String)localObject).contains("4949"))) {
          return "tiff";
        }
        if (((String)localObject).contains("464F524D")) {
          return "iff";
        }
        if (((String)localObject).contains("52494646")) {
          return "ani";
        }
        if (((String)localObject).contains("0000020000")) {
          return "tga";
        }
        if (((String)localObject).contains("0000100000")) {
          return "rle";
        }
        if (((String)localObject).contains("0000010001002020")) {
          return "ico";
        }
        paramFileInputStream = (FileInputStream)localObject;
      } while (!((String)localObject).contains("0000020001002020"));
    }
    return "cur";
  }
  
  /* Error */
  private static String a(InputStream paramInputStream, BitmapFactory.Options paramOptions, String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: getstatic 306	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   4: putfield 623	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   7: aload_0
    //   8: aconst_null
    //   9: aload_1
    //   10: invokestatic 116	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   13: astore 4
    //   15: aload 4
    //   17: ifnonnull +5 -> 22
    //   20: aconst_null
    //   21: areturn
    //   22: aload_2
    //   23: invokestatic 874	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)Ljava/io/File;
    //   26: astore_3
    //   27: new 763	java/io/FileOutputStream
    //   30: dup
    //   31: aload_3
    //   32: invokespecial 764	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   35: astore_0
    //   36: aload 4
    //   38: getstatic 877	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   41: bipush 100
    //   43: aload_0
    //   44: invokevirtual 774	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   47: pop
    //   48: aload_0
    //   49: ifnull +7 -> 56
    //   52: aload_0
    //   53: invokevirtual 777	java/io/OutputStream:close	()V
    //   56: aload 4
    //   58: ifnull +16 -> 74
    //   61: aload 4
    //   63: invokevirtual 581	android/graphics/Bitmap:isRecycled	()Z
    //   66: ifne +8 -> 74
    //   69: aload 4
    //   71: invokevirtual 539	android/graphics/Bitmap:recycle	()V
    //   74: aload_2
    //   75: astore_0
    //   76: aload_2
    //   77: ifnonnull +25 -> 102
    //   80: aload_2
    //   81: astore_0
    //   82: aload_3
    //   83: ifnull +19 -> 102
    //   86: aload_2
    //   87: astore_0
    //   88: aload_3
    //   89: invokevirtual 612	java/io/File:exists	()Z
    //   92: ifeq +10 -> 102
    //   95: aload_3
    //   96: invokevirtual 696	java/io/File:delete	()Z
    //   99: pop
    //   100: aload_2
    //   101: astore_0
    //   102: aload_0
    //   103: areturn
    //   104: astore_0
    //   105: aconst_null
    //   106: astore_0
    //   107: aload_0
    //   108: ifnull +7 -> 115
    //   111: aload_0
    //   112: invokevirtual 777	java/io/OutputStream:close	()V
    //   115: aload 4
    //   117: ifnull +16 -> 133
    //   120: aload 4
    //   122: invokevirtual 581	android/graphics/Bitmap:isRecycled	()Z
    //   125: ifne +8 -> 133
    //   128: aload 4
    //   130: invokevirtual 539	android/graphics/Bitmap:recycle	()V
    //   133: iconst_0
    //   134: ifne +157 -> 291
    //   137: aload_3
    //   138: ifnull +153 -> 291
    //   141: aload_3
    //   142: invokevirtual 612	java/io/File:exists	()Z
    //   145: ifeq +146 -> 291
    //   148: aload_3
    //   149: invokevirtual 696	java/io/File:delete	()Z
    //   152: pop
    //   153: aconst_null
    //   154: astore_0
    //   155: goto -53 -> 102
    //   158: astore_0
    //   159: aconst_null
    //   160: astore_0
    //   161: aload_0
    //   162: ifnull +7 -> 169
    //   165: aload_0
    //   166: invokevirtual 777	java/io/OutputStream:close	()V
    //   169: aload 4
    //   171: ifnull +16 -> 187
    //   174: aload 4
    //   176: invokevirtual 581	android/graphics/Bitmap:isRecycled	()Z
    //   179: ifne +8 -> 187
    //   182: aload 4
    //   184: invokevirtual 539	android/graphics/Bitmap:recycle	()V
    //   187: iconst_0
    //   188: ifne +103 -> 291
    //   191: aload_3
    //   192: ifnull +99 -> 291
    //   195: aload_3
    //   196: invokevirtual 612	java/io/File:exists	()Z
    //   199: ifeq +92 -> 291
    //   202: aload_3
    //   203: invokevirtual 696	java/io/File:delete	()Z
    //   206: pop
    //   207: aconst_null
    //   208: astore_0
    //   209: goto -107 -> 102
    //   212: astore_1
    //   213: aconst_null
    //   214: astore_0
    //   215: aload_0
    //   216: ifnull +7 -> 223
    //   219: aload_0
    //   220: invokevirtual 777	java/io/OutputStream:close	()V
    //   223: aload 4
    //   225: ifnull +16 -> 241
    //   228: aload 4
    //   230: invokevirtual 581	android/graphics/Bitmap:isRecycled	()Z
    //   233: ifne +8 -> 241
    //   236: aload 4
    //   238: invokevirtual 539	android/graphics/Bitmap:recycle	()V
    //   241: aload_2
    //   242: ifnonnull +19 -> 261
    //   245: aload_3
    //   246: ifnull +15 -> 261
    //   249: aload_3
    //   250: invokevirtual 612	java/io/File:exists	()Z
    //   253: ifeq +8 -> 261
    //   256: aload_3
    //   257: invokevirtual 696	java/io/File:delete	()Z
    //   260: pop
    //   261: aload_1
    //   262: athrow
    //   263: astore_0
    //   264: goto -208 -> 56
    //   267: astore_0
    //   268: goto -153 -> 115
    //   271: astore_0
    //   272: goto -103 -> 169
    //   275: astore_0
    //   276: goto -53 -> 223
    //   279: astore_1
    //   280: goto -65 -> 215
    //   283: astore_1
    //   284: goto -123 -> 161
    //   287: astore_1
    //   288: goto -181 -> 107
    //   291: aconst_null
    //   292: astore_0
    //   293: goto -191 -> 102
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	296	0	paramInputStream	InputStream
    //   0	296	1	paramOptions	BitmapFactory.Options
    //   0	296	2	paramString	String
    //   26	231	3	localFile	File
    //   13	224	4	localBitmap	Bitmap
    // Exception table:
    //   from	to	target	type
    //   27	36	104	java/lang/Exception
    //   27	36	158	java/lang/OutOfMemoryError
    //   27	36	212	finally
    //   52	56	263	java/io/IOException
    //   111	115	267	java/io/IOException
    //   165	169	271	java/io/IOException
    //   219	223	275	java/io/IOException
    //   36	48	279	finally
    //   36	48	283	java/lang/OutOfMemoryError
    //   36	48	287	java/lang/Exception
  }
  
  /* Error */
  private static String a(InputStream paramInputStream, BitmapFactory.Options paramOptions, String paramString, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aload_1
    //   4: getstatic 306	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   7: putfield 623	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   10: aload_0
    //   11: aconst_null
    //   12: aload_1
    //   13: invokestatic 116	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   16: astore_1
    //   17: aload_1
    //   18: ifnonnull +5 -> 23
    //   21: aconst_null
    //   22: areturn
    //   23: aload_2
    //   24: invokestatic 874	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)Ljava/io/File;
    //   27: astore_0
    //   28: aload_1
    //   29: invokevirtual 335	android/graphics/Bitmap:getWidth	()I
    //   32: i2f
    //   33: fstore 4
    //   35: aload_1
    //   36: invokevirtual 407	android/graphics/Bitmap:getHeight	()I
    //   39: i2f
    //   40: fstore 5
    //   42: new 489	android/graphics/Matrix
    //   45: dup
    //   46: invokespecial 490	android/graphics/Matrix:<init>	()V
    //   49: astore 7
    //   51: aload 7
    //   53: iload_3
    //   54: i2f
    //   55: fload 4
    //   57: fconst_2
    //   58: fdiv
    //   59: fload 5
    //   61: fconst_2
    //   62: fdiv
    //   63: invokevirtual 761	android/graphics/Matrix:setRotate	(FFF)V
    //   66: aload_1
    //   67: iconst_0
    //   68: iconst_0
    //   69: fload 4
    //   71: f2i
    //   72: fload 5
    //   74: f2i
    //   75: aload 7
    //   77: iconst_1
    //   78: invokestatic 578	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   81: astore 7
    //   83: new 763	java/io/FileOutputStream
    //   86: dup
    //   87: aload_0
    //   88: invokespecial 764	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   91: astore_1
    //   92: aload 7
    //   94: getstatic 877	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   97: bipush 100
    //   99: aload_1
    //   100: invokevirtual 774	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   103: pop
    //   104: aload_2
    //   105: astore_0
    //   106: aload_1
    //   107: ifnull +9 -> 116
    //   110: aload_1
    //   111: invokevirtual 777	java/io/OutputStream:close	()V
    //   114: aload_2
    //   115: astore_0
    //   116: aload_0
    //   117: areturn
    //   118: astore_0
    //   119: aconst_null
    //   120: astore_1
    //   121: aload_1
    //   122: ifnull +50 -> 172
    //   125: aload_1
    //   126: invokevirtual 777	java/io/OutputStream:close	()V
    //   129: aconst_null
    //   130: astore_0
    //   131: goto -15 -> 116
    //   134: astore_0
    //   135: aconst_null
    //   136: astore_0
    //   137: goto -21 -> 116
    //   140: astore_0
    //   141: aload 6
    //   143: astore_1
    //   144: aload_1
    //   145: ifnull +7 -> 152
    //   148: aload_1
    //   149: invokevirtual 777	java/io/OutputStream:close	()V
    //   152: aload_0
    //   153: athrow
    //   154: astore_0
    //   155: aload_2
    //   156: astore_0
    //   157: goto -41 -> 116
    //   160: astore_1
    //   161: goto -9 -> 152
    //   164: astore_0
    //   165: goto -21 -> 144
    //   168: astore_0
    //   169: goto -48 -> 121
    //   172: aconst_null
    //   173: astore_0
    //   174: goto -58 -> 116
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	177	0	paramInputStream	InputStream
    //   0	177	1	paramOptions	BitmapFactory.Options
    //   0	177	2	paramString	String
    //   0	177	3	paramInt	int
    //   33	37	4	f1	float
    //   40	33	5	f2	float
    //   1	141	6	localObject1	Object
    //   49	44	7	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   83	92	118	java/lang/Exception
    //   125	129	134	java/io/IOException
    //   83	92	140	finally
    //   110	114	154	java/io/IOException
    //   148	152	160	java/io/IOException
    //   92	104	164	finally
    //   92	104	168	java/lang/Exception
  }
  
  public static String a(String paramString, int paramInt)
  {
    String str = paramString.substring(paramString.lastIndexOf("/") + 1);
    return AppConstants.as + "photo/" + paramString.hashCode() + paramInt + str;
  }
  
  /* Error */
  public static String a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: new 343	java/io/File
    //   6: dup
    //   7: aload_0
    //   8: invokespecial 677	java/io/File:<init>	(Ljava/lang/String;)V
    //   11: astore_0
    //   12: aload_0
    //   13: iload_2
    //   14: iload_3
    //   15: invokestatic 615	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/io/File;II)Landroid/graphics/BitmapFactory$Options;
    //   18: astore 6
    //   20: new 617	java/io/FileInputStream
    //   23: dup
    //   24: aload_0
    //   25: invokespecial 620	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   28: astore_0
    //   29: aload_0
    //   30: aload 6
    //   32: aload_1
    //   33: bipush 100
    //   35: iload 4
    //   37: invokestatic 149	java/lang/Math:min	(II)I
    //   40: invokestatic 794	com/tencent/mobileqq/utils/ImageUtil:b	(Ljava/io/InputStream;Landroid/graphics/BitmapFactory$Options;Ljava/lang/String;I)Ljava/lang/String;
    //   43: astore_1
    //   44: aload_1
    //   45: astore 5
    //   47: aload 5
    //   49: astore_1
    //   50: aload_0
    //   51: ifnull +10 -> 61
    //   54: aload_0
    //   55: invokevirtual 626	java/io/InputStream:close	()V
    //   58: aload 5
    //   60: astore_1
    //   61: aload_1
    //   62: areturn
    //   63: astore_0
    //   64: aconst_null
    //   65: astore_0
    //   66: aload 5
    //   68: astore_1
    //   69: aload_0
    //   70: ifnull -9 -> 61
    //   73: aload_0
    //   74: invokevirtual 626	java/io/InputStream:close	()V
    //   77: aconst_null
    //   78: areturn
    //   79: astore_0
    //   80: aconst_null
    //   81: areturn
    //   82: astore_0
    //   83: aconst_null
    //   84: astore_0
    //   85: aload 5
    //   87: astore_1
    //   88: aload_0
    //   89: ifnull -28 -> 61
    //   92: aload_0
    //   93: invokevirtual 626	java/io/InputStream:close	()V
    //   96: aconst_null
    //   97: areturn
    //   98: astore_0
    //   99: aconst_null
    //   100: areturn
    //   101: astore_1
    //   102: aconst_null
    //   103: astore_0
    //   104: aload_0
    //   105: ifnull +7 -> 112
    //   108: aload_0
    //   109: invokevirtual 626	java/io/InputStream:close	()V
    //   112: aload_1
    //   113: athrow
    //   114: astore_0
    //   115: aload 5
    //   117: areturn
    //   118: astore_0
    //   119: goto -7 -> 112
    //   122: astore_1
    //   123: goto -19 -> 104
    //   126: astore_1
    //   127: goto -42 -> 85
    //   130: astore_1
    //   131: goto -65 -> 66
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	paramString1	String
    //   0	134	1	paramString2	String
    //   0	134	2	paramInt1	int
    //   0	134	3	paramInt2	int
    //   0	134	4	paramInt3	int
    //   1	115	5	str	String
    //   18	13	6	localOptions	BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   3	29	63	java/lang/Exception
    //   73	77	79	java/io/IOException
    //   3	29	82	java/lang/Error
    //   92	96	98	java/io/IOException
    //   3	29	101	finally
    //   54	58	114	java/io/IOException
    //   108	112	118	java/io/IOException
    //   29	44	122	finally
    //   29	44	126	java/lang/Error
    //   29	44	130	java/lang/Exception
  }
  
  private static void a(int paramInt1, int paramInt2, Context paramContext, boolean paramBoolean, String paramString)
  {
    a(paramInt1, paramInt2, paramContext, paramBoolean, null, paramString);
  }
  
  private static void a(int paramInt1, int paramInt2, Context paramContext, boolean paramBoolean, String paramString1, String paramString2)
  {
    if ((paramInt1 < 0) || (paramInt1 > 7) || (paramInt2 < 0) || (paramInt2 > 9)) {
      return;
    }
    String str2 = null;
    String str1 = str2;
    if (paramContext != null) {
      str1 = str2;
    }
    try
    {
      if ((paramContext instanceof BaseActivity)) {
        str1 = ((QQAppInterface)((BaseActivity)paramContext).getAppRuntime()).a();
      }
      localHashMap = new HashMap();
      if (paramBoolean) {
        break label231;
      }
      String str3 = String.valueOf(paramInt2 * 10 + paramInt1 + 88100);
      localHashMap.put("param_FailCode", str3);
      str2 = paramString2;
      if (paramString2 == null) {
        str2 = AbstractImageDownloader.a(new RuntimeException(str3));
      }
      if (!(paramContext instanceof Activity)) {
        break label213;
      }
      paramContext = ((Activity)paramContext).getCallingActivity();
      if (paramContext == null) {
        break label213;
      }
      localHashMap.put("param_callingActivity", paramContext.getClassName());
    }
    catch (Exception paramContext)
    {
      HashMap localHashMap;
      return;
    }
    localHashMap.put("param_sdCardSize", Long.toString(Utils.b()));
    label170:
    localHashMap.put("param_failMsg", str2);
    for (;;)
    {
      label184:
      StatisticCollector.a(BaseApplication.getContext()).a(str1, paramContext, paramBoolean, 0L, 0L, localHashMap, "");
      return;
      label213:
      label231:
      do
      {
        paramContext = paramString1;
        break label184;
        if ((paramInt2 == 9) || (paramInt2 == 0)) {
          break;
        }
        if (paramInt2 != 5) {
          break label170;
        }
        break;
      } while (paramString1 != null);
      paramContext = "report_sendphoto_file_error";
    }
  }
  
  /* Error */
  private static void a(int paramInt1, Context paramContext, File paramFile1, File paramFile2, ImageInfo paramImageInfo, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: aload 4
    //   2: ldc_w 946
    //   5: new 212	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 213	java/lang/StringBuilder:<init>	()V
    //   12: ldc_w 948
    //   15: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: iload 7
    //   20: invokevirtual 364	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   23: ldc_w 950
    //   26: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: iload 6
    //   31: invokevirtual 364	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   34: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: invokestatic 953	com/tencent/mobileqq/utils/ImageUtil:a	(Lcom/tencent/mobileqq/activity/photo/ImageInfo;Ljava/lang/String;Ljava/lang/String;)V
    //   40: iload 8
    //   42: ifeq +103 -> 145
    //   45: aload_1
    //   46: invokestatic 737	com/tencent/mobileqq/utils/NetworkUtil:b	(Landroid/content/Context;)Z
    //   49: ifeq +89 -> 138
    //   52: bipush 80
    //   54: istore 6
    //   56: iconst_0
    //   57: istore 7
    //   59: aload 4
    //   61: getfield 399	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_j_of_type_Int	I
    //   64: ifne +8 -> 72
    //   67: sipush 960
    //   70: istore 7
    //   72: aconst_null
    //   73: astore 14
    //   75: aconst_null
    //   76: astore 13
    //   78: iload_0
    //   79: aload_1
    //   80: aload_2
    //   81: iload 7
    //   83: aload 4
    //   85: invokestatic 955	com/tencent/mobileqq/utils/ImageUtil:a	(ILandroid/content/Context;Ljava/io/File;ILcom/tencent/mobileqq/activity/photo/ImageInfo;)Landroid/graphics/Bitmap;
    //   88: astore_1
    //   89: aload_1
    //   90: ifnonnull +62 -> 152
    //   93: aload 4
    //   95: iconst_0
    //   96: putfield 957	com/tencent/mobileqq/activity/photo/ImageInfo:h	Z
    //   99: aload_3
    //   100: invokevirtual 696	java/io/File:delete	()Z
    //   103: pop
    //   104: ldc_w 959
    //   107: invokestatic 367	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   110: iconst_0
    //   111: ifeq +11 -> 122
    //   114: new 628	java/lang/NullPointerException
    //   117: dup
    //   118: invokespecial 629	java/lang/NullPointerException:<init>	()V
    //   121: athrow
    //   122: aload_1
    //   123: ifnull +14 -> 137
    //   126: aload_1
    //   127: invokevirtual 581	android/graphics/Bitmap:isRecycled	()Z
    //   130: ifne +7 -> 137
    //   133: aload_1
    //   134: invokevirtual 539	android/graphics/Bitmap:recycle	()V
    //   137: return
    //   138: bipush 70
    //   140: istore 6
    //   142: goto -86 -> 56
    //   145: bipush 80
    //   147: istore 6
    //   149: goto -93 -> 56
    //   152: aload 4
    //   154: iconst_1
    //   155: putfield 957	com/tencent/mobileqq/activity/photo/ImageInfo:h	Z
    //   158: iload 9
    //   160: ifne +102 -> 262
    //   163: aload_1
    //   164: invokevirtual 335	android/graphics/Bitmap:getWidth	()I
    //   167: istore 10
    //   169: aload_1
    //   170: invokevirtual 407	android/graphics/Bitmap:getHeight	()I
    //   173: istore_0
    //   174: iload 10
    //   176: iload 7
    //   178: if_icmpgt +12 -> 190
    //   181: aload_1
    //   182: astore 13
    //   184: iload_0
    //   185: iload 7
    //   187: if_icmple +11 -> 198
    //   190: aload_1
    //   191: iload 7
    //   193: invokestatic 961	com/tencent/mobileqq/utils/ImageUtil:b	(Landroid/graphics/Bitmap;I)Landroid/graphics/Bitmap;
    //   196: astore 13
    //   198: aload 13
    //   200: astore_1
    //   201: aload_1
    //   202: ifnonnull +73 -> 275
    //   205: aload_1
    //   206: astore 13
    //   208: aload_1
    //   209: astore 14
    //   211: aload 4
    //   213: ldc_w 946
    //   216: ldc_w 963
    //   219: invokestatic 953	com/tencent/mobileqq/utils/ImageUtil:a	(Lcom/tencent/mobileqq/activity/photo/ImageInfo;Ljava/lang/String;Ljava/lang/String;)V
    //   222: aload_1
    //   223: astore 13
    //   225: aload_1
    //   226: astore 14
    //   228: aload 4
    //   230: iconst_1
    //   231: putfield 965	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_k_of_type_Boolean	Z
    //   234: iconst_0
    //   235: ifeq +11 -> 246
    //   238: new 628	java/lang/NullPointerException
    //   241: dup
    //   242: invokespecial 629	java/lang/NullPointerException:<init>	()V
    //   245: athrow
    //   246: aload_1
    //   247: ifnull -110 -> 137
    //   250: aload_1
    //   251: invokevirtual 581	android/graphics/Bitmap:isRecycled	()Z
    //   254: ifne -117 -> 137
    //   257: aload_1
    //   258: invokevirtual 539	android/graphics/Bitmap:recycle	()V
    //   261: return
    //   262: aload_1
    //   263: aload_2
    //   264: invokestatic 967	com/tencent/mobileqq/utils/ImageUtil:a	(Landroid/graphics/Bitmap;Ljava/io/File;)Landroid/graphics/Bitmap;
    //   267: astore 13
    //   269: aload 13
    //   271: astore_1
    //   272: goto -71 -> 201
    //   275: new 763	java/io/FileOutputStream
    //   278: dup
    //   279: aload_3
    //   280: invokespecial 764	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   283: astore 16
    //   285: aload 16
    //   287: astore 13
    //   289: aload 4
    //   291: aload_1
    //   292: getstatic 770	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   295: iload 6
    //   297: aload 16
    //   299: invokevirtual 774	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   302: putfield 969	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_l_of_type_Boolean	Z
    //   305: aload 16
    //   307: astore 13
    //   309: aload 4
    //   311: iconst_1
    //   312: putfield 971	com/tencent/mobileqq/activity/photo/ImageInfo:o	Z
    //   315: aload 16
    //   317: astore 13
    //   319: aload 4
    //   321: getfield 969	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_l_of_type_Boolean	Z
    //   324: ifeq +12 -> 336
    //   327: aload 16
    //   329: astore 13
    //   331: aload 16
    //   333: invokestatic 974	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/io/FileOutputStream;)V
    //   336: aload 16
    //   338: astore 13
    //   340: new 212	java/lang/StringBuilder
    //   343: dup
    //   344: invokespecial 213	java/lang/StringBuilder:<init>	()V
    //   347: ldc_w 976
    //   350: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: aload 4
    //   355: getfield 969	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_l_of_type_Boolean	Z
    //   358: invokevirtual 979	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   361: ldc_w 981
    //   364: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: aload_3
    //   368: invokevirtual 779	java/io/File:length	()J
    //   371: invokevirtual 746	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   374: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   377: invokestatic 367	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   380: aload 16
    //   382: astore 13
    //   384: aload 16
    //   386: ifnull +26 -> 412
    //   389: aload 16
    //   391: astore 15
    //   393: aload_1
    //   394: astore 21
    //   396: aload 16
    //   398: astore 14
    //   400: aload_1
    //   401: astore 18
    //   403: aload 16
    //   405: invokevirtual 982	java/io/FileOutputStream:close	()V
    //   408: aload 16
    //   410: astore 13
    //   412: iload 5
    //   414: iconst_1
    //   415: if_icmpeq +26 -> 441
    //   418: iload 5
    //   420: sipush 1001
    //   423: if_icmpeq +18 -> 441
    //   426: aload 13
    //   428: astore 19
    //   430: aload_1
    //   431: astore 20
    //   433: iload 5
    //   435: sipush 3000
    //   438: if_icmpne +830 -> 1268
    //   441: iload 5
    //   443: sipush 1001
    //   446: if_icmpne +583 -> 1029
    //   449: aload 13
    //   451: astore 15
    //   453: aload_1
    //   454: astore 21
    //   456: aload 13
    //   458: astore 14
    //   460: aload_1
    //   461: astore 18
    //   463: getstatic 985	com/tencent/common/config/AppSetting:d	I
    //   466: i2l
    //   467: lstore 11
    //   469: lload 11
    //   471: l2i
    //   472: istore 10
    //   474: aload 13
    //   476: astore 15
    //   478: aload_1
    //   479: astore 21
    //   481: aload 13
    //   483: astore 14
    //   485: aload_1
    //   486: astore 18
    //   488: new 212	java/lang/StringBuilder
    //   491: dup
    //   492: invokespecial 213	java/lang/StringBuilder:<init>	()V
    //   495: ldc_w 987
    //   498: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   501: iload 10
    //   503: invokevirtual 364	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   506: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   509: invokestatic 367	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   512: aload 13
    //   514: astore 15
    //   516: aload_1
    //   517: astore 21
    //   519: aload 13
    //   521: astore 14
    //   523: aload_1
    //   524: astore 18
    //   526: new 212	java/lang/StringBuilder
    //   529: dup
    //   530: invokespecial 213	java/lang/StringBuilder:<init>	()V
    //   533: ldc_w 989
    //   536: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   539: aload_3
    //   540: invokevirtual 779	java/io/File:length	()J
    //   543: invokevirtual 746	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   546: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   549: invokestatic 367	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   552: aload 13
    //   554: astore 17
    //   556: aload_1
    //   557: astore 16
    //   559: aload_3
    //   560: invokevirtual 779	java/io/File:length	()J
    //   563: iload 10
    //   565: i2l
    //   566: lcmp
    //   567: ifle +601 -> 1168
    //   570: aload 13
    //   572: astore 17
    //   574: aload_1
    //   575: astore 16
    //   577: aload_2
    //   578: invokestatic 995	com/tencent/image/GifDrawable:isGifFile	(Ljava/io/File;)Z
    //   581: ifne +587 -> 1168
    //   584: aload 4
    //   586: ldc_w 946
    //   589: ldc_w 997
    //   592: invokestatic 953	com/tencent/mobileqq/utils/ImageUtil:a	(Lcom/tencent/mobileqq/activity/photo/ImageInfo;Ljava/lang/String;Ljava/lang/String;)V
    //   595: aload 13
    //   597: astore 17
    //   599: aload_1
    //   600: astore 16
    //   602: aload_3
    //   603: invokevirtual 696	java/io/File:delete	()Z
    //   606: ifeq +562 -> 1168
    //   609: aload_3
    //   610: invokevirtual 693	java/io/File:createNewFile	()Z
    //   613: istore 8
    //   615: aload 13
    //   617: astore 17
    //   619: aload_1
    //   620: astore 16
    //   622: iload 8
    //   624: ifeq +544 -> 1168
    //   627: iconst_1
    //   628: istore 5
    //   630: iload 7
    //   632: istore_0
    //   633: iload 5
    //   635: iconst_1
    //   636: iadd
    //   637: istore 7
    //   639: iload 5
    //   641: iconst_4
    //   642: if_icmpge +496 -> 1138
    //   645: aload_1
    //   646: astore 14
    //   648: aload_1
    //   649: astore 15
    //   651: aload_3
    //   652: invokevirtual 779	java/io/File:length	()J
    //   655: iload 10
    //   657: i2l
    //   658: lcmp
    //   659: ifle +479 -> 1138
    //   662: aload_1
    //   663: astore 14
    //   665: aload_1
    //   666: astore 15
    //   668: new 212	java/lang/StringBuilder
    //   671: dup
    //   672: invokespecial 213	java/lang/StringBuilder:<init>	()V
    //   675: ldc_w 999
    //   678: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   681: iload 7
    //   683: invokevirtual 364	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   686: ldc_w 1001
    //   689: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   692: aload_3
    //   693: invokevirtual 779	java/io/File:length	()J
    //   696: invokevirtual 746	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   699: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   702: invokestatic 367	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   705: aload_1
    //   706: astore 14
    //   708: aload_1
    //   709: astore 15
    //   711: iload_0
    //   712: iload 7
    //   714: iconst_2
    //   715: ixor
    //   716: idiv
    //   717: istore_0
    //   718: iload_0
    //   719: ifne +1040 -> 1759
    //   722: iconst_1
    //   723: istore_0
    //   724: aload_1
    //   725: astore 14
    //   727: aload_1
    //   728: astore 15
    //   730: aload_1
    //   731: iload_0
    //   732: invokestatic 961	com/tencent/mobileqq/utils/ImageUtil:b	(Landroid/graphics/Bitmap;I)Landroid/graphics/Bitmap;
    //   735: astore_1
    //   736: aload_1
    //   737: ifnonnull +349 -> 1086
    //   740: aload_1
    //   741: astore 14
    //   743: aload_1
    //   744: astore 15
    //   746: aload 4
    //   748: iconst_1
    //   749: putfield 965	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_k_of_type_Boolean	Z
    //   752: aload 13
    //   754: ifnull +21 -> 775
    //   757: aload_1
    //   758: astore_3
    //   759: aload 13
    //   761: astore 15
    //   763: aload_1
    //   764: astore 16
    //   766: aload 13
    //   768: astore 14
    //   770: aload 13
    //   772: invokevirtual 982	java/io/FileOutputStream:close	()V
    //   775: aload_1
    //   776: ifnull +40 -> 816
    //   779: aload_1
    //   780: astore_3
    //   781: aload 13
    //   783: astore 15
    //   785: aload_1
    //   786: astore 16
    //   788: aload 13
    //   790: astore 14
    //   792: aload_1
    //   793: invokevirtual 581	android/graphics/Bitmap:isRecycled	()Z
    //   796: ifne +20 -> 816
    //   799: aload_1
    //   800: astore_3
    //   801: aload 13
    //   803: astore 15
    //   805: aload_1
    //   806: astore 16
    //   808: aload 13
    //   810: astore 14
    //   812: aload_1
    //   813: invokevirtual 539	android/graphics/Bitmap:recycle	()V
    //   816: aload 13
    //   818: ifnull +8 -> 826
    //   821: aload 13
    //   823: invokevirtual 982	java/io/FileOutputStream:close	()V
    //   826: aload_1
    //   827: ifnull -690 -> 137
    //   830: aload_1
    //   831: invokevirtual 581	android/graphics/Bitmap:isRecycled	()Z
    //   834: ifne -697 -> 137
    //   837: aload_1
    //   838: invokevirtual 539	android/graphics/Bitmap:recycle	()V
    //   841: return
    //   842: astore 13
    //   844: aconst_null
    //   845: astore 16
    //   847: aload 16
    //   849: astore 13
    //   851: aload 4
    //   853: iconst_0
    //   854: putfield 971	com/tencent/mobileqq/activity/photo/ImageInfo:o	Z
    //   857: aload 16
    //   859: astore 13
    //   861: aload 4
    //   863: invokestatic 1003	com/tencent/mobileqq/utils/ImageUtil:a	()Z
    //   866: putfield 1005	com/tencent/mobileqq/activity/photo/ImageInfo:m	Z
    //   869: aload 16
    //   871: astore 13
    //   873: ldc_w 1007
    //   876: invokestatic 367	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   879: aload 16
    //   881: astore 13
    //   883: aload 16
    //   885: ifnull -473 -> 412
    //   888: aload 16
    //   890: astore 15
    //   892: aload_1
    //   893: astore 21
    //   895: aload 16
    //   897: astore 14
    //   899: aload_1
    //   900: astore 18
    //   902: aload 16
    //   904: invokevirtual 982	java/io/FileOutputStream:close	()V
    //   907: aload 16
    //   909: astore 13
    //   911: goto -499 -> 412
    //   914: astore 13
    //   916: aload 16
    //   918: astore 13
    //   920: goto -508 -> 412
    //   923: astore_3
    //   924: aconst_null
    //   925: astore_2
    //   926: aload_2
    //   927: ifnull +19 -> 946
    //   930: aload_2
    //   931: astore 15
    //   933: aload_1
    //   934: astore 21
    //   936: aload_2
    //   937: astore 14
    //   939: aload_1
    //   940: astore 18
    //   942: aload_2
    //   943: invokevirtual 982	java/io/FileOutputStream:close	()V
    //   946: aload_2
    //   947: astore 15
    //   949: aload_1
    //   950: astore 21
    //   952: aload_2
    //   953: astore 14
    //   955: aload_1
    //   956: astore 18
    //   958: aload_3
    //   959: athrow
    //   960: astore_1
    //   961: aload 21
    //   963: astore_1
    //   964: aload 15
    //   966: astore 14
    //   968: aload_1
    //   969: astore 18
    //   971: aload 4
    //   973: iconst_0
    //   974: putfield 971	com/tencent/mobileqq/activity/photo/ImageInfo:o	Z
    //   977: aload 15
    //   979: astore 14
    //   981: aload_1
    //   982: astore 18
    //   984: aload 4
    //   986: iconst_1
    //   987: putfield 395	com/tencent/mobileqq/activity/photo/ImageInfo:g	Z
    //   990: aload 15
    //   992: astore 14
    //   994: aload_1
    //   995: astore 18
    //   997: ldc_w 1009
    //   1000: invokestatic 367	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   1003: aload 15
    //   1005: ifnull +8 -> 1013
    //   1008: aload 15
    //   1010: invokevirtual 982	java/io/FileOutputStream:close	()V
    //   1013: aload_1
    //   1014: ifnull -877 -> 137
    //   1017: aload_1
    //   1018: invokevirtual 581	android/graphics/Bitmap:isRecycled	()Z
    //   1021: ifne -884 -> 137
    //   1024: aload_1
    //   1025: invokevirtual 539	android/graphics/Bitmap:recycle	()V
    //   1028: return
    //   1029: ldc2_w 1010
    //   1032: lstore 11
    //   1034: goto -565 -> 469
    //   1037: astore_2
    //   1038: aload_1
    //   1039: astore_3
    //   1040: aload 13
    //   1042: astore 15
    //   1044: aload_1
    //   1045: astore 16
    //   1047: aload 13
    //   1049: astore 14
    //   1051: new 212	java/lang/StringBuilder
    //   1054: dup
    //   1055: invokespecial 213	java/lang/StringBuilder:<init>	()V
    //   1058: ldc_w 1013
    //   1061: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1064: aload_2
    //   1065: invokevirtual 1014	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1068: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1071: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1074: invokestatic 367	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   1077: goto -302 -> 775
    //   1080: astore_1
    //   1081: aload_3
    //   1082: astore_1
    //   1083: goto -119 -> 964
    //   1086: aload_1
    //   1087: astore 14
    //   1089: aload_1
    //   1090: astore 15
    //   1092: new 763	java/io/FileOutputStream
    //   1095: dup
    //   1096: aload_3
    //   1097: invokespecial 764	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   1100: astore_2
    //   1101: aload 4
    //   1103: aload_1
    //   1104: getstatic 770	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   1107: iload 6
    //   1109: aload_2
    //   1110: invokevirtual 774	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   1113: putfield 969	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_l_of_type_Boolean	Z
    //   1116: aload 4
    //   1118: getfield 969	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_l_of_type_Boolean	Z
    //   1121: ifeq +628 -> 1749
    //   1124: aload_2
    //   1125: invokestatic 974	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/io/FileOutputStream;)V
    //   1128: iload 7
    //   1130: istore 5
    //   1132: aload_2
    //   1133: astore 13
    //   1135: goto -502 -> 633
    //   1138: iload 7
    //   1140: iconst_4
    //   1141: if_icmplt +20 -> 1161
    //   1144: aload_1
    //   1145: astore 14
    //   1147: aload_1
    //   1148: astore 15
    //   1150: aload 4
    //   1152: ldc_w 946
    //   1155: ldc_w 1016
    //   1158: invokestatic 953	com/tencent/mobileqq/utils/ImageUtil:a	(Lcom/tencent/mobileqq/activity/photo/ImageInfo;Ljava/lang/String;Ljava/lang/String;)V
    //   1161: aload_1
    //   1162: astore 16
    //   1164: aload 13
    //   1166: astore 17
    //   1168: aload 17
    //   1170: ifnull +24 -> 1194
    //   1173: aload 17
    //   1175: astore 15
    //   1177: aload 16
    //   1179: astore 21
    //   1181: aload 17
    //   1183: astore 14
    //   1185: aload 16
    //   1187: astore 18
    //   1189: aload 17
    //   1191: invokevirtual 982	java/io/FileOutputStream:close	()V
    //   1194: aload 17
    //   1196: astore 19
    //   1198: aload 16
    //   1200: astore 20
    //   1202: aload 16
    //   1204: ifnull +64 -> 1268
    //   1207: aload 17
    //   1209: astore 15
    //   1211: aload 16
    //   1213: astore 21
    //   1215: aload 17
    //   1217: astore 19
    //   1219: aload 16
    //   1221: astore 20
    //   1223: aload 17
    //   1225: astore 14
    //   1227: aload 16
    //   1229: astore 18
    //   1231: aload 16
    //   1233: invokevirtual 581	android/graphics/Bitmap:isRecycled	()Z
    //   1236: ifne +32 -> 1268
    //   1239: aload 17
    //   1241: astore 15
    //   1243: aload 16
    //   1245: astore 21
    //   1247: aload 17
    //   1249: astore 14
    //   1251: aload 16
    //   1253: astore 18
    //   1255: aload 16
    //   1257: invokevirtual 539	android/graphics/Bitmap:recycle	()V
    //   1260: aload 16
    //   1262: astore 20
    //   1264: aload 17
    //   1266: astore 19
    //   1268: aload 19
    //   1270: ifnull +8 -> 1278
    //   1273: aload 19
    //   1275: invokevirtual 982	java/io/FileOutputStream:close	()V
    //   1278: aload 20
    //   1280: ifnull -1143 -> 137
    //   1283: aload 20
    //   1285: invokevirtual 581	android/graphics/Bitmap:isRecycled	()Z
    //   1288: ifne -1151 -> 137
    //   1291: aload 20
    //   1293: invokevirtual 539	android/graphics/Bitmap:recycle	()V
    //   1296: return
    //   1297: astore_1
    //   1298: aload 17
    //   1300: astore 15
    //   1302: aload 16
    //   1304: astore 21
    //   1306: aload 17
    //   1308: astore 14
    //   1310: aload 16
    //   1312: astore 18
    //   1314: new 212	java/lang/StringBuilder
    //   1317: dup
    //   1318: invokespecial 213	java/lang/StringBuilder:<init>	()V
    //   1321: ldc_w 1013
    //   1324: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1327: aload_1
    //   1328: invokevirtual 1014	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1331: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1334: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1337: invokestatic 367	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   1340: goto -146 -> 1194
    //   1343: astore_1
    //   1344: aload 18
    //   1346: astore_2
    //   1347: aload 14
    //   1349: ifnull +8 -> 1357
    //   1352: aload 14
    //   1354: invokevirtual 982	java/io/FileOutputStream:close	()V
    //   1357: aload_2
    //   1358: ifnull +14 -> 1372
    //   1361: aload_2
    //   1362: invokevirtual 581	android/graphics/Bitmap:isRecycled	()Z
    //   1365: ifne +7 -> 1372
    //   1368: aload_2
    //   1369: invokevirtual 539	android/graphics/Bitmap:recycle	()V
    //   1372: aload_1
    //   1373: athrow
    //   1374: astore_2
    //   1375: aload_1
    //   1376: astore_2
    //   1377: aload 13
    //   1379: astore_1
    //   1380: aload 4
    //   1382: iconst_0
    //   1383: putfield 971	com/tencent/mobileqq/activity/photo/ImageInfo:o	Z
    //   1386: aload 4
    //   1388: invokestatic 1003	com/tencent/mobileqq/utils/ImageUtil:a	()Z
    //   1391: putfield 1005	com/tencent/mobileqq/activity/photo/ImageInfo:m	Z
    //   1394: ldc_w 1018
    //   1397: invokestatic 367	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   1400: aload_1
    //   1401: ifnull +7 -> 1408
    //   1404: aload_1
    //   1405: invokevirtual 982	java/io/FileOutputStream:close	()V
    //   1408: aload_2
    //   1409: ifnull +331 -> 1740
    //   1412: aload_2
    //   1413: invokevirtual 581	android/graphics/Bitmap:isRecycled	()Z
    //   1416: ifne +324 -> 1740
    //   1419: aload_2
    //   1420: invokevirtual 539	android/graphics/Bitmap:recycle	()V
    //   1423: aload_1
    //   1424: astore 19
    //   1426: aload_2
    //   1427: astore 20
    //   1429: goto -161 -> 1268
    //   1432: astore_3
    //   1433: new 212	java/lang/StringBuilder
    //   1436: dup
    //   1437: invokespecial 213	java/lang/StringBuilder:<init>	()V
    //   1440: ldc_w 1013
    //   1443: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1446: aload_3
    //   1447: invokevirtual 1014	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1450: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1453: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1456: invokestatic 367	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   1459: goto -51 -> 1408
    //   1462: astore_3
    //   1463: aload_1
    //   1464: astore 15
    //   1466: aload_2
    //   1467: astore_1
    //   1468: goto -504 -> 964
    //   1471: astore_2
    //   1472: aload 13
    //   1474: ifnull +21 -> 1495
    //   1477: aload_1
    //   1478: astore_3
    //   1479: aload 13
    //   1481: astore 15
    //   1483: aload_1
    //   1484: astore 16
    //   1486: aload 13
    //   1488: astore 14
    //   1490: aload 13
    //   1492: invokevirtual 982	java/io/FileOutputStream:close	()V
    //   1495: aload_1
    //   1496: ifnull +40 -> 1536
    //   1499: aload_1
    //   1500: astore_3
    //   1501: aload 13
    //   1503: astore 15
    //   1505: aload_1
    //   1506: astore 16
    //   1508: aload 13
    //   1510: astore 14
    //   1512: aload_1
    //   1513: invokevirtual 581	android/graphics/Bitmap:isRecycled	()Z
    //   1516: ifne +20 -> 1536
    //   1519: aload_1
    //   1520: astore_3
    //   1521: aload 13
    //   1523: astore 15
    //   1525: aload_1
    //   1526: astore 16
    //   1528: aload 13
    //   1530: astore 14
    //   1532: aload_1
    //   1533: invokevirtual 539	android/graphics/Bitmap:recycle	()V
    //   1536: aload_1
    //   1537: astore_3
    //   1538: aload 13
    //   1540: astore 15
    //   1542: aload_1
    //   1543: astore 16
    //   1545: aload 13
    //   1547: astore 14
    //   1549: aload_2
    //   1550: athrow
    //   1551: astore 17
    //   1553: aload_1
    //   1554: astore_3
    //   1555: aload 13
    //   1557: astore 15
    //   1559: aload_1
    //   1560: astore 16
    //   1562: aload 13
    //   1564: astore 14
    //   1566: new 212	java/lang/StringBuilder
    //   1569: dup
    //   1570: invokespecial 213	java/lang/StringBuilder:<init>	()V
    //   1573: ldc_w 1013
    //   1576: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1579: aload 17
    //   1581: invokevirtual 1014	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1584: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1587: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1590: invokestatic 367	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   1593: goto -98 -> 1495
    //   1596: astore_2
    //   1597: goto -1475 -> 122
    //   1600: astore_2
    //   1601: goto -1355 -> 246
    //   1604: astore 13
    //   1606: aload 16
    //   1608: astore 13
    //   1610: goto -1198 -> 412
    //   1613: astore 13
    //   1615: goto -669 -> 946
    //   1618: astore_2
    //   1619: goto -793 -> 826
    //   1622: astore_1
    //   1623: goto -345 -> 1278
    //   1626: astore_2
    //   1627: goto -614 -> 1013
    //   1630: astore_3
    //   1631: goto -274 -> 1357
    //   1634: astore_1
    //   1635: aconst_null
    //   1636: astore 14
    //   1638: aload 13
    //   1640: astore_2
    //   1641: goto -294 -> 1347
    //   1644: astore_3
    //   1645: aload_1
    //   1646: astore_2
    //   1647: aconst_null
    //   1648: astore 14
    //   1650: aload_3
    //   1651: astore_1
    //   1652: goto -305 -> 1347
    //   1655: astore_3
    //   1656: aload_1
    //   1657: astore 14
    //   1659: aload_3
    //   1660: astore_1
    //   1661: goto -314 -> 1347
    //   1664: astore_1
    //   1665: aconst_null
    //   1666: astore 15
    //   1668: aload 14
    //   1670: astore_1
    //   1671: goto -707 -> 964
    //   1674: astore_2
    //   1675: aconst_null
    //   1676: astore 15
    //   1678: goto -714 -> 964
    //   1681: astore_2
    //   1682: aload 14
    //   1684: astore_1
    //   1685: goto -213 -> 1472
    //   1688: astore_3
    //   1689: aload_2
    //   1690: astore 13
    //   1692: aload_3
    //   1693: astore_2
    //   1694: goto -222 -> 1472
    //   1697: astore_3
    //   1698: aload_1
    //   1699: astore 13
    //   1701: aload_2
    //   1702: astore_1
    //   1703: aload_3
    //   1704: astore_2
    //   1705: goto -233 -> 1472
    //   1708: astore_1
    //   1709: aload 15
    //   1711: astore_2
    //   1712: aload 13
    //   1714: astore_1
    //   1715: goto -335 -> 1380
    //   1718: astore_3
    //   1719: aload_2
    //   1720: astore_3
    //   1721: aload_1
    //   1722: astore_2
    //   1723: aload_3
    //   1724: astore_1
    //   1725: goto -345 -> 1380
    //   1728: astore_3
    //   1729: aload 13
    //   1731: astore_2
    //   1732: goto -806 -> 926
    //   1735: astore 13
    //   1737: goto -890 -> 847
    //   1740: aload_1
    //   1741: astore 19
    //   1743: aload_2
    //   1744: astore 20
    //   1746: goto -478 -> 1268
    //   1749: iload 7
    //   1751: istore 5
    //   1753: aload_2
    //   1754: astore 13
    //   1756: goto -1123 -> 633
    //   1759: goto -1035 -> 724
    //   1762: astore_1
    //   1763: aload 16
    //   1765: astore_2
    //   1766: goto -419 -> 1347
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1769	0	paramInt1	int
    //   0	1769	1	paramContext	Context
    //   0	1769	2	paramFile1	File
    //   0	1769	3	paramFile2	File
    //   0	1769	4	paramImageInfo	ImageInfo
    //   0	1769	5	paramInt2	int
    //   0	1769	6	paramInt3	int
    //   0	1769	7	paramInt4	int
    //   0	1769	8	paramBoolean1	boolean
    //   0	1769	9	paramBoolean2	boolean
    //   167	489	10	i1	int
    //   467	566	11	l1	long
    //   76	746	13	localObject1	Object
    //   842	1	13	localIOException1	IOException
    //   849	61	13	localObject2	Object
    //   914	1	13	localIOException2	IOException
    //   918	645	13	localObject3	Object
    //   1604	1	13	localIOException3	IOException
    //   1608	1	13	localObject4	Object
    //   1613	26	13	localIOException4	IOException
    //   1690	40	13	localObject5	Object
    //   1735	1	13	localIOException5	IOException
    //   1754	1	13	localFile	File
    //   73	1610	14	localObject6	Object
    //   391	1319	15	localObject7	Object
    //   283	1481	16	localObject8	Object
    //   554	753	17	localObject9	Object
    //   1551	29	17	localIOException6	IOException
    //   401	944	18	localObject10	Object
    //   428	1314	19	localObject11	Object
    //   431	1314	20	localObject12	Object
    //   394	911	21	localObject13	Object
    // Exception table:
    //   from	to	target	type
    //   275	285	842	java/io/IOException
    //   902	907	914	java/io/IOException
    //   275	285	923	finally
    //   403	408	960	java/lang/OutOfMemoryError
    //   463	469	960	java/lang/OutOfMemoryError
    //   488	512	960	java/lang/OutOfMemoryError
    //   526	552	960	java/lang/OutOfMemoryError
    //   902	907	960	java/lang/OutOfMemoryError
    //   942	946	960	java/lang/OutOfMemoryError
    //   958	960	960	java/lang/OutOfMemoryError
    //   1189	1194	960	java/lang/OutOfMemoryError
    //   1231	1239	960	java/lang/OutOfMemoryError
    //   1255	1260	960	java/lang/OutOfMemoryError
    //   1314	1340	960	java/lang/OutOfMemoryError
    //   770	775	1037	java/io/IOException
    //   770	775	1080	java/lang/OutOfMemoryError
    //   792	799	1080	java/lang/OutOfMemoryError
    //   812	816	1080	java/lang/OutOfMemoryError
    //   1051	1077	1080	java/lang/OutOfMemoryError
    //   1490	1495	1080	java/lang/OutOfMemoryError
    //   1512	1519	1080	java/lang/OutOfMemoryError
    //   1532	1536	1080	java/lang/OutOfMemoryError
    //   1549	1551	1080	java/lang/OutOfMemoryError
    //   1566	1593	1080	java/lang/OutOfMemoryError
    //   1189	1194	1297	java/io/IOException
    //   403	408	1343	finally
    //   463	469	1343	finally
    //   488	512	1343	finally
    //   526	552	1343	finally
    //   902	907	1343	finally
    //   942	946	1343	finally
    //   958	960	1343	finally
    //   971	977	1343	finally
    //   984	990	1343	finally
    //   997	1003	1343	finally
    //   1189	1194	1343	finally
    //   1231	1239	1343	finally
    //   1255	1260	1343	finally
    //   1314	1340	1343	finally
    //   559	570	1374	java/io/IOException
    //   577	595	1374	java/io/IOException
    //   602	615	1374	java/io/IOException
    //   1404	1408	1432	java/io/IOException
    //   1404	1408	1462	java/lang/OutOfMemoryError
    //   1412	1423	1462	java/lang/OutOfMemoryError
    //   1433	1459	1462	java/lang/OutOfMemoryError
    //   559	570	1471	finally
    //   577	595	1471	finally
    //   602	615	1471	finally
    //   1490	1495	1551	java/io/IOException
    //   114	122	1596	java/io/IOException
    //   238	246	1600	java/io/IOException
    //   403	408	1604	java/io/IOException
    //   942	946	1613	java/io/IOException
    //   821	826	1618	java/io/IOException
    //   1273	1278	1622	java/io/IOException
    //   1008	1013	1626	java/io/IOException
    //   1352	1357	1630	java/io/IOException
    //   78	89	1634	finally
    //   211	222	1634	finally
    //   228	234	1634	finally
    //   93	110	1644	finally
    //   152	158	1644	finally
    //   163	174	1644	finally
    //   190	198	1644	finally
    //   262	269	1644	finally
    //   1404	1408	1655	finally
    //   1412	1423	1655	finally
    //   1433	1459	1655	finally
    //   78	89	1664	java/lang/OutOfMemoryError
    //   211	222	1664	java/lang/OutOfMemoryError
    //   228	234	1664	java/lang/OutOfMemoryError
    //   93	110	1674	java/lang/OutOfMemoryError
    //   152	158	1674	java/lang/OutOfMemoryError
    //   163	174	1674	java/lang/OutOfMemoryError
    //   190	198	1674	java/lang/OutOfMemoryError
    //   262	269	1674	java/lang/OutOfMemoryError
    //   651	662	1681	finally
    //   668	705	1681	finally
    //   711	718	1681	finally
    //   730	736	1681	finally
    //   746	752	1681	finally
    //   1092	1101	1681	finally
    //   1150	1161	1681	finally
    //   1101	1128	1688	finally
    //   1380	1400	1697	finally
    //   651	662	1708	java/io/IOException
    //   668	705	1708	java/io/IOException
    //   711	718	1708	java/io/IOException
    //   730	736	1708	java/io/IOException
    //   746	752	1708	java/io/IOException
    //   1092	1101	1708	java/io/IOException
    //   1150	1161	1708	java/io/IOException
    //   1101	1128	1718	java/io/IOException
    //   289	305	1728	finally
    //   309	315	1728	finally
    //   319	327	1728	finally
    //   331	336	1728	finally
    //   340	380	1728	finally
    //   851	857	1728	finally
    //   861	869	1728	finally
    //   873	879	1728	finally
    //   289	305	1735	java/io/IOException
    //   309	315	1735	java/io/IOException
    //   319	327	1735	java/io/IOException
    //   331	336	1735	java/io/IOException
    //   340	380	1735	java/io/IOException
    //   770	775	1762	finally
    //   792	799	1762	finally
    //   812	816	1762	finally
    //   1051	1077	1762	finally
    //   1490	1495	1762	finally
    //   1512	1519	1762	finally
    //   1532	1536	1762	finally
    //   1549	1551	1762	finally
    //   1566	1593	1762	finally
  }
  
  public static void a(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean, String paramString1, String paramString2)
  {
    RichMediaUtil.b(paramInt1, paramBoolean, paramInt2, String.valueOf(paramLong), paramString1, paramString2);
  }
  
  public static void a(long paramLong, int paramInt, boolean paramBoolean, String paramString1, String paramString2)
  {
    a(paramLong, paramInt, 1, paramBoolean, paramString1, paramString2);
  }
  
  private static void a(Context paramContext, int paramInt, boolean paramBoolean)
  {
    if (paramContext != null) {
      try
      {
        if ((paramContext instanceof BaseActivity))
        {
          paramContext = (QQAppInterface)((BaseActivity)paramContext).getAppRuntime();
          HashMap localHashMap = new HashMap();
          if ((!paramBoolean) && (paramInt == 1)) {
            localHashMap.put("param_FailCode", Integer.toString(A));
          }
          for (;;)
          {
            StatisticCollector.a(BaseApplication.getContext()).a(paramContext.a(), "report_sendphoto_thumb_oom", paramBoolean, 0L, 0L, localHashMap, "");
            return;
            localHashMap.put("param_FailCode", Integer.toString(z + paramInt - 1));
          }
        }
        return;
      }
      catch (Exception paramContext) {}
    }
  }
  
  public static void a(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
    localIntent.setData(Uri.fromFile(new File(paramString)));
    paramContext.sendBroadcast(localIntent);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    a(paramContext, paramString1, paramString2, true);
  }
  
  /* Error */
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: new 343	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 677	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_0
    //   9: aload_0
    //   10: iload_3
    //   11: iload 4
    //   13: invokestatic 615	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/io/File;II)Landroid/graphics/BitmapFactory$Options;
    //   16: astore 5
    //   18: new 617	java/io/FileInputStream
    //   21: dup
    //   22: aload_0
    //   23: invokespecial 620	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   26: astore_1
    //   27: aload_1
    //   28: astore_0
    //   29: aload_1
    //   30: aload 5
    //   32: aload_2
    //   33: invokestatic 1063	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/io/InputStream;Landroid/graphics/BitmapFactory$Options;Ljava/lang/String;)Ljava/lang/String;
    //   36: pop
    //   37: aload_1
    //   38: ifnull +7 -> 45
    //   41: aload_1
    //   42: invokevirtual 626	java/io/InputStream:close	()V
    //   45: return
    //   46: astore_2
    //   47: aconst_null
    //   48: astore_1
    //   49: aload_1
    //   50: astore_0
    //   51: new 212	java/lang/StringBuilder
    //   54: dup
    //   55: invokespecial 213	java/lang/StringBuilder:<init>	()V
    //   58: ldc_w 1065
    //   61: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: aload_2
    //   65: invokevirtual 588	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   68: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: invokestatic 367	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   77: aload_1
    //   78: ifnull -33 -> 45
    //   81: aload_1
    //   82: invokevirtual 626	java/io/InputStream:close	()V
    //   85: return
    //   86: astore_0
    //   87: return
    //   88: astore_1
    //   89: aconst_null
    //   90: astore_0
    //   91: aload_0
    //   92: ifnull +7 -> 99
    //   95: aload_0
    //   96: invokevirtual 626	java/io/InputStream:close	()V
    //   99: aload_1
    //   100: athrow
    //   101: astore_0
    //   102: return
    //   103: astore_0
    //   104: goto -5 -> 99
    //   107: astore_1
    //   108: goto -17 -> 91
    //   111: astore_2
    //   112: goto -63 -> 49
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	115	0	paramContext	Context
    //   0	115	1	paramString1	String
    //   0	115	2	paramString2	String
    //   0	115	3	paramInt1	int
    //   0	115	4	paramInt2	int
    //   16	15	5	localOptions	BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   0	27	46	java/lang/Exception
    //   81	85	86	java/io/IOException
    //   0	27	88	finally
    //   41	45	101	java/io/IOException
    //   95	99	103	java/io/IOException
    //   29	37	107	finally
    //   51	77	107	finally
    //   29	37	111	java/lang/Exception
  }
  
  /* Error */
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: new 343	java/io/File
    //   6: dup
    //   7: aload_1
    //   8: invokespecial 677	java/io/File:<init>	(Ljava/lang/String;)V
    //   11: astore_0
    //   12: aload_0
    //   13: iload 4
    //   15: iload 5
    //   17: invokestatic 615	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/io/File;II)Landroid/graphics/BitmapFactory$Options;
    //   20: astore_1
    //   21: new 617	java/io/FileInputStream
    //   24: dup
    //   25: aload_0
    //   26: invokespecial 620	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   29: astore_0
    //   30: aload_0
    //   31: aload_1
    //   32: aload_2
    //   33: iload_3
    //   34: invokestatic 1068	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/io/InputStream;Landroid/graphics/BitmapFactory$Options;Ljava/lang/String;I)Ljava/lang/String;
    //   37: pop
    //   38: aload_0
    //   39: ifnull +7 -> 46
    //   42: aload_0
    //   43: invokevirtual 626	java/io/InputStream:close	()V
    //   46: return
    //   47: astore_0
    //   48: aconst_null
    //   49: astore_0
    //   50: aload_0
    //   51: ifnull -5 -> 46
    //   54: aload_0
    //   55: invokevirtual 626	java/io/InputStream:close	()V
    //   58: return
    //   59: astore_0
    //   60: return
    //   61: astore_0
    //   62: aload 6
    //   64: astore_1
    //   65: aload_1
    //   66: ifnull +7 -> 73
    //   69: aload_1
    //   70: invokevirtual 626	java/io/InputStream:close	()V
    //   73: aload_0
    //   74: athrow
    //   75: astore_0
    //   76: return
    //   77: astore_1
    //   78: goto -5 -> 73
    //   81: astore_2
    //   82: aload_0
    //   83: astore_1
    //   84: aload_2
    //   85: astore_0
    //   86: goto -21 -> 65
    //   89: astore_1
    //   90: goto -40 -> 50
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	93	0	paramContext	Context
    //   0	93	1	paramString1	String
    //   0	93	2	paramString2	String
    //   0	93	3	paramInt1	int
    //   0	93	4	paramInt2	int
    //   0	93	5	paramInt3	int
    //   1	62	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	30	47	java/lang/Exception
    //   54	58	59	java/io/IOException
    //   3	30	61	finally
    //   42	46	75	java/io/IOException
    //   69	73	77	java/io/IOException
    //   30	38	81	finally
    //   30	38	89	java/lang/Exception
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((paramContext == null) || (paramString1 == null) || (paramString2 == null)) {
      return;
    }
    File localFile = new File(paramString1);
    Matrix localMatrix = null;
    BitmapFactory.Options localOptions = a(localFile.getPath(), PhotoPreviewConstant.jdField_l_of_type_Int);
    int i1 = 1;
    paramString1 = localMatrix;
    if (i1 <= 3) {}
    for (;;)
    {
      try
      {
        paramString1 = BitmapFactory.decodeFile(localFile.getPath(), localOptions);
        if (paramString1 == null) {
          break label117;
        }
        bool = true;
        a(paramContext, i1, bool);
        if (bool) {
          break label123;
        }
        a("compressAIOThumbImg  bitmap is null ");
        return;
      }
      catch (OutOfMemoryError paramString1)
      {
        a("compressAIOThumbImg  OOM ");
        localOptions.inSampleSize *= 2;
        i1 += 1;
      }
      break;
      label117:
      boolean bool = false;
    }
    label123:
    localMatrix = new Matrix();
    int i5 = paramString1.getWidth();
    int i6 = paramString1.getHeight();
    float f2 = 1.0F;
    int i3 = 0;
    int i4 = 0;
    a("compressAIOThumbImg  width:" + i5 + ",height:" + i6);
    float f1;
    int i2;
    label236:
    int i7;
    if (i6 == i5)
    {
      f1 = f2;
      if (i5 > PhotoPreviewConstant.jdField_l_of_type_Int) {
        f1 = PhotoPreviewConstant.jdField_l_of_type_Int / (i5 * 1.0F);
      }
      i1 = Math.min(i5, PhotoPreviewConstant.jdField_l_of_type_Int);
      i3 = 0;
      i2 = i1;
      i7 = 0;
    }
    for (;;)
    {
      try
      {
        int i8 = b(localFile.getPath());
        if ((!paramBoolean) || (i8 == 0) || (i8 % 90 != 0)) {
          break label794;
        }
        localMatrix.postRotate(i8, i5 / 2.0F, i6 / 2.0F);
        i4 = 1;
        if (f1 == 1.0F) {
          break label814;
        }
        localMatrix.postScale(f1, f1);
        i7 = 1;
        break label814;
        paramContext = Bitmap.createBitmap(paramString1, 0, 0, i5, i6, localMatrix, true);
        paramString1 = paramContext;
        if (paramContext != null)
        {
          paramString1 = paramContext;
          if (i3 != 0)
          {
            if ((i4 == 0) || (i8 / 90 % 2 == 0)) {
              break label787;
            }
            i3 = i1;
            i1 = i2;
            paramString1 = Bitmap.createBitmap(paramContext, 0, 0, i3, i1);
          }
        }
        if (paramString1 == null) {
          break;
        }
        a("compressAIOThumbImg  end width:" + paramString1.getWidth() + ",height:" + paramString1.getHeight());
        paramContext = new File(paramString2);
        if (paramContext.exists()) {
          paramContext.delete();
        }
        paramContext.createNewFile();
        paramContext = new FileOutputStream(paramContext);
        paramString1.compress(Bitmap.CompressFormat.PNG, 70, paramContext);
        paramContext.close();
        paramString1.recycle();
        return;
      }
      catch (Exception paramContext)
      {
        a("createThumbnail", paramContext);
        return;
        if (i6 > i5)
        {
          i4 = i6;
          i3 = i5;
          if ((i3 <= 0) || (i3 > PhotoPreviewConstant.jdField_k_of_type_Int)) {
            continue;
          }
          f1 = f2;
          i2 = i3;
          i1 = i4;
          if (i4 > i3 * 3)
          {
            i1 = Math.min(i4, PhotoPreviewConstant.jdField_l_of_type_Int);
            i2 = i3;
            f1 = f2;
          }
          if (i6 <= i5) {
            continue;
          }
          i3 = 1;
          break label236;
        }
        if (i6 >= i5) {
          continue;
        }
        i4 = i5;
        i3 = i6;
        continue;
        if ((i3 > PhotoPreviewConstant.jdField_k_of_type_Int) && (i3 <= PhotoPreviewConstant.jdField_l_of_type_Int))
        {
          if (i4 > i3 * 3)
          {
            f1 = PhotoPreviewConstant.jdField_k_of_type_Int / (i3 * 1.0F);
            i2 = PhotoPreviewConstant.jdField_k_of_type_Int;
            i1 = (int)Math.min(PhotoPreviewConstant.jdField_l_of_type_Int, i4 * f1);
            continue;
          }
          f1 = f2;
          i2 = i3;
          i1 = i4;
          if (i4 < PhotoPreviewConstant.jdField_l_of_type_Int) {
            continue;
          }
          f1 = PhotoPreviewConstant.jdField_l_of_type_Int / (i4 * 1.0F);
          i1 = PhotoPreviewConstant.jdField_l_of_type_Int;
          i2 = (int)(i3 * f1);
          continue;
        }
        if (i4 > i3 * 3)
        {
          f1 = PhotoPreviewConstant.jdField_k_of_type_Int / (i3 * 1.0F);
          i2 = PhotoPreviewConstant.jdField_k_of_type_Int;
          i1 = PhotoPreviewConstant.jdField_l_of_type_Int;
          continue;
        }
        f1 = PhotoPreviewConstant.jdField_l_of_type_Int / (i4 * 1.0F);
        i1 = PhotoPreviewConstant.jdField_l_of_type_Int;
        i2 = (int)(i3 * f1);
        continue;
        if (i6 >= i5) {
          break label800;
        }
        i4 = 1;
        i3 = i2;
        i2 = i1;
        i1 = i3;
        i3 = i4;
      }
      catch (OutOfMemoryError paramContext)
      {
        a("createThumbnail : OOM ");
        return;
      }
      label787:
      i3 = i2;
      continue;
      label794:
      i4 = 0;
      continue;
      label800:
      i3 = 1;
      i1 = i6;
      i2 = i5;
      break label236;
      label814:
      if (i7 == 0)
      {
        paramContext = paramString1;
        if (i4 == 0) {}
      }
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean, ImageInfo paramImageInfo, int paramInt)
  {
    a(-1, paramContext, paramString1, paramString2, paramBoolean, paramImageInfo, paramInt);
  }
  
  public static void a(Context paramContext, List paramList, int paramInt)
  {
    if ((paramContext == null) || (paramList == null)) {}
    int i1;
    label18:
    ImageInfo localImageInfo;
    do
    {
      return;
      paramList = paramList.iterator();
      i1 = 0;
      if (!paramList.hasNext()) {
        break;
      }
      localImageInfo = (ImageInfo)paramList.next();
    } while ((localImageInfo == null) || (localImageInfo.b == null));
    File localFile = new File(localImageInfo.b);
    long l1;
    switch (paramInt)
    {
    default: 
      l1 = 19922944L;
      label113:
      if ((localFile.length() > l1) && (!localImageInfo.q)) {
        i1 = 1;
      }
      break;
    }
    for (;;)
    {
      break label18;
      l1 = 19922944L;
      break label113;
      l1 = 19922944L;
      break label113;
      if ((paramContext != null) && ((paramContext instanceof BaseActivity)))
      {
        if (((QQAppInterface)((BaseActivity)paramContext).getAppRuntime()).b(localImageInfo.c)) {}
        l1 = 19922944L;
        break label113;
      }
      l1 = AppSetting.d;
      break label113;
      if ((localImageInfo.g) && (!NetworkUtil.g(paramContext)))
      {
        i1 = 1;
        continue;
        if (i1 == 0) {
          break;
        }
        QQToast.a(paramContext, "系统可用内存不足，图片已压缩发送", 0).b(paramContext.getResources().getDimensionPixelSize(2131492887));
        return;
      }
    }
  }
  
  public static final void a(Bitmap paramBitmap, Canvas paramCanvas, int paramInt1, int paramInt2, float paramFloat, int paramInt3)
  {
    if ((paramBitmap == null) || (paramCanvas == null)) {
      return;
    }
    int i1 = paramBitmap.getWidth();
    int i2 = paramBitmap.getHeight();
    Rect localRect1 = new Rect(paramInt1, paramInt2, i1 + paramInt1, i2 + paramInt2);
    Rect localRect2 = new Rect(0, 0, i1, i2);
    RectF localRectF = new RectF(localRect2);
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    localPaint.setColor(paramInt3);
    Bitmap localBitmap = Bitmap.createBitmap(i1, i2, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    localCanvas.drawRoundRect(localRectF, paramFloat, paramFloat, localPaint);
    localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    localCanvas.drawBitmap(paramBitmap, localRect2, localRect2, localPaint);
    paramCanvas.drawBitmap(localBitmap, localRect2, localRect1, null);
  }
  
  /* Error */
  public static void a(Bitmap paramBitmap, File paramFile)
  {
    // Byte code:
    //   0: new 343	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokevirtual 1130	java/io/File:getParent	()Ljava/lang/String;
    //   8: invokespecial 677	java/io/File:<init>	(Ljava/lang/String;)V
    //   11: astore_2
    //   12: aload_2
    //   13: invokevirtual 612	java/io/File:exists	()Z
    //   16: ifeq +10 -> 26
    //   19: aload_2
    //   20: invokevirtual 1133	java/io/File:isDirectory	()Z
    //   23: ifne +8 -> 31
    //   26: aload_2
    //   27: invokevirtual 690	java/io/File:mkdirs	()Z
    //   30: pop
    //   31: aload_1
    //   32: invokevirtual 612	java/io/File:exists	()Z
    //   35: ifeq +10 -> 45
    //   38: aload_1
    //   39: invokevirtual 1136	java/io/File:isFile	()Z
    //   42: ifne +8 -> 50
    //   45: aload_1
    //   46: invokevirtual 693	java/io/File:createNewFile	()Z
    //   49: pop
    //   50: aconst_null
    //   51: astore_2
    //   52: new 763	java/io/FileOutputStream
    //   55: dup
    //   56: aload_1
    //   57: invokespecial 764	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   60: astore_1
    //   61: aload_0
    //   62: getstatic 877	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   65: bipush 100
    //   67: aload_1
    //   68: invokevirtual 774	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   71: pop
    //   72: aload_1
    //   73: invokevirtual 1139	java/io/FileOutputStream:flush	()V
    //   76: aload_1
    //   77: ifnull +7 -> 84
    //   80: aload_1
    //   81: invokevirtual 982	java/io/FileOutputStream:close	()V
    //   84: return
    //   85: astore_0
    //   86: aconst_null
    //   87: astore_1
    //   88: aload_1
    //   89: ifnull -5 -> 84
    //   92: aload_1
    //   93: invokevirtual 982	java/io/FileOutputStream:close	()V
    //   96: return
    //   97: astore_0
    //   98: aload_2
    //   99: astore_1
    //   100: aload_1
    //   101: ifnull +7 -> 108
    //   104: aload_1
    //   105: invokevirtual 982	java/io/FileOutputStream:close	()V
    //   108: aload_0
    //   109: athrow
    //   110: astore_0
    //   111: goto -11 -> 100
    //   114: astore_0
    //   115: goto -27 -> 88
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	118	0	paramBitmap	Bitmap
    //   0	118	1	paramFile	File
    //   11	88	2	localFile	File
    // Exception table:
    //   from	to	target	type
    //   52	61	85	java/io/IOException
    //   52	61	97	finally
    //   61	76	110	finally
    //   61	76	114	java/io/IOException
  }
  
  private static void a(Rect paramRect, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 > paramInt2)
    {
      paramRect.set(0, 0, paramInt3, (int)(paramInt3 / paramInt1 * paramInt2));
      return;
    }
    paramRect.set(0, 0, (int)(paramInt3 / paramInt2 * paramInt1), paramInt3);
  }
  
  public static void a(ImageInfo paramImageInfo, String paramString1, String paramString2)
  {
    if (paramImageInfo == null)
    {
      a(-1L, -1, true, paramString1, "@ImageUtil.log ImageInfo is null@ " + paramString2);
      return;
    }
    boolean bool = MsgUtils.b(paramImageInfo.jdField_e_of_type_Int);
    if (paramImageInfo.jdField_j_of_type_Int == 2)
    {
      a(paramImageInfo.jdField_e_of_type_Long, paramImageInfo.d, 131075, bool, paramString1, paramString2);
      return;
    }
    a(paramImageInfo.jdField_e_of_type_Long, paramImageInfo.d, bool, paramString1, paramString2);
  }
  
  private static final void a(FileOutputStream paramFileOutputStream)
  {
    paramFileOutputStream.flush();
    paramFileOutputStream = paramFileOutputStream.getFD();
    if ((paramFileOutputStream != null) && (paramFileOutputStream.valid())) {
      paramFileOutputStream.sync();
    }
  }
  
  private static void a(String paramString)
  {
    if ((QLog.isColorLevel()) || (RichMediaUtil.a())) {
      QLog.e(p, 2, paramString);
    }
  }
  
  private static void a(String paramString, Context paramContext, boolean paramBoolean)
  {
    if ((paramContext != null) && ((paramContext instanceof BaseActivity))) {
      new Thread(new evw((QQAppInterface)((BaseActivity)paramContext).getAppRuntime(), paramString, paramBoolean), "report_send_photo_performance").start();
    }
  }
  
  /* Error */
  public static void a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 5
    //   6: new 343	java/io/File
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 677	java/io/File:<init>	(Ljava/lang/String;)V
    //   14: astore_0
    //   15: aload_1
    //   16: invokestatic 874	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)Ljava/io/File;
    //   19: astore_1
    //   20: new 617	java/io/FileInputStream
    //   23: dup
    //   24: aload_0
    //   25: invokespecial 620	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   28: astore_0
    //   29: new 763	java/io/FileOutputStream
    //   32: dup
    //   33: aload_1
    //   34: invokespecial 764	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   37: astore 5
    //   39: sipush 2048
    //   42: newarray byte
    //   44: astore_1
    //   45: lconst_0
    //   46: lstore_3
    //   47: aload_0
    //   48: aload_1
    //   49: invokevirtual 1186	java/io/InputStream:read	([B)I
    //   52: istore_2
    //   53: iload_2
    //   54: iflt +42 -> 96
    //   57: lload_3
    //   58: iload_2
    //   59: i2l
    //   60: ladd
    //   61: lstore_3
    //   62: aload 5
    //   64: aload_1
    //   65: iconst_0
    //   66: iload_2
    //   67: invokevirtual 1190	java/io/OutputStream:write	([BII)V
    //   70: goto -23 -> 47
    //   73: astore_1
    //   74: aload_0
    //   75: astore_1
    //   76: aload 5
    //   78: astore_0
    //   79: aload_1
    //   80: ifnull +7 -> 87
    //   83: aload_1
    //   84: invokevirtual 626	java/io/InputStream:close	()V
    //   87: aload_0
    //   88: ifnull +7 -> 95
    //   91: aload_0
    //   92: invokevirtual 777	java/io/OutputStream:close	()V
    //   95: return
    //   96: aload_0
    //   97: ifnull +7 -> 104
    //   100: aload_0
    //   101: invokevirtual 626	java/io/InputStream:close	()V
    //   104: aload 5
    //   106: ifnull -11 -> 95
    //   109: aload 5
    //   111: invokevirtual 777	java/io/OutputStream:close	()V
    //   114: return
    //   115: astore_0
    //   116: return
    //   117: astore_1
    //   118: aconst_null
    //   119: astore_0
    //   120: aload 6
    //   122: astore 5
    //   124: aload_0
    //   125: ifnull +7 -> 132
    //   128: aload_0
    //   129: invokevirtual 626	java/io/InputStream:close	()V
    //   132: aload 5
    //   134: ifnull +8 -> 142
    //   137: aload 5
    //   139: invokevirtual 777	java/io/OutputStream:close	()V
    //   142: aload_1
    //   143: athrow
    //   144: astore_0
    //   145: goto -41 -> 104
    //   148: astore_1
    //   149: goto -62 -> 87
    //   152: astore_0
    //   153: return
    //   154: astore_0
    //   155: goto -23 -> 132
    //   158: astore_0
    //   159: goto -17 -> 142
    //   162: astore_1
    //   163: aload 6
    //   165: astore 5
    //   167: goto -43 -> 124
    //   170: astore_1
    //   171: goto -47 -> 124
    //   174: astore_0
    //   175: aconst_null
    //   176: astore_0
    //   177: aload 5
    //   179: astore_1
    //   180: goto -101 -> 79
    //   183: astore_1
    //   184: aconst_null
    //   185: astore 5
    //   187: aload_0
    //   188: astore_1
    //   189: aload 5
    //   191: astore_0
    //   192: goto -113 -> 79
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	195	0	paramString1	String
    //   0	195	1	paramString2	String
    //   52	15	2	i1	int
    //   46	16	3	l1	long
    //   4	186	5	localObject1	Object
    //   1	163	6	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   39	45	73	java/lang/Exception
    //   47	53	73	java/lang/Exception
    //   62	70	73	java/lang/Exception
    //   109	114	115	java/io/IOException
    //   6	29	117	finally
    //   100	104	144	java/io/IOException
    //   83	87	148	java/io/IOException
    //   91	95	152	java/io/IOException
    //   128	132	154	java/io/IOException
    //   137	142	158	java/io/IOException
    //   29	39	162	finally
    //   39	45	170	finally
    //   47	53	170	finally
    //   62	70	170	finally
    //   6	29	174	java/lang/Exception
    //   29	39	183	java/lang/Exception
  }
  
  public static void a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    try
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      BitmapFactory.decodeFile(paramString1, localOptions);
      if ((localOptions.outWidth < paramInt1) && (localOptions.outHeight < paramInt2))
      {
        a(paramString1, paramString2, paramInt1, paramInt2, 100);
        return;
      }
      paramString2 = BitmapFactory.decodeFile(paramString1);
      if (paramString2.getWidth() >= paramInt1) {
        break label98;
      }
      paramString2.getWidth();
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        a(paramString1.toString());
        return;
        if (paramString2.getHeight() < paramInt2) {
          paramString2.getHeight();
        }
      }
    }
    catch (Error paramString1)
    {
      label98:
      a(paramString1.toString());
    }
    b(a(paramString2, paramInt1, paramInt2), new File(paramString1));
    return;
  }
  
  /* Error */
  public static void a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 9
    //   3: aload_0
    //   4: invokestatic 1206	com/tencent/mobileqq/util/BitmapManager:a	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   7: astore 10
    //   9: aload 10
    //   11: ifnonnull +16 -> 27
    //   14: iconst_0
    //   15: ifeq +11 -> 26
    //   18: new 628	java/lang/NullPointerException
    //   21: dup
    //   22: invokespecial 629	java/lang/NullPointerException:<init>	()V
    //   25: athrow
    //   26: return
    //   27: aload 10
    //   29: invokevirtual 335	android/graphics/Bitmap:getWidth	()I
    //   32: istore 7
    //   34: aload 10
    //   36: invokevirtual 407	android/graphics/Bitmap:getHeight	()I
    //   39: istore 8
    //   41: iload_2
    //   42: i2f
    //   43: iload 7
    //   45: i2f
    //   46: fdiv
    //   47: fstore 5
    //   49: iload_3
    //   50: i2f
    //   51: iload 8
    //   53: i2f
    //   54: fdiv
    //   55: fstore 6
    //   57: new 489	android/graphics/Matrix
    //   60: dup
    //   61: invokespecial 490	android/graphics/Matrix:<init>	()V
    //   64: astore_0
    //   65: aload_0
    //   66: fload 5
    //   68: fload 6
    //   70: invokevirtual 494	android/graphics/Matrix:postScale	(FF)Z
    //   73: pop
    //   74: aload 10
    //   76: iconst_0
    //   77: iconst_0
    //   78: iload 7
    //   80: iload 8
    //   82: aload_0
    //   83: iconst_0
    //   84: invokestatic 578	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   87: astore 10
    //   89: new 763	java/io/FileOutputStream
    //   92: dup
    //   93: new 343	java/io/File
    //   96: dup
    //   97: aload_1
    //   98: invokespecial 677	java/io/File:<init>	(Ljava/lang/String;)V
    //   101: invokespecial 764	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   104: astore_1
    //   105: aload_1
    //   106: astore_0
    //   107: aload 10
    //   109: getstatic 877	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   112: iload 4
    //   114: aload_1
    //   115: invokevirtual 774	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   118: ifeq +15 -> 133
    //   121: aload_1
    //   122: astore_0
    //   123: aload_1
    //   124: invokevirtual 1139	java/io/FileOutputStream:flush	()V
    //   127: aload_1
    //   128: astore_0
    //   129: aload_1
    //   130: invokevirtual 982	java/io/FileOutputStream:close	()V
    //   133: aload_1
    //   134: ifnull -108 -> 26
    //   137: aload_1
    //   138: invokevirtual 982	java/io/FileOutputStream:close	()V
    //   141: return
    //   142: astore_0
    //   143: return
    //   144: astore 9
    //   146: aconst_null
    //   147: astore_1
    //   148: aload_1
    //   149: astore_0
    //   150: aload 9
    //   152: invokevirtual 249	java/lang/Exception:printStackTrace	()V
    //   155: aload_1
    //   156: ifnull -130 -> 26
    //   159: aload_1
    //   160: invokevirtual 982	java/io/FileOutputStream:close	()V
    //   163: return
    //   164: astore_0
    //   165: return
    //   166: astore_0
    //   167: aload 9
    //   169: astore_1
    //   170: aload_1
    //   171: ifnull +7 -> 178
    //   174: aload_1
    //   175: invokevirtual 982	java/io/FileOutputStream:close	()V
    //   178: aload_0
    //   179: athrow
    //   180: astore_0
    //   181: return
    //   182: astore_1
    //   183: goto -5 -> 178
    //   186: astore 9
    //   188: aload_0
    //   189: astore_1
    //   190: aload 9
    //   192: astore_0
    //   193: goto -23 -> 170
    //   196: astore 9
    //   198: goto -50 -> 148
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	201	0	paramString1	String
    //   0	201	1	paramString2	String
    //   0	201	2	paramInt1	int
    //   0	201	3	paramInt2	int
    //   0	201	4	paramInt3	int
    //   47	20	5	f1	float
    //   55	14	6	f2	float
    //   32	47	7	i1	int
    //   39	42	8	i2	int
    //   1	1	9	localObject1	Object
    //   144	24	9	localException1	Exception
    //   186	5	9	localObject2	Object
    //   196	1	9	localException2	Exception
    //   7	101	10	localBitmap	Bitmap
    // Exception table:
    //   from	to	target	type
    //   137	141	142	java/io/IOException
    //   3	9	144	java/lang/Exception
    //   27	105	144	java/lang/Exception
    //   159	163	164	java/io/IOException
    //   3	9	166	finally
    //   27	105	166	finally
    //   18	26	180	java/io/IOException
    //   174	178	182	java/io/IOException
    //   107	121	186	finally
    //   123	127	186	finally
    //   129	133	186	finally
    //   150	155	186	finally
    //   107	121	196	java/lang/Exception
    //   123	127	196	java/lang/Exception
    //   129	133	196	java/lang/Exception
  }
  
  private static void a(String paramString, Throwable paramThrowable)
  {
    if ((QLog.isColorLevel()) || (RichMediaUtil.a())) {
      QLog.e(p, 2, paramString, paramThrowable);
    }
  }
  
  private static void a(String paramString1, boolean paramBoolean, String paramString2, String paramString3)
  {
    try
    {
      HashMap localHashMap = new HashMap();
      if (!paramBoolean)
      {
        localHashMap.put("param_FailCode", paramString3);
        localHashMap.put("param_FailMsg", paramString2);
      }
      StatisticCollector.a(BaseApplication.getContext()).a(null, paramString1, paramBoolean, 0L, 0L, localHashMap, "");
      return;
    }
    catch (Exception paramString1) {}
  }
  
  private static boolean a()
  {
    return Utils.b() >> 20 < 2L;
  }
  
  public static boolean a(int paramInt1, Context paramContext, String paramString1, String paramString2, boolean paramBoolean, ImageInfo paramImageInfo, int paramInt2)
  {
    RichMediaUtil.a("compressPic", AppSetting.a, a(), 10000, 600000L);
    File localFile;
    if (FileUtils.a(paramString2))
    {
      localFile = new File(paramString2);
      if (!a(paramString2)) {
        localFile.delete();
      }
    }
    else
    {
      boolean bool = false;
      if (paramInt1 == 8) {
        bool = true;
      }
      paramBoolean = a(paramInt1, paramContext, paramString1, paramString2, paramBoolean, paramImageInfo, paramInt2, bool);
      if ((paramBoolean) && (!bool)) {
        b(paramString1, paramString2);
      }
      return paramBoolean;
    }
    paramImageInfo.b = localFile.getPath();
    paramImageInfo.a = localFile.length();
    paramImageInfo.o = true;
    paramImageInfo.h = true;
    if (paramImageInfo.jdField_l_of_type_Int > 0)
    {
      a("compress succ with retry : " + paramImageInfo.jdField_l_of_type_Int);
      a(paramInt1, 8, paramContext, false, null);
      if (paramImageInfo.jdField_l_of_type_Int <= 0) {
        break label207;
      }
    }
    label207:
    for (paramBoolean = true;; paramBoolean = false)
    {
      RichMediaUtil.a("compressPic", paramBoolean, "compressPic");
      return true;
      a(paramInt1, 0, paramContext, true, null);
      break;
    }
  }
  
  /* Error */
  private static boolean a(int paramInt1, Context paramContext, String paramString1, String paramString2, boolean paramBoolean1, ImageInfo paramImageInfo, int paramInt2, boolean paramBoolean2)
  {
    // Byte code:
    //   0: ldc_w 1248
    //   3: invokestatic 367	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   6: aload_3
    //   7: ifnull +16 -> 23
    //   10: aload_2
    //   11: ifnull +12 -> 23
    //   14: aload 5
    //   16: ifnull +7 -> 23
    //   19: aload_1
    //   20: ifnonnull +5 -> 25
    //   23: iconst_0
    //   24: ireturn
    //   25: new 343	java/io/File
    //   28: dup
    //   29: new 212	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 213	java/lang/StringBuilder:<init>	()V
    //   36: getstatic 702	com/tencent/mobileqq/app/AppConstants:as	Ljava/lang/String;
    //   39: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: ldc 23
    //   44: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: invokespecial 677	java/io/File:<init>	(Ljava/lang/String;)V
    //   53: astore 14
    //   55: aload 14
    //   57: invokevirtual 612	java/io/File:exists	()Z
    //   60: ifne +23 -> 83
    //   63: ldc_w 1250
    //   66: invokestatic 367	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   69: aload 14
    //   71: invokevirtual 690	java/io/File:mkdirs	()Z
    //   74: ifne +9 -> 83
    //   77: ldc_w 1252
    //   80: invokestatic 367	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   83: new 343	java/io/File
    //   86: dup
    //   87: aload_3
    //   88: invokespecial 677	java/io/File:<init>	(Ljava/lang/String;)V
    //   91: astore 15
    //   93: new 343	java/io/File
    //   96: dup
    //   97: aload_2
    //   98: invokespecial 677	java/io/File:<init>	(Ljava/lang/String;)V
    //   101: astore 16
    //   103: aload 5
    //   105: ldc_w 1254
    //   108: new 212	java/lang/StringBuilder
    //   111: dup
    //   112: invokespecial 213	java/lang/StringBuilder:<init>	()V
    //   115: ldc_w 1256
    //   118: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: aload 5
    //   123: getfield 1239	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_l_of_type_Int	I
    //   126: invokevirtual 364	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   129: ldc_w 1258
    //   132: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: aload 5
    //   137: getfield 399	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_j_of_type_Int	I
    //   140: invokevirtual 364	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   143: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   146: invokestatic 953	com/tencent/mobileqq/utils/ImageUtil:a	(Lcom/tencent/mobileqq/activity/photo/ImageInfo;Ljava/lang/String;Ljava/lang/String;)V
    //   149: aload_2
    //   150: invokestatic 1229	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;)Z
    //   153: ifne +13 -> 166
    //   156: iload_0
    //   157: iconst_1
    //   158: aload_1
    //   159: iconst_0
    //   160: aconst_null
    //   161: invokestatic 1243	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   164: iconst_0
    //   165: ireturn
    //   166: aload_2
    //   167: invokestatic 1259	com/tencent/mobileqq/utils/FileUtils:b	(Ljava/lang/String;)Z
    //   170: ifne +13 -> 183
    //   173: iload_0
    //   174: iconst_2
    //   175: aload_1
    //   176: iconst_0
    //   177: aconst_null
    //   178: invokestatic 1243	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   181: iconst_0
    //   182: ireturn
    //   183: aload_2
    //   184: invokestatic 1230	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)Z
    //   187: ifne +13 -> 200
    //   190: iload_0
    //   191: iconst_4
    //   192: aload_1
    //   193: iconst_0
    //   194: aconst_null
    //   195: invokestatic 1243	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   198: iconst_0
    //   199: ireturn
    //   200: aload 5
    //   202: aload 16
    //   204: invokevirtual 346	java/io/File:getPath	()Ljava/lang/String;
    //   207: putfield 1105	com/tencent/mobileqq/activity/photo/ImageInfo:b	Ljava/lang/String;
    //   210: aload 5
    //   212: aload 16
    //   214: invokevirtual 779	java/io/File:length	()J
    //   217: putfield 1238	com/tencent/mobileqq/activity/photo/ImageInfo:a	J
    //   220: aload 16
    //   222: invokestatic 1261	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/io/File;)Landroid/graphics/BitmapFactory$Options;
    //   225: astore 14
    //   227: new 212	java/lang/StringBuilder
    //   230: dup
    //   231: invokespecial 213	java/lang/StringBuilder:<init>	()V
    //   234: ldc_w 1263
    //   237: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: aload 16
    //   242: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   245: ldc_w 1265
    //   248: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: aload 16
    //   253: invokevirtual 779	java/io/File:length	()J
    //   256: invokevirtual 746	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   259: ldc_w 1267
    //   262: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: aload 14
    //   267: getfield 119	android/graphics/BitmapFactory$Options:outWidth	I
    //   270: invokevirtual 364	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   273: ldc_w 1269
    //   276: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: aload 14
    //   281: getfield 122	android/graphics/BitmapFactory$Options:outHeight	I
    //   284: invokevirtual 364	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   287: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   290: invokestatic 367	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   293: aload_3
    //   294: invokestatic 1229	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;)Z
    //   297: ifeq +16 -> 313
    //   300: aload_3
    //   301: invokestatic 1230	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)Z
    //   304: ifne +460 -> 764
    //   307: aload 15
    //   309: invokevirtual 696	java/io/File:delete	()Z
    //   312: pop
    //   313: aload 16
    //   315: invokestatic 995	com/tencent/image/GifDrawable:isGifFile	(Ljava/io/File;)Z
    //   318: istore 11
    //   320: aload 5
    //   322: iload 11
    //   324: putfield 1107	com/tencent/mobileqq/activity/photo/ImageInfo:q	Z
    //   327: iload 11
    //   329: ifne +125 -> 454
    //   332: aload 15
    //   334: invokevirtual 693	java/io/File:createNewFile	()Z
    //   337: ifeq +117 -> 454
    //   340: ldc_w 1271
    //   343: invokestatic 367	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   346: new 105	android/graphics/BitmapFactory$Options
    //   349: dup
    //   350: invokespecial 106	android/graphics/BitmapFactory$Options:<init>	()V
    //   353: astore 14
    //   355: aload 14
    //   357: iconst_1
    //   358: putfield 110	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   361: aload 16
    //   363: invokevirtual 346	java/io/File:getPath	()Ljava/lang/String;
    //   366: aload 14
    //   368: invokestatic 359	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   371: pop
    //   372: aload 14
    //   374: getfield 122	android/graphics/BitmapFactory$Options:outHeight	I
    //   377: istore 8
    //   379: aload 14
    //   381: getfield 119	android/graphics/BitmapFactory$Options:outWidth	I
    //   384: istore 9
    //   386: iload 8
    //   388: iconst_m1
    //   389: if_icmpeq +65 -> 454
    //   392: iload 9
    //   394: iconst_m1
    //   395: if_icmpeq +59 -> 454
    //   398: iload 7
    //   400: ifne +1240 -> 1640
    //   403: iload 4
    //   405: ifeq +1235 -> 1640
    //   408: iload 8
    //   410: iload 9
    //   412: iconst_3
    //   413: imul
    //   414: if_icmpgt +12 -> 426
    //   417: iload 9
    //   419: iload 8
    //   421: iconst_3
    //   422: imul
    //   423: if_icmple +1217 -> 1640
    //   426: iload_0
    //   427: aload_1
    //   428: aload 16
    //   430: aload 15
    //   432: aload 5
    //   434: iload 6
    //   436: iload 8
    //   438: iload 9
    //   440: iload 4
    //   442: iload 7
    //   444: invokestatic 1273	com/tencent/mobileqq/utils/ImageUtil:b	(ILandroid/content/Context;Ljava/io/File;Ljava/io/File;Lcom/tencent/mobileqq/activity/photo/ImageInfo;IIIZZ)V
    //   447: ldc 62
    //   449: aload_1
    //   450: iconst_1
    //   451: invokestatic 352	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;Landroid/content/Context;Z)V
    //   454: aload 5
    //   456: getfield 393	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_k_of_type_Int	I
    //   459: iconst_1
    //   460: if_icmpeq +12 -> 472
    //   463: aload 5
    //   465: getfield 393	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_k_of_type_Int	I
    //   468: iconst_1
    //   469: if_icmpne +1499 -> 1968
    //   472: iconst_1
    //   473: istore 10
    //   475: aload_3
    //   476: invokestatic 1259	com/tencent/mobileqq/utils/FileUtils:b	(Ljava/lang/String;)Z
    //   479: istore 12
    //   481: aload 5
    //   483: ldc_w 1275
    //   486: new 212	java/lang/StringBuilder
    //   489: dup
    //   490: invokespecial 213	java/lang/StringBuilder:<init>	()V
    //   493: ldc_w 1277
    //   496: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   499: aload 5
    //   501: getfield 957	com/tencent/mobileqq/activity/photo/ImageInfo:h	Z
    //   504: invokevirtual 979	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   507: ldc_w 1279
    //   510: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   513: aload 5
    //   515: getfield 395	com/tencent/mobileqq/activity/photo/ImageInfo:g	Z
    //   518: invokevirtual 979	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   521: ldc_w 1281
    //   524: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   527: iload 12
    //   529: invokevirtual 979	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   532: ldc_w 1283
    //   535: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   538: iload 10
    //   540: invokevirtual 979	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   543: ldc_w 1285
    //   546: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   549: aload 5
    //   551: getfield 969	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_l_of_type_Boolean	Z
    //   554: invokevirtual 979	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   557: ldc_w 1287
    //   560: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   563: aload 5
    //   565: getfield 1005	com/tencent/mobileqq/activity/photo/ImageInfo:m	Z
    //   568: invokevirtual 979	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   571: ldc_w 1289
    //   574: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   577: invokestatic 921	com/tencent/mobileqq/util/Utils:b	()J
    //   580: invokevirtual 746	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   583: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   586: invokestatic 953	com/tencent/mobileqq/utils/ImageUtil:a	(Lcom/tencent/mobileqq/activity/photo/ImageInfo;Ljava/lang/String;Ljava/lang/String;)V
    //   589: aload 5
    //   591: getfield 957	com/tencent/mobileqq/activity/photo/ImageInfo:h	Z
    //   594: ifne +1391 -> 1985
    //   597: aload 5
    //   599: getfield 395	com/tencent/mobileqq/activity/photo/ImageInfo:g	Z
    //   602: ifeq +1372 -> 1974
    //   605: iload_0
    //   606: iconst_3
    //   607: aload_1
    //   608: iconst_0
    //   609: aconst_null
    //   610: invokestatic 1243	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   613: iload 12
    //   615: ifeq +27 -> 642
    //   618: aload 15
    //   620: invokevirtual 779	java/io/File:length	()J
    //   623: aload 16
    //   625: invokevirtual 779	java/io/File:length	()J
    //   628: lcmp
    //   629: ifgt +13 -> 642
    //   632: iload 10
    //   634: ifne +8 -> 642
    //   637: iload 11
    //   639: ifeq +1670 -> 2309
    //   642: aload 5
    //   644: aload 16
    //   646: invokevirtual 346	java/io/File:getPath	()Ljava/lang/String;
    //   649: putfield 1105	com/tencent/mobileqq/activity/photo/ImageInfo:b	Ljava/lang/String;
    //   652: aload 5
    //   654: aload 16
    //   656: invokevirtual 779	java/io/File:length	()J
    //   659: putfield 1238	com/tencent/mobileqq/activity/photo/ImageInfo:a	J
    //   662: aload 5
    //   664: iconst_0
    //   665: putfield 971	com/tencent/mobileqq/activity/photo/ImageInfo:o	Z
    //   668: aload 5
    //   670: iconst_0
    //   671: putfield 957	com/tencent/mobileqq/activity/photo/ImageInfo:h	Z
    //   674: aload 15
    //   676: ifnull +17 -> 693
    //   679: aload 15
    //   681: invokevirtual 612	java/io/File:exists	()Z
    //   684: ifeq +9 -> 693
    //   687: aload 15
    //   689: invokevirtual 696	java/io/File:delete	()Z
    //   692: pop
    //   693: iload 10
    //   695: ifne +8 -> 703
    //   698: iload 11
    //   700: ifeq +1448 -> 2148
    //   703: new 212	java/lang/StringBuilder
    //   706: dup
    //   707: invokespecial 213	java/lang/StringBuilder:<init>	()V
    //   710: ldc_w 1291
    //   713: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   716: aload 16
    //   718: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   721: ldc_w 1265
    //   724: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   727: aload 16
    //   729: invokevirtual 779	java/io/File:length	()J
    //   732: invokevirtual 746	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   735: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   738: invokestatic 367	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   741: ldc_w 1215
    //   744: iconst_0
    //   745: ldc_w 1215
    //   748: invokestatic 1246	com/tencent/mobileqq/transfile/RichMediaUtil:a	(Ljava/lang/String;ZLjava/lang/String;)V
    //   751: aload 5
    //   753: ldc_w 1293
    //   756: ldc_w 1295
    //   759: invokestatic 953	com/tencent/mobileqq/utils/ImageUtil:a	(Lcom/tencent/mobileqq/activity/photo/ImageInfo;Ljava/lang/String;Ljava/lang/String;)V
    //   762: iconst_0
    //   763: ireturn
    //   764: aload 5
    //   766: ldc_w 946
    //   769: ldc_w 1297
    //   772: invokestatic 953	com/tencent/mobileqq/utils/ImageUtil:a	(Lcom/tencent/mobileqq/activity/photo/ImageInfo;Ljava/lang/String;Ljava/lang/String;)V
    //   775: aload 5
    //   777: getfield 393	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_k_of_type_Int	I
    //   780: iconst_1
    //   781: if_icmpeq +12 -> 793
    //   784: aload 5
    //   786: getfield 393	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_k_of_type_Int	I
    //   789: iconst_1
    //   790: if_icmpne +380 -> 1170
    //   793: iconst_1
    //   794: istore 10
    //   796: aload_3
    //   797: invokestatic 1259	com/tencent/mobileqq/utils/FileUtils:b	(Ljava/lang/String;)Z
    //   800: istore 11
    //   802: aload 5
    //   804: ldc_w 1275
    //   807: new 212	java/lang/StringBuilder
    //   810: dup
    //   811: invokespecial 213	java/lang/StringBuilder:<init>	()V
    //   814: ldc_w 1277
    //   817: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   820: aload 5
    //   822: getfield 957	com/tencent/mobileqq/activity/photo/ImageInfo:h	Z
    //   825: invokevirtual 979	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   828: ldc_w 1279
    //   831: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   834: aload 5
    //   836: getfield 395	com/tencent/mobileqq/activity/photo/ImageInfo:g	Z
    //   839: invokevirtual 979	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   842: ldc_w 1281
    //   845: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   848: iload 11
    //   850: invokevirtual 979	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   853: ldc_w 1283
    //   856: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   859: iload 10
    //   861: invokevirtual 979	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   864: ldc_w 1285
    //   867: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   870: aload 5
    //   872: getfield 969	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_l_of_type_Boolean	Z
    //   875: invokevirtual 979	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   878: ldc_w 1287
    //   881: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   884: aload 5
    //   886: getfield 1005	com/tencent/mobileqq/activity/photo/ImageInfo:m	Z
    //   889: invokevirtual 979	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   892: ldc_w 1289
    //   895: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   898: invokestatic 921	com/tencent/mobileqq/util/Utils:b	()J
    //   901: invokevirtual 746	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   904: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   907: invokestatic 953	com/tencent/mobileqq/utils/ImageUtil:a	(Lcom/tencent/mobileqq/activity/photo/ImageInfo;Ljava/lang/String;Ljava/lang/String;)V
    //   910: aload 5
    //   912: getfield 957	com/tencent/mobileqq/activity/photo/ImageInfo:h	Z
    //   915: ifne +272 -> 1187
    //   918: aload 5
    //   920: getfield 395	com/tencent/mobileqq/activity/photo/ImageInfo:g	Z
    //   923: ifeq +253 -> 1176
    //   926: iload_0
    //   927: iconst_3
    //   928: aload_1
    //   929: iconst_0
    //   930: aconst_null
    //   931: invokestatic 1243	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   934: iload 11
    //   936: ifeq +409 -> 1345
    //   939: aload 15
    //   941: invokevirtual 779	java/io/File:length	()J
    //   944: aload 16
    //   946: invokevirtual 779	java/io/File:length	()J
    //   949: lcmp
    //   950: ifgt +395 -> 1345
    //   953: iload 10
    //   955: ifne +390 -> 1345
    //   958: aload 5
    //   960: aload 15
    //   962: invokevirtual 346	java/io/File:getPath	()Ljava/lang/String;
    //   965: putfield 1105	com/tencent/mobileqq/activity/photo/ImageInfo:b	Ljava/lang/String;
    //   968: aload 5
    //   970: aload 15
    //   972: invokevirtual 779	java/io/File:length	()J
    //   975: putfield 1238	com/tencent/mobileqq/activity/photo/ImageInfo:a	J
    //   978: aload 5
    //   980: iconst_1
    //   981: putfield 971	com/tencent/mobileqq/activity/photo/ImageInfo:o	Z
    //   984: aload 5
    //   986: iconst_1
    //   987: putfield 957	com/tencent/mobileqq/activity/photo/ImageInfo:h	Z
    //   990: aload 15
    //   992: invokestatic 1261	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/io/File;)Landroid/graphics/BitmapFactory$Options;
    //   995: astore_2
    //   996: new 212	java/lang/StringBuilder
    //   999: dup
    //   1000: invokespecial 213	java/lang/StringBuilder:<init>	()V
    //   1003: ldc_w 1299
    //   1006: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1009: aload 16
    //   1011: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1014: ldc_w 1301
    //   1017: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1020: aload_3
    //   1021: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1024: ldc_w 1265
    //   1027: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1030: aload 15
    //   1032: invokevirtual 779	java/io/File:length	()J
    //   1035: invokevirtual 746	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1038: ldc_w 1267
    //   1041: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1044: aload_2
    //   1045: getfield 119	android/graphics/BitmapFactory$Options:outWidth	I
    //   1048: invokevirtual 364	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1051: ldc_w 1269
    //   1054: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1057: aload_2
    //   1058: getfield 122	android/graphics/BitmapFactory$Options:outHeight	I
    //   1061: invokevirtual 364	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1064: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1067: invokestatic 367	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   1070: aload 5
    //   1072: getfield 1239	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_l_of_type_Int	I
    //   1075: ifle +548 -> 1623
    //   1078: new 212	java/lang/StringBuilder
    //   1081: dup
    //   1082: invokespecial 213	java/lang/StringBuilder:<init>	()V
    //   1085: ldc_w 1241
    //   1088: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1091: aload 5
    //   1093: getfield 1239	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_l_of_type_Int	I
    //   1096: invokevirtual 364	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1099: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1102: invokestatic 367	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   1105: iload_0
    //   1106: bipush 8
    //   1108: aload_1
    //   1109: iconst_0
    //   1110: aconst_null
    //   1111: invokestatic 1243	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   1114: aload 5
    //   1116: getfield 1239	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_l_of_type_Int	I
    //   1119: ifle +515 -> 1634
    //   1122: iconst_1
    //   1123: istore 4
    //   1125: ldc_w 1215
    //   1128: iload 4
    //   1130: ldc_w 1215
    //   1133: invokestatic 1246	com/tencent/mobileqq/transfile/RichMediaUtil:a	(Ljava/lang/String;ZLjava/lang/String;)V
    //   1136: aload 5
    //   1138: ldc_w 1293
    //   1141: new 212	java/lang/StringBuilder
    //   1144: dup
    //   1145: invokespecial 213	java/lang/StringBuilder:<init>	()V
    //   1148: ldc_w 1303
    //   1151: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1154: aload 5
    //   1156: getfield 1239	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_l_of_type_Int	I
    //   1159: invokevirtual 364	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1162: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1165: invokestatic 953	com/tencent/mobileqq/utils/ImageUtil:a	(Lcom/tencent/mobileqq/activity/photo/ImageInfo;Ljava/lang/String;Ljava/lang/String;)V
    //   1168: iconst_1
    //   1169: ireturn
    //   1170: iconst_0
    //   1171: istore 10
    //   1173: goto -377 -> 796
    //   1176: iload_0
    //   1177: iconst_4
    //   1178: aload_1
    //   1179: iconst_0
    //   1180: aconst_null
    //   1181: invokestatic 1243	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   1184: goto -250 -> 934
    //   1187: iload 11
    //   1189: ifne -255 -> 934
    //   1192: iload 10
    //   1194: ifne -260 -> 934
    //   1197: aload 5
    //   1199: getfield 1239	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_l_of_type_Int	I
    //   1202: istore 8
    //   1204: aload 5
    //   1206: iload 8
    //   1208: iconst_1
    //   1209: iadd
    //   1210: putfield 1239	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_l_of_type_Int	I
    //   1213: iload 8
    //   1215: iconst_2
    //   1216: if_icmpge +33 -> 1249
    //   1219: aload 5
    //   1221: iconst_1
    //   1222: putfield 969	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_l_of_type_Boolean	Z
    //   1225: ldc_w 1305
    //   1228: invokestatic 367	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   1231: iload_0
    //   1232: aload_1
    //   1233: aload_2
    //   1234: aload_3
    //   1235: iload 4
    //   1237: aload 5
    //   1239: iload 6
    //   1241: iload 7
    //   1243: invokestatic 1233	com/tencent/mobileqq/utils/ImageUtil:a	(ILandroid/content/Context;Ljava/lang/String;Ljava/lang/String;ZLcom/tencent/mobileqq/activity/photo/ImageInfo;IZ)Z
    //   1246: pop
    //   1247: iconst_0
    //   1248: ireturn
    //   1249: aload 5
    //   1251: getfield 965	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_k_of_type_Boolean	Z
    //   1254: ifeq +15 -> 1269
    //   1257: iload_0
    //   1258: bipush 6
    //   1260: aload_1
    //   1261: iconst_0
    //   1262: aconst_null
    //   1263: invokestatic 1243	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   1266: goto -332 -> 934
    //   1269: aload 5
    //   1271: getfield 1307	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_j_of_type_Boolean	Z
    //   1274: ifeq +15 -> 1289
    //   1277: iload_0
    //   1278: bipush 7
    //   1280: aload_1
    //   1281: iconst_0
    //   1282: aconst_null
    //   1283: invokestatic 1243	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   1286: goto -352 -> 934
    //   1289: aload 5
    //   1291: getfield 969	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_l_of_type_Boolean	Z
    //   1294: ifne +15 -> 1309
    //   1297: iload_0
    //   1298: bipush 9
    //   1300: aload_1
    //   1301: iconst_0
    //   1302: aconst_null
    //   1303: invokestatic 1243	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   1306: goto -372 -> 934
    //   1309: aload 5
    //   1311: getfield 1005	com/tencent/mobileqq/activity/photo/ImageInfo:m	Z
    //   1314: ifeq +14 -> 1328
    //   1317: iload_0
    //   1318: iconst_0
    //   1319: aload_1
    //   1320: iconst_0
    //   1321: aconst_null
    //   1322: invokestatic 1243	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   1325: goto -391 -> 934
    //   1328: ldc_w 1309
    //   1331: invokestatic 367	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   1334: iload_0
    //   1335: iconst_5
    //   1336: aload_1
    //   1337: iconst_0
    //   1338: aconst_null
    //   1339: invokestatic 1243	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   1342: goto -408 -> 934
    //   1345: aload 5
    //   1347: aload 16
    //   1349: invokevirtual 346	java/io/File:getPath	()Ljava/lang/String;
    //   1352: putfield 1105	com/tencent/mobileqq/activity/photo/ImageInfo:b	Ljava/lang/String;
    //   1355: aload 5
    //   1357: aload 16
    //   1359: invokevirtual 779	java/io/File:length	()J
    //   1362: putfield 1238	com/tencent/mobileqq/activity/photo/ImageInfo:a	J
    //   1365: aload 5
    //   1367: iconst_0
    //   1368: putfield 971	com/tencent/mobileqq/activity/photo/ImageInfo:o	Z
    //   1371: aload 5
    //   1373: iconst_0
    //   1374: putfield 957	com/tencent/mobileqq/activity/photo/ImageInfo:h	Z
    //   1377: aload 15
    //   1379: ifnull +17 -> 1396
    //   1382: aload 15
    //   1384: invokevirtual 612	java/io/File:exists	()Z
    //   1387: ifeq +9 -> 1396
    //   1390: aload 15
    //   1392: invokevirtual 696	java/io/File:delete	()Z
    //   1395: pop
    //   1396: iload 10
    //   1398: ifne +155 -> 1553
    //   1401: new 212	java/lang/StringBuilder
    //   1404: dup
    //   1405: invokespecial 213	java/lang/StringBuilder:<init>	()V
    //   1408: ldc_w 1311
    //   1411: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1414: aload_3
    //   1415: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1418: ldc_w 1265
    //   1421: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1424: aload 15
    //   1426: invokevirtual 779	java/io/File:length	()J
    //   1429: invokevirtual 746	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1432: ldc_w 1313
    //   1435: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1438: aload 16
    //   1440: invokevirtual 779	java/io/File:length	()J
    //   1443: invokevirtual 746	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1446: ldc_w 1315
    //   1449: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1452: iload 10
    //   1454: invokevirtual 979	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1457: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1460: invokestatic 367	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   1463: new 212	java/lang/StringBuilder
    //   1466: dup
    //   1467: invokespecial 213	java/lang/StringBuilder:<init>	()V
    //   1470: ldc_w 1317
    //   1473: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1476: iconst_0
    //   1477: invokevirtual 979	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1480: ldc_w 1319
    //   1483: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1486: aload_3
    //   1487: invokestatic 1229	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;)Z
    //   1490: invokevirtual 979	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1493: ldc_w 1321
    //   1496: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1499: astore_1
    //   1500: aload 15
    //   1502: invokevirtual 779	java/io/File:length	()J
    //   1505: lconst_0
    //   1506: lcmp
    //   1507: ifgt +97 -> 1604
    //   1510: iconst_1
    //   1511: istore 4
    //   1513: aload_1
    //   1514: iload 4
    //   1516: invokevirtual 979	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1519: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1522: invokestatic 367	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   1525: iload 11
    //   1527: ifne +83 -> 1610
    //   1530: ldc_w 1215
    //   1533: iconst_1
    //   1534: ldc_w 1215
    //   1537: invokestatic 1246	com/tencent/mobileqq/transfile/RichMediaUtil:a	(Ljava/lang/String;ZLjava/lang/String;)V
    //   1540: aload 5
    //   1542: ldc_w 1293
    //   1545: ldc_w 1295
    //   1548: invokestatic 953	com/tencent/mobileqq/utils/ImageUtil:a	(Lcom/tencent/mobileqq/activity/photo/ImageInfo;Ljava/lang/String;Ljava/lang/String;)V
    //   1551: iconst_1
    //   1552: ireturn
    //   1553: new 212	java/lang/StringBuilder
    //   1556: dup
    //   1557: invokespecial 213	java/lang/StringBuilder:<init>	()V
    //   1560: ldc_w 1291
    //   1563: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1566: aload 16
    //   1568: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1571: ldc_w 1265
    //   1574: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1577: aload 16
    //   1579: invokevirtual 779	java/io/File:length	()J
    //   1582: invokevirtual 746	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1585: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1588: invokestatic 367	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   1591: ldc_w 1215
    //   1594: iconst_0
    //   1595: ldc_w 1215
    //   1598: invokestatic 1246	com/tencent/mobileqq/transfile/RichMediaUtil:a	(Ljava/lang/String;ZLjava/lang/String;)V
    //   1601: goto -61 -> 1540
    //   1604: iconst_0
    //   1605: istore 4
    //   1607: goto -94 -> 1513
    //   1610: ldc_w 1215
    //   1613: iconst_0
    //   1614: ldc_w 1215
    //   1617: invokestatic 1246	com/tencent/mobileqq/transfile/RichMediaUtil:a	(Ljava/lang/String;ZLjava/lang/String;)V
    //   1620: goto -80 -> 1540
    //   1623: iload_0
    //   1624: iconst_0
    //   1625: aload_1
    //   1626: iconst_1
    //   1627: aconst_null
    //   1628: invokestatic 1243	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   1631: goto -517 -> 1114
    //   1634: iconst_0
    //   1635: istore 4
    //   1637: goto -512 -> 1125
    //   1640: iload_0
    //   1641: aload_1
    //   1642: aload 16
    //   1644: aload 15
    //   1646: aload 5
    //   1648: iload 6
    //   1650: iload 8
    //   1652: iload 9
    //   1654: iload 4
    //   1656: iload 7
    //   1658: invokestatic 1323	com/tencent/mobileqq/utils/ImageUtil:a	(ILandroid/content/Context;Ljava/io/File;Ljava/io/File;Lcom/tencent/mobileqq/activity/photo/ImageInfo;IIIZZ)V
    //   1661: ldc 62
    //   1663: aload_1
    //   1664: iconst_0
    //   1665: invokestatic 352	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;Landroid/content/Context;Z)V
    //   1668: goto -1214 -> 454
    //   1671: astore 14
    //   1673: iload 11
    //   1675: istore 10
    //   1677: iconst_1
    //   1678: istore 12
    //   1680: ldc_w 1325
    //   1683: invokestatic 367	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   1686: aload 5
    //   1688: getfield 393	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_k_of_type_Int	I
    //   1691: iconst_1
    //   1692: if_icmpeq +12 -> 1704
    //   1695: aload 5
    //   1697: getfield 393	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_k_of_type_Int	I
    //   1700: iconst_1
    //   1701: if_icmpne +837 -> 2538
    //   1704: iconst_1
    //   1705: istore 11
    //   1707: aload_3
    //   1708: invokestatic 1259	com/tencent/mobileqq/utils/FileUtils:b	(Ljava/lang/String;)Z
    //   1711: istore 12
    //   1713: aload 5
    //   1715: ldc_w 1275
    //   1718: new 212	java/lang/StringBuilder
    //   1721: dup
    //   1722: invokespecial 213	java/lang/StringBuilder:<init>	()V
    //   1725: ldc_w 1277
    //   1728: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1731: aload 5
    //   1733: getfield 957	com/tencent/mobileqq/activity/photo/ImageInfo:h	Z
    //   1736: invokevirtual 979	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1739: ldc_w 1279
    //   1742: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1745: aload 5
    //   1747: getfield 395	com/tencent/mobileqq/activity/photo/ImageInfo:g	Z
    //   1750: invokevirtual 979	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1753: ldc_w 1281
    //   1756: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1759: iload 12
    //   1761: invokevirtual 979	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1764: ldc_w 1283
    //   1767: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1770: iload 11
    //   1772: invokevirtual 979	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1775: ldc_w 1285
    //   1778: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1781: aload 5
    //   1783: getfield 969	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_l_of_type_Boolean	Z
    //   1786: invokevirtual 979	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1789: ldc_w 1287
    //   1792: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1795: aload 5
    //   1797: getfield 1005	com/tencent/mobileqq/activity/photo/ImageInfo:m	Z
    //   1800: invokevirtual 979	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1803: ldc_w 1289
    //   1806: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1809: invokestatic 921	com/tencent/mobileqq/util/Utils:b	()J
    //   1812: invokevirtual 746	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1815: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1818: invokestatic 953	com/tencent/mobileqq/utils/ImageUtil:a	(Lcom/tencent/mobileqq/activity/photo/ImageInfo;Ljava/lang/String;Ljava/lang/String;)V
    //   1821: aload 5
    //   1823: getfield 957	com/tencent/mobileqq/activity/photo/ImageInfo:h	Z
    //   1826: ifne +729 -> 2555
    //   1829: aload 5
    //   1831: getfield 395	com/tencent/mobileqq/activity/photo/ImageInfo:g	Z
    //   1834: ifeq +710 -> 2544
    //   1837: iload_0
    //   1838: iconst_3
    //   1839: aload_1
    //   1840: iconst_0
    //   1841: aconst_null
    //   1842: invokestatic 1243	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   1845: aload 5
    //   1847: aload 16
    //   1849: invokevirtual 346	java/io/File:getPath	()Ljava/lang/String;
    //   1852: putfield 1105	com/tencent/mobileqq/activity/photo/ImageInfo:b	Ljava/lang/String;
    //   1855: aload 5
    //   1857: aload 16
    //   1859: invokevirtual 779	java/io/File:length	()J
    //   1862: putfield 1238	com/tencent/mobileqq/activity/photo/ImageInfo:a	J
    //   1865: aload 5
    //   1867: iconst_0
    //   1868: putfield 971	com/tencent/mobileqq/activity/photo/ImageInfo:o	Z
    //   1871: aload 5
    //   1873: iconst_0
    //   1874: putfield 957	com/tencent/mobileqq/activity/photo/ImageInfo:h	Z
    //   1877: aload 15
    //   1879: ifnull +17 -> 1896
    //   1882: aload 15
    //   1884: invokevirtual 612	java/io/File:exists	()Z
    //   1887: ifeq +9 -> 1896
    //   1890: aload 15
    //   1892: invokevirtual 696	java/io/File:delete	()Z
    //   1895: pop
    //   1896: iload 11
    //   1898: ifne +8 -> 1906
    //   1901: iload 10
    //   1903: ifeq +815 -> 2718
    //   1906: new 212	java/lang/StringBuilder
    //   1909: dup
    //   1910: invokespecial 213	java/lang/StringBuilder:<init>	()V
    //   1913: ldc_w 1291
    //   1916: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1919: aload 16
    //   1921: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1924: ldc_w 1265
    //   1927: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1930: aload 16
    //   1932: invokevirtual 779	java/io/File:length	()J
    //   1935: invokevirtual 746	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1938: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1941: invokestatic 367	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   1944: ldc_w 1215
    //   1947: iconst_0
    //   1948: ldc_w 1215
    //   1951: invokestatic 1246	com/tencent/mobileqq/transfile/RichMediaUtil:a	(Ljava/lang/String;ZLjava/lang/String;)V
    //   1954: aload 5
    //   1956: ldc_w 1293
    //   1959: ldc_w 1295
    //   1962: invokestatic 953	com/tencent/mobileqq/utils/ImageUtil:a	(Lcom/tencent/mobileqq/activity/photo/ImageInfo;Ljava/lang/String;Ljava/lang/String;)V
    //   1965: goto -1203 -> 762
    //   1968: iconst_0
    //   1969: istore 10
    //   1971: goto -1496 -> 475
    //   1974: iload_0
    //   1975: iconst_4
    //   1976: aload_1
    //   1977: iconst_0
    //   1978: aconst_null
    //   1979: invokestatic 1243	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   1982: goto -1369 -> 613
    //   1985: iload 12
    //   1987: ifne -1374 -> 613
    //   1990: iload 10
    //   1992: ifne -1379 -> 613
    //   1995: iload 11
    //   1997: ifne -1384 -> 613
    //   2000: aload 5
    //   2002: getfield 1239	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_l_of_type_Int	I
    //   2005: istore 8
    //   2007: aload 5
    //   2009: iload 8
    //   2011: iconst_1
    //   2012: iadd
    //   2013: putfield 1239	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_l_of_type_Int	I
    //   2016: iload 8
    //   2018: iconst_2
    //   2019: if_icmpge +33 -> 2052
    //   2022: aload 5
    //   2024: iconst_1
    //   2025: putfield 969	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_l_of_type_Boolean	Z
    //   2028: ldc_w 1305
    //   2031: invokestatic 367	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   2034: iload_0
    //   2035: aload_1
    //   2036: aload_2
    //   2037: aload_3
    //   2038: iload 4
    //   2040: aload 5
    //   2042: iload 6
    //   2044: iload 7
    //   2046: invokestatic 1233	com/tencent/mobileqq/utils/ImageUtil:a	(ILandroid/content/Context;Ljava/lang/String;Ljava/lang/String;ZLcom/tencent/mobileqq/activity/photo/ImageInfo;IZ)Z
    //   2049: pop
    //   2050: iconst_0
    //   2051: ireturn
    //   2052: aload 5
    //   2054: getfield 965	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_k_of_type_Boolean	Z
    //   2057: ifeq +15 -> 2072
    //   2060: iload_0
    //   2061: bipush 6
    //   2063: aload_1
    //   2064: iconst_0
    //   2065: aconst_null
    //   2066: invokestatic 1243	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   2069: goto -1456 -> 613
    //   2072: aload 5
    //   2074: getfield 1307	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_j_of_type_Boolean	Z
    //   2077: ifeq +15 -> 2092
    //   2080: iload_0
    //   2081: bipush 7
    //   2083: aload_1
    //   2084: iconst_0
    //   2085: aconst_null
    //   2086: invokestatic 1243	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   2089: goto -1476 -> 613
    //   2092: aload 5
    //   2094: getfield 969	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_l_of_type_Boolean	Z
    //   2097: ifne +15 -> 2112
    //   2100: iload_0
    //   2101: bipush 9
    //   2103: aload_1
    //   2104: iconst_0
    //   2105: aconst_null
    //   2106: invokestatic 1243	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   2109: goto -1496 -> 613
    //   2112: aload 5
    //   2114: getfield 1005	com/tencent/mobileqq/activity/photo/ImageInfo:m	Z
    //   2117: ifeq +14 -> 2131
    //   2120: iload_0
    //   2121: iconst_0
    //   2122: aload_1
    //   2123: iconst_0
    //   2124: aconst_null
    //   2125: invokestatic 1243	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   2128: goto -1515 -> 613
    //   2131: ldc_w 1309
    //   2134: invokestatic 367	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   2137: iload_0
    //   2138: iconst_5
    //   2139: aload_1
    //   2140: iconst_0
    //   2141: aconst_null
    //   2142: invokestatic 1243	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   2145: goto -1532 -> 613
    //   2148: new 212	java/lang/StringBuilder
    //   2151: dup
    //   2152: invokespecial 213	java/lang/StringBuilder:<init>	()V
    //   2155: ldc_w 1311
    //   2158: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2161: aload_3
    //   2162: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2165: ldc_w 1265
    //   2168: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2171: aload 15
    //   2173: invokevirtual 779	java/io/File:length	()J
    //   2176: invokevirtual 746	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2179: ldc_w 1313
    //   2182: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2185: aload 16
    //   2187: invokevirtual 779	java/io/File:length	()J
    //   2190: invokevirtual 746	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2193: ldc_w 1315
    //   2196: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2199: iload 10
    //   2201: invokevirtual 979	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2204: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2207: invokestatic 367	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   2210: new 212	java/lang/StringBuilder
    //   2213: dup
    //   2214: invokespecial 213	java/lang/StringBuilder:<init>	()V
    //   2217: ldc_w 1317
    //   2220: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2223: iconst_0
    //   2224: invokevirtual 979	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2227: ldc_w 1319
    //   2230: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2233: aload_3
    //   2234: invokestatic 1229	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;)Z
    //   2237: invokevirtual 979	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2240: ldc_w 1321
    //   2243: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2246: astore_1
    //   2247: aload 15
    //   2249: invokevirtual 779	java/io/File:length	()J
    //   2252: lconst_0
    //   2253: lcmp
    //   2254: ifgt +36 -> 2290
    //   2257: iconst_1
    //   2258: istore 4
    //   2260: aload_1
    //   2261: iload 4
    //   2263: invokevirtual 979	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2266: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2269: invokestatic 367	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   2272: iload 12
    //   2274: ifne +22 -> 2296
    //   2277: ldc_w 1215
    //   2280: iconst_1
    //   2281: ldc_w 1215
    //   2284: invokestatic 1246	com/tencent/mobileqq/transfile/RichMediaUtil:a	(Ljava/lang/String;ZLjava/lang/String;)V
    //   2287: goto -1536 -> 751
    //   2290: iconst_0
    //   2291: istore 4
    //   2293: goto -33 -> 2260
    //   2296: ldc_w 1215
    //   2299: iconst_0
    //   2300: ldc_w 1215
    //   2303: invokestatic 1246	com/tencent/mobileqq/transfile/RichMediaUtil:a	(Ljava/lang/String;ZLjava/lang/String;)V
    //   2306: goto -1555 -> 751
    //   2309: aload 5
    //   2311: aload 15
    //   2313: invokevirtual 346	java/io/File:getPath	()Ljava/lang/String;
    //   2316: putfield 1105	com/tencent/mobileqq/activity/photo/ImageInfo:b	Ljava/lang/String;
    //   2319: aload 5
    //   2321: aload 15
    //   2323: invokevirtual 779	java/io/File:length	()J
    //   2326: putfield 1238	com/tencent/mobileqq/activity/photo/ImageInfo:a	J
    //   2329: aload 5
    //   2331: iconst_1
    //   2332: putfield 971	com/tencent/mobileqq/activity/photo/ImageInfo:o	Z
    //   2335: aload 5
    //   2337: iconst_1
    //   2338: putfield 957	com/tencent/mobileqq/activity/photo/ImageInfo:h	Z
    //   2341: aload 15
    //   2343: invokestatic 1261	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/io/File;)Landroid/graphics/BitmapFactory$Options;
    //   2346: astore_2
    //   2347: new 212	java/lang/StringBuilder
    //   2350: dup
    //   2351: invokespecial 213	java/lang/StringBuilder:<init>	()V
    //   2354: ldc_w 1299
    //   2357: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2360: aload 16
    //   2362: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2365: ldc_w 1301
    //   2368: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2371: aload_3
    //   2372: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2375: ldc_w 1265
    //   2378: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2381: aload 15
    //   2383: invokevirtual 779	java/io/File:length	()J
    //   2386: invokevirtual 746	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2389: ldc_w 1267
    //   2392: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2395: aload_2
    //   2396: getfield 119	android/graphics/BitmapFactory$Options:outWidth	I
    //   2399: invokevirtual 364	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2402: ldc_w 1269
    //   2405: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2408: aload_2
    //   2409: getfield 122	android/graphics/BitmapFactory$Options:outHeight	I
    //   2412: invokevirtual 364	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2415: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2418: invokestatic 367	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   2421: aload 5
    //   2423: getfield 1239	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_l_of_type_Int	I
    //   2426: ifle +95 -> 2521
    //   2429: new 212	java/lang/StringBuilder
    //   2432: dup
    //   2433: invokespecial 213	java/lang/StringBuilder:<init>	()V
    //   2436: ldc_w 1241
    //   2439: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2442: aload 5
    //   2444: getfield 1239	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_l_of_type_Int	I
    //   2447: invokevirtual 364	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2450: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2453: invokestatic 367	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   2456: iload_0
    //   2457: bipush 8
    //   2459: aload_1
    //   2460: iconst_0
    //   2461: aconst_null
    //   2462: invokestatic 1243	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   2465: aload 5
    //   2467: getfield 1239	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_l_of_type_Int	I
    //   2470: ifle +62 -> 2532
    //   2473: iconst_1
    //   2474: istore 4
    //   2476: ldc_w 1215
    //   2479: iload 4
    //   2481: ldc_w 1215
    //   2484: invokestatic 1246	com/tencent/mobileqq/transfile/RichMediaUtil:a	(Ljava/lang/String;ZLjava/lang/String;)V
    //   2487: aload 5
    //   2489: ldc_w 1293
    //   2492: new 212	java/lang/StringBuilder
    //   2495: dup
    //   2496: invokespecial 213	java/lang/StringBuilder:<init>	()V
    //   2499: ldc_w 1303
    //   2502: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2505: aload 5
    //   2507: getfield 1239	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_l_of_type_Int	I
    //   2510: invokevirtual 364	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2513: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2516: invokestatic 953	com/tencent/mobileqq/utils/ImageUtil:a	(Lcom/tencent/mobileqq/activity/photo/ImageInfo;Ljava/lang/String;Ljava/lang/String;)V
    //   2519: iconst_1
    //   2520: ireturn
    //   2521: iload_0
    //   2522: iconst_0
    //   2523: aload_1
    //   2524: iconst_1
    //   2525: aconst_null
    //   2526: invokestatic 1243	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   2529: goto -64 -> 2465
    //   2532: iconst_0
    //   2533: istore 4
    //   2535: goto -59 -> 2476
    //   2538: iconst_0
    //   2539: istore 11
    //   2541: goto -834 -> 1707
    //   2544: iload_0
    //   2545: iconst_4
    //   2546: aload_1
    //   2547: iconst_0
    //   2548: aconst_null
    //   2549: invokestatic 1243	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   2552: goto -707 -> 1845
    //   2555: iload 12
    //   2557: ifne -712 -> 1845
    //   2560: iload 11
    //   2562: ifne -717 -> 1845
    //   2565: iload 10
    //   2567: ifne -722 -> 1845
    //   2570: aload 5
    //   2572: getfield 1239	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_l_of_type_Int	I
    //   2575: istore 8
    //   2577: aload 5
    //   2579: iload 8
    //   2581: iconst_1
    //   2582: iadd
    //   2583: putfield 1239	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_l_of_type_Int	I
    //   2586: iload 8
    //   2588: iconst_2
    //   2589: if_icmpge +33 -> 2622
    //   2592: aload 5
    //   2594: iconst_1
    //   2595: putfield 969	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_l_of_type_Boolean	Z
    //   2598: ldc_w 1305
    //   2601: invokestatic 367	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   2604: iload_0
    //   2605: aload_1
    //   2606: aload_2
    //   2607: aload_3
    //   2608: iload 4
    //   2610: aload 5
    //   2612: iload 6
    //   2614: iload 7
    //   2616: invokestatic 1233	com/tencent/mobileqq/utils/ImageUtil:a	(ILandroid/content/Context;Ljava/lang/String;Ljava/lang/String;ZLcom/tencent/mobileqq/activity/photo/ImageInfo;IZ)Z
    //   2619: pop
    //   2620: iconst_0
    //   2621: ireturn
    //   2622: aload 5
    //   2624: getfield 965	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_k_of_type_Boolean	Z
    //   2627: ifeq +15 -> 2642
    //   2630: iload_0
    //   2631: bipush 6
    //   2633: aload_1
    //   2634: iconst_0
    //   2635: aconst_null
    //   2636: invokestatic 1243	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   2639: goto -794 -> 1845
    //   2642: aload 5
    //   2644: getfield 1307	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_j_of_type_Boolean	Z
    //   2647: ifeq +15 -> 2662
    //   2650: iload_0
    //   2651: bipush 7
    //   2653: aload_1
    //   2654: iconst_0
    //   2655: aconst_null
    //   2656: invokestatic 1243	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   2659: goto -814 -> 1845
    //   2662: aload 5
    //   2664: getfield 969	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_l_of_type_Boolean	Z
    //   2667: ifne +15 -> 2682
    //   2670: iload_0
    //   2671: bipush 9
    //   2673: aload_1
    //   2674: iconst_0
    //   2675: aconst_null
    //   2676: invokestatic 1243	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   2679: goto -834 -> 1845
    //   2682: aload 5
    //   2684: getfield 1005	com/tencent/mobileqq/activity/photo/ImageInfo:m	Z
    //   2687: ifeq +14 -> 2701
    //   2690: iload_0
    //   2691: iconst_0
    //   2692: aload_1
    //   2693: iconst_0
    //   2694: aconst_null
    //   2695: invokestatic 1243	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   2698: goto -853 -> 1845
    //   2701: ldc_w 1309
    //   2704: invokestatic 367	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   2707: iload_0
    //   2708: iconst_5
    //   2709: aload_1
    //   2710: iconst_0
    //   2711: aconst_null
    //   2712: invokestatic 1243	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   2715: goto -870 -> 1845
    //   2718: new 212	java/lang/StringBuilder
    //   2721: dup
    //   2722: invokespecial 213	java/lang/StringBuilder:<init>	()V
    //   2725: ldc_w 1311
    //   2728: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2731: aload_3
    //   2732: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2735: ldc_w 1265
    //   2738: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2741: aload 15
    //   2743: invokevirtual 779	java/io/File:length	()J
    //   2746: invokevirtual 746	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2749: ldc_w 1313
    //   2752: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2755: aload 16
    //   2757: invokevirtual 779	java/io/File:length	()J
    //   2760: invokevirtual 746	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2763: ldc_w 1315
    //   2766: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2769: iload 11
    //   2771: invokevirtual 979	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2774: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2777: invokestatic 367	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   2780: new 212	java/lang/StringBuilder
    //   2783: dup
    //   2784: invokespecial 213	java/lang/StringBuilder:<init>	()V
    //   2787: ldc_w 1317
    //   2790: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2793: iconst_1
    //   2794: invokevirtual 979	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2797: ldc_w 1319
    //   2800: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2803: aload_3
    //   2804: invokestatic 1229	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;)Z
    //   2807: invokevirtual 979	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2810: ldc_w 1321
    //   2813: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2816: astore_1
    //   2817: aload 15
    //   2819: invokevirtual 779	java/io/File:length	()J
    //   2822: lconst_0
    //   2823: lcmp
    //   2824: ifgt +31 -> 2855
    //   2827: iconst_1
    //   2828: istore 4
    //   2830: aload_1
    //   2831: iload 4
    //   2833: invokevirtual 979	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2836: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2839: invokestatic 367	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   2842: ldc_w 1215
    //   2845: iconst_1
    //   2846: ldc_w 1215
    //   2849: invokestatic 1246	com/tencent/mobileqq/transfile/RichMediaUtil:a	(Ljava/lang/String;ZLjava/lang/String;)V
    //   2852: goto -898 -> 1954
    //   2855: iconst_0
    //   2856: istore 4
    //   2858: goto -28 -> 2830
    //   2861: astore 14
    //   2863: iconst_0
    //   2864: istore 11
    //   2866: iconst_0
    //   2867: istore 10
    //   2869: aload 5
    //   2871: getfield 393	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_k_of_type_Int	I
    //   2874: iconst_1
    //   2875: if_icmpeq +12 -> 2887
    //   2878: aload 5
    //   2880: getfield 393	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_k_of_type_Int	I
    //   2883: iconst_1
    //   2884: if_icmpne +301 -> 3185
    //   2887: iconst_1
    //   2888: istore 12
    //   2890: aload_3
    //   2891: invokestatic 1259	com/tencent/mobileqq/utils/FileUtils:b	(Ljava/lang/String;)Z
    //   2894: istore 13
    //   2896: aload 5
    //   2898: ldc_w 1275
    //   2901: new 212	java/lang/StringBuilder
    //   2904: dup
    //   2905: invokespecial 213	java/lang/StringBuilder:<init>	()V
    //   2908: ldc_w 1277
    //   2911: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2914: aload 5
    //   2916: getfield 957	com/tencent/mobileqq/activity/photo/ImageInfo:h	Z
    //   2919: invokevirtual 979	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2922: ldc_w 1279
    //   2925: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2928: aload 5
    //   2930: getfield 395	com/tencent/mobileqq/activity/photo/ImageInfo:g	Z
    //   2933: invokevirtual 979	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2936: ldc_w 1281
    //   2939: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2942: iload 13
    //   2944: invokevirtual 979	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2947: ldc_w 1283
    //   2950: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2953: iload 12
    //   2955: invokevirtual 979	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2958: ldc_w 1285
    //   2961: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2964: aload 5
    //   2966: getfield 969	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_l_of_type_Boolean	Z
    //   2969: invokevirtual 979	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2972: ldc_w 1287
    //   2975: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2978: aload 5
    //   2980: getfield 1005	com/tencent/mobileqq/activity/photo/ImageInfo:m	Z
    //   2983: invokevirtual 979	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2986: ldc_w 1289
    //   2989: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2992: invokestatic 921	com/tencent/mobileqq/util/Utils:b	()J
    //   2995: invokevirtual 746	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2998: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3001: invokestatic 953	com/tencent/mobileqq/utils/ImageUtil:a	(Lcom/tencent/mobileqq/activity/photo/ImageInfo;Ljava/lang/String;Ljava/lang/String;)V
    //   3004: aload 5
    //   3006: getfield 957	com/tencent/mobileqq/activity/photo/ImageInfo:h	Z
    //   3009: ifne +193 -> 3202
    //   3012: aload 5
    //   3014: getfield 395	com/tencent/mobileqq/activity/photo/ImageInfo:g	Z
    //   3017: ifeq +174 -> 3191
    //   3020: iload_0
    //   3021: iconst_3
    //   3022: aload_1
    //   3023: iconst_0
    //   3024: aconst_null
    //   3025: invokestatic 1243	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   3028: iload 10
    //   3030: ifne +32 -> 3062
    //   3033: iload 13
    //   3035: ifeq +27 -> 3062
    //   3038: aload 15
    //   3040: invokevirtual 779	java/io/File:length	()J
    //   3043: aload 16
    //   3045: invokevirtual 779	java/io/File:length	()J
    //   3048: lcmp
    //   3049: ifgt +13 -> 3062
    //   3052: iload 12
    //   3054: ifne +8 -> 3062
    //   3057: iload 11
    //   3059: ifeq +473 -> 3532
    //   3062: aload 5
    //   3064: aload 16
    //   3066: invokevirtual 346	java/io/File:getPath	()Ljava/lang/String;
    //   3069: putfield 1105	com/tencent/mobileqq/activity/photo/ImageInfo:b	Ljava/lang/String;
    //   3072: aload 5
    //   3074: aload 16
    //   3076: invokevirtual 779	java/io/File:length	()J
    //   3079: putfield 1238	com/tencent/mobileqq/activity/photo/ImageInfo:a	J
    //   3082: aload 5
    //   3084: iconst_0
    //   3085: putfield 971	com/tencent/mobileqq/activity/photo/ImageInfo:o	Z
    //   3088: aload 5
    //   3090: iconst_0
    //   3091: putfield 957	com/tencent/mobileqq/activity/photo/ImageInfo:h	Z
    //   3094: aload 15
    //   3096: ifnull +17 -> 3113
    //   3099: aload 15
    //   3101: invokevirtual 612	java/io/File:exists	()Z
    //   3104: ifeq +9 -> 3113
    //   3107: aload 15
    //   3109: invokevirtual 696	java/io/File:delete	()Z
    //   3112: pop
    //   3113: iload 12
    //   3115: ifne +8 -> 3123
    //   3118: iload 11
    //   3120: ifeq +245 -> 3365
    //   3123: new 212	java/lang/StringBuilder
    //   3126: dup
    //   3127: invokespecial 213	java/lang/StringBuilder:<init>	()V
    //   3130: ldc_w 1291
    //   3133: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3136: aload 16
    //   3138: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3141: ldc_w 1265
    //   3144: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3147: aload 16
    //   3149: invokevirtual 779	java/io/File:length	()J
    //   3152: invokevirtual 746	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3155: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3158: invokestatic 367	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   3161: ldc_w 1215
    //   3164: iconst_0
    //   3165: ldc_w 1215
    //   3168: invokestatic 1246	com/tencent/mobileqq/transfile/RichMediaUtil:a	(Ljava/lang/String;ZLjava/lang/String;)V
    //   3171: aload 5
    //   3173: ldc_w 1293
    //   3176: ldc_w 1295
    //   3179: invokestatic 953	com/tencent/mobileqq/utils/ImageUtil:a	(Lcom/tencent/mobileqq/activity/photo/ImageInfo;Ljava/lang/String;Ljava/lang/String;)V
    //   3182: aload 14
    //   3184: athrow
    //   3185: iconst_0
    //   3186: istore 12
    //   3188: goto -298 -> 2890
    //   3191: iload_0
    //   3192: iconst_4
    //   3193: aload_1
    //   3194: iconst_0
    //   3195: aconst_null
    //   3196: invokestatic 1243	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   3199: goto -171 -> 3028
    //   3202: iload 13
    //   3204: ifne -176 -> 3028
    //   3207: iload 12
    //   3209: ifne -181 -> 3028
    //   3212: iload 11
    //   3214: ifne -186 -> 3028
    //   3217: aload 5
    //   3219: getfield 1239	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_l_of_type_Int	I
    //   3222: istore 8
    //   3224: aload 5
    //   3226: iload 8
    //   3228: iconst_1
    //   3229: iadd
    //   3230: putfield 1239	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_l_of_type_Int	I
    //   3233: iload 8
    //   3235: iconst_2
    //   3236: if_icmpge +33 -> 3269
    //   3239: aload 5
    //   3241: iconst_1
    //   3242: putfield 969	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_l_of_type_Boolean	Z
    //   3245: ldc_w 1305
    //   3248: invokestatic 367	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   3251: iload_0
    //   3252: aload_1
    //   3253: aload_2
    //   3254: aload_3
    //   3255: iload 4
    //   3257: aload 5
    //   3259: iload 6
    //   3261: iload 7
    //   3263: invokestatic 1233	com/tencent/mobileqq/utils/ImageUtil:a	(ILandroid/content/Context;Ljava/lang/String;Ljava/lang/String;ZLcom/tencent/mobileqq/activity/photo/ImageInfo;IZ)Z
    //   3266: pop
    //   3267: iconst_0
    //   3268: ireturn
    //   3269: aload 5
    //   3271: getfield 965	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_k_of_type_Boolean	Z
    //   3274: ifeq +15 -> 3289
    //   3277: iload_0
    //   3278: bipush 6
    //   3280: aload_1
    //   3281: iconst_0
    //   3282: aconst_null
    //   3283: invokestatic 1243	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   3286: goto -258 -> 3028
    //   3289: aload 5
    //   3291: getfield 1307	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_j_of_type_Boolean	Z
    //   3294: ifeq +15 -> 3309
    //   3297: iload_0
    //   3298: bipush 7
    //   3300: aload_1
    //   3301: iconst_0
    //   3302: aconst_null
    //   3303: invokestatic 1243	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   3306: goto -278 -> 3028
    //   3309: aload 5
    //   3311: getfield 969	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_l_of_type_Boolean	Z
    //   3314: ifne +15 -> 3329
    //   3317: iload_0
    //   3318: bipush 9
    //   3320: aload_1
    //   3321: iconst_0
    //   3322: aconst_null
    //   3323: invokestatic 1243	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   3326: goto -298 -> 3028
    //   3329: aload 5
    //   3331: getfield 1005	com/tencent/mobileqq/activity/photo/ImageInfo:m	Z
    //   3334: ifeq +14 -> 3348
    //   3337: iload_0
    //   3338: iconst_0
    //   3339: aload_1
    //   3340: iconst_0
    //   3341: aconst_null
    //   3342: invokestatic 1243	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   3345: goto -317 -> 3028
    //   3348: ldc_w 1309
    //   3351: invokestatic 367	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   3354: iload_0
    //   3355: iconst_5
    //   3356: aload_1
    //   3357: iconst_0
    //   3358: aconst_null
    //   3359: invokestatic 1243	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   3362: goto -334 -> 3028
    //   3365: new 212	java/lang/StringBuilder
    //   3368: dup
    //   3369: invokespecial 213	java/lang/StringBuilder:<init>	()V
    //   3372: ldc_w 1311
    //   3375: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3378: aload_3
    //   3379: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3382: ldc_w 1265
    //   3385: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3388: aload 15
    //   3390: invokevirtual 779	java/io/File:length	()J
    //   3393: invokevirtual 746	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3396: ldc_w 1313
    //   3399: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3402: aload 16
    //   3404: invokevirtual 779	java/io/File:length	()J
    //   3407: invokevirtual 746	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3410: ldc_w 1315
    //   3413: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3416: iload 12
    //   3418: invokevirtual 979	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3421: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3424: invokestatic 367	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   3427: new 212	java/lang/StringBuilder
    //   3430: dup
    //   3431: invokespecial 213	java/lang/StringBuilder:<init>	()V
    //   3434: ldc_w 1317
    //   3437: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3440: iload 10
    //   3442: invokevirtual 979	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3445: ldc_w 1319
    //   3448: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3451: aload_3
    //   3452: invokestatic 1229	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;)Z
    //   3455: invokevirtual 979	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3458: ldc_w 1321
    //   3461: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3464: astore_1
    //   3465: aload 15
    //   3467: invokevirtual 779	java/io/File:length	()J
    //   3470: lconst_0
    //   3471: lcmp
    //   3472: ifgt +41 -> 3513
    //   3475: iconst_1
    //   3476: istore 4
    //   3478: aload_1
    //   3479: iload 4
    //   3481: invokevirtual 979	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3484: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3487: invokestatic 367	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   3490: iload 10
    //   3492: ifne +8 -> 3500
    //   3495: iload 13
    //   3497: ifne +22 -> 3519
    //   3500: ldc_w 1215
    //   3503: iconst_1
    //   3504: ldc_w 1215
    //   3507: invokestatic 1246	com/tencent/mobileqq/transfile/RichMediaUtil:a	(Ljava/lang/String;ZLjava/lang/String;)V
    //   3510: goto -339 -> 3171
    //   3513: iconst_0
    //   3514: istore 4
    //   3516: goto -38 -> 3478
    //   3519: ldc_w 1215
    //   3522: iconst_0
    //   3523: ldc_w 1215
    //   3526: invokestatic 1246	com/tencent/mobileqq/transfile/RichMediaUtil:a	(Ljava/lang/String;ZLjava/lang/String;)V
    //   3529: goto -358 -> 3171
    //   3532: aload 5
    //   3534: aload 15
    //   3536: invokevirtual 346	java/io/File:getPath	()Ljava/lang/String;
    //   3539: putfield 1105	com/tencent/mobileqq/activity/photo/ImageInfo:b	Ljava/lang/String;
    //   3542: aload 5
    //   3544: aload 15
    //   3546: invokevirtual 779	java/io/File:length	()J
    //   3549: putfield 1238	com/tencent/mobileqq/activity/photo/ImageInfo:a	J
    //   3552: aload 5
    //   3554: iconst_1
    //   3555: putfield 971	com/tencent/mobileqq/activity/photo/ImageInfo:o	Z
    //   3558: aload 5
    //   3560: iconst_1
    //   3561: putfield 957	com/tencent/mobileqq/activity/photo/ImageInfo:h	Z
    //   3564: aload 15
    //   3566: invokestatic 1261	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/io/File;)Landroid/graphics/BitmapFactory$Options;
    //   3569: astore_2
    //   3570: new 212	java/lang/StringBuilder
    //   3573: dup
    //   3574: invokespecial 213	java/lang/StringBuilder:<init>	()V
    //   3577: ldc_w 1299
    //   3580: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3583: aload 16
    //   3585: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3588: ldc_w 1301
    //   3591: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3594: aload_3
    //   3595: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3598: ldc_w 1265
    //   3601: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3604: aload 15
    //   3606: invokevirtual 779	java/io/File:length	()J
    //   3609: invokevirtual 746	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3612: ldc_w 1267
    //   3615: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3618: aload_2
    //   3619: getfield 119	android/graphics/BitmapFactory$Options:outWidth	I
    //   3622: invokevirtual 364	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3625: ldc_w 1269
    //   3628: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3631: aload_2
    //   3632: getfield 122	android/graphics/BitmapFactory$Options:outHeight	I
    //   3635: invokevirtual 364	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3638: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3641: invokestatic 367	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   3644: aload 5
    //   3646: getfield 1239	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_l_of_type_Int	I
    //   3649: ifle +95 -> 3744
    //   3652: new 212	java/lang/StringBuilder
    //   3655: dup
    //   3656: invokespecial 213	java/lang/StringBuilder:<init>	()V
    //   3659: ldc_w 1241
    //   3662: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3665: aload 5
    //   3667: getfield 1239	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_l_of_type_Int	I
    //   3670: invokevirtual 364	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3673: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3676: invokestatic 367	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   3679: iload_0
    //   3680: bipush 8
    //   3682: aload_1
    //   3683: iconst_0
    //   3684: aconst_null
    //   3685: invokestatic 1243	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   3688: aload 5
    //   3690: getfield 1239	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_l_of_type_Int	I
    //   3693: ifle +62 -> 3755
    //   3696: iconst_1
    //   3697: istore 4
    //   3699: ldc_w 1215
    //   3702: iload 4
    //   3704: ldc_w 1215
    //   3707: invokestatic 1246	com/tencent/mobileqq/transfile/RichMediaUtil:a	(Ljava/lang/String;ZLjava/lang/String;)V
    //   3710: aload 5
    //   3712: ldc_w 1293
    //   3715: new 212	java/lang/StringBuilder
    //   3718: dup
    //   3719: invokespecial 213	java/lang/StringBuilder:<init>	()V
    //   3722: ldc_w 1303
    //   3725: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3728: aload 5
    //   3730: getfield 1239	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_l_of_type_Int	I
    //   3733: invokevirtual 364	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3736: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3739: invokestatic 953	com/tencent/mobileqq/utils/ImageUtil:a	(Lcom/tencent/mobileqq/activity/photo/ImageInfo;Ljava/lang/String;Ljava/lang/String;)V
    //   3742: iconst_1
    //   3743: ireturn
    //   3744: iload_0
    //   3745: iconst_0
    //   3746: aload_1
    //   3747: iconst_1
    //   3748: aconst_null
    //   3749: invokestatic 1243	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   3752: goto -64 -> 3688
    //   3755: iconst_0
    //   3756: istore 4
    //   3758: goto -59 -> 3699
    //   3761: astore 14
    //   3763: iconst_0
    //   3764: istore 10
    //   3766: goto -897 -> 2869
    //   3769: astore 14
    //   3771: iload 10
    //   3773: istore 11
    //   3775: iload 12
    //   3777: istore 10
    //   3779: goto -910 -> 2869
    //   3782: astore 14
    //   3784: iconst_0
    //   3785: istore 10
    //   3787: goto -2110 -> 1677
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3790	0	paramInt1	int
    //   0	3790	1	paramContext	Context
    //   0	3790	2	paramString1	String
    //   0	3790	3	paramString2	String
    //   0	3790	4	paramBoolean1	boolean
    //   0	3790	5	paramImageInfo	ImageInfo
    //   0	3790	6	paramInt2	int
    //   0	3790	7	paramBoolean2	boolean
    //   377	2860	8	i1	int
    //   384	1269	9	i2	int
    //   473	3313	10	bool1	boolean
    //   318	3456	11	bool2	boolean
    //   479	3297	12	bool3	boolean
    //   2894	602	13	bool4	boolean
    //   53	327	14	localObject1	Object
    //   1671	1	14	localIOException1	IOException
    //   2861	322	14	localObject2	Object
    //   3761	1	14	localObject3	Object
    //   3769	1	14	localObject4	Object
    //   3782	1	14	localIOException2	IOException
    //   91	3514	15	localFile1	File
    //   101	3483	16	localFile2	File
    // Exception table:
    //   from	to	target	type
    //   320	327	1671	java/io/IOException
    //   332	386	1671	java/io/IOException
    //   426	454	1671	java/io/IOException
    //   1640	1668	1671	java/io/IOException
    //   200	313	2861	finally
    //   313	320	2861	finally
    //   764	775	2861	finally
    //   320	327	3761	finally
    //   332	386	3761	finally
    //   426	454	3761	finally
    //   1640	1668	3761	finally
    //   1680	1686	3769	finally
    //   200	313	3782	java/io/IOException
    //   313	320	3782	java/io/IOException
    //   764	775	3782	java/io/IOException
  }
  
  public static boolean a(Context paramContext, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    String str = paramString2;
    if (paramString2 == null) {
      str = "image_upload";
    }
    if (!FileUtils.b(paramString1)) {
      try
      {
        if (!FileUtils.a(paramString1))
        {
          if (QLog.isColorLevel()) {
            QLog.e(str, 2, paramString3 + ",filePath not exist,filePath=" + paramString1);
          }
          throw new RuntimeException(paramString3 + " file not exists,path=" + paramString1);
        }
      }
      catch (Exception paramString2)
      {
        paramString2 = AbstractImageDownloader.a(paramString2);
        if (!FileUtils.a(paramString1))
        {
          a(paramInt, 1, paramContext, false, "report_sendphoto_file_error", paramString2);
          return false;
          if (QLog.isColorLevel()) {
            QLog.e(str, 2, paramString3 + ",filePath size is 0,filePath=" + paramString1);
          }
          throw new RuntimeException(paramString3 + " file size==0,path=" + paramString1);
        }
        a(paramInt, 2, paramContext, false, "report_sendphoto_file_error", paramString2);
        return false;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.e(str, 2, paramString3 + ",filePath not exist,filePath=" + paramString1);
    }
    a(paramInt, 0, paramContext, true, "report_sendphoto_file_error");
    return true;
  }
  
  /* Error */
  public static boolean a(Context paramContext, String paramString1, String paramString2, ImageInfo paramImageInfo, int paramInt)
  {
    // Byte code:
    //   0: new 343	java/io/File
    //   3: dup
    //   4: aload_2
    //   5: invokespecial 677	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore 6
    //   10: new 343	java/io/File
    //   13: dup
    //   14: aload_1
    //   15: invokespecial 677	java/io/File:<init>	(Ljava/lang/String;)V
    //   18: astore_1
    //   19: aload_1
    //   20: invokestatic 995	com/tencent/image/GifDrawable:isGifFile	(Ljava/io/File;)Z
    //   23: ifeq +11 -> 34
    //   26: aload_1
    //   27: aload 6
    //   29: invokestatic 1338	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/io/File;Ljava/io/File;)V
    //   32: iconst_1
    //   33: ireturn
    //   34: new 105	android/graphics/BitmapFactory$Options
    //   37: dup
    //   38: invokespecial 106	android/graphics/BitmapFactory$Options:<init>	()V
    //   41: aload_1
    //   42: invokevirtual 346	java/io/File:getPath	()Ljava/lang/String;
    //   45: getstatic 92	com/tencent/mobileqq/utils/ImageUtil:x	I
    //   48: invokestatic 349	com/tencent/mobileqq/utils/ImageUtil:a	(Landroid/graphics/BitmapFactory$Options;Ljava/lang/String;I)Landroid/graphics/BitmapFactory$Options;
    //   51: astore_2
    //   52: iconst_1
    //   53: istore 4
    //   55: aconst_null
    //   56: astore_0
    //   57: aload_0
    //   58: ifnonnull +11 -> 69
    //   61: aload_2
    //   62: getfield 355	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   65: iconst_4
    //   66: if_icmple +8 -> 74
    //   69: iload 4
    //   71: ifeq +48 -> 119
    //   74: iload 4
    //   76: ifne +13 -> 89
    //   79: aload_2
    //   80: aload_2
    //   81: getfield 355	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   84: iconst_2
    //   85: imul
    //   86: putfield 355	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   89: aload_1
    //   90: invokevirtual 346	java/io/File:getPath	()Ljava/lang/String;
    //   93: aload_2
    //   94: invokestatic 359	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   97: astore_0
    //   98: iconst_0
    //   99: istore 4
    //   101: goto -44 -> 57
    //   104: astore_0
    //   105: ldc_w 1340
    //   108: invokestatic 367	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   111: iconst_0
    //   112: istore 4
    //   114: aconst_null
    //   115: astore_0
    //   116: goto -59 -> 57
    //   119: aload_0
    //   120: ifnonnull +16 -> 136
    //   123: aload_3
    //   124: iconst_0
    //   125: putfield 957	com/tencent/mobileqq/activity/photo/ImageInfo:h	Z
    //   128: aload 6
    //   130: invokevirtual 696	java/io/File:delete	()Z
    //   133: pop
    //   134: iconst_0
    //   135: ireturn
    //   136: aload_0
    //   137: aload_1
    //   138: invokestatic 967	com/tencent/mobileqq/utils/ImageUtil:a	(Landroid/graphics/Bitmap;Ljava/io/File;)Landroid/graphics/Bitmap;
    //   141: astore_1
    //   142: aload_1
    //   143: astore_0
    //   144: new 763	java/io/FileOutputStream
    //   147: dup
    //   148: aload 6
    //   150: invokespecial 764	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   153: astore_1
    //   154: aload_1
    //   155: astore_2
    //   156: aload_0
    //   157: astore 5
    //   159: aload_0
    //   160: getstatic 770	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   163: bipush 100
    //   165: aload_1
    //   166: invokevirtual 774	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   169: pop
    //   170: aload_1
    //   171: astore_2
    //   172: aload_0
    //   173: astore 5
    //   175: aload_3
    //   176: aload 6
    //   178: invokevirtual 346	java/io/File:getPath	()Ljava/lang/String;
    //   181: putfield 1105	com/tencent/mobileqq/activity/photo/ImageInfo:b	Ljava/lang/String;
    //   184: aload_1
    //   185: astore_2
    //   186: aload_0
    //   187: astore 5
    //   189: aload_3
    //   190: aload 6
    //   192: invokevirtual 779	java/io/File:length	()J
    //   195: putfield 1238	com/tencent/mobileqq/activity/photo/ImageInfo:a	J
    //   198: aload_1
    //   199: ifnull +7 -> 206
    //   202: aload_1
    //   203: invokevirtual 777	java/io/OutputStream:close	()V
    //   206: aload_0
    //   207: ifnull -175 -> 32
    //   210: aload_0
    //   211: invokevirtual 581	android/graphics/Bitmap:isRecycled	()Z
    //   214: ifne -182 -> 32
    //   217: aload_0
    //   218: invokevirtual 539	android/graphics/Bitmap:recycle	()V
    //   221: iconst_1
    //   222: ireturn
    //   223: astore_1
    //   224: aload_1
    //   225: invokevirtual 780	java/io/IOException:toString	()Ljava/lang/String;
    //   228: invokestatic 367	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   231: goto -25 -> 206
    //   234: astore_2
    //   235: aconst_null
    //   236: astore 5
    //   238: aload_0
    //   239: astore_1
    //   240: aload 5
    //   242: astore_0
    //   243: aload_3
    //   244: iconst_0
    //   245: putfield 957	com/tencent/mobileqq/activity/photo/ImageInfo:h	Z
    //   248: aload 6
    //   250: invokevirtual 696	java/io/File:delete	()Z
    //   253: pop
    //   254: new 212	java/lang/StringBuilder
    //   257: dup
    //   258: invokespecial 213	java/lang/StringBuilder:<init>	()V
    //   261: ldc_w 1013
    //   264: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: aload_2
    //   268: invokevirtual 588	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   271: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   277: invokestatic 367	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   280: aload_0
    //   281: ifnull +7 -> 288
    //   284: aload_0
    //   285: invokevirtual 777	java/io/OutputStream:close	()V
    //   288: aload_1
    //   289: ifnull +14 -> 303
    //   292: aload_1
    //   293: invokevirtual 581	android/graphics/Bitmap:isRecycled	()Z
    //   296: ifne +7 -> 303
    //   299: aload_1
    //   300: invokevirtual 539	android/graphics/Bitmap:recycle	()V
    //   303: iconst_0
    //   304: ireturn
    //   305: astore_0
    //   306: aload_0
    //   307: invokevirtual 780	java/io/IOException:toString	()Ljava/lang/String;
    //   310: invokestatic 367	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   313: goto -25 -> 288
    //   316: astore_1
    //   317: aconst_null
    //   318: astore_1
    //   319: aload_1
    //   320: astore_2
    //   321: aload_0
    //   322: astore 5
    //   324: aload_3
    //   325: iconst_0
    //   326: putfield 957	com/tencent/mobileqq/activity/photo/ImageInfo:h	Z
    //   329: aload_1
    //   330: astore_2
    //   331: aload_0
    //   332: astore 5
    //   334: aload 6
    //   336: invokevirtual 696	java/io/File:delete	()Z
    //   339: pop
    //   340: aload_1
    //   341: astore_2
    //   342: aload_0
    //   343: astore 5
    //   345: ldc_w 1340
    //   348: invokestatic 367	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   351: aload_1
    //   352: ifnull +7 -> 359
    //   355: aload_1
    //   356: invokevirtual 777	java/io/OutputStream:close	()V
    //   359: aload_0
    //   360: ifnull +14 -> 374
    //   363: aload_0
    //   364: invokevirtual 581	android/graphics/Bitmap:isRecycled	()Z
    //   367: ifne +7 -> 374
    //   370: aload_0
    //   371: invokevirtual 539	android/graphics/Bitmap:recycle	()V
    //   374: iconst_0
    //   375: ireturn
    //   376: astore_1
    //   377: aload_1
    //   378: invokevirtual 780	java/io/IOException:toString	()Ljava/lang/String;
    //   381: invokestatic 367	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   384: goto -25 -> 359
    //   387: astore_1
    //   388: aconst_null
    //   389: astore_2
    //   390: aload_2
    //   391: ifnull +7 -> 398
    //   394: aload_2
    //   395: invokevirtual 777	java/io/OutputStream:close	()V
    //   398: aload_0
    //   399: ifnull +14 -> 413
    //   402: aload_0
    //   403: invokevirtual 581	android/graphics/Bitmap:isRecycled	()Z
    //   406: ifne +7 -> 413
    //   409: aload_0
    //   410: invokevirtual 539	android/graphics/Bitmap:recycle	()V
    //   413: aload_1
    //   414: athrow
    //   415: astore_2
    //   416: aload_2
    //   417: invokevirtual 780	java/io/IOException:toString	()Ljava/lang/String;
    //   420: invokestatic 367	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   423: goto -25 -> 398
    //   426: astore_1
    //   427: aconst_null
    //   428: astore_2
    //   429: goto -39 -> 390
    //   432: astore_1
    //   433: aload 5
    //   435: astore_0
    //   436: goto -46 -> 390
    //   439: astore_2
    //   440: aload_1
    //   441: astore_3
    //   442: aload_2
    //   443: astore_1
    //   444: aload_0
    //   445: astore_2
    //   446: aload_3
    //   447: astore_0
    //   448: goto -58 -> 390
    //   451: astore_1
    //   452: aconst_null
    //   453: astore_1
    //   454: goto -135 -> 319
    //   457: astore_2
    //   458: goto -139 -> 319
    //   461: astore_2
    //   462: aconst_null
    //   463: astore 5
    //   465: aload_0
    //   466: astore_1
    //   467: aload 5
    //   469: astore_0
    //   470: goto -227 -> 243
    //   473: astore_2
    //   474: aload_0
    //   475: astore 5
    //   477: aload_1
    //   478: astore_0
    //   479: aload 5
    //   481: astore_1
    //   482: goto -239 -> 243
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	485	0	paramContext	Context
    //   0	485	1	paramString1	String
    //   0	485	2	paramString2	String
    //   0	485	3	paramImageInfo	ImageInfo
    //   0	485	4	paramInt	int
    //   157	323	5	localContext	Context
    //   8	327	6	localFile	File
    // Exception table:
    //   from	to	target	type
    //   89	98	104	java/lang/OutOfMemoryError
    //   202	206	223	java/io/IOException
    //   136	142	234	java/lang/Exception
    //   284	288	305	java/io/IOException
    //   136	142	316	java/lang/OutOfMemoryError
    //   355	359	376	java/io/IOException
    //   136	142	387	finally
    //   394	398	415	java/io/IOException
    //   144	154	426	finally
    //   159	170	432	finally
    //   175	184	432	finally
    //   189	198	432	finally
    //   324	329	432	finally
    //   334	340	432	finally
    //   345	351	432	finally
    //   243	280	439	finally
    //   144	154	451	java/lang/OutOfMemoryError
    //   159	170	457	java/lang/OutOfMemoryError
    //   175	184	457	java/lang/OutOfMemoryError
    //   189	198	457	java/lang/OutOfMemoryError
    //   144	154	461	java/lang/Exception
    //   159	170	473	java/lang/Exception
    //   175	184	473	java/lang/Exception
    //   189	198	473	java/lang/Exception
  }
  
  public static boolean a(File paramFile)
  {
    paramFile = new RandomAccessFile(paramFile, "r");
    byte[] arrayOfByte = new byte[10];
    paramFile.read(arrayOfByte);
    if ((arrayOfByte[0] != 71) || (arrayOfByte[1] != 73) || (arrayOfByte[2] != 70))
    {
      paramFile.close();
      return false;
    }
    paramFile.close();
    return true;
  }
  
  public static boolean a(String paramString)
  {
    if (!FileUtils.b(paramString)) {}
    for (;;)
    {
      return false;
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      try
      {
        BitmapFactory.decodeFile(paramString, localOptions);
        if ((localOptions.outWidth > 0) && (localOptions.outHeight > 0)) {
          return true;
        }
      }
      catch (Exception paramString)
      {
        return false;
      }
      catch (OutOfMemoryError paramString) {}
    }
    return false;
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    try
    {
      if (FileUtils.b(paramString2)) {
        break label96;
      }
      bool = FileUtils.a(paramString2);
      if (bool) {
        break label64;
      }
      i1 = 9042;
      try
      {
        throw new RuntimeException("file not exists,path=" + paramString2);
      }
      catch (Exception paramString2) {}
    }
    catch (Exception paramString2)
    {
      for (;;)
      {
        boolean bool;
        label64:
        label96:
        String str;
        int i1 = 0;
      }
    }
    a(paramString1, false, AbstractImageDownloader.a(paramString2), String.valueOf(i1));
    return false;
    i1 = 9071;
    throw new RuntimeException("file size==0,path=" + paramString2);
    str = FileUtils.a(paramString2);
    if ((str != null) && (str.length() > 0))
    {
      bool = str.contains(FileUtils.b);
      if (bool)
      {
        i1 = 9072;
        throw new RuntimeException("file unKnownFileTypeMark" + paramString2);
      }
    }
    a(paramString1, true, null, null);
    return true;
  }
  
  private static byte[] a(long paramLong)
  {
    byte[] arrayOfByte1 = new byte[54];
    byte[] tmp8_6 = arrayOfByte1;
    tmp8_6[0] = 66;
    byte[] tmp14_8 = tmp8_6;
    tmp14_8[1] = 77;
    byte[] tmp20_14 = tmp14_8;
    tmp20_14[2] = -56;
    byte[] tmp26_20 = tmp20_14;
    tmp26_20[3] = 1;
    byte[] tmp31_26 = tmp26_20;
    tmp31_26[4] = 0;
    byte[] tmp36_31 = tmp31_26;
    tmp36_31[5] = 0;
    byte[] tmp41_36 = tmp36_31;
    tmp41_36[6] = 0;
    byte[] tmp47_41 = tmp41_36;
    tmp47_41[7] = 0;
    byte[] tmp53_47 = tmp47_41;
    tmp53_47[8] = 0;
    byte[] tmp59_53 = tmp53_47;
    tmp59_53[9] = 0;
    byte[] tmp65_59 = tmp59_53;
    tmp65_59[10] = 54;
    byte[] tmp72_65 = tmp65_59;
    tmp72_65[11] = 0;
    byte[] tmp78_72 = tmp72_65;
    tmp78_72[12] = 0;
    byte[] tmp84_78 = tmp78_72;
    tmp84_78[13] = 0;
    byte[] tmp90_84 = tmp84_78;
    tmp90_84[14] = 40;
    byte[] tmp97_90 = tmp90_84;
    tmp97_90[15] = 0;
    byte[] tmp103_97 = tmp97_90;
    tmp103_97[16] = 0;
    byte[] tmp109_103 = tmp103_97;
    tmp109_103[17] = 0;
    byte[] tmp115_109 = tmp109_103;
    tmp115_109[18] = 10;
    byte[] tmp122_115 = tmp115_109;
    tmp122_115[19] = 0;
    byte[] tmp128_122 = tmp122_115;
    tmp128_122[20] = 0;
    byte[] tmp134_128 = tmp128_122;
    tmp134_128[21] = 0;
    byte[] tmp140_134 = tmp134_128;
    tmp140_134[22] = 10;
    byte[] tmp147_140 = tmp140_134;
    tmp147_140[23] = 0;
    byte[] tmp153_147 = tmp147_140;
    tmp153_147[24] = 0;
    byte[] tmp159_153 = tmp153_147;
    tmp159_153[25] = 0;
    byte[] tmp165_159 = tmp159_153;
    tmp165_159[26] = 1;
    byte[] tmp171_165 = tmp165_159;
    tmp171_165[27] = 0;
    byte[] tmp177_171 = tmp171_165;
    tmp177_171[28] = 32;
    byte[] tmp184_177 = tmp177_171;
    tmp184_177[29] = 0;
    byte[] tmp190_184 = tmp184_177;
    tmp190_184[30] = 0;
    byte[] tmp196_190 = tmp190_184;
    tmp196_190[31] = 0;
    byte[] tmp202_196 = tmp196_190;
    tmp202_196[32] = 0;
    byte[] tmp208_202 = tmp202_196;
    tmp208_202[33] = 0;
    byte[] tmp214_208 = tmp208_202;
    tmp214_208[34] = 0;
    byte[] tmp220_214 = tmp214_208;
    tmp220_214[35] = 0;
    byte[] tmp226_220 = tmp220_214;
    tmp226_220[36] = 0;
    byte[] tmp232_226 = tmp226_220;
    tmp232_226[37] = 0;
    byte[] tmp238_232 = tmp232_226;
    tmp238_232[38] = 18;
    byte[] tmp245_238 = tmp238_232;
    tmp245_238[39] = 11;
    byte[] tmp252_245 = tmp245_238;
    tmp252_245[40] = 0;
    byte[] tmp258_252 = tmp252_245;
    tmp258_252[41] = 0;
    byte[] tmp264_258 = tmp258_252;
    tmp264_258[42] = 18;
    byte[] tmp271_264 = tmp264_258;
    tmp271_264[43] = 11;
    byte[] tmp278_271 = tmp271_264;
    tmp278_271[44] = 0;
    byte[] tmp284_278 = tmp278_271;
    tmp284_278[45] = 0;
    byte[] tmp290_284 = tmp284_278;
    tmp290_284[46] = 0;
    byte[] tmp296_290 = tmp290_284;
    tmp296_290[47] = 0;
    byte[] tmp302_296 = tmp296_290;
    tmp302_296[48] = 0;
    byte[] tmp308_302 = tmp302_296;
    tmp308_302[49] = 0;
    byte[] tmp314_308 = tmp308_302;
    tmp314_308[50] = 0;
    byte[] tmp320_314 = tmp314_308;
    tmp320_314[51] = 0;
    byte[] tmp326_320 = tmp320_314;
    tmp326_320[52] = 0;
    byte[] tmp332_326 = tmp326_320;
    tmp332_326[53] = 0;
    tmp332_326;
    int i2 = (int)(paramLong / 4L);
    int i1 = i2;
    if (paramLong % 4L != 0L) {
      i1 = i2 + 1;
    }
    int i3 = (int)Math.sqrt(i1);
    i2 = i1 / i3;
    if (i1 % i3 != 0) {}
    for (i1 = i2 + 1;; i1 = i2)
    {
      i2 = (int)(i3 * i1 * 4 - paramLong);
      paramLong = i3 * i1 * 4 + 54;
      arrayOfByte1[2] = ((byte)(int)paramLong);
      arrayOfByte1[3] = ((byte)(int)(paramLong >> 8));
      arrayOfByte1[4] = ((byte)(int)(paramLong >> 16));
      arrayOfByte1[5] = ((byte)(int)(paramLong >> 24));
      arrayOfByte1[18] = ((byte)i3);
      arrayOfByte1[19] = ((byte)(i3 >> 8));
      arrayOfByte1[20] = ((byte)(i3 >> 16));
      arrayOfByte1[21] = ((byte)(i3 >> 24));
      arrayOfByte1[22] = ((byte)i1);
      arrayOfByte1[23] = ((byte)(i1 >> 8));
      arrayOfByte1[24] = ((byte)(i1 >> 16));
      arrayOfByte1[25] = ((byte)(i1 >> 24));
      byte[] arrayOfByte2 = new byte[i2 + 54];
      System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, 54);
      return arrayOfByte2;
    }
  }
  
  private static String[] a()
  {
    if (a != null) {
      return a;
    }
    String[] arrayOfString = RichMediaUtil.d();
    a = new String[arrayOfString.length + 1];
    int i1 = 0;
    while (i1 < arrayOfString.length)
    {
      a[i1] = arrayOfString[i1];
      i1 += 1;
    }
    a[(a.length - 1)] = p;
    return a;
  }
  
  public static int b(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int i3 = 1;
    int i2 = 1;
    int i1 = i2;
    if (paramInt1 != 0)
    {
      i1 = i2;
      if (paramInt2 != 0)
      {
        i1 = i2;
        if (paramInt1 != -1)
        {
          if (paramInt2 != -1) {
            break label43;
          }
          i1 = i2;
        }
      }
    }
    return i1;
    label43:
    float f1 = paramOptions.outWidth * paramOptions.outHeight / (paramInt1 * paramInt2);
    paramInt1 = i3;
    for (;;)
    {
      i1 = paramInt1;
      if (f1 <= 1.0F) {
        break;
      }
      paramInt1 *= 2;
      f1 /= 4.0F;
    }
  }
  
  public static int b(InputStream paramInputStream, int paramInt1, int paramInt2)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeStream(paramInputStream, null, localOptions);
    int i1 = localOptions.outWidth;
    int i2 = localOptions.outHeight;
    paramInt1 = Math.min((int)Math.round(i1 / paramInt1), (int)Math.round(i2 / paramInt2));
    if (paramInt1 < 1) {
      return 1;
    }
    return paramInt1;
  }
  
  public static int b(String paramString)
  {
    int i2 = 0;
    try
    {
      paramString = new ExifInterface(paramString);
      i1 = i2;
      int i3;
      if (paramString != null)
      {
        i3 = paramString.getAttributeInt("Orientation", -1);
        a("getExifOrientation  orientation  =====" + i3 + "=====");
        i1 = i2;
        if (i3 != -1) {
          i1 = i2;
        }
      }
      switch (i3)
      {
      default: 
        i1 = i2;
      case 4: 
      case 5: 
      case 7: 
        a("getExifOrientation degree =======" + i1 + "==========");
        return i1;
      }
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        a("cannot read exif", paramString);
        paramString = null;
        continue;
        int i1 = 90;
        continue;
        i1 = 180;
        continue;
        i1 = 270;
      }
    }
  }
  
  private static long b(InputStream paramInputStream)
  {
    try
    {
      int i1;
      do
      {
        for (;;)
        {
          i1 = paramInputStream.read();
          if (i1 == -1) {
            break label132;
          }
          if (i1 == 255)
          {
            i1 = paramInputStream.read();
            if ((i1 >= 192) && (i1 <= 195))
            {
              paramInputStream.skip(3L);
              i1 = paramInputStream.read();
              int i2 = paramInputStream.read();
              int i3 = paramInputStream.read();
              return (paramInputStream.read() | i3 << 8) * (i1 << 8 | i2);
            }
            if ((i1 == 0) || (i1 == 217) || (i1 == 216)) {
              break;
            }
            paramInputStream.skip((paramInputStream.read() << 8 | paramInputStream.read()) - 2);
          }
        }
      } while (i1 != -1);
    }
    catch (Exception paramInputStream)
    {
      paramInputStream.printStackTrace();
      return -1L;
    }
    label132:
    return -1L;
  }
  
  public static Bitmap b()
  {
    Bitmap localBitmap1 = null;
    if (BaseApplicationImpl.a != null) {
      localBitmap1 = (Bitmap)BaseApplicationImpl.a.get("static://DefaultFace140_140");
    }
    Bitmap localBitmap2 = localBitmap1;
    if (localBitmap1 == null)
    {
      localBitmap1 = BitmapFactory.decodeResource(BaseApplicationImpl.a().getResources(), 2130838056);
      if ((localBitmap1 != null) && (BaseApplicationImpl.a != null)) {
        BaseApplicationImpl.a.put("static://DefaultFace140_140", localBitmap1);
      }
      localBitmap2 = localBitmap1;
      if (QLog.isColorLevel())
      {
        QLog.d(p, 2, "getDefaultFaceBitmap140_140, bitmap=" + localBitmap1);
        localBitmap2 = localBitmap1;
      }
    }
    return localBitmap2;
  }
  
  public static Bitmap b(int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, ArrayList paramArrayList)
  {
    int i2 = paramInt1 * paramInt2;
    int[] arrayOfInt = new int[i2];
    int i1 = 0;
    while (i1 < i2)
    {
      arrayOfInt[i1] = -2631723;
      i1 += 1;
    }
    i1 = (int)(3.0F * paramFloat);
    i2 = (int)(2.0F * paramFloat);
    int i3 = (int)(20.0F * paramFloat);
    return b(paramInt1, paramInt2, paramFloat, arrayOfInt, -2631723, i1, i2, i3, i3, paramInt3, paramInt4, paramArrayList);
  }
  
  private static Bitmap b(int paramInt1, int paramInt2, float paramFloat, int[] paramArrayOfInt, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, ArrayList paramArrayList)
  {
    Bitmap localBitmap2 = null;
    Bitmap localBitmap1 = localBitmap2;
    if (paramArrayList != null)
    {
      localBitmap1 = localBitmap2;
      if (paramArrayList.size() > 0)
      {
        localBitmap2 = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
        localBitmap2.setPixels(paramArrayOfInt, 0, paramInt1, 0, 0, paramInt1, paramInt2);
        paramArrayOfInt = new Canvas(localBitmap2);
        paramArrayList = paramArrayList.iterator();
        paramInt1 = 0;
        for (;;)
        {
          localBitmap1 = localBitmap2;
          if (!paramArrayList.hasNext()) {
            break;
          }
          localBitmap1 = (Bitmap)paramArrayList.next();
          a(localBitmap1, paramArrayOfInt, paramInt1 % 3 * (paramInt6 + paramInt5) + paramInt4, paramInt1 / 3 * (paramInt7 + paramInt5) + paramInt4, localBitmap1.getWidth() / paramInt8, paramInt3);
          paramInt1 += 1;
        }
      }
    }
    return localBitmap1;
  }
  
  public static Bitmap b(Bitmap paramBitmap)
  {
    Bitmap localBitmap = null;
    int i4;
    int i1;
    int i2;
    if (paramBitmap != null)
    {
      i3 = paramBitmap.getWidth();
      i4 = paramBitmap.getHeight();
      if (i3 <= i4) {
        break label63;
      }
      i1 = i4;
      if (i3 <= i4) {
        break label68;
      }
      i2 = (i3 - i4) / 2;
      label40:
      if (i3 <= i4) {
        break label73;
      }
    }
    label63:
    label68:
    label73:
    for (int i3 = 0;; i3 = (i4 - i3) / 2)
    {
      localBitmap = Bitmap.createBitmap(paramBitmap, i2, i3, i1, i1, null, false);
      return localBitmap;
      i1 = i3;
      break;
      i2 = 0;
      break label40;
    }
  }
  
  public static Bitmap b(Bitmap paramBitmap, float paramFloat)
  {
    double d2 = Math.toRadians(paramFloat);
    int i1 = paramBitmap.getWidth();
    int i2 = paramBitmap.getHeight();
    double d1 = Math.abs(Math.cos(d2));
    d2 = Math.abs(Math.sin(d2));
    int i3 = (int)(i2 * d2 + i1 * d1);
    int i4 = (int)(d2 * i1 + d1 * i2);
    float f1 = (i3 - i1) / 2.0F;
    float f2 = (i4 - i2) / 2.0F;
    Bitmap localBitmap = Bitmap.createBitmap(i3, i4, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    localCanvas.rotate(paramFloat, i3 / 2.0F, i4 / 2.0F);
    localCanvas.drawBitmap(paramBitmap, f1, f2, null);
    return localBitmap;
  }
  
  public static Bitmap b(Bitmap paramBitmap, float paramFloat, int paramInt1, int paramInt2)
  {
    if (paramBitmap == null) {
      return null;
    }
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap);
      Paint localPaint = new Paint();
      Rect localRect1 = new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
      Rect localRect2 = new Rect(0, 0, paramInt1, paramInt2);
      RectF localRectF = new RectF(localRect2);
      localPaint.setAntiAlias(true);
      localPaint.setDither(true);
      localPaint.setFilterBitmap(true);
      localCanvas.drawARGB(0, 0, 0, 0);
      localPaint.setColor(-12434878);
      localCanvas.drawRoundRect(localRectF, paramFloat, paramFloat, localPaint);
      localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
      localCanvas.drawBitmap(paramBitmap, localRect1, localRect2, localPaint);
      return localBitmap;
    }
    catch (Throwable paramBitmap)
    {
      paramBitmap.printStackTrace();
    }
    return null;
  }
  
  public static Bitmap b(Bitmap paramBitmap, int paramInt)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    if (paramBitmap == null) {
      return localObject2;
    }
    localObject2 = new Matrix();
    int i1 = paramBitmap.getWidth();
    int i2 = paramBitmap.getHeight();
    float f1 = paramInt / (Math.max(i1, i2) * 1.0F);
    if ((f1 != 1.0F) && (f1 > 0.0F)) {}
    for (;;)
    {
      try
      {
        ((Matrix)localObject2).postScale(f1, f1);
        localObject2 = Bitmap.createBitmap(paramBitmap, 0, 0, i1, i2, (Matrix)localObject2, true);
        localObject1 = localObject2;
      }
      catch (Exception localException)
      {
        a("compress :" + localException.getMessage());
        continue;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        a("compress :  scaleBitmap OOM");
        continue;
      }
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (paramBitmap == null) {
          break;
        }
        localObject2 = localObject1;
        if (paramBitmap.isRecycled()) {
          break;
        }
        localObject2 = localObject1;
        if (paramBitmap.equals(localObject1)) {
          break;
        }
        paramBitmap.recycle();
        return localObject1;
      }
      return paramBitmap;
      localObject1 = null;
    }
  }
  
  /* Error */
  public static Bitmap b(String paramString, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 5
    //   6: aload 5
    //   8: astore 4
    //   10: aload_0
    //   11: ifnull +14 -> 25
    //   14: aload_0
    //   15: invokevirtual 683	java/lang/String:length	()I
    //   18: ifne +10 -> 28
    //   21: aload 5
    //   23: astore 4
    //   25: aload 4
    //   27: areturn
    //   28: new 617	java/io/FileInputStream
    //   31: dup
    //   32: aload_0
    //   33: invokespecial 632	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   36: astore_3
    //   37: aload_3
    //   38: invokevirtual 1429	java/io/FileInputStream:getFD	()Ljava/io/FileDescriptor;
    //   41: astore 4
    //   43: new 105	android/graphics/BitmapFactory$Options
    //   46: dup
    //   47: invokespecial 106	android/graphics/BitmapFactory$Options:<init>	()V
    //   50: astore 7
    //   52: aload 7
    //   54: iconst_1
    //   55: putfield 110	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   58: aload 4
    //   60: aconst_null
    //   61: aload 7
    //   63: invokestatic 1433	android/graphics/BitmapFactory:decodeFileDescriptor	(Ljava/io/FileDescriptor;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   66: pop
    //   67: aload 7
    //   69: aload 7
    //   71: iload_1
    //   72: iload_2
    //   73: invokestatic 1435	com/tencent/mobileqq/utils/ImageUtil:a	(Landroid/graphics/BitmapFactory$Options;II)I
    //   76: putfield 355	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   79: aload 7
    //   81: iconst_0
    //   82: putfield 110	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   85: aload 7
    //   87: getstatic 500	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   90: putfield 623	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   93: aload_0
    //   94: aload 7
    //   96: invokestatic 359	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   99: astore_0
    //   100: aload_0
    //   101: ifnonnull +26 -> 127
    //   104: aload 6
    //   106: astore_0
    //   107: aload_0
    //   108: astore 4
    //   110: aload_3
    //   111: ifnull -86 -> 25
    //   114: aload_3
    //   115: invokevirtual 1436	java/io/FileInputStream:close	()V
    //   118: aload_0
    //   119: areturn
    //   120: astore_3
    //   121: aload_3
    //   122: invokevirtual 782	java/io/IOException:printStackTrace	()V
    //   125: aload_0
    //   126: areturn
    //   127: goto -20 -> 107
    //   130: astore_0
    //   131: aload 5
    //   133: astore 4
    //   135: aload_3
    //   136: ifnull -111 -> 25
    //   139: aload_3
    //   140: invokevirtual 1436	java/io/FileInputStream:close	()V
    //   143: aconst_null
    //   144: areturn
    //   145: astore_0
    //   146: aload_0
    //   147: invokevirtual 782	java/io/IOException:printStackTrace	()V
    //   150: aconst_null
    //   151: areturn
    //   152: astore_0
    //   153: aconst_null
    //   154: astore_0
    //   155: aload 5
    //   157: astore 4
    //   159: aload_0
    //   160: ifnull -135 -> 25
    //   163: aload_0
    //   164: invokevirtual 1436	java/io/FileInputStream:close	()V
    //   167: aconst_null
    //   168: areturn
    //   169: astore_0
    //   170: aload_0
    //   171: invokevirtual 782	java/io/IOException:printStackTrace	()V
    //   174: aconst_null
    //   175: areturn
    //   176: astore_0
    //   177: aconst_null
    //   178: astore_3
    //   179: aload_3
    //   180: ifnull +7 -> 187
    //   183: aload_3
    //   184: invokevirtual 1436	java/io/FileInputStream:close	()V
    //   187: aload_0
    //   188: athrow
    //   189: astore_3
    //   190: aload_3
    //   191: invokevirtual 782	java/io/IOException:printStackTrace	()V
    //   194: goto -7 -> 187
    //   197: astore_0
    //   198: goto -19 -> 179
    //   201: astore_0
    //   202: aload_3
    //   203: astore_0
    //   204: goto -49 -> 155
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	207	0	paramString	String
    //   0	207	1	paramInt1	int
    //   0	207	2	paramInt2	int
    //   36	79	3	localFileInputStream	FileInputStream
    //   120	20	3	localIOException1	IOException
    //   178	6	3	localObject1	Object
    //   189	14	3	localIOException2	IOException
    //   8	150	4	localObject2	Object
    //   4	152	5	localObject3	Object
    //   1	104	6	localObject4	Object
    //   50	45	7	localOptions	BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   114	118	120	java/io/IOException
    //   79	100	130	java/lang/OutOfMemoryError
    //   139	143	145	java/io/IOException
    //   28	37	152	java/lang/Exception
    //   163	167	169	java/io/IOException
    //   28	37	176	finally
    //   183	187	189	java/io/IOException
    //   37	79	197	finally
    //   79	100	197	finally
    //   37	79	201	java/lang/Exception
    //   79	100	201	java/lang/Exception
  }
  
  public static Rect b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, ImageUtil.ScalingLogic paramScalingLogic)
  {
    if (paramScalingLogic == ImageUtil.ScalingLogic.FIT)
    {
      float f1 = paramInt1 / paramInt2;
      if (f1 > paramInt3 / paramInt4) {
        return new Rect(0, 0, paramInt3, (int)(paramInt3 / f1));
      }
      return new Rect(0, 0, (int)(f1 * paramInt4), paramInt4);
    }
    return new Rect(0, 0, paramInt3, paramInt4);
  }
  
  public static Drawable b()
  {
    return new BitmapDrawable(a());
  }
  
  public static String b(Context paramContext, Uri paramUri)
  {
    if (paramUri == null) {
      return "";
    }
    paramContext = c(paramContext, paramUri);
    paramUri = paramContext.substring(paramContext.lastIndexOf("/") + 1);
    return AppConstants.as + "photo/" + paramContext.hashCode() + paramUri;
  }
  
  public static String b(Context paramContext, String paramString)
  {
    Object localObject = AppConstants.as + "thumb2/";
    if (paramString.startsWith((String)localObject)) {}
    do
    {
      return paramString;
      paramContext = paramString.substring(paramString.lastIndexOf("/") + 1);
      paramContext = (String)localObject + paramString.hashCode() + paramContext;
      localObject = new File((String)localObject);
      paramString = paramContext;
    } while (((File)localObject).exists());
    ((File)localObject).mkdirs();
    return paramContext;
  }
  
  public static String b(Context paramContext, String paramString, int paramInt)
  {
    String str = AppConstants.as + "photo/" + String.valueOf(System.currentTimeMillis()) + ".jpg";
    int i2 = 600;
    int i1 = 800;
    try
    {
      a(paramContext, paramString, str, 600, 800);
      int i3 = 0;
      for (;;)
      {
        localObject1 = new File(str);
        if ((localObject1 == null) || (((File)localObject1).length() <= paramInt) || (i3 >= 3)) {
          break;
        }
        i3 += 1;
        i2 -= 100;
        i1 -= 100;
        a(paramContext, paramString, str, Math.max(100, i2), Math.max(100, i1));
      }
      localObject2 = a(paramContext, Uri.parse(paramString));
    }
    catch (Exception paramContext)
    {
      a("compressImageForGroup exception", paramContext);
      return paramString;
    }
    Object localObject1 = a(paramContext, Uri.parse(str));
    Object localObject2 = new File((String)localObject2);
    if (((File)localObject2).exists()) {
      ((File)localObject2).renameTo(new File((String)localObject1));
    } else {
      a(paramContext, str, (String)localObject1, 160, 160);
    }
    return str;
  }
  
  /* Error */
  private static String b(InputStream paramInputStream, BitmapFactory.Options paramOptions, String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: aconst_null
    //   2: aload_1
    //   3: invokestatic 116	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   6: astore_0
    //   7: aload_0
    //   8: ifnonnull +5 -> 13
    //   11: aconst_null
    //   12: areturn
    //   13: aload_2
    //   14: invokestatic 874	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)Ljava/io/File;
    //   17: astore_1
    //   18: new 763	java/io/FileOutputStream
    //   21: dup
    //   22: aload_1
    //   23: invokespecial 764	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   26: astore_1
    //   27: aload_0
    //   28: getstatic 770	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   31: bipush 100
    //   33: iload_3
    //   34: invokestatic 149	java/lang/Math:min	(II)I
    //   37: aload_1
    //   38: invokevirtual 774	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   41: pop
    //   42: aload_2
    //   43: astore_0
    //   44: aload_1
    //   45: ifnull +9 -> 54
    //   48: aload_1
    //   49: invokevirtual 777	java/io/OutputStream:close	()V
    //   52: aload_2
    //   53: astore_0
    //   54: aload_0
    //   55: areturn
    //   56: astore_0
    //   57: aconst_null
    //   58: astore_1
    //   59: aload_1
    //   60: ifnull +49 -> 109
    //   63: aload_1
    //   64: invokevirtual 777	java/io/OutputStream:close	()V
    //   67: aconst_null
    //   68: astore_0
    //   69: goto -15 -> 54
    //   72: astore_0
    //   73: aconst_null
    //   74: astore_0
    //   75: goto -21 -> 54
    //   78: astore_0
    //   79: aconst_null
    //   80: astore_1
    //   81: aload_1
    //   82: ifnull +7 -> 89
    //   85: aload_1
    //   86: invokevirtual 777	java/io/OutputStream:close	()V
    //   89: aload_0
    //   90: athrow
    //   91: astore_0
    //   92: aload_2
    //   93: astore_0
    //   94: goto -40 -> 54
    //   97: astore_1
    //   98: goto -9 -> 89
    //   101: astore_0
    //   102: goto -21 -> 81
    //   105: astore_0
    //   106: goto -47 -> 59
    //   109: aconst_null
    //   110: astore_0
    //   111: goto -57 -> 54
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	114	0	paramInputStream	InputStream
    //   0	114	1	paramOptions	BitmapFactory.Options
    //   0	114	2	paramString	String
    //   0	114	3	paramInt	int
    // Exception table:
    //   from	to	target	type
    //   18	27	56	java/lang/Exception
    //   63	67	72	java/io/IOException
    //   18	27	78	finally
    //   48	52	91	java/io/IOException
    //   85	89	97	java/io/IOException
    //   27	42	101	finally
    //   27	42	105	java/lang/Exception
  }
  
  /* Error */
  private static void b(int paramInt1, Context paramContext, File paramFile1, File paramFile2, ImageInfo paramImageInfo, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: aload 4
    //   2: ldc_w 946
    //   5: new 212	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 213	java/lang/StringBuilder:<init>	()V
    //   12: ldc_w 1461
    //   15: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: iload 7
    //   20: invokevirtual 364	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   23: ldc_w 950
    //   26: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: iload 6
    //   31: invokevirtual 364	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   34: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: invokestatic 953	com/tencent/mobileqq/utils/ImageUtil:a	(Lcom/tencent/mobileqq/activity/photo/ImageInfo;Ljava/lang/String;Ljava/lang/String;)V
    //   40: aload 4
    //   42: iconst_1
    //   43: putfield 1463	com/tencent/mobileqq/activity/photo/ImageInfo:i	Z
    //   46: aload_2
    //   47: invokevirtual 346	java/io/File:getPath	()Ljava/lang/String;
    //   50: invokestatic 1196	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   53: astore 20
    //   55: getstatic 985	com/tencent/common/config/AppSetting:d	I
    //   58: i2l
    //   59: lstore 14
    //   61: aload 4
    //   63: getfield 957	com/tencent/mobileqq/activity/photo/ImageInfo:h	Z
    //   66: ifeq +8 -> 74
    //   69: aload 20
    //   71: ifnonnull +379 -> 450
    //   74: aload 4
    //   76: ldc_w 946
    //   79: ldc_w 1465
    //   82: invokestatic 953	com/tencent/mobileqq/utils/ImageUtil:a	(Lcom/tencent/mobileqq/activity/photo/ImageInfo;Ljava/lang/String;Ljava/lang/String;)V
    //   85: lload 14
    //   87: lstore 16
    //   89: iload 5
    //   91: sipush 1001
    //   94: if_icmpne +52 -> 146
    //   97: lload 14
    //   99: lstore 16
    //   101: aload_1
    //   102: ifnull +44 -> 146
    //   105: lload 14
    //   107: lstore 16
    //   109: aload_1
    //   110: instanceof 373
    //   113: ifeq +33 -> 146
    //   116: lload 14
    //   118: lstore 16
    //   120: aload_1
    //   121: checkcast 373	com/tencent/mobileqq/app/BaseActivity
    //   124: invokevirtual 377	com/tencent/mobileqq/app/BaseActivity:getAppRuntime	()Lmqq/app/AppRuntime;
    //   127: checkcast 379	com/tencent/mobileqq/app/QQAppInterface
    //   130: aload 4
    //   132: getfield 1109	com/tencent/mobileqq/activity/photo/ImageInfo:c	Ljava/lang/String;
    //   135: invokevirtual 1111	com/tencent/mobileqq/app/QQAppInterface:b	(Ljava/lang/String;)Z
    //   138: ifeq +8 -> 146
    //   141: ldc2_w 1010
    //   144: lstore 16
    //   146: iload 5
    //   148: ifne +232 -> 380
    //   151: aload_2
    //   152: invokevirtual 779	java/io/File:length	()J
    //   155: ldc2_w 1010
    //   158: lcmp
    //   159: ifle +221 -> 380
    //   162: iconst_1
    //   163: istore 11
    //   165: iload 5
    //   167: sipush 1001
    //   170: if_icmpne +216 -> 386
    //   173: aload_2
    //   174: invokevirtual 779	java/io/File:length	()J
    //   177: lload 16
    //   179: lcmp
    //   180: ifle +206 -> 386
    //   183: iconst_1
    //   184: istore 12
    //   186: iload 5
    //   188: iconst_1
    //   189: if_icmpeq +11 -> 200
    //   192: iload 5
    //   194: sipush 3000
    //   197: if_icmpne +195 -> 392
    //   200: aload_2
    //   201: invokevirtual 779	java/io/File:length	()J
    //   204: ldc2_w 1010
    //   207: lcmp
    //   208: ifle +184 -> 392
    //   211: iconst_1
    //   212: istore 13
    //   214: iload 11
    //   216: ifne +13 -> 229
    //   219: iload 12
    //   221: ifne +8 -> 229
    //   224: iload 13
    //   226: ifeq +172 -> 398
    //   229: aload 4
    //   231: ldc_w 946
    //   234: new 212	java/lang/StringBuilder
    //   237: dup
    //   238: invokespecial 213	java/lang/StringBuilder:<init>	()V
    //   241: ldc_w 1467
    //   244: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: aload_2
    //   248: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   251: ldc_w 1469
    //   254: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: iload 11
    //   259: invokevirtual 979	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   262: ldc_w 1471
    //   265: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: iload 12
    //   270: invokevirtual 979	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   273: ldc_w 1473
    //   276: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: iload 13
    //   281: invokevirtual 979	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   284: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   287: invokestatic 953	com/tencent/mobileqq/utils/ImageUtil:a	(Lcom/tencent/mobileqq/activity/photo/ImageInfo;Ljava/lang/String;Ljava/lang/String;)V
    //   290: iload_0
    //   291: aload_1
    //   292: aload_2
    //   293: aload_3
    //   294: aload 4
    //   296: iload 5
    //   298: iload 6
    //   300: iload 7
    //   302: iload 8
    //   304: iload 9
    //   306: invokestatic 1323	com/tencent/mobileqq/utils/ImageUtil:a	(ILandroid/content/Context;Ljava/io/File;Ljava/io/File;Lcom/tencent/mobileqq/activity/photo/ImageInfo;IIIZZ)V
    //   309: return
    //   310: astore 18
    //   312: new 212	java/lang/StringBuilder
    //   315: dup
    //   316: invokespecial 213	java/lang/StringBuilder:<init>	()V
    //   319: ldc_w 1475
    //   322: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: aload_2
    //   326: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   329: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   332: invokestatic 367	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   335: aconst_null
    //   336: astore 20
    //   338: aload_1
    //   339: invokestatic 737	com/tencent/mobileqq/utils/NetworkUtil:b	(Landroid/content/Context;)Z
    //   342: ifeq +18 -> 360
    //   345: aload 4
    //   347: iconst_1
    //   348: putfield 395	com/tencent/mobileqq/activity/photo/ImageInfo:g	Z
    //   351: aload 4
    //   353: iconst_0
    //   354: putfield 957	com/tencent/mobileqq/activity/photo/ImageInfo:h	Z
    //   357: goto -302 -> 55
    //   360: iload_0
    //   361: aload_1
    //   362: aload_2
    //   363: aload_3
    //   364: aload 4
    //   366: iload 5
    //   368: iload 6
    //   370: iload 7
    //   372: iload 8
    //   374: iload 9
    //   376: invokestatic 1323	com/tencent/mobileqq/utils/ImageUtil:a	(ILandroid/content/Context;Ljava/io/File;Ljava/io/File;Lcom/tencent/mobileqq/activity/photo/ImageInfo;IIIZZ)V
    //   379: return
    //   380: iconst_0
    //   381: istore 11
    //   383: goto -218 -> 165
    //   386: iconst_0
    //   387: istore 12
    //   389: goto -203 -> 186
    //   392: iconst_0
    //   393: istore 13
    //   395: goto -181 -> 214
    //   398: aload 4
    //   400: iconst_1
    //   401: putfield 393	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_k_of_type_Int	I
    //   404: aload 4
    //   406: iconst_0
    //   407: putfield 957	com/tencent/mobileqq/activity/photo/ImageInfo:h	Z
    //   410: iload 5
    //   412: ifne +9 -> 421
    //   415: aload 4
    //   417: iconst_2
    //   418: putfield 399	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_j_of_type_Int	I
    //   421: aload 4
    //   423: ldc_w 946
    //   426: new 212	java/lang/StringBuilder
    //   429: dup
    //   430: invokespecial 213	java/lang/StringBuilder:<init>	()V
    //   433: ldc_w 1477
    //   436: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   439: aload_2
    //   440: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   443: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   446: invokestatic 953	com/tencent/mobileqq/utils/ImageUtil:a	(Lcom/tencent/mobileqq/activity/photo/ImageInfo;Ljava/lang/String;Ljava/lang/String;)V
    //   449: return
    //   450: aload_1
    //   451: invokestatic 737	com/tencent/mobileqq/utils/NetworkUtil:b	(Landroid/content/Context;)Z
    //   454: ifeq +279 -> 733
    //   457: bipush 80
    //   459: istore 10
    //   461: aconst_null
    //   462: astore 19
    //   464: new 763	java/io/FileOutputStream
    //   467: dup
    //   468: aload_3
    //   469: invokespecial 764	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   472: astore 18
    //   474: aload 18
    //   476: astore 19
    //   478: aload 4
    //   480: aload 20
    //   482: getstatic 770	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   485: iload 10
    //   487: aload 18
    //   489: invokevirtual 774	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   492: putfield 969	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_l_of_type_Boolean	Z
    //   495: aload 18
    //   497: astore 19
    //   499: aload 4
    //   501: iconst_1
    //   502: putfield 971	com/tencent/mobileqq/activity/photo/ImageInfo:o	Z
    //   505: aload 18
    //   507: astore 19
    //   509: aload 4
    //   511: getfield 969	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_l_of_type_Boolean	Z
    //   514: ifeq +603 -> 1117
    //   517: aload 18
    //   519: astore 19
    //   521: aload 18
    //   523: invokestatic 974	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/io/FileOutputStream;)V
    //   526: goto +591 -> 1117
    //   529: lload 14
    //   531: l2i
    //   532: istore 10
    //   534: aload 18
    //   536: astore 19
    //   538: ldc_w 1479
    //   541: invokestatic 367	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   544: aload 18
    //   546: astore 19
    //   548: aload_3
    //   549: invokevirtual 779	java/io/File:length	()J
    //   552: iload 10
    //   554: i2l
    //   555: lcmp
    //   556: ifle +555 -> 1111
    //   559: aload 18
    //   561: astore 19
    //   563: aload_2
    //   564: invokestatic 995	com/tencent/image/GifDrawable:isGifFile	(Ljava/io/File;)Z
    //   567: istore 11
    //   569: iload 11
    //   571: ifne +540 -> 1111
    //   574: iconst_1
    //   575: istore 10
    //   577: aload 18
    //   579: ifnull +8 -> 587
    //   582: aload 18
    //   584: invokevirtual 982	java/io/FileOutputStream:close	()V
    //   587: aload 20
    //   589: ifnull +519 -> 1108
    //   592: aload 20
    //   594: invokevirtual 581	android/graphics/Bitmap:isRecycled	()Z
    //   597: ifne +511 -> 1108
    //   600: aload 20
    //   602: invokevirtual 539	android/graphics/Bitmap:recycle	()V
    //   605: iload 10
    //   607: ifeq -298 -> 309
    //   610: aload_3
    //   611: invokevirtual 612	java/io/File:exists	()Z
    //   614: ifeq +445 -> 1059
    //   617: aload_3
    //   618: invokevirtual 696	java/io/File:delete	()Z
    //   621: ifeq +438 -> 1059
    //   624: aload_3
    //   625: invokevirtual 693	java/io/File:createNewFile	()Z
    //   628: ifeq +431 -> 1059
    //   631: iconst_1
    //   632: istore 11
    //   634: aload 4
    //   636: ldc_w 946
    //   639: new 212	java/lang/StringBuilder
    //   642: dup
    //   643: invokespecial 213	java/lang/StringBuilder:<init>	()V
    //   646: ldc_w 1481
    //   649: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   652: aload_3
    //   653: invokevirtual 779	java/io/File:length	()J
    //   656: invokevirtual 746	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   659: ldc_w 1483
    //   662: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   665: iload 11
    //   667: invokevirtual 979	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   670: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   673: invokestatic 953	com/tencent/mobileqq/utils/ImageUtil:a	(Lcom/tencent/mobileqq/activity/photo/ImageInfo;Ljava/lang/String;Ljava/lang/String;)V
    //   676: iload 11
    //   678: ifeq -369 -> 309
    //   681: aload 4
    //   683: iconst_0
    //   684: putfield 957	com/tencent/mobileqq/activity/photo/ImageInfo:h	Z
    //   687: aload 4
    //   689: iconst_0
    //   690: putfield 971	com/tencent/mobileqq/activity/photo/ImageInfo:o	Z
    //   693: aload 4
    //   695: iconst_0
    //   696: putfield 395	com/tencent/mobileqq/activity/photo/ImageInfo:g	Z
    //   699: iload_0
    //   700: aload_1
    //   701: aload_2
    //   702: aload_3
    //   703: aload 4
    //   705: iload 5
    //   707: iload 6
    //   709: iload 7
    //   711: iload 8
    //   713: iload 9
    //   715: invokestatic 1323	com/tencent/mobileqq/utils/ImageUtil:a	(ILandroid/content/Context;Ljava/io/File;Ljava/io/File;Lcom/tencent/mobileqq/activity/photo/ImageInfo;IIIZZ)V
    //   718: return
    //   719: astore_1
    //   720: ldc_w 1485
    //   723: invokestatic 367	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   726: aload 4
    //   728: iconst_0
    //   729: putfield 971	com/tencent/mobileqq/activity/photo/ImageInfo:o	Z
    //   732: return
    //   733: bipush 70
    //   735: istore 10
    //   737: goto -276 -> 461
    //   740: ldc2_w 1010
    //   743: lstore 14
    //   745: goto -216 -> 529
    //   748: astore 18
    //   750: new 212	java/lang/StringBuilder
    //   753: dup
    //   754: invokespecial 213	java/lang/StringBuilder:<init>	()V
    //   757: ldc_w 1487
    //   760: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   763: aload 18
    //   765: invokevirtual 1014	java/io/IOException:getMessage	()Ljava/lang/String;
    //   768: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   771: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   774: invokestatic 367	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   777: goto -190 -> 587
    //   780: astore 18
    //   782: aconst_null
    //   783: astore 18
    //   785: ldc_w 1489
    //   788: invokestatic 367	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   791: aload 4
    //   793: iconst_0
    //   794: putfield 971	com/tencent/mobileqq/activity/photo/ImageInfo:o	Z
    //   797: aload 4
    //   799: invokestatic 1003	com/tencent/mobileqq/utils/ImageUtil:a	()Z
    //   802: putfield 1005	com/tencent/mobileqq/activity/photo/ImageInfo:m	Z
    //   805: aload 18
    //   807: ifnull +8 -> 815
    //   810: aload 18
    //   812: invokevirtual 982	java/io/FileOutputStream:close	()V
    //   815: aload_3
    //   816: ifnull +8 -> 824
    //   819: aload_3
    //   820: invokevirtual 696	java/io/File:delete	()Z
    //   823: pop
    //   824: aload 20
    //   826: ifnull +276 -> 1102
    //   829: aload 20
    //   831: invokevirtual 581	android/graphics/Bitmap:isRecycled	()Z
    //   834: ifne +268 -> 1102
    //   837: aload 20
    //   839: invokevirtual 539	android/graphics/Bitmap:recycle	()V
    //   842: iconst_0
    //   843: istore 10
    //   845: goto -240 -> 605
    //   848: astore 18
    //   850: new 212	java/lang/StringBuilder
    //   853: dup
    //   854: invokespecial 213	java/lang/StringBuilder:<init>	()V
    //   857: ldc_w 1487
    //   860: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   863: aload 18
    //   865: invokevirtual 1014	java/io/IOException:getMessage	()Ljava/lang/String;
    //   868: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   871: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   874: invokestatic 367	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   877: goto -62 -> 815
    //   880: astore 18
    //   882: aconst_null
    //   883: astore 18
    //   885: aload 18
    //   887: astore 19
    //   889: ldc_w 1491
    //   892: invokestatic 367	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   895: aload 4
    //   897: iconst_1
    //   898: putfield 395	com/tencent/mobileqq/activity/photo/ImageInfo:g	Z
    //   901: aload 4
    //   903: iconst_0
    //   904: putfield 971	com/tencent/mobileqq/activity/photo/ImageInfo:o	Z
    //   907: aload 18
    //   909: ifnull +8 -> 917
    //   912: aload 18
    //   914: invokevirtual 982	java/io/FileOutputStream:close	()V
    //   917: aload_3
    //   918: ifnull +8 -> 926
    //   921: aload_3
    //   922: invokevirtual 696	java/io/File:delete	()Z
    //   925: pop
    //   926: aload 20
    //   928: ifnull +174 -> 1102
    //   931: aload 20
    //   933: invokevirtual 581	android/graphics/Bitmap:isRecycled	()Z
    //   936: ifne +166 -> 1102
    //   939: aload 20
    //   941: invokevirtual 539	android/graphics/Bitmap:recycle	()V
    //   944: iconst_0
    //   945: istore 10
    //   947: goto -342 -> 605
    //   950: astore 18
    //   952: new 212	java/lang/StringBuilder
    //   955: dup
    //   956: invokespecial 213	java/lang/StringBuilder:<init>	()V
    //   959: ldc_w 1487
    //   962: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   965: aload 18
    //   967: invokevirtual 1014	java/io/IOException:getMessage	()Ljava/lang/String;
    //   970: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   973: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   976: invokestatic 367	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   979: goto -62 -> 917
    //   982: astore_1
    //   983: iconst_0
    //   984: istore_0
    //   985: aload 19
    //   987: astore_2
    //   988: aload_2
    //   989: ifnull +7 -> 996
    //   992: aload_2
    //   993: invokevirtual 982	java/io/FileOutputStream:close	()V
    //   996: iload_0
    //   997: ifeq +12 -> 1009
    //   1000: aload_3
    //   1001: ifnull +8 -> 1009
    //   1004: aload_3
    //   1005: invokevirtual 696	java/io/File:delete	()Z
    //   1008: pop
    //   1009: aload 20
    //   1011: ifnull +16 -> 1027
    //   1014: aload 20
    //   1016: invokevirtual 581	android/graphics/Bitmap:isRecycled	()Z
    //   1019: ifne +8 -> 1027
    //   1022: aload 20
    //   1024: invokevirtual 539	android/graphics/Bitmap:recycle	()V
    //   1027: aload_1
    //   1028: athrow
    //   1029: astore_2
    //   1030: new 212	java/lang/StringBuilder
    //   1033: dup
    //   1034: invokespecial 213	java/lang/StringBuilder:<init>	()V
    //   1037: ldc_w 1487
    //   1040: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1043: aload_2
    //   1044: invokevirtual 1014	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1047: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1050: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1053: invokestatic 367	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   1056: goto -60 -> 996
    //   1059: iconst_0
    //   1060: istore 11
    //   1062: goto -428 -> 634
    //   1065: astore_1
    //   1066: aload 19
    //   1068: astore_2
    //   1069: iconst_0
    //   1070: istore_0
    //   1071: goto -83 -> 988
    //   1074: astore_1
    //   1075: aload 18
    //   1077: astore_2
    //   1078: iconst_0
    //   1079: istore_0
    //   1080: goto -92 -> 988
    //   1083: astore_1
    //   1084: aload 18
    //   1086: astore_2
    //   1087: iconst_1
    //   1088: istore_0
    //   1089: goto -101 -> 988
    //   1092: astore 19
    //   1094: goto -209 -> 885
    //   1097: astore 19
    //   1099: goto -314 -> 785
    //   1102: iconst_0
    //   1103: istore 10
    //   1105: goto -500 -> 605
    //   1108: goto -503 -> 605
    //   1111: iconst_0
    //   1112: istore 10
    //   1114: goto -537 -> 577
    //   1117: iload 5
    //   1119: iconst_1
    //   1120: if_icmpeq +19 -> 1139
    //   1123: iload 5
    //   1125: sipush 1001
    //   1128: if_icmpeq +11 -> 1139
    //   1131: iload 5
    //   1133: sipush 3000
    //   1136: if_icmpne -25 -> 1111
    //   1139: iload 5
    //   1141: sipush 1001
    //   1144: if_icmpne -404 -> 740
    //   1147: goto -618 -> 529
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1150	0	paramInt1	int
    //   0	1150	1	paramContext	Context
    //   0	1150	2	paramFile1	File
    //   0	1150	3	paramFile2	File
    //   0	1150	4	paramImageInfo	ImageInfo
    //   0	1150	5	paramInt2	int
    //   0	1150	6	paramInt3	int
    //   0	1150	7	paramInt4	int
    //   0	1150	8	paramBoolean1	boolean
    //   0	1150	9	paramBoolean2	boolean
    //   459	654	10	i1	int
    //   163	898	11	bool1	boolean
    //   184	204	12	bool2	boolean
    //   212	182	13	bool3	boolean
    //   59	685	14	l1	long
    //   87	91	16	l2	long
    //   310	1	18	localOutOfMemoryError1	OutOfMemoryError
    //   472	111	18	localFileOutputStream	FileOutputStream
    //   748	16	18	localIOException1	IOException
    //   780	1	18	localException1	Exception
    //   783	28	18	localObject1	Object
    //   848	16	18	localIOException2	IOException
    //   880	1	18	localOutOfMemoryError2	OutOfMemoryError
    //   883	30	18	localObject2	Object
    //   950	135	18	localIOException3	IOException
    //   462	605	19	localObject3	Object
    //   1092	1	19	localOutOfMemoryError3	OutOfMemoryError
    //   1097	1	19	localException2	Exception
    //   53	970	20	localBitmap	Bitmap
    // Exception table:
    //   from	to	target	type
    //   46	55	310	java/lang/OutOfMemoryError
    //   610	631	719	java/io/IOException
    //   634	676	719	java/io/IOException
    //   681	718	719	java/io/IOException
    //   582	587	748	java/io/IOException
    //   464	474	780	java/lang/Exception
    //   810	815	848	java/io/IOException
    //   464	474	880	java/lang/OutOfMemoryError
    //   912	917	950	java/io/IOException
    //   464	474	982	finally
    //   992	996	1029	java/io/IOException
    //   478	495	1065	finally
    //   499	505	1065	finally
    //   509	517	1065	finally
    //   521	526	1065	finally
    //   538	544	1065	finally
    //   548	559	1065	finally
    //   563	569	1065	finally
    //   889	895	1065	finally
    //   785	805	1074	finally
    //   895	907	1083	finally
    //   478	495	1092	java/lang/OutOfMemoryError
    //   499	505	1092	java/lang/OutOfMemoryError
    //   509	517	1092	java/lang/OutOfMemoryError
    //   521	526	1092	java/lang/OutOfMemoryError
    //   538	544	1092	java/lang/OutOfMemoryError
    //   548	559	1092	java/lang/OutOfMemoryError
    //   563	569	1092	java/lang/OutOfMemoryError
    //   478	495	1097	java/lang/Exception
    //   499	505	1097	java/lang/Exception
    //   509	517	1097	java/lang/Exception
    //   521	526	1097	java/lang/Exception
    //   538	544	1097	java/lang/Exception
    //   548	559	1097	java/lang/Exception
    //   563	569	1097	java/lang/Exception
  }
  
  /* Error */
  public static void b(Bitmap paramBitmap, File paramFile)
  {
    // Byte code:
    //   0: new 343	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokevirtual 1130	java/io/File:getParent	()Ljava/lang/String;
    //   8: invokespecial 677	java/io/File:<init>	(Ljava/lang/String;)V
    //   11: astore_2
    //   12: aload_2
    //   13: invokevirtual 612	java/io/File:exists	()Z
    //   16: ifeq +10 -> 26
    //   19: aload_2
    //   20: invokevirtual 1133	java/io/File:isDirectory	()Z
    //   23: ifne +8 -> 31
    //   26: aload_2
    //   27: invokevirtual 690	java/io/File:mkdirs	()Z
    //   30: pop
    //   31: aload_1
    //   32: invokevirtual 612	java/io/File:exists	()Z
    //   35: ifeq +10 -> 45
    //   38: aload_1
    //   39: invokevirtual 1136	java/io/File:isFile	()Z
    //   42: ifne +8 -> 50
    //   45: aload_1
    //   46: invokevirtual 693	java/io/File:createNewFile	()Z
    //   49: pop
    //   50: aconst_null
    //   51: astore_2
    //   52: new 763	java/io/FileOutputStream
    //   55: dup
    //   56: aload_1
    //   57: invokespecial 764	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   60: astore_1
    //   61: aload_0
    //   62: getstatic 770	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   65: bipush 100
    //   67: aload_1
    //   68: invokevirtual 774	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   71: pop
    //   72: aload_1
    //   73: invokevirtual 1139	java/io/FileOutputStream:flush	()V
    //   76: aload_1
    //   77: ifnull +7 -> 84
    //   80: aload_1
    //   81: invokevirtual 982	java/io/FileOutputStream:close	()V
    //   84: return
    //   85: astore_0
    //   86: aconst_null
    //   87: astore_1
    //   88: aload_1
    //   89: ifnull -5 -> 84
    //   92: aload_1
    //   93: invokevirtual 982	java/io/FileOutputStream:close	()V
    //   96: return
    //   97: astore_0
    //   98: aload_2
    //   99: astore_1
    //   100: aload_1
    //   101: ifnull +7 -> 108
    //   104: aload_1
    //   105: invokevirtual 982	java/io/FileOutputStream:close	()V
    //   108: aload_0
    //   109: athrow
    //   110: astore_0
    //   111: goto -11 -> 100
    //   114: astore_0
    //   115: goto -27 -> 88
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	118	0	paramBitmap	Bitmap
    //   0	118	1	paramFile	File
    //   11	88	2	localFile	File
    // Exception table:
    //   from	to	target	type
    //   52	61	85	java/io/IOException
    //   52	61	97	finally
    //   61	76	110	finally
    //   61	76	114	java/io/IOException
  }
  
  public static boolean b(File paramFile)
  {
    paramFile = a(new FileInputStream(paramFile));
    int i1 = paramFile.outHeight;
    int i2 = paramFile.outWidth;
    return (i1 > i2 * 3) || (i2 > i1 * 3);
  }
  
  public static boolean b(String paramString)
  {
    boolean bool1 = false;
    try
    {
      boolean bool2 = "jpg".equals(a(new FileInputStream(paramString)));
      if (bool2) {
        bool1 = true;
      }
      return bool1;
    }
    catch (Exception paramString)
    {
      a(paramString.toString());
    }
    return false;
  }
  
  public static boolean b(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString1 != null)
    {
      bool1 = bool2;
      if (paramString1.equals(paramString2)) {}
    }
    try
    {
      paramString1 = new ExifInterface(paramString1);
      paramString2 = new ExifInterface(paramString2);
      int i1 = paramString1.getAttributeInt("Orientation", 0);
      paramString2.setAttribute("Orientation", i1 + "");
      paramString2.saveAttributes();
      bool1 = true;
    }
    catch (IOException paramString1)
    {
      do
      {
        bool1 = bool2;
      } while (!QLog.isColorLevel());
      QLog.e(p, 2, "copyExif ", paramString1);
    }
    return bool1;
    return false;
  }
  
  private static int c(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    double d1 = paramOptions.outWidth;
    double d2 = paramOptions.outHeight;
    int i1;
    int i2;
    if (paramInt2 == -1)
    {
      i1 = 1;
      if (paramInt1 != -1) {
        break label60;
      }
      i2 = 128;
      label31:
      if (i2 >= i1) {
        break label84;
      }
    }
    label60:
    label84:
    do
    {
      return i1;
      i1 = (int)Math.ceil(Math.sqrt(d1 * d2 / paramInt2));
      break;
      i2 = (int)Math.min(Math.floor(d1 / paramInt1), Math.floor(d2 / paramInt1));
      break label31;
      if ((paramInt2 == -1) && (paramInt1 == -1)) {
        return 1;
      }
    } while (paramInt1 == -1);
    return i2;
  }
  
  public static int c(String paramString)
  {
    int i1 = 1;
    int i2 = 0;
    for (;;)
    {
      try
      {
        i3 = new ExifInterface(paramString).getAttributeInt("Orientation", 1);
        if (i3 != 6) {
          continue;
        }
      }
      catch (IOException paramString)
      {
        int i3;
        i1 = i2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e(p, 2, "read exif error", paramString);
      }
      return i1;
      if (i3 == 3) {
        i1 = 2;
      } else if (i3 == 8) {
        i1 = 3;
      } else {
        i1 = 0;
      }
    }
    return 0;
  }
  
  public static Bitmap c()
  {
    Bitmap localBitmap1 = null;
    if (BaseApplicationImpl.a != null) {
      localBitmap1 = (Bitmap)BaseApplicationImpl.a.get("static://DefaultTroopFace");
    }
    Bitmap localBitmap2 = localBitmap1;
    if (localBitmap1 == null)
    {
      localBitmap1 = a(BitmapFactory.decodeResource(BaseApplicationImpl.a().getResources(), 2130838119), 50, 50);
      localBitmap2 = localBitmap1;
      if (localBitmap1 != null)
      {
        localBitmap2 = localBitmap1;
        if (BaseApplicationImpl.a != null)
        {
          BaseApplicationImpl.a.put("static://DefaultTroopFace", localBitmap1);
          localBitmap2 = localBitmap1;
        }
      }
    }
    return localBitmap2;
  }
  
  public static Drawable c()
  {
    return new BitmapDrawable(c());
  }
  
  /* Error */
  public static String c(Context paramContext, Uri paramUri)
  {
    // Byte code:
    //   0: ldc_w 704
    //   3: astore 4
    //   5: aload 4
    //   7: astore_3
    //   8: aload_1
    //   9: ifnull +39 -> 48
    //   12: aload 4
    //   14: astore_3
    //   15: ldc_w 704
    //   18: aload_1
    //   19: invokevirtual 1521	android/net/Uri:toString	()Ljava/lang/String;
    //   22: invokevirtual 1494	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   25: ifne +23 -> 48
    //   28: aload_1
    //   29: invokevirtual 1524	android/net/Uri:getScheme	()Ljava/lang/String;
    //   32: astore_3
    //   33: ldc_w 1526
    //   36: aload_3
    //   37: invokevirtual 1494	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   40: ifeq +10 -> 50
    //   43: aload_1
    //   44: invokevirtual 1527	android/net/Uri:getPath	()Ljava/lang/String;
    //   47: astore_3
    //   48: aload_3
    //   49: areturn
    //   50: ldc_w 1529
    //   53: aload_3
    //   54: invokevirtual 1494	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   57: ifeq +117 -> 174
    //   60: aload_0
    //   61: invokevirtual 1533	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   64: aload_1
    //   65: iconst_1
    //   66: anewarray 160	java/lang/String
    //   69: dup
    //   70: iconst_0
    //   71: ldc_w 1535
    //   74: aastore
    //   75: aconst_null
    //   76: aconst_null
    //   77: aconst_null
    //   78: invokevirtual 1541	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   81: astore_0
    //   82: aload_0
    //   83: ldc_w 1535
    //   86: invokeinterface 1546 2 0
    //   91: istore_2
    //   92: aload_0
    //   93: invokeinterface 1549 1 0
    //   98: ifle +34 -> 132
    //   101: aload_0
    //   102: invokeinterface 1552 1 0
    //   107: pop
    //   108: aload_0
    //   109: iload_2
    //   110: invokeinterface 1555 2 0
    //   115: astore_1
    //   116: aload_1
    //   117: astore_3
    //   118: aload_0
    //   119: ifnull +11 -> 130
    //   122: aload_0
    //   123: invokeinterface 1556 1 0
    //   128: aload_1
    //   129: astore_3
    //   130: aload_3
    //   131: areturn
    //   132: ldc_w 704
    //   135: astore_1
    //   136: goto -20 -> 116
    //   139: astore_0
    //   140: aconst_null
    //   141: astore_0
    //   142: aload_0
    //   143: ifnull +44 -> 187
    //   146: aload_0
    //   147: invokeinterface 1556 1 0
    //   152: ldc_w 704
    //   155: astore_3
    //   156: goto -26 -> 130
    //   159: astore_1
    //   160: aconst_null
    //   161: astore_0
    //   162: aload_0
    //   163: ifnull +9 -> 172
    //   166: aload_0
    //   167: invokeinterface 1556 1 0
    //   172: aload_1
    //   173: athrow
    //   174: aload_1
    //   175: invokevirtual 1521	android/net/Uri:toString	()Ljava/lang/String;
    //   178: areturn
    //   179: astore_1
    //   180: goto -18 -> 162
    //   183: astore_1
    //   184: goto -42 -> 142
    //   187: ldc_w 704
    //   190: astore_3
    //   191: goto -61 -> 130
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	194	0	paramContext	Context
    //   0	194	1	paramUri	Uri
    //   91	19	2	i1	int
    //   7	184	3	localObject	Object
    //   3	10	4	str	String
    // Exception table:
    //   from	to	target	type
    //   60	82	139	java/lang/Exception
    //   60	82	159	finally
    //   82	116	179	finally
    //   82	116	183	java/lang/Exception
  }
  
  public static Bitmap d()
  {
    Bitmap localBitmap1 = null;
    if (BaseApplicationImpl.a != null) {
      localBitmap1 = (Bitmap)BaseApplicationImpl.a.get("static://DefaultDiscusionFace");
    }
    Bitmap localBitmap2 = localBitmap1;
    if (localBitmap1 == null)
    {
      localBitmap1 = BitmapFactory.decodeResource(BaseApplicationImpl.a().getResources(), 2130837756);
      localBitmap2 = localBitmap1;
      if (localBitmap1 != null)
      {
        localBitmap2 = localBitmap1;
        if (BaseApplicationImpl.a != null)
        {
          BaseApplicationImpl.a.put("static://DefaultDiscusionFace", localBitmap1);
          localBitmap2 = localBitmap1;
        }
      }
    }
    return localBitmap2;
  }
  
  public static Drawable d()
  {
    return new BitmapDrawable(d());
  }
  
  public static Bitmap e()
  {
    Bitmap localBitmap1 = null;
    if (BaseApplicationImpl.a != null) {
      localBitmap1 = (Bitmap)BaseApplicationImpl.a.get("static://DefaultSystemIcon");
    }
    Bitmap localBitmap2 = localBitmap1;
    if (localBitmap1 == null)
    {
      localBitmap1 = BitmapFactory.decodeResource(BaseApplicationImpl.a().getResources(), 2130839440);
      localBitmap2 = localBitmap1;
      if (localBitmap1 != null)
      {
        localBitmap2 = localBitmap1;
        if (BaseApplicationImpl.a != null)
        {
          BaseApplicationImpl.a.put("static://DefaultSystemIcon", localBitmap1, (byte)0);
          localBitmap2 = localBitmap1;
        }
      }
    }
    return localBitmap2;
  }
  
  public static Drawable e()
  {
    return new BitmapDrawable(f());
  }
  
  public static Bitmap f()
  {
    Bitmap localBitmap1 = null;
    if (BaseApplicationImpl.a != null) {
      localBitmap1 = (Bitmap)BaseApplicationImpl.a.get("static://DefaultDataLineFace");
    }
    Bitmap localBitmap2 = localBitmap1;
    if (localBitmap1 == null)
    {
      localBitmap1 = BitmapFactory.decodeResource(BaseApplicationImpl.a().getResources(), 2130838529);
      localBitmap2 = localBitmap1;
      if (localBitmap1 != null)
      {
        localBitmap2 = localBitmap1;
        if (BaseApplicationImpl.a != null)
        {
          BaseApplicationImpl.a.put("static://DefaultDataLineFace", localBitmap1, (byte)0);
          localBitmap2 = localBitmap1;
        }
      }
    }
    return localBitmap2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.ImageUtil
 * JD-Core Version:    0.7.0.1
 */