import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ChatSettingActivity;

public class sbx
  implements DialogInterface.OnClickListener
{
  public sbx(ChatSettingActivity paramChatSettingActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.finish();
    if ((ChatSettingActivity.a(this.a) != null) && (ChatSettingActivity.a(this.a).isShowing())) {
      ChatSettingActivity.a(this.a).dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sbx
 * JD-Core Version:    0.7.0.1
 */