import android.os.Bundle;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.emosm.web.MessengerService;

public class acau
  extends FriendListObserver
{
  public acau(MessengerService paramMessengerService) {}
  
  protected void onGetSigZanInfo(boolean paramBoolean, Object paramObject)
  {
    if (this.a.b != null)
    {
      this.a.b.putString("cmd", "ipc_signature_setlike");
      paramObject = new Bundle();
      if (!paramBoolean) {
        break label81;
      }
    }
    label81:
    for (int i = 0;; i = 101)
    {
      paramObject.putInt("result", i);
      this.a.b.putBundle("response", paramObject);
      this.a.a(this.a.b);
      this.a.b = null;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acau
 * JD-Core Version:    0.7.0.1
 */