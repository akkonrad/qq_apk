package com.tencent.mobileqq.activity.recent.cur;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import xlm;
import xln;
import xlo;

public class DragFrameLayout
  extends FrameLayout
  implements IDragView.OnChangeModeListener
{
  private static final int[] jdField_a_of_type_ArrayOfInt = { 2130840446, 2130840447, 2130840448, 2130840449, 2130840450 };
  private float jdField_a_of_type_Float;
  private final int jdField_a_of_type_Int;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private PointF jdField_a_of_type_AndroidGraphicsPointF = new PointF(-1.0F, -1.0F);
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private View jdField_a_of_type_AndroidViewView;
  private DragFrameLayout.IDragViewProvider jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout$IDragViewProvider;
  private DragFrameLayout.OnDragListener jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout$OnDragListener;
  private final List jdField_a_of_type_JavaUtilList = new ArrayList();
  private xlm jdField_a_of_type_Xlm;
  private xln jdField_a_of_type_Xln;
  private xlo jdField_a_of_type_Xlo;
  private final int jdField_b_of_type_Int;
  private Bitmap jdField_b_of_type_AndroidGraphicsBitmap;
  private final int c;
  private int d = -1;
  private int e;
  private int f;
  private int g;
  
  public DragFrameLayout(Context paramContext)
  {
    super(paramContext);
    super.setWillNotDraw(false);
    this.jdField_b_of_type_Int = ((int)(3.0F * getResources().getDisplayMetrics().density));
    this.c = ((int)(12.0F * getResources().getDisplayMetrics().density));
    this.jdField_a_of_type_Int = ((int)(48.0F * getResources().getDisplayMetrics().density));
  }
  
  public DragFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    super.setWillNotDraw(false);
    this.jdField_b_of_type_Int = ((int)(3.0F * getResources().getDisplayMetrics().density));
    this.c = ((int)(12.0F * getResources().getDisplayMetrics().density));
    this.jdField_a_of_type_Int = ((int)(48.0F * getResources().getDisplayMetrics().density));
  }
  
  public DragFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    super.setWillNotDraw(false);
    this.jdField_b_of_type_Int = ((int)(3.0F * getResources().getDisplayMetrics().density));
    this.c = ((int)(12.0F * getResources().getDisplayMetrics().density));
    this.jdField_a_of_type_Int = ((int)(48.0F * getResources().getDisplayMetrics().density));
  }
  
  private static Bitmap a(View paramView)
  {
    Object localObject3 = null;
    paramView.setDrawingCacheEnabled(true);
    Bitmap localBitmap = paramView.getDrawingCache();
    Object localObject1 = localObject3;
    if (localBitmap != null) {}
    try
    {
      localObject1 = localBitmap.copy(Bitmap.Config.ARGB_8888, false);
      paramView.setDrawingCacheEnabled(false);
      return localObject1;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Object localObject2 = localObject3;
      }
    }
  }
  
  public static DragFrameLayout a(Activity paramActivity)
  {
    ViewGroup localViewGroup = (ViewGroup)paramActivity.getWindow().getDecorView();
    View localView = localViewGroup.getChildAt(0);
    if ((localView != null) && ((localView instanceof DragFrameLayout))) {
      return (DragFrameLayout)localView;
    }
    paramActivity = new DragFrameLayout(paramActivity.getApplication());
    localViewGroup.addView(paramActivity);
    localViewGroup.removeView(localView);
    paramActivity.addView(localView);
    return paramActivity;
  }
  
  private void a(float paramFloat1, float paramFloat2, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout$OnDragListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout$OnDragListener.a(paramFloat1, paramFloat2, paramInt, this.jdField_a_of_type_AndroidViewView);
    }
  }
  
  private void a(int paramInt)
  {
    this.d = paramInt;
    if (QLog.isColorLevel()) {
      QLog.d("Drag", 2, "setMode:" + this.d);
    }
  }
  
  private void a(Canvas paramCanvas)
  {
    if (this.d == -1) {}
    do
    {
      do
      {
        do
        {
          return;
          this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
          if (this.e != 0) {
            this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.e);
          }
          while (this.d == 0)
          {
            paramCanvas.drawBitmap(this.jdField_b_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_AndroidGraphicsRect.left, this.jdField_a_of_type_AndroidGraphicsRect.top, this.jdField_a_of_type_AndroidGraphicsPaint);
            return;
            if (this.f == 1) {
              this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-4797728);
            } else {
              this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-65536);
            }
          }
          if (this.d == 1)
          {
            paramCanvas.save();
            f3 = this.g / 1.5F;
            f2 = this.g * (0.8F - 0.45F * this.jdField_a_of_type_Float / this.jdField_a_of_type_Int);
            f1 = f2;
            if (f2 > this.c) {
              f1 = this.c;
            }
            f2 = f1;
            if (f1 < this.jdField_b_of_type_Int) {
              f2 = this.jdField_b_of_type_Int;
            }
            if (QLog.isColorLevel()) {
              QLog.d("Drag", 2, "MODE_DRAG:" + f2 + " for " + this.jdField_a_of_type_Float + ", " + this.jdField_a_of_type_Int);
            }
            paramCanvas.translate(this.jdField_a_of_type_AndroidGraphicsRect.centerX(), this.jdField_a_of_type_AndroidGraphicsRect.centerY());
            paramCanvas.rotate((float)(Math.atan2(this.jdField_a_of_type_AndroidGraphicsPointF.y - this.jdField_a_of_type_AndroidGraphicsRect.centerY(), this.jdField_a_of_type_AndroidGraphicsPointF.x - this.jdField_a_of_type_AndroidGraphicsRect.centerX()) * 57.295779513082323D) - 90.0F);
            paramCanvas.translate(-f3, -f2);
            a(paramCanvas, f2, f3);
            paramCanvas.restore();
            this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-16711936);
            paramCanvas.drawBitmap(this.jdField_b_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_AndroidGraphicsPointF.x - this.jdField_a_of_type_AndroidGraphicsRect.width() / 2.0F, this.jdField_a_of_type_AndroidGraphicsPointF.y - this.jdField_a_of_type_AndroidGraphicsRect.height() / 2.0F, this.jdField_a_of_type_AndroidGraphicsPaint);
            return;
          }
          if ((this.d != 3) && (this.d != 6)) {
            break;
          }
        } while ((this.jdField_a_of_type_Xlo == null) || (this.jdField_b_of_type_AndroidGraphicsBitmap == null));
        localObject = this.jdField_a_of_type_Xlo.a();
        this.jdField_a_of_type_AndroidGraphicsPointF.set((PointF)localObject);
        this.jdField_a_of_type_Float = ((float)Math.sqrt((this.jdField_a_of_type_AndroidGraphicsPointF.x - this.jdField_a_of_type_AndroidGraphicsRect.centerX()) * (this.jdField_a_of_type_AndroidGraphicsPointF.x - this.jdField_a_of_type_AndroidGraphicsRect.centerX()) + (this.jdField_a_of_type_AndroidGraphicsPointF.y - this.jdField_a_of_type_AndroidGraphicsRect.centerY()) * (this.jdField_a_of_type_AndroidGraphicsPointF.y - this.jdField_a_of_type_AndroidGraphicsRect.centerY())));
        paramCanvas.save();
        float f3 = this.g / 1.5F;
        float f2 = (1.0F - this.jdField_a_of_type_Float / this.jdField_a_of_type_Int) * f3;
        float f1 = f2;
        if (f2 > this.c / 2) {
          f1 = this.c / 2;
        }
        f2 = f1;
        if (f1 < this.jdField_b_of_type_Int) {
          f2 = this.jdField_b_of_type_Int;
        }
        paramCanvas.translate(this.jdField_a_of_type_AndroidGraphicsRect.centerX(), this.jdField_a_of_type_AndroidGraphicsRect.centerY());
        paramCanvas.rotate((float)(Math.atan2(this.jdField_a_of_type_AndroidGraphicsPointF.y - this.jdField_a_of_type_AndroidGraphicsRect.centerY(), this.jdField_a_of_type_AndroidGraphicsPointF.x - this.jdField_a_of_type_AndroidGraphicsRect.centerX()) * 57.295779513082323D) - 90.0F);
        paramCanvas.translate(-f3, -f2);
        paramCanvas.restore();
        this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-16711936);
        paramCanvas.drawBitmap(this.jdField_b_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_AndroidGraphicsPointF.x - this.jdField_a_of_type_AndroidGraphicsRect.width() / 2.0F, this.jdField_a_of_type_AndroidGraphicsPointF.y - this.jdField_a_of_type_AndroidGraphicsRect.height() / 2.0F, this.jdField_a_of_type_AndroidGraphicsPaint);
        postDelayed(this.jdField_a_of_type_Xlo, 60L);
        return;
        if (this.d == 2)
        {
          paramCanvas.drawBitmap(this.jdField_b_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_AndroidGraphicsPointF.x - this.jdField_a_of_type_AndroidGraphicsRect.width() / 2.0F, this.jdField_a_of_type_AndroidGraphicsPointF.y - this.jdField_a_of_type_AndroidGraphicsRect.height() / 2.0F, this.jdField_a_of_type_AndroidGraphicsPaint);
          return;
        }
        if (this.d != 4) {
          break;
        }
      } while (this.jdField_a_of_type_Xln == null);
      localObject = this.jdField_a_of_type_Xln.a();
      if (localObject != null) {
        paramCanvas.drawBitmap((Bitmap)localObject, new Rect(0, 0, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight()), new RectF(this.jdField_a_of_type_AndroidGraphicsPointF.x - ((Bitmap)localObject).getWidth() / 2.0F, this.jdField_a_of_type_AndroidGraphicsPointF.y - ((Bitmap)localObject).getHeight() / 2.0F, this.jdField_a_of_type_AndroidGraphicsPointF.x + ((Bitmap)localObject).getWidth() / 2.0F, this.jdField_a_of_type_AndroidGraphicsPointF.y + ((Bitmap)localObject).getHeight() / 2.0F), this.jdField_a_of_type_AndroidGraphicsPaint);
      }
      postDelayed(this.jdField_a_of_type_Xln, 50L);
      return;
    } while ((this.d != 5) || (this.jdField_a_of_type_Xlm == null));
    Object localObject = this.jdField_a_of_type_Xlm.a();
    Bitmap localBitmap = this.jdField_a_of_type_Xlm.a();
    if ((localBitmap != null) && (((PointF)localObject).x > 0.0F) && (((PointF)localObject).y > 0.0F)) {
      paramCanvas.drawBitmap(localBitmap, new Rect(0, 0, localBitmap.getWidth(), localBitmap.getHeight()), new RectF(((PointF)localObject).x - localBitmap.getWidth() / 2.0F, ((PointF)localObject).y - localBitmap.getHeight() / 2.0F, ((PointF)localObject).x + localBitmap.getWidth() / 2.0F, ((PointF)localObject).y + localBitmap.getHeight() / 2.0F), this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    postDelayed(this.jdField_a_of_type_Xlm, 40L);
  }
  
  private void a(Canvas paramCanvas, float paramFloat1, float paramFloat2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Drag", 2, "drawAtOrigion:" + paramFloat1 + ", " + paramFloat2);
    }
    float f1 = paramFloat1 + this.jdField_a_of_type_Float;
    float f2 = paramFloat1 / 2.0F;
    float f3 = this.jdField_a_of_type_Float;
    float f4 = paramFloat1 / 2.0F;
    float f5 = this.jdField_a_of_type_Float;
    float f6 = paramFloat1 / 2.0F;
    float f7 = this.jdField_a_of_type_Float;
    float f8 = paramFloat1 / 2.0F;
    float f9 = this.jdField_a_of_type_Float;
    paramCanvas.drawCircle(paramFloat2, paramFloat1, paramFloat1, this.jdField_a_of_type_AndroidGraphicsPaint);
    Path localPath = new Path();
    localPath.moveTo(paramFloat2 + paramFloat1, paramFloat1);
    localPath.cubicTo(paramFloat2 + f6, paramFloat1 + 0.3F * f7, paramFloat2 + f8, paramFloat1 + 0.7F * f9, paramFloat2 + paramFloat2, 0.5F + f1);
    localPath.lineTo(paramFloat2 - paramFloat2, 0.5F + f1);
    localPath.cubicTo(paramFloat2 - f4, paramFloat1 + 0.7F * f5, paramFloat2 - f2, paramFloat1 + 0.3F * f3, paramFloat2 - paramFloat1, paramFloat1);
    paramCanvas.drawPath(localPath, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.d == -1) {
      this.e = 0;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((DragFrameLayout.OnDragModeChangedListener)localIterator.next()).a(paramBoolean, this.f, this);
    }
  }
  
  public int a()
  {
    return this.d;
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void a()
  {
    if (this.d != -1)
    {
      if (this.jdField_a_of_type_Xlo != null)
      {
        getHandler().removeCallbacks(this.jdField_a_of_type_Xlo);
        this.jdField_a_of_type_Xlo = null;
      }
      if (this.jdField_a_of_type_Xln != null)
      {
        getHandler().removeCallbacks(this.jdField_a_of_type_Xln);
        this.jdField_a_of_type_Xln = null;
      }
      if (this.jdField_a_of_type_Xlm != null)
      {
        getHandler().removeCallbacks(this.jdField_a_of_type_Xlm);
        this.jdField_a_of_type_Xlm = null;
      }
      a(-1);
      a(false);
      this.jdField_b_of_type_AndroidGraphicsBitmap = null;
      this.jdField_a_of_type_AndroidViewView = null;
    }
  }
  
  public void a(View paramView, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Drag", 2, "onModeChanged:" + paramView);
    }
    this.e = 0;
    this.jdField_a_of_type_AndroidGraphicsBitmap = a(paramView);
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      this.e = this.jdField_a_of_type_AndroidGraphicsBitmap.getPixel(this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() / 2, 1);
      if (QLog.isColorLevel()) {
        QLog.d("Drag", 2, "getOrginalCachePixel:" + this.e);
      }
      Object localObject = new Matrix();
      ((Matrix)localObject).postScale(1.1F, 1.1F);
      this.jdField_b_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, 0, 0, this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth(), this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight(), (Matrix)localObject, true);
      getGlobalVisibleRect(this.jdField_a_of_type_AndroidGraphicsRect);
      int i = this.jdField_a_of_type_AndroidGraphicsRect.left;
      int j = this.jdField_a_of_type_AndroidGraphicsRect.top;
      paramView.getGlobalVisibleRect(this.jdField_a_of_type_AndroidGraphicsRect);
      localObject = this.jdField_a_of_type_AndroidGraphicsRect;
      ((Rect)localObject).left -= i;
      localObject = this.jdField_a_of_type_AndroidGraphicsRect;
      ((Rect)localObject).top -= j;
      localObject = this.jdField_a_of_type_AndroidGraphicsRect;
      ((Rect)localObject).right -= i;
      localObject = this.jdField_a_of_type_AndroidGraphicsRect;
      ((Rect)localObject).bottom -= j;
      i = this.jdField_a_of_type_AndroidGraphicsRect.width();
      j = this.jdField_a_of_type_AndroidGraphicsRect.height();
      localObject = this.jdField_a_of_type_AndroidGraphicsRect;
      ((Rect)localObject).left = ((int)(((Rect)localObject).left - (i * 1.1F - i) / 2.0F));
      localObject = this.jdField_a_of_type_AndroidGraphicsRect;
      float f1 = ((Rect)localObject).right;
      ((Rect)localObject).right = ((int)((i * 1.1F - i) / 2.0F + f1));
      localObject = this.jdField_a_of_type_AndroidGraphicsRect;
      ((Rect)localObject).bottom = ((int)(((Rect)localObject).bottom + (j * 1.1F - j) / 2.0F));
      localObject = this.jdField_a_of_type_AndroidGraphicsRect;
      ((Rect)localObject).top = ((int)(((Rect)localObject).top - (j * 1.1F - j) / 2.0F));
      this.g = ((int)(Math.min(this.jdField_a_of_type_AndroidGraphicsRect.width(), this.jdField_a_of_type_AndroidGraphicsRect.height()) * 0.8D));
      if (this.g > this.c) {
        this.g = this.c;
      }
      this.jdField_a_of_type_AndroidViewView = paramView;
      a(0);
      this.f = paramInt;
      paramView.setVisibility(4);
      invalidate();
      a(false);
      if (QLog.isColorLevel()) {
        QLog.d("Drag", 2, "init:" + this.jdField_a_of_type_AndroidGraphicsRect);
      }
    }
  }
  
  public void a(DragFrameLayout.OnDragModeChangedListener paramOnDragModeChangedListener)
  {
    if ((paramOnDragModeChangedListener != null) && (this.jdField_a_of_type_JavaUtilList.contains(paramOnDragModeChangedListener))) {
      this.jdField_a_of_type_JavaUtilList.remove(paramOnDragModeChangedListener);
    }
  }
  
  public void a(DragFrameLayout.OnDragModeChangedListener paramOnDragModeChangedListener, boolean paramBoolean)
  {
    if ((paramOnDragModeChangedListener != null) && (!this.jdField_a_of_type_JavaUtilList.contains(paramOnDragModeChangedListener)))
    {
      if (!paramBoolean) {
        this.jdField_a_of_type_JavaUtilList.add(paramOnDragModeChangedListener);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_JavaUtilList.add(0, paramOnDragModeChangedListener);
  }
  
  public void dispatchDraw(Canvas paramCanvas)
  {
    try
    {
      super.dispatchDraw(paramCanvas);
      label5:
      a(paramCanvas);
      return;
    }
    catch (Exception localException)
    {
      break label5;
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = true;
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    int i = paramMotionEvent.getAction();
    boolean bool1;
    if (this.d == -1)
    {
      if ((i == 0) && (QLog.isColorLevel())) {
        QLog.d("Drag", 2, "Host.dispatchTouchEvent: Down At<" + paramMotionEvent.getX() + ", " + paramMotionEvent.getY() + ">");
      }
      bool1 = super.dispatchTouchEvent(paramMotionEvent);
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return bool1;
                if (QLog.isColorLevel()) {
                  QLog.d("Drag", 2, "Host.dispatchTouchEvent: " + paramMotionEvent.getAction() + " At<" + paramMotionEvent.getX() + ", " + paramMotionEvent.getY() + ">");
                }
                if ((this.d != 6) && (this.f == 4))
                {
                  a(6);
                  paramMotionEvent = new RectF(this.jdField_a_of_type_AndroidGraphicsRect.centerX(), this.jdField_a_of_type_AndroidGraphicsRect.centerY(), this.jdField_a_of_type_AndroidGraphicsRect.centerX() - 6, this.jdField_a_of_type_AndroidGraphicsRect.centerY());
                  this.jdField_a_of_type_Xlo = new xlo(this, new PointF(this.jdField_a_of_type_AndroidGraphicsRect.centerX(), this.jdField_a_of_type_AndroidGraphicsRect.centerY()), paramMotionEvent);
                  invalidate();
                }
                if ((i != 3) && (i != 1)) {
                  break;
                }
                a(this.jdField_a_of_type_AndroidGraphicsRect.centerX() - f1, this.jdField_a_of_type_AndroidGraphicsRect.centerY() - f2, -1);
                if (this.d == 0)
                {
                  this.jdField_b_of_type_AndroidGraphicsBitmap = null;
                  this.jdField_a_of_type_AndroidViewView.setVisibility(0);
                  this.jdField_a_of_type_AndroidViewView = null;
                  a(-1);
                  invalidate();
                  a(false);
                  return true;
                }
                if (this.d == 1)
                {
                  a(3);
                  this.jdField_a_of_type_AndroidGraphicsPointF.set(f1, f2);
                  paramMotionEvent = new RectF(this.jdField_a_of_type_AndroidGraphicsRect.centerX(), this.jdField_a_of_type_AndroidGraphicsRect.centerY(), this.jdField_a_of_type_AndroidGraphicsPointF.x, this.jdField_a_of_type_AndroidGraphicsPointF.y);
                  this.jdField_a_of_type_Xlo = new xlo(this, new PointF(this.jdField_a_of_type_AndroidGraphicsRect.centerX(), this.jdField_a_of_type_AndroidGraphicsRect.centerY()), paramMotionEvent);
                  invalidate();
                  return true;
                }
                bool1 = bool2;
              } while (this.d == 3);
              if (this.d == 2)
              {
                if ((float)Math.sqrt((f1 - this.jdField_a_of_type_AndroidGraphicsRect.centerX()) * (f1 - this.jdField_a_of_type_AndroidGraphicsRect.centerX()) + (f2 - this.jdField_a_of_type_AndroidGraphicsRect.centerY()) * (f2 - this.jdField_a_of_type_AndroidGraphicsRect.centerY())) < (this.g + this.jdField_a_of_type_Int) / 2)
                {
                  this.jdField_b_of_type_AndroidGraphicsBitmap = null;
                  this.jdField_a_of_type_AndroidViewView.setVisibility(0);
                  this.jdField_a_of_type_AndroidViewView = null;
                  a(-1);
                  a(false);
                }
                for (;;)
                {
                  invalidate();
                  return true;
                  a(4);
                  this.jdField_a_of_type_AndroidGraphicsPointF.set(f1, f2);
                  this.jdField_a_of_type_Xln = new xln(this, this.jdField_a_of_type_AndroidGraphicsPointF);
                }
              }
              bool1 = bool2;
            } while (this.d == 4);
            bool1 = bool2;
          } while (this.d != 6);
          return true;
          bool1 = bool2;
        } while (i != 2);
        if ((this.d == 0) || (this.d == 1))
        {
          float f3 = (float)Math.sqrt((f1 - this.jdField_a_of_type_AndroidGraphicsRect.centerX()) * (f1 - this.jdField_a_of_type_AndroidGraphicsRect.centerX()) + (f2 - this.jdField_a_of_type_AndroidGraphicsRect.centerY()) * (f2 - this.jdField_a_of_type_AndroidGraphicsRect.centerY()));
          if (f3 >= this.g + this.jdField_a_of_type_Int)
          {
            this.jdField_a_of_type_Float = f3;
            this.jdField_a_of_type_AndroidGraphicsPointF.set(f1, f2);
            a(2);
            a(this.jdField_a_of_type_AndroidGraphicsRect.centerX() - f1, this.jdField_a_of_type_AndroidGraphicsRect.centerY() - f2, 2);
          }
          for (;;)
          {
            invalidate();
            return true;
            if (f3 >= 0.0F)
            {
              this.jdField_a_of_type_Float = f3;
              this.jdField_a_of_type_AndroidGraphicsPointF.set(f1, f2);
              a(1);
              a(this.jdField_a_of_type_AndroidGraphicsRect.centerX() - f1, this.jdField_a_of_type_AndroidGraphicsRect.centerY() - f2, 1);
            }
            else
            {
              a(0);
              a(0.0F, 0.0F, 0);
            }
          }
        }
        bool1 = bool2;
      } while (this.d == 3);
      if (this.d == 2)
      {
        this.jdField_a_of_type_AndroidGraphicsPointF.set(f1, f2);
        a(this.jdField_a_of_type_AndroidGraphicsRect.centerX() - f1, this.jdField_a_of_type_AndroidGraphicsRect.centerY() - f2, 2);
        invalidate();
        return true;
      }
      bool1 = bool2;
    } while (this.d != 6);
    return true;
  }
  
  public void setDragViewProvider(DragFrameLayout.IDragViewProvider paramIDragViewProvider)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout$IDragViewProvider = paramIDragViewProvider;
  }
  
  public void setOnDragListener(DragFrameLayout.OnDragListener paramOnDragListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout$OnDragListener = paramOnDragListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.cur.DragFrameLayout
 * JD-Core Version:    0.7.0.1
 */