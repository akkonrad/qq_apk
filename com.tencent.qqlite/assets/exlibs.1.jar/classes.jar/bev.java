import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQSetting;

class bev
  implements View.OnClickListener
{
  bev(beu parambeu) {}
  
  public void onClick(View paramView)
  {
    if ((QQSetting.a(this.a.a) != null) && (QQSetting.a(this.a.a).isShowing())) {
      QQSetting.a(this.a.a).dismiss();
    }
    QQSetting.a(this.a.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bev
 * JD-Core Version:    0.7.0.1
 */