import android.os.Build;
import com.tencent.mobileqq.ar.arengine.ARReport;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public class aaid
  implements Runnable
{
  public aaid(ARReport paramARReport, int paramInt, long paramLong) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("ar_model", Build.MODEL);
    localHashMap.put("result", this.jdField_a_of_type_Int + "");
    localHashMap.put("alltime", String.valueOf(this.jdField_a_of_type_Long));
    StatisticCollector.a(BaseApplication.getContext()).a("", "AREngine_openCamera", true, 0L, 0L, localHashMap, "", true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaid
 * JD-Core Version:    0.7.0.1
 */