import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.managers.TimJumpLoginManager;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import oicq.wlogin_sdk.request.WFastLoginInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.request.WtloginHelper;
import oicq.wlogin_sdk.request.WtloginListener;
import oicq.wlogin_sdk.tools.ErrMsg;

public class aefe
  extends WtloginListener
{
  public aefe(TimJumpLoginManager paramTimJumpLoginManager, QQProgressDialog paramQQProgressDialog, WtloginHelper paramWtloginHelper, Bundle paramBundle) {}
  
  public void OnException(ErrMsg paramErrMsg, int paramInt, WUserSigInfo paramWUserSigInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TimJumpLoginManager.a, 2, "jumpTimLogin OnException=" + paramErrMsg + ", cmd=" + paramInt);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    QQToast.a(TimJumpLoginManager.a(this.jdField_a_of_type_ComTencentMobileqqManagersTimJumpLoginManager).getApp(), 1, 2131439134, 0).a();
  }
  
  public void onGetA1WithA1(String paramString, long paramLong1, int paramInt1, long paramLong2, byte[] paramArrayOfByte1, long paramLong3, long paramLong4, long paramLong5, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, WUserSigInfo paramWUserSigInfo, WFastLoginInfo paramWFastLoginInfo, int paramInt2, ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TimJumpLoginManager.a, 2, "jumpTimLogin onGetA1WithA1 ret=" + paramInt2);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    if (paramInt2 != 0)
    {
      QQToast.a(TimJumpLoginManager.a(this.jdField_a_of_type_ComTencentMobileqqManagersTimJumpLoginManager).getApp(), 1, 2131439134, 0).a();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(TimJumpLoginManager.a, 2, "jumpTimLogin call TIM JumpActivity");
    }
    paramArrayOfByte1 = new Intent();
    paramArrayOfByte1.setComponent(new ComponentName("com.tencent.tim", "com.tencent.mobileqq.activity.LoginJumpTeamWorkActivity"));
    paramArrayOfByte1.setFlags(268435456);
    paramArrayOfByte1.putExtras(this.jdField_a_of_type_OicqWlogin_sdkRequestWtloginHelper.PrepareQloginResult(paramString, paramLong4, paramLong5, paramInt2, paramWFastLoginInfo));
    paramArrayOfByte1.putExtras(this.jdField_a_of_type_AndroidOsBundle);
    TimJumpLoginManager.a(this.jdField_a_of_type_ComTencentMobileqqManagersTimJumpLoginManager).getApp().startActivity(paramArrayOfByte1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aefe
 * JD-Core Version:    0.7.0.1
 */