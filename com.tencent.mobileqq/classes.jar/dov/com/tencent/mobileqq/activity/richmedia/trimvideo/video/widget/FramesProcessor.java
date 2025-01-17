package dov.com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.Scroller;

public class FramesProcessor
  implements FrameAdapter.DataSetChangeListener
{
  public static final boolean a;
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Canvas jdField_a_of_type_AndroidGraphicsCanvas;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  private Scroller jdField_a_of_type_AndroidWidgetScroller;
  private FrameAdapter jdField_a_of_type_DovComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFrameAdapter;
  private FrameParent jdField_a_of_type_DovComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFrameParent;
  private FramesProcessor.OnMoveListener jdField_a_of_type_DovComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFramesProcessor$OnMoveListener;
  private OnFetchFrameListener jdField_a_of_type_DovComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetOnFetchFrameListener;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private Paint jdField_b_of_type_AndroidGraphicsPaint;
  private Rect jdField_b_of_type_AndroidGraphicsRect;
  private float jdField_c_of_type_Float;
  private final int jdField_c_of_type_Int;
  private Rect jdField_c_of_type_AndroidGraphicsRect;
  private float jdField_d_of_type_Float;
  private int jdField_d_of_type_Int;
  private float e;
  private float f;
  private float g;
  private float h;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 10) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  private void a()
  {
    if ((this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFrameAdapter == null) || (this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFrameAdapter.a())) {}
    int i;
    do
    {
      return;
      i = (int)(this.jdField_d_of_type_Float / this.jdField_b_of_type_Float);
      this.jdField_a_of_type_Int = Math.max(i, 0);
    } while (this.jdField_c_of_type_Int < 6);
    this.jdField_b_of_type_Int = Math.min(i + this.jdField_c_of_type_Int, this.jdField_d_of_type_Int);
  }
  
  private boolean a(float paramFloat1, float paramFloat2)
  {
    return Math.abs(paramFloat1 - paramFloat2) == 0.0F;
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidGraphicsCanvas.drawColor(-16777216);
    if (this.jdField_a_of_type_AndroidWidgetScroller.computeScrollOffset())
    {
      this.jdField_d_of_type_Float = this.jdField_a_of_type_AndroidWidgetScroller.getCurrX();
      if (this.jdField_d_of_type_Float < this.h)
      {
        this.jdField_d_of_type_Float = this.h;
        this.jdField_a_of_type_AndroidWidgetScroller.forceFinished(true);
      }
      if (this.jdField_d_of_type_Float > this.g)
      {
        this.jdField_d_of_type_Float = this.g;
        this.jdField_a_of_type_AndroidWidgetScroller.forceFinished(true);
      }
      a();
      if (this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFrameParent != null) {
        this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFrameParent.invalidate();
      }
      float f1 = this.jdField_d_of_type_Float;
      float f2 = this.e;
      this.e = this.jdField_d_of_type_Float;
      if (!a(f1 - f2, 0.0F)) {
        break label157;
      }
    }
    label157:
    while (this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFramesProcessor$OnMoveListener == null)
    {
      return;
      this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetOnFetchFrameListener.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      break;
    }
    this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFramesProcessor$OnMoveListener.a(this.jdField_d_of_type_Float, -this.jdField_d_of_type_Float, this.f - this.jdField_d_of_type_Float);
  }
  
  public void a(int paramInt)
  {
    int i = this.jdField_a_of_type_AndroidGraphicsRect.right;
    float f1 = this.h;
    this.h = (i - paramInt + f1);
    this.jdField_a_of_type_AndroidGraphicsRect.right = paramInt;
    this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFrameParent.invalidate();
  }
  
  public void a(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFrameAdapter == null) {
      return;
    }
    b();
    int i = Math.max(this.jdField_a_of_type_Int - 1, 0);
    float f1 = i;
    f1 = this.jdField_b_of_type_Float * f1;
    this.jdField_a_of_type_AndroidGraphicsCanvas.translate(f1 - this.jdField_d_of_type_Float + this.jdField_a_of_type_Float, 0.0F);
    int k = Math.min(this.jdField_b_of_type_Int + 3, this.jdField_d_of_type_Int);
    int j = (int)this.jdField_b_of_type_Float;
    while (i < k)
    {
      FramesProcessor.Frame localFrame = this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFrameAdapter.a(i);
      if (localFrame != null)
      {
        j = (int)Math.min(this.f - f1, this.jdField_b_of_type_Float);
        this.jdField_c_of_type_AndroidGraphicsRect.set(0, 0, j, (int)this.jdField_c_of_type_Float);
        this.jdField_a_of_type_AndroidGraphicsCanvas.drawBitmap(localFrame.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_c_of_type_AndroidGraphicsRect, this.jdField_c_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
      }
      this.jdField_a_of_type_AndroidGraphicsCanvas.translate(j, 0.0F);
      f1 += j;
      i += 1;
    }
    this.jdField_a_of_type_AndroidGraphicsCanvas.translate(-f1 + this.jdField_d_of_type_Float - this.jdField_a_of_type_Float, 0.0F);
    paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, 0.0F, 0.0F, this.jdField_a_of_type_AndroidGraphicsPaint);
    paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_b_of_type_AndroidGraphicsPaint);
    paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_b_of_type_AndroidGraphicsRect, this.jdField_b_of_type_AndroidGraphicsRect, this.jdField_b_of_type_AndroidGraphicsPaint);
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_AndroidViewGestureDetector != null) {
      this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
    }
  }
  
  public void b(int paramInt)
  {
    int i = this.jdField_b_of_type_AndroidGraphicsRect.left;
    float f1 = this.g;
    this.g = (i - paramInt + f1);
    this.jdField_b_of_type_AndroidGraphicsRect.left = paramInt;
    this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFrameParent.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.FramesProcessor
 * JD-Core Version:    0.7.0.1
 */