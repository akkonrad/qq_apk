import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.voip.VoipDialInterface;
import com.tencent.mobileqq.activity.voip.VoipDialInterfaceActivity;

public class ezx
  implements View.OnClickListener
{
  public ezx(VoipDialInterfaceActivity paramVoipDialInterfaceActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.a.a("6");
    VoipDialInterfaceActivity.a(this.a, '6');
    if (VoipDialInterfaceActivity.b(this.a)) {
      new Thread(new ezy(this)).start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     ezx
 * JD-Core Version:    0.7.0.1
 */