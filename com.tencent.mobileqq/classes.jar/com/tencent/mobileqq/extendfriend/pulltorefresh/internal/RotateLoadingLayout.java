package com.tencent.mobileqq.extendfriend.pulltorefresh.internal;

import acjs;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mobileqq.extendfriend.pulltorefresh.PullToRefreshBase.Mode;
import com.tencent.mobileqq.extendfriend.pulltorefresh.PullToRefreshBase.Orientation;

public class RotateLoadingLayout
  extends acjs
{
  private float jdField_a_of_type_Float;
  private final Matrix jdField_a_of_type_AndroidGraphicsMatrix;
  private final Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private final boolean jdField_a_of_type_Boolean;
  private float b;
  
  public RotateLoadingLayout(Context paramContext, PullToRefreshBase.Mode paramMode, PullToRefreshBase.Orientation paramOrientation, TypedArray paramTypedArray)
  {
    super(paramContext, paramMode, paramOrientation, paramTypedArray);
    this.jdField_a_of_type_Boolean = paramTypedArray.getBoolean(16, true);
    this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.MATRIX);
    this.jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
    this.jdField_a_of_type_AndroidWidgetImageView.setImageMatrix(this.jdField_a_of_type_AndroidGraphicsMatrix);
    this.jdField_a_of_type_AndroidViewAnimationAnimation = new RotateAnimation(0.0F, 720.0F, 1, 0.5F, 1, 0.5F);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setInterpolator(jdField_a_of_type_AndroidViewAnimationInterpolator);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setDuration(1200L);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setRepeatCount(-1);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setRepeatMode(1);
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_AndroidGraphicsMatrix != null)
    {
      this.jdField_a_of_type_AndroidGraphicsMatrix.reset();
      this.jdField_a_of_type_AndroidWidgetImageView.setImageMatrix(this.jdField_a_of_type_AndroidGraphicsMatrix);
    }
  }
  
  public void a(Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      this.jdField_a_of_type_Float = Math.round(paramDrawable.getIntrinsicWidth() / 2.0F);
      this.b = Math.round(paramDrawable.getIntrinsicHeight() / 2.0F);
    }
  }
  
  protected int b()
  {
    return 2130839639;
  }
  
  protected void b(float paramFloat)
  {
    if (this.jdField_a_of_type_Boolean) {}
    for (paramFloat = 90.0F * paramFloat;; paramFloat = Math.max(0.0F, Math.min(180.0F, 360.0F * paramFloat - 180.0F)))
    {
      this.jdField_a_of_type_AndroidGraphicsMatrix.setRotate(paramFloat, this.jdField_a_of_type_Float, this.b);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageMatrix(this.jdField_a_of_type_AndroidGraphicsMatrix);
      return;
    }
  }
  
  protected void e() {}
  
  protected void f()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
  }
  
  protected void g() {}
  
  protected void h()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
    j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.pulltorefresh.internal.RotateLoadingLayout
 * JD-Core Version:    0.7.0.1
 */