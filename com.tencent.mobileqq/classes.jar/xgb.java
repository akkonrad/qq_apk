import Wallet.JudgeDownloadRsp;
import android.os.Bundle;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadFlowControlConfig;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadModule;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadResource;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.observer.BusinessObserver;

public class xgb
  implements BusinessObserver
{
  public xgb(PreloadResource paramPreloadResource, WeakReference paramWeakReference, DownloadListener paramDownloadListener, PreloadModule paramPreloadModule) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle arg3)
  {
    int i = 60;
    PreloadManager localPreloadManager1;
    label83:
    JudgeDownloadRsp localJudgeDownloadRsp;
    if (paramInt == 1)
    {
      try
      {
        localPreloadManager1 = (PreloadManager)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (!PreloadManager.a(localPreloadManager1)) {
          return;
        }
        if (paramBoolean) {
          break label83;
        }
        localPreloadManager1.d();
        return;
      }
      catch (Throwable ???)
      {
        if (!QLog.isColorLevel()) {
          break label579;
        }
      }
      QLog.d("PreloadResource", 2, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadResource.mResId + " startFlowControlReq onReceive exception:" + ???);
      return;
      localJudgeDownloadRsp = (JudgeDownloadRsp)???.getSerializable("rsp");
      if (localJudgeDownloadRsp == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PreloadResource", 2, "onReceive rsp is null:" + localJudgeDownloadRsp);
        }
        localPreloadManager1.d();
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PreloadResource", 2, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadResource.mResId + "FlowControlRsp|" + localJudgeDownloadRsp.iDownloadStatus + "|" + localJudgeDownloadRsp.iSegTime + "|" + localJudgeDownloadRsp.iFailedRetryMax);
      }
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadResource)
      {
        switch (localJudgeDownloadRsp.iDownloadStatus)
        {
        case 1: 
          if (localJudgeDownloadRsp.iDownloadStatus != 0) {
            PreloadResource.access$100(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadResource).mRetryReqTimes = 0;
          }
          PreloadResource.access$100(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadResource).saveConfig();
          if (localJudgeDownloadRsp.iDownloadStatus != 2) {
            break label527;
          }
          localPreloadManager1.d();
          if (this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener == null) {
            break label579;
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadResource.notifyListenerDownloadFailInFlowControl(this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadModule, localPreloadManager1);
          return;
          PreloadResource.access$100(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadResource).mDownloadStatus = 1;
          localPreloadFlowControlConfig = PreloadResource.access$100(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadResource);
          if (localJudgeDownloadRsp.iFailedRetryMax > 0)
          {
            paramInt = localJudgeDownloadRsp.iFailedRetryMax;
            localPreloadFlowControlConfig.mRetryDownloadTimes = paramInt;
            localPreloadFlowControlConfig = PreloadResource.access$100(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadResource);
            if (localJudgeDownloadRsp.iSegTime > 60) {
              i = localJudgeDownloadRsp.iSegTime;
            }
            localPreloadFlowControlConfig.mValidDownloadTime = (i * 1000 + NetConnInfoCenter.getServerTimeMillis());
          }
          break;
        }
      }
      paramInt = 3;
      continue;
      PreloadResource.access$100(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadResource).mDownloadStatus = 2;
      PreloadFlowControlConfig localPreloadFlowControlConfig = PreloadResource.access$100(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadResource);
      if (localJudgeDownloadRsp.iSegTime > 60) {
        i = localJudgeDownloadRsp.iSegTime;
      }
      localPreloadFlowControlConfig.mNextCanReqTime = (i * 1000 + NetConnInfoCenter.getServerTimeMillis());
      continue;
      PreloadResource.access$100(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadResource).mDownloadStatus = 0;
      localPreloadFlowControlConfig = PreloadResource.access$100(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadResource);
      if (localJudgeDownloadRsp.iSegTime > 60) {
        i = localJudgeDownloadRsp.iSegTime;
      }
      localPreloadFlowControlConfig.mNextRetryReqTime = (i * 1000 + NetConnInfoCenter.getServerTimeMillis());
      continue;
      label527:
      if (localJudgeDownloadRsp.iDownloadStatus == 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadResource.handleFlowConfig(localPreloadManager2, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadModule, this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener);
        return;
      }
      if (localJudgeDownloadRsp.iDownloadStatus == 1) {
        this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadResource.handleFlowConfig(localPreloadManager2, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadModule, this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener);
      }
      label579:
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xgb
 * JD-Core Version:    0.7.0.1
 */