package tencent.im.oidb.cmd0x5e3;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x5e3$QQLoginSig
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_sig = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32 }, new String[] { "uint64_uin", "uint32_type", "bytes_sig", "uint32_appid" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0) }, QQLoginSig.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x5e3.oidb_0x5e3.QQLoginSig
 * JD-Core Version:    0.7.0.1
 */