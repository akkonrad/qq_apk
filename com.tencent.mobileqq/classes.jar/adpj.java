import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.mobileqq.hiboom.HiBoomTextView;
import com.tencent.mobileqq.hiboom.HiBoomTextView.OnDoubleClick;

public class adpj
  extends GestureDetector.SimpleOnGestureListener
{
  public adpj(HiBoomTextView paramHiBoomTextView) {}
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    if (this.a.a != null)
    {
      this.a.a.a(this.a);
      return true;
    }
    return super.onDoubleTap(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adpj
 * JD-Core Version:    0.7.0.1
 */