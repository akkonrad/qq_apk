package com.tencent.util;

import android.os.Handler;
import android.os.Looper;

public class UiThreadUtil
{
  private static Handler a;
  
  public static void a(Runnable paramRunnable)
  {
    try
    {
      if (a == null) {
        a = new Handler(Looper.getMainLooper());
      }
      a.post(paramRunnable);
      return;
    }
    finally {}
  }
  
  public static boolean a()
  {
    return Looper.getMainLooper().getThread() == Thread.currentThread();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.util.UiThreadUtil
 * JD-Core Version:    0.7.0.1
 */