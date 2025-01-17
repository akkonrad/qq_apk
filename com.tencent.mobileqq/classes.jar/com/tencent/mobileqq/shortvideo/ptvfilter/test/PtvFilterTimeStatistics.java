package com.tencent.mobileqq.shortvideo.ptvfilter.test;

import com.tencent.qphone.base.util.QLog;

public class PtvFilterTimeStatistics
{
  public static int a;
  public static String a;
  public static boolean a;
  private static long[] a;
  public static int b;
  private static volatile boolean jdField_b_of_type_Boolean;
  private static long[] jdField_b_of_type_ArrayOfLong;
  private static int jdField_c_of_type_Int;
  private static volatile boolean jdField_c_of_type_Boolean;
  private static long[] jdField_c_of_type_ArrayOfLong;
  private static int jdField_d_of_type_Int;
  private static boolean jdField_d_of_type_Boolean;
  private static long[] jdField_d_of_type_ArrayOfLong;
  private static int jdField_e_of_type_Int;
  private static long[] jdField_e_of_type_ArrayOfLong;
  private static int jdField_f_of_type_Int;
  private static long[] jdField_f_of_type_ArrayOfLong;
  private static int g;
  private static int h;
  private static int i;
  
  static
  {
    jdField_a_of_type_ArrayOfLong = new long[20];
    jdField_b_of_type_ArrayOfLong = new long[20];
    jdField_c_of_type_ArrayOfLong = new long[20];
    jdField_d_of_type_ArrayOfLong = new long[20];
    jdField_e_of_type_ArrayOfLong = new long[20];
    jdField_f_of_type_ArrayOfLong = new long[20];
    jdField_a_of_type_JavaLangString = "";
  }
  
  public static void a()
  {
    if (!jdField_c_of_type_Boolean) {
      i += 1;
    }
    if (i >= 5) {
      jdField_c_of_type_Boolean = true;
    }
  }
  
  public static void a(long paramLong)
  {
    int j;
    if (jdField_c_of_type_Int < 20)
    {
      long[] arrayOfLong = jdField_a_of_type_ArrayOfLong;
      j = jdField_c_of_type_Int;
      jdField_c_of_type_Int = j + 1;
      arrayOfLong[j] = paramLong;
    }
    if ((!jdField_b_of_type_Boolean) && (jdField_c_of_type_Int == 20))
    {
      jdField_b_of_type_Boolean = true;
      paramLong = 0L;
      j = 0;
      while (j < 20)
      {
        paramLong += jdField_a_of_type_ArrayOfLong[j];
        j += 1;
      }
      PerformenceDataTag.a("sv_filter_face_detect", paramLong / 1000L / 20L);
    }
  }
  
  public static void a(String paramString, long paramLong)
  {
    if (!jdField_a_of_type_JavaLangString.equals(paramString))
    {
      jdField_f_of_type_Int = 0;
      jdField_a_of_type_JavaLangString = paramString;
    }
    if ((jdField_c_of_type_Boolean) && (jdField_f_of_type_Int < 20))
    {
      paramString = jdField_d_of_type_ArrayOfLong;
      int j = jdField_f_of_type_Int;
      jdField_f_of_type_Int = j + 1;
      paramString[j] = paramLong;
    }
  }
  
  public static void b()
  {
    long l2 = 0L;
    int k = 0;
    if ((h > 5) && (!jdField_d_of_type_Boolean))
    {
      jdField_d_of_type_Boolean = true;
      int j;
      long l1;
      double d1;
      if (jdField_d_of_type_Int > 0)
      {
        j = 0;
        l1 = 0L;
        while (j < jdField_d_of_type_Int)
        {
          l1 += jdField_b_of_type_ArrayOfLong[j];
          j += 1;
        }
        d1 = l1 / 1000.0D;
        if (QLog.isColorLevel()) {
          QLog.d("PtvFilterTimeStatistics", 2, "FilterProcessRender_showPreview[FaceTotalTime=" + d1 + "ms] avg=" + d1 / jdField_d_of_type_Int);
        }
        PerformenceDataTag.a("sv_filter_face_track", d1 / jdField_d_of_type_Int);
      }
      if (jdField_e_of_type_Int > 0)
      {
        j = 0;
        l1 = 0L;
        while (j < jdField_e_of_type_Int)
        {
          l1 += jdField_c_of_type_ArrayOfLong[j];
          j += 1;
        }
        d1 = l1 / 1000.0D;
        if (QLog.isColorLevel()) {
          QLog.d("PtvFilterTimeStatistics", 2, "FilterProcessRender_showPreview[FilterTotalTime=" + d1 + "ms] avg=" + d1 / jdField_e_of_type_Int);
        }
        PerformenceDataTag.a("sv_filter_draw_frame", d1 / jdField_e_of_type_Int);
      }
      if (jdField_f_of_type_Int > 0)
      {
        j = 0;
        l1 = 0L;
        while (j < jdField_f_of_type_Int)
        {
          l1 += jdField_d_of_type_ArrayOfLong[j];
          j += 1;
        }
        d1 = l1 / 1000.0D;
        if (QLog.isColorLevel()) {
          QLog.d("PtvFilterTimeStatistics", 2, "FilterProcessRender_showPreview[ShowTotalDrawTime=" + d1 + "ms] avg=" + d1 / jdField_f_of_type_Int);
        }
        PerformenceDataTag.a("sv_filter_total_draw", d1 / jdField_f_of_type_Int);
      }
      if (g > 0)
      {
        j = 0;
        l1 = 0L;
        while (j < g)
        {
          l1 += jdField_e_of_type_ArrayOfLong[j];
          j += 1;
        }
        d1 = l1 / 1000.0D;
        if (QLog.isColorLevel()) {
          QLog.d("PtvFilterTimeStatistics", 2, "FilterProcessRender_showPreview[ShowNoFilterTotalDrawTime=" + d1 + "ms] avg=" + d1 / g);
        }
        PerformenceDataTag.a("sv_filter_no_filter_total_draw", d1 / g);
      }
      if (h > 0)
      {
        l1 = l2;
        j = k;
        while (j < h)
        {
          l1 += jdField_f_of_type_ArrayOfLong[j];
          j += 1;
        }
        d1 = l1 / 1000.0D;
        if (QLog.isColorLevel()) {
          QLog.d("PtvFilterTimeStatistics", 2, "FilterProcessRender_showPreview[ShowTotalTime=" + d1 + "ms] avg=" + d1 / h);
        }
        PerformenceDataTag.a("sv_filter_total_process_frame", d1 / h);
      }
      if (jdField_b_of_type_Int == 0) {
        jdField_b_of_type_Int = 1;
      }
      PerformenceDataTag.a("sv_filter_track_ratio", jdField_a_of_type_Int * 1000 / jdField_b_of_type_Int);
    }
  }
  
  public static void b(long paramLong)
  {
    if ((jdField_c_of_type_Boolean) && (jdField_d_of_type_Int < 20))
    {
      long[] arrayOfLong = jdField_b_of_type_ArrayOfLong;
      int j = jdField_d_of_type_Int;
      jdField_d_of_type_Int = j + 1;
      arrayOfLong[j] = paramLong;
    }
  }
  
  public static void c(long paramLong)
  {
    if ((jdField_c_of_type_Boolean) && (jdField_e_of_type_Int < 20))
    {
      long[] arrayOfLong = jdField_c_of_type_ArrayOfLong;
      int j = jdField_e_of_type_Int;
      jdField_e_of_type_Int = j + 1;
      arrayOfLong[j] = paramLong;
    }
  }
  
  public static void d(long paramLong)
  {
    if ((jdField_c_of_type_Boolean) && (g < 20))
    {
      long[] arrayOfLong = jdField_e_of_type_ArrayOfLong;
      int j = g;
      g = j + 1;
      arrayOfLong[j] = paramLong;
    }
  }
  
  public static void e(long paramLong)
  {
    if ((jdField_c_of_type_Boolean) && (h < 20))
    {
      long[] arrayOfLong = jdField_f_of_type_ArrayOfLong;
      int j = h;
      h = j + 1;
      arrayOfLong[j] = paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ptvfilter.test.PtvFilterTimeStatistics
 * JD-Core Version:    0.7.0.1
 */