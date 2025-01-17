import android.app.Activity;
import android.graphics.Bitmap;
import android.net.http.SslCertificate;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.pubaccount.util.PublicAccountH5AbilityPlugin;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.activity.aio.AIOOpenWebMonitor;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.webview.sonic.SonicClientImpl;
import com.tencent.mobileqq.webview.swift.WebViewCallback;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.webview.swift.WebViewWrapper;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Map;

public class aknz
  extends WebViewClient
{
  ArrayMap a;
  
  aknz(WebViewWrapper paramWebViewWrapper) {}
  
  WebResourceResponse a(WebView paramWebView, String paramString)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    if (TextUtils.isEmpty(paramString)) {}
    WebViewPluginEngine localWebViewPluginEngine;
    do
    {
      return localObject2;
      if (paramString.startsWith("mqqpa://resourceid/")) {
        return PublicAccountH5AbilityPlugin.a(paramString);
      }
      localWebViewPluginEngine = ((CustomWebView)paramWebView).a();
    } while (localWebViewPluginEngine == null);
    Object localObject1;
    if (paramString.startsWith("https://jsbridge/"))
    {
      localObject1 = paramString.replace("https://jsbridge/", "jsbridge://");
      if (QLog.isColorLevel())
      {
        if ((!((String)localObject1).startsWith("jsbridge://")) || (((String)localObject1).length() <= 512)) {
          break label239;
        }
        QLog.i("WebLog_WebViewWrapper", 2, "doInterceptRequest:" + ((String)localObject1).substring(0, 512));
      }
    }
    for (;;)
    {
      if ((!((String)localObject1).startsWith("jsbridge:")) || (this.b.jdField_a_of_type_ComTencentBizUiTouchWebView == null)) {
        break label264;
      }
      this.b.jdField_a_of_type_ComTencentBizUiTouchWebView.post(new akoa(this, localWebViewPluginEngine, (String)localObject1));
      localObject1 = new WebResourceResponse("text/html", "utf-8", new ByteArrayInputStream(new byte[0]));
      paramString = ((WebResourceResponse)localObject1).getResponseHeaders();
      paramWebView = paramString;
      if (paramString == null) {
        paramWebView = new HashMap();
      }
      paramWebView.put("cache-control", "must-revalidate，no-store");
      ((WebResourceResponse)localObject1).setResponseHeaders(paramWebView);
      return localObject1;
      localObject1 = paramString;
      if (!paramString.startsWith("http://jsbridge/")) {
        break;
      }
      localObject1 = paramString.replace("http://jsbridge/", "jsbridge://");
      break;
      label239:
      QLog.i("WebLog_WebViewWrapper", 2, "doInterceptRequest:" + (String)localObject1);
    }
    for (;;)
    {
      try
      {
        label264:
        if (this.b.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl != null)
        {
          paramWebView = this.b.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl.requestResource((String)localObject1);
          if (!(paramWebView instanceof WebResourceResponse)) {
            break label417;
          }
          paramWebView = (WebResourceResponse)paramWebView;
        }
      }
      catch (Exception paramString)
      {
        label337:
        paramWebView = localObject3;
        label348:
        QLog.e("WebLog_WebViewWrapper", 1, "shouldInterceptRequest:intercept by sonic error -> " + paramString.getMessage());
        continue;
      }
      for (;;)
      {
        try
        {
          QLog.i("WebLog_WebViewWrapper", 1, "doInterceptRequest:intercept by sonic.");
          localObject2 = paramWebView;
          if (paramWebView != null) {
            break;
          }
        }
        catch (Exception paramString)
        {
          break label348;
          break label337;
        }
        try
        {
          paramString = localWebViewPluginEngine.a((String)localObject1, 8L);
          if (!(paramString instanceof WebResourceResponse)) {
            continue;
          }
          paramString = (WebResourceResponse)paramString;
          paramWebView = paramString;
          return paramWebView;
        }
        catch (Exception paramString)
        {
          QLog.e("WebLog_WebViewWrapper", 1, "shouldInterceptRequest error:" + paramString.getMessage());
          return paramWebView;
        }
      }
      paramWebView = null;
      continue;
      label417:
      paramWebView = null;
    }
  }
  
  public void onDetectedBlankScreen(String paramString, int paramInt)
  {
    QLog.i("WebLog_WebViewWrapper", 1, "onDetectedBlankScreen, status: " + paramInt + ", url:" + paramString);
    if (this.b.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewCallback != null) {
      this.b.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewCallback.a(paramString, paramInt);
    }
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    if ((this.b.jdField_a_of_type_AndroidAppActivity.isFinishing()) || (this.b.jdField_a_of_type_ComTencentBizUiTouchWebView == null)) {
      return;
    }
    QLog.d("WebLog_WebViewWrapper", 1, "onPageFinished:" + paramString);
    super.onPageFinished(paramWebView, paramString);
    if (this.b.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewCallback != null) {
      this.b.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewCallback.a(paramWebView, paramString);
    }
    paramWebView = ((CustomWebView)paramWebView).a();
    if (paramWebView != null) {
      paramWebView.a(paramString, 8589934594L, null);
    }
    AIOOpenWebMonitor.b(this.b.jdField_a_of_type_AndroidContentIntent);
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    if ((this.b.jdField_a_of_type_AndroidAppActivity.isFinishing()) || (this.b.jdField_a_of_type_ComTencentBizUiTouchWebView == null)) {}
    do
    {
      return;
      QLog.d("WebLog_WebViewWrapper", 1, "onPageStarted:" + paramString);
      super.onPageStarted(paramWebView, paramString, paramBitmap);
      if (this.b.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewCallback != null)
      {
        this.b.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewCallback.a(paramWebView, paramString, paramBitmap);
        this.b.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewCallback.b(paramWebView, paramString, paramBitmap);
      }
      paramWebView = ((CustomWebView)paramWebView).a();
    } while (paramWebView == null);
    paramWebView.a(paramString, 8589934593L, null);
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    if ((this.b.jdField_a_of_type_AndroidAppActivity.isFinishing()) || (this.b.jdField_a_of_type_ComTencentBizUiTouchWebView == null)) {}
    do
    {
      return;
      QLog.e("WebLog_WebViewWrapper", 1, "onReceivedError:" + paramInt + ", desc=" + paramString1 + ", url=" + paramString2);
      if (this.b.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewCallback != null) {
        this.b.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewCallback.a(paramWebView, paramInt, paramString1, paramString2);
      }
      paramWebView = ((CustomWebView)paramWebView).a();
    } while (paramWebView == null);
    paramWebView.a(paramString2, 8589934595L, paramInt);
  }
  
  public void onReceivedHttpError(WebView paramWebView, WebResourceRequest paramWebResourceRequest, WebResourceResponse paramWebResourceResponse)
  {
    if ((paramWebView != null) && (paramWebResourceRequest != null) && (paramWebResourceResponse != null))
    {
      QLog.e("WebLog_WebViewWrapper", 1, "onReceivedHttpError:" + paramWebResourceRequest.getUrl() + "Occur error, resp code=" + paramWebResourceResponse.getStatusCode());
      String str = paramWebView.getUrl();
      if ((str != null) && (AuthorizeConfig.a().a(str)))
      {
        paramWebView = ((CustomWebView)paramWebView).a();
        if (paramWebView != null)
        {
          if (this.a == null) {
            this.a = new ArrayMap(4);
          }
          this.a.put("requestData", paramWebResourceRequest);
          this.a.put("responseData", paramWebResourceResponse);
          this.a.put("errorCode", Integer.valueOf(paramWebResourceResponse.getStatusCode()));
          paramWebView.a(str, 64L, this.a);
          paramWebView.a(str, 8589934612L, this.a);
        }
      }
    }
  }
  
  public void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
  {
    if ((this.b.jdField_a_of_type_AndroidAppActivity.isFinishing()) || (this.b.jdField_a_of_type_ComTencentBizUiTouchWebView == null)) {
      return;
    }
    SslCertificate localSslCertificate = paramSslError.getCertificate();
    String str = paramWebView.getUrl();
    paramSslError = new StringBuilder().append("onReceivedSslError:").append(paramSslError.getPrimaryError()).append(", cert=");
    if (localSslCertificate == null) {}
    for (paramWebView = "null";; paramWebView = localSslCertificate.toString())
    {
      QLog.e("WebLog_WebViewWrapper", 1, paramWebView + ", pageUrl=" + Util.b(str, new String[0]));
      paramSslErrorHandler.cancel();
      return;
    }
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    if ((this.b.jdField_a_of_type_ComTencentBizUiTouchWebView == null) || (this.b.jdField_a_of_type_AndroidAppActivity.isFinishing()))
    {
      QLog.e("WebLog_WebViewWrapper", 1, "call shouldOverrideUrlLoading after destroy.");
      return true;
    }
    if ((TextUtils.isEmpty(paramString)) || ("about:blank;".equals(paramString)) || ("about:blank".equals(paramString)))
    {
      QLog.e("WebLog_WebViewWrapper", 1, new Object[] { new StringBuilder("shouldOverrideUrlLoading fail , url=[").append(paramString).append("].") });
      return true;
    }
    String str;
    if (paramString.startsWith("https://jsbridge/"))
    {
      str = paramString.replace("https://jsbridge/", "jsbridge://");
      if (QLog.isColorLevel())
      {
        if ((!str.startsWith("jsbridge://")) || (str.length() <= 512)) {
          break label264;
        }
        QLog.d("WebLog_WebViewWrapper", 2, "shouldOverrideUrlLoading:" + str.substring(0, 512));
      }
    }
    for (;;)
    {
      AIOOpenWebMonitor.b(this.b.jdField_a_of_type_AndroidContentIntent, str);
      paramString = SwiftWebViewUtils.a(str);
      if ((this.b.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewCallback == null) || (!this.b.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewCallback.c(this.b.jdField_a_of_type_ComTencentBizUiTouchWebView, str))) {
        break label301;
      }
      QLog.d("WebLog_WebViewWrapper", 1, "shouldOverrideUrlLoading callback handle override url");
      return true;
      str = paramString;
      if (!paramString.startsWith("http://jsbridge/")) {
        break;
      }
      str = paramString.replace("http://jsbridge/", "jsbridge://");
      break;
      label264:
      QLog.d("WebLog_WebViewWrapper", 2, "shouldOverrideUrlLoading:" + Util.b(str, new String[0]));
    }
    label301:
    if ((("http".equals(paramString)) || ("data".equals(paramString))) && (!str.contains("/cgi-bin/httpconn?htcmd=0x6ff0080"))) {
      CustomWebView.b(Util.b(str, new String[0]));
    }
    try
    {
      WebViewPluginEngine localWebViewPluginEngine = ((CustomWebView)paramWebView).a();
      if ((localWebViewPluginEngine != null) && (localWebViewPluginEngine.a(str, 1024L, null)))
      {
        QLog.i("WebLog_WebViewWrapper", 1, "KEY_EVENT_OVERRIDE_URL_LOADING");
        return true;
      }
      if ((localWebViewPluginEngine != null) && (localWebViewPluginEngine.a(str))) {
        return true;
      }
      if ((this.b.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewCallback != null) && (this.b.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewCallback.b(paramWebView, str))) {
        return true;
      }
      if (("http".equals(paramString)) || ("https".equals(paramString)) || ("data".equals(paramString)) || ("file".equals(paramString)))
      {
        if ((localWebViewPluginEngine != null) && (localWebViewPluginEngine.a(str, 16L, null))) {
          return true;
        }
      }
      else if (this.b.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewCallback != null)
      {
        boolean bool = this.b.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewCallback.a(this.b.jdField_a_of_type_ComTencentBizUiTouchWebView, str);
        if (bool) {
          return true;
        }
      }
    }
    catch (RuntimeException paramWebView)
    {
      paramString = QLog.getStackTraceString(paramWebView);
      if (paramString.length() > 255) {}
      for (paramWebView = paramString.substring(0, 255);; paramWebView = paramString)
      {
        ReportController.b(null, "P_CliOper", "BizTechReport", "", "webview", "exception", 0, 1, 0, paramWebView, "", "", "");
        QLog.e("WebLog_WebViewWrapper", 1, paramString);
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aknz
 * JD-Core Version:    0.7.0.1
 */