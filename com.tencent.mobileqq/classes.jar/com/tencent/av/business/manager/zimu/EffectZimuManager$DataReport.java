package com.tencent.av.business.manager.zimu;

import android.text.TextUtils;
import com.tencent.av.AVLog;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.opengl.utils.Utils;
import com.tencent.beacon.event.UserAction;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.HashMap;
import java.util.Map;

public class EffectZimuManager$DataReport
{
  static long jdField_a_of_type_Long;
  static String jdField_a_of_type_JavaLangString;
  static boolean jdField_a_of_type_Boolean;
  
  static long a(String paramString)
  {
    long l1 = 0L;
    long l2 = l1;
    if (!Utils.a(paramString, jdField_a_of_type_JavaLangString))
    {
      long l3 = System.currentTimeMillis();
      AVLog.c("EffectZimuManager", "DataReport calTime zimu:" + paramString + "|" + jdField_a_of_type_JavaLangString + "|" + jdField_a_of_type_Long);
      l2 = l1;
      if (!TextUtils.isEmpty(jdField_a_of_type_JavaLangString))
      {
        if (jdField_a_of_type_Long != 0L)
        {
          l1 = l3 - jdField_a_of_type_Long;
          AVLog.c("EffectZimuManager", "DataReport zimu:" + l1);
          jdField_a_of_type_Boolean = true;
          l1 /= 1000L;
          a(jdField_a_of_type_JavaLangString, l1);
          ReportController.b(null, "CliOper", "", "", "0X800888D", "0X800888D", 0, 0, String.valueOf(l1), "", jdField_a_of_type_JavaLangString, "");
          if (ARZimuUtil.a(jdField_a_of_type_JavaLangString)) {
            ReportController.b(null, "CliOper", "", "", "0X8009193", "0X8009193", 0, 0, String.valueOf(l1), "", jdField_a_of_type_JavaLangString, "");
          }
        }
        AVLog.c("EffectZimuManager", "DataReport zimu 33:" + l1);
        l2 = l1;
      }
      jdField_a_of_type_JavaLangString = paramString;
      jdField_a_of_type_Long = l3;
    }
    return l2;
  }
  
  public static void a(VideoAppInterface paramVideoAppInterface)
  {
    if (paramVideoAppInterface.a(0))
    {
      paramVideoAppInterface = (ZimuItem)((EffectZimuManager)paramVideoAppInterface.a(0)).a();
      if ((paramVideoAppInterface != null) && (!TextUtils.isEmpty(paramVideoAppInterface.getId()))) {
        a(null);
      }
    }
  }
  
  public static void a(String paramString, long paramLong)
  {
    AVLog.c("EffectZimuManager", "DataReport zimu:" + paramString + "|" + paramLong);
    HashMap localHashMap = new HashMap();
    localHashMap.put("zimuName", paramString);
    localHashMap.put("duration", String.valueOf(paramLong));
    UserAction.onUserAction("actAVFunChatZimu", true, -1L, -1L, localHashMap, true);
    try
    {
      UserAction.flushObjectsToDB(true);
      return;
    }
    catch (Exception paramString)
    {
      AVLog.e("EffectZimuManager", paramString.getMessage());
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    AVLog.c("EffectZimuManager", "DataReport onUsedZimu reportClickEvent:" + paramString1 + "|" + paramString2);
    ReportController.b(null, "CliOper", "", "", paramString1, paramString1, 0, 0, "", "", paramString2, "");
  }
  
  public static void a(String paramString1, String paramString2, String paramString3)
  {
    AVLog.c("EffectZimuManager", "DataReport onUsedZimu reportClickEvent:" + paramString1 + "|" + paramString2 + "|" + paramString3);
    ReportController.b(null, "CliOper", "", "", paramString1, paramString1, 0, 0, "", "", paramString2, paramString3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.business.manager.zimu.EffectZimuManager.DataReport
 * JD-Core Version:    0.7.0.1
 */