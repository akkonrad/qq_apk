import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.qphone.base.util.QLog;

public class ryf
  implements Animation.AnimationListener
{
  public ryf(ChatFragment paramChatFragment) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    QLog.d("Q.aio.ChatFragment", 2, "AIO onAnimationEnd");
    this.a.b(1);
  }
  
  public void onAnimationRepeat(Animation paramAnimation)
  {
    QLog.d("Q.aio.ChatFragment", 2, "AIO onAnimationRepeat");
  }
  
  public void onAnimationStart(Animation paramAnimation)
  {
    QLog.d("Q.aio.ChatFragment", 2, "AIO onAnimationStart");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ryf
 * JD-Core Version:    0.7.0.1
 */