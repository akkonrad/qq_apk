import com.tencent.mobileqq.utils.CameraUtil;
import com.tencent.mobileqq.widget.CameraFrameLayout;

public class hjp
  implements Runnable
{
  public hjp(CameraFrameLayout paramCameraFrameLayout) {}
  
  public void run()
  {
    synchronized (CameraFrameLayout.a(this.a))
    {
      if (CameraFrameLayout.a(this.a) != null)
      {
        CameraUtil.a(CameraFrameLayout.a(this.a));
        CameraFrameLayout.a(this.a, null);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hjp
 * JD-Core Version:    0.7.0.1
 */