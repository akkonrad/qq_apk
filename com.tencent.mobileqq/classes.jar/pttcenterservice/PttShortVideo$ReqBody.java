package pttcenterservice;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class PttShortVideo$ReqBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 50, 802 }, new String[] { "uint32_cmd", "uint32_seq", "msg_PttShortVideoUpload_Req", "msg_PttShortVideoDownload_Req", "rpt_msg_short_video_retweet_req", "rpt_msg_short_video_delete_req", "rpt_msg_extension_req" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null, null, null, null, null }, ReqBody.class);
  public PttShortVideo.PttShortVideoDownloadReq msg_PttShortVideoDownload_Req = new PttShortVideo.PttShortVideoDownloadReq();
  public PttShortVideo.PttShortVideoUploadReq msg_PttShortVideoUpload_Req = new PttShortVideo.PttShortVideoUploadReq();
  public final PBRepeatMessageField rpt_msg_extension_req = PBField.initRepeatMessage(PttShortVideo.ExtensionReq.class);
  public final PBRepeatMessageField rpt_msg_short_video_delete_req = PBField.initRepeatMessage(PttShortVideo.PttShortVideoDeleteReq.class);
  public final PBRepeatMessageField rpt_msg_short_video_retweet_req = PBField.initRepeatMessage(PttShortVideo.PttShortVideoRetweetReq.class);
  public final PBUInt32Field uint32_cmd = PBField.initUInt32(0);
  public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     pttcenterservice.PttShortVideo.ReqBody
 * JD-Core Version:    0.7.0.1
 */