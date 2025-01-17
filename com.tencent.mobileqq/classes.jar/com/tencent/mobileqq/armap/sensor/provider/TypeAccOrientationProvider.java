package com.tencent.mobileqq.armap.sensor.provider;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mobileqq.armap.sensor.ARSensorManager.OnSensorChangeListener;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class TypeAccOrientationProvider
  extends OrientationProvider2
{
  private float[] d = new float[4];
  
  public TypeAccOrientationProvider(Context paramContext, int paramInt, SensorManager paramSensorManager, ARSensorManager.OnSensorChangeListener paramOnSensorChangeListener)
  {
    super(paramContext, paramInt, paramSensorManager, paramOnSensorChangeListener);
    Sensor localSensor;
    if (paramInt == 5)
    {
      paramInt = 15;
      paramContext = paramSensorManager.getDefaultSensor(paramInt);
      localSensor = paramSensorManager.getDefaultSensor(1);
      paramSensorManager = paramSensorManager.getDefaultSensor(4);
      if ((paramSensorManager == null) || (paramContext == null) || (Build.VERSION.SDK_INT < 9)) {
        break label150;
      }
      paramOnSensorChangeListener.onSensorSupport(4, true);
      this.jdField_a_of_type_JavaUtilList.add(paramContext);
      QLog.i("OrientationProvider2", 2, "Gyroscope support,model:" + Build.MODEL + ", manufacture:" + Build.MANUFACTURER);
    }
    for (;;)
    {
      if (localSensor == null) {
        break label298;
      }
      paramOnSensorChangeListener.onSensorSupport(1, true);
      this.jdField_a_of_type_JavaUtilList.add(localSensor);
      return;
      paramInt = 11;
      break;
      label150:
      paramOnSensorChangeListener.onSensorSupport(4, false);
      if (paramSensorManager == null) {
        QLog.i("OrientationProvider2", 2, "Gyroscope not support,model:" + Build.MODEL + ", manufacture:" + Build.MANUFACTURER);
      } else if (paramContext == null) {
        if (Build.VERSION.SDK_INT >= 9) {
          QLog.i("OrientationProvider2", 2, "Gyroscope not support(rotationVectorSensor),model:" + Build.MODEL + ", manufacture:" + Build.MANUFACTURER);
        } else {
          QLog.i("OrientationProvider2", 2, "Gyroscope not support(sdk < 9),model:" + Build.MODEL + ", manufacture:" + Build.MANUFACTURER);
        }
      }
    }
    label298:
    paramOnSensorChangeListener.onSensorSupport(1, false);
  }
  
  private void a(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArmapSensorARSensorManager$OnSensorChangeListener == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqArmapSensorARSensorManager$OnSensorChangeListener.updateAccelerometer(paramFloat1, paramFloat2, paramFloat3, paramLong);
  }
  
  @TargetApi(9)
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if ((paramSensorEvent.sensor.getType() == 11) || (paramSensorEvent.sensor.getType() == 15))
    {
      SensorManager.getQuaternionFromVector(this.d, paramSensorEvent.values);
      this.jdField_a_of_type_ComTencentMobileqqArmapSensorARSensorManager$OnSensorChangeListener.onRotationUpdateQuaternion(this.d);
    }
    while (paramSensorEvent.sensor.getType() != 1) {
      return;
    }
    a(paramSensorEvent.values[0], paramSensorEvent.values[1], paramSensorEvent.values[2], paramSensorEvent.timestamp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.sensor.provider.TypeAccOrientationProvider
 * JD-Core Version:    0.7.0.1
 */