import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.av.VideoController;
import com.tencent.av.app.GVipFunCallMonitor;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;

public class jeu
  extends BroadcastReceiver
{
  public jeu(GVipFunCallMonitor paramGVipFunCallMonitor) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent == null) || (paramIntent.getAction() == null)) {}
    do
    {
      do
      {
        return;
        paramContext = GVipFunCallMonitor.a(this.a).a();
      } while (paramContext == null);
      if (QLog.isColorLevel()) {
        QLog.d("GVipFunCallMonitor", 2, "recv vipfuncall msg broadcast: " + paramIntent.getAction());
      }
    } while (!paramIntent.getAction().equals("tencent.video.q2v.AnnimateDownloadFinish"));
    if (QLog.isColorLevel()) {
      QLog.d("GVipFunCallMonitor", 2, "ACTION_ANNIMATE_DOWNLOAD_FINISH");
    }
    paramContext.e(paramIntent.getIntExtra("fun_call_id", 0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jeu
 * JD-Core Version:    0.7.0.1
 */