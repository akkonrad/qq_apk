import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.vashealth.SportManager;
import mqq.observer.BusinessObserver;

public class akkf
  implements BusinessObserver
{
  public akkf(SportManager paramSportManager) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean) {
      ThreadManager.post(new akkg(this, paramBundle.getString("StepInfoJSON")), 5, null, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akkf
 * JD-Core Version:    0.7.0.1
 */