import android.os.Bundle;
import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity;
import com.tencent.mobileqq.observer.GameCenterObserver;

public class wrz
  extends GameCenterObserver
{
  public wrz(AvatarPendantActivity paramAvatarPendantActivity) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    AvatarPendantActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wrz
 * JD-Core Version:    0.7.0.1
 */