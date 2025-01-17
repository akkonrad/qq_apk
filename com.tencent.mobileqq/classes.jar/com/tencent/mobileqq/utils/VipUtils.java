package com.tencent.mobileqq.utils;

import QQService.EVIPSPEC;
import akgt;
import android.app.Activity;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class VipUtils
{
  public static int a(QQAppInterface paramQQAppInterface, String paramString)
  {
    int j = -1;
    int i = j;
    boolean bool;
    if (paramQQAppInterface != null)
    {
      String str = paramString;
      if (TextUtils.isEmpty(paramString)) {
        str = paramQQAppInterface.getCurrentAccountUin();
      }
      paramQQAppInterface = (FriendsManager)paramQQAppInterface.getManager(50);
      if (paramQQAppInterface == null) {
        break label106;
      }
      paramQQAppInterface = paramQQAppInterface.c(str);
      if (paramQQAppInterface == null) {
        break label87;
      }
      bool = paramQQAppInterface.isServiceEnabled(EVIPSPEC.E_SP_QQVIP);
      if (!paramQQAppInterface.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)) {
        break label72;
      }
      i = 3;
    }
    label72:
    label87:
    label106:
    do
    {
      for (;;)
      {
        return i;
        if (bool)
        {
          i = 2;
        }
        else
        {
          i = 1;
          continue;
          if (QLog.isColorLevel()) {
            QLog.e("VipUtils", 2, "getUserStatus Friends is null");
          }
          i = -1;
        }
      }
      i = j;
    } while (!QLog.isColorLevel());
    QLog.e("VipUtils", 2, "getUserStatus FriendsManagerImp is null");
    return -1;
  }
  
  public static int a(AppRuntime paramAppRuntime, String paramString)
  {
    int j = 0;
    int k = 0;
    int i = j;
    if (paramAppRuntime != null)
    {
      String str = paramString;
      if (TextUtils.isEmpty(paramString)) {
        str = paramAppRuntime.getAccount();
      }
      paramAppRuntime = (FriendsManager)paramAppRuntime.getManager(50);
      if (paramAppRuntime == null) {
        break label128;
      }
      paramAppRuntime = paramAppRuntime.c(str);
      if (paramAppRuntime == null) {
        break label110;
      }
      if (!paramAppRuntime.isServiceEnabled(EVIPSPEC.E_SP_SUPERQQ)) {
        break label100;
      }
      i = 1;
      if (!paramAppRuntime.isServiceEnabled(EVIPSPEC.E_SP_QQVIP)) {
        break label105;
      }
      j = 2;
      label76:
      if (paramAppRuntime.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)) {
        k = 4;
      }
      i = k | j | 0x0 | i;
    }
    label100:
    label105:
    label110:
    do
    {
      do
      {
        return i;
        i = 0;
        break;
        j = 0;
        break label76;
        i = j;
      } while (!QLog.isColorLevel());
      QLog.e("VipUtils", 2, "getPrivilegeFlags Friends is null");
      return 0;
      i = j;
    } while (!QLog.isColorLevel());
    label128:
    QLog.e("VipUtils", 2, "getPrivilegeFlags FriendsManagerImp is null");
    return 0;
  }
  
  public static String a(AppInterface paramAppInterface, String paramString)
  {
    int i = a(paramAppInterface, paramString);
    if ((i & 0x4) != 0) {
      return "2";
    }
    if ((i & 0x2) != 0) {
      return "1";
    }
    return "0";
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      paramString = "";
    }
    String str;
    do
    {
      return paramString;
      str = paramString.replace("-", "_");
      paramString = str;
    } while (str.contains("_"));
    return "jhan_" + str;
  }
  
  public static short a(AppRuntime paramAppRuntime, String paramString)
  {
    if (paramAppRuntime != null)
    {
      String str = paramString;
      if (TextUtils.isEmpty(paramString)) {
        str = paramAppRuntime.getAccount();
      }
      paramAppRuntime = (FriendsManager)paramAppRuntime.getManager(50);
      if (paramAppRuntime != null)
      {
        paramAppRuntime = paramAppRuntime.c(str);
        if (paramAppRuntime != null)
        {
          if (paramAppRuntime.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)) {
            return (short)(paramAppRuntime.getServiceType(EVIPSPEC.E_SP_SUPERVIP) | 0x200);
          }
          if (paramAppRuntime.isServiceEnabled(EVIPSPEC.E_SP_QQVIP)) {
            return (short)(paramAppRuntime.getServiceType(EVIPSPEC.E_SP_QQVIP) | 0x100);
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.e("VipUtils", 2, "getPrivilegeFlags Friends is null");
        }
      }
      for (;;)
      {
        return 0;
        if (QLog.isColorLevel()) {
          QLog.e("VipUtils", 2, "getPrivilegeFlags FriendsManagerImp is null");
        }
      }
    }
    return 0;
  }
  
  public static void a(Activity paramActivity, akgt paramakgt)
  {
    if ((paramakgt == null) || (paramActivity == null) || (TextUtils.isEmpty(paramakgt.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(paramakgt.d)) || (TextUtils.isEmpty(paramakgt.e)) || (TextUtils.isEmpty(paramakgt.b)) || (TextUtils.isEmpty(paramakgt.c)) || (paramakgt.jdField_a_of_type_Int < 1)) {
      return;
    }
    Object localObject = new JSONObject();
    for (;;)
    {
      try
      {
        ((JSONObject)localObject).put("serviceCode", paramakgt.b);
        ((JSONObject)localObject).put("aid", paramakgt.d);
        ((JSONObject)localObject).put("openMonth", String.valueOf(paramakgt.jdField_a_of_type_Int));
        ((JSONObject)localObject).put("offerId", paramakgt.e);
        ((JSONObject)localObject).put("serviceName", paramakgt.c);
        ((JSONObject)localObject).put("userId", paramakgt.jdField_a_of_type_JavaLangString);
        if (!paramakgt.jdField_a_of_type_Boolean) {
          ((JSONObject)localObject).put("isCanChange", false);
        }
        localObject = ((JSONObject)localObject).toString();
        if (paramakgt.f == null) {
          break label225;
        }
        paramakgt = paramakgt.f;
        PayBridgeActivity.tenpay(paramActivity, (String)localObject, 4, paramakgt);
        return;
      }
      catch (Exception paramActivity)
      {
        paramActivity.printStackTrace();
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("VipUtils", 2, "openRechargeDialog exception : " + paramActivity.getMessage());
      return;
      label225:
      paramakgt = "";
    }
  }
  
  public static void a(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String... paramVarArgs)
  {
    String[] arrayOfString = new String[4];
    arrayOfString[0] = "";
    arrayOfString[1] = "";
    arrayOfString[2] = "";
    arrayOfString[3] = "";
    if (paramVarArgs != null)
    {
      int j = paramVarArgs.length;
      int k = arrayOfString.length;
      int i = 0;
      while ((i < j) && (i < k))
      {
        if (!TextUtils.isEmpty(paramVarArgs[i])) {
          arrayOfString[i] = paramVarArgs[i];
        }
        i += 1;
      }
    }
    if ((paramAppInterface instanceof QQAppInterface))
    {
      paramVarArgs = (QQAppInterface)paramAppInterface;
      if (TextUtils.isEmpty(paramString1)) {}
      for (paramAppInterface = "UNKNOWN";; paramAppInterface = paramString1)
      {
        ReportController.b(paramVarArgs, "P_CliOper", paramAppInterface, "", paramString2, paramString3, paramInt1, paramInt2, arrayOfString[0], arrayOfString[1], arrayOfString[2], arrayOfString[3]);
        return;
      }
    }
    if (paramAppInterface != null)
    {
      if (TextUtils.isEmpty(paramString1)) {
        paramString1 = "UNKNOWN";
      }
      for (;;)
      {
        paramAppInterface.reportClickEvent("P_CliOper", paramString1, "", paramString2, paramString3, paramInt1, paramInt2, arrayOfString[0], arrayOfString[1], arrayOfString[2], arrayOfString[3]);
        return;
      }
    }
    if (TextUtils.isEmpty(paramString1)) {}
    for (paramAppInterface = "UNKNOWN";; paramAppInterface = paramString1)
    {
      ReportController.b(null, "P_CliOper", paramAppInterface, "", paramString2, paramString3, paramInt1, paramInt2, arrayOfString[0], arrayOfString[1], arrayOfString[2], arrayOfString[3]);
      return;
    }
  }
  
  public static void a(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, String... paramVarArgs)
  {
    String[] arrayOfString = new String[4];
    arrayOfString[0] = "";
    arrayOfString[1] = "";
    arrayOfString[2] = "";
    arrayOfString[3] = "";
    if (paramVarArgs != null)
    {
      int j = paramVarArgs.length;
      int k = arrayOfString.length;
      int i = 0;
      while ((i < j) && (i < k))
      {
        if (!TextUtils.isEmpty(paramVarArgs[i])) {
          arrayOfString[i] = paramVarArgs[i];
        }
        i += 1;
      }
    }
    if (paramString4 == null) {
      paramString4 = "";
    }
    for (;;)
    {
      if ((paramAppInterface instanceof QQAppInterface))
      {
        paramVarArgs = (QQAppInterface)paramAppInterface;
        if (TextUtils.isEmpty(paramString1)) {}
        for (paramAppInterface = "UNKNOWN";; paramAppInterface = paramString1)
        {
          ReportController.b(paramVarArgs, "P_CliOper", paramAppInterface, paramString4, paramString2, paramString3, paramInt1, paramInt2, arrayOfString[0], arrayOfString[1], arrayOfString[2], arrayOfString[3]);
          return;
        }
      }
      if (paramAppInterface != null)
      {
        if (TextUtils.isEmpty(paramString1)) {
          paramString1 = "UNKNOWN";
        }
        for (;;)
        {
          paramAppInterface.reportClickEvent("P_CliOper", paramString1, paramString4, paramString2, paramString3, paramInt1, paramInt2, arrayOfString[0], arrayOfString[1], arrayOfString[2], arrayOfString[3]);
          return;
        }
      }
      if (TextUtils.isEmpty(paramString1)) {}
      for (paramAppInterface = "UNKNOWN";; paramAppInterface = paramString1)
      {
        ReportController.b(null, "P_CliOper", paramAppInterface, paramString4, paramString2, paramString3, paramInt1, paramInt2, arrayOfString[0], arrayOfString[1], arrayOfString[2], arrayOfString[3]);
        return;
      }
    }
  }
  
  public static void a(BaseActivity paramBaseActivity, int paramInt, String paramString)
  {
    if ((paramBaseActivity != null) && (!TextUtils.isEmpty(paramString)) && (paramInt > 0))
    {
      akgt localakgt = new akgt();
      localakgt.jdField_a_of_type_JavaLangString = paramBaseActivity.app.getCurrentAccountUin();
      localakgt.d = paramString;
      localakgt.e = "1450000515";
      localakgt.b = "LTMCLUB";
      localakgt.c = paramBaseActivity.getString(2131436740);
      localakgt.jdField_a_of_type_Int = paramInt;
      localakgt.f = "vip";
      a(paramBaseActivity, localakgt);
    }
  }
  
  public static void a(BaseActivity paramBaseActivity, boolean paramBoolean1, int paramInt, boolean paramBoolean2, String paramString)
  {
    akgt localakgt;
    if ((paramBaseActivity != null) && (!TextUtils.isEmpty(paramString)) && (paramInt > 0))
    {
      localakgt = new akgt();
      localakgt.jdField_a_of_type_JavaLangString = paramBaseActivity.app.getCurrentAccountUin();
      localakgt.d = paramString;
      localakgt.jdField_a_of_type_Int = paramInt;
      localakgt.jdField_a_of_type_Boolean = paramBoolean2;
      if (!paramBoolean1) {
        break label99;
      }
      localakgt.e = "1450000516";
      localakgt.b = "CJCLUBT";
      localakgt.c = paramBaseActivity.getString(2131436943);
    }
    for (localakgt.f = "svip";; localakgt.f = "vip")
    {
      a(paramBaseActivity, localakgt);
      return;
      label99:
      localakgt.e = "1450000515";
      localakgt.b = "LTMCLUB";
      localakgt.c = paramBaseActivity.getString(2131436740);
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    return (a(paramQQAppInterface, null) & 0x4) != 0;
  }
  
  public static void b(BaseActivity paramBaseActivity, int paramInt, String paramString)
  {
    if ((paramBaseActivity != null) && (!TextUtils.isEmpty(paramString)) && (paramInt > 0))
    {
      akgt localakgt = new akgt();
      localakgt.jdField_a_of_type_JavaLangString = paramBaseActivity.app.getCurrentAccountUin();
      localakgt.d = paramString;
      localakgt.e = "1450000516";
      localakgt.b = "CJCLUBT";
      localakgt.c = paramBaseActivity.getString(2131436943);
      localakgt.jdField_a_of_type_Int = paramInt;
      localakgt.f = "svip";
      a(paramBaseActivity, localakgt);
    }
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface)
  {
    return (a(paramQQAppInterface, null) & 0x2) != 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.utils.VipUtils
 * JD-Core Version:    0.7.0.1
 */