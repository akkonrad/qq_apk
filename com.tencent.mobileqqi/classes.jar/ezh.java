import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.voip.VoipDialInterface;
import com.tencent.mobileqq.activity.voip.VoipDialInterfaceActivity;

public class ezh
  implements View.OnClickListener
{
  public ezh(VoipDialInterfaceActivity paramVoipDialInterfaceActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.a.a("1");
    VoipDialInterfaceActivity.a(this.a, '1');
    if (VoipDialInterfaceActivity.b(this.a)) {
      new Thread(new ezi(this)).start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     ezh
 * JD-Core Version:    0.7.0.1
 */