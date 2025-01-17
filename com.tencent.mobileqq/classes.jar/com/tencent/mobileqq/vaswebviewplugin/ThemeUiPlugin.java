package com.tencent.mobileqq.vaswebviewplugin;

import akkn;
import android.content.Intent;
import android.os.Handler;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import java.io.File;
import org.json.JSONObject;

public class ThemeUiPlugin
  extends VasWebviewUiPlugin
{
  public static final String EXTRA_THEME_ID = "extra_theme_id";
  public static final String REPORT_COPYCAT_THEME_DOWNLOAD_TAG = "report_copycat_theme_file_download";
  public static final int REPORT_THEME_DOWNLOAD_CONTENT_RANGE_IILEGAL = 89065;
  public static final int REPORT_THEME_DOWNLOAD_DATA_WRONG = 89068;
  public static final int REPORT_THEME_DOWNLOAD_MKDIR_FAILED = 89069;
  public static final int REPORT_THEME_DOWNLOAD_NOT_EQUAL = 89066;
  public static final int REPORT_THEME_DOWNLOAD_RENAME_FAILED = 89067;
  public static final String REPORT_THEME_DOWNLOAD_TAG = "report_theme_file_download";
  static final int REPORT_THEME_INFO = 1;
  private static final String TAG = "ThemeUiPlugin";
  public static String initCurrThemeNameForReport;
  public static int initDownloadedThemeNumForReport;
  public static Handler reportHandler;
  public static int reportTimes;
  
  public static void destroy(QQAppInterface paramQQAppInterface)
  {
    initDownloadedThemeNumForReport = 0;
    initCurrThemeNameForReport = null;
    reportTimes = 0;
    if (reportHandler != null) {
      reportHandler.removeMessages(1);
    }
  }
  
  public static String getReportCurrThemeName()
  {
    String str2 = SkinEngine.getInstances().getSkinRootPath();
    if ((str2 == null) || (str2.trim().length() == 0)) {
      return "default_theme";
    }
    String str1 = str2;
    if (str2.charAt(str2.length() - 1) == File.separatorChar) {
      str1 = str2.substring(0, str2.length() - 1);
    }
    return str1.substring(str1.lastIndexOf(File.separatorChar), str1.length());
  }
  
  public static void reportThemeNumAndCurrThemeName(QQAppInterface paramQQAppInterface, String paramString)
  {
    reportTimes = 0;
    if (reportHandler == null) {
      reportHandler = new akkn(BaseApplication.getContext().getMainLooper());
    }
    reportHandler.removeMessages(1);
    initDownloadedThemeNumForReport = 0;
    initCurrThemeNameForReport = null;
    paramQQAppInterface.a(new ThemeUiPlugin.1(paramQQAppInterface, paramString));
  }
  
  void OnActivityResume()
  {
    this.activity.setTitle("主题");
  }
  
  protected long getPluginBusiness()
  {
    return 32L;
  }
  
  public boolean onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ThemeUiPlugin", 2, "BaseWebActivity onActivityResult requestCode=" + paramInt1 + ",resultCode=" + paramInt2);
    }
    if (paramInt2 == -1) {}
    switch (paramInt1)
    {
    default: 
      return false;
    }
    try
    {
      String str = paramIntent.getStringExtra("callbackSn");
      paramIntent = paramIntent.getStringExtra("result");
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("responseId", str);
      localJSONObject.put("responseData", new JSONObject(paramIntent));
      if (QLog.isColorLevel()) {
        QLog.i("ThemeUiPlugin", 2, "BaseWebActivity loadUrl setMessage =" + localJSONObject.toString());
      }
      this.mRuntime.a().loadUrl("javascript:window.qqJSBridge&&qqJSBridge.setMessage('" + localJSONObject.toString() + "');");
    }
    catch (Exception paramIntent)
    {
      for (;;)
      {
        paramIntent.printStackTrace();
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ThemeUiPlugin
 * JD-Core Version:    0.7.0.1
 */