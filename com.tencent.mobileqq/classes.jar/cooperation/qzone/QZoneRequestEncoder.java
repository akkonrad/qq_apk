package cooperation.qzone;

import NS_MOBILE_MAIN_PAGE.mobile_sub_get_cover_req;
import com.qq.taf.jce.JceStruct;

public class QZoneRequestEncoder
  extends QzoneExternalRequest
{
  public JceStruct a;
  
  public QZoneRequestEncoder(long paramLong1, long paramLong2, int paramInt)
  {
    mobile_sub_get_cover_req localmobile_sub_get_cover_req = new mobile_sub_get_cover_req();
    localmobile_sub_get_cover_req.uin = paramLong1;
    localmobile_sub_get_cover_req.flag = paramInt;
    this.a = localmobile_sub_get_cover_req;
    super.setHostUin(paramLong1);
    super.setLoginUserId(paramLong2);
  }
  
  public static JceStruct a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    return decode(paramArrayOfByte, "getCover");
  }
  
  public String getCmdString()
  {
    return "QzoneNewService.getCover";
  }
  
  public JceStruct getReq()
  {
    return this.a;
  }
  
  public String uniKey()
  {
    return "getCover";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.QZoneRequestEncoder
 * JD-Core Version:    0.7.0.1
 */