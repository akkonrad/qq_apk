import android.os.Message;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.app.MessageObserver;
import mqq.os.MqqHandler;

public class rza
  extends MessageObserver
{
  public rza(ChatHistory paramChatHistory) {}
  
  protected void a(boolean paramBoolean)
  {
    this.a.r();
    if (!paramBoolean)
    {
      Message localMessage = this.a.a.obtainMessage(5);
      this.a.a(localMessage);
    }
  }
  
  protected void b(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      localMessage = this.a.a.obtainMessage(3);
      this.a.a(localMessage);
      return;
    }
    Message localMessage = this.a.a.obtainMessage(2);
    this.a.a(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rza
 * JD-Core Version:    0.7.0.1
 */