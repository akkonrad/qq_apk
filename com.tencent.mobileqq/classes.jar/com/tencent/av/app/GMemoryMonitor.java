package com.tencent.av.app;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.av.VideoController;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.statistics.DcReportUtil;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import jes;
import mqq.app.MobileQQ;

public class GMemoryMonitor
{
  ComponentCallbacks a;
  public VideoAppInterface a;
  
  public GMemoryMonitor(VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
  }
  
  public void a()
  {
    if (Build.VERSION.SDK_INT >= 14) {}
    try
    {
      if (this.jdField_a_of_type_AndroidContentComponentCallbacks != null)
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().unregisterComponentCallbacks(this.jdField_a_of_type_AndroidContentComponentCallbacks);
        this.jdField_a_of_type_AndroidContentComponentCallbacks = null;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("GMemoryMonitor", 2, "onDestroy unregisterComponentCallbacks failed", localThrowable);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GMemoryMonitor", 2, "reportLowMemory  level = " + paramInt + ",isExit = " + paramBoolean);
    }
    try
    {
      Object localObject1 = new HashMap();
      ((HashMap)localObject1).put("lowMemoryLevel", String.valueOf(paramInt));
      ((HashMap)localObject1).put("isExit", String.valueOf(paramBoolean));
      StatisticCollector.a(BaseApplicationImpl.getApplication()).a(null, "av_qua_low_memory", true, 0L, 0L, (HashMap)localObject1, "", true);
      localObject1 = Build.MODEL;
      String str1 = String.valueOf(Build.VERSION.SDK_INT);
      String str2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
      StringBuilder localStringBuilder = new StringBuilder();
      Object localObject2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a();
      if (localObject2 != null)
      {
        String str3 = ((SessionInfo)localObject2).c;
        localObject2 = ((SessionInfo)localObject2).b;
        String str4 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a(str3) + "";
        if (QLog.isColorLevel()) {
          QLog.d("GMemoryMonitor", 2, "reportLowMemory  ,roomID = " + str4);
        }
        localStringBuilder.append("Android").append('|');
        localStringBuilder.append((String)localObject1).append('|');
        localStringBuilder.append(str1).append('|');
        localStringBuilder.append(str1).append('|');
        localStringBuilder.append(str2).append('|');
        localStringBuilder.append(str3).append('|');
        localStringBuilder.append(str4).append('|');
        localStringBuilder.append((String)localObject2).append('|');
        localStringBuilder.append(paramInt);
      }
      localObject1 = localStringBuilder.toString();
      if (QLog.isColorLevel()) {
        QLog.d("GMemoryMonitor", 2, "reportLowMemory  dcDetail = " + (String)localObject1);
      }
      DcReportUtil.a(null, "dc02660", (String)localObject1);
      return;
    }
    catch (Exception localException)
    {
      QLog.d("GMemoryMonitor", 1, "reportLowMemory  Exception", localException);
    }
  }
  
  public void b()
  {
    if (Build.VERSION.SDK_INT >= 14) {}
    try
    {
      if (this.jdField_a_of_type_AndroidContentComponentCallbacks == null)
      {
        this.jdField_a_of_type_AndroidContentComponentCallbacks = new jes(this);
        BaseApplicationImpl.getApplication().getApplicationContext().registerComponentCallbacks(this.jdField_a_of_type_AndroidContentComponentCallbacks);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.d("GMemoryMonitor", 1, "registerComponentCallbacks failed", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.app.GMemoryMonitor
 * JD-Core Version:    0.7.0.1
 */