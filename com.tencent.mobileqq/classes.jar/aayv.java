import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.API.ArkAppModuleReg.ModuleQQ;
import com.tencent.mobileqq.ark.setting.ArkAuthorityInfoActivity;

public class aayv
  implements CompoundButton.OnCheckedChangeListener
{
  public aayv(ArkAuthorityInfoActivity paramArkAuthorityInfoActivity, int paramInt) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton = ArkAuthorityInfoActivity.a(this.jdField_a_of_type_ComTencentMobileqqArkSettingArkAuthorityInfoActivity);
    String str1 = ArkAuthorityInfoActivity.a()[this.jdField_a_of_type_Int];
    String str2 = this.jdField_a_of_type_ComTencentMobileqqArkSettingArkAuthorityInfoActivity.app.getCurrentAccountUin();
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      ArkAppModuleReg.ModuleQQ.a(paramCompoundButton, str1, str2, i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aayv
 * JD-Core Version:    0.7.0.1
 */