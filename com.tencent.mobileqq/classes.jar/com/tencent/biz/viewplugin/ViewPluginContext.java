package com.tencent.biz.viewplugin;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import com.tencent.mobileqq.pluginsdk.DebugHelper;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ViewPluginContext
  extends ContextThemeWrapper
{
  private int jdField_a_of_type_Int;
  private AssetManager jdField_a_of_type_AndroidContentResAssetManager;
  private Resources.Theme jdField_a_of_type_AndroidContentResResources$Theme;
  private Resources jdField_a_of_type_AndroidContentResResources;
  private ClassLoader jdField_a_of_type_JavaLangClassLoader;
  
  public ViewPluginContext(Context paramContext, int paramInt, ViewPluginContext paramViewPluginContext)
  {
    super(paramContext, paramInt);
    this.jdField_a_of_type_JavaLangClassLoader = paramViewPluginContext.jdField_a_of_type_JavaLangClassLoader;
    this.jdField_a_of_type_AndroidContentResAssetManager = paramViewPluginContext.jdField_a_of_type_AndroidContentResAssetManager;
    this.jdField_a_of_type_AndroidContentResResources$Theme = paramViewPluginContext.jdField_a_of_type_AndroidContentResResources$Theme;
    this.jdField_a_of_type_AndroidContentResResources = paramViewPluginContext.jdField_a_of_type_AndroidContentResResources;
    this.jdField_a_of_type_Int = paramViewPluginContext.jdField_a_of_type_Int;
  }
  
  public ViewPluginContext(Context paramContext, int paramInt, String paramString, ClassLoader paramClassLoader)
  {
    this(paramContext, paramInt, paramString, paramClassLoader, null, true);
  }
  
  public ViewPluginContext(Context paramContext, int paramInt, String paramString, ClassLoader paramClassLoader, Resources paramResources, boolean paramBoolean)
  {
    super(paramContext, paramInt);
    this.jdField_a_of_type_JavaLangClassLoader = paramClassLoader;
    if (paramResources != null)
    {
      this.jdField_a_of_type_AndroidContentResAssetManager = paramResources.getAssets();
      this.jdField_a_of_type_AndroidContentResResources = paramResources;
      this.jdField_a_of_type_AndroidContentResResources$Theme = a(this.jdField_a_of_type_AndroidContentResResources);
      return;
    }
    paramResources = a(paramContext);
    if ((!TextUtils.isEmpty(paramResources)) && (paramBoolean))
    {
      paramClassLoader = new String[2];
      paramClassLoader[0] = paramResources;
      paramClassLoader[1] = paramString;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ViewPluginContext", 2, "qq path:" + paramResources + ", apk path:" + paramString);
      }
      this.jdField_a_of_type_AndroidContentResAssetManager = a(paramClassLoader);
      this.jdField_a_of_type_AndroidContentResResources = a(paramContext, this.jdField_a_of_type_AndroidContentResAssetManager);
      break;
      paramClassLoader = new String[1];
      paramClassLoader[0] = paramString;
    }
  }
  
  private int a(String paramString)
  {
    try
    {
      String str2 = paramString.substring(0, paramString.indexOf(".R.") + 2);
      i = paramString.lastIndexOf(".");
      String str1 = paramString.substring(i + 1, paramString.length());
      paramString = paramString.substring(0, i);
      String str3 = paramString.substring(paramString.lastIndexOf(".") + 1, paramString.length());
      str2 = str2 + "$" + str3;
      i = Class.forName(str2).getDeclaredField(str1).getInt(null);
      paramString.printStackTrace();
    }
    catch (Throwable paramString)
    {
      try
      {
        if (DebugHelper.sDebug)
        {
          DebugHelper.log("plugin_tag", "getInnderR rStrnig:" + paramString);
          DebugHelper.log("plugin_tag", "getInnderR className:" + str2);
          DebugHelper.log("plugin_tag", "getInnderR fieldName:" + str1);
        }
        return i;
      }
      catch (Throwable paramString)
      {
        int i;
        break label184;
      }
      paramString = paramString;
      i = -1;
    }
    label184:
    return i;
  }
  
  private AssetManager a(String[] paramArrayOfString)
  {
    try
    {
      AssetManager localAssetManager = (AssetManager)AssetManager.class.newInstance();
      localThrowable1.printStackTrace();
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        AssetManager.class.getDeclaredMethod("addAssetPaths", new Class[] { [Ljava.lang.String.class }).invoke(localAssetManager, new Object[] { paramArrayOfString });
        return localAssetManager;
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          paramArrayOfString = localThrowable1;
          Object localObject = localThrowable2;
        }
      }
      localThrowable1 = localThrowable1;
      paramArrayOfString = null;
    }
    return paramArrayOfString;
  }
  
  private Resources.Theme a(Resources paramResources)
  {
    paramResources = paramResources.newTheme();
    this.jdField_a_of_type_Int = a("com.android.internal.R.style.Theme");
    paramResources.applyStyle(this.jdField_a_of_type_Int, true);
    return paramResources;
  }
  
  private Resources a(Context paramContext, AssetManager paramAssetManager)
  {
    return new Resources(paramAssetManager, paramContext.getResources().getDisplayMetrics(), paramContext.getResources().getConfiguration());
  }
  
  public static String a(Context paramContext)
  {
    Object localObject1 = null;
    Object localObject2 = paramContext.getPackageManager();
    paramContext = paramContext.getPackageName();
    try
    {
      localObject2 = ((PackageManager)localObject2).getApplicationInfo(paramContext, 8192);
      paramContext = localObject1;
      if (localObject2 != null) {
        paramContext = ((ApplicationInfo)localObject2).sourceDir;
      }
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public AssetManager getAssets()
  {
    return this.jdField_a_of_type_AndroidContentResAssetManager;
  }
  
  public ClassLoader getClassLoader()
  {
    if (this.jdField_a_of_type_JavaLangClassLoader != null) {
      return this.jdField_a_of_type_JavaLangClassLoader;
    }
    return super.getClassLoader();
  }
  
  public Resources getResources()
  {
    return this.jdField_a_of_type_AndroidContentResResources;
  }
  
  public Resources.Theme getTheme()
  {
    return this.jdField_a_of_type_AndroidContentResResources$Theme;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.viewplugin.ViewPluginContext
 * JD-Core Version:    0.7.0.1
 */