import android.view.animation.Transformation;
import com.tencent.mobileqq.portal.ImageShakeAnimView;
import com.tencent.mobileqq.utils.ValueAnimation;
import com.tencent.mobileqq.utils.ValueAnimation.AnimationUpdateListener;

public class agmo
  implements ValueAnimation.AnimationUpdateListener
{
  public agmo(ImageShakeAnimView paramImageShakeAnimView) {}
  
  public void a(ValueAnimation paramValueAnimation, float paramFloat, Float paramFloat1, Transformation paramTransformation)
  {
    if (this.a.jdField_a_of_type_Boolean)
    {
      if (paramFloat1.floatValue() < 180.0F)
      {
        this.a.jdField_a_of_type_Float = (1.0F - paramFloat1.floatValue() * 0.01F / 180.0F);
        this.a.b = (0.02F * paramFloat1.floatValue() / 180.0F + 1.0F);
        return;
      }
      if (paramFloat1.floatValue() < 360.0F)
      {
        paramValueAnimation = Float.valueOf(paramFloat1.floatValue() - 180.0F);
        this.a.jdField_a_of_type_Float = (0.99F + 0.03F * paramValueAnimation.floatValue() / 180.0F);
        this.a.b = (1.02F - paramValueAnimation.floatValue() * 0.04F / 180.0F);
        return;
      }
      if (paramFloat1.floatValue() < 540.0F)
      {
        paramValueAnimation = Float.valueOf(paramFloat1.floatValue() - 360.0F);
        this.a.jdField_a_of_type_Float = (1.02F - 0.03F * paramValueAnimation.floatValue() / 180.0F);
        this.a.b = (paramValueAnimation.floatValue() * 0.03F / 180.0F + 0.98F);
        return;
      }
      paramValueAnimation = Float.valueOf(paramFloat1.floatValue() - 540.0F);
      this.a.jdField_a_of_type_Float = (0.99F + paramValueAnimation.floatValue() * 0.01F / 180.0F);
      this.a.b = (1.01F - paramValueAnimation.floatValue() * 0.01F / 180.0F);
      return;
    }
    if (paramFloat1.floatValue() < 120.0F)
    {
      this.a.jdField_a_of_type_Float = (1.0F - 0.02F * paramFloat1.floatValue() / 120.0F);
      this.a.b = (paramFloat1.floatValue() * 0.04F / 120.0F + 1.0F);
      return;
    }
    if (paramFloat1.floatValue() < 380.0F)
    {
      paramValueAnimation = Float.valueOf(paramFloat1.floatValue() - 120.0F);
      this.a.jdField_a_of_type_Float = (0.98F + paramValueAnimation.floatValue() * 0.04F / 260.0F);
      this.a.b = (1.04F - paramValueAnimation.floatValue() * 0.08F / 260.0F);
      return;
    }
    paramValueAnimation = Float.valueOf(paramFloat1.floatValue() - 380.0F);
    this.a.jdField_a_of_type_Float = (1.02F - 0.02F * paramValueAnimation.floatValue() / 120.0F);
    this.a.b = (paramValueAnimation.floatValue() * 0.04F / 120.0F + 0.96F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agmo
 * JD-Core Version:    0.7.0.1
 */