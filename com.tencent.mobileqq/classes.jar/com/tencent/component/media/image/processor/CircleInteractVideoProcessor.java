package com.tencent.component.media.image.processor;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import com.tencent.component.media.ImageManagerEnv;
import com.tencent.component.media.image.BitmapReference;
import com.tencent.component.media.image.ImageManager;
import com.tencent.component.media.image.ImageProcessor;
import com.tencent.component.media.image.drawable.BitmapRefDrawable;

public class CircleInteractVideoProcessor
  extends ImageProcessor
{
  public int mColor = -1;
  public int mRingWidth = 0;
  
  public CircleInteractVideoProcessor() {}
  
  public CircleInteractVideoProcessor(int paramInt1, int paramInt2)
  {
    this.mColor = paramInt2;
    this.mRingWidth = paramInt1;
  }
  
  public int getType()
  {
    return 8;
  }
  
  public Drawable process(Drawable paramDrawable)
  {
    Object localObject = ImageManagerEnv.g().drawableToBitmap(paramDrawable);
    if (localObject == null) {
      return paramDrawable;
    }
    int i = Math.max(((BitmapReference)localObject).getWidth(), ((BitmapReference)localObject).getHeight());
    try
    {
      paramDrawable = ImageManager.getInstance().getBitmap(i, i, Bitmap.Config.ARGB_8888);
      if (Build.VERSION.SDK_INT >= 12) {
        paramDrawable.getBitmap().setHasAlpha(true);
      }
      Canvas localCanvas = new Canvas(paramDrawable.getBitmap());
      RectF localRectF = new RectF(0.0F, 0.0F, i, i);
      Path localPath = new Path();
      Paint localPaint = new Paint();
      int j = Math.min(localCanvas.getWidth(), localCanvas.getHeight());
      localPath.addCircle(localCanvas.getWidth() / 2, localCanvas.getHeight() / 2, j / 2, Path.Direction.CW);
      localPaint.setAntiAlias(true);
      localCanvas.drawPath(localPath, localPaint);
      localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
      localCanvas.drawBitmap(((BitmapReference)localObject).getBitmap(), null, localRectF, localPaint);
      ((BitmapReference)localObject).release();
      if (this.mRingWidth > 0.0F)
      {
        localObject = new Paint();
        ((Paint)localObject).setAntiAlias(true);
        ((Paint)localObject).setColor(this.mColor);
        ((Paint)localObject).setStrokeWidth(this.mRingWidth);
        ((Paint)localObject).setStyle(Paint.Style.STROKE);
        localCanvas.drawOval(new RectF(this.mRingWidth, this.mRingWidth, i - this.mRingWidth, i - this.mRingWidth), (Paint)localObject);
      }
      return new BitmapRefDrawable(paramDrawable);
    }
    catch (OutOfMemoryError paramDrawable)
    {
      for (;;)
      {
        paramDrawable = BitmapReference.getBitmapReference(Bitmap.createBitmap(i, i, Bitmap.Config.ARGB_4444));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.image.processor.CircleInteractVideoProcessor
 * JD-Core Version:    0.7.0.1
 */