import android.app.Dialog;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AddFriendVerifyActivity;
import com.tencent.mobileqq.statistics.ReportController;

public class rjq
  implements View.OnClickListener
{
  public rjq(AddFriendVerifyActivity paramAddFriendVerifyActivity, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.jdField_a_of_type_AndroidViewInputmethodInputMethodManager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.getWindow().setSoftInputMode(2);
      this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.jdField_a_of_type_AndroidWidgetEditText.getWindowToken(), 0);
      this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.jdField_a_of_type_AndroidWidgetEditText.clearFocus();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.jdField_a_of_type_AndroidWidgetEditText.getText().toString().length() > 30)
    {
      paramView = new Dialog(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity, 2131624516);
      paramView.setContentView(2130971508);
      ((TextView)paramView.findViewById(2131362776)).setText(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.getString(2131434784));
      ((ProgressBar)paramView.findViewById(2131362775)).setVisibility(8);
      ((ImageView)paramView.findViewById(2131374243)).setImageResource(2130838752);
      paramView.show();
    }
    for (;;)
    {
      return;
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.jdField_a_of_type_AndroidWidgetEditText.getText().toString().trim();
      this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.a(paramView, false);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.getString(2131434467).equals(paramView)) && (!AddFriendVerifyActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity))) {
        AddFriendVerifyActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.jdField_a_of_type_AndroidWidgetEditText.getText().toString().trim());
      if (this.jdField_a_of_type_Int == 0) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.app, "dc00898", "", "", "0X800796F", "0X800796F", 0, 0, "", "", "", "");
      }
      while (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.f))
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.app, "dc00899", "Qidian", "", "0X8008802", "ClickAddFriendButton", 0, 0, "1", "", "", "");
        return;
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.app, "dc00898", "", "", "0X8007976", "0X8007976", 0, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rjq
 * JD-Core Version:    0.7.0.1
 */