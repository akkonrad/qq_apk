package com.tencent.mobileqq.streamtransfile;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ptt.PttBuffer;
import com.tencent.mobileqq.ptt.StreamParams;
import com.tencent.mobileqq.transfile.NetworkCenter;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class StreamFileInfo
{
  public final int a;
  public long a;
  private String jdField_a_of_type_JavaLangString;
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  private short jdField_a_of_type_Short;
  boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int;
  public long b;
  private short jdField_b_of_type_Short;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long;
  private short jdField_c_of_type_Short = 1;
  
  public StreamFileInfo(QQAppInterface paramQQAppInterface, int paramInt1, String paramString, int paramInt2)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_Int = StreamParams.a(paramQQAppInterface, paramInt1, NetworkCenter.a().a());
    PttBuffer.a(paramString);
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public File a()
  {
    return new File(this.jdField_a_of_type_JavaLangString);
  }
  
  public List a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public short a()
  {
    return this.jdField_b_of_type_Short;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Short = 0;
  }
  
  public void a(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.jdField_c_of_type_Long = paramLong;
  }
  
  public void a(short paramShort)
  {
    this.jdField_b_of_type_Short = paramShort;
  }
  
  public void a(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      PttBuffer.b(this.jdField_a_of_type_JavaLangString);
      return;
    }
    PttBuffer.a(this.jdField_a_of_type_JavaLangString);
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt)
  {
    PttBuffer.a(this.jdField_a_of_type_JavaLangString, paramArrayOfByte, paramInt);
  }
  
  public int b()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public short b()
  {
    return this.jdField_c_of_type_Short;
  }
  
  public void b(short paramShort)
  {
    this.jdField_c_of_type_Short = paramShort;
  }
  
  public short c()
  {
    return this.jdField_a_of_type_Short;
  }
  
  public void c(short paramShort)
  {
    this.jdField_a_of_type_Short = paramShort;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.streamtransfile.StreamFileInfo
 * JD-Core Version:    0.7.0.1
 */