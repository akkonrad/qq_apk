package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class mobile_detail_rsp
  extends JceStruct
{
  static single_detail cache_detail_data = new single_detail();
  static Map cache_extend_info = new HashMap();
  static single_feed cache_ugc_detail_adv = new single_feed();
  public String attach_info = "";
  public String attach_info_essence = "";
  public single_detail detail_data;
  public Map extend_info;
  public int hasmore;
  public int hasmore_essence;
  public int type_info;
  public single_feed ugc_detail_adv;
  public int wait_time;
  
  static
  {
    cache_extend_info.put("", "");
  }
  
  public mobile_detail_rsp() {}
  
  public mobile_detail_rsp(single_detail paramsingle_detail, int paramInt1, String paramString1, int paramInt2, int paramInt3, Map paramMap, int paramInt4, String paramString2, single_feed paramsingle_feed)
  {
    this.detail_data = paramsingle_detail;
    this.hasmore = paramInt1;
    this.attach_info = paramString1;
    this.type_info = paramInt2;
    this.wait_time = paramInt3;
    this.extend_info = paramMap;
    this.hasmore_essence = paramInt4;
    this.attach_info_essence = paramString2;
    this.ugc_detail_adv = paramsingle_feed;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.detail_data = ((single_detail)paramJceInputStream.read(cache_detail_data, 0, false));
    this.hasmore = paramJceInputStream.read(this.hasmore, 1, false);
    this.attach_info = paramJceInputStream.readString(2, false);
    this.type_info = paramJceInputStream.read(this.type_info, 3, false);
    this.wait_time = paramJceInputStream.read(this.wait_time, 4, false);
    this.extend_info = ((Map)paramJceInputStream.read(cache_extend_info, 5, false));
    this.hasmore_essence = paramJceInputStream.read(this.hasmore_essence, 6, false);
    this.attach_info_essence = paramJceInputStream.readString(7, false);
    this.ugc_detail_adv = ((single_feed)paramJceInputStream.read(cache_ugc_detail_adv, 9, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.detail_data != null) {
      paramJceOutputStream.write(this.detail_data, 0);
    }
    paramJceOutputStream.write(this.hasmore, 1);
    if (this.attach_info != null) {
      paramJceOutputStream.write(this.attach_info, 2);
    }
    paramJceOutputStream.write(this.type_info, 3);
    paramJceOutputStream.write(this.wait_time, 4);
    if (this.extend_info != null) {
      paramJceOutputStream.write(this.extend_info, 5);
    }
    paramJceOutputStream.write(this.hasmore_essence, 6);
    if (this.attach_info_essence != null) {
      paramJceOutputStream.write(this.attach_info_essence, 7);
    }
    if (this.ugc_detail_adv != null) {
      paramJceOutputStream.write(this.ugc_detail_adv, 9);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     NS_MOBILE_FEEDS.mobile_detail_rsp
 * JD-Core Version:    0.7.0.1
 */