import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.msgnotify.MsgNotifyPushDialog;
import com.tencent.mobileqq.statistics.ReportController;

public class zup
  implements View.OnClickListener
{
  public zup(MsgNotifyPushDialog paramMsgNotifyPushDialog) {}
  
  public void onClick(View paramView)
  {
    if (MsgNotifyPushDialog.a != null) {
      MsgNotifyPushDialog.a(this.a).startActivity(MsgNotifyPushDialog.a);
    }
    ReportController.b(null, "CliOper", "", "", "0X8006B15", "0X8006B15", 0, 0, "", "", "", "");
    paramView = PreferenceManager.getDefaultSharedPreferences(MsgNotifyPushDialog.a(this.a));
    int i = paramView.getInt("push_msg_notify_open", 0);
    paramView = paramView.edit();
    paramView.putInt("push_msg_notify_open", i + 1);
    paramView.commit();
    this.a.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zup
 * JD-Core Version:    0.7.0.1
 */