package NS_WEISHI_QQ_PROFILE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class stGetNewestFeedReq
  extends JceStruct
{
  static Map cache_mapReq = new HashMap();
  public Map mapReq;
  
  static
  {
    stGetNewestFeedReqInner localstGetNewestFeedReqInner = new stGetNewestFeedReqInner();
    cache_mapReq.put(Long.valueOf(0L), localstGetNewestFeedReqInner);
  }
  
  public stGetNewestFeedReq() {}
  
  public stGetNewestFeedReq(Map paramMap)
  {
    this.mapReq = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.mapReq = ((Map)paramJceInputStream.read(cache_mapReq, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.mapReq != null) {
      paramJceOutputStream.write(this.mapReq, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_WEISHI_QQ_PROFILE.stGetNewestFeedReq
 * JD-Core Version:    0.7.0.1
 */