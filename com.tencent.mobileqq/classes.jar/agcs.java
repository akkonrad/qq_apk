import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ocr.activity.ScanOcrActivity;
import com.tencent.mobileqq.statistics.StatisticCollector;
import java.util.HashMap;

public class agcs
  implements Runnable
{
  public agcs(ScanOcrActivity paramScanOcrActivity, int paramInt) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(this.jdField_a_of_type_Int));
    StatisticCollector.a(BaseApplicationImpl.getContext()).a("", "ocr_recog", true, 0L, 0L, localHashMap, "", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agcs
 * JD-Core Version:    0.7.0.1
 */