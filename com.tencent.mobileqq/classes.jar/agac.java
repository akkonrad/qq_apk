import android.view.View;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.Animator.AnimatorListener;
import com.tencent.mobileqq.now.enter.ConversationNowController;

public class agac
  implements Animator.AnimatorListener
{
  public agac(ConversationNowController paramConversationNowController, View paramView) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.jdField_a_of_type_ComTencentMobileqqNowEnterConversationNowController.g();
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.jdField_a_of_type_ComTencentMobileqqNowEnterConversationNowController.g();
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNowEnterConversationNowController.d) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agac
 * JD-Core Version:    0.7.0.1
 */