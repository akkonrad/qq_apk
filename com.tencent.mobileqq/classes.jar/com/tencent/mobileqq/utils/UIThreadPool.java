package com.tencent.mobileqq.utils;

import akgi;

public class UIThreadPool
{
  private static akgi a;
  
  public static void a(Runnable paramRunnable)
  {
    if (paramRunnable == null) {
      return;
    }
    if (a == null) {
      a = new akgi(3, 10L);
    }
    a.execute(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.utils.UIThreadPool
 * JD-Core Version:    0.7.0.1
 */