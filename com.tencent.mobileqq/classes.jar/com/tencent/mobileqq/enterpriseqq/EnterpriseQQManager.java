package com.tencent.mobileqq.enterpriseqq;

import achc;
import achd;
import ache;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.crmqq.structmsg.StructMsg.ButtonInfo;
import com.tencent.crmqq.structmsg.StructMsg.GetCRMMenuResponse;
import com.tencent.crmqq.structmsg.StructMsg.RetInfo;
import com.tencent.mobileqq.app.EnterpriseQQHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EnterpriseQQManager
{
  private static EnterpriseQQManager jdField_a_of_type_ComTencentMobileqqEnterpriseqqEnterpriseQQManager;
  private static byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  private static byte[] jdField_b_of_type_ArrayOfByte = new byte[0];
  private double jdField_a_of_type_Double;
  private long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public SosoInterface.OnLocationListener a;
  private EnterPriseQQCache jdField_a_of_type_ComTencentMobileqqEnterpriseqqEnterPriseQQCache = new EnterPriseQQCache();
  protected Runnable a;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private double jdField_b_of_type_Double;
  private long jdField_b_of_type_Long = 1800000L;
  
  private EnterpriseQQManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaLangRunnable = new achc(this);
    this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener = new achd(this, 4, true, true, 0L, false, false, "EnterpriseQQManager");
    if (paramQQAppInterface != null) {
      a(paramQQAppInterface);
    }
  }
  
  public static EnterpriseQQManager a(QQAppInterface paramQQAppInterface)
  {
    if (jdField_a_of_type_ComTencentMobileqqEnterpriseqqEnterpriseQQManager == null) {}
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      if (jdField_a_of_type_ComTencentMobileqqEnterpriseqqEnterpriseQQManager == null) {
        jdField_a_of_type_ComTencentMobileqqEnterpriseqqEnterpriseQQManager = new EnterpriseQQManager(paramQQAppInterface);
      }
      return jdField_a_of_type_ComTencentMobileqqEnterpriseqqEnterpriseQQManager;
    }
  }
  
  private static void a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString, StructMsg.ButtonInfo paramButtonInfo)
  {
    paramButtonInfo = new StringBuilder(paramButtonInfo.url.get());
    if (paramButtonInfo.indexOf("?") < 0) {
      paramButtonInfo.append("?");
    }
    for (;;)
    {
      paramButtonInfo.append("uin=" + paramQQAppInterface.getCurrentAccountUin());
      paramButtonInfo.append("&puin=" + paramString);
      Intent localIntent = new Intent(paramContext, PublicAccountBrowser.class);
      localIntent.putExtra("url", paramButtonInfo.toString());
      localIntent.putExtra("uin", paramQQAppInterface.getCurrentAccountUin());
      localIntent.putExtra("puin", paramString);
      localIntent.putExtra("assignBackText", paramContext.getResources().getString(2131433698));
      if (paramString.equalsIgnoreCase("2632129500")) {
        localIntent.putExtra("hide_operation_bar", true);
      }
      paramContext.startActivity(localIntent);
      return;
      if (paramButtonInfo.indexOf("?") < paramButtonInfo.length() - 1) {
        if (paramButtonInfo.indexOf("&") < 0) {
          paramButtonInfo.append("&");
        } else if (paramButtonInfo.lastIndexOf("&") < paramButtonInfo.length() - 1) {
          paramButtonInfo.append("&");
        }
      }
    }
  }
  
  public List a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEnterpriseqqEnterPriseQQCache != null) {
      return this.jdField_a_of_type_ComTencentMobileqqEnterpriseqqEnterPriseQQCache.a(paramString);
    }
    return null;
  }
  
  public void a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString1, String paramString2, boolean paramBoolean, double paramDouble1, double paramDouble2)
  {
    if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramString1)))
    {
      paramContext = (EnterpriseQQHandler)paramQQAppInterface.a(21);
      if (paramContext != null) {
        paramContext.a(paramString1, paramString2, 1, paramBoolean, paramDouble1, paramDouble2);
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEnterpriseqqEnterPriseQQCache == null) {
      this.jdField_a_of_type_ComTencentMobileqqEnterpriseqqEnterPriseQQCache = new EnterPriseQQCache();
    }
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.getEntityManagerFactory().createEntityManager().a(EnterpriseQQMenuEntity.class);
      if ((paramQQAppInterface != null) && (paramQQAppInterface.size() > 0)) {
        paramQQAppInterface = paramQQAppInterface.iterator();
      }
    }
    for (;;)
    {
      EnterpriseQQMenuEntity localEnterpriseQQMenuEntity;
      StructMsg.GetCRMMenuResponse localGetCRMMenuResponse;
      if (paramQQAppInterface.hasNext())
      {
        localEnterpriseQQMenuEntity = (EnterpriseQQMenuEntity)paramQQAppInterface.next();
        if (localEnterpriseQQMenuEntity == null) {
          continue;
        }
        localGetCRMMenuResponse = new StructMsg.GetCRMMenuResponse();
      }
      try
      {
        localGetCRMMenuResponse.mergeFrom(localEnterpriseQQMenuEntity.data);
        label95:
        if (!localGetCRMMenuResponse.ret_info.has()) {
          continue;
        }
        this.jdField_a_of_type_ComTencentMobileqqEnterpriseqqEnterPriseQQCache.a(localEnterpriseQQMenuEntity.uin, localGetCRMMenuResponse.button_info.get(), localEnterpriseQQMenuEntity.seqno, localEnterpriseQQMenuEntity.savedDateTime);
        continue;
        return;
      }
      catch (Exception localException)
      {
        break label95;
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, StructMsg.GetCRMMenuResponse paramGetCRMMenuResponse)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {}
    long l;
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqEnterpriseqqEnterPriseQQCache == null) {
        this.jdField_a_of_type_ComTencentMobileqqEnterpriseqqEnterPriseQQCache = new EnterPriseQQCache();
      }
      l = System.currentTimeMillis();
      if ((this.jdField_a_of_type_ComTencentMobileqqEnterpriseqqEnterPriseQQCache.a(paramString) != paramInt) && (paramGetCRMMenuResponse != null))
      {
        List localList = paramGetCRMMenuResponse.button_info.get();
        paramGetCRMMenuResponse = new EnterpriseQQMenuEntity(paramString, paramGetCRMMenuResponse, paramInt, l);
        paramQQAppInterface = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
        EnterpriseQQMenuEntity localEnterpriseQQMenuEntity = (EnterpriseQQMenuEntity)paramQQAppInterface.a(EnterpriseQQMenuEntity.class, paramString);
        if (localEnterpriseQQMenuEntity != null)
        {
          localEnterpriseQQMenuEntity.data = ((byte[])paramGetCRMMenuResponse.data.clone());
          localEnterpriseQQMenuEntity.savedDateTime = paramGetCRMMenuResponse.savedDateTime;
          localEnterpriseQQMenuEntity.seqno = paramGetCRMMenuResponse.seqno;
          paramQQAppInterface.a(localEnterpriseQQMenuEntity);
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentMobileqqEnterpriseqqEnterPriseQQCache.a(paramString, localList, paramInt, l);
          return;
          paramQQAppInterface.a(paramGetCRMMenuResponse);
        }
      }
    } while (paramGetCRMMenuResponse == null);
    paramQQAppInterface = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    paramGetCRMMenuResponse = (EnterpriseQQMenuEntity)paramQQAppInterface.a(EnterpriseQQMenuEntity.class, paramString);
    if (paramGetCRMMenuResponse != null)
    {
      paramGetCRMMenuResponse.savedDateTime = l;
      paramQQAppInterface.a(paramGetCRMMenuResponse);
    }
    this.jdField_a_of_type_ComTencentMobileqqEnterpriseqqEnterPriseQQCache.a(paramString, l);
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramString)))
    {
      long l = 0L;
      if (this.jdField_a_of_type_ComTencentMobileqqEnterpriseqqEnterPriseQQCache != null) {
        l = this.jdField_a_of_type_ComTencentMobileqqEnterpriseqqEnterPriseQQCache.a(paramString);
      }
      if ((paramBoolean) || ((!paramBoolean) && (System.currentTimeMillis() - l > 43200000L)))
      {
        paramQQAppInterface = (EnterpriseQQHandler)paramQQAppInterface.a(21);
        if (paramQQAppInterface != null) {
          paramQQAppInterface.a(paramString);
        }
      }
    }
  }
  
  public void a(String arg1, Context paramContext, QQAppInterface paramQQAppInterface, String paramString2, StructMsg.ButtonInfo paramButtonInfo)
  {
    if (paramButtonInfo == null) {
      if (QLog.isColorLevel()) {
        QLog.e("EnterpriseQQManager", 2, "buttoninfo is null.");
      }
    }
    int i;
    do
    {
      return;
      switch (paramButtonInfo.type.get())
      {
      default: 
        return;
      case 1: 
        if (paramButtonInfo.is_need_lbs.get())
        {
          if ((System.currentTimeMillis() - this.jdField_a_of_type_Long < this.jdField_b_of_type_Long) && (this.jdField_a_of_type_Double != 0.0D) && (this.jdField_b_of_type_Double != 0.0D))
          {
            a(paramContext, paramQQAppInterface, paramString2, ???, true, this.jdField_a_of_type_Double, this.jdField_b_of_type_Double);
            return;
          }
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
          this.jdField_a_of_type_AndroidContentContext = paramContext;
          paramContext = new ache(this);
          paramContext.a = paramString2;
          paramContext.b = ???;
          synchronized (jdField_b_of_type_ArrayOfByte)
          {
            this.jdField_a_of_type_JavaUtilArrayList.add(paramContext);
            ThreadManager.post(this.jdField_a_of_type_JavaLangRunnable, 8, null, true);
            return;
          }
        }
        a(paramContext, paramQQAppInterface, paramString2, ???, false, 0.0D, 0.0D);
        return;
      case 2: 
        a(paramContext, paramQQAppInterface, paramString2, paramButtonInfo);
        return;
      }
      i = paramButtonInfo.event_id.get();
    } while ((i == 1) || (i == 2) || (i == 3) || (i != 4));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.enterpriseqq.EnterpriseQQManager
 * JD-Core Version:    0.7.0.1
 */