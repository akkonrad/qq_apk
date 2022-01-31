package ConfigPush;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class DomainIpList
  extends JceStruct
{
  static ArrayList cache_vIplist;
  public int uDomain_type = 0;
  public ArrayList vIplist = null;
  
  public DomainIpList() {}
  
  public DomainIpList(int paramInt, ArrayList paramArrayList)
  {
    this.uDomain_type = paramInt;
    this.vIplist = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uDomain_type = paramJceInputStream.read(this.uDomain_type, 0, true);
    if (cache_vIplist == null)
    {
      cache_vIplist = new ArrayList();
      DomainIpInfo localDomainIpInfo = new DomainIpInfo();
      cache_vIplist.add(localDomainIpInfo);
    }
    this.vIplist = ((ArrayList)paramJceInputStream.read(cache_vIplist, 1, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uDomain_type, 0);
    paramJceOutputStream.write(this.vIplist, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ConfigPush.DomainIpList
 * JD-Core Version:    0.7.0.1
 */