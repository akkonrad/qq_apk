import android.os.Bundle;
import com.tencent.open.wadl.WLog;
import cooperation.wadl.ipc.WadlProxyServiceManager;
import mqq.observer.BusinessObserver;

public class angn
  implements BusinessObserver
{
  public angn(WadlProxyServiceManager paramWadlProxyServiceManager, String paramString) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    paramInt = paramBundle.getInt("extra_result_code");
    String str = paramBundle.getString("extra_result_err_msg");
    paramBundle = paramBundle.getString("extra_cmd");
    if (!paramBoolean)
    {
      WLog.a("WadlProxyServiceManager", "onReportDownloadEvent fail operId=" + this.jdField_a_of_type_JavaLangString + ",cmd=" + paramBundle + ",errCode=" + paramInt + ",errMsg=" + str);
      return;
    }
    WLog.b("WadlProxyServiceManager", "onReportDownloadEvent success operId=" + this.jdField_a_of_type_JavaLangString + ",cmd=" + paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     angn
 * JD-Core Version:    0.7.0.1
 */