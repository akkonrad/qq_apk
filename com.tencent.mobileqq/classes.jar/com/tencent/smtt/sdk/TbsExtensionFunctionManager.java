package com.tencent.smtt.sdk;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.utils.ReflectionUtils;
import com.tencent.smtt.utils.TbsLog;
import java.io.File;
import java.io.IOException;

public class TbsExtensionFunctionManager
{
  public static final String BUGLY_SWITCH_FILE_NAME = "bugly_switch.txt";
  public static final String COOKIE_SWITCH_FILE_NAME = "cookie_switch.txt";
  private static final String LOGTAG = "TbsExtensionFunMana";
  public static final String SP_KEY_COOKIE_DB_VERSION = "cookie_db_version";
  public static final String SP_NAME_FOR_COOKIE = "cookie_compatiable";
  public static final int SWITCH_BYTE_COOKIE = 1;
  private static final String TBS_BUGLY_CLASS_NAME = "com.tencent.smtt.tbs.bugly.TBSBuglyManager";
  private static final String TBS_BUGLY_DEX_NAME = "tbs_bugly_dex.jar";
  private static final String TBS_BUGLY_INIT_METHOD_NAME = "initBugly";
  public static final String USEX5_FILE_NAME = "usex5.txt";
  private static TbsExtensionFunctionManager mInstance;
  private boolean mIsBuglyInited;
  
  public static TbsExtensionFunctionManager getInstance()
  {
    if (mInstance == null) {}
    try
    {
      if (mInstance == null) {
        mInstance = new TbsExtensionFunctionManager();
      }
      return mInstance;
    }
    finally {}
  }
  
  /* Error */
  public boolean canUseFunction(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: aload_0
    //   4: monitorenter
    //   5: new 53	java/io/File
    //   8: dup
    //   9: aload_1
    //   10: invokevirtual 59	android/content/Context:getFilesDir	()Ljava/io/File;
    //   13: aload_2
    //   14: invokespecial 62	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   17: astore_1
    //   18: aload_1
    //   19: ifnonnull +39 -> 58
    //   22: ldc 14
    //   24: new 64	java/lang/StringBuilder
    //   27: dup
    //   28: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   31: ldc 67
    //   33: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: aload_2
    //   37: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: ldc 73
    //   42: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: invokestatic 83	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   51: iload 4
    //   53: istore_3
    //   54: aload_0
    //   55: monitorexit
    //   56: iload_3
    //   57: ireturn
    //   58: iload 4
    //   60: istore_3
    //   61: aload_1
    //   62: invokevirtual 87	java/io/File:exists	()Z
    //   65: ifeq -11 -> 54
    //   68: aload_1
    //   69: invokevirtual 90	java/io/File:isFile	()Z
    //   72: istore 5
    //   74: iload 4
    //   76: istore_3
    //   77: iload 5
    //   79: ifeq -25 -> 54
    //   82: iconst_1
    //   83: istore_3
    //   84: goto -30 -> 54
    //   87: astore_1
    //   88: aload_0
    //   89: monitorexit
    //   90: aload_1
    //   91: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	92	0	this	TbsExtensionFunctionManager
    //   0	92	1	paramContext	Context
    //   0	92	2	paramString	String
    //   53	31	3	bool1	boolean
    //   1	74	4	bool2	boolean
    //   72	6	5	bool3	boolean
    // Exception table:
    //   from	to	target	type
    //   5	18	87	finally
    //   22	51	87	finally
    //   61	74	87	finally
  }
  
  /* Error */
  public int getRomCookieDBVersion(Context paramContext)
  {
    // Byte code:
    //   0: iconst_m1
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: getstatic 97	android/os/Build$VERSION:SDK_INT	I
    //   7: bipush 11
    //   9: if_icmplt +19 -> 28
    //   12: aload_1
    //   13: ldc 20
    //   15: iconst_4
    //   16: invokevirtual 101	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   19: astore_1
    //   20: aload_1
    //   21: ifnonnull +18 -> 39
    //   24: aload_0
    //   25: monitorexit
    //   26: iload_2
    //   27: ireturn
    //   28: aload_1
    //   29: ldc 20
    //   31: iconst_0
    //   32: invokevirtual 101	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   35: astore_1
    //   36: goto -16 -> 20
    //   39: aload_1
    //   40: ldc 17
    //   42: iconst_m1
    //   43: invokeinterface 107 3 0
    //   48: istore_2
    //   49: goto -25 -> 24
    //   52: astore_1
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_1
    //   56: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	this	TbsExtensionFunctionManager
    //   0	57	1	paramContext	Context
    //   1	48	2	i	int
    // Exception table:
    //   from	to	target	type
    //   4	20	52	finally
    //   28	36	52	finally
    //   39	49	52	finally
  }
  
  public void initTbsBuglyIfNeed(Context paramContext)
  {
    for (;;)
    {
      try
      {
        boolean bool = this.mIsBuglyInited;
        if (bool) {
          return;
        }
        if (!canUseFunction(paramContext, "bugly_switch.txt"))
        {
          TbsLog.i("TbsExtensionFunMana", "bugly is forbiden!!");
          continue;
        }
        if (!TbsShareManager.isThirdPartyApp(paramContext)) {}
      }
      finally {}
      for (Object localObject1 = TbsShareManager.getAvailableTbsCorePath(paramContext);; localObject1 = ((File)localObject1).getAbsolutePath())
      {
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break label130;
        }
        TbsLog.i("TbsExtensionFunMana", "bugly init ,corePath is null");
        break;
        localObject1 = TbsInstaller.getInstance().getTbsCoreShareDir(paramContext);
        if (localObject1 == null) {
          TbsLog.i("TbsExtensionFunMana", "getTbsCoreShareDir is null");
        }
        if ((((File)localObject1).listFiles() == null) || (((File)localObject1).listFiles().length <= 0))
        {
          TbsLog.i("TbsExtensionFunMana", "getTbsCoreShareDir is empty!");
          break;
        }
      }
      label130:
      Object localObject3 = TbsInstaller.getInstance().getTbsCoreShareDir(paramContext);
      if (localObject3 == null)
      {
        TbsLog.i("TbsExtensionFunMana", "bugly init ,optDir is null");
      }
      else
      {
        Object localObject4 = new File((String)localObject1, "tbs_bugly_dex.jar");
        try
        {
          Object localObject2 = ((File)localObject4).getParent();
          localObject4 = ((File)localObject4).getAbsolutePath();
          localObject3 = ((File)localObject3).getAbsolutePath();
          localObject2 = new DexLoader((String)localObject2, paramContext, new String[] { localObject4 }, (String)localObject3, null).loadClass("com.tencent.smtt.tbs.bugly.TBSBuglyManager");
          int i = WebView.getTbsSDKVersion(paramContext);
          int j = WebView.getTbsCoreVersion(paramContext);
          ReflectionUtils.invokeStatic((Class)localObject2, "initBugly", new Class[] { Context.class, String.class, String.class, String.class }, new Object[] { paramContext, localObject1, String.valueOf(i), String.valueOf(j) });
          this.mIsBuglyInited = true;
          TbsLog.i("TbsExtensionFunMana", "initTbsBuglyIfNeed success!");
        }
        catch (Throwable paramContext)
        {
          TbsLog.i("TbsExtensionFunMana", "bugly init ,try init bugly failed(need new core):" + Log.getStackTraceString(paramContext));
        }
      }
    }
  }
  
  public boolean setFunctionEnable(Context paramContext, String paramString, boolean paramBoolean)
  {
    boolean bool = false;
    if (paramContext == null) {
      paramBoolean = bool;
    }
    for (;;)
    {
      return paramBoolean;
      try
      {
        paramContext = new File(paramContext.getFilesDir(), paramString);
        if (paramContext == null)
        {
          TbsLog.e("TbsExtensionFunMana", "setFunctionEnable," + paramString + " is null!");
          paramBoolean = bool;
          continue;
        }
      }
      finally {}
      if (paramBoolean)
      {
        paramBoolean = paramContext.exists();
        if (!paramBoolean) {
          try
          {
            paramBoolean = paramContext.createNewFile();
            if (!paramBoolean) {
              break label184;
            }
            paramBoolean = true;
          }
          catch (IOException paramContext)
          {
            TbsLog.e("TbsExtensionFunMana", "setFunctionEnable,createNewFile fail:" + paramString);
            paramContext.printStackTrace();
            paramBoolean = bool;
          }
        }
      }
      else if (paramContext.exists())
      {
        if (paramContext.delete())
        {
          paramBoolean = true;
          continue;
        }
        TbsLog.e("TbsExtensionFunMana", "setFunctionEnable,file.delete fail:" + paramString);
        paramBoolean = bool;
        continue;
      }
      label184:
      paramBoolean = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsExtensionFunctionManager
 * JD-Core Version:    0.7.0.1
 */