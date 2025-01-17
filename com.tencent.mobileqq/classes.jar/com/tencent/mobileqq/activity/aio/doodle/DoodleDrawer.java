package com.tencent.mobileqq.activity.aio.doodle;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.scribble.ScribbleResMgr.ResCallback;
import com.tencent.mobileqq.scribble.ScribbleResMgr.ResInfo;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.FileOutputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import urd;
import ure;
import usq;

public class DoodleDrawer
  implements ScribbleResMgr.ResCallback, usq
{
  private int jdField_a_of_type_Int = -1;
  private long jdField_a_of_type_Long = -1L;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Canvas jdField_a_of_type_AndroidGraphicsCanvas;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private View jdField_a_of_type_AndroidViewView;
  private DoodleParam jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleParam = new DoodleParam();
  private LoadDataJob jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLoadDataJob;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private String jdField_a_of_type_JavaLangString;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  private Map jdField_a_of_type_JavaUtilMap = new HashMap();
  private ure jdField_a_of_type_Ure = new ure(this);
  boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 0;
  private long jdField_b_of_type_Long = -1L;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private int d;
  
  private String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return null;
      try
      {
        paramString = paramString.substring(0, paramString.lastIndexOf('_')) + "_cache";
        boolean bool = FileUtils.a(paramString);
        if (bool) {
          return paramString;
        }
      }
      catch (Exception paramString) {}
    }
    return null;
  }
  
  private void a(int paramInt)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        PathDrawer localPathDrawer = (PathDrawer)localIterator.next();
        if (localPathDrawer.a() == paramInt) {
          localPathDrawer.b(paramInt);
        }
      }
    }
  }
  
  private void a(String paramString, long paramLong)
  {
    int i = 0;
    if ((this.jdField_a_of_type_JavaLangString == null) || (!this.jdField_a_of_type_JavaLangString.equalsIgnoreCase(paramString))) {}
    DoodleDrawer.DoodleDrawerListener localDoodleDrawerListener;
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_JavaLangRefWeakReference == null);
      localDoodleDrawerListener = (DoodleDrawer.DoodleDrawerListener)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (localDoodleDrawerListener == null);
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      localDoodleDrawerListener.a(paramString, paramLong, this.jdField_a_of_type_AndroidGraphicsBitmap);
    }
  }
  
  private void a(String paramString, long paramLong, List paramList)
  {
    if ((this.jdField_a_of_type_Int != 3) && (this.jdField_a_of_type_Int != 0)) {
      break label15;
    }
    label15:
    while (paramList == null) {
      return;
    }
    if (!a())
    {
      a(paramString, this.jdField_a_of_type_Long);
      return;
    }
    if (paramLong < this.jdField_a_of_type_Long) {
      d();
    }
    if (paramLong < 0L)
    {
      a(paramString, this.jdField_a_of_type_Long);
      return;
    }
    long l1 = a(paramList);
    if (this.jdField_a_of_type_Long >= l1)
    {
      a(paramString, this.jdField_a_of_type_Long);
      return;
    }
    if (paramLong >= l1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DoodleDrawer", 2, "draw last frame try use cache");
      }
      if (a(paramString, l1))
      {
        if (QLog.isColorLevel()) {
          QLog.d("DoodleDrawer", 2, "cache ok, drawfilecache finish");
        }
        a(paramString, this.jdField_a_of_type_Long);
        return;
      }
    }
    long l2 = this.jdField_a_of_type_Long;
    if (paramLong > l1) {
      paramLong = l1;
    }
    while (this.jdField_a_of_type_Long < paramLong)
    {
      long l3 = System.currentTimeMillis();
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (a(this.jdField_a_of_type_AndroidGraphicsCanvas, l2, paramLong, l1, paramList)) {
          if (this.jdField_a_of_type_Long < paramLong) {
            this.jdField_a_of_type_Long = paramLong;
          }
        }
        do
        {
          do
          {
            a(paramString, this.jdField_a_of_type_Long);
            return;
            break;
            this.jdField_a_of_type_Long = l1;
            l2 = System.currentTimeMillis();
          } while ((l2 - l3 <= 1000L) || (paramLong < l1));
          if (QLog.isColorLevel()) {
            QLog.d("DoodleDrawer", 2, "creage file cache:" + (l2 - l3) + "-" + paramString);
          }
          a(paramString, this.jdField_a_of_type_AndroidGraphicsBitmap);
        } while (!QLog.isColorLevel());
        QLog.d("DoodleDrawer", 2, "creage file cache end");
      }
    }
  }
  
  private void a(String paramString, Bitmap paramBitmap)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramBitmap == null)) {}
    do
    {
      return;
      paramString = paramString.substring(0, paramString.lastIndexOf('_')) + "_cache";
    } while (FileUtils.a(paramString));
    String str = paramString + "tmp";
    if (FileUtils.a(str)) {
      FileUtils.d(str);
    }
    try
    {
      FileOutputStream localFileOutputStream = new FileOutputStream(str);
      paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, localFileOutputStream);
      localFileOutputStream.flush();
      localFileOutputStream.close();
      FileUtils.c(str, paramString);
      return;
    }
    catch (Exception paramBitmap)
    {
      paramBitmap.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.e("DoodleDrawer", 2, "saveFileCache exception:" + paramBitmap);
      }
      FileUtils.a(paramString, true);
    }
  }
  
  private boolean a()
  {
    bool = true;
    if ((this.d <= 0) || (this.jdField_c_of_type_Int <= 0))
    {
      if (QLog.isColorLevel()) {
        QLog.e("DoodleDrawer", 2, "checkcache error:" + this.jdField_c_of_type_Int + "-" + this.d);
      }
      return false;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (this.jdField_a_of_type_AndroidGraphicsCanvas != null)) {
        return true;
      }
    }
    try
    {
      if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
      {
        DoodleResHelper.a().a(this.jdField_a_of_type_AndroidGraphicsBitmap);
        this.jdField_a_of_type_AndroidGraphicsBitmap = null;
      }
      this.jdField_a_of_type_AndroidGraphicsBitmap = DoodleResHelper.a().c(this.jdField_c_of_type_Int, this.d);
      if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
      {
        this.jdField_a_of_type_AndroidGraphicsCanvas = new Canvas(this.jdField_a_of_type_AndroidGraphicsBitmap);
        this.jdField_a_of_type_AndroidGraphicsCanvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
        this.jdField_c_of_type_Int = this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
        this.d = this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
      }
      d();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("DoodleDrawer", 2, "create bitmapcache execption!" + localException);
        }
        if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
        {
          DoodleResHelper.a().a(this.jdField_a_of_type_AndroidGraphicsBitmap);
          this.jdField_a_of_type_AndroidGraphicsBitmap = null;
        }
        this.jdField_a_of_type_AndroidGraphicsCanvas = null;
        this.jdField_a_of_type_Long = -1L;
        bool = false;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("DoodleDrawer", 2, "create bitmapcache OOM!");
        }
        if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
        {
          DoodleResHelper.a().a(this.jdField_a_of_type_AndroidGraphicsBitmap);
          this.jdField_a_of_type_AndroidGraphicsBitmap = null;
        }
        this.jdField_a_of_type_AndroidGraphicsCanvas = null;
        this.jdField_a_of_type_Long = -1L;
        bool = false;
      }
    }
    return bool;
  }
  
  private boolean a(Canvas paramCanvas, long paramLong1, long paramLong2, long paramLong3, List paramList)
  {
    if ((paramLong1 > paramLong2) || (paramCanvas == null))
    {
      if (QLog.isColorLevel()) {
        QLog.e("DoodleDrawer", 2, "drawSegmentsInner:param error: " + paramLong1 + " " + paramLong2);
      }
      return false;
    }
    if ((this.jdField_a_of_type_Int != 3) && (this.jdField_a_of_type_Int != 0)) {
      return false;
    }
    paramList = paramList.iterator();
    long l1 = 0L;
    long l2 = 0L;
    PathDrawer localPathDrawer;
    long l3;
    if (paramList.hasNext())
    {
      localPathDrawer = (PathDrawer)paramList.next();
      if (a() == 1) {}
      for (l3 = localPathDrawer.a();; l3 = localPathDrawer.b())
      {
        if (l2 + l3 + l1 > paramLong1) {
          break label167;
        }
        l1 = 100L + l1;
        l2 = l3 + l2;
        break;
      }
      label167:
      if (l2 + l3 + l1 <= paramLong2)
      {
        if (this.jdField_a_of_type_Long < paramLong2) {
          localPathDrawer.a(paramCanvas);
        }
        l2 = l3 + l2;
        label204:
        l1 = 100L + l1;
        if (l2 + l1 <= paramLong2) {
          break label289;
        }
      }
    }
    for (;;)
    {
      if (l1 + l2 - 100L >= paramLong3)
      {
        return false;
        l3 = 0L;
        if (paramLong1 > l2 + l1) {
          l3 = paramLong1 - l2 - l1;
        }
        localPathDrawer.a(paramCanvas, l3, paramLong2 - l2 - l1);
        l2 = paramLong2 - l1;
        break label204;
        label289:
        break;
      }
      return true;
    }
  }
  
  private boolean a(String arg1, long paramLong)
  {
    try
    {
      ??? = a(???);
      if (TextUtils.isEmpty(???)) {
        return false;
      }
      Bitmap localBitmap = BitmapFactory.decodeFile(???);
      if (localBitmap != null)
      {
        Paint localPaint = new Paint();
        localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        localPaint.setAntiAlias(true);
        synchronized (this.jdField_a_of_type_JavaLangObject)
        {
          if (this.jdField_a_of_type_AndroidGraphicsCanvas != null)
          {
            Rect localRect1 = new Rect(0, 0, localBitmap.getWidth(), localBitmap.getHeight());
            Rect localRect2 = new Rect(0, 0, this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth(), this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight());
            this.jdField_a_of_type_AndroidGraphicsCanvas.drawBitmap(localBitmap, localRect1, localRect2, localPaint);
          }
          this.jdField_a_of_type_Long = paramLong;
          localBitmap.recycle();
          return true;
        }
      }
      return false;
    }
    catch (Exception ???)
    {
      return false;
    }
    catch (OutOfMemoryError ???) {}
  }
  
  private boolean b(String paramString)
  {
    try
    {
      if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.equalsIgnoreCase(paramString))) {
        return true;
      }
      this.jdField_a_of_type_JavaLangString = paramString;
      return false;
    }
    finally {}
  }
  
  private void c()
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_b_of_type_Long = -1L;
      return;
    }
  }
  
  private void d()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_AndroidGraphicsPaint == null)
      {
        this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
        this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
      }
      if ((this.jdField_a_of_type_AndroidGraphicsCanvas != null) && (this.jdField_a_of_type_AndroidGraphicsPaint != null)) {
        this.jdField_a_of_type_AndroidGraphicsCanvas.drawPaint(this.jdField_a_of_type_AndroidGraphicsPaint);
      }
      this.jdField_a_of_type_Long = -1L;
      return;
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_Ure != null) {
      this.jdField_a_of_type_Ure.c();
    }
    a(-1L, false);
    try
    {
      this.jdField_a_of_type_Int = -1;
      this.jdField_b_of_type_Boolean = false;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLoadDataJob != null)
      {
        ThreadManager.remove(this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLoadDataJob);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLoadDataJob = null;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLoadDataJob = new LoadDataJob(this.jdField_a_of_type_JavaLangString, this.jdField_c_of_type_Int, this.d, this);
      ThreadManager.post(this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLoadDataJob, 5, null, true);
      QLog.d("DoodleDrawer", 2, "run task now:" + this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_Int = 1;
      return;
    }
    finally {}
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_Int != 3)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DoodleDrawer", 2, "onTextureReady: state error:" + this.jdField_a_of_type_Int);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("DoodleDrawer", 2, "onTextureReady: prepare:" + this.jdField_c_of_type_Boolean);
    }
    if (this.jdField_c_of_type_Boolean)
    {
      a(2147483647L, false);
      return;
    }
    a(-1L, false);
  }
  
  public final int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public long a()
  {
    long l = 0L;
    if (this.jdField_b_of_type_Long > 0L) {}
    for (;;)
    {
      return this.jdField_b_of_type_Long;
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        if (this.jdField_a_of_type_JavaUtilList.size() == 0) {
          this.jdField_b_of_type_Long = 0L;
        }
      }
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    for (;;)
    {
      if (localIterator.hasNext())
      {
        PathDrawer localPathDrawer = (PathDrawer)localIterator.next();
        if (a() == 1) {
          l = localPathDrawer.a() + l;
        } else if (a() == 0) {
          l = localPathDrawer.b() + l;
        }
      }
      else
      {
        this.jdField_b_of_type_Long = ((this.jdField_a_of_type_JavaUtilList.size() - 1) * 100 + l);
        break;
      }
    }
  }
  
  public long a(List paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return 0L;
    }
    Iterator localIterator = paramList.iterator();
    long l = 0L;
    PathDrawer localPathDrawer;
    if (localIterator.hasNext())
    {
      localPathDrawer = (PathDrawer)localIterator.next();
      if (a() == 1) {
        l = localPathDrawer.a() + l;
      }
    }
    for (;;)
    {
      break;
      if (a() == 0)
      {
        l = localPathDrawer.b() + l;
        continue;
        return (paramList.size() - 1) * 100 + l;
      }
    }
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: iconst_m1
    //   6: putfield 33	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:jdField_a_of_type_Int	I
    //   9: aload_0
    //   10: iconst_0
    //   11: putfield 374	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:jdField_b_of_type_Boolean	Z
    //   14: aload_0
    //   15: aconst_null
    //   16: putfield 141	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   19: aload_0
    //   20: aconst_null
    //   21: putfield 410	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   24: aload_0
    //   25: ldc_w 412
    //   28: putfield 136	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   31: aload_0
    //   32: getfield 376	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLoadDataJob	Lcom/tencent/mobileqq/activity/aio/doodle/LoadDataJob;
    //   35: ifnull +16 -> 51
    //   38: aload_0
    //   39: getfield 376	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLoadDataJob	Lcom/tencent/mobileqq/activity/aio/doodle/LoadDataJob;
    //   42: invokestatic 382	com/tencent/mobileqq/app/ThreadManager:remove	(Ljava/lang/Runnable;)Z
    //   45: pop
    //   46: aload_0
    //   47: aconst_null
    //   48: putfield 376	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLoadDataJob	Lcom/tencent/mobileqq/activity/aio/doodle/LoadDataJob;
    //   51: aload_0
    //   52: monitorexit
    //   53: aload_0
    //   54: getfield 60	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:jdField_a_of_type_Ure	Lure;
    //   57: invokevirtual 414	ure:b	()V
    //   60: aload_0
    //   61: getfield 47	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   64: astore_2
    //   65: aload_2
    //   66: monitorenter
    //   67: aload_0
    //   68: ldc2_w 48
    //   71: putfield 51	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:jdField_a_of_type_Long	J
    //   74: aload_0
    //   75: aconst_null
    //   76: putfield 190	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:jdField_a_of_type_AndroidGraphicsCanvas	Landroid/graphics/Canvas;
    //   79: aload_0
    //   80: getfield 150	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   83: ifnull +13 -> 96
    //   86: aload_0
    //   87: getfield 150	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   90: astore_1
    //   91: aload_0
    //   92: aconst_null
    //   93: putfield 150	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   96: aload_0
    //   97: iconst_0
    //   98: putfield 255	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:d	I
    //   101: aload_0
    //   102: iconst_0
    //   103: putfield 257	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:jdField_c_of_type_Int	I
    //   106: aload_2
    //   107: monitorexit
    //   108: aload_1
    //   109: ifnull +10 -> 119
    //   112: invokestatic 267	com/tencent/mobileqq/activity/aio/doodle/DoodleResHelper:a	()Lcom/tencent/mobileqq/activity/aio/doodle/DoodleResHelper;
    //   115: aload_1
    //   116: invokevirtual 270	com/tencent/mobileqq/activity/aio/doodle/DoodleResHelper:a	(Landroid/graphics/Bitmap;)V
    //   119: aload_0
    //   120: invokespecial 415	com/tencent/mobileqq/activity/aio/doodle/DoodleDrawer:c	()V
    //   123: ldc 172
    //   125: iconst_2
    //   126: ldc_w 417
    //   129: invokestatic 177	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   132: return
    //   133: astore_1
    //   134: aload_0
    //   135: monitorexit
    //   136: aload_1
    //   137: athrow
    //   138: astore_1
    //   139: aload_2
    //   140: monitorexit
    //   141: aload_1
    //   142: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	143	0	this	DoodleDrawer
    //   1	115	1	localBitmap	Bitmap
    //   133	4	1	localObject1	Object
    //   138	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   4	51	133	finally
    //   51	53	133	finally
    //   134	136	133	finally
    //   67	79	138	finally
    //   79	96	138	finally
    //   96	108	138	finally
    //   139	141	138	finally
  }
  
  public void a(View paramView, int paramInt1, ScribbleResMgr.ResInfo paramResInfo, int paramInt2)
  {
    if ((paramResInfo == null) || (paramView == null)) {}
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {}
      for (DoodleDrawer.DoodleDrawerListener localDoodleDrawerListener = (DoodleDrawer.DoodleDrawerListener)this.jdField_a_of_type_JavaLangRefWeakReference.get(); (localDoodleDrawerListener != null) && (this.jdField_a_of_type_AndroidViewView == paramView) && (paramInt1 == 1) && (this.jdField_a_of_type_Int == 2); localDoodleDrawerListener = null)
      {
        int i = 0;
        paramInt1 = 0;
        if (1 == paramInt2) {}
        for (;;)
        {
          try
          {
            this.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(paramResInfo.sourceId));
            a(paramResInfo.sourceId);
            if (paramInt1 == 0) {
              break label215;
            }
            try
            {
              this.jdField_a_of_type_Int = 4;
              if (localDoodleDrawerListener != null) {
                localDoodleDrawerListener.a(this.jdField_a_of_type_JavaLangString, 4);
              }
              return;
            }
            finally {}
            if (4 == paramInt2) {
              continue;
            }
          }
          finally {}
          paramInt1 = i;
          try
          {
            if (this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramResInfo.sourceId)) != null)
            {
              this.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(paramResInfo.sourceId));
              this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramResInfo.sourceId), Integer.valueOf(4));
              paramInt1 = 1;
            }
            continue;
          }
          finally {}
          label215:
          if (this.jdField_a_of_type_JavaUtilMap.size() == 0)
          {
            this.jdField_a_of_type_Int = 3;
            f();
          }
        }
      }
    }
  }
  
  public void a(DoodleDrawer.DoodleDrawerListener paramDoodleDrawerListener, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramDoodleDrawerListener);
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_c_of_type_Int = paramInt2;
    this.d = paramInt3;
    a();
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void a(String paramString, int paramInt, DoodleParam arg3, List paramList, Map paramMap)
  {
    if ((??? == null) || (paramList == null))
    {
      if (QLog.isColorLevel()) {
        QLog.e("DoodleDrawer", 2, "onResult param error");
      }
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_Int = 4;
      return;
    }
    try
    {
      if (this.jdField_a_of_type_Ure != null) {
        this.jdField_a_of_type_Ure.a();
      }
      if ((this.jdField_a_of_type_JavaLangString == null) || (!this.jdField_a_of_type_JavaLangString.equalsIgnoreCase(paramString)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("DoodleDrawer", 2, "onResult is not current data");
        }
        return;
      }
    }
    finally {}
    if (paramInt == 4)
    {
      this.jdField_a_of_type_Int = 4;
      this.jdField_b_of_type_Boolean = true;
      if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
      {
        ??? = (DoodleDrawer.DoodleDrawerListener)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (??? != null) {
          ???.a(paramString, 4);
        }
      }
      return;
    }
    this.jdField_a_of_type_Int = 2;
    c();
    d();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLoadDataJob = null;
    if (QLog.isColorLevel()) {
      QLog.d("DoodleDrawer", 2, "onResult:" + paramString + " result:" + paramInt + " State:" + this.jdField_a_of_type_Int);
    }
    this.jdField_b_of_type_Boolean = false;
    if (this.jdField_a_of_type_Int == 1)
    {
      QLog.d("DoodleDrawer", 2, "onResult: reset data, state is loading now");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleParam.a(???);
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
      try
      {
        this.jdField_a_of_type_JavaUtilMap.clear();
        if ((paramMap != null) && (paramMap.size() > 0))
        {
          ??? = paramMap.entrySet().iterator();
          while (???.hasNext())
          {
            paramList = (Map.Entry)???.next();
            if (((Integer)paramList.getValue()).intValue() == 4)
            {
              this.jdField_a_of_type_JavaUtilMap.put(paramList.getKey(), Integer.valueOf(1));
              DoodleResHelper.a().b(0, ((Integer)paramList.getKey()).intValue(), this.jdField_a_of_type_AndroidViewView, this);
              continue;
              paramString = finally;
            }
          }
        }
      }
      finally {}
    }
    if (this.jdField_a_of_type_JavaUtilMap.size() > 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DoodleDrawer", 2, "onResult:" + paramString + " waitting res");
      }
      return;
    }
    this.jdField_a_of_type_Int = 3;
    f();
    if (QLog.isColorLevel()) {
      QLog.d("DoodleDrawer", 2, "onResult end:" + paramString);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a(long paramLong, boolean paramBoolean)
  {
    if ((paramLong > 0L) && (this.jdField_a_of_type_Int != 3) && (this.jdField_a_of_type_Int != 0)) {
      return false;
    }
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        localArrayList.addAll(this.jdField_a_of_type_JavaUtilList);
        if (!paramBoolean)
        {
          ??? = this.jdField_a_of_type_JavaLangString;
          this.jdField_a_of_type_Ure.a(new urd(this, (String)???, paramLong, localArrayList));
          if (paramLong >= a()) {
            break;
          }
          return true;
        }
      }
      a(this.jdField_a_of_type_JavaLangString, paramLong, localList);
    }
  }
  
  public boolean a(String paramString)
  {
    try
    {
      if (this.jdField_a_of_type_JavaLangString == null) {
        return false;
      }
      if (!this.jdField_a_of_type_JavaLangString.equalsIgnoreCase(paramString)) {
        return false;
      }
    }
    finally {}
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Int = -1;
      this.jdField_a_of_type_JavaLangString = "";
      return false;
    }
    return true;
  }
  
  public boolean a(String paramString, boolean paramBoolean, Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoodleDrawer", 2, "setData ：" + paramString + " state:" + this.jdField_a_of_type_Int);
    }
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("DoodleDrawer", 2, "setContent filename is null");
      this.jdField_a_of_type_JavaLangString = "";
      this.jdField_a_of_type_Int = -1;
      a(-1L, false);
      return false;
    }
    if (b(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("DoodleDrawer", 2, "checkdigest, no change:" + this.jdField_a_of_type_Int + " old prepare:" + this.jdField_c_of_type_Boolean);
      }
      try
      {
        if (this.jdField_c_of_type_Boolean != paramBoolean) {
          break label186;
        }
        if (this.jdField_a_of_type_Int == 0) {
          return false;
        }
      }
      finally {}
      if (this.jdField_a_of_type_Int == 4)
      {
        b();
        return false;
      }
      return true;
      label186:
      this.jdField_c_of_type_Boolean = paramBoolean;
      if ((this.jdField_a_of_type_Int == -1) || (this.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_Int == 2))
      {
        QLog.d("DoodleDrawer", 2, "checkdigest, waitting event");
        return true;
      }
      if ((this.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Int == 3))
      {
        this.jdField_a_of_type_Int = 3;
        long l = 9223372036854775807L;
        if (!paramBoolean) {
          l = -1L;
        }
        a(l, false);
        QLog.d("DoodleDrawer", 2, "checkdigest, preapre:" + l);
        return true;
      }
      b();
      QLog.d("DoodleDrawer", 2, "checkdigest, state error:" + this.jdField_a_of_type_Int);
      return false;
    }
    try
    {
      this.jdField_a_of_type_AndroidViewView = new View(paramContext);
      this.jdField_a_of_type_AndroidViewView.setVisibility(4);
      this.jdField_c_of_type_Boolean = paramBoolean;
      e();
      return true;
    }
    finally {}
  }
  
  public int b()
  {
    try
    {
      int i = this.jdField_a_of_type_Int;
      return i;
    }
    finally {}
  }
  
  public void b()
  {
    Object localObject1;
    if (this.jdField_a_of_type_Int == 0) {
      if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
      {
        localObject1 = (DoodleDrawer.DoodleDrawerListener)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (localObject1 != null) {
          ((DoodleDrawer.DoodleDrawerListener)localObject1).a(this.jdField_a_of_type_JavaLangString, 0);
        }
      }
    }
    while ((this.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_Int == -1)) {
      return;
    }
    if (this.jdField_b_of_type_Boolean == true)
    {
      e();
      return;
    }
    for (;;)
    {
      int i;
      try
      {
        this.jdField_a_of_type_Int = 2;
        if (this.jdField_a_of_type_JavaUtilMap.size() <= 0) {
          break;
        }
        localObject1 = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject1).next();
        i = ((Integer)localEntry.getKey()).intValue();
        if (DoodleResHelper.a().b(0, i))
        {
          ((Iterator)localObject1).remove();
          a(i);
          continue;
        }
        localEntry.setValue(Integer.valueOf(1));
      }
      finally {}
      DoodleResHelper.a().b(0, i, this.jdField_a_of_type_AndroidViewView, this);
    }
    if (this.jdField_a_of_type_JavaUtilMap.size() > 0) {
      if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
      {
        DoodleDrawer.DoodleDrawerListener localDoodleDrawerListener = (DoodleDrawer.DoodleDrawerListener)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (localDoodleDrawerListener != null) {
          localDoodleDrawerListener.a(this.jdField_a_of_type_JavaLangString, 2);
        }
      }
    }
    for (;;)
    {
      return;
      this.jdField_a_of_type_Int = 3;
      f();
    }
  }
  
  public int c()
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      int i = this.jdField_a_of_type_JavaUtilList.size();
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.DoodleDrawer
 * JD-Core Version:    0.7.0.1
 */