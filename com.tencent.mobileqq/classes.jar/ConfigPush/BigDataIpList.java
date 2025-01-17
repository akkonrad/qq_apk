package ConfigPush;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class BigDataIpList
  extends JceStruct
{
  static ArrayList cache_netSegConfs;
  static ArrayList cache_vIplist;
  public ArrayList netSegConfs;
  public long uService_type;
  public long ufragment_size;
  public ArrayList vIplist;
  
  public BigDataIpList() {}
  
  public BigDataIpList(long paramLong1, ArrayList paramArrayList1, ArrayList paramArrayList2, long paramLong2)
  {
    this.uService_type = paramLong1;
    this.vIplist = paramArrayList1;
    this.netSegConfs = paramArrayList2;
    this.ufragment_size = paramLong2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uService_type = paramJceInputStream.read(this.uService_type, 0, true);
    Object localObject;
    if (cache_vIplist == null)
    {
      cache_vIplist = new ArrayList();
      localObject = new BigDataIpInfo();
      cache_vIplist.add(localObject);
    }
    this.vIplist = ((ArrayList)paramJceInputStream.read(cache_vIplist, 1, true));
    if (cache_netSegConfs == null)
    {
      cache_netSegConfs = new ArrayList();
      localObject = new NetSegConf();
      cache_netSegConfs.add(localObject);
    }
    this.netSegConfs = ((ArrayList)paramJceInputStream.read(cache_netSegConfs, 2, false));
    this.ufragment_size = paramJceInputStream.read(this.ufragment_size, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uService_type, 0);
    paramJceOutputStream.write(this.vIplist, 1);
    if (this.netSegConfs != null) {
      paramJceOutputStream.write(this.netSegConfs, 2);
    }
    paramJceOutputStream.write(this.ufragment_size, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ConfigPush.BigDataIpList
 * JD-Core Version:    0.7.0.1
 */