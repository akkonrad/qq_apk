package com.tencent.mobileqq.dinifly.animation.keyframe;

import com.tencent.mobileqq.dinifly.animation.Keyframe;
import com.tencent.mobileqq.dinifly.model.DocumentData;
import java.util.List;

public class TextKeyframeAnimation
  extends KeyframeAnimation<DocumentData>
{
  public TextKeyframeAnimation(List<? extends Keyframe<DocumentData>> paramList)
  {
    super(paramList);
  }
  
  DocumentData getValue(Keyframe<DocumentData> paramKeyframe, float paramFloat)
  {
    return (DocumentData)paramKeyframe.startValue;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.animation.keyframe.TextKeyframeAnimation
 * JD-Core Version:    0.7.0.1
 */