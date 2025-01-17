package tencent.im.oidb.cmd0x68b;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0x68b$PosAdInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_msg = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField enum_pos_layout = PBField.initEnum(0);
  public final PBInt32Field int32_ret = PBField.initInt32(0);
  public oidb_cmd0x68b.AdInfo msg_ad_info = new oidb_cmd0x68b.AdInfo();
  public final PBUInt64Field uint64_pos_id = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42 }, new String[] { "int32_ret", "bytes_msg", "enum_pos_layout", "uint64_pos_id", "msg_ad_info" }, new Object[] { Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0), Long.valueOf(0L), null }, PosAdInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.PosAdInfo
 * JD-Core Version:    0.7.0.1
 */