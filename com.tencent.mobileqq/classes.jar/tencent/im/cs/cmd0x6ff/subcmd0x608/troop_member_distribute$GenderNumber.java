package tencent.im.cs.cmd0x6ff.subcmd0x608;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class troop_member_distribute$GenderNumber
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint32_man_number", "uint32_woman_number", "uint32_unknow_number" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, GenderNumber.class);
  public final PBUInt32Field uint32_man_number = PBField.initUInt32(0);
  public final PBUInt32Field uint32_unknow_number = PBField.initUInt32(0);
  public final PBUInt32Field uint32_woman_number = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.cs.cmd0x6ff.subcmd0x608.troop_member_distribute.GenderNumber
 * JD-Core Version:    0.7.0.1
 */