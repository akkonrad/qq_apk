import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.vashealth.SSOHttpUtils;
import com.tencent.mobileqq.vashealth.SportManager;
import com.tencent.mobileqq.vashealth.StepAlarmReceiver;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class akkj
  implements Runnable
{
  public akkj(StepAlarmReceiver paramStepAlarmReceiver) {}
  
  public void run()
  {
    String str = String.valueOf(SSOHttpUtils.a());
    if ((!TextUtils.isEmpty(StepAlarmReceiver.jdField_a_of_type_JavaLangString)) && (!str.equals(StepAlarmReceiver.jdField_a_of_type_JavaLangString))) {
      SSOHttpUtils.jdField_a_of_type_Float = 0.0F;
    }
    Object localObject = SportManager.a();
    if (((SharedPreferences)localObject).getBoolean("config_ready", false))
    {
      this.a.jdField_a_of_type_Long = ((SharedPreferences)localObject).getInt("max_interval", 0);
      this.a.jdField_a_of_type_Int = ((SharedPreferences)localObject).getInt("max_increment", 0);
    }
    StepAlarmReceiver.jdField_a_of_type_JavaLangString = str;
    try
    {
      localObject = SSOHttpUtils.a();
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        return;
      }
      localObject = new JSONObject((String)localObject);
      int i = ((JSONObject)localObject).getInt(str + "_total");
      int j = ((JSONObject)localObject).getInt(str + "_init");
      float f1 = ((JSONObject)localObject).getInt(str + "_offset") + (i - j);
      float f2 = SSOHttpUtils.jdField_a_of_type_Float;
      long l1 = NetConnInfoCenter.getServerTimeMillis();
      long l2 = SSOHttpUtils.jdField_a_of_type_Long;
      str = ((JSONObject)localObject).toString();
      QLog.i("StepAlarmReceiver", 1, "receiver long time report max report steps:" + this.a.jdField_a_of_type_Int + ",report interval:" + this.a.jdField_a_of_type_Long);
      if ((f1 - f2 > this.a.jdField_a_of_type_Int) || (l1 - l2 > this.a.jdField_a_of_type_Long))
      {
        SSOHttpUtils.a(str);
        return;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("health_manager", 2, "long time report Exception:" + localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akkj
 * JD-Core Version:    0.7.0.1
 */