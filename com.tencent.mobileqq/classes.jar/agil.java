import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;

public class agil
  implements Runnable
{
  public agil(ScanTorchActivity paramScanTorchActivity) {}
  
  public void run()
  {
    ScanTorchActivity.c(this.a, true, ScanTorchActivity.c(this.a));
    ScanTorchActivity.y(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agil
 * JD-Core Version:    0.7.0.1
 */