import android.os.Bundle;
import com.tencent.mobileqq.app.ConfigObserver;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.DownloaderGetCodeServer;
import eipc.EIPCResult;
import java.util.Map;

public class alhr
  extends ConfigObserver
{
  private alhr(DownloaderGetCodeServer paramDownloaderGetCodeServer) {}
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2)
  {
    LogUtility.c("DownloaderWriteCodeIPC", "GetAuthCodeObserver onGetAuthCode isSuccess|" + paramBoolean + " code|" + paramString1 + " reqId|" + paramString2);
    if (paramString2 == null) {
      return;
    }
    Bundle localBundle = (Bundle)DownloaderGetCodeServer.a(this.a).get(paramString2);
    if (localBundle == null)
    {
      LogUtility.c("DownloaderWriteCodeIPC", "GetAuthCodeObserver reqId|" + paramString2 + "  but params context is null");
      return;
    }
    int i = localBundle.getInt("CallbackId");
    paramString2 = new Bundle();
    paramString2.putString("PackageName", localBundle.getString("PackageName"));
    paramString2.putInt("VersionCode", localBundle.getInt("VersionCode"));
    if (paramBoolean)
    {
      paramString2.putBoolean("IsSuccess", true);
      paramString2.putString("Code", paramString1);
    }
    for (;;)
    {
      LogUtility.c("DownloaderWriteCodeIPC", "GetAuthCodeObserver callbackId|" + i + " result|" + paramString2);
      DownloaderGetCodeServer.a(this.a).callbackResult(i, EIPCResult.createSuccessResult(paramString2));
      return;
      paramString2.putBoolean("IsSuccess", false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     alhr
 * JD-Core Version:    0.7.0.1
 */