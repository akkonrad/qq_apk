package com.tencent.biz.qqstory.support.logging;

import com.tencent.qphone.base.util.QLog;

public class QQStoryLoggingDelegate
  implements LoggingDelegate
{
  public static final QQStoryLoggingDelegate a;
  public int a;
  private int b = -1;
  
  static
  {
    jdField_a_of_type_ComTencentBizQqstorySupportLoggingQQStoryLoggingDelegate = new QQStoryLoggingDelegate();
  }
  
  private QQStoryLoggingDelegate()
  {
    this.jdField_a_of_type_Int = 3;
  }
  
  public static QQStoryLoggingDelegate a()
  {
    return jdField_a_of_type_ComTencentBizQqstorySupportLoggingQQStoryLoggingDelegate;
  }
  
  private void a(int paramInt, String paramString1, String paramString2)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 2: 
      QLog.d(paramString1, 2, paramString2);
      return;
    case 3: 
      QLog.d(paramString1, 2, paramString2);
      return;
    case 4: 
      QLog.i(paramString1, 2, paramString2);
      return;
    case 5: 
      QLog.e(paramString1, 1, paramString2);
      return;
    }
    QLog.e(paramString1, 1, paramString2);
  }
  
  private void a(int paramInt, String paramString1, String paramString2, Throwable paramThrowable)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 2: 
      QLog.d(paramString1, 2, paramString2, paramThrowable);
      return;
    case 3: 
      QLog.d(paramString1, 2, paramString2, paramThrowable);
      return;
    case 4: 
      QLog.i(paramString1, 2, paramString2, paramThrowable);
      return;
    case 5: 
      QLog.e(paramString1, 1, paramString2, paramThrowable);
      return;
    }
    QLog.e(paramString1, 1, paramString2, paramThrowable);
  }
  
  public void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void a(String paramString1, String paramString2)
  {
    a(2, paramString1, paramString2);
  }
  
  public void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    a(3, paramString1, paramString2, paramThrowable);
  }
  
  public boolean a(int paramInt)
  {
    if ((this.b != -1) && (paramInt >= this.b)) {}
    do
    {
      do
      {
        return true;
      } while (5 <= paramInt);
      if (!QLog.isColorLevel()) {
        return false;
      }
    } while (this.jdField_a_of_type_Int <= paramInt);
    return false;
  }
  
  public void b(String paramString1, String paramString2)
  {
    a(3, paramString1, paramString2);
  }
  
  public void b(String paramString1, String paramString2, Throwable paramThrowable)
  {
    a(4, paramString1, paramString2, paramThrowable);
  }
  
  public void c(String paramString1, String paramString2)
  {
    a(4, paramString1, paramString2);
  }
  
  public void c(String paramString1, String paramString2, Throwable paramThrowable)
  {
    a(5, paramString1, paramString2, paramThrowable);
  }
  
  public void d(String paramString1, String paramString2)
  {
    a(5, paramString1, paramString2);
  }
  
  public void d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    a(6, paramString1, paramString2, paramThrowable);
  }
  
  public void e(String paramString1, String paramString2)
  {
    a(6, paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.support.logging.QQStoryLoggingDelegate
 * JD-Core Version:    0.7.0.1
 */