package com.tencent.mobileqq.activity.aio.item;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import com.immersion.stickersampleapp.HapticManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;
import vac;
import vad;
import vae;
import vaf;
import vag;

public class HeartCombolEffectView
  extends View
  implements Handler.Callback
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Matrix jdField_a_of_type_AndroidGraphicsMatrix;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private String jdField_a_of_type_JavaLangString = "chat_item_for_qqbixin_strong";
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private vag jdField_a_of_type_Vag;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private Bitmap jdField_b_of_type_AndroidGraphicsBitmap;
  private boolean jdField_b_of_type_Boolean = true;
  private int c;
  private int d;
  private int e;
  
  public HeartCombolEffectView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public HeartCombolEffectView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  public HeartCombolEffectView(Context paramContext, boolean paramBoolean)
  {
    super(paramContext);
    this.jdField_a_of_type_Boolean = paramBoolean;
    a(paramContext);
  }
  
  @TargetApi(11)
  private vag a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, float paramFloat, int paramInt6)
  {
    vag localvag = new vag(this);
    localvag.jdField_a_of_type_Boolean = false;
    localvag.jdField_a_of_type_Int = paramInt1;
    localvag.jdField_b_of_type_Int = paramInt2;
    localvag.c = paramInt3;
    localvag.d = paramInt4;
    localvag.e = paramInt5;
    localvag.jdField_a_of_type_Float = paramFloat;
    localvag.h = paramInt6;
    localvag.jdField_b_of_type_Boolean = false;
    localvag.jdField_a_of_type_AndroidWidgetScroller = new Scroller(getContext(), new DecelerateInterpolator());
    localvag.jdField_a_of_type_AndroidWidgetScroller = new Scroller(getContext(), new DecelerateInterpolator());
    localvag.jdField_b_of_type_AndroidWidgetScroller = new Scroller(getContext(), new AccelerateInterpolator());
    localvag.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { localvag.jdField_a_of_type_Float, 0.0F });
    localvag.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(1100 - localvag.h);
    localvag.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new vae(this, localvag));
    return localvag;
  }
  
  public Bitmap a(Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      int i = paramBitmap.getWidth();
      int j = paramBitmap.getHeight();
      Matrix localMatrix = new Matrix();
      localMatrix.postScale(-1.0F, 1.0F);
      try
      {
        paramBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, i, j, localMatrix, true);
        return paramBitmap;
      }
      catch (OutOfMemoryError paramBitmap)
      {
        paramBitmap.printStackTrace();
        return null;
      }
    }
    return null;
  }
  
  void a(Context paramContext)
  {
    setOnTouchListener(new vac(this));
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_AndroidGraphicsBitmap = ImageUtil.a(getResources(), 2130838360);
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
      this.jdField_b_of_type_AndroidGraphicsBitmap = a(this.jdField_a_of_type_AndroidGraphicsBitmap);
    }
    if (this.jdField_b_of_type_AndroidGraphicsBitmap == null) {
      this.jdField_b_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
    }
    this.jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
    int i = getResources().getDisplayMetrics().widthPixels;
    int j = getResources().getDisplayMetrics().heightPixels - ImmersiveUtils.a(getContext()) * 2;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilArrayList.add(a(300, (int)(i * 1.2F), (int)(j * 0.37F), 0, (int)(j * 0.15F), 1.0F, 500));
    this.jdField_a_of_type_JavaUtilArrayList.add(a(780, (int)(i * 1.2F), (int)(j * 0.42F), 0, (int)(j * 0.25F), 0.95F, 500));
    this.jdField_a_of_type_JavaUtilArrayList.add(a(180, (int)(i * 1.2F), (int)(j * 0.46F), (int)(-i * 0.06D), (int)(j * 0.27F), 1.42F, 500));
    this.jdField_a_of_type_JavaUtilArrayList.add(a(450, (int)(i * 1.2F), (int)(j * 0.51F), 0, (int)(j * 0.45F), 0.92F, 500));
    this.jdField_a_of_type_JavaUtilArrayList.add(a(0, (int)(i * 1.2F), (int)(j * 0.56F), (int)(-i * 0.1D), (int)(j * 0.6F), 0.55F, 500));
    this.jdField_a_of_type_JavaUtilArrayList.add(a(620, (int)(i * 1.2F), (int)(j * 0.63F), (int)(-i * 0.04D), (int)(j * 0.75F), 1.3F, 500));
    this.jdField_a_of_type_JavaUtilArrayList.add(a(410, (int)(i * 1.2F), (int)(j * 0.71F), (int)(-i * 0.06D), (int)(j * 0.89F), 0.88F, 500));
    this.jdField_a_of_type_Vag = ((vag)this.jdField_a_of_type_JavaUtilArrayList.get(1));
    this.jdField_a_of_type_Vag.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(new vad(this));
    this.jdField_a_of_type_Int = i;
    this.jdField_b_of_type_Int = j;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    setVisibility(0);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
    if (this.jdField_a_of_type_Boolean) {
      ThreadManager.postImmediately(new vaf(this), null, true);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      this.jdField_a_of_type_Long = AnimationUtils.currentAnimationTimeMillis();
      paramMessage = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramMessage.hasNext())
      {
        vag localvag = (vag)paramMessage.next();
        localvag.jdField_a_of_type_Boolean = false;
        localvag.jdField_a_of_type_AndroidWidgetScroller.abortAnimation();
        localvag.jdField_b_of_type_AndroidWidgetScroller.abortAnimation();
        localvag.f = localvag.jdField_b_of_type_Int;
        localvag.g = localvag.c;
        localvag.jdField_b_of_type_Float = localvag.jdField_a_of_type_Float;
      }
      if (this.jdField_a_of_type_Boolean) {
        this.c = HapticManager.a().a(this.jdField_a_of_type_JavaLangString, 2);
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
      continue;
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
      long l1 = AnimationUtils.currentAnimationTimeMillis();
      long l2 = this.jdField_a_of_type_Long;
      int i = 0;
      if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        paramMessage = (vag)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        if (l1 - l2 >= paramMessage.jdField_a_of_type_Int) {
          if (!paramMessage.jdField_a_of_type_Boolean)
          {
            if (!this.jdField_b_of_type_Boolean) {
              break label367;
            }
            j = paramMessage.jdField_b_of_type_Int;
          }
        }
        for (int k = paramMessage.d;; k = this.jdField_a_of_type_Int - paramMessage.d)
        {
          paramMessage.jdField_a_of_type_AndroidWidgetScroller.startScroll(j, 0, k - j, 0, 1100);
          paramMessage.jdField_b_of_type_AndroidWidgetScroller.startScroll(0, paramMessage.c, 0, paramMessage.e - paramMessage.c, 1100);
          paramMessage.jdField_a_of_type_Boolean = true;
          if (paramMessage.jdField_a_of_type_AndroidWidgetScroller.computeScrollOffset())
          {
            paramMessage.jdField_b_of_type_AndroidWidgetScroller.computeScrollOffset();
            if ((paramMessage.jdField_a_of_type_AndroidWidgetScroller.timePassed() > paramMessage.h) && (paramMessage.jdField_b_of_type_Float == paramMessage.jdField_a_of_type_Float)) {
              paramMessage.jdField_a_of_type_AndroidAnimationValueAnimator.start();
            }
            paramMessage.f = paramMessage.jdField_a_of_type_AndroidWidgetScroller.getCurrX();
            paramMessage.g = paramMessage.jdField_b_of_type_AndroidWidgetScroller.getCurrY();
          }
          i += 1;
          break;
          label367:
          j = this.jdField_a_of_type_Int - paramMessage.jdField_b_of_type_Int;
        }
      }
      i = this.jdField_a_of_type_Int;
      int j = this.jdField_a_of_type_Vag.d;
      float f = ((Float)this.jdField_a_of_type_Vag.jdField_a_of_type_AndroidAnimationValueAnimator.getAnimatedValue()).floatValue();
      if ((!this.jdField_a_of_type_Vag.jdField_a_of_type_Boolean) || ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Vag.f > this.jdField_a_of_type_Vag.d)) || ((!this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Vag.f < i - j)) || ((this.jdField_a_of_type_Vag.jdField_b_of_type_Boolean) && (f > 0.001D)))
      {
        postInvalidate();
        paramMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
        paramMessage.what = 2;
        this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramMessage, 25L);
      }
      else
      {
        if (this.jdField_a_of_type_Boolean) {
          HapticManager.a().c(this.c);
        }
        this.c = 0;
      }
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_AndroidGraphicsBitmap == null)) {}
    for (;;)
    {
      return;
      if ((this.jdField_b_of_type_Boolean) || (this.jdField_b_of_type_AndroidGraphicsBitmap != null))
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          vag localvag = (vag)localIterator.next();
          if (localvag.jdField_a_of_type_Boolean)
          {
            this.jdField_a_of_type_AndroidGraphicsMatrix.reset();
            this.d = ((int)(this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() * localvag.jdField_b_of_type_Float / 2.0F));
            this.e = ((int)(this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() * localvag.jdField_b_of_type_Float / 2.0F));
            this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(localvag.f, localvag.g);
            this.jdField_a_of_type_AndroidGraphicsMatrix.preScale(localvag.jdField_b_of_type_Float, localvag.jdField_b_of_type_Float);
            if (this.jdField_b_of_type_Boolean) {
              paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_AndroidGraphicsMatrix, null);
            } else {
              paramCanvas.drawBitmap(this.jdField_b_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_AndroidGraphicsMatrix, null);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.HeartCombolEffectView
 * JD-Core Version:    0.7.0.1
 */