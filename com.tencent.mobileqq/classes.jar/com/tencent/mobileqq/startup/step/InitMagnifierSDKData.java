package com.tencent.mobileqq.startup.step;

import aiev;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mfsdk.LeakInspector.LeakInspector.InspectUUID;
import com.tencent.mfsdk.MagnifierSDK;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.cooperation.ApkUtils;
import com.tencent.qphone.base.util.QLog;

public class InitMagnifierSDKData
  extends Step
{
  private int a;
  
  private static boolean b(LeakInspector.InspectUUID paramInspectUUID)
  {
    paramInspectUUID = BaseApplicationImpl.getApplication().getProcessName();
    QLog.e("LeakInspector", 2, "afterInspect, process : " + paramInspectUUID);
    if (!AppSetting.c) {}
    return false;
  }
  
  protected boolean a()
  {
    Object localObject = "V 7.6.3." + ApkUtils.a(BaseApplicationImpl.sApplication);
    if (QLog.isColorLevel()) {
      QLog.i("InitMagnifierSDK", 4, "init MagnifierSDK: process =  verson = " + (String)localObject);
    }
    localObject = MagnifierSDK.a(ThreadManager.getSubThreadHandler(), this.a, (String)localObject);
    ((MagnifierSDK)localObject).a(new aiev());
    ((MagnifierSDK)localObject).a(BaseApplicationImpl.getApplication());
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.InitMagnifierSDKData
 * JD-Core Version:    0.7.0.1
 */