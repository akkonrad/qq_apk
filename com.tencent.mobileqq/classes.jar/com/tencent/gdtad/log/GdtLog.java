package com.tencent.gdtad.log;

import android.util.Log;
import com.tencent.qphone.base.util.QLog;

public class GdtLog
{
  public static void a(String paramString1, String paramString2)
  {
    a(paramString1, paramString2, null);
  }
  
  public static void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (QLog.isColorLevel())
    {
      QLog.d(paramString1, 2, paramString2, paramThrowable);
      return;
    }
    Log.d(paramString1, paramString2, paramThrowable);
  }
  
  public static void b(String paramString1, String paramString2)
  {
    b(paramString1, paramString2, null);
  }
  
  public static void b(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (QLog.isColorLevel())
    {
      QLog.i(paramString1, 2, paramString2, paramThrowable);
      return;
    }
    Log.i(paramString1, paramString2, paramThrowable);
  }
  
  public static void c(String paramString1, String paramString2)
  {
    c(paramString1, paramString2, null);
  }
  
  public static void c(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (QLog.isColorLevel())
    {
      QLog.w(paramString1, 2, paramString2, paramThrowable);
      return;
    }
    Log.w(paramString1, paramString2, paramThrowable);
  }
  
  public static void d(String paramString1, String paramString2)
  {
    d(paramString1, paramString2, null);
  }
  
  public static void d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    QLog.e(paramString1, 1, paramString2, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.gdtad.log.GdtLog
 * JD-Core Version:    0.7.0.1
 */