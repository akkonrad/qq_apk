package com.tencent.mobileqq.activity.aio.item;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import bxx;
import bxy;
import bxz;
import bya;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.FileTransferManager;
import com.tencent.mobileqq.activity.aio.FileTransferManager.Callback;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.customviews.MessageProgressTextView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.pic.PicPreDownloader;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgClickHandler;
import com.tencent.mobileqq.structmsg.StructMsgForAudioShare;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemImage;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.RecyclerListener;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavReport;
import cooperation.qqfav.QfavUtil;
import java.io.File;
import java.net.URL;

public class StructingMsgItemBuilder
  extends BaseBubbleBuilder
  implements FileTransferManager.Callback
{
  private final float a;
  public AbsListView.RecyclerListener a;
  
  public StructingMsgItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    this.jdField_a_of_type_ComTencentWidgetAbsListView$RecyclerListener = new bya(this);
    if ((paramContext instanceof ChatActivity)) {
      ((ChatActivity)paramContext).a().a(this.jdField_a_of_type_ComTencentWidgetAbsListView$RecyclerListener);
    }
    this.jdField_a_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
  }
  
  private StructMsgForGeneralShare a(ChatMessage paramChatMessage)
  {
    if (!(paramChatMessage instanceof MessageForStructing)) {
      paramChatMessage = null;
    }
    StructMsgForGeneralShare localStructMsgForGeneralShare;
    do
    {
      return paramChatMessage;
      paramChatMessage = (MessageForStructing)paramChatMessage;
      if (!(paramChatMessage.structingMsg instanceof StructMsgForGeneralShare)) {
        break;
      }
      localStructMsgForGeneralShare = (StructMsgForGeneralShare)paramChatMessage.structingMsg;
      paramChatMessage = localStructMsgForGeneralShare;
    } while (localStructMsgForGeneralShare.getProgress() >= 0);
    return null;
  }
  
  private void a(View paramView, StructMsgForGeneralShare paramStructMsgForGeneralShare)
  {
    new StructMsgClickHandler(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView).a(paramStructMsgForGeneralShare.mMsgAction, paramStructMsgForGeneralShare.mMsgUrl, paramStructMsgForGeneralShare.mMsgActionData, paramStructMsgForGeneralShare.mMsg_A_ActionData);
  }
  
  private void a(StructingMsgItemBuilder.StructingMsgViewHolder paramStructingMsgViewHolder, BaseChatItemLayout paramBaseChatItemLayout, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramBaseChatItemLayout.setHeadIconVisible(false);
      paramStructingMsgViewHolder.c.setBackgroundResource(2130839516);
      int i = paramStructingMsgViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.getPaddingLeft();
      int j = paramStructingMsgViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.getPaddingLeft();
      paramStructingMsgViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(0, i, 0, j);
      return;
    }
    paramBaseChatItemLayout.setHeadIconVisible(true);
  }
  
  private void a(StructingMsgItemBuilder.StructingMsgViewHolder paramStructingMsgViewHolder, BaseChatItemLayout paramBaseChatItemLayout, boolean paramBoolean1, AbsStructMsg paramAbsStructMsg, Resources paramResources, boolean paramBoolean2)
  {
    RelativeLayout localRelativeLayout = paramStructingMsgViewHolder.b;
    if (localRelativeLayout == null)
    {
      localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      paramStructingMsgViewHolder.b = localRelativeLayout;
      localRelativeLayout.setId(2131296308);
      paramBaseChatItemLayout.addView(localRelativeLayout);
    }
    for (;;)
    {
      Object localObject2 = (RelativeLayout.LayoutParams)localRelativeLayout.getLayoutParams();
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new RelativeLayout.LayoutParams(-2, -2);
      }
      ((RelativeLayout.LayoutParams)localObject1).topMargin = AIOUtils.a(2.0F, paramResources);
      if (paramBoolean2)
      {
        ((RelativeLayout.LayoutParams)localObject1).leftMargin = AIOUtils.a(0.0F, paramResources);
        ((RelativeLayout.LayoutParams)localObject1).addRule(5, 2131296305);
        ((RelativeLayout.LayoutParams)localObject1).addRule(3, 2131296305);
        if (!paramBoolean1) {
          break label304;
        }
        ((RelativeLayout.LayoutParams)localObject1).addRule(1, 0);
        ((RelativeLayout.LayoutParams)localObject1).addRule(7, 2131296298);
      }
      for (;;)
      {
        localRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        localObject1 = localRelativeLayout.getChildAt(0);
        paramResources = (Resources)localObject1;
        if (localObject1 != null)
        {
          paramResources = (Resources)localObject1;
          if (paramStructingMsgViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
          {
            localObject2 = paramStructingMsgViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(0);
            paramResources = (Resources)localObject1;
            if (localObject2 != null)
            {
              localObject2 = ((View)localObject2).getTag(2131296292);
              if (QLog.isColorLevel()) {
                QLog.d("structMsg", 2, "bindviwfor structmsg tag:" + localObject2);
              }
              if (localObject2 != null)
              {
                paramResources = (Resources)localObject1;
                if (localObject2.getClass() == paramAbsStructMsg.getClass()) {}
              }
              else
              {
                paramResources = null;
              }
            }
          }
        }
        localRelativeLayout.removeAllViews();
        paramAbsStructMsg = paramAbsStructMsg.getSourceView(this.jdField_a_of_type_AndroidContentContext, paramResources);
        if (paramAbsStructMsg == null) {
          break label324;
        }
        localRelativeLayout.addView(paramAbsStructMsg);
        return;
        ((RelativeLayout.LayoutParams)localObject1).leftMargin = AIOUtils.a(10.0F, paramResources);
        break;
        label304:
        ((RelativeLayout.LayoutParams)localObject1).addRule(1, 2131296298);
        ((RelativeLayout.LayoutParams)localObject1).addRule(7, 2131296305);
      }
      label324:
      paramBaseChatItemLayout.removeView(localRelativeLayout);
      paramStructingMsgViewHolder.b = null;
      return;
    }
  }
  
  private void a(IHttpCommunicatorListener paramIHttpCommunicatorListener, StructingMsgItemBuilder.StructingMsgViewHolder paramStructingMsgViewHolder)
  {
    if (paramStructingMsgViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {
      return;
    }
    Object localObject;
    int i;
    if ((paramIHttpCommunicatorListener instanceof BaseTransProcessor))
    {
      localObject = (BaseTransProcessor)paramIHttpCommunicatorListener;
      i = (int)((BaseTransProcessor)localObject).c();
      if ((i != 1004) || (!((BaseTransProcessor)localObject).b()) || (!((BaseTransProcessor)localObject).c())) {
        break label412;
      }
      i = 1006;
    }
    label412:
    for (;;)
    {
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(6, 2131296292);
      ((RelativeLayout.LayoutParams)localObject).addRule(8, 2131296292);
      ((RelativeLayout.LayoutParams)localObject).addRule(5, 2131296292);
      ((RelativeLayout.LayoutParams)localObject).addRule(7, 2131296292);
      if ((paramStructingMsgViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (paramStructingMsgViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131296343) == null) && (paramStructingMsgViewHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView != null)) {
        paramStructingMsgViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramStructingMsgViewHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView, (ViewGroup.LayoutParams)localObject);
      }
      switch (i)
      {
      default: 
        if (paramStructingMsgViewHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView == null) {
          break;
        }
        paramStructingMsgViewHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setProcessor(null);
        paramStructingMsgViewHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setVisibility(8);
        return;
      case 1000: 
      case 1001: 
      case 1002: 
      case 1006: 
      case 4001: 
        if (paramStructingMsgViewHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView == null)
        {
          MessageProgressTextView localMessageProgressTextView = new MessageProgressTextView(this.jdField_a_of_type_AndroidContentContext);
          localMessageProgressTextView.setTextColor(-1);
          localMessageProgressTextView.setTextSize(2, 15.0F);
          localMessageProgressTextView.setGravity(17);
          localMessageProgressTextView.setId(2131296343);
          localMessageProgressTextView.setBackgroundDrawable(new AIOSendMask(2130706432, this.jdField_a_of_type_Float * 12.0F));
          if (paramStructingMsgViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
            paramStructingMsgViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(localMessageProgressTextView, (ViewGroup.LayoutParams)localObject);
          }
          paramStructingMsgViewHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView = localMessageProgressTextView;
        }
        paramStructingMsgViewHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setProcessor((BaseTransProcessor)paramIHttpCommunicatorListener);
        paramStructingMsgViewHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setVisibility(0);
        switch (i)
        {
        }
        for (;;)
        {
          paramStructingMsgViewHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.a();
          return;
          paramStructingMsgViewHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setProgress(0);
          return;
          paramStructingMsgViewHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setProgress(0);
        }
        if (paramStructingMsgViewHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView == null) {
          break;
        }
        paramStructingMsgViewHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setProcessor(null);
        paramStructingMsgViewHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setVisibility(4);
        return;
      }
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    paramChatMessage = (MessageForStructing)paramChatMessage;
    if ((paramChatMessage != null) && (paramChatMessage.structingMsg != null) && (paramChatMessage.structingMsg.hasFlag(4))) {
      return 0;
    }
    return 2;
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramView = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramOnLongClickAndTouchListener);
    paramViewGroup = (StructingMsgItemBuilder.StructingMsgViewHolder)paramView.getTag();
    paramOnLongClickAndTouchListener = paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout;
    paramChatMessage = (MessageForStructing)paramChatMessage;
    AbsStructMsg localAbsStructMsg = paramChatMessage.structingMsg;
    if (localAbsStructMsg == null) {
      return paramView;
    }
    Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
    a(paramViewGroup, paramOnLongClickAndTouchListener, localAbsStructMsg.hasFlag(4));
    a(paramViewGroup, paramOnLongClickAndTouchListener, paramChatMessage.isSend(), localAbsStructMsg, localResources, localAbsStructMsg.hasFlag(4));
    paramView.requestLayout();
    return paramView;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    if ((this.jdField_a_of_type_AndroidContentContext instanceof ChatActivity)) {}
    for (StructingMsgItemBuilder.ViewCache localViewCache = ((ChatActivity)this.jdField_a_of_type_AndroidContentContext).a().a();; localViewCache = null)
    {
      Object localObject1;
      if (paramView == null)
      {
        paramViewHolder = this.jdField_a_of_type_AndroidContentContext.getResources();
        paramView = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
        paramView.setId(2131296305);
        paramView.setMinimumHeight(AIOUtils.a(44.0F, paramViewHolder));
        paramView.setClickable(true);
        paramView.setPadding(paramViewHolder.getDimensionPixelSize(2131492962), paramViewHolder.getDimensionPixelSize(2131492960), paramViewHolder.getDimensionPixelSize(2131492963), paramViewHolder.getDimensionPixelSize(2131492961));
        paramView.setBackgroundResource(2130837546);
        localObject1 = new RelativeLayout.LayoutParams(-2, -2);
        int i = AIOUtils.a(3.0F, paramViewHolder);
        ((RelativeLayout.LayoutParams)localObject1).setMargins(i, 0, i, 0);
        ((RelativeLayout.LayoutParams)localObject1).addRule(1, 2131296456);
        paramView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      for (;;)
      {
        if (!MessageForStructing.class.isInstance(paramChatMessage)) {}
        MessageForStructing localMessageForStructing;
        AbsStructMsg localAbsStructMsg;
        do
        {
          return paramView;
          localMessageForStructing = (MessageForStructing)paramChatMessage;
          localAbsStructMsg = localMessageForStructing.structingMsg;
          if (localAbsStructMsg != null) {
            break;
          }
        } while (!QLog.isColorLevel());
        paramViewHolder = new StringBuilder().append("structMsg is null,msgdata:");
        if (localMessageForStructing == null) {
          paramChatMessage = "null";
        }
        for (;;)
        {
          QLog.d("structMsg", 2, paramChatMessage);
          return paramView;
          if (localMessageForStructing.msgData == null) {
            paramChatMessage = "null";
          } else {
            paramChatMessage = Integer.valueOf(localMessageForStructing.msgData.length);
          }
        }
        localAbsStructMsg.uniseq = localMessageForStructing.uniseq;
        localAbsStructMsg.uin = localMessageForStructing.frienduin;
        localAbsStructMsg.uinType = localMessageForStructing.istroop;
        localAbsStructMsg.currentAccountUin = localMessageForStructing.selfuin;
        localAbsStructMsg.messageVersion = localMessageForStructing.versionCode;
        if (StructMsgForImageShare.class.isInstance(localAbsStructMsg))
        {
          paramViewHolder = (StructMsgForImageShare)localAbsStructMsg;
          paramViewHolder.mIsSend = localMessageForStructing.issend;
          paramViewHolder.mUniseq = localMessageForStructing.uniseq;
          paramViewHolder.mMsgType = localMessageForStructing.msgtype;
        }
        paramBaseChatItemLayout.setAddStatesFromChildren(false);
        paramViewHolder = paramBaseChatItemLayout.getTag();
        if (paramViewHolder != null) {}
        for (paramViewHolder = (StructingMsgItemBuilder.StructingMsgViewHolder)paramViewHolder;; paramViewHolder = null)
        {
          if (paramViewHolder == null) {}
          for (localObject1 = new StructingMsgItemBuilder.StructingMsgViewHolder();; localObject1 = paramViewHolder)
          {
            ((StructingMsgItemBuilder.StructingMsgViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
            paramViewHolder = ((StructingMsgItemBuilder.StructingMsgViewHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout;
            Object localObject2 = paramViewHolder;
            if (paramViewHolder == null)
            {
              localObject2 = (RelativeLayout)paramView;
              ((StructingMsgItemBuilder.StructingMsgViewHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject2);
            }
            paramView.setTag(localObject1);
            String str;
            if ((localAbsStructMsg instanceof StructMsgForGeneralShare))
            {
              str = ((StructMsgForGeneralShare)localAbsStructMsg).getLayoutStr();
              paramViewHolder = null;
              if (localViewCache != null) {
                paramViewHolder = localViewCache.a(str, (ViewGroup)paramView);
              }
              if (paramViewHolder != null)
              {
                paramViewHolder = localAbsStructMsg.getView(this.jdField_a_of_type_AndroidContentContext, paramViewHolder, paramOnLongClickAndTouchListener);
                paramView.setOnTouchListener(paramOnLongClickAndTouchListener);
                paramView.setOnLongClickListener(paramOnLongClickAndTouchListener);
                if (!(localAbsStructMsg instanceof AbsShareMsg)) {
                  break label735;
                }
                paramOnLongClickAndTouchListener = ((AbsShareMsg)localAbsStructMsg).getOnClickListener();
                long l = paramChatMessage.time;
                paramView.setOnClickListener(new bxx(this, paramOnLongClickAndTouchListener));
                if (StructMsgForImageShare.class.isInstance(localAbsStructMsg)) {
                  FileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramBaseChatItemLayout, this);
                }
              }
            }
            for (;;)
            {
              ((RelativeLayout)localObject2).addView(paramViewHolder);
              if (!localMessageForStructing.isSendFromLocal()) {
                break label767;
              }
              paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageForStructing.frienduin, localMessageForStructing.uniseq);
              ((StructingMsgItemBuilder.StructingMsgViewHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject2);
              a(paramChatMessage, (StructingMsgItemBuilder.StructingMsgViewHolder)localObject1);
              return paramView;
              paramViewHolder = localAbsStructMsg.getView(this.jdField_a_of_type_AndroidContentContext, null, paramOnLongClickAndTouchListener);
              if (localViewCache != null) {
                localViewCache.a(str, paramViewHolder, (ViewGroup)paramView);
              }
              break;
              if (((RelativeLayout)localObject2).getChildCount() > 0)
              {
                paramViewHolder = ((RelativeLayout)localObject2).getChildAt(0);
                if (paramViewHolder != null)
                {
                  paramViewHolder = paramViewHolder.getTag(2131296292);
                  if (QLog.isColorLevel()) {
                    QLog.d("structMsg", 2, "bindviwfor structmsg tag:" + paramViewHolder);
                  }
                  if ((paramViewHolder == null) || (paramViewHolder.getClass() == localAbsStructMsg.getClass())) {}
                }
              }
              ((RelativeLayout)localObject2).removeAllViews();
              paramViewHolder = localAbsStructMsg.getView(this.jdField_a_of_type_AndroidContentContext, null, paramOnLongClickAndTouchListener);
              break;
              label735:
              if (localAbsStructMsg.mMsgServiceID == 3) {
                if (a()) {
                  paramView.setClickable(false);
                } else {
                  paramView.setClickable(true);
                }
              }
            }
            label767:
            if (!(localAbsStructMsg instanceof StructMsgForImageShare)) {
              break;
            }
            paramChatMessage = ((StructMsgForImageShare)localAbsStructMsg).getFirstImageElement();
            if ((paramChatMessage == null) || (paramChatMessage.jdField_a_of_type_ComTencentMobileqqDataMessageForPic == null)) {
              break;
            }
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramChatMessage.jdField_a_of_type_ComTencentMobileqqDataMessageForPic, 2);
            return paramView;
          }
        }
      }
    }
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new StructingMsgItemBuilder.StructingMsgViewHolder();
  }
  
  protected String a(ChatMessage paramChatMessage)
  {
    AbsStructMsg localAbsStructMsg = ((MessageForStructing)paramChatMessage).structingMsg;
    if (localAbsStructMsg != null) {
      if ((localAbsStructMsg instanceof AbsShareMsg))
      {
        paramChatMessage = (AbsShareMsg)localAbsStructMsg;
        if ((paramChatMessage.mContentTitle != null) && (paramChatMessage.mContentTitle.trim().length() > 0))
        {
          paramChatMessage = "" + paramChatMessage.mContentTitle;
          localObject = paramChatMessage;
          if (localAbsStructMsg.mMsgBrief != null)
          {
            localObject = paramChatMessage;
            if (localAbsStructMsg.mMsgBrief.trim().length() <= 0) {}
          }
        }
      }
    }
    for (Object localObject = paramChatMessage + localAbsStructMsg.mMsgBrief;; localObject = "")
    {
      return "发送了" + (String)localObject;
      paramChatMessage = "";
      break;
    }
  }
  
  @SuppressLint({"NewApi"})
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if (paramInt == 2131296289) {
      if ((paramChatMessage != null) && ((paramChatMessage instanceof MessageForStructing)))
      {
        paramContext = (MessageForStructing)paramChatMessage;
        if ((paramContext.structingMsg != null) && ((paramContext.structingMsg instanceof StructMsgForImageShare)))
        {
          paramContext = ((StructMsgForImageShare)paramContext.structingMsg).getFirstImageElement();
          if (paramContext != null)
          {
            paramContext = paramContext.jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
            paramChatMessage = URLDrawable.getDrawable(URLDrawableHelper.a(paramContext, 1), -1, -1, null, null, false);
            paramChatMessage.setTag(paramContext);
            AIOGalleryUtils.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, paramContext.frienduin, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131492887));
          }
        }
      }
    }
    Object localObject2;
    Object localObject3;
    Object localObject4;
    Object localObject1;
    Object localObject5;
    label338:
    label357:
    AbsShareMsg localAbsShareMsg;
    label466:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  return;
                  if (paramInt != 2131296655) {
                    break;
                  }
                } while ((paramChatMessage == null) || (!(paramChatMessage instanceof MessageForStructing)));
                localObject2 = (MessageForStructing)paramChatMessage;
              } while (((MessageForStructing)localObject2).structingMsg == null);
              if (!(((MessageForStructing)localObject2).structingMsg instanceof StructMsgForImageShare)) {
                break label357;
              }
              paramChatMessage = (StructMsgForImageShare)((MessageForStructing)localObject2).structingMsg;
              localObject3 = paramChatMessage.getFirstImageElement();
              if (localObject3 == null) {
                break label466;
              }
              if (((StructMsgItemImage)localObject3).jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare == null) {
                ((StructMsgItemImage)localObject3).jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare = paramChatMessage;
              }
              paramChatMessage = ((StructMsgItemImage)localObject3).a();
              localObject4 = ForwardUtils.a(this.jdField_a_of_type_AndroidContentContext, paramChatMessage);
              if (!new File(paramChatMessage.path).exists()) {
                break;
              }
              ((StructMsgItemImage)localObject3).h = paramChatMessage.path;
              if (!TextUtils.isEmpty(((StructMsgItemImage)localObject3).h)) {
                break label338;
              }
            } while (!QLog.isColorLevel());
            QLog.d(jdField_a_of_type_JavaLangString, 2, "StructingMsgItemBuilder onMenuItemClicked forward imageElement.mShareImageUrl is null!!!");
            return;
            localObject1 = null;
            localObject5 = ((URLDrawable)localObject4).getURL().toString();
            if (AbsDownloader.a((String)localObject5)) {
              paramChatMessage = AbsDownloader.a((String)localObject5).getAbsolutePath();
            }
            for (;;)
            {
              ((StructMsgItemImage)localObject3).h = paramChatMessage;
              break;
              localObject5 = AbsDownloader.a(URLDrawableHelper.a(paramChatMessage, 65537).toString());
              paramChatMessage = localObject1;
              if (localObject5 != null)
              {
                paramChatMessage = localObject1;
                if (((File)localObject5).exists()) {
                  paramChatMessage = ((File)localObject5).getAbsolutePath();
                }
              }
            }
            if (!AbsDownloader.a(((URLDrawable)localObject4).getURL().toString())) {
              ((URLDrawable)localObject4).startDownload();
            }
            paramChatMessage = new Bundle();
            paramChatMessage.putInt("forward_type", -3);
            ((MessageForStructing)localObject2).structingMsg.mCommentText = null;
            paramChatMessage.putByteArray("stuctmsg_bytes", ((MessageForStructing)localObject2).structingMsg.getBytes());
            paramContext = new Intent(paramContext, ForwardRecentActivity.class);
            paramContext.putExtras(paramChatMessage);
            ((Activity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult(paramContext, 21);
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "", "", "", "");
            return;
          } while (!QLog.isColorLevel());
          QLog.d(jdField_a_of_type_JavaLangString, 2, "StructingMsgItemBuilder onMenuItemClicked forward imageElement is null!!!");
          return;
          if (paramInt == 2131298958)
          {
            ChatActivityFacade.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
            return;
          }
          if (paramInt != 2131296659) {
            break;
          }
        } while ((paramChatMessage == null) || (!(paramChatMessage instanceof MessageForStructing)));
        paramContext = (MessageForStructing)paramChatMessage;
      } while (paramContext.structingMsg == null);
      localAbsShareMsg = (AbsShareMsg)paramContext.structingMsg;
      if (!(localAbsShareMsg instanceof StructMsgForImageShare)) {
        break;
      }
      paramContext = QfavUtil.a((StructMsgForImageShare)localAbsShareMsg);
    } while (paramContext == null);
    QfavBuilder.a(paramContext.j, localAbsShareMsg.uinType, paramContext.i, paramContext.b, paramContext.h, paramContext.c).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
    QfavReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 3);
    return;
    int i;
    if (!TextUtils.isEmpty(localAbsShareMsg.mMsgActionData))
    {
      String[] arrayOfString1 = localAbsShareMsg.mMsgActionData.split("&");
      i = arrayOfString1.length;
      localObject3 = null;
      localObject2 = null;
      localObject1 = null;
      paramContext = null;
      paramInt = 0;
      if (paramInt < i)
      {
        String[] arrayOfString2 = arrayOfString1[paramInt].split("=");
        localObject4 = localObject3;
        localObject5 = localObject2;
        Object localObject6 = localObject1;
        Object localObject7 = paramContext;
        if (arrayOfString2.length > 1)
        {
          if (!arrayOfString2[0].trim().equals("lat")) {
            break label765;
          }
          localObject7 = arrayOfString2[1];
          localObject6 = localObject1;
          localObject5 = localObject2;
          localObject4 = localObject3;
        }
        for (;;)
        {
          paramInt += 1;
          localObject3 = localObject4;
          localObject2 = localObject5;
          localObject1 = localObject6;
          paramContext = (Context)localObject7;
          break;
          label765:
          if (arrayOfString2[0].trim().equals("lon"))
          {
            localObject6 = arrayOfString2[1];
            localObject4 = localObject3;
            localObject5 = localObject2;
            localObject7 = paramContext;
          }
          else if (arrayOfString2[0].trim().equals("loc"))
          {
            localObject5 = arrayOfString2[1];
            localObject4 = localObject3;
            localObject6 = localObject1;
            localObject7 = paramContext;
          }
          else
          {
            localObject4 = localObject3;
            localObject5 = localObject2;
            localObject6 = localObject1;
            localObject7 = paramContext;
            if (arrayOfString2[0].trim().equals("title"))
            {
              localObject4 = arrayOfString2[1];
              localObject5 = localObject2;
              localObject6 = localObject1;
              localObject7 = paramContext;
            }
          }
        }
      }
      if ((localAbsShareMsg.mMsgServiceID == 32) && (!TextUtils.isEmpty(paramContext)) && (!TextUtils.isEmpty(localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject2)))
      {
        QfavBuilder.a(Float.valueOf(paramContext).floatValue(), Float.valueOf(localObject1).floatValue(), (String)localObject3, (String)localObject2, null).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
        QfavReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 7);
        return;
      }
    }
    paramContext = QfavUtil.a(localAbsShareMsg.getXmlBytes());
    if ((localAbsShareMsg instanceof StructMsgForAudioShare)) {
      i = 10;
    }
    for (paramInt = 2;; paramInt = 0)
    {
      QfavBuilder.a(paramInt, localAbsShareMsg.mContentTitle, localAbsShareMsg.mMsgUrl, localAbsShareMsg.mSourceName, localAbsShareMsg.mContentSummary, localAbsShareMsg.mContentCover, localAbsShareMsg.mContentSrc, paramContext, false).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
      QfavReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, i);
      return;
      if (paramInt == 2131298963)
      {
        paramContext = (MessageForStructing)paramChatMessage;
        if ((paramContext == null) || (paramContext.structingMsg == null) || (!"web".equals(paramContext.structingMsg.mMsgAction)) || (paramContext.structingMsg.mMsgUrl == null)) {
          break;
        }
        ((ClipboardManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setText(paramContext.structingMsg.mMsgUrl);
        return;
      }
      if (paramInt != 2131298965) {
        break;
      }
      a(paramChatMessage);
      return;
      i = 2;
    }
  }
  
  protected void a(View paramView)
  {
    super.a(paramView);
    if (AIOUtils.a(paramView).isMultiMsg) {}
    Object localObject1;
    Context localContext;
    Object localObject2;
    do
    {
      do
      {
        return;
        localObject1 = AIOUtils.a(paramView);
      } while (!StructingMsgItemBuilder.StructingMsgViewHolder.class.isInstance(localObject1));
      localContext = this.jdField_a_of_type_AndroidContentContext;
      localObject1 = ((StructingMsgItemBuilder.StructingMsgViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      localObject2 = a((ChatMessage)localObject1);
      if (localObject2 != null)
      {
        a(paramView, (StructMsgForGeneralShare)localObject2);
        return;
      }
      paramView = localContext.getString(2131363083);
      localObject2 = localContext.getString(2131363084);
    } while (!((ChatMessage)localObject1).isSendFromLocal());
    DialogUtil.a(localContext, 230, paramView, (String)localObject2, new bxy(this, (ChatMessage)localObject1, localContext), new bxz(this)).show();
  }
  
  public void a(View paramView, FileMsg paramFileMsg, int paramInt1, int paramInt2)
  {
    if (!BaseChatItemLayout.class.isInstance(paramView)) {}
    label9:
    ChatMessage localChatMessage;
    do
    {
      do
      {
        do
        {
          break label9;
          do
          {
            return;
          } while ((paramFileMsg.e != 1) && (paramFileMsg.e != 131075));
          paramView = AIOUtils.a(paramView);
        } while (!StructingMsgItemBuilder.StructingMsgViewHolder.class.isInstance(paramView));
        paramView = (StructingMsgItemBuilder.StructingMsgViewHolder)paramView;
      } while ((!StructingMsgItemBuilder.StructingMsgViewHolder.class.isInstance(paramView)) || (paramView.jdField_a_of_type_AndroidWidgetRelativeLayout == null) || (!MessageForStructing.class.isInstance(paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage)));
      localChatMessage = paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if ((localChatMessage.uniseq == paramFileMsg.c) && (localChatMessage.isSendFromLocal()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("structMsg", 2, "handleMessage status = " + paramInt1 + ", retCode = " + paramInt2 + ", message.uniseq = " + localChatMessage.uniseq + ", file.uniseq = " + paramFileMsg.c);
        }
        a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localChatMessage.frienduin, localChatMessage.uniseq), paramView);
        if (paramInt1 == 1005) {
          a();
        }
      }
    } while ((localChatMessage.uniseq != paramFileMsg.c) || (paramInt1 != 2003) || (!(((MessageForStructing)localChatMessage).structingMsg instanceof StructMsgForImageShare)));
    paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
    paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(((MessageForStructing)localChatMessage).structingMsg.getView(this.jdField_a_of_type_AndroidContentContext, null, null));
  }
  
  protected boolean a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    if (paramChatMessage.isMultiMsg) {
      return false;
    }
    Object localObject = (MessageForStructing)paramChatMessage;
    if ((((MessageForStructing)localObject).structingMsg != null) && (StructMsgForImageShare.class.isInstance(((MessageForStructing)localObject).structingMsg)) && (paramChatMessage.isSendFromLocal()))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramChatMessage.frienduin, paramChatMessage.istroop, paramChatMessage.uniseq);
      if ((localObject instanceof MessageForStructing))
      {
        localObject = ((StructMsgForImageShare)((MessageForStructing)localObject).structingMsg).getFirstImageElement();
        if ((localObject != null) && (((StructMsgItemImage)localObject).c <= 0L))
        {
          paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramChatMessage.frienduin, paramChatMessage.uniseq);
          if ((paramChatMessage instanceof BaseTransProcessor))
          {
            if (((BaseTransProcessor)paramChatMessage).c() == 1005L) {}
            for (boolean bool = true;; bool = false) {
              return bool;
            }
          }
          return true;
        }
      }
    }
    return super.a(paramChatMessage, paramBaseChatItemLayout);
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    Object localObject1 = (MessageForStructing)AIOUtils.a(paramView);
    paramView = new QQCustomMenu();
    localObject1 = ((MessageForStructing)localObject1).structingMsg;
    if (localObject1 != null)
    {
      if ((localObject1 instanceof StructMsgForImageShare))
      {
        localObject2 = ((StructMsgForImageShare)localObject1).getFirstImageElement();
        if ((((StructMsgItemImage)localObject2).jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null) && (URLDrawableHelper.a(this.jdField_a_of_type_AndroidContentContext, ((StructMsgItemImage)localObject2).jdField_a_of_type_ComTencentMobileqqDataMessageForPic, 65537))) {}
        for (int i = 1; i == 0; i = 0) {
          return paramView.a();
        }
        paramView.a(2131296289, this.jdField_a_of_type_AndroidContentContext.getString(2131363943));
      }
      Object localObject2 = this.jdField_a_of_type_AndroidContentContext.getResources();
      if (((AbsStructMsg)localObject1).fwFlag != 1)
      {
        if (((AbsStructMsg)localObject1).hasFlag(8)) {
          paramView.a(2131298963, ((Resources)localObject2).getString(2131364336));
        }
        if (!((AbsStructMsg)localObject1).hasFlag(1)) {
          paramView.a(2131296655, ((Resources)localObject2).getString(2131363573));
        }
        if ((!((AbsStructMsg)localObject1).hasFlag(2)) && (!"10000512".equals(AppSetting.a(this.jdField_a_of_type_AndroidContentContext)))) {
          paramView.a(2131296659, ((Resources)localObject2).getString(2131362673));
        }
        if (!((AbsStructMsg)localObject1).hasFlag(1)) {
          a(paramView);
        }
      }
    }
    ChatActivityFacade.a(paramView, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    return paramView.a();
  }
  
  protected void b(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    AbsStructMsg localAbsStructMsg = ((MessageForStructing)paramChatMessage).structingMsg;
    if ((localAbsStructMsg != null) && (StructMsgForImageShare.class.isInstance(localAbsStructMsg)))
    {
      paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramChatMessage.frienduin, paramChatMessage.uniseq);
      if ((paramChatMessage != null) && (BaseTransProcessor.class.isInstance(paramChatMessage)))
      {
        a(paramBaseChatItemLayout, ((BaseTransProcessor)paramChatMessage).a(), 0, 0);
        return;
      }
      paramBaseChatItemLayout.setProgressVisable(false);
      return;
    }
    super.b(paramChatMessage, paramBaseChatItemLayout);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder
 * JD-Core Version:    0.7.0.1
 */