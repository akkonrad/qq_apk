package com.tencent.mobileqq.ar.ARRecord;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Environment;
import android.os.StatFs;
import com.tencent.biz.qqstory.utils.FileUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.SharedPreUtils;
import java.io.File;
import java.text.DecimalFormat;
import mqq.os.MqqHandler;
import zxz;
import zyb;

public final class ARRecordUtils
{
  public static String a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder(30);
    localStringBuilder.append("录制中 (");
    int i = paramInt / 60;
    paramInt -= i * 60;
    if (i < 10)
    {
      localStringBuilder.append("0").append(i);
      localStringBuilder.append(":");
      if (paramInt >= 10) {
        break label91;
      }
      localStringBuilder.append("0").append(paramInt);
    }
    for (;;)
    {
      localStringBuilder.append(")");
      return localStringBuilder.toString();
      localStringBuilder.append(i);
      break;
      label91:
      localStringBuilder.append(paramInt);
    }
  }
  
  public static void a(File paramFile)
  {
    FileUtils.a(BaseApplicationImpl.getContext(), paramFile);
  }
  
  public static void a(String paramString1, String paramString2)
  {
    ThreadManager.getUIHandler().post(new zxz(paramString1, paramString2));
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    ThreadManager.getUIHandler().post(new zyb(paramBoolean, paramString));
  }
  
  public static void a(boolean paramBoolean)
  {
    SharedPreUtils.a(BaseApplicationImpl.getApplication().getSharedPreferences("ARRecordUtils_AR", 4).edit().putBoolean("ARVideoRecordPressKey12", paramBoolean));
  }
  
  public static boolean a()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("ARRecordUtils_AR", 4).getBoolean("ARVideoRecordPressKey12", false);
  }
  
  public static boolean a(long paramLong)
  {
    StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath());
    int i = localStatFs.getAvailableBlocks();
    long l = localStatFs.getBlockSize();
    return i * l >= paramLong;
  }
  
  public static String b(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder(10);
    DecimalFormat localDecimalFormat = new DecimalFormat(".00");
    double d = paramInt / 1024.0F / 1024.0F;
    if (d < 1.0D) {
      localStringBuilder.append(0);
    }
    localStringBuilder.append(localDecimalFormat.format(d));
    localStringBuilder.append("M");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRecord.ARRecordUtils
 * JD-Core Version:    0.7.0.1
 */