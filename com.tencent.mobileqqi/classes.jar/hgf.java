import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.utils.JumpAction;

public class hgf
  implements DialogInterface.OnDismissListener
{
  public hgf(JumpAction paramJumpAction) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if ((JumpAction.a(this.a) instanceof LoginActivity)) {
      ((LoginActivity)JumpAction.a(this.a)).finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hgf
 * JD-Core Version:    0.7.0.1
 */