package oicq.wlogin_sdk.tlv_type;

import java.io.Serializable;
import oicq.wlogin_sdk.tools.cryptor;
import oicq.wlogin_sdk.tools.util;

public class tlv_t
  implements Serializable
{
  int _body_len = 0;
  byte[] _buf = new byte[this._max];
  int _cmd = 0;
  int _head_len = 4;
  int _max = 128;
  int _pos = 0;
  int _type = 0;
  
  public tlv_t() {}
  
  public tlv_t(int paramInt)
  {
    this._cmd = paramInt;
  }
  
  public void fill_body(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramInt > this._max - this._head_len)
    {
      this._max = (this._head_len + paramInt + 64);
      byte[] arrayOfByte = new byte[this._max];
      System.arraycopy(this._buf, 0, arrayOfByte, 0, this._pos);
      this._buf = arrayOfByte;
    }
    this._body_len = paramInt;
    System.arraycopy(paramArrayOfByte, 0, this._buf, this._pos, paramInt);
    this._pos += paramInt;
  }
  
  public void fill_head(int paramInt)
  {
    util.int16_to_buf(this._buf, this._pos, paramInt);
    this._pos += 2;
    util.int16_to_buf(this._buf, this._pos, 0);
    this._pos += 2;
  }
  
  public byte[] get_buf()
  {
    byte[] arrayOfByte = new byte[this._pos];
    System.arraycopy(this._buf, 0, arrayOfByte, 0, this._pos);
    return arrayOfByte;
  }
  
  public byte[] get_data()
  {
    byte[] arrayOfByte = new byte[this._body_len];
    System.arraycopy(this._buf, this._head_len, arrayOfByte, 0, this._body_len);
    return arrayOfByte;
  }
  
  public int get_data_len()
  {
    return this._body_len;
  }
  
  public int get_tlv(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = search_tlv(paramArrayOfByte, paramInt1, paramInt2, this._cmd);
    if (i < 0) {}
    do
    {
      do
      {
        return -1;
        paramInt1 = paramInt2 - (i - paramInt1);
      } while (this._head_len >= paramInt1);
      this._body_len = util.buf_to_int16(paramArrayOfByte, i + 2);
    } while (this._head_len + this._body_len > paramInt1);
    set_buf(paramArrayOfByte, i, this._head_len + this._body_len);
    if (!verify().booleanValue()) {
      return -1005;
    }
    return this._head_len + i + this._body_len;
  }
  
  public int get_tlv(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2)
  {
    int i = search_tlv(paramArrayOfByte1, paramInt1, paramInt2, this._cmd);
    if (i < 0) {
      return -1;
    }
    paramInt1 = paramInt2 - (i - paramInt1);
    byte[] arrayOfByte = new byte[paramInt1];
    System.arraycopy(paramArrayOfByte1, i, arrayOfByte, 0, paramInt1);
    return get_tlv(arrayOfByte, paramInt1, paramArrayOfByte2);
  }
  
  int get_tlv(byte[] paramArrayOfByte1, int paramInt, byte[] paramArrayOfByte2)
  {
    if (this._head_len >= paramInt) {}
    do
    {
      return -1;
      this._body_len = util.buf_to_int16(paramArrayOfByte1, 2);
    } while (this._head_len + this._body_len > paramInt);
    paramArrayOfByte2 = cryptor.decrypt(paramArrayOfByte1, this._head_len, this._body_len, paramArrayOfByte2);
    if (paramArrayOfByte2 == null) {
      return -1015;
    }
    if (this._head_len + paramArrayOfByte2.length > this._max)
    {
      this._max = (this._head_len + paramArrayOfByte2.length);
      this._buf = new byte[this._max];
    }
    this._pos = 0;
    System.arraycopy(paramArrayOfByte1, 0, this._buf, 0, this._head_len);
    this._pos += this._head_len;
    System.arraycopy(paramArrayOfByte2, 0, this._buf, this._pos, paramArrayOfByte2.length);
    this._pos += paramArrayOfByte2.length;
    this._body_len = paramArrayOfByte2.length;
    if (!verify().booleanValue()) {
      return -1005;
    }
    return 0;
  }
  
  public int limit_len(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length > paramInt) {
        return paramInt;
      }
      return paramArrayOfByte.length;
    }
    return 0;
  }
  
  int search_tlv(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt2 = paramArrayOfByte.length;
    for (;;)
    {
      if ((paramInt1 >= paramInt2) || (paramInt1 + 2 > paramInt2)) {}
      do
      {
        return -1;
        if (util.buf_to_int16(paramArrayOfByte, paramInt1) == paramInt3) {
          return paramInt1;
        }
        paramInt1 += 2;
      } while (paramInt1 + 2 > paramInt2);
      paramInt1 += util.buf_to_int16(paramArrayOfByte, paramInt1) + 2;
    }
  }
  
  public void set_buf(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramInt > this._max)
    {
      this._max = (paramInt + 128);
      this._buf = new byte[this._max];
    }
    this._pos = paramInt;
    System.arraycopy(paramArrayOfByte, 0, this._buf, 0, paramInt);
    this._cmd = util.buf_to_int16(paramArrayOfByte, 0);
    this._body_len = (paramInt - this._head_len);
  }
  
  public void set_buf(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramInt2 > this._max)
    {
      this._max = (paramInt2 + 128);
      this._buf = new byte[this._max];
    }
    this._pos = paramInt2;
    System.arraycopy(paramArrayOfByte, paramInt1, this._buf, 0, paramInt2);
    this._cmd = util.buf_to_int16(paramArrayOfByte, paramInt1);
    this._body_len = (paramInt2 - this._head_len);
  }
  
  public void set_data(byte[] paramArrayOfByte, int paramInt)
  {
    if (this._head_len + paramInt > this._max)
    {
      this._max = (this._head_len + paramInt + 128);
      byte[] arrayOfByte = new byte[this._max];
      System.arraycopy(this._buf, 0, arrayOfByte, 0, this._head_len);
      this._buf = arrayOfByte;
    }
    this._pos = (this._head_len + paramInt);
    System.arraycopy(paramArrayOfByte, 0, this._buf, this._head_len, paramInt);
    this._body_len = paramInt;
    util.int16_to_buf(this._buf, 0, this._cmd);
    util.int16_to_buf(this._buf, 2, this._body_len);
  }
  
  public void set_data(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this._head_len + paramInt2 > this._max)
    {
      this._max = (this._head_len + paramInt2 + 128);
      byte[] arrayOfByte = new byte[this._max];
      System.arraycopy(this._buf, 0, arrayOfByte, 0, this._head_len);
      this._buf = arrayOfByte;
    }
    this._pos = (this._head_len + paramInt2);
    System.arraycopy(paramArrayOfByte, paramInt1, this._buf, this._head_len, paramInt2);
    this._body_len = paramInt2;
    util.int16_to_buf(this._buf, 0, this._cmd);
    util.int16_to_buf(this._buf, 2, this._body_len);
  }
  
  public void set_length()
  {
    util.int16_to_buf(this._buf, 2, this._pos - this._head_len);
  }
  
  public Boolean verify()
  {
    return Boolean.valueOf(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.tlv_type.tlv_t
 * JD-Core Version:    0.7.0.1
 */