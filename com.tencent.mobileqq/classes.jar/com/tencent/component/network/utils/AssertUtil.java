package com.tencent.component.network.utils;

public class AssertUtil
{
  public static void a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      throw new AssertionError();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.utils.AssertUtil
 * JD-Core Version:    0.7.0.1
 */