package com.tencent.smtt.utils;

import android.os.Build.VERSION;
import android.util.Log;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;

public class ReflectionUtils
{
  public static Method getParentDeclaredMethod(Object paramObject, String paramString, Class<?>... paramVarArgs)
  {
    paramObject = paramObject.getClass();
    while (paramObject != Object.class)
    {
      if (paramObject == null) {
        return null;
      }
      try
      {
        Method localMethod = paramObject.getDeclaredMethod(paramString, paramVarArgs);
        return localMethod;
      }
      catch (Exception localException)
      {
        paramObject = paramObject.getSuperclass();
      }
    }
    return null;
  }
  
  public static Object invokeInstance(Object paramObject, String paramString)
  {
    return invokeInstance(paramObject, paramString, null, new Object[0]);
  }
  
  public static Object invokeInstance(Object paramObject, String paramString, Class<?>[] paramArrayOfClass, Object... paramVarArgs)
  {
    if (paramObject == null) {}
    do
    {
      return null;
      try
      {
        Object localObject = paramObject.getClass();
        if (Build.VERSION.SDK_INT > 10) {}
        for (paramArrayOfClass = ((Class)localObject).getMethod(paramString, paramArrayOfClass);; paramArrayOfClass = ((Class)localObject).getDeclaredMethod(paramString, paramArrayOfClass))
        {
          paramArrayOfClass.setAccessible(true);
          localObject = paramVarArgs;
          if (paramVarArgs.length == 0) {
            localObject = null;
          }
          return paramArrayOfClass.invoke(paramObject, (Object[])localObject);
        }
        if (paramString == null) {
          break;
        }
      }
      catch (Throwable paramObject)
      {
        TbsLog.addLog(997, String.valueOf(paramObject), new Object[0]);
        if ((paramObject.getCause() != null) && (paramObject.getCause().toString().contains("AuthenticationFail"))) {
          return new String("AuthenticationFail");
        }
      }
    } while ((paramString.equalsIgnoreCase("canLoadX5Core")) || (paramString.equalsIgnoreCase("initTesRuntimeEnvironment")));
    paramString = new StringWriter();
    paramObject.printStackTrace(new PrintWriter(paramString));
    Log.e("ReflectionUtils", "invokeInstance -- exceptions:" + paramString.toString());
    return null;
  }
  
  public static Object invokeStatic(Class<?> paramClass, String paramString, Class<?>[] paramArrayOfClass, Object... paramVarArgs)
  {
    try
    {
      paramClass = paramClass.getMethod(paramString, paramArrayOfClass);
      paramClass.setAccessible(true);
      paramClass = paramClass.invoke(null, paramVarArgs);
      return paramClass;
    }
    catch (Throwable paramClass)
    {
      TbsLog.addLog(997, String.valueOf(paramClass), new Object[0]);
      paramClass.printStackTrace();
    }
    return null;
  }
  
  public static Object invokeStatic(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = Class.forName(paramString1).getMethod(paramString2, new Class[0]).invoke(null, new Object[0]);
      return paramString1;
    }
    catch (Throwable paramString1)
    {
      TbsLog.addLog(997, String.valueOf(paramString1), new Object[0]);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.smtt.utils.ReflectionUtils
 * JD-Core Version:    0.7.0.1
 */