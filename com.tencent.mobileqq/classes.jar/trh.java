import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.activity.SecurityPickproofActivity;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;

public class trh
  implements Runnable
{
  public trh(SecurityPickproofActivity paramSecurityPickproofActivity) {}
  
  public void run()
  {
    SecurityPickproofActivity.a(this.a, false);
    FMToastUtil.a(2131434613);
    SecurityPickproofActivity.a(this.a).setText(SecurityPickproofActivity.a(this.a));
    SecurityPickproofActivity.b(this.a).setVisibility(0);
    SecurityPickproofActivity.a(this.a).setVisibility(0);
    SecurityPickproofActivity.a(this.a).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     trh
 * JD-Core Version:    0.7.0.1
 */