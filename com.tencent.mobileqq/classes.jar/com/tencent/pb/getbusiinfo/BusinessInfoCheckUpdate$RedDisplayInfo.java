package com.tencent.pb.getbusiinfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class BusinessInfoCheckUpdate$RedDisplayInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "red_type_info", "tab_display_info" }, new Object[] { null, null }, RedDisplayInfo.class);
  public final PBRepeatMessageField red_type_info = PBField.initRepeatMessage(BusinessInfoCheckUpdate.RedTypeInfo.class);
  public BusinessInfoCheckUpdate.RedTypeInfo tab_display_info = new BusinessInfoCheckUpdate.RedTypeInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedDisplayInfo
 * JD-Core Version:    0.7.0.1
 */