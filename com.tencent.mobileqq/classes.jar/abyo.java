import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.PathMeasure;
import com.tencent.mobileqq.doutu.combo.ComboMasterView;

public class abyo
  implements ValueAnimator.AnimatorUpdateListener
{
  public abyo(ComboMasterView paramComboMasterView, PathMeasure paramPathMeasure, float[] paramArrayOfFloat) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.jdField_a_of_type_AndroidGraphicsPathMeasure.getPosTan(f, this.jdField_a_of_type_ArrayOfFloat, null);
    this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboMasterView.setTranslationX(this.jdField_a_of_type_ArrayOfFloat[0]);
    this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboMasterView.setTranslationY(this.jdField_a_of_type_ArrayOfFloat[1]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abyo
 * JD-Core Version:    0.7.0.1
 */