import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.mobileqq.troop.createNewTroop.AbsNewTroopBaseView;
import com.tencent.mobileqq.troop.createNewTroop.NewTroopCreateActivity;

public class ajbr
  extends AnimatorListenerAdapter
{
  public ajbr(NewTroopCreateActivity paramNewTroopCreateActivity) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopAbsNewTroopBaseView != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopAbsNewTroopBaseView.a(this.a.jdField_a_of_type_Boolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajbr
 * JD-Core Version:    0.7.0.1
 */