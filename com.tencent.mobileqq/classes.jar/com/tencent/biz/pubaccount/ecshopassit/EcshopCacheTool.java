package com.tencent.biz.pubaccount.ecshopassit;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.jsp.WebSSOAgentServlet;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import laa;
import lac;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import tencent.im.oidb.qqshop.qqshop.SQQSHPClientReq;

public class EcshopCacheTool
{
  public static final String a;
  public EcshopReportHandler a;
  public ShopWebViewFragment a;
  public EntityManager a;
  Runnable jdField_a_of_type_JavaLangRunnable = new laa(this);
  public Map a;
  BusinessObserver jdField_a_of_type_MqqObserverBusinessObserver = new lac(this);
  public boolean a;
  Map b;
  public Map c;
  public Map d;
  
  static
  {
    jdField_a_of_type_JavaLangString = BaseApplication.getContext().getFilesDir() + File.separator + "shop_assit_banner_json.txt";
  }
  
  public EcshopCacheTool(AppInterface paramAppInterface, ShopWebViewFragment paramShopWebViewFragment)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitShopWebViewFragment = paramShopWebViewFragment;
    this.c = new ConcurrentHashMap();
    this.d = new ConcurrentHashMap();
    this.b = new ConcurrentHashMap();
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramAppInterface.getEntityManagerFactory().createEntityManager();
    this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcshopReportHandler = ((EcshopReportHandler)paramAppInterface.getBusinessHandler(0));
    ThreadManager.post(this.jdField_a_of_type_JavaLangRunnable, 5, null, true);
  }
  
  public Bitmap a(String paramString)
  {
    synchronized (this.b)
    {
      paramString = (Bitmap)this.b.get(paramString);
      return paramString;
    }
  }
  
  public String a(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.jdField_a_of_type_JavaUtilMap == null)) {
      return "";
    }
    paramString = (Friends)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (paramString != null) {
      return paramString.getFriendNick();
    }
    return "";
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitShopWebViewFragment = null;
    this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcshopReportHandler = null;
    if (this.jdField_a_of_type_JavaUtilMap != null) {
      this.jdField_a_of_type_JavaUtilMap.clear();
    }
    if (this.b != null) {
      this.b.clear();
    }
    if (this.c != null) {
      this.c.clear();
    }
    if (this.d != null) {
      this.d.clear();
    }
  }
  
  public void a(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent("action_get_PA_head");
    localIntent.putExtra("uin", paramString);
    paramContext.sendBroadcast(localIntent);
  }
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    synchronized (this.b)
    {
      this.b.put(paramString, paramBitmap);
      return;
    }
  }
  
  public void a(AppRuntime paramAppRuntime, int paramInt)
  {
    qqshop.SQQSHPClientReq localSQQSHPClientReq = new qqshop.SQQSHPClientReq();
    localSQQSHPClientReq.msglistlen.set(paramInt);
    NewIntent localNewIntent = new NewIntent(paramAppRuntime.getApplication(), WebSSOAgentServlet.class);
    localNewIntent.putExtra("extra_cmd", "SQQShopFolderSvc.GetFolderInfo");
    localNewIntent.putExtra("extra_data", localSQQSHPClientReq.toByteArray());
    localNewIntent.putExtra("extra_timeout", 30000L);
    localNewIntent.setObserver(this.jdField_a_of_type_MqqObserverBusinessObserver);
    paramAppRuntime.startServlet(localNewIntent);
  }
  
  public void a(AppRuntime paramAppRuntime, List paramList, double paramDouble1, double paramDouble2)
  {
    NewIntent localNewIntent = new NewIntent(paramAppRuntime.getApplication(), WebSSOAgentServlet.class);
    qqshop.SQQSHPClientReq localSQQSHPClientReq = new qqshop.SQQSHPClientReq();
    localSQQSHPClientReq.puinlist.addAll(paramList);
    if ((!TextUtils.isEmpty(paramAppRuntime.getAccount())) && (paramDouble1 != 0.0D) && (paramDouble2 != 0.0D))
    {
      localSQQSHPClientReq.latitude.set(paramDouble2);
      localSQQSHPClientReq.longitude.set(paramDouble1);
      if (QLog.isColorLevel()) {
        QLog.i("EcshopCacheTool", 2, "lat:" + paramDouble2 + ",lon:" + paramDouble1);
      }
    }
    localNewIntent.putExtra("extra_cmd", "SQQShopFolderSvc.GetShopBindUin");
    localNewIntent.putExtra("extra_data", localSQQSHPClientReq.toByteArray());
    localNewIntent.putExtra("extra_timeout", 30000L);
    localNewIntent.setObserver(this.jdField_a_of_type_MqqObserverBusinessObserver);
    paramAppRuntime.startServlet(localNewIntent);
  }
  
  public boolean a(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.jdField_a_of_type_JavaUtilMap == null)) {
      return false;
    }
    return (Friends)this.jdField_a_of_type_JavaUtilMap.get(paramString) != null;
  }
  
  public void b(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("url", paramString);
    localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
    paramContext.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.EcshopCacheTool
 * JD-Core Version:    0.7.0.1
 */