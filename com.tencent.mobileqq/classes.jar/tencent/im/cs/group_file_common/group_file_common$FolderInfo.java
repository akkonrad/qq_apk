package tencent.im.cs.group_file_common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class group_file_common$FolderInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 40, 48, 58, 64 }, new String[] { "str_folder_id", "str_parent_folder_id", "str_folder_name", "uint32_create_time", "uint32_modify_time", "uint64_create_uin", "str_creator_name", "uint32_total_file_count" }, new Object[] { "", "", "", Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), "", Integer.valueOf(0) }, FolderInfo.class);
  public final PBStringField str_creator_name = PBField.initString("");
  public final PBStringField str_folder_id = PBField.initString("");
  public final PBStringField str_folder_name = PBField.initString("");
  public final PBStringField str_parent_folder_id = PBField.initString("");
  public final PBUInt32Field uint32_create_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_modify_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_total_file_count = PBField.initUInt32(0);
  public final PBUInt64Field uint64_create_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.cs.group_file_common.group_file_common.FolderInfo
 * JD-Core Version:    0.7.0.1
 */