import com.tencent.mobileqq.app.message.C2CMessageProcessor;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import com.tencent.mobileqq.statistics.StatisticCollector;
import java.util.HashMap;

public class zsy
  implements Runnable
{
  public zsy(C2CMessageProcessor paramC2CMessageProcessor, String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2, String paramString4) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("fromUin", this.jdField_a_of_type_JavaLangString);
    localHashMap.put("toUin", this.jdField_b_of_type_JavaLangString);
    localHashMap.put("msgId", this.c);
    localHashMap.put("createTime", String.valueOf(this.jdField_a_of_type_Long));
    localHashMap.put("recvTime", String.valueOf(this.jdField_b_of_type_Long));
    localHashMap.put("sendFlag", this.d);
    localHashMap.put("nodeNo", String.valueOf(3000));
    long l2 = this.jdField_b_of_type_Long - this.jdField_a_of_type_Long;
    long l1;
    if (l2 > 0L)
    {
      l1 = l2;
      if (l2 <= 86400L) {}
    }
    else
    {
      l1 = 0L;
    }
    StatisticCollector.a(BaseApplication.getContext()).a(null, "actPubAccMsgReceipt", true, l1, 0L, localHashMap, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zsy
 * JD-Core Version:    0.7.0.1
 */