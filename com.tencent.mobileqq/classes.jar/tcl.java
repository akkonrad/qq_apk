import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;

public class tcl
  implements DialogInterface.OnClickListener
{
  public tcl(NotificationActivity paramNotificationActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    SettingCloneUtil.writeValue(this.a.app.getApp(), null, "security_scan_key", "qqsetting_security_scan_key", true);
    this.a.app.w();
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tcl
 * JD-Core Version:    0.7.0.1
 */