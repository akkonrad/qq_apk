package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.MixedImageOnclickListener;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.BubbleInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.PicPreDownloader;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.mobileqq.widget.AnimationTextView.OnDoubleClick;
import com.tencent.mobileqq.widget.MixedMsgLinearLayout;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavReport;
import eex;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MixedMsgItemBuilder
  extends BaseBubbleBuilder
{
  private static final String b = MixedMsgItemBuilder.class.getSimpleName();
  private MixedImageOnclickListener jdField_a_of_type_ComTencentMobileqqActivityAioMixedImageOnclickListener = new MixedImageOnclickListener();
  private AnimationTextView.OnDoubleClick jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView$OnDoubleClick = new eex(this);
  
  public MixedMsgItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioMixedImageOnclickListener.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
  }
  
  private void a(SpannableStringBuilder paramSpannableStringBuilder, List paramList)
  {
    if (paramSpannableStringBuilder.length() > 0)
    {
      MessageRecord localMessageRecord = MessageRecordFactory.a(-1000);
      ((MessageForText)localMessageRecord).sb = new SpannableStringBuilder(paramSpannableStringBuilder);
      paramSpannableStringBuilder.clear();
      paramList.add(localMessageRecord);
    }
  }
  
  private void a(URLDrawable paramURLDrawable)
  {
    if ((AbsDownloader.a(paramURLDrawable.getURL().toString())) && (paramURLDrawable.getStatus() != 1)) {}
    try
    {
      paramURLDrawable.startDownload();
      return;
    }
    catch (OutOfMemoryError paramURLDrawable) {}
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 2;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramBaseChatItemLayout = (MixedMsgItemBuilder.MixedHolder)paramViewHolder;
    int i;
    int j;
    if (MixedMsgItemBuilder.MixedHolder.a(paramBaseChatItemLayout) != null)
    {
      i = 1;
      if (MixedMsgItemBuilder.MixedHolder.a(paramBaseChatItemLayout) != paramChatMessage.uniseq) {
        break label49;
      }
      j = 1;
      label33:
      if ((j & i) == 0) {
        break label55;
      }
    }
    label49:
    label55:
    do
    {
      do
      {
        return paramView;
        i = 0;
        break;
        j = 0;
        break label33;
        if ((paramChatMessage instanceof MessageForMixedMsg))
        {
          paramBaseChatItemLayout = (MessageForMixedMsg)paramChatMessage;
          j = paramBaseChatItemLayout.msgElemList.size();
          i = 0;
          while (i < j)
          {
            localObject1 = (MessageRecord)paramBaseChatItemLayout.msgElemList.get(i);
            if ((localObject1 instanceof MessageForPic))
            {
              localObject1 = (MessageForPic)localObject1;
              if (((MessageForPic)localObject1).time == 0L) {
                MessageForMixedMsg.copyBaseInfoFromMixedToPic((MessageForPic)localObject1, paramBaseChatItemLayout);
              }
            }
            i += 1;
          }
          paramView = a(paramViewHolder, (MixedMsgLinearLayout)paramView, paramBaseChatItemLayout.msgElemList, paramOnLongClickAndTouchListener);
          MixedMsgItemBuilder.MixedHolder.a((MixedMsgItemBuilder.MixedHolder)paramViewHolder, paramChatMessage.uniseq);
          return paramView;
        }
      } while (!(paramChatMessage instanceof MessageForLongMsg));
      localObject2 = (MessageForLongMsg)paramChatMessage;
      paramBaseChatItemLayout = new ArrayList();
    } while ((((MessageForLongMsg)localObject2).longMsgFragmentList == null) || (((MessageForLongMsg)localObject2).longMsgFragmentList.isEmpty()));
    Object localObject1 = new SpannableStringBuilder();
    Object localObject2 = ((MessageForLongMsg)localObject2).longMsgFragmentList.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = (MessageRecord)((Iterator)localObject2).next();
      if ((localObject3 instanceof MessageForText))
      {
        ((SpannableStringBuilder)localObject1).append(((MessageForText)localObject3).sb);
      }
      else if ((localObject3 instanceof MessageForPic))
      {
        a((SpannableStringBuilder)localObject1, paramBaseChatItemLayout);
        paramBaseChatItemLayout.add(localObject3);
      }
      else if ((localObject3 instanceof MessageForMixedMsg))
      {
        localObject3 = (MessageForMixedMsg)localObject3;
        j = ((MessageForMixedMsg)localObject3).msgElemList.size();
        i = 0;
        label349:
        MessageRecord localMessageRecord;
        if (i < j)
        {
          localMessageRecord = (MessageRecord)((MessageForMixedMsg)localObject3).msgElemList.get(i);
          if (!(localMessageRecord instanceof MessageForPic)) {
            break label431;
          }
          if (((MessageForPic)localMessageRecord).time == 0L) {
            MessageForMixedMsg.copyBaseInfoFromMixedToPic((MessageForPic)localMessageRecord, (MessageForMixedMsg)localObject3);
          }
          a((SpannableStringBuilder)localObject1, paramBaseChatItemLayout);
          paramBaseChatItemLayout.add(localMessageRecord);
        }
        for (;;)
        {
          i += 1;
          break label349;
          break;
          label431:
          if ((localMessageRecord instanceof MessageForText)) {
            ((SpannableStringBuilder)localObject1).append(((MessageForText)localMessageRecord).sb);
          } else {
            paramBaseChatItemLayout.add(localMessageRecord);
          }
        }
      }
    }
    a((SpannableStringBuilder)localObject1, paramBaseChatItemLayout);
    paramView = a(paramViewHolder, (MixedMsgLinearLayout)paramView, paramBaseChatItemLayout, paramOnLongClickAndTouchListener);
    MixedMsgItemBuilder.MixedHolder.a((MixedMsgItemBuilder.MixedHolder)paramViewHolder, paramChatMessage.uniseq);
    return paramView;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new MixedMsgItemBuilder.MixedHolder(this);
  }
  
  public MixedMsgLinearLayout a(BaseBubbleBuilder.ViewHolder paramViewHolder, MixedMsgLinearLayout paramMixedMsgLinearLayout, List paramList, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    ArrayList localArrayList = new ArrayList(paramList);
    paramList = paramMixedMsgLinearLayout;
    if (paramMixedMsgLinearLayout == null)
    {
      paramList = new MixedMsgLinearLayout(this.jdField_a_of_type_AndroidContentContext);
      paramList.setId(2131230779);
      paramList.setOrientation(1);
      paramList.setFocusable(false);
      paramList.setClickable(true);
      paramList.setMinimumHeight(AIOUtils.a(44.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      paramList.setPadding(2131427461, 2131427459, 2131427462, 2131427460);
      paramMixedMsgLinearLayout = new RelativeLayout.LayoutParams(-2, -2);
      paramMixedMsgLinearLayout.addRule(1, 2131230940);
      paramMixedMsgLinearLayout.addRule(3, 2131231294);
      paramMixedMsgLinearLayout.leftMargin = AIOUtils.a(3.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramMixedMsgLinearLayout.rightMargin = AIOUtils.a(3.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramList.setLayoutParams(paramMixedMsgLinearLayout);
      paramList.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView$OnDoubleClick = this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView$OnDoubleClick;
      MixedMsgItemBuilder.MixedHolder.a((MixedMsgItemBuilder.MixedHolder)paramViewHolder, paramList);
    }
    paramList.a(localArrayList);
    int j = localArrayList.size();
    int i = 0;
    while (i < j)
    {
      paramMixedMsgLinearLayout = (MessageRecord)localArrayList.get(i);
      paramViewHolder = paramList.getChildAt(i);
      if (paramViewHolder == null)
      {
        i += 1;
      }
      else
      {
        Object localObject;
        if ((paramMixedMsgLinearLayout instanceof MessageForText))
        {
          localObject = (AnimationTextView)paramViewHolder;
          ((AnimationTextView)localObject).setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
          ((AnimationTextView)localObject).setText(((MessageForText)paramMixedMsgLinearLayout).sb);
          label254:
          paramMixedMsgLinearLayout = (LinearLayout.LayoutParams)paramViewHolder.getLayoutParams();
          paramMixedMsgLinearLayout.topMargin = BaseChatItemLayout.n;
          if (i != j - 1) {
            break label425;
          }
        }
        label425:
        for (paramMixedMsgLinearLayout.bottomMargin = BaseChatItemLayout.n;; paramMixedMsgLinearLayout.bottomMargin = 0)
        {
          paramViewHolder.setOnTouchListener(paramOnLongClickAndTouchListener);
          paramViewHolder.setOnLongClickListener(paramOnLongClickAndTouchListener);
          break;
          if ((paramMixedMsgLinearLayout instanceof MessageForPic))
          {
            paramMixedMsgLinearLayout = (MessageForPic)paramMixedMsgLinearLayout;
            localObject = (ChatThumbView)paramViewHolder;
            URLDrawable localURLDrawable = PicItemBuilder.a(this.jdField_a_of_type_AndroidContentContext, paramMixedMsgLinearLayout, (ChatThumbView)localObject);
            ((ChatThumbView)localObject).setTag(2131230791, paramMixedMsgLinearLayout);
            ((ChatThumbView)localObject).setImageDrawable(localURLDrawable);
            ((ChatThumbView)localObject).setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityAioMixedImageOnclickListener);
            a(localURLDrawable);
            if (paramMixedMsgLinearLayout.isSendFromLocal()) {
              break label254;
            }
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramMixedMsgLinearLayout, 2);
            break label254;
          }
          if (!QLog.isColorLevel()) {
            break label254;
          }
          QLog.e(b, 2, "mixed type not support yet." + paramMixedMsgLinearLayout.getClass().getSimpleName());
          break label254;
        }
      }
    }
    paramList.setOnTouchListener(paramOnLongClickAndTouchListener);
    paramList.setOnLongClickListener(paramOnLongClickAndTouchListener);
    paramList.b = this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView$OnDoubleClick;
    return paramList;
  }
  
  protected String a(ChatMessage paramChatMessage)
  {
    return this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131558897, new Object[] { paramChatMessage.msg });
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 2131234872: 
      ChatActivityFacade.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
    case 2131234877: 
      ((ClipboardManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setText(MessageForMixedMsg.getTextFromMixedMsg(paramChatMessage));
      return;
    case 2131231190: 
      paramChatMessage = MessageForMixedMsg.getTextFromMixedMsg(paramChatMessage);
      paramContext = new Bundle();
      paramContext.putInt("forward_type", -1);
      paramContext.putString("forward_text", paramChatMessage.toString());
      paramChatMessage = new Intent(this.jdField_a_of_type_AndroidContentContext, ForwardRecentActivity.class);
      paramChatMessage.putExtras(paramContext);
      ((Activity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult(paramChatMessage, 21);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "", "", "", "");
      return;
    }
    QfavBuilder.b(paramChatMessage).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
    QfavReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 8);
  }
  
  protected void a(BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, ChatMessage paramChatMessage, BubbleInfo paramBubbleInfo)
  {
    MixedMsgItemBuilder.MixedHolder localMixedHolder = (MixedMsgItemBuilder.MixedHolder)paramViewHolder;
    if ((paramBubbleInfo.a == 0) || (!paramBubbleInfo.a()))
    {
      paramView = paramView.getResources();
      if (paramChatMessage.isSend())
      {
        paramViewHolder = paramView.getColorStateList(2131362080);
        if (!paramChatMessage.isSend()) {
          break label79;
        }
      }
      label79:
      for (paramView = paramView.getColorStateList(2131362079);; paramView = paramView.getColorStateList(2131362078))
      {
        MixedMsgItemBuilder.MixedHolder.a(localMixedHolder).a(paramViewHolder, paramView);
        return;
        paramViewHolder = paramView.getColorStateList(2131362077);
        break;
      }
    }
    paramViewHolder = ColorStateList.valueOf(-16777216);
    paramView = paramView.getResources().getColorStateList(2131362078);
    if (paramBubbleInfo.b != 0) {
      paramViewHolder = ColorStateList.valueOf(paramBubbleInfo.b);
    }
    if (paramBubbleInfo.c != 0) {
      paramView = ColorStateList.valueOf(paramBubbleInfo.c);
    }
    MixedMsgItemBuilder.MixedHolder.a(localMixedHolder).a(paramViewHolder, paramView);
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    paramView = new QQCustomMenu();
    paramView.a(this.jdField_a_of_type_AndroidContentContext.getString(2131562176));
    paramView.a(2131234877, this.jdField_a_of_type_AndroidContentContext.getString(2131561881));
    paramView.a(2131231190, this.jdField_a_of_type_AndroidContentContext.getString(2131562129));
    paramView.a(2131231192, this.jdField_a_of_type_AndroidContentContext.getString(2131560772));
    ChatActivityFacade.a(paramView, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    return paramView.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.MixedMsgItemBuilder
 * JD-Core Version:    0.7.0.1
 */