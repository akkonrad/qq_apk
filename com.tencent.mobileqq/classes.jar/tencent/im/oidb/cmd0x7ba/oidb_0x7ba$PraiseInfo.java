package tencent.im.oidb.cmd0x7ba;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x7ba$PraiseInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 80, 88, 96, 104 }, new String[] { "uint64_ddwuin", "uint32_praise_today_count", "uint32_rank_number", "uint32_praise_total_count" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, PraiseInfo.class);
  public final PBUInt32Field uint32_praise_today_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_praise_total_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_rank_number = PBField.initUInt32(0);
  public final PBUInt64Field uint64_ddwuin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x7ba.oidb_0x7ba.PraiseInfo
 * JD-Core Version:    0.7.0.1
 */