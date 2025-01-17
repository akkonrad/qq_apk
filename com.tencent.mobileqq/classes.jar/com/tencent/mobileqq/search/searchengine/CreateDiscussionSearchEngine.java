package com.tencent.mobileqq.search.searchengine;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.model.ContactSearchModelCreateDiscussion;
import com.tencent.mobileqq.search.model.IContactSearchModel;
import com.tencent.mobileqq.search.util.KMAlgorithm;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CreateDiscussionSearchEngine
  implements ISearchEngine
{
  int jdField_a_of_type_Int;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  ContactSearchEngine jdField_a_of_type_ComTencentMobileqqSearchSearchengineContactSearchEngine;
  boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  
  public CreateDiscussionSearchEngine(QQAppInterface paramQQAppInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineContactSearchEngine = new ContactSearchEngine(paramQQAppInterface, 10002, 5, null);
  }
  
  public List a(SearchRequest paramSearchRequest)
  {
    long l1 = System.currentTimeMillis();
    this.jdField_a_of_type_Boolean = false;
    if ((paramSearchRequest == null) || (TextUtils.isEmpty(paramSearchRequest.a))) {
      return null;
    }
    Object localObject2 = paramSearchRequest.a.split("\\s+");
    if (localObject2.length < 2) {
      return null;
    }
    if (!this.c)
    {
      this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineContactSearchEngine.a();
      this.c = true;
    }
    Object localObject1 = new ArrayList();
    int j = localObject2.length;
    int i = 0;
    while (i < j)
    {
      localObject3 = localObject2[i];
      if (this.jdField_a_of_type_Boolean) {
        return null;
      }
      localObject3 = new SearchRequest((String)localObject3);
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineContactSearchEngine.a((SearchRequest)localObject3);
      if ((localObject3 != null) && (!((List)localObject3).isEmpty())) {
        ((List)localObject1).add(localObject3);
      }
      i += 1;
    }
    if (((List)localObject1).size() < 2) {
      return null;
    }
    int m = ((List)localObject1).size();
    Object localObject3 = new ArrayList();
    Object localObject4 = ((List)localObject1).iterator();
    while (((Iterator)localObject4).hasNext())
    {
      localObject2 = (List)((Iterator)localObject4).next();
      localObject1 = localObject2;
      if (((List)localObject2).size() > m) {
        localObject1 = ((List)localObject2).subList(0, m);
      }
      ((List)localObject3).add(localObject1);
    }
    localObject2 = new HashMap();
    localObject1 = new HashMap();
    localObject4 = ((List)localObject3).iterator();
    i = 0;
    Object localObject5;
    Object localObject6;
    while (((Iterator)localObject4).hasNext())
    {
      localObject5 = ((List)((Iterator)localObject4).next()).iterator();
      while (((Iterator)localObject5).hasNext())
      {
        localObject6 = (IContactSearchModel)((Iterator)localObject5).next();
        if (!((Map)localObject2).containsKey(((IContactSearchModel)localObject6).a()))
        {
          ((Map)localObject2).put(((IContactSearchModel)localObject6).a(), Integer.valueOf(i));
          ((Map)localObject1).put(Integer.valueOf(i), ((IContactSearchModel)localObject6).a());
          i += 1;
        }
      }
    }
    localObject4 = (long[][])Array.newInstance(Long.TYPE, new int[] { m, i });
    j = 0;
    while (j < ((List)localObject3).size())
    {
      int k = 0;
      while (k < ((List)((List)localObject3).get(j)).size())
      {
        localObject5 = (Integer)((Map)localObject2).get(((IContactSearchModel)((List)((List)localObject3).get(j)).get(k)).a());
        if (localObject5 != null) {
          localObject4[j][localObject5.intValue()] = ((IContactSearchModel)((List)((List)localObject3).get(j)).get(k)).b();
        }
        k += 1;
      }
      j += 1;
    }
    localObject2 = KMAlgorithm.a((long[][])localObject4, m, i);
    localObject4 = new ArrayList();
    i = localObject2.length - 1;
    while (i >= 0)
    {
      if (localObject2[i] != -1)
      {
        localObject6 = (List)((List)localObject3).get(i);
        localObject5 = (String)((Map)localObject1).get(Integer.valueOf(localObject2[i]));
        localObject6 = ((List)localObject6).iterator();
        while (((Iterator)localObject6).hasNext())
        {
          IContactSearchModel localIContactSearchModel = (IContactSearchModel)((Iterator)localObject6).next();
          if ((localObject5 != null) && (((String)localObject5).equals(localIContactSearchModel.a()))) {
            ((List)localObject4).add(localIContactSearchModel);
          }
        }
      }
      i -= 1;
    }
    if (((List)localObject4).size() < 2) {
      return null;
    }
    paramSearchRequest = new ContactSearchModelCreateDiscussion(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Int, paramSearchRequest.a, (List)localObject4);
    localObject1 = new ArrayList();
    ((List)localObject1).add(paramSearchRequest);
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("CreateDiscussionSearchEngine", 2, "Create discussion search cost time = " + (l2 - l1));
    }
    if (!this.b)
    {
      this.b = true;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800635E", "0X800635E", 0, 0, "", "", "", "");
    }
    return localObject1;
  }
  
  public void a() {}
  
  public void a(SearchRequest paramSearchRequest, ISearchListener paramISearchListener) {}
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineContactSearchEngine.b();
  }
  
  public void c() {}
  
  public void d() {}
  
  public void e() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.searchengine.CreateDiscussionSearchEngine
 * JD-Core Version:    0.7.0.1
 */