package com.tencent.mobileqq.werewolves;

import java.lang.reflect.Method;

public class ReflectUtils
{
  public static Class a(ClassLoader paramClassLoader, String paramString)
  {
    try
    {
      paramClassLoader = paramClassLoader.loadClass(paramString);
      return paramClassLoader;
    }
    catch (ClassNotFoundException paramClassLoader)
    {
      paramClassLoader.printStackTrace();
    }
    return null;
  }
  
  public static Method a(Class paramClass, String paramString, Class[] paramArrayOfClass)
  {
    try
    {
      paramClass = paramClass.getDeclaredMethod(paramString, paramArrayOfClass);
      paramClass.setAccessible(true);
      return paramClass;
    }
    catch (NoSuchMethodException paramClass)
    {
      paramClass.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.werewolves.ReflectUtils
 * JD-Core Version:    0.7.0.1
 */