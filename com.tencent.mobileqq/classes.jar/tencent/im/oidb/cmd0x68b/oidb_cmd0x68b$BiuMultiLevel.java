package tencent.im.oidb.cmd0x68b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0x68b$BiuMultiLevel
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32 }, new String[] { "rpt_biu_mutli_level", "uint64_origin_feeds_id", "uint64_origin_feeds_type", "enum_origin_verify_status" }, new Object[] { null, Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(2) }, BiuMultiLevel.class);
  public final PBEnumField enum_origin_verify_status = PBField.initEnum(2);
  public final PBRepeatMessageField rpt_biu_mutli_level = PBField.initRepeatMessage(oidb_cmd0x68b.BiuOneLevelItem.class);
  public final PBUInt64Field uint64_origin_feeds_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_origin_feeds_type = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.BiuMultiLevel
 * JD-Core Version:    0.7.0.1
 */