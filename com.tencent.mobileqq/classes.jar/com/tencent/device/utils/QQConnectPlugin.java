package com.tencent.device.utils;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.device.bind.DevicePluginDownloadActivity;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.ToastUtil;
import java.net.URLDecoder;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class QQConnectPlugin
  extends WebViewPlugin
{
  public QQConnectPlugin()
  {
    this.mPluginNameSpace = "QQConnect";
  }
  
  private HashMap a(String paramString)
  {
    HashMap localHashMap = new HashMap();
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return localHashMap;
      paramString = URLDecoder.decode(paramString).split("&");
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        String[] arrayOfString = paramString[i].split("=");
        if (arrayOfString.length > 1) {
          localHashMap.put(arrayOfString[0], arrayOfString[1]);
        }
        i += 1;
      }
    }
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    paramJsBridgeListener = null;
    if (!"QQConnect".equals(paramString2)) {
      return false;
    }
    if ("goShare".equals(paramString3))
    {
      LogUtility.c(this.TAG, "goshare");
      String str1;
      String str2;
      int i;
      try
      {
        paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
        paramString3 = paramJsBridgeListener.getString("din");
        paramString2 = a(paramJsBridgeListener.getString("args"));
        paramVarArgs = (String)paramString2.get("uin");
        str1 = (String)paramString2.get("sn");
        str2 = (String)paramString2.get("pid");
        i = paramJsBridgeListener.optInt("public_device", 0);
        if ((i != 0) && ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2))))
        {
          ToastUtil.a().a(this.mRuntime.a().getString(2131427815));
          return true;
        }
      }
      catch (JSONException paramJsBridgeListener)
      {
        ToastUtil.a().a(this.mRuntime.a().getString(2131427811));
        return true;
      }
      paramString2 = this.mRuntime.a();
      paramJsBridgeListener = paramString2;
      if ((paramString2 instanceof BasePluginActivity)) {
        paramJsBridgeListener = ((BasePluginActivity)paramString2).getOutActivity();
      }
      paramJsBridgeListener = new Intent(paramJsBridgeListener, DevicePluginDownloadActivity.class);
      if (i != 0)
      {
        paramJsBridgeListener.putExtra("DevicePID", str2);
        paramJsBridgeListener.putExtra("DeviceSN", str1);
        paramJsBridgeListener.putExtra("DeviceToken", "");
        paramJsBridgeListener.putExtra("public_device", i);
      }
      for (;;)
      {
        paramJsBridgeListener.putExtra("from", "share");
        this.mRuntime.a().startActivity(paramJsBridgeListener);
        this.mRuntime.a().finish();
        return true;
        paramJsBridgeListener.putExtra("troop_uin", paramString3);
        paramJsBridgeListener.putExtra("uin", paramVarArgs);
        paramJsBridgeListener.putExtra("url", paramString1);
      }
    }
    if ("doReport".equals(paramString3)) {}
    try
    {
      LogUtility.c(this.TAG, "doReport");
      paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
      SmartDeviceReport.a(null, paramJsBridgeListener.optString("actionName"), paramJsBridgeListener.optInt("fromType"), paramJsBridgeListener.optInt("actionResult"), paramJsBridgeListener.optInt("ext2"));
      return true;
    }
    catch (JSONException paramJsBridgeListener)
    {
      break label649;
    }
    if ("goBind".equals(paramString3)) {}
    label649:
    try
    {
      LogUtility.c(this.TAG, "qrUrl");
      paramString1 = new JSONObject(paramVarArgs[0]).optString("url");
      boolean bool = TextUtils.isEmpty(paramString1);
      if (bool) {}
    }
    catch (JSONException paramJsBridgeListener)
    {
      label428:
      break label649;
    }
    try
    {
      paramString1 = new String(Base64Util.decode(paramString1, 0));
      paramJsBridgeListener = paramString1;
    }
    catch (Exception paramString1)
    {
      break label428;
    }
    if (!TextUtils.isEmpty(paramJsBridgeListener))
    {
      paramString2 = this.mRuntime.a();
      paramString1 = paramString2;
      if ((paramString2 instanceof BasePluginActivity)) {
        paramString1 = ((BasePluginActivity)paramString2).getOutActivity();
      }
      paramString1 = new Intent(paramString1, DevicePluginDownloadActivity.class);
      paramString1.putExtra("qrurl", paramJsBridgeListener);
      paramString1.putExtra("entrance", 1);
      paramString1.putExtra("from", "connect");
      this.mRuntime.a().startActivity(paramString1);
    }
    this.mRuntime.a().finish();
    return true;
    if ("jumpPublicDevice".equals(paramString3)) {
      try
      {
        LogUtility.c(this.TAG, "METHOD_JUMP_PUBLICDEVICE");
        paramString2 = new JSONObject(paramVarArgs[0]).optString("actionUrl");
        if (TextUtils.isEmpty(paramString2)) {
          return true;
        }
        paramString1 = this.mRuntime.a();
        paramJsBridgeListener = paramString1;
        if ((paramString1 instanceof BasePluginActivity)) {
          paramJsBridgeListener = ((BasePluginActivity)paramString1).getOutActivity();
        }
        paramJsBridgeListener = new Intent(paramJsBridgeListener, DevicePluginDownloadActivity.class);
        paramJsBridgeListener.putExtra("url", paramString2);
        paramJsBridgeListener.putExtra("jumpPublicDevice", true);
        paramJsBridgeListener.putExtra("from", "share");
        this.mRuntime.a().startActivity(paramJsBridgeListener);
        this.mRuntime.a().finish();
        return true;
      }
      catch (JSONException paramJsBridgeListener) {}
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.device.utils.QQConnectPlugin
 * JD-Core Version:    0.7.0.1
 */