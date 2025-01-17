package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class s_likeman
  extends JceStruct
{
  static s_CustomPraise cache_customPraise = new s_CustomPraise();
  static s_user cache_user = new s_user();
  public s_CustomPraise customPraise;
  public String refer = "";
  public int superflag;
  public s_user user;
  
  public s_likeman() {}
  
  public s_likeman(s_user params_user, String paramString, int paramInt, s_CustomPraise params_CustomPraise)
  {
    this.user = params_user;
    this.refer = paramString;
    this.superflag = paramInt;
    this.customPraise = params_CustomPraise;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.user = ((s_user)paramJceInputStream.read(cache_user, 0, false));
    this.refer = paramJceInputStream.readString(1, false);
    this.superflag = paramJceInputStream.read(this.superflag, 2, false);
    this.customPraise = ((s_CustomPraise)paramJceInputStream.read(cache_customPraise, 3, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.user != null) {
      paramJceOutputStream.write(this.user, 0);
    }
    if (this.refer != null) {
      paramJceOutputStream.write(this.refer, 1);
    }
    paramJceOutputStream.write(this.superflag, 2);
    if (this.customPraise != null) {
      paramJceOutputStream.write(this.customPraise, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     NS_MOBILE_FEEDS.s_likeman
 * JD-Core Version:    0.7.0.1
 */