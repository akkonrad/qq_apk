package com.tencent.mfsdk;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.SparseArray;

public class ReportedStatus
{
  public static int a;
  private static long a;
  public static SparseArray a;
  
  static
  {
    jdField_a_of_type_Long = Math.round((float)(System.currentTimeMillis() / 86400000L));
    jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(18);
    jdField_a_of_type_AndroidUtilSparseArray.put(1, new ReportedStatus.CurrentRecord(0L, 0));
    jdField_a_of_type_AndroidUtilSparseArray.put(4, new ReportedStatus.CurrentRecord(0L, 0));
    jdField_a_of_type_AndroidUtilSparseArray.put(6, new ReportedStatus.CurrentRecord(0L, 0));
    jdField_a_of_type_AndroidUtilSparseArray.put(7, new ReportedStatus.CurrentRecord(0L, 0));
    jdField_a_of_type_AndroidUtilSparseArray.put(14, new ReportedStatus.CurrentRecord(0L, 0));
    jdField_a_of_type_AndroidUtilSparseArray.put(9, new ReportedStatus.CurrentRecord(0L, 0));
    jdField_a_of_type_AndroidUtilSparseArray.put(16, new ReportedStatus.CurrentRecord(0L, 0));
  }
  
  public static void a()
  {
    long l;
    if (MagnifierSDK.jdField_a_of_type_AndroidContentSharedPreferences != null) {
      l = MagnifierSDK.jdField_a_of_type_AndroidContentSharedPreferences.getLong("last_start_date", 0L);
    }
    int[] arrayOfInt;
    int j;
    int i;
    int k;
    for (;;)
    {
      if ((jdField_a_of_type_Long - l > 0L) && (MagnifierSDK.jdField_a_of_type_AndroidContentSharedPreferences$Editor != null))
      {
        MagnifierSDK.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong("last_start_date", jdField_a_of_type_Long);
        MagnifierSDK.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putInt("count_today_reported", 0);
        arrayOfInt = Config.jdField_a_of_type_ArrayOfInt;
        j = arrayOfInt.length;
        i = 0;
        for (;;)
        {
          if (i < j)
          {
            k = arrayOfInt[i];
            MagnifierSDK.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putInt("count_plugin_" + String.valueOf(k), 0);
            jdField_a_of_type_AndroidUtilSparseArray.put(k, new ReportedStatus.CurrentRecord(0L, 0));
            i += 1;
            continue;
            l = jdField_a_of_type_Long;
            break;
          }
        }
        MagnifierSDK.jdField_a_of_type_AndroidContentSharedPreferences$Editor.apply();
      }
    }
    for (;;)
    {
      return;
      if (MagnifierSDK.jdField_a_of_type_AndroidContentSharedPreferences != null)
      {
        jdField_a_of_type_Int = MagnifierSDK.jdField_a_of_type_AndroidContentSharedPreferences.getInt("count_today_reported", 0);
        if (jdField_a_of_type_Int >= Config.jdField_a_of_type_Int) {
          break;
        }
        arrayOfInt = Config.jdField_a_of_type_ArrayOfInt;
        j = arrayOfInt.length;
        i = 0;
        while (i < j)
        {
          k = arrayOfInt[i];
          int m = MagnifierSDK.jdField_a_of_type_AndroidContentSharedPreferences.getInt("count_plugin_" + String.valueOf(k), 0);
          jdField_a_of_type_AndroidUtilSparseArray.put(k, new ReportedStatus.CurrentRecord(0L, m));
          i += 1;
        }
      }
    }
  }
  
  public static void a(int paramInt)
  {
    ReportedStatus.CurrentRecord localCurrentRecord = (ReportedStatus.CurrentRecord)jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localCurrentRecord == null) {
      return;
    }
    localCurrentRecord.jdField_a_of_type_Int += 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mfsdk.ReportedStatus
 * JD-Core Version:    0.7.0.1
 */