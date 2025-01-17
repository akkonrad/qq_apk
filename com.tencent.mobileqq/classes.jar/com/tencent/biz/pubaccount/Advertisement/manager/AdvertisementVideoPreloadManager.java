package com.tencent.biz.pubaccount.Advertisement.manager;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.Advertisement.data.AdvertisementItem;
import com.tencent.biz.pubaccount.Advertisement.data.VideoCoverItem;
import com.tencent.biz.pubaccount.Advertisement.data.VideoDownloadItem;
import com.tencent.biz.pubaccount.persistence.entity.PAAdPreloadTask;
import com.tencent.biz.pubaccount.persistence.manager.PublicAccountEntityHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Content;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.olympic.utils.OlympicUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_ICacheMgr;
import com.tencent.qqlive.mediaplayer.api.TVK_IProxyFactory;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import com.tencent.qqlive.mediaplayer.api.TVK_UserInfo;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kug;
import kuh;
import kui;
import kuk;
import kul;
import kum;
import kun;
import kuo;
import kuq;
import kur;
import kus;
import kut;
import kuu;
import mqq.app.MobileQQ;
import mqq.manager.Manager;

public class AdvertisementVideoPreloadManager
  implements Manager
{
  private static final Long jdField_a_of_type_JavaLangLong = Long.valueOf(86400000L);
  private static final String jdField_a_of_type_JavaLangString = Environment.getExternalStorageDirectory().getPath() + "/Android/data/com.tencent.mobileqq/cache/public_account_ad_download/";
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "mp4", "fhd", "shd", "hd", "sd", "msd" };
  private int jdField_a_of_type_Int = 0;
  private Context jdField_a_of_type_AndroidContentContext;
  private PAAdPreloadTask jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask;
  private TVK_ICacheMgr jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr;
  private TVK_UserInfo jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_UserInfo;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private kus jdField_a_of_type_Kus;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private ArrayList jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private ArrayList c = new ArrayList();
  
  public AdvertisementVideoPreloadManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.jdField_a_of_type_AndroidContentContext = paramQQAppInterface.getApplication().getApplicationContext();
  }
  
  private static int a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return 0;
      File localFile = new File(a(paramString));
      if ((localFile.exists()) && (localFile.length() > 0L)) {
        return 2;
      }
      paramString = new File(b(paramString));
    } while ((!paramString.exists()) || (paramString.length() <= 0L));
    return 1;
  }
  
  private PublicAccountEntityHelper a()
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
      return (PublicAccountEntityHelper)((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getManager(236);
    }
    return null;
  }
  
  public static String a()
  {
    File localFile = new File(jdField_a_of_type_JavaLangString);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return jdField_a_of_type_JavaLangString;
  }
  
  public static String a(String paramString)
  {
    String str2 = "";
    String str1 = str2;
    if (!TextUtils.isEmpty(paramString))
    {
      File localFile = new File(jdField_a_of_type_JavaLangString);
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      str1 = str2;
      if (localFile.exists())
      {
        str1 = str2;
        if (localFile.isDirectory()) {
          str1 = jdField_a_of_type_JavaLangString + String.valueOf(20170807) + "_" + paramString;
        }
      }
    }
    return str1;
  }
  
  public static boolean a(String paramString)
  {
    return a(paramString) == 2;
  }
  
  private String b()
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
      return ((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).c();
    }
    return "";
  }
  
  public static String b(String paramString)
  {
    String str = a(paramString);
    paramString = str;
    if (!TextUtils.isEmpty(str)) {
      paramString = str + ".tmp";
    }
    return paramString;
  }
  
  private void b()
  {
    c("initCacheManager");
    TVK_IProxyFactory localTVK_IProxyFactory = TVK_SDKMgr.getProxyFactory();
    if (localTVK_IProxyFactory != null)
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr = localTVK_IProxyFactory.getCacheMgr(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr.setPreloadCallback(new kut(this, null));
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr.setOnPreLoadCompleteCallback(new kuu(this, null));
    }
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_UserInfo = new TVK_UserInfo(b(), "");
    this.jdField_a_of_type_Kus = new kus(this, this);
    AppNetConnInfo.registerConnectionChangeReceiver(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Kus);
    ThreadManager.executeOnNetWorkThread(new kuk(this));
    this.jdField_a_of_type_Boolean = true;
  }
  
  private void b(int paramInt)
  {
    c("continueDownload queueType:" + paramInt);
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask = null;
    ThreadManager.executeOnNetWorkThread(new kuh(this, paramInt));
  }
  
  public static void b(String paramString)
  {
    c("clearCacheVideo vid:" + paramString);
    if (!TextUtils.isEmpty(paramString))
    {
      File localFile = new File(b(paramString));
      if (localFile.exists()) {
        localFile.delete();
      }
      paramString = new File(a(paramString));
      if (paramString.exists()) {
        paramString.delete();
      }
    }
  }
  
  private void c()
  {
    c("resetDownload");
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask = null;
    this.jdField_b_of_type_Int = 0;
  }
  
  public static void c(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementVideoPreloadManager", 2, paramString);
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Int == 0) {
      c("onNetworkChange, no queue is working");
    }
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask == null)
      {
        c("onNetworkChange, no valid task");
        return;
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask.isNetworkValid())
      {
        c("onNetworkChange, vid:" + this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask.mVideoVid + ", networkType:" + this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask.mNetworkType + ", valid network, going on");
        return;
      }
      c("onNetworkChange, vid:" + this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask.mVideoVid + ", networkType:" + this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask.mNetworkType + ", invalid network, skip to next task");
    } while (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr == null);
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr.stopCacheData(20170807);
    b(this.jdField_a_of_type_Int);
  }
  
  public void a()
  {
    c("installTVKSdk");
    TVK_SDKMgr.initSdk(this.jdField_a_of_type_AndroidContentContext, "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==", b());
    if (!TVK_SDKMgr.isInstalled(this.jdField_a_of_type_AndroidContentContext))
    {
      ThreadManager.post(new kui(this), 8, null, false);
      return;
    }
    b();
  }
  
  public void a(int paramInt)
  {
    if (!this.jdField_a_of_type_Boolean) {
      a();
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      c("startVideoDownload queueType:" + paramInt);
      if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr == null)
      {
        c("startVideoDownload cache manager not init!");
        c();
        return;
      }
      if (paramInt <= this.jdField_a_of_type_Int)
      {
        c("startVideoDownload queue(" + this.jdField_a_of_type_Int + ") already run!");
        return;
      }
    }
    if (this.jdField_a_of_type_Int != 0)
    {
      c("startVideoDownload break current queue(" + this.jdField_a_of_type_Int + ")!");
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr.stopCacheData(20170807);
      c();
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask == null)
      {
        c("startVideoDownload no task to download");
        c();
        return;
        if (this.jdField_b_of_type_Int < this.jdField_a_of_type_JavaUtilArrayList.size())
        {
          this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask = ((PAAdPreloadTask)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_b_of_type_Int));
          this.jdField_b_of_type_Int += 1;
          continue;
          if (this.jdField_b_of_type_JavaUtilArrayList.size() > 0)
          {
            this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask = ((PAAdPreloadTask)this.jdField_b_of_type_JavaUtilArrayList.remove(0));
            continue;
            if (this.c.size() > 0) {
              this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask = ((PAAdPreloadTask)this.c.remove(0));
            }
          }
        }
      }
      else
      {
        this.jdField_a_of_type_Int = paramInt;
        String str1 = this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask.mVideoVid;
        int i;
        String str2;
        Object localObject3;
        if (!TextUtils.isEmpty(str1)) {
          if (this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask.mExpireTime > NetConnInfoCenter.getServerTimeMillis())
          {
            i = a(str1);
            c("startVideoDownload vid:" + str1 + ", cacheState:" + i);
            if (i != 2) {
              if (this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask.isNetworkValid())
              {
                str2 = b(str1);
                localObject3 = new File(str2);
                boolean bool = ((File)localObject3).exists();
                if (bool) {}
              }
            }
          }
        }
        for (;;)
        {
          try
          {
            ((File)localObject3).createNewFile();
            localObject3 = new TVK_PlayerVideoInfo(2, str1, "");
            HashMap localHashMap = new HashMap();
            localHashMap.put("shouq_bus_type", "bus_type_pa_advertisement");
            ((TVK_PlayerVideoInfo)localObject3).setReportInfoMap(localHashMap);
            ((TVK_PlayerVideoInfo)localObject3).setConfigMap("cache_duration", String.valueOf(-1));
            ((TVK_PlayerVideoInfo)localObject3).setConfigMap("cache_servers_type", String.valueOf(20170807));
            ((TVK_PlayerVideoInfo)localObject3).setConfigMap("file_dir", str2);
            this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr.preLoadVideoById(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_UserInfo, (TVK_PlayerVideoInfo)localObject3, "");
            c("startVideoDownload vid:" + str1);
            return;
          }
          catch (IOException localIOException)
          {
            c("startVideoDownload create tmp file failed for vid:" + str1);
            continue;
          }
          i = NetworkUtil.a(BaseApplication.getContext());
          c("startVideoDownload vid:" + str1 + ", networkType:" + this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask.mNetworkType + ", curNetType:" + i + ", no valid network, skip to next task");
          b(paramInt);
          continue;
          c("startVideoDownload vid:" + str1 + ", full cached, skip to next task");
          b(paramInt);
          continue;
          c("startVideoDownload vid:" + str1 + ", expireTime:" + this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask.mExpireTime + ", task expired, clean cache and skip to next task");
          b(paramInt);
          if (a(str1) != 0)
          {
            ThreadManager.executeOnFileThread(new kug(this, str1));
            continue;
            c("startVideoDownload empty vid, skip to next task");
            b(paramInt);
          }
        }
        switch (paramInt)
        {
        }
      }
    }
  }
  
  public void a(AdvertisementItem paramAdvertisementItem)
  {
    Object localObject = this.jdField_a_of_type_JavaLangObject;
    if (paramAdvertisementItem != null) {}
    for (;;)
    {
      VideoCoverItem localVideoCoverItem;
      try
      {
        if ((paramAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem == null) || (paramAdvertisementItem.jdField_a_of_type_JavaUtilArrayList == null) || (paramAdvertisementItem.jdField_a_of_type_JavaUtilArrayList.size() <= 0))
        {
          c("handlePreloadTaskFromMessage invalid item");
          return;
        }
        VideoDownloadItem localVideoDownloadItem = paramAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem;
        localVideoCoverItem = (VideoCoverItem)paramAdvertisementItem.jdField_a_of_type_JavaUtilArrayList.get(0);
        c("handlePreloadTaskFromMessage msgid:" + paramAdvertisementItem.c + ", vid:" + localVideoCoverItem.b);
        if (!TextUtils.isEmpty(localVideoCoverItem.b))
        {
          PAAdPreloadTask localPAAdPreloadTask = new PAAdPreloadTask();
          localPAAdPreloadTask.mUserUin = b();
          localPAAdPreloadTask.mVideoVid = localVideoCoverItem.b;
          if (this.jdField_b_of_type_JavaUtilArrayList.contains(localPAAdPreloadTask)) {
            break label309;
          }
          localPAAdPreloadTask.mMsgId = paramAdvertisementItem.c;
          localPAAdPreloadTask.mSource = 2;
          if (paramAdvertisementItem.jdField_a_of_type_Long > 0L)
          {
            l = paramAdvertisementItem.jdField_a_of_type_Long;
            localPAAdPreloadTask.mReceiveTime = l;
            localPAAdPreloadTask.mExpireTime = (localPAAdPreloadTask.mReceiveTime + jdField_a_of_type_JavaLangLong.longValue());
            localPAAdPreloadTask.mPreloadState = 1;
            localPAAdPreloadTask.mNetworkType = localVideoDownloadItem.e;
            this.jdField_b_of_type_JavaUtilArrayList.add(localPAAdPreloadTask);
            ThreadManager.executeOnNetWorkThread(new kuq(this));
            c("handlePreloadTaskFromMessage msgid:" + paramAdvertisementItem.c + ", vid:" + localVideoCoverItem.b + ", add to queue");
          }
        }
        else
        {
          return;
        }
      }
      finally {}
      long l = NetConnInfoCenter.getServerTimeMillis();
      continue;
      label309:
      c("handlePreloadTaskFromMessage msgid:" + paramAdvertisementItem.c + ", vid:" + localVideoCoverItem.b + ", exist in queue, ignore");
    }
  }
  
  public void a(AdvertisementItem paramAdvertisementItem, int paramInt)
  {
    Object localObject = this.jdField_a_of_type_JavaLangObject;
    if (paramAdvertisementItem != null) {}
    for (;;)
    {
      String str;
      try
      {
        if ((paramAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem == null) || (paramAdvertisementItem.jdField_a_of_type_JavaUtilArrayList == null) || (paramAdvertisementItem.jdField_a_of_type_JavaUtilArrayList.size() <= paramInt))
        {
          c("handlePreloadTaskFromPlay invalid item");
          return;
        }
        str = ((VideoCoverItem)paramAdvertisementItem.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).b;
        c("handlePreloadTaskFromPlay msgid:" + paramAdvertisementItem.c + ", index:" + paramInt + ", vid:" + str);
        if (!TextUtils.isEmpty(str))
        {
          PAAdPreloadTask localPAAdPreloadTask = new PAAdPreloadTask();
          localPAAdPreloadTask.mUserUin = b();
          localPAAdPreloadTask.mVideoVid = str;
          if (this.c.contains(localPAAdPreloadTask)) {
            break label317;
          }
          localPAAdPreloadTask.mMsgId = paramAdvertisementItem.c;
          localPAAdPreloadTask.mSource = 3;
          if (paramAdvertisementItem.jdField_a_of_type_Long > 0L)
          {
            l = paramAdvertisementItem.jdField_a_of_type_Long;
            localPAAdPreloadTask.mReceiveTime = l;
            localPAAdPreloadTask.mExpireTime = (localPAAdPreloadTask.mReceiveTime + jdField_a_of_type_JavaLangLong.longValue());
            localPAAdPreloadTask.mPreloadState = 1;
            localPAAdPreloadTask.mNetworkType = paramAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.e;
            this.c.add(localPAAdPreloadTask);
            ThreadManager.executeOnNetWorkThread(new kur(this));
            c("handlePreloadTaskFromPlay msgid:" + paramAdvertisementItem.c + ", index:" + paramInt + ", vid:" + str + ", add to queue");
          }
        }
        else
        {
          return;
        }
      }
      finally {}
      long l = NetConnInfoCenter.getServerTimeMillis();
      continue;
      label317:
      c("handlePreloadTaskFromPlay msgid:" + paramAdvertisementItem.c + ", index:" + paramInt + ", vid:" + str + ", exist in queue, ignore");
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int j;
    ArrayList localArrayList;
    Iterator localIterator;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      int i = paramQQAppInterface.getPreferences().getInt("public_account_ad_preload_task", 0);
      j = paramConfig.version.get();
      c("handlePreloadTaskFromConfig localVer:" + i + ", serverVer:" + j);
      if (i != j) {
        if (paramConfig.msg_content_list.size() > 0)
        {
          localArrayList = new ArrayList();
          localIterator = paramConfig.msg_content_list.get().iterator();
          if (localIterator.hasNext())
          {
            paramConfig = (ConfigurationService.Content)localIterator.next();
            if ((paramConfig != null) && (paramConfig.content.has())) {
              if (paramConfig.compress.get() == 1)
              {
                paramConfig = OlympicUtil.a(paramConfig.content.get().toByteArray());
                if (paramConfig == null) {
                  break label500;
                }
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        paramConfig = new String(paramConfig, "UTF-8");
        if (TextUtils.isEmpty(paramConfig)) {
          break;
        }
        localArrayList.addAll(PAAdPreloadTask.parserConfigTask(paramQQAppInterface.getCurrentAccountUin(), paramConfig));
        break;
        paramQQAppInterface = finally;
        throw paramQQAppInterface;
      }
      catch (Exception paramConfig)
      {
        QLog.e("AdvertisementVideoPreloadManager", 1, "handlePreloadTaskFromConfig|uncompress failed " + paramConfig);
        paramConfig = null;
        continue;
      }
      paramConfig = paramConfig.content.get().toStringUtf8();
      continue;
      c("handlePreloadTaskFromConfig empty content");
      break;
      if ((this.jdField_a_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr != null))
      {
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr.stopCacheData(20170807);
        c();
      }
      long l = NetConnInfoCenter.getServerTimeMillis();
      paramConfig = new ArrayList();
      localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        PAAdPreloadTask localPAAdPreloadTask = (PAAdPreloadTask)localIterator.next();
        if ((localPAAdPreloadTask.mExpireTime <= l) || (!localArrayList.contains(localPAAdPreloadTask))) {
          paramConfig.add(localPAAdPreloadTask);
        }
      }
      ThreadManager.executeOnFileThread(new kul(this, paramConfig));
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilArrayList.addAll(localArrayList);
      c("handlePreloadTaskFromConfig new taskSize:" + localArrayList.size());
      ThreadManager.executeOnSubThread(new kum(this));
      paramQQAppInterface = paramQQAppInterface.getPreferences().edit();
      paramQQAppInterface.putInt("public_account_ad_preload_task", j);
      paramQQAppInterface.apply();
      ThreadManager.executeOnNetWorkThread(new kun(this));
      for (;;)
      {
        return;
        c("handlePreloadTaskFromConfig empty config");
        continue;
        c("handlePreloadTaskFromConfig same version, no need to update");
      }
      label500:
      paramConfig = null;
    }
  }
  
  public void a(String paramString)
  {
    ThreadManager.executeOnSubThread(new kuo(this, paramString));
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    this.c.clear();
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr != null)
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr.stopCacheData(20170807);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr.removePreloadCallback();
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr.setOnPreLoadCompleteCallback(null);
    }
    if (this.jdField_a_of_type_Kus != null)
    {
      this.jdField_a_of_type_Kus.a();
      AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_Kus);
      this.jdField_a_of_type_Kus = null;
    }
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementVideoPreloadManager
 * JD-Core Version:    0.7.0.1
 */