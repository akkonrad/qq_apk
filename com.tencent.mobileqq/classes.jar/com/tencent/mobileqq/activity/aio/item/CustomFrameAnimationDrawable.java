package com.tencent.mobileqq.activity.aio.item;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import com.immersion.stickersampleapp.HapticManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import mqq.os.MqqHandler;
import uvo;
import uvp;
import uvq;

public class CustomFrameAnimationDrawable
  extends Drawable
  implements Runnable
{
  private int jdField_a_of_type_Int;
  Resources jdField_a_of_type_AndroidContentResResources = null;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap = null;
  Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  CustomFrameAnimationDrawable.AnimationEndListener jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$AnimationEndListener = null;
  public CustomFrameAnimationDrawable.FrameAnimationState a;
  private CustomFrameAnimationDrawable.FrameListener jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameListener;
  private String jdField_a_of_type_JavaLangString;
  ArrayList jdField_a_of_type_JavaUtilArrayList;
  private Vector jdField_a_of_type_JavaUtilVector;
  MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  public uvp a;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = 160;
  private boolean jdField_b_of_type_Boolean = true;
  private int c;
  private int d;
  
  public CustomFrameAnimationDrawable(Resources paramResources, Bitmap paramBitmap, MqqHandler paramMqqHandler)
  {
    this.jdField_a_of_type_Uvp = null;
    this.jdField_a_of_type_MqqOsMqqHandler = paramMqqHandler;
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    this.jdField_a_of_type_JavaUtilArrayList = null;
    this.jdField_a_of_type_AndroidContentResResources = paramResources;
    this.jdField_a_of_type_JavaUtilArrayList = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState = new CustomFrameAnimationDrawable.FrameAnimationState();
    this.jdField_a_of_type_JavaUtilVector = new Vector();
    int j;
    if (paramResources != null)
    {
      j = paramResources.getDisplayMetrics().densityDpi;
      if (j != 0) {}
    }
    for (this.jdField_b_of_type_Int = i;; this.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_b_of_type_Int)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_b_of_type_Int = this.jdField_b_of_type_Int;
      if (paramBitmap == null) {
        break label195;
      }
      this.jdField_c_of_type_Int = paramBitmap.getScaledWidth(this.jdField_b_of_type_Int);
      this.jdField_d_of_type_Int = paramBitmap.getScaledHeight(this.jdField_b_of_type_Int);
      return;
      i = j;
      break;
    }
    label195:
    this.jdField_d_of_type_Int = -1;
    this.jdField_c_of_type_Int = -1;
  }
  
  public CustomFrameAnimationDrawable(Resources paramResources, Bitmap paramBitmap, MqqHandler paramMqqHandler, CustomFrameAnimationDrawable.FrameAnimationState paramFrameAnimationState, String paramString, boolean paramBoolean)
  {
    this(paramResources, paramBitmap, paramMqqHandler);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState = paramFrameAnimationState;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = paramBoolean;
    if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_Boolean)) {
      ThreadManager.postImmediately(new uvo(this), null, true);
    }
  }
  
  private CustomFrameAnimationDrawable(CustomFrameAnimationDrawable.FrameAnimationState paramFrameAnimationState, Resources paramResources)
  {
    this.jdField_a_of_type_Uvp = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState = paramFrameAnimationState;
    a(paramResources);
  }
  
  private void a(Resources paramResources)
  {
    int i;
    if (paramResources != null)
    {
      int j = paramResources.getDisplayMetrics().densityDpi;
      i = j;
      if (j == 0) {
        i = 160;
      }
    }
    for (this.jdField_b_of_type_Int = i;; this.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_b_of_type_Int)
    {
      k();
      return;
    }
  }
  
  public static boolean a()
  {
    return (!Build.VERSION.RELEASE.equals("5.0.2")) || ((!Build.MODEL.equals("SM-A5009")) && (!Build.MODEL.equals("SM-A7000")) && (!Build.MODEL.equals("Redmi Note 2")));
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      if (this.jdField_a_of_type_JavaUtilArrayList.size() != 0) {
        break label48;
      }
    }
    label48:
    for (Bitmap localBitmap = null; localBitmap != null; localBitmap = (Bitmap)this.jdField_a_of_type_JavaUtilArrayList.get(0))
    {
      this.jdField_c_of_type_Int = localBitmap.getScaledWidth(this.jdField_b_of_type_Int);
      this.jdField_d_of_type_Int = localBitmap.getScaledHeight(this.jdField_b_of_type_Int);
      return;
    }
    this.jdField_d_of_type_Int = -1;
    this.jdField_c_of_type_Int = -1;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_Int;
  }
  
  public Bitmap a()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_b_of_type_JavaUtilArrayList != null)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_b_of_type_JavaUtilArrayList.size() > 0) {
        localObject1 = (Bitmap)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_b_of_type_JavaUtilArrayList.remove(0);
      }
    }
    return localObject1;
  }
  
  public uvq a(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState != null)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_JavaUtilArrayList != null)
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_JavaUtilArrayList.size() > 0)
        {
          localObject1 = localObject2;
          if (paramInt >= 0)
          {
            localObject1 = localObject2;
            if (paramInt < this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_JavaUtilArrayList.size()) {
              localObject1 = (uvq)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
            }
          }
        }
      }
    }
    return localObject1;
  }
  
  public void a()
  {
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_d_of_type_Int = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    uvq localuvq = new uvq();
    localuvq.jdField_a_of_type_Int = paramInt1;
    localuvq.jdField_b_of_type_Int = paramInt2;
    localuvq.jdField_c_of_type_Int = paramInt3;
    localuvq.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_JavaUtilArrayList.add(localuvq);
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    uvq localuvq = new uvq();
    localuvq.jdField_a_of_type_Int = paramInt1;
    localuvq.jdField_b_of_type_Int = paramInt2;
    localuvq.jdField_a_of_type_JavaLangString = paramString;
    localuvq.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_JavaUtilArrayList.add(localuvq);
  }
  
  public void a(Bitmap paramBitmap)
  {
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
  }
  
  public void a(CustomFrameAnimationDrawable.AnimationEndListener paramAnimationEndListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$AnimationEndListener = paramAnimationEndListener;
  }
  
  public void a(CustomFrameAnimationDrawable.FrameListener paramFrameListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameListener = paramFrameListener;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_JavaUtilArrayList.size() - 1;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_b_of_type_Boolean = true;
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_c_of_type_Int = paramInt;
  }
  
  public void c()
  {
    unscheduleSelf(this);
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) && (this.jdField_a_of_type_AndroidGraphicsBitmap != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_c_of_type_Int = 0;
      invalidateSelf();
      scheduleSelf(this, 0L);
    }
    while (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_JavaUtilArrayList.size() == 0)
    {
      if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_Boolean)) {
        this.jdField_a_of_type_Int = HapticManager.a().a(this.jdField_a_of_type_JavaLangString, 2);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_c_of_type_Boolean = false;
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_JavaUtilArrayList.size() == -1) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_JavaUtilArrayList.size() == 0)) {}
    for (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_Int = -1;; this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_Int = 0)
    {
      scheduleSelf(this, 0L);
      break;
    }
  }
  
  public void d()
  {
    unscheduleSelf(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_Boolean = true;
    scheduleSelf(this, 0L);
  }
  
  public void draw(Canvas paramCanvas)
  {
    Paint localPaint = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_AndroidGraphicsPaint;
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) && (this.jdField_a_of_type_AndroidGraphicsBitmap != null)) {
      if (this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())
      {
        if (QLog.isColorLevel()) {
          QLog.d("CustomFrameAnimationDrawable", 2, "draw use recycle bitmap");
        }
        this.jdField_a_of_type_AndroidGraphicsBitmap = null;
      }
    }
    label484:
    for (;;)
    {
      return;
      Object localObject = this.jdField_a_of_type_AndroidGraphicsBitmap;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_b_of_type_Boolean)
      {
        paramCanvas.save();
        paramCanvas.scale(-1.0F, 1.0F, this.jdField_c_of_type_Int / 2, this.jdField_d_of_type_Int / 2);
      }
      this.jdField_a_of_type_AndroidGraphicsRect.set(0, 0, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
      this.jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, this.jdField_c_of_type_Int, this.jdField_d_of_type_Int);
      int i = paramCanvas.getWidth();
      float f = paramCanvas.getHeight() * 1.0F / this.jdField_d_of_type_Int;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_d_of_type_Int == 1) {
        paramCanvas.translate((i / f - this.jdField_c_of_type_Int) / 2.0F, 0.0F);
      }
      for (;;)
      {
        paramCanvas.drawBitmap((Bitmap)localObject, this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsRectF, localPaint);
        if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_b_of_type_Boolean) {
          break;
        }
        paramCanvas.restore();
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_d_of_type_Int == 2) {
          paramCanvas.translate(Math.abs(i / f - this.jdField_c_of_type_Int) / 2.0F, 0.0F);
        }
      }
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_Int < 0) {
          localObject = null;
        }
        for (;;)
        {
          if ((localObject == null) || (((Bitmap)localObject).isRecycled())) {
            break label484;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_b_of_type_Boolean)
          {
            paramCanvas.save();
            paramCanvas.scale(-1.0F, 1.0F, ((Bitmap)localObject).getWidth() / 2, ((Bitmap)localObject).getHeight() / 2);
          }
          this.jdField_a_of_type_AndroidGraphicsRect.set(0, 0, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
          this.jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
          paramCanvas.drawBitmap((Bitmap)localObject, 0.0F, 0.0F, localPaint);
          if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_b_of_type_Boolean) {
            break;
          }
          paramCanvas.restore();
          return;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_Int >= this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_JavaUtilArrayList.size())
          {
            localObject = (Bitmap)this.jdField_a_of_type_JavaUtilArrayList.get(((uvq)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_JavaUtilArrayList.size() - 1)).jdField_a_of_type_Int);
          }
          else
          {
            localObject = (uvq)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_Int);
            localObject = (Bitmap)this.jdField_a_of_type_JavaUtilArrayList.get(((uvq)localObject).jdField_a_of_type_Int);
          }
        }
      }
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_Boolean) {
      unscheduleSelf(this);
    }
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) && (this.jdField_a_of_type_AndroidGraphicsBitmap != null))
    {
      int i = 0;
      while (i < this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_b_of_type_JavaUtilArrayList.size())
      {
        ((Bitmap)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_b_of_type_JavaUtilArrayList.remove(0)).recycle();
        i += 1;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_b_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_Int;
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_Boolean) {
      unscheduleSelf(this);
    }
  }
  
  public void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_d_of_type_Boolean = true;
  }
  
  public int getAlpha()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_AndroidGraphicsPaint.getAlpha();
  }
  
  public int getIntrinsicHeight()
  {
    return this.jdField_d_of_type_Int;
  }
  
  public int getIntrinsicWidth()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_JavaUtilArrayList != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_JavaUtilArrayList.clear();
    }
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_b_of_type_JavaUtilArrayList;
    Object localObject2 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Bitmap localBitmap = (Bitmap)((Iterator)localObject2).next();
      if ((localBitmap != null) && (!localBitmap.isRecycled())) {
        localBitmap.recycle();
      }
    }
    ((ArrayList)localObject1).clear();
    if (this.jdField_a_of_type_JavaUtilVector != null)
    {
      localObject1 = this.jdField_a_of_type_JavaUtilVector.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Bitmap)((Iterator)localObject1).next();
        if ((localObject2 != null) && (!((Bitmap)localObject2).isRecycled())) {
          ((Bitmap)localObject2).recycle();
        }
      }
      this.jdField_a_of_type_JavaUtilVector.clear();
    }
  }
  
  public void j()
  {
    unscheduleSelf(this);
    if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_Boolean)) {
      HapticManager.a().a(this.jdField_a_of_type_Int);
    }
  }
  
  public void run()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) && (this.jdField_a_of_type_AndroidGraphicsBitmap != null))
    {
      int j = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_Int + 1;
      int i = j;
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_d_of_type_Boolean) {
        i = j % this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_JavaUtilArrayList.size();
      }
      if (i < this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_JavaUtilArrayList.size())
      {
        localObject1 = a();
        Object localObject2;
        if (localObject1 != null)
        {
          localObject2 = this.jdField_a_of_type_AndroidGraphicsBitmap;
          if (this.jdField_a_of_type_JavaUtilVector.size() <= 2) {
            this.jdField_a_of_type_JavaUtilVector.add(localObject2);
          }
          this.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)localObject1);
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState;
          ((CustomFrameAnimationDrawable.FrameAnimationState)localObject1).jdField_a_of_type_Int += 1;
          if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_d_of_type_Boolean)
          {
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState;
            ((CustomFrameAnimationDrawable.FrameAnimationState)localObject1).jdField_a_of_type_Int %= this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_JavaUtilArrayList.size();
          }
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameListener != null) {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameListener.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_Int);
          }
          invalidateSelf();
        }
        j = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_c_of_type_Int + 1;
        i = j;
        if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_d_of_type_Boolean) {
          i = j % this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_JavaUtilArrayList.size();
        }
        if (i < this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_JavaUtilArrayList.size())
        {
          if (i - this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_c_of_type_Int < 2)
          {
            localObject1 = (uvq)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_JavaUtilArrayList.get(i);
            if (this.jdField_a_of_type_Uvp == null)
            {
              this.jdField_a_of_type_Uvp = new uvp(this, i, ((uvq)localObject1).jdField_a_of_type_JavaLangString, ((uvq)localObject1).jdField_c_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_b_of_type_JavaUtilArrayList);
              this.jdField_a_of_type_Uvp.a(this.jdField_a_of_type_AndroidContentResResources);
              if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
                this.jdField_a_of_type_MqqOsMqqHandler.post(this.jdField_a_of_type_Uvp);
              }
              localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState;
              ((CustomFrameAnimationDrawable.FrameAnimationState)localObject1).jdField_c_of_type_Int += 1;
              if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_d_of_type_Boolean)
              {
                localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState;
                ((CustomFrameAnimationDrawable.FrameAnimationState)localObject1).jdField_c_of_type_Int %= this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_JavaUtilArrayList.size();
              }
            }
          }
          localObject1 = (uvq)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_Int);
          scheduleSelf(this, SystemClock.uptimeMillis() + ((uvq)localObject1).jdField_b_of_type_Int);
          if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_Boolean))
          {
            localObject2 = HapticManager.a();
            i = this.jdField_a_of_type_Int;
            j = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_Int;
            ((HapticManager)localObject2).a(i, ((uvq)localObject1).jdField_b_of_type_Int * j);
          }
        }
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$AnimationEndListener != null) {
              this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$AnimationEndListener.a();
            }
            if (this.jdField_b_of_type_Boolean)
            {
              i();
              this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_JavaUtilArrayList.clear();
            }
            this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_Boolean = false;
            this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_c_of_type_Boolean = true;
            return;
            if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$AnimationEndListener != null) {
              this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$AnimationEndListener.a();
            }
            if (this.jdField_b_of_type_Boolean)
            {
              i();
              this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_JavaUtilArrayList.clear();
            }
            this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_Boolean = false;
            this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_c_of_type_Boolean = true;
          } while (this.jdField_a_of_type_JavaLangString == null);
          if (this.jdField_a_of_type_Boolean) {
            HapticManager.a().c(this.jdField_a_of_type_Int);
          }
          this.jdField_a_of_type_Int = 0;
          return;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_JavaUtilArrayList.size() != 1) {
            break;
          }
          invalidateSelf();
        } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameListener == null);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameListener.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_Int);
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_d_of_type_Boolean != true) {
          break;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_Int < this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_JavaUtilArrayList.size())
        {
          invalidateSelf();
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameListener != null) {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameListener.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_Int);
          }
          localObject1 = (uvq)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_Int);
          l = SystemClock.uptimeMillis();
          scheduleSelf(this, ((uvq)localObject1).jdField_b_of_type_Int + l);
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState;
          ((CustomFrameAnimationDrawable.FrameAnimationState)localObject1).jdField_a_of_type_Int += 1;
          return;
        }
      } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_c_of_type_Boolean);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$AnimationEndListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$AnimationEndListener.a();
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_c_of_type_Boolean = true;
    } while (this.jdField_a_of_type_JavaLangString == null);
    if (this.jdField_a_of_type_Boolean) {
      HapticManager.a().c(this.jdField_a_of_type_Int);
    }
    this.jdField_a_of_type_Int = 0;
    return;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_Int %= this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_JavaUtilArrayList.size();
    invalidateSelf();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameListener.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_Int);
    }
    Object localObject1 = (uvq)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_Int);
    long l = SystemClock.uptimeMillis();
    scheduleSelf(this, ((uvq)localObject1).jdField_b_of_type_Int + l);
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState;
    ((CustomFrameAnimationDrawable.FrameAnimationState)localObject1).jdField_a_of_type_Int += 1;
  }
  
  public void setAlpha(int paramInt)
  {
    if (paramInt != this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_AndroidGraphicsPaint.getAlpha())
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(paramInt);
      invalidateSelf();
    }
  }
  
  public void setBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable$FrameAnimationState.jdField_a_of_type_AndroidGraphicsPaint.setColorFilter(paramColorFilter);
    invalidateSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.CustomFrameAnimationDrawable
 * JD-Core Version:    0.7.0.1
 */