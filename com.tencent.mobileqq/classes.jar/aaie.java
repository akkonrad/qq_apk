import com.tencent.mobileqq.ar.arengine.ARReport;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public class aaie
  implements Runnable
{
  public aaie(ARReport paramARReport, long paramLong, int paramInt) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("alltime", String.valueOf(this.jdField_a_of_type_Long));
    localHashMap.put("result", this.jdField_a_of_type_Int + "");
    StatisticCollector.a(BaseApplication.getContext()).a("", "AREngineinitAR", true, 0L, 0L, localHashMap, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaie
 * JD-Core Version:    0.7.0.1
 */