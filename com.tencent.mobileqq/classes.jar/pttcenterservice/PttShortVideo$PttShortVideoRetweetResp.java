package pttcenterservice;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class PttShortVideo$PttShortVideoRetweetResp
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_ukey = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field int32_ret_code = PBField.initInt32(0);
  public final PBRepeatMessageField rpt_data_hole = PBField.initRepeatMessage(PttShortVideo.DataHole.class);
  public final PBRepeatMessageField rpt_diff_area_inner_addr = PBField.initRepeatMessage(PttShortVideo.PttShortVideoIpList.class);
  public final PBRepeatMessageField rpt_diff_area_out_addr = PBField.initRepeatMessage(PttShortVideo.PttShortVideoIpList.class);
  public final PBRepeatMessageField rpt_same_area_inner_addr = PBField.initRepeatMessage(PttShortVideo.PttShortVideoIpList.class);
  public final PBRepeatMessageField rpt_same_area_out_addr = PBField.initRepeatMessage(PttShortVideo.PttShortVideoIpList.class);
  public final PBStringField str_fileid = PBField.initString("");
  public final PBStringField str_ret_msg = PBField.initString("");
  public final PBUInt32Field uint32_file_exist = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_hot_file = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 56, 66, 74, 82, 88 }, new String[] { "int32_ret_code", "str_ret_msg", "rpt_same_area_out_addr", "rpt_diff_area_out_addr", "str_fileid", "bytes_ukey", "uint32_file_exist", "rpt_same_area_inner_addr", "rpt_diff_area_inner_addr", "rpt_data_hole", "uint32_is_hot_file" }, new Object[] { Integer.valueOf(0), "", null, null, "", localByteStringMicro, Integer.valueOf(0), null, null, null, Integer.valueOf(0) }, PttShortVideoRetweetResp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     pttcenterservice.PttShortVideo.PttShortVideoRetweetResp
 * JD-Core Version:    0.7.0.1
 */