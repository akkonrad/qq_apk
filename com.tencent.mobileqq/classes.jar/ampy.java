import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqindividuality.QQIndividualityBridgeActivity;

public class ampy
  implements DialogInterface.OnDismissListener
{
  public ampy(QQIndividualityBridgeActivity paramQQIndividualityBridgeActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.a.a) {
      QQIndividualityBridgeActivity.b(this.a);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQIndividuality", 2, "dialog dismiss: " + this.a.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ampy
 * JD-Core Version:    0.7.0.1
 */