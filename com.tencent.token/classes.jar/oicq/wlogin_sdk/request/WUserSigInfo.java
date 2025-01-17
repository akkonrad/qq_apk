package oicq.wlogin_sdk.request;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.List;
import oicq.wlogin_sdk.sharemem.WloginSigInfo;

public class WUserSigInfo
  implements Parcelable
{
  public static final Parcelable.Creator<WUserSigInfo> CREATOR = new WUserSigInfo.1();
  public List<String> _domains = new ArrayList();
  public byte[] _fastLoginBuf;
  public byte[] _in_ksid;
  public int _login_bitmap = 0;
  public byte[] _reserveData;
  public long _seqence = 0L;
  public List<Ticket> _tickets = new ArrayList();
  public String uin = "";
  
  public WUserSigInfo() {}
  
  private WUserSigInfo(Parcel paramParcel)
  {
    readFromParcel(paramParcel);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void get_clone(WloginSigInfo paramWloginSigInfo)
  {
    this._tickets.clear();
    this._tickets.add(new Ticket(2, paramWloginSigInfo._userA5, null, paramWloginSigInfo._userA5_create_time, 0L));
    this._tickets.add(new Ticket(2097152, paramWloginSigInfo._aqSig, null, paramWloginSigInfo._aqSig_create_time, 0L));
    this._tickets.add(new Ticket(8192, paramWloginSigInfo._userSig64, null, paramWloginSigInfo._userSig64_create_time, 0L));
    this._tickets.add(new Ticket(1048576, paramWloginSigInfo._superKey, null, paramWloginSigInfo._psKey_create_time, paramWloginSigInfo._psKey));
    this._tickets.add(new Ticket(16384, paramWloginSigInfo._openkey, paramWloginSigInfo._openid, paramWloginSigInfo._openkey_create_time, 0L));
    this._tickets.add(new Ticket(32768, paramWloginSigInfo._access_token, paramWloginSigInfo._openid, paramWloginSigInfo._access_token_create_time, 0L));
    this._tickets.add(new Ticket(128, paramWloginSigInfo._userStSig, paramWloginSigInfo._userSt_Key, paramWloginSigInfo._userStSig_create_time, 0L));
    this._tickets.add(new Ticket(16, paramWloginSigInfo._userA8, null, paramWloginSigInfo._userA8_create_time, paramWloginSigInfo._userA8_expire_time));
    this._tickets.add(new Ticket(512, paramWloginSigInfo._lsKey, null, paramWloginSigInfo._lsKey_create_time, paramWloginSigInfo._lsKey_expire_time));
    this._tickets.add(new Ticket(4096, paramWloginSigInfo._sKey, null, paramWloginSigInfo._sKey_create_time, paramWloginSigInfo._sKey_expire_time));
    this._tickets.add(new Ticket(131072, paramWloginSigInfo._vkey, null, paramWloginSigInfo._vkey_create_time, paramWloginSigInfo._vKey_expire_time));
    this._tickets.add(new Ticket(64, paramWloginSigInfo._TGT, paramWloginSigInfo._TGTKey, paramWloginSigInfo._A2_create_time, paramWloginSigInfo._A2_expire_time));
    this._tickets.add(new Ticket(262144, paramWloginSigInfo._D2, paramWloginSigInfo._D2Key, paramWloginSigInfo._D2_create_time, paramWloginSigInfo._D2_expire_time));
    this._tickets.add(new Ticket(524288, paramWloginSigInfo._sid, null, paramWloginSigInfo._sid_create_time, paramWloginSigInfo._sid_expire_time));
    this._tickets.add(new Ticket(32, paramWloginSigInfo._userStWebSig, null, paramWloginSigInfo._userStWebSig_create_time, paramWloginSigInfo._userStWebSig_expire_time));
    this._tickets.add(new Ticket(8388608, paramWloginSigInfo._pay_token, null, 0L, 0L));
    this._tickets.add(new Ticket(16777216, paramWloginSigInfo._pf, paramWloginSigInfo._pfKey, 0L, 0L));
    this._tickets.add(new Ticket(33554432, paramWloginSigInfo._DA2, null, 0L, 0L));
  }
  
  public void readFromParcel(Parcel paramParcel)
  {
    this._in_ksid = paramParcel.createByteArray();
    this._reserveData = paramParcel.createByteArray();
    this._fastLoginBuf = paramParcel.createByteArray();
    this._seqence = paramParcel.readLong();
    this._login_bitmap = paramParcel.readInt();
    this._domains = paramParcel.readArrayList(List.class.getClassLoader());
    paramParcel.readTypedList(this._tickets, Ticket.CREATOR);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeByteArray(this._in_ksid);
    paramParcel.writeByteArray(this._reserveData);
    paramParcel.writeByteArray(this._fastLoginBuf);
    paramParcel.writeLong(this._seqence);
    paramParcel.writeInt(this._login_bitmap);
    paramParcel.writeList(this._domains);
    paramParcel.writeTypedList(this._tickets);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.WUserSigInfo
 * JD-Core Version:    0.7.0.1
 */