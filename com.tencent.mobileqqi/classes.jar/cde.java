import android.app.Dialog;
import com.tencent.mobileqq.activity.ChatActivity;

public class cde
  implements Runnable
{
  public cde(ChatActivity paramChatActivity) {}
  
  public void run()
  {
    if ((this.a.d != null) && (this.a.d.isShowing())) {
      this.a.d.dismiss();
    }
    while ((this.a.e == null) || (!this.a.e.isShowing())) {
      return;
    }
    this.a.e.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cde
 * JD-Core Version:    0.7.0.1
 */