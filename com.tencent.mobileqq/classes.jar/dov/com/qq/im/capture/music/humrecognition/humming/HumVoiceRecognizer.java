package dov.com.qq.im.capture.music.humrecognition.humming;

import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.music.humrecognition.recognize.RecognitionManager;
import java.io.File;

public class HumVoiceRecognizer
  implements IRecognizer
{
  private File a;
  
  public void a()
  {
    try
    {
      RecognitionManager localRecognitionManager = (RecognitionManager)QIMManager.a().c(10);
      localRecognitionManager.a(this.a);
      localRecognitionManager.a(7000.0F);
      localRecognitionManager.c();
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("HumVoiceRecognizer", 2, "recognize: invoked. info: throwable = " + localThrowable);
    }
  }
  
  public void a(File paramFile)
  {
    this.a = paramFile;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.music.humrecognition.humming.HumVoiceRecognizer
 * JD-Core Version:    0.7.0.1
 */