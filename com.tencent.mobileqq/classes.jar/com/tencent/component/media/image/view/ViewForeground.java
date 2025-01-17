package com.tencent.component.media.image.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;

public class ViewForeground
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private View jdField_a_of_type_AndroidViewView;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean = true;
  
  public ViewForeground(View paramView)
  {
    this.jdField_a_of_type_AndroidContentContext = paramView.getContext();
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public ViewForeground(View paramView, int paramInt)
  {
    this(paramView);
    setDrawable(paramInt);
  }
  
  public ViewForeground(View paramView, Drawable paramDrawable)
  {
    this(paramView);
    setDrawable(paramDrawable);
  }
  
  private void a(Drawable paramDrawable)
  {
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setCallback(null);
      localView.unscheduleDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    }
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    if (paramDrawable != null)
    {
      paramDrawable.setCallback(localView);
      if (paramDrawable.isStateful()) {
        paramDrawable.setState(localView.getDrawableState());
      }
      this.jdField_a_of_type_Int = paramDrawable.getIntrinsicWidth();
      this.jdField_b_of_type_Int = paramDrawable.getIntrinsicHeight();
      return;
    }
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_Int = -1;
  }
  
  public void boundsChanged()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void draw(Canvas paramCanvas)
  {
    int j = 0;
    Drawable localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    int k;
    int i;
    int m;
    if (localDrawable != null)
    {
      View localView = this.jdField_a_of_type_AndroidViewView;
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = false;
        k = localView.getWidth();
        i = localView.getHeight();
        if (!this.jdField_b_of_type_Boolean) {
          break label100;
        }
        m = localView.getPaddingLeft();
        k -= localView.getPaddingRight();
        j = localView.getPaddingTop();
        i -= localView.getPaddingBottom();
      }
    }
    for (;;)
    {
      localDrawable.setBounds(m, j, k, i);
      localDrawable.draw(paramCanvas);
      return;
      label100:
      m = 0;
    }
  }
  
  public void drawableStateChanged()
  {
    if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.isStateful())) {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setState(this.jdField_a_of_type_AndroidViewView.getDrawableState());
    }
  }
  
  public Drawable getDrawable()
  {
    return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  public void setDrawable(int paramInt)
  {
    setDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(paramInt));
  }
  
  public void setDrawable(Drawable paramDrawable)
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != paramDrawable)
    {
      View localView = this.jdField_a_of_type_AndroidViewView;
      int i = this.jdField_a_of_type_Int;
      int j = this.jdField_b_of_type_Int;
      a(paramDrawable);
      if ((i != this.jdField_a_of_type_Int) || (j != this.jdField_b_of_type_Int)) {
        localView.requestLayout();
      }
      localView.invalidate();
    }
  }
  
  public void setForegroundInPadding(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_Boolean != paramBoolean)
    {
      this.jdField_b_of_type_Boolean = paramBoolean;
      boundsChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.image.view.ViewForeground
 * JD-Core Version:    0.7.0.1
 */