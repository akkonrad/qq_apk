package tencent.im.s2c.msgtype0x210.submsgtype0xc5;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class submsgtype0xc5$CommentInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_comment_content = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_comment_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_reply_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field uint64_comment_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_reply_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 16, 26, 32, 42, 50 }, new String[] { "uint64_comment_uin", "bytes_comment_id", "uint64_reply_uin", "bytes_reply_id", "bytes_comment_content" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, Long.valueOf(0L), localByteStringMicro2, localByteStringMicro3 }, CommentInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0xc5.submsgtype0xc5.CommentInfo
 * JD-Core Version:    0.7.0.1
 */