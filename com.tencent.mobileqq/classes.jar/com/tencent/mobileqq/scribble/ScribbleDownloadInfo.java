package com.tencent.mobileqq.scribble;

import com.tencent.mobileqq.data.MessageForScribble;
import com.tencent.qphone.base.util.QLog;

public class ScribbleDownloadInfo
  implements Comparable
{
  public int a;
  public MessageForScribble a;
  
  ScribbleDownloadInfo(MessageForScribble paramMessageForScribble, int paramInt)
  {
    this.jdField_a_of_type_Int = 200;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble = paramMessageForScribble;
    if (paramInt >= 200)
    {
      this.jdField_a_of_type_Int = paramInt;
      return;
    }
    QLog.e("ScribbleDownloadInfo", 1, "err priority");
  }
  
  public int a(ScribbleDownloadInfo paramScribbleDownloadInfo)
  {
    if (this.jdField_a_of_type_Int < paramScribbleDownloadInfo.jdField_a_of_type_Int) {
      return -1;
    }
    if (this.jdField_a_of_type_Int > paramScribbleDownloadInfo.jdField_a_of_type_Int) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.scribble.ScribbleDownloadInfo
 * JD-Core Version:    0.7.0.1
 */