import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.widget.DynamicGridView;

public class ambb
  extends AnimatorListenerAdapter
{
  public ambb(DynamicGridView paramDynamicGridView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    DynamicGridView.b(this.a, false);
    DynamicGridView.a(this.a);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    DynamicGridView.b(this.a, true);
    DynamicGridView.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ambb
 * JD-Core Version:    0.7.0.1
 */