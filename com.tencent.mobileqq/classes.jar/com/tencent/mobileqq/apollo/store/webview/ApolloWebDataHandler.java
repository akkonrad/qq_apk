package com.tencent.mobileqq.apollo.store.webview;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vaswebviewplugin.ApolloJsPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.util.LRULinkedHashMap;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONObject;
import yuv;
import yuw;
import yux;

public class ApolloWebDataHandler
{
  private static ApolloWebDataHandler jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloWebDataHandler;
  private static boolean jdField_a_of_type_Boolean;
  private ApolloSSOConfig jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloSSOConfig = new ApolloSSOConfig(this);
  private final LRULinkedHashMap jdField_a_of_type_ComTencentUtilLRULinkedHashMap = new LRULinkedHashMap(128);
  
  private ApolloWebDataHandler()
  {
    jdField_a_of_type_Boolean = BaseApplicationImpl.getApplication().getSharedPreferences("sp_apollo_webView", 4).getBoolean("sp_key_disable_thunder_cache", false);
  }
  
  private ApolloUrlInterceptor a(CustomWebView paramCustomWebView)
  {
    if (paramCustomWebView == null) {
      return null;
    }
    paramCustomWebView = paramCustomWebView.a();
    if (paramCustomWebView != null)
    {
      paramCustomWebView = paramCustomWebView.a("apollo");
      if ((paramCustomWebView != null) && ((paramCustomWebView instanceof ApolloJsPlugin))) {
        return ((ApolloJsPlugin)paramCustomWebView).getIntercepter();
      }
    }
    return null;
  }
  
  public static ApolloWebDataHandler a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloWebDataHandler == null) {
        jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloWebDataHandler = new ApolloWebDataHandler();
      }
      ApolloWebDataHandler localApolloWebDataHandler = jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloWebDataHandler;
      return localApolloWebDataHandler;
    }
    finally {}
  }
  
  public static void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("apollo_client_ApolloWebDataHandler", 2, "apollo_client initInAsyncThread isInstanceCreated():" + a());
    }
    if (!a()) {
      ThreadManager.postImmediately(new yuv(), null, true);
    }
  }
  
  public static boolean a()
  {
    return jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloWebDataHandler != null;
  }
  
  private String b(String paramString)
  {
    Object localObject;
    if (TextUtils.isEmpty(paramString)) {
      localObject = "";
    }
    String str;
    do
    {
      return localObject;
      if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloSSOConfig == null) {
        return "";
      }
      str = this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloSSOConfig.a(paramString);
      localObject = str;
    } while (!QLog.isColorLevel());
    QLog.d("apollo_client_ApolloWebDataHandler", 2, "getMD5FromDb pageId:" + paramString + " md5:" + str);
    return str;
  }
  
  public WebResourceResponse a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloSSOConfig == null) {
      return null;
    }
    if (paramString1.contains("http://cmshow.qq.com/get_thunder_data?cmd="))
    {
      paramString1 = paramString1.substring("http://cmshow.qq.com/get_thunder_data?cmd=".length());
      if (!this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloSSOConfig.a(paramString2, paramString1))
      {
        if (QLog.isColorLevel()) {
          QLog.d("apollo_client_ApolloWebDataHandler", 2, "getApolloCmdResource false, apolloClientId:" + paramString2 + " cmd:" + paramString1 + ",mSSOConfig.isValidCmd:false");
        }
        return null;
      }
      paramString2 = ApolloSSOConfig.a(paramString2, paramString1);
      yux localyux = (yux)this.jdField_a_of_type_ComTencentUtilLRULinkedHashMap.get(paramString2);
      if (localyux != null) {
        if (yux.a(localyux))
        {
          if (localyux.a(paramString1))
          {
            if (QLog.isColorLevel()) {
              QLog.d("apollo_client_ApolloWebDataHandler", 2, "getApolloCmdResource, webSSOTask.isValid true, webSSOTask=" + localyux);
            }
            if (yux.a(localyux) != null)
            {
              yux.a(localyux).c = System.currentTimeMillis();
              yux.a(localyux).d = System.currentTimeMillis();
            }
            paramString1 = new WebResourceResponse("text/plain", "utf-8", ApolloClientUtil.a(yux.a(localyux).toString()));
            this.jdField_a_of_type_ComTencentUtilLRULinkedHashMap.remove(paramString2);
            return paramString1;
          }
          if (QLog.isColorLevel()) {
            QLog.d("apollo_client_ApolloWebDataHandler", 2, "getApolloCmdResource, webSSOTask.isValid false,webSSOTask:" + localyux);
          }
          this.jdField_a_of_type_ComTencentUtilLRULinkedHashMap.remove(paramString2);
        }
      }
      for (;;)
      {
        return new WebResourceResponse("text/plain", "utf-8", new BridgeStream(null, null, null));
        if (QLog.isColorLevel()) {
          QLog.d("apollo_client_ApolloWebDataHandler", 2, "getApolloCmdResource, has webSSOTask = false");
        }
      }
    }
    return null;
  }
  
  public String a(String paramString)
  {
    try
    {
      paramString = Uri.parse(paramString);
      if (paramString.isHierarchical())
      {
        paramString = paramString.getQueryParameter("thunder_id");
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      QLog.e("apollo_client_ApolloWebDataHandler", 2, paramString.getMessage());
    }
    return null;
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, AppInterface paramAppInterface, ApolloWebStatistics paramApolloWebStatistics)
  {
    if ((TextUtils.isEmpty(paramString1)) || (this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloSSOConfig == null)) {}
    do
    {
      do
      {
        return;
        if (NetworkUtil.g(paramContext)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("apollo_client_ApolloWebDataHandler", 2, "preLoadSSOCmd false, NetworkUtil.isNetworkAvailable:false");
      return;
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloSSOConfig.a(paramString1);
      if ((localObject1 != null) && (!((Set)localObject1).isEmpty())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("apollo_client_ApolloWebDataHandler", 2, "preloadSSOCmd, apolloClientId:" + paramString1 + " cmds is null or empty");
    return;
    if (QLog.isColorLevel()) {
      QLog.d("apollo_client_ApolloWebDataHandler", 2, "preloadSSOCmd, apolloClientId:" + paramString1 + " print all task:" + this.jdField_a_of_type_ComTencentUtilLRULinkedHashMap);
    }
    Object localObject1 = ((Set)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (String)((Iterator)localObject1).next();
      String str = ApolloSSOConfig.a(paramString1, (String)localObject2);
      yux localyux = (yux)this.jdField_a_of_type_ComTencentUtilLRULinkedHashMap.get(str);
      if ((localyux != null) && (localyux.a((String)localObject2)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("apollo_client_ApolloWebDataHandler", 2, "preloadSSOCmd, apolloClientId:" + paramString1 + " mPreloadSSOCmds.has WebSSOTask:" + localyux);
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentUtilLRULinkedHashMap.remove(str);
        localyux = new yux(paramApolloWebStatistics, str, (String)localObject2);
        this.jdField_a_of_type_ComTencentUtilLRULinkedHashMap.put(str, localyux);
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloSSOConfig.a(paramString2, paramString1, (String)localObject2, paramAppInterface);
        if (QLog.isColorLevel()) {
          QLog.d("apollo_client_ApolloWebDataHandler", 2, "preloadSSOCmd, apolloClientId:" + paramString1 + " create new WebSSOTask, requestJson" + localObject2);
        }
        if (localObject2 != null) {
          localyux.a(paramContext, paramString2, (JSONObject)localObject2, paramAppInterface);
        }
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloSSOConfig.a(paramAppInterface);
  }
  
  public boolean a(String paramString)
  {
    if (ApolloUtil.a()) {
      QLog.d("apollo_client_ApolloWebDataHandler", 2, "isApolloClientId, ApolloUtil.isApolloProxyEnable() return");
    }
    do
    {
      do
      {
        return false;
      } while (TextUtils.isEmpty(paramString));
      if (QLog.isColorLevel()) {
        QLog.d("apollo_client_ApolloWebDataHandler", 2, "isApolloClientId, apolloClientId:" + paramString);
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloSSOConfig == null);
    return this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloSSOConfig.a(paramString);
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    if (jdField_a_of_type_Boolean) {
      if (QLog.isColorLevel()) {
        QLog.d("apollo_client_ApolloWebDataHandler", 2, "verifyCache, sDisableCache:" + jdField_a_of_type_Boolean);
      }
    }
    String str;
    do
    {
      do
      {
        return false;
      } while ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)));
      str = ApolloClientUtil.b(paramString2);
      paramString1 = b(paramString1);
      if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(str)) && (str.toUpperCase().equals(paramString1.toUpperCase()))) {
        return true;
      }
    } while (!QLog.isColorLevel());
    QLog.d("apollo_client_ApolloWebDataHandler", 2, "verifyMd5 false:" + paramString1 + " contentMd5:" + str + ",configMd5:" + paramString1 + " html.length:" + paramString2.length());
    return false;
  }
  
  public boolean a(String paramString1, String paramString2, AppInterface paramAppInterface, WebViewPlugin paramWebViewPlugin)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (paramWebViewPlugin == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("apollo_client_ApolloWebDataHandler", 2, "doInterceptApollo false, url=" + paramString1 + " plugin:" + paramWebViewPlugin + " app:" + paramAppInterface + " requestStr:" + paramString2);
      }
      return false;
    }
    if (!NetworkUtil.g(BaseApplicationImpl.getContext()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("apollo_client_ApolloWebDataHandler", 2, "doInterceptApollo false, NetworkUtil.isNetworkAvailable:false");
      }
      return false;
    }
    if ((paramWebViewPlugin.mRuntime == null) || (paramWebViewPlugin.mRuntime.a() == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("apollo_client_ApolloWebDataHandler", 2, "doInterceptApollo false, plugin.mRuntime.getWebView() is null");
      }
      return false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloSSOConfig == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("apollo_client_ApolloWebDataHandler", 2, "doInterceptApollo false, mSSOConfig is null");
      }
      return false;
    }
    for (;;)
    {
      try
      {
        String str3 = a().a(paramString1);
        if (TextUtils.isEmpty(str3))
        {
          if (!QLog.isColorLevel()) {
            break label735;
          }
          QLog.d("apollo_client_ApolloWebDataHandler", 2, "doInterceptApollo false, url is:" + paramString1 + " no need preload");
          break label735;
        }
        ApolloUrlInterceptor localApolloUrlInterceptor = a(paramWebViewPlugin.mRuntime.a());
        if (localApolloUrlInterceptor == null)
        {
          if (!QLog.isColorLevel()) {
            break label737;
          }
          QLog.d("apollo_client_ApolloWebDataHandler", 2, "doInterceptApollo false, apolloSession is null");
          break label737;
        }
        JSONObject localJSONObject = new JSONObject(paramString2);
        String str1 = localJSONObject.getString("callback");
        if (TextUtils.isEmpty(str1)) {
          return false;
        }
        String str2 = localJSONObject.getString("cmd");
        if (!this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloSSOConfig.a(str3, str2))
        {
          if (!QLog.isColorLevel()) {
            break label739;
          }
          QLog.d("apollo_client_ApolloWebDataHandler", 2, "doInterceptApollo false, apolloClientId:" + str3 + " cmd:" + str2 + ",mSSOConfig.isValidCmd:false");
          break label739;
        }
        str3 = ApolloSSOConfig.a(str3, str2);
        paramString2 = (yux)this.jdField_a_of_type_ComTencentUtilLRULinkedHashMap.get(str3);
        if (paramString2 != null)
        {
          if (yux.a(paramString2))
          {
            if (paramString2.a(str2))
            {
              if (QLog.isColorLevel()) {
                QLog.d("apollo_client_ApolloWebDataHandler", 2, "doInterceptApolloCmd, webSSOTask.isValid true, mResultJson=" + paramString2);
              }
              if (yux.a(paramString2) != null)
              {
                yux.a(paramString2).c = System.currentTimeMillis();
                yux.a(paramString2).d = System.currentTimeMillis();
              }
              paramWebViewPlugin.callJs(str1, new String[] { yux.a(paramString2).toString() });
              this.jdField_a_of_type_ComTencentUtilLRULinkedHashMap.remove(str3);
              return true;
            }
            if (QLog.isColorLevel()) {
              QLog.d("apollo_client_ApolloWebDataHandler", 2, "doInterceptApolloCmd, webSSOTask.isValid false,webSSOTask:" + paramString2);
            }
            i = 1;
            this.jdField_a_of_type_ComTencentUtilLRULinkedHashMap.remove(str3);
            if (i == 0) {
              break label741;
            }
            if (localApolloUrlInterceptor != null)
            {
              paramString2 = localApolloUrlInterceptor.a();
              paramString2.c = System.currentTimeMillis();
              paramString2 = new yux(paramString2, str3, str2);
              paramString2.a(new yuw(this, str1, paramWebViewPlugin));
              if (paramWebViewPlugin.mRuntime != null) {
                paramString2.a(paramWebViewPlugin.mRuntime.a(), paramString1, localJSONObject, paramAppInterface);
              }
              this.jdField_a_of_type_ComTencentUtilLRULinkedHashMap.put(str3, paramString2);
              break label741;
            }
          }
          else
          {
            if (yux.a(paramString2) != null) {
              yux.a(paramString2).c = System.currentTimeMillis();
            }
            paramString2.a(new yuw(this, str1, paramWebViewPlugin));
            if (!QLog.isColorLevel()) {
              break label729;
            }
            QLog.d("apollo_client_ApolloWebDataHandler", 2, "doInterceptApolloCmd, has webSSOTask = true, but webSSOTask.mReceivedSSO:false, wait notify!");
            i = 0;
            continue;
          }
        }
        else
        {
          if (!QLog.isColorLevel()) {
            break label743;
          }
          QLog.d("apollo_client_ApolloWebDataHandler", 2, "doInterceptApolloCmd, has webSSOTask = false,create webSSOTask!");
          break label743;
        }
        paramString2 = new ApolloWebStatistics();
        continue;
        i = 0;
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        return false;
      }
      label729:
      continue;
      label735:
      return false;
      label737:
      return false;
      label739:
      return false;
      label741:
      return true;
      label743:
      int i = 1;
    }
  }
  
  public void b()
  {
    jdField_a_of_type_Boolean = true;
    BaseApplicationImpl.getApplication().getSharedPreferences("sp_apollo_webView", 4).edit().putBoolean("sp_key_disable_thunder_cache", true).commit();
  }
  
  public boolean b(String paramString)
  {
    return paramString.contains("http://cmshow.qq.com/get_thunder_data?cmd=");
  }
  
  public boolean b(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return false;
    }
    int i = paramString1.indexOf("?");
    String str = paramString1;
    if (i != -1) {
      str = paramString1.substring(0, i);
    }
    ApolloClientUtil.a(ApolloClientUtil.d(ApolloClientUtil.e(str)), paramString2);
    if (QLog.isColorLevel()) {
      QLog.d("apollo_client_ApolloWebDataHandler", 2, "saveHtml url:" + str + " html.length:" + paramString2.length());
    }
    return true;
  }
  
  public void c()
  {
    jdField_a_of_type_Boolean = false;
    BaseApplicationImpl.getApplication().getSharedPreferences("sp_apollo_webView", 4).edit().putBoolean("sp_key_disable_thunder_cache", false).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.webview.ApolloWebDataHandler
 * JD-Core Version:    0.7.0.1
 */