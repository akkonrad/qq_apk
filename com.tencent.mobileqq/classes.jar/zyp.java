import android.view.View;
import com.tencent.mobileqq.ar.ARRecord.ARVideoRecordViewProxy;

public class zyp
  implements Runnable
{
  public zyp(ARVideoRecordViewProxy paramARVideoRecordViewProxy) {}
  
  public void run()
  {
    if (ARVideoRecordViewProxy.b(this.a) != null) {
      ARVideoRecordViewProxy.b(this.a).setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     zyp
 * JD-Core Version:    0.7.0.1
 */