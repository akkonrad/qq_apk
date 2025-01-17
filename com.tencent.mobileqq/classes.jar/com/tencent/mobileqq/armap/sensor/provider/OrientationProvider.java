package com.tencent.mobileqq.armap.sensor.provider;

import android.hardware.GeomagneticField;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.mobileqq.armap.sensor.ARSensorManager.OnSensorChangeListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class OrientationProvider
  implements SensorEventListener
{
  private float jdField_a_of_type_Float = -1.0F;
  protected SensorManager a;
  protected ARSensorManager.OnSensorChangeListener a;
  protected List a;
  private boolean jdField_a_of_type_Boolean;
  protected float[] a;
  private float b = -1.0F;
  private float c = -1.0F;
  
  public OrientationProvider(SensorManager paramSensorManager, ARSensorManager.OnSensorChangeListener paramOnSensorChangeListener)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ArrayOfFloat = new float[3];
    this.jdField_a_of_type_AndroidHardwareSensorManager = paramSensorManager;
    this.jdField_a_of_type_ComTencentMobileqqArmapSensorARSensorManager$OnSensorChangeListener = paramOnSensorChangeListener;
  }
  
  private GeomagneticField a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return new GeomagneticField(this.jdField_a_of_type_Float, this.b, this.c, System.currentTimeMillis());
    }
    return null;
  }
  
  protected float a()
  {
    GeomagneticField localGeomagneticField = a();
    if (localGeomagneticField != null) {
      return localGeomagneticField.getDeclination();
    }
    return 0.0F;
  }
  
  public void a(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      Sensor localSensor = (Sensor)localIterator.next();
      this.jdField_a_of_type_AndroidHardwareSensorManager.registerListener(this, localSensor, paramInt);
    }
  }
  
  public void b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      Sensor localSensor = (Sensor)localIterator.next();
      this.jdField_a_of_type_AndroidHardwareSensorManager.registerListener(this, localSensor, 1);
    }
  }
  
  public void c()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      Sensor localSensor = (Sensor)localIterator.next();
      this.jdField_a_of_type_AndroidHardwareSensorManager.unregisterListener(this, localSensor);
    }
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.sensor.provider.OrientationProvider
 * JD-Core Version:    0.7.0.1
 */