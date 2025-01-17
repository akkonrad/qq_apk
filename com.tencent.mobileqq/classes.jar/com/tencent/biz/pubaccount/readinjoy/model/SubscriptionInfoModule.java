package com.tencent.biz.pubaccount.readinjoy.model;

import android.content.Context;
import android.os.Handler;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyMSFService;
import com.tencent.biz.pubaccount.subscript.SubscriptionFeed;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.PublicAccountObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import lrt;
import lru;
import lrv;
import lrw;
import lrx;
import lry;
import lrz;
import lsa;
import mqq.os.MqqHandler;

public class SubscriptionInfoModule
  extends ReadInJoyEngineModule
{
  protected long a;
  private PublicAccountObserver jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver = new lrz(this);
  private List jdField_a_of_type_JavaUtilList;
  private long jdField_b_of_type_Long;
  private Handler jdField_b_of_type_AndroidOsHandler = new lsa(this, ThreadManager.getSubThreadLooper());
  
  public SubscriptionInfoModule(AppInterface paramAppInterface, EntityManager paramEntityManager, ExecutorService paramExecutorService, ReadInJoyMSFService paramReadInJoyMSFService, Handler paramHandler)
  {
    super(paramAppInterface, paramEntityManager, paramExecutorService, paramReadInJoyMSFService, paramHandler);
    this.jdField_a_of_type_Long = 2000L;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new lry(this, paramInt1, paramInt2));
  }
  
  public int a()
  {
    int i = 0;
    int j = 0;
    if (!(this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)) {
      return j;
    }
    Iterator localIterator = TroopBarAssistantManager.a().b((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface).iterator();
    for (;;)
    {
      j = i;
      if (!localIterator.hasNext()) {
        break;
      }
      i = ((SubscriptionFeed)localIterator.next()).b + i;
    }
  }
  
  public SubscriptionFeed a()
  {
    Object localObject2 = null;
    SubscriptionFeed localSubscriptionFeed = null;
    List localList = TroopBarAssistantManager.a().b((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    Object localObject1 = localObject2;
    int i;
    if (localList != null)
    {
      localObject1 = localObject2;
      if (!localList.isEmpty())
      {
        i = 0;
        localObject1 = localSubscriptionFeed;
        if (i < localList.size()) {
          if (((SubscriptionFeed)localList.get(i)).b > 0) {}
        }
      }
    }
    for (;;)
    {
      i += 1;
      break;
      if ((localSubscriptionFeed == null) || (((SubscriptionFeed)localList.get(i)).jdField_a_of_type_Long > localSubscriptionFeed.jdField_a_of_type_Long))
      {
        localSubscriptionFeed = (SubscriptionFeed)localList.get(i);
        continue;
        return localObject1;
      }
    }
  }
  
  public List a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver = null;
    if (this.jdField_b_of_type_AndroidOsHandler != null)
    {
      this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_b_of_type_AndroidOsHandler = null;
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
  
  public void a(String paramString)
  {
    int j;
    SubscriptionFeed localSubscriptionFeed;
    if (!TroopBarAssistantManager.a().a(paramString, (QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface))
    {
      TroopBarAssistantManager.a().b(paramString, (QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      PublicAccountReportUtils.a(null, "CliOper", "", "", "0X8006112", "0X8006112", 0, 0, "", "", "", "");
      j = TroopBarAssistantManager.a().a();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localSubscriptionFeed = (SubscriptionFeed)localIterator.next();
      } while ((localSubscriptionFeed.jdField_a_of_type_JavaLangString == null) || (!localSubscriptionFeed.jdField_a_of_type_JavaLangString.equals(paramString)));
    }
    for (int i = localSubscriptionFeed.b;; i = 0)
    {
      f();
      ReportController.b(null, "dc00899", "Pb_account_lifeservice", paramString, "0X80064CD", "0X80064CD", 0, 0, "" + i, "" + j, "", "");
      return;
    }
  }
  
  public void a(String paramString, Context paramContext)
  {
    if (!(this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SubscriptionInfoModule", 2, "mApp isn't instanceof QQAppInterface unFollowSubscribeAccount failed!");
      }
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new lrw(this, paramString, paramContext));
    paramContext = this.jdField_a_of_type_JavaUtilList.iterator();
    SubscriptionFeed localSubscriptionFeed;
    do
    {
      if (!paramContext.hasNext()) {
        break;
      }
      localSubscriptionFeed = (SubscriptionFeed)paramContext.next();
    } while ((localSubscriptionFeed.jdField_a_of_type_JavaLangString == null) || (!localSubscriptionFeed.jdField_a_of_type_JavaLangString.equals(paramString)));
    for (int i = localSubscriptionFeed.b;; i = 0)
    {
      ReportController.b(null, "dc00899", "Pb_account_lifeservice", paramString, "0X80064CF", "0X80064CF", 0, 0, "" + i, "", "", "");
      return;
    }
  }
  
  public void a(List paramList)
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new lrv(this, paramList));
  }
  
  public void b() {}
  
  public void b(String paramString)
  {
    TroopBarAssistantManager.a().c(paramString, (QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    int j = TroopBarAssistantManager.a().a();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    SubscriptionFeed localSubscriptionFeed;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localSubscriptionFeed = (SubscriptionFeed)localIterator.next();
    } while ((localSubscriptionFeed.jdField_a_of_type_JavaLangString == null) || (!localSubscriptionFeed.jdField_a_of_type_JavaLangString.equals(paramString)));
    for (int i = localSubscriptionFeed.b;; i = 0)
    {
      f();
      ReportController.b(null, "dc00899", "Pb_account_lifeservice", paramString, "0X80064CE", "0X80064CE", 0, 0, "" + i, "" + j, "", "");
      return;
    }
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)) {}
  }
  
  public void c(String paramString)
  {
    if (!(this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SubscriptionInfoModule", 2, "mApp isn't instanceof QQAppInterface unFollowSubscribeAccount failed!");
      }
      return;
    }
    TroopBarAssistantManager.a().a(paramString, (QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    f();
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new lrx(this, paramString));
    Object localObject = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getHandler(Conversation.class);
    if (localObject != null) {
      ((MqqHandler)localObject).sendEmptyMessage(1014);
    }
    localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    SubscriptionFeed localSubscriptionFeed;
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      localSubscriptionFeed = (SubscriptionFeed)((Iterator)localObject).next();
    } while ((localSubscriptionFeed.jdField_a_of_type_JavaLangString == null) || (!localSubscriptionFeed.jdField_a_of_type_JavaLangString.equals(paramString)));
    for (int i = localSubscriptionFeed.b;; i = 0)
    {
      ReportController.b(null, "dc00899", "Pb_account_lifeservice", paramString, "0X80064D0", "0X80064D0", 0, 0, "" + i, "", "", "");
      return;
    }
  }
  
  public void d()
  {
    if (!(this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)) {
      if (QLog.isColorLevel()) {
        QLog.d("SubscriptionInfoModule", 2, "mApp isn't instanceof QQAppInterface init model failed!");
      }
    }
    while (this.jdField_a_of_type_JavaUtilConcurrentExecutorService == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new lrt(this));
  }
  
  public void e() {}
  
  public void f()
  {
    if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)) {
      this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new lru(this));
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("SubscriptionInfoModule", 2, "mApp isn't instanceof QQAppInterface");
  }
  
  public void g()
  {
    long l2 = Math.abs(System.currentTimeMillis() - this.jdField_b_of_type_Long);
    long l1 = l2;
    if (l2 < 0L) {
      l1 = this.jdField_a_of_type_Long + 1L;
    }
    if (l1 < this.jdField_a_of_type_Long)
    {
      this.jdField_b_of_type_AndroidOsHandler.removeMessages(10002);
      this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessageDelayed(10002, this.jdField_a_of_type_Long - l1 + 50L);
      return;
    }
    this.jdField_b_of_type_AndroidOsHandler.removeMessages(10002);
    this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(10002);
    this.jdField_b_of_type_Long = System.currentTimeMillis();
  }
  
  public void h()
  {
    a(((KandianMergeManager)((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface).getManager(161)).a(1), 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.SubscriptionInfoModule
 * JD-Core Version:    0.7.0.1
 */