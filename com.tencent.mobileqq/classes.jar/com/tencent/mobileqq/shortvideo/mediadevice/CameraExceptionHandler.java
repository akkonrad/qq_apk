package com.tencent.mobileqq.shortvideo.mediadevice;

import aice;
import android.os.Handler;

public class CameraExceptionHandler
{
  public Handler a;
  public CameraExceptionHandler.Callback a;
  
  public CameraExceptionHandler(Handler paramHandler, CameraExceptionHandler.Callback paramCallback)
  {
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler$Callback = paramCallback;
  }
  
  public void a(RuntimeException paramRuntimeException)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new aice(this, paramRuntimeException));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.mediadevice.CameraExceptionHandler
 * JD-Core Version:    0.7.0.1
 */