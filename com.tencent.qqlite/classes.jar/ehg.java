import android.os.Handler;
import com.tencent.mobileqq.transfile.NetworkCenter;

public class ehg
  implements Runnable
{
  public ehg(NetworkCenter paramNetworkCenter) {}
  
  public void run()
  {
    this.a.b();
    NetworkCenter.a(this.a).postDelayed(this, 120000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     ehg
 * JD-Core Version:    0.7.0.1
 */