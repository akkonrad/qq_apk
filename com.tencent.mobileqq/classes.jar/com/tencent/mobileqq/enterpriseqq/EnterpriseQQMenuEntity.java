package com.tencent.mobileqq.enterpriseqq;

import com.tencent.crmqq.structmsg.StructMsg.GetCRMMenuResponse;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class EnterpriseQQMenuEntity
  extends Entity
{
  public byte[] data;
  public long savedDateTime;
  public int seqno;
  @unique
  public String uin;
  
  public EnterpriseQQMenuEntity() {}
  
  public EnterpriseQQMenuEntity(String paramString, StructMsg.GetCRMMenuResponse paramGetCRMMenuResponse, int paramInt, long paramLong)
  {
    this.uin = paramString;
    this.data = paramGetCRMMenuResponse.toByteArray();
    this.seqno = paramInt;
    this.savedDateTime = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.enterpriseqq.EnterpriseQQMenuEntity
 * JD-Core Version:    0.7.0.1
 */