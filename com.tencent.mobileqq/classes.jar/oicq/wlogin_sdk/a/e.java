package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.util;

public class e
  extends c
{
  public e()
  {
    this.b = 7;
  }
  
  public byte[] a(int paramInt, byte[] paramArrayOfByte, long paramLong)
  {
    this.d = (paramArrayOfByte.length + 2 + 4);
    byte[] arrayOfByte = new byte[this.d];
    util.int8_to_buf(arrayOfByte, 0, paramInt);
    util.int8_to_buf(arrayOfByte, 1, paramArrayOfByte.length);
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 2, paramArrayOfByte.length);
    paramInt = paramArrayOfByte.length + 2;
    util.int64_to_buf32(arrayOfByte, paramInt, paramLong);
    return a(arrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.e
 * JD-Core Version:    0.7.0.1
 */