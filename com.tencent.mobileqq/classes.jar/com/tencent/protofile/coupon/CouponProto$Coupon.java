package com.tencent.protofile.coupon;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class CouponProto$Coupon
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40, 48, 56, 66, 74, 80, 88, 98, 106, 114, 122, 128, 136, 146, 152, 160, 168 }, new String[] { "cid", "bid", "name", "detail", "stime", "etime", "veri_type", "pic", "tag", "shids", "is_valid", "usage", "rebate", "qrcode", "qlife_url", "source_id", "rcv_time", "tips", "rcv_limit", "rcv_count", "is_readdable" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", "", Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), "", "", "", "", Integer.valueOf(0), Long.valueOf(0L), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, Coupon.class);
  public final PBUInt32Field bid = PBField.initUInt32(0);
  public final PBUInt32Field cid = PBField.initUInt32(0);
  public final PBStringField detail = PBField.initString("");
  public final PBUInt64Field etime = PBField.initUInt64(0L);
  public final PBUInt32Field is_readdable = PBField.initUInt32(0);
  public final PBUInt32Field is_valid = PBField.initUInt32(0);
  public final PBStringField name = PBField.initString("");
  public final PBStringField pic = PBField.initString("");
  public final PBStringField qlife_url = PBField.initString("");
  public final PBStringField qrcode = PBField.initString("");
  public final PBUInt32Field rcv_count = PBField.initUInt32(0);
  public final PBUInt32Field rcv_limit = PBField.initUInt32(0);
  public final PBUInt64Field rcv_time = PBField.initUInt64(0L);
  public final PBStringField rebate = PBField.initString("");
  public final PBRepeatField shids = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBUInt32Field source_id = PBField.initUInt32(0);
  public final PBUInt64Field stime = PBField.initUInt64(0L);
  public final PBStringField tag = PBField.initString("");
  public final PBStringField tips = PBField.initString("");
  public final PBStringField usage = PBField.initString("");
  public final PBUInt32Field veri_type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.protofile.coupon.CouponProto.Coupon
 * JD-Core Version:    0.7.0.1
 */