import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ReadInJoyGlobalReporter;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;

public class mkf
  implements Runnable
{
  public mkf(ReadinjoyTabFrame paramReadinjoyTabFrame) {}
  
  public void run()
  {
    ReadInJoyGlobalReporter.a().a(this.a.a, NetConnInfoCenter.getServerTimeMillis(), ReadInJoyUtils.e(), ReadInJoyUtils.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mkf
 * JD-Core Version:    0.7.0.1
 */