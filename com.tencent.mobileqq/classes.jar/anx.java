import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout;
import com.qq.im.poi.LbsStrangerPoiDialog;

public class anx
  implements Animation.AnimationListener
{
  public anx(LbsStrangerPoiDialog paramLbsStrangerPoiDialog) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.b.setVisibility(8);
    this.a.dismiss();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     anx
 * JD-Core Version:    0.7.0.1
 */