package tencent.im.oidb.cmd0xa02;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class cmd0xa02$RspBody
  extends MessageMicro
{
  public static final int RPT_TINYID2USERACC_INFO_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_tinyid2useracc_info" }, new Object[] { null }, RspBody.class);
  public final PBRepeatMessageField rpt_tinyid2useracc_info = PBField.initRepeatMessage(cmd0xa02.TinyID2UserAccInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0xa02.cmd0xa02.RspBody
 * JD-Core Version:    0.7.0.1
 */