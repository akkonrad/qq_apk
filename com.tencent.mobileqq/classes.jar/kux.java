import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.biz.pubaccount.Advertisement.view.AdControlView;

public class kux
  extends AnimatorListenerAdapter
{
  public kux(AdControlView paramAdControlView) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    super.onAnimationCancel(paramAnimator);
    this.a.b = false;
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    this.a.b = false;
    this.a.setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kux
 * JD-Core Version:    0.7.0.1
 */