package tencent.im.s2c.msgtype0x210.submsgtype0xc5;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class submsgtype0xc5$NotifyBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 82, 90, 98 }, new String[] { "msg_style_sheet", "msg_comment_article", "msg_like_article", "msg_bb_info" }, new Object[] { null, null, null, null }, NotifyBody.class);
  public submsgtype0xc5.BBInfo msg_bb_info = new submsgtype0xc5.BBInfo();
  public submsgtype0xc5.CommentInfo msg_comment_article = new submsgtype0xc5.CommentInfo();
  public submsgtype0xc5.LikeInfo msg_like_article = new submsgtype0xc5.LikeInfo();
  public submsgtype0xc5.StyleSheet msg_style_sheet = new submsgtype0xc5.StyleSheet();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0xc5.submsgtype0xc5.NotifyBody
 * JD-Core Version:    0.7.0.1
 */