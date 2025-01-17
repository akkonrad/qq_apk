package cooperation.qqfav;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import com.qq.jce.wup.BasicClassTypeUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener;
import com.tencent.mobileqq.pluginsdk.PluginManagerHelper;
import com.tencent.mobileqq.pluginsdk.PluginManagerHelper.OnPluginManagerLoadedListener;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import iga;
import igb;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public final class QfavHelper
  implements iga
{
  public static final String X = "com.qqfav.QfavAppInterface";
  public static PluginManagerHelper.OnPluginManagerLoadedListener a = null;
  
  public static ClassLoader a()
  {
    Object localObject = BaseApplicationImpl.a().getApplicationContext();
    try
    {
      localObject = PluginStatic.getOrCreateClassLoader((Context)localObject, "qqfav.apk");
      localException1.printStackTrace();
    }
    catch (Exception localException1)
    {
      try
      {
        BasicClassTypeUtil.setClassLoader(true, (ClassLoader)localObject);
        return localObject;
      }
      catch (Exception localException2)
      {
        break label24;
      }
      localException1 = localException1;
      localObject = null;
    }
    label24:
    return localObject;
  }
  
  public static Object a(String paramString)
  {
    return a(paramString, new Class[0], new Object[0]);
  }
  
  public static Object a(String paramString, Class paramClass, Object paramObject)
  {
    return a(paramString, new Class[] { paramClass }, new Object[] { paramObject });
  }
  
  public static Object a(String paramString, Class[] paramArrayOfClass, Object[] paramArrayOfObject)
  {
    for (;;)
    {
      try
      {
        Class localClass = Class.forName(paramString);
        paramString = localClass;
        ClassLoader localClassLoader;
        paramString = null;
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        try
        {
          return paramString.getDeclaredConstructor(paramArrayOfClass).newInstance(paramArrayOfObject);
        }
        catch (ClassNotFoundException paramString)
        {
          paramString.printStackTrace();
          return null;
        }
        localClassNotFoundException = localClassNotFoundException;
        localClassLoader = a();
        if (localClassLoader != null) {
          paramString = localClassLoader.loadClass(paramString);
        }
      }
      catch (IllegalArgumentException paramString)
      {
        paramString.printStackTrace();
        return null;
      }
      catch (IllegalAccessException paramString)
      {
        paramString.printStackTrace();
        return null;
      }
      catch (InstantiationException paramString)
      {
        paramString.printStackTrace();
        return null;
      }
      catch (InvocationTargetException paramString)
      {
        paramString.printStackTrace();
        return null;
      }
      catch (NoSuchMethodException paramString)
      {
        paramString.printStackTrace();
        return null;
      }
      catch (NullPointerException paramString)
      {
        paramString.printStackTrace();
        return null;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return null;
      }
    }
  }
  
  public static AppRuntime a(BaseApplicationImpl paramBaseApplicationImpl)
  {
    return (AppRuntime)a("com.qqfav.QfavAppInterface", new Class[] { BaseApplicationImpl.class, String.class }, new Object[] { paramBaseApplicationImpl, "qqfav" });
  }
  
  public static void a(Context paramContext, OnPluginInstallListener paramOnPluginInstallListener)
  {
    Context localContext = paramContext;
    if (paramContext == null) {
      localContext = BaseApplicationImpl.a().getApplicationContext();
    }
    a = new igb(paramOnPluginInstallListener);
    PluginManagerHelper.getPluginInterface(localContext, a);
  }
  
  public static boolean a(Activity paramActivity, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("nOperation", 3);
    return QfavPluginProxyActivity.a(paramActivity, paramString, localIntent, -1);
  }
  
  public static boolean a(Activity paramActivity, String paramString, Intent paramIntent, int paramInt)
  {
    paramIntent.setFlags(paramIntent.getFlags() & 0xFBFFFFFF & 0xDFFFFFFF);
    return QfavPluginProxyActivity.a(paramActivity, paramString, paramIntent, paramInt);
  }
  
  public static boolean a(Context paramContext)
  {
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    if (paramContext != null)
    {
      paramContext = paramContext.iterator();
      while (paramContext.hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
        if ((localRunningAppProcessInfo.processName != null) && (localRunningAppProcessInfo.processName.endsWith(":qqfav"))) {
          return true;
        }
      }
    }
    return false;
  }
  
  public static boolean b(Activity paramActivity, String paramString, Intent paramIntent, int paramInt)
  {
    if (paramIntent == null) {}
    for (paramIntent = new Intent();; paramIntent = new Intent(paramIntent))
    {
      paramIntent.putExtra("nOperation", 2);
      paramIntent.putExtra("bShowProgress", true);
      return QfavPluginProxyActivity.a(paramActivity, paramString, paramIntent, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cooperation.qqfav.QfavHelper
 * JD-Core Version:    0.7.0.1
 */