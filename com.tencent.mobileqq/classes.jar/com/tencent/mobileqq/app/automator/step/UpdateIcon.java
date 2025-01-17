package com.tencent.mobileqq.app.automator.step;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.now.NowAppHelper;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.qphone.base.util.BaseApplication;

public class UpdateIcon
  extends AsyncStep
{
  protected int a()
  {
    NowAppHelper.a(this.a.b);
    if (!BaseApplication.getContext().getSharedPreferences("mobileQQ", 4).getBoolean("enableUpdateIconStep", false)) {}
    SharedPreferences localSharedPreferences;
    do
    {
      return 7;
      localSharedPreferences = this.a.b.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 0);
    } while (!localSharedPreferences.getBoolean("updateShortcutIcon7.6.3.3560", true));
    QQUtils.a(this.a.b, "sid");
    localSharedPreferences.edit().putBoolean("updateShortcutIcon7.6.3.3560", false).commit();
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.UpdateIcon
 * JD-Core Version:    0.7.0.1
 */