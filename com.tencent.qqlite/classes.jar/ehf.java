import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.message.SystemMessageProcessor;
import com.tencent.mobileqq.systemmsg.SystemMsgController;

public class ehf
  extends Handler
{
  public ehf(SystemMsgController paramSystemMsgController, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if ((SystemMsgController.a(this.a)) && (SystemMsgController.a(this.a) != null))
    {
      SystemMsgController.a(this.a, false);
      SystemMsgController.a(this.a).a().a(3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     ehf
 * JD-Core Version:    0.7.0.1
 */