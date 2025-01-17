package com.tencent.mobileqq.app.asyncdb;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.persistence.Entity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public abstract class BaseCache
{
  public QQAppInterface a;
  public DBDelayManager a;
  protected Class a;
  protected ArrayList a;
  public ConcurrentHashMap a;
  
  public BaseCache(QQAppInterface paramQQAppInterface, DBDelayManager paramDBDelayManager, Class paramClass)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbDBDelayManager = paramDBDelayManager;
    this.jdField_a_of_type_JavaLangClass = paramClass;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public Entity a(String paramString)
  {
    return (Entity)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
  }
  
  public String a(Entity paramEntity)
  {
    return Long.toString(paramEntity.getId());
  }
  
  public abstract void a();
  
  public void a(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((CacheObserver)localIterator.next()).a(paramInt);
    }
  }
  
  public void a(Entity paramEntity)
  {
    a(paramEntity, 0, null);
  }
  
  public abstract void a(Entity paramEntity, int paramInt, ProxyListener paramProxyListener);
  
  public abstract void b();
  
  public void b(Entity paramEntity)
  {
    b(paramEntity, 0, null);
  }
  
  public void b(Entity paramEntity, int paramInt, ProxyListener paramProxyListener)
  {
    String str = a(paramEntity);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, paramEntity);
    if (paramEntity.getStatus() == 1000)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbDBDelayManager.a(paramEntity, 0, paramInt, paramProxyListener);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbDBDelayManager.a(paramEntity, 1, paramInt, paramProxyListener);
  }
  
  public void c(Entity paramEntity)
  {
    c(paramEntity, 0, null);
  }
  
  public void c(Entity paramEntity, int paramInt, ProxyListener paramProxyListener)
  {
    String str = a(paramEntity);
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(str)) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(str);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbDBDelayManager.a(paramEntity, 2, paramInt, paramProxyListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.asyncdb.BaseCache
 * JD-Core Version:    0.7.0.1
 */