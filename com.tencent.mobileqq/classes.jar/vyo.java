import com.tencent.ark.ark;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;

public class vyo
  implements Runnable
{
  public vyo(PublicAccountChatPie paramPublicAccountChatPie) {}
  
  public void run()
  {
    try
    {
      ark.arkNotify("com.tencent.weather", "pubaccountPendantRefresh", "", "json");
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vyo
 * JD-Core Version:    0.7.0.1
 */