import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.rebuild.GameRoomChatPie;
import com.tencent.mobileqq.nearby.gameroom.GameRoomAVController;
import com.tencent.qphone.base.util.QLog;

public class vue
  extends BroadcastReceiver
{
  public vue(GameRoomChatPie paramGameRoomChatPie) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramIntent.getStringExtra("peerUin");
    paramIntent.getIntExtra("sessionType", -1);
    paramContext = paramIntent.getStringExtra("sessionId");
    if (TextUtils.isEmpty(paramContext)) {}
    while (!paramContext.startsWith("10-")) {
      return;
    }
    this.a.a.c();
    this.a.j.setEnabled(true);
    if (QLog.isColorLevel()) {
      QLog.d("Q.werewolf.GameRoomChatPie", 2, "onBind enter room setSoundDisable");
    }
    this.a.a.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vue
 * JD-Core Version:    0.7.0.1
 */