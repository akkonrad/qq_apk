package com.tencent.mobileqq.webview.swift;

import aknt;
import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider.SwiftBrowserComponentProviderSupporter;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class WebViewPlugin
{
  public static final String KEY_ERROR_CODE = "errorCode";
  public static final String KEY_PERFORMANCE = "performanceData";
  public static final String KEY_REQUEST = "requestData";
  public static final String KEY_RESPONSE = "responseData";
  public static final String KEY_TARGET = "target";
  public static final String KEY_URL = "url";
  public static final int RECODE_FAILED_FREQUENCY_LIMIT = 5;
  public static final int RECODE_FAILED_NATIVE_ERROR = -100;
  public static final int RECODE_FAILED_NO_SUCH_METHOD = 3;
  public static final int RECODE_FAILED_PARAMS_ERROR = 4;
  public static final int RECODE_FAILED_PERMISSION_DENIED = 1;
  public static final int RECODE_FAILED_TOKEN_VERIFY_TIME_OUT = 2;
  public static final int RECODE_SUCCESSED = 0;
  public static final int TARGET_LEFT_VIEW = 1;
  public static final int TARGET_NAV_BACK = 2;
  public static final int TARGET_SYS_BACK = 3;
  public final String TAG = getClass().getSimpleName();
  AtomicBoolean inited = new AtomicBoolean(false);
  public boolean isDestroy;
  public HashMap mOpenApiListeners;
  public String mPluginNameSpace = "";
  public WebViewPlugin.PluginRuntime mRuntime;
  public long pluginEventFlag;
  
  public static JSONObject getJsonFromJSBridge(String paramString)
  {
    int i;
    try
    {
      i = paramString.indexOf("=");
      if ((i == -1) || (i + 1 > paramString.length() - 1)) {
        throw new Exception("illegal json");
      }
    }
    catch (Exception localException)
    {
      QLog.e("WebViewPlugin", 1, "getJsonFromJSBridge error!" + paramString, localException);
      return null;
    }
    JSONObject localJSONObject = new JSONObject(URLDecoder.decode(paramString.substring(i + 1), "UTF-8"));
    return localJSONObject;
  }
  
  public static String toJsScript(String paramString, JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    return "window.mqq && mqq.execEventCallback && mqq.execEventCallback(" + Util.a(paramString) + "," + String.valueOf(paramJSONObject1) + "," + String.valueOf(paramJSONObject2) + ");";
  }
  
  public void addOpenApiListenerIfNeeded(String paramString, JsBridgeListener paramJsBridgeListener)
  {
    if ((paramJsBridgeListener != null) && (paramJsBridgeListener.a))
    {
      if (this.mOpenApiListeners == null) {
        this.mOpenApiListeners = new HashMap();
      }
      this.mOpenApiListeners.put(paramString, paramJsBridgeListener);
    }
  }
  
  final void bindFragment(WebViewFragment paramWebViewFragment)
  {
    if (this.mRuntime != null)
    {
      this.mRuntime.a(paramWebViewFragment);
      return;
    }
    throw new IllegalArgumentException("plugin runtime must be init");
  }
  
  @Deprecated
  public void callJs(String paramString)
  {
    if (this.isDestroy) {}
    for (;;)
    {
      return;
      if (this.mRuntime != null) {}
      for (CustomWebView localCustomWebView = this.mRuntime.a(); localCustomWebView != null; localCustomWebView = null)
      {
        localCustomWebView.c(paramString);
        return;
      }
    }
  }
  
  public void callJs(String paramString, String... paramVarArgs)
  {
    if (this.isDestroy) {}
    for (;;)
    {
      return;
      if (this.mRuntime != null) {}
      for (CustomWebView localCustomWebView = this.mRuntime.a(); localCustomWebView != null; localCustomWebView = null)
      {
        localCustomWebView.a(paramString, paramVarArgs);
        return;
      }
    }
  }
  
  public void callJs4OpenApi(JsBridgeListener paramJsBridgeListener, int paramInt, String paramString)
  {
    if (this.isDestroy) {}
    for (;;)
    {
      return;
      if (this.mRuntime != null) {}
      for (CustomWebView localCustomWebView = this.mRuntime.a(); localCustomWebView != null; localCustomWebView = null)
      {
        localCustomWebView.a(paramJsBridgeListener, paramInt, new String[] { paramString });
        return;
      }
    }
  }
  
  public void callJs4OpenApiIfNeeded(String paramString, int paramInt, Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.mOpenApiListeners != null)
    {
      bool1 = bool2;
      if (this.mOpenApiListeners.containsKey(paramString))
      {
        callJs4OpenApi((JsBridgeListener)this.mOpenApiListeners.remove(paramString), paramInt, JsBridgeListener.a(paramInt, paramObject, null));
        bool1 = true;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG + ".troop.openapi", 2, "callJs4OpenApiIfNeeded, methodName:" + paramString + "| callJs4OpenApi:" + bool1);
    }
  }
  
  public void callJs4OpenApiIfNeeded(String paramString1, int paramInt, String paramString2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.mOpenApiListeners != null)
    {
      bool1 = bool2;
      if (this.mOpenApiListeners.containsKey(paramString1))
      {
        callJs4OpenApi((JsBridgeListener)this.mOpenApiListeners.remove(paramString1), paramInt, JsBridgeListener.a(paramInt, null, paramString2));
        bool1 = true;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG + ".troop.openapi", 2, "callJs4OpenApiIfNeeded, methodName:" + paramString1 + "| callJs4OpenApi:" + bool1);
    }
  }
  
  public void dispatchJsEvent(String paramString, JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    callJs(toJsScript(paramString, paramJSONObject1, paramJSONObject2));
  }
  
  public final Object getBrowserComponent(int paramInt)
  {
    if (this.mRuntime != null)
    {
      WebViewFragment localWebViewFragment = this.mRuntime.a();
      if (localWebViewFragment != null) {
        return localWebViewFragment.b().a(paramInt);
      }
      if ((this.mRuntime.a() instanceof SwiftBrowserComponentsProvider.SwiftBrowserComponentProviderSupporter)) {
        return ((SwiftBrowserComponentsProvider.SwiftBrowserComponentProviderSupporter)this.mRuntime.a()).b().a(paramInt);
      }
    }
    return null;
  }
  
  public int getRequestCode(byte paramByte)
  {
    if (this.mRuntime != null) {}
    for (WebUiBaseInterface localWebUiBaseInterface = this.mRuntime.a(this.mRuntime.a()); (localWebUiBaseInterface instanceof WebViewPluginContainer); localWebUiBaseInterface = null) {
      return ((WebViewPluginContainer)localWebUiBaseInterface).a(this, paramByte);
    }
    if (QLog.isDevelopLevel()) {
      QLog.d(this.TAG, 4, "startActivityForResult not called, activity need implement Interface WebViewPluginContainer");
    }
    return -1;
  }
  
  public Object handleEvent(String paramString, long paramLong)
  {
    return null;
  }
  
  public boolean handleEvent(String paramString, long paramLong, Map paramMap)
  {
    return false;
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    return false;
  }
  
  public boolean handleSchemaRequest(String paramString1, String paramString2)
  {
    return false;
  }
  
  final void initRuntime(Activity paramActivity, AppInterface paramAppInterface)
  {
    if (this.inited.compareAndSet(false, true)) {
      this.mRuntime = new WebViewPlugin.PluginRuntime(paramActivity, paramAppInterface);
    }
  }
  
  public void onActivityReady() {}
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt) {}
  
  public void onAppRuntimeReady(AppInterface paramAppInterface) {}
  
  public void onCreate() {}
  
  public void onDestroy()
  {
    this.isDestroy = true;
    if (this.mOpenApiListeners != null) {
      this.mOpenApiListeners.clear();
    }
  }
  
  public void onPostPluginAsyncTask() {}
  
  public void onWebViewCreated(CustomWebView paramCustomWebView)
  {
    if ((paramCustomWebView != null) && (this.mRuntime != null)) {
      this.mRuntime.a = new WeakReference(paramCustomWebView);
    }
  }
  
  public void postPluginAsyncTask(Runnable paramRunnable)
  {
    ThreadManager.post(paramRunnable, 5, new aknt(this), false);
  }
  
  public WebViewPlugin setHandler(Handler paramHandler)
  {
    return this;
  }
  
  public void setWebUiInterface(WebUiBaseInterface paramWebUiBaseInterface) {}
  
  public void startActivityForResult(Intent paramIntent, byte paramByte)
  {
    Activity localActivity = null;
    WebUiBaseInterface localWebUiBaseInterface;
    if (this.mRuntime != null)
    {
      localWebUiBaseInterface = this.mRuntime.a(this.mRuntime.a());
      if (this.mRuntime != null) {
        localActivity = this.mRuntime.a();
      }
      if (!(localWebUiBaseInterface instanceof WebViewPluginContainer)) {
        break label67;
      }
      ((WebViewPluginContainer)localWebUiBaseInterface).a(this, paramIntent, paramByte);
    }
    label67:
    do
    {
      return;
      localWebUiBaseInterface = null;
      break;
      if ((localActivity instanceof WebViewPluginContainer))
      {
        ((WebViewPluginContainer)localActivity).a(this, paramIntent, paramByte);
        return;
      }
    } while (!QLog.isDevelopLevel());
    QLog.d(this.TAG, 4, "startActivityForResult not called, activity need implement Interface WebViewPluginContainer");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.WebViewPlugin
 * JD-Core Version:    0.7.0.1
 */