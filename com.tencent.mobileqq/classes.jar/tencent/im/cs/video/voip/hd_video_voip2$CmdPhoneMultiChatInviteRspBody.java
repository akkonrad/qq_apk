package tencent.im.cs.video.voip;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class hd_video_voip2$CmdPhoneMultiChatInviteRspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_conf_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField msg_invite_fail_tel = PBField.initRepeatMessage(hd_video_voip2.TelInfo.class);
  public final PBRepeatMessageField msg_invite_succ_tel = PBField.initRepeatMessage(hd_video_voip2.TelInfo.class);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "bytes_conf_id", "msg_invite_fail_tel", "msg_invite_succ_tel" }, new Object[] { localByteStringMicro, null, null }, CmdPhoneMultiChatInviteRspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.cs.video.voip.hd_video_voip2.CmdPhoneMultiChatInviteRspBody
 * JD-Core Version:    0.7.0.1
 */