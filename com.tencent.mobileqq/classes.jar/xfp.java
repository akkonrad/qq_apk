import Wallet.DownloadChooseRsp;
import android.os.Bundle;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadBackControlConfig;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.observer.BusinessObserver;

public class xfp
  implements BusinessObserver
{
  public xfp(PreloadManager paramPreloadManager, List paramList, DownloadListener paramDownloadListener, boolean paramBoolean) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (!paramBoolean) {}
    do
    {
      for (;;)
      {
        return;
        if (paramInt == 3) {
          try
          {
            paramBundle = (DownloadChooseRsp)paramBundle.getSerializable("rsp");
            if (paramBundle != null) {
              break label89;
            }
            if (QLog.isColorLevel())
            {
              QLog.d("PreloadManager", 2, "download choose rsp is null:" + paramBundle);
              return;
            }
          }
          catch (Throwable paramBundle) {}
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("PreloadManager", 2, "downloadBackControlModules onReceive exception:" + paramBundle);
    return;
    label89:
    if (QLog.isColorLevel()) {
      QLog.d("PreloadManager", 2, "download choose rsp:" + paramBundle.vecResInfo);
    }
    PreloadManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadManager).update(paramBundle.vecResInfo);
    ThreadManager.post(new xfq(this), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xfp
 * JD-Core Version:    0.7.0.1
 */