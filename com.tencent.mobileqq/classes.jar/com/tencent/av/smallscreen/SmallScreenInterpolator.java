package com.tencent.av.smallscreen;

import android.view.animation.Interpolator;

public class SmallScreenInterpolator
  implements Interpolator
{
  public float getInterpolation(float paramFloat)
  {
    if (0.8571429F < paramFloat) {
      return 1.0F;
    }
    return (float)(Math.cos((1.0F + 7.0F * paramFloat / 6.0F) * 3.141592653589793D) / 2.0D) + 0.5F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenInterpolator
 * JD-Core Version:    0.7.0.1
 */