import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import dov.com.tencent.mobileqq.activity.richmedia.view.SensorFrameImageView;

public class aoim
  implements SensorEventListener
{
  public aoim(SensorFrameImageView paramSensorFrameImageView) {}
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    switch (paramSensorEvent.sensor.getType())
    {
    }
    for (;;)
    {
      SensorFrameImageView.a(this.a);
      SensorFrameImageView.b(this.a);
      return;
      SensorFrameImageView.a(this.a, paramSensorEvent.values);
      continue;
      SensorFrameImageView.b(this.a, paramSensorEvent.values);
      continue;
      SensorFrameImageView.c(this.a, paramSensorEvent.values);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aoim
 * JD-Core Version:    0.7.0.1
 */