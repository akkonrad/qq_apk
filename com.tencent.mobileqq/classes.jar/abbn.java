import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.armap.ARMapActivity;

public class abbn
  implements DialogInterface.OnClickListener
{
  public abbn(ARMapActivity paramARMapActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.startActivity(new Intent("android.settings.WIFI_SETTINGS"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abbn
 * JD-Core Version:    0.7.0.1
 */