package com.tencent.open.appcommon.now.download.js;

import aley;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.PublicFragmentActivityForTool;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.open.appcommon.js.BaseInterface;
import com.tencent.open.appcommon.now.download.DownloadCenterImpl;
import com.tencent.open.base.LogUtility;
import com.tencent.open.business.base.IJsCallBack;
import com.tencent.open.downloadnew.DownloadApi;
import com.tencent.open.downloadnew.DownloadConstants;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.open.downloadnew.UpdateManager;
import com.tencent.open.downloadnew.UpdateManager.OnCheckUpdateListener;
import com.tencent.smtt.sdk.WebView;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

public class DownloadWebInterface
  extends BaseInterface
  implements IJsCallBack
{
  public static final String PLUGIN_NAMESPACE = "q_download_now";
  public final String TAG = DownloadWebInterface.class.getSimpleName();
  protected String jsCallBackMethod = "";
  protected UpdateManager.OnCheckUpdateListener listener;
  protected Activity mActivity;
  protected Handler mHandler;
  public final WebView webview;
  
  public DownloadWebInterface(Activity paramActivity, WebView paramWebView)
  {
    LogUtility.c(this.TAG, "init in");
    this.mActivity = paramActivity;
    this.webview = paramWebView;
    this.mHandler = new Handler(Looper.getMainLooper());
    if ((paramActivity instanceof PublicFragmentActivityForTool)) {
      paramWebView = (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web");
    }
    for (;;)
    {
      DownloadManager.a().a(paramWebView);
      H5JSCallbackManager.a().a(this);
      LogUtility.c(this.TAG, "init out");
      return;
      paramWebView = localObject;
      if ((paramActivity instanceof BaseActivity)) {
        paramWebView = (AppInterface)((BaseActivity)paramActivity).getAppRuntime();
      }
    }
  }
  
  public static boolean changeIntToBoolean(int paramInt)
  {
    boolean bool = true;
    if (paramInt == 0) {
      bool = false;
    }
    while (paramInt != 1) {
      return bool;
    }
    return true;
  }
  
  public void destroy()
  {
    LogUtility.c(this.TAG, "destroy");
    H5JSCallbackManager.a().b(this);
    if (UpdateManager.a()) {
      UpdateManager.a().b(this.listener);
    }
    DownloadCenterImpl.a().b(DownloadCallbackWebImpl.a());
  }
  
  public int doDownloadAction(String paramString)
  {
    LogUtility.c("TIME-STATISTIC", "DownloadWebInterface--doDownloadAction");
    if (!hasRight()) {
      return -1;
    }
    Bundle localBundle = new Bundle();
    try
    {
      localJSONObject = new JSONObject(paramString);
      localBundle.putString(DownloadConstants.a, localJSONObject.optString("appid"));
      localBundle.putString(DownloadConstants.i, localJSONObject.optString("url"));
      localBundle.putString(DownloadConstants.e, localJSONObject.optString("packageName"));
      localBundle.putInt(DownloadConstants.j, localJSONObject.optInt("actionCode"));
      localBundle.putString(DownloadConstants.h, localJSONObject.optString("via"));
      localBundle.putString(DownloadConstants.k, localJSONObject.optString("appName"));
      localBundle.putBoolean(DownloadConstants.q, changeIntToBoolean(localJSONObject.optInt("showNetworkDialog")));
      localBundle.putString(DownloadConstants.C, localJSONObject.optString("iconUrl"));
      localBundle.putInt(DownloadConstants.G, localJSONObject.optInt("showNotification"));
      localBundle.putBoolean(DownloadConstants.I, changeIntToBoolean(localJSONObject.optInt("isAutoInstallBySdk")));
      localBundle.putString(DownloadConstants.H, localJSONObject.optString("extraData"));
      localBundle.putString(DownloadConstants.E, localJSONObject.optString("downloadStyle"));
      localBundle.putString(DownloadConstants.F, localJSONObject.optString("downloadSize"));
      localBundle.putString(DownloadConstants.o, localJSONObject.optString("wording"));
      if (localJSONObject.has("bolckNotify")) {
        localBundle.putBoolean(DownloadConstants.w, localJSONObject.optBoolean("bolckNotify"));
      }
      paramString = localJSONObject.optString(DownloadConstants.A);
      LogUtility.d(this.TAG, " feedChannel:" + paramString);
      if (TextUtils.isEmpty(paramString)) {
        break label856;
      }
      if (!paramString.startsWith("0;")) {
        break label745;
      }
    }
    catch (JSONException paramString)
    {
      JSONObject localJSONObject;
      boolean bool;
      LogUtility.c(this.TAG, "JSONException", paramString);
      return -1;
    }
    catch (NumberFormatException paramString)
    {
      for (;;)
      {
        LogUtility.c(this.TAG, "Exception", paramString);
        continue;
        paramString = null;
        continue;
        paramString = "";
        continue;
        paramString = "";
      }
    }
    LogUtility.d(this.TAG, " finalFeedChannel:" + paramString);
    localBundle.putString(DownloadConstants.A, paramString);
    localJSONObject.optString("via");
    localJSONObject.optString("appid");
    if (localJSONObject.optInt("actionCode") == 12)
    {
      bool = changeIntToBoolean(localJSONObject.optInt("updateType"));
      localBundle.putBoolean(DownloadConstants.n, bool);
      bool = localJSONObject.has("updateData");
      if (bool) {
        for (;;)
        {
          try
          {
            localObject = localJSONObject.optString("updateData");
            if (TextUtils.isEmpty((CharSequence)localObject)) {
              continue;
            }
            paramString = new ApkUpdateDetail();
          }
          catch (Exception paramString)
          {
            Object localObject;
            int i;
            int j;
            label745:
            paramString = null;
            continue;
          }
          try
          {
            localObject = new JSONObject((String)localObject);
            paramString.packageName = ((JSONObject)localObject).optString("packageName");
            paramString.newapksize = ((JSONObject)localObject).optInt("newapksize");
            paramString.patchsize = ((JSONObject)localObject).optInt("patchsize");
            paramString.updatemethod = ((JSONObject)localObject).optInt("updatemethod");
            paramString.versioncode = ((JSONObject)localObject).optInt("versioncode");
            paramString.versionname = ((JSONObject)localObject).optString("versionname");
            paramString.fileMd5 = ((JSONObject)localObject).optString("fileMd5");
            paramString.sigMd5 = ((JSONObject)localObject).optString("sigMd5");
            paramString.url = ((JSONObject)localObject).optString("url");
            i = localJSONObject.optInt("myAppConfig");
            localBundle.putString(DownloadConstants.b, localJSONObject.optString("myAppId"));
            localBundle.putString(DownloadConstants.c, localJSONObject.optString("apkId"));
            localBundle.putInt(DownloadConstants.d, localJSONObject.optInt("versionCode"));
            localBundle.putInt(DownloadConstants.m, localJSONObject.optInt("toPageType"));
            localBundle.putBoolean(DownloadConstants.f, changeIntToBoolean(localJSONObject.optInt("isAutoDownload")));
            localBundle.putBoolean(DownloadConstants.g, changeIntToBoolean(localJSONObject.optInt("isAutoInstall")));
            j = localJSONObject.optInt("sourceType");
            LogUtility.c(this.TAG, "doDownloadAction object " + localJSONObject.toString());
            DownloadJSApi.a(this.mActivity, localBundle, j, paramString, i);
            return 0;
          }
          catch (Exception localException)
          {
            continue;
          }
          paramString = paramString.split(";");
          if (paramString == null)
          {
            paramString = "";
            break;
          }
          if (paramString.length <= 0)
          {
            paramString = "";
            break;
          }
          localObject = paramString[0];
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            continue;
          }
          paramString = (String)localObject;
          if (!((String)localObject).equals("0")) {
            break;
          }
          continue;
          LogUtility.c(this.TAG, "enter doDownloadAction updateData json");
        }
      }
    }
  }
  
  public String getDownloadVersion()
  {
    return DownloadApi.a() + "";
  }
  
  public String getInterfaceName()
  {
    return "q_download_now";
  }
  
  public String getJsCallbackMethod()
  {
    return this.jsCallBackMethod;
  }
  
  public WebView getWebview()
  {
    return this.webview;
  }
  
  protected void jsCallBack(String paramString)
  {
    this.mHandler.post(new aley(this, paramString));
  }
  
  public void registerDownloadCallBackListener(String paramString)
  {
    LogUtility.c(this.TAG, "enter registerDownloadCallBackListener");
    this.jsCallBackMethod = paramString;
    DownloadCenterImpl.a().a(DownloadCallbackWebImpl.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.open.appcommon.now.download.js.DownloadWebInterface
 * JD-Core Version:    0.7.0.1
 */