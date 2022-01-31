package oicq.wlogin_sdk.code2d;

import oicq.wlogin_sdk.request.t;
import oicq.wlogin_sdk.tools.util;

public class b
{
  public static int _seq = 0;
  public static c _status = new c();
  public static int _version = 50;
  public int _cmd = 0;
  public int _head_len = 43;
  public int _role = 114;
  public int _sub_cmd = 0;
  
  protected int fill_staff(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt)
  {
    util.int16_to_buf(paramArrayOfByte1, paramInt, paramArrayOfByte2.length);
    paramInt += 2;
    System.arraycopy(paramArrayOfByte2, 0, paramArrayOfByte1, paramInt, paramArrayOfByte2.length);
    return paramInt + paramArrayOfByte2.length;
  }
  
  protected byte[] getAppInfo(long paramLong1, long paramLong2)
  {
    byte[] arrayOfByte = new byte[28 + (t.C.length + 2 + 2 + t.E.length + 2 + t.F.length)];
    util.int64_to_buf32(arrayOfByte, 0, 5L);
    util.int64_to_buf32(arrayOfByte, 4, paramLong1);
    util.int64_to_buf32(arrayOfByte, 8, paramLong2);
    System.arraycopy(t.y, 0, arrayOfByte, 12, t.y.length);
    int i = t.y.length;
    i = fill_staff(arrayOfByte, t.C, i + 12);
    i = fill_staff(arrayOfByte, t.E, i);
    fill_staff(arrayOfByte, t.F, i);
    return arrayOfByte;
  }
  
  public int get_cmd()
  {
    return this._cmd;
  }
  
  protected byte[] get_request(long paramLong, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = new byte[this._head_len + paramArrayOfByte.length + 1];
    util.int8_to_buf(arrayOfByte, 0, 2);
    util.int16_to_buf(arrayOfByte, 1, arrayOfByte.length);
    util.int16_to_buf(arrayOfByte, 3, this._cmd);
    util.int8_to_buf(arrayOfByte, 26, 3);
    if (paramBoolean) {
      util.int16_to_buf(arrayOfByte, 27, 0);
    }
    for (;;)
    {
      util.int16_to_buf(arrayOfByte, 29, _version);
      int i = _seq;
      _seq = i + 1;
      util.int32_to_buf(arrayOfByte, 31, i);
      util.int64_to_buf(arrayOfByte, 35, paramLong);
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 43, paramArrayOfByte.length);
      i = paramArrayOfByte.length + 43;
      util.int8_to_buf(arrayOfByte, i, 3);
      return arrayOfByte;
      util.int16_to_buf(arrayOfByte, 27, 1);
    }
  }
  
  protected byte[] get_response(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte.length <= this._head_len) {
      return null;
    }
    byte[] arrayOfByte = new byte[paramArrayOfByte.length - this._head_len];
    System.arraycopy(paramArrayOfByte, this._head_len, arrayOfByte, 0, arrayOfByte.length);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.code2d.b
 * JD-Core Version:    0.7.0.1
 */