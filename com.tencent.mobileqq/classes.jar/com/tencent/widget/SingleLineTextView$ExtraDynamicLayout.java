package com.tencent.widget;

import android.text.DynamicLayout;
import android.text.Layout.Alignment;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;

public class SingleLineTextView$ExtraDynamicLayout
  extends DynamicLayout
{
  public SingleLineTextView$ExtraDynamicLayout(CharSequence paramCharSequence1, CharSequence paramCharSequence2, TextPaint paramTextPaint, int paramInt1, Layout.Alignment paramAlignment, float paramFloat1, float paramFloat2, boolean paramBoolean, TextUtils.TruncateAt paramTruncateAt, int paramInt2)
  {
    super(paramCharSequence1, paramCharSequence2, paramTextPaint, paramInt1, paramAlignment, paramFloat1, paramFloat2, paramBoolean, paramTruncateAt, paramInt2);
  }
  
  public int getParagraphDirection(int paramInt)
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.widget.SingleLineTextView.ExtraDynamicLayout
 * JD-Core Version:    0.7.0.1
 */