package com.tencent.sharp.jni;

public class TraeAudioManager$DeviceConfigManager$DeviceConfig
{
  int jdField_a_of_type_Int = 0;
  String jdField_a_of_type_JavaLangString = "DEVICE_NONE";
  boolean jdField_a_of_type_Boolean = false;
  boolean b = false;
  
  public TraeAudioManager$DeviceConfigManager$DeviceConfig(TraeAudioManager.DeviceConfigManager paramDeviceConfigManager) {}
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(String paramString, int paramInt)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {}
    while (TraeAudioManager.a(paramString) != true) {
      return false;
    }
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
    return true;
  }
  
  public void b(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public boolean b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.sharp.jni.TraeAudioManager.DeviceConfigManager.DeviceConfig
 * JD-Core Version:    0.7.0.1
 */