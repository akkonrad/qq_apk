package tencent.qun.group_effect;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class group_effect_commu$TSetSwitchReq0x10
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "group_id", "forbid_self" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, TSetSwitchReq0x10.class);
  public final PBUInt64Field forbid_self = PBField.initUInt64(0L);
  public final PBUInt64Field group_id = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     tencent.qun.group_effect.group_effect_commu.TSetSwitchReq0x10
 * JD-Core Version:    0.7.0.1
 */