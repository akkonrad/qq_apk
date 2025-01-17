package cooperation.comic;

import amjh;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.qq.jce.wup.BasicClassTypeUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mfsdk.MagnifierSDK;
import com.tencent.mfsdk.reporter.ReporterMachine;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.mobileqq.statistics.UnifiedMonitor;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import mqq.app.AppRuntime;

public class VipComicHelper
{
  public static VipComicHelper.ExtraParams a;
  public static String a;
  public static AtomicLong a;
  public static AtomicReference a;
  private static boolean a;
  public static String b;
  public static String c;
  public static String d;
  public static String e;
  public static String f;
  public static String g;
  public static String h;
  public static String i;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference = new AtomicReference("");
    jdField_a_of_type_JavaLangString = "";
    b = "";
    c = "";
    d = "";
    e = "";
    f = "";
    g = "0";
    h = "";
    jdField_a_of_type_CooperationComicVipComicHelper$ExtraParams = new VipComicHelper.ExtraParams();
    i = "";
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong = new AtomicLong(0L);
  }
  
  public static String a()
  {
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    str = BaseApplicationImpl.getApplication().getSharedPreferences("ComicGlobalConfig_" + str, 0).getString("defaultComicTab", null);
    if (QLog.isColorLevel()) {
      QLog.d("ComicHelper", 2, "[ComicGlobalConfig] get default tab is " + str);
    }
    return str;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (!TextUtils.isEmpty(paramString1))
    {
      localObject1 = localObject2;
      if (paramString1.contains("~")) {
        localObject1 = paramString1.substring(0, paramString1.indexOf("~"));
      }
    }
    paramString1 = (String)localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      paramString1 = "NULL_NULL_NULL_NULL_NULL";
    }
    localObject1 = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      localObject1 = "NULL_NULL_NULL_NULL_NULL";
    }
    paramString2 = ((String)localObject1).split("_");
    if (paramString2.length >= 5) {}
    for (paramString2 = paramString2[4];; paramString2 = "NULL")
    {
      h = paramString2;
      return paramString1 + "~" + (String)localObject1;
    }
  }
  
  public static String a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    return paramString1 + "_" + paramString2 + "_" + paramString3 + "_" + paramString4 + "_" + h;
  }
  
  public static AppRuntime a(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    if ((paramBaseApplicationImpl == null) || (paramString == null)) {
      return null;
    }
    if ((paramBaseApplicationImpl.getRuntime().getRunningModuleSize() > 0) && (VipComicReportUtils.a.get() != 2)) {
      VipComicReportUtils.a.set(3);
    }
    try
    {
      Class localClass1 = Class.forName("com.qqcomic.app.VipComicPluginRuntime");
      if (localClass1 != null) {}
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;)
      {
        try
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("ComicHelper", 2, "createCOMICRuntime: load class failed");
        }
        catch (ClassNotFoundException paramBaseApplicationImpl)
        {
          ClassLoader localClassLoader;
          paramBaseApplicationImpl.printStackTrace();
        }
        localClassNotFoundException = localClassNotFoundException;
        localClassLoader = PluginStatic.getOrCreateClassLoader(paramBaseApplicationImpl, "comic_plugin.apk");
        Class localClass2 = localClassLoader.loadClass("com.qqcomic.app.VipComicPluginRuntime");
        BasicClassTypeUtil.setClassLoader(true, localClassLoader);
        continue;
        do
        {
          return null;
          paramBaseApplicationImpl = localClass2.getDeclaredConstructor(new Class[] { BaseApplicationImpl.class, String.class }).newInstance(new Object[] { paramBaseApplicationImpl, paramString });
        } while ((paramBaseApplicationImpl == null) || (!(paramBaseApplicationImpl instanceof AppRuntime)));
        paramBaseApplicationImpl = (AppRuntime)paramBaseApplicationImpl;
        return paramBaseApplicationImpl;
      }
    }
    catch (IllegalArgumentException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (IllegalAccessException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (InstantiationException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (InvocationTargetException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (NoSuchMethodException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (Exception paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    return null;
  }
  
  public static void a()
  {
    d = "";
    e = "";
    f = "NULL_NULL_NULL_NULL_NULL~NULL_NULL_NULL_NULL_NULL";
    g = "0";
    h = "NULL";
    VipComicHelper.ExtraParams.a(jdField_a_of_type_CooperationComicVipComicHelper$ExtraParams).clear();
    i = "";
  }
  
  public static void a(int paramInt, QQAppInterface paramQQAppInterface)
  {
    if (!NetworkUtil.g(paramQQAppInterface.getApplication()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ComicHelper", 2, "no network. skip update offline pkg. entry = " + paramInt);
      }
      return;
    }
    ThreadManager.post(new amjh(paramInt, paramQQAppInterface), 5, null, false);
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    if ((paramActivity == null) || (paramIntent == null)) {
      return;
    }
    paramIntent.setComponent(new ComponentName("com.tencent.mobileqq", "com.tencent.mobileqq.activity.QQBrowserActivity"));
    paramIntent.putExtra("fragmentStyle", 1);
    paramIntent.putExtra("tabBarStyle", 1);
    paramIntent.putExtra("titleBarStyle", 1);
    paramIntent.putExtra("hide_operation_bar", true);
    paramIntent.putExtra("hide_more_button", true);
    paramIntent.putExtra("isScreenOrientationPortrait", true);
    paramActivity.startActivityForResult(paramIntent, paramInt);
  }
  
  public static void a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ComicHelper", 2, "DO SAVE IMPORTANT PARAMS FOR REPORTING");
    }
    paramBundle.putString("fromCode", jdField_a_of_type_JavaLangString);
    paramBundle.putString("landCode", c);
    paramBundle.putString("landId", d);
    paramBundle.putString("pos", e);
    paramBundle.putString("detailPage_from", f);
    paramBundle.putString("algoId", g);
    paramBundle.putString("actionId", b);
    paramBundle.putString("ext8", h);
    paramBundle.putString("extraParams", jdField_a_of_type_CooperationComicVipComicHelper$ExtraParams.toString());
    paramBundle.putString("storyboardState", i);
  }
  
  public static void a(String paramString)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    localObject = BaseApplicationImpl.getApplication().getSharedPreferences("ComicGlobalConfig_" + (String)localObject, 0);
    String str = ((SharedPreferences)localObject).getString("defaultComicTab", null);
    if (TextUtils.isEmpty(paramString)) {
      if (!TextUtils.isEmpty(str))
      {
        ((SharedPreferences)localObject).edit().remove("defaultComicTab").apply();
        if (QLog.isColorLevel()) {
          QLog.d("ComicHelper", 2, "[ComicGlobalConfig] erase default tab");
        }
      }
    }
    do
    {
      do
      {
        return;
      } while (paramString.equals(str));
      ((SharedPreferences)localObject).edit().putString("defaultComicTab", paramString).apply();
    } while (!QLog.isColorLevel());
    QLog.d("ComicHelper", 2, "[ComicGlobalConfig] update default tab to " + paramString);
  }
  
  public static void a(AppRuntime paramAppRuntime)
  {
    if ((paramAppRuntime == null) || (jdField_a_of_type_Boolean)) {
      return;
    }
    MagnifierSDK.a(paramAppRuntime.getLongAccountUin());
    try
    {
      QLog.i("ComicHelper", 4, "MagnifierSDK is enable, current process is QQComic");
      ReporterMachine.a();
      UnifiedMonitor.a().a();
      jdField_a_of_type_Boolean = true;
      return;
    }
    catch (Exception paramAppRuntime)
    {
      for (;;)
      {
        QLog.e("ComicHelper", 4, "[Magnifier startMachine error]" + paramAppRuntime);
      }
    }
  }
  
  public static boolean a(String paramString, Intent paramIntent)
  {
    int j = 100;
    boolean bool3 = false;
    Object localObject;
    boolean bool1;
    if (paramString != null)
    {
      localObject = Uri.parse(paramString);
      if ((localObject != null) && (((Uri)localObject).isHierarchical()))
      {
        bool1 = "1".equals(((Uri)localObject).getQueryParameter("init_player"));
        paramString = ((Uri)localObject).getQueryParameter("id");
        localObject = ((Uri)localObject).getQueryParameter("type");
      }
    }
    for (;;)
    {
      try
      {
        int k = Integer.parseInt((String)localObject);
        j = k;
      }
      catch (Exception localException)
      {
        boolean bool2;
        continue;
      }
      bool2 = bool3;
      if (!TextUtils.isEmpty(paramString))
      {
        bool2 = bool3;
        if (bool1)
        {
          paramIntent.putExtra("key_comic_id", paramString);
          paramIntent.putExtra("key_type", j);
          paramIntent.putExtra("key_is_fullscreen", false);
          paramIntent.putExtra("params_remote_connect_at_launch", true);
          bool2 = true;
        }
      }
      return bool2;
      paramString = null;
      bool1 = false;
    }
  }
  
  public static void b(Bundle paramBundle)
  {
    if (paramBundle == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ComicHelper", 2, "DO RESTORE IMPORTANT PARAMS FOR REPORTING");
      }
      if (paramBundle.containsKey("fromCode")) {
        jdField_a_of_type_JavaLangString = paramBundle.getString("fromCode");
      }
      if (paramBundle.containsKey("landCode")) {
        c = paramBundle.getString("landCode");
      }
      if (paramBundle.containsKey("landId")) {
        d = paramBundle.getString("landId");
      }
      if (paramBundle.containsKey("pos")) {
        e = paramBundle.getString("pos");
      }
      if (paramBundle.containsKey("detailPage_from")) {
        f = paramBundle.getString("detailPage_from");
      }
      if (paramBundle.containsKey("algoId")) {
        g = paramBundle.getString("algoId");
      }
      if (paramBundle.containsKey("actionId")) {
        b = paramBundle.getString("actionId");
      }
      if (paramBundle.containsKey("ext8")) {
        h = paramBundle.getString("ext8");
      }
      if (paramBundle.containsKey("extraParams")) {
        jdField_a_of_type_CooperationComicVipComicHelper$ExtraParams.a(paramBundle.getString("extraParams"));
      }
    } while (!paramBundle.containsKey("storyboardState"));
    i = paramBundle.getString("storyboardState");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.comic.VipComicHelper
 * JD-Core Version:    0.7.0.1
 */