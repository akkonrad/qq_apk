import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.qrcode.ipc.PreCallUpToolProc;
import com.tencent.biz.qrcode.ipc.PreCallUpToolProc.Callback;
import com.tencent.qphone.base.util.QLog;

public class ouv
  extends BroadcastReceiver
{
  public ouv(PreCallUpToolProc paramPreCallUpToolProc) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (QLog.isColorLevel()) {
      QLog.d("PreCallUpToolProc", 2, String.format("onReceive action=%s", new Object[] { paramContext }));
    }
    if (("com.tencent.mobileqq.armap.ACTION_START_THREAD_COMPLETED".equals(paramContext)) && (TextUtils.equals(paramIntent.getStringExtra("from"), PreCallUpToolProc.a(this.a))))
    {
      if (PreCallUpToolProc.a(this.a) != null) {
        PreCallUpToolProc.a(this.a).removeMessages(108);
      }
      if (PreCallUpToolProc.a(this.a) != null) {
        PreCallUpToolProc.a(this.a).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ouv
 * JD-Core Version:    0.7.0.1
 */