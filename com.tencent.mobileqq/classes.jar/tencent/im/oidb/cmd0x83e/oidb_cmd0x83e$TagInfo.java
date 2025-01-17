package tencent.im.oidb.cmd0x83e;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0x83e$TagInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_tag_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBDoubleField double_tag_score = PBField.initDouble(0.0D);
  public final PBUInt64Field uint64_channel = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_tag_id = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 25, 32 }, new String[] { "uint64_tag_id", "bytes_tag_name", "double_tag_score", "uint64_channel" }, new Object[] { Long.valueOf(0L), localByteStringMicro, Double.valueOf(0.0D), Long.valueOf(0L) }, TagInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x83e.oidb_cmd0x83e.TagInfo
 * JD-Core Version:    0.7.0.1
 */