package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.log.VipWebViewReportLog;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.URLInterceptManager;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.SwiftWebViewFragmentSupporter;
import com.tencent.mobileqq.webview.swift.WebUiBaseInterface;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebviewReportSpeedInterface;
import com.tencent.mqpsdk.util.NetUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class VasWebReport
  extends WebViewPlugin
{
  private static final int HTTP_CAPTURE_TO_QLOG = 1;
  private static final int PERFORMANCE_TO_QLOG = 2;
  public static final String PLUGIN_NAMESPACE = "debug";
  static final String TAG = "VasWebReport";
  public static final String WEB_CORE_DATA_FLAGS = "filterType";
  public static final int WEB_CORE_DUMP_ERROR = 4;
  public static final int WEB_CORE_HTTP_CAPTURE = 2;
  public static final int WEB_CORE_PERFORMANCE_DATA = 1;
  private Map errorMap = new HashMap();
  private JSONObject mFirstScreenPerformanceObject;
  private JSONObject mIndexPerformanceObject;
  URLInterceptManager mURLInterceptManager;
  private int mWebCoreDumpFlags;
  private int mWebCoreDumpHandlePolicy;
  private Map startTimeMap = new HashMap();
  
  public VasWebReport()
  {
    this.mPluginNameSpace = "debug";
  }
  
  private void handleNewPerformanceData(String paramString, JSONObject paramJSONObject)
  {
    if ((paramJSONObject == null) || (!paramJSONObject.has("infotype"))) {}
    label335:
    do
    {
      do
      {
        return;
        for (;;)
        {
          int i;
          try
          {
            i = paramJSONObject.optInt("infotype");
            if ((i == 2) && (paramJSONObject.has("first_screen")))
            {
              this.mFirstScreenPerformanceObject = paramJSONObject;
              if (QLog.isColorLevel()) {
                QLog.i("Web_X5_Performance", 2, "X5 mFirstScreenPerformanceObject: " + paramJSONObject.toString());
              }
              if ((this.mIndexPerformanceObject == null) || (this.mFirstScreenPerformanceObject == null)) {
                break;
              }
              paramString = this.mIndexPerformanceObject;
              paramString.put("first_screen", this.mFirstScreenPerformanceObject.optLong("first_screen"));
              paramString.optLong("dns_start");
              paramString.optLong("dns_end");
              paramString.optLong("connect_start");
              paramString.optLong("connect_end");
              paramString.optLong("recv_start");
              paramString.optLong("recv_end");
              paramJSONObject = this.mRuntime.a(this.mRuntime.a());
              if ((paramJSONObject == null) || (!(paramJSONObject instanceof WebUiUtils.WebviewReportSpeedInterface))) {
                break label335;
              }
              ((WebUiUtils.WebviewReportSpeedInterface)paramJSONObject).setX5Performance(paramString);
              this.mIndexPerformanceObject = null;
              this.mFirstScreenPerformanceObject = null;
              return;
            }
          }
          catch (Exception paramString)
          {
            paramString.printStackTrace();
            return;
          }
          if ((i == 1) && (paramJSONObject.has("recv_start")))
          {
            String str2 = paramJSONObject.optString("url");
            if (TextUtils.isEmpty(str2)) {
              break;
            }
            i = str2.indexOf("?");
            String str1 = str2;
            if (i != -1) {
              str1 = str2.substring(0, i);
            }
            i = paramString.indexOf("?");
            str2 = paramString;
            if (i != -1) {
              str2 = paramString.substring(0, i);
            }
            if (str2.equalsIgnoreCase(str1))
            {
              if (QLog.isColorLevel()) {
                QLog.i("Web_X5_Performance", 2, "X5 index onResourcesPerformance: " + paramJSONObject.toString());
              }
              this.mIndexPerformanceObject = paramJSONObject;
            }
          }
        }
      } while (!(this.mRuntime.a() instanceof SwiftWebViewFragmentSupporter));
      paramJSONObject = (SwiftBrowserStatistics)super.getBrowserComponent(-2);
    } while (paramJSONObject == null);
    paramJSONObject.a = paramString;
    this.mIndexPerformanceObject = null;
    this.mFirstScreenPerformanceObject = null;
  }
  
  private void handlePerformanceData(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    for (;;)
    {
      try
      {
        long l1 = paramJSONObject.optLong("first_word");
        long l2 = paramJSONObject.optLong("first_screen");
        long l3 = paramJSONObject.optLong("page_finish");
        if (QLog.isColorLevel()) {
          QLog.i("Web_X5_Performance", 2, "X5 onResourcesPerformance, first_word: " + l1 + ", first_screen:" + l2 + ", page_finish:" + l3);
        }
        paramJSONObject = paramJSONObject.getJSONArray("resources");
        if ((paramJSONObject == null) || (paramJSONObject.length() <= 0)) {
          break;
        }
        localJSONObject = paramJSONObject.getJSONObject(0);
        if (QLog.isColorLevel()) {
          QLog.i("Web_X5_Performance", 2, "X5 onResourcesPerformance: " + localJSONObject);
        }
        localJSONObject.put("first_screen", l2);
        localJSONObject.optLong("dns_start");
        localJSONObject.optLong("dns_end");
        localJSONObject.optLong("connect_start");
        localJSONObject.optLong("connect_end");
        localJSONObject.optLong("recv_start");
        localJSONObject.optLong("recv_end");
        WebUiBaseInterface localWebUiBaseInterface = this.mRuntime.a(this.mRuntime.a());
        if ((localWebUiBaseInterface == null) || (!(localWebUiBaseInterface instanceof WebUiUtils.WebviewReportSpeedInterface))) {
          break label298;
        }
        ((WebUiUtils.WebviewReportSpeedInterface)localWebUiBaseInterface).setX5Performance(localJSONObject);
      }
      catch (Exception paramJSONObject)
      {
        JSONObject localJSONObject;
        paramJSONObject.printStackTrace();
        return;
      }
      if (i >= paramJSONObject.length()) {
        break;
      }
      localJSONObject = paramJSONObject.getJSONObject(i);
      if (QLog.isColorLevel()) {
        QLog.i("Web_X5_Performance", 2, "X5 onResourcesPerformance: " + localJSONObject);
      }
      i += 1;
      continue;
      label298:
      int i = 1;
    }
  }
  
  private void handlePublicAccountReport(String paramString, JSONObject paramJSONObject)
  {
    if ((paramJSONObject == null) || (!paramJSONObject.has("infotype"))) {
      return;
    }
    for (;;)
    {
      String str3;
      try
      {
        if (paramJSONObject.optInt("infotype") != 1) {
          break;
        }
        str3 = paramJSONObject.optString("url");
        if (TextUtils.isEmpty(str3)) {
          break;
        }
        int i = str3.indexOf("?");
        if (i != -1)
        {
          str1 = str3.substring(0, i);
          i = paramString.indexOf("?");
          String str2 = paramString;
          if (i != -1) {
            str2 = paramString.substring(0, i);
          }
          long l1 = paramJSONObject.optLong("dns_start");
          long l2 = paramJSONObject.optLong("dns_end");
          long l3 = paramJSONObject.optLong("connect_start");
          long l4 = paramJSONObject.optLong("connect_end");
          long l5 = paramJSONObject.optLong("recv_start");
          long l6 = paramJSONObject.optLong("recv_end");
          Object localObject = new URL(str3);
          paramString = ((URL)localObject).getHost();
          localObject = ((URL)localObject).getPath();
          if (("qqpublic.qpic.cn".equalsIgnoreCase(paramString)) && (!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).startsWith("/qq_public")))
          {
            i = (int)(l2 - l1);
            j = (int)(l4 - l3);
            k = (int)(l6 - l5);
            m = paramJSONObject.optInt("errorcode");
            localObject = paramJSONObject.optString("website_address");
            int n = NetUtil.a(null);
            if (QLog.isColorLevel()) {
              QLog.i("PublicAccountWebReport", 2, "urlStr: " + str3 + ",errorcode:" + m + ",netType:" + n + ",DNSCost" + i + ",connectCost:" + j + ",receiveCost:" + k + ",website_address:" + (String)localObject + ",AppSetting.subVersion:" + "7.6.3,3,3560");
            }
          }
          if (!str2.equalsIgnoreCase(str1)) {
            break;
          }
          i = 0;
          if ("post.mp.qq.com".equalsIgnoreCase(paramString)) {
            i = 1;
          }
          if (i == 0) {
            break;
          }
          i = (int)(l2 - l1);
          int j = (int)(l4 - l3);
          int k = (int)(l6 - l5);
          int m = paramJSONObject.optInt("errorcode");
          paramString = paramJSONObject.optString("website_address");
          PublicAccountWebReport.reportPublicAccountNetInfoRequest(this.mRuntime.a(), j, i, m, k, str3, paramString);
          l2 = this.mFirstScreenPerformanceObject.optLong("first_screen");
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("PublicAccountWebReport", 2, "first_screen: " + (l2 - l1));
          return;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return;
      }
      String str1 = str3;
    }
  }
  
  private void startActivity(Intent paramIntent)
  {
    if (this.mRuntime == null) {}
    do
    {
      return;
      if (this.mRuntime.a() != null)
      {
        this.mRuntime.a().startActivity(paramIntent);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("VasWebReport", 2, "Activity is null");
  }
  
  protected boolean handleEvent(String paramString, long paramLong, Map paramMap)
  {
    Object localObject1;
    int i;
    if (paramLong == 32L)
    {
      if ((paramString.startsWith("http")) || (paramString.startsWith("https")))
      {
        paramMap = this.mRuntime.a();
        if ((paramMap == null) || (paramMap.getX5WebViewExtension() == null)) {
          return false;
        }
        localObject1 = WebAccelerateHelper.getInstance().getWebViewFeatureParams();
        if (localObject1 == null) {
          break label331;
        }
        i = localObject1[6].intValue();
        this.mWebCoreDumpHandlePolicy |= 0x1;
        if ((VipWebViewReportLog.a(paramString)) && (VipWebViewReportLog.b())) {
          this.mWebCoreDumpFlags |= 0x3;
        }
        if (paramMap.getContext().getSharedPreferences("WebView_X5_Report", 4).getBoolean("enableX5Report", true))
        {
          this.mWebCoreDumpFlags |= 0x1;
          this.mWebCoreDumpHandlePolicy |= 0x2;
        }
        this.mWebCoreDumpFlags &= i;
        if (QLog.isColorLevel()) {
          QLog.d("WebCoreDump", 2, "Data Filter Mask=0x" + Integer.toHexString(i) + ". setDataFilterForRequestInfo=" + this.mWebCoreDumpFlags + ". WebCoreDumpPolicy=" + this.mWebCoreDumpHandlePolicy);
        }
        if (this.mWebCoreDumpFlags != 0)
        {
          paramString = new Bundle();
          paramString.putInt("filterType", this.mWebCoreDumpFlags);
          paramMap.getX5WebViewExtension().invokeMiscMethod("setDataFilterForRequestInfo", paramString);
          if ((this.mWebCoreDumpFlags & 0x2) == 0) {
            break label339;
          }
          bool = true;
          label278:
          paramMap.a(bool);
          paramString = new Bundle();
          if ((this.mWebCoreDumpFlags & 0x1) == 0) {
            break label345;
          }
        }
      }
      label331:
      label339:
      label345:
      for (boolean bool = true;; bool = false)
      {
        paramString.putBoolean("enabled", bool);
        paramMap.getX5WebViewExtension().invokeMiscMethod("webPerformanceRecordingEnabled", paramString);
        return false;
        i = 65535;
        break;
        bool = false;
        break label278;
      }
    }
    WebResourceRequest localWebResourceRequest;
    WebResourceResponse localWebResourceResponse;
    if (paramLong == 64L) {
      if (this.mWebCoreDumpFlags != 0)
      {
        localObject1 = null;
        localWebResourceRequest = null;
        localWebResourceResponse = null;
        Object localObject2 = paramMap.get("performanceData");
        if ((localObject2 instanceof JSONObject)) {
          localObject1 = (JSONObject)localObject2;
        }
        localObject2 = paramMap.get("requestData");
        if ((localObject2 instanceof WebResourceRequest)) {
          localWebResourceRequest = (WebResourceRequest)localObject2;
        }
        localObject2 = paramMap.get("responseData");
        if ((localObject2 instanceof WebResourceResponse)) {
          localWebResourceResponse = (WebResourceResponse)localObject2;
        }
        paramMap = paramMap.get("errorCode");
        if (!(paramMap instanceof Integer)) {
          break label1162;
        }
      }
    }
    label902:
    label1162:
    for (paramMap = (Integer)paramMap;; paramMap = Integer.valueOf(0))
    {
      if (((this.mWebCoreDumpHandlePolicy & 0x1) != 0) && (localWebResourceRequest != null)) {
        VipWebViewReportLog.a((JSONObject)localObject1, localWebResourceRequest, localWebResourceResponse, paramMap.intValue());
      }
      if (((this.mWebCoreDumpHandlePolicy & 0x2) != 0) && (localObject1 != null))
      {
        if (!((JSONObject)localObject1).has("infotype")) {
          break label551;
        }
        handleNewPerformanceData(paramString, (JSONObject)localObject1);
        handlePublicAccountReport(paramString, (JSONObject)localObject1);
      }
      for (;;)
      {
        return true;
        label551:
        handlePerformanceData((JSONObject)localObject1);
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("VasWebReport", 2, "WebView core dump received but no policy can handle it");
        }
      }
      if (paramLong == 8589934593L)
      {
        this.startTimeMap.remove(paramString);
        this.startTimeMap.put(paramString, Long.valueOf(System.currentTimeMillis()));
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("VasWebReport", 2, "VasWebReport:EVENT_LOAD_START");
        break;
      }
      if (paramLong == 8589934594L)
      {
        if (QLog.isColorLevel()) {
          QLog.d("VasWebReport", 2, "VasWebReport:EVENT_LOAD_FINISH");
        }
        if ((paramString.contains("vip.qq.com")) || (paramString.contains("vaswebreport=1")))
        {
          paramMap = "XG";
          if ((this.mRuntime == null) || (this.mRuntime.a() == null)) {
            return false;
          }
          localObject1 = this.mRuntime.a().getApplicationContext();
          if (2 != NetworkUtil.a((Context)localObject1)) {
            break label902;
          }
          paramMap = "2G";
        }
        for (;;)
        {
          if (!this.errorMap.containsKey(paramString)) {
            break label953;
          }
          ReportController.a(null, "P_CliOper", "vasweb", "", "load", "finish", 0, 1, "errocode:" + this.errorMap.get(paramString), paramMap, Util.b(paramString, new String[0]), "7.6.3--android--" + Build.VERSION.SDK_INT);
          this.errorMap.remove(paramString);
          this.startTimeMap.remove(paramString);
          paramString = this.mRuntime.a();
          paramMap = this.mRuntime.a();
          if ((paramMap == null) || (paramMap.a == null) || (paramMap.a.a != null)) {
            break;
          }
          paramMap.a.a = new URLInterceptManager(paramString);
          break;
          if (3 == NetworkUtil.a((Context)localObject1)) {
            paramMap = "3G";
          } else if (4 == NetworkUtil.a((Context)localObject1)) {
            paramMap = "4G";
          } else if (1 == NetworkUtil.a((Context)localObject1)) {
            paramMap = "WIFI";
          }
        }
        label953:
        if (this.startTimeMap.containsKey(paramString)) {}
        for (paramLong = System.currentTimeMillis() - ((Long)this.startTimeMap.get(paramString)).longValue();; paramLong = -1L)
        {
          ReportController.a(null, "P_CliOper", "vasweb", "", "load", "finish", 0, 0, "" + paramLong, paramMap, Util.b(paramString, new String[0]), "7.6.3--android--" + Build.VERSION.SDK_INT);
          break;
          if (QLog.isColorLevel()) {
            QLog.e("VasWebReport", 2, "VasWebReport--EVENT_LOAD_FINISH:report erro,there is not starttime for " + paramString);
          }
        }
      }
      if (paramLong != 8589934595L) {
        break;
      }
      i = ((Integer)paramMap.get("errorCode")).intValue();
      this.errorMap.put(paramString, Integer.valueOf(i));
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("VasWebReport", 2, "VasWebReport:EVENT_LOAD_ERROR");
      break;
    }
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (("debug".equalsIgnoreCase(paramString2)) && ("log".equalsIgnoreCase(paramString3)))
    {
      paramJsBridgeListener = (SwiftBrowserStatistics)super.getBrowserComponent(-2);
      if (paramJsBridgeListener != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQBrowser_report", 2, "try report web status, onNetworkCost,  step: 11, asyncMode: " + paramJsBridgeListener.jdField_b_of_type_Int + ", from loadUrl: " + (System.currentTimeMillis() - paramJsBridgeListener.n) + ", stepTime: " + (System.currentTimeMillis() - paramJsBridgeListener.jdField_b_of_type_Long) + ", totalTime: " + (System.currentTimeMillis() - paramJsBridgeListener.jdField_b_of_type_Long) + ", \n " + paramString1);
        }
        return true;
      }
    }
    return false;
  }
  
  protected void onDestroy()
  {
    this.startTimeMap.clear();
    this.startTimeMap = null;
    this.errorMap.clear();
    this.errorMap = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.VasWebReport
 * JD-Core Version:    0.7.0.1
 */