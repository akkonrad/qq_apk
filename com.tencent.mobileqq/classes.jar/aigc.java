import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.remote.ToServiceMsg;

public class aigc
  implements Runnable
{
  public aigc(StatisticCollector paramStatisticCollector, ToServiceMsg paramToServiceMsg) {}
  
  public void run()
  {
    MsfServiceSdk.get().sendMsg(this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aigc
 * JD-Core Version:    0.7.0.1
 */