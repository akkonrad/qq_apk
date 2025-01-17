package com.tencent.mobileqq.extendfriend.pulltorefresh;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public abstract class LoadingLayoutBase
  extends FrameLayout
  implements ILoadingLayout
{
  public LoadingLayoutBase(Context paramContext)
  {
    super(paramContext);
  }
  
  public LoadingLayoutBase(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public LoadingLayoutBase(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public abstract int a();
  
  public abstract void a();
  
  public abstract void a(float paramFloat);
  
  public abstract void b();
  
  public abstract void c();
  
  public abstract void d();
  
  public final void setHeight(int paramInt)
  {
    getLayoutParams().height = paramInt;
    requestLayout();
  }
  
  public void setLastUpdatedLabel(CharSequence paramCharSequence) {}
  
  public void setLoadingDrawable(Drawable paramDrawable) {}
  
  public void setRefreshResultLabel(CharSequence paramCharSequence) {}
  
  public void setTextTypeface(Typeface paramTypeface) {}
  
  public final void setWidth(int paramInt)
  {
    getLayoutParams().width = paramInt;
    requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.pulltorefresh.LoadingLayoutBase
 * JD-Core Version:    0.7.0.1
 */