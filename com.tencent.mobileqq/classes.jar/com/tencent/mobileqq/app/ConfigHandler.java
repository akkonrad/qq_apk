package com.tencent.mobileqq.app;

import MAAccessClient.AccessRsp;
import MAAccessClient.GetSinglePkgSigRsp;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.qq.taf.jce.JceInputStream;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.activity.aio.anim.AioAnimationConfigHelper;
import com.tencent.mobileqq.activity.weather.WeatherManager;
import com.tencent.mobileqq.app.upgrade.UpgradeController;
import com.tencent.mobileqq.app.upgrade.UpgradeController.OnHandleUpgradeFinishListener;
import com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper.NewApkInfo;
import com.tencent.mobileqq.config.operation.QQOperateManager;
import com.tencent.mobileqq.config.operation.QQOperationRequestTaskInfo;
import com.tencent.mobileqq.config.operation.QQOperationViopTipTask;
import com.tencent.mobileqq.config.operation.QQOperationVoipTipsTaskExcuteRecord;
import com.tencent.mobileqq.config.splashlogo.ConfigServlet;
import com.tencent.mobileqq.cooperation.ApkUtils;
import com.tencent.mobileqq.data.AppShareID;
import com.tencent.mobileqq.data.OperateVoipTipsInfo;
import com.tencent.mobileqq.earlydownload.EarlyDownloadManager;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.service.MobileQQServiceBase;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.AppShareIDUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.JumpFilterHelper;
import com.tencent.mobileqq.vaswebviewplugin.ThemeUiPlugin;
import com.tencent.open.downloadnew.MyAppApi;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.securitysdk.utils.ApkExternalInfoTool;
import com.tencent.securitysdk.utils.Verify;
import com.tencent.util.Pair;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import protocol.KQQConfig.GetResourceReqInfo;
import protocol.KQQConfig.GetResourceResp;
import protocol.KQQConfig.GetResourceRespInfo;
import protocol.KQQConfig.UpgradeInfo;
import tencent.im.mobiletips.MobileTips.MobileTipsPkg;
import tencent.im.mobiletips.MobileTips.ReqBody;
import tencent.im.mobiletips.MobileTips.RspBody;
import tencent.im.mobiletips.MobileTips.TaskInfo;
import tencent.im.oidb.cmd0x9ae.cmd0x9ae.AuthTips;
import tencent.im.oidb.cmd0x9ae.cmd0x9ae.ReqBody;
import tencent.im.oidb.cmd0x9ae.cmd0x9ae.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;
import tencent.im.s2c.msgtype0x210.SubMsgType0x43.UpdateTips;
import zbq;
import zbr;
import zbs;
import zbt;
import zbu;
import zbv;
import zbw;
import zbx;
import zby;
import zbz;

public class ConfigHandler
  extends BusinessHandler
  implements UpgradeController.OnHandleUpgradeFinishListener
{
  public ConfigHandler.InstallSuccessCallback a;
  private HashSet jdField_a_of_type_JavaUtilHashSet = new HashSet();
  private volatile boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public ConfigHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppConfigHandler$InstallSuccessCallback = new ConfigHandler.InstallSuccessCallback(this);
  }
  
  public static int a(QQAppInterface paramQQAppInterface)
  {
    int i = paramQQAppInterface.getPreferences().getInt("UPGRADE_TIPS_SHOW_COUNT", 0);
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "ConfigHandler.getUpgradeTipsShowCount:" + i);
    }
    return i;
  }
  
  public static UpgradeDetailWrapper.NewApkInfo a(UpgradeInfo paramUpgradeInfo)
  {
    if ((paramUpgradeInfo != null) && (paramUpgradeInfo.strProgressName != null))
    {
      paramUpgradeInfo = paramUpgradeInfo.strProgressName;
      if (paramUpgradeInfo != null)
      {
        String[] arrayOfString = paramUpgradeInfo.split("\\|");
        try
        {
          paramUpgradeInfo = new UpgradeDetailWrapper.NewApkInfo();
          return null;
        }
        catch (Exception paramUpgradeInfo)
        {
          try
          {
            paramUpgradeInfo.jdField_a_of_type_JavaLangString = arrayOfString[2];
            paramUpgradeInfo.b = arrayOfString[1];
            paramUpgradeInfo.jdField_a_of_type_Long = Long.parseLong(arrayOfString[0]);
            paramUpgradeInfo.jdField_a_of_type_Int = Integer.parseInt(arrayOfString[3]);
            return paramUpgradeInfo;
          }
          catch (Exception localException)
          {
            return paramUpgradeInfo;
          }
          paramUpgradeInfo = paramUpgradeInfo;
          return null;
        }
      }
    }
  }
  
  private static String a()
  {
    Date localDate = new Date();
    int i = localDate.getYear();
    int j = localDate.getMonth();
    int k = localDate.getDay();
    return i + ":" + j + ":" + k;
  }
  
  public static String a(Context paramContext)
  {
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningTasks(1);
    if ((paramContext != null) && (paramContext.size() > 0) && (((ActivityManager.RunningTaskInfo)paramContext.get(0)).topActivity != null)) {
      return ((ActivityManager.RunningTaskInfo)paramContext.get(0)).topActivity.getClassName();
    }
    return null;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "ConfigHandler.getUpgradeTipsUrl:" + paramInt);
    }
    Object localObject = paramQQAppInterface.getPreferences();
    paramQQAppInterface = ((SharedPreferences)localObject).getString("UPGRADE_TIPS_URL", null);
    if (paramQQAppInterface == null) {}
    do
    {
      long l1;
      long l2;
      long l3;
      do
      {
        return null;
        localObject = ((SharedPreferences)localObject).getString("UPGRADE_TIPS_URL_MARK", null);
        if (QLog.isColorLevel()) {
          QLog.d("UpgradeController", 2, "ConfigHandler.getUpgradeTipsUrl:" + (String)localObject);
        }
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break;
        }
        localObject = ((String)localObject).split(":");
        l1 = Long.parseLong(localObject[0]);
        l2 = Long.parseLong(localObject[1]);
        l3 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("UpgradeController", 2, "ConfigHandler.getUpgradeTipsUrl:" + l3);
        }
      } while ((l2 < l1) || (l3 <= l1));
      if (l3 > l2) {
        return paramQQAppInterface;
      }
    } while (paramInt > 0);
    return paramQQAppInterface;
  }
  
  private void a(Intent paramIntent)
  {
    paramIntent.putExtra("logout_intent", true);
    ThemeUiPlugin.destroy(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
    ChatBackgroundManager.a();
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.logout(true);
    if (BaseApplicationImpl.sImageCache != null) {
      BaseApplicationImpl.sImageCache.evictAll();
    }
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    Object localObject = localBaseActivity;
    if (localBaseActivity == null)
    {
      localObject = BaseApplication.getContext();
      paramIntent.addFlags(268435456);
    }
    paramIntent.setClass((Context)localObject, LoginActivity.class);
    ((Context)localObject).startActivity(paramIntent);
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.getPreferences().edit();
    paramQQAppInterface.putString("UPGRADE_TIPS_DAILY_STR", a());
    paramQQAppInterface.commit();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    paramQQAppInterface = paramQQAppInterface.getPreferences().edit();
    paramQQAppInterface.putInt("NEW_ICON_TIMESTAMP", paramInt);
    paramQQAppInterface.commit();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    Object localObject = paramQQAppInterface.getPreferences();
    String str = ((SharedPreferences)localObject).getString("UPGRADE_TIPS_URL", null);
    if ((str != null) && (paramInt >= 0))
    {
      if (str.equals(paramString)) {
        return;
      }
      b(paramQQAppInterface, 0);
    }
    if (TextUtils.isEmpty(paramString))
    {
      paramQQAppInterface = ((SharedPreferences)localObject).edit();
      paramQQAppInterface.putString("UPGRADE_TIPS_URL_MARK", null);
      paramQQAppInterface.putString("UPGRADE_TIPS_URL", paramString);
      paramQQAppInterface.commit();
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = paramInt * 24 * 60 * 60 * 1000;
    paramQQAppInterface = l1 + ":" + (l2 + l1);
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putString("UPGRADE_TIPS_URL_MARK", paramQQAppInterface);
    ((SharedPreferences.Editor)localObject).putString("UPGRADE_TIPS_URL", paramString);
    ((SharedPreferences.Editor)localObject).commit();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    paramQQAppInterface = paramQQAppInterface.getPreferences().edit();
    paramQQAppInterface.putBoolean("UPGRADE_AUTO_DOWNLOAD_IN_WIFI", paramBoolean);
    paramQQAppInterface.commit();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "ConfigHandler.onReceiverPCUpgradeMessage");
    }
    paramQQAppInterface = new SubMsgType0x43.UpdateTips();
    try
    {
      String str = paramQQAppInterface.bytes_desc.get().toString();
      if (QLog.isColorLevel()) {
        QLog.d("UpgradeController", 2, "ConfigHandler.onReceiverPCUpgradeMessage: " + str);
      }
      paramQQAppInterface.mergeFrom(paramArrayOfByte);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramQQAppInterface) {}
  }
  
  private void a(EntityManager paramEntityManager, GetResourceRespInfo paramGetResourceRespInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("share_appid", 2, "get share appid resp info");
    }
    if (paramGetResourceRespInfo.iResult != 0) {
      a(5, false, null);
    }
    AppShareID localAppShareID;
    do
    {
      return;
      localAppShareID = AppShareIDUtil.a(paramGetResourceRespInfo);
    } while (localAppShareID == null);
    if (QLog.isColorLevel()) {
      QLog.d("share_appid", 2, "parser share appid from resp info, result:  " + localAppShareID);
    }
    paramGetResourceRespInfo = (AppShareID)paramEntityManager.a(AppShareID.class, "strPkgName=?", new String[] { paramGetResourceRespInfo.strPkgName });
    if (paramGetResourceRespInfo == null)
    {
      paramEntityManager.a(localAppShareID);
      if (QLog.isColorLevel()) {
        QLog.d("share_appid", 2, "Persist DB appid = " + localAppShareID.strPkgName);
      }
    }
    for (;;)
    {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a.a(localAppShareID.strPkgName, localAppShareID);
      a(localAppShareID.strResURL_big, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getFileStreamPath(localAppShareID.strPkgName));
      a(5, true, localAppShareID);
      return;
      if (localAppShareID.uiNewVer != paramGetResourceRespInfo.uiNewVer)
      {
        paramEntityManager.b(paramGetResourceRespInfo);
        paramEntityManager.a(localAppShareID);
        if (QLog.isColorLevel()) {
          QLog.d("share_appid", 2, "Update DB appid = " + localAppShareID.strPkgName);
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("share_appid", 2, "Not need update DB appid = " + localAppShareID.strPkgName);
      }
    }
  }
  
  private void a(GetResourceRespInfo paramGetResourceRespInfo)
  {
    if (paramGetResourceRespInfo == null) {}
    long l2;
    do
    {
      return;
      long l1 = JumpFilterHelper.a().a();
      l2 = paramGetResourceRespInfo.uiNewVer;
      if (QLog.isColorLevel()) {
        QLog.d("JumpWhiteList", 2, "handleJumpWhiteList currentVersion: " + l1 + ", serverVersion: " + l2 + ",iResult: " + paramGetResourceRespInfo.iResult + ", bigUrl: " + paramGetResourceRespInfo.strResURL_big);
      }
      if (l2 == l1) {
        break;
      }
      paramGetResourceRespInfo = paramGetResourceRespInfo.strResURL_big;
    } while (TextUtils.isEmpty(paramGetResourceRespInfo));
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(new zbq(this, paramGetResourceRespInfo, l2));
    return;
    ThreadManager.getFileThreadHandler().post(new zbs(this));
  }
  
  private void a(boolean paramBoolean, UpgradeDetailWrapper paramUpgradeDetailWrapper)
  {
    a(4, paramBoolean, paramUpgradeDetailWrapper);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.getPreferences();
    boolean bool2 = false;
    paramQQAppInterface = paramQQAppInterface.getString("UPGRADE_TIPS_DAILY_STR", null);
    boolean bool1 = bool2;
    if (paramQQAppInterface != null)
    {
      bool1 = bool2;
      if (a().equals(paramQQAppInterface)) {
        bool1 = true;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "ConfigHandler.isDailyShowTips:" + bool1 + "--> " + paramQQAppInterface);
    }
    return bool1;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    return paramInt == paramQQAppInterface.getPreferences().getInt("NEW_ICON_TIMESTAMP", -1);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    return paramQQAppInterface.getPreferences().getBoolean("UPGRADE_AUTO_DOWNLOAD_IN_WIFI", paramBoolean);
  }
  
  private boolean a(String paramString, long paramLong)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (paramString == null) {
      bool2 = bool1;
    }
    do
    {
      return bool2;
      DeviceProfileManager localDeviceProfileManager = DeviceProfileManager.a();
      bool1 = bool2;
      if ("eggs_android_CI_4.7.1".equals(paramString))
      {
        bool1 = bool2;
        if (!localDeviceProfileManager.a(DeviceProfileManager.DpcNames.aio_eggs.name(), paramLong))
        {
          FileUtils.d(new File(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getFilesDir(), "eggs_config.zip").getAbsolutePath());
          FileUtils.d(AioAnimationConfigHelper.b);
          bool1 = false;
          AioAnimationConfigHelper.a().a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApplication());
          this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit().putLong("k_eggs_file_version", 0L).commit();
        }
      }
      bool2 = bool1;
    } while (!QLog.isColorLevel());
    QLog.d("ConfigHandler", 2, "str=" + paramString + ", isFeatureSupport=" + bool1);
    return bool1;
  }
  
  public static void b(QQAppInterface paramQQAppInterface, int paramInt)
  {
    paramQQAppInterface = paramQQAppInterface.getPreferences().edit();
    paramQQAppInterface.putInt("UPGRADE_TIPS_SHOW_COUNT", paramInt);
    paramQQAppInterface.commit();
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    paramQQAppInterface = paramQQAppInterface.getPreferences();
    String str = paramQQAppInterface.getString("UPGRADE_BANNER_URL", null);
    if ((str != null) && (paramInt > 0) && (str.equals(paramString))) {
      return;
    }
    if (TextUtils.isEmpty(paramString))
    {
      paramQQAppInterface = paramQQAppInterface.edit();
      paramQQAppInterface.putString("UPGRADE_BANNER_URL_MARK", null);
      paramQQAppInterface.putString("UPGRADE_BANNER_URL", paramString);
      paramQQAppInterface.commit();
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = paramInt * 24 * 60 * 60 * 1000;
    str = l1 + ":" + (l2 + l1);
    paramQQAppInterface = paramQQAppInterface.edit();
    paramQQAppInterface.putString("UPGRADE_BANNER_URL_MARK", str);
    paramQQAppInterface.putString("UPGRADE_BANNER_URL", paramString);
    paramQQAppInterface.commit();
  }
  
  public static void b(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    paramQQAppInterface = paramQQAppInterface.getPreferences().edit();
    paramQQAppInterface.putBoolean("AUTO_DOWNLOADED_IN_WIFI", paramBoolean);
    paramQQAppInterface.commit();
    if (QLog.isColorLevel()) {
      QLog.d("preLoad_configServlet", 2, "is auto download : " + paramBoolean);
    }
  }
  
  private void b(UpgradeDetailWrapper paramUpgradeDetailWrapper)
  {
    SharedPreferences localSharedPreferences = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
    if (paramUpgradeDetailWrapper == null) {}
    label44:
    label58:
    do
    {
      UpgradeInfo localUpgradeInfo;
      do
      {
        for (;;)
        {
          return;
          localUpgradeInfo = paramUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo;
          if (localUpgradeInfo != null)
          {
            int i;
            if ((localUpgradeInfo.iUpgradeType > 0) && (localUpgradeInfo.bNewSwitch == 1))
            {
              i = 1;
              QQAppInterface localQQAppInterface = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface;
              if (i == 0) {
                break label272;
              }
              localObject = "1";
              ReportController.b(localQQAppInterface, "CliOper", "", "", "0X8004DA5", "0X8004DA5", 0, 0, (String)localObject, "", UpgradeController.a(), "");
              localObject = localSharedPreferences.edit();
              if (localSharedPreferences.getInt("upgrade_timeStamp", 0) < localUpgradeInfo.iNewTimeStamp) {
                ((SharedPreferences.Editor)localObject).putInt("upgrade_timeStamp", localUpgradeInfo.iNewTimeStamp);
              }
              ((SharedPreferences.Editor)localObject).commit();
              a(true, paramUpgradeDetailWrapper);
              if (localUpgradeInfo.iActionType != 0) {
                continue;
              }
              if (localUpgradeInfo.iUpgradeType != 1) {
                break label279;
              }
            }
            for (;;)
            {
              if (localUpgradeInfo.iUpgradeType != 2) {
                break label286;
              }
              localObject = a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp());
              if ((localObject == null) || (((String)localObject).equals("com.tencent.mobileqq.activity.UserguideActivity"))) {
                break;
              }
              localObject = new Intent();
              ((Intent)localObject).putExtra("reason_for_upgrade", true);
              ((Intent)localObject).putExtra("StrTitle", "版本升级");
              ((Intent)localObject).putExtra("StrUpgradeDesc", "你当前使用的QQ版本过低，需要立即升级");
              ((Intent)localObject).putExtra("StrUrl", localUpgradeInfo.strNewSoftwareURL);
              ((Intent)localObject).putExtra(paramUpgradeDetailWrapper.getClass().getSimpleName(), paramUpgradeDetailWrapper);
              a((Intent)localObject);
              return;
              i = 0;
              break label44;
              localObject = "0";
              break label58;
              d();
            }
            if (localUpgradeInfo.iUpgradeType != 1) {
              break;
            }
            if (UpgradeController.a().a() == 4)
            {
              if (QLog.isColorLevel()) {
                QLog.d("UpgradeConfigManager", 2, "apk has been download, and install tip need shown.");
              }
              UpgradeController.a().d(true);
              return;
            }
            if (QLog.isColorLevel()) {
              QLog.d("UpgradeConfigManager", 2, "apk has not been download, try to download.");
            }
            this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
            Object localObject = UpgradeController.a();
            if (a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, false))
            {
              if (AppNetConnInfo.isWifiConn())
              {
                if (QLog.isColorLevel()) {
                  QLog.d("UpgradeConfigManager", 2, "start anto download in wifi");
                }
                ((UpgradeController)localObject).a();
                return;
              }
              if (QLog.isColorLevel()) {
                QLog.d("UpgradeConfigManager", 2, "start auto download but not in wifi, mark it");
              }
              ((UpgradeController)localObject).d(true);
              return;
            }
            if ((localUpgradeInfo.iTipsType == 0) || (localUpgradeInfo.iTipsType == 2)) {
              ((UpgradeController)localObject).d(true);
            }
            while (QLog.isColorLevel())
            {
              QLog.d("UpgradeConfigManager", 2, "tip to download.");
              return;
              localObject = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(Conversation.class);
              if (localObject != null) {
                ((MqqHandler)localObject).obtainMessage(1134020, paramUpgradeDetailWrapper).sendToTarget();
              }
            }
          }
        }
      } while (localUpgradeInfo.iUpgradeType != 3);
      if (paramUpgradeDetailWrapper.jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig.dialog.jdField_a_of_type_Boolean)
      {
        if (QLog.isColorLevel()) {
          QLog.d("UpgradeConfigManager", 2, "start preDownload YYB");
        }
        MyAppApi.a().a(BaseActivity.sTopActivity, 0);
        ThreadManager.getUIHandler().postDelayed(new zbr(this), 5000L);
        return;
      }
    } while (!QLog.isColorLevel());
    label272:
    label279:
    label286:
    QLog.d("UpgradeConfigManager", 2, "do not need to preDownload YYB");
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool9 = false;
    boolean bool10 = false;
    boolean bool11 = false;
    boolean bool8 = false;
    boolean bool1;
    boolean bool2;
    boolean bool7;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool1 = true;
      if (QLog.isColorLevel()) {
        QLog.d("ConfigHandler", 2, "handleGetPCActiveConfig success=" + bool1);
      }
      bool2 = bool1;
      bool7 = bool9;
      if (bool1)
      {
        bool3 = bool1;
        bool4 = bool10;
        bool5 = bool1;
        bool6 = bool11;
      }
    }
    for (;;)
    {
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        if (paramFromServiceMsg == null) {
          continue;
        }
        bool3 = bool1;
        bool4 = bool10;
        bool5 = bool1;
        bool6 = bool11;
        if (paramFromServiceMsg.uint32_result.get() != 0) {
          continue;
        }
        bool1 = true;
        bool3 = bool1;
        bool4 = bool10;
        bool5 = bool1;
        bool6 = bool11;
        if (QLog.isColorLevel())
        {
          bool3 = bool1;
          bool4 = bool10;
          bool5 = bool1;
          bool6 = bool11;
          QLog.d("ConfigHandler", 2, "handleGetPCActiveConfig result=" + bool1);
        }
        bool2 = bool1;
        bool7 = bool9;
        if (bool1)
        {
          bool2 = bool1;
          bool7 = bool9;
          bool3 = bool1;
          bool4 = bool10;
          bool5 = bool1;
          bool6 = bool11;
          if (paramFromServiceMsg.bytes_bodybuffer.has())
          {
            bool2 = bool1;
            bool7 = bool9;
            bool3 = bool1;
            bool4 = bool10;
            bool5 = bool1;
            bool6 = bool11;
            if (paramFromServiceMsg.bytes_bodybuffer.get() != null)
            {
              bool3 = bool1;
              bool4 = bool10;
              bool5 = bool1;
              bool6 = bool11;
              paramFromServiceMsg = ByteBuffer.wrap(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
              bool3 = bool1;
              bool4 = bool10;
              bool5 = bool1;
              bool6 = bool11;
              int i = paramFromServiceMsg.getShort();
              bool3 = bool1;
              bool4 = bool10;
              bool5 = bool1;
              bool6 = bool11;
              int j = paramFromServiceMsg.getShort();
              bool2 = bool1;
              bool7 = bool9;
              if (i == 16)
              {
                bool3 = bool1;
                bool4 = bool10;
                bool5 = bool1;
                bool6 = bool11;
                paramObject = new byte[j];
                bool3 = bool1;
                bool4 = bool10;
                bool5 = bool1;
                bool6 = bool11;
                paramFromServiceMsg.get(paramObject);
                bool2 = bool8;
                if ((paramObject[16] & 0x1) > 0) {
                  bool2 = true;
                }
                bool3 = bool1;
                bool4 = bool2;
                bool5 = bool1;
                bool6 = bool2;
                SettingCloneUtil.writeValue(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), paramToServiceMsg.getUin(), null, "pcactive_config", bool2);
                bool3 = bool1;
                bool4 = bool2;
                bool5 = bool1;
                bool6 = bool2;
                this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.openMsfPCActive(paramToServiceMsg.getUin(), "config", bool2);
                bool3 = bool1;
                bool4 = bool2;
                bool5 = bool1;
                bool6 = bool2;
                QLog.d("ConfigHandler", 1, "PCActive opened: " + bool2 + " by config");
                bool3 = bool1;
                bool4 = bool2;
                bool5 = bool1;
                bool6 = bool2;
                paramFromServiceMsg = new Intent("com.tencent.mobileqq.activity.NotifyPushSettingActivity.ConfigPCActive");
                bool3 = bool1;
                bool4 = bool2;
                bool5 = bool1;
                bool6 = bool2;
                paramFromServiceMsg.putExtra("configPCActive", bool2);
                bool3 = bool1;
                bool4 = bool2;
                bool5 = bool1;
                bool6 = bool2;
                paramFromServiceMsg.putExtra("uin", paramToServiceMsg.getUin());
                bool3 = bool1;
                bool4 = bool2;
                bool5 = bool1;
                bool6 = bool2;
                this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp().sendBroadcast(paramFromServiceMsg);
                bool7 = bool2;
                bool2 = bool1;
              }
            }
          }
        }
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        bool5 = bool3;
        bool6 = bool4;
        if (!QLog.isColorLevel()) {
          continue;
        }
        bool5 = bool3;
        bool6 = bool4;
        QLog.d("ConfigHandler", 2, "handleGetPCActiveConfig ex", paramToServiceMsg);
        return;
      }
      finally
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ConfigHandler", 2, "handleGetPCActiveConfig result=" + bool5 + ";allow=" + bool6);
      }
      bool1 = false;
      break;
      bool1 = false;
    }
  }
  
  private void b(GetResourceRespInfo paramGetResourceRespInfo)
  {
    if (paramGetResourceRespInfo == null) {}
    WeatherManager localWeatherManager;
    long l1;
    do
    {
      long l2;
      do
      {
        return;
        localWeatherManager = (WeatherManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(113);
        l1 = paramGetResourceRespInfo.uiNewVer;
        l2 = localWeatherManager.a();
        if (QLog.isColorLevel()) {
          QLog.d("weatherManager", 2, "handleWeatherResources currentVersion: " + l2 + ", serverVersion: " + l1 + ",iResult: " + paramGetResourceRespInfo.iResult + ", bigUrl: " + paramGetResourceRespInfo.strResURL_big);
        }
      } while (l1 == l2);
      paramGetResourceRespInfo = paramGetResourceRespInfo.strResURL_big;
    } while (TextUtils.isEmpty(paramGetResourceRespInfo));
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(new zbt(this, paramGetResourceRespInfo, localWeatherManager, l1));
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getPreferences().getBoolean("AUTO_DOWNLOADED_IN_WIFI", false);
  }
  
  /* Error */
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: aconst_null
    //   4: astore 11
    //   6: aconst_null
    //   7: astore 10
    //   9: aconst_null
    //   10: astore 9
    //   12: aload_2
    //   13: invokevirtual 709	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   16: ifeq +187 -> 203
    //   19: aload_3
    //   20: ifnull +183 -> 203
    //   23: iconst_1
    //   24: istore 8
    //   26: iload 8
    //   28: ifne +181 -> 209
    //   31: aconst_null
    //   32: astore_1
    //   33: aconst_null
    //   34: astore_2
    //   35: aconst_null
    //   36: astore_3
    //   37: iload 8
    //   39: ifne +670 -> 709
    //   42: iconst_1
    //   43: istore 6
    //   45: ldc 53
    //   47: iconst_1
    //   48: new 55	java/lang/StringBuilder
    //   51: dup
    //   52: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   55: ldc_w 812
    //   58: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: iload 8
    //   63: invokevirtual 453	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   66: ldc_w 814
    //   69: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: iload 6
    //   74: invokevirtual 453	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   77: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: invokestatic 73	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   83: aload_0
    //   84: iload 6
    //   86: putfield 816	com/tencent/mobileqq/app/ConfigHandler:jdField_b_of_type_Boolean	Z
    //   89: iload 6
    //   91: ifne +98 -> 189
    //   94: getstatic 820	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   97: invokevirtual 824	com/tencent/common/app/BaseApplicationImpl:getResources	()Landroid/content/res/Resources;
    //   100: pop
    //   101: new 196	android/content/Intent
    //   104: dup
    //   105: invokespecial 585	android/content/Intent:<init>	()V
    //   108: astore 12
    //   110: aload 12
    //   112: ldc_w 826
    //   115: iconst_1
    //   116: invokevirtual 200	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   119: pop
    //   120: aload 12
    //   122: ldc_w 589
    //   125: aload 11
    //   127: invokevirtual 594	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   130: pop
    //   131: aload 12
    //   133: ldc_w 596
    //   136: aload 10
    //   138: invokevirtual 594	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   141: pop
    //   142: aload 12
    //   144: ldc_w 828
    //   147: aload 9
    //   149: invokevirtual 594	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   152: pop
    //   153: aload 12
    //   155: ldc_w 830
    //   158: aload_2
    //   159: invokevirtual 594	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   162: pop
    //   163: aload 12
    //   165: ldc_w 832
    //   168: aload_1
    //   169: invokevirtual 594	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   172: pop
    //   173: aload 12
    //   175: ldc_w 834
    //   178: aload_3
    //   179: invokevirtual 594	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   182: pop
    //   183: aload_0
    //   184: aload 12
    //   186: invokespecial 617	com/tencent/mobileqq/app/ConfigHandler:a	(Landroid/content/Intent;)V
    //   189: aload_0
    //   190: bipush 11
    //   192: iload 8
    //   194: iload 6
    //   196: invokestatic 840	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   199: invokevirtual 330	com/tencent/mobileqq/app/ConfigHandler:a	(IZLjava/lang/Object;)V
    //   202: return
    //   203: iconst_0
    //   204: istore 8
    //   206: goto -180 -> 26
    //   209: aload_3
    //   210: checkcast 842	MAAccessClient/AccessRsp
    //   213: astore 14
    //   215: aload 14
    //   217: getfield 845	MAAccessClient/AccessRsp:ret	I
    //   220: istore 4
    //   222: iload 4
    //   224: iconst_1
    //   225: if_icmpne +15 -> 240
    //   228: iconst_1
    //   229: istore 5
    //   231: aconst_null
    //   232: astore_1
    //   233: aconst_null
    //   234: astore_2
    //   235: aconst_null
    //   236: astore_3
    //   237: goto -200 -> 37
    //   240: iload 4
    //   242: ifeq +15 -> 257
    //   245: iconst_1
    //   246: istore 5
    //   248: aconst_null
    //   249: astore_1
    //   250: aconst_null
    //   251: astore_2
    //   252: aconst_null
    //   253: astore_3
    //   254: goto -217 -> 37
    //   257: aload 14
    //   259: getfield 848	MAAccessClient/AccessRsp:body	[B
    //   262: ifnull +489 -> 751
    //   265: aload 14
    //   267: getfield 848	MAAccessClient/AccessRsp:body	[B
    //   270: arraylength
    //   271: ifle +480 -> 751
    //   274: new 850	com/qq/taf/jce/JceInputStream
    //   277: dup
    //   278: aload 14
    //   280: getfield 848	MAAccessClient/AccessRsp:body	[B
    //   283: invokespecial 853	com/qq/taf/jce/JceInputStream:<init>	([B)V
    //   286: astore_2
    //   287: new 855	MAAccessClient/CheckSinglePkgSigRsp
    //   290: dup
    //   291: invokespecial 856	MAAccessClient/CheckSinglePkgSigRsp:<init>	()V
    //   294: astore_1
    //   295: aload_1
    //   296: aload_2
    //   297: invokevirtual 860	MAAccessClient/CheckSinglePkgSigRsp:readFrom	(Lcom/qq/taf/jce/JceInputStream;)V
    //   300: aload_1
    //   301: ifnull +28 -> 329
    //   304: aload_1
    //   305: getfield 861	MAAccessClient/CheckSinglePkgSigRsp:ret	I
    //   308: iconst_1
    //   309: if_icmpeq +20 -> 329
    //   312: aload_1
    //   313: getfield 861	MAAccessClient/CheckSinglePkgSigRsp:ret	I
    //   316: iconst_m1
    //   317: if_icmpeq +12 -> 329
    //   320: aload_1
    //   321: getfield 861	MAAccessClient/CheckSinglePkgSigRsp:ret	I
    //   324: bipush 100
    //   326: if_icmpne +21 -> 347
    //   329: iconst_1
    //   330: istore 5
    //   332: aconst_null
    //   333: astore_1
    //   334: aconst_null
    //   335: astore_2
    //   336: aconst_null
    //   337: astore_3
    //   338: goto -301 -> 37
    //   341: astore_1
    //   342: aconst_null
    //   343: astore_1
    //   344: goto -44 -> 300
    //   347: aload_1
    //   348: getfield 861	MAAccessClient/CheckSinglePkgSigRsp:ret	I
    //   351: ifne +346 -> 697
    //   354: aload_1
    //   355: getfield 865	MAAccessClient/CheckSinglePkgSigRsp:vtMarket	Ljava/util/ArrayList;
    //   358: ifnull +387 -> 745
    //   361: aload_1
    //   362: getfield 865	MAAccessClient/CheckSinglePkgSigRsp:vtMarket	Ljava/util/ArrayList;
    //   365: invokevirtual 871	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   368: astore_2
    //   369: iconst_0
    //   370: istore 5
    //   372: iload 5
    //   374: istore 7
    //   376: aload_2
    //   377: invokeinterface 876 1 0
    //   382: ifeq +154 -> 536
    //   385: aload_2
    //   386: invokeinterface 880 1 0
    //   391: checkcast 882	MAAccessClient/NoCheckMarket
    //   394: astore_3
    //   395: iload 5
    //   397: istore 7
    //   399: aload_3
    //   400: getfield 885	MAAccessClient/NoCheckMarket:pkgName	Ljava/lang/String;
    //   403: invokestatic 182	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   406: ifne +284 -> 690
    //   409: iload 5
    //   411: istore 6
    //   413: iload 5
    //   415: ifne +23 -> 438
    //   418: getstatic 820	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   421: aload_3
    //   422: getfield 885	MAAccessClient/NoCheckMarket:pkgName	Ljava/lang/String;
    //   425: aload_3
    //   426: getfield 888	MAAccessClient/NoCheckMarket:versionCode	I
    //   429: aload_3
    //   430: getfield 891	MAAccessClient/NoCheckMarket:signatureMd5	Ljava/lang/String;
    //   433: invokestatic 896	com/tencent/securitysdk/utils/Verify:a	(Landroid/content/Context;Ljava/lang/String;ILjava/lang/String;)Z
    //   436: istore 6
    //   438: invokestatic 899	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   441: ifeq +45 -> 486
    //   444: ldc 53
    //   446: iconst_4
    //   447: new 55	java/lang/StringBuilder
    //   450: dup
    //   451: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   454: ldc_w 901
    //   457: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   460: aload_3
    //   461: getfield 885	MAAccessClient/NoCheckMarket:pkgName	Ljava/lang/String;
    //   464: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   467: ldc_w 903
    //   470: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   473: aload_3
    //   474: getfield 888	MAAccessClient/NoCheckMarket:versionCode	I
    //   477: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   480: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   483: invokestatic 73	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   486: iload 6
    //   488: istore 7
    //   490: iload 6
    //   492: ifeq +198 -> 690
    //   495: iload 6
    //   497: istore 7
    //   499: invokestatic 899	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   502: ifeq +34 -> 536
    //   505: ldc 53
    //   507: iconst_4
    //   508: new 55	java/lang/StringBuilder
    //   511: dup
    //   512: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   515: ldc_w 901
    //   518: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   521: iload 6
    //   523: invokevirtual 453	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   526: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   529: invokestatic 73	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   532: iload 6
    //   534: istore 7
    //   536: aload_1
    //   537: getfield 906	MAAccessClient/CheckSinglePkgSigRsp:pkgSig	Ljava/lang/String;
    //   540: astore 13
    //   542: aload_1
    //   543: getfield 909	MAAccessClient/CheckSinglePkgSigRsp:tmastUrl	Ljava/lang/String;
    //   546: astore 12
    //   548: aload_1
    //   549: getfield 912	MAAccessClient/CheckSinglePkgSigRsp:pageUrl	Ljava/lang/String;
    //   552: astore_2
    //   553: aload_1
    //   554: getfield 915	MAAccessClient/CheckSinglePkgSigRsp:sigVersionCode	I
    //   557: istore 4
    //   559: new 55	java/lang/StringBuilder
    //   562: dup
    //   563: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   566: aload_2
    //   567: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   570: ldc_w 917
    //   573: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   576: iload 4
    //   578: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   581: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   584: astore 10
    //   586: invokestatic 899	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   589: ifeq +41 -> 630
    //   592: ldc 53
    //   594: iconst_4
    //   595: new 55	java/lang/StringBuilder
    //   598: dup
    //   599: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   602: ldc_w 919
    //   605: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   608: aload 13
    //   610: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   613: ldc_w 903
    //   616: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   619: iload 4
    //   621: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   624: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   627: invokestatic 73	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   630: aload 14
    //   632: getfield 923	MAAccessClient/AccessRsp:tips	LMAAccessClient/Tips;
    //   635: ifnull +101 -> 736
    //   638: aload 14
    //   640: getfield 923	MAAccessClient/AccessRsp:tips	LMAAccessClient/Tips;
    //   643: getfield 928	MAAccessClient/Tips:title	Ljava/lang/String;
    //   646: astore_3
    //   647: aload 14
    //   649: getfield 923	MAAccessClient/AccessRsp:tips	LMAAccessClient/Tips;
    //   652: getfield 931	MAAccessClient/Tips:content	Ljava/lang/String;
    //   655: astore_2
    //   656: aload 14
    //   658: getfield 923	MAAccessClient/AccessRsp:tips	LMAAccessClient/Tips;
    //   661: getfield 934	MAAccessClient/Tips:button	Ljava/lang/String;
    //   664: astore_1
    //   665: aload_1
    //   666: astore 9
    //   668: iload 7
    //   670: istore 5
    //   672: aload 10
    //   674: astore_1
    //   675: aload_2
    //   676: astore 10
    //   678: aload_3
    //   679: astore 11
    //   681: aload 12
    //   683: astore_2
    //   684: aload 13
    //   686: astore_3
    //   687: goto -650 -> 37
    //   690: iload 7
    //   692: istore 5
    //   694: goto -322 -> 372
    //   697: iconst_1
    //   698: istore 5
    //   700: aconst_null
    //   701: astore_1
    //   702: aconst_null
    //   703: astore_2
    //   704: aconst_null
    //   705: astore_3
    //   706: goto -669 -> 37
    //   709: iload 5
    //   711: istore 6
    //   713: iload 5
    //   715: ifeq -670 -> 45
    //   718: getstatic 820	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   721: invokestatic 937	com/tencent/securitysdk/utils/Verify:a	(Landroid/content/Context;)Z
    //   724: pop
    //   725: iload 5
    //   727: istore 6
    //   729: goto -684 -> 45
    //   732: astore_2
    //   733: goto -389 -> 344
    //   736: aconst_null
    //   737: astore_1
    //   738: aconst_null
    //   739: astore_2
    //   740: aconst_null
    //   741: astore_3
    //   742: goto -77 -> 665
    //   745: iconst_0
    //   746: istore 7
    //   748: goto -212 -> 536
    //   751: aconst_null
    //   752: astore_1
    //   753: goto -453 -> 300
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	756	0	this	ConfigHandler
    //   0	756	1	paramToServiceMsg	ToServiceMsg
    //   0	756	2	paramFromServiceMsg	FromServiceMsg
    //   0	756	3	paramObject	Object
    //   220	400	4	i	int
    //   1	725	5	bool1	boolean
    //   43	685	6	bool2	boolean
    //   374	373	7	bool3	boolean
    //   24	181	8	bool4	boolean
    //   10	657	9	localObject1	Object
    //   7	670	10	localObject2	Object
    //   4	676	11	localObject3	Object
    //   108	574	12	localObject4	Object
    //   540	145	13	str	String
    //   213	444	14	localAccessRsp	AccessRsp
    // Exception table:
    //   from	to	target	type
    //   274	295	341	java/lang/Exception
    //   295	300	732	java/lang/Exception
  }
  
  private void c(GetResourceRespInfo paramGetResourceRespInfo)
  {
    com.tencent.mobileqq.filemanager.data.FMConstants.jdField_a_of_type_Boolean = true;
    if (paramGetResourceRespInfo.iResult == -2) {}
    while (paramGetResourceRespInfo.iResult == 0)
    {
      String str = paramGetResourceRespInfo.strResURL_big;
      if ((str != null) && (str.length() > 0)) {
        this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(new zbu(this, str, paramGetResourceRespInfo));
      }
      return;
    }
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool2 = false;
    String str2 = paramToServiceMsg.extraData.getString("rid");
    String str1 = "";
    int i;
    boolean bool1;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      i = 1;
      if (i != 0) {
        break label136;
      }
      bool1 = bool2;
      paramToServiceMsg = str1;
    }
    label136:
    label178:
    do
    {
      for (;;)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("UpgradeController", 4, "handleGetAuthCode:" + bool1 + ", " + str2 + ", code:" + paramToServiceMsg);
        }
        a(10, bool1, new Pair(paramToServiceMsg, str2));
        UpgradeController.a().a(bool1, str2, paramToServiceMsg);
        return;
        i = 0;
        break;
        paramFromServiceMsg = (AccessRsp)paramObject;
        i = paramFromServiceMsg.ret;
        if (i != 1) {
          break label178;
        }
        if (QLog.isDevelopLevel()) {
          QLog.d("UpgradeController", 4, "handleGetAuthCode not supported");
        }
        paramToServiceMsg = "";
        bool1 = true;
      }
      paramToServiceMsg = str1;
      bool1 = bool2;
    } while (i != 0);
    if ((paramFromServiceMsg.body != null) && (paramFromServiceMsg.body.length > 0)) {}
    for (;;)
    {
      try
      {
        paramToServiceMsg = new JceInputStream(paramFromServiceMsg.body);
        paramFromServiceMsg = new GetSinglePkgSigRsp();
      }
      catch (Exception paramToServiceMsg)
      {
        try
        {
          paramFromServiceMsg.readFrom(paramToServiceMsg);
          paramToServiceMsg = str1;
          bool1 = bool2;
          if (paramFromServiceMsg == null) {
            break;
          }
          paramToServiceMsg = str1;
          bool1 = bool2;
          if (paramFromServiceMsg.ret != 0) {
            break;
          }
          paramToServiceMsg = paramFromServiceMsg.pkgSig;
          bool1 = true;
          break;
          paramToServiceMsg = paramToServiceMsg;
          paramFromServiceMsg = null;
          continue;
        }
        catch (Exception paramToServiceMsg)
        {
          continue;
        }
      }
      paramFromServiceMsg = null;
    }
  }
  
  private void d(GetResourceRespInfo paramGetResourceRespInfo)
  {
    if (paramGetResourceRespInfo.iResult != 0) {
      a(1, false, paramGetResourceRespInfo);
    }
    String str;
    do
    {
      return;
      str = paramGetResourceRespInfo.strResURL_big;
    } while ((str == null) || (str.length() <= 0));
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(new zbv(this, str, paramGetResourceRespInfo));
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg == null) || (paramObject == null)) {}
    int i;
    label49:
    label68:
    label89:
    label111:
    do
    {
      return;
      paramToServiceMsg = new cmd0x9ae.RspBody();
      i = a(paramFromServiceMsg, paramObject, paramToServiceMsg);
      if (i == 0)
      {
        boolean bool1;
        boolean bool2;
        if (paramToServiceMsg.bool_has_been_authenticated.has())
        {
          bool1 = paramToServiceMsg.bool_has_been_authenticated.get();
          if (!paramToServiceMsg.bool_need_auth_tips.has()) {
            break label268;
          }
          bool2 = paramToServiceMsg.bool_need_auth_tips.get();
          if (!paramToServiceMsg.msg_auth_tips.has()) {
            break label274;
          }
          paramFromServiceMsg = (cmd0x9ae.AuthTips)paramToServiceMsg.msg_auth_tips.get();
          if (paramFromServiceMsg == null) {
            break label300;
          }
          if (!paramFromServiceMsg.string_tips_title.has()) {
            break label279;
          }
          paramToServiceMsg = paramFromServiceMsg.string_tips_title.get();
          if (!paramFromServiceMsg.string_tips_context.has()) {
            break label286;
          }
          paramObject = paramFromServiceMsg.string_tips_context.get();
          if (!paramFromServiceMsg.string_tips_action_url.has()) {
            break label293;
          }
        }
        for (paramFromServiceMsg = paramFromServiceMsg.string_tips_action_url.get();; paramFromServiceMsg = "")
        {
          a(13, true, new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), paramToServiceMsg, paramObject, paramFromServiceMsg });
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("RealName", 2, "handleGetRealNameStatus value is: " + bool1 + "|" + bool2 + "|" + paramToServiceMsg + "|" + paramObject + "|" + paramFromServiceMsg);
          return;
          bool1 = true;
          break label49;
          bool2 = false;
          break label68;
          paramFromServiceMsg = null;
          break label89;
          paramToServiceMsg = "";
          break label111;
          paramObject = "";
          break label129;
        }
        QLog.i("RealName", 2, "handleGetRealNameStatus, authTips is null");
        this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit().putBoolean("has_auth_real_name", bool1).commit();
      }
    } while (!QLog.isColorLevel());
    label129:
    label268:
    label274:
    label279:
    label286:
    label293:
    label300:
    QLog.i("RealName", 2, "handleGetRealNameStatus, result is: " + i);
  }
  
  private void e(GetResourceRespInfo paramGetResourceRespInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.xml", 2, "ConfigHandler.handleUpdateStatusActions, result is " + paramGetResourceRespInfo.iResult + ", server version:" + paramGetResourceRespInfo.uiNewVer);
    }
    if (paramGetResourceRespInfo.iResult == -2) {
      a(7, true, Integer.valueOf(100));
    }
    StatusManager localStatusManager;
    do
    {
      return;
      if (paramGetResourceRespInfo.iResult != 0)
      {
        a(7, false, Integer.valueOf(-1));
        return;
      }
      localStatusManager = (StatusManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14);
    } while (localStatusManager == null);
    if (!localStatusManager.a(paramGetResourceRespInfo.uiNewVer))
    {
      a(7, true, Integer.valueOf(100));
      return;
    }
    String str = paramGetResourceRespInfo.strResURL_big;
    if (TextUtils.isEmpty(str))
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.richstatus.xml", 2, "url is empty");
      }
      a(7, false, Integer.valueOf(-1));
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(new zbw(this, str, localStatusManager, paramGetResourceRespInfo));
  }
  
  private void f(GetResourceRespInfo paramGetResourceRespInfo)
  {
    if (paramGetResourceRespInfo == null) {}
    long l2;
    String str;
    do
    {
      return;
      long l1 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getLong("k_eggs_file_version", 0L);
      l2 = paramGetResourceRespInfo.uiNewVer;
      if (QLog.isColorLevel()) {
        QLog.d("eggs", 2, "handleUpdateEggsActions currentVersion: " + l1 + ", serverVersion: " + l2 + ",iResult: " + paramGetResourceRespInfo.iResult + ", bigUrl: " + paramGetResourceRespInfo.strResURL_big);
      }
      if (l2 == l1) {
        break;
      }
      str = paramGetResourceRespInfo.strResURL_big;
    } while (TextUtils.isEmpty(str));
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(new zbx(this, paramGetResourceRespInfo, str, l2));
    return;
    ThreadManager.getFileThreadHandler().post(new zby(this, paramGetResourceRespInfo));
  }
  
  public int a(ArrayList paramArrayList, GetResourceReqInfo... paramVarArgs)
  {
    ArrayList localArrayList = new ArrayList(4);
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      paramArrayList = paramArrayList.iterator();
      for (bool1 = false;; bool1 = bool2)
      {
        bool2 = bool1;
        if (!paramArrayList.hasNext()) {
          break;
        }
        GetResourceReqInfo localGetResourceReqInfo = (GetResourceReqInfo)paramArrayList.next();
        bool2 = bool1;
        if (localGetResourceReqInfo != null)
        {
          if (localGetResourceReqInfo.strPkgName.equals("QQAddFriend.AdministrateRegion")) {
            bool1 = true;
          }
          localArrayList.add(localGetResourceReqInfo);
          bool2 = bool1;
        }
      }
    }
    boolean bool2 = false;
    int j = paramVarArgs.length;
    boolean bool1 = bool2;
    int i = 0;
    while (i < j)
    {
      paramArrayList = paramVarArgs[i];
      bool2 = bool1;
      if (paramArrayList != null)
      {
        if (paramArrayList.strPkgName.equals("QQAddFriend.AdministrateRegion")) {
          bool1 = true;
        }
        localArrayList.add(paramArrayList);
        bool2 = bool1;
      }
      i += 1;
      bool1 = bool2;
    }
    if (localArrayList.size() <= 0) {
      return -1;
    }
    paramArrayList = a("ConfigService.GetResourceReq");
    paramArrayList.extraData.putSerializable("getResourceReqInfos", localArrayList);
    paramArrayList.extraData.putBoolean("reqRegionConfig", bool1);
    i = MobileQQServiceBase.jdField_a_of_type_Int;
    MobileQQServiceBase.jdField_a_of_type_Int = i + 1;
    paramArrayList.setAppSeq(i);
    if (QLog.isColorLevel()) {
      QLog.d("updateConfigs", 2, String.format("updateConfigs reqRegionConfig!, AppSeq[%s]", new Object[] { Integer.valueOf(paramArrayList.getAppSeq()) }));
    }
    a(paramArrayList);
    return paramArrayList.getAppSeq();
  }
  
  protected Class a()
  {
    return ConfigObserver.class;
  }
  
  public GetResourceReqInfo a()
  {
    long l = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getLong("k_eggs_file_version", 0L);
    if (QLog.isColorLevel()) {
      QLog.d("eggs", 2, "getEggsInfo curVersion: " + l);
    }
    GetResourceReqInfo localGetResourceReqInfo = new GetResourceReqInfo();
    localGetResourceReqInfo.uiResID = 0L;
    localGetResourceReqInfo.strPkgName = "eggs_android_CI_4.7.1";
    localGetResourceReqInfo.uiCurVer = l;
    localGetResourceReqInfo.sResType = 2;
    localGetResourceReqInfo.sLanType = 0;
    localGetResourceReqInfo.sReqType = 1;
    return localGetResourceReqInfo;
  }
  
  public void a(int paramInt, UpgradeDetailWrapper paramUpgradeDetailWrapper, UpgradeController paramUpgradeController)
  {
    paramUpgradeController = paramUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo;
    if ((paramInt == 0) && (paramUpgradeController != null))
    {
      BaseApplicationImpl.sApplication.getPackageName();
      a(paramUpgradeController);
      a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramUpgradeController.strNewTipsDescURL, paramUpgradeController.iTipsWaitDay);
      b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramUpgradeController.strBannerPicUrl, paramUpgradeController.iDisplayDay);
      b(paramUpgradeDetailWrapper);
      return;
    }
    a(true, paramUpgradeDetailWrapper);
  }
  
  public void a(UpgradeDetailWrapper paramUpgradeDetailWrapper)
  {
    if (paramUpgradeDetailWrapper != null)
    {
      paramUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo = new UpgradeInfo();
      a(false, paramUpgradeDetailWrapper);
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if (QLog.isColorLevel())
    {
      String str = paramFromServiceMsg.getServiceCmd();
      i = paramToServiceMsg.getAppSeq();
      if (paramObject != null)
      {
        bool1 = true;
        QLog.d("ConfigHandler", 2, String.format("ConfigHandler serviceCmd[%s], appseq[%s], data[%s]", new Object[] { str, Integer.valueOf(i), Boolean.valueOf(bool1) }));
      }
    }
    else
    {
      if (!"ConfigService.GetResourceReq".equals(paramFromServiceMsg.getServiceCmd())) {
        break label434;
      }
      if (paramObject != null) {
        break label119;
      }
      if (paramToServiceMsg.extraData.getBoolean("reqRegionConfig")) {
        ((ConditionSearchManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(58)).a(null);
      }
    }
    label119:
    do
    {
      return;
      bool1 = false;
      break;
      paramToServiceMsg = ((GetResourceResp)paramObject).vecResRespInfo;
    } while ((paramToServiceMsg == null) || (paramToServiceMsg.size() <= 0));
    int i = 0;
    label141:
    if (i < paramToServiceMsg.size())
    {
      paramFromServiceMsg = (GetResourceRespInfo)paramToServiceMsg.get(i);
      if (QLog.isColorLevel()) {
        QLog.d("ThemeDownloadTrace", 2, String.format("onReceive_GetResourceRespInfo. \r\n%s", new Object[] { paramFromServiceMsg }));
      }
      if (paramFromServiceMsg.sResType != 3) {
        break label230;
      }
      if (!"FileOnlinePreviewConfigV2".equals(paramFromServiceMsg.strPkgName)) {
        break label222;
      }
      c(paramFromServiceMsg);
    }
    for (;;)
    {
      i += 1;
      break label141;
      break;
      label222:
      d(paramFromServiceMsg);
      continue;
      label230:
      if (paramFromServiceMsg.sResType == 0)
      {
        if ("com.tencent.weather_bg".equals(paramFromServiceMsg.strPkgName)) {
          b(paramFromServiceMsg);
        }
      }
      else if (paramFromServiceMsg.sResType == 2)
      {
        if ("rich_status_android".equals(paramFromServiceMsg.strPkgName))
        {
          e(paramFromServiceMsg);
        }
        else if ("eggs_android_CI_4.7.1".equals(paramFromServiceMsg.strPkgName))
        {
          f(paramFromServiceMsg);
        }
        else if ("QQAddFriend.AdministrateRegion".equals(paramFromServiceMsg.strPkgName))
        {
          paramObject = (ConditionSearchManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(58);
          if (paramObject != null) {
            paramObject.a(paramFromServiceMsg);
          }
        }
        else if ("com.tencent.jumpCI".equals(paramFromServiceMsg.strPkgName))
        {
          a(paramFromServiceMsg);
        }
      }
      else if (paramFromServiceMsg.sResType == 4)
      {
        paramObject = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
        a(paramObject, paramFromServiceMsg);
        paramObject.a();
      }
      else if (paramFromServiceMsg.sResType == 512)
      {
        paramObject = (EarlyDownloadManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(76);
        if (paramObject != null) {
          paramObject.a(paramFromServiceMsg);
        }
      }
    }
    label434:
    if ("MobileTipsSvc.TipsReport".equals(paramFromServiceMsg.getServiceCmd()))
    {
      bool1 = paramFromServiceMsg.isSuccess();
      if (!bool1) {
        break label670;
      }
      paramToServiceMsg = new MobileTips.MobileTipsPkg();
    }
    label670:
    for (;;)
    {
      try
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if (paramToServiceMsg.rsp.result.get() == 0)
        {
          bool1 = bool2;
          if (QLog.isDevelopLevel()) {
            QLog.d("QQOperateVoIP", 4, "get voip_tips req ack rsp confighandler isSuccess " + bool1);
          }
          if (bool1) {
            break;
          }
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        paramFromServiceMsg.printStackTrace();
        continue;
        bool1 = false;
        continue;
      }
      if ("OidbSvc.0x82f_0".equals(paramFromServiceMsg.getServiceCmd()))
      {
        b(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("MAAControl.CheckSinglePkgSig".equals(paramFromServiceMsg.getServiceCmd()))
      {
        c(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("MAAControl.GetSinglePkgSig".equals(paramFromServiceMsg.getServiceCmd()))
      {
        d(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x9ae_2".equals(paramFromServiceMsg.getServiceCmd()))
      {
        e(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.richstatus.xml", 2, "cmdfilter error=" + paramFromServiceMsg.getServiceCmd());
      return;
    }
  }
  
  public void a(String paramString, int paramInt, ArrayList paramArrayList)
  {
    if (QLog.isDevelopLevel())
    {
      QLog.d("QQOperateVoIP", 4, "receive task, uin =" + paramString + " uinType=" + paramInt);
      localObject1 = paramArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (QQOperationViopTipTask)((Iterator)localObject1).next();
        QLog.d("QQOperateVoIP", 4, "receive task, taskid=" + ((QQOperationViopTipTask)localObject2).taskid);
      }
    }
    Object localObject1 = new OperateVoipTipsInfo();
    ((OperateVoipTipsInfo)localObject1).uin = paramString;
    ((OperateVoipTipsInfo)localObject1).uinType = paramInt;
    ((OperateVoipTipsInfo)localObject1).taskList = paramArrayList;
    Object localObject2 = QQOperateManager.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      QQOperationViopTipTask localQQOperationViopTipTask = ((QQOperateManager)localObject2).a(((QQOperationViopTipTask)paramArrayList.next()).taskid);
      if (localQQOperationViopTipTask == null)
      {
        ConfigServlet.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
        return;
      }
      QQOperationVoipTipsTaskExcuteRecord localQQOperationVoipTipsTaskExcuteRecord = new QQOperationVoipTipsTaskExcuteRecord();
      localQQOperationVoipTipsTaskExcuteRecord.taskid = localQQOperationViopTipTask.taskid;
      localQQOperationVoipTipsTaskExcuteRecord.tipType = localQQOperationViopTipTask.tipType;
      localQQOperationVoipTipsTaskExcuteRecord.uin = paramString;
      localQQOperationVoipTipsTaskExcuteRecord.uinType = paramInt;
      localQQOperationVoipTipsTaskExcuteRecord.count = 1;
      localQQOperationVoipTipsTaskExcuteRecord.time = System.currentTimeMillis();
      ((QQOperateManager)localObject2).a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, localQQOperationVoipTipsTaskExcuteRecord);
    }
    a(8, true, localObject1);
  }
  
  public void a(String paramString, int paramInt, ArrayList paramArrayList, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    for (;;)
    {
      try
      {
        Long.parseLong(paramString);
        MobileTips.MobileTipsPkg localMobileTipsPkg = new MobileTips.MobileTipsPkg();
        if (paramInt == 3000)
        {
          i = 2;
          localMobileTipsPkg.req.peer_type.set(i);
          localMobileTipsPkg.req.peer_uin.set(Long.parseLong(paramString));
          if (paramArrayList != null)
          {
            ArrayList localArrayList = new ArrayList();
            paramArrayList = paramArrayList.iterator();
            if (paramArrayList.hasNext())
            {
              QQOperationRequestTaskInfo localQQOperationRequestTaskInfo = (QQOperationRequestTaskInfo)paramArrayList.next();
              MobileTips.TaskInfo localTaskInfo = new MobileTips.TaskInfo();
              localTaskInfo.task_id.set(localQQOperationRequestTaskInfo.jdField_a_of_type_Int);
              localTaskInfo.msgcnt.set(localQQOperationRequestTaskInfo.b);
              localTaskInfo.keywords.set(localQQOperationRequestTaskInfo.jdField_a_of_type_JavaUtilArrayList);
              localTaskInfo.setHasFlag(true);
              localArrayList.add(localTaskInfo);
              continue;
            }
            localMobileTipsPkg.req.task_list.set(localArrayList);
          }
          localMobileTipsPkg.req.setHasFlag(true);
          localMobileTipsPkg.rsp.setHasFlag(true);
          localMobileTipsPkg.setHasFlag(true);
          paramArrayList = new ToServiceMsg("mobileqq.service", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "MobileTipsSvc.TipsReport");
          paramArrayList.extraData.putBoolean("isRetry", paramBoolean);
          paramArrayList.extraData.putString("chatuin", paramString);
          paramArrayList.extraData.putInt("chattype", paramInt);
          paramArrayList.putWupBuffer(localMobileTipsPkg.toByteArray());
          b(paramArrayList);
          return;
        }
      }
      catch (NumberFormatException paramString)
      {
        return;
      }
      int i = 1;
    }
  }
  
  public void a(String paramString, File paramFile)
  {
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(new zbz(this, paramString, paramFile));
  }
  
  public boolean a()
  {
    boolean bool = Verify.b(BaseApplicationImpl.sApplication);
    if (QLog.isDevelopLevel()) {
      QLog.d("UpgradeController", 4, "checkAuthIfNeccessary preCheck:" + bool);
    }
    this.jdField_b_of_type_Boolean = bool;
    if (bool) {
      return false;
    }
    Object localObject1 = null;
    try
    {
      localObject2 = ApkExternalInfoTool.a(new File(BaseApplicationImpl.sApplication.getPackageResourcePath()));
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      Object localObject2;
      label71:
      break label71;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("UpgradeController", 4, "checkAuthIfNeccessary forCode:" + localObject1);
    }
    localObject2 = a("MAAControl.CheckSinglePkgSig");
    ((ToServiceMsg)localObject2).extraData.putString("ac", localObject1);
    ((ToServiceMsg)localObject2).extraData.putInt("mv", ApkUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp()));
    ((ToServiceMsg)localObject2).extraData.putInt("sv", DeviceInfoUtil.a());
    a((ToServiceMsg)localObject2);
    return true;
  }
  
  public boolean a(String paramString1, int paramInt, String paramString2)
  {
    ToServiceMsg localToServiceMsg = a("MAAControl.GetSinglePkgSig");
    localToServiceMsg.extraData.putString("pn", paramString1);
    localToServiceMsg.extraData.putInt("vc", paramInt);
    localToServiceMsg.extraData.putString("rid", paramString2);
    localToServiceMsg.extraData.putInt("mv", ApkUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp()));
    localToServiceMsg.extraData.putInt("sv", DeviceInfoUtil.a());
    a(localToServiceMsg);
    if (QLog.isDevelopLevel()) {
      QLog.d("UpgradeController", 4, "getAuthCode:" + paramString2 + ", forPkg:" + paramString1);
    }
    return true;
  }
  
  public GetResourceReqInfo b()
  {
    long l = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getLong("k_voice_notify2_file_version", 0L);
    if (QLog.isColorLevel()) {
      QLog.d("VoiceNotify", 2, "updateVoiceNotifyConfig => curVersion: " + l);
    }
    GetResourceReqInfo localGetResourceReqInfo = new GetResourceReqInfo();
    localGetResourceReqInfo.uiResID = 0L;
    localGetResourceReqInfo.strPkgName = "QQVoiceNotifyConfig2_android_CI";
    localGetResourceReqInfo.uiCurVer = l;
    localGetResourceReqInfo.sResType = 2;
    localGetResourceReqInfo.sLanType = 0;
    localGetResourceReqInfo.sReqType = 1;
    return localGetResourceReqInfo;
  }
  
  public void b()
  {
    MqqHandler localMqqHandler = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(Conversation.class);
    if (localMqqHandler != null)
    {
      localMqqHandler.sendEmptyMessage(11340004);
      localMqqHandler.sendEmptyMessage(1134019);
    }
    a(true, null);
  }
  
  public GetResourceReqInfo c()
  {
    long l = BaseApplicationImpl.getApplication().getSharedPreferences("qq_safe_jump_whitelist", 0).getLong("key_jump_whitelist_version", 0L);
    GetResourceReqInfo localGetResourceReqInfo = new GetResourceReqInfo();
    localGetResourceReqInfo.uiResID = 0L;
    localGetResourceReqInfo.strPkgName = "com.tencent.jumpCI";
    localGetResourceReqInfo.uiCurVer = l;
    localGetResourceReqInfo.sResType = 2;
    localGetResourceReqInfo.sLanType = 0;
    localGetResourceReqInfo.sReqType = 1;
    return localGetResourceReqInfo;
  }
  
  public void c()
  {
    UpgradeController.a().a(false);
    a(false, null);
  }
  
  public GetResourceReqInfo d()
  {
    Object localObject = (StatusManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14);
    if (localObject == null) {
      return null;
    }
    long l = ((StatusManager)localObject).a();
    localObject = new GetResourceReqInfo();
    ((GetResourceReqInfo)localObject).uiResID = 0L;
    ((GetResourceReqInfo)localObject).strPkgName = "rich_status_android";
    ((GetResourceReqInfo)localObject).uiCurVer = l;
    ((GetResourceReqInfo)localObject).sResType = 2;
    ((GetResourceReqInfo)localObject).sLanType = 0;
    ((GetResourceReqInfo)localObject).sReqType = 1;
    return localObject;
  }
  
  public void d()
  {
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit().putInt("upgrade_tip_count", 0).putLong("upgrade_tip_time", 0L).putLong("YELLOW_BAR_LAST_SHOW", 0L).putBoolean("AUTO_DOWNLOADED_IN_WIFI", false).remove("APPID_SHOULD_DOWNLOAD").commit();
    b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, 0);
  }
  
  public GetResourceReqInfo e()
  {
    ConditionSearchManager localConditionSearchManager = (ConditionSearchManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(58);
    if (localConditionSearchManager == null) {
      return null;
    }
    GetResourceReqInfo localGetResourceReqInfo = new GetResourceReqInfo();
    localGetResourceReqInfo.uiResID = 0L;
    localGetResourceReqInfo.strPkgName = "QQAddFriend.AdministrateRegion";
    localGetResourceReqInfo.uiCurVer = localConditionSearchManager.a(true);
    localGetResourceReqInfo.sResType = 2;
    localGetResourceReqInfo.sLanType = 0;
    localGetResourceReqInfo.sReqType = 1;
    return localGetResourceReqInfo;
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConfigHandler", 2, "getPCActiveConfig");
    }
    try
    {
      oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
      localOIDBSSOPkg.uint32_command.set(2095);
      localOIDBSSOPkg.uint32_service_type.set(0);
      Object localObject = ByteBuffer.allocate(6);
      ((ByteBuffer)localObject).putInt(Utils.a(Long.parseLong(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()))).putShort((short)16);
      localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
      localObject = a("OidbSvc.0x82f_0");
      ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
      ((ToServiceMsg)localObject).setTimeout(30000L);
      b((ToServiceMsg)localObject);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ConfigHandler", 2, "getPCActiveConfig ex", localException);
    }
  }
  
  public GetResourceReqInfo f()
  {
    Object localObject = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("QlinkResistTerrorist", 0);
    long l1 = ((SharedPreferences)localObject).getLong("SettingQlinkResistTerroristLastTime", 0L);
    l1 = MessageCache.a() - l1;
    if (QLog.isColorLevel()) {
      QLog.i("FMConfig<FileAssistant>", 2, "verifyResistTerrorist,qlinkdur[" + l1 + "]");
    }
    String str = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    if (!((SharedPreferences)localObject).getString("SettingQlinkResistTerroristLastAccount", "0").equalsIgnoreCase(str))
    {
      if (QLog.isColorLevel()) {
        QLog.i("FMConfig<FileAssistant>", 2, "verifyResistTerrorist,change account!");
      }
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    }
    for (;;)
    {
      localObject = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("OfflineFileConfigV2", 0);
      l1 = ((SharedPreferences)localObject).getLong("FMConfigUpdateLastTime", 0L);
      long l2 = MessageCache.a();
      if (QLog.isDevelopLevel()) {
        l1 = 0L;
      }
      l1 = l2 - l1;
      if (QLog.isColorLevel()) {
        QLog.i("FMConfig<FileAssistant>", 2, "updateConfig,durtime[" + l1 + "]");
      }
      if (l1 <= 86400L) {
        break;
      }
      l1 = ((SharedPreferences)localObject).getLong("FileOnlinePreviewVersionKey", 0L);
      if (QLog.isDevelopLevel()) {
        l1 = 0L;
      }
      localObject = new GetResourceReqInfo();
      ((GetResourceReqInfo)localObject).uiResID = 0L;
      ((GetResourceReqInfo)localObject).strPkgName = "FileOnlinePreviewConfigV2";
      ((GetResourceReqInfo)localObject).uiCurVer = l1;
      ((GetResourceReqInfo)localObject).sResType = 3;
      ((GetResourceReqInfo)localObject).sLanType = 0;
      ((GetResourceReqInfo)localObject).sReqType = 1;
      if (QLog.isColorLevel()) {
        QLog.i("FMConfig<FileAssistant>", 2, "updateConfig,durtime over one day!currentVersion[" + l1 + "]");
      }
      return localObject;
      if (l1 > 86400L)
      {
        if (QLog.isColorLevel()) {
          QLog.i("FMConfig<FileAssistant>", 2, "verifyResistTerrorist,durtime over one day!");
        }
        this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      }
    }
    return null;
  }
  
  public void f()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getBoolean("has_auth_real_name", false)) {
      if (QLog.isColorLevel()) {
        QLog.i("RealName", 2, "has auth real name.");
      }
    }
    do
    {
      do
      {
        return;
        if (EquipmentLockImpl.a().a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getApplication()) != 0) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("RealName", 2, "devlock status is 0.");
      return;
      b(a("OidbSvc.0x9ae_2", 2478, 2, new cmd0x9ae.ReqBody().toByteArray()));
    } while (!QLog.isColorLevel());
    QLog.i("RealName", 2, "queryRealNameStatus");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.ConfigHandler
 * JD-Core Version:    0.7.0.1
 */