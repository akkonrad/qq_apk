import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.plugin.QZonePluginManager;

class amya
  extends Handler
{
  amya(amxz paramamxz, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZonePluginPreInstaller", 2, "handleMessage, retryInstallNum=" + amxz.a());
    }
    if (paramMessage.what == 1) {}
    try
    {
      paramMessage = (String)paramMessage.obj;
      amxz.a(this.a).a(paramMessage, this.a, 2);
      return;
    }
    catch (Exception paramMessage)
    {
      QLog.e("QZonePluginPreInstaller", 1, paramMessage, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amya
 * JD-Core Version:    0.7.0.1
 */