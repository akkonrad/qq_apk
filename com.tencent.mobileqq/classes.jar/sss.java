import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity;

public class sss
  implements DialogInterface.OnClickListener
{
  public sss(FriendProfileMoreInfoActivity paramFriendProfileMoreInfoActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    if (this.a.l)
    {
      this.a.a("0X80081E7", 3);
      return;
    }
    this.a.a("0X80081E4", 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sss
 * JD-Core Version:    0.7.0.1
 */