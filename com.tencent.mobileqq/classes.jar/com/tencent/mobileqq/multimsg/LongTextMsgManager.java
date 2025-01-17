package com.tencent.mobileqq.multimsg;

import aejf;
import aejg;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.MsgProxy;
import com.tencent.mobileqq.app.message.MultiMsgProxy;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.manager.Manager;

public class LongTextMsgManager
  implements Manager
{
  public static boolean a;
  private static byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  private long jdField_a_of_type_Long;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public boolean b;
  public boolean c;
  
  static
  {
    jdField_a_of_type_Boolean = true;
  }
  
  public LongTextMsgManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    paramMessageRecord.extraflag = 32768;
    paramQQAppInterface.a().a(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.uniseq);
    String str = paramMessageRecord.frienduin;
    int i = paramMessageRecord.istroop;
    long l = paramMessageRecord.uniseq;
    ((MessageHandler)paramQQAppInterface.a(0)).a(MessageHandler.c(paramMessageRecord.istroop), false, new Object[] { str, Integer.valueOf(i), Integer.valueOf(-1), null, Long.valueOf(0L), Long.valueOf(l) });
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt, long paramLong, String paramString2)
  {
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("StructLongTextMsg", 2, "requestDownloadLongTextMsg begin! touin:" + paramString1 + ",touinType:" + paramInt + ",uniseq:" + paramLong + ",fileKey:" + paramString2);
    }
    MultiMsgManager.a().a(paramQQAppInterface, paramString2, paramQQAppInterface.getCurrentAccountUin(), paramString1, paramString1, paramInt, paramLong, 1035, new aejg(paramQQAppInterface, paramString1, paramInt, paramLong, l));
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    LongTextMsgManager localLongTextMsgManager = (LongTextMsgManager)paramQQAppInterface.getManager(165);
    if (!localLongTextMsgManager.b)
    {
      String str = paramQQAppInterface.getAccount();
      paramQQAppInterface = PreferenceManager.getDefaultSharedPreferences(paramQQAppInterface.getApp());
      if (paramQQAppInterface.contains(str + "_" + "long_text_msg_config_version")) {
        localLongTextMsgManager.c = paramQQAppInterface.getBoolean(str + "_" + "long_text_msg_switch", jdField_a_of_type_Boolean);
      }
    }
    localLongTextMsgManager.b = true;
    return localLongTextMsgManager.c;
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool = false;
    if (paramInt2 == 0) {
      bool = true;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_resultCode", String.valueOf(paramInt2));
    localHashMap.put("param_uin", paramQQAppInterface.getCurrentAccountUin());
    localHashMap.put("param_isTroop", String.valueOf(paramInt1));
    switch (paramInt3)
    {
    default: 
      return;
    case 1: 
      StatisticCollector.a(BaseApplication.getContext()).a(paramQQAppInterface.getCurrentAccountUin(), "ltextAutoPullResult", bool, 0L, 0L, localHashMap, "");
      return;
    }
    StatisticCollector.a(BaseApplication.getContext()).a(paramQQAppInterface.getCurrentAccountUin(), "ltextManualPullResult", bool, 0L, 0L, localHashMap, "");
  }
  
  public void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StructLongTextMsg", 4, " sendLongTextMsg start");
    }
    if (paramMessageRecord == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("StructLongTextMsg", 2, "step1: sendLongTextMsg saveMessage start currenttime:" + System.currentTimeMillis());
      }
      if ((paramMessageRecord instanceof ChatMessage)) {
        ((ChatMessage)paramMessageRecord).mPendantAnimatable = true;
      }
      if ((!paramBoolean) || (TextUtils.isEmpty(paramMessageRecord.extStr)))
      {
        paramMessageRecord.saveExtInfoToExtStr("long_text_recv_state", "0");
        paramQQAppInterface.a().b(paramMessageRecord, paramQQAppInterface.getCurrentAccountUin());
        if (QLog.isColorLevel()) {
          QLog.d("StructLongTextMsg", 2, "saveLongTextMsg reSend:" + paramBoolean + ",extStr:" + paramMessageRecord.extStr);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("StructLongTextMsg", 2, "step2: sendLongTextMsg saveMessage end and pack longTextMsg start currenttime:" + System.currentTimeMillis());
      }
      Object localObject = paramQQAppInterface.a().a().a(paramMessageRecord);
      if (localObject == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("StructLongTextMsg", 2, "step2: sendLongTextMsg pack failed! packData is null.............................");
        }
        paramMessageRecord.extraflag = 32768;
        paramQQAppInterface.a().a(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.uniseq);
        localObject = paramMessageRecord.frienduin;
        int i = paramMessageRecord.istroop;
        long l = paramMessageRecord.uniseq;
        ((MessageHandler)paramQQAppInterface.a(0)).a(MessageHandler.c(paramMessageRecord.istroop), false, new Object[] { localObject, Integer.valueOf(i), Integer.valueOf(-1), null, Long.valueOf(0L), Long.valueOf(l) });
        return;
      }
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      paramBoolean = a(paramQQAppInterface, (byte[])localObject, paramQQAppInterface.getCurrentAccountUin(), paramMessageRecord.frienduin, paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.uniseq, 1035, new aejf(this, paramQQAppInterface, paramMessageRecord, paramBoolean));
      if (!paramBoolean) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("StructLongTextMsg", 2, "sendLongTextMsg successful, uploadLongTextMsgPkg start!");
    return;
    if (QLog.isColorLevel()) {
      QLog.d("StructLongTextMsg", 2, "sendLongTextMsg failed! isSuccess:" + paramBoolean);
    }
    a(paramQQAppInterface, paramMessageRecord);
  }
  
  public void a(String paramString, int paramInt1, long paramLong1, int paramInt2, long paramLong2)
  {
    try
    {
      MessageRecord localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(paramString, paramInt1, paramLong1);
      if (localMessageRecord != null)
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("param_istroop", String.valueOf(localMessageRecord.istroop));
        localHashMap.put("param_msgtype", String.valueOf(localMessageRecord.msgtype));
        localHashMap.put("param_replycode", String.valueOf(paramInt2));
        localHashMap.put("param_cost", String.valueOf(paramLong2));
        localHashMap.put("param_isAnonymous", String.valueOf(AnonymousChatHelper.a(localMessageRecord)));
        if (localMessageRecord.msgtype == -1051) {
          StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "ltextNewSendResult", true, 0L, 0L, localHashMap, "");
        }
        while (QLog.isColorLevel())
        {
          QLog.d("StructLongTextMsg", 2, "reportSendLongMsg  peerUin:" + paramString + " istroop=" + localMessageRecord.istroop + " issend=" + localMessageRecord.issend + " msgType=" + localMessageRecord.msgtype + " longMsgCount=" + localMessageRecord.longMsgCount + " longMsgId=" + localMessageRecord.longMsgId + " longMsgIndex=" + localMessageRecord.longMsgIndex + " replyCost=" + paramInt2 + " cost=" + paramLong2);
          return;
          if ((!localMessageRecord.isLongMsg()) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(localMessageRecord))) {
            break;
          }
          localHashMap.put("param_longMsgCount", String.valueOf(localMessageRecord.longMsgCount));
          localHashMap.put("param_longMsgId", String.valueOf(localMessageRecord.longMsgId));
          localHashMap.put("param_longMsgIndex", String.valueOf(localMessageRecord.longMsgIndex));
          StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "ltextOldSendResult", true, 0L, 0L, localHashMap, "");
        }
      }
      return;
    }
    catch (Exception paramString)
    {
      QLog.d("StructLongTextMsg", 1, "longmsg send report error!", paramString);
    }
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte, String paramString1, String paramString2, String paramString3, int paramInt1, long paramLong, int paramInt2, UpCallBack paramUpCallBack)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StructLongTextMsg", 2, "[sendLongTextMsg]data.length = " + paramArrayOfByte.length);
    }
    TransferRequest localTransferRequest = new TransferRequest();
    localTransferRequest.jdField_a_of_type_Boolean = true;
    localTransferRequest.jdField_b_of_type_Int = 131078;
    localTransferRequest.h = 1;
    localTransferRequest.jdField_b_of_type_ArrayOfByte = paramArrayOfByte;
    localTransferRequest.jdField_b_of_type_JavaLangString = paramString1;
    localTransferRequest.c = paramString2;
    localTransferRequest.d = paramString3;
    localTransferRequest.jdField_a_of_type_Int = paramInt1;
    localTransferRequest.jdField_a_of_type_Long = paramLong;
    localTransferRequest.e = paramInt2;
    localTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack = paramUpCallBack;
    paramQQAppInterface.a().a(localTransferRequest);
    return true;
  }
  
  public void b(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StructLongTextMsg", 2, "reportReceiveLongMsg  istroop=" + paramMessageRecord.istroop + " issend=" + paramMessageRecord.issend + " msgType=" + paramMessageRecord.msgtype + " longMsgCount=" + paramMessageRecord.longMsgCount + " longMsgId=" + paramMessageRecord.longMsgId + " longMsgIndex=" + paramMessageRecord.longMsgIndex);
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_istroop", String.valueOf(paramMessageRecord.istroop));
    localHashMap.put("param_issend", String.valueOf(paramMessageRecord.issend));
    localHashMap.put("param_msgtype", String.valueOf(paramMessageRecord.msgtype));
    localHashMap.put("param_isAnonymous", String.valueOf(AnonymousChatHelper.a(paramMessageRecord)));
    if (paramMessageRecord.msgtype == -1051) {
      StatisticCollector.a(BaseApplication.getContext()).a(paramQQAppInterface.getCurrentAccountUin(), "ltextNewReceiveResult", true, 0L, 0L, localHashMap, "");
    }
    while (!paramMessageRecord.isLongMsg()) {
      return;
    }
    localHashMap.put("param_longMsgCount", String.valueOf(paramMessageRecord.longMsgCount));
    localHashMap.put("param_longMsgId", String.valueOf(paramMessageRecord.longMsgId));
    localHashMap.put("param_longMsgIndex", String.valueOf(paramMessageRecord.longMsgIndex));
    StatisticCollector.a(BaseApplication.getContext()).a(paramQQAppInterface.getCurrentAccountUin(), "ltextOldReceiveResult", true, 0L, 0L, localHashMap, "");
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.multimsg.LongTextMsgManager
 * JD-Core Version:    0.7.0.1
 */