package com.tencent.mobileqq.urldrawable;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.tencent.image.DownloadParams;
import com.tencent.image.DownloadParams.DecodeHandler;
import com.tencent.mobileqq.utils.StackBlur;

public class URLDrawableDecodeHandler$FastBlurDecoder
  implements DownloadParams.DecodeHandler
{
  private int a;
  
  public URLDrawableDecodeHandler$FastBlurDecoder(int paramInt)
  {
    this.a = paramInt;
  }
  
  public Bitmap run(DownloadParams paramDownloadParams, Bitmap paramBitmap)
  {
    int k = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    int m = paramDownloadParams.reqHeight;
    int i = k * m / j;
    if (m >= j) {
      i = k;
    }
    for (;;)
    {
      try
      {
        paramDownloadParams = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_4444);
        new Canvas(paramDownloadParams).drawBitmap(paramBitmap, null, new Rect(0, 0, i, j), new Paint(7));
        StackBlur.a(paramDownloadParams, this.a);
        return paramDownloadParams;
      }
      catch (OutOfMemoryError paramDownloadParams)
      {
        return paramBitmap;
      }
      catch (Exception paramDownloadParams)
      {
        return paramBitmap;
      }
      j = m;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler.FastBlurDecoder
 * JD-Core Version:    0.7.0.1
 */