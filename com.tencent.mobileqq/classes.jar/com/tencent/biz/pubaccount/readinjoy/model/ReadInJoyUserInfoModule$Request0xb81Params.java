package com.tencent.biz.pubaccount.readinjoy.model;

import java.util.List;

public class ReadInJoyUserInfoModule$Request0xb81Params
{
  private int jdField_a_of_type_Int;
  private List jdField_a_of_type_JavaUtilList;
  private int b;
  private int c;
  private int d;
  
  private ReadInJoyUserInfoModule$Request0xb81Params(ReadInJoyUserInfoModule.Request0xb81Params.Builder paramBuilder)
  {
    this.jdField_a_of_type_Int = ReadInJoyUserInfoModule.Request0xb81Params.Builder.a(paramBuilder);
    this.b = ReadInJoyUserInfoModule.Request0xb81Params.Builder.b(paramBuilder);
    this.c = ReadInJoyUserInfoModule.Request0xb81Params.Builder.c(paramBuilder);
    this.d = ReadInJoyUserInfoModule.Request0xb81Params.Builder.d(paramBuilder);
    this.jdField_a_of_type_JavaUtilList = ReadInJoyUserInfoModule.Request0xb81Params.Builder.a(paramBuilder);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("Request0xb81Params, \nreqClientType = " + this.jdField_a_of_type_Int + '\n' + "nick = " + this.b + '\n' + "headUrl = " + this.c + '\n' + "infoPriority = " + this.d + '\n');
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      localStringBuilder.append("accountInfoReqs = \n");
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        localStringBuilder.append("[").append(i).append("] ").append(((ReadInJoyUserInfoModule.Request0xb81Params.AccountInfoReq)this.jdField_a_of_type_JavaUtilList.get(i)).toString());
        i += 1;
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule.Request0xb81Params
 * JD-Core Version:    0.7.0.1
 */