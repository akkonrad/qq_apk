package tencent.qun.group_effect;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class group_effect_commu$TGetEffectDetailReq0x1
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "effect_id" }, new Object[] { Long.valueOf(0L) }, TGetEffectDetailReq0x1.class);
  public final PBRepeatField effect_id = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     tencent.qun.group_effect.group_effect_commu.TGetEffectDetailReq0x1
 * JD-Core Version:    0.7.0.1
 */