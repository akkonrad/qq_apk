package com.tencent.mobileqq.app.automator;

import android.os.Process;
import android.os.SystemClock;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.TraceUtils;

public class AsyncStep
  implements Runnable
{
  public volatile int a;
  public Automator a;
  protected IResultListener a;
  private Object a;
  public int b;
  protected long b;
  public String b;
  public int c;
  
  public AsyncStep()
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_b_of_type_Long = 30000L;
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangObject = new Object();
  }
  
  private boolean a()
  {
    for (;;)
    {
      int i;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        i = this.jdField_a_of_type_Int;
        if (i != 2) {}
      }
      try
      {
        this.jdField_a_of_type_JavaLangObject.wait(this.jdField_b_of_type_Long);
        if (QLog.isColorLevel()) {
          QLog.d("QQInitHandler", 2, this.jdField_b_of_type_JavaLangString + " waitResult " + this.jdField_a_of_type_Int + " " + this.c);
        }
        if (this.jdField_a_of_type_Int == 3)
        {
          this.jdField_a_of_type_Int = 2;
          continue;
          localObject2 = finally;
          throw localObject2;
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          localInterruptedException.printStackTrace();
        }
        if (this.jdField_a_of_type_Int == 2)
        {
          this.jdField_a_of_type_Int = 5;
          Automator localAutomator = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator;
          localAutomator.jdField_b_of_type_Int += 1;
        }
        if ((this.jdField_a_of_type_Int == 6) || (this.jdField_a_of_type_Int == 5))
        {
          i = this.c;
          this.c = (i - 1);
          if (i > 0)
          {
            this.jdField_a_of_type_Int = 1;
            return true;
          }
        }
      }
    }
    return false;
  }
  
  public int a()
  {
    if (QLog.isColorLevel()) {
      QLog.e("QQInitHandler", 2, this.jdField_b_of_type_JavaLangString + " AsyncStep.doStep()");
    }
    return 7;
  }
  
  public void a() {}
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, this.jdField_b_of_type_JavaLangString + " setResult " + paramInt + ", when " + this.jdField_a_of_type_Int);
    }
    if (paramInt == 6)
    {
      ??? = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator;
      ((Automator)???).jdField_b_of_type_Int += 1;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((paramInt > this.jdField_a_of_type_Int) && (paramInt != 4)) {
        this.jdField_a_of_type_Int = paramInt;
      }
      this.jdField_a_of_type_JavaLangObject.notifyAll();
      return;
    }
  }
  
  public final void a(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder(64);
      ((StringBuilder)???).append(this.jdField_b_of_type_JavaLangString);
      ((StringBuilder)???).append(" updateTimeout ");
      ((StringBuilder)???).append(paramLong);
      ((StringBuilder)???).append(", when ");
      ((StringBuilder)???).append(this.jdField_a_of_type_Int);
      QLog.d("QQInitHandler", 2, ((StringBuilder)???).toString());
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_Int == 2) {
        this.jdField_a_of_type_Int = 3;
      }
      this.jdField_b_of_type_Long = paramLong;
      this.jdField_a_of_type_JavaLangObject.notifyAll();
      return;
    }
  }
  
  public void c() {}
  
  public final void run()
  {
    long l;
    if (this.jdField_a_of_type_Int == 1)
    {
      l = 0L;
      TraceUtils.a(4096L, this.jdField_b_of_type_JavaLangString, Process.myTid());
      if (QLog.isColorLevel())
      {
        l = SystemClock.uptimeMillis();
        QLog.d("QQInitHandler", 2, this.jdField_b_of_type_JavaLangString + " begin with " + this.jdField_a_of_type_Int);
      }
    }
    try
    {
      a();
      do
      {
        a(a());
      } while (a());
      c();
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QQInitHandler", 1, "", localThrowable);
      a(8);
      return;
    }
    finally
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 2, this.jdField_b_of_type_JavaLangString + " cost: " + (SystemClock.uptimeMillis() - l));
      }
      TraceUtils.b(4096L, this.jdField_b_of_type_JavaLangString, Process.myTid());
      if (this.jdField_a_of_type_ComTencentMobileqqAppAutomatorIResultListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppAutomatorIResultListener.a(this, this.jdField_a_of_type_Int);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.AsyncStep
 * JD-Core Version:    0.7.0.1
 */