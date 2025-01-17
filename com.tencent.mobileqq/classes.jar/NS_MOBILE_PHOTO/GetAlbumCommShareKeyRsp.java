package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class GetAlbumCommShareKeyRsp
  extends JceStruct
{
  static Map cache_outs = new HashMap();
  public String msg = "";
  public Map outs;
  public int ret;
  
  static
  {
    cache_outs.put("", "");
  }
  
  public GetAlbumCommShareKeyRsp() {}
  
  public GetAlbumCommShareKeyRsp(int paramInt, String paramString, Map paramMap)
  {
    this.ret = paramInt;
    this.msg = paramString;
    this.outs = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret = paramJceInputStream.read(this.ret, 0, false);
    this.msg = paramJceInputStream.readString(1, false);
    this.outs = ((Map)paramJceInputStream.read(cache_outs, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret, 0);
    if (this.msg != null) {
      paramJceOutputStream.write(this.msg, 1);
    }
    if (this.outs != null) {
      paramJceOutputStream.write(this.outs, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_PHOTO.GetAlbumCommShareKeyRsp
 * JD-Core Version:    0.7.0.1
 */