package com.tencent.av.business.manager.filter;

import com.tencent.av.AVLog;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.beacon.event.UserAction;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.HashMap;
import java.util.Map;

public class EffectFilterTools$DataReport
{
  static long jdField_a_of_type_Long;
  static boolean jdField_a_of_type_Boolean;
  
  public static void a(VideoAppInterface paramVideoAppInterface)
  {
    if (paramVideoAppInterface.a(1))
    {
      paramVideoAppInterface = (FilterItem)((EffectFilterTools)paramVideoAppInterface.a(1)).a();
      a(paramVideoAppInterface);
      AVLog.c("EffectFilterTools", "DataReport onUserdFilter:" + paramVideoAppInterface + "|" + jdField_a_of_type_Boolean);
      if (!jdField_a_of_type_Boolean) {
        break label76;
      }
    }
    label76:
    for (paramVideoAppInterface = "0X80076B2";; paramVideoAppInterface = "0X80076B1")
    {
      a(paramVideoAppInterface);
      return;
    }
  }
  
  static void a(FilterItem paramFilterItem)
  {
    long l1 = System.currentTimeMillis();
    AVLog.c("EffectFilterTools", "DataReport onUserdFilter:" + paramFilterItem + "|" + jdField_a_of_type_Long);
    if ((paramFilterItem != null) && (!paramFilterItem.isEmptyFilter()))
    {
      if (jdField_a_of_type_Long != 0L)
      {
        long l2 = l1 - jdField_a_of_type_Long;
        AVLog.c("EffectFilterTools", "DataReport onUserdFilter:" + l2);
        if (l2 > 5000L)
        {
          jdField_a_of_type_Boolean = true;
          a(paramFilterItem, l2 / 1000L);
        }
      }
      AVLog.c("EffectFilterTools", "DataReport onUserdFilter 33:" + jdField_a_of_type_Long);
    }
    jdField_a_of_type_Long = l1;
  }
  
  public static void a(FilterItem paramFilterItem, long paramLong)
  {
    paramFilterItem = paramFilterItem.getId();
    AVLog.c("EffectFilterTools", "DataReport onStateReport:" + paramFilterItem + "|" + paramLong);
    HashMap localHashMap = new HashMap();
    localHashMap.put("filterName", paramFilterItem);
    localHashMap.put("duration", String.valueOf(paramLong));
    UserAction.onUserAction("actAVFunChatFilter", true, -1L, -1L, localHashMap, true);
    try
    {
      UserAction.flushObjectsToDB(true);
      return;
    }
    catch (Exception paramFilterItem)
    {
      AVLog.e("EffectFilterTools", paramFilterItem.getMessage());
    }
  }
  
  public static void a(String paramString)
  {
    ReportController.b(null, "CliOper", "", "", paramString, paramString, 0, 0, "", "", "", "");
  }
  
  public static void a(boolean paramBoolean)
  {
    AVLog.c("EffectFilterTools", "DataReport onSupport:" + paramBoolean);
    if (paramBoolean) {}
    for (String str = "0X80076AF";; str = "0X80076B0")
    {
      a(str);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.business.manager.filter.EffectFilterTools.DataReport
 * JD-Core Version:    0.7.0.1
 */