import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.ocr.OcrControl;
import com.tencent.mobileqq.ocr.activity.ScanOcrActivity;

public class agcg
  implements View.OnClickListener
{
  public agcg(ScanOcrActivity paramScanOcrActivity) {}
  
  public void onClick(View paramView)
  {
    if ((ScanOcrActivity.a(this.a) == 1) && ((ScanOcrActivity.b(this.a) == 0) || (ScanOcrActivity.b(this.a) == 4)))
    {
      ScanOcrActivity.a(this.a).a();
      ScanOcrActivity.a(this.a, false);
      ScanOcrActivity.b(this.a);
      return;
    }
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agcg
 * JD-Core Version:    0.7.0.1
 */