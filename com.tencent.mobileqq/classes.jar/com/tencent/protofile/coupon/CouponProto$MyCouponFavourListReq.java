package com.tencent.protofile.coupon;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class CouponProto$MyCouponFavourListReq
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "ts", "stype" }, new Object[] { Long.valueOf(0L), "" }, MyCouponFavourListReq.class);
  public final PBStringField stype = PBField.initString("");
  public final PBUInt64Field ts = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.protofile.coupon.CouponProto.MyCouponFavourListReq
 * JD-Core Version:    0.7.0.1
 */