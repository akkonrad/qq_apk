import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.extendfriend.pulltorefresh.LoadingLayoutBase;
import com.tencent.mobileqq.extendfriend.pulltorefresh.PullToRefreshBase.Mode;
import com.tencent.mobileqq.extendfriend.pulltorefresh.PullToRefreshBase.Orientation;
import com.tencent.mobileqq.extendfriend.pulltorefresh.internal.ViewCompat;

@SuppressLint({"ViewConstructor"})
public abstract class acjs
  extends LoadingLayoutBase
{
  public static final Interpolator a;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  public final ImageView a;
  public final ProgressBar a;
  private final TextView jdField_a_of_type_AndroidWidgetTextView;
  public final PullToRefreshBase.Mode a;
  public final PullToRefreshBase.Orientation a;
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  private boolean jdField_a_of_type_Boolean;
  private final TextView jdField_b_of_type_AndroidWidgetTextView;
  private CharSequence jdField_b_of_type_JavaLangCharSequence;
  private CharSequence c;
  private CharSequence d;
  
  static
  {
    jdField_a_of_type_AndroidViewAnimationInterpolator = new LinearInterpolator();
  }
  
  public acjs(Context paramContext, PullToRefreshBase.Mode paramMode, PullToRefreshBase.Orientation paramOrientation, TypedArray paramTypedArray)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshPullToRefreshBase$Mode = paramMode;
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshPullToRefreshBase$Orientation = paramOrientation;
    FrameLayout.LayoutParams localLayoutParams;
    int i;
    switch (acjt.a[paramOrientation.ordinal()])
    {
    default: 
      LayoutInflater.from(paramContext).inflate(2130969196, this);
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131365559));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131365562));
      this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131365561));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131365563));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131365560));
      localLayoutParams = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
      switch (acjt.b[paramMode.ordinal()])
      {
      default: 
        if (paramOrientation == PullToRefreshBase.Orientation.VERTICAL)
        {
          i = 80;
          label179:
          localLayoutParams.gravity = i;
          this.jdField_a_of_type_JavaLangCharSequence = paramContext.getString(2131428431);
          this.jdField_b_of_type_JavaLangCharSequence = paramContext.getString(2131428433);
          this.c = paramContext.getString(2131428432);
          if (paramTypedArray.hasValue(1))
          {
            paramOrientation = paramTypedArray.getDrawable(1);
            if (paramOrientation != null) {
              ViewCompat.a(this, paramOrientation);
            }
          }
          if (paramTypedArray.hasValue(10))
          {
            paramOrientation = new TypedValue();
            paramTypedArray.getValue(10, paramOrientation);
            b(paramOrientation.data);
          }
          if (paramTypedArray.hasValue(11))
          {
            paramOrientation = new TypedValue();
            paramTypedArray.getValue(11, paramOrientation);
            a(paramOrientation.data);
          }
          if (paramTypedArray.hasValue(2))
          {
            paramOrientation = paramTypedArray.getColorStateList(2);
            if (paramOrientation != null) {
              b(paramOrientation);
            }
          }
          if (paramTypedArray.hasValue(3))
          {
            paramOrientation = paramTypedArray.getColorStateList(3);
            if (paramOrientation != null) {
              a(paramOrientation);
            }
          }
          paramOrientation = null;
          if (paramTypedArray.hasValue(6)) {
            paramOrientation = paramTypedArray.getDrawable(6);
          }
          switch (acjt.b[paramMode.ordinal()])
          {
          default: 
            if (paramTypedArray.hasValue(7)) {
              paramMode = paramTypedArray.getDrawable(7);
            }
            break;
          }
        }
        break;
      }
      break;
    }
    for (;;)
    {
      paramOrientation = paramMode;
      if (paramMode == null) {
        paramOrientation = paramContext.getResources().getDrawable(b());
      }
      setLoadingDrawable(paramOrientation);
      i();
      return;
      LayoutInflater.from(paramContext).inflate(2130969195, this);
      break;
      if (paramOrientation == PullToRefreshBase.Orientation.VERTICAL) {}
      for (i = 48;; i = 3)
      {
        localLayoutParams.gravity = i;
        this.jdField_a_of_type_JavaLangCharSequence = paramContext.getString(2131428434);
        this.jdField_b_of_type_JavaLangCharSequence = paramContext.getString(2131428436);
        this.c = paramContext.getString(2131428435);
        break;
      }
      i = 5;
      break label179;
      paramMode = paramOrientation;
      if (paramTypedArray.hasValue(18))
      {
        paramMode = paramTypedArray.getDrawable(18);
        continue;
        if (paramTypedArray.hasValue(8))
        {
          paramMode = paramTypedArray.getDrawable(8);
        }
        else
        {
          paramMode = paramOrientation;
          if (paramTypedArray.hasValue(19)) {
            paramMode = paramTypedArray.getDrawable(19);
          }
        }
      }
    }
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
      this.jdField_b_of_type_AndroidWidgetTextView.setTextAppearance(getContext(), paramInt);
    }
  }
  
  private void a(ColorStateList paramColorStateList)
  {
    if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramColorStateList);
    }
  }
  
  private void a(CharSequence paramCharSequence)
  {
    if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramCharSequence);
    }
  }
  
  private void b(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextAppearance(getContext(), paramInt);
    }
    if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
      this.jdField_b_of_type_AndroidWidgetTextView.setTextAppearance(getContext(), paramInt);
    }
  }
  
  private void b(ColorStateList paramColorStateList)
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramColorStateList);
    }
    if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramColorStateList);
    }
  }
  
  public final int a()
  {
    switch (acjt.a[this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshPullToRefreshBase$Orientation.ordinal()])
    {
    default: 
      return this.jdField_a_of_type_AndroidWidgetFrameLayout.getHeight();
    }
    return this.jdField_a_of_type_AndroidWidgetFrameLayout.getWidth();
  }
  
  public final void a()
  {
    i();
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangCharSequence);
    }
    e();
  }
  
  public final void a(float paramFloat)
  {
    if (!this.jdField_a_of_type_Boolean) {
      b(paramFloat);
    }
  }
  
  public abstract void a(Drawable paramDrawable);
  
  public abstract int b();
  
  public final void b()
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.c);
    }
    g();
  }
  
  public abstract void b(float paramFloat);
  
  public final void c()
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_JavaLangCharSequence);
    }
    if (this.jdField_a_of_type_Boolean) {
      ((AnimationDrawable)this.jdField_a_of_type_AndroidWidgetImageView.getDrawable()).start();
    }
    for (;;)
    {
      if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      return;
      f();
    }
  }
  
  public final void d()
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.d);
    }
    if (this.jdField_a_of_type_AndroidWidgetProgressBar != null) {
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
    }
  }
  
  public abstract void e();
  
  public abstract void f();
  
  public abstract void g();
  
  public abstract void h();
  
  public final void i()
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangCharSequence);
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    if (this.jdField_a_of_type_Boolean) {
      ((AnimationDrawable)this.jdField_a_of_type_AndroidWidgetImageView.getDrawable()).stop();
    }
    for (;;)
    {
      if (this.jdField_b_of_type_AndroidWidgetTextView != null)
      {
        if (!TextUtils.isEmpty(this.jdField_b_of_type_AndroidWidgetTextView.getText())) {
          break;
        }
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      return;
      h();
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
  }
  
  public void setLastUpdatedLabel(CharSequence paramCharSequence)
  {
    a(paramCharSequence);
  }
  
  public final void setLoadingDrawable(Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramDrawable);
    this.jdField_a_of_type_Boolean = (paramDrawable instanceof AnimationDrawable);
    a(paramDrawable);
  }
  
  public void setPullLabel(CharSequence paramCharSequence)
  {
    this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
  }
  
  public void setRefreshResultLabel(CharSequence paramCharSequence)
  {
    this.d = paramCharSequence;
  }
  
  public void setRefreshingLabel(CharSequence paramCharSequence)
  {
    this.jdField_b_of_type_JavaLangCharSequence = paramCharSequence;
  }
  
  public void setReleaseLabel(CharSequence paramCharSequence)
  {
    this.c = paramCharSequence;
  }
  
  public void setTextTypeface(Typeface paramTypeface)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setTypeface(paramTypeface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acjs
 * JD-Core Version:    0.7.0.1
 */