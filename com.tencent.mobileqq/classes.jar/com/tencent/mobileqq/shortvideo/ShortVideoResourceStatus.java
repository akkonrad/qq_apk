package com.tencent.mobileqq.shortvideo;

import ahzz;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;

public class ShortVideoResourceStatus
{
  static ahzz a(String paramString)
  {
    ahzz localahzz = new ahzz();
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("short_video_resource_status_sp", 4);
    localahzz.a = localSharedPreferences.getInt(paramString + "_version_k", 0);
    localahzz.b = localSharedPreferences.getInt(paramString + "_status_k", -1);
    localahzz.c = localSharedPreferences.getInt(paramString + "_last_error_k", -1);
    return localahzz;
  }
  
  static boolean a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("short_video_resource_status_sp", 4).edit();
    localEditor.putInt(paramString + "_version_k", paramInt1);
    localEditor.putInt(paramString + "_status_k", paramInt2);
    localEditor.putInt(paramString + "_last_error_k", paramInt3);
    return localEditor.commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ShortVideoResourceStatus
 * JD-Core Version:    0.7.0.1
 */