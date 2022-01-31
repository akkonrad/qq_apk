package com.tencent.mobileqq.apollo.process.data;

import com.tencent.mobileqq.apollo.view.ApolloPanel.GameMsgInfo;
import com.tencent.qphone.base.util.QLog;

public class CmGameMessageInfo
  extends ApolloPanel.GameMsgInfo
{
  public int a;
  public long a;
  public String a;
  public int b;
  public String b;
  public int c;
  public String c;
  public int d = 3;
  
  public void a()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("gameId:").append(this.jdField_a_of_type_Int).append(",roomId:").append(this.jdField_a_of_type_Long).append(",actionId:").append(this.jdField_b_of_type_Int).append(",gameName:").append(this.jdField_b_of_type_JavaLangString).append(",wording:").append(",imgType:");
      QLog.d("CmGameMessageInfo", 2, localStringBuilder.toString());
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_c_of_type_Int = 0;
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.d = 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.data.CmGameMessageInfo
 * JD-Core Version:    0.7.0.1
 */