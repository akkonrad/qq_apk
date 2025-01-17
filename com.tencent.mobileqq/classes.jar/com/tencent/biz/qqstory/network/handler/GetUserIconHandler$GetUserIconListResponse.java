package com.tencent.biz.qqstory.network.handler;

import android.os.Bundle;
import com.tencent.biz.qqstory.comment.lego.LegoResponseBase;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspIconPostfix;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import nfq;

public class GetUserIconHandler$GetUserIconListResponse
  extends LegoResponseBase
{
  public qqstory_service.RspIconPostfix a;
  
  public GetUserIconHandler$GetUserIconListResponse(GetUserIconHandler paramGetUserIconHandler) {}
  
  public GetUserIconHandler$GetUserIconListResponse(GetUserIconHandler paramGetUserIconHandler, qqstory_service.RspIconPostfix paramRspIconPostfix)
  {
    super(paramRspIconPostfix.result);
    this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$RspIconPostfix = paramRspIconPostfix;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$RspIconPostfix.icon_info.has()) && (this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$RspIconPostfix.icon_info.size() > 0)) {
      Bosses.get().postJob(new nfq(this));
    }
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.e("GetUserIconHandler", 2, "GetUserIconListResponse onNetError errorCode " + paramInt);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.e("GetUserIconHandler", 2, "GetUserIconListResponse errorCode:" + paramInt + " errorMsg:" + paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.GetUserIconHandler.GetUserIconListResponse
 * JD-Core Version:    0.7.0.1
 */