package com.tencent.mobileqq.data;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;

public class MessageForQQWalletTips$CenterImageSpan
  extends ImageSpan
{
  public MessageForQQWalletTips$CenterImageSpan(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public MessageForQQWalletTips$CenterImageSpan(Context paramContext, Bitmap paramBitmap)
  {
    super(paramContext, paramBitmap);
  }
  
  public void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
    paramCharSequence = getDrawable();
    paramCanvas.save();
    paramCanvas.translate(paramFloat, (paramInt5 - paramInt3 - paramCharSequence.getBounds().bottom) / 2 + paramInt3);
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
    return paramCharSequence.right;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForQQWalletTips.CenterImageSpan
 * JD-Core Version:    0.7.0.1
 */