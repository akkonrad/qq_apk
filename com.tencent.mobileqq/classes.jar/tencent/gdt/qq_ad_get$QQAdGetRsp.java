package tencent.gdt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class qq_ad_get$QQAdGetRsp
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42 }, new String[] { "ret", "msg", "pos_ads_info", "gdt_cookie", "busi_cookie" }, new Object[] { Integer.valueOf(0), "", null, "", "" }, QQAdGetRsp.class);
  public final PBStringField busi_cookie = PBField.initString("");
  public final PBStringField gdt_cookie = PBField.initString("");
  public final PBStringField msg = PBField.initString("");
  public final PBRepeatMessageField pos_ads_info = PBField.initRepeatMessage(qq_ad_get.QQAdGetRsp.PosAdInfo.class);
  public final PBInt32Field ret = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     tencent.gdt.qq_ad_get.QQAdGetRsp
 * JD-Core Version:    0.7.0.1
 */