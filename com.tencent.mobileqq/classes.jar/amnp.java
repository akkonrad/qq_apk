import com.tencent.qphone.base.util.QLog;
import cooperation.qlink.QlinkReliableReport;
import java.util.TimerTask;

public class amnp
  extends TimerTask
{
  public amnp(QlinkReliableReport paramQlinkReliableReport) {}
  
  public void run()
  {
    QLog.d("QlinkReliableReport", 2, "doStopReportTimer :  on timer");
    QlinkReliableReport.a(this.a, null);
    QlinkReliableReport.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amnp
 * JD-Core Version:    0.7.0.1
 */