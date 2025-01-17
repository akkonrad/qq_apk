package com.tencent.mobileqq.app.automator.step;

import android.content.SharedPreferences;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.vipav.VipFunCallManager;
import com.tencent.mobileqq.vipav.VipSetFunCallHandler;
import com.tencent.qphone.base.util.QLog;

public class GetFunCallData
  extends AsyncStep
{
  protected int a()
  {
    long l = VipFunCallManager.a(this.a.b, 1, null).getLong("update_time", 0L);
    if ((System.currentTimeMillis() - l > 14400000L) || (System.currentTimeMillis() < l))
    {
      ((VipSetFunCallHandler)this.a.b.a(46)).a(1, new Bundle());
      if (QLog.isColorLevel()) {
        QLog.d("GetFunCallData", 2, "doStep SUB_CMD_GET_MY_FC.");
      }
    }
    for (;;)
    {
      return 7;
      if (QLog.isColorLevel()) {
        QLog.d("GetFunCallData", 2, "doStep system time" + System.currentTimeMillis() + ",last update time:" + l);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetFunCallData
 * JD-Core Version:    0.7.0.1
 */