import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.selectmember.PhoneContactSelectActivity;
import com.tencent.mobileqq.qcall.PstnManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.QQCustomDialog;

class xzh
  implements DialogInterface.OnClickListener
{
  xzh(xzg paramxzg, PstnManager paramPstnManager) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramInt = 1;
    boolean bool = ((QQCustomDialog)paramDialogInterface).getCheckBoxState();
    if (bool) {
      this.jdField_a_of_type_ComTencentMobileqqQcallPstnManager.b(true);
    }
    if (!PhoneContactSelectActivity.a(this.jdField_a_of_type_Xzg.a)) {
      this.jdField_a_of_type_Xzg.a.a();
    }
    paramDialogInterface.dismiss();
    paramDialogInterface = this.jdField_a_of_type_Xzg.a.app;
    if (bool) {}
    for (;;)
    {
      ReportController.b(paramDialogInterface, "CliOper", "", "", "0X8006404", "0X8006404", paramInt, 0, "", "", "", "");
      return;
      paramInt = 2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xzh
 * JD-Core Version:    0.7.0.1
 */