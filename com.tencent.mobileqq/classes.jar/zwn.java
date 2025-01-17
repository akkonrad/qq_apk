import android.content.Intent;
import com.tencent.mobileqq.activity.UpgradeActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.NewUpgradeConfig;
import com.tencent.mobileqq.app.NewUpgradeConfig.Dialog;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.upgrade.UpgradeController;
import com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import protocol.KQQConfig.UpgradeInfo;

public class zwn
  implements Runnable
{
  public zwn(UpgradeController paramUpgradeController, boolean paramBoolean, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    if ((UpgradeController.a(this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeController) == null) || (UpgradeController.a(this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeController).jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig == null) || (UpgradeController.a(this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeController).jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig.dialog == null)) {
      QLog.d("UpgradeController", 1, "showUpgradeDialog fail, invalid param.");
    }
    Intent localIntent;
    do
    {
      return;
      Object localObject = UpgradeController.a(this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeController).jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig.dialog;
      localIntent = new Intent(BaseApplication.getContext(), UpgradeActivity.class);
      localIntent.putExtra("StrTitle", ((NewUpgradeConfig.Dialog)localObject).jdField_b_of_type_JavaLangString);
      localIntent.putExtra("StrUpgradeDesc", ((NewUpgradeConfig.Dialog)localObject).c);
      if (this.jdField_a_of_type_Boolean) {
        localIntent.putExtra("strDesc", ((NewUpgradeConfig.Dialog)localObject).d);
      }
      localIntent.putExtra("lBtnText", ((NewUpgradeConfig.Dialog)localObject).i);
      localIntent.putExtra("rBtnText", ((NewUpgradeConfig.Dialog)localObject).j);
      localIntent.putExtra("StrUrl", "");
      localIntent.putExtra("iUpgradeType", UpgradeController.a(this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeController).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iUpgradeType);
      localIntent.putExtra("iTipsType", UpgradeController.a(this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeController).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iTipsType);
      localIntent.putExtra("strConfirmBtnText", UpgradeController.a(this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeController).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.strButtonDesc);
      localIntent.putExtra("strCancelButtonDesc", UpgradeController.a(this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeController).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.strCancelButtonDesc);
      localIntent.putExtra("iUpgradeSdkId", UpgradeController.a(this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeController).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iUpgradeSdkId);
      if ((UpgradeController.a(this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeController).jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig != null) && (UpgradeController.a(this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeController).jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig.dialog != null)) {
        localIntent.putExtra("rate", UpgradeController.a(this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeController).jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig.dialog.jdField_b_of_type_Int);
      }
      localIntent.putExtra("activity_type", 4096);
      localIntent.putExtra("mode", 0);
      localObject = ConfigHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp());
      if ((localObject != null) && (((String)localObject).equals("com.tencent.mobileqq.activity.UserguideActivity")))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a = localIntent;
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a = null;
    } while (BaseActivity.sTopActivity == null);
    BaseActivity.sTopActivity.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zwn
 * JD-Core Version:    0.7.0.1
 */