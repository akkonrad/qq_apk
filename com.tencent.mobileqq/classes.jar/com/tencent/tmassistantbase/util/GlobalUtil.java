package com.tencent.tmassistantbase.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GlobalUtil
{
  public static final int DEF_INT = 0;
  public static final long DEF_LONG = 0L;
  public static final String DEF_STRING = "empty";
  protected static final String SharedPreferencesName = "TMAssistantSDKSharedPreference";
  protected static final String TAG = GlobalUtil.class.getSimpleName();
  protected static final String UN_DEFINED = "NA";
  protected static String mDevicedId = "NA";
  protected static GlobalUtil mInstance = null;
  protected static int mMemUUID = 0;
  public final int JCE_CMDID_Empty = 0;
  public final int JCE_CMDID_GetAppSimpleDetail = 5;
  public final int JCE_CMDID_GetAppUpdate = 3;
  public final int JCE_CMDID_GetAuthorized = 4;
  public final int JCE_CMDID_GetCallerSetting = 6;
  public final int JCE_CMDID_GetConfig = 7;
  public final int JCE_CMDID_GetHalleyUrl = 10;
  public final int JCE_CMDID_GetSettings = 2;
  public final int JCE_CMDID_ReportLog = 1;
  public final int JCE_CMDID_StatReport = 9;
  protected Context mContext;
  public HashMap<Integer, String> mJCECmdIdMap = null;
  private String mMACAdress = null;
  public String mQUA = "";
  
  protected GlobalUtil()
  {
    this.mJCECmdIdMap.put(Integer.valueOf(1), "ReportLog");
    this.mJCECmdIdMap.put(Integer.valueOf(2), "GetSettings");
    this.mJCECmdIdMap.put(Integer.valueOf(3), "GetAppUpdate");
    this.mJCECmdIdMap.put(Integer.valueOf(4), "GetAuthorized");
    this.mJCECmdIdMap.put(Integer.valueOf(5), "GetAppSimpleDetail");
    this.mJCECmdIdMap.put(Integer.valueOf(6), "GetCallerSetting");
    this.mJCECmdIdMap.put(Integer.valueOf(7), "GetConfig");
    this.mJCECmdIdMap.put(Integer.valueOf(9), "StatReport");
    this.mJCECmdIdMap.put(Integer.valueOf(10), "GetHalleyUrl");
  }
  
  public static ArrayList<String> String2List(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = paramString.split(",");
      int i = 0;
      while (i < paramString.length)
      {
        CharSequence localCharSequence = paramString[i];
        if (!TextUtils.isEmpty(localCharSequence)) {
          localArrayList.add(localCharSequence);
        }
        i += 1;
      }
    }
    return localArrayList;
  }
  
  public static int assistantErrorCode2SDKErrorCode(int paramInt)
  {
    switch (paramInt)
    {
    case -1000: 
    case -26: 
    case -24: 
    default: 
      return 604;
    case 0: 
      return 0;
    case -1: 
      return 709;
    case -11: 
      return 708;
    case -12: 
      return 730;
    case -13: 
      return 703;
    case -15: 
      return 1;
    case -16: 
      return 731;
    case -21: 
      return 700;
    case -22: 
      return 732;
    case -23: 
      return 601;
    case -25: 
      return 602;
    case -27: 
      return 606;
    }
    return 701;
  }
  
  public static int assistantState2SDKState(int paramInt)
  {
    switch (paramInt)
    {
    case 5: 
    case 7: 
    case 8: 
    default: 
      return 0;
    case 1: 
      return 2;
    case 6: 
      return 1;
    case 2: 
      return 3;
    case 4: 
      return 4;
    case 3: 
      return 5;
    }
    return 6;
  }
  
  public static String calcMD5AsString(String paramString)
  {
    int i = 0;
    Object localObject = "";
    if (!TextUtils.isEmpty(paramString)) {
      paramString = paramString.getBytes();
    }
    try
    {
      localObject = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject).reset();
      ((MessageDigest)localObject).update(paramString, 0, paramString.length);
      paramString = ((MessageDigest)localObject).digest();
      localObject = new StringBuffer();
      while (i < paramString.length)
      {
        ((StringBuffer)localObject).append(Integer.toHexString(paramString[i] & 0xFF));
        i += 1;
      }
      localObject = ((StringBuffer)localObject).toString();
      return localObject;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  public static void deleteOldDB(String paramString)
  {
    if (getInstance().getContext() != null)
    {
      paramString = getInstance().getContext().getDatabasePath(paramString);
      if (paramString.exists() != true) {}
    }
    try
    {
      paramString.delete();
      r.c("GlobalUtil", "deleteDB");
      return;
    }
    catch (Exception paramString)
    {
      r.c("GlobalUtil", "deleteDB failed");
    }
  }
  
  private String filter(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if (TextUtils.isEmpty(paramString))
    {
      localStringBuffer.append("NA");
      return localStringBuffer.toString();
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
    return localStringBuffer.toString();
  }
  
  public static String getAppPackageName(Context paramContext)
  {
    if (paramContext != null) {
      return paramContext.getPackageName();
    }
    return "";
  }
  
  public static int getAppVersionCode(Context paramContext)
  {
    int i = 0;
    if (paramContext != null) {}
    try
    {
      i = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionCode;
      return i;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return 0;
  }
  
  public static GlobalUtil getInstance()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new GlobalUtil();
      }
      GlobalUtil localGlobalUtil = mInstance;
      return localGlobalUtil;
    }
    finally {}
  }
  
  public static int getInt(Integer paramInteger)
  {
    if (paramInteger == null) {
      return 0;
    }
    return paramInteger.intValue();
  }
  
  public static int getMemUUID()
  {
    try
    {
      int i = mMemUUID;
      mMemUUID = i + 1;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public static String getNetStatus()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 200	com/tencent/tmassistantbase/util/GlobalUtil:getInstance	()Lcom/tencent/tmassistantbase/util/GlobalUtil;
    //   6: invokevirtual 204	com/tencent/tmassistantbase/util/GlobalUtil:getContext	()Landroid/content/Context;
    //   9: astore_0
    //   10: aload_0
    //   11: ifnonnull +11 -> 22
    //   14: ldc 65
    //   16: astore_0
    //   17: ldc 2
    //   19: monitorexit
    //   20: aload_0
    //   21: areturn
    //   22: aload_0
    //   23: ldc_w 273
    //   26: invokevirtual 277	android/content/Context:checkCallingOrSelfPermission	(Ljava/lang/String;)I
    //   29: ifeq +16 -> 45
    //   32: ldc 65
    //   34: astore_0
    //   35: goto -18 -> 17
    //   38: astore_0
    //   39: ldc 65
    //   41: astore_0
    //   42: goto -25 -> 17
    //   45: aload_0
    //   46: ldc_w 279
    //   49: invokevirtual 283	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   52: checkcast 285	android/net/ConnectivityManager
    //   55: astore_0
    //   56: aload_0
    //   57: invokevirtual 289	android/net/ConnectivityManager:getActiveNetworkInfo	()Landroid/net/NetworkInfo;
    //   60: astore_0
    //   61: aload_0
    //   62: ifnonnull +25 -> 87
    //   65: ldc 65
    //   67: astore_0
    //   68: goto -51 -> 17
    //   71: astore_0
    //   72: getstatic 53	com/tencent/tmassistantbase/util/GlobalUtil:TAG	Ljava/lang/String;
    //   75: aload_0
    //   76: invokevirtual 292	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   79: invokestatic 295	com/tencent/tmassistantbase/util/r:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   82: aconst_null
    //   83: astore_0
    //   84: goto -23 -> 61
    //   87: aload_0
    //   88: invokevirtual 300	android/net/NetworkInfo:getType	()I
    //   91: iconst_1
    //   92: if_icmpne +10 -> 102
    //   95: ldc_w 302
    //   98: astore_0
    //   99: goto -82 -> 17
    //   102: aload_0
    //   103: invokevirtual 305	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   106: astore_0
    //   107: aload_0
    //   108: ifnonnull +9 -> 117
    //   111: ldc 65
    //   113: astore_0
    //   114: goto -97 -> 17
    //   117: aload_0
    //   118: invokevirtual 308	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   121: astore_0
    //   122: getstatic 53	com/tencent/tmassistantbase/util/GlobalUtil:TAG	Ljava/lang/String;
    //   125: new 310	java/lang/StringBuilder
    //   128: dup
    //   129: invokespecial 311	java/lang/StringBuilder:<init>	()V
    //   132: ldc_w 313
    //   135: invokevirtual 316	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: aload_0
    //   139: invokevirtual 316	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: invokevirtual 317	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   145: invokestatic 320	com/tencent/tmassistantbase/util/r:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   148: goto -131 -> 17
    //   151: astore_0
    //   152: ldc 2
    //   154: monitorexit
    //   155: aload_0
    //   156: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   9	26	0	localObject1	Object
    //   38	1	0	localException1	Exception
    //   41	27	0	localObject2	Object
    //   71	5	0	localException2	Exception
    //   83	56	0	str	String
    //   151	5	0	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   22	32	38	java/lang/Exception
    //   56	61	71	java/lang/Exception
    //   3	10	151	finally
    //   22	32	151	finally
    //   45	56	151	finally
    //   56	61	151	finally
    //   72	82	151	finally
    //   87	95	151	finally
    //   102	107	151	finally
    //   117	148	151	finally
  }
  
  public static String getString(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "empty";
    }
    return str;
  }
  
  public static String getSystemVersion()
  {
    int i = Build.VERSION.SDK_INT;
    return i + "";
  }
  
  public static String getUserId(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "supersdk_nulluser";
    }
    return str;
  }
  
  public static boolean isDBExist(String paramString)
  {
    return (getInstance().getContext() != null) && (getInstance().getContext().getDatabasePath(paramString).exists());
  }
  
  public static boolean isNetworkConncted()
  {
    Object localObject1 = getInstance().getContext();
    if (localObject1 == null)
    {
      r.d(TAG, "GlobalUtil.getInstance().getContext() == null.");
      return false;
    }
    localObject1 = (ConnectivityManager)((Context)localObject1).getSystemService("connectivity");
    try
    {
      localObject1 = ((ConnectivityManager)localObject1).getActiveNetworkInfo();
      if (localObject1 != null)
      {
        bool = ((NetworkInfo)localObject1).isAvailable();
        return bool;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        r.e(TAG, localException.getMessage());
        Object localObject2 = null;
        continue;
        boolean bool = false;
      }
    }
  }
  
  public static boolean isOppo()
  {
    try
    {
      String str = Build.MANUFACTURER;
      if ((!TextUtils.isEmpty(str)) && (str.toLowerCase().contains("oppo"))) {
        return true;
      }
      str = Build.FINGERPRINT;
      if (!TextUtils.isEmpty(str))
      {
        boolean bool = str.toLowerCase().contains("oppo");
        if (bool) {
          break label70;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("DeviceUtils", localException.getMessage(), localException);
      }
    }
    return false;
    label70:
    return true;
  }
  
  public static boolean isVivo()
  {
    return replaceBlank((Build.MANUFACTURER + "-" + Build.MODEL).toLowerCase()).contains("vivo");
  }
  
  public static String replaceBlank(String paramString)
  {
    String str = "";
    if (paramString != null) {
      str = Pattern.compile("\\s*|\t|\r|\n").matcher(paramString).replaceAll("");
    }
    return str;
  }
  
  public static void updateFilePathAuthorized(String paramString)
  {
    Object localObject = new File(paramString);
    String str2 = ((File)localObject).getParent();
    String str1 = new File(str2).getParent();
    paramString = new File(str1).getParent();
    try
    {
      localObject = "chmod 777 " + ((File)localObject).getAbsolutePath();
      Runtime.getRuntime().exec((String)localObject);
      str2 = "chmod 777 " + str2;
      Runtime.getRuntime().exec(str2);
      str1 = "chmod 777 " + str1;
      Runtime.getRuntime().exec(str1);
      paramString = "chmod 777" + paramString;
      Runtime.getRuntime().exec(paramString);
      return;
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public boolean canReportValue()
  {
    return "wifi".equals(getNetStatus());
  }
  
  public void destroy()
  {
    this.mContext = null;
    mInstance = null;
  }
  
  public String getAndroidIdInPhone()
  {
    try
    {
      if (this.mContext == null) {
        return null;
      }
      String str = Settings.Secure.getString(getContext().getContentResolver(), "android_id");
      return str;
    }
    catch (Exception localException)
    {
      r.c(TAG, "getAndroidIdInPhone Exception:", localException);
    }
    return "";
  }
  
  public String getBrand()
  {
    return filter(Build.BRAND);
  }
  
  public Context getContext()
  {
    return this.mContext;
  }
  
  public String getImei()
  {
    try
    {
      if (this.mContext == null) {
        return null;
      }
      if ((mDevicedId != null) && (mDevicedId.equals("NA"))) {
        mDevicedId = ((TelephonyManager)getContext().getSystemService("phone")).getDeviceId();
      }
      String str = mDevicedId;
      return str;
    }
    catch (Exception localException)
    {
      r.c(TAG, "getImei Exception:", localException);
    }
    return null;
  }
  
  public String getImsi()
  {
    try
    {
      if (this.mContext == null) {
        return null;
      }
      String str = ((TelephonyManager)getContext().getSystemService("phone")).getSubscriberId();
      return str;
    }
    catch (Exception localException)
    {
      r.c(TAG, "getImsi Exception:", localException);
    }
    return null;
  }
  
  public int getJceCmdIdByClassName(String paramString)
  {
    if (paramString == null) {
      return 0;
    }
    if (this.mJCECmdIdMap != null)
    {
      Iterator localIterator = this.mJCECmdIdMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Map.Entry)localIterator.next();
        if (localObject != null)
        {
          Integer localInteger = (Integer)((Map.Entry)localObject).getKey();
          localObject = (String)((Map.Entry)localObject).getValue();
          if ((localObject != null) && (((String)localObject).equals(paramString))) {
            return localInteger.intValue();
          }
        }
      }
    }
    return 0;
  }
  
  public String getMacAddress()
  {
    if (this.mContext == null) {
      return null;
    }
    if (!TextUtils.isEmpty(this.mMACAdress)) {
      return this.mMACAdress;
    }
    try
    {
      Object localObject = ((WifiManager)getContext().getSystemService("wifi")).getConnectionInfo();
      if (localObject != null)
      {
        this.mMACAdress = ((WifiInfo)localObject).getMacAddress();
        return this.mMACAdress;
      }
      this.mMACAdress = "EMPTY";
      localObject = this.mMACAdress;
      return localObject;
    }
    catch (Exception localException)
    {
      r.c(TAG, "getMacAddress Exception:", localException);
    }
    return "";
  }
  
  public String getManufacture()
  {
    return filter(Build.MANUFACTURER);
  }
  
  public String getModel()
  {
    return filter(Build.MODEL);
  }
  
  public String getNetworkOperator()
  {
    try
    {
      if (this.mContext == null) {
        return "";
      }
      String str = ((TelephonyManager)this.mContext.getSystemService("phone")).getNetworkOperator();
      return str;
    }
    catch (Exception localException)
    {
      r.c(TAG, "getNetworkOperator Exception:", localException);
    }
    return "";
  }
  
  public int getNetworkType()
  {
    try
    {
      if (this.mContext == null) {
        return 0;
      }
      int i = ((TelephonyManager)this.mContext.getSystemService("phone")).getNetworkType();
      return i;
    }
    catch (Exception localException)
    {
      r.c(TAG, "getNetworkType Exception:", localException);
    }
    return 0;
  }
  
  public String getPhoneGuid()
  {
    if (this.mContext == null) {
      return "";
    }
    SharedPreferences localSharedPreferences = this.mContext.getSharedPreferences("TMAssistantSDKSharedPreference", 0);
    if (localSharedPreferences != null) {
      return localSharedPreferences.getString("TMAssistantSDKPhoneGUID", "");
    }
    return "";
  }
  
  public String getProduct()
  {
    return filter(Build.PRODUCT);
  }
  
  public int getQQDownloaderAPILevel()
  {
    if (this.mContext == null) {
      r.c("SelfUpdateSDK", "context == null");
    }
    for (;;)
    {
      return 0;
      r.c("SelfUpdateSDK", "getQQDownloaderAPILevel");
      try
      {
        ApplicationInfo localApplicationInfo = this.mContext.getPackageManager().getApplicationInfo("com.tencent.android.qqdownloader", 128);
        r.c("SelfUpdateSDK", "appInfo:" + localApplicationInfo);
        if ((localApplicationInfo != null) && (localApplicationInfo.metaData != null))
        {
          int i = localApplicationInfo.metaData.getInt("com.tencent.android.qqdownloader.sdk.apilevel");
          r.c("SelfUpdateSDK", "apiLevel:" + i);
          return i;
        }
      }
      catch (Exception localException) {}
    }
    return 0;
  }
  
  public int getQQDownloaderConnectLevel()
  {
    if (this.mContext == null) {
      r.c("SelfUpdateSDK", "context == null");
    }
    for (;;)
    {
      return 0;
      r.c("SelfUpdateSDK", "getQQDownloaderConnectLevel");
      try
      {
        ApplicationInfo localApplicationInfo = this.mContext.getPackageManager().getApplicationInfo("com.tencent.android.qqdownloader", 128);
        r.c("SelfUpdateSDK", "appInfo:" + localApplicationInfo);
        if ((localApplicationInfo != null) && (localApplicationInfo.metaData != null))
        {
          int i = localApplicationInfo.metaData.getInt("com.tencent.android.qqdownloader.sdk.connectlevel");
          r.c("SelfUpdateSDK", "apiLevel:" + i);
          return i;
        }
      }
      catch (Exception localException) {}
    }
    return 0;
  }
  
  public int getQQDownloaderVersionCode()
  {
    int j = 0;
    for (;;)
    {
      try
      {
        localObject1 = this.mContext;
        if (localObject1 != null) {
          continue;
        }
        i = j;
      }
      finally
      {
        try
        {
          Object localObject1 = this.mContext.getPackageManager();
          i = j;
          if (localObject1 == null) {
            continue;
          }
          localObject1 = ((PackageManager)localObject1).getPackageInfo("com.tencent.android.qqdownloader", 0);
          i = j;
          if (localObject1 == null) {
            continue;
          }
          i = ((PackageInfo)localObject1).versionCode;
        }
        catch (Exception localException)
        {
          int i = j;
        }
        localObject2 = finally;
      }
      return i;
    }
  }
  
  public int getScreenHeight()
  {
    if (this.mContext != null) {
      return this.mContext.getResources().getDisplayMetrics().heightPixels;
    }
    return 0;
  }
  
  public int getScreenWidth()
  {
    if (this.mContext != null) {
      return this.mContext.getResources().getDisplayMetrics().widthPixels;
    }
    return 0;
  }
  
  public SharedPreferences getSharedPreferences()
  {
    if (getInstance().getContext() == null)
    {
      r.d(TAG, "GlobalUtil.getInstance().getContext() == null.");
      return null;
    }
    return getInstance().getContext().getSharedPreferences("TMAssistantSDKSharedPreference", 0);
  }
  
  public void setContext(Context paramContext)
  {
    Context localContext = paramContext;
    if (paramContext != null) {
      localContext = paramContext.getApplicationContext();
    }
    this.mContext = localContext;
    this.mQUA = new o(localContext).a();
    r.a(localContext);
  }
  
  public void setNetTypeValue(byte paramByte) {}
  
  public void setPhoneGuid(String paramString)
  {
    if (this.mContext == null) {}
    SharedPreferences localSharedPreferences;
    do
    {
      do
      {
        return;
      } while (TextUtils.isEmpty(paramString));
      localSharedPreferences = this.mContext.getSharedPreferences("TMAssistantSDKSharedPreference", 0);
    } while (localSharedPreferences == null);
    localSharedPreferences.edit().putString("TMAssistantSDKPhoneGUID", paramString).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tmassistantbase.util.GlobalUtil
 * JD-Core Version:    0.7.0.1
 */