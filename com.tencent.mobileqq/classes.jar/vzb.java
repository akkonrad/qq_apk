import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;

public class vzb
  implements Runnable
{
  public vzb(PublicAccountChatPie paramPublicAccountChatPie) {}
  
  public void run()
  {
    boolean bool = false;
    PublicAccountChatPie localPublicAccountChatPie = this.a;
    if ((this.a.b(true)) || (this.a.b(false))) {
      bool = true;
    }
    localPublicAccountChatPie.an = bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vzb
 * JD-Core Version:    0.7.0.1
 */