package com.tencent.mobileqq.audiotrans;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class AudioTransClientInterface$IntC2SJoinSessionReq
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56 }, new String[] { "uint32_client_ver", "enum_term", "enum_net_type", "uint32_client_port", "enum_business_direction", "enum_data_source", "bool_translate" }, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(1), Boolean.valueOf(false) }, IntC2SJoinSessionReq.class);
  public final PBBoolField bool_translate = PBField.initBool(false);
  public final PBEnumField enum_business_direction = PBField.initEnum(1);
  public final PBEnumField enum_data_source = PBField.initEnum(1);
  public final PBEnumField enum_net_type = PBField.initEnum(1);
  public final PBEnumField enum_term = PBField.initEnum(1);
  public final PBUInt32Field uint32_client_port = PBField.initUInt32(0);
  public final PBUInt32Field uint32_client_ver = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.audiotrans.AudioTransClientInterface.IntC2SJoinSessionReq
 * JD-Core Version:    0.7.0.1
 */