import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.ar.arengine.ARCamera;
import com.tencent.mobileqq.ar.arengine.AREngine;

public class aaez
  extends Handler
{
  public aaez(ARCamera paramARCamera, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 100: 
      AREngine.c(new aafa(this));
      removeMessages(100);
      sendEmptyMessageDelayed(100, 3000L);
      return;
    case 101: 
      AREngine.c(new aafb(this));
      return;
    }
    AREngine.c(new aafc(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaez
 * JD-Core Version:    0.7.0.1
 */