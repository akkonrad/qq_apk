package com.tencent.mobileqq.app;

import com.tencent.mobileqq.search.model.SearchEntryDataModel;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.List;
import pb.unite.search.DynamicAssociationWord.SuggestUrlItem;

public class UniteSearchObserver
  implements BusinessObserver
{
  public void a(int paramInt, String paramString) {}
  
  public void a(int paramInt1, String paramString, int paramInt2) {}
  
  public void a(int paramInt, List paramList) {}
  
  public void a(SearchEntryDataModel paramSearchEntryDataModel) {}
  
  public void a(String paramString, int paramInt, List paramList1, List paramList2, DynamicAssociationWord.SuggestUrlItem paramSuggestUrlItem) {}
  
  public void a(String paramString1, Integer paramInteger, String paramString2) {}
  
  public void a(String paramString, DynamicAssociationWord.SuggestUrlItem paramSuggestUrlItem, int paramInt) {}
  
  public void a(String paramString1, boolean paramBoolean, String paramString2, int paramInt, String paramString3) {}
  
  public void a(String paramString1, boolean paramBoolean, String paramString2, int paramInt, String paramString3, long[] paramArrayOfLong) {}
  
  public void a(String paramString1, boolean paramBoolean1, String paramString2, byte[] paramArrayOfByte, boolean paramBoolean2, List paramList1, List paramList2) {}
  
  public void a(String paramString1, boolean paramBoolean1, String paramString2, byte[] paramArrayOfByte, boolean paramBoolean2, List paramList1, long[] paramArrayOfLong, String paramString3, List paramList2, boolean paramBoolean3) {}
  
  public void a(List paramList, int paramInt) {}
  
  public void b(int paramInt, String paramString) {}
  
  public void b(int paramInt1, String paramString, int paramInt2) {}
  
  public void b(String paramString1, Integer paramInteger, String paramString2) {}
  
  public void b(List paramList, int paramInt) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    int i = -1;
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.UniteSearchObserver", 2, "UniteSearchObserver onUpdate type" + paramInt + " isSuccess=" + paramBoolean + " data=" + paramObject);
    }
    Object localObject1;
    Object localObject2;
    switch (paramInt)
    {
    case 1001: 
    case 1003: 
    default: 
    case 1005: 
    case 1006: 
    case 1004: 
    case 1000: 
      Object localObject4;
      do
      {
        boolean bool;
        long[] arrayOfLong;
        do
        {
          return;
          if (paramBoolean)
          {
            paramObject = (Object[])paramObject;
            a((String)paramObject[0], (DynamicAssociationWord.SuggestUrlItem)paramObject[1], ((Integer)paramObject[2]).intValue());
            return;
          }
          paramObject = (Object[])paramObject;
          b((String)paramObject[0], (Integer)paramObject[1], (String)paramObject[2]);
          return;
          if (paramBoolean)
          {
            paramObject = (Object[])paramObject;
            a((String)paramObject[0], ((Integer)paramObject[1]).intValue(), (List)paramObject[2], (List)paramObject[3], (DynamicAssociationWord.SuggestUrlItem)paramObject[4]);
            return;
          }
          paramObject = (Object[])paramObject;
          a((String)paramObject[0], (Integer)paramObject[1], (String)paramObject[2]);
          return;
          if (paramBoolean)
          {
            paramObject = (Object[])paramObject;
            a((String)paramObject[0], ((Boolean)paramObject[1]).booleanValue(), (String)paramObject[2], (byte[])paramObject[3], ((Boolean)paramObject[4]).booleanValue(), (List)paramObject[5], (List)paramObject[6]);
            return;
          }
          localObject3 = (Object[])paramObject;
          paramObject = (String)localObject3[0];
          paramBoolean = ((Boolean)localObject3[1]).booleanValue();
          localObject1 = (String)localObject3[2];
          localObject2 = (Integer)localObject3[3];
          localObject3 = (String)localObject3[4];
          a(paramObject, paramBoolean, (String)localObject1, ((Integer)localObject2).intValue(), (String)localObject3);
          return;
          if (!paramBoolean) {
            break;
          }
          paramObject = (Object[])paramObject;
          localObject1 = (String)paramObject[0];
          paramBoolean = ((Boolean)paramObject[1]).booleanValue();
          localObject2 = (String)paramObject[2];
          localObject3 = (byte[])paramObject[3];
          bool = ((Boolean)paramObject[4]).booleanValue();
          localObject4 = (List)paramObject[5];
          arrayOfLong = (long[])paramObject[6];
          a((String)localObject1, paramBoolean, (String)localObject2, (byte[])localObject3, bool, (List)localObject4, arrayOfLong, (String)paramObject[7], (List)paramObject[8], ((Boolean)paramObject[9]).booleanValue());
        } while (!QLog.isColorLevel());
        QLog.i("Q.uniteSearch.UniteSearchObserver", 2, "handleTabSearchResult_NOTIFY_TYPE_TAB_SEARCH isEnd = " + bool + " mask;" + Arrays.toString(arrayOfLong) + " key=" + (String)localObject1 + " time=" + (String)localObject2);
        return;
        localObject4 = (Object[])paramObject;
        paramObject = (String)localObject4[0];
        paramBoolean = ((Boolean)localObject4[1]).booleanValue();
        localObject1 = (String)localObject4[2];
        localObject2 = (Integer)localObject4[3];
        Object localObject3 = (String)localObject4[4];
        localObject4 = (long[])localObject4[5];
        a(paramObject, paramBoolean, (String)localObject1, ((Integer)localObject2).intValue(), (String)localObject3, (long[])localObject4);
      } while (!QLog.isColorLevel());
      QLog.w("Q.uniteSearch.UniteSearchObserver", 2, "handleTabSearchResult_NOTIFY_TYPE_TAB_SEARCH error!  mask;" + Arrays.toString((long[])localObject4) + " key=" + paramObject + " time=" + (String)localObject1);
      return;
    case 1002: 
      if (paramObject != null)
      {
        if (paramBoolean)
        {
          localObject1 = (Object[])paramObject;
          paramObject = (Integer)localObject1[0];
          localObject1 = (List)localObject1[1];
          a(paramObject.intValue(), (List)localObject1);
          return;
        }
        localObject1 = (Object[])paramObject;
        paramObject = (Integer)localObject1[0];
        localObject1 = (String)localObject1[1];
        a(paramObject.intValue(), (String)localObject1);
        return;
      }
      a(-1, "");
      return;
    case 1007: 
      if (paramObject != null)
      {
        if (paramBoolean)
        {
          localObject1 = (Object[])paramObject;
          paramObject = (List)localObject1[0];
          localObject1 = (Integer)localObject1[1];
          if (localObject1 != null) {}
          for (paramInt = ((Integer)localObject1).intValue();; paramInt = -1)
          {
            b(paramObject, paramInt);
            return;
          }
        }
        localObject2 = (Object[])paramObject;
        paramObject = (Integer)localObject2[0];
        localObject1 = (String)localObject2[1];
        localObject2 = (Integer)localObject2[2];
        if (paramObject != null) {}
        for (paramInt = paramObject.intValue();; paramInt = -1)
        {
          if (localObject2 != null) {
            i = ((Integer)localObject2).intValue();
          }
          b(paramInt, (String)localObject1, i);
          return;
        }
      }
      b(-1, null, -1);
      return;
    case 1008: 
      if (paramObject != null)
      {
        if (paramBoolean)
        {
          a((SearchEntryDataModel)((Object[])(Object[])paramObject)[0]);
          return;
        }
        localObject1 = (Object[])paramObject;
        paramObject = (Integer)localObject1[0];
        localObject1 = (String)localObject1[1];
        b(paramObject.intValue(), (String)localObject1);
        return;
      }
      b(-1, "");
      return;
    }
    if (paramObject != null)
    {
      if (paramBoolean)
      {
        localObject1 = (Object[])paramObject;
        paramObject = (List)localObject1[0];
        localObject1 = (Integer)localObject1[1];
        if (localObject1 != null) {
          i = ((Integer)localObject1).intValue();
        }
        a(paramObject, i);
        return;
      }
      localObject2 = (Object[])paramObject;
      paramObject = (Integer)localObject2[0];
      localObject1 = (String)localObject2[1];
      localObject2 = (Integer)localObject2[2];
      if (paramObject != null) {}
      for (paramInt = paramObject.intValue();; paramInt = -1)
      {
        if (localObject2 != null) {
          i = ((Integer)localObject2).intValue();
        }
        a(paramInt, (String)localObject1, i);
        return;
      }
    }
    a(-1, null, -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.UniteSearchObserver
 * JD-Core Version:    0.7.0.1
 */