import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.olympic.activity.ARTipsManager;
import java.lang.ref.WeakReference;

public class ages
  extends Handler
{
  private WeakReference a;
  
  public ages(ARTipsManager paramARTipsManager)
  {
    this.a = new WeakReference(paramARTipsManager);
  }
  
  public void handleMessage(Message paramMessage)
  {
    ARTipsManager localARTipsManager = (ARTipsManager)this.a.get();
    if (localARTipsManager == null) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      return;
    case 100: 
      ARTipsManager.a(localARTipsManager, (aget)paramMessage.obj);
      return;
    }
    ARTipsManager.a(localARTipsManager);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ages
 * JD-Core Version:    0.7.0.1
 */