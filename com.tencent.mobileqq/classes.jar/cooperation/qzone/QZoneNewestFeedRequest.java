package cooperation.qzone;

import NS_MOBILE_AIONewestFeed.AIONewestFeedReq;
import NS_MOBILE_AIONewestFeed.AIONewestFeedRsp;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;

public class QZoneNewestFeedRequest
  extends QzoneExternalRequest
{
  public JceStruct a;
  
  public QZoneNewestFeedRequest(long paramLong1, ArrayList paramArrayList, long paramLong2, String paramString)
  {
    super.setRefer(paramString);
    super.setHostUin(paramLong1);
    super.setLoginUserId(paramLong1);
    paramString = new AIONewestFeedReq();
    paramString.uOpUin = paramLong1;
    paramString.uHostUin = paramArrayList;
    paramString.uLastTime = paramLong2;
    this.a = paramString;
  }
  
  public static AIONewestFeedRsp a(byte[] paramArrayOfByte, QQAppInterface paramQQAppInterface, int[] paramArrayOfInt)
  {
    if (paramArrayOfByte == null) {
      paramArrayOfByte = null;
    }
    do
    {
      return paramArrayOfByte;
      paramQQAppInterface = (AIONewestFeedRsp)decode(paramArrayOfByte, "getAIONewestFeed", paramArrayOfInt);
      paramArrayOfByte = paramQQAppInterface;
    } while (paramQQAppInterface != null);
    return null;
  }
  
  public String getCmdString()
  {
    return "QzoneNewService.getAIONewestFeed";
  }
  
  public JceStruct getReq()
  {
    return this.a;
  }
  
  public String uniKey()
  {
    return "getAIONewestFeed";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.QZoneNewestFeedRequest
 * JD-Core Version:    0.7.0.1
 */