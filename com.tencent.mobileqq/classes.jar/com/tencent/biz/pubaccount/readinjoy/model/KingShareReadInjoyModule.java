package com.tencent.biz.pubaccount.readinjoy.model;

import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyMSFService;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyOidbHelper;
import com.tencent.biz.pubaccount.readinjoy.struct.KingMomentInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ExecutorService;
import lrm;
import tencent.im.oidb.cmd0xa70.oidb_cmd0xa70.ReqBody;
import tencent.im.oidb.cmd0xa70.oidb_cmd0xa70.RspBody;
import tencent.im.oidb.cmd0xa70.oidb_cmd0xa70.VideoReqInfo;
import tencent.im.oidb.cmd0xa70.oidb_cmd0xa70.VideoRspInfo;

public class KingShareReadInjoyModule
  extends ReadInJoyEngineModule
{
  public KingShareReadInjoyModule(AppInterface paramAppInterface, EntityManager paramEntityManager, ExecutorService paramExecutorService, ReadInJoyMSFService paramReadInJoyMSFService, Handler paramHandler)
  {
    super(paramAppInterface, paramEntityManager, paramExecutorService, paramReadInJoyMSFService, paramHandler);
    if (QLog.isColorLevel()) {
      QLog.d("KingShareReadInjoyModule", 2, "construct!");
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xa70")) {
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("KingShareReadInjoyModule", 2, "get king moment ,url =" + paramString1);
    }
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong(paramString2);
      l1 = l2;
    }
    catch (Exception paramString2)
    {
      label42:
      oidb_cmd0xa70.VideoReqInfo localVideoReqInfo;
      break label42;
    }
    paramString2 = new oidb_cmd0xa70.ReqBody();
    paramString2.uint64_uin.set(l1);
    localVideoReqInfo = new oidb_cmd0xa70.VideoReqInfo();
    localVideoReqInfo.bytes_wangzhe_share_url.set(ByteStringMicro.copyFromUtf8(paramString1));
    paramString2.msg_video_req_info.set(localVideoReqInfo);
    a(ReadInJoyOidbHelper.a("OidbSvc.0xa70", 2672, 0, paramString2.toByteArray()));
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("KingShareReadInjoyModule", 2, "handle 0xa70 get king moment info");
    }
    paramToServiceMsg = new oidb_cmd0xa70.RspBody();
    int i = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, paramToServiceMsg);
    paramFromServiceMsg = new KingMomentInfo();
    paramFromServiceMsg.jdField_a_of_type_Int = ((oidb_cmd0xa70.VideoRspInfo)paramToServiceMsg.msg_video_rsp_info.get()).uint32_business_id.get();
    paramFromServiceMsg.jdField_a_of_type_JavaLangString = ((oidb_cmd0xa70.VideoRspInfo)paramToServiceMsg.msg_video_rsp_info.get()).bytes_business_name.get().toStringUtf8();
    paramFromServiceMsg.jdField_b_of_type_JavaLangString = ((oidb_cmd0xa70.VideoRspInfo)paramToServiceMsg.msg_video_rsp_info.get()).bytes_business_url.get().toStringUtf8();
    paramFromServiceMsg.jdField_c_of_type_JavaLangString = ((oidb_cmd0xa70.VideoRspInfo)paramToServiceMsg.msg_video_rsp_info.get()).bytes_business_name_prefix.get().toStringUtf8();
    paramFromServiceMsg.jdField_d_of_type_JavaLangString = ((oidb_cmd0xa70.VideoRspInfo)paramToServiceMsg.msg_video_rsp_info.get()).bytes_title.get().toStringUtf8();
    paramFromServiceMsg.jdField_e_of_type_JavaLangString = ((oidb_cmd0xa70.VideoRspInfo)paramToServiceMsg.msg_video_rsp_info.get()).bytes_desc.get().toStringUtf8();
    paramFromServiceMsg.f = ((oidb_cmd0xa70.VideoRspInfo)paramToServiceMsg.msg_video_rsp_info.get()).bytes_uuid.get().toStringUtf8();
    paramFromServiceMsg.g = ((oidb_cmd0xa70.VideoRspInfo)paramToServiceMsg.msg_video_rsp_info.get()).bytes_video_url.get().toStringUtf8();
    paramFromServiceMsg.h = ((oidb_cmd0xa70.VideoRspInfo)paramToServiceMsg.msg_video_rsp_info.get()).bytes_pic_url.get().toStringUtf8();
    paramFromServiceMsg.jdField_c_of_type_Int = ((oidb_cmd0xa70.VideoRspInfo)paramToServiceMsg.msg_video_rsp_info.get()).uint32_pic_width.get();
    paramFromServiceMsg.jdField_b_of_type_Int = ((oidb_cmd0xa70.VideoRspInfo)paramToServiceMsg.msg_video_rsp_info.get()).uint32_pic_height.get();
    paramFromServiceMsg.jdField_e_of_type_Int = paramFromServiceMsg.jdField_c_of_type_Int;
    paramFromServiceMsg.jdField_d_of_type_Int = paramFromServiceMsg.jdField_b_of_type_Int;
    paramFromServiceMsg.jdField_a_of_type_Long = ((oidb_cmd0xa70.VideoRspInfo)paramToServiceMsg.msg_video_rsp_info.get()).uint64_duration.get();
    this.a.post(new lrm(this, i, paramFromServiceMsg));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.KingShareReadInjoyModule
 * JD-Core Version:    0.7.0.1
 */