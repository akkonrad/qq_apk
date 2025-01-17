package com.tencent.sonic.sdk;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.sonic.sdk.download.SonicDownloadCache;
import com.tencent.sonic.sdk.download.SonicDownloadEngine;
import java.io.File;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public abstract class SonicSession
  implements Handler.Callback
{
  public static final String CHROME_FILE_THREAD = "Chrome_FileThread";
  protected static final int CLIENT_MSG_NOTIFY_RESULT = 1;
  protected static final int CLIENT_MSG_ON_WEB_READY = 2;
  protected static final int COMMON_MSG_BEGIN = 0;
  protected static final int COMMON_MSG_END = 4;
  public static final String DATA_UPDATE_BUNDLE_PARAMS_DIFF = "_diff_data_";
  protected static final int FILE_THREAD_MSG_BEGIN = 0;
  protected static final int FILE_THREAD_SAVE_CACHE_ON_SERVER_CLOSE = 1;
  protected static final int FILE_THREAD_SAVE_CACHE_ON_SESSION_FINISHED = 2;
  public static final String OFFLINE_MODE_FALSE = "false";
  public static final String OFFLINE_MODE_HTTP = "http";
  public static final String OFFLINE_MODE_STORE = "store";
  public static final String OFFLINE_MODE_TRUE = "true";
  protected static final int RESOURCE_INTERCEPT_STATE_IN_FILE_THREAD = 1;
  protected static final int RESOURCE_INTERCEPT_STATE_IN_OTHER_THREAD = 2;
  protected static final int RESOURCE_INTERCEPT_STATE_NONE = 0;
  protected static final int SESSION_MSG_FORCE_DESTROY = 3;
  public static final int SONIC_RESULT_CODE_DATA_UPDATE = 200;
  public static final int SONIC_RESULT_CODE_FIRST_LOAD = 1000;
  public static final int SONIC_RESULT_CODE_HIT_CACHE = 304;
  public static final int SONIC_RESULT_CODE_TEMPLATE_CHANGE = 2000;
  public static final int SONIC_RESULT_CODE_UNKNOWN = -1;
  public static final String SONIC_URL_PARAM_PRELOAD = "_preload";
  public static final String SONIC_URL_PARAM_SESSION_ID = "_sonic_id";
  public static final int STATE_DESTROY = 3;
  public static final int STATE_NONE = 0;
  public static final int STATE_READY = 2;
  public static final int STATE_RUNNING = 1;
  public static final String TAG = "SonicSdk_SonicSession";
  public static final String WEB_RESPONSE_CODE = "code";
  public static final String WEB_RESPONSE_DATA = "result";
  public static final String WEB_RESPONSE_EXTRA = "extra";
  public static final String WEB_RESPONSE_LAST_IS_RED_PRELOAD = "isPreload";
  public static final String WEB_RESPONSE_LOCAL_REFRESH_TIME = "local_refresh_time";
  public static final String WEB_RESPONSE_SRC_CODE = "srcCode";
  protected static long sNextSessionLogId = new Random().nextInt(263167);
  protected final AtomicBoolean clientIsReady = new AtomicBoolean(false);
  protected final AtomicBoolean clientIsReload = new AtomicBoolean(false);
  public final SonicSessionConfig config;
  public long createdTime;
  public String currUrl;
  protected SonicDiffDataCallback diffDataCallback;
  protected final Handler fileHandler;
  protected int finalResultCode = -1;
  public final String id;
  protected final Intent intent = new Intent();
  protected boolean isPreload;
  private boolean isRedPointPreload;
  protected final AtomicBoolean isWaitingForDestroy = new AtomicBoolean(false);
  protected final AtomicBoolean isWaitingForSaveFile = new AtomicBoolean(false);
  protected final AtomicBoolean isWaitingForSessionThread = new AtomicBoolean(false);
  private long lastDateUpdateTime;
  private boolean lastIsRedPointPreload;
  protected final Handler mainHandler = new Handler(Looper.getMainLooper(), this);
  protected String pendingDiffData = "";
  protected volatile InputStream pendingWebResourceStream;
  protected List<String> preloadLinks;
  protected volatile SonicDownloadEngine resourceDownloaderEngine;
  protected final AtomicInteger resourceInterceptState = new AtomicInteger(0);
  public final long sId;
  protected volatile SonicServer server;
  protected final CopyOnWriteArrayList<WeakReference<SonicSessionCallback>> sessionCallbackList = new CopyOnWriteArrayList();
  protected volatile SonicSessionClient sessionClient;
  protected final AtomicInteger sessionState = new AtomicInteger(0);
  protected int srcResultCode = -1;
  public String srcUrl;
  protected final CopyOnWriteArrayList<WeakReference<Callback>> stateChangedCallbackList = new CopyOnWriteArrayList();
  protected SonicSessionStatistics statistics = new SonicSessionStatistics();
  protected final AtomicBoolean wasInterceptInvoked = new AtomicBoolean(false);
  private final AtomicBoolean wasNotified = new AtomicBoolean(false);
  protected final AtomicBoolean wasOnPageFinishInvoked = new AtomicBoolean(false);
  
  SonicSession(String paramString1, String paramString2, SonicSessionConfig paramSonicSessionConfig)
  {
    this.id = paramString1;
    this.config = paramSonicSessionConfig;
    long l = sNextSessionLogId;
    sNextSessionLogId = 1L + l;
    this.sId = l;
    this.statistics.srcUrl = paramString2.trim();
    this.srcUrl = SonicUtils.addSonicUrlParam(this.statistics.srcUrl, "_sonic_id", String.valueOf(this.sId));
    this.currUrl = this.srcUrl;
    this.createdTime = System.currentTimeMillis();
    this.isRedPointPreload = isRedPointPreload();
    this.fileHandler = new Handler(SonicEngine.getInstance().getRuntime().getFileThreadLooper(), new Handler.Callback()
    {
      public boolean handleMessage(Message paramAnonymousMessage)
      {
        switch (paramAnonymousMessage.what)
        {
        default: 
          return false;
        case 1: 
          paramAnonymousMessage = (SonicServer)paramAnonymousMessage.obj;
          SonicSession.this.saveSonicCacheOnServerClose(paramAnonymousMessage);
          return true;
        }
        paramAnonymousMessage = (String)paramAnonymousMessage.obj;
        SonicSession.this.doSaveSonicCache(SonicSession.this.server, paramAnonymousMessage);
        return true;
      }
    });
    if (SonicEngine.getInstance().getConfig().GET_COOKIE_WHEN_SESSION_CREATE)
    {
      paramSonicSessionConfig = SonicEngine.getInstance().getRuntime().getCookie(this.srcUrl);
      if (!TextUtils.isEmpty(paramSonicSessionConfig)) {
        this.intent.putExtra("Cookie", paramSonicSessionConfig);
      }
    }
    if (SonicUtils.shouldLog(4)) {
      SonicUtils.log("SonicSdk_SonicSession", 4, "session(" + this.sId + ") create:id=" + paramString1 + ", url = " + paramString2 + ".");
    }
  }
  
  private void checkAndClearCacheData()
  {
    SonicEngine.getInstance().getRuntime().postTaskToThread(new Runnable()
    {
      public void run()
      {
        if (SonicUtils.shouldClearCache(SonicEngine.getInstance().getConfig().SONIC_CACHE_CHECK_TIME_INTERVAL))
        {
          SonicEngine.getInstance().trimSonicCache();
          SonicUtils.saveClearCacheTime(System.currentTimeMillis());
        }
      }
    }, 50L);
  }
  
  @Nullable
  private SonicDataHelper.SessionData getSessionData(boolean paramBoolean)
  {
    if (paramBoolean) {
      return SonicDataHelper.getSessionData(this.id);
    }
    if (this.server != null)
    {
      SonicDataHelper.SessionData localSessionData = new SonicDataHelper.SessionData();
      localSessionData.eTag = this.server.getResponseHeaderField("eTag");
      localSessionData.templateTag = this.server.getResponseHeaderField("template-tag");
      if (((TextUtils.isEmpty(localSessionData.eTag)) || (TextUtils.isEmpty(localSessionData.templateTag))) && (this.config.SUPPORT_LOCAL_SERVER))
      {
        this.server.separateTemplateAndData();
        localSessionData.eTag = this.server.getResponseHeaderField("eTag");
        localSessionData.templateTag = this.server.getResponseHeaderField("template-tag");
      }
      localSessionData.sessionId = this.id;
      return localSessionData;
    }
    SonicUtils.log("SonicSdk_SonicSession", 6, "session(" + this.sId + ") runSonicFlow error:server is not valid!");
    return new SonicDataHelper.SessionData();
  }
  
  private void handleFlow_PreloadSubResource()
  {
    if ((this.preloadLinks == null) || (this.preloadLinks.isEmpty())) {
      return;
    }
    SonicEngine.getInstance().getRuntime().postTaskToThread(new Runnable()
    {
      public void run()
      {
        if (SonicSession.this.resourceDownloaderEngine == null) {
          SonicSession.this.resourceDownloaderEngine = new SonicDownloadEngine(SonicDownloadCache.getSubResourceCache());
        }
        SonicSession.this.resourceDownloaderEngine.addSubResourcePreloadTask(SonicSession.this.preloadLinks);
      }
    }, 0L);
  }
  
  private boolean isRedPointPreload()
  {
    Uri localUri = Uri.parse(this.srcUrl);
    this.isRedPointPreload = false;
    if ((localUri != null) && (localUri.isHierarchical())) {
      this.isRedPointPreload = "1".equals(localUri.getQueryParameter("_sonic_rp"));
    }
    return this.isRedPointPreload;
  }
  
  private void runSonicFlow(boolean paramBoolean)
  {
    if (1 != this.sessionState.get())
    {
      SonicUtils.log("SonicSdk_SonicSession", 6, "session(" + this.sId + ") runSonicFlow error:sessionState=" + this.sessionState.get() + ".");
      return;
    }
    this.statistics.sonicFlowStartTime = System.currentTimeMillis();
    Object localObject = null;
    SonicDataHelper.SessionData localSessionData = getSessionData(paramBoolean);
    if (paramBoolean)
    {
      localObject = SonicCacheInterceptor.getSonicCacheData(this);
      this.statistics.cacheVerifyTime = System.currentTimeMillis();
      SonicUtils.log("SonicSdk_SonicSession", 4, "session(" + this.sId + ") runSonicFlow verify cache cost " + (this.statistics.cacheVerifyTime - this.statistics.sonicFlowStartTime) + " ms");
      handleFlow_LoadLocalCache((String)localObject);
    }
    if ((!TextUtils.isEmpty((CharSequence)localObject)) || (!paramBoolean))
    {
      paramBoolean = true;
      label178:
      localObject = SonicEngine.getInstance().getRuntime();
      if (((SonicRuntime)localObject).isNetworkValid()) {
        break label325;
      }
      if ((paramBoolean) && (!TextUtils.isEmpty(this.config.USE_SONIC_CACHE_IN_BAD_NETWORK_TOAST))) {
        ((SonicRuntime)localObject).postTaskToMainThread(new Runnable()
        {
          public void run()
          {
            if ((SonicSession.this.clientIsReady.get()) && (!SonicSession.this.isDestroyedOrWaitingForDestroy())) {
              this.val$runtime.showToast(SonicSession.this.config.USE_SONIC_CACHE_IN_BAD_NETWORK_TOAST, 1);
            }
          }
        }, 1500L);
      }
      SonicUtils.log("SonicSdk_SonicSession", 6, "session(" + this.sId + ") runSonicFlow error:network is not valid!");
    }
    for (;;)
    {
      switchState(1, 2, true);
      this.isWaitingForSessionThread.set(false);
      if (!postForceDestroyIfNeed()) {
        break;
      }
      SonicUtils.log("SonicSdk_SonicSession", 4, "session(" + this.sId + ") runSonicFlow:send force destroy message.");
      return;
      paramBoolean = false;
      break label178;
      label325:
      handleFlow_Connection(paramBoolean, localSessionData);
      this.statistics.connectionFlowFinishTime = System.currentTimeMillis();
    }
  }
  
  private void saveSonicCacheOnServerClose(SonicServer paramSonicServer)
  {
    boolean bool = false;
    if (isDestroyedOrWaitingForDestroy())
    {
      localObject = new StringBuilder().append("session(").append(this.sId).append(") doSaveSonicCache: save session files fail. Current session is destroy (").append(isDestroyedOrWaitingForDestroy()).append(") or refresh ( ");
      if (paramSonicServer != this.server) {
        bool = true;
      }
      SonicUtils.log("SonicSdk_SonicSession", 6, bool + ")");
      return;
    }
    Object localObject = paramSonicServer.getResponseData(false);
    StringBuilder localStringBuilder;
    if (SonicUtils.shouldLog(3))
    {
      localStringBuilder = new StringBuilder().append("session(").append(this.sId).append(") onClose:htmlString size:");
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label275;
      }
    }
    label275:
    for (int i = ((String)localObject).length();; i = 0)
    {
      SonicUtils.log("SonicSdk_SonicSession", 3, i);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        long l = System.currentTimeMillis();
        doSaveSonicCache(paramSonicServer, (String)localObject);
        SonicUtils.log("SonicSdk_SonicSession", 4, "session(" + this.sId + ") onClose:separate And save ache finish, cost " + (System.currentTimeMillis() - l) + " ms.");
      }
      this.isWaitingForSaveFile.set(false);
      if (!postForceDestroyIfNeed()) {
        break;
      }
      SonicUtils.log("SonicSdk_SonicSession", 4, "session(" + this.sId + ") onClose: postForceDestroyIfNeed send destroy message.");
      return;
    }
  }
  
  public boolean addSessionCallback(SonicSessionCallback paramSonicSessionCallback)
  {
    return this.sessionCallbackList.add(new WeakReference(paramSonicSessionCallback));
  }
  
  protected boolean addSessionStateChangedCallback(Callback paramCallback)
  {
    return this.stateChangedCallbackList.add(new WeakReference(paramCallback));
  }
  
  public boolean bindClient(SonicSessionClient paramSonicSessionClient)
  {
    if (this.sessionClient == null)
    {
      this.sessionClient = paramSonicSessionClient;
      paramSonicSessionClient.bindSession(this);
      SonicUtils.log("SonicSdk_SonicSession", 4, "session(" + this.sId + ") bind client.");
      return true;
    }
    return false;
  }
  
  protected boolean canDestroy()
  {
    if ((this.isWaitingForSessionThread.get()) || (this.isWaitingForSaveFile.get()))
    {
      SonicUtils.log("SonicSdk_SonicSession", 4, "session(" + this.sId + ") canDestroy:false, isWaitingForSessionThread=" + this.isWaitingForDestroy.get() + ", isWaitingForSaveFile=" + this.isWaitingForSaveFile.get());
      return false;
    }
    return true;
  }
  
  protected void clearSessionData() {}
  
  protected Intent createConnectionIntent(SonicDataHelper.SessionData paramSessionData)
  {
    boolean bool = true;
    Intent localIntent = new Intent();
    SonicUtils.log("SonicSdk_SonicSession", 4, String.format("Session (%s) send sonic request, etag=(%s), templateTag=(%s)", new Object[] { this.id, paramSessionData.eTag, paramSessionData.templateTag }));
    localIntent.putExtra("eTag", paramSessionData.eTag);
    localIntent.putExtra("template-tag", paramSessionData.templateTag);
    String str = SonicEngine.getInstance().getRuntime().getHostDirectAddress(this.srcUrl);
    if (!TextUtils.isEmpty(str))
    {
      localIntent.putExtra("dns-prefetch-address", str);
      this.statistics.isDirectAddress = true;
    }
    if (paramSessionData.isRedPointPreload == 1)
    {
      this.lastIsRedPointPreload = bool;
      this.lastDateUpdateTime = paramSessionData.templateUpdateTime;
      paramSessionData = SonicEngine.getInstance().getRuntime();
      if (SonicEngine.getInstance().getConfig().GET_COOKIE_WHEN_SESSION_CREATE) {
        break label229;
      }
      str = paramSessionData.getCookie(this.srcUrl);
      if (!TextUtils.isEmpty(str)) {
        localIntent.putExtra("Cookie", str);
      }
      label180:
      paramSessionData = paramSessionData.getUserAgent();
      if (TextUtils.isEmpty(paramSessionData)) {
        break label250;
      }
    }
    label229:
    label250:
    for (paramSessionData = paramSessionData + " Sonic/2.0.0";; paramSessionData = "Sonic/2.0.0")
    {
      localIntent.putExtra("User-Agent", paramSessionData);
      return localIntent;
      bool = false;
      break;
      localIntent.putExtra("Cookie", this.intent.getStringExtra("Cookie"));
      break label180;
    }
  }
  
  public void destroy()
  {
    destroy(false);
  }
  
  protected void destroy(boolean paramBoolean)
  {
    int i = this.sessionState.get();
    if (3 != i)
    {
      if (this.sessionClient != null) {
        this.sessionClient = null;
      }
      if (this.pendingWebResourceStream != null) {}
      try
      {
        this.pendingWebResourceStream.close();
        this.pendingWebResourceStream = null;
        if (this.pendingDiffData != null) {
          this.pendingDiffData = null;
        }
        clearSessionData();
        checkAndClearCacheData();
        if ((paramBoolean) || (canDestroy()))
        {
          this.sessionState.set(3);
          SonicSessionCallback localSonicSessionCallback;
          SonicUtils.log("SonicSdk_SonicSession", 4, "session(" + this.sId + ") final destroy, force=" + paramBoolean + ".");
        }
      }
      catch (Throwable localThrowable)
      {
        synchronized (this.sessionState)
        {
          this.sessionState.notify();
          if ((this.server != null) && (!paramBoolean))
          {
            this.server.disconnect();
            this.server = null;
          }
          notifyStateChange(i, 3, null);
          this.mainHandler.removeMessages(3);
          this.stateChangedCallbackList.clear();
          this.isWaitingForDestroy.set(false);
          ??? = this.sessionCallbackList.iterator();
          while (((Iterator)???).hasNext())
          {
            localSonicSessionCallback = (SonicSessionCallback)((WeakReference)((Iterator)???).next()).get();
            if (localSonicSessionCallback != null)
            {
              localSonicSessionCallback.onSessionDestroy();
              continue;
              localThrowable = localThrowable;
              SonicUtils.log("SonicSdk_SonicSession", 6, "pendingWebResourceStream.close error:" + localThrowable.getMessage());
            }
          }
        }
      }
    }
    while (!this.isWaitingForDestroy.compareAndSet(false, true)) {
      return;
    }
    this.mainHandler.sendEmptyMessageDelayed(3, 6000L);
    SonicUtils.log("SonicSdk_SonicSession", 4, "session(" + this.sId + ") waiting for destroy, current state =" + i + ".");
  }
  
  protected void doSaveSonicCache(SonicServer paramSonicServer, String paramString)
  {
    if ((isDestroyedOrWaitingForDestroy()) || (this.server == null))
    {
      SonicUtils.log("SonicSdk_SonicSession", 6, "session(" + this.sId + ") doSaveSonicCache: save session files fail. Current session is destroy!");
      return;
    }
    long l1 = System.currentTimeMillis();
    String str3 = paramSonicServer.getTemplate();
    String str4 = paramSonicServer.getUpdatedData();
    if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty(str3)))
    {
      String str2 = paramSonicServer.getResponseHeaderField("sonic-html-sha1");
      String str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = SonicUtils.getSHA1(paramString);
      }
      str2 = paramSonicServer.getResponseHeaderField("eTag");
      String str5 = paramSonicServer.getResponseHeaderField("template-tag");
      paramSonicServer = paramSonicServer.getResponseHeaderFields();
      Iterator localIterator = this.sessionCallbackList.iterator();
      while (localIterator.hasNext())
      {
        SonicSessionCallback localSonicSessionCallback = (SonicSessionCallback)((WeakReference)localIterator.next()).get();
        if (localSonicSessionCallback != null) {
          localSonicSessionCallback.onSessionSaveCache(paramString, str3, str4);
        }
      }
      if (SonicUtils.saveSessionFiles(this.id, paramString, str3, str4, paramSonicServer))
      {
        long l2 = new File(SonicFileUtils.getSonicHtmlPath(this.id)).length();
        SonicUtils.saveSonicData(this.id, str2, str5, str1, l2, this.isRedPointPreload, paramSonicServer);
      }
    }
    for (;;)
    {
      SonicUtils.log("SonicSdk_SonicSession", 4, "session(" + this.sId + ") doSaveSonicCache: finish, cost " + (System.currentTimeMillis() - l1) + "ms.");
      return;
      SonicUtils.log("SonicSdk_SonicSession", 6, "session(" + this.sId + ") doSaveSonicCache: save session files fail.");
      SonicEngine.getInstance().getRuntime().notifyError(this.sessionClient, this.srcUrl, -1004);
      continue;
      SonicUtils.log("SonicSdk_SonicSession", 6, "session(" + this.sId + ") doSaveSonicCache: save separate template and data files fail.");
      SonicEngine.getInstance().getRuntime().notifyError(this.sessionClient, this.srcUrl, -1005);
    }
  }
  
  protected HashMap<String, String> getCacheHeaders()
  {
    return SonicUtils.getFilteredHeaders(SonicFileUtils.getHeaderFromLocalCache(SonicFileUtils.getSonicHeaderPath(this.id)));
  }
  
  protected String getCharsetFromHeaders()
  {
    return getCharsetFromHeaders(getHeaders());
  }
  
  public String getCharsetFromHeaders(Map<String, String> paramMap)
  {
    String str2 = SonicUtils.DEFAULT_CHARSET;
    String str3 = "Content-Type".toLowerCase();
    String str1 = str2;
    if (paramMap != null)
    {
      str1 = str2;
      if (paramMap.containsKey(str3))
      {
        paramMap = (String)paramMap.get(str3);
        str1 = str2;
        if (!TextUtils.isEmpty(paramMap)) {
          str1 = SonicUtils.getCharset(paramMap);
        }
      }
    }
    return str1;
  }
  
  public String getCurrentUrl()
  {
    return this.srcUrl;
  }
  
  public int getFinalResultCode()
  {
    return this.finalResultCode;
  }
  
  protected HashMap<String, String> getHeaders()
  {
    if (this.server != null) {
      return SonicUtils.getFilteredHeaders(this.server.getResponseHeaderFields());
    }
    return null;
  }
  
  public SonicSessionClient getSessionClient()
  {
    return this.sessionClient;
  }
  
  public int getSrcResultCode()
  {
    return this.srcResultCode;
  }
  
  public SonicSessionStatistics getStatistics()
  {
    return this.statistics;
  }
  
  protected void handleFlow_Connection(boolean paramBoolean, SonicDataHelper.SessionData paramSessionData)
  {
    this.statistics.connectionFlowStartTime = System.currentTimeMillis();
    if ((this.config.SUPPORT_CACHE_CONTROL) && (this.statistics.connectionFlowStartTime < paramSessionData.expiredTime))
    {
      if (SonicUtils.shouldLog(3)) {
        SonicUtils.log("SonicSdk_SonicSession", 3, "session(" + this.sId + ") won't send any request in " + (paramSessionData.expiredTime - this.statistics.connectionFlowStartTime) + ".ms");
      }
      paramSessionData = this.sessionCallbackList.iterator();
    }
    int i;
    long l1;
    while (paramSessionData.hasNext())
    {
      localObject = (SonicSessionCallback)((WeakReference)paramSessionData.next()).get();
      if (localObject != null)
      {
        ((SonicSessionCallback)localObject).onSessionHitCache();
        continue;
        this.server = new SonicServer(this, createConnectionIntent(paramSessionData));
        int j = this.server.connect();
        i = j;
        if (j == 0)
        {
          j = this.server.getResponseCode();
          l1 = System.currentTimeMillis();
          paramSessionData = this.server.getResponseHeaderFields();
          if (SonicUtils.shouldLog(3)) {
            SonicUtils.log("SonicSdk_SonicSession", 3, "session(" + this.sId + ") connection get header fields cost = " + (System.currentTimeMillis() - l1) + " ms.");
          }
          l1 = System.currentTimeMillis();
          setCookiesFromHeaders(paramSessionData, shouldSetCookieAsynchronous());
          i = j;
          if (SonicUtils.shouldLog(3))
          {
            SonicUtils.log("SonicSdk_SonicSession", 3, "session(" + this.sId + ") connection set cookies cost = " + (System.currentTimeMillis() - l1) + " ms.");
            i = j;
          }
        }
        SonicUtils.log("SonicSdk_SonicSession", 4, "session(" + this.sId + ") handleFlow_Connection: respCode = " + i + ", cost " + (System.currentTimeMillis() - this.statistics.connectionFlowStartTime) + " ms.");
        if (!isDestroyedOrWaitingForDestroy()) {
          break label447;
        }
        SonicUtils.log("SonicSdk_SonicSession", 6, "session(" + this.sId + ") handleFlow_Connection error: destroy before server response!");
      }
    }
    for (;;)
    {
      return;
      label447:
      paramSessionData = this.server.getResponseHeaderField("sonic-link");
      if (!TextUtils.isEmpty(paramSessionData))
      {
        this.preloadLinks = Arrays.asList(paramSessionData.split(";"));
        handleFlow_PreloadSubResource();
      }
      if (304 == i)
      {
        SonicUtils.log("SonicSdk_SonicSession", 4, "session(" + this.sId + ") handleFlow_Connection: Server response is not modified.");
        handleFlow_NotModified();
        return;
      }
      if (200 != i)
      {
        handleFlow_HttpError(i);
        SonicEngine.getInstance().getRuntime().notifyError(this.sessionClient, this.srcUrl, i);
        SonicUtils.log("SonicSdk_SonicSession", 6, "session(" + this.sId + ") handleFlow_Connection error: response code(" + i + ") is not OK!");
        return;
      }
      paramSessionData = this.server.getResponseHeaderField("cache-offline");
      SonicUtils.log("SonicSdk_SonicSession", 4, "session(" + this.sId + ") handleFlow_Connection: cacheOffline is " + paramSessionData + ".");
      if (!"http".equalsIgnoreCase(paramSessionData)) {
        break;
      }
      if (paramBoolean) {
        handleFlow_ServiceUnavailable();
      }
      l1 = System.currentTimeMillis();
      long l2 = SonicEngine.getInstance().getConfig().SONIC_UNAVAILABLE_TIME;
      SonicDataHelper.setSonicUnavailableTime(this.id, l1 + l2);
      paramSessionData = this.sessionCallbackList.iterator();
      while (paramSessionData.hasNext())
      {
        localObject = (SonicSessionCallback)((WeakReference)paramSessionData.next()).get();
        if (localObject != null) {
          ((SonicSessionCallback)localObject).onSessionUnAvailable();
        }
      }
    }
    if (!paramBoolean)
    {
      handleFlow_FirstLoad();
      return;
    }
    if ((TextUtils.isEmpty(paramSessionData)) || ("false".equalsIgnoreCase(paramSessionData)))
    {
      SonicUtils.log("SonicSdk_SonicSession", 6, "session(" + this.sId + ") handleFlow_Connection error: Cache-Offline is empty or false!");
      SonicUtils.removeSessionCache(this.id);
      return;
    }
    paramSessionData = this.server.getResponseHeaderField("eTag");
    Object localObject = this.server.getResponseHeaderField("template-change");
    if ((TextUtils.isEmpty(paramSessionData)) || (TextUtils.isEmpty((CharSequence)localObject)))
    {
      SonicUtils.log("SonicSdk_SonicSession", 6, "session(" + this.sId + ") handleFlow_Connection error: eTag is ( " + paramSessionData + " ) , templateChange is ( " + (String)localObject + " )!");
      SonicUtils.removeSessionCache(this.id);
      return;
    }
    if (("false".equals(localObject)) || ("0".equals(localObject)))
    {
      handleFlow_DataUpdate(this.server.getUpdatedData());
      return;
    }
    handleFlow_TemplateChange(this.server.getResponseData(this.clientIsReload.get()));
  }
  
  protected abstract void handleFlow_DataUpdate(String paramString);
  
  protected abstract void handleFlow_FirstLoad();
  
  protected abstract void handleFlow_HttpError(int paramInt);
  
  protected abstract void handleFlow_LoadLocalCache(String paramString);
  
  protected void handleFlow_NotModified()
  {
    Object localObject = this.mainHandler.obtainMessage(1);
    ((Message)localObject).arg1 = 304;
    ((Message)localObject).arg2 = 304;
    this.mainHandler.sendMessage((Message)localObject);
    localObject = this.sessionCallbackList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      SonicSessionCallback localSonicSessionCallback = (SonicSessionCallback)((WeakReference)((Iterator)localObject).next()).get();
      if (localSonicSessionCallback != null) {
        localSonicSessionCallback.onSessionHitCache();
      }
    }
  }
  
  protected abstract void handleFlow_ServiceUnavailable();
  
  protected abstract void handleFlow_TemplateChange(String paramString);
  
  public boolean handleMessage(Message paramMessage)
  {
    if (3 == paramMessage.what)
    {
      destroy(true);
      SonicUtils.log("SonicSdk_SonicSession", 4, "session(" + this.sId + ") handleMessage:force destroy.");
      return true;
    }
    if (isDestroyedOrWaitingForDestroy())
    {
      SonicUtils.log("SonicSdk_SonicSession", 6, "session(" + this.sId + ") handleMessage error: is destroyed or waiting for destroy.");
      return true;
    }
    if (SonicUtils.shouldLog(3)) {
      SonicUtils.log("SonicSdk_SonicSession", 3, "session(" + this.sId + ") handleMessage: msg what = " + paramMessage.what + ".");
    }
    return false;
  }
  
  public boolean isDestroyedOrWaitingForDestroy()
  {
    return (3 == this.sessionState.get()) || (this.isWaitingForDestroy.get());
  }
  
  public boolean isMatchCurrentUrl(String paramString)
  {
    try
    {
      Uri localUri = Uri.parse(this.srcUrl);
      paramString = Uri.parse(paramString);
      Object localObject = localUri.getHost() + localUri.getPath();
      String str = paramString.getHost() + paramString.getPath();
      if (localUri.getHost().equalsIgnoreCase(paramString.getHost()))
      {
        paramString = (String)localObject;
        if (!((String)localObject).endsWith("/")) {
          paramString = (String)localObject + "/";
        }
        localObject = str;
        if (!str.endsWith("/")) {
          localObject = str + "/";
        }
        boolean bool = paramString.equalsIgnoreCase((String)localObject);
        return bool;
      }
    }
    catch (Throwable paramString)
    {
      SonicUtils.log("SonicSdk_SonicSession", 6, "isMatchCurrentUrl error:" + paramString.getMessage());
    }
    return false;
  }
  
  public boolean isPreload()
  {
    return this.isPreload;
  }
  
  protected void notifyStateChange(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    Iterator localIterator = this.stateChangedCallbackList.iterator();
    while (localIterator.hasNext())
    {
      Callback localCallback = (Callback)((WeakReference)localIterator.next()).get();
      if (localCallback != null) {
        localCallback.onSessionStateChange(this, paramInt1, paramInt2, paramBundle);
      }
    }
  }
  
  public boolean onClientPageFinished(String paramString)
  {
    if (isMatchCurrentUrl(paramString))
    {
      SonicUtils.log("SonicSdk_SonicSession", 4, "session(" + this.sId + ") onClientPageFinished:url=" + paramString + ".");
      this.wasOnPageFinishInvoked.set(true);
      return true;
    }
    return false;
  }
  
  public boolean onClientReady()
  {
    return false;
  }
  
  public final Object onClientRequestResource(String paramString)
  {
    String str = Thread.currentThread().getName();
    if ("Chrome_FileThread".equals(str))
    {
      this.resourceInterceptState.set(1);
      if (!isMatchCurrentUrl(paramString)) {
        break label98;
      }
      paramString = onRequestResource(paramString);
    }
    for (;;)
    {
      this.resourceInterceptState.set(0);
      return paramString;
      this.resourceInterceptState.set(2);
      if (!SonicUtils.shouldLog(3)) {
        break;
      }
      SonicUtils.log("SonicSdk_SonicSession", 3, "onClientRequestResource called in " + str + ".");
      break;
      label98:
      if (this.resourceDownloaderEngine != null) {
        paramString = this.resourceDownloaderEngine.onRequestSubResource(paramString, this);
      } else {
        paramString = null;
      }
    }
  }
  
  protected Object onRequestResource(String paramString)
  {
    return null;
  }
  
  public void onServerClosed(SonicServer paramSonicServer, boolean paramBoolean)
  {
    if (isDestroyedOrWaitingForDestroy()) {
      return;
    }
    if (this.pendingWebResourceStream != null) {
      this.pendingWebResourceStream = null;
    }
    this.isWaitingForSaveFile.set(true);
    long l = System.currentTimeMillis();
    if (paramBoolean)
    {
      Object localObject = paramSonicServer.getResponseHeaderField("cache-offline");
      if (SonicUtils.needSaveData(this.config.SUPPORT_CACHE_CONTROL, (String)localObject, paramSonicServer.getResponseHeaderFields()))
      {
        SonicUtils.log("SonicSdk_SonicSession", 4, "session(" + this.sId + ") onClose:offline->" + (String)localObject + " , post separateAndSaveCache task.");
        localObject = Message.obtain();
        ((Message)localObject).what = 1;
        ((Message)localObject).obj = paramSonicServer;
        this.fileHandler.sendMessageDelayed((Message)localObject, 1500L);
        return;
      }
      SonicUtils.log("SonicSdk_SonicSession", 4, "session(" + this.sId + ") onClose:offline->" + (String)localObject + " , so do not need cache to file.");
    }
    for (;;)
    {
      this.isWaitingForSaveFile.set(false);
      if (postForceDestroyIfNeed()) {
        SonicUtils.log("SonicSdk_SonicSession", 4, "session(" + this.sId + ") onClose: postForceDestroyIfNeed send destroy message in chromium_io thread.");
      }
      if (!SonicUtils.shouldLog(3)) {
        break;
      }
      SonicUtils.log("SonicSdk_SonicSession", 6, "session(" + this.sId + ") onClose cost " + (System.currentTimeMillis() - l) + " ms.");
      return;
      SonicUtils.log("SonicSdk_SonicSession", 6, "session(" + this.sId + ") onClose error:readComplete = false!");
    }
  }
  
  public boolean onWebReady(SonicDiffDataCallback paramSonicDiffDataCallback)
  {
    return false;
  }
  
  protected boolean postForceDestroyIfNeed()
  {
    if ((this.isWaitingForDestroy.get()) && (canDestroy()))
    {
      this.mainHandler.sendEmptyMessage(3);
      return true;
    }
    return false;
  }
  
  protected void postTaskToSaveSonicCache(String paramString)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 2;
    localMessage.obj = paramString;
    this.fileHandler.sendMessageDelayed(localMessage, 1500L);
  }
  
  public boolean refresh()
  {
    if (!this.sessionState.compareAndSet(2, 1))
    {
      SonicUtils.log("SonicSdk_SonicSession", 6, "session(" + this.sId + ") refresh error:sessionState=" + this.sessionState.get() + ".");
      return false;
    }
    this.wasInterceptInvoked.set(false);
    this.clientIsReload.set(true);
    this.finalResultCode = -1;
    this.srcResultCode = -1;
    SonicUtils.log("SonicSdk_SonicSession", 4, "session(" + this.sId + ") now refresh sonic flow task.");
    this.statistics.sonicStartTime = System.currentTimeMillis();
    Iterator localIterator = this.sessionCallbackList.iterator();
    while (localIterator.hasNext())
    {
      SonicSessionCallback localSonicSessionCallback = (SonicSessionCallback)((WeakReference)localIterator.next()).get();
      if (localSonicSessionCallback != null) {
        localSonicSessionCallback.onSonicSessionRefresh();
      }
    }
    this.isWaitingForSessionThread.set(true);
    SonicEngine.getInstance().getRuntime().postTaskToSessionThread(new Runnable()
    {
      public void run()
      {
        SonicSession.this.runSonicFlow(false);
      }
    });
    notifyStateChange(2, 1, null);
    return true;
  }
  
  public boolean removeSessionCallback(SonicSessionCallback paramSonicSessionCallback)
  {
    Object localObject2 = null;
    Iterator localIterator = this.sessionCallbackList.iterator();
    Object localObject1;
    do
    {
      localObject1 = localObject2;
      if (!localIterator.hasNext()) {
        break;
      }
      localObject1 = (WeakReference)localIterator.next();
    } while ((localObject1 == null) || (((WeakReference)localObject1).get() != paramSonicSessionCallback));
    if (localObject1 != null) {
      return this.sessionCallbackList.remove(localObject1);
    }
    return false;
  }
  
  protected boolean removeSessionStateChangedCallback(Callback paramCallback)
  {
    return this.stateChangedCallbackList.remove(new WeakReference(paramCallback));
  }
  
  protected boolean setCookiesFromHeaders(final Map<String, List<String>> paramMap, boolean paramBoolean)
  {
    if (paramMap != null)
    {
      paramMap = (List)paramMap.get("Set-Cookie".toLowerCase());
      if ((paramMap != null) && (paramMap.size() != 0))
      {
        if (!paramBoolean) {
          return SonicEngine.getInstance().getRuntime().setCookie(getCurrentUrl(), paramMap);
        }
        SonicUtils.log("SonicSdk_SonicSession", 4, "setCookiesFromHeaders asynchronous in new thread.");
        SonicEngine.getInstance().getRuntime().postTaskToThread(new Runnable()
        {
          public void run()
          {
            SonicEngine.getInstance().getRuntime().setCookie(SonicSession.this.getCurrentUrl(), paramMap);
          }
        }, 0L);
        return true;
      }
    }
    return false;
  }
  
  void setIsPreload(String paramString)
  {
    this.isPreload = true;
    SonicSessionStatistics localSonicSessionStatistics = this.statistics;
    String str = paramString.trim();
    localSonicSessionStatistics.srcUrl = str;
    this.srcUrl = str;
    if (SonicUtils.shouldLog(4)) {
      SonicUtils.log("SonicSdk_SonicSession", 4, "session(" + this.sId + ") is preload, new url=" + paramString + ".");
    }
  }
  
  protected void setResult(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    SonicUtils.log("SonicSdk_SonicSession", 4, "session(" + this.sId + ")  setResult: srcCode=" + paramInt1 + ", finalCode=" + paramInt2 + ".");
    Object localObject1 = this.statistics;
    this.srcResultCode = paramInt1;
    ((SonicSessionStatistics)localObject1).originalMode = paramInt1;
    localObject1 = this.statistics;
    this.finalResultCode = paramInt2;
    ((SonicSessionStatistics)localObject1).finalMode = paramInt2;
    if (!paramBoolean) {
      return;
    }
    if (this.wasNotified.get()) {
      SonicUtils.log("SonicSdk_SonicSession", 6, "session(" + this.sId + ")  setResult: notify error -> already has notified!");
    }
    if (this.diffDataCallback == null)
    {
      SonicUtils.log("SonicSdk_SonicSession", 6, "session(" + this.sId + ")  setResult: notify fail as webCallback is not set, please wait!");
      return;
    }
    if (this.finalResultCode == -1)
    {
      SonicUtils.log("SonicSdk_SonicSession", 6, "session(" + this.sId + ")  setResult: notify fail finalResultCode is not set, please wait!");
      return;
    }
    this.wasNotified.compareAndSet(false, true);
    final JSONObject localJSONObject = new JSONObject();
    try
    {
      if (this.finalResultCode == 200)
      {
        localObject1 = new JSONObject(this.pendingDiffData);
        if (!((JSONObject)localObject1).has("local_refresh_time"))
        {
          SonicUtils.log("SonicSdk_SonicSession", 4, "session(" + this.sId + ") setResult: no any updated data. " + this.pendingDiffData);
          this.pendingDiffData = "";
          return;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      SonicUtils.log("SonicSdk_SonicSession", 6, "session(" + this.sId + ") setResult: notify error -> " + localThrowable.getMessage());
      Object localObject2;
      if (SonicUtils.shouldLog(3))
      {
        String str = localJSONObject.toString();
        localObject2 = str;
        if (str.length() > 512) {
          localObject2 = str.substring(0, 512);
        }
        SonicUtils.log("SonicSdk_SonicSession", 3, "session(" + this.sId + ") setResult: notify now call jsCallback, jsonStr = " + (String)localObject2);
      }
      this.pendingDiffData = null;
      long l1 = 0L;
      if (this.clientIsReload.get())
      {
        long l2 = System.currentTimeMillis() - this.statistics.diffDataCallbackTime;
        l1 = l2;
        if (l2 >= 2000L) {
          l1 = 0L;
        }
      }
      if (l1 > 0L)
      {
        SonicEngine.getInstance().getRuntime().postTaskToMainThread(new Runnable()
        {
          public void run()
          {
            if (SonicSession.this.diffDataCallback != null)
            {
              SonicSession.this.diffDataCallback.callback(localJSONObject.toString());
              SonicSession.this.statistics.diffDataCallbackTime = System.currentTimeMillis();
            }
          }
        }, 2000L - l1);
        return;
        l1 = System.currentTimeMillis() - ((JSONObject)localObject2).optLong("local_refresh_time", 0L);
        if (l1 > 30000L)
        {
          SonicUtils.log("SonicSdk_SonicSession", 6, "session(" + this.sId + ") setResult: notify fail as receive js call too late, " + l1 / 1000.0D + " s.");
          this.pendingDiffData = "";
          return;
        }
        if (SonicUtils.shouldLog(3)) {
          SonicUtils.log("SonicSdk_SonicSession", 3, "session(" + this.sId + ") setResult: notify receive js call in time: " + l1 / 1000.0D + " s.");
        }
        if (l1 > 0L) {
          localJSONObject.put("local_refresh_time", l1);
        }
        ((JSONObject)localObject2).remove("local_refresh_time");
        localJSONObject.put("result", ((JSONObject)localObject2).toString());
        if (this.isRedPointPreload) {
          this.lastIsRedPointPreload = true;
        }
        for (;;)
        {
          localJSONObject.put("isPreload", this.lastIsRedPointPreload);
          localJSONObject.put("code", this.finalResultCode);
          localJSONObject.put("srcCode", this.srcResultCode);
          localObject2 = new JSONObject();
          if (this.server != null)
          {
            ((JSONObject)localObject2).put("eTag", this.server.getResponseHeaderField("eTag"));
            ((JSONObject)localObject2).put("template-tag", this.server.getResponseHeaderField("template-tag"));
            ((JSONObject)localObject2).put("cache-offline", this.server.getResponseHeaderField("cache-offline"));
          }
          ((JSONObject)localObject2).put("isReload", this.clientIsReload);
          localJSONObject.put("extra", localObject2);
          break;
          if (System.currentTimeMillis() - this.lastDateUpdateTime > 86400000L) {
            this.lastIsRedPointPreload = false;
          }
        }
      }
      this.diffDataCallback.callback(localJSONObject.toString());
      this.statistics.diffDataCallbackTime = System.currentTimeMillis();
    }
  }
  
  protected boolean shouldSetCookieAsynchronous()
  {
    return 2 == this.resourceInterceptState.get();
  }
  
  public void start()
  {
    if (!this.sessionState.compareAndSet(0, 1))
    {
      SonicUtils.log("SonicSdk_SonicSession", 3, "session(" + this.sId + ") start error:sessionState=" + this.sessionState.get() + ".");
      return;
    }
    SonicUtils.log("SonicSdk_SonicSession", 4, "session(" + this.sId + ") now post sonic flow task.");
    Iterator localIterator = this.sessionCallbackList.iterator();
    while (localIterator.hasNext())
    {
      SonicSessionCallback localSonicSessionCallback = (SonicSessionCallback)((WeakReference)localIterator.next()).get();
      if (localSonicSessionCallback != null) {
        localSonicSessionCallback.onSonicSessionStart();
      }
    }
    this.statistics.sonicStartTime = System.currentTimeMillis();
    this.isWaitingForSessionThread.set(true);
    SonicEngine.getInstance().getRuntime().postTaskToSessionThread(new Runnable()
    {
      public void run()
      {
        SonicSession.this.runSonicFlow(true);
      }
    });
    notifyStateChange(0, 1, null);
  }
  
  protected boolean switchState(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (this.sessionState.compareAndSet(paramInt1, paramInt2))
    {
      if (paramBoolean) {}
      synchronized (this.sessionState)
      {
        this.sessionState.notify();
        notifyStateChange(paramInt1, paramInt2, null);
        return true;
      }
    }
    return false;
  }
  
  public static abstract interface Callback
  {
    public abstract void onSessionStateChange(SonicSession paramSonicSession, int paramInt1, int paramInt2, Bundle paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.sonic.sdk.SonicSession
 * JD-Core Version:    0.7.0.1
 */