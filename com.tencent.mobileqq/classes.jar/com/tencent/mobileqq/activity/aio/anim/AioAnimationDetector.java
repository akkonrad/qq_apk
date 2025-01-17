package com.tencent.mobileqq.activity.aio.anim;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.HotReactiveHelper;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkFlashChat;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.view.StructMsgItemSummary;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import umx;
import umy;
import umz;
import una;
import unb;
import unc;
import und;
import une;
import unf;
import ung;
import unh;
import uni;

public class AioAnimationDetector
{
  private static volatile AioAnimationDetector jdField_a_of_type_ComTencentMobileqqActivityAioAnimAioAnimationDetector;
  public volatile long a;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  public volatile boolean a;
  private long jdField_b_of_type_Long = -1L;
  private boolean jdField_b_of_type_Boolean;
  
  private AioAnimationDetector()
  {
    this.jdField_a_of_type_Long = -1L;
  }
  
  public static AioAnimationDetector a()
  {
    if (jdField_a_of_type_ComTencentMobileqqActivityAioAnimAioAnimationDetector == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqActivityAioAnimAioAnimationDetector == null) {
        jdField_a_of_type_ComTencentMobileqqActivityAioAnimAioAnimationDetector = new AioAnimationDetector();
      }
      return jdField_a_of_type_ComTencentMobileqqActivityAioAnimAioAnimationDetector;
    }
    finally {}
  }
  
  private void a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage, int paramInt)
  {
    String str2 = "";
    String str1;
    if (paramInt == 0) {
      str1 = "0X8004A27";
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(str1)) {
        VipUtils.a(paramQQAppInterface, "Vip_StructuredEgg", str1, str1, 0, 0, new String[0]);
      }
      return;
      str1 = str2;
      if (paramInt == 1) {
        if (paramChatMessage.istroop == 1)
        {
          str1 = "0X8004A28";
        }
        else
        {
          str1 = str2;
          if (paramChatMessage.istroop == 3000) {
            str1 = "0X8004A29";
          }
        }
      }
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage, int paramInt1, int paramInt2, AioAnimationRule paramAioAnimationRule)
  {
    int j = -1;
    int i;
    if (paramInt1 == 0)
    {
      i = 0;
      if (paramInt2 != 2) {
        break label134;
      }
      if (paramChatMessage.isSendFromLocal()) {
        break label100;
      }
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "Supr-Eggs", "Egg_stack_rec", 0, 0, String.valueOf(i), String.valueOf(paramAioAnimationRule.jdField_a_of_type_Int), "", "");
    }
    label100:
    while (paramInt2 != 3)
    {
      return;
      i = j;
      if (paramInt1 != 1) {
        break;
      }
      if (paramChatMessage.istroop == 1)
      {
        i = 1;
        break;
      }
      i = j;
      if (paramChatMessage.istroop != 3000) {
        break;
      }
      i = 2;
      break;
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "Supr-Eggs", "Egg_stack_launch", 0, 0, String.valueOf(i), String.valueOf(paramAioAnimationRule.jdField_a_of_type_Int), "", "");
      return;
    }
    label134:
    if (!paramChatMessage.isSendFromLocal())
    {
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "Supr-Eggs", "Egg_jump_rec", 0, 0, String.valueOf(i), String.valueOf(paramAioAnimationRule.jdField_a_of_type_Int), "", "");
      return;
    }
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "Supr-Eggs", "Egg_jump_launch", 0, 0, String.valueOf(i), String.valueOf(paramAioAnimationRule.jdField_a_of_type_Int), "", "");
  }
  
  private void a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage, AioAnimationRule paramAioAnimationRule)
  {
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.d("AioAnimationDetector", 2, "detect combo =======> isLastStackMessageFromOthers ? " + this.jdField_b_of_type_Boolean + "  lastStackMessageSeq=" + this.jdField_b_of_type_Long + "thisMessageSeq=" + paramChatMessage.shmsgseq);
    }
    if ((paramChatMessage.isSendFromLocal()) && (this.jdField_b_of_type_Boolean) && (paramChatMessage.shmsgseq == this.jdField_b_of_type_Long + 1L)) {
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "Supr-Eggs", "Eggs_stack_new", 0, 0, String.valueOf(0), String.valueOf(paramAioAnimationRule.jdField_a_of_type_Int), "", "");
    }
    if (!paramChatMessage.isSendFromLocal()) {
      bool = true;
    }
    this.jdField_b_of_type_Boolean = bool;
    this.jdField_b_of_type_Long = paramChatMessage.shmsgseq;
  }
  
  public String a(AbsShareMsg paramAbsShareMsg)
  {
    if ((paramAbsShareMsg != null) && (paramAbsShareMsg.getItemCount() > 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      paramAbsShareMsg = paramAbsShareMsg.iterator();
      while (paramAbsShareMsg.hasNext())
      {
        Object localObject = (AbsStructMsgElement)paramAbsShareMsg.next();
        if ((localObject instanceof AbsStructMsgItem))
        {
          localObject = ((AbsStructMsgItem)localObject).jdField_a_of_type_JavaUtilArrayList.iterator();
          while (((Iterator)localObject).hasNext())
          {
            AbsStructMsgElement localAbsStructMsgElement = (AbsStructMsgElement)((Iterator)localObject).next();
            String str = localAbsStructMsgElement.jdField_a_of_type_JavaLangString;
            if ("title".equals(str)) {
              localStringBuilder.append(((StructMsgItemTitle)localAbsStructMsgElement).b());
            } else if ("summary".equals(str)) {
              localStringBuilder.append(((StructMsgItemSummary)localAbsStructMsgElement).b());
            }
          }
        }
      }
      return localStringBuilder.toString();
    }
    return "";
  }
  
  public ArrayList a(ChatMessage paramChatMessage)
  {
    AioAnimationRule localAioAnimationRule = null;
    Object localObject1 = null;
    Iterator localIterator = null;
    Object localObject2 = localIterator;
    if (paramChatMessage != null)
    {
      if (a(paramChatMessage)) {
        break label32;
      }
      localObject2 = localIterator;
    }
    label32:
    Object localObject3;
    do
    {
      return localObject2;
      localObject3 = AioAnimationConfigHelper.a().a();
      if (localObject3 != null) {
        break;
      }
      localObject2 = localIterator;
    } while (!QLog.isColorLevel());
    QLog.d("AioAnimationDetector", 2, "match : rules == null, just return;");
    return null;
    paramChatMessage.parse();
    long l1 = System.currentTimeMillis();
    if (b(paramChatMessage)) {
      localObject2 = a((AbsShareMsg)((MessageForStructing)paramChatMessage).structingMsg);
    }
    label115:
    long l2;
    for (;;)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localIterator = ((ArrayList)localObject3).iterator();
        paramChatMessage = localAioAnimationRule;
        localObject1 = paramChatMessage;
        if (localIterator.hasNext())
        {
          localAioAnimationRule = (AioAnimationRule)localIterator.next();
          if (localAioAnimationRule.jdField_a_of_type_JavaUtilArrayList == null) {
            break label401;
          }
          localObject1 = localAioAnimationRule.jdField_a_of_type_JavaUtilArrayList.iterator();
          for (;;)
          {
            if (!((Iterator)localObject1).hasNext()) {
              break label401;
            }
            localObject3 = (String)((Iterator)localObject1).next();
            if ((localObject2 != null) && (((String)localObject2).contains((CharSequence)localObject3)))
            {
              if (localAioAnimationRule.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAioAnimationRule$BussinessData == null) {
                break;
              }
              l2 = System.currentTimeMillis() / 1000L;
              if ((localAioAnimationRule.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAioAnimationRule$BussinessData.jdField_a_of_type_Int != 1) || ((localAioAnimationRule.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAioAnimationRule$BussinessData.jdField_b_of_type_Int <= l2) && (localAioAnimationRule.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAioAnimationRule$BussinessData.c >= l2))) {
                break;
              }
              if (QLog.isColorLevel()) {
                QLog.d("AioAnimationDetector", 2, "JD red pack,But not in date.");
              }
            }
          }
          localObject2 = paramChatMessage.msg;
          continue;
          if (paramChatMessage != null) {
            break label398;
          }
          paramChatMessage = new ArrayList();
          label292:
          paramChatMessage.add(localAioAnimationRule);
          localObject1 = paramChatMessage;
          if (QLog.isColorLevel()) {
            QLog.d("AioAnimationDetector", 2, "matched ===> rule: id=" + localAioAnimationRule.jdField_a_of_type_Int);
          }
        }
      }
    }
    label398:
    label401:
    for (localObject1 = paramChatMessage;; localObject1 = paramChatMessage)
    {
      paramChatMessage = (ChatMessage)localObject1;
      break label115;
      l2 = System.currentTimeMillis();
      localObject2 = localObject1;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("AioAnimationDetector", 2, "match duration: " + (l2 - l1) + " ms");
      return localObject1;
      break label292;
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    this.jdField_a_of_type_Long = -1L;
  }
  
  public void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    if ((paramQQAppInterface == null) || (paramSessionInfo == null) || (paramAIOAnimationConatiner == null)) {}
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("AioAnimationDetector", 2, "handleUnreadMsgList, hasUnRead=" + this.jdField_a_of_type_Boolean);
      }
      if ((this.jdField_a_of_type_Boolean) && (paramSessionInfo.jdField_a_of_type_Int != 1008))
      {
        int j = 0;
        int i;
        if ((paramSessionInfo.jdField_a_of_type_Int == 1) || (paramSessionInfo.jdField_a_of_type_Int == 3000)) {
          i = 1;
        }
        while ((i != 0) || (j != 0))
        {
          paramSessionInfo = paramQQAppInterface.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, -1L, true);
          long l = this.jdField_a_of_type_Long;
          j = 0;
          int n = paramSessionInfo.size();
          int m = 0;
          label139:
          ChatMessage localChatMessage;
          int k;
          ArrayList localArrayList;
          if (m < n)
          {
            localChatMessage = (ChatMessage)paramSessionInfo.get(m);
            if (i != 0)
            {
              k = j;
              if (localChatMessage.shmsgseq >= l)
              {
                k = j;
                if (!localChatMessage.isAioAnimChecked)
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("AioAnimationDetector", 2, "handleUnreadMsgList, troop&discussion message ===> (" + localChatMessage.shmsgseq + ")");
                  }
                  boolean bool = false;
                  if (m == n - 1) {
                    bool = true;
                  }
                  localArrayList = a(localChatMessage);
                  this.jdField_a_of_type_Long = localChatMessage.shmsgseq;
                  if (localArrayList == null) {
                    break label459;
                  }
                  a(paramQQAppInterface, localArrayList, true, localChatMessage, bool, paramAIOAnimationConatiner, j * 800);
                  j += 1;
                }
              }
            }
          }
          label459:
          for (;;)
          {
            k = j;
            for (;;)
            {
              m += 1;
              j = k;
              break label139;
              if (!MsgProxyUtils.c(paramSessionInfo.jdField_a_of_type_Int)) {
                break label462;
              }
              j = 1;
              i = 0;
              break;
              k = j;
              if (localChatMessage.time >= l)
              {
                k = j;
                if (!localChatMessage.isAioAnimChecked)
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("AioAnimationDetector", 2, "handleUnreadMsgList, c2c message ===> (" + localChatMessage.time + ")");
                  }
                  localArrayList = a(localChatMessage);
                  this.jdField_a_of_type_Long = localChatMessage.time;
                  k = j;
                  if (localArrayList != null)
                  {
                    a(paramQQAppInterface, localArrayList, false, localChatMessage, false, paramAIOAnimationConatiner, j * 800);
                    k = j + 1;
                  }
                }
              }
            }
            this.jdField_a_of_type_Boolean = false;
            return;
          }
          label462:
          i = 0;
        }
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner, int paramInt1, int paramInt2)
  {
    AioAnimationDetector localAioAnimationDetector = a();
    BaseApplicationImpl.getContext().getResources().getDrawable(2130845927);
    if (paramInt1 == 3) {
      paramSessionInfo = BaseApplicationImpl.getContext().getResources().getDrawable(2130845927);
    }
    for (;;)
    {
      if (paramSessionInfo != null) {
        localAioAnimationDetector.a(paramQQAppInterface, false, true, paramAIOAnimationConatiner, 0, paramSessionInfo, paramInt2);
      }
      do
      {
        return;
        if (paramInt1 == 4)
        {
          paramSessionInfo = BaseApplicationImpl.getContext().getResources().getDrawable(2130845913);
          break;
        }
        if (paramInt1 == 1)
        {
          paramSessionInfo = BaseApplicationImpl.getContext().getResources().getDrawable(2130845930);
          break;
        }
        if (paramInt1 == 2)
        {
          paramSessionInfo = BaseApplicationImpl.getContext().getResources().getDrawable(2130845916);
          break;
        }
        if (paramInt1 == 5)
        {
          paramSessionInfo = BaseApplicationImpl.getContext().getResources().getDrawable(2130845929);
          break;
        }
        if (paramInt1 == HotReactiveHelper.jdField_a_of_type_Int)
        {
          paramSessionInfo = BaseApplicationImpl.getContext().getResources().getDrawable(2130845923);
          break;
        }
      } while (paramInt1 != HotReactiveHelper.jdField_b_of_type_Int);
      paramSessionInfo = BaseApplicationImpl.getContext().getResources().getDrawable(2130845925);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, MessageRecord paramMessageRecord, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    if ((paramSessionInfo.jdField_a_of_type_Int == 1033) || (paramSessionInfo.jdField_a_of_type_Int == 1034))
    {
      break label20;
      break label20;
      break label20;
    }
    label20:
    label437:
    label441:
    for (;;)
    {
      return;
      if (!this.jdField_a_of_type_Boolean)
      {
        if (this.jdField_a_of_type_Long == -1L)
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("AioAnimationDetector", 2, "handleNewMsg, lastMsgIdOrTime == -1, just return");
          return;
        }
        if ((paramSessionInfo.jdField_a_of_type_Int == 1008) || (MsgProxyUtils.a(paramSessionInfo.jdField_a_of_type_Int) == 1032)) {
          break;
        }
        int j = 0;
        int i;
        if ((paramSessionInfo.jdField_a_of_type_Int == 1) || (paramSessionInfo.jdField_a_of_type_Int == 3000)) {
          i = 1;
        }
        for (;;)
        {
          label102:
          if (((i == 0) && (j == 0)) || (!paramSessionInfo.jdField_a_of_type_JavaLangString.equals(paramMessageRecord.frienduin)) || ((paramSessionInfo.jdField_a_of_type_Int != paramMessageRecord.istroop) && ((j == 0) || (!MsgProxyUtils.c(paramMessageRecord.istroop))))) {
            break label441;
          }
          paramSessionInfo = paramQQAppInterface.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, true);
          paramMessageRecord = a();
          long l = paramMessageRecord.jdField_a_of_type_Long;
          j = paramSessionInfo.size() - 1;
          label189:
          ChatMessage localChatMessage;
          ArrayList localArrayList;
          if (j >= 0)
          {
            localChatMessage = (ChatMessage)paramSessionInfo.get(j);
            if (i == 0) {
              break label337;
            }
            if (localChatMessage.shmsgseq <= l) {
              break;
            }
            if (!localChatMessage.isAioAnimChecked)
            {
              if (QLog.isColorLevel()) {
                QLog.d("AioAnimationDetector", 2, "handle troop&discussion new message ===> (" + localChatMessage.shmsgseq + ")");
              }
              localArrayList = paramMessageRecord.a(localChatMessage);
              if (localArrayList != null) {
                paramMessageRecord.a(paramQQAppInterface, localArrayList, true, localChatMessage, true, paramAIOAnimationConatiner, 0);
              }
              paramMessageRecord.jdField_a_of_type_Long = localChatMessage.shmsgseq;
            }
          }
          for (;;)
          {
            j -= 1;
            break label189;
            break label20;
            if (!MsgProxyUtils.c(paramSessionInfo.jdField_a_of_type_Int)) {
              break label437;
            }
            j = 1;
            i = 0;
            break label102;
            label337:
            if (localChatMessage.time <= l) {
              break;
            }
            if (!localChatMessage.isAioAnimChecked)
            {
              if (QLog.isColorLevel()) {
                QLog.d("AioAnimationDetector", 2, "handle c2c new message ===> (" + localChatMessage.time + ")");
              }
              localArrayList = paramMessageRecord.a(localChatMessage);
              if (localArrayList != null) {
                paramMessageRecord.a(paramQQAppInterface, localArrayList, false, localChatMessage, true, paramAIOAnimationConatiner, 0);
              }
              paramMessageRecord.jdField_a_of_type_Long = localChatMessage.time;
            }
          }
          i = 0;
        }
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, ArrayList paramArrayList, boolean paramBoolean1, ChatMessage paramChatMessage, boolean paramBoolean2, AIOAnimationConatiner paramAIOAnimationConatiner, int paramInt)
  {
    if ((paramQQAppInterface == null) || (paramChatMessage == null) || (paramAIOAnimationConatiner == null) || (paramArrayList == null) || (!a(paramChatMessage))) {}
    label74:
    AioAnimationRule localAioAnimationRule;
    int i;
    int m;
    Object localObject;
    int k;
    label450:
    label504:
    do
    {
      return;
      break label74;
      break label74;
      do
      {
        if (!paramChatMessage.isAioAnimChecked) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("AioAnimationDetector", 2, "detect : message is checked, just return;");
      return;
      paramChatMessage.isAioAnimChecked = true;
      EcShopAssistantManager localEcShopAssistantManager = (EcShopAssistantManager)paramQQAppInterface.getManager(87);
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        localAioAnimationRule = (AioAnimationRule)paramArrayList.next();
        i = paramChatMessage.getRepeatCount();
        j = localAioAnimationRule.jdField_b_of_type_Int;
        m = localAioAnimationRule.c;
        if (QLog.isColorLevel()) {
          QLog.d("AioAnimationDetector", 2, "detect : troopOrDiscussion=" + paramBoolean1 + " matched (" + paramChatMessage.uniseq + "), rule: id=" + localAioAnimationRule.jdField_a_of_type_Int + ",M=" + i + ",X=" + j + ",Y=" + m + ",crazyMode=" + localAioAnimationRule.jdField_a_of_type_Boolean);
        }
        if (paramBoolean1) {
          break label504;
        }
        if ((j == 0) && (m == 0))
        {
          if (QLog.isColorLevel()) {
            QLog.d("AioAnimationDetector", 2, "detect c2c =======>  egg_jumper animation, crazyModeEnable=" + localAioAnimationRule.jdField_a_of_type_Boolean);
          }
          a(paramQQAppInterface, paramChatMessage, 0, 3, localAioAnimationRule);
          if ((paramChatMessage instanceof MessageForStructing)) {
            a(paramQQAppInterface, paramChatMessage, 0);
          }
          if (localAioAnimationRule.jdField_a_of_type_Boolean)
          {
            j = localAioAnimationRule.jdField_b_of_type_JavaUtilArrayList.size();
            i = 0;
            while (i < j)
            {
              localObject = (AioAnimationRule.JumpImage)localAioAnimationRule.jdField_b_of_type_JavaUtilArrayList.get(i);
              localObject = AioAnimationRule.JumpImage.a(paramQQAppInterface.getApplication(), (AioAnimationRule.JumpImage)localObject);
              k = i * 800;
              this.jdField_a_of_type_AndroidOsHandler.postDelayed(new unb(this, paramAIOAnimationConatiner, (Drawable)localObject, k, localAioAnimationRule), paramInt + k);
              i += 1;
            }
          }
          localObject = (AioAnimationRule.JumpImage)localAioAnimationRule.jdField_b_of_type_JavaUtilArrayList.get(0);
          localObject = AioAnimationRule.JumpImage.a(paramQQAppInterface.getApplication(), (AioAnimationRule.JumpImage)localObject);
          this.jdField_a_of_type_AndroidOsHandler.postDelayed(new unc(this, paramAIOAnimationConatiner, (Drawable)localObject, localAioAnimationRule), paramInt);
        }
      }
      do
      {
        for (;;)
        {
          if ((localAioAnimationRule.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAioAnimationRule$BussinessData == null) || (localAioAnimationRule.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAioAnimationRule$BussinessData.jdField_a_of_type_Int != 1) || (localEcShopAssistantManager == null)) {
            break label1503;
          }
          localEcShopAssistantManager.jdField_b_of_type_Int = localAioAnimationRule.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAioAnimationRule$BussinessData.d;
          localEcShopAssistantManager.c = localAioAnimationRule.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAioAnimationRule$BussinessData.e;
          break label74;
          break;
          if ((j != 0) || (m != 0)) {
            break label731;
          }
          if (QLog.isColorLevel()) {
            QLog.d("AioAnimationDetector", 2, "detect =======>  egg_jumper animation ,crazyModeEnable=" + localAioAnimationRule.jdField_a_of_type_Boolean);
          }
          a(paramQQAppInterface, paramChatMessage, 1, 3, localAioAnimationRule);
          if ((paramChatMessage instanceof MessageForStructing)) {
            a(paramQQAppInterface, paramChatMessage, 1);
          }
          if (localAioAnimationRule.jdField_a_of_type_Boolean)
          {
            j = localAioAnimationRule.jdField_b_of_type_JavaUtilArrayList.size();
            i = 0;
            while (i < j)
            {
              localObject = (AioAnimationRule.JumpImage)localAioAnimationRule.jdField_b_of_type_JavaUtilArrayList.get(i);
              localObject = AioAnimationRule.JumpImage.a(paramQQAppInterface.getApplication(), (AioAnimationRule.JumpImage)localObject);
              k = i * 800;
              this.jdField_a_of_type_AndroidOsHandler.postDelayed(new und(this, paramAIOAnimationConatiner, (Drawable)localObject, k, localAioAnimationRule), paramInt + k);
              i += 1;
            }
          }
          else
          {
            localObject = (AioAnimationRule.JumpImage)localAioAnimationRule.jdField_b_of_type_JavaUtilArrayList.get(0);
            localObject = AioAnimationRule.JumpImage.a(paramQQAppInterface.getApplication(), (AioAnimationRule.JumpImage)localObject);
            this.jdField_a_of_type_AndroidOsHandler.postDelayed(new une(this, paramAIOAnimationConatiner, (Drawable)localObject, localAioAnimationRule), paramInt);
          }
        }
      } while (j >= m);
    } while (i < j);
    label731:
    if (i == m)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AioAnimationDetector", 2, "detect (M == Y) =======>  egg_combo animation, checkCombo= " + paramBoolean2);
      }
      if (paramBoolean2)
      {
        a(paramQQAppInterface, paramChatMessage, 1, 2, localAioAnimationRule);
        a(paramQQAppInterface, paramChatMessage, localAioAnimationRule);
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new unf(this, paramAIOAnimationConatiner, i, paramChatMessage), paramInt + 0);
      }
      if (QLog.isColorLevel()) {
        QLog.d("AioAnimationDetector", 2, "detect (M == Y) =======>  egg_jumper animation ,Y=" + m + ",crazyModeEnable=" + localAioAnimationRule.jdField_a_of_type_Boolean);
      }
      a(paramQQAppInterface, paramChatMessage, 1, 3, localAioAnimationRule);
      i = 0;
      if (i < m) {
        if (!paramBoolean2) {
          break label1511;
        }
      }
    }
    label898:
    label1503:
    label1505:
    label1511:
    for (int j = 1000;; j = 0)
    {
      if (localAioAnimationRule.jdField_a_of_type_Boolean)
      {
        int n = localAioAnimationRule.jdField_b_of_type_JavaUtilArrayList.size();
        k = 0;
        while (k < n)
        {
          localObject = (AioAnimationRule.JumpImage)localAioAnimationRule.jdField_b_of_type_JavaUtilArrayList.get(k);
          localObject = AioAnimationRule.JumpImage.a(paramQQAppInterface.getApplication(), (AioAnimationRule.JumpImage)localObject);
          int i1 = (k + i) * 800;
          this.jdField_a_of_type_AndroidOsHandler.postDelayed(new ung(this, paramAIOAnimationConatiner, (Drawable)localObject, i1, localAioAnimationRule), paramInt + j + i1);
          k += 1;
        }
      }
      localObject = (AioAnimationRule.JumpImage)localAioAnimationRule.jdField_b_of_type_JavaUtilArrayList.get(0);
      localObject = AioAnimationRule.JumpImage.a(paramQQAppInterface.getApplication(), (AioAnimationRule.JumpImage)localObject);
      k = i * 800;
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new unh(this, paramAIOAnimationConatiner, (Drawable)localObject, k, localAioAnimationRule), paramInt + j + k);
      i += 1;
      break label898;
      break label450;
      if (i > m)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AioAnimationDetector", 2, "detect (M > Y) =======>  egg_combo animation, checkCombo= " + paramBoolean2);
        }
        if (paramBoolean2)
        {
          a(paramQQAppInterface, paramChatMessage, 1, 2, localAioAnimationRule);
          a(paramQQAppInterface, paramChatMessage, localAioAnimationRule);
          this.jdField_a_of_type_AndroidOsHandler.postDelayed(new uni(this, paramAIOAnimationConatiner, i, paramChatMessage), paramInt + 0);
        }
        if (QLog.isColorLevel()) {
          QLog.d("AioAnimationDetector", 2, "detect (M > Y) =======>  egg_jumper animation ,Y=" + m + ",crazyModeEnable=" + localAioAnimationRule.jdField_a_of_type_Boolean);
        }
        a(paramQQAppInterface, paramChatMessage, 1, 3, localAioAnimationRule);
        if (!paramBoolean2) {
          break label1505;
        }
      }
      for (i = 1000;; i = 0)
      {
        if (localAioAnimationRule.jdField_a_of_type_Boolean)
        {
          k = localAioAnimationRule.jdField_b_of_type_JavaUtilArrayList.size();
          j = 0;
          while (j < k)
          {
            localObject = (AioAnimationRule.JumpImage)localAioAnimationRule.jdField_b_of_type_JavaUtilArrayList.get(j);
            localObject = AioAnimationRule.JumpImage.a(paramQQAppInterface.getApplication(), (AioAnimationRule.JumpImage)localObject);
            m = j * 800;
            this.jdField_a_of_type_AndroidOsHandler.postDelayed(new umy(this, paramAIOAnimationConatiner, (Drawable)localObject, m, localAioAnimationRule), paramInt + i + m);
            j += 1;
          }
          break label450;
        }
        localObject = (AioAnimationRule.JumpImage)localAioAnimationRule.jdField_b_of_type_JavaUtilArrayList.get(0);
        localObject = AioAnimationRule.JumpImage.a(paramQQAppInterface.getApplication(), (AioAnimationRule.JumpImage)localObject);
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new umz(this, paramAIOAnimationConatiner, (Drawable)localObject, localAioAnimationRule), paramInt + i);
        break label450;
        if (QLog.isColorLevel()) {
          QLog.d("AioAnimationDetector", 2, "detect (X <= M < Y) ======>  egg_combo animation, checkCombo= " + paramBoolean2);
        }
        if (!paramBoolean2) {
          break;
        }
        a(paramQQAppInterface, paramChatMessage, 1, 2, localAioAnimationRule);
        a(paramQQAppInterface, paramChatMessage, localAioAnimationRule);
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new una(this, paramAIOAnimationConatiner, i, paramChatMessage), 0 + paramInt);
        break label450;
        break label74;
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, boolean paramBoolean1, boolean paramBoolean2, AIOAnimationConatiner paramAIOAnimationConatiner, int paramInt1, Drawable paramDrawable, int paramInt2)
  {
    int i = 0;
    while (i < paramInt2)
    {
      int j = i * 800;
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new umx(this, paramAIOAnimationConatiner, paramDrawable, j), j + paramInt1);
      i += 1;
    }
  }
  
  public boolean a(ChatMessage paramChatMessage)
  {
    if ((!(paramChatMessage instanceof MessageForText)) && (!(paramChatMessage instanceof MessageForLongMsg)) && (!(paramChatMessage instanceof MessageForStructing)) && (!(paramChatMessage instanceof MessageForArkFlashChat)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AioAnimationDetector", 2, "checkMsgType : not MessageForText and MessageForLongMsg and MessageFlashChat, return false;");
      }
      return false;
    }
    if ((paramChatMessage instanceof MessageForText)) {
      if (QLog.isColorLevel()) {
        QLog.d("AioAnimationDetector", 2, "checkMsgType : messageForText");
      }
    }
    for (;;)
    {
      return true;
      if ((paramChatMessage instanceof MessageForLongMsg))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AioAnimationDetector", 2, "checkMsgType : MessageForLongMsg");
        }
      }
      else if ((paramChatMessage instanceof MessageForStructing))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AioAnimationDetector", 2, "checkMsgType : MessageForStructing");
        }
      }
      else if (((paramChatMessage instanceof MessageForArkFlashChat)) && (QLog.isColorLevel())) {
        QLog.d("AioAnimationDetector", 2, "checkMsgType : MessageForStructing");
      }
    }
  }
  
  public boolean b(ChatMessage paramChatMessage)
  {
    if ((paramChatMessage instanceof MessageForStructing))
    {
      paramChatMessage = ((MessageForStructing)paramChatMessage).structingMsg;
      if (paramChatMessage != null) {
        break label36;
      }
      if (QLog.isColorLevel()) {
        QLog.d("AioAnimationDetector", 2, "msg type is MessageForStructing, strctMsg is null");
      }
    }
    return false;
    label36:
    return paramChatMessage instanceof AbsShareMsg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.AioAnimationDetector
 * JD-Core Version:    0.7.0.1
 */