import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.arcard.ARCardCamereButtonLayout;

public class aalq
  implements ValueAnimator.AnimatorUpdateListener
{
  public aalq(ARCardCamereButtonLayout paramARCardCamereButtonLayout) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    ARCardCamereButtonLayout.a(this.a, f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aalq
 * JD-Core Version:    0.7.0.1
 */