package tencent.im.group;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class group_member_info$RspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40 }, new String[] { "uint64_group_code", "uint32_self_role", "msg_meminfo", "bool_self_location_shared", "uint32_group_type" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), null, Boolean.valueOf(false), Integer.valueOf(0) }, RspBody.class);
  public final PBBoolField bool_self_location_shared = PBField.initBool(false);
  public group_member_info.MemberInfo msg_meminfo = new group_member_info.MemberInfo();
  public final PBUInt32Field uint32_group_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_self_role = PBField.initUInt32(0);
  public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.group.group_member_info.RspBody
 * JD-Core Version:    0.7.0.1
 */