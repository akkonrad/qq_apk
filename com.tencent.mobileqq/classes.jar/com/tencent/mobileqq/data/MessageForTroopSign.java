package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemCover;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout2;
import com.tencent.mobileqq.structmsg.view.StructMsgItemSummary;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class MessageForTroopSign
  extends MessageForStructing
{
  public static final String TAG = "MessageForTroopSign";
  public String dynamicSource;
  public String markDesc;
  public String markIconUrl;
  public int markType;
  public String markWord;
  public String msgAction;
  public String msgBrief;
  public String msgContent;
  public String msgCoverUrl;
  public String msgTitle;
  public int positonType;
  public String srcAction;
  public String srcIconUrl;
  public String srcName;
  
  public void doParse()
  {
    super.doParse();
    Object localObject1 = (StructMsgForGeneralShare)this.structingMsg;
    this.srcName = ((StructMsgForGeneralShare)localObject1).mSourceName;
    this.srcAction = ((StructMsgForGeneralShare)localObject1).mSourceUrl;
    this.srcIconUrl = ((StructMsgForGeneralShare)localObject1).mSourceIcon;
    this.msgBrief = ((StructMsgForGeneralShare)localObject1).mMsgBrief;
    this.msgAction = ((StructMsgForGeneralShare)localObject1).mMsgUrl;
    localObject1 = ((StructMsgForGeneralShare)localObject1).mStructMsgItemLists;
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      localObject1 = (AbsStructMsgElement)((List)localObject1).get(0);
      if ((localObject1 instanceof StructMsgItemLayout2))
      {
        Object localObject2 = (StructMsgItemLayout2)localObject1;
        localObject1 = ((StructMsgItemLayout2)localObject2).a;
        try
        {
          if (QLog.isColorLevel()) {
            QLog.d("MessageForTroopSign", 2, "doParse, mCommonData=" + ((StructMsgItemLayout2)localObject2).i);
          }
          if (!TextUtils.isEmpty(((StructMsgItemLayout2)localObject2).i))
          {
            localObject2 = new JSONObject(((StructMsgItemLayout2)localObject2).i);
            this.markType = ((JSONObject)localObject2).getInt("markType");
            this.positonType = ((JSONObject)localObject2).getInt("positonType");
            this.markIconUrl = ((JSONObject)localObject2).getString("markIconUrl");
            this.markWord = ((JSONObject)localObject2).getString("markWord");
            this.markDesc = ((JSONObject)localObject2).getString("markDesc");
            this.dynamicSource = ((JSONObject)localObject2).optString("dynamicSource", null);
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            String str;
            if (QLog.isColorLevel())
            {
              QLog.e("MessageForTroopSign", 2, "doParse:" + localException.toString());
              continue;
              if ("summary".equals(str))
              {
                if ((localException instanceof StructMsgItemSummary)) {
                  this.msgContent = ((StructMsgItemSummary)localException).b();
                }
              }
              else if (("title".equals(str)) && ((localException instanceof StructMsgItemTitle))) {
                this.msgTitle = ((StructMsgItemTitle)localException).b();
              }
            }
          }
        }
        localObject1 = ((ArrayList)localObject1).iterator();
        for (;;)
        {
          if (!((Iterator)localObject1).hasNext()) {
            break label372;
          }
          localObject2 = (AbsStructMsgElement)((Iterator)localObject1).next();
          str = ((AbsStructMsgElement)localObject2).a;
          if (!"vote".equals(str)) {
            break;
          }
          if ((localObject2 instanceof StructMsgItemCover)) {
            this.msgCoverUrl = ((StructMsgItemCover)localObject2).u;
          }
        }
      }
    }
    label372:
    this.msg = getSummaryMsg();
    if (QLog.isColorLevel()) {
      QLog.d("MessageForTroopSign", 2, "doParse:" + toString());
    }
  }
  
  public String getSummaryMsg()
  {
    if (TextUtils.isEmpty(this.msgBrief)) {
      this.msgBrief = "[签到]";
    }
    return this.msgBrief;
  }
  
  public boolean isSupportReply()
  {
    return true;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("MessageForSign{");
    localStringBuilder.append("msgCoverUrl=").append(this.msgCoverUrl);
    localStringBuilder.append(", msgAction=").append(this.msgAction);
    localStringBuilder.append(", msgTitle=").append(this.msgTitle);
    localStringBuilder.append(", msgContent=").append(this.msgContent);
    localStringBuilder.append(", srcName=").append(this.srcName);
    localStringBuilder.append(", srcAction=").append(this.srcAction);
    localStringBuilder.append(", srcIconUrl=").append(this.srcIconUrl);
    localStringBuilder.append(", msgBrief=").append(this.msgBrief);
    localStringBuilder.append(", markType=").append(this.markType);
    localStringBuilder.append(", positonType=").append(this.positonType);
    localStringBuilder.append(", markIconUrl=").append(this.markIconUrl);
    localStringBuilder.append(", markWord=").append(this.markWord);
    localStringBuilder.append(", markDesc=").append(this.markDesc);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForTroopSign
 * JD-Core Version:    0.7.0.1
 */