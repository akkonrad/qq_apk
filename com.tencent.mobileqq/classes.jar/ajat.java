import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.troop.browser.TroopWebviewPlugin;

public class ajat
  implements DialogInterface.OnDismissListener
{
  public ajat(TroopWebviewPlugin paramTroopWebviewPlugin) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (paramDialogInterface == this.a.a) {
      this.a.a = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajat
 * JD-Core Version:    0.7.0.1
 */