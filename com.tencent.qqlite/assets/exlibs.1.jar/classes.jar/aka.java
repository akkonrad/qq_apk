import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.DoodleActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class aka
  implements View.OnClickListener
{
  public aka(DoodleActivity paramDoodleActivity) {}
  
  public void onClick(View paramView)
  {
    DialogUtil.a(this.a, this.a.getString(2131363464), 2131362801, 2131363465, new akb(this), new akc(this)).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     aka
 * JD-Core Version:    0.7.0.1
 */