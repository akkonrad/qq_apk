import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mobileqq.activity.PhoneUnityBindInfoActivity;

public class tfu
  implements DialogInterface.OnCancelListener
{
  public tfu(PhoneUnityBindInfoActivity paramPhoneUnityBindInfoActivity) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tfu
 * JD-Core Version:    0.7.0.1
 */