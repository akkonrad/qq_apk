package com.tencent.av.doodle;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.os.SystemClock;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class LineDoodleItem
  extends PathDoodleItem
{
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private Queue jdField_a_of_type_JavaUtilQueue = new LinkedList();
  
  public LineDoodleItem()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setDither(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-65536);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeJoin(Paint.Join.ROUND);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeCap(Paint.Cap.ROUND);
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilQueue.offer(new LineDoodleItem.DistanceItem(this, this.jdField_a_of_type_AndroidGraphicsPathMeasure.getLength()));
  }
  
  public void a(long paramLong) {}
  
  public void b(Canvas paramCanvas, MySurfaceView paramMySurfaceView, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.e);
    float f4 = 0.01111111F * this.c;
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(f4);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    int i;
    if ((this.jdField_a_of_type_Long != -1L) && (paramMySurfaceView.jdField_a_of_type_Long - this.jdField_a_of_type_Long > 1200L))
    {
      i = (int)(255L - (paramMySurfaceView.jdField_a_of_type_Long - this.jdField_a_of_type_Long - 1200L) * 255L / 800L);
      this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(i);
      this.jdField_a_of_type_AndroidGraphicsPaint.setMaskFilter(null);
      if (this.jdField_a_of_type_AndroidGraphicsPathMeasure.getLength() <= 0.0F) {
        break label251;
      }
      paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    long l;
    Object localObject1;
    LineDoodleItem.DistanceItem localDistanceItem;
    Object localObject2;
    label251:
    float f2;
    float f1;
    for (;;)
    {
      if ((paramBoolean) && (this.jdField_a_of_type_JavaUtilQueue.size() > 0))
      {
        l = SystemClock.elapsedRealtime() - 500L;
        localObject1 = null;
        paramMySurfaceView = null;
        localDistanceItem = (LineDoodleItem.DistanceItem)((LinkedList)this.jdField_a_of_type_JavaUtilQueue).getLast();
        Iterator localIterator = this.jdField_a_of_type_JavaUtilQueue.iterator();
        for (;;)
        {
          localObject2 = paramMySurfaceView;
          if (!localIterator.hasNext()) {
            break;
          }
          paramMySurfaceView = (LineDoodleItem.DistanceItem)localIterator.next();
          localObject2 = paramMySurfaceView;
          if (paramMySurfaceView.jdField_a_of_type_Long - l >= 0L) {
            break;
          }
          localObject1 = paramMySurfaceView;
        }
        this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(255);
        break;
        paramCanvas.drawPoint(this.jdField_a_of_type_AndroidGraphicsPointF.x, this.jdField_a_of_type_AndroidGraphicsPointF.y, this.jdField_a_of_type_AndroidGraphicsPaint);
        continue;
        f2 = localDistanceItem.jdField_a_of_type_Float;
        if (localObject2 == null) {
          break label680;
        }
        if ((localObject1 != null) && (localObject1 != localObject2)) {
          f1 = (((LineDoodleItem.DistanceItem)localObject1).jdField_a_of_type_Float * (float)(((LineDoodleItem.DistanceItem)localObject2).jdField_a_of_type_Long - l) + ((LineDoodleItem.DistanceItem)localObject2).jdField_a_of_type_Float * (float)(l - ((LineDoodleItem.DistanceItem)localObject1).jdField_a_of_type_Long)) / (float)(((LineDoodleItem.DistanceItem)localObject2).jdField_a_of_type_Long - ((LineDoodleItem.DistanceItem)localObject1).jdField_a_of_type_Long);
        }
      }
    }
    for (;;)
    {
      float f3 = 0.01481482F * this.c * (float)(localDistanceItem.jdField_a_of_type_Long - l) / 500.0F;
      f4 /= 2.0F;
      paramMySurfaceView = new float[2];
      localObject1 = new float[2];
      localObject2 = new Path();
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
      ((Path)localObject2).setFillType(Path.FillType.WINDING);
      float f5 = f2 - f1;
      float f6 = (f3 - f4) / f5;
      i = this.e;
      i = this.e;
      float f7 = 0.005555556F * this.c;
      for (;;)
      {
        if (f1 <= localDistanceItem.jdField_a_of_type_Float)
        {
          this.jdField_a_of_type_AndroidGraphicsPathMeasure.getPosTan(f1, paramMySurfaceView, (float[])localObject1);
          float f8 = (f2 - f1) / f5;
          int j = DoodleUtils.a(new int[] { i, -1 }, 1.0F - f8);
          this.jdField_a_of_type_AndroidGraphicsPaint.setColor(j);
          paramCanvas.drawCircle(paramMySurfaceView[0], paramMySurfaceView[1], f3 - (f2 - f1) * f6, this.jdField_a_of_type_AndroidGraphicsPaint);
          f1 += f7;
          continue;
          f1 = ((LineDoodleItem.DistanceItem)localObject2).jdField_a_of_type_Float;
          break;
        }
      }
      if (QLog.isColorLevel())
      {
        QLog.e("LineDoodleItem", 2, "WL_DEBUG doDraw mScreenWidth = " + this.c);
        QLog.e("LineDoodleItem", 2, "WL_DEBUG doDraw maxRadius = " + f3);
        QLog.e("LineDoodleItem", 2, "WL_DEBUG doDraw minRadius = " + f4);
        QLog.e("LineDoodleItem", 2, "WL_DEBUG doDraw startAnimationPathPointDistance = " + f7);
      }
      return;
      label680:
      f1 = 0.0F;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.doodle.LineDoodleItem
 * JD-Core Version:    0.7.0.1
 */