import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.LinearLayout;
import com.tencent.biz.qqstory.playvideo.player.ExploreAnimalView;

public class noy
  implements Animation.AnimationListener
{
  public noy(ExploreAnimalView paramExploreAnimalView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.a.startAnimation(this.a.b);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     noy
 * JD-Core Version:    0.7.0.1
 */