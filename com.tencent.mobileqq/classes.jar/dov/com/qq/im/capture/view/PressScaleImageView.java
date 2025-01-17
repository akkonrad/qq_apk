package dov.com.qq.im.capture.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;

public class PressScaleImageView
  extends ImageView
{
  private final PressScaleAnimDelegate a;
  public boolean a;
  
  public PressScaleImageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public PressScaleImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public PressScaleImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_DovComQqImCaptureViewPressScaleAnimDelegate = new PressScaleAnimDelegate(this);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_DovComQqImCaptureViewPressScaleAnimDelegate.a())
    {
      paramCanvas.save();
      this.jdField_a_of_type_DovComQqImCaptureViewPressScaleAnimDelegate.a(paramCanvas);
    }
    super.onDraw(paramCanvas);
    if (this.jdField_a_of_type_DovComQqImCaptureViewPressScaleAnimDelegate.a()) {
      paramCanvas.restore();
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_DovComQqImCaptureViewPressScaleAnimDelegate.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.view.PressScaleImageView
 * JD-Core Version:    0.7.0.1
 */