import android.content.Intent;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.StrangerChatPie;
import com.tencent.mobileqq.app.BaseActivity;

class vzn
  implements Runnable
{
  vzn(vzm paramvzm) {}
  
  public void run()
  {
    Intent localIntent = this.a.a.a().getIntent();
    localIntent.putExtra("uinname", this.a.a.a.d);
    this.a.a.b(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vzn
 * JD-Core Version:    0.7.0.1
 */