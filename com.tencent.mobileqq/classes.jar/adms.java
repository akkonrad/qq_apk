import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.fragment.HotChatFragment;
import com.tencent.mobileqq.fragment.HotChatFragment.HotChatWebView;

public class adms
  extends BroadcastReceiver
{
  public adms(HotChatFragment paramHotChatFragment) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent != null) && ("com.tencent.mobileqq.refresh_hot_chat_list".equals(paramIntent.getAction())) && (this.a.a != null) && (this.a.a.a != null)) {
      this.a.a.x();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adms
 * JD-Core Version:    0.7.0.1
 */