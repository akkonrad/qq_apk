package tencent.im.oidb.cmd0x8f9;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x8f9$GetLatestNodeInfoRsp
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_err_msg = PBField.initBytes(ByteStringMicro.EMPTY);
  public oidb_0x8f9.LiteMailBrief msg_litemail_brief = new oidb_0x8f9.LiteMailBrief();
  public oidb_0x8f9.UnreadMailCountInfo msg_unread_cnt_info = new oidb_0x8f9.UnreadMailCountInfo();
  public final PBUInt32Field uint32_result = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "uint32_result", "bytes_err_msg", "msg_litemail_brief", "msg_unread_cnt_info" }, new Object[] { Integer.valueOf(0), localByteStringMicro, null, null }, GetLatestNodeInfoRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8f9.oidb_0x8f9.GetLatestNodeInfoRsp
 * JD-Core Version:    0.7.0.1
 */