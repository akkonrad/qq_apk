package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.mobileqq.app.fms.MessageSearchUtils;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;

public class MessageForStructing
  extends MessageForRichText
{
  @notColumn
  public boolean bDynicMsg;
  public AbsStructMsg structingMsg;
  
  public MessageForStructing() {}
  
  public MessageForStructing(MessageRecord paramMessageRecord)
  {
    copyStructingMsg(paramMessageRecord);
    this.uniseq = paramMessageRecord.uniseq;
  }
  
  public void copyStructingMsg(MessageRecord paramMessageRecord)
  {
    this.extInt = paramMessageRecord.extInt;
    this.extLong = paramMessageRecord.extLong;
    this.extraflag = paramMessageRecord.extraflag;
    this.extStr = paramMessageRecord.extStr;
    this.frienduin = paramMessageRecord.frienduin;
    this.isread = paramMessageRecord.isread;
    this.issend = paramMessageRecord.issend;
    this.istroop = paramMessageRecord.istroop;
    this.isValid = paramMessageRecord.isValid;
    this.longMsgCount = paramMessageRecord.longMsgCount;
    this.longMsgId = paramMessageRecord.longMsgId;
    this.longMsgIndex = paramMessageRecord.longMsgIndex;
    this.msg = paramMessageRecord.msg;
    this.msgData = paramMessageRecord.msgData;
    this.msgseq = paramMessageRecord.msgseq;
    this.msgtype = paramMessageRecord.msgtype;
    this.msgUid = paramMessageRecord.msgUid;
    this.selfuin = paramMessageRecord.selfuin;
    this.senderuin = paramMessageRecord.senderuin;
    this.sendFailCode = paramMessageRecord.sendFailCode;
    this.shmsgseq = paramMessageRecord.shmsgseq;
    this.time = paramMessageRecord.time;
    this.versionCode = paramMessageRecord.versionCode;
    this.vipBubbleID = paramMessageRecord.vipBubbleID;
    this.structingMsg = StructMsgFactory.a(this.msgData);
  }
  
  protected void doParse()
  {
    if (!this.bDynicMsg) {
      this.structingMsg = StructMsgFactory.a(this.msgData);
    }
  }
  
  public void doPrewrite()
  {
    prewrite();
  }
  
  public String getContentForSearch()
  {
    String str2 = null;
    String str1 = str2;
    if (this.structingMsg != null)
    {
      boolean bool = MessageSearchUtils.a(String.valueOf(this.structingMsg.mMsgServiceID));
      str1 = str2;
      if ((this.structingMsg instanceof AbsShareMsg))
      {
        str1 = str2;
        if (bool)
        {
          str2 = ((AbsShareMsg)this.structingMsg).mContentTitle;
          str1 = str2;
          if (TextUtils.isEmpty(str2))
          {
            str1 = str2;
            if ((this.structingMsg instanceof AbsStructMsg)) {
              str1 = ((AbsShareMsg)this.structingMsg).mMsgBrief;
            }
          }
        }
      }
    }
    return str1;
  }
  
  public String getSummaryMsg()
  {
    if (this.structingMsg != null)
    {
      if (this.structingMsg.mMsgBrief != null) {
        return this.structingMsg.mMsgBrief;
      }
      return "";
    }
    return "";
  }
  
  public boolean isHotPicsStruct()
  {
    if (StructMsgForImageShare.class.isInstance(this.structingMsg)) {
      return ((StructMsgForImageShare)this.structingMsg).mImageBizType == 2;
    }
    return false;
  }
  
  public boolean isSupportFTS()
  {
    return MsgProxyUtils.v(this.istroop);
  }
  
  public boolean isSupportReply()
  {
    return true;
  }
  
  protected void postRead()
  {
    parse();
  }
  
  protected void prewrite()
  {
    if (this.structingMsg != null) {}
    try
    {
      if (!this.bDynicMsg) {
        this.msgData = this.structingMsg.getBytes();
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForStructing
 * JD-Core Version:    0.7.0.1
 */