package com.tencent.av.app;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.SystemMessageProcessor;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.systemmsg.FriendSystemMsgController;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jec;
import jed;
import jee;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsgAction;
import tencent.mobileim.structmsg.structmsg.SystemMsgActionInfo;

public class AvAddFriendService
{
  public static String a;
  public int a;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new jec(this);
  MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new jed(this);
  public QQAppInterface a;
  public HashMap a;
  public boolean a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "AvAddFriendService";
  }
  
  public AvAddFriendService(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "AvAddFriendLogic");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
  }
  
  private void a(String paramString, int paramInt)
  {
    if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "setRelationStatus no uin in map:" + paramString);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "setRelationStatus :" + paramString + ",status" + paramInt);
    }
    ((jee)this.jdField_a_of_type_JavaUtilHashMap.get(paramString)).b = paramInt;
  }
  
  private void a(String paramString, int paramInt1, int paramInt2)
  {
    if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "setRelationStatus no uin in map:" + paramString);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "setRelationStatus :" + paramString + ",status" + paramInt1 + ",safeStatus:" + paramInt2);
    }
    ((jee)this.jdField_a_of_type_JavaUtilHashMap.get(paramString)).b = paramInt1;
    ((jee)this.jdField_a_of_type_JavaUtilHashMap.get(paramString)).b = paramInt2;
  }
  
  private void a(structmsg.StructMsg paramStructMsg, long paramLong)
  {
    if (paramStructMsg != null)
    {
      long l = ((structmsg.StructMsg)paramStructMsg.get()).msg_seq.get() + ((structmsg.StructMsg)paramStructMsg.get()).msg_type.get();
      FriendSystemMsgController.a().a(Long.valueOf(l), (structmsg.StructMsg)paramStructMsg.get());
      FriendSystemMsgController.a().b(l);
      FriendSystemMsgController.a().a(paramLong);
    }
  }
  
  private boolean a(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    if (paramString.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
      return false;
    }
    for (;;)
    {
      try
      {
        Long.parseLong(paramString);
        FriendsManager localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
        if (localFriendsManager != null)
        {
          paramString = localFriendsManager.c(paramString);
          if ((paramString == null) || (paramString.groupid < 0)) {
            break;
          }
          return false;
        }
      }
      catch (Throwable paramString)
      {
        return false;
      }
      paramString = null;
    }
    return true;
  }
  
  private void d(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1) != null) {
      ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).a(paramString, this.jdField_a_of_type_Int, 0, "");
    }
  }
  
  public int a(String paramString)
  {
    if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "getRelationStatus no uin in map:" + paramString);
      }
      return 0;
    }
    return ((jee)this.jdField_a_of_type_JavaUtilHashMap.get(paramString)).b;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "AvAddFriendLogic onDestory");
    }
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
  
  public void a(String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("tencent.video.q2v.AddfrindMsg");
    localIntent.putExtra("peerUin", paramString);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().sendBroadcast(localIntent);
    }
  }
  
  public boolean a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "addFriend uin is null");
      }
      return false;
    }
    this.jdField_a_of_type_Int = paramInt;
    if (((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).b(paramString))
    {
      localjee = new jee(this);
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localjee);
      a(paramString, 4);
      a(paramString);
      return true;
    }
    if (!a(1, paramString)) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "addFriend uin" + paramString);
    }
    jee localjee = new jee(this);
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localjee);
    ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).a("OidbSvc.0x476_147", Long.parseLong(paramString), 147);
    return true;
  }
  
  public void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      this.jdField_a_of_type_JavaUtilHashMap.clear();
    }
    while (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilHashMap.remove(paramString);
  }
  
  public void c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "acceptAddFriend uin is null");
      }
    }
    label514:
    do
    {
      List localList;
      structmsg.StructMsg localStructMsg;
      do
      {
        do
        {
          return;
          new ArrayList();
          localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(AppConstants.K, 0);
          localStructMsg = null;
          if (localList != null) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d(jdField_a_of_type_JavaLangString, 2, "systemMsgList is null");
        return;
        if ((localList.size() <= 0) || ((localList.get(0) instanceof MessageForSystemMsg))) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d(jdField_a_of_type_JavaLangString, 2, "systemMsgList error");
      return;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "answerAddFriend systemMsgList size" + localList.size());
      }
      int i = localList.size() - 1;
      for (;;)
      {
        if (i >= 0)
        {
          localStructMsg = ((MessageForSystemMsg)localList.get(i)).getSystemMsg();
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "answerAddFriend structMsg.req_uin =" + String.valueOf(localStructMsg.req_uin.get()) + "friendUin=" + paramString);
          }
          if (!paramString.equals(String.valueOf(localStructMsg.req_uin.get()))) {}
        }
        else
        {
          if ((localStructMsg == null) || (!paramString.equals(String.valueOf(localStructMsg.req_uin.get())))) {
            break label514;
          }
          i = localStructMsg.msg_type.get();
          long l1 = localStructMsg.msg_seq.get();
          long l2 = localStructMsg.req_uin.get();
          int j = localStructMsg.msg.sub_type.get();
          int k = localStructMsg.msg.src_id.get();
          int m = localStructMsg.msg.sub_src_id.get();
          int n = localStructMsg.msg.group_msg_type.get();
          paramString = localStructMsg.msg.actions.get();
          if ((paramString == null) || (paramString.size() >= 0)) {
            break;
          }
          paramString = (structmsg.SystemMsgActionInfo)((structmsg.SystemMsgAction)paramString.get(0)).action_info.get();
          paramString.remark.set("");
          paramString.group_id.set(0);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(i, l1, l2, j, k, m, n, paramString, 0, localStructMsg, false);
          a(localStructMsg, localStructMsg.msg_seq.get());
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d(jdField_a_of_type_JavaLangString, 2, "answerAddFriend  structMsg.req_uin:  " + String.valueOf(localStructMsg.req_uin.get()));
          return;
        }
        i -= 1;
      }
    } while (!QLog.isColorLevel());
    QLog.d(jdField_a_of_type_JavaLangString, 2, "answerAddFriend  structMsg == null | , friendUin == structMsg.req_uin | ");
  }
  
  protected void finalize()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "finalize");
      }
      return;
    }
    finally
    {
      super.finalize();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.av.app.AvAddFriendService
 * JD-Core Version:    0.7.0.1
 */