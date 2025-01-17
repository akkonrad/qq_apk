package tencent.im.oidb.cmd0x6d8;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x6d8$GetFileListReqBody
  extends MessageMicro
{
  public static final int SORT_BY_FILETYPE = 2;
  public static final int SORT_BY_TIMESTAMP = 1;
  public static final int SORT_BY_UPLOADER = 3;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_context = PBField.initBytes(ByteStringMicro.EMPTY);
  public oidb_0x6d8.FileTimeStamp max_timestamp = new oidb_0x6d8.FileTimeStamp();
  public oidb_0x6d8.FileTimeStamp start_timestamp = new oidb_0x6d8.FileTimeStamp();
  public final PBStringField str_folder_id = PBField.initString("");
  public final PBUInt32Field uint32_all_file_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_app_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_client_version = PBField.initUInt32(0);
  public final PBUInt32Field uint32_field_flag = PBField.initUInt32(16777215);
  public final PBUInt32Field uint32_file_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_filter_code = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_from = PBField.initUInt32(0);
  public final PBUInt32Field uint32_sort_by = PBField.initUInt32(0);
  public final PBUInt32Field uint32_start_index = PBField.initUInt32(0);
  public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40, 50, 56, 64, 72, 80, 88, 96, 104, 114, 120 }, new String[] { "uint64_group_code", "uint32_app_id", "str_folder_id", "start_timestamp", "uint32_file_count", "max_timestamp", "uint32_all_file_count", "uint32_req_from", "uint32_sort_by", "uint32_filter_code", "uint64_uin", "uint32_field_flag", "uint32_start_index", "bytes_context", "uint32_client_version" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), "", null, Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(16777215), Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0) }, GetFileListReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x6d8.oidb_0x6d8.GetFileListReqBody
 * JD-Core Version:    0.7.0.1
 */