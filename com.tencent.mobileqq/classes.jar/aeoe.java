import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.mobileqq.nearby.gameroom.GameRoomInviteActivity;
import com.tencent.mobileqq.widget.QQToast;

public class aeoe
  implements View.OnClickListener
{
  public aeoe(GameRoomInviteActivity paramGameRoomInviteActivity) {}
  
  public void onClick(View paramView)
  {
    if (!NetworkUtils.isNetworkAvailable(this.a))
    {
      QQToast.a(this.a, 1, 2131434811, 1).a();
      return;
    }
    this.a.d();
    this.a.a("invite_page", "clk_exit");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aeoe
 * JD-Core Version:    0.7.0.1
 */