package tencent.im.oidb.cmd0xa80;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xa80$ReqGroupInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "uint64_group_code", "rpt_msg_member_info", "uint32_op" }, new Object[] { Long.valueOf(0L), null, Integer.valueOf(0) }, ReqGroupInfo.class);
  public final PBRepeatMessageField rpt_msg_member_info = PBField.initRepeatMessage(oidb_cmd0xa80.MemberInfo.class);
  public final PBUInt32Field uint32_op = PBField.initUInt32(0);
  public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0xa80.oidb_cmd0xa80.ReqGroupInfo
 * JD-Core Version:    0.7.0.1
 */