package com.tencent.mobileqq.ar.arengine;

public class ARCloudMarkerRecogResult$ImageTag
{
  public float a;
  public int a;
  public String a;
  public byte[] a;
  public int b;
  public String b;
  public int c = -1;
  
  public ARCloudMarkerRecogResult$ImageTag()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Float = 0.0F;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_ArrayOfByte = null;
  }
  
  public String toString()
  {
    try
    {
      String str1 = new String(this.jdField_a_of_type_ArrayOfByte, "utf-8");
      return "ImageTag{imageId = " + this.jdField_a_of_type_JavaLangString + ", tagName = " + this.jdField_b_of_type_JavaLangString + ", tagConfidence = " + this.jdField_a_of_type_Int + ", tagConfidence_f = " + this.jdField_a_of_type_Float + ", need_check_lbs = " + this.jdField_b_of_type_Int + ", cdbRetCode = " + this.c + ", cdbRes = " + str1 + '}';
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str2 = "";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARCloudMarkerRecogResult.ImageTag
 * JD-Core Version:    0.7.0.1
 */