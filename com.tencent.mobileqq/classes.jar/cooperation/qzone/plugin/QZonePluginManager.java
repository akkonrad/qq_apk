package cooperation.qzone.plugin;

import amxs;
import amxt;
import amxv;
import amxw;
import amxx;
import amxz;
import amyd;
import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.ProcessUtils;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;

public class QZonePluginManager
  extends IQZonePluginManager
  implements amxs, amxt, Handler.Callback, QZoneLiveSoDownloader.OnSoDownloadListener, QZonePluginDownloader.OnPluginDownloadListner, QZonePluginUpdater.OnUpdateListner, Manager
{
  private amxz jdField_a_of_type_Amxz;
  Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
  private QZoneLiveSoDownloader jdField_a_of_type_CooperationQzonePluginQZoneLiveSoDownloader;
  private QZonePluginDownloader jdField_a_of_type_CooperationQzonePluginQZonePluginDownloader;
  private QZonePluginInstaller jdField_a_of_type_CooperationQzonePluginQZonePluginInstaller;
  QZonePluginManager.LaunchState jdField_a_of_type_CooperationQzonePluginQZonePluginManager$LaunchState;
  private QZonePluginUpdater jdField_a_of_type_CooperationQzonePluginQZonePluginUpdater;
  Object jdField_a_of_type_JavaLangObject = new Object();
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private boolean jdField_a_of_type_Boolean;
  private ConcurrentHashMap jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  private boolean d;
  
  public QZonePluginManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_AndroidContentContext = paramQQAppInterface.getApp();
    this.jdField_a_of_type_CooperationQzonePluginQZonePluginUpdater = new QZonePluginUpdater(paramQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_CooperationQzonePluginQZonePluginUpdater.a(this);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_CooperationQzonePluginQZonePluginDownloader = new QZonePluginDownloader(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_CooperationQzonePluginQZoneLiveSoDownloader = new QZoneLiveSoDownloader(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_CooperationQzonePluginQZonePluginInstaller = new QZonePluginInstaller(this.jdField_a_of_type_AndroidContentContext);
    this.c = false;
    amyd.a().a(paramQQAppInterface);
  }
  
  private void a(int paramInt, Context paramContext, IQZonePluginManager.PluginParams paramPluginParams, IQZonePluginManager.OnPluginReadyListener paramOnPluginReadyListener)
  {
    if (c()) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (QLog.isColorLevel()) {
              QLog.d("QZonePluginManger", 2, "doInstallAndLaunch. confirmCode, pluginId:" + paramInt + "," + paramPluginParams.b);
            }
            if (this.jdField_b_of_type_Boolean) {
              break;
            }
          } while (paramOnPluginReadyListener == null);
          paramOnPluginReadyListener.a(false, paramContext, paramPluginParams);
          return;
          if (paramInt != 0) {
            break;
          }
        } while (paramOnPluginReadyListener == null);
        paramOnPluginReadyListener.a(false, paramContext, paramPluginParams);
        return;
        if (paramInt != 2) {
          break;
        }
      } while (paramOnPluginReadyListener == null);
      localObject1 = this.jdField_a_of_type_CooperationQzonePluginQZonePluginInstaller.a(paramPluginParams.b);
      if (localObject1 != null) {
        paramPluginParams.c = ((PluginRecord)localObject1).k;
      }
      paramOnPluginReadyListener.a(true, paramContext, paramPluginParams);
      return;
      if (paramInt == 1)
      {
        localObject1 = paramPluginParams.b;
        localObject2 = this.jdField_a_of_type_CooperationQzonePluginQZonePluginUpdater.a((String)localObject1);
        if (localObject2 == null) {}
        for (;;)
        {
          localObject2 = new QZonePluginManager.LaunchState();
          ((QZonePluginManager.LaunchState)localObject2).jdField_a_of_type_AndroidContentContext = paramContext;
          ((QZonePluginManager.LaunchState)localObject2).jdField_a_of_type_CooperationQzonePluginIQZonePluginManager$PluginParams = paramPluginParams;
          ((QZonePluginManager.LaunchState)localObject2).jdField_a_of_type_CooperationQzonePluginIQZonePluginManager$OnPluginReadyListener = paramOnPluginReadyListener;
          try
          {
            a((String)localObject1, new amxx(this, (QZonePluginManager.LaunchState)localObject2), 0);
            return;
          }
          catch (RemoteException paramContext)
          {
            QLog.e("QZonePluginManger", 1, paramContext, new Object[0]);
            return;
          }
          localObject2 = ((PluginRecord)localObject2).e;
        }
      }
    } while (paramInt != 3);
    Object localObject1 = paramPluginParams.b;
    Object localObject2 = new QZonePluginManager.LaunchState();
    ((QZonePluginManager.LaunchState)localObject2).jdField_a_of_type_AndroidContentContext = paramContext;
    ((QZonePluginManager.LaunchState)localObject2).jdField_a_of_type_CooperationQzonePluginIQZonePluginManager$PluginParams = paramPluginParams;
    ((QZonePluginManager.LaunchState)localObject2).jdField_a_of_type_CooperationQzonePluginIQZonePluginManager$OnPluginReadyListener = paramOnPluginReadyListener;
    try
    {
      a((String)localObject1, new amxx(this, (QZonePluginManager.LaunchState)localObject2), 0);
      return;
    }
    catch (RemoteException paramContext)
    {
      QLog.e("QZonePluginManger", 1, paramContext, new Object[0]);
    }
  }
  
  private void a(String paramString, int paramInt)
  {
    QzoneHandlerThreadFactory.getHandlerThread("Report_HandlerThread").post(new amxv(this, paramString, paramInt));
  }
  
  private boolean a(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 2);
  }
  
  private PluginRecord b(String paramString)
  {
    Object localObject2 = null;
    if (c()) {}
    do
    {
      return localObject2;
      QLog.i("QZonePluginManger", 1, "getPluginRecordInner " + paramString + "");
    } while (TextUtils.isEmpty(paramString));
    localObject2 = (PluginRecord)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    QLog.i("QZonePluginManger", 1, "mProcessingPlugins getInstalledPlugininfo " + localObject2 + "");
    Object localObject1;
    if (localObject2 == null)
    {
      localObject1 = this.jdField_a_of_type_CooperationQzonePluginQZonePluginInstaller.a(paramString);
      QLog.i("QZonePluginManger", 1, "installer getInstalledPlugininfo " + localObject1 + "");
      if (localObject1 == null)
      {
        localObject1 = this.jdField_a_of_type_CooperationQzonePluginQZonePluginUpdater.a(paramString);
        QLog.i("QZonePluginManger", 1, "updater getNewPluginRecord " + localObject1 + "");
      }
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("QZonePluginManger", 2, "getPluginRecordInner final record " + localObject1 + "");
      return localObject1;
      boolean bool = this.jdField_a_of_type_CooperationQzonePluginQZonePluginUpdater.a((PluginRecord)localObject1);
      QLog.i("QZonePluginManger", 1, "updater.checkUpToDate: " + bool + "");
      if (!bool)
      {
        localObject1 = this.jdField_a_of_type_CooperationQzonePluginQZonePluginUpdater.a(paramString);
        QLog.i("QZonePluginManger", 1, "updater getNewPluginRecord " + localObject1 + "");
        continue;
        int i = ((PluginRecord)localObject2).jdField_a_of_type_Int;
        if ((i != -1) && (i != 4))
        {
          localObject1 = localObject2;
          if (i != -2) {}
        }
        else
        {
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
          localObject1 = localObject2;
        }
      }
    }
  }
  
  private void b(Context paramContext, IQZonePluginManager.PluginParams paramPluginParams, IQZonePluginManager.OnPluginReadyListener paramOnPluginReadyListener)
  {
    if (c()) {}
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
        } while (paramPluginParams == null);
        if (QLog.isColorLevel()) {
          QLog.d("QZonePluginManger", 2, "checkUpdate:" + paramPluginParams.b);
        }
        if (this.jdField_b_of_type_Boolean) {
          break;
        }
      } while (paramOnPluginReadyListener == null);
      paramOnPluginReadyListener.a(false, paramContext, paramPluginParams);
      return;
      localObject = paramPluginParams.b;
      PluginRecord localPluginRecord = this.jdField_a_of_type_CooperationQzonePluginQZonePluginUpdater.b((String)localObject);
      if (localPluginRecord == null)
      {
        a(0, paramContext, paramPluginParams, paramOnPluginReadyListener);
        return;
      }
      boolean bool = a((String)localObject);
      if (QLog.isColorLevel()) {
        QLog.d("QZonePluginManger", 2, "installed :" + bool);
      }
      localObject = this.jdField_a_of_type_CooperationQzonePluginQZonePluginInstaller.a((String)localObject);
      if (bool)
      {
        bool = this.jdField_a_of_type_CooperationQzonePluginQZonePluginUpdater.a((PluginRecord)localObject);
        if (QLog.isColorLevel()) {
          QLog.d("QZonePluginManger", 2, "up to day :" + bool);
        }
        if (bool)
        {
          a(2, paramContext, paramPluginParams, paramOnPluginReadyListener);
          return;
        }
      }
      if ((!QZonePluginUtils.a(localPluginRecord, paramContext)) || (localPluginRecord == null)) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QZonePluginManger", 2, "plugin still running");
      }
    } while (paramOnPluginReadyListener == null);
    paramPluginParams.c = ((PluginRecord)localObject).k;
    paramOnPluginReadyListener.a(true, paramContext, paramPluginParams);
    return;
    if (QLog.isColorLevel()) {
      QLog.d("QZonePluginManger", 2, "forceUpdate, deamonInstall：" + true + ", " + true);
    }
    a(3, paramContext, paramPluginParams, paramOnPluginReadyListener);
  }
  
  private void b(String paramString, int paramInt)
  {
    if (c()) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(paramInt));
    localHashMap.put("pluginid", paramString);
    StatisticCollector.a(this.jdField_a_of_type_AndroidContentContext).a(null, "actQzonePluginPatch", true, 0L, 0L, localHashMap, null);
  }
  
  public static boolean b()
  {
    boolean bool2 = true;
    int i = QzoneConfig.getInstance().getConfig("LiveSetting", "PluginDownloadOnlyWifi", 1);
    QLog.d("QZonePluginManger", 1, "canDownloadPlugin, onlyWifi=" + i);
    boolean bool1;
    if (i > 0) {
      bool1 = NetworkState.isWifiConn();
    }
    do
    {
      do
      {
        do
        {
          return bool1;
          i = NetworkState.getNetworkType();
          QLog.d("QZonePluginManger", 1, "network type = " + i);
          bool1 = bool2;
        } while (1 == i);
        bool1 = bool2;
      } while (4 == i);
      bool1 = bool2;
    } while (2 == i);
    return false;
  }
  
  private void c()
  {
    if (c()) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("QZonePluginManger", 2, "getPluginList  pluginInfoRequesting:" + this.jdField_a_of_type_Boolean + "");
      }
    } while (this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_CooperationQzonePluginQZonePluginUpdater.a();
  }
  
  private boolean c()
  {
    return this.c;
  }
  
  private void d()
  {
    if (c()) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("QZonePluginManger", 2, "getPluginListIfNeed  pluginInfoRequesting:" + this.jdField_a_of_type_Boolean + " isReady:" + a() + " :lastUpdateSuccess:" + this.d);
      }
    } while ((this.jdField_a_of_type_Boolean) || (this.d));
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
  }
  
  public PluginRecord a(String paramString)
  {
    Object localObject2 = null;
    if (c()) {}
    Object localObject1;
    do
    {
      do
      {
        return localObject2;
      } while (TextUtils.isEmpty(paramString));
      localObject2 = b(paramString);
      localObject1 = localObject2;
      if (localObject2 != null) {
        localObject1 = ((PluginRecord)localObject2).a();
      }
      d();
      localObject2 = localObject1;
    } while (!QLog.isColorLevel());
    QLog.d("QZonePluginManger", 2, "queryPlugin queryPlugin：" + paramString + ",record:" + localObject1);
    return localObject1;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZonePluginManger", 1, "triggerQQDownloadPtuFilter");
    }
    QQAppInterface localQQAppInterface = amyd.a().a();
    if (localQQAppInterface == null) {
      QLog.w("QZonePluginManger", 1, "triggerQQDownloadPtuFilter, app is null");
    }
    do
    {
      do
      {
        return;
      } while (!PtvFilterSoLoad.b());
      QLog.w("QZonePluginManger", 1, "triggerQQDownloadPtuFilter");
    } while (PtvFilterSoLoad.a(BaseApplicationImpl.getContext()));
    PtvFilterSoLoad.a(localQQAppInterface, BaseApplicationImpl.getContext());
  }
  
  public void a(Context paramContext, IQZonePluginManager.PluginParams paramPluginParams, IQZonePluginManager.OnPluginReadyListener paramOnPluginReadyListener)
  {
    if (c())
    {
      QLog.w("QZonePluginManger", 1, "QZonePluginManagerIsClosed=true");
      return;
    }
    if (!this.jdField_b_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QZonePluginManger", 2, "not ready");
      }
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_CooperationQzonePluginQZonePluginManager$LaunchState != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("QZonePluginManger", 2, "mPengdingLaunchState already set");
          }
          if (paramOnPluginReadyListener != null) {
            paramOnPluginReadyListener.a(false, paramContext, paramPluginParams);
          }
          return;
        }
      }
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        d();
        QZonePluginManager.LaunchState localLaunchState = new QZonePluginManager.LaunchState();
        localLaunchState.jdField_a_of_type_AndroidContentContext = paramContext;
        localLaunchState.jdField_a_of_type_CooperationQzonePluginIQZonePluginManager$PluginParams = paramPluginParams;
        localLaunchState.jdField_a_of_type_CooperationQzonePluginIQZonePluginManager$OnPluginReadyListener = paramOnPluginReadyListener;
        this.jdField_a_of_type_CooperationQzonePluginQZonePluginManager$LaunchState = localLaunchState;
        if (QLog.isColorLevel()) {
          QLog.d("QZonePluginManger", 2, "set mPendingLaunchState");
        }
        return;
      }
    }
    b(paramContext, paramPluginParams, paramOnPluginReadyListener);
  }
  
  public void a(OnQZoneLiveSoDownloadListener paramOnQZoneLiveSoDownloadListener, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZonePluginManger", 1, "installPituSo");
    }
    if (amyd.a().a() == null) {
      QLog.w("QZonePluginManger", 1, "installPituSo, app is null");
    }
    do
    {
      return;
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramOnQZoneLiveSoDownloadListener);
      paramOnQZoneLiveSoDownloadListener = QZoneHelper.b();
    } while (TextUtils.isEmpty(paramOnQZoneLiveSoDownloadListener));
    this.jdField_a_of_type_CooperationQzonePluginQZoneLiveSoDownloader.a(paramOnQZoneLiveSoDownloadListener, this, paramInt);
  }
  
  public void a(PluginRecord paramPluginRecord)
  {
    if (c()) {}
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("QZonePluginManger", 2, "onDownLoadStart record:" + paramPluginRecord);
      }
      if (paramPluginRecord != null)
      {
        Object localObject = (PluginRecord)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramPluginRecord.f);
        if (localObject != null)
        {
          ((PluginRecord)localObject).jdField_a_of_type_Int = 1;
          localObject = (WeakReference)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramPluginRecord.f);
          if (localObject != null) {
            try
            {
              localObject = (OnQZonePluginInstallListner)((WeakReference)localObject).get();
              if (localObject != null)
              {
                ((OnQZonePluginInstallListner)localObject).a(paramPluginRecord.f);
                return;
              }
            }
            catch (RemoteException paramPluginRecord)
            {
              QLog.e("QZonePluginManger", 1, paramPluginRecord, new Object[0]);
            }
          }
        }
      }
    }
  }
  
  public void a(PluginRecord paramPluginRecord, int paramInt)
  {
    if (c()) {}
    Object localObject;
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("QZonePluginManger", 2, "onDownloadFailed record:" + paramPluginRecord);
      }
      if (paramPluginRecord != null)
      {
        paramPluginRecord.jdField_a_of_type_Int = -2;
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramPluginRecord.f);
        localObject = (WeakReference)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramPluginRecord.f);
        if (localObject != null) {
          try
          {
            localObject = (OnQZonePluginInstallListner)((WeakReference)localObject).get();
            if (localObject != null) {
              if (-9998 == paramInt)
              {
                ((OnQZonePluginInstallListner)localObject).a(paramPluginRecord.f, 8);
                b(paramPluginRecord.f, 8);
                return;
              }
            }
          }
          catch (RemoteException paramPluginRecord)
          {
            QLog.e("QZonePluginManger", 1, paramPluginRecord, new Object[0]);
            return;
          }
        }
      }
    }
    ((OnQZonePluginInstallListner)localObject).a(paramPluginRecord.f, 5);
    b(paramPluginRecord.f, 5);
  }
  
  public void a(QZoneLiveSoDownloader.DownloadSoRecord paramDownloadSoRecord)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {}
    try
    {
      paramDownloadSoRecord = (OnQZoneLiveSoDownloadListener)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (paramDownloadSoRecord != null) {
        paramDownloadSoRecord.a();
      }
      return;
    }
    catch (RemoteException paramDownloadSoRecord)
    {
      QLog.e("QZonePluginManger", 1, paramDownloadSoRecord, new Object[0]);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (c()) {
      return;
    }
    QLog.i("QZonePluginManger", 1, "onUpdatefinish success:" + paramBoolean);
    this.d = paramBoolean;
    this.jdField_b_of_type_Boolean = true;
    if ((paramBoolean) && (this.jdField_a_of_type_Amxz != null)) {
      this.jdField_a_of_type_Amxz.a();
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_CooperationQzonePluginQZonePluginManager$LaunchState != null)
      {
        QLog.i("QZonePluginManger", 1, "onUpdateFinish. handle pending launch state");
        QZonePluginManager.LaunchState localLaunchState = this.jdField_a_of_type_CooperationQzonePluginQZonePluginManager$LaunchState;
        b(localLaunchState.jdField_a_of_type_AndroidContentContext, localLaunchState.jdField_a_of_type_CooperationQzonePluginIQZonePluginManager$PluginParams, localLaunchState.jdField_a_of_type_CooperationQzonePluginIQZonePluginManager$OnPluginReadyListener);
        this.jdField_a_of_type_CooperationQzonePluginQZonePluginManager$LaunchState = null;
        this.jdField_a_of_type_AndroidOsHandler.post(new amxw(this));
        return;
      }
      QLog.i("QZonePluginManger", 1, "mPendingLaunchState is null");
    }
  }
  
  public void a(boolean paramBoolean, PluginRecord paramPluginRecord)
  {
    if (c()) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("QZonePluginManger", 2, "onInstallFinish record:" + paramPluginRecord);
      }
    } while (paramPluginRecord == null);
    Object localObject = (WeakReference)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramPluginRecord.f);
    try
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramPluginRecord.f);
      if (paramBoolean)
      {
        if (localObject != null)
        {
          localObject = (OnQZonePluginInstallListner)((WeakReference)localObject).get();
          if (localObject != null) {
            ((OnQZonePluginInstallListner)localObject).b(paramPluginRecord.f);
          }
        }
        b(paramPluginRecord.f, 0);
        return;
      }
    }
    catch (RemoteException paramPluginRecord)
    {
      QLog.e("QZonePluginManger", 1, paramPluginRecord, new Object[0]);
      return;
    }
    if (localObject != null)
    {
      localObject = (OnQZonePluginInstallListner)((WeakReference)localObject).get();
      if (localObject != null) {
        ((OnQZonePluginInstallListner)localObject).a(paramPluginRecord.f, 7);
      }
    }
    b(paramPluginRecord.f, 7);
  }
  
  public boolean a()
  {
    if (c()) {
      return false;
    }
    return this.jdField_b_of_type_Boolean;
  }
  
  public boolean a(String paramString)
  {
    if (c()) {}
    do
    {
      do
      {
        do
        {
          return false;
          if (QLog.isColorLevel()) {
            QLog.d("QZonePluginManger", 2, "isPluginInstalled: " + paramString + "");
          }
        } while (TextUtils.isEmpty(paramString));
        paramString = a(paramString);
      } while (paramString == null);
      if (QLog.isColorLevel()) {
        QLog.d("QZonePluginManger", 2, " isPluginInstalled record :" + paramString);
      }
    } while (paramString.jdField_a_of_type_Int != 4);
    return true;
  }
  
  public boolean a(String paramString, OnQZonePluginInstallListner paramOnQZonePluginInstallListner, int paramInt)
  {
    if (c()) {}
    do
    {
      return false;
      QLog.i("QZonePluginManger", 1, "installPlugin pluginid=" + paramString + " refer=" + paramInt);
    } while (TextUtils.isEmpty(paramString));
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString))
    {
      QLog.d("QZonePluginManger", 1, "installPlugin pluginid:" + paramString + ",正在处理，skip。。。");
      return false;
    }
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, new WeakReference(paramOnQZonePluginInstallListner));
    PluginRecord localPluginRecord1 = this.jdField_a_of_type_CooperationQzonePluginQZonePluginUpdater.a(paramString);
    if (localPluginRecord1 != null)
    {
      PluginRecord localPluginRecord2 = this.jdField_a_of_type_CooperationQzonePluginQZonePluginInstaller.a(paramString);
      if ((localPluginRecord2 != null) && (localPluginRecord2.jdField_a_of_type_Int == 4) && (this.jdField_a_of_type_CooperationQzonePluginQZonePluginUpdater.a(localPluginRecord2)))
      {
        QLog.i("QZonePluginManger", 1, "installPlugin " + paramString + " 已安装");
        if (paramOnQZonePluginInstallListner != null) {
          paramOnQZonePluginInstallListner.b(paramString);
        }
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Amxz == null) {
        this.jdField_a_of_type_Amxz = new amxz(this, this.jdField_a_of_type_CooperationQzonePluginQZonePluginUpdater);
      }
      return true;
      QLog.i("QZonePluginManger", 1, "installPlugin " + paramString + " 未安装,开始下载");
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localPluginRecord1);
      this.jdField_a_of_type_CooperationQzonePluginQZonePluginDownloader.a(localPluginRecord1, this, paramInt);
      a(localPluginRecord1.f, paramInt);
      continue;
      QLog.e("QZonePluginManger", 1, "installPlugin record==null 没有插件信息，失败");
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
      if (paramOnQZonePluginInstallListner != null) {
        paramOnQZonePluginInstallListner.a(paramString, 1);
      }
      b(paramString, 1);
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "setReadyToNetworking");
    }
    d();
  }
  
  public void b(PluginRecord paramPluginRecord)
  {
    if (c()) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("QZonePluginManger", 2, "onDownloadCanceled record:" + paramPluginRecord);
      }
    } while (paramPluginRecord == null);
    paramPluginRecord.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramPluginRecord.f);
    Object localObject = (WeakReference)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramPluginRecord.f);
    if (localObject != null) {}
    try
    {
      localObject = (OnQZonePluginInstallListner)((WeakReference)localObject).get();
      if (localObject != null) {
        ((OnQZonePluginInstallListner)localObject).a(paramPluginRecord.f, 3);
      }
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        QLog.e("QZonePluginManger", 1, localRemoteException, new Object[0]);
      }
    }
    b(paramPluginRecord.f, 3);
  }
  
  public void b(PluginRecord paramPluginRecord, int paramInt)
  {
    if (c()) {}
    PluginRecord localPluginRecord;
    do
    {
      do
      {
        return;
        QLog.i("QZonePluginManger", 1, "onDownloadSucceed record:" + paramPluginRecord + " refer=" + paramInt);
      } while (paramPluginRecord == null);
      localPluginRecord = (PluginRecord)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramPluginRecord.f);
    } while (localPluginRecord == null);
    localPluginRecord.jdField_a_of_type_Int = 2;
    if ((a(paramInt)) && (QZonePluginUtils.a(paramPluginRecord, this.jdField_a_of_type_AndroidContentContext)))
    {
      if ((!paramPluginRecord.f.equals("qzone_vertical_video_plugin.apk")) && (!paramPluginRecord.f.equals(QZonePluginUtils.a()))) {
        break label221;
      }
      if (!ProcessUtils.f(ProcessUtils.a())) {
        break label216;
      }
      paramInt = 1;
    }
    for (;;)
    {
      Object localObject;
      if (paramInt != 0)
      {
        localObject = (WeakReference)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramPluginRecord.f);
        if (localObject != null)
        {
          localObject = (OnQZonePluginInstallListner)((WeakReference)localObject).get();
          if (localObject == null) {}
        }
      }
      try
      {
        ((OnQZonePluginInstallListner)localObject).a(paramPluginRecord.f, 2);
        b(paramPluginRecord.f, 2);
        this.jdField_a_of_type_CooperationQzonePluginQZonePluginInstaller.a(localPluginRecord, this);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        for (;;)
        {
          QLog.e("QZonePluginManger", 1, localRemoteException, new Object[0]);
        }
      }
      label216:
      paramInt = 0;
      continue;
      label221:
      paramInt = 1;
    }
  }
  
  public void b(QZoneLiveSoDownloader.DownloadSoRecord paramDownloadSoRecord)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {}
    try
    {
      paramDownloadSoRecord = (OnQZoneLiveSoDownloadListener)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (paramDownloadSoRecord != null) {
        paramDownloadSoRecord.c();
      }
      return;
    }
    catch (RemoteException paramDownloadSoRecord)
    {
      QLog.e("QZonePluginManger", 1, paramDownloadSoRecord, new Object[0]);
    }
  }
  
  public void b(boolean paramBoolean, PluginRecord paramPluginRecord)
  {
    if (c()) {}
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("QZonePluginManger", 2, "onUnInstallFinish reslut:" + paramBoolean + "record:" + paramPluginRecord);
  }
  
  public boolean b(String paramString)
  {
    if (c()) {}
    do
    {
      return false;
      if (QLog.isColorLevel()) {
        QLog.d("QZonePluginManger", 2, "cancelInstall " + paramString + "");
      }
    } while (TextUtils.isEmpty(paramString));
    paramString = this.jdField_a_of_type_CooperationQzonePluginQZonePluginUpdater.a(paramString);
    this.jdField_a_of_type_CooperationQzonePluginQZonePluginDownloader.a(paramString, this);
    return false;
  }
  
  public void c(PluginRecord paramPluginRecord)
  {
    if (c()) {
      break label7;
    }
    for (;;)
    {
      label7:
      return;
      if (paramPluginRecord != null)
      {
        Object localObject = (PluginRecord)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramPluginRecord.f);
        if (localObject != null) {
          ((PluginRecord)localObject).jdField_a_of_type_Int = 1;
        }
        localObject = (WeakReference)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramPluginRecord.f);
        if (localObject == null) {
          break;
        }
        try
        {
          localObject = (OnQZonePluginInstallListner)((WeakReference)localObject).get();
          if (localObject != null)
          {
            ((OnQZonePluginInstallListner)localObject).a(paramPluginRecord.f, paramPluginRecord.jdField_a_of_type_Float, paramPluginRecord.jdField_a_of_type_Long);
            return;
          }
        }
        catch (RemoteException paramPluginRecord)
        {
          QLog.e("QZonePluginManger", 1, paramPluginRecord, new Object[0]);
        }
      }
    }
  }
  
  public void c(QZoneLiveSoDownloader.DownloadSoRecord paramDownloadSoRecord)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {}
    try
    {
      OnQZoneLiveSoDownloadListener localOnQZoneLiveSoDownloadListener = (OnQZoneLiveSoDownloadListener)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localOnQZoneLiveSoDownloadListener != null) {
        localOnQZoneLiveSoDownloadListener.a(paramDownloadSoRecord.jdField_a_of_type_Int);
      }
      return;
    }
    catch (RemoteException paramDownloadSoRecord)
    {
      QLog.e("QZonePluginManger", 1, paramDownloadSoRecord, new Object[0]);
    }
  }
  
  public boolean c(String paramString)
  {
    if (c()) {}
    do
    {
      do
      {
        return false;
        QLog.i("QZonePluginManger", 1, "uninstallPlugin " + paramString);
      } while (TextUtils.isEmpty(paramString));
      paramString = this.jdField_a_of_type_CooperationQzonePluginQZonePluginUpdater.a(paramString);
      this.jdField_a_of_type_CooperationQzonePluginQZonePluginInstaller.a(paramString, null);
      this.jdField_a_of_type_CooperationQzonePluginQZonePluginDownloader.a(paramString, this);
      paramString = QZoneHelper.b();
    } while (TextUtils.isEmpty(paramString));
    this.jdField_a_of_type_CooperationQzonePluginQZoneLiveSoDownloader.a(paramString);
    return false;
  }
  
  public void d(PluginRecord paramPluginRecord)
  {
    if (c()) {}
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("QZonePluginManger", 2, "onInstallBegin record:" + paramPluginRecord);
      }
      if (paramPluginRecord != null)
      {
        Object localObject = (PluginRecord)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramPluginRecord.f);
        if (localObject != null)
        {
          ((PluginRecord)localObject).jdField_a_of_type_Int = 3;
          localObject = (WeakReference)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramPluginRecord.f);
          if (localObject != null) {
            try
            {
              localObject = (OnQZonePluginInstallListner)((WeakReference)localObject).get();
              if (localObject != null)
              {
                ((OnQZonePluginInstallListner)localObject).a(paramPluginRecord.f);
                return;
              }
            }
            catch (RemoteException paramPluginRecord)
            {
              QLog.e("QZonePluginManger", 1, paramPluginRecord, new Object[0]);
            }
          }
        }
      }
    }
  }
  
  public void d(QZoneLiveSoDownloader.DownloadSoRecord paramDownloadSoRecord)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {}
    try
    {
      paramDownloadSoRecord = (OnQZoneLiveSoDownloadListener)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (paramDownloadSoRecord != null) {
        paramDownloadSoRecord.b();
      }
      return;
    }
    catch (RemoteException paramDownloadSoRecord)
    {
      QLog.e("QZonePluginManger", 1, paramDownloadSoRecord, new Object[0]);
    }
  }
  
  public void e(PluginRecord paramPluginRecord)
  {
    if (c()) {}
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("QZonePluginManger", 2, "onUnInstallBegin record:" + paramPluginRecord);
  }
  
  public void e(QZoneLiveSoDownloader.DownloadSoRecord paramDownloadSoRecord)
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (paramDownloadSoRecord != null)) {}
    try
    {
      OnQZoneLiveSoDownloadListener localOnQZoneLiveSoDownloadListener = (OnQZoneLiveSoDownloadListener)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localOnQZoneLiveSoDownloadListener != null) {
        localOnQZoneLiveSoDownloadListener.a(paramDownloadSoRecord.jdField_a_of_type_Float);
      }
      return;
    }
    catch (RemoteException paramDownloadSoRecord)
    {
      QLog.e("QZonePluginManger", 1, paramDownloadSoRecord, new Object[0]);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      c();
    }
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZonePluginManger", 2, "onDestroy");
    }
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_a_of_type_CooperationQzonePluginQZonePluginUpdater = null;
    this.jdField_a_of_type_CooperationQzonePluginQZonePluginInstaller = null;
    if (this.jdField_a_of_type_CooperationQzonePluginQZonePluginDownloader != null) {
      this.jdField_a_of_type_CooperationQzonePluginQZonePluginDownloader.a();
    }
    this.jdField_a_of_type_CooperationQzonePluginQZoneLiveSoDownloader = null;
    this.jdField_a_of_type_CooperationQzonePluginQZonePluginDownloader = null;
    if (this.jdField_a_of_type_Amxz != null) {
      this.jdField_a_of_type_Amxz.b();
    }
    this.jdField_a_of_type_Amxz = null;
    this.c = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.plugin.QZonePluginManager
 * JD-Core Version:    0.7.0.1
 */