package com.tencent.mobileqq.ar;

import android.content.Intent;
import android.os.IBinder;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ar.aidl.IArGlobalConfigManager.Stub;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppService;
import zxh;

public class ARGlobalConfigService
  extends AppService
{
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  public ARGlobalConfigManager a;
  private IArGlobalConfigManager.Stub jdField_a_of_type_ComTencentMobileqqArAidlIArGlobalConfigManager$Stub = new zxh(this);
  
  public void onAccountChanged()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime());
    this.jdField_a_of_type_ComTencentMobileqqArARGlobalConfigManager = ((ARGlobalConfigManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(219));
    if (QLog.isColorLevel()) {
      QLog.d("ARGlobalConfigService", 2, "onAccountChanged");
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARGlobalConfigService", 2, "onBind");
    }
    return this.jdField_a_of_type_ComTencentMobileqqArAidlIArGlobalConfigManager$Stub;
  }
  
  public void onCreate()
  {
    super.onCreate();
    if ((this.app instanceof QQAppInterface))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.app);
      this.jdField_a_of_type_ComTencentMobileqqArARGlobalConfigManager = ((ARGlobalConfigManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(219));
    }
    if (QLog.isColorLevel()) {
      QLog.d("ARGlobalConfigService", 2, "onCreate");
    }
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARGlobalConfigService", 2, "onDestroy");
    }
    super.onDestroy();
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARGlobalConfigService", 2, "onUnbind");
    }
    return super.onUnbind(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARGlobalConfigService
 * JD-Core Version:    0.7.0.1
 */