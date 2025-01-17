package com.tencent.mobileqq.emoticonview;

import acdz;
import acea;
import aceb;
import android.util.SparseIntArray;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.pb.emosm.EmosmPb.SmallYellowItem;
import com.tencent.pb.emosm.EmosmPb.SubCmd0x13Rsp;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class CommonUsedSystemEmojiManager
  implements Manager
{
  private static final HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap(5);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public Object a;
  public List a;
  public int[] a;
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(217), Integer.valueOf(0));
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(223), Integer.valueOf(3));
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(168), Integer.valueOf(8));
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(219), Integer.valueOf(10));
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(212), Integer.valueOf(12));
  }
  
  public CommonUsedSystemEmojiManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ArrayOfInt = new int[] { 128525, 13, 128532, 5, 6, 14, 3, 20, 109, 28, 127874, 63, 9, 1, 49, 22, 128557, 11, 128169, 128163, 98, 27, 35, 2 };
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private List a(List paramList)
  {
    Object localObject = paramList;
    if (paramList == null) {
      localObject = new ArrayList();
    }
    paramList = null;
    int i;
    int j;
    int k;
    int m;
    label91:
    int n;
    label94:
    EmosmPb.SmallYellowItem localSmallYellowItem;
    if (((List)localObject).size() < 21)
    {
      i = ((List)localObject).size();
      paramList = new ArrayList();
      if (21 - i < 0)
      {
        j = 0;
        k = 0;
        if (j < this.jdField_a_of_type_ArrayOfInt.length)
        {
          i = this.jdField_a_of_type_ArrayOfInt[j];
          if (i > MessageUtils.b.length)
          {
            m = MessageUtils.b[i];
            i = 2;
            n = 0;
            if (n >= ((List)localObject).size()) {
              break label346;
            }
            localSmallYellowItem = (EmosmPb.SmallYellowItem)((List)localObject).get(n);
            i1 = localSmallYellowItem.type.get();
            int i2 = localSmallYellowItem.id.get();
            if ((i1 != i) || (i2 != m)) {
              break label335;
            }
          }
        }
      }
    }
    label335:
    label346:
    for (int i1 = 1;; i1 = 0)
    {
      n = k;
      if (i1 == 0)
      {
        n = k + 1;
        localSmallYellowItem = new EmosmPb.SmallYellowItem();
        localSmallYellowItem.type.set(i);
        localSmallYellowItem.id.set(m);
        localSmallYellowItem.ts.set(0L);
        paramList.add(localSmallYellowItem);
      }
      j += 1;
      k = n;
      break;
      m = EmotcationConstants.jdField_a_of_type_AndroidUtilSparseIntArray.get(i);
      i = m;
      if (jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(m)))
      {
        QLog.d("CommonUsedSystemEmojiManager", 2, "paddedData dedault before EMOTIONPANEL_EMOJI_MAP index = " + m);
        i = ((Integer)jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(m))).intValue();
        QLog.d("CommonUsedSystemEmojiManager", 2, "paddedData dedault after EMOTIONPANEL_EMOJI_MAP index = " + i);
      }
      n = 1;
      m = i;
      i = n;
      break label91;
      n += 1;
      break label94;
      return paramList;
    }
  }
  
  private List a(List paramList1, List paramList2)
  {
    List localList = null;
    int j = 0;
    if (QLog.isColorLevel()) {
      QLog.d("CommonUsedSystemEmojiManager", 2, "mergeAndSortSystemEmojiInfo");
    }
    if ((paramList1 == null) && (paramList2 == null))
    {
      QLog.e("CommonUsedSystemEmojiManager", 1, "mergeAndSortSystemEmojiInfo list IS null");
      paramList1 = localList;
      return paramList1;
    }
    if (paramList1 == null) {
      QLog.e("CommonUsedSystemEmojiManager", 1, "mergeAndSortSystemEmojiInfo  list1 = NULL");
    }
    for (localList = paramList2;; localList = null)
    {
      if (paramList2 == null)
      {
        QLog.e("CommonUsedSystemEmojiManager", 1, "mergeAndSortSystemEmojiInfo  list2 = NULL");
        localList = paramList1;
      }
      if (localList == null)
      {
        paramList1.addAll(paramList2);
        localList = paramList1;
      }
      for (;;)
      {
        Object localObject;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder("mergeAndSortSystemEmojiInfo:");
          if (paramList1 != null)
          {
            ((StringBuilder)localObject).append("befor sort list1 : ");
            i = 0;
            while (i < paramList1.size())
            {
              EmosmPb.SmallYellowItem localSmallYellowItem = (EmosmPb.SmallYellowItem)paramList1.get(i);
              ((StringBuilder)localObject).append("type = " + localSmallYellowItem.type.get()).append(";id = " + localSmallYellowItem.id.get()).append(";ts = " + localSmallYellowItem.ts.get());
              i += 1;
            }
          }
          if (paramList2 != null)
          {
            ((StringBuilder)localObject).append("befor sort list2 : ");
            i = 0;
            while (i < paramList2.size())
            {
              paramList1 = (EmosmPb.SmallYellowItem)paramList2.get(i);
              ((StringBuilder)localObject).append("type = " + paramList1.type.get()).append(";id = " + paramList1.id.get()).append(";ts = " + paramList1.ts.get());
              i += 1;
            }
          }
          QLog.d("CommonUsedSystemEmojiManager", 2, "mergeAndSortSystemEmojiInfo merge:" + ((StringBuilder)localObject).toString());
        }
        Collections.sort(localList, new acea(this));
        if (QLog.isColorLevel())
        {
          paramList1 = new StringBuilder("mergeAndSortSystemEmojiInfo:");
          paramList1.append("after sort ,mergeList:");
          i = 0;
          while (i < localList.size())
          {
            paramList2 = (EmosmPb.SmallYellowItem)localList.get(i);
            paramList1.append("type = " + paramList2.type.get()).append(";id = " + paramList2.id.get()).append(";ts = " + paramList2.ts.get());
            i += 1;
          }
          QLog.d("CommonUsedSystemEmojiManager", 2, "mergeAndSortSystemEmojiInfo merge:" + paramList1.toString());
        }
        paramList1 = new HashSet();
        paramList2 = localList.iterator();
        while (paramList2.hasNext())
        {
          localObject = (EmosmPb.SmallYellowItem)paramList2.next();
          localObject = ((EmosmPb.SmallYellowItem)localObject).type.get() + "-" + ((EmosmPb.SmallYellowItem)localObject).id.get();
          if (paramList1.contains(localObject)) {
            paramList2.remove();
          } else {
            paramList1.add(localObject);
          }
        }
        paramList1 = localList;
        if (!QLog.isColorLevel()) {
          break;
        }
        paramList1 = new StringBuilder("mergeAndSortSystemEmojiInfo:");
        paramList1.append("after merge ,mergeList:");
        int i = j;
        while (i < localList.size())
        {
          paramList2 = (EmosmPb.SmallYellowItem)localList.get(i);
          paramList1.append("type = " + paramList2.type.get()).append(";id = " + paramList2.id.get()).append(";ts = " + paramList2.ts.get());
          i += 1;
        }
        QLog.d("CommonUsedSystemEmojiManager", 2, "mergeAndSortSystemEmojiInfo merge:" + paramList1.toString());
        return localList;
      }
    }
  }
  
  private List c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CommonUsedSystemEmojiManager", 2, "getCacheInfo");
    }
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() < 1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("CommonUsedSystemEmojiManager", 2, "getCacheInfo is null");
      }
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    try
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add((EmosmPb.SmallYellowItem)localIterator.next());
      }
    }
    finally {}
    return localList;
  }
  
  public List a()
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() < 1))
    {
      QLog.e("CommonUsedSystemEmojiManager", 1, "getCommonUsedSystemEmojiInfo  useDefaultinfo");
      a();
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      if (i < this.jdField_a_of_type_ArrayOfInt.length)
      {
        EmosmPb.SmallYellowItem localSmallYellowItem = new EmosmPb.SmallYellowItem();
        int j = this.jdField_a_of_type_ArrayOfInt[i];
        int k;
        if (j > MessageUtils.b.length)
        {
          localSmallYellowItem.type.set(2);
          k = EmotcationConstants.jdField_a_of_type_AndroidUtilSparseIntArray.get(j);
          j = k;
          if (jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(k)))
          {
            QLog.d("CommonUsedSystemEmojiManager", 2, "getCommonUsedSystemEmojiInfo dedault before EMOTIONPANEL_EMOJI_MAP index = " + k);
            j = ((Integer)jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(k))).intValue();
            QLog.d("CommonUsedSystemEmojiManager", 2, "getCommonUsedSystemEmojiInfo dedault after EMOTIONPANEL_EMOJI_MAP index = " + j);
          }
          localSmallYellowItem.id.set(j);
        }
        for (;;)
        {
          localSmallYellowItem.ts.set(0L);
          localArrayList.add(localSmallYellowItem);
          i += 1;
          break;
          localSmallYellowItem.type.set(1);
          k = MessageUtils.b[j];
          j = k;
          if (k == 250) {
            j = 10;
          }
          localSmallYellowItem.id.set(j);
        }
      }
      try
      {
        this.jdField_a_of_type_JavaUtilList = localArrayList;
        return c();
      }
      finally {}
    }
    if (QLog.isColorLevel()) {
      QLog.d("CommonUsedSystemEmojiManager", 2, "getCommonUsedSystemEmojiInfo ");
    }
    return c();
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CommonUsedSystemEmojiManager", 2, "updateCacheFromFile");
    }
    ThreadManager.getFileThreadHandler().post(new acdz(this));
  }
  
  public void a(EmosmPb.SmallYellowItem paramSmallYellowItem)
  {
    int i = 0;
    if (paramSmallYellowItem == null)
    {
      QLog.e("CommonUsedSystemEmojiManager", 1, "saveSystemEmojiInfoToCahce info = null");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("CommonUsedSystemEmojiManager", 2, "saveSystemEmojiInfoToCahce id = " + paramSmallYellowItem.id.get() + ";type = " + paramSmallYellowItem.type.get() + ";ts = " + paramSmallYellowItem.ts.get());
    }
    int j = paramSmallYellowItem.type.get();
    int k = paramSmallYellowItem.id.get();
    for (;;)
    {
      EmosmPb.SmallYellowItem localSmallYellowItem;
      try
      {
        if (this.jdField_a_of_type_JavaUtilList == null) {
          break label330;
        }
        if (i >= this.jdField_a_of_type_JavaUtilList.size()) {
          break label355;
        }
        localSmallYellowItem = (EmosmPb.SmallYellowItem)this.jdField_a_of_type_JavaUtilList.get(i);
        if ((localSmallYellowItem.type.get() == j) && (localSmallYellowItem.id.get() == k))
        {
          localSmallYellowItem = null;
          if (i < 0) {
            break label288;
          }
          localSmallYellowItem = (EmosmPb.SmallYellowItem)this.jdField_a_of_type_JavaUtilList.remove(i);
          if ((QLog.isColorLevel()) && (localSmallYellowItem != null)) {
            QLog.d("CommonUsedSystemEmojiManager", 2, "saveSystemEmojiInfoToCahce removeInfo : type =" + localSmallYellowItem.type.get() + ";id = " + localSmallYellowItem.id.get() + ";ts = " + localSmallYellowItem.ts.get());
          }
          this.jdField_a_of_type_JavaUtilList.add(0, paramSmallYellowItem);
          return;
        }
      }
      finally {}
      i += 1;
      continue;
      label288:
      if (this.jdField_a_of_type_JavaUtilList.size() >= 21)
      {
        localSmallYellowItem = (EmosmPb.SmallYellowItem)this.jdField_a_of_type_JavaUtilList.remove(this.jdField_a_of_type_JavaUtilList.size() - 1);
        continue;
        label330:
        this.jdField_a_of_type_JavaUtilList = new ArrayList();
        this.jdField_a_of_type_JavaUtilList.add(paramSmallYellowItem);
        continue;
        label355:
        i = -1;
      }
    }
  }
  
  public void a(File paramFile1, File paramFile2)
  {
    Object localObject2;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      localObject2 = FileUtils.a(paramFile1);
      if (localObject2 == null)
      {
        QLog.e("CommonUsedSystemEmojiManager", 1, "Can not translate pb file to byte");
        return;
      }
    }
    paramFile1 = new EmosmPb.SubCmd0x13Rsp();
    for (;;)
    {
      int i;
      try
      {
        paramFile1.mergeFrom((byte[])localObject2);
        ??? = paramFile1.itemlist.get();
        localObject2 = ((List)???).iterator();
        if (((Iterator)localObject2).hasNext())
        {
          EmosmPb.SmallYellowItem localSmallYellowItem = (EmosmPb.SmallYellowItem)((Iterator)localObject2).next();
          i = 0;
          if (i >= EmotcationConstants.c.length) {
            continue;
          }
          if (localSmallYellowItem.id.get() == EmotcationConstants.c[i]) {
            ((Iterator)localObject2).remove();
          }
        }
        else
        {
          paramFile1.itemlist.set((List)???);
          FileUtils.a(paramFile2.getAbsolutePath(), paramFile1.toByteArray(), false);
          return;
        }
      }
      catch (Exception paramFile1)
      {
        QLog.e("CommonUsedSystemEmojiManager", 1, "getLocalSystemEmojiInfoFromFile mergeFromBody exception e = " + paramFile1.getMessage());
        return;
      }
      i += 1;
    }
  }
  
  public void a(List paramList)
  {
    if (paramList == null)
    {
      QLog.e("CommonUsedSystemEmojiManager", 1, "updateItemInfo info = null");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("CommonUsedSystemEmojiManager", 2, "updateItemInfo backList size = " + paramList.size());
    }
    ??? = new ArrayList();
    int i = 0;
    Object localObject2;
    if (i < paramList.size())
    {
      localObject2 = (EmosmPb.SmallYellowItem)paramList.get(i);
      int j = ((EmosmPb.SmallYellowItem)localObject2).type.get();
      int m = ((EmosmPb.SmallYellowItem)localObject2).id.get();
      int k;
      if (j == 1) {
        if ((m >= 0) && (m < MessageUtils.b.length))
        {
          k = MessageUtils.b[m];
          j = k;
          if (k == 250) {
            j = 10;
          }
          if ((j >= EmotcationConstants.jdField_a_of_type_Int) || (j < 0))
          {
            ((List)???).add(localObject2);
            QLog.e("CommonUsedSystemEmojiManager", 1, "updateItemInfo system id overflow index = " + m + ";emId = " + j);
          }
        }
      }
      for (;;)
      {
        i += 1;
        break;
        ((EmosmPb.SmallYellowItem)localObject2).id.set(j);
        continue;
        ((List)???).add(localObject2);
        QLog.e("CommonUsedSystemEmojiManager", 1, "updateItemInfo system id overflow index = " + m);
        continue;
        if (j == 2)
        {
          k = EmotcationConstants.jdField_a_of_type_AndroidUtilSparseIntArray.get(m);
          j = k;
          if (jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(k)))
          {
            QLog.d("CommonUsedSystemEmojiManager", 2, "updateItemInfo before EMOTIONPANEL_EMOJI_MAP index = " + k);
            j = ((Integer)jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(k))).intValue();
            QLog.d("CommonUsedSystemEmojiManager", 2, "updateItemInfo after EMOTIONPANEL_EMOJI_MAP index = " + j);
          }
          if (j < 0)
          {
            ((List)???).add(localObject2);
            QLog.e("CommonUsedSystemEmojiManager", 1, "updateItemInfo emoji id overflow index = " + m + ";localIndex = " + j);
          }
          else
          {
            ((EmosmPb.SmallYellowItem)localObject2).id.set(j);
          }
        }
      }
    }
    if (((List)???).size() > 0) {
      paramList.removeAll((Collection)???);
    }
    if (paramList.size() < 1)
    {
      QLog.e("CommonUsedSystemEmojiManager", 1, "updateItemInfo itemInfos size < 1");
      return;
    }
    new ArrayList();
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) {
      paramList = a(paramList, c());
    }
    while (paramList.size() > 21)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CommonUsedSystemEmojiManager", 2, "before remove size = " + paramList.size());
      }
      ??? = new ArrayList();
      i = 21;
      for (;;)
      {
        if (i < paramList.size())
        {
          ((List)???).add(paramList.get(i));
          i += 1;
          continue;
          paramList = a(null, paramList);
          break;
        }
      }
      paramList.removeAll((Collection)???);
      if (QLog.isColorLevel()) {
        QLog.d("CommonUsedSystemEmojiManager", 2, "after remove size = " + paramList.size());
      }
    }
    ??? = a(paramList);
    if (??? != null) {
      paramList.addAll((Collection)???);
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      localObject2 = new File(BaseApplicationImpl.sApplication.getFilesDir(), "commonusedSystemEmojiInfoFile_v3_" + BaseApplicationImpl.sApplication.getRuntime().getAccount());
      EmosmPb.SubCmd0x13Rsp localSubCmd0x13Rsp = new EmosmPb.SubCmd0x13Rsp();
      localSubCmd0x13Rsp.itemlist.set(paramList);
      FileUtils.a(((File)localObject2).getAbsolutePath(), localSubCmd0x13Rsp.toByteArray(), false);
      try
      {
        this.jdField_a_of_type_JavaUtilList = paramList;
        return;
      }
      finally {}
    }
  }
  
  public List b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CommonUsedSystemEmojiManager", 2, "getLocalSystemEmojiInfoFromFile");
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      Object localObject3 = new File(BaseApplicationImpl.sApplication.getFilesDir(), "commonusedSystemEmojiInfoFile_v3_" + BaseApplicationImpl.sApplication.getRuntime().getAccount());
      if (!((File)localObject3).exists())
      {
        QLog.d("CommonUsedSystemEmojiManager", 2, "getLocalSystemEmojiInfoFromFile file not exists");
        return null;
      }
      localObject3 = FileUtils.a((File)localObject3);
      if (localObject3 == null)
      {
        QLog.e("CommonUsedSystemEmojiManager", 1, "Can not translate pb file to byte");
        return null;
      }
    }
    ??? = new EmosmPb.SubCmd0x13Rsp();
    List localList;
    Object localObject4;
    int j;
    EmosmPb.SmallYellowItem localSmallYellowItem;
    int k;
    label315:
    int i;
    for (;;)
    {
      int m;
      try
      {
        ((EmosmPb.SubCmd0x13Rsp)???).mergeFrom(arrayOfByte);
        localList = ((EmosmPb.SubCmd0x13Rsp)???).itemlist.get();
        localObject4 = new ArrayList();
        ??? = new ArrayList();
        if ((localList == null) || (localList.size() <= 0)) {
          break;
        }
        j = 0;
        if (j >= localList.size()) {
          break;
        }
        localObject5 = (EmosmPb.SmallYellowItem)localList.get(j);
        localSmallYellowItem = new EmosmPb.SmallYellowItem();
        localSmallYellowItem.ts.set(((EmosmPb.SmallYellowItem)localObject5).ts.get());
        localSmallYellowItem.type.set(((EmosmPb.SmallYellowItem)localObject5).type.get());
        m = ((EmosmPb.SmallYellowItem)localObject5).type.get();
        k = ((EmosmPb.SmallYellowItem)localObject5).id.get();
        if (m != 1) {
          break label371;
        }
        if ((k >= 0) && (k < EmotcationConstants.jdField_a_of_type_Int)) {
          break label776;
        }
        QLog.e("CommonUsedSystemEmojiManager", 1, "getLocalSystemEmojiInfoFromFile type = system, id error, id = " + k);
      }
      catch (Exception localException)
      {
        QLog.e("CommonUsedSystemEmojiManager", 1, "getLocalSystemEmojiInfoFromFile mergeFromBody exception e = " + localException.getMessage());
        return null;
      }
      localSmallYellowItem.id.set(i);
      ((List)localObject4).add(localSmallYellowItem);
      break label769;
      label371:
      i = k;
      if (m == 2)
      {
        if ((k < 0) || (k >= EmotcationConstants.b))
        {
          QLog.e("CommonUsedSystemEmojiManager", 1, "getLocalSystemEmojiInfoFromFile type = emoji, id error, id = " + k);
          break label769;
        }
        i = k;
        if (jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(k)))
        {
          QLog.d("CommonUsedSystemEmojiManager", 2, "getLocalSystemEmojiInfoFromFile before EMOTIONPANEL_EMOJI_MAP index = " + k);
          i = ((Integer)jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(k))).intValue();
          QLog.d("CommonUsedSystemEmojiManager", 2, "getLocalSystemEmojiInfoFromFile after EMOTIONPANEL_EMOJI_MAP index = " + i);
        }
      }
    }
    Object localObject5 = c();
    if ((localList != null) && (localList.size() > 0)) {
      i = 0;
    }
    for (;;)
    {
      if (i < localList.size())
      {
        localSmallYellowItem = (EmosmPb.SmallYellowItem)localList.get(i);
        j = localSmallYellowItem.type.get();
        k = localSmallYellowItem.id.get();
        if (j == 1) {
          if ((k >= 0) && (k < MessageUtils.a.length))
          {
            j = k;
            if (k == 10) {
              j = 250;
            }
            j = MessageUtils.a[j];
            localSmallYellowItem.id.set(j);
          }
        }
        for (;;)
        {
          localException.add(localSmallYellowItem);
          break label791;
          QLog.e("CommonUsedSystemEmojiManager", 1, "getLocalSystemEmojiInfoFromFile system error localId = " + k);
          break label791;
          if ((k < 0) || (k >= EmotcationConstants.d.length)) {
            break;
          }
          j = EmotcationConstants.d[k];
          localSmallYellowItem.id.set(j);
        }
        QLog.e("CommonUsedSystemEmojiManager", 1, "getLocalSystemEmojiInfoFromFile emoji error localId = " + k);
      }
      else
      {
        localList = a((List)localObject4, (List)localObject5);
        localObject4 = a(localList);
        if (localObject4 != null) {
          localList.addAll((Collection)localObject4);
        }
        try
        {
          this.jdField_a_of_type_JavaUtilList = localList;
          return localException;
        }
        finally {}
        label769:
        j += 1;
        break;
        label776:
        i = k;
        if (k != 250) {
          break label315;
        }
        i = 10;
        break label315;
      }
      label791:
      i += 1;
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CommonUsedSystemEmojiManager", 2, "saveSystemEmojiInfoToFile");
    }
    ThreadManager.getFileThreadHandler().post(new aceb(this));
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.CommonUsedSystemEmojiManager
 * JD-Core Version:    0.7.0.1
 */