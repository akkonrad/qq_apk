package com.tencent.mobileqq.ar;

import com.tencent.mobileqq.transfile.HttpNetReq;

public class ArResourceDownload$DownloadInfo
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  HttpNetReq jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int;
  long jdField_b_of_type_Long;
  String jdField_b_of_type_JavaLangString;
  boolean jdField_b_of_type_Boolean = false;
  String c;
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("DownloadInfo{");
    localStringBuffer.append("type=").append(this.jdField_a_of_type_Int);
    localStringBuffer.append(", url='").append(this.jdField_a_of_type_JavaLangString).append('\'');
    localStringBuffer.append(", md5='").append(this.jdField_b_of_type_JavaLangString).append('\'');
    localStringBuffer.append(", fileName='").append(this.c).append('\'');
    localStringBuffer.append(", fileSize=").append(this.jdField_a_of_type_Long);
    localStringBuffer.append(", downloadSize=").append(this.jdField_b_of_type_Long);
    localStringBuffer.append(", req=").append(this.jdField_a_of_type_Boolean);
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ArResourceDownload.DownloadInfo
 * JD-Core Version:    0.7.0.1
 */