import com.tencent.mobileqq.ar.ARNativeBridge;
import com.tencent.mobileqq.ar.ARRenderModel.Interactive3DRenderable;
import com.tencent.qphone.base.util.QLog;

public class aabj
  implements Runnable
{
  public aabj(Interactive3DRenderable paramInteractive3DRenderable, int paramInt, float paramFloat1, float paramFloat2, long paramLong) {}
  
  public void run()
  {
    Interactive3DRenderable.a(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelInteractive3DRenderable).native_onTouchEnd(this.jdField_a_of_type_Int, this.jdField_a_of_type_Float, this.b, 1, this.jdField_a_of_type_Long, Interactive3DRenderable.a(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelInteractive3DRenderable).mCurrentActiveId);
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_Interactive3DRenderable", 2, "ACTION_UP native_onTouchEnd");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aabj
 * JD-Core Version:    0.7.0.1
 */