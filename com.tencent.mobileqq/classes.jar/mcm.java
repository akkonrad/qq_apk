import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.capture.ReadInJoyCameraCaptureSoManager.Callback;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAppInterface;
import com.tencent.mobileqq.qipc.QIPCServerHelper;

class mcm
  implements ReadInJoyCameraCaptureSoManager.Callback
{
  mcm(mck parammck) {}
  
  public void a(int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("VALUE_CAMERA_CAPTURE_SO_DOWNLOAD_STATUS", paramInt);
    QIPCServerHelper.getInstance().callClient(VideoFeedsAppInterface.a, "Module_VideoFeedsIPCServer", "CMD_CAMERA_CAPTURE_SO_DOWNLOAD", localBundle, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mcm
 * JD-Core Version:    0.7.0.1
 */