import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.intervideo.now.NowProxy;

public class xqy
  implements DialogInterface.OnClickListener
{
  public xqy(NewFlowCameraActivity paramNewFlowCameraActivity, NowProxy paramNowProxy) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    StoryReportor.a("video_shoot", "down_now", 0, 0, new String[0]);
    this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowProxy.a(null);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xqy
 * JD-Core Version:    0.7.0.1
 */