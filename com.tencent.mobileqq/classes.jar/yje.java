import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.antiphing.AntiphingHandler;
import com.tencent.qphone.base.util.QLog;

public class yje
  implements DialogInterface.OnClickListener
{
  public yje(AntiphingHandler paramAntiphingHandler) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(AntiphingHandler.a(this.a), 4, "right button is clicked! ");
    }
    AntiphingHandler.a(this.a, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     yje
 * JD-Core Version:    0.7.0.1
 */