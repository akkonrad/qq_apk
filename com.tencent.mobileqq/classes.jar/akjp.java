import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.vashealth.HealthStepCounterPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class akjp
  implements SensorEventListener
{
  public akjp(HealthStepCounterPlugin paramHealthStepCounterPlugin) {}
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    this.a.f = ("Current step data:" + String.valueOf(paramSensorEvent.values[0]));
    QLog.d("HealthStepCounterPlugin", 1, "onSensorChanged:" + this.a.f);
    if ((HealthStepCounterPlugin.jdField_b_of_type_Int == 1) && (HealthStepCounterPlugin.jdField_b_of_type_Boolean))
    {
      this.a.c = ((int)paramSensorEvent.values[0]);
      HealthStepCounterPlugin.jdField_b_of_type_Boolean = false;
    }
    if (HealthStepCounterPlugin.jdField_b_of_type_Int == 3)
    {
      HealthStepCounterPlugin.jdField_b_of_type_Int = 0;
      this.a.d = ((int)paramSensorEvent.values[0]);
    }
    for (;;)
    {
      JSONObject localJSONObject;
      try
      {
        paramSensorEvent = new JSONObject();
        paramSensorEvent.put("retCode", 0);
        paramSensorEvent.put("step", this.a.d - this.a.c);
        localJSONObject = new JSONObject();
        localJSONObject.put("source", "none");
        paramSensorEvent = WebViewPlugin.toJsScript("StepsDetect", paramSensorEvent, localJSONObject);
        if (HealthStepCounterPlugin.a)
        {
          this.a.mRuntime.a().loadUrl("javascript:" + paramSensorEvent);
          QLog.d("HealthStepCounterPlugin", 1, "Steps detect:" + (this.a.d - this.a.c));
          HealthStepCounterPlugin.a = false;
        }
        HealthStepCounterPlugin.jdField_b_of_type_Boolean = true;
        return;
      }
      catch (Exception paramSensorEvent)
      {
        paramSensorEvent = new JSONObject();
      }
      try
      {
        paramSensorEvent.put("retCode", -1);
        paramSensorEvent.put("step", 0);
        localJSONObject = new JSONObject();
        localJSONObject.put("source", "none");
        this.a.dispatchJsEvent("StepsDetect", paramSensorEvent, localJSONObject);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("HealthStepCounterPlugin", 2, "Err StepsDetect");
      }
      catch (JSONException paramSensorEvent)
      {
        for (;;)
        {
          paramSensorEvent.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akjp
 * JD-Core Version:    0.7.0.1
 */