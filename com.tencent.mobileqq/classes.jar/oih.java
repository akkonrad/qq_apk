import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.biz.qqstory.takevideo.doodle.layer.FaceLayer;
import com.tencent.biz.qqstory.takevideo.doodle.layer.FaceLayer.FaceItem;

public class oih
  implements ValueAnimator.AnimatorUpdateListener
{
  public oih(FaceLayer.FaceItem paramFaceItem) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.p = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.a.b.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oih
 * JD-Core Version:    0.7.0.1
 */