package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class cell_operation
  extends JceStruct
{
  static Map cache_busi_param = new HashMap();
  static Map cache_bypass_param;
  static Map cache_click_stream_report;
  static ArrayList cache_custom_btn;
  static Map cache_droplist_cookie;
  static Map cache_feed_report_cookie;
  static Map cache_recomm_cookie;
  static s_schema cache_schema_info;
  static s_outshare cache_share_info;
  public Map busi_param;
  public Map bypass_param;
  public Map click_stream_report;
  public ArrayList custom_btn;
  public Map droplist_cookie;
  public Map feed_report_cookie;
  public String generic_url = "";
  public String qboss_trace = "";
  public String qq_url = "";
  public Map recomm_cookie;
  public s_schema schema_info;
  public s_outshare share_info;
  public String weixin_url = "";
  
  static
  {
    cache_busi_param.put(Integer.valueOf(0), "");
    cache_share_info = new s_outshare();
    cache_schema_info = new s_schema();
    cache_recomm_cookie = new HashMap();
    cache_recomm_cookie.put(Integer.valueOf(0), "");
    cache_click_stream_report = new HashMap();
    Object localObject = new HashMap();
    ((Map)localObject).put("", "");
    cache_click_stream_report.put(Integer.valueOf(0), localObject);
    cache_custom_btn = new ArrayList();
    localObject = new s_op_btn();
    cache_custom_btn.add(localObject);
    cache_feed_report_cookie = new HashMap();
    cache_feed_report_cookie.put(Integer.valueOf(0), "");
    cache_bypass_param = new HashMap();
    cache_bypass_param.put("", "");
    cache_droplist_cookie = new HashMap();
    cache_droplist_cookie.put(Integer.valueOf(0), "");
  }
  
  public cell_operation() {}
  
  public cell_operation(Map paramMap1, String paramString1, String paramString2, s_outshare params_outshare, s_schema params_schema, Map paramMap2, Map paramMap3, String paramString3, ArrayList paramArrayList, Map paramMap4, String paramString4, Map paramMap5, Map paramMap6)
  {
    this.busi_param = paramMap1;
    this.weixin_url = paramString1;
    this.qq_url = paramString2;
    this.share_info = params_outshare;
    this.schema_info = params_schema;
    this.recomm_cookie = paramMap2;
    this.click_stream_report = paramMap3;
    this.qboss_trace = paramString3;
    this.custom_btn = paramArrayList;
    this.feed_report_cookie = paramMap4;
    this.generic_url = paramString4;
    this.bypass_param = paramMap5;
    this.droplist_cookie = paramMap6;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.busi_param = ((Map)paramJceInputStream.read(cache_busi_param, 0, false));
    this.weixin_url = paramJceInputStream.readString(1, false);
    this.qq_url = paramJceInputStream.readString(2, false);
    this.share_info = ((s_outshare)paramJceInputStream.read(cache_share_info, 3, false));
    this.schema_info = ((s_schema)paramJceInputStream.read(cache_schema_info, 4, false));
    this.recomm_cookie = ((Map)paramJceInputStream.read(cache_recomm_cookie, 5, false));
    this.click_stream_report = ((Map)paramJceInputStream.read(cache_click_stream_report, 6, false));
    this.qboss_trace = paramJceInputStream.readString(7, false);
    this.custom_btn = ((ArrayList)paramJceInputStream.read(cache_custom_btn, 8, false));
    this.feed_report_cookie = ((Map)paramJceInputStream.read(cache_feed_report_cookie, 9, false));
    this.generic_url = paramJceInputStream.readString(10, false);
    this.bypass_param = ((Map)paramJceInputStream.read(cache_bypass_param, 11, false));
    this.droplist_cookie = ((Map)paramJceInputStream.read(cache_droplist_cookie, 12, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.busi_param != null) {
      paramJceOutputStream.write(this.busi_param, 0);
    }
    if (this.weixin_url != null) {
      paramJceOutputStream.write(this.weixin_url, 1);
    }
    if (this.qq_url != null) {
      paramJceOutputStream.write(this.qq_url, 2);
    }
    if (this.share_info != null) {
      paramJceOutputStream.write(this.share_info, 3);
    }
    if (this.schema_info != null) {
      paramJceOutputStream.write(this.schema_info, 4);
    }
    if (this.recomm_cookie != null) {
      paramJceOutputStream.write(this.recomm_cookie, 5);
    }
    if (this.click_stream_report != null) {
      paramJceOutputStream.write(this.click_stream_report, 6);
    }
    if (this.qboss_trace != null) {
      paramJceOutputStream.write(this.qboss_trace, 7);
    }
    if (this.custom_btn != null) {
      paramJceOutputStream.write(this.custom_btn, 8);
    }
    if (this.feed_report_cookie != null) {
      paramJceOutputStream.write(this.feed_report_cookie, 9);
    }
    if (this.generic_url != null) {
      paramJceOutputStream.write(this.generic_url, 10);
    }
    if (this.bypass_param != null) {
      paramJceOutputStream.write(this.bypass_param, 11);
    }
    if (this.droplist_cookie != null) {
      paramJceOutputStream.write(this.droplist_cookie, 12);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     NS_MOBILE_FEEDS.cell_operation
 * JD-Core Version:    0.7.0.1
 */