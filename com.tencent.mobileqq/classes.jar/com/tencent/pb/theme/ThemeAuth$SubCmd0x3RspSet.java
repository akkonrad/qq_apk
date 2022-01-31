package com.tencent.pb.theme;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class ThemeAuth$SubCmd0x3RspSet
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "int32_result", "uint32_theme_id", "uint32_suit_id", "str_diy_theme_err_msg" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "" }, SubCmd0x3RspSet.class);
  public final PBInt32Field int32_result = PBField.initInt32(0);
  public final PBStringField str_diy_theme_err_msg = PBField.initString("");
  public final PBInt32Field uint32_suit_id = PBField.initInt32(0);
  public final PBInt32Field uint32_theme_id = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.pb.theme.ThemeAuth.SubCmd0x3RspSet
 * JD-Core Version:    0.7.0.1
 */