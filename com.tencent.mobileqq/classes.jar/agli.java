import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.pic.PicPreDownloader;

public class agli
  extends BroadcastReceiver
{
  String a;
  
  public agli(String paramString)
  {
    this.a = paramString;
  }
  
  public boolean a(Context paramContext)
  {
    return ((KeyguardManager)paramContext.getSystemService("keyguard")).inKeyguardRestrictedInputMode();
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    boolean bool = false;
    paramIntent = paramIntent.getAction();
    if ("android.intent.action.SCREEN_ON".equals(paramIntent))
    {
      PicPreDownloader.b = PicPreDownloader.a;
      if (!a(paramContext)) {
        bool = true;
      }
      PicPreDownloader.a = bool;
    }
    for (;;)
    {
      Logger.a("PIC_TAG_PRELOAD", "onReceive", "isScreenOn:" + PicPreDownloader.a + ",lastScreenOnState:" + PicPreDownloader.b);
      if ((PicPreDownloader.b != PicPreDownloader.a) || (PicPreDownloader.a)) {
        break;
      }
      return;
      if ("android.intent.action.SCREEN_OFF".equals(paramIntent))
      {
        PicPreDownloader.b = PicPreDownloader.a;
        PicPreDownloader.a = false;
      }
      else if ("android.intent.action.USER_PRESENT".equals(paramIntent))
      {
        PicPreDownloader.b = PicPreDownloader.a;
        PicPreDownloader.a = true;
      }
    }
    ThreadManager.post(new aglj(this), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agli
 * JD-Core Version:    0.7.0.1
 */