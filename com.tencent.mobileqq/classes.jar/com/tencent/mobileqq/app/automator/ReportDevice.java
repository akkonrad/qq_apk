package com.tencent.mobileqq.app.automator;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;

public class ReportDevice
  extends AsyncStep
{
  protected int a()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.sApplication;
    Object localObject = localBaseApplicationImpl.getSharedPreferences("mobileQQ", 0);
    if (((SharedPreferences)localObject).getInt("needDoReportAppDeviceStat", 0) == 1) {}
    for (;;)
    {
      try
      {
        StatisticCollector.a(BaseApplication.getContext()).d("");
        localObject = ((SharedPreferences)localObject).edit();
        ((SharedPreferences.Editor)localObject).putInt("needDoReportAppDeviceStat", 0);
        ((SharedPreferences.Editor)localObject).commit();
        return 7;
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
        continue;
      }
      int j = localException1.getInt("firstTimeCollectpdInt", 0);
      try
      {
        i = localBaseApplicationImpl.getPackageManager().getPackageInfo(localBaseApplicationImpl.getPackageName(), 0).versionCode;
        if ((j != 0) && (i == j)) {
          continue;
        }
        SharedPreferences.Editor localEditor = localException1.edit();
        localEditor.putInt("firstTimeCollectpdInt", i);
        localEditor.putInt("needDoReportAppDeviceStat", 1);
        localEditor.commit();
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          localException2.printStackTrace();
          int i = 0;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.ReportDevice
 * JD-Core Version:    0.7.0.1
 */