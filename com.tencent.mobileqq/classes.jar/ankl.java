import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import dov.com.qq.im.capture.QIMCaptureController;
import dov.com.qq.im.capture.view.ProviderViewEditContainer;

public class ankl
  implements View.OnTouchListener
{
  public ankl(QIMCaptureController paramQIMCaptureController) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    return QIMCaptureController.a(this.a).a(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ankl
 * JD-Core Version:    0.7.0.1
 */