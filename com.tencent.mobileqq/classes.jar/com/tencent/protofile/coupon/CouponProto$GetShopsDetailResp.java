package com.tencent.protofile.coupon;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class CouponProto$GetShopsDetailResp
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "retcode", "shops" }, new Object[] { Integer.valueOf(0), null }, GetShopsDetailResp.class);
  public final PBUInt32Field retcode = PBField.initUInt32(0);
  public final PBRepeatMessageField shops = PBField.initRepeatMessage(CouponProto.Shop.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.protofile.coupon.CouponProto.GetShopsDetailResp
 * JD-Core Version:    0.7.0.1
 */