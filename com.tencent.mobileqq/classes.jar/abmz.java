import android.app.Dialog;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.businessCard.activity.BusinessCardEditActivity;
import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.mobileqq.businessCard.utilities.BusinessCardUtils;
import com.tencent.mobileqq.statistics.ReportController;

public class abmz
  implements View.OnClickListener
{
  public abmz(BusinessCardEditActivity paramBusinessCardEditActivity) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.jdField_a_of_type_AndroidAppDialog != null) && (this.a.jdField_a_of_type_AndroidAppDialog.isShowing()))
    {
      this.a.jdField_a_of_type_AndroidAppDialog.dismiss();
      this.a.jdField_a_of_type_AndroidAppDialog = null;
    }
    if (this.a.jdField_a_of_type_Int == 0) {
      ReportController.b(this.a.app, "CliOper", "", "", "0X80064E3", "0X80064E3", 0, 0, "", "", "", "");
    }
    while ((this.a.jdField_a_of_type_Boolean) && (this.a.b) && (!this.a.isFinishing()))
    {
      this.a.finish();
      return;
      if (this.a.getIntent().getIntExtra("source_activity", 0) == 1) {
        ReportController.b(this.a.app, "CliOper", "", "", "0X80064EE", "0X80064EE", 0, 0, "", "", "", "");
      }
    }
    if (this.a.c)
    {
      BusinessCardUtils.a(this.a.app.getCurrentAccountUin(), -1);
      this.a.c = false;
    }
    if ((this.a.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard == null) || (TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.cardId)))
    {
      this.a.finish();
      return;
    }
    BusinessCardEditActivity.a(this.a, false, true, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abmz
 * JD-Core Version:    0.7.0.1
 */