package SLICE_UPLOAD;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class FileUploadReq
  extends JceStruct
{
  static int cache_check_type = 0;
  static byte[] cache_data = (byte[])new byte[1];
  public String appid = "";
  public int check_type = 0;
  public String checksum = "";
  public byte[] data = null;
  public long offset = 0L;
  public String session = "";
  public String uin = "";
  
  static
  {
    ((byte[])cache_data)[0] = 0;
  }
  
  public FileUploadReq() {}
  
  public FileUploadReq(String paramString1, String paramString2, String paramString3, long paramLong, byte[] paramArrayOfByte, String paramString4, int paramInt)
  {
    this.uin = paramString1;
    this.appid = paramString2;
    this.session = paramString3;
    this.offset = paramLong;
    this.data = paramArrayOfByte;
    this.checksum = paramString4;
    this.check_type = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.readString(0, true);
    this.appid = paramJceInputStream.readString(1, true);
    this.session = paramJceInputStream.readString(2, true);
    this.offset = paramJceInputStream.read(this.offset, 3, true);
    this.data = ((byte[])paramJceInputStream.read(cache_data, 4, true));
    this.checksum = paramJceInputStream.readString(5, false);
    this.check_type = paramJceInputStream.read(this.check_type, 6, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.appid, 1);
    paramJceOutputStream.write(this.session, 2);
    paramJceOutputStream.write(this.offset, 3);
    paramJceOutputStream.write(this.data, 4);
    if (this.checksum != null) {
      paramJceOutputStream.write(this.checksum, 5);
    }
    paramJceOutputStream.write(this.check_type, 6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     SLICE_UPLOAD.FileUploadReq
 * JD-Core Version:    0.7.0.1
 */