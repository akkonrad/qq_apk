package tencent.im.cs.group_file_common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class group_file_common$FeedsResult
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "int32_ret_code", "str_detail", "str_file_id" }, new Object[] { Integer.valueOf(0), "", "" }, FeedsResult.class);
  public final PBInt32Field int32_ret_code = PBField.initInt32(0);
  public final PBStringField str_detail = PBField.initString("");
  public final PBStringField str_file_id = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.cs.group_file_common.group_file_common.FeedsResult
 * JD-Core Version:    0.7.0.1
 */