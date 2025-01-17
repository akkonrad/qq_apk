package com.tencent.mobileqq.webview.sonic;

import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.common.util.Util;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebViewUtils;
import com.tencent.mobileqq.webview.webso.WebSoUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.sonic.sdk.SonicRuntime;
import com.tencent.sonic.sdk.SonicSessionClient;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class SonicRuntimeImpl
  extends SonicRuntime
{
  public SonicRuntimeImpl(Context paramContext)
  {
    super(paramContext);
  }
  
  public Object createWebResourceResponse(String paramString1, String paramString2, InputStream paramInputStream, Map paramMap)
  {
    paramString1 = new WebResourceResponse(paramString1, paramString2, paramInputStream);
    paramString1.setResponseHeaders(paramMap);
    return paramString1;
  }
  
  public String getCookie(String paramString)
  {
    return SwiftBrowserCookieMonster.c(paramString);
  }
  
  public String getCurrentUserAccount()
  {
    return BaseApplicationImpl.getApplication().getRuntime().getAccount();
  }
  
  public String getHostDirectAddress(String paramString)
  {
    Object localObject3 = null;
    Object localObject4 = null;
    Object localObject2 = localObject3;
    try
    {
      long l = System.currentTimeMillis();
      Object localObject1 = localObject4;
      localObject2 = localObject3;
      if (InnerDns.b() != null)
      {
        localObject2 = localObject3;
        Uri localUri = Uri.parse(paramString);
        localObject1 = localObject4;
        localObject2 = localObject3;
        if (localUri.isHierarchical())
        {
          localObject2 = localObject3;
          String str = localUri.getQueryParameter("_sonic_xv");
          localObject1 = localObject4;
          localObject2 = localObject3;
          if (!TextUtils.isEmpty(str))
          {
            localObject1 = localObject4;
            localObject2 = localObject3;
            if (1L == (Long.parseLong(str) & 1L))
            {
              localObject2 = localObject3;
              if (localUri.getScheme().equalsIgnoreCase("https"))
              {
                localObject2 = localObject3;
                localObject1 = WebAccelerateHelper.getInstance().queryWebViewFeatureParams();
                if (localObject1 != null)
                {
                  localObject2 = localObject3;
                  if (1 == localObject1[10].intValue())
                  {
                    localObject2 = localObject3;
                    QLog.i("SonicSdkImpl_SonicRuntimeImpl", 1, "getHostDirectAddress(" + paramString + ") fail:SW_ENABLE_SONIC_HTTPS_DNS_PREFETCH is not enable!");
                    return null;
                  }
                }
              }
              localObject2 = localObject3;
              localObject1 = InnerDns.a().a(localUri.getHost(), 1013, false);
            }
          }
        }
      }
      localObject2 = localObject1;
      localObject3 = localObject1;
      if (QLog.isColorLevel())
      {
        localObject2 = localObject1;
        QLog.i("SonicSdkImpl_SonicRuntimeImpl", 2, "getHostDirectAddress(" + (String)localObject1 + "), cost " + (System.currentTimeMillis() - l) + " ms.");
        return localObject1;
      }
    }
    catch (Exception localException)
    {
      QLog.e("SonicSdkImpl_SonicRuntimeImpl", 1, "getHostDirectAddress error:" + localException.getMessage() + ", url=" + paramString);
      localObject3 = localObject2;
    }
    return localObject3;
  }
  
  public String getUserAgent()
  {
    return WebSoUtils.a();
  }
  
  public boolean isNetworkValid()
  {
    return NetworkUtil.a(BaseApplicationImpl.getContext()) != 0;
  }
  
  public boolean isSonicUrl(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    for (;;)
    {
      Object localObject1;
      try
      {
        long l = System.currentTimeMillis();
        localObject1 = WebAccelerateHelper.getInstance().queryWebViewFeatureParams();
        if (localObject1 != null)
        {
          int j = localObject1[8].intValue();
          i = j;
          if (-1 == j)
          {
            i = j;
            if (QbSdk.getTbsVersion(BaseApplicationImpl.sApplication.getApplicationContext()) != 0) {
              i = 1;
            }
          }
          if (QLog.isColorLevel()) {
            QLog.d("SonicSdkImpl_SonicRuntimeImpl", 2, "isSonicUrl:check sonic enable cost " + (System.currentTimeMillis() - l) + " ms.");
          }
          if (1 == i) {
            break label188;
          }
          QLog.e("SonicSdkImpl_SonicRuntimeImpl", 1, "isSonicUrl: dpc disable sonic, enableSonic = " + i);
          return false;
        }
      }
      catch (Throwable paramString)
      {
        QLog.e("SonicSdkImpl_SonicRuntimeImpl", 1, "isSonicUrl error:" + paramString.getMessage());
        return false;
      }
      if ((Build.VERSION.SDK_INT >= 24) && (QbSdk.getTbsVersion(BaseApplicationImpl.sApplication.getApplicationContext()) == 0))
      {
        i = -1;
        continue;
        label188:
        localObject1 = paramString.trim();
        Object localObject2 = SwiftWebViewUtils.a((String)localObject1);
        if ((!"http".equals(localObject2)) && (!"https".equals(localObject2))) {
          break;
        }
        localObject2 = Uri.parse((String)localObject1);
        if ((localObject2 == null) || (!((Uri)localObject2).isHierarchical()) || ((!"3".equals(((Uri)localObject2).getQueryParameter("asyncMode"))) && (!"1".equals(((Uri)localObject2).getQueryParameter("sonic"))))) {
          break;
        }
        localObject2 = ((Uri)localObject2).getHost();
        AuthorizeConfig localAuthorizeConfig = AuthorizeConfig.a();
        if ((((String)localObject2).endsWith(".vip.qq.com")) || (((String)localObject2).endsWith(".gamecenter.qq.com"))) {
          break label408;
        }
        if ((localAuthorizeConfig.b(paramString)) || (localAuthorizeConfig.c((String)localObject1)))
        {
          if (!QLog.isColorLevel()) {
            break label410;
          }
          QLog.d("SonicSdkImpl_SonicRuntimeImpl", 2, "isSonicUrl return true! " + Util.c((String)localObject1, new String[0]));
          break label410;
        }
        QLog.e("SonicSdkImpl_SonicRuntimeImpl", 1, "isSonicUrl return false! " + Util.c((String)localObject1, new String[0]));
        return false;
      }
      int i = 1;
    }
    label408:
    return true;
    label410:
    return true;
  }
  
  public void log(String paramString1, int paramInt, String paramString2)
  {
    if (3 == paramInt)
    {
      QLog.d(paramString1, 1, paramString2);
      return;
    }
    if (4 == paramInt)
    {
      QLog.i(paramString1, 1, paramString2);
      return;
    }
    if (5 == paramInt)
    {
      QLog.w(paramString1, 1, paramString2);
      return;
    }
    QLog.e(paramString1, 1, paramString2);
  }
  
  public void notifyError(SonicSessionClient paramSonicSessionClient, String paramString, int paramInt)
  {
    int j = NetworkUtil.a(BaseApplicationImpl.getContext());
    int i = j;
    if (j == 0) {
      i = -1;
    }
    VasWebviewUtil.doSonicErrorCodeReport("SonicReport", "SonicErrorCode", paramString, paramInt, i, 0, "", "");
  }
  
  public void postTaskToMainThread(Runnable paramRunnable, long paramLong)
  {
    ThreadManager.getUIHandler().postDelayed(paramRunnable, paramLong);
  }
  
  public void postTaskToThread(Runnable paramRunnable, long paramLong)
  {
    ThreadManager.getSubThreadHandler().postDelayed(paramRunnable, paramLong);
  }
  
  public boolean setCookie(String paramString, List paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      try
      {
        String[] arrayOfString = new String[paramList.size()];
        paramList.toArray(arrayOfString);
        paramList = new HashMap(1);
        paramList.put(paramString, arrayOfString);
        CookieManager.getInstance().setCookies(paramList);
        return true;
      }
      catch (Throwable paramString)
      {
        QLog.e("SonicSdkImpl_SonicRuntimeImpl", 1, "setCookies error:" + paramString.getMessage());
      }
    }
    return false;
  }
  
  public boolean shouldLog(int paramInt)
  {
    if ((paramInt == 6) || (paramInt == 4)) {
      return true;
    }
    return QLog.isColorLevel();
  }
  
  public void showToast(CharSequence paramCharSequence, int paramInt)
  {
    try
    {
      QQToast.a(BaseApplicationImpl.sApplication.getApplicationContext(), 1, paramCharSequence, 0).a();
      return;
    }
    catch (Exception paramCharSequence)
    {
      QLog.e("SonicSdkImpl_SonicRuntimeImpl", 1, "showToast exception e =", paramCharSequence);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.webview.sonic.SonicRuntimeImpl
 * JD-Core Version:    0.7.0.1
 */