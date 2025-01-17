package com.tencent.mobileqq.activity.aio.anim;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.AnimateUtils;
import com.tencent.widget.ListView;

public class MoveToBottomScroller
  implements Runnable
{
  public static int b;
  float jdField_a_of_type_Float = 1.0F;
  public int a;
  private long jdField_a_of_type_Long;
  AIOFooterViewDetector jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOFooterViewDetector;
  MoveToBottomScroller.OnScrollerListener jdField_a_of_type_ComTencentMobileqqActivityAioAnimMoveToBottomScroller$OnScrollerListener;
  ListView jdField_a_of_type_ComTencentWidgetListView;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private boolean jdField_b_of_type_Boolean = true;
  private float jdField_c_of_type_Float;
  int jdField_c_of_type_Int;
  private float jdField_d_of_type_Float;
  int jdField_d_of_type_Int = 0;
  int e = 0;
  int f = 0;
  int g = 0;
  int h = 0;
  int i = 0;
  private int j;
  private int k;
  private int l;
  private int m;
  private int n;
  
  static
  {
    jdField_b_of_type_Int = 50;
  }
  
  public MoveToBottomScroller(ListView paramListView, AIOFooterViewDetector paramAIOFooterViewDetector)
  {
    this.jdField_a_of_type_ComTencentWidgetListView = paramListView;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOFooterViewDetector = paramAIOFooterViewDetector;
    this.jdField_c_of_type_Int = ViewConfiguration.get(this.jdField_a_of_type_ComTencentWidgetListView.getContext()).getScaledMinimumFlingVelocity();
    if (DeviceInfoUtil.e() / 1048576L > 512L) {}
    for (;;)
    {
      this.jdField_b_of_type_Boolean = bool;
      this.jdField_a_of_type_Float = this.jdField_a_of_type_ComTencentWidgetListView.getResources().getDisplayMetrics().density;
      return;
      bool = false;
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MoveToBottomScroller", 2, "MoveToBottomScroller start");
    }
    this.jdField_a_of_type_Int = 0;
    this.i = 0;
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentWidgetListView.setSelection(this.jdField_a_of_type_ComTencentWidgetListView.getCount() - 1);
      b();
    }
    while (this.jdField_a_of_type_ComTencentWidgetListView == null) {
      return;
    }
    this.h = this.jdField_a_of_type_ComTencentWidgetListView.getResources().getDisplayMetrics().heightPixels;
    this.e = this.jdField_a_of_type_ComTencentWidgetListView.mFirstPosition;
    this.f = (this.e + this.jdField_a_of_type_ComTencentWidgetListView.getChildCount() - 1);
    this.jdField_d_of_type_Int = (this.jdField_a_of_type_ComTencentWidgetListView.getCount() - this.f - 1);
    if (QLog.isColorLevel()) {
      QLog.d("MoveToBottomScroller", 2, "MoveToBottomScroller start scrollCount: " + this.jdField_d_of_type_Int);
    }
    label260:
    int i2;
    if (this.jdField_d_of_type_Int == 0)
    {
      if (this.jdField_a_of_type_ComTencentWidgetListView.getChildCount() < 1)
      {
        this.jdField_a_of_type_ComTencentWidgetListView.setSelection(this.jdField_a_of_type_ComTencentWidgetListView.getCount() - 1);
        return;
      }
      this.n = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(this.jdField_a_of_type_ComTencentWidgetListView.getChildCount() - 1).getBottom();
      if (this.n == 0)
      {
        b();
        return;
      }
      this.m = 800;
      this.jdField_a_of_type_Long = AnimationUtils.currentAnimationTimeMillis();
      this.j = 0;
      this.k = 3;
      this.jdField_a_of_type_ComTencentWidgetListView.post(this);
      if (QLog.isColorLevel()) {
        QLog.d("MoveToBottomScroller", 2, new Object[] { "MoveToBottomScroller start end with mDistance: " + this.n, " scrollCount: " + this.jdField_d_of_type_Int });
      }
    }
    else
    {
      int i1 = this.jdField_a_of_type_ComTencentWidgetListView.getChildCount();
      if (this.jdField_a_of_type_ComTencentWidgetListView.getChildCount() == 0) {
        i1 = 1;
      }
      if ((this.jdField_a_of_type_ComTencentWidgetListView.getFooterViewsCount() <= 0) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOFooterViewDetector.jdField_a_of_type_Int < 0)) {
        break label513;
      }
      if (this.jdField_d_of_type_Int <= 1) {
        break label508;
      }
      i2 = this.jdField_d_of_type_Int - 1;
      label382:
      this.jdField_d_of_type_Int = i2;
      this.n = this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOFooterViewDetector.jdField_a_of_type_Int;
      label398:
      i2 = this.n;
      this.n = (this.jdField_d_of_type_Int * this.jdField_a_of_type_ComTencentWidgetListView.getHeight() / i1 + i2);
      this.jdField_d_of_type_Float = (this.n / 600.0F);
      this.jdField_b_of_type_Float = (this.jdField_d_of_type_Float / 200.0F);
      this.jdField_c_of_type_Float = 0.0F;
      this.jdField_a_of_type_Long = AnimationUtils.currentAnimationTimeMillis();
      this.k = 0;
      this.j = 0;
      this.l = (this.jdField_a_of_type_ComTencentWidgetListView.getCount() - 1);
      if (this.jdField_d_of_type_Int != 1) {
        break label521;
      }
    }
    label513:
    label521:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      this.jdField_a_of_type_ComTencentWidgetListView.post(this);
      break label260;
      break;
      label508:
      i2 = 0;
      break label382;
      this.n = 0;
      break label398;
    }
  }
  
  public void a(MoveToBottomScroller.OnScrollerListener paramOnScrollerListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimMoveToBottomScroller$OnScrollerListener = paramOnScrollerListener;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimMoveToBottomScroller$OnScrollerListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimMoveToBottomScroller$OnScrollerListener.a();
    }
    this.jdField_a_of_type_ComTencentWidgetListView.removeCallbacks(this);
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MoveToBottomScroller", 2, "MoveToBottomScroller run with mDistance: " + this.n);
    }
    this.jdField_a_of_type_Int += 1;
    if (this.jdField_a_of_type_Int >= jdField_b_of_type_Int)
    {
      this.jdField_a_of_type_ComTencentWidgetListView.setSelectionFromBottom(this.jdField_a_of_type_ComTencentWidgetListView.getCount() - 1, 0);
      b();
      return;
    }
    int i3 = (int)(AnimationUtils.currentAnimationTimeMillis() - this.jdField_a_of_type_Long);
    int i2;
    switch (this.k)
    {
    default: 
      i1 = 0;
      i2 = i1 - this.j;
      this.j = i1;
      if (i2 >= 0) {
        break;
      }
    }
    for (int i1 = 0;; i1 = i2)
    {
      if (this.jdField_a_of_type_ComTencentWidgetListView.getChildCount() - 1 > 0) {
        this.g = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(this.jdField_a_of_type_ComTencentWidgetListView.getChildCount() - 1).getHeight();
      }
      QLog.d("MoveToBottomScroller", 2, "run  delta=" + i1);
      i2 = i1;
      if (this.jdField_d_of_type_Int < 2)
      {
        if (this.g > this.h) {
          break label747;
        }
        i2 = i1;
        if (i1 < this.jdField_a_of_type_Float * 2.0F) {
          i2 = (int)(this.jdField_a_of_type_Float * 2.0F + 0.5D);
        }
      }
      for (;;)
      {
        try
        {
          bool = this.jdField_a_of_type_ComTencentWidgetListView.trackMotionScroll(-i2, -i2);
        }
        catch (Exception localException1)
        {
          label747:
          boolean bool = true;
        }
        try
        {
          QLog.d("MoveToBottomScroller", 2, "move delta=" + i2);
          if (bool) {
            break label832;
          }
          i1 = this.jdField_a_of_type_ComTencentWidgetListView.getChildCount();
          i2 = this.jdField_a_of_type_ComTencentWidgetListView.mFirstPosition;
          if ((this.k != 3) && (this.k != 1) && (i2 + i1 - 1 >= this.l))
          {
            if (i1 < 2) {
              break label799;
            }
            this.n = (this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(i1 - 1).getBottom() - this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(i1 - 2).getBottom());
            QLog.d("MoveToBottomScroller", 2, "at position mDistance=" + this.n);
            this.m = (800 - i3);
            if (this.m < 100) {
              this.m = 100;
            }
            if (this.m > 400) {
              this.m = 400;
            }
            this.jdField_a_of_type_Long = AnimationUtils.currentAnimationTimeMillis();
            this.j = 0;
            if ((this.jdField_c_of_type_Float * 1000.0F <= this.jdField_c_of_type_Int) || (this.jdField_a_of_type_Boolean)) {
              break label824;
            }
            this.k = 1;
            this.jdField_c_of_type_Float = (this.n * 2.0F / this.m);
            this.jdField_b_of_type_Float = (this.jdField_c_of_type_Float / this.m);
            QLog.d("MoveToBottomScroller", 2, "at position mCurrVelocity=" + this.jdField_c_of_type_Float + "mCurrVelocity=" + this.jdField_c_of_type_Float + "mDuration=" + this.m);
          }
          this.jdField_a_of_type_ComTencentWidgetListView.post(this);
          return;
        }
        catch (Exception localException2)
        {
          break label784;
        }
        this.jdField_c_of_type_Float = (this.jdField_b_of_type_Float * i3);
        i1 = (int)(this.jdField_c_of_type_Float * i3 / 2.0F);
        break;
        i1 = (int)(this.jdField_d_of_type_Float * i3 - this.jdField_d_of_type_Float * 800.0F / 8.0F);
        break;
        if (i3 > this.m)
        {
          i1 = this.n;
          i1 = this.j;
          this.jdField_a_of_type_ComTencentWidgetListView.setSelectionFromBottom(this.jdField_a_of_type_ComTencentWidgetListView.getCount() - 1, 0);
          b();
          return;
        }
        this.jdField_c_of_type_Float -= this.jdField_b_of_type_Float * i3;
        i1 = (int)(this.n - this.jdField_c_of_type_Float * (this.m - i3) / 2.0F);
        break;
        i1 = (int)(AnimateUtils.a(i3 / this.m) * this.n);
        break;
        i1 = (int)(i3 / this.m * this.n);
        break;
        i2 = i1;
        if (i1 > this.jdField_a_of_type_Float * 10.0F)
        {
          i2 = (int)(this.jdField_a_of_type_Float * 10.0F + 0.5D);
          continue;
          label784:
          QLog.d("MoveToBottomScroller", 2, localException1, new Object[0]);
          continue;
          label799:
          if (i1 == 1)
          {
            this.n = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(i1 - 1).getBottom();
            continue;
            label824:
            this.k = 3;
          }
        }
      }
      label832:
      if (QLog.isColorLevel()) {
        QLog.d("MoveToBottomScroller", 2, "atEdge");
      }
      b();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.MoveToBottomScroller
 * JD-Core Version:    0.7.0.1
 */