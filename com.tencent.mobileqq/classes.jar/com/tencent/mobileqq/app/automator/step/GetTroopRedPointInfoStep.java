package com.tencent.mobileqq.app.automator.step;

import com.tencent.biz.TroopRedpoint.TroopRedTouchHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;

public class GetTroopRedPointInfoStep
  extends AsyncStep
{
  protected int a()
  {
    ((TroopRedTouchHandler)this.a.b.a(43)).a();
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetTroopRedPointInfoStep
 * JD-Core Version:    0.7.0.1
 */