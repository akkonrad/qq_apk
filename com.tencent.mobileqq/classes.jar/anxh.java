import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.TextLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.TextLayer.TextItem;

public class anxh
  implements ValueAnimator.AnimatorUpdateListener
{
  public anxh(TextLayer.TextItem paramTextItem) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (this.a.a.b == null) {
      return;
    }
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.a.s = (this.a.d + this.a.f * (1.0F - f));
    this.a.t = (this.a.e + this.a.g * (1.0F - f));
    this.a.q = (this.a.b + this.a.h * (1.0F - f));
    this.a.r = (this.a.c + this.a.i * (1.0F - f));
    if (f == 1.0F)
    {
      this.a.a.b = null;
      this.a.a.b(4);
    }
    TextLayer.b(this.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anxh
 * JD-Core Version:    0.7.0.1
 */