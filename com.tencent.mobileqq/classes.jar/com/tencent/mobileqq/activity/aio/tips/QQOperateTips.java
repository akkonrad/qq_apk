package com.tencent.mobileqq.activity.aio.tips;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.operation.QQOperateManager;
import com.tencent.mobileqq.config.operation.QQOperationViopTipTask;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import wdd;
import wde;
import wdf;

public class QQOperateTips
  implements GrayTipsTask, TipsBarTask
{
  private int jdField_a_of_type_Int = -1;
  private long jdField_a_of_type_Long = -1L;
  private ChatAdapter1 jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private TipsManager jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private XPanelContainer jdField_a_of_type_ComTencentWidgetXPanelContainer;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  protected List a;
  private long b = -1L;
  
  public QQOperateTips(QQAppInterface paramQQAppInterface, TipsManager paramTipsManager, Context paramContext, XPanelContainer paramXPanelContainer, List paramList, SessionInfo paramSessionInfo, ChatAdapter1 paramChatAdapter1)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer = paramXPanelContainer;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager = paramTipsManager;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 = paramChatAdapter1;
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new wdd(this));
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new wde(this));
  }
  
  private void b(QQOperationViopTipTask paramQQOperationViopTipTask)
  {
    List localList = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a();
    if (localList == null) {
      return;
    }
    int j = localList.size();
    int i = j - 1;
    label27:
    if (i >= 0) {
      if (i < j - 10) {
        i = 0;
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("QQOperateTips", 2, " findExcludeMsg, just return ");
        return;
        if (((ChatMessage)localList.get(i)).msgtype == -1043)
        {
          i = 1;
          continue;
        }
        i -= 1;
        break label27;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this, new Object[] { paramQQOperationViopTipTask });
      return;
      i = 0;
    }
  }
  
  public int a()
  {
    return 40;
  }
  
  public View a(Object... paramVarArgs)
  {
    if ((paramVarArgs[0] instanceof QQOperationViopTipTask))
    {
      paramVarArgs = (QQOperationViopTipTask)paramVarArgs[0];
      if ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null)) {
        return null;
      }
      View localView = LayoutInflater.from((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).inflate(2130970190, null);
      TextView localTextView = (TextView)localView.findViewById(2131369484);
      Button localButton = (Button)localView.findViewById(2131369483);
      localTextView.setText(paramVarArgs.adwords);
      localButton.setText(paramVarArgs.clickableWord);
      localButton.setOnClickListener(new wdf(this, paramVarArgs));
      return localView;
    }
    return null;
  }
  
  public MessageRecord a(Object... paramVarArgs)
  {
    if ((paramVarArgs[0] instanceof QQOperationViopTipTask))
    {
      paramVarArgs = (QQOperationViopTipTask)paramVarArgs[0];
      MessageRecord localMessageRecord = MessageRecordFactory.a(-1041);
      long l = MessageCache.a();
      localMessageRecord.init(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), paramVarArgs.adwords + "|" + paramVarArgs.clickableWord + "|" + paramVarArgs.linkOffset + "|" + paramVarArgs.url + "|" + paramVarArgs.taskid, l, -1041, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, l);
      localMessageRecord.isread = true;
      if (!MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageRecord, false)) {
        return localMessageRecord;
      }
      return null;
    }
    return null;
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000)) {}
    do
    {
      return;
      if (paramInt == 1000)
      {
        a();
        return;
      }
    } while (paramInt != 1001);
    b();
  }
  
  public void a(QQOperationViopTipTask paramQQOperationViopTipTask)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this, new Object[] { paramQQOperationViopTipTask });
  }
  
  public void a(List paramList)
  {
    QQOperateManager localQQOperateManager = QQOperateManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    paramList = paramList.iterator();
    label147:
    while (paramList.hasNext())
    {
      int i = ((QQOperationViopTipTask)paramList.next()).taskid;
      QQOperationViopTipTask localQQOperationViopTipTask = localQQOperateManager.a(i);
      if ((QLog.isDevelopLevel()) && (localQQOperationViopTipTask == null)) {
        QLog.d("QQOperateVoIP", 4, "on showTips, voipTask is null, taskId=" + i);
      }
      if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 0) {}
      for (i = 1;; i = 0)
      {
        if (localQQOperationViopTipTask == null) {
          break label123;
        }
        if (!localQQOperationViopTipTask.isBlueTipsTask()) {
          break label147;
        }
        if (i == 0) {
          break label125;
        }
        a(localQQOperationViopTipTask);
        break;
      }
      label123:
      continue;
      label125:
      if (this.jdField_a_of_type_JavaUtilList != null)
      {
        this.jdField_a_of_type_JavaUtilList.add(localQQOperationViopTipTask);
        continue;
        if ((localQQOperationViopTipTask.isGryTipsTask()) && (!localQQOperateManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 2))) {
          b(localQQOperationViopTipTask);
        }
      }
    }
  }
  
  public int[] a()
  {
    return null;
  }
  
  public int b()
  {
    return 6;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.QQOperateTips
 * JD-Core Version:    0.7.0.1
 */