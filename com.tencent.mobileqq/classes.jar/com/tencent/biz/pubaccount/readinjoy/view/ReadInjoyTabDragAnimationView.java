package com.tencent.biz.pubaccount.readinjoy.view;

import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import com.tencent.mobileqq.widget.TabDragAnimationView;
import com.tencent.qphone.base.util.QLog;
import mjq;
import mjr;
import mjs;

public class ReadInjoyTabDragAnimationView
  extends TabDragAnimationView
{
  private AnimatorSet jdField_a_of_type_AndroidAnimationAnimatorSet;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private boolean d;
  private int g = 0;
  private int h;
  private int i;
  
  public ReadInjoyTabDragAnimationView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ReadInjoyTabDragAnimationView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ReadInjoyTabDragAnimationView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private mjs a()
  {
    mjs localmjs = new mjs(null);
    int n = getPaddingLeft();
    int m = getRight() - getLeft() - getPaddingRight();
    int k = getPaddingTop();
    int j = getBottom() - getTop() - getPaddingBottom();
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      m = (m + n) / 2;
      j = (j + k) / 2;
      n = m - this.jdField_b_of_type_Int / 2;
      m += this.jdField_b_of_type_Int / 2;
      k = j - this.c / 2;
      j += this.c / 2;
    }
    for (;;)
    {
      localmjs.jdField_a_of_type_Int = n;
      localmjs.c = k;
      localmjs.jdField_b_of_type_Int = m;
      localmjs.d = j;
      return localmjs;
      j = (n + m) / 2;
      n = j - this.jdField_b_of_type_Int / 2;
      m = this.jdField_b_of_type_Int / 2 + j;
      j = this.c + k;
      continue;
      k = (n + m) / 2;
      n = k - this.jdField_b_of_type_Int / 2;
      m = this.jdField_b_of_type_Int / 2 + k;
      k = j - this.c;
      continue;
      j = (j + k) / 2;
      m = n + this.jdField_b_of_type_Int;
      k = j - this.c / 2;
      j += this.c / 2;
      continue;
      j = (j + k) / 2;
      n = m - this.jdField_b_of_type_Int / 2;
      k = j - this.c / 2;
      j += this.c / 2;
    }
  }
  
  private boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public int a()
  {
    return this.g;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getContext().getResources().getDrawable(2130845418);
  }
  
  public void a(int paramInt)
  {
    QLog.d("ReadInjoyTabDragAnimationView", 4, "changeStyle  : " + paramInt);
    this.g = paramInt;
    if (this.jdField_a_of_type_AndroidAnimationAnimatorSet != null)
    {
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.cancel();
      this.jdField_a_of_type_AndroidAnimationAnimatorSet = null;
    }
    com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils.f = this.g;
    invalidate();
  }
  
  public void a(boolean paramBoolean)
  {
    if ((!a()) || (!this.d) || (this.g != 1)) {
      return;
    }
    if (!paramBoolean)
    {
      setPivotX(this.h);
      setPivotY(this.i);
      localObjectAnimator1 = ObjectAnimator.ofFloat(this, "scaleX", new float[] { 1.0F, 0.8F, 1.0F }).setDuration(150L);
      localObjectAnimator2 = ObjectAnimator.ofFloat(this, "scaleY", new float[] { 1.0F, 0.8F, 1.0F }).setDuration(150L);
      ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(this, "rotation", new float[] { 0.0F, 720.0F }).setDuration(800L);
      ObjectAnimator localObjectAnimator4 = ObjectAnimator.ofFloat(this, "alpha", new float[] { 1.0F, 0.0F }).setDuration(200L);
      localObjectAnimator4.setStartDelay(700L);
      this.jdField_a_of_type_AndroidAnimationAnimatorSet = new AnimatorSet();
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.setInterpolator(new LinearInterpolator());
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.play(localObjectAnimator1).with(localObjectAnimator2);
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.play(localObjectAnimator2).before(localObjectAnimator3);
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.play(localObjectAnimator3).with(localObjectAnimator4);
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.addListener(new mjq(this));
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.start();
      return;
    }
    setPivotX(this.h);
    setPivotY(this.i);
    setVisibility(0);
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this, "alpha", new float[] { 0.0F, 1.0F }).setDuration(500L);
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this, "rotation", new float[] { -30.0F, 0.0F }).setDuration(500L);
    this.jdField_a_of_type_AndroidAnimationAnimatorSet = new AnimatorSet();
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.play(localObjectAnimator2).with(localObjectAnimator1);
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.addListener(new mjr(this));
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.start();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    mjs localmjs;
    if ((a()) && (this.d) && (this.g == 1))
    {
      localmjs = a();
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
      {
        this.h = ((localmjs.jdField_a_of_type_Int + localmjs.jdField_b_of_type_Int) / 2);
        this.i = ((localmjs.c + localmjs.d) / 2);
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(localmjs.jdField_a_of_type_Int, localmjs.c, localmjs.jdField_b_of_type_Int, localmjs.d);
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
      }
      return;
    }
    if (this.h == 0)
    {
      localmjs = a();
      this.h = ((localmjs.jdField_a_of_type_Int + localmjs.jdField_b_of_type_Int) / 2);
      int j = localmjs.c;
      this.i = ((localmjs.d + j) / 2);
    }
    super.onDraw(paramCanvas);
  }
  
  public void setIsSelect(boolean paramBoolean)
  {
    QLog.d("ReadInjoyTabDragAnimationView", 4, "setIsSelect  : " + paramBoolean);
    this.d = paramBoolean;
    if (this.jdField_a_of_type_AndroidAnimationAnimatorSet != null)
    {
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.cancel();
      this.jdField_a_of_type_AndroidAnimationAnimatorSet = null;
    }
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInjoyTabDragAnimationView
 * JD-Core Version:    0.7.0.1
 */