import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.richmedia.capture.gesture.GLGestureProxy;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureButtonLayout;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureButtonLayout.CaptureButtonListenerInterceptor;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class ahlb
  implements View.OnTouchListener
{
  public ahlb(CameraCaptureButtonLayout paramCameraCaptureButtonLayout) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraCaptureLayout", 2, "touch action:" + (paramMotionEvent.getAction() & 0xFF) + ", shortVideoShot:" + this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get() + ", actionUp:" + this.a.b.get() + ", isOver:" + CameraCaptureButtonLayout.a(this.a));
    }
    this.a.a();
    GLGestureProxy.a().a(paramMotionEvent, true, this.a.jdField_a_of_type_AndroidWidgetImageView, CameraCaptureButtonLayout.a(this.a));
    if (CameraCaptureButtonLayout.a(this.a)) {}
    do
    {
      return false;
      switch (paramMotionEvent.getAction() & 0xFF)
      {
      case 2: 
      default: 
        return false;
      }
    } while (CameraCaptureButtonLayout.b(this.a));
    if ((CameraCaptureButtonLayout.a(this.a) != null) && (!CameraCaptureButtonLayout.a(this.a).a())) {
      return true;
    }
    this.a.b();
    if ((CameraCaptureButtonLayout.a(this.a) == 3) || (CameraCaptureButtonLayout.a(this.a) == 1)) {
      CameraCaptureButtonLayout.a(this.a).sendEmptyMessageDelayed(1, 100L);
    }
    CameraCaptureButtonLayout.a(this.a, true);
    return true;
    CameraCaptureButtonLayout.b(this.a);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahlb
 * JD-Core Version:    0.7.0.1
 */