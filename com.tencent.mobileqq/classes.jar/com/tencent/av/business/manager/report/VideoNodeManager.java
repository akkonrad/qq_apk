package com.tencent.av.business.manager.report;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.av.AVLog;
import com.tencent.av.SessionMgr;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import jgh;

public class VideoNodeManager
{
  public static int a;
  private static Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new jgh();
  private static Handler jdField_a_of_type_AndroidOsHandler;
  private static HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private static VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  private static String jdField_a_of_type_JavaLangString;
  private static Map jdField_a_of_type_JavaUtilMap = new HashMap();
  
  private static int a()
  {
    String str = a("0");
    if ((str == null) || (str.equals("0"))) {
      return 0;
    }
    return 1;
  }
  
  private static int a(Map paramMap)
  {
    long l = c();
    return (int)((float)Long.valueOf(a("22", "0", paramMap)).longValue() / (float)l * 100.0F);
  }
  
  public static long a()
  {
    SessionInfo localSessionInfo = SessionMgr.a().a();
    if (localSessionInfo == null) {
      return 0L;
    }
    return localSessionInfo.j;
  }
  
  private static String a(String paramString)
  {
    return BaseApplicationImpl.getApplication().getSystemSharedPreferences(jdField_a_of_type_JavaLangString, 0).getString(paramString, null);
  }
  
  private static String a(String paramString1, String paramString2, Map paramMap)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (paramMap == null)) {
      return null;
    }
    if (paramMap.containsKey(paramString1)) {
      return (String)paramMap.get(paramString1);
    }
    return paramString2;
  }
  
  private static String a(Map paramMap)
  {
    if ((paramMap == null) || (paramMap.size() == 0)) {}
    while ((Build.MODEL != null) && ("Android SDK built for x86".equals(Build.MODEL))) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramMap != null) && (paramMap.size() > 0))
    {
      localStringBuilder.append("Android").append('|');
      localStringBuilder.append(String.valueOf(Build.VERSION.SDK_INT)).append('|');
      localStringBuilder.append("7.6.3").append('|');
      localStringBuilder.append(Build.MANUFACTURER).append('|');
      localStringBuilder.append(Build.MODEL).append('|');
      localStringBuilder.append(a("9", "0", paramMap)).append('|');
      localStringBuilder.append(c()).append('|');
      localStringBuilder.append(a("11", "0", paramMap)).append('|');
      localStringBuilder.append(a("12", "0", paramMap)).append('|');
      localStringBuilder.append(a("13", "0", paramMap)).append('|');
      localStringBuilder.append(a("14", "0", paramMap)).append('|');
      localStringBuilder.append(a("15", "0", paramMap)).append('|');
      localStringBuilder.append(a("16", "0", paramMap)).append('|');
      localStringBuilder.append(a("17", "0", paramMap)).append('|');
      localStringBuilder.append(a("18", "0", paramMap)).append('|');
      localStringBuilder.append(a("19", "0", paramMap)).append('|');
      localStringBuilder.append(a("20", "0", paramMap)).append('|');
      localStringBuilder.append(c() + "").append('|');
      localStringBuilder.append(a("22", "0", paramMap)).append('|');
      localStringBuilder.append(a("23", "0", paramMap)).append('|');
      localStringBuilder.append(a("24", "0", paramMap)).append('|');
      localStringBuilder.append(a("25", "0", paramMap)).append('|');
      localStringBuilder.append(a("26", "0", paramMap)).append('|');
      localStringBuilder.append(a("27", "0", paramMap)).append('|');
      localStringBuilder.append(a("28", "0", paramMap)).append('|');
      localStringBuilder.append(a("29", "0", paramMap)).append('|');
      localStringBuilder.append(a("30", "0", paramMap)).append('|');
      localStringBuilder.append(a("31", "0", paramMap)).append('|');
      localStringBuilder.append(a("32", "0", paramMap)).append('|');
      localStringBuilder.append(a("33", "0", paramMap)).append('|');
      localStringBuilder.append(a("34", "0", paramMap)).append('|');
      localStringBuilder.append(a("35", "0", paramMap)).append('|');
      localStringBuilder.append(a("36", "0", paramMap)).append('|');
      localStringBuilder.append(a("37", "0", paramMap)).append('|');
      localStringBuilder.append(a("38", "0", paramMap)).append('|');
      localStringBuilder.append(a("39", "0", paramMap)).append('|');
      localStringBuilder.append("6").append('|');
      localStringBuilder.append(a("41", "0", paramMap)).append('|');
      localStringBuilder.append(a(paramMap)).append('|');
      localStringBuilder.append(a("43", "0", paramMap)).append('|');
      localStringBuilder.append(a("44", "0", paramMap)).append('|');
      localStringBuilder.append(a("45", "0", paramMap)).append('|');
      localStringBuilder.append(a("46", "0", paramMap)).append('|');
      localStringBuilder.append(a("47", "0", paramMap)).append('|');
    }
    return localStringBuilder.toString();
  }
  
  public static void a()
  {
    a(a());
  }
  
  public static void a(int paramInt)
  {
    a(a(), paramInt, d(), true);
  }
  
  public static void a(int paramInt, long paramLong)
  {
    a(a(), paramInt, paramLong, false);
  }
  
  public static void a(int paramInt, long paramLong, boolean paramBoolean)
  {
    if (paramInt == 20) {
      jdField_a_of_type_Int = (int)paramLong;
    }
    for (;;)
    {
      return;
      if ((paramInt == 27) || (paramInt == 28) || (paramInt == 36) || (paramInt == 29) || (paramInt == 31) || (paramInt == 32) || (paramInt == 30))
      {
        if (SmallScreenUtils.f(BaseApplicationImpl.getApplication())) {}
        for (int i = 1; i != jdField_a_of_type_Int; i = 2)
        {
          jdField_a_of_type_Int = i;
          AVLog.a("VideoNodeManager", "checkAppOnForeground()  isAppOnForeground change !!! = " + jdField_a_of_type_Int);
          if (paramBoolean) {
            break label162;
          }
          d(paramInt + "", jdField_a_of_type_Int + "", false);
          return;
        }
      }
    }
    label162:
    c(paramInt + "", jdField_a_of_type_Int + "", false);
  }
  
  public static void a(int paramInt, boolean paramBoolean)
  {
    if (paramInt != 0) {}
    for (;;)
    {
      return;
      if (!paramBoolean)
      {
        try
        {
          if (a() != 0) {
            continue;
          }
          e();
          AVLog.a("VideoNodeManager", "--> checkAndClearSession() ***********************************");
          continue;
        }
        finally {}
      }
      else if (!b())
      {
        f();
        AVLog.b("VideoNodeManager", "--> checkAndClearSession()  temp ***********************************");
      }
    }
  }
  
  public static void a(long paramLong)
  {
    AVLog.a("VideoNodeManager", "--> onSessionCreate() roomId = " + paramLong);
    if (jdField_a_of_type_AndroidOsHandler != null)
    {
      jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
    }
    if (a(paramLong)) {
      g();
    }
    a(paramLong, 0, 1L);
  }
  
  public static void a(long paramLong, int paramInt)
  {
    a(paramLong, paramInt, d(), true);
  }
  
  public static void a(long paramLong1, int paramInt, long paramLong2)
  {
    a(paramLong1, paramInt, paramLong2, false);
  }
  
  private static void a(long paramLong1, int paramInt, long paramLong2, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        if ((jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) || (jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() == null) || (jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a() == null))
        {
          QLog.e("VideoNodeManager", 1, "reportToHandler param is null  !!!!!!!!!-------------------");
          return;
        }
        if (!jdField_a_of_type_ComTencentAvAppVideoAppInterface.e) {
          break label114;
        }
        break label114;
        if ((b()) && (b(paramInt)))
        {
          c(paramLong1, paramInt, paramLong2, paramBoolean);
          b(paramLong1, paramInt, paramLong2, paramBoolean);
          continue;
        }
        if (a(paramLong1)) {
          continue;
        }
      }
      finally {}
      c(paramLong1, paramInt, paramLong2, paramBoolean);
      continue;
      label114:
      if ((paramLong1 == 0L) || (paramLong1 != -1L)) {}
    }
  }
  
  public static void a(VideoAppInterface paramVideoAppInterface)
  {
    AVLog.a("VideoNodeManager", "--> init()");
    jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    String[] arrayOfString = BaseApplicationImpl.processName.split(":");
    Object localObject = null;
    paramVideoAppInterface = localObject;
    if (arrayOfString != null)
    {
      paramVideoAppInterface = localObject;
      if (arrayOfString.length == 2) {
        paramVideoAppInterface = arrayOfString[1];
      }
    }
    jdField_a_of_type_JavaLangString = "video_node_manager_" + paramVideoAppInterface;
    if (jdField_a_of_type_AndroidOsHandler == null)
    {
      jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("VideoNodeReportThread");
      jdField_a_of_type_AndroidOsHandlerThread.start();
      jdField_a_of_type_AndroidOsHandler = new Handler(jdField_a_of_type_AndroidOsHandlerThread.getLooper(), jdField_a_of_type_AndroidOsHandler$Callback);
    }
  }
  
  public static boolean a()
  {
    return a() == 1;
  }
  
  public static boolean a(int paramInt, boolean paramBoolean)
  {
    if ((!paramBoolean) && (a(paramInt + "") != null))
    {
      AVLog.b("VideoNodeManager", "--> checkNodeHasWrite() the node is has writh !!!!!!!!!!!!!!!!!!!!!!!!! node = " + VideoNodeConstant.a(paramInt));
      return true;
    }
    if ((paramBoolean) && (jdField_a_of_type_JavaUtilMap.get(paramInt + "") != null))
    {
      AVLog.b("VideoNodeManager", "--> checkNodeHasWrite() temp ,the node is has writh !!!!!!!!!!!!!!!!!!!!!!!!! node = " + VideoNodeConstant.a(paramInt));
      return true;
    }
    return false;
  }
  
  public static boolean a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((!paramBoolean2) && (paramInt != 0)) {}
    do
    {
      do
      {
        return false;
      } while ((paramInt == 31) || (paramInt == 32));
      if ((!paramBoolean1) && (a(paramInt + "") != null))
      {
        AVLog.b("VideoNodeManager", "--> checkNodeHasWrite() the node is has writh !!!!!!!!!!!!!!!!!!!!!!!!! node = " + VideoNodeConstant.a(paramInt));
        return true;
      }
    } while ((!paramBoolean1) || (jdField_a_of_type_JavaUtilMap.get(paramInt + "") == null));
    AVLog.b("VideoNodeManager", "--> checkNodeHasWrite() temp ,the node is has writh !!!!!!!!!!!!!!!!!!!!!!!!! node = " + VideoNodeConstant.a(paramInt));
    return true;
  }
  
  public static boolean a(long paramLong)
  {
    return (a() == -1L) || (a() == 0L) || (paramLong == a());
  }
  
  public static long b()
  {
    if (SessionMgr.a().a().d == 0L) {
      return 0L;
    }
    return (SystemClock.elapsedRealtime() - SessionMgr.a().a().d) / 1000L + SessionMgr.a().a().e;
  }
  
  public static void b()
  {
    AVLog.a("VideoNodeManager", "--> release()");
    jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    if (jdField_a_of_type_AndroidOsHandler != null)
    {
      jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      jdField_a_of_type_AndroidOsHandler = null;
      jdField_a_of_type_AndroidOsHandlerThread.quit();
      jdField_a_of_type_AndroidOsHandlerThread = null;
    }
  }
  
  public static void b(int paramInt)
  {
    AVLog.a("VideoNodeManager", "=========> setSessionType()  original sessionType = " + paramInt);
    if ((paramInt == 1) || (paramInt == 2)) {
      a(15, 1L);
    }
    while ((paramInt != 3) && (paramInt != 4)) {
      return;
    }
    a(15, 2L);
  }
  
  public static void b(long paramLong)
  {
    jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    if (a(paramLong))
    {
      AVLog.a("VideoNodeManager", "--> onSessionDestroy() roomId = " + paramLong);
      g();
      return;
    }
    AVLog.b("VideoNodeManager", "--> onSessionDestroy() TempSessionRecord roomId = " + paramLong);
    h();
  }
  
  private static void b(long paramLong1, int paramInt, long paramLong2, boolean paramBoolean)
  {
    Message localMessage = jdField_a_of_type_AndroidOsHandler.obtainMessage();
    localMessage.what = 2;
    Bundle localBundle = new Bundle();
    localBundle.putLong("roomId", paramLong1);
    localBundle.putInt("node", paramInt);
    localBundle.putLong("value", paramLong2);
    localBundle.putBoolean("isNode", paramBoolean);
    localMessage.setData(localBundle);
    jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  private static boolean b()
  {
    String str = (String)jdField_a_of_type_JavaUtilMap.get("0");
    return (str != null) && (str.equals("1"));
  }
  
  private static boolean b(int paramInt)
  {
    return (paramInt == 20) || (paramInt == 19) || (paramInt == 18) || (paramInt == 23) || (paramInt == 21) || (paramInt == 22);
  }
  
  private static long c()
  {
    return DeviceInfoUtil.e() / 1024L / 1024L;
  }
  
  private static String c()
  {
    if ((jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin() != null)) {
      return jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
    }
    return "0";
  }
  
  public static void c()
  {
    try
    {
      long l1 = DeviceInfoUtil.f() / 1024L / 1024L;
      long l2 = DeviceInfoUtil.a(Process.myPid()) / 1024L / 1024L;
      a(22, l1);
      a(23, l2);
      return;
    }
    catch (Exception localException)
    {
      QLog.d("VideoNodeManager", 1, "reportMemoryStatus,Exception ", localException);
    }
  }
  
  private static void c(long paramLong1, int paramInt, long paramLong2, boolean paramBoolean)
  {
    Message localMessage = jdField_a_of_type_AndroidOsHandler.obtainMessage();
    localMessage.what = 6;
    Bundle localBundle = new Bundle();
    localBundle.putLong("roomId", paramLong1);
    localBundle.putInt("node", paramInt);
    localBundle.putLong("value", paramLong2);
    localBundle.putBoolean("isNode", paramBoolean);
    localMessage.setData(localBundle);
    jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  private static void c(String paramString1, String paramString2, boolean paramBoolean)
  {
    jdField_a_of_type_JavaUtilMap.put(paramString1, paramString2);
    if (paramBoolean) {
      jdField_a_of_type_JavaUtilMap.put("17", paramString1);
    }
  }
  
  private static boolean c(int paramInt)
  {
    return (paramInt != 24) && (paramInt != 18) && (paramInt != 23) && (paramInt != 21) && (paramInt != 22);
  }
  
  private static long d()
  {
    return System.currentTimeMillis();
  }
  
  private static String d()
  {
    return a(BaseApplicationImpl.getApplication().getSystemSharedPreferences(jdField_a_of_type_JavaLangString, 0).getAll());
  }
  
  public static void d()
  {
    AVLog.a("VideoNodeManager", "--> reportToServer() ----------------------------------------");
    jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
  }
  
  private static void d(String paramString1, String paramString2, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSystemSharedPreferences(jdField_a_of_type_JavaLangString, 0).edit();
    localEditor.putString(paramString1, paramString2);
    if (paramBoolean) {
      localEditor.putString("17", paramString1 + "");
    }
    localEditor.commit();
  }
  
  private static String e()
  {
    return a(jdField_a_of_type_JavaUtilMap);
  }
  
  public static void e()
  {
    QLog.d("VideoNodeManager", 1, "--> resetVideoNode() ----------------------------------------");
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSystemSharedPreferences(jdField_a_of_type_JavaLangString, 0).edit();
    localEditor.clear();
    localEditor.commit();
  }
  
  public static void f()
  {
    QLog.e("VideoNodeManager", 1, "--> resetTempSeesionRecord() ----------------------------------------");
    jdField_a_of_type_JavaUtilMap.clear();
  }
  
  public static void g()
  {
    try
    {
      int i = a();
      AVLog.a("VideoNodeManager", "--> checkAndReport() reportStatus = " + i);
      if (i == 1)
      {
        AVLog.a("VideoNodeManager", "--> checkAndReport() ***********************************");
        d();
      }
      return;
    }
    finally {}
  }
  
  public static void h()
  {
    AVLog.b("VideoNodeManager", "--> checkAndReportTempRecord() ***********************************");
    if (b()) {
      i();
    }
  }
  
  public static void i()
  {
    AVLog.b("VideoNodeManager", "--> reportTempRecordToServer() =================================");
    jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(5);
  }
  
  public static void j()
  {
    AVLog.b("VideoNodeManager", "=========> SYNC Start !!---------------------------  mTempSeesionRecord.size() = " + jdField_a_of_type_JavaUtilMap.size());
    if (b())
    {
      e();
      if (jdField_a_of_type_JavaUtilMap.size() > 0)
      {
        SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSystemSharedPreferences(jdField_a_of_type_JavaLangString, 0).edit();
        Iterator localIterator = jdField_a_of_type_JavaUtilMap.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          AVLog.b("VideoNodeManager", "=========> SYNC Temp !!   node= " + VideoNodeConstant.a(Integer.valueOf((String)localEntry.getKey()).intValue()) + "     Value = " + (String)localEntry.getValue());
          localEditor.putString((String)localEntry.getKey(), (String)localEntry.getValue());
        }
        localEditor.commit();
      }
    }
    AVLog.b("VideoNodeManager", "=========> SYNC end !!----------------------------------");
    f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.business.manager.report.VideoNodeManager
 * JD-Core Version:    0.7.0.1
 */