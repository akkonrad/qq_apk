package com.tencent.mobileqq.shortvideo.util;

import java.io.File;

public class FileUtil
{
  public static boolean a(String paramString)
  {
    return new File(paramString).exists();
  }
  
  public static boolean b(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return false;
      paramString = new File(paramString);
    } while ((!paramString.exists()) || (paramString.length() <= 0L));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.util.FileUtil
 * JD-Core Version:    0.7.0.1
 */