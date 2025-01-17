package com.tencent.mobileqq.vip;

import MQQ.PopupImgInfo;
import MQQ.ToastImgInfo;
import MQQ.TrafficResultInfo;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.VipInfoHandler;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;

public class CUKingCardHelper
{
  private static final ConcurrentHashMap a = new ConcurrentHashMap();
  
  public static int a()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    localObject = BaseApplicationImpl.getApplication().getSharedPreferences("CUKingCardFile_" + (String)localObject, 4);
    int i = ((SharedPreferences)localObject).getInt("kingCard", -1);
    int j = ((SharedPreferences)localObject).getInt("kingCard2", -1);
    if (QLog.isColorLevel()) {
      QLog.i("CUKingCardHelper", 2, "getCUKingStatus: status1=" + i + " status2=" + j);
    }
    if ((i < 0) && (j < 0)) {
      return -1;
    }
    if ((i <= 0) && (j <= 0)) {
      return 0;
    }
    return 1;
  }
  
  /* Error */
  public static int a(int paramInt, Context paramContext)
  {
    // Byte code:
    //   0: ldc 84
    //   2: invokestatic 90	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   5: astore_2
    //   6: aload_1
    //   7: invokevirtual 96	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   10: astore_1
    //   11: aload_1
    //   12: aload_2
    //   13: iconst_2
    //   14: anewarray 98	java/lang/String
    //   17: dup
    //   18: iconst_0
    //   19: ldc 100
    //   21: aastore
    //   22: dup
    //   23: iconst_1
    //   24: ldc 102
    //   26: aastore
    //   27: ldc 104
    //   29: iconst_1
    //   30: anewarray 98	java/lang/String
    //   33: dup
    //   34: iconst_0
    //   35: iload_0
    //   36: invokestatic 108	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   39: aastore
    //   40: aconst_null
    //   41: invokevirtual 114	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   44: astore_2
    //   45: aload_2
    //   46: ifnull +43 -> 89
    //   49: aload_2
    //   50: astore_1
    //   51: aload_2
    //   52: invokeinterface 119 1 0
    //   57: ifeq +32 -> 89
    //   60: aload_2
    //   61: astore_1
    //   62: aload_2
    //   63: aload_2
    //   64: ldc 100
    //   66: invokeinterface 123 2 0
    //   71: invokeinterface 126 2 0
    //   76: istore_0
    //   77: aload_2
    //   78: ifnull +9 -> 87
    //   81: aload_2
    //   82: invokeinterface 129 1 0
    //   87: iload_0
    //   88: ireturn
    //   89: aload_2
    //   90: ifnull +9 -> 99
    //   93: aload_2
    //   94: invokeinterface 129 1 0
    //   99: iconst_m1
    //   100: ireturn
    //   101: astore_3
    //   102: aconst_null
    //   103: astore_2
    //   104: aload_2
    //   105: astore_1
    //   106: ldc 68
    //   108: iconst_1
    //   109: new 36	java/lang/StringBuilder
    //   112: dup
    //   113: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   116: ldc 131
    //   118: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: aload_3
    //   122: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   125: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: invokestatic 137	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   131: aload_2
    //   132: ifnull -33 -> 99
    //   135: aload_2
    //   136: invokeinterface 129 1 0
    //   141: goto -42 -> 99
    //   144: astore_2
    //   145: aconst_null
    //   146: astore_1
    //   147: aload_1
    //   148: ifnull +9 -> 157
    //   151: aload_1
    //   152: invokeinterface 129 1 0
    //   157: aload_2
    //   158: athrow
    //   159: astore_2
    //   160: goto -13 -> 147
    //   163: astore_3
    //   164: goto -60 -> 104
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	167	0	paramInt	int
    //   0	167	1	paramContext	Context
    //   5	131	2	localObject1	Object
    //   144	14	2	localObject2	Object
    //   159	1	2	localObject3	Object
    //   101	21	3	localException1	Exception
    //   163	1	3	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   11	45	101	java/lang/Exception
    //   11	45	144	finally
    //   51	60	159	finally
    //   62	77	159	finally
    //   106	131	159	finally
    //   51	60	163	java/lang/Exception
    //   62	77	163	java/lang/Exception
  }
  
  public static CUKingCardHelper.CUKingCustomDialogInfo a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    VasWebviewUtil.reportCommercialDrainage("", "wkclub", "P1", paramString, 1, 0, 0, "", "", "");
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("CUKingCardFile_" + BaseApplicationImpl.getApplication().getRuntime().getAccount(), 4);
    CUKingCardHelper.CUKingCustomDialogInfo localCUKingCustomDialogInfo = new CUKingCardHelper.CUKingCustomDialogInfo();
    localCUKingCustomDialogInfo.jdField_a_of_type_JavaLangString = a(paramString);
    String str;
    if (!localSharedPreferences.getBoolean("guideEnable", false))
    {
      if (QLog.isColorLevel()) {
        QLog.i("CUKingCardHelper", 2, "not in CUKing Card gray uin!");
      }
      localCUKingCustomDialogInfo.jdField_a_of_type_Int = 4;
      switch (localCUKingCustomDialogInfo.jdField_a_of_type_Int)
      {
      case 3: 
      default: 
        str = "P3";
      }
    }
    for (;;)
    {
      VasWebviewUtil.reportCommercialDrainage("", "wkclub", str, paramString, 1, 0, 0, "", "", "");
      return localCUKingCustomDialogInfo;
      int i;
      if (localSharedPreferences.getInt("guideToastOpen", 0) == 1)
      {
        if (paramBoolean2)
        {
          str = localSharedPreferences.getString("toastText", "");
          if (!a.containsKey(paramString)) {
            break label258;
          }
          str = localSharedPreferences.getString("shortToastText", "");
        }
        for (;;)
        {
          i = localSharedPreferences.getInt("toastShowTime", 2);
          QQToast.a(BaseApplicationImpl.getContext(), 2, str, i * 1000).a();
          localCUKingCustomDialogInfo.jdField_a_of_type_Int = 1;
          break;
          label258:
          a.put(paramString, Boolean.TRUE);
        }
      }
      if (localSharedPreferences.getInt("guidePopupOpen", 0) == 1)
      {
        i = localSharedPreferences.getInt("popupRateType", 0);
        if ((i == 0) || (i == 1))
        {
          i = localSharedPreferences.getInt("popupRate", 0);
          label351:
          long l;
          StringBuilder localStringBuilder;
          if ((localSharedPreferences.getInt("kingCard", 0) == 1) || (localSharedPreferences.getInt("kingCard2", 0) == 1))
          {
            localCUKingCustomDialogInfo.jdField_a_of_type_Int = 3;
            l = System.currentTimeMillis();
            localStringBuilder = new StringBuilder();
            if (!paramBoolean1) {
              break label461;
            }
          }
          label461:
          for (str = "lastTipTime_";; str = "lastDialogTime_")
          {
            str = str + paramString;
            if (l - localSharedPreferences.getLong(str, 0L) < i * 1000) {
              localCUKingCustomDialogInfo.jdField_a_of_type_Int = 4;
            }
            if (localCUKingCustomDialogInfo.jdField_a_of_type_Int == 4) {
              break;
            }
            localSharedPreferences.edit().putLong(str, l).commit();
            break;
            localCUKingCustomDialogInfo.jdField_a_of_type_Int = 2;
            break label351;
          }
        }
        localCUKingCustomDialogInfo.jdField_a_of_type_Int = 4;
        break;
      }
      localCUKingCustomDialogInfo.jdField_a_of_type_Int = 4;
      break;
      str = "P5";
      continue;
      str = "P4";
      continue;
      str = "P2";
    }
  }
  
  private static Object a(int paramInt, String paramString, Context paramContext)
  {
    try
    {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      if (Build.VERSION.SDK_INT >= 21)
      {
        paramString = paramContext.getClass().getMethod(paramString, a(paramString));
        if (paramInt >= 0)
        {
          paramString = paramString.invoke(paramContext, new Object[] { Integer.valueOf(paramInt) });
          return paramString;
        }
      }
    }
    catch (Exception paramString)
    {
      QLog.e("CUKingCardHelper", 1, "getPhoneInfo e = " + paramString);
    }
    return null;
  }
  
  public static String a(int paramInt, Context paramContext)
  {
    paramContext = (String)a(a(paramInt, paramContext), "getSubscriberId", paramContext);
    if (QLog.isColorLevel()) {
      QLog.d("CUKingCardHelper", 2, "getSubscriberId, imsi = " + paramContext);
    }
    return paramContext;
  }
  
  public static String a(String paramString)
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("CUKingCardFile_" + BaseApplicationImpl.getApplication().getRuntime().getAccount(), 4);
    String str2 = localSharedPreferences.getString("guideUrl", "");
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "https://mc.vip.qq.com/wkcenter/index?_wv=3&_nav_alpha=0&_wvx=3";
    }
    str2 = "open";
    if ((localSharedPreferences.getInt("kingCard", 0) == 1) || (localSharedPreferences.getInt("kingCard2", 0) == 1)) {
      str2 = "update";
    }
    if (!str1.contains("?")) {
      str1 = str1 + "?";
    }
    for (paramString = str1 + "source=" + paramString + "&type=" + str2;; paramString = str1 + "&source=" + paramString + "&type=" + str2)
    {
      if (QLog.isColorLevel()) {
        QLog.i("CUKingCardHelper", 2, "open guide url: " + paramString);
      }
      return paramString;
    }
  }
  
  public static void a(TrafficResultInfo paramTrafficResultInfo, Bundle paramBundle)
  {
    boolean bool2 = true;
    if (paramTrafficResultInfo == null)
    {
      QLog.e("CUKingCardHelper", 1, "saveCUKingInfo error : trafficInfo = null");
      return;
    }
    boolean bool1 = paramBundle.getBoolean(VipInfoHandler.d);
    boolean bool3 = paramBundle.getBoolean(VipInfoHandler.e);
    String str2 = paramBundle.getString(VipInfoHandler.f);
    String str1 = paramBundle.getString(VipInfoHandler.g);
    paramBundle = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("CUKingCardFile_" + paramBundle, 4);
    SharedPreferences.Editor localEditor = localSharedPreferences.edit();
    if (bool1)
    {
      if (QLog.isColorLevel()) {
        QLog.i("CUKingCardHelper", 2, String.format("Save CUKing Card Order State, State1: %d", new Object[] { Integer.valueOf(paramTrafficResultInfo.iWkOrderState1) }));
      }
      localEditor.putInt("kingCard", paramTrafficResultInfo.iWkOrderState1);
      if (!TextUtils.isEmpty(str2))
      {
        paramBundle = str2;
        localEditor.putString("imsiOne", paramBundle);
        localEditor.putLong("kingCardLastRequest", System.currentTimeMillis() / 1000L);
      }
    }
    else
    {
      if (bool3)
      {
        if (QLog.isColorLevel()) {
          QLog.i("CUKingCardHelper", 2, String.format("Save CUKing Card Order State, State2: %d", new Object[] { Integer.valueOf(paramTrafficResultInfo.iWkOrderState2) }));
        }
        localEditor.putInt("kingCard2", paramTrafficResultInfo.iWkOrderState2);
        if (TextUtils.isEmpty(str1)) {
          break label767;
        }
        paramBundle = str1;
        label252:
        localEditor.putString("imsiTwo", paramBundle);
        localEditor.putLong("kingCardLastRequest", System.currentTimeMillis() / 1000L);
      }
      if (paramTrafficResultInfo.iDrawerEnable != 1) {
        break label773;
      }
      bool1 = true;
      label292:
      localEditor.putBoolean("drawerEnable", bool1);
      if (paramTrafficResultInfo.iGuideEnable != 1) {
        break label778;
      }
      bool1 = true;
      label314:
      localEditor.putBoolean("guideEnable", bool1);
      if (QLog.isColorLevel())
      {
        paramBundle = new StringBuilder().append("saveCUKingInfo, is in gray : ");
        if (paramTrafficResultInfo.iGuideEnable != 1) {
          break label783;
        }
      }
    }
    label773:
    label778:
    label783:
    for (bool1 = bool2;; bool1 = false)
    {
      QLog.i("CUKingCardHelper", 2, bool1);
      localEditor.putString("drawerText", paramTrafficResultInfo.sDrawerText);
      localEditor.putString("drawerUrl", paramTrafficResultInfo.sDrawerUrl);
      localEditor.putString("guideUrl", paramTrafficResultInfo.sGuideUrl);
      localEditor.putInt("kingCardRequestInterval", paramTrafficResultInfo.iImsiInterval);
      int i;
      if (paramTrafficResultInfo.popInfo != null)
      {
        i = localSharedPreferences.getInt("popup_version_v2", 0);
        paramBundle = paramTrafficResultInfo.popInfo;
        localEditor.putInt("guidePopupOpen", paramBundle.iOpen);
        localEditor.putInt("popupRate", paramBundle.iRate);
        localEditor.putInt("popupRateType", paramBundle.iRateType);
        if (i != paramBundle.iPopupVer)
        {
          localEditor.putString("guidePopupText_v2", paramBundle.sPopupText);
          localEditor.putString("guideJumpText_v2", paramBundle.sRedirectText);
          localEditor.putString("guideContinueText_v2", paramBundle.sContinueText);
          localEditor.putString("guidePopupImgUrl_v2", paramBundle.sPopupImgUrl);
          localEditor.putInt("popup_version_v2", paramBundle.iPopupVer);
        }
        if (QLog.isColorLevel()) {
          QLog.i("CUKingCardHelper", 2, "saveCUKingInfo, popup open : " + paramBundle.iOpen);
        }
      }
      if (paramTrafficResultInfo.toasInfo != null)
      {
        i = localSharedPreferences.getInt("toast_version", 0);
        paramTrafficResultInfo = paramTrafficResultInfo.toasInfo;
        localEditor.putInt("guideToastOpen", paramTrafficResultInfo.iOpen);
        localEditor.putInt("toastShowTime", paramTrafficResultInfo.iShowTime);
        if (i != paramTrafficResultInfo.iToastVer)
        {
          localEditor.putString("toastText", paramTrafficResultInfo.sText);
          localEditor.putString("shortToastText", paramTrafficResultInfo.sShortText);
          localEditor.putInt("toast_version", paramTrafficResultInfo.iToastVer);
        }
        if (QLog.isColorLevel()) {
          QLog.i("CUKingCardHelper", 2, "saveCUKingInfo, toast open : " + paramTrafficResultInfo.iOpen);
        }
      }
      localEditor.commit();
      return;
      paramBundle = "";
      break;
      label767:
      paramBundle = "";
      break label252;
      bool1 = false;
      break label292;
      bool1 = false;
      break label314;
    }
  }
  
  public static boolean a(Activity paramActivity, int paramInt, CUKingCardHelper.CUKingDialogListener paramCUKingDialogListener, String paramString)
  {
    boolean bool = true;
    if ((paramActivity == null) || (paramActivity.isFinishing())) {
      bool = false;
    }
    CUKingCardHelper.CUKingCustomDialogInfo localCUKingCustomDialogInfo;
    do
    {
      return bool;
      localCUKingCustomDialogInfo = a(paramString, false, true);
      if (QLog.isColorLevel()) {
        QLog.i("CUKingCardHelper", 2, "shouldOverrideDialog, popUpType: " + localCUKingCustomDialogInfo.jdField_a_of_type_Int);
      }
    } while (localCUKingCustomDialogInfo.jdField_a_of_type_Int == 4);
    if (localCUKingCustomDialogInfo.jdField_a_of_type_Int == 1)
    {
      if (paramCUKingDialogListener != null) {
        paramCUKingDialogListener.callback(2);
      }
      return false;
    }
    new CUKingCardDialog(paramActivity, paramCUKingDialogListener, paramInt, paramString, localCUKingCustomDialogInfo.jdField_a_of_type_Int).show();
    return false;
  }
  
  private static Class[] a(String paramString)
  {
    try
    {
      arrayOfMethod = TelephonyManager.class.getDeclaredMethods();
      localObject1 = null;
      i = 0;
    }
    catch (Exception paramString)
    {
      try
      {
        Method[] arrayOfMethod;
        int i;
        Object localObject3;
        if (i < arrayOfMethod.length)
        {
          localObject3 = localObject1;
          localObject2 = localObject1;
          if (paramString.equals(arrayOfMethod[i].getName()))
          {
            localObject2 = localObject1;
            localObject1 = arrayOfMethod[i].getParameterTypes();
            localObject3 = localObject1;
            localObject2 = localObject1;
            if (localObject1.length >= 1)
            {
              localObject2 = localObject1;
              Log.d("length:", "" + localObject1.length);
              localObject3 = localObject1;
            }
          }
        }
        else
        {
          return localObject3;
        }
        i += 1;
        Object localObject1 = localObject3;
      }
      catch (Exception paramString)
      {
        Object localObject2;
        break label112;
      }
      paramString = paramString;
      localObject2 = null;
    }
    localObject3 = localObject1;
    localObject2 = localObject1;
    label112:
    QLog.e("CUKingCardHelper", 1, "getMethodParamTypes e = " + paramString);
    return localObject2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.vip.CUKingCardHelper
 * JD-Core Version:    0.7.0.1
 */