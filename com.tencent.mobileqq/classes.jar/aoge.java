import android.content.Context;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import dov.com.tencent.mobileqq.activity.richmedia.FlowCameraActivity2;

public class aoge
  extends GestureDetector.SimpleOnGestureListener
{
  float jdField_a_of_type_Float;
  
  public aoge(FlowCameraActivity2 paramFlowCameraActivity2, Context paramContext)
  {
    this.jdField_a_of_type_Float = (ViewConfiguration.get(paramContext).getScaledTouchSlop() * 2);
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    return super.onDown(paramMotionEvent);
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if ((paramMotionEvent1 == null) || (paramMotionEvent2 == null)) {
      return super.onScroll(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    }
    if ((this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaFlowCameraActivity2.i) || (this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaFlowCameraActivity2.j)) {
      return super.onScroll(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    }
    float f = paramMotionEvent1.getX() - paramMotionEvent2.getX();
    if (Math.abs(f) > this.jdField_a_of_type_Float)
    {
      this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaFlowCameraActivity2.a(f);
      return true;
    }
    return super.onScroll(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    return super.onSingleTapUp(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aoge
 * JD-Core Version:    0.7.0.1
 */