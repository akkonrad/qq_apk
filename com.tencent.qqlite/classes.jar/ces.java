import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.main.MainAssistObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

public class ces
  extends Handler
{
  public ces(MainAssistObserver paramMainAssistObserver, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity == null) || (this.a.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app == null) || (!this.a.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.isLogin())) {}
    do
    {
      do
      {
        return;
        switch (paramMessage.what)
        {
        default: 
          return;
        }
        paramMessage = paramMessage.getData();
      } while (paramMessage == null);
      int i = paramMessage.getInt("result");
      if ((i == -1) || (i == -2))
      {
        if (i == -1) {
          paramMessage = this.a.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getString(2131363005);
        }
        for (String str = this.a.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getString(2131363006);; str = this.a.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getString(2131363008))
        {
          try
          {
            if (this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null)
            {
              if (this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()) {
                this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
              }
              this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
            }
            this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, 230, paramMessage, str, new cet(this), null);
            this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnCancelListener(new ceu(this));
            this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnDismissListener(new cev(this));
            this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
            return;
          }
          catch (Exception paramMessage) {}
          if (!QLog.isColorLevel()) {
            break;
          }
          paramMessage.printStackTrace();
          return;
          paramMessage = this.a.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getString(2131363007);
        }
      }
    } while (this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null);
    this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     ces
 * JD-Core Version:    0.7.0.1
 */