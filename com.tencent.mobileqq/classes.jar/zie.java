import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.richmedia.server.PeakAudioTransHandler;
import com.tencent.qphone.base.util.QLog;

public class zie
  extends BroadcastReceiver
{
  public zie(PeakAppInterface paramPeakAppInterface) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent != null) && ("tencent.peak.q2v.AudioTransPush".equals(paramIntent.getAction())))
    {
      int i = paramIntent.getIntExtra("rsptype", 0);
      paramContext = paramIntent.getByteArrayExtra("rspbody");
      QLog.d("PeakAppInterface", 2, "ACTION_AUDIO_TRANS_PUSH rsptype=" + i + "|" + paramContext.length);
      ((PeakAudioTransHandler)this.a.a(0)).a(i, paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zie
 * JD-Core Version:    0.7.0.1
 */