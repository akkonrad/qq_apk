package com.tencent.biz.qqstory.support.report;

import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqMonitorValue;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspMonitorValue;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class MonitorValueRequest
  extends NetworkRequest
{
  public String a;
  private int c;
  private int d;
  
  public BaseResponse a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspMonitorValue localRspMonitorValue = new qqstory_service.RspMonitorValue();
    try
    {
      localRspMonitorValue.mergeFrom(paramArrayOfByte);
      return new MonitorValueResponse(localRspMonitorValue);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte) {}
    return null;
  }
  
  public String a()
  {
    return StoryApi.a("StoryMonitorSvc.client_monitor_report");
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.c = paramInt1;
    this.d = paramInt2;
  }
  
  protected byte[] a()
  {
    qqstory_service.ReqMonitorValue localReqMonitorValue = new qqstory_service.ReqMonitorValue();
    localReqMonitorValue.ID.set(this.c);
    if (this.d > 0) {
      localReqMonitorValue.Value.set(this.d);
    }
    for (;;)
    {
      if (this.a != null) {
        localReqMonitorValue.errmsg.set(ByteStringMicro.copyFromUtf8(this.a));
      }
      return localReqMonitorValue.toByteArray();
      localReqMonitorValue.Value.set(1);
    }
  }
  
  public String toString()
  {
    return "MonitorValueRequest{ID=" + this.c + ", value=" + this.d + ", msg=" + this.a + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.support.report.MonitorValueRequest
 * JD-Core Version:    0.7.0.1
 */