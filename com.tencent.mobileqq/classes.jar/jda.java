import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.qphone.base.util.QLog;

public class jda
  implements Runnable
{
  public jda(VideoController paramVideoController) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(VideoController.a, 2, "mSwitchToMultiRunnable timeOut ");
    }
    this.a.c(this.a.a().c, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jda
 * JD-Core Version:    0.7.0.1
 */