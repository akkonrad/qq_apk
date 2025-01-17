package com.tencent.weiyun.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.telephony.TelephonyManager;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

public final class Utils
{
  private static final String SP_NAME = "com.tencent.weiyun.pref.device_info";
  
  public static String bytes2HexStr(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append(String.format("%02X", new Object[] { Byte.valueOf(paramArrayOfByte[i]) }));
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static String getDeviceId(Context paramContext)
  {
    String str2 = getSpString(paramContext, "device_id", null);
    String str1 = str2;
    if (str2 == null)
    {
      str2 = getSpString(paramContext, "device_mac", null);
      str1 = str2;
      if (str2 == null)
      {
        str2 = NetworkUtils.getWifiMacAddress(paramContext);
        str1 = str2;
        if (str2 != null)
        {
          saveSpString(paramContext, "device_mac", str2);
          str1 = str2;
        }
      }
      if (str1 != null)
      {
        str1 = makeStringWithLength(str1, 17);
        saveSpString(paramContext, "device_id", str1);
      }
    }
    else
    {
      return str1;
    }
    str1 = ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId();
    if (str1 != null)
    {
      str1 = makeStringWithLength(str1, 17);
      saveSpString(paramContext, "device_id", str1);
      return str1;
    }
    return makeStringWithLength("", 17);
  }
  
  private static String getSpString(Context paramContext, String paramString1, String paramString2)
  {
    if (paramContext == null) {
      return paramString2;
    }
    return paramContext.getSharedPreferences("com.tencent.weiyun.pref.device_info", 0).getString(paramString1, paramString2);
  }
  
  public static byte[] hexStr2Bytes(String paramString)
  {
    int k = paramString.length();
    if ((k & 0x1) != 0) {
      throw new RuntimeException("Odd number of characters.");
    }
    byte[] arrayOfByte = new byte[k >> 1];
    int i = 0;
    int j = 0;
    while (j < k)
    {
      int m = j + 1;
      int n = Character.digit(paramString.charAt(j), 16);
      j = m + 1;
      arrayOfByte[i] = ((byte)((n << 4 | Character.digit(paramString.charAt(m), 16)) & 0xFF));
      i += 1;
    }
    return arrayOfByte;
  }
  
  public static String makeStringWithLength(String paramString, int paramInt)
  {
    paramString = new StringBuilder(paramString);
    while (paramString.length() <= paramInt) {
      paramString.append(UUID.randomUUID().toString());
    }
    return paramString.substring(0, paramInt);
  }
  
  private static void saveSpString(Context paramContext, String paramString1, String paramString2)
  {
    if (paramContext == null) {
      return;
    }
    paramContext = paramContext.getSharedPreferences("com.tencent.weiyun.pref.device_info", 0);
    if (paramString2 == null)
    {
      paramContext.edit().remove(paramString1).commit();
      return;
    }
    paramContext.edit().putString(paramString1, paramString2).commit();
  }
  
  public static byte[] str2Md5(String paramString)
  {
    try
    {
      Object localObject = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject).update(paramString.getBytes());
      localObject = ((MessageDigest)localObject).digest();
      return localObject;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException) {}
    return paramString.getBytes();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.weiyun.utils.Utils
 * JD-Core Version:    0.7.0.1
 */