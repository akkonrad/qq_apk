import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

public final class mce
  extends AnimatorListenerAdapter
{
  public mce(View paramView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.setLayerType(0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mce
 * JD-Core Version:    0.7.0.1
 */