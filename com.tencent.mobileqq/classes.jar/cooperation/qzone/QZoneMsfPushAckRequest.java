package cooperation.qzone;

import PUSHAPI.PushRsp;
import com.qq.taf.jce.JceStruct;
import common.config.service.WupTool;

public class QZoneMsfPushAckRequest
  extends QzoneExternalRequest
{
  private long jdField_a_of_type_Long;
  private String jdField_a_of_type_JavaLangString;
  private long b;
  
  public QZoneMsfPushAckRequest(long paramLong1, long paramLong2, String paramString1, long paramLong3, String paramString2)
  {
    super.setHostUin(paramLong1);
    super.setLoginUserId(paramLong1);
    super.setRefer(paramString1);
    this.jdField_a_of_type_Long = paramLong2;
    this.b = paramLong3;
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.needCompress = false;
  }
  
  public String getCmdString()
  {
    return "wns.pushrsp";
  }
  
  protected byte[] getEncodedUniParameter()
  {
    PushRsp localPushRsp = new PushRsp();
    localPushRsp.ptime = this.jdField_a_of_type_Long;
    localPushRsp.is_bgd = 0;
    localPushRsp.sUID = "<JIEHEBAN>";
    localPushRsp.flag = this.b;
    localPushRsp.Mark = this.jdField_a_of_type_JavaLangString;
    return WupTool.a(localPushRsp);
  }
  
  public JceStruct getReq()
  {
    return null;
  }
  
  public String uniKey()
  {
    return "wns.pushrsp";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.QZoneMsfPushAckRequest
 * JD-Core Version:    0.7.0.1
 */