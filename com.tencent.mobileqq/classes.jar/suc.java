import android.widget.TextView;
import com.tencent.mobileqq.activity.GesturePWDUnlockActivity;

public class suc
  implements Runnable
{
  public suc(GesturePWDUnlockActivity paramGesturePWDUnlockActivity) {}
  
  public void run()
  {
    GesturePWDUnlockActivity.a(this.a).setEnabled(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     suc
 * JD-Core Version:    0.7.0.1
 */