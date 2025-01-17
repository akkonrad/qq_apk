package oicq.wlogin_sdk.sharemem;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.io.Serializable;
import oicq.wlogin_sdk.tools.util;

public class WloginSigInfo
  implements Parcelable, Serializable
{
  public static final Parcelable.Creator<WloginSigInfo> CREATOR = new WloginSigInfo.1();
  public static final int SIG_RESERVE_LENGTH = 12;
  public static final int SIG_RESERVE_VALID_LENGTH = 7;
  public static byte[] _LHSig = new byte[0];
  public static byte[] _QRPUSHSig = new byte[0];
  private static final long serialVersionUID = 1L;
  public long _A2_create_time = 0L;
  public long _A2_expire_time = 0L;
  public byte[] _D2 = new byte[0];
  public byte[] _D2Key = new byte[0];
  public long _D2_create_time = 0L;
  public long _D2_expire_time = 0L;
  public byte[] _DA2 = new byte[0];
  public byte[] _G = new byte[0];
  public byte[] _TGT = new byte[0];
  public byte[] _TGTKey = new byte[0];
  public byte[] _access_token = new byte[0];
  public long _access_token_create_time = 0L;
  public long _app_pri = 0L;
  public byte[] _aqSig = new byte[0];
  public long _aqSig_create_time = 0L;
  public long _create_time = 0L;
  public byte[] _dpwd = new byte[0];
  public byte[] _en_A1 = new byte[0];
  public int _login_bitmap = 0;
  public byte[] _lsKey = new byte[0];
  public long _lsKey_create_time = 0L;
  public long _lsKey_expire_time = 0L;
  public byte[] _noPicSig = new byte[0];
  public byte[] _openid = new byte[0];
  public byte[] _openkey = new byte[0];
  public long _openkey_create_time = 0L;
  public byte[] _pay_token = new byte[0];
  public byte[] _pf = new byte[0];
  public byte[] _pfKey = new byte[0];
  public byte[] _psKey = new byte[0];
  public long _psKey_create_time = 0L;
  public byte[] _randseed = new byte[0];
  public byte[] _sKey = new byte[0];
  public long _sKey_create_time = 0L;
  public long _sKey_expire_time = 0L;
  public byte[] _sid = new byte[0];
  public long _sid_create_time = 0L;
  public long _sid_expire_time = 0L;
  public byte[] _superKey = new byte[0];
  public byte[] _userA5 = new byte[0];
  public long _userA5_create_time = 0L;
  public byte[] _userA8 = new byte[0];
  public long _userA8_create_time = 0L;
  public long _userA8_expire_time = 0L;
  public byte[] _userSig64 = new byte[0];
  public long _userSig64_create_time = 0L;
  public byte[] _userStSig = new byte[0];
  public long _userStSig_create_time = 0L;
  public byte[] _userStWebSig = new byte[0];
  public long _userStWebSig_create_time = 0L;
  public long _userStWebSig_expire_time = 0L;
  public byte[] _userSt_Key = new byte[0];
  public long _vKey_expire_time = 0L;
  public byte[] _vkey = new byte[0];
  public long _vkey_create_time = 0L;
  
  public WloginSigInfo(long paramLong1, long paramLong2, long paramLong3, long paramLong4, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5, byte[] paramArrayOfByte6, byte[] paramArrayOfByte7, byte[] paramArrayOfByte8, byte[] paramArrayOfByte9, byte[] paramArrayOfByte10, byte[] paramArrayOfByte11, byte[] paramArrayOfByte12, byte[][] paramArrayOfByte, long[] paramArrayOfLong, int paramInt)
  {
    SetSigInfo(paramLong1, paramLong2, paramLong3, paramLong4, paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3, paramArrayOfByte4, paramArrayOfByte5, paramArrayOfByte6, paramArrayOfByte7, paramArrayOfByte8, paramArrayOfByte9, paramArrayOfByte10, paramArrayOfByte11, paramArrayOfByte12, paramArrayOfByte, paramArrayOfLong, paramInt);
  }
  
  public WloginSigInfo(long paramLong1, long paramLong2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    this._app_pri = 4294967295L;
    if ((paramArrayOfByte1 != null) && (paramArrayOfByte1.length > 0))
    {
      this._userStSig = ((byte[])paramArrayOfByte1.clone());
      this._userStSig_create_time = paramLong1;
    }
    if ((paramArrayOfByte2 != null) && (paramArrayOfByte2.length > 0)) {
      this._userSt_Key = ((byte[])paramArrayOfByte2.clone());
    }
  }
  
  private WloginSigInfo(Parcel paramParcel)
  {
    readFromParcel(paramParcel);
  }
  
  public WloginSigInfo Set(long paramLong1, long paramLong2, long paramLong3, long paramLong4, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5, byte[] paramArrayOfByte6, byte[] paramArrayOfByte7, byte[] paramArrayOfByte8, byte[] paramArrayOfByte9, byte[] paramArrayOfByte10, byte[] paramArrayOfByte11, byte[] paramArrayOfByte12, byte[][] paramArrayOfByte, long[] paramArrayOfLong, int paramInt)
  {
    SetSigInfo(paramLong1, paramLong2, paramLong3, paramLong4, paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3, paramArrayOfByte4, paramArrayOfByte5, paramArrayOfByte6, paramArrayOfByte7, paramArrayOfByte8, paramArrayOfByte9, paramArrayOfByte10, paramArrayOfByte11, paramArrayOfByte12, paramArrayOfByte, paramArrayOfLong, paramInt);
    return this;
  }
  
  public WloginSigInfo Set(byte[][] paramArrayOfByte, long paramLong)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length == 5)) {
      if ((paramArrayOfByte[0] != null) && (paramArrayOfByte[0].length > 0))
      {
        this._en_A1 = ((byte[])paramArrayOfByte[0].clone());
        this._create_time = paramLong;
        if ((paramArrayOfByte[1] == null) || (paramArrayOfByte[1].length <= 0)) {
          break label147;
        }
      }
    }
    label147:
    for (this._noPicSig = ((byte[])paramArrayOfByte[1].clone());; this._noPicSig = new byte[0])
    {
      if ((paramArrayOfByte[2] != null) && (paramArrayOfByte[2].length > 0)) {
        this._G = ((byte[])paramArrayOfByte[2].clone());
      }
      if ((paramArrayOfByte[3] != null) && (paramArrayOfByte[3].length > 0)) {
        this._dpwd = ((byte[])paramArrayOfByte[3].clone());
      }
      if ((paramArrayOfByte[4] != null) && (paramArrayOfByte[4].length > 0)) {
        this._randseed = ((byte[])paramArrayOfByte[4].clone());
      }
      return this;
    }
  }
  
  public void SetSigInfo(long paramLong1, long paramLong2, long paramLong3, long paramLong4, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5, byte[] paramArrayOfByte6, byte[] paramArrayOfByte7, byte[] paramArrayOfByte8, byte[] paramArrayOfByte9, byte[] paramArrayOfByte10, byte[] paramArrayOfByte11, byte[] paramArrayOfByte12, byte[][] paramArrayOfByte, long[] paramArrayOfLong, int paramInt)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length != 12)) {
      util.LOGI("ERROR:reserve null or length not right", "");
    }
    do
    {
      return;
      if ((paramArrayOfLong == null) || (paramArrayOfLong.length != 7))
      {
        util.LOGI("reserve_valid null or length not right", "");
        return;
      }
      this._app_pri = paramLong1;
      this._A2_expire_time = paramLong4;
      this._login_bitmap |= paramInt;
      if ((paramArrayOfByte1 != null) && (paramArrayOfByte1.length > 0))
      {
        this._TGT = ((byte[])paramArrayOfByte1.clone());
        this._A2_create_time = paramLong2;
      }
      if ((paramArrayOfByte2 != null) && (paramArrayOfByte2.length > 0)) {
        this._TGTKey = ((byte[])paramArrayOfByte2.clone());
      }
      if ((paramArrayOfByte3 != null) && (paramArrayOfByte3.length > 0))
      {
        this._userStSig = ((byte[])paramArrayOfByte3.clone());
        this._userStSig_create_time = paramLong2;
      }
      if ((paramArrayOfByte4 != null) && (paramArrayOfByte4.length > 0)) {
        this._userSt_Key = ((byte[])paramArrayOfByte4.clone());
      }
      if ((paramArrayOfByte5 != null) && (paramArrayOfByte5.length > 0))
      {
        this._userStWebSig = ((byte[])paramArrayOfByte5.clone());
        this._userStWebSig_create_time = paramLong2;
        this._userStWebSig_expire_time = (paramArrayOfLong[4] + paramLong2);
      }
      if ((paramArrayOfByte6 != null) && (paramArrayOfByte6.length > 0))
      {
        this._userA5 = ((byte[])paramArrayOfByte6.clone());
        this._userA5_create_time = paramLong2;
      }
      if ((paramArrayOfByte7 != null) && (paramArrayOfByte7.length > 0))
      {
        this._userA8 = ((byte[])paramArrayOfByte7.clone());
        this._userA8_create_time = paramLong2;
        this._userA8_expire_time = (paramArrayOfLong[3] + paramLong2);
      }
      if ((paramArrayOfByte8 != null) && (paramArrayOfByte8.length > 0))
      {
        this._lsKey = ((byte[])paramArrayOfByte8.clone());
        this._lsKey_create_time = paramLong2;
        this._lsKey_expire_time = (paramArrayOfLong[0] + paramLong2);
      }
      if ((paramArrayOfByte9 != null) && (paramArrayOfByte9.length > 0))
      {
        this._sKey = ((byte[])paramArrayOfByte9.clone());
        this._sKey_create_time = paramLong2;
        this._sKey_expire_time = (paramArrayOfLong[1] + paramLong2);
      }
      if ((paramArrayOfByte10 != null) && (paramArrayOfByte10.length > 0))
      {
        this._userSig64 = ((byte[])paramArrayOfByte10.clone());
        this._userSig64_create_time = paramLong2;
      }
      if ((paramArrayOfByte11 != null) && (paramArrayOfByte11.length > 0)) {
        this._openid = ((byte[])paramArrayOfByte11.clone());
      }
      if ((paramArrayOfByte12 != null) && (paramArrayOfByte12.length > 0))
      {
        this._openkey = ((byte[])paramArrayOfByte12.clone());
        this._openkey_create_time = paramLong2;
      }
      if ((paramArrayOfByte[0] != null) && (paramArrayOfByte[0].length > 0))
      {
        this._vkey = ((byte[])paramArrayOfByte[0].clone());
        this._vkey_create_time = paramLong2;
        this._vKey_expire_time = (paramArrayOfLong[2] + paramLong2);
      }
      if ((paramArrayOfByte[1] != null) && (paramArrayOfByte[1].length > 0))
      {
        this._access_token = ((byte[])paramArrayOfByte[1].clone());
        this._access_token_create_time = paramLong2;
      }
      if ((paramArrayOfByte[2] != null) && (paramArrayOfByte[2].length > 0))
      {
        this._D2 = ((byte[])paramArrayOfByte[2].clone());
        this._D2_create_time = paramLong2;
        this._D2_expire_time = (paramArrayOfLong[5] + paramLong2);
      }
      if ((paramArrayOfByte[3] != null) && (paramArrayOfByte[3].length > 0)) {
        this._D2Key = ((byte[])paramArrayOfByte[3].clone());
      }
      if ((paramArrayOfByte[4] != null) && (paramArrayOfByte[4].length > 0))
      {
        this._sid = ((byte[])paramArrayOfByte[4].clone());
        this._sid_create_time = paramLong2;
        this._sid_expire_time = (paramArrayOfLong[6] + paramLong2);
      }
      if ((paramArrayOfByte[5] != null) && (paramArrayOfByte[5].length > 0))
      {
        this._aqSig = ((byte[])paramArrayOfByte[5].clone());
        this._aqSig_create_time = paramLong2;
      }
      if ((paramArrayOfByte[6] != null) && (paramArrayOfByte[6].length > 2))
      {
        this._psKey = ((byte[])paramArrayOfByte[6].clone());
        this._psKey_create_time = paramLong2;
      }
      if ((paramArrayOfByte[7] != null) && (paramArrayOfByte[7].length > 0))
      {
        this._superKey = ((byte[])paramArrayOfByte[7].clone());
        this._psKey_create_time = paramLong2;
      }
      if ((paramArrayOfByte[8] != null) && (paramArrayOfByte[8].length > 0)) {
        this._pay_token = ((byte[])paramArrayOfByte[8].clone());
      }
      if ((paramArrayOfByte[9] != null) && (paramArrayOfByte[9].length > 0)) {
        this._pf = ((byte[])paramArrayOfByte[9].clone());
      }
      if ((paramArrayOfByte[10] != null) && (paramArrayOfByte[10].length > 0)) {
        this._pfKey = ((byte[])paramArrayOfByte[10].clone());
      }
    } while (paramArrayOfByte[11] == null);
    if (paramArrayOfByte[11].length > 0)
    {
      this._DA2 = ((byte[])paramArrayOfByte[11].clone());
      return;
    }
    this._DA2 = new byte[0];
    util.LOGI("clear _DA2", "");
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean iSExpireA2(long paramLong)
  {
    return paramLong > this._A2_expire_time;
  }
  
  public void readFromParcel(Parcel paramParcel)
  {
    this._TGT = paramParcel.createByteArray();
    this._TGTKey = paramParcel.createByteArray();
    this._userStSig = paramParcel.createByteArray();
    this._userSt_Key = paramParcel.createByteArray();
    this._userStWebSig = paramParcel.createByteArray();
    this._userA5 = paramParcel.createByteArray();
    this._userA8 = paramParcel.createByteArray();
    this._lsKey = paramParcel.createByteArray();
    this._sKey = paramParcel.createByteArray();
    this._userSig64 = paramParcel.createByteArray();
    this._openid = paramParcel.createByteArray();
    this._openkey = paramParcel.createByteArray();
    this._vkey = paramParcel.createByteArray();
    this._en_A1 = paramParcel.createByteArray();
    this._access_token = paramParcel.createByteArray();
    this._D2 = paramParcel.createByteArray();
    this._D2Key = paramParcel.createByteArray();
    this._sid = paramParcel.createByteArray();
    this._noPicSig = paramParcel.createByteArray();
    this._aqSig = paramParcel.createByteArray();
    this._psKey = paramParcel.createByteArray();
    this._superKey = paramParcel.createByteArray();
    this._G = paramParcel.createByteArray();
    this._dpwd = paramParcel.createByteArray();
    this._randseed = paramParcel.createByteArray();
    this._login_bitmap = paramParcel.readInt();
    this._app_pri = paramParcel.readLong();
    this._A2_expire_time = paramParcel.readLong();
    this._lsKey_expire_time = paramParcel.readLong();
    this._sKey_expire_time = paramParcel.readLong();
    this._vKey_expire_time = paramParcel.readLong();
    this._userA8_expire_time = paramParcel.readLong();
    this._userStWebSig_expire_time = paramParcel.readLong();
    this._D2_expire_time = paramParcel.readLong();
    this._sid_expire_time = paramParcel.readLong();
    this._create_time = paramParcel.readLong();
    this._A2_create_time = paramParcel.readLong();
    this._userStSig_create_time = paramParcel.readLong();
    this._userStWebSig_create_time = paramParcel.readLong();
    this._userA5_create_time = paramParcel.readLong();
    this._userA8_create_time = paramParcel.readLong();
    this._lsKey_create_time = paramParcel.readLong();
    this._sKey_create_time = paramParcel.readLong();
    this._userSig64_create_time = paramParcel.readLong();
    this._openkey_create_time = paramParcel.readLong();
    this._vkey_create_time = paramParcel.readLong();
    this._access_token_create_time = paramParcel.readLong();
    this._D2_create_time = paramParcel.readLong();
    this._sid_create_time = paramParcel.readLong();
    this._aqSig_create_time = paramParcel.readLong();
    this._psKey_create_time = paramParcel.readLong();
    this._pay_token = paramParcel.createByteArray();
    this._pf = paramParcel.createByteArray();
    this._pfKey = paramParcel.createByteArray();
    this._DA2 = paramParcel.createByteArray();
  }
  
  public WloginSigInfo setDA2(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      this._DA2 = new byte[0];
      return this;
    }
    this._DA2 = ((byte[])paramArrayOfByte.clone());
    return this;
  }
  
  public WloginSigInfo setRandSeed(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0)) {
      this._randseed = ((byte[])paramArrayOfByte.clone());
    }
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeByteArray(this._TGT);
    paramParcel.writeByteArray(this._TGTKey);
    paramParcel.writeByteArray(this._userStSig);
    paramParcel.writeByteArray(this._userSt_Key);
    paramParcel.writeByteArray(this._userStWebSig);
    paramParcel.writeByteArray(this._userA5);
    paramParcel.writeByteArray(this._userA8);
    paramParcel.writeByteArray(this._lsKey);
    paramParcel.writeByteArray(this._sKey);
    paramParcel.writeByteArray(this._userSig64);
    paramParcel.writeByteArray(this._openid);
    paramParcel.writeByteArray(this._openkey);
    paramParcel.writeByteArray(this._vkey);
    paramParcel.writeByteArray(this._en_A1);
    paramParcel.writeByteArray(this._access_token);
    paramParcel.writeByteArray(this._D2);
    paramParcel.writeByteArray(this._D2Key);
    paramParcel.writeByteArray(this._sid);
    paramParcel.writeByteArray(this._noPicSig);
    paramParcel.writeByteArray(this._aqSig);
    paramParcel.writeByteArray(this._psKey);
    paramParcel.writeByteArray(this._superKey);
    paramParcel.writeByteArray(this._G);
    paramParcel.writeByteArray(this._dpwd);
    paramParcel.writeByteArray(this._randseed);
    paramParcel.writeInt(this._login_bitmap);
    paramParcel.writeLong(this._app_pri);
    paramParcel.writeLong(this._A2_expire_time);
    paramParcel.writeLong(this._lsKey_expire_time);
    paramParcel.writeLong(this._sKey_expire_time);
    paramParcel.writeLong(this._vKey_expire_time);
    paramParcel.writeLong(this._userA8_expire_time);
    paramParcel.writeLong(this._userStWebSig_expire_time);
    paramParcel.writeLong(this._D2_expire_time);
    paramParcel.writeLong(this._sid_expire_time);
    paramParcel.writeLong(this._create_time);
    paramParcel.writeLong(this._A2_create_time);
    paramParcel.writeLong(this._userStSig_create_time);
    paramParcel.writeLong(this._userStWebSig_create_time);
    paramParcel.writeLong(this._userA5_create_time);
    paramParcel.writeLong(this._userA8_create_time);
    paramParcel.writeLong(this._lsKey_create_time);
    paramParcel.writeLong(this._sKey_create_time);
    paramParcel.writeLong(this._userSig64_create_time);
    paramParcel.writeLong(this._openkey_create_time);
    paramParcel.writeLong(this._vkey_create_time);
    paramParcel.writeLong(this._access_token_create_time);
    paramParcel.writeLong(this._D2_create_time);
    paramParcel.writeLong(this._sid_create_time);
    paramParcel.writeLong(this._aqSig_create_time);
    paramParcel.writeLong(this._psKey_create_time);
    paramParcel.writeByteArray(this._pay_token);
    paramParcel.writeByteArray(this._pf);
    paramParcel.writeByteArray(this._pfKey);
    paramParcel.writeByteArray(this._DA2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.sharemem.WloginSigInfo
 * JD-Core Version:    0.7.0.1
 */