import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.GesturePWDUnlockActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;

public class cvo
  implements DialogInterface.OnDismissListener
{
  public cvo(GesturePWDUnlockActivity paramGesturePWDUnlockActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.c();
    GesturePWDUtils.setGestureUnlockFailedType(this.a, 1);
    StatisticCollector.a(this.a.getBaseContext()).a(this.a.b, this.a.b.a(), "Gesture_pwd", "click_wrong_pwd", 0, 1, "0", null, null, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cvo
 * JD-Core Version:    0.7.0.1
 */