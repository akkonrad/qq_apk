import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.av.ui.QavPanel;
import com.tencent.av.ui.QavPanelSoundWaveView;

public class jzn
  extends BroadcastReceiver
{
  public jzn(QavPanel paramQavPanel) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent == null) || (paramIntent.getAction() == null)) {}
    do
    {
      do
      {
        return;
        if (!"android.intent.action.SCREEN_ON".equals(paramIntent.getAction())) {
          break;
        }
      } while ((this.a.a == null) || (!this.a.c));
      this.a.a.f();
      return;
    } while ((!"android.intent.action.SCREEN_OFF".equals(paramIntent.getAction())) || (this.a.a == null));
    this.a.a.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jzn
 * JD-Core Version:    0.7.0.1
 */