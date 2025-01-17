package com.tencent.mobileqq.activity.fling;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.ChatFragment.InterceptTouchEventListener;
import com.tencent.mobileqq.activity.ChatFragment.MyDispatchDrawListener;
import com.tencent.mobileqq.emoticonview.StickerGestureDetector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.ref.WeakReference;

public class TopGestureLayout
  extends RelativeLayout
{
  public static final int FLAG_GESTURE_END = -1;
  public static final int FLAG_GESTURE_FLINE_RL = 2;
  public static final int FLAG_GESTURE_FLING_LR = 1;
  public static final int FLAG_GESTURE_IDLE = 0;
  public static final String TAG = "TopGestureLayout";
  private int jdField_a_of_type_Int;
  public GestureDetector.SimpleOnGestureListener a;
  private boolean jdField_a_of_type_Boolean = true;
  private boolean b;
  private boolean c = true;
  private boolean d;
  public GestureDetector defaultGestureDetector;
  public WeakReference mInterceptTouchEventListener;
  public ChatFragment.MyDispatchDrawListener mMyDispatchDrawListener;
  public TopGestureLayout.OnGestureListener mOnFlingGesture;
  public GestureDetector mTopGestureDetector;
  
  public TopGestureLayout(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public TopGestureLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TopGestureLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  public TopGestureLayout(Context paramContext, ChatFragment.MyDispatchDrawListener paramMyDispatchDrawListener, ChatFragment.InterceptTouchEventListener paramInterceptTouchEventListener)
  {
    super(paramContext);
    a(paramContext);
    this.mMyDispatchDrawListener = paramMyDispatchDrawListener;
    this.mInterceptTouchEventListener = new WeakReference(paramInterceptTouchEventListener);
  }
  
  private void a()
  {
    if (this.d) {
      QLog.e("TopGestureLayout", 1, "TGRemoveCatchedException ", new RuntimeException("TGRemoveCatchedException"));
    }
  }
  
  public void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidViewGestureDetector$SimpleOnGestureListener = new TopGestureLayout.TopGestureDetector(this, paramContext);
    this.mTopGestureDetector = new TopGestureLayout.StickerDismissGestureDetector(this, paramContext, this.jdField_a_of_type_AndroidViewGestureDetector$SimpleOnGestureListener);
    this.defaultGestureDetector = this.mTopGestureDetector;
  }
  
  public boolean a()
  {
    if (this.mTopGestureDetector != null)
    {
      if ((this.mTopGestureDetector instanceof StickerGestureDetector)) {
        return ((StickerGestureDetector)this.mTopGestureDetector).jdField_a_of_type_Boolean;
      }
      if ((this.mTopGestureDetector instanceof TopGestureLayout.StickerDismissGestureDetector)) {
        return ((TopGestureLayout.StickerDismissGestureDetector)this.mTopGestureDetector).isInTowFingerMode;
      }
    }
    return false;
  }
  
  protected void detachViewFromParent(int paramInt)
  {
    a();
    super.detachViewFromParent(paramInt);
  }
  
  protected void detachViewFromParent(View paramView)
  {
    a();
    super.detachViewFromParent(paramView);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    if (paramCanvas == null) {}
    for (;;)
    {
      return;
      try
      {
        super.dispatchDraw(paramCanvas);
        if (this.mMyDispatchDrawListener == null) {
          continue;
        }
        this.mMyDispatchDrawListener.a();
        return;
      }
      catch (Throwable paramCanvas)
      {
        for (;;)
        {
          paramCanvas.printStackTrace();
        }
      }
    }
  }
  
  public GestureDetector getGestureDetector()
  {
    return this.mTopGestureDetector;
  }
  
  public GestureDetector.SimpleOnGestureListener getGestureListener()
  {
    return this.jdField_a_of_type_AndroidViewGestureDetector$SimpleOnGestureListener;
  }
  
  public int getPaddingTop()
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return ImmersiveUtils.a(getContext());
    }
    return super.getPaddingTop();
  }
  
  public boolean hasGestureFlag(int paramInt)
  {
    return (!isGestureEnd()) && ((this.jdField_a_of_type_Int & paramInt) == paramInt);
  }
  
  public boolean isGestureEnd()
  {
    return this.jdField_a_of_type_Int == -1;
  }
  
  public boolean isGestureIdle()
  {
    return this.jdField_a_of_type_Int == 0;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return false;
    }
    if ((this.mInterceptTouchEventListener != null) && (this.mInterceptTouchEventListener.get() != null) && (!((ChatFragment.InterceptTouchEventListener)this.mInterceptTouchEventListener.get()).a(paramMotionEvent))) {
      return false;
    }
    return this.mTopGestureDetector.onTouchEvent(paramMotionEvent);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.d = true;
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.d = false;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return this.mTopGestureDetector.onTouchEvent(paramMotionEvent);
  }
  
  public void removeView(View paramView)
  {
    a();
    super.removeView(paramView);
  }
  
  public void removeViewInLayout(View paramView)
  {
    a();
    super.removeViewInLayout(paramView);
  }
  
  public void restoreGestureDetector()
  {
    if (this.defaultGestureDetector != null)
    {
      this.mTopGestureDetector = this.defaultGestureDetector;
      return;
    }
    this.mTopGestureDetector = new TopGestureLayout.StickerDismissGestureDetector(this, getContext(), this.jdField_a_of_type_AndroidViewGestureDetector$SimpleOnGestureListener);
  }
  
  public void setGestureDetector(GestureDetector paramGestureDetector)
  {
    this.mTopGestureDetector = paramGestureDetector;
  }
  
  public void setGestureFlag(int paramInt)
  {
    if ((paramInt == 0) || (paramInt == -1))
    {
      this.jdField_a_of_type_Int = paramInt;
      return;
    }
    this.jdField_a_of_type_Int = (this.jdField_a_of_type_Int & (paramInt ^ 0xFFFFFFFF) | paramInt);
  }
  
  public void setInterceptScrollLRFlag(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public void setInterceptScrollRLFlag(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public void setInterceptTouchFlag(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setOnFlingGesture(TopGestureLayout.OnGestureListener paramOnGestureListener)
  {
    this.mOnFlingGesture = paramOnGestureListener;
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (Build.VERSION.SDK_INT >= 19)
    {
      super.setPadding(paramInt1, ImmersiveUtils.a(getContext()), paramInt3, paramInt4);
      return;
    }
    super.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.fling.TopGestureLayout
 * JD-Core Version:    0.7.0.1
 */