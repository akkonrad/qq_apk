package com.tencent.mobileqq.pic;

import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class PicReporter
{
  private static final Object a = "PicReporter";
  
  public static void a()
  {
    boolean bool = SettingCloneUtil.readValue(BaseApplication.getContext(), null, BaseApplication.getContext().getString(2131433572), "qqsetting_auto_receive_pic_key", true);
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_state", String.valueOf(bool));
    Logger.a(a, "report2G3G4GSwitchState", "param_state:" + bool);
    StatisticCollector.a(BaseApplication.getContext()).a(null, "act2G3G4GSwitch", false, 0L, 0L, localHashMap, "");
  }
  
  public static void a(int paramInt, long paramLong)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_network", String.valueOf(paramInt));
    localHashMap.put("param_limit", String.valueOf(paramLong));
    Logger.a(a, "reportOverFlow", "param_network:" + paramInt + ",param_limit:" + paramLong);
    StatisticCollector.a(BaseApplication.getContext()).a(null, "actPicPreDownOverFlow", false, 0L, 0L, localHashMap, "");
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    Logger.a(a, "reportBigPicDownCost", "uintype:" + paramInt1 + ",networktype:" + paramInt2 + ",timeCost:" + paramLong);
    if ((paramInt1 == -1) || (paramInt2 == -1) || (paramLong < 0L)) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_uintype", String.valueOf(paramInt1));
    localHashMap.put("param_networktype", String.valueOf(paramInt2));
    localHashMap.put("param_timecost", String.valueOf(paramLong));
    StatisticCollector.a(BaseApplication.getContext()).a(paramString, "actBigPicDownCost", false, 0L, 0L, localHashMap, "");
  }
  
  public static void a(String paramString, HashMap paramHashMap)
  {
    if (paramHashMap == null)
    {
      Logger.a(a, "reportPicDownAutoLearn", "reportInfo == null");
      return;
    }
    if ((String)paramHashMap.get("xgPreDownCount") == null)
    {
      Logger.a(a, "reportPicDownAutoLearn", "no xg report data");
      return;
    }
    StatisticCollector.a(BaseApplication.getContext()).a(paramString, "actPicDownAutoLearn", false, 0L, 0L, paramHashMap, "");
    Logger.a(a, "reportPicDownAutoLearn", "");
  }
  
  public static void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PicReporter", 2, "device busy " + paramBoolean);
    }
    StatisticCollector.a(BaseApplication.getContext()).a(null, "Pic.Mkdir.DeviceBusy", paramBoolean, 0L, 0L, null, "");
  }
  
  public static void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PicReporter", 2, "Aio preview " + paramBoolean);
    }
    StatisticCollector.a(BaseApplication.getContext()).a(null, "Pic.AioPreview.Empty", paramBoolean, 0L, 0L, null, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PicReporter
 * JD-Core Version:    0.7.0.1
 */