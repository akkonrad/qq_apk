package com.tencent.mobileqq.tribe.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;

public class TEditText
  extends EditText
{
  private TEditText.OnSelectionChangedListener a;
  
  public TEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onSelectionChanged(int paramInt1, int paramInt2)
  {
    super.onSelectionChanged(paramInt1, paramInt2);
    if (this.a != null) {
      this.a.a(paramInt1, paramInt2);
    }
  }
  
  public void setOnSelectionChangedListener(TEditText.OnSelectionChangedListener paramOnSelectionChangedListener)
  {
    this.a = paramOnSelectionChangedListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.tribe.view.TEditText
 * JD-Core Version:    0.7.0.1
 */