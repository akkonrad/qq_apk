package com.tencent.av.ui;

import android.view.animation.Animation;
import android.view.animation.Transformation;

public class QavVideoRecordUICtrl$FadeInOutAnimation
  extends Animation
{
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    if (paramFloat < 0.5F) {}
    for (float f = (0.5F - paramFloat) / 0.5F;; f = (paramFloat - 0.5F) / 0.5F)
    {
      paramTransformation.setAlpha(f);
      super.applyTransformation(paramFloat, paramTransformation);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.ui.QavVideoRecordUICtrl.FadeInOutAnimation
 * JD-Core Version:    0.7.0.1
 */