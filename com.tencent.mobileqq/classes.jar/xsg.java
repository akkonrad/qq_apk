import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;

class xsg
  implements ValueAnimator.AnimatorUpdateListener
{
  xsg(xsf paramxsf, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f1 = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    paramValueAnimator = (RelativeLayout.LayoutParams)NewFlowCameraActivity.a(this.jdField_a_of_type_Xsf.a).getLayoutParams();
    paramValueAnimator.width = ((int)((this.jdField_a_of_type_Int - this.b) * f1 + this.b));
    paramValueAnimator.height = ((int)((this.c - this.d) * f1 + this.d));
    paramValueAnimator.leftMargin = ((int)((this.e + 0) * f1 + 0.0F));
    paramValueAnimator.bottomMargin = ((int)(f1 * (this.f + 0) + 0.0F));
    NewFlowCameraActivity.a(this.jdField_a_of_type_Xsf.a).setLayoutParams(paramValueAnimator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xsg
 * JD-Core Version:    0.7.0.1
 */