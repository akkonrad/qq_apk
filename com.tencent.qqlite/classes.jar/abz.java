import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

public final class abz
  implements Animation.AnimationListener
{
  public abz(Handler paramHandler, Runnable paramRunnable, long paramLong) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, this.jdField_a_of_type_Long);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     abz
 * JD-Core Version:    0.7.0.1
 */