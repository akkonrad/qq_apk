import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import com.tencent.util.AnimateUtils.AnimationAdapter;

class mkb
  extends AnimateUtils.AnimationAdapter
{
  mkb(mka parammka) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = new ScaleAnimation(0.95F, 1.0F, 0.95F, 1.0F, 1, 0.5F, 1, 0.5F);
    paramAnimation.setDuration(60L);
    paramAnimation.setAnimationListener(new mkc(this));
    this.a.a.a.a.startAnimation(paramAnimation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mkb
 * JD-Core Version:    0.7.0.1
 */