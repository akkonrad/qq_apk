import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.profile.view.CircularProgressBar;

public class ebf
  extends Handler
{
  public ebf(CircularProgressBar paramCircularProgressBar) {}
  
  public void handleMessage(Message paramMessage)
  {
    this.a.invalidate();
    if (CircularProgressBar.a(this.a))
    {
      CircularProgressBar.a(this.a, CircularProgressBar.a(this.a));
      if (CircularProgressBar.b(this.a) > 360) {
        CircularProgressBar.b(this.a, 0);
      }
      CircularProgressBar.a(this.a).sendEmptyMessageDelayed(0, CircularProgressBar.c(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ebf
 * JD-Core Version:    0.7.0.1
 */