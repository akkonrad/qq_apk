import android.animation.ValueAnimator;
import com.tencent.biz.qqstory.support.logging.SLog;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.animation.AnimatorFactory.SimpleAnimatorListener;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.widget.ElasticImageView;

public class aobm
  extends AnimatorFactory.SimpleAnimatorListener
{
  public aobm(ElasticImageView paramElasticImageView) {}
  
  public void a(ValueAnimator paramValueAnimator)
  {
    this.a.d = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    ElasticImageView.a(this.a, this.a.d);
    SLog.b("ElasticImageView", "updateAnimator:" + this.a.d);
    ElasticImageView.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aobm
 * JD-Core Version:    0.7.0.1
 */