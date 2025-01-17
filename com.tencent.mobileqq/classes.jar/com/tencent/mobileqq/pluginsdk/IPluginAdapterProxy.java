package com.tencent.mobileqq.pluginsdk;

import android.os.Looper;
import com.tencent.qphone.base.util.QLog;

public class IPluginAdapterProxy
{
  static IPluginAdapterProxy a;
  private IPluginAdapter b;
  public String currentUin;
  
  private IPluginAdapterProxy(IPluginAdapter paramIPluginAdapter)
  {
    this.b = paramIPluginAdapter;
  }
  
  public static IPluginAdapterProxy getProxy()
  {
    return a;
  }
  
  public static void setProxy(IPluginAdapter paramIPluginAdapter)
  {
    a = new IPluginAdapterProxy(paramIPluginAdapter);
  }
  
  public Looper getSubThreadLooper()
  {
    IPluginAdapter localIPluginAdapter = this.b;
    if (localIPluginAdapter == null)
    {
      QLog.d("plugin_tag", 1, "IPluginAdapter null");
      return null;
    }
    return (Looper)localIPluginAdapter.invoke(2, null);
  }
  
  public boolean isDefaultMode()
  {
    IPluginAdapter localIPluginAdapter = this.b;
    boolean bool1;
    if (localIPluginAdapter == null)
    {
      QLog.d("plugin_tag", 1, "IPluginAdapter null");
      bool1 = false;
    }
    boolean bool2;
    do
    {
      return bool1;
      bool2 = ((Boolean)localIPluginAdapter.invoke(3, null)).booleanValue();
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.d("plugin_tag", 1, "isDefaultMode = " + bool2);
    return bool2;
  }
  
  public boolean isNightMode()
  {
    IPluginAdapter localIPluginAdapter = this.b;
    if (localIPluginAdapter == null)
    {
      QLog.d("plugin_tag", 1, "IPluginAdapter null");
      return false;
    }
    return ((Boolean)localIPluginAdapter.invoke(1, null)).booleanValue();
  }
  
  public int isSupportImmersive()
  {
    try
    {
      IPluginAdapter localIPluginAdapter = this.b;
      if (localIPluginAdapter == null)
      {
        QLog.d("plugin_tag", 1, "IPluginAdapter null");
        return -1;
      }
      int i = ((Integer)localIPluginAdapter.invoke(5, null)).intValue();
      return i;
    }
    catch (Exception localException) {}
    return -1;
  }
  
  public boolean isSupportMultiDex(String paramString)
  {
    IPluginAdapter localIPluginAdapter = this.b;
    if (localIPluginAdapter == null)
    {
      QLog.d("plugin_tag", 1, "IPluginAdapter null");
      return false;
    }
    return ((Boolean)localIPluginAdapter.invoke(4, paramString)).booleanValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.IPluginAdapterProxy
 * JD-Core Version:    0.7.0.1
 */