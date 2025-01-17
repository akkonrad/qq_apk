package com.tencent.mobileqq.nearby.now.utils;

public class CommentsUtil
{
  public static int a(CharSequence paramCharSequence)
  {
    if (paramCharSequence == null) {
      return 0;
    }
    int m = paramCharSequence.length();
    int i = 0;
    int j = 0;
    if (i < m)
    {
      if (paramCharSequence.charAt(i) < '') {}
      for (int k = 1;; k = 2)
      {
        j += k;
        i += 1;
        break;
      }
    }
    return j;
  }
  
  public static int a(String paramString)
  {
    int j = 0;
    if (paramString == null) {
      return 0;
    }
    int i = 0;
    if (j < paramString.length())
    {
      if (a(paramString.charAt(j))) {
        i += 2;
      }
      for (;;)
      {
        j += 1;
        break;
        i += 1;
      }
    }
    return i;
  }
  
  public static CharSequence a(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    int m = paramCharSequence.length();
    int j = 0;
    int i = paramInt1;
    for (;;)
    {
      CharSequence localCharSequence = paramCharSequence;
      if (i < m) {
        if (paramCharSequence.charAt(i) >= '') {
          break label91;
        }
      }
      label91:
      for (int k = 1;; k = 2)
      {
        j = k + j;
        if (j <= paramInt2) {
          break;
        }
        paramInt2 = i;
        if (i > 0)
        {
          paramInt2 = i;
          if (Character.isHighSurrogate(paramCharSequence.charAt(i - 1))) {
            paramInt2 = i - 1;
          }
        }
        localCharSequence = paramCharSequence.subSequence(paramInt1, paramInt2);
        return localCharSequence;
      }
      i += 1;
    }
  }
  
  public static String a(long paramLong)
  {
    paramLong = System.currentTimeMillis() - paramLong;
    if (paramLong < 3600000L) {
      return paramLong / 60L / 1000L + 1L + "分钟前";
    }
    if (paramLong < 86400000L) {
      return paramLong / 60L / 60L / 1000L + "小时前";
    }
    return paramLong / 24L / 60L / 60L / 1000L + "天前";
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder(paramArrayOfByte.length * 2);
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      localStringBuilder.append(String.format("%02x", new Object[] { Integer.valueOf(paramArrayOfByte[i] & 0xFF) }));
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static boolean a(char paramChar)
  {
    return (paramChar >= 'ÿ') || (paramChar < 0);
  }
  
  public static String b(long paramLong)
  {
    if (paramLong < 10000L) {
      return Long.toString(paramLong);
    }
    if (paramLong > 100000L) {
      return "9.9万+";
    }
    return String.format("%.1f万", new Object[] { Double.valueOf(paramLong / 10000.0D) });
  }
  
  public static String c(long paramLong)
  {
    if (paramLong < 10000L) {
      return Long.toString(paramLong);
    }
    if ((paramLong > 10000L) && (paramLong < 10000000L)) {
      return String.format("%.1f万", new Object[] { Double.valueOf(paramLong / 10000.0D) });
    }
    return String.format("%d千万", new Object[] { Long.valueOf(paramLong / 10000000L) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.utils.CommentsUtil
 * JD-Core Version:    0.7.0.1
 */