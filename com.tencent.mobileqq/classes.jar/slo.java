import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.EditActivity;

public class slo
  implements View.OnClickListener
{
  public slo(EditActivity paramEditActivity) {}
  
  public void onClick(View paramView)
  {
    if ((EditActivity.a(this.a) != null) && (EditActivity.a(this.a).isShowing()) && (EditActivity.a(this.a).getWindow() != null)) {
      EditActivity.a(this.a).dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     slo
 * JD-Core Version:    0.7.0.1
 */