import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import cooperation.qqdataline.ipc.DatalineRemoteManager;

public class amoq
  implements DialogInterface.OnDismissListener
{
  public amoq(DatalineRemoteManager paramDatalineRemoteManager) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (!this.a.b) {
      DatalineRemoteManager.a(this.a, 1);
    }
    this.a.b = false;
    this.a.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amoq
 * JD-Core Version:    0.7.0.1
 */