import com.tencent.mfsdk.collector.DropFrameMonitor;
import mqq.util.AbstractUnifiedMonitor.ThreadMonitorCallback;

public class rds
  implements AbstractUnifiedMonitor.ThreadMonitorCallback
{
  public rds(DropFrameMonitor paramDropFrameMonitor) {}
  
  public void onThreadMonitorEnd(int paramInt)
  {
    if (paramInt == 10) {
      DropFrameMonitor.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     rds
 * JD-Core Version:    0.7.0.1
 */