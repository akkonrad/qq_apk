package cooperation.qzone.report.lp;

import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TimeZone;
import mqq.app.AppRuntime;

public class LpReportUtils
{
  public static final String ALL_REPORT = "全量上报";
  public static final String CLICK_MESSAGE = "点击统计上报信息: ";
  public static final String NOT_HIT = ",没命中,今天命中的QQ尾号是：";
  public static final String SAMPLE_REPORT = "抽样上报";
  private static final String TAG = "LpReport.LpReportUtils";
  private static boolean isSampled;
  private static long sampleValidEndTime;
  private static long sampleValidStartTime;
  
  public static long getBeijingTimeInMillis(int paramInt1, int paramInt2, int paramInt3)
  {
    return getBeijingTimeInMillis(0, 0, 0, paramInt1, paramInt2, paramInt3);
  }
  
  private static long getBeijingTimeInMillis(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    Calendar localCalendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
    if ((paramInt1 != 0) || (paramInt2 != 0) || (paramInt3 != 0))
    {
      localCalendar.set(1, paramInt1);
      localCalendar.set(2, paramInt2);
      localCalendar.set(5, paramInt3);
    }
    localCalendar.set(11, paramInt4);
    localCalendar.set(12, paramInt5);
    localCalendar.set(13, paramInt6);
    localCalendar.set(14, 0);
    return localCalendar.getTimeInMillis();
  }
  
  public static int getDaysSince1970()
  {
    return (int)((System.currentTimeMillis() - getBeijingTimeInMillis(1970, 0, 1, 0, 0, 0)) / 1000L / 60L / 60L / 24L);
  }
  
  public static String getMobileType()
  {
    return Build.BRAND + "_" + Build.DEVICE + "_" + Build.DISPLAY + "_" + Build.HARDWARE + "_" + Build.MANUFACTURER + "_" + Build.MODEL + "_" + Build.PRODUCT;
  }
  
  public static boolean isNeedReport()
  {
    if (!isTodayTime(System.currentTimeMillis())) {
      userSample();
    }
    return isSampled;
  }
  
  private static boolean isTodayTime(long paramLong)
  {
    return (sampleValidStartTime != 0L) && (sampleValidEndTime != 0L) && (paramLong >= sampleValidStartTime) && (paramLong < sampleValidEndTime);
  }
  
  public static boolean meetCondition(LpReportInfos paramLpReportInfos, long paramLong)
  {
    long l = SystemClock.uptimeMillis();
    int i = QzoneConfig.getInstance().getConfig("ClientReport", "TraceReportInterval", 600);
    int j = QzoneConfig.getInstance().getConfig("ClientReport", "TraceReportCount", 50);
    return (paramLpReportInfos.size() >= j) || ((l - paramLong >= i * 1000) && (paramLpReportInfos.size() > 0));
  }
  
  public static void safePut(Map paramMap, String paramString, int paramInt)
  {
    if (paramMap == null) {}
    while (TextUtils.isEmpty(paramString)) {
      return;
    }
    paramMap.put(paramString, String.valueOf(paramInt));
  }
  
  public static void safePut(Map paramMap, String paramString1, String paramString2)
  {
    if (paramMap == null) {}
    while ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    paramMap.put(paramString1, paramString2);
  }
  
  public static void showToast(LpReportInfo paramLpReportInfo, boolean paramBoolean) {}
  
  public static String transMapToString(Map paramMap)
  {
    if (paramMap == null) {
      return "";
    }
    StringBuffer localStringBuffer1 = new StringBuffer();
    Iterator localIterator = paramMap.entrySet().iterator();
    if (localIterator.hasNext())
    {
      paramMap = (Map.Entry)localIterator.next();
      StringBuffer localStringBuffer2 = localStringBuffer1.append(paramMap.getKey().toString()).append(":");
      if (paramMap.getValue() == null)
      {
        paramMap = "";
        label77:
        localStringBuffer2 = localStringBuffer2.append(paramMap);
        if (!localIterator.hasNext()) {
          break label117;
        }
      }
      label117:
      for (paramMap = ", ";; paramMap = "")
      {
        localStringBuffer2.append(paramMap);
        break;
        paramMap = paramMap.getValue().toString();
        break label77;
      }
    }
    return localStringBuffer1.toString();
  }
  
  private static void userSample()
  {
    int i = QzoneConfig.getInstance().getConfig("ClientReport", "TraceReportSamples", 100);
    long l1 = getDaysSince1970();
    long l2 = BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin();
    if (l2 == 0L) {
      return;
    }
    if (i == 0)
    {
      isSampled = false;
      sampleValidStartTime = getBeijingTimeInMillis(0, 0, 0);
      sampleValidEndTime = getBeijingTimeInMillis(24, 0, 0);
      return;
    }
    int j = (int)(l1 % i);
    if (j == l2 % i) {}
    for (boolean bool = true;; bool = false)
    {
      isSampled = bool;
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.d("LpReport.LpReportUtils", 4, "抽中的尾数： " + j);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.report.lp.LpReportUtils
 * JD-Core Version:    0.7.0.1
 */