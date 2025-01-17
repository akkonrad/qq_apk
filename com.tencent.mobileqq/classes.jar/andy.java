import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.DownloadResult.Status;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.webviewplugin.sound.QzoneSoundPlugin;
import org.json.JSONObject;

public class andy
  implements Downloader.DownloadListener
{
  public andy(QzoneSoundPlugin paramQzoneSoundPlugin, String paramString) {}
  
  public void onDownloadCanceled(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QzoneSoundPlugin", 2, "onDownloadCanceled:" + paramString);
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("code", -1);
      localJSONObject.put("message", paramString);
      QzoneSoundPlugin.a(this.jdField_a_of_type_CooperationQzoneWebviewpluginSoundQzoneSoundPlugin).callJs(this.jdField_a_of_type_JavaLangString, new String[] { localJSONObject.toString() });
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("QzoneSoundPlugin", 2, "DownloaderFactory onDownloadCanceled : " + paramString.getMessage());
    }
  }
  
  public void onDownloadFailed(String paramString, DownloadResult paramDownloadResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QzoneSoundPlugin", 2, "onDownloadFailed:" + paramString);
    }
    for (;;)
    {
      try
      {
        paramString = new JSONObject();
        if (paramDownloadResult == null) {
          continue;
        }
        DownloadResult.Status localStatus = paramDownloadResult.getStatus();
        if (localStatus == null) {
          continue;
        }
        paramString.put("code", localStatus.failReason);
        paramString.put("message", paramDownloadResult.getDetailDownloadInfo());
      }
      catch (Exception paramString)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.i("QzoneSoundPlugin", 2, "DownloaderFactory onDownloadFailed : " + paramString.getMessage());
        return;
        paramString.put("code", -1);
        paramString.put("message", "DownloadFailed");
        continue;
      }
      QzoneSoundPlugin.b(this.jdField_a_of_type_CooperationQzoneWebviewpluginSoundQzoneSoundPlugin).callJs(this.jdField_a_of_type_JavaLangString, new String[] { paramString.toString() });
      return;
      paramString.put("code", -1);
    }
  }
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QzoneSoundPlugin", 2, new Object[] { "onDownloadProgress: ", paramString + " : " + paramLong + " : " + paramFloat });
    }
  }
  
  public void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QzoneSoundPlugin", 2, "onDownloadSucceed");
    }
    try
    {
      paramString = new JSONObject();
      paramString.put("code", 0);
      paramString.put("message", "success");
      QzoneSoundPlugin.c(this.jdField_a_of_type_CooperationQzoneWebviewpluginSoundQzoneSoundPlugin).callJs(this.jdField_a_of_type_JavaLangString, new String[] { paramString.toString() });
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("QzoneSoundPlugin", 2, "DownloaderFactory onDownloadSucceed : " + paramString.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     andy
 * JD-Core Version:    0.7.0.1
 */