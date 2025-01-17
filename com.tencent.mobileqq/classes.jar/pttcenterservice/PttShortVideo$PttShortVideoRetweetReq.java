package pttcenterservice;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class PttShortVideo$PttShortVideoRetweetReq
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 66, 72, 82, 88 }, new String[] { "uint64_from_uin", "uint64_to_uin", "uint32_from_chat_type", "uint32_to_chat_type", "uint32_from_busi_type", "uint32_to_busi_type", "uint32_client_type", "msg_PttShortVideoFileInfo", "uint32_agent_type", "str_fileid", "uint64_group_code" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), "", Long.valueOf(0L) }, PttShortVideoRetweetReq.class);
  public PttShortVideo.PttShortVideoFileInfo msg_PttShortVideoFileInfo = new PttShortVideo.PttShortVideoFileInfo();
  public final PBStringField str_fileid = PBField.initString("");
  public final PBUInt32Field uint32_agent_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_client_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_from_busi_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_from_chat_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_to_busi_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_to_chat_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_to_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     pttcenterservice.PttShortVideo.PttShortVideoRetweetReq
 * JD-Core Version:    0.7.0.1
 */