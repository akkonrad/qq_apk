package com.tencent.biz.troop;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import ovw;
import ovx;
import ovy;

@SuppressLint({"InlinedApi"})
public class TroopMemberApiPlugin
  extends WebViewPlugin
  implements TroopMemberApiClient.Callback
{
  TroopMemberApiClient jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = null;
  VideoCombineHelper jdField_a_of_type_ComTencentBizTroopVideoCombineHelper = null;
  protected String a;
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  
  public TroopMemberApiPlugin()
  {
    this.mPluginNameSpace = "TroopMemberApiPlugin";
  }
  
  private void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      for (;;)
      {
        return;
        try
        {
          Object localObject = new JSONObject(paramString);
          paramString = ((JSONObject)localObject).optString("gcode");
          localObject = ((JSONObject)localObject).optString("id");
          if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(paramString)))
          {
            this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.b(paramString, (String)localObject);
            return;
          }
        }
        catch (JSONException paramString)
        {
          paramString.printStackTrace();
        }
      }
    } while (!QLog.isColorLevel());
    QLog.i(this.TAG, 2, "anonymousReport exception" + paramString.getMessage());
  }
  
  void a()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true))
    {
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = TroopMemberApiClient.a();
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a();
    }
  }
  
  public void a(Bundle paramBundle)
  {
    if (paramBundle == null) {}
    String str;
    do
    {
      return;
      if ("changeAnonymousNick".equals(paramBundle.getString("method")))
      {
        boolean bool = paramBundle.getBoolean("result");
        callJs(this.jdField_a_of_type_JavaLangString, new String[] { "{result : " + bool + "}" });
        return;
      }
      str = paramBundle.getString("callback");
    } while (TextUtils.isEmpty(str));
    callJs(str, new String[] { paramBundle.getString("data") });
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ("anonymousReport".equals(paramString3))
    {
      a(paramVarArgs[0]);
      return true;
    }
    int i;
    if ("anonymousNickChanged".equals(paramString3)) {
      try
      {
        paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
        paramString1 = paramJsBridgeListener.optString("troopUin");
        long l = paramJsBridgeListener.optLong("bubbleId");
        i = paramJsBridgeListener.optInt("headId");
        paramString2 = paramJsBridgeListener.optString("nickName");
        int j = paramJsBridgeListener.optInt("expireTime");
        paramString3 = paramJsBridgeListener.optString("rankColor");
        this.jdField_a_of_type_JavaLangString = paramJsBridgeListener.optString("callback");
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 2, "TroopMemberApiPlugin, anonymousNickChanged, json : " + paramJsBridgeListener);
        }
        this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a(paramString1, l, i, paramString2, j, paramString3, this);
        return true;
      }
      catch (JSONException paramJsBridgeListener)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 2, "TroopMemberApiPlugin, anonymousNickChanged, JSONException :" + paramJsBridgeListener);
        }
      }
    }
    Object localObject1;
    for (;;)
    {
      return false;
      if ("getUploadInfo".equals(paramString3)) {
        try
        {
          callJs(new JSONObject(paramVarArgs[0]).optString("callback"), new String[] { "{stateus:0}" });
          return true;
        }
        catch (JSONException paramJsBridgeListener)
        {
          for (;;)
          {
            paramJsBridgeListener.printStackTrace();
          }
        }
      }
      if ("cleanDynamicRedPoint".equals(paramString3)) {
        try
        {
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]).optString("callback");
          this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.c(paramJsBridgeListener, this);
          return true;
        }
        catch (JSONException paramJsBridgeListener)
        {
          for (;;)
          {
            paramJsBridgeListener.printStackTrace();
          }
        }
      }
      Object localObject2;
      if (("selectedTribe".endsWith(paramString3)) && (paramVarArgs.length == 1))
      {
        try
        {
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
          paramVarArgs = this.mRuntime.a();
          paramString3 = paramJsBridgeListener.optString("name");
          paramString2 = paramJsBridgeListener.optString("bid");
          localObject1 = paramJsBridgeListener.optJSONObject("condition");
          paramString1 = paramJsBridgeListener.optString("tribeList");
          localObject2 = new Intent();
          paramJsBridgeListener = paramString3;
          if (TextUtils.isEmpty(paramString3)) {
            paramJsBridgeListener = "";
          }
          ((Intent)localObject2).putExtra("tribeName", paramJsBridgeListener);
          paramJsBridgeListener = paramString2;
          if (TextUtils.isEmpty(paramString2)) {
            paramJsBridgeListener = "";
          }
          ((Intent)localObject2).putExtra("bid", paramJsBridgeListener);
          paramJsBridgeListener = paramString1;
          if (TextUtils.isEmpty(paramString1)) {
            paramJsBridgeListener = "";
          }
          ((Intent)localObject2).putExtra("tribeList", paramJsBridgeListener);
          i = ((JSONObject)localObject1).optInt("optionType", -1);
          if (i != -1) {
            ((Intent)localObject2).putExtra("optionType", i);
          }
          paramVarArgs.setResult(-1, (Intent)localObject2);
          paramVarArgs.finish();
        }
        catch (JSONException paramJsBridgeListener) {}
        if (QLog.isColorLevel()) {
          QLog.e(this.TAG, 2, "JSONException:" + paramJsBridgeListener.toString());
        }
      }
      else if ("getTroopBarPublishInfo".equals(paramString3))
      {
        try
        {
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]).optString("callback");
          if (this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient == null)
          {
            this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = TroopMemberApiClient.a();
            this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a();
          }
          this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a(new ovw(this, paramJsBridgeListener));
        }
        catch (JSONException paramJsBridgeListener)
        {
          paramJsBridgeListener.printStackTrace();
        }
      }
      else
      {
        if (("createVideoAndSend".equals(paramString3)) || ("prepareVideoResources".equals(paramString3))) {
          try
          {
            if (QLog.isColorLevel()) {
              QLog.i(this.TAG, 2, paramString3 + "json:" + paramVarArgs[0]);
            }
            paramVarArgs = new JSONObject(paramVarArgs[0]);
            paramString1 = paramVarArgs.optString("troopUin");
            paramString2 = paramVarArgs.optString("wording");
            localObject1 = paramVarArgs.optString("bgMusic");
            i = paramVarArgs.optInt("tailType");
            paramJsBridgeListener = paramVarArgs.optString("callback");
            paramVarArgs = paramVarArgs.optJSONArray("videos");
            if ((("createVideoAndSend".equals(paramString3)) && (TextUtils.isEmpty(paramString1))) || (TextUtils.isEmpty(paramString2)) || (paramVarArgs == null) || (paramVarArgs.length() == 0))
            {
              paramString3 = new JSONObject();
              paramString3.put("retCode", 1);
              paramString3.put("errorMsg", "params error: troopUin = " + paramString1 + " wroding = " + paramString2 + " array = " + paramVarArgs);
              callJs(paramJsBridgeListener, new String[] { paramString3.toString() });
              return true;
            }
            if (this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper == null) {
              this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper = new VideoCombineHelper((BaseActivity)this.mRuntime.a());
            }
            localObject2 = this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper;
            localObject2.getClass();
            localObject2 = new VideoCombineHelper.CombineParams((VideoCombineHelper)localObject2);
            ((VideoCombineHelper.CombineParams)localObject2).jdField_a_of_type_JavaLangString = paramString1;
            ((VideoCombineHelper.CombineParams)localObject2).b = ((String)localObject1);
            ((VideoCombineHelper.CombineParams)localObject2).c = paramString2;
            ((VideoCombineHelper.CombineParams)localObject2).jdField_a_of_type_Int = i;
            i = 0;
            while (i < paramVarArgs.length())
            {
              paramString1 = paramVarArgs.getString(i);
              ((VideoCombineHelper.CombineParams)localObject2).jdField_a_of_type_JavaUtilArrayList.add(paramString1);
              i += 1;
            }
            if ("createVideoAndSend".equals(paramString3)) {
              this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper.a((VideoCombineHelper.CombineParams)localObject2, new ovx(this, paramJsBridgeListener));
            } else {
              this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper.a((VideoCombineHelper.CombineParams)localObject2, new ovy(this, paramJsBridgeListener));
            }
          }
          catch (Exception paramJsBridgeListener)
          {
            QLog.e(this.TAG, 1, "invoke createVideoAndSend failed", paramJsBridgeListener);
          }
        }
        if ("checkVideoLib".equals(paramString3))
        {
          try
          {
            paramJsBridgeListener = new JSONObject(paramVarArgs[0]).optString("callback");
            paramString1 = new JSONObject();
            if (!VideoEnvironment.e(this.mRuntime.a())) {
              break label1112;
            }
            paramString1.put("retCode", 0);
            callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
          }
          catch (Exception paramJsBridgeListener)
          {
            paramJsBridgeListener.printStackTrace();
          }
          continue;
          label1112:
          paramString1.put("retCode", -1);
          callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
          if (this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient == null)
          {
            this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = TroopMemberApiClient.a();
            this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a();
          }
          this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.d();
        }
        else if (("setTribePublishTopic".equals(paramString3)) && (paramVarArgs.length == 1))
        {
          try
          {
            paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
            paramString2 = paramJsBridgeListener.optString("callback");
            paramString3 = new JSONObject();
            paramVarArgs = this.mRuntime.a();
            i = paramJsBridgeListener.optInt("theme_id", -1);
            paramString1 = paramJsBridgeListener.optString("theme_name");
            localObject1 = new Intent();
            if ((i == -1) || (paramString1 != null)) {
              break;
            }
            paramVarArgs.setResult(0, (Intent)localObject1);
            paramString3.put("retCode", -1);
            if (QLog.isColorLevel()) {
              QLog.d(this.TAG, 2, "setTribePublishTopic JSAPI mThemeID = " + i + " mThemeName = " + paramString1);
            }
            callJs(paramString2, new String[] { paramString3.toString() });
          }
          catch (JSONException paramJsBridgeListener) {}
          if (QLog.isColorLevel()) {
            QLog.e(this.TAG, 2, "selectedTheme JSONException:" + paramJsBridgeListener.toString());
          }
        }
      }
    }
    ((Intent)localObject1).putExtra("theme_id", i);
    if (TextUtils.isEmpty(paramString1)) {}
    for (paramJsBridgeListener = "";; paramJsBridgeListener = paramString1)
    {
      ((Intent)localObject1).putExtra("theme_name", paramJsBridgeListener);
      paramVarArgs.setResult(-1, (Intent)localObject1);
      paramString3.put("retCode", 0);
      break;
    }
    return true;
  }
  
  protected void onCreate()
  {
    AppInterface localAppInterface = this.mRuntime.a();
    Activity localActivity = this.mRuntime.a();
    if ((localAppInterface == null) || (localActivity == null)) {
      return;
    }
    a();
  }
  
  protected void onDestroy()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.b();
    }
    this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.troop.TroopMemberApiPlugin
 * JD-Core Version:    0.7.0.1
 */