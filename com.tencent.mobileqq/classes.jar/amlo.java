import android.os.IBinder;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.jtcode.JtcodePluginInstallActivity;
import cooperation.plugin.IPluginManager;

public class amlo
  implements OnPluginInstallListener
{
  public amlo(JtcodePluginInstallActivity paramJtcodePluginInstallActivity) {}
  
  public IBinder asBinder()
  {
    return null;
  }
  
  public void onInstallBegin(String paramString) {}
  
  public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2) {}
  
  public void onInstallError(String paramString, int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("JtcodePluginInstallActivity", 4, "onInstallError, pluginId:" + paramString + ",errorCode:" + paramInt);
    }
    QQToast.a(this.a.getApplicationContext(), 2131438295, 0);
    JtcodePluginInstallActivity.a(this.a, false);
    this.a.finish();
  }
  
  public void onInstallFinish(String paramString)
  {
    long l = System.currentTimeMillis();
    JtcodePluginInstallActivity.a(this.a).append(" ==step8: onInstallFinish, cost=" + (l - this.a.a));
    if (QLog.isDevelopLevel()) {
      QLog.i("JtcodePluginInstallActivity", 4, "onInstallFinish, pluginId:" + paramString);
    }
    boolean bool = JtcodePluginInstallActivity.a(this.a).isPlugininstalled("wlx_jtcode.apk");
    JtcodePluginInstallActivity.a(this.a).append(" ==step9: onInstallFinish, isPlugininstalled cost=" + (System.currentTimeMillis() - l));
    if (bool)
    {
      JtcodePluginInstallActivity.a(this.a);
      return;
    }
    QQToast.a(this.a.getApplicationContext(), 2131438295, 0);
    JtcodePluginInstallActivity.a(this.a, false);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amlo
 * JD-Core Version:    0.7.0.1
 */