package com.tencent.biz.pubaccount.readinjoy.model;

import java.io.Serializable;

public class ReadInJoyUserInfoModule$Request0xb81Params$AccountInfoReq
  implements Serializable
{
  private int accountType;
  private long uin;
  
  private ReadInJoyUserInfoModule$Request0xb81Params$AccountInfoReq(ReadInJoyUserInfoModule.Request0xb81Params.AccountInfoReq.AccountInfoBuilder paramAccountInfoBuilder)
  {
    this.accountType = ReadInJoyUserInfoModule.Request0xb81Params.AccountInfoReq.AccountInfoBuilder.a(paramAccountInfoBuilder);
    this.uin = ReadInJoyUserInfoModule.Request0xb81Params.AccountInfoReq.AccountInfoBuilder.a(paramAccountInfoBuilder);
  }
  
  public String toString()
  {
    return "AccountInfoReq, accountType = " + this.accountType + ", uin = " + this.uin + '\n';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule.Request0xb81Params.AccountInfoReq
 * JD-Core Version:    0.7.0.1
 */