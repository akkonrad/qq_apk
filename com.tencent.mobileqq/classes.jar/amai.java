import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import com.tencent.widget.ActionSheet;

public class amai
  implements Runnable
{
  public amai(ActionSheet paramActionSheet) {}
  
  public void run()
  {
    ActionSheet.a(this.a, new TranslateAnimation(0.0F, 0.0F, 0.0F, ActionSheet.a(this.a).getHeight()));
    ActionSheet.a(this.a).setDuration(200L);
    ActionSheet.a(this.a).setFillAfter(true);
    ActionSheet.a(this.a).startAnimation(ActionSheet.a(this.a));
    ActionSheet.a(this.a).setAnimationListener(new amaj(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amai
 * JD-Core Version:    0.7.0.1
 */