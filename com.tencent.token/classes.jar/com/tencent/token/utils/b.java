package com.tencent.token.utils;

public class b
{
  public static final byte[] a;
  public static final byte[] b;
  private static final byte[] d;
  private static final byte[] e;
  
  static
  {
    if (!b.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      c = bool;
      a = new byte[] { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };
      b = new byte[] { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95 };
      d = new byte[] { -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9 };
      e = new byte[] { -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, 63, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9 };
      return;
    }
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    int i1 = paramArrayOfByte.length;
    byte[] arrayOfByte1 = a;
    int i = (i1 + 2) / 3 * 4;
    byte[] arrayOfByte2 = new byte[i + i / 2147483647];
    int j = 0;
    i = 0;
    int k = 0;
    int n;
    while (k < i1 - 2)
    {
      m = paramArrayOfByte[(k + 0)] << 24 >>> 8 | paramArrayOfByte[(k + 1 + 0)] << 24 >>> 16 | paramArrayOfByte[(k + 2 + 0)] << 24 >>> 24;
      arrayOfByte2[i] = arrayOfByte1[(m >>> 18)];
      arrayOfByte2[(i + 1)] = arrayOfByte1[(m >>> 12 & 0x3F)];
      arrayOfByte2[(i + 2)] = arrayOfByte1[(m >>> 6 & 0x3F)];
      arrayOfByte2[(i + 3)] = arrayOfByte1[(m & 0x3F)];
      n = j + 4;
      j = n;
      m = i;
      if (n == 2147483647)
      {
        arrayOfByte2[(i + 4)] = 10;
        m = i + 1;
        j = 0;
      }
      k += 3;
      i = m + 4;
    }
    int m = i;
    if (k < i1)
    {
      n = k + 0;
      i1 -= k;
      if (i1 <= 0) {
        break label349;
      }
      k = paramArrayOfByte[n] << 24 >>> 8;
      if (i1 <= 1) {
        break label354;
      }
      m = paramArrayOfByte[(n + 1)] << 24 >>> 16;
      label244:
      if (i1 <= 2) {
        break label360;
      }
      n = paramArrayOfByte[(n + 2)] << 24 >>> 24;
      label264:
      k = n | k | m;
      switch (i1)
      {
      }
    }
    for (;;)
    {
      k = i;
      if (j + 4 == 2147483647)
      {
        arrayOfByte2[(i + 4)] = 10;
        k = i + 1;
      }
      m = k + 4;
      if ((c) || (m == arrayOfByte2.length)) {
        break label525;
      }
      throw new AssertionError();
      label349:
      k = 0;
      break;
      label354:
      m = 0;
      break label244;
      label360:
      n = 0;
      break label264;
      arrayOfByte2[i] = arrayOfByte1[(k >>> 18)];
      arrayOfByte2[(i + 1)] = arrayOfByte1[(k >>> 12 & 0x3F)];
      arrayOfByte2[(i + 2)] = arrayOfByte1[(k >>> 6 & 0x3F)];
      arrayOfByte2[(i + 3)] = arrayOfByte1[(k & 0x3F)];
      continue;
      arrayOfByte2[i] = arrayOfByte1[(k >>> 18)];
      arrayOfByte2[(i + 1)] = arrayOfByte1[(k >>> 12 & 0x3F)];
      arrayOfByte2[(i + 2)] = arrayOfByte1[(k >>> 6 & 0x3F)];
      arrayOfByte2[(i + 3)] = 61;
      continue;
      arrayOfByte2[i] = arrayOfByte1[(k >>> 18)];
      arrayOfByte2[(i + 1)] = arrayOfByte1[(k >>> 12 & 0x3F)];
      arrayOfByte2[(i + 2)] = 61;
      arrayOfByte2[(i + 3)] = 61;
    }
    label525:
    return new String(arrayOfByte2, 0, arrayOfByte2.length);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.utils.b
 * JD-Core Version:    0.7.0.1
 */