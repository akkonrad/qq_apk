import android.content.IntentFilter;
import com.tencent.av.ui.AVActivity;
import com.tencent.qphone.base.util.QLog;

public class jpo
  implements Runnable
{
  public jpo(AVActivity paramAVActivity) {}
  
  public void run()
  {
    try
    {
      this.a.a = new jpy(this.a);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
      this.a.registerReceiver(this.a.a, localIntentFilter);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d(this.a.b, 2, "Exception", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jpo
 * JD-Core Version:    0.7.0.1
 */