package com.tencent.biz.qqstory.takevideo;

import android.view.MotionEvent;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraControl;
import java.math.BigDecimal;

public class NewStoryCameraZoom
{
  public float a;
  private float b;
  private float c;
  
  public boolean a(MotionEvent paramMotionEvent, boolean paramBoolean)
  {
    int i = paramMotionEvent.getPointerCount();
    int j = paramMotionEvent.getAction() & 0xFF;
    if ((i == 1) && (paramBoolean)) {
      switch (j)
      {
      }
    }
    while (((i != 2) || (paramBoolean)) && ((i != 3) || (!paramBoolean)))
    {
      do
      {
        return false;
        this.c = this.a;
        return false;
        if (paramMotionEvent.getY() >= this.a)
        {
          this.c = this.a;
          return false;
        }
        i = new BigDecimal((this.c - paramMotionEvent.getY()) / 20.0F).setScale(0, 4).intValue();
      } while (i == 0);
      CameraControl.a().c(i);
      this.c = paramMotionEvent.getY();
      return false;
    }
    SLog.a("NewStoryCameraZoom", "onTouchEvent %s", new Object[] { paramMotionEvent });
    float f4;
    float f2;
    float f3;
    if (i == 2)
    {
      f4 = paramMotionEvent.getX(0);
      f2 = paramMotionEvent.getY(0);
      f3 = paramMotionEvent.getX(1);
    }
    for (float f1 = paramMotionEvent.getY(1);; f1 = paramMotionEvent.getY(2)) {
      switch (j)
      {
      case 6: 
      case 3: 
      case 4: 
      default: 
        return false;
      case 2: 
        f1 = TakeVideoUtils.a(f4, f2, f3, f1);
        i = new BigDecimal((f1 - this.b) / 20.0F).setScale(0, 4).intValue();
        if (i != 0)
        {
          SLog.a("NewStoryCameraZoom", "set camera zoom increase value %d", new Object[] { Integer.valueOf(i) });
          CameraControl.a().c(i);
          this.b = f1;
        }
        return true;
        f4 = paramMotionEvent.getX(1);
        f2 = paramMotionEvent.getY(1);
        f3 = paramMotionEvent.getX(2);
      }
    }
    this.b = TakeVideoUtils.a(f4, f2, f3, f1);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.NewStoryCameraZoom
 * JD-Core Version:    0.7.0.1
 */