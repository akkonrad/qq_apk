import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.ProfileCardMoreActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class bbm
  implements Runnable
{
  public bbm(ProfileCardMoreActivity paramProfileCardMoreActivity) {}
  
  public void run()
  {
    try
    {
      i = ProfileCardMoreActivity.a(this.a, this.a.a.a);
      ProfileCardMoreActivity.a(this.a, false);
      this.a.app.runOnUiThread(new bbn(this, i));
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i = -1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bbm
 * JD-Core Version:    0.7.0.1
 */