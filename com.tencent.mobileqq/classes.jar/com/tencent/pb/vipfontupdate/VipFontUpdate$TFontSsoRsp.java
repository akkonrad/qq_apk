package com.tencent.pb.vipfontupdate;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class VipFontUpdate$TFontSsoRsp
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42, 50, 82 }, new String[] { "i32_ret", "str_msg", "u32_cmd", "u64_seq", "st_fresh_rsp", "st_md5_check_rsp", "st_diyfont_rsp" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), Long.valueOf(0L), null, null, null }, TFontSsoRsp.class);
  public final PBInt32Field i32_ret = PBField.initInt32(0);
  public VipFontUpdate.TDiyFontRsp st_diyfont_rsp = new VipFontUpdate.TDiyFontRsp();
  public VipFontUpdate.TFontFreshRsp st_fresh_rsp = new VipFontUpdate.TFontFreshRsp();
  public VipFontUpdate.TFontMd5CheckRsp st_md5_check_rsp = new VipFontUpdate.TFontMd5CheckRsp();
  public final PBStringField str_msg = PBField.initString("");
  public final PBUInt32Field u32_cmd = PBField.initUInt32(0);
  public final PBUInt64Field u64_seq = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.pb.vipfontupdate.VipFontUpdate.TFontSsoRsp
 * JD-Core Version:    0.7.0.1
 */