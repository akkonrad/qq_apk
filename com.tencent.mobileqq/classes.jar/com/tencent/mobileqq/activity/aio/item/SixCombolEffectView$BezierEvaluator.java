package com.tencent.mobileqq.activity.aio.item;

import android.animation.TypeEvaluator;
import android.graphics.PointF;

public class SixCombolEffectView$BezierEvaluator
  implements TypeEvaluator
{
  private PointF[] jdField_a_of_type_ArrayOfAndroidGraphicsPointF;
  
  public SixCombolEffectView$BezierEvaluator(SixCombolEffectView paramSixCombolEffectView) {}
  
  public PointF a(float paramFloat, PointF paramPointF1, PointF paramPointF2)
  {
    paramPointF1 = this.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[0];
    paramPointF2 = this.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[1];
    PointF localPointF = this.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[2];
    if (paramFloat <= 1.0F)
    {
      float f1 = 1.0F - paramFloat;
      float f2 = (float)(paramPointF1.x * Math.pow(f1, 2.0D) + 2.0F * paramPointF2.x * paramFloat * f1 + localPointF.x * Math.pow(paramFloat, 2.0D));
      double d1 = paramPointF1.y;
      double d2 = Math.pow(f1, 2.0D);
      return new PointF(f2, (float)(2.0F * paramPointF2.y * paramFloat * f1 + d1 * d2 + localPointF.y * Math.pow(paramFloat, 2.0D)));
    }
    return this.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[2];
  }
  
  public void a(PointF... paramVarArgs)
  {
    if (paramVarArgs.length != 3) {
      throw new IllegalArgumentException("只演示三次方贝赛尔曲线");
    }
    this.jdField_a_of_type_ArrayOfAndroidGraphicsPointF = paramVarArgs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.SixCombolEffectView.BezierEvaluator
 * JD-Core Version:    0.7.0.1
 */