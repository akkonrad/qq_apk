package com.tencent.mobileqq.app.automator.step;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.model.QZoneManager;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;

public class NotifyQZoneServer
  extends AsyncStep
{
  protected int a()
  {
    if (!this.a.b.isBackground_Pause)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NotifyQZoneServer", 2, "isBackground_Pause:" + this.a.b.isBackground_Pause);
      }
      return super.a();
    }
    int i = QzoneConfig.getInstance().getConfig("QZoneSetting", "ClientOnlineColdTime", 300);
    Object localObject2 = BaseApplicationImpl.getApplication().getSharedPreferences("QZoneOnLineServlet", 0);
    Object localObject1 = this.a.c();
    long l1 = ((SharedPreferences)localObject2).getLong("lastReqTime" + (String)localObject1, 0L);
    long l2 = System.currentTimeMillis();
    long l3 = l2 - l1;
    if (QLog.isDevelopLevel()) {
      QLog.d("NotifyQZoneServer", 4, "lastReqTime(ms):" + l1 + ",currentTime(ms):" + l2 + "divTime(ms):" + l3 + ",coldTime(ms):" + i * 1000);
    }
    if (l3 > i * 1000)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("NotifyQZoneServer", 4, "saveReqTime:" + l2);
      }
      localObject2 = ((SharedPreferences)localObject2).edit();
      ((SharedPreferences.Editor)localObject2).putLong("lastReqTime" + (String)localObject1, l2);
      if (Build.VERSION.SDK_INT < 9) {
        break label328;
      }
      ((SharedPreferences.Editor)localObject2).apply();
    }
    for (;;)
    {
      localObject1 = (QZoneManager)this.a.b.getManager(9);
      if (localObject1 != null) {
        ((QZoneManager)localObject1).a();
      }
      return super.a();
      label328:
      ((SharedPreferences.Editor)localObject2).commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.NotifyQZoneServer
 * JD-Core Version:    0.7.0.1
 */