import com.tencent.av.AVLog;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.camera.QavCameraUsage;

public class jfa
  implements Runnable
{
  public jfa(VideoAppInterface paramVideoAppInterface) {}
  
  public void run()
  {
    AVLog.d(VideoAppInterface.c(), "CameraUsageRunnable: ");
    QavCameraUsage.a(this.a.getApplication(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jfa
 * JD-Core Version:    0.7.0.1
 */