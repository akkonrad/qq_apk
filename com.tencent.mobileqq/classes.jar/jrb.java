import android.content.IntentFilter;
import com.tencent.av.ui.CallbackWaitingActivityExt;
import com.tencent.qphone.base.util.QLog;

public class jrb
  implements Runnable
{
  public jrb(CallbackWaitingActivityExt paramCallbackWaitingActivityExt) {}
  
  public void run()
  {
    try
    {
      this.a.a = new jro(this.a);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
      this.a.registerReceiver(this.a.a, localIntentFilter);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d(CallbackWaitingActivityExt.a(), 2, "Exception", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jrb
 * JD-Core Version:    0.7.0.1
 */