package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class StreamData
  extends JceStruct
{
  static byte[] cache_vData;
  public short shPackSeq;
  public byte[] vData;
  
  public StreamData() {}
  
  public StreamData(short paramShort, byte[] paramArrayOfByte)
  {
    this.shPackSeq = paramShort;
    this.vData = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.shPackSeq = paramJceInputStream.read(this.shPackSeq, 1, true);
    if (cache_vData == null)
    {
      cache_vData = (byte[])new byte[1];
      ((byte[])cache_vData)[0] = 0;
    }
    this.vData = ((byte[])paramJceInputStream.read(cache_vData, 2, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.shPackSeq, 1);
    paramJceOutputStream.write(this.vData, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     QQService.StreamData
 * JD-Core Version:    0.7.0.1
 */