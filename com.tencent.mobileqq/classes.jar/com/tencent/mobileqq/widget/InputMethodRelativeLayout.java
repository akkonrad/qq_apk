package com.tencent.mobileqq.widget;

import akuq;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.RelativeLayout;

public class InputMethodRelativeLayout
  extends RelativeLayout
{
  private int jdField_a_of_type_Int;
  private ViewTreeObserver.OnGlobalLayoutListener jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new akuq(this);
  public InputMethodRelativeLayout.onSizeChangedListenner a;
  private boolean jdField_a_of_type_Boolean;
  
  public InputMethodRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    getViewTreeObserver().addOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
  }
  
  public InputMethodRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    getViewTreeObserver().addOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
  }
  
  private int a()
  {
    Rect localRect = new Rect();
    getWindowVisibleDisplayFrame(localRect);
    return localRect.bottom - localRect.top;
  }
  
  public void setOnSizeChangedListenner(InputMethodRelativeLayout.onSizeChangedListenner paramonSizeChangedListenner)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodRelativeLayout$onSizeChangedListenner = paramonSizeChangedListenner;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.widget.InputMethodRelativeLayout
 * JD-Core Version:    0.7.0.1
 */