import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.ipc.ConnectNearbyProcService;
import com.tencent.mobileqq.nearby.now.model.PicFeedUploadInfo;
import com.tencent.mobileqq.nearby.now.send.uploader.VideoFeedsUploader.UploadResult;
import com.tencent.mobileqq.nearby.now.utils.NowVideoReporter;
import com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentFailedAdapter;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class afke
  implements Runnable
{
  afke(afkd paramafkd, PicFeedUploadInfo paramPicFeedUploadInfo, VideoFeedsUploader.UploadResult paramUploadResult) {}
  
  public void run()
  {
    int i = 0;
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelPicFeedUploadInfo != null)
    {
      ConnectNearbyProcService.a(4155, new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult.a), NearbyMomentFailedAdapter.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelPicFeedUploadInfo, this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult) });
      if ((this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelPicFeedUploadInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult.a == 0)) {
        break label201;
      }
      QQToast.a(BaseApplicationImpl.getContext(), 1, "发表失败，请重试", 1).a();
      QLog.i("NearbyMomentFailedAdapter", 1, "upload failed, errMsg=" + this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult.i + "code=" + this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadResult.a);
      label124:
      localObject = BaseApplicationImpl.getApplication().peekAppRuntime();
      if (!(localObject instanceof QQAppInterface)) {
        break label226;
      }
    }
    label201:
    label226:
    for (Object localObject = (QQAppInterface)localObject;; localObject = null)
    {
      NowVideoReporter localNowVideoReporter = new NowVideoReporter().h("video_public").i("re_republic").d("5").c("2");
      if (i != 0) {}
      for (String str = "1";; str = "2")
      {
        localNowVideoReporter.e(str).b((QQAppInterface)localObject);
        return;
        QLog.i("NearbyMomentFailedAdapter", 1, "mImageUploadListener, sendIPCMessage failed, info == null");
        break;
        QQToast.a(BaseApplicationImpl.getContext(), 2, "发表成功", 1).a();
        i = 1;
        break label124;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afke
 * JD-Core Version:    0.7.0.1
 */