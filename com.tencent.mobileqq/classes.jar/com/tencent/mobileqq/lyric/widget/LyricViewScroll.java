package com.tencent.mobileqq.lyric.widget;

import aede;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ScrollView;
import android.widget.Scroller;
import java.util.Timer;

public class LyricViewScroll
  extends ScrollView
{
  public volatile int a;
  protected Scroller a;
  private LyricViewScroll.LyricViewScrollListener a;
  public Timer a;
  public volatile boolean a;
  private volatile boolean b = true;
  private volatile boolean c;
  
  public LyricViewScroll(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(paramContext, new AccelerateDecelerateInterpolator());
  }
  
  public void a(int paramInt)
  {
    if (!this.c)
    {
      paramInt -= this.jdField_a_of_type_Int;
      if (paramInt != 0)
      {
        this.jdField_a_of_type_AndroidWidgetScroller.startScroll(this.jdField_a_of_type_AndroidWidgetScroller.getFinalX(), this.jdField_a_of_type_Int, 0, paramInt, 500);
        this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidWidgetScroller.getFinalY();
        invalidate();
      }
    }
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    if (!this.b) {
      return true;
    }
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    default: 
      Log.v("LyricViewScroll", "default:" + paramMotionEvent.getAction());
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_AndroidWidgetScroller.forceFinished(true);
        boolean bool = super.onTouchEvent(paramMotionEvent);
        return bool;
      }
      catch (Exception paramMotionEvent)
      {
        Log.e("LyricViewScroll", paramMotionEvent.toString());
      }
      Log.v("LyricViewScroll", "onTouchEvent -> ACTION_DOWN");
      this.c = true;
      if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_JavaUtilTimer != null))
      {
        this.jdField_a_of_type_JavaUtilTimer.cancel();
        this.jdField_a_of_type_Boolean = false;
        continue;
        this.c = true;
        if (this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewScroll$LyricViewScrollListener != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewScroll$LyricViewScrollListener.a(getScrollY());
          continue;
          Log.v("LyricViewScroll", "onTouchEvent -> ACTION_UP");
          if (!this.jdField_a_of_type_Boolean)
          {
            this.jdField_a_of_type_Boolean = true;
            this.jdField_a_of_type_JavaUtilTimer = new Timer();
            this.jdField_a_of_type_JavaUtilTimer.scheduleAtFixedRate(new aede(this), 100L, 100L);
            continue;
            Log.v("LyricViewScroll", "onTouchEvent -> ACTION_CANCEL");
            this.jdField_a_of_type_Int = getScrollY();
            this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewScroll$LyricViewScrollListener.b(this.jdField_a_of_type_Int);
            this.c = false;
            if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_JavaUtilTimer != null))
            {
              this.jdField_a_of_type_JavaUtilTimer.cancel();
              this.jdField_a_of_type_Boolean = false;
            }
          }
        }
      }
    }
    return false;
  }
  
  public void computeScroll()
  {
    super.computeScroll();
    if ((this.jdField_a_of_type_AndroidWidgetScroller.computeScrollOffset()) && (!this.c))
    {
      smoothScrollTo(this.jdField_a_of_type_AndroidWidgetScroller.getCurrX(), this.jdField_a_of_type_AndroidWidgetScroller.getCurrY());
      postInvalidate();
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void setScrollEnable(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public void setScrollListener(LyricViewScroll.LyricViewScrollListener paramLyricViewScrollListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewScroll$LyricViewScrollListener = paramLyricViewScrollListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.lyric.widget.LyricViewScroll
 * JD-Core Version:    0.7.0.1
 */