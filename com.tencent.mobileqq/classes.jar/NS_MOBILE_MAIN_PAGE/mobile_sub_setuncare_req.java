package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class mobile_sub_setuncare_req
  extends JceStruct
{
  static s_uncare cache_uncare;
  public int action;
  public s_uncare uncare;
  
  public mobile_sub_setuncare_req() {}
  
  public mobile_sub_setuncare_req(int paramInt, s_uncare params_uncare)
  {
    this.action = paramInt;
    this.uncare = params_uncare;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.action = paramJceInputStream.read(this.action, 0, false);
    if (cache_uncare == null) {
      cache_uncare = new s_uncare();
    }
    this.uncare = ((s_uncare)paramJceInputStream.read(cache_uncare, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.action, 0);
    if (this.uncare != null) {
      paramJceOutputStream.write(this.uncare, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_MAIN_PAGE.mobile_sub_setuncare_req
 * JD-Core Version:    0.7.0.1
 */