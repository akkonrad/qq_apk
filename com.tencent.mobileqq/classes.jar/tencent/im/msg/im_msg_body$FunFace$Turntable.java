package tencent.im.msg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class im_msg_body$FunFace$Turntable
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "rpt_uint64_uin_list", "uint64_hit_uin", "str_hit_uin_nick" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), "" }, Turntable.class);
  public final PBRepeatField rpt_uint64_uin_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBStringField str_hit_uin_nick = PBField.initString("");
  public final PBUInt64Field uint64_hit_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.msg.im_msg_body.FunFace.Turntable
 * JD-Core Version:    0.7.0.1
 */