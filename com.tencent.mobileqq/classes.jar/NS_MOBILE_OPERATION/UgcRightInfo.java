package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class UgcRightInfo
  extends JceStruct
{
  static ArrayList cache_allow_uins;
  public ArrayList allow_uins;
  public int ugc_right = 1;
  
  public UgcRightInfo() {}
  
  public UgcRightInfo(int paramInt, ArrayList paramArrayList)
  {
    this.ugc_right = paramInt;
    this.allow_uins = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ugc_right = paramJceInputStream.read(this.ugc_right, 0, false);
    if (cache_allow_uins == null)
    {
      cache_allow_uins = new ArrayList();
      cache_allow_uins.add(Long.valueOf(0L));
    }
    this.allow_uins = ((ArrayList)paramJceInputStream.read(cache_allow_uins, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ugc_right, 0);
    if (this.allow_uins != null) {
      paramJceOutputStream.write(this.allow_uins, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     NS_MOBILE_OPERATION.UgcRightInfo
 * JD-Core Version:    0.7.0.1
 */