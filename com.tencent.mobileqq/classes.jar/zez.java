import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;

public final class zez
  implements DialogInterface.OnClickListener
{
  public zez(Activity paramActivity, QQAppInterface paramQQAppInterface) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    HotChatManager.a(this.jdField_a_of_type_AndroidAppActivity, false);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004C6B", "0X8004C6B", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zez
 * JD-Core Version:    0.7.0.1
 */