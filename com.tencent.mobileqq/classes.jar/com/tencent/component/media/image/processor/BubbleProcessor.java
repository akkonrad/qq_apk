package com.tencent.component.media.image.processor;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.tencent.component.media.ImageManagerEnv;
import com.tencent.component.media.image.BitmapReference;
import com.tencent.component.media.image.ImageManager;
import com.tencent.component.media.image.ImageProcessor;
import com.tencent.component.media.image.drawable.BitmapRefDrawable;

public class BubbleProcessor
  extends ImageProcessor
{
  private Bitmap a;
  
  public BubbleProcessor(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      throw new IllegalArgumentException("mask bitmap can not be null for BubbleProcessor");
    }
    this.a = paramBitmap;
  }
  
  public int getType()
  {
    return 6;
  }
  
  public Drawable process(Drawable paramDrawable)
  {
    BitmapReference localBitmapReference = ImageManagerEnv.g().drawableToBitmap(paramDrawable);
    if ((localBitmapReference == null) || (this.a == null)) {
      return paramDrawable;
    }
    try
    {
      localBitmapReference = BitmapReference.getBitmapReference(Bitmap.createScaledBitmap(localBitmapReference.getBitmap(), this.a.getWidth(), this.a.getHeight(), true));
      try
      {
        paramDrawable = ImageManager.getInstance().getBitmap(localBitmapReference.getWidth(), localBitmapReference.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas localCanvas = new Canvas(paramDrawable.getBitmap());
        RectF localRectF = new RectF(0.0F, 0.0F, localBitmapReference.getWidth(), localBitmapReference.getHeight());
        Paint localPaint = new Paint();
        localPaint.setAntiAlias(true);
        localCanvas.drawBitmap(this.a, null, localRectF, localPaint);
        localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        localCanvas.drawBitmap(localBitmapReference.getBitmap(), null, localRectF, localPaint);
        return new BitmapRefDrawable(paramDrawable);
      }
      catch (OutOfMemoryError paramDrawable)
      {
        for (;;)
        {
          paramDrawable = BitmapReference.getBitmapReference(Bitmap.createBitmap(localBitmapReference.getWidth(), localBitmapReference.getHeight(), Bitmap.Config.ARGB_4444));
        }
      }
      return paramDrawable;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.image.processor.BubbleProcessor
 * JD-Core Version:    0.7.0.1
 */