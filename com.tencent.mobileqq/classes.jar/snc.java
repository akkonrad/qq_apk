import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.FontSettingActivity;
import com.tencent.mobileqq.app.FontSettingManager;

public class snc
  implements View.OnClickListener
{
  public snc(FontSettingActivity paramFontSettingActivity) {}
  
  public void onClick(View paramView)
  {
    if (FontSettingManager.a(this.a, FontSettingActivity.a(this.a), true)) {
      FontSettingManager.a();
    }
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     snc
 * JD-Core Version:    0.7.0.1
 */