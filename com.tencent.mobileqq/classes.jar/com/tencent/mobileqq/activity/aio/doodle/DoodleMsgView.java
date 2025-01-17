package com.tencent.mobileqq.activity.aio.doodle;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import java.util.Timer;
import java.util.TimerTask;
import mqq.util.WeakReference;
import uro;
import urr;
import urt;

public class DoodleMsgView
  extends View
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = -1L;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Canvas jdField_a_of_type_AndroidGraphicsCanvas;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  private DoodleDrawer.DoodleDrawerListener jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleDrawer$DoodleDrawerListener;
  private DoodleDrawer jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleDrawer;
  private Timer jdField_a_of_type_JavaUtilTimer;
  private TimerTask jdField_a_of_type_JavaUtilTimerTask;
  private WeakReference jdField_a_of_type_MqqUtilWeakReference;
  private int jdField_b_of_type_Int;
  private Paint jdField_b_of_type_AndroidGraphicsPaint;
  
  public DoodleMsgView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleDrawer != null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleDrawer = new DoodleDrawer();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleDrawer$DoodleDrawerListener = new uro(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleDrawer.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleDrawer$DoodleDrawerListener, 1, paramInt1, paramInt2);
  }
  
  private boolean a()
  {
    return this.jdField_a_of_type_JavaUtilTimerTask != null;
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    bool = true;
    label99:
    try
    {
      if ((this.jdField_a_of_type_AndroidGraphicsCanvas != null) && (this.jdField_a_of_type_AndroidGraphicsBitmap != null)) {
        return true;
      }
    }
    finally {}
    try
    {
      if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
      {
        DoodleResHelper.a().a(this.jdField_a_of_type_AndroidGraphicsBitmap);
        this.jdField_a_of_type_AndroidGraphicsBitmap = null;
      }
      this.jdField_a_of_type_AndroidGraphicsCanvas = null;
      this.jdField_a_of_type_AndroidGraphicsBitmap = DoodleResHelper.a().c(paramInt1, paramInt2);
      if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
        break label207;
      }
      this.jdField_a_of_type_AndroidGraphicsCanvas = new Canvas(this.jdField_a_of_type_AndroidGraphicsBitmap);
      this.jdField_a_of_type_AndroidGraphicsCanvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
    }
    catch (Exception localException)
    {
      QLog.e("DoodleMsgView", 2, "create bitmapcache execption!" + localException);
      if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
        break label160;
      }
      DoodleResHelper.a().a(this.jdField_a_of_type_AndroidGraphicsBitmap);
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
      this.jdField_a_of_type_AndroidGraphicsCanvas = null;
      bool = false;
      break label99;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      QLog.e("DoodleMsgView", 2, "create bitmapcache OOM!");
      if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
        break label202;
      }
      DoodleResHelper.a().a(this.jdField_a_of_type_AndroidGraphicsBitmap);
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
      this.jdField_a_of_type_AndroidGraphicsCanvas = null;
      bool = false;
      break label99;
    }
    return bool;
  }
  
  private void b(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleDrawer == null) {
      return;
    }
    long l1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleDrawer.a();
    label34:
    Object localObject;
    TimerTask localTimerTask;
    if (l1 <= 3000L)
    {
      l1 = (int)((float)l1 * 1.0F / 1.2F);
      l1 /= 25L;
      long l2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleDrawer.a();
      this.jdField_a_of_type_JavaUtilTimerTask = new urr(this, l2, l2 / (l1 + 1L));
      this.jdField_a_of_type_JavaUtilTimer = new Timer();
      this.jdField_a_of_type_Long = 0L;
      localObject = this.jdField_a_of_type_JavaUtilTimer;
      localTimerTask = this.jdField_a_of_type_JavaUtilTimerTask;
      if (paramLong <= 0L) {
        break label180;
      }
    }
    for (;;)
    {
      ((Timer)localObject).schedule(localTimerTask, paramLong, 25L);
      if (this.jdField_a_of_type_MqqUtilWeakReference == null) {
        break;
      }
      localObject = (urt)this.jdField_a_of_type_MqqUtilWeakReference.get();
      if (localObject == null) {
        break;
      }
      ((urt)localObject).f();
      return;
      if (l1 <= 20000L)
      {
        l1 = (int)((float)l1 * 1.0F / 1.5F);
        break label34;
      }
      l1 = (int)((float)l1 * 1.0F / 1.8F);
      break label34;
      label180:
      paramLong = 0L;
    }
  }
  
  private void e()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidGraphicsPaint == null)
      {
        this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
        this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
      }
      if ((this.jdField_a_of_type_AndroidGraphicsCanvas != null) && (this.jdField_a_of_type_AndroidGraphicsPaint != null)) {
        this.jdField_a_of_type_AndroidGraphicsCanvas.drawPaint(this.jdField_a_of_type_AndroidGraphicsPaint);
      }
      return;
    }
    finally {}
  }
  
  private void f()
  {
    try
    {
      if (this.jdField_a_of_type_JavaUtilTimerTask != null)
      {
        this.jdField_a_of_type_JavaUtilTimerTask.cancel();
        this.jdField_a_of_type_JavaUtilTimerTask = null;
      }
      if (this.jdField_a_of_type_JavaUtilTimer != null)
      {
        this.jdField_a_of_type_JavaUtilTimer.cancel();
        this.jdField_a_of_type_JavaUtilTimer = null;
      }
      return;
    }
    finally {}
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleDrawer != null) {
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleDrawer.b();
    }
    return 4;
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleDrawer != null)
    {
      d();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleDrawer.a();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleDrawer = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleDrawer$DoodleDrawerListener = null;
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      DoodleResHelper.a().a(this.jdField_a_of_type_AndroidGraphicsBitmap);
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    }
    QLog.d("DoodleMsgView", 2, "DoodleMsgView unInit");
  }
  
  public void a(long paramLong)
  {
    QLog.d("DoodleMsgView", 2, "play:");
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleDrawer == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleDrawer.c() == 0))
    {
      if (this.jdField_a_of_type_MqqUtilWeakReference != null)
      {
        urt localurt = (urt)this.jdField_a_of_type_MqqUtilWeakReference.get();
        if (localurt != null) {
          localurt.g();
        }
      }
      return;
    }
    if (a()) {
      d();
    }
    b(paramLong);
  }
  
  public void a(Runnable paramRunnable)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(paramRunnable);
  }
  
  public void a(urt paramurt, int paramInt1, int paramInt2)
  {
    QLog.d("DoodleMsgView", 2, "DoodleMsgView init begin");
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramurt);
    this.jdField_a_of_type_AndroidGraphicsCanvas = null;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    a(paramInt1, paramInt2);
    QLog.d("DoodleMsgView", 2, "DoodleMsgView init end");
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleDrawer != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleDrawer.a(paramBoolean);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleDrawer != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleDrawer.b();
    }
  }
  
  public void c()
  {
    e();
    invalidate();
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoodleMsgView", 2, "stop");
    }
    f();
    this.jdField_a_of_type_Long = -9223372036854775808L;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleDrawer != null) && (isShown()))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleDrawer.a(2147483647L, false);
      if (QLog.isColorLevel()) {
        QLog.d("DoodleMsgView", 2, "preparesegments");
      }
    }
    QLog.d("DoodleMsgView", 2, "stop end");
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleDrawer != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleDrawer.b() != 0))
    {
      QLog.d("DoodleMsgView", 2, "onDraw not ready");
      return;
    }
    try
    {
      if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
        paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, new Rect(0, 0, this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth(), this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight()), new Rect(0, 0, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int), null);
      }
      return;
    }
    finally {}
  }
  
  public void setContent(String paramString, boolean paramBoolean)
  {
    QLog.d("DoodleMsgView", 2, "setContent:" + paramString + " prepare:" + paramBoolean);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleDrawer == null) {}
    do
    {
      do
      {
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleDrawer.a(paramString, paramBoolean, getContext()))
        {
          QLog.d("DoodleMsgView", 2, "drawer setdata return true:");
          f();
          return;
        }
        QLog.d("DoodleMsgView", 2, "drawer setdata same data:" + a());
      } while (this.jdField_a_of_type_MqqUtilWeakReference == null);
      paramString = (urt)this.jdField_a_of_type_MqqUtilWeakReference.get();
    } while (paramString == null);
    paramString.a(a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.DoodleMsgView
 * JD-Core Version:    0.7.0.1
 */