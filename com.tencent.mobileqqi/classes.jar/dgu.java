import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.biz.ui.CustomMenuBar;
import com.tencent.mobileqq.activity.PublicAccountChatActivity;

public class dgu
  implements View.OnClickListener
{
  public dgu(PublicAccountChatActivity paramPublicAccountChatActivity) {}
  
  public void onClick(View paramView)
  {
    PublicAccountChatActivity.a(this.a).setVisibility(8);
    if (this.a.a != null) {
      this.a.a.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     dgu
 * JD-Core Version:    0.7.0.1
 */