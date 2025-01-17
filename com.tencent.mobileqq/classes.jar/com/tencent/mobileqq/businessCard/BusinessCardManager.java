package com.tencent.mobileqq.businessCard;

import abmp;
import abmq;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.mobileqq.businessCard.data.CardOCRInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.transfile.BDHCommonUploadProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;

public class BusinessCardManager
  implements Manager
{
  SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  public TransFileController a;
  public ConcurrentHashMap a;
  protected ConcurrentHashMap b;
  
  public BusinessCardManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.b = new ConcurrentHashMap();
    this.jdField_a_of_type_AndroidContentSharedPreferences = paramQQAppInterface.getApp().getSharedPreferences("pref_business_card" + paramQQAppInterface.getAccount(), 0);
    a();
  }
  
  private boolean a(BusinessCard paramBusinessCard)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramBusinessCard != null)
    {
      String str = paramBusinessCard.cardId;
      bool1 = bool2;
      if (str != null)
      {
        bool1 = bool2;
        if (str.length() != 0)
        {
          paramBusinessCard.setStatus(1000);
          this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(paramBusinessCard);
          bool1 = bool2;
          if (paramBusinessCard.getStatus() == 1001) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  private void c(BusinessCard paramBusinessCard)
  {
    if (paramBusinessCard != null) {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(paramBusinessCard);
    }
  }
  
  private void d(BusinessCard paramBusinessCard)
  {
    if (paramBusinessCard != null) {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(paramBusinessCard);
    }
  }
  
  public int a()
  {
    int i = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("key_server_seq", -1);
    if (QLog.isColorLevel()) {
      QLog.d("BusinessCard_Manager", 2, "getLocalSeq | seq = " + i);
    }
    return i;
  }
  
  public BusinessCard a()
  {
    BusinessCard localBusinessCard;
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty())
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localBusinessCard = (BusinessCard)((Map.Entry)localIterator.next()).getValue();
      } while (localBusinessCard.cardType != 1);
    }
    for (;;)
    {
      if ((localBusinessCard == null) && (QLog.isColorLevel())) {
        QLog.w("BusinessCard_Manager", 2, "getMyBusinessCard return null");
      }
      return localBusinessCard;
      localBusinessCard = null;
    }
  }
  
  public BusinessCard a(String paramString)
  {
    return (BusinessCard)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
  }
  
  public ArrayList a()
  {
    ArrayList localArrayList = new ArrayList();
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty())
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(((Map.Entry)localIterator.next()).getValue());
      }
    }
    return localArrayList;
  }
  
  public List a()
  {
    List localList = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(BusinessCard.class);
    if ((localList != null) && (QLog.isColorLevel())) {
      QLog.d("BusinessCard_Manager", 2, "getBusinessCardListFromDB= " + localList.size());
    }
    return localList;
  }
  
  public void a()
  {
    ThreadManager.post(new abmp(this), 8, null, true);
  }
  
  public void a(int paramInt)
  {
    if (paramInt != -1) {
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("key_server_seq", paramInt).commit();
    }
    if (QLog.isColorLevel()) {
      QLog.d("BusinessCard_Manager", 2, "saveServerSeq | seq = " + paramInt);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BusinessCard_Manager", 2, "setCardSetting|type=" + paramInt + ", flag=" + paramBoolean);
    }
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("key_show_open_card", paramBoolean).commit();
      return;
    case 1: 
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("key_need_req_card", paramBoolean).commit();
      return;
    }
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("key_need_show_guide", paramBoolean).commit();
  }
  
  public void a(BusinessCard paramBusinessCard)
  {
    if (paramBusinessCard == null) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramBusinessCard.cardId)) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramBusinessCard.cardId);
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramBusinessCard.cardId, paramBusinessCard);
  }
  
  public void a(TransProcessorHandler paramTransProcessorHandler)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController == null) {
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    }
    paramTransProcessorHandler.a(new Class[] { BDHCommonUploadProcessor.class });
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController.a(paramTransProcessorHandler);
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString))
    {
      d((BusinessCard)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString));
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
    }
  }
  
  public void a(String paramString, BusinessCard paramBusinessCard)
  {
    if ((paramBusinessCard == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    if (this.b.containsKey(paramString)) {
      this.b.remove(paramString);
    }
    this.b.put(paramString, paramBusinessCard);
  }
  
  public void a(List paramList, boolean paramBoolean)
  {
    if (paramList != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a().a();
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(BusinessCard.class.getSimpleName());
      }
      paramList = paramList.iterator();
      BusinessCard localBusinessCard;
      do
      {
        if (!paramList.hasNext()) {
          break;
        }
        localBusinessCard = (BusinessCard)paramList.next();
      } while (a(localBusinessCard));
      throw new Exception("saveCardList exception : comicId = " + localBusinessCard.cardId);
    }
    catch (Exception paramList)
    {
      QLog.d("BusinessCard_Manager", 2, "saveComicHistoryList exception :" + paramList.toString());
      paramList.printStackTrace();
      return;
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a().c();
      return;
    }
    finally
    {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a().b();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("key_red_point", paramBoolean).commit();
    if (QLog.isColorLevel()) {
      QLog.d("BusinessCard_Manager", 2, "setRedPointClicked | clicked = " + paramBoolean);
    }
  }
  
  public boolean a()
  {
    boolean bool = this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("key_red_point", true);
    if (QLog.isColorLevel()) {
      QLog.d("BusinessCard_Manager", 2, "getRedPointClicked | ret = " + bool);
    }
    return bool;
  }
  
  public boolean a(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    switch (paramInt)
    {
    default: 
      bool1 = bool2;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BusinessCard_Manager", 2, "getCardSetting|type=" + paramInt + ", result=" + bool1);
      }
      return bool1;
      bool1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("key_show_open_card", false);
      continue;
      bool1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("key_need_req_card", false);
      continue;
      bool1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("key_need_show_guide", true);
    }
  }
  
  public int b()
  {
    int i = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("key_sort_type", 0);
    if (QLog.isColorLevel()) {
      QLog.d("BusinessCard_Manager", 2, "getListSortType | type = " + i);
    }
    return i;
  }
  
  public BusinessCard b(String paramString)
  {
    return (BusinessCard)this.b.get(paramString);
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(BusinessCard.class);
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("key_sort_type", paramInt).commit();
    if (QLog.isColorLevel()) {
      QLog.d("BusinessCard_Manager", 2, "saveListSortType | type = " + paramInt);
    }
  }
  
  public void b(BusinessCard paramBusinessCard)
  {
    if (paramBusinessCard == null) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramBusinessCard.cardId))
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramBusinessCard.cardId);
      c(paramBusinessCard);
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramBusinessCard.cardId, paramBusinessCard);
      return;
      a(paramBusinessCard);
    }
  }
  
  public void b(TransProcessorHandler paramTransProcessorHandler)
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController.b(paramTransProcessorHandler);
  }
  
  public void b(String paramString)
  {
    if (this.b.containsKey(paramString)) {
      this.b.remove(paramString);
    }
  }
  
  public BusinessCard c(String paramString)
  {
    if ((paramString == null) || (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty())) {
      return null;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
    while (localIterator.hasNext())
    {
      BusinessCard localBusinessCard = (BusinessCard)localIterator.next();
      if ((localBusinessCard.OCRInfo != null) && (paramString.equals(localBusinessCard.OCRInfo.b))) {
        return localBusinessCard;
      }
    }
    return null;
  }
  
  public void c(String paramString)
  {
    TransferRequest localTransferRequest = new TransferRequest();
    localTransferRequest.i = paramString;
    localTransferRequest.jdField_a_of_type_Boolean = true;
    localTransferRequest.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    localTransferRequest.b = 24;
    localTransferRequest.jdField_c_of_type_Int = 18;
    localTransferRequest.jdField_a_of_type_JavaLangString = "actBusinessCardPicUpload";
    ThreadManager.post(new abmq(this, localTransferRequest), 8, null, true);
  }
  
  public BusinessCard d(String paramString)
  {
    BusinessCard localBusinessCard1 = new BusinessCard();
    BusinessCard localBusinessCard2 = (BusinessCard)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(BusinessCard.class, paramString);
    paramString = localBusinessCard2;
    if (localBusinessCard2 == null) {
      paramString = localBusinessCard1;
    }
    return paramString;
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.b.clear();
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.businessCard.BusinessCardManager
 * JD-Core Version:    0.7.0.1
 */