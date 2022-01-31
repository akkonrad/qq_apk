package com.tencent.mobileqq.extendfriend.utils;

import android.graphics.drawable.GradientDrawable;

public class GradientDrawableUtils
{
  public static GradientDrawable a(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setShape(0);
    localGradientDrawable.setColor(paramInt);
    localGradientDrawable.setCornerRadii(new float[] { paramFloat1, paramFloat1, paramFloat2, paramFloat2, paramFloat3, paramFloat3, paramFloat4, paramFloat4 });
    return localGradientDrawable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.utils.GradientDrawableUtils
 * JD-Core Version:    0.7.0.1
 */