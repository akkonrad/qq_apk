import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.apollo.game.ApolloWebGameActivity;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class ypu
  implements DialogInterface.OnClickListener
{
  public ypu(ApolloWebGameActivity paramApolloWebGameActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ApolloWebGameActivity.a(this.a).dismiss();
    ApolloWebGameActivity.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ypu
 * JD-Core Version:    0.7.0.1
 */