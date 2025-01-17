package tencent.im.oidb.cmd0xad6;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xad6$ReqArticle
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_article_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_row_key = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field uint64_prev_version = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_public_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 96 }, new String[] { "bytes_url", "uint64_public_uin", "bytes_article_id", "bytes_row_key", "uint64_prev_version" }, new Object[] { localByteStringMicro1, Long.valueOf(0L), localByteStringMicro2, localByteStringMicro3, Long.valueOf(0L) }, ReqArticle.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0xad6.oidb_cmd0xad6.ReqArticle
 * JD-Core Version:    0.7.0.1
 */