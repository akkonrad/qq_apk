import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.observer.BusinessObserver;

class xhy
  implements BusinessObserver
{
  xhy(xhx paramxhx, long paramLong) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    ThreadManager.postImmediately(new xhz(this, paramBoolean, paramBundle, paramInt), null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xhy
 * JD-Core Version:    0.7.0.1
 */