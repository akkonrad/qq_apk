import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayTribePanel;
import com.tencent.mobileqq.statistics.ReportController;

public class affl
  implements DialogInterface.OnClickListener
{
  public affl(NearbyProfileDisplayTribePanel paramNearbyProfileDisplayTribePanel) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.d(true);
    ReportController.b(null, "dc00899", "grp_lbs", "", "data_like", "clk_entry", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     affl
 * JD-Core Version:    0.7.0.1
 */