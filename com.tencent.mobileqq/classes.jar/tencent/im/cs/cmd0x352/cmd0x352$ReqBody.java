package tencent.im.cs.cmd0x352;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x352$ReqBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 80 }, new String[] { "uint32_subcmd", "rpt_msg_tryup_img_req", "rpt_msg_getimg_url_req", "uint32_net_type" }, new Object[] { Integer.valueOf(0), null, null, Integer.valueOf(0) }, ReqBody.class);
  public final PBRepeatMessageField rpt_msg_getimg_url_req = PBField.initRepeatMessage(cmd0x352.GetImgUrlReq.class);
  public final PBRepeatMessageField rpt_msg_tryup_img_req = PBField.initRepeatMessage(cmd0x352.TryUpImgReq.class);
  public final PBUInt32Field uint32_net_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_subcmd = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.cs.cmd0x352.cmd0x352.ReqBody
 * JD-Core Version:    0.7.0.1
 */