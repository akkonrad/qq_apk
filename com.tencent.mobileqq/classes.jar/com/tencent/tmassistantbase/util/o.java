package com.tencent.tmassistantbase.util;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;

public class o
{
  protected static String b = "NA";
  protected Context a = null;
  
  public o(Context paramContext)
  {
    this.a = paramContext;
  }
  
  private StringBuffer a(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if (TextUtils.isEmpty(paramString))
    {
      localStringBuffer.append("NA");
      return localStringBuffer;
    }
    paramString = paramString.toCharArray();
    int i = 0;
    while (i < paramString.length)
    {
      if ((paramString[i] > ' ') && (paramString[i] != '/') && (paramString[i] != '_') && (paramString[i] != '&') && (paramString[i] != '|') && (paramString[i] != '-')) {
        localStringBuffer.append(paramString[i]);
      }
      i += 1;
    }
    return localStringBuffer;
  }
  
  public static String b()
  {
    if ("1002".contains("BuildNo")) {
      return "0000";
    }
    return "1002";
  }
  
  private int c()
  {
    return this.a.getResources().getDisplayMetrics().widthPixels;
  }
  
  private int d()
  {
    return this.a.getResources().getDisplayMetrics().heightPixels;
  }
  
  private int e()
  {
    return 0;
  }
  
  private String f()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(a(Build.BRAND));
    localStringBuffer.append("_");
    localStringBuffer.append(a(Build.MODEL));
    return localStringBuffer.toString();
  }
  
  private String g()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    String str = Build.VERSION.RELEASE;
    if (TextUtils.isEmpty(str)) {
      localStringBuffer.append("NA");
    }
    for (;;)
    {
      localStringBuffer.append("_");
      localStringBuffer.append(Build.VERSION.SDK_INT);
      return localStringBuffer.toString();
      localStringBuffer.append(str);
    }
  }
  
  public String a()
  {
    n localn = new n();
    localn.c = b();
    localn.d = "";
    localn.e = b;
    localn.f = g();
    localn.h = d();
    localn.g = c();
    localn.i = e();
    localn.a = f();
    localn.b = "1002";
    return localn.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tmassistantbase.util.o
 * JD-Core Version:    0.7.0.1
 */