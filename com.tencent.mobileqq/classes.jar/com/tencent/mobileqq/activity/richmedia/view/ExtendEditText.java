package com.tencent.mobileqq.activity.richmedia.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.Build.VERSION;
import android.text.InputFilter;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import xxo;
import xxp;
import xxr;

public class ExtendEditText
  extends EditText
{
  public static final ExtendEditText.LengthConvertor a;
  private static final ExtendEditText.LengthConvertor c;
  protected int a;
  private ColorStateList jdField_a_of_type_AndroidContentResColorStateList;
  protected LinearGradient a;
  protected GradientDrawable.Orientation a;
  private Transformation jdField_a_of_type_AndroidViewAnimationTransformation = new Transformation();
  private ExtendEditText.LimitListener jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewExtendEditText$LimitListener;
  protected TextColorAnimation a;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  protected float[] a;
  protected int[] a;
  int jdField_b_of_type_Int = -1;
  private ExtendEditText.LengthConvertor jdField_b_of_type_ComTencentMobileqqActivityRichmediaViewExtendEditText$LengthConvertor;
  protected int c;
  private int d = 4;
  private int e;
  
  static
  {
    jdField_c_of_type_ComTencentMobileqqActivityRichmediaViewExtendEditText$LengthConvertor = new xxo();
    jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewExtendEditText$LengthConvertor = new xxp();
  }
  
  public ExtendEditText(Context paramContext)
  {
    super(paramContext);
    d();
  }
  
  public ExtendEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.EditText);
    setClearFocusOnBack(paramContext.getBoolean(0, false));
    this.jdField_b_of_type_Int = paramContext.getInteger(1, -1);
    paramContext.recycle();
    d();
  }
  
  public ExtendEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    d();
  }
  
  private void a(ExtendEditText.SuperFontInfo paramSuperFontInfo)
  {
    int j = 0;
    if (paramSuperFontInfo == null)
    {
      if (this.jdField_a_of_type_AndroidContentResColorStateList != null)
      {
        setTextColor(this.jdField_a_of_type_AndroidContentResColorStateList);
        setHintTextColor(this.jdField_a_of_type_AndroidContentResColorStateList);
      }
      setShadowLayer(0.0F, 0.0F, 0.0F, 0);
      setTextColorAnimation(null, 0);
      setGradientColor(null, null, null);
      return;
    }
    if (this.jdField_a_of_type_AndroidContentResColorStateList == null) {
      this.jdField_a_of_type_AndroidContentResColorStateList = getTextColors();
    }
    int i;
    if ((paramSuperFontInfo.jdField_a_of_type_Long & 1L) != 0L)
    {
      i = ExtendEditText.SuperFontInfo.a(paramSuperFontInfo.jdField_e_of_type_JavaLangString);
      setTextColor(i);
      setHintTextColor(i);
      if ((paramSuperFontInfo.jdField_a_of_type_Long & 0x2) == 0L) {
        break label271;
      }
      setShadowLayer(AIOUtils.a(paramSuperFontInfo.d, getResources()), AIOUtils.a(paramSuperFontInfo.jdField_b_of_type_Int, getResources()), AIOUtils.a(paramSuperFontInfo.jdField_c_of_type_Int, getResources()), ExtendEditText.SuperFontInfo.a(paramSuperFontInfo.jdField_f_of_type_JavaLangString));
    }
    label158:
    Object localObject;
    int k;
    for (;;)
    {
      if (((paramSuperFontInfo.jdField_a_of_type_Long & 0x8) != 0L) && (paramSuperFontInfo.jdField_c_of_type_JavaUtilArrayList != null) && (paramSuperFontInfo.jdField_c_of_type_JavaUtilArrayList.size() >= 2))
      {
        localObject = new ArrayList(paramSuperFontInfo.jdField_c_of_type_JavaUtilArrayList.size());
        k = paramSuperFontInfo.jdField_c_of_type_JavaUtilArrayList.size();
        i = 0;
        for (;;)
        {
          if (i < k)
          {
            ((ArrayList)localObject).add(Integer.valueOf(ExtendEditText.SuperFontInfo.a((String)paramSuperFontInfo.jdField_c_of_type_JavaUtilArrayList.get(i))));
            i += 1;
            continue;
            setTextColor(this.jdField_a_of_type_AndroidContentResColorStateList);
            setHintTextColor(this.jdField_a_of_type_AndroidContentResColorStateList);
            break;
            label271:
            setShadowLayer(0.0F, 0.0F, 0.0F, 0);
            break label158;
          }
        }
        setTextColorAnimation((ArrayList)localObject, paramSuperFontInfo.jdField_f_of_type_Int * (k - 1));
      }
    }
    while (((paramSuperFontInfo.jdField_a_of_type_Long & 0x4) != 0L) && (paramSuperFontInfo.jdField_a_of_type_JavaUtilArrayList != null) && (paramSuperFontInfo.jdField_a_of_type_JavaUtilArrayList.size() >= 2) && (paramSuperFontInfo.jdField_b_of_type_JavaUtilArrayList != null) && (paramSuperFontInfo.jdField_b_of_type_JavaUtilArrayList.size() >= 2))
    {
      k = paramSuperFontInfo.jdField_a_of_type_JavaUtilArrayList.size();
      localObject = new int[k];
      i = 0;
      for (;;)
      {
        if (i < k)
        {
          localObject[i] = ExtendEditText.SuperFontInfo.a((String)paramSuperFontInfo.jdField_a_of_type_JavaUtilArrayList.get(i));
          i += 1;
          continue;
          setTextColorAnimation(null, 0);
          break;
        }
      }
      k = paramSuperFontInfo.jdField_b_of_type_JavaUtilArrayList.size();
      float[] arrayOfFloat = new float[k];
      i = j;
      while (i < k)
      {
        arrayOfFloat[i] = ((Double)paramSuperFontInfo.jdField_b_of_type_JavaUtilArrayList.get(i)).floatValue();
        i += 1;
      }
      GradientDrawable.Orientation localOrientation = GradientDrawable.Orientation.LEFT_RIGHT;
      switch (paramSuperFontInfo.jdField_e_of_type_Int)
      {
      default: 
        paramSuperFontInfo = GradientDrawable.Orientation.LEFT_RIGHT;
      }
      for (;;)
      {
        setGradientColor((int[])localObject, arrayOfFloat, paramSuperFontInfo);
        return;
        paramSuperFontInfo = GradientDrawable.Orientation.LEFT_RIGHT;
        continue;
        paramSuperFontInfo = GradientDrawable.Orientation.BL_TR;
        continue;
        paramSuperFontInfo = GradientDrawable.Orientation.TOP_BOTTOM;
        continue;
        paramSuperFontInfo = GradientDrawable.Orientation.TL_BR;
      }
    }
    setGradientColor(null, null, null);
  }
  
  private int b()
  {
    int i = 0;
    int j = 0;
    Layout localLayout = getLayout();
    if (TextUtils.isEmpty(getText()))
    {
      CharSequence localCharSequence = getHint();
      if (!TextUtils.isEmpty(localCharSequence))
      {
        if (!localCharSequence.equals(this.jdField_a_of_type_JavaLangString))
        {
          this.jdField_a_of_type_JavaLangString = localCharSequence.toString();
          this.jdField_e_of_type_Int = ((int)getPaint().measureText(localCharSequence.toString()));
        }
        j = this.jdField_e_of_type_Int;
      }
    }
    int m;
    int k;
    do
    {
      do
      {
        return j;
      } while (localLayout == null);
      m = localLayout.getLineCount();
      k = 0;
      j = i;
    } while (k >= m);
    j = (int)localLayout.getLineRight(k);
    if (i < j) {
      i = j;
    }
    for (;;)
    {
      k += 1;
      break;
    }
  }
  
  private void d()
  {
    if (this.jdField_b_of_type_Int >= 0) {
      setFilters(new InputFilter[] { new xxr(this, this.jdField_b_of_type_Int) });
    }
  }
  
  private void e()
  {
    if ((this.jdField_a_of_type_ArrayOfInt == null) || (this.jdField_a_of_type_ArrayOfFloat == null)) {}
    int i;
    do
    {
      return;
      i = b();
    } while ((this.jdField_a_of_type_AndroidGraphicsLinearGradient != null) && (i == this.jdField_c_of_type_Int));
    this.jdField_c_of_type_Int = i;
    Rect localRect = new Rect(0, 0, this.jdField_c_of_type_Int, getMeasuredHeight());
    float f1;
    float f2;
    float f3;
    float f4;
    switch (xxq.jdField_a_of_type_ArrayOfInt[this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable$Orientation.ordinal()])
    {
    default: 
      f1 = localRect.left;
      f2 = localRect.top;
      f3 = localRect.right * 1.0F;
      f4 = 1.0F * localRect.bottom;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidGraphicsLinearGradient = new LinearGradient(f1, f2, f3, f4, this.jdField_a_of_type_ArrayOfInt, this.jdField_a_of_type_ArrayOfFloat, Shader.TileMode.CLAMP);
      return;
      f3 = localRect.left;
      f2 = localRect.top;
      f4 = 1.0F * localRect.bottom;
      f1 = f3;
      continue;
      f1 = localRect.right;
      f2 = localRect.top;
      f3 = localRect.left * 1.0F;
      f4 = 1.0F * localRect.bottom;
      continue;
      f1 = localRect.right;
      f4 = localRect.top;
      f3 = 1.0F * localRect.left;
      f2 = f4;
      continue;
      f1 = localRect.right;
      f2 = localRect.bottom;
      f3 = localRect.left * 1.0F;
      f4 = 1.0F * localRect.top;
      continue;
      f3 = localRect.left;
      f2 = localRect.bottom;
      f4 = 1.0F * localRect.top;
      f1 = f3;
      continue;
      f1 = localRect.left;
      f2 = localRect.bottom;
      f3 = localRect.right * 1.0F;
      f4 = 1.0F * localRect.top;
      continue;
      f1 = localRect.left;
      f4 = localRect.top;
      f3 = 1.0F * localRect.right;
      f2 = f4;
    }
  }
  
  private void f()
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)getContext().getSystemService("input_method");
    if (localInputMethodManager != null) {
      localInputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
    }
  }
  
  @TargetApi(14)
  int a()
  {
    int j = 0;
    int i;
    try
    {
      if (getLayout() == null) {
        return 0;
      }
      i = Build.VERSION.SDK_INT;
      if (i > 13)
      {
        try
        {
          i = getOffsetForPosition(getX(), getY());
          i = getLayout().getLineForOffset(i);
          return i;
        }
        catch (Exception localException1)
        {
          i = j;
          if (!QLog.isColorLevel()) {
            return i;
          }
        }
        QLog.w("ExtendEditText", 2, "", localException1);
        return 0;
      }
    }
    catch (Exception localException2)
    {
      i = j;
      if (QLog.isColorLevel())
      {
        QLog.w("ExtendEditText", 2, "", localException2);
        return 0;
        if (i > 10) {
          return a(getY());
        }
        i = a(getTop());
      }
    }
    return i;
  }
  
  int a(float paramFloat)
  {
    if ((this == null) || (getLayout() == null)) {
      return 0;
    }
    paramFloat = Math.max(0.0F, paramFloat - getTotalPaddingTop());
    paramFloat = Math.min(getHeight() - getTotalPaddingBottom() - 1, paramFloat);
    float f = getScrollY();
    return getLayout().getLineForVertical((int)(paramFloat + f));
  }
  
  protected void a()
  {
    Layout localLayout = getLayout();
    if (localLayout == null) {
      return;
    }
    int j = a();
    int i = localLayout.getLineTop(j);
    j = localLayout.getLineBottom(j);
    int m = getScrollY();
    int k = getScrollX();
    if (Math.abs(m - i) <= Math.abs(j - m)) {}
    for (;;)
    {
      scrollTo(k, i);
      return;
      i = j;
    }
  }
  
  protected void b()
  {
    Layout localLayout = getLayout();
    if (localLayout == null) {
      return;
    }
    int i = localLayout.getLineBottom(a());
    scrollTo(getScrollX(), i);
  }
  
  public boolean bringPointIntoView(int paramInt)
  {
    return false;
  }
  
  protected void c()
  {
    Layout localLayout = getLayout();
    if (localLayout == null) {}
    do
    {
      return;
      i = a() - 1;
    } while (i < 0);
    int i = localLayout.getLineTop(i);
    scrollTo(getScrollX(), i);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    TextPaint localTextPaint = getPaint();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewTextColorAnimation != null)
    {
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewTextColorAnimation.getTransformation(AnimationUtils.currentAnimationTimeMillis(), this.jdField_a_of_type_AndroidViewAnimationTransformation);
      int i = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewTextColorAnimation.a();
      setTextColor(i);
      setHintTextColor(i);
      if (bool) {
        postInvalidateOnAnimation();
      }
    }
    e();
    if (this.jdField_a_of_type_AndroidGraphicsLinearGradient != null) {
      localTextPaint.setShader(this.jdField_a_of_type_AndroidGraphicsLinearGradient);
    }
    super.onDraw(paramCanvas);
    if (this.jdField_a_of_type_AndroidGraphicsLinearGradient != null) {
      localTextPaint.setShader(null);
    }
  }
  
  public boolean onKeyPreIme(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((this.jdField_a_of_type_Boolean) && (paramInt == 4) && (paramKeyEvent.getAction() == 1))
    {
      f();
      clearFocus();
      return true;
    }
    return super.onKeyPreIme(paramInt, paramKeyEvent);
  }
  
  protected void onSelectionChanged(int paramInt1, int paramInt2)
  {
    super.onSelectionChanged(paramInt1, paramInt2);
    a();
  }
  
  protected void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    paramInt1 = getLineCount();
    if (this.jdField_a_of_type_Int != paramInt1)
    {
      if (this.jdField_a_of_type_Int < paramInt1)
      {
        if (paramInt1 > this.d) {
          b();
        }
        return;
      }
      c();
      return;
    }
    a();
  }
  
  public void postInvalidateOnAnimation()
  {
    super.postInvalidateDelayed(33L);
  }
  
  public void setBeforeChangeLineCount(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void setClearFocusOnBack(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setGradientColor(int[] paramArrayOfInt, float[] paramArrayOfFloat, GradientDrawable.Orientation paramOrientation)
  {
    this.jdField_a_of_type_AndroidGraphicsLinearGradient = null;
    this.jdField_a_of_type_ArrayOfInt = paramArrayOfInt;
    this.jdField_a_of_type_ArrayOfFloat = paramArrayOfFloat;
    this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable$Orientation = paramOrientation;
    if (Build.VERSION.SDK_INT >= 11) {}
    try
    {
      setLayerType(0, null);
      setDrawingCacheEnabled(false);
      return;
    }
    catch (Exception paramArrayOfInt)
    {
      for (;;)
      {
        paramArrayOfInt.printStackTrace();
      }
    }
  }
  
  public void setLimitListener(ExtendEditText.LimitListener paramLimitListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewExtendEditText$LimitListener = paramLimitListener;
  }
  
  public void setMaxLengthConvertor(ExtendEditText.LengthConvertor paramLengthConvertor)
  {
    this.jdField_b_of_type_ComTencentMobileqqActivityRichmediaViewExtendEditText$LengthConvertor = paramLengthConvertor;
  }
  
  public void setTextColorAnimation(ArrayList paramArrayList, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewTextColorAnimation != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewTextColorAnimation.cancel();
    }
    if ((paramArrayList == null) || (paramArrayList.size() < 2) || (paramInt == 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewTextColorAnimation = null;
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewTextColorAnimation = new TextColorAnimation(paramArrayList);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewTextColorAnimation.setFillAfter(true);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewTextColorAnimation.setRepeatCount(-1);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewTextColorAnimation.setRepeatMode(2);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewTextColorAnimation.setInterpolator(new LinearInterpolator());
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewTextColorAnimation.setDuration(paramInt);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewTextColorAnimation.setStartTime(0L);
  }
  
  public void setTextEffect(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      a(null);
      return;
    }
    a(ExtendEditText.SuperFontInfo.a(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.view.ExtendEditText
 * JD-Core Version:    0.7.0.1
 */