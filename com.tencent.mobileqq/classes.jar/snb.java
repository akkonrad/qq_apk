import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.FontSettingActivity;

public class snb
  implements View.OnClickListener
{
  public snb(FontSettingActivity paramFontSettingActivity) {}
  
  public void onClick(View paramView)
  {
    FontSettingActivity.a(this.a).dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     snb
 * JD-Core Version:    0.7.0.1
 */