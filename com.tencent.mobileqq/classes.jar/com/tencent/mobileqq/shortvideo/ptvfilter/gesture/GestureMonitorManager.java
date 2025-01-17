package com.tencent.mobileqq.shortvideo.ptvfilter.gesture;

import com.tencent.qphone.base.util.QLog;

public class GestureMonitorManager
{
  public static GestureMonitorManager a;
  private final int jdField_a_of_type_Int = 20;
  private long jdField_a_of_type_Long;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private boolean jdField_b_of_type_Boolean;
  private long jdField_c_of_type_Long;
  private boolean jdField_c_of_type_Boolean;
  private long jdField_d_of_type_Long;
  private volatile boolean jdField_d_of_type_Boolean;
  private long e;
  private long f;
  private long g;
  private long h;
  
  public static GestureMonitorManager a()
  {
    if (jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterGestureGestureMonitorManager == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterGestureGestureMonitorManager == null) {
        jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterGestureGestureMonitorManager = new GestureMonitorManager();
      }
      return jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterGestureGestureMonitorManager;
    }
    finally {}
  }
  
  private void h()
  {
    this.jdField_d_of_type_Boolean = false;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_d_of_type_Long = 0L;
    this.e = 0L;
  }
  
  public void a()
  {
    if (this.jdField_d_of_type_Boolean) {
      this.f = System.currentTimeMillis();
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 1;
    if ((this.jdField_d_of_type_Boolean) && (this.jdField_b_of_type_Int <= 20))
    {
      this.jdField_b_of_type_Int += 1;
      if (QLog.isColorLevel()) {
        QLog.i("GestureMonitorManager", 2, "start " + this.jdField_b_of_type_Int + "");
      }
    }
    do
    {
      return;
      if ((this.jdField_d_of_type_Boolean) && (this.jdField_b_of_type_Int > 20))
      {
        g();
        h();
        return;
      }
    } while (this.jdField_d_of_type_Boolean);
    if ((paramBoolean1) && (paramBoolean2))
    {
      paramBoolean1 = true;
      this.jdField_d_of_type_Boolean = paramBoolean1;
      if (!this.jdField_d_of_type_Boolean) {
        break label133;
      }
    }
    for (;;)
    {
      this.jdField_b_of_type_Int = i;
      return;
      paramBoolean1 = false;
      break;
      label133:
      i = 0;
    }
  }
  
  public void b()
  {
    if (this.jdField_d_of_type_Boolean)
    {
      this.f = (System.currentTimeMillis() - this.f);
      this.jdField_a_of_type_Long += this.f;
      if (QLog.isColorLevel()) {
        QLog.i("GestureMonitorManager", 2, "GestureMonitorManager TotalDetetcorConsumer[startPreview] " + this.f + "ms");
      }
    }
  }
  
  public void c()
  {
    if (this.jdField_d_of_type_Boolean) {
      this.g = System.currentTimeMillis();
    }
  }
  
  public void d()
  {
    if (this.jdField_d_of_type_Boolean)
    {
      this.g = (System.currentTimeMillis() - this.g);
      this.jdField_c_of_type_Long += this.g;
      if (QLog.isColorLevel()) {
        QLog.i("GestureMonitorManager", 2, "GestureMonitorManager FaceDetectorConsumer[FaceDetector] " + this.g + "ms");
      }
    }
  }
  
  public void e()
  {
    if (this.jdField_d_of_type_Boolean) {
      this.h = System.currentTimeMillis();
    }
  }
  
  public void f()
  {
    if (this.jdField_d_of_type_Boolean)
    {
      this.h = (System.currentTimeMillis() - this.h);
      this.jdField_d_of_type_Long += this.h;
      if (QLog.isColorLevel()) {
        QLog.i("GestureMonitorManager", 2, "GestureMonitorManager GestureDrawConsumer[GestureDraw] " + this.h + "ms");
      }
    }
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.i("GestureMonitorManagerdoReport", 2, "GestureMonitorManager check Frame numbers[+20],[StartPreview:" + this.jdField_a_of_type_Long + "ms],[FaceDetector Aysn childThread:" + this.jdField_c_of_type_Long + "ms],ms],[FaceDraw:" + this.jdField_b_of_type_Long + "ms],[GestureDetector Aysn childThread:" + this.e + "ms],ms],[GestureDraw:" + this.jdField_d_of_type_Long + "ms]");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ptvfilter.gesture.GestureMonitorManager
 * JD-Core Version:    0.7.0.1
 */