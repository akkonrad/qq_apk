package dov.com.tencent.mobileqq.richmedia;

import com.tencent.qphone.base.util.QLog;

public class LOG
{
  public static int a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(paramString1, 2, "##" + paramString2);
    }
    return 0;
  }
  
  public static int b(String paramString1, String paramString2)
  {
    QLog.e(paramString1, 2, "##" + paramString2);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.LOG
 * JD-Core Version:    0.7.0.1
 */