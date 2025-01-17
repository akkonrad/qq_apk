package tencent.im.cs.ptt_reserve;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ptt_reserve$ReserveStruct
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_general_flags = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_redpack_score_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_change_voice = PBField.initUInt32(0);
  public final PBUInt32Field uint32_color_text_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_redpack_type = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 40, 50 }, new String[] { "uint32_change_voice", "bytes_general_flags", "uint32_color_text_id", "uint32_redpack_type", "bytes_redpack_score_id" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2 }, ReserveStruct.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.cs.ptt_reserve.ptt_reserve.ReserveStruct
 * JD-Core Version:    0.7.0.1
 */