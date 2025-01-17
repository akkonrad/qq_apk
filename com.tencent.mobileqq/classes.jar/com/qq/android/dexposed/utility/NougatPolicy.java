package com.qq.android.dexposed.utility;

import android.content.Context;
import android.os.SystemClock;
import android.util.Log;
import java.lang.reflect.Method;

public class NougatPolicy
{
  private static final String TAG = "NougatPolicy";
  
  public static boolean clearCompileData(Context paramContext)
  {
    try
    {
      Object localObject = getPackageManagerBinderProxy();
      boolean bool = ((Boolean)localObject.getClass().getDeclaredMethod("performDexOpt", new Class[] { String.class, Boolean.TYPE, Integer.TYPE, Boolean.TYPE }).invoke(localObject, new Object[] { paramContext.getPackageName(), Boolean.valueOf(false), Integer.valueOf(2), Boolean.valueOf(true) })).booleanValue();
      return bool;
    }
    catch (Throwable paramContext)
    {
      TraceLogger.e("NougatPolicy", "clear compile data failed", paramContext);
    }
    return false;
  }
  
  public static boolean fullCompile(Context paramContext)
  {
    try
    {
      long l1 = SystemClock.elapsedRealtime();
      Object localObject = getPackageManagerBinderProxy();
      if (localObject == null)
      {
        TraceLogger.e("NougatPolicy", "can not found package service");
        return false;
      }
      boolean bool = ((Boolean)localObject.getClass().getDeclaredMethod("performDexOptMode", new Class[] { String.class, Boolean.TYPE, String.class, Boolean.TYPE }).invoke(localObject, new Object[] { paramContext.getPackageName(), Boolean.valueOf(false), "speed", Boolean.valueOf(true) })).booleanValue();
      long l2 = SystemClock.elapsedRealtime();
      Log.i("NougatPolicy", "full Compile cost: " + (l2 - l1) + " result:" + bool);
      return bool;
    }
    catch (Throwable paramContext)
    {
      TraceLogger.e("NougatPolicy", "fullCompile failed:", paramContext);
    }
    return false;
  }
  
  private static Object getPackageManagerBinderProxy()
    throws Exception
  {
    return Class.forName("android.app.ActivityThread").getDeclaredMethod("getPackageManager", new Class[0]).invoke(null, new Object[0]);
  }
  
  private static class TraceLogger
  {
    static void e(String paramString1, String paramString2)
    {
      Log.i(paramString1, paramString2);
    }
    
    static void e(String paramString1, String paramString2, Throwable paramThrowable)
    {
      Log.i(paramString1, paramString2, paramThrowable);
    }
    
    static void i(String paramString1, String paramString2)
    {
      Log.i(paramString1, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.qq.android.dexposed.utility.NougatPolicy
 * JD-Core Version:    0.7.0.1
 */