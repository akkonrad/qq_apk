import com.tencent.mobileqq.activity.DevlockPushActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class aif
  implements Runnable
{
  public aif(DevlockPushActivity paramDevlockPushActivity) {}
  
  public void run()
  {
    try
    {
      if ((DevlockPushActivity.a(this.a) != null) && (DevlockPushActivity.a(this.a).isShowing()))
      {
        DevlockPushActivity.a(this.a).dismiss();
        DevlockPushActivity.a(this.a).cancel();
      }
      DevlockPushActivity.a(this.a, null);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     aif
 * JD-Core Version:    0.7.0.1
 */