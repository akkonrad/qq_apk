package com.tencent.mobileqq.activity.richmedia.view;

import android.graphics.Color;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import java.util.ArrayList;

public class TextColorAnimation
  extends Animation
{
  private int jdField_a_of_type_Int;
  private TextColorAnimation.OnUpdateColorListener jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewTextColorAnimation$OnUpdateColorListener;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  
  public TextColorAnimation(ArrayList paramArrayList)
  {
    a(paramArrayList);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a(ArrayList paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    super.applyTransformation(paramFloat, paramTransformation);
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() < 2)) {
      return;
    }
    float f = 1.0F / (this.jdField_a_of_type_JavaUtilArrayList.size() - 1);
    int i = (int)(paramFloat / f);
    f = (paramFloat - i * f) / f;
    if (i == this.jdField_a_of_type_JavaUtilArrayList.size() - 1) {
      i = this.jdField_a_of_type_JavaUtilArrayList.size() - 2;
    }
    for (;;)
    {
      int k = ((Integer)this.jdField_a_of_type_JavaUtilArrayList.get(i)).intValue();
      int j = ((Integer)this.jdField_a_of_type_JavaUtilArrayList.get(i + 1)).intValue();
      i = j;
      if (paramFloat < 1.0F)
      {
        i = (int)(Color.alpha(k) + (Color.alpha(j) - Color.alpha(k)) * f);
        int m = (int)(Color.red(k) + (Color.red(j) - Color.red(k)) * f);
        int n = (int)(Color.green(k) + (Color.green(j) - Color.green(k)) * f);
        paramFloat = Color.blue(k);
        i = Color.argb(i, m, n, (int)((Color.blue(j) - Color.blue(k)) * f + paramFloat));
      }
      this.jdField_a_of_type_Int = i;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewTextColorAnimation$OnUpdateColorListener == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewTextColorAnimation$OnUpdateColorListener.a(i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.view.TextColorAnimation
 * JD-Core Version:    0.7.0.1
 */