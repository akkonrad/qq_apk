package com.tencent.mobileqq.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.highway.utils.HwNetworkUtil;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mqpsdk.util.NetUtil;
import cooperation.qzone.util.NetworkState;

public class NetworkUtil
{
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    case 2: 
    default: 
      return 2;
    case 1: 
    case 4: 
    case 5: 
      return 4;
    }
    return 3;
  }
  
  public static int a(Context paramContext)
  {
    int j = HttpUtil.a();
    int i = j;
    if (j == -1) {
      i = 2;
    }
    return i;
  }
  
  public static String a(int paramInt)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(paramInt & 0xFF).append(".").append(paramInt >> 8 & 0xFF).append(".").append(paramInt >> 16 & 0xFF).append(".").append(paramInt >> 24 & 0xFF);
    return localStringBuffer.toString();
  }
  
  public static String a(Context paramContext)
  {
    return NetworkState.getAPN();
  }
  
  public static boolean a(Context paramContext)
  {
    return AppNetConnInfo.isWifiConn();
  }
  
  public static boolean a(NetworkInfo paramNetworkInfo)
  {
    return HwNetworkUtil.isMobileNetworkInfo(paramNetworkInfo);
  }
  
  public static int b(Context paramContext)
  {
    int j = -1;
    int i = j;
    if (AppNetConnInfo.isNetSupport())
    {
      paramContext = AppNetConnInfo.getRecentNetworkInfo();
      i = j;
      if (paramContext != null) {
        i = paramContext.getType();
      }
    }
    return i;
  }
  
  public static boolean b(Context paramContext)
  {
    return AppNetConnInfo.isMobileConn();
  }
  
  public static boolean c(Context paramContext)
  {
    int i = NetUtil.a(paramContext);
    return (i == 2) || (i == 3);
  }
  
  public static boolean d(Context paramContext)
  {
    return AppNetConnInfo.isNetSupport();
  }
  
  public static boolean e(Context paramContext)
  {
    return HwNetworkUtil.isNetSupport(paramContext);
  }
  
  @TargetApi(13)
  public static boolean f(Context paramContext)
  {
    return (Build.VERSION.SDK_INT >= 13) && (b(paramContext) == 7);
  }
  
  public static boolean g(Context paramContext)
  {
    return AppNetConnInfo.isNetSupport();
  }
  
  public static boolean h(Context paramContext)
  {
    return NetworkState.isWifiConn();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.NetworkUtil
 * JD-Core Version:    0.7.0.1
 */