import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.ark.setting.ArkAppListActivity;
import com.tencent.mobileqq.ark.setting.ArkAuthorityInfoActivity;

public class aayu
  implements View.OnClickListener
{
  public aayu(ArkAppListActivity paramArkAppListActivity, String paramString) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqArkSettingArkAppListActivity, ArkAuthorityInfoActivity.class);
    paramView.putExtra("intent_extra_authority_app_name", this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqArkSettingArkAppListActivity.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aayu
 * JD-Core Version:    0.7.0.1
 */