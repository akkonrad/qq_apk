import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.ChatSettingForTroop;

class afn
  implements Animation.AnimationListener
{
  afn(afm paramafm, LinearLayout paramLinearLayout) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = new TranslateAnimation(-this.jdField_a_of_type_Afm.a.ao, 0.0F, 0.0F, 0.0F);
    paramAnimation.setDuration(800L);
    paramAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
    this.jdField_a_of_type_AndroidWidgetLinearLayout.startAnimation(paramAnimation);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     afn
 * JD-Core Version:    0.7.0.1
 */