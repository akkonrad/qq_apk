import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.activity.TroopMemberListActivity;

public class uam
  implements View.OnTouchListener
{
  public uam(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1)
    {
      this.a.j();
      paramView = this.a.n;
      this.a.a("Clk_find", paramView, "");
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uam
 * JD-Core Version:    0.7.0.1
 */