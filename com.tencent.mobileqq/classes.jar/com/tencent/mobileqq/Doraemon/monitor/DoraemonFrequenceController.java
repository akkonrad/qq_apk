package com.tencent.mobileqq.Doraemon.monitor;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.util.LruCache;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DoraemonFrequenceController
  implements DoraemonAPIReporter.OnFrequenceDataUpdateListener
{
  private static DoraemonFrequenceController jdField_a_of_type_ComTencentMobileqqDoraemonMonitorDoraemonFrequenceController;
  LruCache jdField_a_of_type_AndroidUtilLruCache = new LruCache(5);
  DoraemonAPIReporter jdField_a_of_type_ComTencentMobileqqDoraemonMonitorDoraemonAPIReporter;
  Map jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  
  private DoraemonFrequenceController()
  {
    if (BaseApplicationImpl.sProcessId == 1) {
      if (QLog.isColorLevel()) {
        QLog.d("DoraemonOpenAPI.freqCtrl", 2, "create reporter");
      }
    }
    for (this.jdField_a_of_type_ComTencentMobileqqDoraemonMonitorDoraemonAPIReporter = new DoraemonAPIReporterMain();; this.jdField_a_of_type_ComTencentMobileqqDoraemonMonitorDoraemonAPIReporter = new DoraemonAPIReporterProxy())
    {
      this.jdField_a_of_type_ComTencentMobileqqDoraemonMonitorDoraemonAPIReporter.a(this);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("DoraemonOpenAPI.freqCtrl", 2, "create reporter proxy");
      }
    }
  }
  
  public static DoraemonFrequenceController a()
  {
    if (jdField_a_of_type_ComTencentMobileqqDoraemonMonitorDoraemonFrequenceController == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqDoraemonMonitorDoraemonFrequenceController == null) {
        jdField_a_of_type_ComTencentMobileqqDoraemonMonitorDoraemonFrequenceController = new DoraemonFrequenceController();
      }
      return jdField_a_of_type_ComTencentMobileqqDoraemonMonitorDoraemonFrequenceController;
    }
    finally {}
  }
  
  @NonNull
  private Map a(String paramString1, int paramInt, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoraemonOpenAPI.freqCtrl", 2, "init key=" + paramString1);
    }
    int i = 0;
    int j = 0;
    Map localMap = (Map)this.jdField_a_of_type_AndroidUtilLruCache.get(paramString1);
    Object localObject = localMap;
    if (localMap == null) {}
    try
    {
      localMap = (Map)this.jdField_a_of_type_AndroidUtilLruCache.get(paramString1);
      localObject = localMap;
      i = j;
      if (localMap == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("DoraemonOpenAPI.freqCtrl", 2, "init create cache map, key=" + paramString1);
        }
        localObject = new ConcurrentHashMap();
        this.jdField_a_of_type_AndroidUtilLruCache.put(paramString1, localObject);
        i = 1;
      }
      if (i != 0) {
        this.jdField_a_of_type_ComTencentMobileqqDoraemonMonitorDoraemonAPIReporter.a(paramString1, paramInt, paramString2);
      }
      return localObject;
    }
    finally {}
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    a(paramString1, paramInt, paramString2);
  }
  
  public void a(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoraemonOpenAPI.freqCtrl", 2, "report key=" + paramString1 + ", api=" + paramString3);
    }
    this.jdField_a_of_type_ComTencentMobileqqDoraemonMonitorDoraemonAPIReporter.a(paramString1, paramInt, paramString2, paramString3);
  }
  
  public void a(String paramString1, int paramInt, String paramString2, String paramString3, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoraemonOpenAPI.freqCtrl", 2, "update key=" + paramString1 + ", api=" + paramString3 + ", remain=" + paramLong1);
    }
    Object localObject = (Map)this.jdField_a_of_type_AndroidUtilLruCache.get(paramString1);
    APIQuotaItem localAPIQuotaItem;
    if (localObject != null)
    {
      localAPIQuotaItem = (APIQuotaItem)((Map)localObject).get(paramString3);
      if (localAPIQuotaItem != null) {
        break label222;
      }
      localAPIQuotaItem = new APIQuotaItem();
      localAPIQuotaItem.remainTimes = paramLong1;
      localAPIQuotaItem.expireTimeMillis = paramLong2;
      ((Map)localObject).put(paramString3, localAPIQuotaItem);
    }
    for (;;)
    {
      if ((BaseApplicationImpl.sProcessId == 1) && (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString1)))
      {
        localObject = new Intent("com.tencent.mobileqq.Doraemon.monitor.update");
        ((Intent)localObject).putExtra("key", paramString1);
        ((Intent)localObject).putExtra("type", paramInt);
        ((Intent)localObject).putExtra("appid", paramString2);
        ((Intent)localObject).putExtra("api", paramString3);
        ((Intent)localObject).putExtra("remain", paramLong1);
        ((Intent)localObject).putExtra("time", paramLong2);
        BaseApplicationImpl.getContext().sendBroadcast((Intent)localObject, "com.tencent.msg.permission.pushnotify");
      }
      return;
      label222:
      localAPIQuotaItem.remainTimes = paramLong1;
      localAPIQuotaItem.expireTimeMillis = paramLong2;
    }
  }
  
  public void a(String paramString, HashMap paramHashMap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoraemonOpenAPI.freqCtrl", 2, "update all key=" + paramString);
    }
    Object localObject = (Map)this.jdField_a_of_type_AndroidUtilLruCache.get(paramString);
    if (localObject != null) {
      ((Map)localObject).putAll(paramHashMap);
    }
    if ((BaseApplicationImpl.sProcessId == 1) && (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString)))
    {
      localObject = new Intent("com.tencent.mobileqq.Doraemon.monitor.update_batch");
      ((Intent)localObject).putExtra("key", paramString);
      ((Intent)localObject).putExtra("map", paramHashMap);
      BaseApplicationImpl.getContext().sendBroadcast((Intent)localObject, "com.tencent.msg.permission.pushnotify");
    }
  }
  
  public boolean a(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    Object localObject = (Map)this.jdField_a_of_type_AndroidUtilLruCache.get(paramString1);
    if (localObject == null) {}
    for (paramString2 = a(paramString1, paramInt, paramString2);; paramString2 = (String)localObject)
    {
      localObject = (APIQuotaItem)paramString2.get(paramString3);
      long l = NetConnInfoCenter.getServerTimeMillis();
      if (localObject == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("DoraemonOpenAPI.freqCtrl", 2, "no record use default key=" + paramString1 + ", api=" + paramString3);
        }
        paramString1 = new APIQuotaItem();
        paramString1.remainTimes = 10L;
        paramString1.expireTimeMillis = (l + 60000L);
        paramString2.put(paramString3, paramString1);
        return true;
      }
      if (((APIQuotaItem)localObject).remainTimes > 0L)
      {
        if (QLog.isColorLevel()) {
          QLog.d("DoraemonOpenAPI.freqCtrl", 2, "has quota key=" + paramString1 + ", api=" + paramString3 + ", remain=" + ((APIQuotaItem)localObject).remainTimes);
        }
        return true;
      }
      if (((APIQuotaItem)localObject).expireTimeMillis < l)
      {
        if (QLog.isColorLevel()) {
          QLog.d("DoraemonOpenAPI.freqCtrl", 2, "expired use default key=" + paramString1 + ", api=" + paramString3);
        }
        ((APIQuotaItem)localObject).remainTimes = 10L;
        ((APIQuotaItem)localObject).expireTimeMillis = (l + 60000L);
        return true;
      }
      if (QLog.isColorLevel()) {
        QLog.d("DoraemonOpenAPI.freqCtrl", 2, "no quota key=" + paramString1 + ", api=" + paramString3);
      }
      return false;
    }
  }
  
  public void b(String paramString1, int paramInt, String paramString2)
  {
    if (BaseApplicationImpl.sProcessId != 1) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("DoraemonOpenAPI.freqCtrl", 2, "load from proxy key=" + paramString1);
    }
    this.jdField_a_of_type_JavaUtilMap.put(paramString1, Boolean.TRUE);
    this.jdField_a_of_type_ComTencentMobileqqDoraemonMonitorDoraemonAPIReporter.a(paramString1, paramInt, paramString2);
  }
  
  public void b(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    if (BaseApplicationImpl.sProcessId != 1) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("DoraemonOpenAPI.freqCtrl", 2, "report from proxy key=" + paramString1 + ", api=" + paramString3);
    }
    this.jdField_a_of_type_JavaUtilMap.put(paramString1, Boolean.TRUE);
    this.jdField_a_of_type_ComTencentMobileqqDoraemonMonitorDoraemonAPIReporter.a(paramString1, paramInt, paramString2, paramString3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.monitor.DoraemonFrequenceController
 * JD-Core Version:    0.7.0.1
 */