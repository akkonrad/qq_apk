import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;

public final class aifq
  implements Runnable
{
  public aifq(String paramString) {}
  
  public void run()
  {
    Intent localIntent = new Intent();
    localIntent.setClassName(BaseApplicationImpl.sApplication, "com.tencent.mobileqq.statistics.ReportReceiver");
    localIntent.putExtra("reporting_tag", "dc01616");
    localIntent.putExtra("reporting_detail", this.a);
    localIntent.putExtra("reporting_count", 1);
    localIntent.putExtra("is_runtime", 0);
    BaseApplicationImpl.getApplication().sendBroadcast(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aifq
 * JD-Core Version:    0.7.0.1
 */