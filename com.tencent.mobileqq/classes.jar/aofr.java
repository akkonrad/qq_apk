import com.tencent.mobileqq.shortvideo.mediadevice.CameraExceptionHandler.Callback;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.activity.richmedia.FlowCameraActivity2;

public class aofr
  implements CameraExceptionHandler.Callback
{
  public aofr(FlowCameraActivity2 paramFlowCameraActivity2) {}
  
  public void a(RuntimeException paramRuntimeException)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FlowCameraActivity", 2, "[onDispatchThreadException]", paramRuntimeException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aofr
 * JD-Core Version:    0.7.0.1
 */