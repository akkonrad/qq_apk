import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.richmedia.capture.view.QIMCameraCaptureButtonLayout;
import dov.com.tencent.mobileqq.richmedia.capture.view.QIMCameraCountTimeLayout;
import java.util.concurrent.atomic.AtomicBoolean;

public class aomt
  extends AnimatorListenerAdapter
{
  public aomt(QIMCameraCaptureButtonLayout paramQIMCameraCaptureButtonLayout) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraCaptureLayout", 2, "scaleAnimator cancel!");
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraCaptureLayout", 2, "scaleAnimator end, shortVideoShot:" + this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get() + ", mActionUpAnimator:" + this.a.b.get());
    }
    if (!this.a.b.get())
    {
      this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
      this.a.jdField_a_of_type_Long = System.currentTimeMillis();
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(5);
    }
    for (;;)
    {
      this.a.b.set(false);
      this.a.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCountTimeLayout.setVisibility(0);
      return;
      this.a.d();
      this.a.a(1.0F);
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraCaptureLayout", 2, "scaleAnimator start!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aomt
 * JD-Core Version:    0.7.0.1
 */