package tencent.im.oidb.cmd0x978;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0x978$OneFollowOperationResult
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "uint64_dst_uin", "uint32_op_account_type", "uint32_op_result", "enum_follow_status" }, new Object[] { Long.valueOf(0L), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0) }, OneFollowOperationResult.class);
  public final PBEnumField enum_follow_status = PBField.initEnum(0);
  public final PBEnumField uint32_op_account_type = PBField.initEnum(1);
  public final PBUInt32Field uint32_op_result = PBField.initUInt32(0);
  public final PBUInt64Field uint64_dst_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x978.oidb_cmd0x978.OneFollowOperationResult
 * JD-Core Version:    0.7.0.1
 */