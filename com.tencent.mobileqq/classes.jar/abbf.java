import android.os.Handler;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorListenerAdapter;
import com.tencent.mobileqq.armap.ARMapActivity;
import com.tencent.mobileqq.armap.wealthgod.ARMapSplashView;

public class abbf
  extends AnimatorListenerAdapter
{
  public abbf(ARMapActivity paramARMapActivity) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (ARMapActivity.a(this.a) != null) {
      ARMapActivity.a(this.a).setLoadStatus(2);
    }
    this.a.a.postDelayed(new abbg(this), 200L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abbf
 * JD-Core Version:    0.7.0.1
 */