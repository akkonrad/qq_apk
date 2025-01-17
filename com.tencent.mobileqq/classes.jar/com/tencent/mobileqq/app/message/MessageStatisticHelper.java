package com.tencent.mobileqq.app.message;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class MessageStatisticHelper
{
  private static List jdField_a_of_type_JavaUtilList = new ArrayList(32);
  private static Random jdField_a_of_type_JavaUtilRandom = new Random();
  
  public static void a()
  {
    synchronized (jdField_a_of_type_JavaUtilList)
    {
      Iterator localIterator = jdField_a_of_type_JavaUtilList.iterator();
      if (localIterator.hasNext())
      {
        MessageStatisticHelper.DelayMsgReportItem localDelayMsgReportItem = (MessageStatisticHelper.DelayMsgReportItem)localIterator.next();
        HashMap localHashMap = new HashMap();
        localHashMap.put("param_FailCode", String.valueOf(localDelayMsgReportItem.jdField_a_of_type_Int));
        localHashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
        localHashMap.put("msgType", String.valueOf(localDelayMsgReportItem.b));
        localHashMap.put("uinType", String.valueOf(localDelayMsgReportItem.c));
        StatisticCollector.a(BaseApplication.getContext()).a(localDelayMsgReportItem.jdField_a_of_type_JavaLangString, "actBelatedMsg", false, localDelayMsgReportItem.jdField_a_of_type_Long, 0L, localHashMap, "");
      }
    }
    MessageStatisticHelper.DelayMsgReportItem.a(jdField_a_of_type_JavaUtilList);
    jdField_a_of_type_JavaUtilList.clear();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if (!paramQQAppInterface.c().endsWith("7")) {
      return;
    }
    paramQQAppInterface = new HashMap();
    paramQQAppInterface.put(BaseConstants.RDM_NoChangeFailCode, "");
    paramQQAppInterface.put("uinType", String.valueOf(paramInt));
    paramQQAppInterface.put("convUin", String.valueOf(paramString));
    StatisticCollector.a(BaseApplication.getContext()).a(null, "actNoCachedLastMsg", true, 0L, 0L, paramQQAppInterface, "");
  }
  
  public static void a(MessageRecord arg0, QQAppInterface paramQQAppInterface)
  {
    if (!paramQQAppInterface.c().endsWith("77")) {}
    long l;
    do
    {
      return;
      l = NetConnInfoCenter.getServerTime() - ???.time;
    } while ((l < 30L) || ((paramQQAppInterface.b != 0L) && (???.time < paramQQAppInterface.b)));
    if (???.time < paramQQAppInterface.jdField_a_of_type_Long) {}
    for (int i = 1;; i = 2)
    {
      paramQQAppInterface = MessageStatisticHelper.DelayMsgReportItem.a(i, paramQQAppInterface.c(), l, ???.msgtype, ???.istroop);
      synchronized (jdField_a_of_type_JavaUtilList)
      {
        jdField_a_of_type_JavaUtilList.add(paramQQAppInterface);
        if (jdField_a_of_type_JavaUtilList.size() >= 32) {
          a();
        }
        return;
      }
    }
  }
  
  public static void a(String paramString, long paramLong)
  {
    if (Math.abs(jdField_a_of_type_JavaUtilRandom.nextInt() % 10000) < 10)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
      StatisticCollector.a(BaseApplication.getContext()).a(null, paramString, true, paramLong, 0L, localHashMap, "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.MessageStatisticHelper
 * JD-Core Version:    0.7.0.1
 */