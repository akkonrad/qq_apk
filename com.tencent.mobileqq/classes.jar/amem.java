import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.widget.calloutpopupwindow.CalloutPopupWindow;
import java.lang.ref.WeakReference;

public class amem
  extends Handler
{
  public amem()
  {
    super(Looper.getMainLooper());
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        return;
      } while (paramMessage.obj == null);
      paramMessage = ((WeakReference)paramMessage.obj).get();
    } while ((paramMessage == null) || (!(paramMessage instanceof CalloutPopupWindow)));
    ((CalloutPopupWindow)paramMessage).dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amem
 * JD-Core Version:    0.7.0.1
 */