import android.graphics.Bitmap;
import android.os.Handler;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoSwitchCameraPicMgr;

public class xql
  implements Runnable
{
  public xql(NewFlowCameraActivity paramNewFlowCameraActivity) {}
  
  public void run()
  {
    Bitmap localBitmap = null;
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr != null) {
      localBitmap = this.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a.a(false);
    }
    if (this.a.jdField_a_of_type_AndroidOsHandler != null) {
      this.a.jdField_a_of_type_AndroidOsHandler.post(new xse(localBitmap, this.a.e));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xql
 * JD-Core Version:    0.7.0.1
 */