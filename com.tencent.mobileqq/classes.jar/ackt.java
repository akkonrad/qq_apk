import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity;

public class ackt
  implements Animation.AnimationListener
{
  public ackt(Face2FaceAddFriendActivity paramFace2FaceAddFriendActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.l = false;
    this.a.a.setVisibility(8);
    this.a.e();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ackt
 * JD-Core Version:    0.7.0.1
 */