package com.tencent.biz.webviewplugin;

import android.content.Intent;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class QZoneTihSettingWebPlugin
  extends WebViewPlugin
{
  public QZoneTihSettingWebPlugin()
  {
    this.mPluginNameSpace = "qztodayinhistory";
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZoneTihSettingWebPlugin", 2, "handleJsRequest url: " + paramString1 + "pkgName:" + paramString2 + "method:" + paramString3);
    }
    if (!paramString2.equals("qztodayinhistory")) {}
    while (!paramString3.equals("settihnome")) {
      return false;
    }
    paramJsBridgeListener = new Intent("aciton_switch_tih_setting");
    if (QLog.isColorLevel()) {
      QLog.d("QZoneTihSettingWebPlugin", 2, "actionString: " + paramJsBridgeListener.getAction());
    }
    BaseApplication.getContext().sendBroadcast(paramJsBridgeListener);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.QZoneTihSettingWebPlugin
 * JD-Core Version:    0.7.0.1
 */