package com.tencent.component.media.image.processor;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.tencent.component.media.gif.NewGifDrawable;

public class NewGifDrawableSpecifiedRegionProcessor
  extends SpecifiedSizeCropByPivotProcessor
{
  private final Rect a = new Rect();
  public int height;
  public int width;
  
  public NewGifDrawableSpecifiedRegionProcessor(int paramInt1, int paramInt2, Rect paramRect)
  {
    super(paramInt1, paramInt2);
    this.width = paramInt1;
    this.height = paramInt2;
    if (paramRect != null) {
      this.a.set(paramRect);
    }
  }
  
  public Drawable process(Drawable paramDrawable)
  {
    Drawable localDrawable;
    if (!(paramDrawable instanceof NewGifDrawable)) {
      localDrawable = super.process(paramDrawable);
    }
    int i;
    int k;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return localDrawable;
              i = paramDrawable.getIntrinsicWidth();
              j = paramDrawable.getIntrinsicHeight();
              localDrawable = paramDrawable;
            } while (i == 0);
            localDrawable = paramDrawable;
          } while (j == 0);
          paramDrawable = (NewGifDrawable)paramDrawable;
          if (i <= j) {
            break;
          }
          k = this.a.left + this.a.right;
          localDrawable = paramDrawable;
        } while (k <= 0);
        i = (i - j) * this.a.left / k;
        paramDrawable.setSrcRect(new Rect(i, 0, i + j, j));
        paramDrawable.setIntrinsicWidth(j);
        paramDrawable.setIntrinsicHeight(j);
        return paramDrawable;
        localDrawable = paramDrawable;
      } while (i >= j);
      k = this.a.top + this.a.bottom;
      localDrawable = paramDrawable;
    } while (k <= 0);
    int j = (j - i) * this.a.top / k;
    paramDrawable.setSrcRect(new Rect(0, j, i, j + i));
    paramDrawable.setIntrinsicWidth(i);
    paramDrawable.setIntrinsicHeight(i);
    return paramDrawable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.image.processor.NewGifDrawableSpecifiedRegionProcessor
 * JD-Core Version:    0.7.0.1
 */