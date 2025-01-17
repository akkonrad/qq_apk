package NS_MOBILE_CLIENT_UPDATE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class REPORT_INFO
  extends JceStruct
{
  static ArrayList cache_info = new ArrayList();
  public ArrayList info;
  public int subtable;
  
  static
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("", "");
    cache_info.add(localHashMap);
  }
  
  public REPORT_INFO() {}
  
  public REPORT_INFO(int paramInt, ArrayList paramArrayList)
  {
    this.subtable = paramInt;
    this.info = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.subtable = paramJceInputStream.read(this.subtable, 0, false);
    this.info = ((ArrayList)paramJceInputStream.read(cache_info, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.subtable, 0);
    if (this.info != null) {
      paramJceOutputStream.write(this.info, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     NS_MOBILE_CLIENT_UPDATE.REPORT_INFO
 * JD-Core Version:    0.7.0.1
 */