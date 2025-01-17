package com.tencent.mobileqq.app.automator;

import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.tencent.mobileqq.app.AutomatorObserver;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.service.profile.CheckUpdateItemInterface;
import com.tencent.mobileqq.startup.step.StartService;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import mqq.app.Constants.Key;

public class Automator
  extends BusinessHandler
  implements Runnable
{
  private static ThreadPoolExecutor jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor;
  public int a;
  public long a;
  public SharedPreferences a;
  private LinearGroup jdField_a_of_type_ComTencentMobileqqAppAutomatorLinearGroup;
  private HashMap jdField_a_of_type_JavaUtilHashMap = new LinkedHashMap();
  private LinkedList jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  public boolean a;
  public int b;
  private LinkedList b;
  public boolean b;
  private int c;
  public boolean c;
  private volatile boolean d;
  
  public Automator(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_Int = 1;
    this.jdField_b_of_type_JavaUtilLinkedList = new LinkedList();
  }
  
  private void a(LinearGroup paramLinearGroup)
  {
    boolean bool = true;
    if ("{85,{4,3,5,6},[11,12,14],17,20,21,59,60,22,44,45,[100,79,65,25,10,26,27,28,29,30,32,34,35,39,40,41,42,43,47,48,50,55,107,69,93,70,71,72,73,{91},53,54,61,104,63,77,81,67,80,74,36,37,38,87,88,78,82,84,98,86,102,103],57,95,105}".equals(paramLinearGroup.b)) {
      this.jdField_b_of_type_JavaUtilLinkedList.clear();
    }
    do
    {
      if (bool) {
        this.jdField_b_of_type_JavaUtilLinkedList.add(paramLinearGroup);
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 2, "addWaitingMode_Locked " + paramLinearGroup.b + " " + bool);
      }
      return;
      if ((!"{[13,16],19,21,58,60,89,23,46,33,61,42,92,96,97,99}".equals(paramLinearGroup.b)) && (!"{15,18,21,58,60,24}".equals(paramLinearGroup.b))) {
        break;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqAppAutomatorLinearGroup == null);
    bool = d();
    Iterator localIterator = this.jdField_b_of_type_JavaUtilLinkedList.iterator();
    label122:
    if (localIterator.hasNext())
    {
      AsyncStep localAsyncStep = (AsyncStep)localIterator.next();
      if ((!"{85,{4,3,5,6},[11,12,14],17,20,21,59,60,22,44,45,[100,79,65,25,10,26,27,28,29,30,32,34,35,39,40,41,42,43,47,48,50,55,107,69,93,70,71,72,73,{91},53,54,61,104,63,77,81,67,80,74,36,37,38,87,88,78,82,84,98,86,102,103],57,95,105}".equals(localAsyncStep.b)) && (!localAsyncStep.b.equals(paramLinearGroup.b))) {
        break label240;
      }
      bool = false;
    }
    label240:
    for (;;)
    {
      break label122;
      break;
      if (!"{{4,3,5,6},44,45,[100,79,65,25,10,26,27,28,29,30,32,34,35,39,40,41,42,43,47,48,50,55,107,69,93,70,71,72,73,{91},53,54,61,104,63,77,81,67,80,74,36,37,38,87,88,78,82,84,98,86,102,103],57}".equals(paramLinearGroup.b)) {
        break;
      }
      localIterator = this.jdField_b_of_type_JavaUtilLinkedList.iterator();
      bool = true;
      if (localIterator.hasNext())
      {
        if ("{85,{4,3,5,6},[11,12,14],17,20,21,59,60,22,44,45,[100,79,65,25,10,26,27,28,29,30,32,34,35,39,40,41,42,43,47,48,50,55,107,69,93,70,71,72,73,{91},53,54,61,104,63,77,81,67,80,74,36,37,38,87,88,78,82,84,98,86,102,103],57,95,105}".equals(((AsyncStep)localIterator.next()).b)) {
          bool = false;
        }
        for (;;)
        {
          break;
        }
      }
      break;
    }
  }
  
  public int a()
  {
    LinearGroup localLinearGroup = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorLinearGroup;
    if (localLinearGroup != null) {
      return StepFactory.a(localLinearGroup, false);
    }
    if (this.d) {
      return 1;
    }
    return -1;
  }
  
  public CheckUpdateItemInterface a(int paramInt)
  {
    return (CheckUpdateItemInterface)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
  }
  
  protected Class a()
  {
    return AutomatorObserver.class;
  }
  
  public HashMap a()
  {
    return this.jdField_a_of_type_JavaUtilHashMap;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "onDestroy");
    }
    synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
    {
      this.jdField_a_of_type_JavaUtilLinkedList.clear();
      this.c = 0;
    }
    synchronized (this.jdField_b_of_type_JavaUtilLinkedList)
    {
      this.jdField_b_of_type_JavaUtilLinkedList.clear();
      if (this.jdField_a_of_type_ComTencentMobileqqAppAutomatorLinearGroup != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppAutomatorLinearGroup.a(8);
        this.jdField_a_of_type_ComTencentMobileqqAppAutomatorLinearGroup = null;
      }
      this.jdField_a_of_type_Long = 0L;
      return;
      localObject1 = finally;
      throw localObject1;
    }
  }
  
  public void a(int paramInt, CheckUpdateItemInterface paramCheckUpdateItemInterface)
  {
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), paramCheckUpdateItemInterface);
  }
  
  @TargetApi(9)
  public void a(AsyncStep arg1)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "start " + ???.b);
    }
    LinearGroup localLinearGroup = (LinearGroup)???;
    synchronized (this.jdField_b_of_type_JavaUtilLinkedList)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppAutomatorLinearGroup == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppAutomatorLinearGroup = localLinearGroup;
        if (QLog.isColorLevel()) {
          QLog.d("QQInitHandler", 2, "run " + localLinearGroup.b);
        }
        if (jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor == null)
        {
          jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor = new ThreadPoolExecutor(3, 3, 1000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(24));
          if (Build.VERSION.SDK_INT > 8) {
            jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor.allowCoreThreadTimeOut(true);
          }
        }
        jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor.execute(this);
        return;
      }
      a(localLinearGroup);
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    new RuntimeException("WTF");
  }
  
  public void a(boolean paramBoolean1, long paramLong, boolean paramBoolean2)
  {
    boolean bool = false;
    if ((this.jdField_a_of_type_AndroidContentSharedPreferences != null) && (paramBoolean1)) {
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("isFriendlistok", false).commit();
    }
    if (paramLong != 0L) {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit().putLong(Constants.Key.SvcRegister_timeStamp.toString(), paramLong).commit();
    }
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("refreshAllList isListChanged=").append(paramBoolean1).append(",timeStamp=").append(paramLong).append(",accInfoPref!=null ");
      if (this.jdField_a_of_type_AndroidContentSharedPreferences != null) {
        bool = true;
      }
      QLog.d("QQInitHandler", 2, bool);
    }
    if ((paramBoolean1) || (paramBoolean2))
    {
      localStringBuilder = new StringBuilder().append("{");
      if (!paramBoolean1) {
        break label194;
      }
    }
    label194:
    for (int i = 7;; i = 8)
    {
      a(StepFactory.a(this, i + "}"));
      return;
    }
  }
  
  public void a(AsyncStep[] paramArrayOfAsyncStep)
  {
    for (;;)
    {
      int i;
      synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
      {
        this.c -= 1;
        if (this.jdField_a_of_type_JavaUtilLinkedList.size() > 0)
        {
          if (paramArrayOfAsyncStep != null)
          {
            int j = paramArrayOfAsyncStep.length;
            i = 0;
            if (i < j)
            {
              AsyncStep localAsyncStep = paramArrayOfAsyncStep[i];
              if (!this.jdField_a_of_type_JavaUtilLinkedList.remove(localAsyncStep)) {
                break label94;
              }
              b(localAsyncStep);
              return;
            }
          }
          b((AsyncStep)this.jdField_a_of_type_JavaUtilLinkedList.poll());
        }
        else
        {
          return;
        }
      }
      label94:
      i += 1;
    }
  }
  
  public boolean a()
  {
    if (!StartService.a) {
      return false;
    }
    LinearGroup localLinearGroup = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorLinearGroup;
    if (localLinearGroup != null) {
      return StepFactory.a(localLinearGroup);
    }
    return true;
  }
  
  public void b()
  {
    a(0, true, null);
  }
  
  @TargetApi(9)
  protected void b(AsyncStep paramAsyncStep)
  {
    synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
    {
      if (this.c < 3)
      {
        this.c += 1;
        if (jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor == null)
        {
          jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor = new ThreadPoolExecutor(3, 3, 1000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(24));
          if (Build.VERSION.SDK_INT > 8) {
            jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor.allowCoreThreadTimeOut(true);
          }
        }
        jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor.execute(paramAsyncStep);
        return;
      }
      this.jdField_a_of_type_JavaUtilLinkedList.add(paramAsyncStep);
    }
  }
  
  public boolean b()
  {
    LinearGroup localLinearGroup = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorLinearGroup;
    if (localLinearGroup != null) {
      if (StepFactory.a(localLinearGroup, true) != 0) {}
    }
    while (!this.d)
    {
      return true;
      return false;
    }
    return false;
  }
  
  public void c()
  {
    if (!this.d) {}
    for (;;)
    {
      return;
      boolean bool1 = true;
      boolean bool2 = true;
      LinkedList localLinkedList;
      if (this.jdField_a_of_type_ComTencentMobileqqAppAutomatorLinearGroup != null)
      {
        localLinkedList = this.jdField_b_of_type_JavaUtilLinkedList;
        bool1 = bool2;
      }
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqAppAutomatorLinearGroup != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppAutomatorLinearGroup.a(4);
          bool1 = d();
        }
        if (!bool1) {
          continue;
        }
        a(StepFactory.a(this, "{[13,16],19,21,58,60,89,23,46,33,61,42,92,96,97,99}"));
        return;
      }
      finally {}
    }
  }
  
  public boolean c()
  {
    LinearGroup localLinearGroup = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorLinearGroup;
    if (localLinearGroup != null) {
      return StepFactory.b(localLinearGroup);
    }
    return true;
  }
  
  public void d()
  {
    a(StepFactory.a(this, "{15,18,21,58,60,24}"));
  }
  
  public boolean d()
  {
    LinearGroup localLinearGroup = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorLinearGroup;
    if (localLinearGroup != null) {
      return StepFactory.c(localLinearGroup);
    }
    return true;
  }
  
  public void e()
  {
    a(4, true, null);
  }
  
  public boolean e()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppAutomatorLinearGroup != null;
  }
  
  public void run()
  {
    int i;
    if (!this.d) {
      i = 0;
    }
    for (;;)
    {
      synchronized (this.jdField_b_of_type_JavaUtilLinkedList)
      {
        if (!this.d)
        {
          i = 1;
          this.d = true;
        }
        if (i != 0) {
          StepFactory.a(this, "2").run();
        }
        ??? = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorLinearGroup;
        if (??? != null) {
          ((AsyncStep)???).run();
        }
      }
      synchronized (this.jdField_b_of_type_JavaUtilLinkedList)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppAutomatorLinearGroup = ((LinearGroup)this.jdField_b_of_type_JavaUtilLinkedList.poll());
        if (this.jdField_a_of_type_ComTencentMobileqqAppAutomatorLinearGroup == null)
        {
          return;
          localObject2 = finally;
          throw localObject2;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.Automator
 * JD-Core Version:    0.7.0.1
 */