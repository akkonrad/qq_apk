import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.OnGetPathListener;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;
import com.tencent.mobileqq.activity.qwallet.preload.QWalletIPCModule;
import com.tencent.qphone.base.util.QLog;

public class xgl
  implements PreloadManager.OnGetPathListener
{
  public xgl(QWalletIPCModule paramQWalletIPCModule, ResultReceiver paramResultReceiver) {}
  
  public void onResult(int paramInt, PreloadManager.PathResult paramPathResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QWalletIPCModule", 2, "QWalletIPC downloadUrls" + paramPathResult);
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("result_code", paramInt);
    localBundle.putSerializable("path_result", paramPathResult);
    this.jdField_a_of_type_AndroidOsResultReceiver.send(0, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xgl
 * JD-Core Version:    0.7.0.1
 */