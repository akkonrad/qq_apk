import com.tencent.mobileqq.ocr.OcrControl.OcrCallback;
import com.tencent.mobileqq.ocr.activity.ScanOcrActivity;
import com.tencent.mobileqq.ocr.data.OcrRecogResult;

public class agcq
  implements OcrControl.OcrCallback
{
  public agcq(ScanOcrActivity paramScanOcrActivity) {}
  
  public void a() {}
  
  public void a(int paramInt, OcrRecogResult paramOcrRecogResult, String paramString, long paramLong)
  {
    this.a.runOnUiThread(new agcr(this, paramString, paramInt, paramOcrRecogResult, paramLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agcq
 * JD-Core Version:    0.7.0.1
 */