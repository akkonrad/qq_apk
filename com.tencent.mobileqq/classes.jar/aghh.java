import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;

public class aghh
  implements DialogInterface.OnClickListener
{
  public aghh(ScanTorchActivity paramScanTorchActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aghh
 * JD-Core Version:    0.7.0.1
 */