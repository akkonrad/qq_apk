import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NewUpgradeDialog;
import com.tencent.open.appcircle.st.AppCircleReportManager;
import com.tencent.open.appcircle.st.STUtils;
import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.DownloadManager;

public class akdc
  implements View.OnClickListener
{
  public akdc(NewUpgradeDialog paramNewUpgradeDialog, DialogInterface.OnClickListener paramOnClickListener, boolean paramBoolean) {}
  
  public void onClick(View paramView)
  {
    LogUtility.b("NewUpgradeDialog", STUtils.a(10010, NewUpgradeDialog.a(), 2, 200));
    AppCircleReportManager.a().a(17, STUtils.a(10010, NewUpgradeDialog.a(), 2, 200));
    if (NewUpgradeDialog.a() == 2) {
      ReportController.b(null, "dc00898", "", "", "0X8008F80", "0X8008F80", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null) {
        this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(this.jdField_a_of_type_ComTencentMobileqqUtilsNewUpgradeDialog, 0);
      }
      if (this.jdField_a_of_type_Boolean)
      {
        DownloadManager.a().b(NewUpgradeDialog.a(this.jdField_a_of_type_ComTencentMobileqqUtilsNewUpgradeDialog));
        this.jdField_a_of_type_ComTencentMobileqqUtilsNewUpgradeDialog.dismiss();
      }
      NewUpgradeDialog.a(this.jdField_a_of_type_ComTencentMobileqqUtilsNewUpgradeDialog, true);
      return;
      ReportController.b(null, "dc00898", "", "", "0X8008F83", "0X8008F83", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     akdc
 * JD-Core Version:    0.7.0.1
 */