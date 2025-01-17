package com.tencent.open.component.cache.util;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.BaseApplication;

public class LocalConfig
{
  public static int a(String paramString, int paramInt, long paramLong)
  {
    return a(paramLong).getInt(paramString, paramInt);
  }
  
  public static SharedPreferences a()
  {
    int i = Build.VERSION.SDK_INT;
    BaseApplication localBaseApplication = BaseApplication.getContext();
    if (i > 10) {}
    for (i = 4;; i = 0) {
      return localBaseApplication.getSharedPreferences("OPENSDK_setting", i);
    }
  }
  
  public static SharedPreferences a(long paramLong)
  {
    if (paramLong == 0L) {
      return a();
    }
    String str = MD5Utils.b(String.valueOf(paramLong)) + "_" + "preference";
    return BaseApplication.getContext().getSharedPreferences(str, 0);
  }
  
  public static void a(String paramString, int paramInt, long paramLong)
  {
    SharedPreferences.Editor localEditor = a(paramLong).edit();
    localEditor.putInt(paramString, paramInt);
    localEditor.commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.open.component.cache.util.LocalConfig
 * JD-Core Version:    0.7.0.1
 */