import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.mobileqq.activity.AddFriendVerifyActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;

public class rim
  implements View.OnClickListener
{
  public rim(AddFriendVerifyActivity paramAddFriendVerifyActivity, EditText paramEditText, int paramInt1, int paramInt2) {}
  
  public void onClick(View paramView)
  {
    if ("".equals(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().trim())) {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.getString(2131434473), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.getTitleBarHeight());
    }
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.app, "dc00898", "", "", "0X80077B4", "0X80077B4", 0, 0, "", "", "", "");
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.f)) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.app, "dc00899", "Qidian", "", "0X8008802", "ClickAddFriendButton", 0, 1, "", "", "", "");
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.a(this.b, this.jdField_a_of_type_Int);
      return;
      if (NetworkUtil.d(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity))
      {
        paramView = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.app.a(1);
        String str1 = this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.getIntent().getStringExtra("extra");
        String str2 = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().trim();
        int i = this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.getIntent().getIntExtra("sub_source_id", 0);
        String str3 = this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.getIntent().getStringExtra("src_name");
        paramView.a(AddFriendVerifyActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity), str1, this.jdField_a_of_type_Int, (byte)0, str2, this.b, i, false, null, false, null, str3);
      }
      else
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity, 1, this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.getString(2131434811), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.getTitleBarHeight());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rim
 * JD-Core Version:    0.7.0.1
 */