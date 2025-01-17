package dov.com.qq.im.capture.view;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import anqa;
import anqb;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.widget.RedDotTextView;
import dov.com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import java.util.ArrayList;

public class QIMSlidingTabView
  extends HorizontalScrollView
{
  private static final int[] jdField_a_of_type_ArrayOfInt = { 16842901, 16842904 };
  private int jdField_a_of_type_Int = -7829368;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private LinearLayout.LayoutParams jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private QIMSlidingTabView.IOnTabCheckListener jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView$IOnTabCheckListener;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList(5);
  private boolean jdField_a_of_type_Boolean;
  private int b = -16777216;
  private int c = 14;
  private int d;
  private int e = 15;
  private int f;
  private int g = 52;
  private int h;
  private int i = 4;
  private int j = -16776961;
  private int k = 1;
  private int l = -3355444;
  private int m;
  private int n;
  private int o = 2;
  private int p = 2;
  
  public QIMSlidingTabView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }
  
  public QIMSlidingTabView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  private int a(int paramInt, View paramView)
  {
    if (paramInt < 0) {
      return -1;
    }
    paramView.setOnClickListener(new anqa(this, paramInt));
    this.jdField_a_of_type_JavaUtilArrayList.add(paramInt, paramView);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramView, paramInt);
    return 0;
  }
  
  private void a()
  {
    int i2 = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
    int i1 = 0;
    if (i1 < i2)
    {
      View localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i1);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -1);
      if (i1 == 0) {
        localLayoutParams.setMargins(this.d, 0, 0, 0);
      }
      for (;;)
      {
        localView.setLayoutParams(localLayoutParams);
        i1 += 1;
        break;
        if (i1 == i2 - 1) {
          localLayoutParams.setMargins(0, 0, this.d, 0);
        }
      }
    }
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams = new LinearLayout.LayoutParams(-2, -1);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(paramContext);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(0);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams);
    addView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    this.d = ((int)TypedValue.applyDimension(1, this.d, localDisplayMetrics));
    this.g = ((int)TypedValue.applyDimension(1, this.g, localDisplayMetrics));
    this.i = ((int)TypedValue.applyDimension(1, this.i, localDisplayMetrics));
    this.k = ((int)TypedValue.applyDimension(1, this.k, localDisplayMetrics));
    this.e = ((int)TypedValue.applyDimension(1, this.e, localDisplayMetrics));
    this.c = ((int)TypedValue.applyDimension(1, this.c, localDisplayMetrics));
    this.f = ((int)TypedValue.applyDimension(1, this.f, localDisplayMetrics));
    paramContext.obtainStyledAttributes(paramAttributeSet, jdField_a_of_type_ArrayOfInt).recycle();
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.QIMSlidingTabViewStyle);
    this.d = paramContext.getDimensionPixelSize(0, this.d);
    this.e = paramContext.getDimensionPixelSize(1, this.e);
    this.j = paramContext.getColor(3, this.j);
    this.i = paramContext.getDimensionPixelSize(4, this.i);
    this.jdField_a_of_type_Int = paramContext.getColor(7, this.jdField_a_of_type_Int);
    this.b = paramContext.getColor(8, this.b);
    this.l = paramContext.getColor(5, this.l);
    this.k = paramContext.getDimensionPixelSize(6, this.k);
    this.c = paramContext.getDimensionPixelSize(9, this.c);
    this.f = paramContext.getDimensionPixelSize(2, this.f);
    paramContext.recycle();
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.j);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    setFillViewport(true);
    setWillNotDraw(false);
    setHorizontalScrollBarEnabled(false);
    this.p = ScreenUtil.a(this.o);
  }
  
  @TargetApi(11)
  private void b()
  {
    if (this.n != this.m)
    {
      Object localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(this.n);
      View localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(this.m);
      int i1;
      int i2;
      if ((localObject != null) && (localView != null))
      {
        i1 = ((View)localObject).getLeft();
        i2 = localView.getLeft();
        if ((i1 == 0) && (i2 == 0)) {
          this.jdField_a_of_type_Boolean = true;
        }
      }
      else
      {
        return;
      }
      this.jdField_a_of_type_Boolean = false;
      localObject = ValueAnimator.ofInt(new int[] { i1, i2 });
      ((ValueAnimator)localObject).setDuration(100L);
      ((ValueAnimator)localObject).addUpdateListener(new anqb(this));
      ((ValueAnimator)localObject).start();
      return;
    }
    this.h = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(this.m).getLeft();
    this.jdField_a_of_type_Boolean = true;
    invalidate();
  }
  
  private void b(int paramInt)
  {
    int i2 = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
    int i1 = 0;
    if (i1 < i2)
    {
      Object localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i1);
      View localView;
      if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (i1 < this.jdField_a_of_type_JavaUtilArrayList.size()))
      {
        localView = (View)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
        if (i1 != paramInt) {
          break label189;
        }
        if (!(localView instanceof ImageView)) {
          break label110;
        }
        localObject = (Bundle)localView.getTag();
        if (localObject != null) {
          ((ImageView)localView).setImageResource(((Bundle)localObject).getInt("checked_image_bg_id", 2130843579));
        }
      }
      label189:
      for (;;)
      {
        i1 += 1;
        break;
        label110:
        if ((localView instanceof RedDotTextView))
        {
          ((RedDotTextView)localObject).setTextColor(this.b);
          ((RedDotTextView)localObject).a(false);
        }
        else if ((localView instanceof TextView))
        {
          ((TextView)localObject).setTextColor(this.b);
        }
        else if ((localView instanceof QIMSlidingItemView))
        {
          ((QIMSlidingItemView)localObject).a(this.b, true);
          continue;
          if ((localView instanceof ImageView))
          {
            localObject = (Bundle)localView.getTag();
            if (localObject != null) {
              ((ImageView)localView).setImageResource(((Bundle)localObject).getInt("normal_image_bg_id", 2130843578));
            }
          }
          else if ((localView instanceof RedDotTextView))
          {
            ((RedDotTextView)localObject).setTextColor(this.jdField_a_of_type_Int);
          }
          else if ((localView instanceof TextView))
          {
            ((TextView)localObject).setTextColor(this.jdField_a_of_type_Int);
          }
          else if ((localView instanceof QIMSlidingItemView))
          {
            ((QIMSlidingItemView)localObject).a(this.jdField_a_of_type_Int, false);
          }
        }
      }
    }
  }
  
  private void c(int paramInt)
  {
    View localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(paramInt);
    int i1;
    if (localView != null)
    {
      paramInt = getScrollX();
      i1 = this.e * 4;
      int i2 = localView.getRight() - paramInt - getWidth() + i1;
      if (i2 <= 0) {
        break label53;
      }
      smoothScrollBy(i2, 0);
    }
    label53:
    do
    {
      return;
      paramInt = localView.getLeft() - paramInt - i1;
    } while (paramInt >= 0);
    smoothScrollBy(paramInt, 0);
  }
  
  public void a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return;
    }
    this.m = paramInt;
    b(paramInt);
    c(paramInt);
    b();
    if (this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView$IOnTabCheckListener != null) {
      this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView$IOnTabCheckListener.a(paramInt);
    }
    this.n = this.m;
  }
  
  public void a(ArrayList paramArrayList)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    int i1 = 0;
    while (i1 < paramArrayList.size())
    {
      TextView localTextView = new TextView(getContext());
      localTextView.setText((CharSequence)paramArrayList.get(i1));
      localTextView.setGravity(17);
      localTextView.setSingleLine();
      localTextView.setTextSize(0, this.c);
      localTextView.setPadding(this.e, 0, this.e, 0);
      a(i1, localTextView);
      i1 += 1;
    }
    a();
    a(0);
  }
  
  public void b(ArrayList paramArrayList)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    int i1 = 0;
    if (i1 < paramArrayList.size())
    {
      Object localObject;
      if (((QIMSlidingItemView.SlidingItemData)paramArrayList.get(i1)).jdField_a_of_type_Int == 0)
      {
        localObject = new TextView(getContext());
        ((TextView)localObject).setText(((QIMSlidingItemView.SlidingItemData)paramArrayList.get(i1)).jdField_a_of_type_JavaLangString);
        ((TextView)localObject).setGravity(17);
        ((TextView)localObject).setSingleLine();
        ((TextView)localObject).setTextSize(0, this.c);
        ((TextView)localObject).setPadding(this.e, 0, this.e, 0);
        a(i1, (View)localObject);
      }
      for (;;)
      {
        i1 += 1;
        break;
        localObject = new QIMSlidingItemView(getContext());
        ((QIMSlidingItemView)localObject).a(this.c, this.e);
        ((QIMSlidingItemView)localObject).setData((QIMSlidingItemView.SlidingItemData)paramArrayList.get(i1));
        a(i1, (View)localObject);
      }
    }
    a();
    a(0);
  }
  
  public void c(ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    int i1 = 0;
    while (i1 < paramArrayList.size())
    {
      RedDotTextView localRedDotTextView = new RedDotTextView(getContext());
      localRedDotTextView.setText(((QIMSlidingTabView.TabIcon)paramArrayList.get(i1)).jdField_a_of_type_JavaLangString);
      localRedDotTextView.setGravity(17);
      localRedDotTextView.setSingleLine();
      localRedDotTextView.setTextSize(0, this.c);
      localRedDotTextView.setPadding(this.e, 0, this.e, 0);
      localRedDotTextView.a(((QIMSlidingTabView.TabIcon)paramArrayList.get(i1)).jdField_a_of_type_Boolean);
      a(i1, localRedDotTextView);
      i1 += 1;
    }
    a();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i1 = getHeight();
    View localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(this.m);
    if (localView != null)
    {
      if (this.jdField_a_of_type_Boolean)
      {
        this.h = localView.getLeft();
        c(this.m);
        this.jdField_a_of_type_Boolean = false;
      }
      if ((this.m == 0) && (this.h < localView.getLeft())) {
        this.h = localView.getLeft();
      }
      float f1 = this.h + this.f;
      float f2 = i1 - this.i;
      int i2 = this.h;
      paramCanvas.drawRoundRect(new RectF(f1, f2, localView.getWidth() + i2 - this.f, i1), this.p, this.p, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
  }
  
  public void setIndicateColor(int paramInt)
  {
    this.j = paramInt;
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.j);
    invalidate();
  }
  
  public void setTabCheckListener(QIMSlidingTabView.IOnTabCheckListener paramIOnTabCheckListener)
  {
    this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView$IOnTabCheckListener = paramIOnTabCheckListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.view.QIMSlidingTabView
 * JD-Core Version:    0.7.0.1
 */