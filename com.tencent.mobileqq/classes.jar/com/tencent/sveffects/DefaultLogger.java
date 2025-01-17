package com.tencent.sveffects;

import android.util.Log;

public class DefaultLogger
  implements Logger
{
  public void a(String paramString1, String paramString2)
  {
    Log.e(paramString1, paramString2);
  }
  
  public void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    Log.e(paramString1, paramString2, paramThrowable);
  }
  
  public void a(String paramString, Throwable paramThrowable)
  {
    Log.e(paramString, "", paramThrowable);
  }
  
  public boolean a()
  {
    return true;
  }
  
  public void b(String paramString1, String paramString2)
  {
    Log.w(paramString1, paramString2);
  }
  
  public void c(String paramString1, String paramString2)
  {
    Log.i(paramString1, paramString2);
  }
  
  public void d(String paramString1, String paramString2)
  {
    Log.d(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.sveffects.DefaultLogger
 * JD-Core Version:    0.7.0.1
 */