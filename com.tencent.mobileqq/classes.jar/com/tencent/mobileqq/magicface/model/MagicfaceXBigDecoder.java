package com.tencent.mobileqq.magicface.model;

import aedx;
import aedy;
import com.tencent.mobileqq.magicface.DecoderUtil;
import com.tencent.qphone.base.util.QLog;

public class MagicfaceXBigDecoder
  extends MagicfaceFFMepgDecoder
{
  public Object a;
  Runnable a;
  public Object b;
  Runnable b;
  public volatile boolean b;
  
  public MagicfaceXBigDecoder()
  {
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_b_of_type_JavaLangObject = new Object();
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangRunnable = new aedx(this);
    this.jdField_b_of_type_JavaLangRunnable = new aedy(this);
    if (QLog.isColorLevel()) {
      QLog.i("MagicfaceXBigDecoder", 2, "==MagicfaceXBigDecoder init=");
    }
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil = new DecoderUtil();
    if ((this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.createVideoDecoder() == 0) || (this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.createAlphaDecoder() != 0)) {}
  }
  
  public void a()
  {
    try
    {
      this.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceData.b;
      if (this.jdField_a_of_type_ArrayOfByte == null) {
        return;
      }
      this.d = this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceData.jdField_a_of_type_ArrayOfByte;
      if (this.d != null)
      {
        b();
        if ((this.c != null) && (this.f != null))
        {
          new Thread(this.jdField_b_of_type_JavaLangRunnable).start();
          this.jdField_a_of_type_JavaLangRunnable.run();
          return;
        }
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.i("MagicfaceXBigDecoder", 2, "Exception=" + localException.toString());
      }
    }
  }
  
  void b()
  {
    try
    {
      this.c = new byte[921600];
      this.f = new byte[921600];
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localOutOfMemoryError.printStackTrace();
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MagicfaceXBigDecoder", 2, "==MagicfaceXBigDecoder release=");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.releaseAlphaDecoder();
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.releaseVideoDecoder();
      label37:
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil = null;
      super.c();
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      break label37;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.model.MagicfaceXBigDecoder
 * JD-Core Version:    0.7.0.1
 */