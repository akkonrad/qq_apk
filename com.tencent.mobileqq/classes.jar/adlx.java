import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.forward.ForwardAbility.ForwardAbilityType;
import com.tencent.mobileqq.forward.ForwardSdkShareOption;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;

public class adlx
  implements DialogInterface.OnClickListener
{
  public adlx(ForwardSdkShareOption paramForwardSdkShareOption) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      if (ForwardSdkShareOption.a(this.a))
      {
        this.a.jdField_a_of_type_AndroidOsBundle.putString("uin", String.valueOf("-1010"));
        this.a.jdField_a_of_type_AndroidOsBundle.putInt("uintype", -1);
        this.a.jdField_a_of_type_AndroidOsBundle.putInt("key_forward_ability_type", ForwardAbility.ForwardAbilityType.e.intValue());
        this.a.j();
      }
      StatisticCollector.a(BaseApplication.getContext()).a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "", "multi_account", "click_next", 0, 1, 0);
    }
    while (paramInt != 0) {
      return;
    }
    paramDialogInterface = this.a.jdField_a_of_type_AndroidAppActivity;
    Activity localActivity = this.a.jdField_a_of_type_AndroidAppActivity;
    paramDialogInterface.setResult(0);
    StatisticCollector.a(BaseApplication.getContext()).a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "", "multi_account", "click_cancel", 0, 1, 0);
    this.a.jdField_a_of_type_AndroidAppActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adlx
 * JD-Core Version:    0.7.0.1
 */