import android.os.Handler;
import com.tencent.mobileqq.activity.voip.VoipDialInterface;

public class eyg
  implements Runnable
{
  public eyg(VoipDialInterface paramVoipDialInterface) {}
  
  public void run()
  {
    VoipDialInterface.a(this.a);
    VoipDialInterface.a(this.a).postDelayed(this, 1000L);
    VoipDialInterface.b(this.a).sendEmptyMessage(100);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     eyg
 * JD-Core Version:    0.7.0.1
 */