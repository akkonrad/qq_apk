package c.t.m.g;

import android.content.ComponentName;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;

public final class cc
{
  private static String a = "";
  private static String b = "";
  
  public static int a(Context paramContext, String paramString)
  {
    int j = -407;
    try
    {
      paramContext = paramContext.getPackageManager().getApplicationInfo(paramString, 128);
      if (paramContext == null) {
        return -407;
      }
      if (paramContext.metaData == null) {
        return -408;
      }
      int i = paramContext.metaData.getInt("halley_appid", 0);
      j = i;
      if (i <= 0) {
        return -408;
      }
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return j;
  }
  
  public static a a(int paramInt, Context paramContext, String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return null;
    }
    try
    {
      paramContext = paramContext.getPackageManager().getServiceInfo(new ComponentName(paramString1, paramString2), 128);
      if (paramContext != null)
      {
        paramContext = new a(paramInt, paramString1, paramContext.enabled, paramContext.exported, paramContext.processName, paramContext.metaData);
        return paramContext;
      }
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return null;
  }
  
  public static String a()
  {
    if (!TextUtils.isEmpty(b)) {
      return b;
    }
    String str = l.a().getSharedPreferences(a(false), 0).getString("deviceid", "");
    b = str;
    return str;
  }
  
  public static String a(int paramInt)
  {
    String str = "";
    if (paramInt == 2) {
      str = "2g";
    }
    do
    {
      return str;
      if (paramInt == 3) {
        return "3g";
      }
      if (paramInt == 4) {
        return "4g";
      }
    } while (paramInt != 1);
    return "wifi";
  }
  
  public static String a(Context paramContext)
  {
    if (!TextUtils.isEmpty(a)) {
      return a;
    }
    String str3 = paramContext.getPackageName();
    String str2 = ch.a(Process.myPid());
    String str1;
    if (!TextUtils.isEmpty(str2))
    {
      str1 = str2;
      if (str2.startsWith(str3)) {}
    }
    else
    {
      str1 = ch.a(paramContext, Process.myPid());
    }
    a = str1;
    return str1;
  }
  
  private static String a(boolean paramBoolean)
  {
    Object localObject = new StringBuilder("HalleyServicePreferences_").append(l.c());
    l.b();
    String str = ((StringBuilder)localObject).toString();
    localObject = str;
    if (paramBoolean) {
      localObject = str + "_" + l.i();
    }
    return localObject;
  }
  
  public static void a(String paramString)
  {
    l.a().getSharedPreferences(a(false), 0).edit().putString("deviceid", paramString).commit();
    b = paramString;
  }
  
  public static void a(String paramString, int paramInt)
  {
    l.a().getSharedPreferences(a(false), 0).edit().putInt(paramString, paramInt).commit();
  }
  
  public static void a(String paramString, long paramLong)
  {
    l.a().getSharedPreferences(a(false), 0).edit().putLong(paramString, paramLong).commit();
  }
  
  public static void a(String paramString1, String paramString2)
  {
    l.a().getSharedPreferences(a(true), 0).edit().putString(paramString1, paramString2).commit();
  }
  
  public static long b(String paramString)
  {
    return l.a().getSharedPreferences(a(false), 0).getLong(paramString, 0L);
  }
  
  public static String b(String paramString1, String paramString2)
  {
    return l.a().getSharedPreferences(a(true), 0).getString(paramString1, paramString2);
  }
  
  public static int c(String paramString)
  {
    return l.a().getSharedPreferences(a(false), 0).getInt(paramString, 0);
  }
  
  public static final class a
  {
    public String a;
    public boolean b = false;
    public boolean c = false;
    public String d = "";
    public Bundle e;
    private int f;
    
    public a(int paramInt, String paramString1, boolean paramBoolean1, boolean paramBoolean2, String paramString2, Bundle paramBundle)
    {
      this.f = paramInt;
      this.a = paramString1;
      this.b = paramBoolean1;
      this.c = paramBoolean2;
      this.d = paramString2;
      this.e = paramBundle;
    }
    
    public final String toString()
    {
      return "appid:" + this.f + "," + this.a + "," + this.b + "," + this.c + "," + this.d;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     c.t.m.g.cc
 * JD-Core Version:    0.7.0.1
 */