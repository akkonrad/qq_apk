package com.tencent.biz.pubaccount.readinjoy.video;

import android.os.Bundle;
import com.tencent.biz.pubaccount.PublicAccountArticleHandler;
import com.tencent.biz.pubaccount.VideoPlayCountHandler;
import com.tencent.biz.pubaccount.VideoPlayRecommendHandler;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

public class VideoFeedsAppInterface
  extends AppInterface
{
  public static String a;
  private VideoFeedsService jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsService;
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap(20);
  private List jdField_a_of_type_JavaUtilList = new Vector();
  private List b = new Vector();
  private List c = new Vector();
  
  static
  {
    jdField_a_of_type_JavaLangString = "com.tencent.mobileqq:tool";
  }
  
  public VideoFeedsAppInterface(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    super(paramBaseApplicationImpl, paramString);
  }
  
  public BusinessHandler a(int paramInt)
  {
    BusinessHandler localBusinessHandler = (BusinessHandler)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    if (localBusinessHandler == null) {}
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilHashMap)
      {
        localBusinessHandler = (BusinessHandler)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
        if (localBusinessHandler == null) {
          break label113;
        }
        return localBusinessHandler;
        if (localBusinessHandler != null) {
          this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), localBusinessHandler);
        }
        return localBusinessHandler;
      }
      Object localObject2 = new VideoPlayRecommendHandler(this);
      continue;
      localObject2 = new VideoPlayCountHandler(this);
      continue;
      localObject2 = new PublicAccountArticleHandler(this);
      continue;
      return localObject2;
      label113:
      switch (paramInt)
      {
      }
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsService.a(paramFromServiceMsg.isSuccess(), paramToServiceMsg, paramFromServiceMsg, null);
  }
  
  public void addObserver(BusinessObserver paramBusinessObserver)
  {
    addObserver(paramBusinessObserver, false);
  }
  
  public void addObserver(BusinessObserver paramBusinessObserver, boolean paramBoolean)
  {
    if (paramBusinessObserver == null) {
      return;
    }
    if (paramBoolean) {
      synchronized (this.b)
      {
        if (!this.b.contains(paramBusinessObserver)) {
          this.b.add(paramBusinessObserver);
        }
        return;
      }
    }
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (!this.jdField_a_of_type_JavaUtilList.contains(paramBusinessObserver)) {
        this.jdField_a_of_type_JavaUtilList.add(paramBusinessObserver);
      }
      return;
    }
  }
  
  public BaseApplication getApp()
  {
    return this.app;
  }
  
  public int getAppid()
  {
    return AppSetting.a;
  }
  
  public List getBusinessObserver(int paramInt)
  {
    if (paramInt == 1) {
      return this.jdField_a_of_type_JavaUtilList;
    }
    if (paramInt == 2) {
      return this.b;
    }
    if (paramInt == 0) {
      return this.c;
    }
    return this.c;
  }
  
  public String getCurrentAccountUin()
  {
    return getAccount();
  }
  
  public EntityManagerFactory getEntityManagerFactory(String paramString)
  {
    return null;
  }
  
  public String getModuleId()
  {
    return "module_videofeeds";
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsService = new VideoFeedsService(this);
  }
  
  public void removeObserver(BusinessObserver paramBusinessObserver)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramBusinessObserver);
      synchronized (this.b)
      {
        this.b.remove(paramBusinessObserver);
      }
    }
    synchronized (this.c)
    {
      this.c.remove(paramBusinessObserver);
      return;
      paramBusinessObserver = finally;
      throw paramBusinessObserver;
      paramBusinessObserver = finally;
      throw paramBusinessObserver;
    }
  }
  
  public void sendToService(ToServiceMsg paramToServiceMsg)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsService.a(paramToServiceMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAppInterface
 * JD-Core Version:    0.7.0.1
 */