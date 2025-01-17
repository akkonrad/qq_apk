package com.tencent.mobileqq.ptt.preop;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.ptt.processor.IPttProcessor;
import com.tencent.mobileqq.ptt.processor.IPttProcessor.ProcessData;
import com.tencent.mobileqq.ptt.processor.IPttProcessorListener;
import com.tencent.mobileqq.ptt.processor.PttCompositeProcessor;
import com.tencent.mobileqq.utils.AmrInputStreamWrapper;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import com.tencent.mobileqq.utils.RecordParams;
import com.tencent.mobileqq.utils.SilkCodecWrapper;
import com.tencent.mobileqq.voicechange.VoiceChange;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileOutputStream;

public class PttPreVoiceChanger
  implements IPttProcessorListener
{
  int jdField_a_of_type_Int;
  PttCompositeProcessor jdField_a_of_type_ComTencentMobileqqPttProcessorPttCompositeProcessor;
  FileOutputStream jdField_a_of_type_JavaIoFileOutputStream;
  String jdField_a_of_type_JavaLangString;
  public int b;
  
  public int a()
  {
    return this.b;
  }
  
  public void a()
  {
    try
    {
      if (this.jdField_a_of_type_JavaIoFileOutputStream != null)
      {
        this.jdField_a_of_type_JavaIoFileOutputStream.close();
        this.jdField_a_of_type_JavaIoFileOutputStream = null;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqPttProcessorPttCompositeProcessor != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqPttProcessorPttCompositeProcessor.a();
        this.jdField_a_of_type_ComTencentMobileqqPttProcessorPttCompositeProcessor = null;
      }
      this.jdField_a_of_type_Int = 0;
      this.b = 0;
      return;
    }
    catch (Exception localException)
    {
      do
      {
        localException.printStackTrace();
      } while (!QLog.isColorLevel());
      QLog.e("PttPreSendManager", 2, "PttPreVoiceChanger.close error");
    }
  }
  
  public void a(IPttProcessor paramIPttProcessor, IPttProcessor.ProcessData paramProcessData)
  {
    if (((paramIPttProcessor instanceof SilkCodecWrapper)) || ((paramIPttProcessor instanceof AmrInputStreamWrapper))) {
      this.b += (int)QQRecorder.a(this.jdField_a_of_type_Int, 4, 2, paramProcessData.jdField_a_of_type_Int);
    }
  }
  
  public boolean a(Context paramContext, String paramString1, int paramInt, QQRecorder.RecorderParam paramRecorderParam, String paramString2)
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqPttProcessorPttCompositeProcessor = new PttCompositeProcessor();
      if (paramInt != 0) {
        this.jdField_a_of_type_ComTencentMobileqqPttProcessorPttCompositeProcessor.a(new VoiceChange(paramContext, paramInt, paramString2));
      }
      if (paramRecorderParam.c == 0) {
        this.jdField_a_of_type_ComTencentMobileqqPttProcessorPttCompositeProcessor.a(new AmrInputStreamWrapper(paramContext));
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqPttProcessorPttCompositeProcessor.a(paramRecorderParam.jdField_a_of_type_Int, paramRecorderParam.b, paramRecorderParam.c);
        this.jdField_a_of_type_Int = paramRecorderParam.jdField_a_of_type_Int;
        this.jdField_a_of_type_ComTencentMobileqqPttProcessorPttCompositeProcessor.a(this);
        this.b = 0;
        this.jdField_a_of_type_JavaLangString = paramString1;
        paramContext = new File(this.jdField_a_of_type_JavaLangString);
        if (paramContext.exists()) {
          paramContext.delete();
        }
        paramContext.createNewFile();
        this.jdField_a_of_type_JavaIoFileOutputStream = new FileOutputStream(paramContext);
        paramContext = RecordParams.a(paramRecorderParam.c, paramRecorderParam.jdField_a_of_type_Int);
        this.jdField_a_of_type_JavaIoFileOutputStream.write(paramContext, 0, paramContext.length);
        this.jdField_a_of_type_JavaIoFileOutputStream.flush();
        return true;
        this.jdField_a_of_type_ComTencentMobileqqPttProcessorPttCompositeProcessor.a(new SilkCodecWrapper(paramContext));
      }
      return false;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public boolean a(byte[] paramArrayOfByte, int paramInt)
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqPttProcessorPttCompositeProcessor != null)
      {
        paramArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqPttProcessorPttCompositeProcessor.a(paramArrayOfByte, 0, paramInt);
        if (paramArrayOfByte != null) {
          this.jdField_a_of_type_JavaIoFileOutputStream.write(paramArrayOfByte.jdField_a_of_type_ArrayOfByte, 0, paramArrayOfByte.jdField_a_of_type_Int);
        }
      }
      return true;
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      if (QLog.isDevelopLevel()) {
        QLog.e("PttPreSendManager", 4, "handleSliceDataIfNeed exception !!!");
      }
    }
    return false;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PttPreSendManager", 2, "delete tempfile, path : " + this.jdField_a_of_type_JavaLangString);
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      File localFile = new File(this.jdField_a_of_type_JavaLangString);
      if (localFile.exists()) {
        localFile.delete();
      }
    }
  }
  
  public void b(IPttProcessor paramIPttProcessor, IPttProcessor.ProcessData paramProcessData) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.ptt.preop.PttPreVoiceChanger
 * JD-Core Version:    0.7.0.1
 */