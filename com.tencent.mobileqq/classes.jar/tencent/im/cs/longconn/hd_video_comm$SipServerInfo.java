package tencent.im.cs.longconn;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class hd_video_comm$SipServerInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_domain = PBField.initBytes(ByteStringMicro.EMPTY);
  public hd_video_comm.PstnMobileInfo msg_caller_phone = new hd_video_comm.PstnMobileInfo();
  public hd_video_comm.NetAddr msg_sip_addr = new hd_video_comm.NetAddr();
  public final PBRepeatField rpt_uint32_dtmf_mode = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBUInt32Field uint32_encode_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_provider_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_srtp_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_tls_flag = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32, 40, 50, 56, 64 }, new String[] { "msg_sip_addr", "uint32_provider_id", "msg_caller_phone", "uint32_encode_type", "uint32_tls_flag", "bytes_domain", "uint32_srtp_flag", "rpt_uint32_dtmf_mode" }, new Object[] { null, Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0) }, SipServerInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.cs.longconn.hd_video_comm.SipServerInfo
 * JD-Core Version:    0.7.0.1
 */