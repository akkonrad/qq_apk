import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Handler;
import android.widget.TextView;
import com.tencent.mobileqq.activity.MySelfTroopMemberCard;
import com.tencent.mobileqq.utils.QQCustomDialogWtihInput;

public class dcp
  implements DialogInterface.OnClickListener
{
  public dcp(MySelfTroopMemberCard paramMySelfTroopMemberCard) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = MySelfTroopMemberCard.a(this.a).getInputValue();
    if ((paramDialogInterface != null) && (!paramDialogInterface.equals("")) && (!paramDialogInterface.equals(this.a.a.getText()))) {
      MySelfTroopMemberCard.a(this.a).post(new dcq(this, paramDialogInterface));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dcp
 * JD-Core Version:    0.7.0.1
 */