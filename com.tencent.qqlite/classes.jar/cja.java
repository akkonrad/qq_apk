import android.view.View;
import com.tencent.mobileqq.activity.phone.SettingActivity2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class cja
  implements ActionSheet.OnButtonClickListener
{
  public cja(SettingActivity2 paramSettingActivity2, ActionSheet paramActionSheet) {}
  
  public void a(View paramView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet.cancel();
    if (!NetworkUtil.e(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneSettingActivity2))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhoneSettingActivity2.b(2131363461);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhoneSettingActivity2.b == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhoneSettingActivity2.b = new cjb(this);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhoneSettingActivity2.app.registObserver(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneSettingActivity2.b);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhoneSettingActivity2.a.d();
    this.jdField_a_of_type_ComTencentMobileqqActivityPhoneSettingActivity2.b(2131363392, 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cja
 * JD-Core Version:    0.7.0.1
 */