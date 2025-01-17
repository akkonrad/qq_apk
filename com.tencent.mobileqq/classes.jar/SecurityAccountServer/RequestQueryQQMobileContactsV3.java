package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class RequestQueryQQMobileContactsV3
  extends JceStruct
{
  static int cache_queryFlag;
  static byte[] cache_sessionSid;
  public boolean Compressd;
  public long MaxsignTimeStamp;
  public String MobileUniqueNo = "";
  public boolean OmitOffline;
  public long nextFlag;
  public int queryFlag;
  public byte[] sessionSid;
  public long timeStamp;
  
  public RequestQueryQQMobileContactsV3() {}
  
  public RequestQueryQQMobileContactsV3(long paramLong1, long paramLong2, byte[] paramArrayOfByte, int paramInt, boolean paramBoolean1, long paramLong3, String paramString, boolean paramBoolean2)
  {
    this.nextFlag = paramLong1;
    this.timeStamp = paramLong2;
    this.sessionSid = paramArrayOfByte;
    this.queryFlag = paramInt;
    this.Compressd = paramBoolean1;
    this.MaxsignTimeStamp = paramLong3;
    this.MobileUniqueNo = paramString;
    this.OmitOffline = paramBoolean2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.nextFlag = paramJceInputStream.read(this.nextFlag, 0, true);
    this.timeStamp = paramJceInputStream.read(this.timeStamp, 1, true);
    if (cache_sessionSid == null)
    {
      cache_sessionSid = (byte[])new byte[1];
      ((byte[])cache_sessionSid)[0] = 0;
    }
    this.sessionSid = ((byte[])paramJceInputStream.read(cache_sessionSid, 2, true));
    this.queryFlag = paramJceInputStream.read(this.queryFlag, 3, true);
    this.Compressd = paramJceInputStream.read(this.Compressd, 4, false);
    this.MaxsignTimeStamp = paramJceInputStream.read(this.MaxsignTimeStamp, 5, false);
    this.MobileUniqueNo = paramJceInputStream.readString(6, false);
    this.OmitOffline = paramJceInputStream.read(this.OmitOffline, 7, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.nextFlag, 0);
    paramJceOutputStream.write(this.timeStamp, 1);
    paramJceOutputStream.write(this.sessionSid, 2);
    paramJceOutputStream.write(this.queryFlag, 3);
    paramJceOutputStream.write(this.Compressd, 4);
    paramJceOutputStream.write(this.MaxsignTimeStamp, 5);
    if (this.MobileUniqueNo != null) {
      paramJceOutputStream.write(this.MobileUniqueNo, 6);
    }
    paramJceOutputStream.write(this.OmitOffline, 7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     SecurityAccountServer.RequestQueryQQMobileContactsV3
 * JD-Core Version:    0.7.0.1
 */