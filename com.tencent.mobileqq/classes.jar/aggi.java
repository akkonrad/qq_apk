import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;
import com.tencent.mobileqq.widget.QQToast;

public class aggi
  implements Runnable
{
  public aggi(ScanTorchActivity paramScanTorchActivity) {}
  
  public void run()
  {
    QQToast.a(this.a.getApplicationContext(), "识别失败，请稍后再试。", 1).b(this.a.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aggi
 * JD-Core Version:    0.7.0.1
 */