package com.tencent.mobileqq.app;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Handler;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.CPU;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Camera;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.ConfigSeq;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.DeviceInfo;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Memory;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.OS;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.ReqGetConfig;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.RespGetConfig;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Screen;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Storage;
import com.tencent.mobileqq.cooperation.ApkUtils;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.ReflectedMethods;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.xml.sax.InputSource;
import zct;
import zcu;
import zcv;

public class DeviceProfileManager
{
  private static DeviceProfileManager.AccountDpcManager jdField_a_of_type_ComTencentMobileqqAppDeviceProfileManager$AccountDpcManager;
  private static volatile DeviceProfileManager jdField_a_of_type_ComTencentMobileqqAppDeviceProfileManager;
  public static ConfigurationService.ReqGetConfig a;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private static List jdField_a_of_type_JavaUtilList;
  public static boolean a;
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "featureValue" };
  private static Field[] jdField_a_of_type_ArrayOfJavaLangReflectField;
  public static boolean b;
  public int a;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new zct(this);
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(1);
  private HashMap b;
  boolean c = false;
  
  private DeviceProfileManager()
  {
    this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
    b();
  }
  
  /* Error */
  public static int a(String paramString, Object[] paramArrayOfObject, DeviceProfileManager.StringParser paramStringParser)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: aload_1
    //   4: ifnull +108 -> 112
    //   7: aload_2
    //   8: ifnull +104 -> 112
    //   11: aload_0
    //   12: invokestatic 67	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   15: ifne +97 -> 112
    //   18: aload_0
    //   19: ldc 69
    //   21: invokevirtual 73	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   24: astore_0
    //   25: aload_0
    //   26: arraylength
    //   27: aload_1
    //   28: arraylength
    //   29: invokestatic 79	java/lang/Math:min	(II)I
    //   32: istore_3
    //   33: iload_3
    //   34: istore 4
    //   36: iload 5
    //   38: iload_3
    //   39: if_icmpge +66 -> 105
    //   42: aload_1
    //   43: iload 5
    //   45: aload_2
    //   46: aload_0
    //   47: iload 5
    //   49: aaload
    //   50: invokeinterface 84 2 0
    //   55: aastore
    //   56: iload 5
    //   58: iconst_1
    //   59: iadd
    //   60: istore 5
    //   62: goto -29 -> 33
    //   65: astore_0
    //   66: iconst_0
    //   67: istore_3
    //   68: iload_3
    //   69: istore 4
    //   71: invokestatic 90	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   74: ifeq +31 -> 105
    //   77: ldc 92
    //   79: iconst_2
    //   80: new 94	java/lang/StringBuilder
    //   83: dup
    //   84: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   87: ldc 97
    //   89: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: aload_0
    //   93: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   96: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   99: invokestatic 112	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   102: iload_3
    //   103: istore 4
    //   105: iload 4
    //   107: ireturn
    //   108: astore_0
    //   109: goto -41 -> 68
    //   112: iconst_0
    //   113: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	114	0	paramString	String
    //   0	114	1	paramArrayOfObject	Object[]
    //   0	114	2	paramStringParser	DeviceProfileManager.StringParser
    //   32	71	3	i	int
    //   34	72	4	j	int
    //   1	60	5	k	int
    // Exception table:
    //   from	to	target	type
    //   18	33	65	java/lang/Exception
    //   42	56	108	java/lang/Exception
  }
  
  private DeviceProfileManager.DPCConfigInfo a(String paramString)
  {
    HashMap localHashMap;
    if (DeviceProfileManager.AccountDpcManager.jdField_a_of_type_JavaUtilHashSet.contains(paramString))
    {
      if (jdField_a_of_type_ComTencentMobileqqAppDeviceProfileManager$AccountDpcManager == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("DeviceProfileManager", 2, "getFeatureValue() accountDpcManager is null");
        }
        return null;
      }
      if (QLog.isColorLevel()) {
        QLog.d("DeviceProfileManager", 2, "getFeatureValue() accountDpcNames=" + paramString);
      }
      localHashMap = jdField_a_of_type_ComTencentMobileqqAppDeviceProfileManager$AccountDpcManager.jdField_a_of_type_JavaUtilHashMap;
      paramString = DeviceProfileManager.AccountDpcManager.a(jdField_a_of_type_ComTencentMobileqqAppDeviceProfileManager$AccountDpcManager, paramString);
    }
    for (;;)
    {
      return (DeviceProfileManager.DPCConfigInfo)localHashMap.get(paramString);
      localHashMap = this.jdField_a_of_type_JavaUtilHashMap;
    }
  }
  
  public static DeviceProfileManager a()
  {
    return a(BaseApplicationImpl.sApplication.getRuntime(), 67);
  }
  
  public static DeviceProfileManager a(AppRuntime paramAppRuntime)
  {
    return a(paramAppRuntime, 67);
  }
  
  public static DeviceProfileManager a(AppRuntime paramAppRuntime, int paramInt)
  {
    if (paramAppRuntime != null)
    {
      paramAppRuntime = paramAppRuntime.getManager(paramInt);
      if ((paramAppRuntime instanceof DeviceProfileManager.AccountDpcManager)) {
        jdField_a_of_type_ComTencentMobileqqAppDeviceProfileManager$AccountDpcManager = (DeviceProfileManager.AccountDpcManager)paramAppRuntime;
      }
    }
    if (jdField_a_of_type_ComTencentMobileqqAppDeviceProfileManager == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqAppDeviceProfileManager == null) {
        jdField_a_of_type_ComTencentMobileqqAppDeviceProfileManager = new DeviceProfileManager();
      }
      return jdField_a_of_type_ComTencentMobileqqAppDeviceProfileManager;
    }
    finally {}
  }
  
  public static ConfigurationService.ReqGetConfig a(AppInterface paramAppInterface)
  {
    if ((jdField_a_of_type_Boolean) && (jdField_a_of_type_ComTencentMobileqqConfigStructSplashprotoConfigurationService$ReqGetConfig != null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("DeviceProfileManager", 2, "test mode is enable");
      }
      a(jdField_a_of_type_ComTencentMobileqqConfigStructSplashprotoConfigurationService$ReqGetConfig);
      return jdField_a_of_type_ComTencentMobileqqConfigStructSplashprotoConfigurationService$ReqGetConfig;
    }
    Object localObject1 = new ConfigurationService.OS();
    ((ConfigurationService.OS)localObject1).setHasFlag(true);
    ((ConfigurationService.OS)localObject1).type.set(2);
    ((ConfigurationService.OS)localObject1).kernel.set(DeviceInfoUtil.n());
    ((ConfigurationService.OS)localObject1).sdk.set(String.valueOf(DeviceInfoUtil.a()));
    ((ConfigurationService.OS)localObject1).version.set(DeviceInfoUtil.f());
    ((ConfigurationService.OS)localObject1).rom.set(DeviceInfoUtil.k());
    ConfigurationService.CPU localCPU = new ConfigurationService.CPU();
    localCPU.setHasFlag(true);
    localCPU.model.set(DeviceInfoUtil.h());
    localCPU.cores.set(DeviceInfoUtil.b());
    localCPU.frequency.set((int)DeviceInfoUtil.a());
    ConfigurationService.Memory localMemory = new ConfigurationService.Memory();
    localMemory.setHasFlag(true);
    localMemory.total.set(DeviceInfoUtil.e());
    localMemory.process.set(DeviceInfoUtil.g());
    ConfigurationService.Storage localStorage = new ConfigurationService.Storage();
    localStorage.setHasFlag(true);
    localStorage.builtin.set(DeviceInfoUtil.d());
    Object localObject2 = DeviceInfoUtil.b();
    localStorage.external.set(localObject2[0] * 1048576L + localObject2[1] * 1024L * 1024L);
    localObject2 = new ConfigurationService.Screen();
    ((ConfigurationService.Screen)localObject2).setHasFlag(true);
    ((ConfigurationService.Screen)localObject2).model.set("");
    ((ConfigurationService.Screen)localObject2).width.set((int)DeviceInfoUtil.h());
    ((ConfigurationService.Screen)localObject2).height.set((int)DeviceInfoUtil.i());
    ((ConfigurationService.Screen)localObject2).dpi.set(DeviceInfoUtil.d());
    ((ConfigurationService.Screen)localObject2).multi_touch.set(DeviceInfoUtil.c());
    ConfigurationService.Camera localCamera = new ConfigurationService.Camera();
    localCamera.setHasFlag(true);
    localCamera.primary.set(0L);
    localCamera.secondary.set(0L);
    localCamera.flash.set(false);
    Object localObject3 = new ConfigurationService.ConfigSeq();
    ((ConfigurationService.ConfigSeq)localObject3).setHasFlag(true);
    ((ConfigurationService.ConfigSeq)localObject3).type.set(4);
    long l1 = System.currentTimeMillis();
    SharedPreferences localSharedPreferences = ReflectedMethods.a(BaseApplicationImpl.getContext(), "dpcConfig_account");
    long l2 = localSharedPreferences.getLong(DeviceProfileManager.AccountDpcManager.a(paramAppInterface, "last_update_time"), 0L);
    int k = ApkUtils.a(BaseApplicationImpl.getContext());
    int m = localSharedPreferences.getInt("key_versioncode", 0);
    if (QLog.isColorLevel()) {
      QLog.d("DeviceProfileManager", 2, "DeviceProfileManager.KEY_LAST_UPDATE_TIME=" + l2 + ",nowSystemTime=" + l1 + "versionCode=" + k + ",key_versioncode=" + m);
    }
    int j = 0;
    int i = j;
    if (172800L > Math.abs(l1 - l2) / 1000L)
    {
      i = j;
      if (m >= k) {
        i = localSharedPreferences.getInt(DeviceProfileManager.AccountDpcManager.a(paramAppInterface, "server_version"), 0);
      }
    }
    ((ConfigurationService.ConfigSeq)localObject3).version.set(i);
    paramAppInterface = new ArrayList();
    paramAppInterface.add(localObject3);
    localObject3 = new ConfigurationService.DeviceInfo();
    ((ConfigurationService.DeviceInfo)localObject3).setHasFlag(true);
    ((ConfigurationService.DeviceInfo)localObject3).brand.set(DeviceInfoUtil.i());
    ((ConfigurationService.DeviceInfo)localObject3).model.set(DeviceInfoUtil.e());
    ((ConfigurationService.DeviceInfo)localObject3).os = ((ConfigurationService.OS)localObject1);
    ((ConfigurationService.DeviceInfo)localObject3).cpu = localCPU;
    ((ConfigurationService.DeviceInfo)localObject3).memory = localMemory;
    ((ConfigurationService.DeviceInfo)localObject3).storage = localStorage;
    ((ConfigurationService.DeviceInfo)localObject3).screen = ((ConfigurationService.Screen)localObject2);
    ((ConfigurationService.DeviceInfo)localObject3).camera = localCamera;
    localObject1 = new ConfigurationService.ReqGetConfig();
    ((ConfigurationService.ReqGetConfig)localObject1).device_info = ((ConfigurationService.DeviceInfo)localObject3);
    ((ConfigurationService.ReqGetConfig)localObject1).seq_list.addAll(paramAppInterface);
    a((ConfigurationService.ReqGetConfig)localObject1);
    return localObject1;
  }
  
  private void a()
  {
    Object localObject = DeviceProfileManager.DpcNames.values();
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      localDPCConfigInfo = localObject[i];
      this.jdField_b_of_type_JavaUtilHashMap.put(localDPCConfigInfo.name(), new DeviceProfileManager.DPCConfigInfo());
      i += 1;
    }
    localObject = new DeviceProfileManager.DPCConfigInfo();
    ((DeviceProfileManager.DPCConfigInfo)localObject).featureValue = "1";
    this.jdField_b_of_type_JavaUtilHashMap.put(DeviceProfileManager.DpcNames.magicface_support.name(), localObject);
    DeviceProfileManager.DPCConfigInfo localDPCConfigInfo = new DeviceProfileManager.DPCConfigInfo();
    localDPCConfigInfo.featureValue = "1";
    this.jdField_b_of_type_JavaUtilHashMap.put(DeviceProfileManager.DpcNames.h5magic_support.name(), localDPCConfigInfo);
    new DeviceProfileManager.DPCConfigInfo().featureValue = "1";
    this.jdField_b_of_type_JavaUtilHashMap.put(DeviceProfileManager.DpcNames.aio_eggs.name(), localObject);
    localObject = new DeviceProfileManager.DPCConfigInfo();
    ((DeviceProfileManager.DPCConfigInfo)localObject).featureValue = "1|3|10|30|约会打招呼|有人在约会上给你打招呼，快去看看！";
    this.jdField_b_of_type_JavaUtilHashMap.put(DeviceProfileManager.DpcNames.OneyWayDateMsgNotifyCfg.name(), localObject);
    localObject = new DeviceProfileManager.DPCConfigInfo();
    ((DeviceProfileManager.DPCConfigInfo)localObject).featureValue = "1|5|10|50|附近打招呼|有附近的人给你打招呼，快去看看！";
    this.jdField_b_of_type_JavaUtilHashMap.put(DeviceProfileManager.DpcNames.OneyWayLBSFriendMsgNotifyCfg.name(), localObject);
  }
  
  private void a(long paramLong)
  {
    if (a() != 4) {
      synchronized (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger)
      {
        int i = a();
        if (i != 4) {}
        try
        {
          if (QLog.isColorLevel()) {
            QLog.d("DeviceProfileManager", 2, "waitDPCServerData() is waiting threadID=" + Thread.currentThread().getId());
          }
          this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.wait(paramLong);
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            localInterruptedException.printStackTrace();
            if (QLog.isColorLevel()) {
              QLog.e("DeviceProfileManager", 1, "waitDpcServerData failed", localInterruptedException);
            }
          }
        }
        return;
      }
    }
  }
  
  public static void a(DeviceProfileManager.DPCObserver paramDPCObserver)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_JavaUtilList == null) {
        jdField_a_of_type_JavaUtilList = new ArrayList();
      }
      if ((paramDPCObserver != null) && (!jdField_a_of_type_JavaUtilList.contains(paramDPCObserver))) {
        jdField_a_of_type_JavaUtilList.add(paramDPCObserver);
      }
      return;
    }
  }
  
  private static void a(ConfigurationService.ReqGetConfig paramReqGetConfig)
  {
    ConfigurationService.DeviceInfo localDeviceInfo = paramReqGetConfig.device_info;
    StringBuilder localStringBuilder = new StringBuilder(1024);
    localStringBuilder.append("config.version = " + ((ConfigurationService.ConfigSeq)paramReqGetConfig.seq_list.get(0)).version.get() + "\n");
    localStringBuilder.append("buidldReqConfig{");
    localStringBuilder.append(" brand= ");
    localStringBuilder.append(localDeviceInfo.brand.get());
    localStringBuilder.append(" ,model= ");
    localStringBuilder.append(localDeviceInfo.model.get());
    localStringBuilder.append(" ,os.type= ");
    localStringBuilder.append(localDeviceInfo.os.type.get());
    localStringBuilder.append(" ,os.kernel= ");
    localStringBuilder.append(localDeviceInfo.os.kernel.get());
    localStringBuilder.append(" ,os.sdk= ");
    localStringBuilder.append(localDeviceInfo.os.sdk.get());
    localStringBuilder.append(" ,os.version= ");
    localStringBuilder.append(localDeviceInfo.os.version.get());
    localStringBuilder.append(" ,os.rom= ");
    localStringBuilder.append(localDeviceInfo.os.rom.get());
    localStringBuilder.append(" ,cpu.model= ");
    localStringBuilder.append(localDeviceInfo.cpu.model.get());
    localStringBuilder.append(" ,cpu.cores= ");
    localStringBuilder.append(localDeviceInfo.cpu.cores.get());
    localStringBuilder.append(" ,cpu.frequency= ");
    localStringBuilder.append(localDeviceInfo.cpu.frequency.get());
    localStringBuilder.append(" ,memory.total= ");
    localStringBuilder.append(localDeviceInfo.memory.total.get());
    localStringBuilder.append(" ,memory.process= ");
    localStringBuilder.append(localDeviceInfo.memory.process.get());
    localStringBuilder.append(" ,storage.builtin= ");
    localStringBuilder.append(localDeviceInfo.storage.builtin.get());
    localStringBuilder.append(" ,storage.external= ");
    localStringBuilder.append(localDeviceInfo.storage.external.get());
    localStringBuilder.append(" ,screen.model= ");
    localStringBuilder.append(localDeviceInfo.screen.model.get());
    localStringBuilder.append(" ,screen.width= ");
    localStringBuilder.append(localDeviceInfo.screen.width.get());
    localStringBuilder.append(" ,screen.height= ");
    localStringBuilder.append(localDeviceInfo.screen.height.get());
    localStringBuilder.append(" ,screen.dpi= ");
    localStringBuilder.append(localDeviceInfo.screen.dpi.get());
    localStringBuilder.append(" ,screen.multi_touch= ");
    localStringBuilder.append(localDeviceInfo.screen.multi_touch.get());
    localStringBuilder.append(" ,camera.primary= ");
    localStringBuilder.append(localDeviceInfo.camera.primary.get());
    localStringBuilder.append(" ,camera.secondary= ");
    localStringBuilder.append(localDeviceInfo.camera.secondary.get());
    localStringBuilder.append(" ,camera.flash= ");
    localStringBuilder.append(localDeviceInfo.camera.flash.get());
    localStringBuilder.append(" }");
    QLog.i("DeviceProfileManager", 1, localStringBuilder.toString());
  }
  
  public static DeviceProfileManager b()
  {
    if (jdField_a_of_type_ComTencentMobileqqAppDeviceProfileManager == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqAppDeviceProfileManager == null) {
        jdField_a_of_type_ComTencentMobileqqAppDeviceProfileManager = new DeviceProfileManager();
      }
      return jdField_a_of_type_ComTencentMobileqqAppDeviceProfileManager;
    }
    finally {}
  }
  
  @TargetApi(9)
  private void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("DeviceProfileManager", 2, "DeviceProfileManager init DPC content");
    }
    jdField_b_of_type_Boolean = true;
    a();
    SharedPreferences localSharedPreferences = ReflectedMethods.a(BaseApplicationImpl.getApplication(), "dpcConfig");
    this.jdField_a_of_type_Int = localSharedPreferences.getInt("ab_rand", -1);
    Object localObject;
    int i;
    label122:
    DeviceProfileManager.DpcNames localDpcNames;
    String str;
    if (this.jdField_a_of_type_Int == -1)
    {
      this.jdField_a_of_type_Int = new Random().nextInt(10000);
      localObject = localSharedPreferences.edit();
      ((SharedPreferences.Editor)localObject).putInt("ab_rand", this.jdField_a_of_type_Int);
      if (Build.VERSION.SDK_INT < 9) {
        ((SharedPreferences.Editor)localObject).commit();
      }
    }
    else
    {
      DeviceProfileManager.DpcNames[] arrayOfDpcNames = DeviceProfileManager.DpcNames.values();
      int j = arrayOfDpcNames.length;
      i = 0;
      if (i >= j) {
        return;
      }
      localDpcNames = arrayOfDpcNames[i];
      str = localSharedPreferences.getString(localDpcNames.name(), "");
      if (!"".equals(str)) {
        break label262;
      }
      localObject = (DeviceProfileManager.DPCConfigInfo)((DeviceProfileManager.DPCConfigInfo)this.jdField_b_of_type_JavaUtilHashMap.get(localDpcNames.name())).clone();
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilHashMap.put(localDpcNames.name(), localObject);
      if (QLog.isColorLevel()) {
        QLog.i("DeviceProfileManager", 2, "init loop mFeatureMapLV2 MAP: " + localDpcNames.name() + "=" + ((DeviceProfileManager.DPCConfigInfo)localObject).toString());
      }
      i += 1;
      break label122;
      ((SharedPreferences.Editor)localObject).apply();
      break;
      label262:
      localObject = new DeviceProfileManager.DPCConfigInfo();
      b((DeviceProfileManager.DPCConfigInfo)localObject, str);
    }
  }
  
  public static void b(DeviceProfileManager.DPCObserver paramDPCObserver)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if ((jdField_a_of_type_JavaUtilList != null) && (paramDPCObserver != null)) {
        jdField_a_of_type_JavaUtilList.remove(paramDPCObserver);
      }
      return;
    }
  }
  
  private static void b(boolean paramBoolean)
  {
    for (;;)
    {
      int i;
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        if (jdField_a_of_type_JavaUtilList == null) {
          return;
        }
        i = jdField_a_of_type_JavaUtilList.size() - 1;
        if (i >= 0)
        {
          DeviceProfileManager.DPCObserver localDPCObserver = (DeviceProfileManager.DPCObserver)jdField_a_of_type_JavaUtilList.get(i);
          if (localDPCObserver == null) {
            break label68;
          }
          localDPCObserver.a(paramBoolean);
        }
      }
      return;
      label68:
      i -= 1;
    }
  }
  
  private static boolean b(DeviceProfileManager.DPCConfigInfo paramDPCConfigInfo, String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0) || (paramDPCConfigInfo == null)) {}
    String[] arrayOfString;
    do
    {
      return false;
      arrayOfString = new String[1];
      arrayOfString[0] = paramString.toString().trim();
    } while ((arrayOfString == null) || (arrayOfString.length == 0));
    if (jdField_a_of_type_ArrayOfJavaLangReflectField == null)
    {
      jdField_a_of_type_ArrayOfJavaLangReflectField = new Field[jdField_a_of_type_ArrayOfJavaLangString.length];
      i = 0;
      for (;;)
      {
        if (i < jdField_a_of_type_ArrayOfJavaLangReflectField.length) {
          try
          {
            jdField_a_of_type_ArrayOfJavaLangReflectField[i] = paramDPCConfigInfo.getClass().getField(jdField_a_of_type_ArrayOfJavaLangString[i]);
            jdField_a_of_type_ArrayOfJavaLangReflectField[i].setAccessible(true);
            i += 1;
          }
          catch (NoSuchFieldException paramString)
          {
            for (;;)
            {
              paramString.printStackTrace();
              jdField_a_of_type_ArrayOfJavaLangReflectField[i] = null;
            }
          }
        }
      }
    }
    int j = Math.min(jdField_a_of_type_ArrayOfJavaLangReflectField.length, arrayOfString.length);
    int i = 0;
    boolean bool1 = false;
    boolean bool2;
    while (i < j)
    {
      paramString = arrayOfString[i];
      bool2 = bool1;
      if (paramString != null)
      {
        if (paramString.length() == 0) {
          bool2 = bool1;
        }
      }
      else
      {
        i += 1;
        bool1 = bool2;
        continue;
      }
      if ((paramString.indexOf('{', 0) != 0) || (paramString.lastIndexOf('}') != paramString.length() - 1)) {
        break label288;
      }
      paramString = paramString.substring(1, paramString.length() - 1);
    }
    label285:
    label288:
    for (;;)
    {
      try
      {
        if ((jdField_a_of_type_ArrayOfJavaLangReflectField[i] == null) || (paramString.equals((String)jdField_a_of_type_ArrayOfJavaLangReflectField[i].get(paramDPCConfigInfo)))) {
          break label285;
        }
        jdField_a_of_type_ArrayOfJavaLangReflectField[i].set(paramDPCConfigInfo, paramString);
        bool1 = true;
        bool2 = bool1;
      }
      catch (IllegalArgumentException paramString)
      {
        paramString.printStackTrace();
        bool2 = bool1;
      }
      catch (IllegalAccessException paramString)
      {
        paramString.printStackTrace();
        bool2 = bool1;
      }
      break;
      return bool1;
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
  }
  
  /* Error */
  public String a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: invokespecial 752	com/tencent/mobileqq/app/DeviceProfileManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/app/DeviceProfileManager$DPCConfigInfo;
    //   7: astore_2
    //   8: invokestatic 90	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11: ifeq +50 -> 61
    //   14: new 94	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   21: ldc_w 754
    //   24: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: aload_1
    //   28: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: ldc_w 683
    //   34: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: astore_3
    //   38: aload_2
    //   39: ifnull +51 -> 90
    //   42: aload_2
    //   43: invokevirtual 684	com/tencent/mobileqq/app/DeviceProfileManager$DPCConfigInfo:toString	()Ljava/lang/String;
    //   46: astore_1
    //   47: ldc 92
    //   49: iconst_2
    //   50: aload_3
    //   51: aload_1
    //   52: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   58: invokestatic 112	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   61: aload_2
    //   62: ifnull +20 -> 82
    //   65: aload_2
    //   66: getfield 498	com/tencent/mobileqq/app/DeviceProfileManager$DPCConfigInfo:featureValue	Ljava/lang/String;
    //   69: ifnull +13 -> 82
    //   72: aload_2
    //   73: getfield 498	com/tencent/mobileqq/app/DeviceProfileManager$DPCConfigInfo:featureValue	Ljava/lang/String;
    //   76: invokevirtual 710	java/lang/String:length	()I
    //   79: ifne +18 -> 97
    //   82: ldc_w 306
    //   85: astore_1
    //   86: aload_0
    //   87: monitorexit
    //   88: aload_1
    //   89: areturn
    //   90: ldc_w 756
    //   93: astore_1
    //   94: goto -47 -> 47
    //   97: aload_2
    //   98: getfield 498	com/tencent/mobileqq/app/DeviceProfileManager$DPCConfigInfo:featureValue	Ljava/lang/String;
    //   101: astore_1
    //   102: goto -16 -> 86
    //   105: astore_1
    //   106: aload_0
    //   107: monitorexit
    //   108: aload_1
    //   109: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	110	0	this	DeviceProfileManager
    //   0	110	1	paramString	String
    //   7	91	2	localDPCConfigInfo	DeviceProfileManager.DPCConfigInfo
    //   37	14	3	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   2	38	105	finally
    //   42	47	105	finally
    //   47	61	105	finally
    //   65	82	105	finally
    //   97	102	105	finally
  }
  
  /* Error */
  public String a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: invokevirtual 758	com/tencent/mobileqq/app/DeviceProfileManager:a	(Ljava/lang/String;)Ljava/lang/String;
    //   7: astore 4
    //   9: aload_2
    //   10: astore_1
    //   11: aload 4
    //   13: ifnull +18 -> 31
    //   16: ldc_w 306
    //   19: aload 4
    //   21: invokevirtual 675	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   24: istore_3
    //   25: iload_3
    //   26: ifeq +9 -> 35
    //   29: aload_2
    //   30: astore_1
    //   31: aload_0
    //   32: monitorexit
    //   33: aload_1
    //   34: areturn
    //   35: aload 4
    //   37: astore_1
    //   38: goto -7 -> 31
    //   41: astore_1
    //   42: aload_0
    //   43: monitorexit
    //   44: aload_1
    //   45: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	46	0	this	DeviceProfileManager
    //   0	46	1	paramString1	String
    //   0	46	2	paramString2	String
    //   24	2	3	bool	boolean
    //   7	29	4	str	String
    // Exception table:
    //   from	to	target	type
    //   2	9	41	finally
    //   16	25	41	finally
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(paramInt);
    if (paramInt == 4) {
      synchronized (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger)
      {
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.notifyAll();
        return;
      }
    }
  }
  
  public void a(AppInterface paramAppInterface)
  {
    if ((paramAppInterface == null) || (this.c)) {}
    do
    {
      return;
      paramAppInterface = paramAppInterface.getApplication();
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.tentcent.mobileqq.dpc.broadcast");
      try
      {
        paramAppInterface.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter, "com.tencent.msg.permission.pushnotify", new Handler(ThreadManager.getSubThreadLooper()));
        this.c = true;
        return;
      }
      catch (Exception paramAppInterface) {}
    } while (!QLog.isColorLevel());
    QLog.d("DeviceProfileManager", 2, "registerBroadCast failed! e = " + paramAppInterface + " msg = " + paramAppInterface.getMessage());
  }
  
  public boolean a(ConfigurationService.RespGetConfig paramRespGetConfig, String paramString)
  {
    try
    {
      ThreadManager.getSubThreadHandler().post(new zcu(this, paramRespGetConfig, paramString));
      return true;
    }
    finally
    {
      paramRespGetConfig = finally;
      throw paramRespGetConfig;
    }
  }
  
  public boolean a(String paramString)
  {
    for (;;)
    {
      try
      {
        Object localObject;
        if (DeviceProfileManager.AccountDpcManager.jdField_a_of_type_JavaUtilHashSet.contains(paramString))
        {
          if (jdField_a_of_type_ComTencentMobileqqAppDeviceProfileManager$AccountDpcManager == null)
          {
            if (QLog.isDevelopLevel()) {
              QLog.e("DeviceProfileManager", 2, "isFeatureSupported() accountDpcManager is null");
            }
            bool = false;
            return bool;
          }
          if (QLog.isColorLevel()) {
            QLog.d("DeviceProfileManager", 2, "isFeatureSupported() accountDpcNames=" + paramString);
          }
          localObject = jdField_a_of_type_ComTencentMobileqqAppDeviceProfileManager$AccountDpcManager.jdField_a_of_type_JavaUtilHashMap;
          paramString = DeviceProfileManager.AccountDpcManager.a(jdField_a_of_type_ComTencentMobileqqAppDeviceProfileManager$AccountDpcManager, paramString);
          localObject = (DeviceProfileManager.DPCConfigInfo)((HashMap)localObject).get(paramString);
          if ((QLog.isColorLevel()) && (localObject != null)) {
            QLog.d("DeviceProfileManager", 2, "isFeatureSupported: " + paramString + "=" + ((DeviceProfileManager.DPCConfigInfo)localObject).toString());
          }
          if ((localObject == null) || (((DeviceProfileManager.DPCConfigInfo)localObject).featureValue == null)) {
            break label235;
          }
          if (((DeviceProfileManager.DPCConfigInfo)localObject).featureValue.length() == 0) {
            break label235;
          }
        }
        else
        {
          localObject = this.jdField_a_of_type_JavaUtilHashMap;
          continue;
        }
        if ((((DeviceProfileManager.DPCConfigInfo)localObject).featureValue.equals("0")) || (((DeviceProfileManager.DPCConfigInfo)localObject).featureValue.equals("2"))) {
          break label240;
        }
        bool = ((DeviceProfileManager.DPCConfigInfo)localObject).featureValue.equals("1");
        if (bool)
        {
          bool = true;
          continue;
        }
        bool = false;
        continue;
        bool = false;
      }
      finally {}
      label235:
      continue;
      label240:
      boolean bool = false;
    }
  }
  
  public boolean a(String paramString, long paramLong)
  {
    a(paramLong);
    return a(paramString);
  }
  
  public boolean a(String paramString, HashMap paramHashMap)
  {
    QLog.i("DeviceProfileManager", 1, "dpcStart{" + SecUtil.xor(paramString, "7.6.3") + "}dpcEnd");
    if ((paramString == null) || (paramString.length() == 0)) {
      return false;
    }
    paramHashMap = new zcv(paramHashMap);
    try
    {
      SAXParserFactory.newInstance().newSAXParser().parse(new InputSource(new ByteArrayInputStream(paramString.getBytes("utf-8"))), paramHashMap);
      return true;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("DeviceProfileManager", 2, "pareseDCPXML", paramString);
      }
      paramString.printStackTrace();
    }
    return false;
  }
  
  public void b(AppInterface paramAppInterface)
  {
    if (paramAppInterface == null) {
      return;
    }
    try
    {
      paramAppInterface.getApplication().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      return;
    }
    catch (Exception paramAppInterface) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.DeviceProfileManager
 * JD-Core Version:    0.7.0.1
 */