package com.tencent.qidian.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class mobileqq_qidian$GetUserDetailInfoReqBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint32_req_type", "uint64_uin", "uint32_mobile_client" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0) }, GetUserDetailInfoReqBody.class);
  public final PBUInt32Field uint32_mobile_client = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.qidian.proto.mobileqq_qidian.GetUserDetailInfoReqBody
 * JD-Core Version:    0.7.0.1
 */