package SummaryCard;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class RespSearch
  extends JceStruct
{
  static ArrayList cache_vRecords;
  static byte[] cache_vSecureSig;
  static ArrayList cache_vvRespServices;
  public ArrayList vRecords;
  public byte[] vSecureSig;
  public ArrayList vvRespServices;
  
  public RespSearch() {}
  
  public RespSearch(ArrayList paramArrayList1, byte[] paramArrayOfByte, ArrayList paramArrayList2)
  {
    this.vRecords = paramArrayList1;
    this.vSecureSig = paramArrayOfByte;
    this.vvRespServices = paramArrayList2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    Object localObject;
    if (cache_vRecords == null)
    {
      cache_vRecords = new ArrayList();
      localObject = new SearchInfo();
      cache_vRecords.add(localObject);
    }
    this.vRecords = ((ArrayList)paramJceInputStream.read(cache_vRecords, 0, true));
    if (cache_vSecureSig == null)
    {
      cache_vSecureSig = (byte[])new byte[1];
      ((byte[])cache_vSecureSig)[0] = 0;
    }
    this.vSecureSig = ((byte[])paramJceInputStream.read(cache_vSecureSig, 1, false));
    if (cache_vvRespServices == null)
    {
      cache_vvRespServices = new ArrayList();
      localObject = (byte[])new byte[1];
      ((byte[])localObject)[0] = 0;
      cache_vvRespServices.add(localObject);
    }
    this.vvRespServices = ((ArrayList)paramJceInputStream.read(cache_vvRespServices, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.vRecords, 0);
    if (this.vSecureSig != null) {
      paramJceOutputStream.write(this.vSecureSig, 1);
    }
    if (this.vvRespServices != null) {
      paramJceOutputStream.write(this.vvRespServices, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     SummaryCard.RespSearch
 * JD-Core Version:    0.7.0.1
 */