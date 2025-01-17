package com.tencent.ytcommon.auth;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class StatisticsUtils
{
  private static String encryptUid(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramString.length();
    int i = 0;
    while (i < j)
    {
      int k = paramString.charAt(i);
      localStringBuilder.append(k % j + k);
      i += 1;
    }
    localStringBuilder.reverse();
    return localStringBuilder.toString();
  }
  
  private static char getChar(byte paramByte, int paramInt)
  {
    return (char)(paramByte - getOffset(paramInt & 0x1));
  }
  
  public static String getDeviceUid(Context paramContext)
  {
    String str = getIMEI(paramContext.getApplicationContext());
    Object localObject = getMacAddr(paramContext.getApplicationContext());
    int i;
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      i = 1;
      paramContext = (Context)localObject;
      if (i != 0) {
        paramContext = ((String)localObject).replaceAll(":", "");
      }
      localObject = new StringBuilder().append(str);
      if (i == 0) {
        break label76;
      }
    }
    for (;;)
    {
      return toMD5(encryptUid(paramContext));
      i = 0;
      break;
      label76:
      paramContext = "";
    }
  }
  
  public static String getIMEI(Context paramContext)
  {
    String str2 = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
    {
      paramContext = (TelephonyManager)paramContext.getApplicationContext().getSystemService("phone");
      str1 = str2;
      if (paramContext != null) {
        str1 = paramContext.getDeviceId();
      }
    }
    return str1;
  }
  
  public static String getMacAddr(Context paramContext)
  {
    if (paramContext == null) {}
    do
    {
      do
      {
        return null;
        paramContext = (WifiManager)paramContext.getApplicationContext().getSystemService("wifi");
      } while (paramContext == null);
      paramContext = paramContext.getConnectionInfo();
    } while (paramContext == null);
    return paramContext.getMacAddress();
  }
  
  private static byte getOffset(int paramInt)
  {
    if (paramInt == 0) {}
    for (paramInt = 65;; paramInt = 97) {
      return (byte)paramInt;
    }
  }
  
  public static String toMD5(String paramString)
  {
    Object localObject;
    if (TextUtils.isEmpty(paramString)) {
      localObject = "";
    }
    for (;;)
    {
      return localObject;
      try
      {
        localObject = MessageDigest.getInstance("MD5");
        ((MessageDigest)localObject).reset();
        ((MessageDigest)localObject).update(paramString.getBytes());
        for (paramString = new BigInteger(1, ((MessageDigest)localObject).digest()).toString(16);; paramString = "0" + paramString)
        {
          localObject = paramString;
          if (paramString.length() >= 32) {
            break;
          }
        }
        return "";
      }
      catch (NoSuchAlgorithmException paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ytcommon.auth.StatisticsUtils
 * JD-Core Version:    0.7.0.1
 */