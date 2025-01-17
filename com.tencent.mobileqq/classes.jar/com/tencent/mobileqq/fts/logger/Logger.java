package com.tencent.mobileqq.fts.logger;

import android.util.Log;

public class Logger
  implements ILogger
{
  public void a(String paramString1, String paramString2, String paramString3)
  {
    a(paramString1, paramString2, paramString3, null);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, Throwable paramThrowable)
  {
    if ("d".equals(paramString2))
    {
      Log.d(paramString1, paramString3, paramThrowable);
      return;
    }
    if ("e".equals(paramString2))
    {
      Log.e(paramString1, paramString3, paramThrowable);
      return;
    }
    if ("w".equals(paramString2))
    {
      Log.w(paramString1, paramString3, paramThrowable);
      return;
    }
    if ("i".equals(paramString2))
    {
      Log.i(paramString1, paramString3, paramThrowable);
      return;
    }
    Log.i(paramString1, paramString3, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.fts.logger.Logger
 * JD-Core Version:    0.7.0.1
 */