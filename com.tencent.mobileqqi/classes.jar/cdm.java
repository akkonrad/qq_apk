import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatActivity;

public class cdm
  implements Runnable
{
  public cdm(ChatActivity paramChatActivity) {}
  
  public void run()
  {
    if (ChatActivity.a(this.a) != null) {
      ChatActivity.a(this.a).setVisibility(8);
    }
    if (ChatActivity.a(this.a) != null) {
      ChatActivity.a(this.a).setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cdm
 * JD-Core Version:    0.7.0.1
 */