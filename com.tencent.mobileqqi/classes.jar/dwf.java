import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.TroopMemberCardActivity;

public class dwf
  extends Handler
{
  public dwf(TroopMemberCardActivity paramTroopMemberCardActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    if (this.a.o != 1)
    {
      paramMessage = new Intent();
      paramMessage.putExtra("finish_chat_setting", true);
      this.a.a.setResult(-1, paramMessage);
    }
    this.a.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dwf
 * JD-Core Version:    0.7.0.1
 */