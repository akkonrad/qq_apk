import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Handler;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mobileqq.activity.TroopMemberListActivity;

public class dwp
  implements DialogInterface.OnDismissListener
{
  public dwp(TroopMemberListActivity paramTroopMemberListActivity, TranslateAnimation paramTranslateAnimation, InputMethodManager paramInputMethodManager) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.findViewById(2131234620).getHandler().postDelayed(new dwq(this), 150L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dwp
 * JD-Core Version:    0.7.0.1
 */