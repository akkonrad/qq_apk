package com.tencent.mobileqq.ocr.view;

import agdm;
import agdn;
import agdo;
import agdp;
import agdq;
import agdr;
import agds;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ScanOcrView
  extends View
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  public agds a;
  AnimatorSet jdField_a_of_type_AndroidAnimationAnimatorSet;
  Context jdField_a_of_type_AndroidContentContext;
  Paint jdField_a_of_type_AndroidGraphicsPaint;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  Handler jdField_a_of_type_AndroidOsHandler = new agdm(this);
  public boolean a;
  int jdField_b_of_type_Int;
  agds jdField_b_of_type_Agds;
  AnimatorSet jdField_b_of_type_AndroidAnimationAnimatorSet;
  Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  public boolean b;
  int jdField_c_of_type_Int;
  agds jdField_c_of_type_Agds;
  Drawable jdField_c_of_type_AndroidGraphicsDrawableDrawable;
  boolean jdField_c_of_type_Boolean = false;
  int d;
  int e;
  int f;
  int g;
  int h;
  int i;
  int j;
  int k;
  int l;
  int m;
  int n;
  int o = 1;
  
  public ScanOcrView(Context paramContext)
  {
    super(paramContext);
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    f();
  }
  
  public ScanOcrView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    f();
  }
  
  public static final int a(float paramFloat, Resources paramResources)
  {
    if (paramFloat == 0.0F) {
      return 0;
    }
    return (int)(paramResources.getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  private agds a()
  {
    int i1 = a(200.0F, getResources());
    int i2 = a(200.0F, getResources());
    int i4 = this.h;
    int i3 = this.j;
    i4 /= 2;
    i3 /= 2;
    Rect localRect = new Rect();
    localRect.left = (i4 - i1 / 2);
    localRect.top = (i3 - i2 / 2);
    localRect.right = (localRect.left + i1);
    localRect.bottom = (localRect.top + i2);
    agds localagds = new agds();
    localagds.jdField_b_of_type_AndroidGraphicsRect = localRect;
    localagds.jdField_a_of_type_Int = i1;
    localagds.jdField_b_of_type_Int = i2;
    localagds.jdField_c_of_type_AndroidGraphicsRect = new Rect(localRect);
    localagds.e = 0;
    if (QLog.isColorLevel()) {
      QLog.i("ScanOcrView", 2, "generateScanRectHoldAniParam, \n" + localagds);
    }
    return localagds;
  }
  
  private agds a(int paramInt, agds paramagds)
  {
    int i1 = a(200.0F, getResources());
    int i2 = a(100.0F, getResources());
    Object localObject1 = new Random();
    int i3 = i2 + ((Random)localObject1).nextInt(i1) % (i1 - i2 + 1);
    int i4 = this.h;
    int i5 = this.j;
    int i6 = (int)(i4 * 0.3F + this.m + 0.5F);
    int i8 = (int)(i5 * 0.3F + this.k + 0.5F);
    int i7 = (int)(i6 + i4 * 0.4F + 0.5F);
    int i9 = (int)(i8 + i5 * 0.4F + 0.5F);
    Object localObject2 = new ArrayList();
    i1 = 0;
    while (i1 < 2)
    {
      ((List)localObject2).add(Integer.valueOf(i1));
      i1 += 1;
    }
    if ((paramInt == 0) || (paramagds == null)) {
      i1 = ((Random)localObject1).nextInt(2);
    }
    for (;;)
    {
      if (i1 < ((List)localObject2).size()) {}
      for (i1 = ((Integer)((List)localObject2).get(i1)).intValue();; i1 = 0)
      {
        i2 = i1;
        if (i1 >= 2) {
          i2 = 1;
        }
        i9 = (i9 - i8) / 2;
        i1 = i8 + i9 * i2;
        i8 = i9 + i1;
        paramagds = new Rect(i6, i1, i7, i8);
        i9 = ((Random)localObject1).nextInt(i7);
        int i10 = ((Random)localObject1).nextInt(i8);
        localObject1 = new Rect();
        ((Rect)localObject1).left = (i6 + i9 % (i7 - i6 + 1) - i3 / 2);
        ((Rect)localObject1).top = (i10 % (i8 - i1 + 1) + i1 - i3 / 2);
        ((Rect)localObject1).right = (((Rect)localObject1).left + i3);
        ((Rect)localObject1).bottom = (((Rect)localObject1).top + i3);
        localObject2 = new agds();
        ((agds)localObject2).jdField_c_of_type_Int = 500;
        ((agds)localObject2).d = 700;
        if (((agds)localObject2).d < 0) {
          ((agds)localObject2).d = 0;
        }
        ((agds)localObject2).jdField_a_of_type_Int = i3;
        ((agds)localObject2).jdField_b_of_type_Int = i3;
        ((agds)localObject2).jdField_b_of_type_AndroidGraphicsRect = ((Rect)localObject1);
        ((agds)localObject2).jdField_c_of_type_AndroidGraphicsRect = new Rect((Rect)localObject1);
        ((agds)localObject2).e = 0;
        ((agds)localObject2).jdField_a_of_type_AndroidGraphicsRect = paramagds;
        ((agds)localObject2).f = i2;
        if (QLog.isColorLevel()) {
          QLog.i("ScanOcrView", 2, "generateScanRectAniParam, hasDoneCnt=" + paramInt + "," + i4 + "*" + i5 + "\n" + localObject2);
        }
        return localObject2;
        ((List)localObject2).remove(Integer.valueOf(paramagds.f));
        if (((List)localObject2).size() <= 0) {
          break label554;
        }
        i1 = ((Random)localObject1).nextInt(((List)localObject2).size());
        break;
      }
      label554:
      i1 = 0;
    }
  }
  
  @TargetApi(12)
  private void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ScanOcrView", 2, "realPlayScanRectAnimation, hasDoneCnt=" + paramInt + ",mScanRectPlaying=" + this.jdField_b_of_type_Boolean + ",mPlaying=" + this.jdField_a_of_type_Boolean);
    }
    if (paramInt == 2) {
      return;
    }
    this.jdField_c_of_type_Agds = this.jdField_a_of_type_Agds;
    this.jdField_a_of_type_Agds = a(paramInt, this.jdField_c_of_type_Agds);
    ValueAnimator localValueAnimator1 = ValueAnimator.ofFloat(new float[] { 1.1F, 1.0F });
    localValueAnimator1.addUpdateListener(new agdn(this));
    localValueAnimator1.setDuration(200L);
    ValueAnimator localValueAnimator2 = ValueAnimator.ofInt(new int[] { 255, 0 });
    localValueAnimator2.addUpdateListener(new agdo(this));
    localValueAnimator2.setDuration(200L);
    localValueAnimator2.addListener(new agdp(this, paramInt));
    int i1 = this.jdField_a_of_type_Agds.d;
    if (paramInt == 0) {
      i1 = this.jdField_a_of_type_Agds.jdField_c_of_type_Int;
    }
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playSequentially(new Animator[] { localValueAnimator1, localValueAnimator2 });
    this.jdField_a_of_type_AndroidAnimationAnimatorSet = localAnimatorSet;
    localAnimatorSet.setStartDelay(i1);
    localAnimatorSet.start();
    invalidate();
  }
  
  private void f()
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130842923);
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130842922);
    this.jdField_c_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130842924);
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(1275068416);
    this.jdField_c_of_type_Int = a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    this.e = a(5.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    this.f = a(212.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    this.f = a(212.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    this.g = a(110.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
  }
  
  private void g()
  {
    if (this.o == 0) {
      this.j = (this.i - this.g);
    }
    while (this.o != 1) {
      return;
    }
    this.j = this.i;
  }
  
  @TargetApi(12)
  private void h()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ScanOcrView", 2, "realPlayScanRectHoldAnimation, ,mScanRectHoldPlaying=" + this.jdField_c_of_type_Boolean + ",mPlaying=" + this.jdField_a_of_type_Boolean);
    }
    this.jdField_b_of_type_Agds = a();
    ValueAnimator localValueAnimator1 = ValueAnimator.ofFloat(new float[] { 1.1F, 1.0F });
    Object localObject = this.jdField_b_of_type_Agds;
    localValueAnimator1.addUpdateListener(new agdq(this, (agds)localObject));
    localValueAnimator1.setDuration(200L);
    ValueAnimator localValueAnimator2 = ValueAnimator.ofInt(new int[] { 255, 0 });
    localValueAnimator2.addUpdateListener(new agdr(this, (agds)localObject));
    localValueAnimator2.setDuration(100L);
    localValueAnimator2.setRepeatCount(3);
    localValueAnimator2.setRepeatMode(2);
    localObject = new AnimatorSet();
    ((AnimatorSet)localObject).playSequentially(new Animator[] { localValueAnimator1, localValueAnimator2 });
    this.jdField_b_of_type_AndroidAnimationAnimatorSet = ((AnimatorSet)localObject);
    ((AnimatorSet)localObject).start();
    invalidate();
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ScanOcrView", 2, "stopScan, mPlaying=" + this.jdField_a_of_type_Boolean + ",scanType=" + this.o);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
    this.jdField_a_of_type_Boolean = false;
    invalidate();
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ScanOcrView", 2, "startScan, mPlaying=" + this.jdField_a_of_type_Boolean + ",scanType=" + paramInt + ",mScanType=" + this.o);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
    if (paramInt != this.o)
    {
      a();
      c();
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      this.d = 0;
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      this.o = paramInt;
      g();
      this.jdField_a_of_type_Boolean = true;
      invalidate();
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ScanOcrView", 2, "startScanRectAnimation, mScanRectPlaying=" + this.jdField_b_of_type_Boolean);
    }
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = true;
      b(0);
      invalidate();
    }
  }
  
  @TargetApi(12)
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ScanOcrView", 2, "stopScanRectAnimation, mScanRectPlaying=" + this.jdField_b_of_type_Boolean);
    }
    this.jdField_b_of_type_Boolean = false;
    if (this.jdField_a_of_type_AndroidAnimationAnimatorSet != null) {
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.cancel();
    }
    invalidate();
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ScanOcrView", 2, "startScanRectHoldAni, mScanRectHoldPlaying=" + this.jdField_c_of_type_Boolean);
    }
    if (!this.jdField_c_of_type_Boolean)
    {
      this.jdField_c_of_type_Boolean = true;
      h();
      invalidate();
    }
  }
  
  @TargetApi(12)
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ScanOcrView", 2, "stopScanRectHoldAni, mScanRectHoldPlaying=" + this.jdField_c_of_type_Boolean);
    }
    this.jdField_c_of_type_Boolean = false;
    if (this.jdField_a_of_type_AndroidAnimationAnimatorSet != null) {
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.cancel();
    }
    invalidate();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int i1 = 0;
    int i2;
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.d >= this.j)
      {
        this.d = 0;
        a();
        c();
        if (this.o == 0) {
          b();
        }
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
        paramCanvas = Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 0, this.o, 0);
        this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramCanvas, 2000L);
        return;
      }
      if (this.d == 0) {
        break label416;
      }
      i2 = (int)((System.currentTimeMillis() - this.jdField_a_of_type_Long) * this.j / 2000L);
      if (this.d + i2 <= this.j) {
        break label403;
      }
      this.d = this.j;
      label127:
      i2 = this.d - this.f;
      if (i2 >= 0) {
        break label425;
      }
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds(this.m, i1, this.m + this.h, this.d);
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(this.m, this.d - this.jdField_c_of_type_Int + this.e, this.m + this.h, this.d + this.e);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      invalidate();
      if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Agds != null))
      {
        this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.setAlpha(this.jdField_a_of_type_Agds.e);
        this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.setBounds(this.jdField_a_of_type_Agds.jdField_c_of_type_AndroidGraphicsRect.left, this.jdField_a_of_type_Agds.jdField_c_of_type_AndroidGraphicsRect.top, this.jdField_a_of_type_Agds.jdField_c_of_type_AndroidGraphicsRect.right, this.jdField_a_of_type_Agds.jdField_c_of_type_AndroidGraphicsRect.bottom);
        this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
      }
      if ((!this.jdField_c_of_type_Boolean) || (this.jdField_b_of_type_Agds == null)) {
        break;
      }
      this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.setAlpha(this.jdField_b_of_type_Agds.e);
      this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.setBounds(this.jdField_b_of_type_Agds.jdField_c_of_type_AndroidGraphicsRect.left, this.jdField_b_of_type_Agds.jdField_c_of_type_AndroidGraphicsRect.top, this.jdField_b_of_type_Agds.jdField_c_of_type_AndroidGraphicsRect.right, this.jdField_b_of_type_Agds.jdField_c_of_type_AndroidGraphicsRect.bottom);
      this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
      return;
      label403:
      this.d = (i2 + this.d);
      break label127;
      label416:
      this.d = 10;
      break label127;
      label425:
      i1 = i2;
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.h = (this.jdField_a_of_type_Int - this.m - this.n);
    this.i = (this.jdField_b_of_type_Int - this.k - this.l);
    g();
    invalidate();
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.m = paramInt1;
    this.n = paramInt3;
    this.k = paramInt2;
    this.l = paramInt4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.view.ScanOcrView
 * JD-Core Version:    0.7.0.1
 */