package com.tencent.mobileqq.ar.arengine;

import com.tencent.YTFace.model.FaceStatus;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class ARCloudRecogRspFaceResult
{
  public int a;
  public String a;
  public ArrayList a;
  public FaceStatus[] a;
  public int b;
  public String b;
  public int c;
  public String c;
  public int d;
  
  public static boolean a(ARCloudRecogRspFaceResult paramARCloudRecogRspFaceResult)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramARCloudRecogRspFaceResult != null)
    {
      bool1 = bool2;
      if (paramARCloudRecogRspFaceResult.jdField_a_of_type_Int == 0)
      {
        bool1 = bool2;
        if (paramARCloudRecogRspFaceResult.jdField_b_of_type_Int == 0) {
          bool1 = true;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ARRspFaceResult", 2, "[ScanStarFace]isRecogSuccess result = " + bool1);
    }
    return bool1;
  }
  
  public String toString()
  {
    return "ARCloudRecogRspFaceResult{errCode_MQ=" + this.jdField_a_of_type_Int + ", errMsg_MQ='" + this.jdField_a_of_type_JavaLangString + '\'' + ", errCode_YT=" + this.jdField_b_of_type_Int + ", errMsg_YT=" + this.jdField_b_of_type_JavaLangString + ", time_ms_YT=" + this.jdField_c_of_type_Int + ", group_size_YT=" + this.d + ", sessionID='" + this.jdField_c_of_type_JavaLangString + '\'' + ", starInfoList=" + this.jdField_a_of_type_JavaUtilArrayList + ", faceStatus[]=" + this.jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARCloudRecogRspFaceResult
 * JD-Core Version:    0.7.0.1
 */