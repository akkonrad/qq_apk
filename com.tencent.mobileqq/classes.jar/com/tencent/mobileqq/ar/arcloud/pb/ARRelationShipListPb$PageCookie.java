package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ARRelationShipListPb$PageCookie
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_my_send_start_idx", "uint32_my_recv_start_idx" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, PageCookie.class);
  public final PBUInt32Field uint32_my_recv_start_idx = PBField.initUInt32(0);
  public final PBUInt32Field uint32_my_send_start_idx = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arcloud.pb.ARRelationShipListPb.PageCookie
 * JD-Core Version:    0.7.0.1
 */