import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.UpgradeActivity;
import com.tencent.mobileqq.app.upgrade.UpgradeConstants;
import com.tencent.mobileqq.app.upgrade.UpgradeController;
import com.tencent.mobileqq.statistics.ReportController;

public class ugg
  implements DialogInterface.OnClickListener
{
  public ugg(UpgradeActivity paramUpgradeActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    UpgradeActivity.a(this.a, false);
    ReportController.b(this.a.app, "CliOper", "", "", "0X8004DA1", "0X8004DA1", 0, 0, UpgradeConstants.b(), String.valueOf(0), UpgradeController.a(), "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ugg
 * JD-Core Version:    0.7.0.1
 */