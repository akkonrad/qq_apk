package com.tencent.mobileqq.managers;

import aeez;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.DraftTextInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class DraftTextManager
{
  private static LruCache jdField_a_of_type_AndroidSupportV4UtilLruCache = new LruCache(10);
  private static DraftTextManager jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager;
  private static HashSet jdField_a_of_type_JavaUtilHashSet = new HashSet();
  private static LruCache b = new LruCache(99);
  private Object jdField_a_of_type_JavaLangObject = new Object();
  
  private static DraftSummaryInfo a(DraftTextInfo paramDraftTextInfo)
  {
    if (paramDraftTextInfo == null) {
      return null;
    }
    DraftSummaryInfo localDraftSummaryInfo = new DraftSummaryInfo();
    localDraftSummaryInfo.setUin(paramDraftTextInfo.uin);
    localDraftSummaryInfo.setType(paramDraftTextInfo.type);
    localDraftSummaryInfo.setTime(paramDraftTextInfo.time);
    if ((paramDraftTextInfo.sourceMsgSeq != 0L) && (TextUtils.isEmpty(paramDraftTextInfo.text)))
    {
      localDraftSummaryInfo.setSummary(" ");
      return localDraftSummaryInfo;
    }
    localDraftSummaryInfo.setSummary(a(paramDraftTextInfo.text));
    return localDraftSummaryInfo;
  }
  
  public static DraftTextManager a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      throw new IllegalArgumentException("DraftTextManager this.app == null");
    }
    if (jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager == null)
    {
      jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager = new DraftTextManager();
      a(paramQQAppInterface);
    }
    return jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager;
  }
  
  private static String a(String paramString)
  {
    return Utils.a(paramString, 50);
  }
  
  private static String a(String paramString, int paramInt)
  {
    return MsgProxyUtils.a(paramString, paramInt);
  }
  
  private static List a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    try
    {
      List localList = paramQQAppInterface.a(DraftTextInfo.class, new DraftTextInfo().getTableName(), false, null, null, null, null, null, null);
      if (localList != null)
      {
        int i = localList.size();
        if (i > 0) {
          return localList;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        paramQQAppInterface.a();
      }
    }
    finally
    {
      paramQQAppInterface.a();
    }
    return new ArrayList();
  }
  
  private static void a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = a(paramQQAppInterface).iterator();
    while (paramQQAppInterface.hasNext())
    {
      DraftTextInfo localDraftTextInfo = (DraftTextInfo)paramQQAppInterface.next();
      if ((!TextUtils.isEmpty(localDraftTextInfo.text)) || (localDraftTextInfo.sourceMsgSeq != 0L))
      {
        String str = a(localDraftTextInfo.uin, localDraftTextInfo.type);
        jdField_a_of_type_JavaUtilHashSet.add(str);
        jdField_a_of_type_AndroidSupportV4UtilLruCache.put(str, localDraftTextInfo);
        b.put(str, a(localDraftTextInfo));
      }
    }
  }
  
  public DraftSummaryInfo a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    String str = a(paramString, paramInt);
    Object localObject1;
    if (!jdField_a_of_type_JavaUtilHashSet.contains(str)) {
      localObject1 = null;
    }
    do
    {
      do
      {
        do
        {
          return localObject1;
          localObject2 = (DraftSummaryInfo)b.get(str);
          localObject1 = localObject2;
        } while (localObject2 != null);
        Object localObject2 = (DraftTextInfo)jdField_a_of_type_AndroidSupportV4UtilLruCache.get(str);
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = a(paramQQAppInterface, paramString, paramInt);
        }
        paramQQAppInterface = a((DraftTextInfo)localObject1);
        localObject1 = paramQQAppInterface;
      } while (paramQQAppInterface == null);
      localObject1 = paramQQAppInterface;
    } while (TextUtils.isEmpty(paramQQAppInterface.getSummary()));
    b.put(str, paramQQAppInterface);
    return paramQQAppInterface;
  }
  
  public DraftTextInfo a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      paramQQAppInterface = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
      try
      {
        paramString = paramQQAppInterface.a(DraftTextInfo.class, new DraftTextInfo().getTableName(), false, "uin=? AND type=?", new String[] { paramString, String.valueOf(paramInt) }, null, null, null, null);
        if ((paramString != null) && (paramString.size() > 0))
        {
          paramString = (DraftTextInfo)paramString.get(0);
          paramQQAppInterface.a();
          return paramString;
        }
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
          paramQQAppInterface.a();
        }
        paramQQAppInterface = finally;
        throw paramQQAppInterface;
      }
      finally
      {
        paramQQAppInterface.a();
      }
      return new DraftTextInfo();
    }
  }
  
  public String a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DraftTextManger", 4, "Get draft text| uin=" + paramString + " draftList=" + jdField_a_of_type_JavaUtilHashSet + " cache=" + jdField_a_of_type_AndroidSupportV4UtilLruCache);
    }
    String str = a(paramString, paramInt);
    if (!jdField_a_of_type_JavaUtilHashSet.contains(str)) {
      return null;
    }
    DraftTextInfo localDraftTextInfo = (DraftTextInfo)jdField_a_of_type_AndroidSupportV4UtilLruCache.get(str);
    if (localDraftTextInfo != null) {
      return localDraftTextInfo.text;
    }
    paramQQAppInterface = a(paramQQAppInterface, paramString, paramInt);
    if ((paramQQAppInterface != null) && (!StringUtil.a(paramQQAppInterface.text))) {
      jdField_a_of_type_AndroidSupportV4UtilLruCache.put(str, paramQQAppInterface);
    }
    if (paramQQAppInterface != null) {
      return paramQQAppInterface.text;
    }
    return "";
  }
  
  public void a()
  {
    jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager = null;
    jdField_a_of_type_JavaUtilHashSet.clear();
    jdField_a_of_type_AndroidSupportV4UtilLruCache = new LruCache(10);
    b = new LruCache(99);
  }
  
  /* Error */
  public void a(QQAppInterface paramQQAppInterface, DraftTextInfo paramDraftTextInfo)
  {
    // Byte code:
    //   0: invokestatic 199	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +11 -> 14
    //   6: ldc 201
    //   8: iconst_2
    //   9: ldc 237
    //   11: invokestatic 224	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   14: aload_0
    //   15: getfield 32	com/tencent/mobileqq/managers/DraftTextManager:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   18: astore_3
    //   19: aload_3
    //   20: monitorenter
    //   21: aload_2
    //   22: ifnonnull +6 -> 28
    //   25: aload_3
    //   26: monitorexit
    //   27: return
    //   28: aload_2
    //   29: getfield 42	com/tencent/mobileqq/data/DraftTextInfo:uin	Ljava/lang/String;
    //   32: aload_2
    //   33: getfield 50	com/tencent/mobileqq/data/DraftTextInfo:type	I
    //   36: invokestatic 158	com/tencent/mobileqq/managers/DraftTextManager:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   39: astore 4
    //   41: getstatic 28	com/tencent/mobileqq/managers/DraftTextManager:jdField_a_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   44: aload 4
    //   46: invokevirtual 172	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   49: ifne +12 -> 61
    //   52: getstatic 28	com/tencent/mobileqq/managers/DraftTextManager:jdField_a_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   55: aload 4
    //   57: invokevirtual 162	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   60: pop
    //   61: getstatic 20	com/tencent/mobileqq/managers/DraftTextManager:jdField_a_of_type_AndroidSupportV4UtilLruCache	Landroid/support/v4/util/LruCache;
    //   64: aload 4
    //   66: aload_2
    //   67: invokevirtual 166	android/support/v4/util/LruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   70: pop
    //   71: getstatic 22	com/tencent/mobileqq/managers/DraftTextManager:b	Landroid/support/v4/util/LruCache;
    //   74: aload 4
    //   76: aload_2
    //   77: invokestatic 168	com/tencent/mobileqq/managers/DraftTextManager:a	(Lcom/tencent/mobileqq/data/DraftTextInfo;)Lcom/tencent/mobileqq/data/DraftSummaryInfo;
    //   80: invokevirtual 166	android/support/v4/util/LruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   83: pop
    //   84: new 239	aeey
    //   87: dup
    //   88: aload_0
    //   89: aload_1
    //   90: aload_2
    //   91: invokespecial 242	aeey:<init>	(Lcom/tencent/mobileqq/managers/DraftTextManager;Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/data/DraftTextInfo;)V
    //   94: bipush 8
    //   96: aconst_null
    //   97: iconst_0
    //   98: invokestatic 248	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   101: aload_3
    //   102: monitorexit
    //   103: return
    //   104: astore_1
    //   105: aload_3
    //   106: monitorexit
    //   107: aload_1
    //   108: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	109	0	this	DraftTextManager
    //   0	109	1	paramQQAppInterface	QQAppInterface
    //   0	109	2	paramDraftTextInfo	DraftTextInfo
    //   18	88	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   25	27	104	finally
    //   28	61	104	finally
    //   61	103	104	finally
    //   105	107	104	finally
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      String str = a(paramString, paramInt);
      if (!jdField_a_of_type_JavaUtilHashSet.contains(str)) {
        return false;
      }
      DraftTextInfo localDraftTextInfo = (DraftTextInfo)jdField_a_of_type_AndroidSupportV4UtilLruCache.get(str);
      jdField_a_of_type_JavaUtilHashSet.remove(str);
      jdField_a_of_type_AndroidSupportV4UtilLruCache.remove(str);
      b.remove(str);
      ThreadManager.post(new aeez(this, localDraftTextInfo, paramQQAppInterface, paramString, paramInt), 8, null, false);
      return false;
    }
  }
  
  public boolean a(String paramString, int paramInt)
  {
    paramString = a(paramString, paramInt);
    return jdField_a_of_type_JavaUtilHashSet.contains(paramString);
  }
  
  public DraftTextInfo b(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    DraftTextInfo localDraftTextInfo = null;
    String str = a(paramString, paramInt);
    if (jdField_a_of_type_JavaUtilHashSet.contains(str)) {
      localDraftTextInfo = (DraftTextInfo)jdField_a_of_type_AndroidSupportV4UtilLruCache.get(str);
    }
    Object localObject = localDraftTextInfo;
    if (localDraftTextInfo == null)
    {
      paramQQAppInterface = a(paramQQAppInterface, paramString, paramInt);
      localObject = paramQQAppInterface;
      if (paramQQAppInterface != null)
      {
        localObject = paramQQAppInterface;
        if (!StringUtil.a(paramQQAppInterface.text))
        {
          jdField_a_of_type_AndroidSupportV4UtilLruCache.put(str, paramQQAppInterface);
          localObject = paramQQAppInterface;
        }
      }
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.managers.DraftTextManager
 * JD-Core Version:    0.7.0.1
 */