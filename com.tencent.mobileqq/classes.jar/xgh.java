import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.DownloadCallback;
import com.tencent.mobileqq.activity.qwallet.preload.ResourceInfo;
import com.tencent.qphone.base.util.QLog;

class xgh
  implements PreloadManager.DownloadCallback
{
  xgh(xgg paramxgg, ResultReceiver paramResultReceiver) {}
  
  public void onDownloadResFinished(String paramString1, int paramInt, String paramString2, ResourceInfo paramResourceInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QWalletIPCModule", 2, "QWalletIPC downloadModule" + paramString2 + "|" + paramResourceInfo + "|" + System.currentTimeMillis());
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("id", paramString1);
    localBundle.putInt("result", paramInt);
    localBundle.putString("path", paramString2);
    localBundle.putSerializable("res_info", paramResourceInfo);
    this.jdField_a_of_type_AndroidOsResultReceiver.send(0, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xgh
 * JD-Core Version:    0.7.0.1
 */