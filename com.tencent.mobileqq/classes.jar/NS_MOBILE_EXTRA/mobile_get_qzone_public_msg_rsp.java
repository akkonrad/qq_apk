package NS_MOBILE_EXTRA;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class mobile_get_qzone_public_msg_rsp
  extends JceStruct
{
  static Map cache_map_ext = new HashMap();
  public int left_req_times;
  public Map map_ext;
  public int next_req_tmstamp;
  public int stay_min_seconds_to_req;
  
  static
  {
    cache_map_ext.put("", "");
  }
  
  public mobile_get_qzone_public_msg_rsp() {}
  
  public mobile_get_qzone_public_msg_rsp(int paramInt1, int paramInt2, int paramInt3, Map paramMap)
  {
    this.next_req_tmstamp = paramInt1;
    this.left_req_times = paramInt2;
    this.stay_min_seconds_to_req = paramInt3;
    this.map_ext = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.next_req_tmstamp = paramJceInputStream.read(this.next_req_tmstamp, 0, false);
    this.left_req_times = paramJceInputStream.read(this.left_req_times, 1, false);
    this.stay_min_seconds_to_req = paramJceInputStream.read(this.stay_min_seconds_to_req, 2, false);
    this.map_ext = ((Map)paramJceInputStream.read(cache_map_ext, 3, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.next_req_tmstamp, 0);
    paramJceOutputStream.write(this.left_req_times, 1);
    paramJceOutputStream.write(this.stay_min_seconds_to_req, 2);
    if (this.map_ext != null) {
      paramJceOutputStream.write(this.map_ext, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_EXTRA.mobile_get_qzone_public_msg_rsp
 * JD-Core Version:    0.7.0.1
 */