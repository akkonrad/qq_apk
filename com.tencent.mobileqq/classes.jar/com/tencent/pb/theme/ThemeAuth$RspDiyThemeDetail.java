package com.tencent.pb.theme;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class ThemeAuth$RspDiyThemeDetail
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "drawer_tab_detail", "message_tab_detail", "aio_tab_detail" }, new Object[] { null, null, null }, RspDiyThemeDetail.class);
  public ThemeAuth.DiyThemeDetail aio_tab_detail = new ThemeAuth.DiyThemeDetail();
  public ThemeAuth.DiyThemeDetail drawer_tab_detail = new ThemeAuth.DiyThemeDetail();
  public ThemeAuth.DiyThemeDetail message_tab_detail = new ThemeAuth.DiyThemeDetail();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.pb.theme.ThemeAuth.RspDiyThemeDetail
 * JD-Core Version:    0.7.0.1
 */