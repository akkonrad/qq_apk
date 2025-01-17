package com.tencent.mobileqq.ark;

import aaqu;
import aaqv;
import aaqx;
import aaqz;
import aarb;
import aarc;
import aard;
import aarf;
import aarg;
import aarh;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import mqq.app.MobileQQ;

public class ArkActionAppMgr
{
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  final ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  Set jdField_a_of_type_JavaUtilSet = new TreeSet(new aaqu(this));
  
  static
  {
    if (!ArkActionAppMgr.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  public ArkActionAppMgr(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
  }
  
  private long a(int paramInt, ArrayList paramArrayList)
  {
    long l1 = 0L;
    long l2;
    if (paramArrayList.isEmpty()) {
      l2 = l1;
    }
    for (;;)
    {
      return l2;
      QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localQQAppInterface == null)
      {
        ArkAppCenter.b("ArkApp.ActionAppMgr", "_updateAppInfoDB, appInterface is null");
        return -1L;
      }
      Object localObject = new aard();
      try
      {
        if (!((aard)localObject).a(localQQAppInterface.getApplication().getApplicationContext(), paramInt))
        {
          ArkAppCenter.b("ArkApp.ActionAppMgr", String.format("_updateAppInfoDB, fail to init db, type=%d", new Object[] { Integer.valueOf(paramInt) }));
          return -1L;
        }
        if (!((aard)localObject).a(paramArrayList))
        {
          ArkAppCenter.b("ArkApp.ActionAppMgr", String.format("_updateAppInfoDB, fail to update db, type=%d", new Object[] { Integer.valueOf(paramInt) }));
          return -1L;
        }
        ((aard)localObject).a();
        paramArrayList = paramArrayList.iterator();
        l2 = l1;
        if (!paramArrayList.hasNext()) {
          continue;
        }
        localObject = (ArkAppInfo.ContextActionAppInfo)paramArrayList.next();
        if (((ArkAppInfo.ContextActionAppInfo)localObject).jdField_a_of_type_Long > l1) {
          l1 = ((ArkAppInfo.ContextActionAppInfo)localObject).jdField_a_of_type_Long;
        }
        for (;;)
        {
          break;
        }
      }
      finally
      {
        ((aard)localObject).a();
      }
    }
  }
  
  private void a(aarg paramaarg)
  {
    HashSet localHashSet = new HashSet();
    a(2, paramaarg, localHashSet);
    a(1, paramaarg, localHashSet);
    if (localHashSet.isEmpty())
    {
      ArkAppCenter.b("ArkApp.ActionAppMgr", String.format("_getAppNameByAction, query app from db fail, recent=%s, action=%s.%s", new Object[] { Boolean.toString(paramaarg.jdField_a_of_type_Boolean), paramaarg.jdField_a_of_type_JavaLangString, paramaarg.jdField_b_of_type_JavaLangString }));
      if (!paramaarg.jdField_a_of_type_Boolean)
      {
        paramaarg.jdField_a_of_type_Boolean = true;
        if (!a(paramaarg.jdField_a_of_type_JavaLangString, paramaarg.jdField_b_of_type_JavaLangString, 0L, 0L, paramaarg, new aarc(this)))
        {
          ArkAppCenter.b("ArkApp.ActionAppMgr", String.format("_getAppNameByAction, _updateAppInfo fail, recent=%s, action=%s.%s", new Object[] { Boolean.toString(paramaarg.jdField_a_of_type_Boolean), paramaarg.jdField_a_of_type_JavaLangString, paramaarg.jdField_b_of_type_JavaLangString }));
          if (!jdField_a_of_type_Boolean) {
            throw new AssertionError();
          }
        }
        ArkAppCenter.b("ArkApp.ActionAppMgr", String.format("_getAppNameByAction, _updateAppInfo start, recent=%s, action=%s.%s", new Object[] { Boolean.toString(paramaarg.jdField_a_of_type_Boolean), paramaarg.jdField_a_of_type_JavaLangString, paramaarg.jdField_b_of_type_JavaLangString }));
      }
    }
    do
    {
      return;
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = localHashSet.iterator();
      while (localIterator.hasNext())
      {
        localStringBuilder.append((String)localIterator.next());
        localStringBuilder.append(";");
      }
      ArkAppCenter.b("ArkApp.ActionAppMgr", String.format("_getAppNameByAction, result, action=%s.%s, app-list=%s", new Object[] { paramaarg.jdField_a_of_type_JavaLangString, paramaarg.jdField_b_of_type_JavaLangString, localStringBuilder.toString() }));
    } while (paramaarg.jdField_a_of_type_ComTencentMobileqqArkArkActionAppMgr$IGetAppNameByActionCallback == null);
    paramaarg.jdField_a_of_type_ComTencentMobileqqArkArkActionAppMgr$IGetAppNameByActionCallback.a(paramaarg.jdField_a_of_type_JavaLangObject, localHashSet);
  }
  
  private void a(aarh paramaarh)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localQQAppInterface == null)
    {
      ArkAppCenter.b("ArkApp.ActionAppMgr", "_updateAppInfoTask, appInterface is null");
      return;
    }
    ((ArkAppCenter)localQQAppInterface.getManager(120)).a().a(paramaarh.jdField_a_of_type_JavaLangString, paramaarh.jdField_b_of_type_JavaLangString, paramaarh.jdField_b_of_type_Long, paramaarh.jdField_a_of_type_Long, paramaarh, new aaqz(this));
  }
  
  /* Error */
  private void a(aarh paramaarh, boolean paramBoolean)
  {
    // Byte code:
    //   0: iload_2
    //   1: ifeq +42 -> 43
    //   4: new 218	com/tencent/mobileqq/ark/ArkAppInfo$Context
    //   7: dup
    //   8: invokespecial 219	com/tencent/mobileqq/ark/ArkAppInfo$Context:<init>	()V
    //   11: astore_3
    //   12: aload_3
    //   13: aload_1
    //   14: getfield 203	aarh:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   17: putfield 220	com/tencent/mobileqq/ark/ArkAppInfo$Context:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   20: aload_3
    //   21: aload_1
    //   22: getfield 204	aarh:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   25: putfield 221	com/tencent/mobileqq/ark/ArkAppInfo$Context:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   28: aload_0
    //   29: monitorenter
    //   30: aload_0
    //   31: getfield 36	com/tencent/mobileqq/ark/ArkActionAppMgr:jdField_a_of_type_JavaUtilSet	Ljava/util/Set;
    //   34: aload_3
    //   35: invokeinterface 227 2 0
    //   40: pop
    //   41: aload_0
    //   42: monitorexit
    //   43: aload_0
    //   44: monitorenter
    //   45: aload_0
    //   46: getfield 41	com/tencent/mobileqq/ark/ArkActionAppMgr:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   49: aload_1
    //   50: invokevirtual 230	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   53: pop
    //   54: aload_0
    //   55: monitorexit
    //   56: aload_1
    //   57: getfield 231	aarh:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   60: invokevirtual 111	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   63: astore_3
    //   64: aload_3
    //   65: invokeinterface 116 1 0
    //   70: ifeq +70 -> 140
    //   73: aload_3
    //   74: invokeinterface 119 1 0
    //   79: checkcast 233	android/util/Pair
    //   82: astore 4
    //   84: aload 4
    //   86: getfield 236	android/util/Pair:second	Ljava/lang/Object;
    //   89: ifnull -25 -> 64
    //   92: aload 4
    //   94: getfield 236	android/util/Pair:second	Ljava/lang/Object;
    //   97: checkcast 238	com/tencent/mobileqq/ark/ArkActionAppMgr$IUpdateActionAppCallback
    //   100: iload_2
    //   101: aload 4
    //   103: getfield 241	android/util/Pair:first	Ljava/lang/Object;
    //   106: aload_1
    //   107: getfield 203	aarh:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   110: aload_1
    //   111: getfield 204	aarh:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   114: aload_1
    //   115: getfield 206	aarh:jdField_b_of_type_Long	J
    //   118: aload_1
    //   119: getfield 207	aarh:jdField_a_of_type_Long	J
    //   122: invokeinterface 244 9 0
    //   127: goto -63 -> 64
    //   130: astore_1
    //   131: aload_0
    //   132: monitorexit
    //   133: aload_1
    //   134: athrow
    //   135: astore_1
    //   136: aload_0
    //   137: monitorexit
    //   138: aload_1
    //   139: athrow
    //   140: aload_1
    //   141: getfield 231	aarh:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   144: invokevirtual 247	java/util/ArrayList:clear	()V
    //   147: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	148	0	this	ArkActionAppMgr
    //   0	148	1	paramaarh	aarh
    //   0	148	2	paramBoolean	boolean
    //   11	63	3	localObject	Object
    //   82	20	4	localPair	Pair
    // Exception table:
    //   from	to	target	type
    //   30	43	130	finally
    //   131	133	130	finally
    //   45	56	135	finally
    //   136	138	135	finally
  }
  
  private void a(Map paramMap)
  {
    Object localObject1 = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject1 == null) {
      ArkAppCenter.b("ArkApp.ActionAppMgr", "_prepareActionUpdateList, appInterface is null");
    }
    Object localObject3;
    Object localObject2;
    do
    {
      return;
      localObject3 = new aard();
      ((aard)localObject3).a(((QQAppInterface)localObject1).getApplication().getApplicationContext(), 2);
      localObject2 = ((aard)localObject3).a();
      ((aard)localObject3).a();
      localObject3 = new aard();
      ((aard)localObject3).a(((QQAppInterface)localObject1).getApplication().getApplicationContext(), 1);
      localObject1 = ((aard)localObject3).a();
      ((aard)localObject3).a();
      long l = System.currentTimeMillis();
      if (localObject2 != null)
      {
        localObject2 = ((ArrayList)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (ArkAppInfo.ContextActionAppInfo)((Iterator)localObject2).next();
          if ((l - ((ArkAppInfo.ContextActionAppInfo)localObject3).jdField_b_of_type_Long) / 1000L >= 93600L)
          {
            aarf localaarf = new aarf(this, null);
            localaarf.jdField_a_of_type_Long = ((ArkAppInfo.ContextActionAppInfo)localObject3).jdField_a_of_type_Long;
            paramMap.put(localObject3, localaarf);
          }
        }
      }
      if (localObject1 != null)
      {
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (ArkAppInfo.ContextActionAppInfo)((Iterator)localObject1).next();
          if ((l - ((ArkAppInfo.ContextActionAppInfo)localObject2).jdField_b_of_type_Long) / 1000L >= 93600L) {
            if (paramMap.containsKey(localObject2))
            {
              ((aarf)paramMap.get(localObject2)).jdField_b_of_type_Long = ((ArkAppInfo.ContextActionAppInfo)localObject2).jdField_a_of_type_Long;
            }
            else
            {
              localObject3 = new aarf(this, null);
              ((aarf)localObject3).jdField_b_of_type_Long = ((ArkAppInfo.ContextActionAppInfo)localObject2).jdField_a_of_type_Long;
              paramMap.put(localObject2, localObject3);
            }
          }
        }
      }
    } while (paramMap.isEmpty());
    try
    {
      localObject1 = this.jdField_a_of_type_JavaUtilSet.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (ArkAppInfo.Context)((Iterator)localObject1).next();
        localObject2 = new ArkAppInfo.ContextActionAppInfo();
        ((ArkAppInfo.ContextActionAppInfo)localObject2).jdField_a_of_type_JavaLangString = ((ArkAppInfo.Context)localObject3).jdField_a_of_type_JavaLangString;
        ((ArkAppInfo.ContextActionAppInfo)localObject2).jdField_b_of_type_JavaLangString = ((ArkAppInfo.Context)localObject3).jdField_b_of_type_JavaLangString;
        if (!paramMap.containsKey(localObject2))
        {
          localObject3 = new aarf(this, null);
          ((aarf)localObject3).jdField_a_of_type_Long = 0L;
          ((aarf)localObject3).jdField_b_of_type_Long = 0L;
          paramMap.put(localObject2, localObject3);
        }
      }
    }
    finally {}
  }
  
  private boolean a(int paramInt, aarg paramaarg, HashSet paramHashSet)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localQQAppInterface == null)
    {
      ArkAppCenter.b("ArkApp.ActionAppMgr", "_getAppNameByActionFromDB, appInterface is null");
      return false;
    }
    aard localaard = new aard();
    try
    {
      if (!localaard.a(localQQAppInterface.getApplication().getApplicationContext(), paramInt))
      {
        ArkAppCenter.b("ArkApp.ActionAppMgr", String.format("_getAppNameByActionFromDB, fail to init db, type=%d", new Object[] { Integer.valueOf(paramInt) }));
        return false;
      }
      paramaarg = localaard.a(paramaarg.jdField_a_of_type_JavaLangString, paramaarg.jdField_b_of_type_JavaLangString);
      if (paramaarg == null)
      {
        ArkAppCenter.b("ArkApp.ActionAppMgr", String.format("_getAppNameByActionFromDB, getAppInfoByContextAction fail, type=%d", new Object[] { Integer.valueOf(paramInt) }));
        return false;
      }
      paramaarg = paramaarg.iterator();
      while (paramaarg.hasNext()) {
        paramHashSet.add(((ArkAppInfo.ContextActionAppInfo)paramaarg.next()).c);
      }
    }
    finally
    {
      localaard.a();
    }
    return true;
  }
  
  private boolean a(String paramString1, String paramString2, long paramLong1, long paramLong2)
  {
    return a(paramString1, paramString2, paramLong1, paramLong2, null, null);
  }
  
  private boolean a(String paramString1, String paramString2, long paramLong1, long paramLong2, Object paramObject, ArkActionAppMgr.IUpdateActionAppCallback paramIUpdateActionAppCallback)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      if (!jdField_a_of_type_Boolean) {
        throw new AssertionError();
      }
      return false;
    }
    for (;;)
    {
      Object localObject;
      try
      {
        localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        if (!((Iterator)localObject).hasNext()) {
          break label242;
        }
        aarh localaarh = (aarh)((Iterator)localObject).next();
        if ((!localaarh.jdField_a_of_type_JavaLangString.equals(paramString1)) || (!localaarh.jdField_b_of_type_JavaLangString.equals(paramString2))) {
          continue;
        }
        localaarh.jdField_a_of_type_JavaUtilArrayList.add(new Pair(paramObject, paramIUpdateActionAppCallback));
        i = 1;
        if (i != 0)
        {
          ArkAppCenter.b("ArkApp.ActionAppMgr", String.format("_updateAppInfo, task merged, action=%s.%s", new Object[] { paramString1, paramString2 }));
          return true;
        }
        localObject = new aarh();
        ((aarh)localObject).jdField_a_of_type_JavaLangString = paramString1;
        ((aarh)localObject).jdField_b_of_type_JavaLangString = paramString2;
        ((aarh)localObject).jdField_a_of_type_Long = paramLong2;
        ((aarh)localObject).jdField_b_of_type_Long = paramLong1;
        ((aarh)localObject).jdField_a_of_type_JavaUtilArrayList.add(new Pair(paramObject, paramIUpdateActionAppCallback));
        this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
        if (localObject != null) {
          break label234;
        }
        if (!jdField_a_of_type_Boolean) {
          throw new AssertionError();
        }
      }
      finally {}
      return false;
      label234:
      a((aarh)localObject);
      return true;
      label242:
      int i = 0;
    }
  }
  
  private void b(Map paramMap)
  {
    if (paramMap.isEmpty())
    {
      ArkAppCenter.b("ArkApp.ActionAppMgr", "_checkActionNeedUpdate, actionList is empty");
      return;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localQQAppInterface == null)
    {
      ArkAppCenter.b("ArkApp.ActionAppMgr", "_checkActionNeedUpdate, appInterface is null");
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      ArkAppInfo.ContextActionAppInfo localContextActionAppInfo = (ArkAppInfo.ContextActionAppInfo)localIterator.next();
      aarf localaarf = (aarf)paramMap.get(localContextActionAppInfo);
      ArkAppCGI.ActionAppUpdateInfo localActionAppUpdateInfo = new ArkAppCGI.ActionAppUpdateInfo();
      localActionAppUpdateInfo.jdField_a_of_type_JavaLangString = localContextActionAppInfo.jdField_a_of_type_JavaLangString;
      localActionAppUpdateInfo.jdField_b_of_type_JavaLangString = localContextActionAppInfo.jdField_b_of_type_JavaLangString;
      localActionAppUpdateInfo.jdField_b_of_type_Long = localaarf.jdField_b_of_type_Long;
      localActionAppUpdateInfo.jdField_a_of_type_Long = localaarf.jdField_a_of_type_Long;
      localArrayList.add(localActionAppUpdateInfo);
    }
    paramMap = new WeakReference(this);
    ((ArkAppCenter)localQQAppInterface.getManager(120)).a().a(localArrayList, paramMap, new aaqx(this, paramMap, localQQAppInterface));
  }
  
  public void a()
  {
    try
    {
      this.jdField_a_of_type_JavaUtilSet.clear();
      return;
    }
    finally {}
  }
  
  public boolean a()
  {
    ThreadManager.post(new aaqv(this), 5, null, true);
    return true;
  }
  
  public boolean a(String paramString1, String paramString2, Object paramObject, ArkActionAppMgr.IGetAppNameByActionCallback paramIGetAppNameByActionCallback)
  {
    boolean bool = false;
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return false;
    }
    try
    {
      Object localObject = new ArkAppInfo.Context();
      ((ArkAppInfo.Context)localObject).jdField_a_of_type_JavaLangString = paramString1;
      ((ArkAppInfo.Context)localObject).jdField_b_of_type_JavaLangString = paramString2;
      if (this.jdField_a_of_type_JavaUtilSet.contains(localObject)) {
        bool = true;
      }
      localObject = new aarg(null);
      ((aarg)localObject).jdField_a_of_type_Boolean = bool;
      ((aarg)localObject).jdField_a_of_type_JavaLangString = paramString1;
      ((aarg)localObject).jdField_b_of_type_JavaLangString = paramString2;
      ((aarg)localObject).jdField_a_of_type_JavaLangObject = paramObject;
      ((aarg)localObject).jdField_a_of_type_ComTencentMobileqqArkArkActionAppMgr$IGetAppNameByActionCallback = paramIGetAppNameByActionCallback;
      ThreadManager.post(new aarb(this, (aarg)localObject), 5, null, true);
      return true;
    }
    finally {}
  }
  
  public void b()
  {
    a();
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localQQAppInterface == null) {
      ArkAppCenter.b("ArkApp.ActionAppMgr", "clearActionAppCache, appInterface is null");
    }
    aard localaard;
    do
    {
      return;
      localaard = new aard();
      if (localaard.a(localQQAppInterface.getApplication().getApplicationContext(), 2))
      {
        localaard.a();
        localaard.a();
      }
      localaard = new aard();
    } while (!localaard.a(localQQAppInterface.getApplication().getApplicationContext(), 1));
    localaard.a();
    localaard.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkActionAppMgr
 * JD-Core Version:    0.7.0.1
 */