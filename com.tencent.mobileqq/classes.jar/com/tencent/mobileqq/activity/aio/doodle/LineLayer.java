package com.tencent.mobileqq.activity.aio.doodle;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import usj;
import usk;
import usm;
import ust;
import utd;

public class LineLayer
  extends BaseLayer
  implements ust, utd
{
  public static final int a;
  private long jdField_a_of_type_Long;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Canvas jdField_a_of_type_AndroidGraphicsCanvas;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private DoodleParam jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleParam = new DoodleParam();
  private LineLayer.LineLayerListener jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer$LineLayerListener;
  private PathDesc jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathDesc;
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  private Map jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  private usk jdField_a_of_type_Usk;
  private int jdField_b_of_type_Int = jdField_a_of_type_Int;
  private Map jdField_b_of_type_JavaUtilMap = new ConcurrentHashMap();
  private int jdField_c_of_type_Int;
  private Map jdField_c_of_type_JavaUtilMap = new ConcurrentHashMap();
  private int d;
  private int e;
  private int f;
  private int g = -1;
  private int h;
  private int i;
  
  static
  {
    jdField_a_of_type_Int = Color.parseColor("#ff000000");
  }
  
  public LineLayer(DoodleView paramDoodleView)
  {
    super(paramDoodleView);
  }
  
  private void a(Canvas paramCanvas, PathDesc paramPathDesc, boolean paramBoolean)
  {
    paramPathDesc.a(paramCanvas, paramBoolean);
  }
  
  private int[] a()
  {
    int[] arrayOfInt = new int[2];
    int[] tmp5_4 = arrayOfInt;
    tmp5_4[0] = 0;
    int[] tmp9_5 = tmp5_4;
    tmp9_5[1] = 0;
    tmp9_5;
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return arrayOfInt;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      PathDesc localPathDesc = (PathDesc)localIterator.next();
      arrayOfInt[0] += 1;
    }
    return arrayOfInt;
  }
  
  private void e()
  {
    this.i += 1;
    this.jdField_c_of_type_JavaUtilMap.put(Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()), Integer.valueOf(this.i));
    if (this.jdField_a_of_type_Usk != null)
    {
      ThreadManager.remove(this.jdField_a_of_type_Usk);
      this.jdField_a_of_type_Usk = null;
    }
    this.jdField_a_of_type_Usk = new usk(this, this.jdField_a_of_type_JavaUtilList.size(), this.jdField_a_of_type_JavaUtilMap, this.i, this);
    ThreadManager.post(this.jdField_a_of_type_Usk, 5, null, false);
  }
  
  private void f()
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0))
    {
      g();
      return;
    }
    if (!c()) {
      d();
    }
    int j;
    if (this.jdField_a_of_type_JavaUtilList.size() - 1 > this.e)
    {
      j = this.e;
      while (j < this.jdField_a_of_type_JavaUtilList.size() - 1)
      {
        a(this.jdField_a_of_type_AndroidGraphicsCanvas, (PathDesc)this.jdField_a_of_type_JavaUtilList.get(j), false);
        j += 1;
      }
      this.f = 0;
      this.e = (this.jdField_a_of_type_JavaUtilList.size() - 1);
    }
    for (;;)
    {
      PathDesc localPathDesc = (PathDesc)this.jdField_a_of_type_JavaUtilList.get(this.e);
      j = localPathDesc.a();
      if (j <= this.f) {
        break;
      }
      localPathDesc.a(this.jdField_a_of_type_AndroidGraphicsCanvas, this.f, j);
      this.f = j;
      if (this.f != 1) {
        break;
      }
      this.f = 0;
      return;
      if (this.e > this.jdField_a_of_type_JavaUtilList.size() - 1) {
        this.e = (this.jdField_a_of_type_JavaUtilList.size() - 1);
      }
    }
  }
  
  private void g()
  {
    if ((this.jdField_a_of_type_AndroidGraphicsCanvas != null) && (this.jdField_a_of_type_AndroidGraphicsPaint != null)) {
      this.jdField_a_of_type_AndroidGraphicsCanvas.drawPaint(this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    this.e = 0;
    this.f = 0;
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public final DoodleParam a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleParam;
  }
  
  public List a()
  {
    if (this.jdField_a_of_type_JavaUtilList.size() == 0) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      PathDesc localPathDesc = (PathDesc)localIterator.next();
      PathData localPathData = new PathData();
      localPathData.a(localPathDesc.a());
      localArrayList.add(localPathData);
    }
    return localArrayList;
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    this.g = -1;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleParam.a(paramInt1, paramInt2);
    d();
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, Bitmap paramBitmap)
  {
    this.jdField_a_of_type_Usk = null;
    Object localObject = (Integer)this.jdField_c_of_type_JavaUtilMap.remove(Integer.valueOf(paramInt1));
    if (localObject == null) {
      if (QLog.isColorLevel()) {
        QLog.d("LineLayer", 2, "undo result, seq not exist:" + paramInt1 + "-" + paramInt2 + "-" + paramInt3);
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if (paramInt3 == ((Integer)localObject).intValue()) {
            break;
          }
          this.jdField_c_of_type_JavaUtilMap.put(Integer.valueOf(paramInt1), localObject);
        } while (!QLog.isColorLevel());
        QLog.d("LineLayer", 2, "undo result, seq not match:" + paramInt1 + "-" + paramInt2 + "-" + paramInt3 + "-" + ((Integer)localObject).intValue());
        return;
        if (paramInt1 == this.jdField_a_of_type_JavaUtilList.size()) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("LineLayer", 2, "undo result, pathsize not match:" + paramInt1 + "-" + paramInt2 + "-" + paramInt3 + "-" + this.jdField_a_of_type_JavaUtilList.size());
      return;
      if ((paramInt2 != 0) && (paramBitmap != null)) {
        break;
      }
      g();
      super.b();
    } while (!QLog.isColorLevel());
    QLog.d("LineLayer", 2, "undo result, no cache:" + paramInt1 + "-" + paramInt2 + "-" + paramInt3);
    return;
    if (QLog.isColorLevel()) {
      QLog.d("LineLayer", 2, "undo result, use cache:" + paramInt1 + "-" + paramInt2);
    }
    localObject = new Paint();
    ((Paint)localObject).setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
    this.jdField_a_of_type_AndroidGraphicsCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, (Paint)localObject);
    this.e = (paramInt2 - 1);
    paramBitmap = (PathDesc)this.jdField_a_of_type_JavaUtilList.get(this.e);
    if (paramBitmap != null)
    {
      this.f = paramBitmap.a();
      if (this.f == 1) {
        this.f = 0;
      }
    }
    if (paramInt2 < this.jdField_a_of_type_JavaUtilList.size()) {
      f();
    }
    super.b();
  }
  
  public void a(LineLayer.LineLayerListener paramLineLayerListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer$LineLayerListener = paramLineLayerListener;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_b_of_type_JavaUtilMap.clear();
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathDesc = null;
    this.h = 0;
    ThreadManager.post(new usj(this), 5, null, true);
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidGraphicsCanvas = null;
      if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
      {
        this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
        this.jdField_a_of_type_AndroidGraphicsBitmap = null;
      }
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, String paramString)
  {
    Integer localInteger = (Integer)this.jdField_b_of_type_JavaUtilMap.remove(Integer.valueOf(paramInt1));
    if (localInteger == null) {
      if (QLog.isColorLevel()) {
        QLog.d("LineLayer", 2, "save result, seq not exist:" + paramInt1 + "-" + paramInt2);
      }
    }
    do
    {
      do
      {
        return;
        if (paramInt2 == localInteger.intValue()) {
          break;
        }
        this.jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(paramInt1), localInteger);
      } while (!QLog.isColorLevel());
      QLog.d("LineLayer", 2, "save result, seq not match:" + paramInt1 + "-" + paramInt2 + "-" + localInteger.intValue());
      return;
      if ((paramBoolean) && (!TextUtils.isEmpty(paramString))) {
        this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt1), paramString);
      }
    } while (!QLog.isColorLevel());
    QLog.d("LineLayer", 2, "save result, add cache:" + paramInt1 + "-" + paramString + " : " + this.jdField_a_of_type_JavaUtilMap.size());
  }
  
  public boolean a(Canvas paramCanvas)
  {
    boolean bool = false;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      a(paramCanvas, new PathDesc((PathDesc)localIterator.next()), true);
      bool = true;
    }
    return bool;
  }
  
  public int b()
  {
    int[] arrayOfInt = a();
    int j = arrayOfInt[0];
    return arrayOfInt[1] + j;
  }
  
  public void b(int paramInt)
  {
    if (this.g == paramInt) {
      return;
    }
    this.jdField_b_of_type_Int = -1;
    this.g = paramInt;
  }
  
  protected void b(Canvas paramCanvas)
  {
    f();
    c(paramCanvas);
  }
  
  public boolean b()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    return true;
  }
  
  public boolean b(MotionEvent paramMotionEvent)
  {
    int m = 0;
    if (this.h > 10000)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer$LineLayerListener != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer$LineLayerListener.a(2, 10000);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer$LineLayerListener.a();
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathDesc = null;
      return false;
    }
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    switch (paramMotionEvent.getAction())
    {
    default: 
    case 0: 
    case 2: 
      for (;;)
      {
        return true;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathDesc = new PathDesc(this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleParam, a(), null, this.g);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathDesc.a();
        this.jdField_a_of_type_Long = System.currentTimeMillis();
        this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathDesc.a(f1, f2);
        this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathDesc);
        this.h = c();
        continue;
        long l1 = System.currentTimeMillis();
        long l2 = this.jdField_a_of_type_Long;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathDesc != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathDesc.a(f1, f2, l1 - l2);
          this.h += 1;
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer$LineLayerListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer$LineLayerListener.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathDesc != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathDesc.a(false);
      f();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathDesc.a(true);
      this.f = this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathDesc.a();
      if (this.f == 1) {
        this.f = 0;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathDesc = null;
    this.h = c();
    paramMotionEvent = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    int j = 0;
    label306:
    int k;
    if (paramMotionEvent.hasNext())
    {
      k = ((Integer)paramMotionEvent.next()).intValue();
      if (j >= k) {
        break label530;
      }
      j = k;
    }
    label530:
    for (;;)
    {
      break label306;
      paramMotionEvent = this.jdField_b_of_type_JavaUtilMap.keySet().iterator();
      while (paramMotionEvent.hasNext())
      {
        k = ((Integer)paramMotionEvent.next()).intValue();
        if (j < k) {
          j = k;
        }
      }
      int n;
      for (k = 0; m < j; k = n + k)
      {
        n = ((PathDesc)this.jdField_a_of_type_JavaUtilList.get(m)).b();
        m += 1;
      }
      if (k + 100 >= this.h) {
        break;
      }
      f();
      this.i += 1;
      this.jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()), Integer.valueOf(this.i));
      ThreadManager.post(new usm(this, this.jdField_a_of_type_JavaUtilList.size(), this.i, this.jdField_a_of_type_AndroidGraphicsBitmap, this), 5, null, true);
      break;
    }
  }
  
  public int c()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    for (int j = 0; localIterator.hasNext(); j = ((PathDesc)localIterator.next()).b() + j) {}
    return j;
  }
  
  public void c()
  {
    super.c();
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((PathDesc)localIterator.next()).a();
      }
      this.jdField_a_of_type_JavaUtilList.clear();
    }
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_b_of_type_JavaUtilMap.clear();
    this.jdField_c_of_type_JavaUtilMap.clear();
    this.jdField_a_of_type_Usk = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathDesc = null;
    this.jdField_a_of_type_AndroidGraphicsCanvas = null;
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    }
    this.d = 0;
    this.jdField_c_of_type_Int = 0;
    this.g = -1;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer$LineLayerListener = null;
    ThreadManager.post(new usj(this), 5, null, true);
  }
  
  public void c(Canvas paramCanvas)
  {
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (paramCanvas != null)) {
      paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, 0.0F, 0.0F, null);
    }
  }
  
  public boolean c()
  {
    return (this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (this.jdField_a_of_type_AndroidGraphicsCanvas != null);
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LineLayer", 2, "undo begin");
    }
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      this.jdField_b_of_type_JavaUtilMap.remove(Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()));
      this.jdField_c_of_type_JavaUtilMap.remove(Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()));
      this.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()));
      this.jdField_a_of_type_JavaUtilList.remove(this.jdField_a_of_type_JavaUtilList.size() - 1);
      if (this.jdField_a_of_type_JavaUtilList.size() == 0)
      {
        this.h = 0;
        ThreadManager.post(new usj(this), 5, null, true);
        this.jdField_b_of_type_JavaUtilMap.clear();
        this.jdField_c_of_type_JavaUtilMap.clear();
        this.jdField_a_of_type_JavaUtilMap.clear();
        g();
      }
    }
    else
    {
      if (this.h >= 100) {
        break label242;
      }
      if (QLog.isColorLevel()) {
        QLog.d("LineLayer", 2, "undo draw directly");
      }
      g();
      super.b();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LineLayer", 2, "undo end");
      }
      return;
      this.h = c();
      break;
      label242:
      e();
      if (QLog.isColorLevel()) {
        QLog.d("LineLayer", 2, "undo try use cache");
      }
    }
  }
  
  public boolean d()
  {
    boolean bool = false;
    int j = this.jdField_a_of_type_AndroidGraphicsRect.width();
    int k = this.jdField_a_of_type_AndroidGraphicsRect.height();
    if ((j <= 0) || (k <= 0)) {
      return false;
    }
    try
    {
      if ((this.jdField_c_of_type_Int != j) || (this.d != k) || (this.jdField_a_of_type_AndroidGraphicsBitmap == null) || (this.jdField_a_of_type_AndroidGraphicsCanvas == null))
      {
        if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
        {
          this.jdField_a_of_type_AndroidGraphicsCanvas = null;
          this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
          this.jdField_a_of_type_AndroidGraphicsBitmap = null;
        }
        this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(j, k, Bitmap.Config.ARGB_8888);
        if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
        {
          this.jdField_a_of_type_AndroidGraphicsCanvas = new Canvas(this.jdField_a_of_type_AndroidGraphicsBitmap);
          this.jdField_c_of_type_Int = j;
          this.d = k;
        }
        this.e = 0;
        this.f = 0;
        bool = true;
      }
      return bool;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
      {
        this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
        this.jdField_a_of_type_AndroidGraphicsBitmap = null;
      }
      this.jdField_c_of_type_Int = 0;
      this.d = 0;
      this.jdField_a_of_type_AndroidGraphicsCanvas = null;
      this.e = 0;
      this.f = 0;
      return true;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      if (QLog.isColorLevel()) {
        QLog.e("LineLayer", 2, "checkcache oom:" + localOutOfMemoryError.toString());
      }
      this.jdField_c_of_type_Int = 0;
      this.d = 0;
      this.jdField_a_of_type_AndroidGraphicsCanvas = null;
      this.e = 0;
      this.f = 0;
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.LineLayer
 * JD-Core Version:    0.7.0.1
 */