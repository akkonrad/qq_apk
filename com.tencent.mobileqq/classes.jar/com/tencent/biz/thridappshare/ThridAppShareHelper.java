package com.tencent.biz.thridappshare;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.forward.ForwardAbility.ForwardAbilityType;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.forward.ForwardOptionBuilder;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ThridAppShareHelper
{
  protected static ThridAppShareHelper a;
  protected SessionInfo a;
  protected HashMap a;
  
  public ThridAppShareHelper()
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public static ThridAppShareHelper a()
  {
    if (jdField_a_of_type_ComTencentBizThridappshareThridAppShareHelper == null) {
      jdField_a_of_type_ComTencentBizThridappshareThridAppShareHelper = new ThridAppShareHelper();
    }
    return jdField_a_of_type_ComTencentBizThridappshareThridAppShareHelper;
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    ReportController.a(null, "P_CliOper", "Pb_account_lifeservice", "", "aio_app", paramString2, 0, 0, paramString1, paramString3, paramString4, paramString5);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = null;
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, SessionInfo paramSessionInfo)
  {
    ThridAppShareHelper.ThirdAppInfo localThirdAppInfo = (ThridAppShareHelper.ThirdAppInfo)this.jdField_a_of_type_JavaUtilHashMap.get(paramString1);
    if (localThirdAppInfo == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    if (!DataProviderApi.b(paramContext, localThirdAppInfo.b, paramString1, "android.intent.action.VIEW", "com.tencent.mobileqq", "com.tencent.mobileqq.activity.JumpActivity"))
    {
      if (!DataProviderApi.b(paramContext, localThirdAppInfo.c, paramString1, "android.intent.action.VIEW", "com.tencent.mobileqq", "com.tencent.mobileqq.activity.JumpActivity"))
      {
        paramSessionInfo = new Intent(paramContext, QQBrowserActivity.class);
        if ((localThirdAppInfo != null) && (!TextUtils.isEmpty(localThirdAppInfo.jdField_a_of_type_JavaLangString))) {
          paramSessionInfo.putExtra("url", localThirdAppInfo.jdField_a_of_type_JavaLangString);
        }
        for (;;)
        {
          paramContext.startActivity(paramSessionInfo);
          a(paramString1, "app_click_ver", "2", "", "");
          return;
          paramSessionInfo.putExtra("url", paramString2);
        }
      }
      a(paramString1, "app_click_ver", "0", "", "");
      return;
    }
    a(paramString1, "app_click_ver", "1", "", "");
  }
  
  public boolean a(Intent paramIntent, Activity paramActivity, QQAppInterface paramQQAppInterface)
  {
    boolean bool2 = true;
    boolean bool1;
    if (!"thridapp".equals(paramIntent.getStringExtra("share_from"))) {
      bool1 = false;
    }
    Object localObject;
    Long localLong;
    do
    {
      do
      {
        return bool1;
        paramIntent.removeExtra("share_from");
        localObject = a();
        localLong = Long.valueOf(paramIntent.getLongExtra("req_share_id", 0L));
        bool1 = bool2;
      } while (!((ThridAppShareHelper)localObject).a(String.valueOf(localLong)));
      paramIntent.putExtra("share_from_aio", true);
      paramIntent.putExtra("forward_type", 11);
      paramIntent.putExtra("req_type", 1);
      if (!paramIntent.hasExtra("pkg_name")) {
        paramIntent.putExtra("pkg_name", "");
      }
      paramIntent.putExtra("refuse_show_share_result_dialog", true);
      localObject = ((ThridAppShareHelper)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
      bool1 = bool2;
    } while (localObject == null);
    paramIntent = ForwardOptionBuilder.a(paramIntent, paramQQAppInterface, paramActivity);
    paramActivity = new Bundle();
    paramActivity.putString("uin", ((SessionInfo)localObject).jdField_a_of_type_JavaLangString);
    paramActivity.putInt("uintype", ((SessionInfo)localObject).jdField_a_of_type_Int);
    paramActivity.putString("troop_uin", ((SessionInfo)localObject).b);
    paramActivity.putString("uinname", ((SessionInfo)localObject).d);
    paramIntent.a(ForwardAbility.ForwardAbilityType.a.intValue(), paramActivity);
    a(String.valueOf(localLong), "app_share_view", "", "", "");
    return true;
  }
  
  public boolean a(String paramString)
  {
    return this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString);
  }
  
  public void b()
  {
    Object localObject2 = AuthorizeConfig.a().a("aio_pluginApp", "");
    Object localObject1 = null;
    try
    {
      localObject2 = new JSONArray((String)localObject2);
      localObject1 = localObject2;
    }
    catch (JSONException localJSONException2)
    {
      for (;;)
      {
        try
        {
          localObject2 = localObject1.getJSONObject(i);
          str = ((JSONObject)localObject2).optString("appid");
          localThirdAppInfo = new ThridAppShareHelper.ThirdAppInfo(this);
          localThirdAppInfo.jdField_a_of_type_JavaLangString = ((JSONObject)localObject2).optString("downloadLink");
          localThirdAppInfo.b = String.format("tencent%s.provider://", new Object[] { str });
          localThirdAppInfo.c = ((JSONObject)localObject2).optString("defaultScheme_a");
          this.jdField_a_of_type_JavaUtilHashMap.put(str, localThirdAppInfo);
          i += 1;
        }
        catch (JSONException localJSONException1)
        {
          localJSONException1.printStackTrace();
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("show3rdApp", 2, "get JsonObject error!");
        }
        localJSONException2 = localJSONException2;
        localJSONException2.printStackTrace();
      }
    }
    if ((localObject1 != null) && (localObject1.length() > 0))
    {
      this.jdField_a_of_type_JavaUtilHashMap.clear();
      j = localObject1.length();
      i = 0;
      if (i >= j) {}
    }
    while (!QLog.isColorLevel())
    {
      int j;
      int i;
      String str;
      ThridAppShareHelper.ThirdAppInfo localThirdAppInfo;
      return;
    }
    QLog.d("show3rdApp", 2, "config is null!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.thridappshare.ThridAppShareHelper
 * JD-Core Version:    0.7.0.1
 */