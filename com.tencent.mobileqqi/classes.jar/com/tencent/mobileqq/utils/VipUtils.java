package com.tencent.mobileqq.utils;

import QQService.EVIPSPEC;
import android.app.Activity;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.qphone.base.util.QLog;
import hio;

public class VipUtils
{
  public static final int a = 1;
  public static final String a = "vip";
  public static final int b = 2;
  public static final String b = "svip";
  public static final int c = 4;
  private static final String c = "VipUtils";
  
  public static int a(QQAppInterface paramQQAppInterface, String paramString)
  {
    int j = 0;
    int k = 0;
    int i = j;
    if (paramQQAppInterface != null)
    {
      String str = paramString;
      if (TextUtils.isEmpty(paramString)) {
        str = paramQQAppInterface.a();
      }
      paramQQAppInterface = (FriendsManagerImp)paramQQAppInterface.getManager(8);
      if (paramQQAppInterface == null) {
        break label128;
      }
      paramQQAppInterface = paramQQAppInterface.c(str);
      if (paramQQAppInterface == null) {
        break label110;
      }
      if (!paramQQAppInterface.isServiceEnabled(EVIPSPEC.E_SP_SUPERQQ)) {
        break label100;
      }
      i = 1;
      if (!paramQQAppInterface.isServiceEnabled(EVIPSPEC.E_SP_QQVIP)) {
        break label105;
      }
      j = 2;
      label76:
      if (paramQQAppInterface.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)) {
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
  
  public static void a(Activity paramActivity, hio paramhio)
  {
    if ((paramhio != null) && (paramActivity != null) && (!TextUtils.isEmpty(paramhio.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramhio.d)) && (!TextUtils.isEmpty(paramhio.e)) && (!TextUtils.isEmpty(paramhio.b)) && (!TextUtils.isEmpty(paramhio.c)) && (paramhio.jdField_a_of_type_Int < 1)) {}
  }
  
  public static void a(BaseActivity paramBaseActivity, int paramInt, String paramString)
  {
    if ((paramBaseActivity != null) && (!TextUtils.isEmpty(paramString)) && (paramInt > 0))
    {
      hio localhio = new hio();
      localhio.jdField_a_of_type_JavaLangString = paramBaseActivity.b.a();
      localhio.d = paramString;
      localhio.e = "1450000515";
      localhio.b = "LTMCLUB";
      localhio.c = paramBaseActivity.getString(2131562684);
      localhio.jdField_a_of_type_Int = paramInt;
      localhio.f = "vip";
      a(paramBaseActivity, localhio);
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
      hio localhio = new hio();
      localhio.jdField_a_of_type_JavaLangString = paramBaseActivity.b.a();
      localhio.d = paramString;
      localhio.e = "1450000516";
      localhio.b = "CJCLUBT";
      localhio.c = paramBaseActivity.getString(2131562993);
      localhio.jdField_a_of_type_Int = paramInt;
      localhio.f = "svip";
      a(paramBaseActivity, localhio);
    }
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface)
  {
    return (a(paramQQAppInterface, null) & 0x2) != 0;
  }
  
  public static boolean c(QQAppInterface paramQQAppInterface)
  {
    return (a(paramQQAppInterface, null) & 0x1) != 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.VipUtils
 * JD-Core Version:    0.7.0.1
 */