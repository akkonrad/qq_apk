import android.os.Bundle;
import com.tencent.mobileqq.troop.activity.RecommendTroopAdapter;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

public class aiuw
  implements BusinessObserver
{
  public aiuw(RecommendTroopAdapter paramRecommendTroopAdapter) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("RecommendTroopAdapter", 4, "delRecommendTroop");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiuw
 * JD-Core Version:    0.7.0.1
 */