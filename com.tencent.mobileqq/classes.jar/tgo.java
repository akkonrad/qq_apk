import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.ProfileCardMoreActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import mqq.os.MqqHandler;

public class tgo
  implements ActionSheet.OnButtonClickListener
{
  public tgo(ProfileCardMoreActivity paramProfileCardMoreActivity, String paramString, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.d();
      return;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityProfileCardMoreActivity.app, "CliOper", "", "", "P_prof", "Pp_more_delete", ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileCardMoreActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h), 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileCardMoreActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
      if (NetworkUtil.d(BaseApplication.getContext()))
      {
        ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqActivityProfileCardMoreActivity.app.a(1)).c(this.jdField_a_of_type_JavaLangString, (byte)2);
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityProfileCardMoreActivity.app.getHandler(ChatActivity.class);
        if (paramView != null) {
          paramView.sendMessage(paramView.obtainMessage(16711681, this.jdField_a_of_type_JavaLangString));
        }
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityProfileCardMoreActivity.app.getHandler(ChatSettingActivity.class);
        if (paramView != null) {
          paramView.sendMessage(paramView.obtainMessage(16711681, this.jdField_a_of_type_JavaLangString));
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileCardMoreActivity.jdField_a_of_type_AndroidContentIntent == null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityProfileCardMoreActivity.jdField_a_of_type_AndroidContentIntent = new Intent();
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityProfileCardMoreActivity.jdField_a_of_type_AndroidContentIntent.putExtra("finchat", true);
        this.jdField_a_of_type_ComTencentMobileqqActivityProfileCardMoreActivity.setResult(-1, this.jdField_a_of_type_ComTencentMobileqqActivityProfileCardMoreActivity.jdField_a_of_type_AndroidContentIntent);
        if (Utils.b(this.jdField_a_of_type_JavaLangString)) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityProfileCardMoreActivity.app, "dc00898", "", "", "0X8007FDF", "0X8007FDF", 0, 0, "", "", "", "");
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityProfileCardMoreActivity.finish();
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityProfileCardMoreActivity.a(2131433260, 1);
        continue;
        if (Utils.b(this.jdField_a_of_type_JavaLangString)) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityProfileCardMoreActivity.app, "dc00898", "", "", "0X8007FE0", "0X8007FE0", 0, 0, "", "", "", "");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tgo
 * JD-Core Version:    0.7.0.1
 */