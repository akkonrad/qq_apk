import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.armap.map.ARGridMapViewDialog;

public class abgk
  implements Animation.AnimationListener
{
  public abgk(ARGridMapViewDialog paramARGridMapViewDialog) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.a.setVisibility(8);
    this.a.dismiss();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abgk
 * JD-Core Version:    0.7.0.1
 */