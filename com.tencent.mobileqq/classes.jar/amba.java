import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.tencent.widget.DynamicGridView;

public class amba
  extends AnimatorListenerAdapter
{
  public amba(DynamicGridView paramDynamicGridView, View paramView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    DynamicGridView.a(this.jdField_a_of_type_ComTencentWidgetDynamicGridView, false);
    DynamicGridView.a(this.jdField_a_of_type_ComTencentWidgetDynamicGridView);
    DynamicGridView.a(this.jdField_a_of_type_ComTencentWidgetDynamicGridView, this.jdField_a_of_type_AndroidViewView);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    DynamicGridView.a(this.jdField_a_of_type_ComTencentWidgetDynamicGridView, true);
    DynamicGridView.a(this.jdField_a_of_type_ComTencentWidgetDynamicGridView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amba
 * JD-Core Version:    0.7.0.1
 */