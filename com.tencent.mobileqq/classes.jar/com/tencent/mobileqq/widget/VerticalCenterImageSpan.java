package com.tencent.mobileqq.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;

public class VerticalCenterImageSpan
  extends ImageSpan
{
  private int a;
  private int b;
  
  public VerticalCenterImageSpan(Drawable paramDrawable, int paramInt)
  {
    super(paramDrawable, paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
  }
  
  public void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
    paramCharSequence = getDrawable();
    paramCanvas.save();
    paramInt1 = (paramInt5 - paramInt3 - paramCharSequence.getBounds().bottom) / 2;
    paramCanvas.translate(this.a + paramFloat - this.b, paramInt1 + paramInt3);
    paramCharSequence.draw(paramCanvas);
    paramCanvas.restore();
  }
  
  public int getSize(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, Paint.FontMetricsInt paramFontMetricsInt)
  {
    paramCharSequence = getDrawable().getBounds();
    if (paramFontMetricsInt != null)
    {
      paramPaint = paramPaint.getFontMetricsInt();
      paramInt2 = paramPaint.bottom - paramPaint.top;
      int i = paramCharSequence.bottom - paramCharSequence.top;
      paramInt1 = i / 2 - paramInt2 / 4;
      i /= 2;
      paramInt2 = paramInt2 / 4 + i;
      paramFontMetricsInt.ascent = (-paramInt2);
      paramFontMetricsInt.top = (-paramInt2);
      paramFontMetricsInt.bottom = paramInt1;
      paramFontMetricsInt.descent = paramInt1;
    }
    return paramCharSequence.right + this.a + this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.widget.VerticalCenterImageSpan
 * JD-Core Version:    0.7.0.1
 */