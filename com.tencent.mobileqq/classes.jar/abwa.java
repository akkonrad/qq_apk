import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.database.corrupt.DBFixDialogUI;
import com.tencent.mobileqq.database.corrupt.DBFixManager;
import com.tencent.mobileqq.statistics.ReportController;
import mqq.app.MobileQQ;

public class abwa
  implements DialogInterface.OnClickListener
{
  public abwa(DBFixDialogUI paramDBFixDialogUI) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.cancel();
    DBFixDialogUI.a(this.a).b();
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences(DBFixManager.b, 0).edit().remove(this.a.jdField_a_of_type_JavaLangString + DBFixManager.g).commit();
    ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.a.jdField_a_of_type_JavaLangString, DBFixDialogUI.f, DBFixDialogUI.f, 0, 0, "", "", "", "");
    DBFixDialogUI.a(this.a).c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abwa
 * JD-Core Version:    0.7.0.1
 */