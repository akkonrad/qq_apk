import cooperation.qlink.QlinkServiceProxy;
import cooperation.qlink.SendMsg;
import java.util.concurrent.ConcurrentLinkedQueue;

public class amnt
  extends Thread
{
  public amnt(QlinkServiceProxy paramQlinkServiceProxy) {}
  
  public void run()
  {
    while (!QlinkServiceProxy.a(this.a).isEmpty())
    {
      SendMsg localSendMsg = (SendMsg)QlinkServiceProxy.a(this.a).poll();
      if (localSendMsg != null) {
        try
        {
          QlinkServiceProxy.a(this.a, localSendMsg);
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amnt
 * JD-Core Version:    0.7.0.1
 */