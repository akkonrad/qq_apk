package com.tencent.mobileqq.activity;

import AccostSvc.EventItem;
import MessageSvcPack.UinPairReadInfo;
import NS_MOBILE_AIONewestFeed.AIONewestFeedRsp;
import NS_MOBILE_AIONewestFeed.NewestFeedInfo;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.text.format.Time;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;
import cfs;
import cft;
import cfu;
import cfv;
import cfw;
import cfy;
import cfz;
import com.qq.taf.jce.JceOutputStream;
import com.tencent.av.gaudio.GAudioNotifyCenter;
import com.tencent.biz.common.util.SubString;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.VoiceNotifyConfigHelper;
import com.tencent.mobileqq.activity.aio.VoiceNotifyRules;
import com.tencent.mobileqq.activity.aio.VoiceNotifyRules.RuleItem;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.app.TroopQZoneUploadAlbumHandler;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.config.operation.QQOperateManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForFunnyFace;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForShakeWindow;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForTroopUnreadTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentEmotionData;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerRSCenter;
import com.tencent.mobileqq.filemanager.core.OnlineFileSessionCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.pic.PicBusiManager;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.pic.PicUploadInfo.Builder;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.service.MobileQQService;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.servlet.QZoneFeedsServlet;
import com.tencent.mobileqq.servlet.ReduFriendServlet;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.streamtransfile.StreamDataManager;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsShareMsg.Builder;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.StructMsgElementFactory;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.structmsg.StructMsgHelper;
import com.tencent.mobileqq.structmsg.TestStructMsg;
import com.tencent.mobileqq.stt.SttManager;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.QQText.EmotcationSpan;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.TranDbRecord.PicDbRecord;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.TransfileUtile;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ForwardSendPicUtil;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.MsgUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ChatActivityFacade
{
  public static final int a = 3478;
  public static long a = 0L;
  private static Time jdField_a_of_type_AndroidTextFormatTime;
  private static cfz jdField_a_of_type_Cfz = new cfz();
  private static final String jdField_a_of_type_JavaLangString = ChatActivityFacade.class.getSimpleName();
  private static HashMap jdField_a_of_type_JavaUtilHashMap;
  private static final short jdField_a_of_type_Short = 8;
  public static final boolean a = true;
  public static final int b = 1;
  private static HashMap b = new HashMap();
  public static final int c = 2;
  private static HashMap c = new HashMap();
  public static final int d = 3;
  private static HashMap d = new HashMap();
  private static HashMap e = new HashMap();
  
  static
  {
    jdField_a_of_type_AndroidTextFormatTime = new Time();
    jdField_a_of_type_Long = -1L;
    jdField_a_of_type_JavaUtilHashMap = null;
  }
  
  public static int a(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    Object localObject3 = paramQQAppInterface.a();
    Object localObject4 = (String)localObject3 + "_" + paramString;
    if (QLog.isColorLevel()) {
      QLog.d(ReduFriendServlet.jdField_b_of_type_JavaLangString, 2, "shouldShowHotFriendVoiceCallBar() is called,mapKey is:" + (String)localObject4);
    }
    Object localObject2 = "";
    localObject1 = localObject2;
    for (;;)
    {
      try
      {
        if (b.get(localObject4) == null) {
          continue;
        }
        localObject1 = localObject2;
        localObject3 = (Integer)c.get(localObject4);
        if (localObject3 != null)
        {
          localObject1 = localObject2;
          if (((Integer)localObject3).intValue() > 3) {
            continue;
          }
        }
        localObject1 = localObject2;
        localObject3 = ((FriendManager)paramQQAppInterface.getManager(8)).c(paramString);
        if (localObject3 == null) {
          continue;
        }
        localObject1 = localObject2;
        if ((((Friends)localObject3).abilityBits & 1L) == 0L) {
          continue;
        }
        localObject1 = localObject2;
        i = ((Friends)localObject3).getNetWorkType();
        if (i != 2) {
          continue;
        }
        j = 2;
        i = j;
        if (QLog.isColorLevel())
        {
          QLog.d(ReduFriendServlet.jdField_b_of_type_JavaLangString, 2, "step is:" + "");
          i = j;
        }
      }
      finally
      {
        try
        {
          int j;
          long l;
          int k;
          int m;
          int n;
          int i1;
          ReportController.b(paramQQAppInterface, "CliOper", "", "", "Free_call", "Free_call_tips", 0, 0, "", "", "", "");
          int i = 1;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d(ReduFriendServlet.jdField_b_of_type_JavaLangString, 2, "step is:" + "can show hot friend voice call bar");
          return 1;
        }
        finally
        {
          localObject1 = "can show hot friend voice call bar";
        }
        paramQQAppInterface = finally;
      }
      return i;
      i = 1;
      if (QLog.isColorLevel())
      {
        QLog.d(ReduFriendServlet.jdField_b_of_type_JavaLangString, 2, "step is:" + "find true flag from memory");
        return 1;
        localObject1 = localObject2;
        d(paramQQAppInterface, paramString);
        i = 2;
        if (QLog.isColorLevel())
        {
          QLog.d(ReduFriendServlet.jdField_b_of_type_JavaLangString, 2, "step is:" + "find true flag from memory but friend abilityBits does not contain support voice flag");
          return 2;
          localObject1 = localObject2;
          d(paramQQAppInterface, paramString);
          localObject1 = localObject2;
          paramQQAppInterface = "find true flag from memory but enterAIOTimes is too large,enterAIOTimes is:" + localObject3 + ",MAX_ENTER_TIMES is:" + 3;
          i = 2;
          if (QLog.isColorLevel())
          {
            QLog.d(ReduFriendServlet.jdField_b_of_type_JavaLangString, 2, "step is:" + paramQQAppInterface);
            return 2;
            localObject1 = localObject2;
            localObject4 = BaseApplication.getContext().getSharedPreferences("free_call", 0);
            localObject1 = localObject2;
            if (((SharedPreferences)localObject4).getBoolean(a((String)localObject3), false))
            {
              i = 2;
              if (QLog.isColorLevel())
              {
                QLog.d(ReduFriendServlet.jdField_b_of_type_JavaLangString, 2, "step is:" + "has shown hot friend tip");
                return 2;
              }
            }
            else
            {
              localObject1 = localObject2;
              localObject4 = ((SharedPreferences)localObject4).getString("voice_remark_tip_show_time" + (String)localObject3, "");
              localObject1 = localObject2;
              l = MessageCache.a() * 1000L;
              localObject1 = localObject2;
              if (QLog.isColorLevel())
              {
                localObject1 = localObject2;
                QLog.d(ReduFriendServlet.jdField_b_of_type_JavaLangString, 2, "multiRemarkTipShowTime is:" + (String)localObject4 + ",currTimeMillis is:" + l);
              }
              if (localObject4 != null)
              {
                localObject1 = localObject2;
                if (((String)localObject4).length() > 0)
                {
                  localObject1 = localObject2;
                  localObject4 = ((String)localObject4).split("\\|");
                  localObject1 = localObject2;
                  jdField_a_of_type_AndroidTextFormatTime.set(l);
                  localObject1 = localObject2;
                  i = jdField_a_of_type_AndroidTextFormatTime.year;
                  localObject1 = localObject2;
                  j = jdField_a_of_type_AndroidTextFormatTime.month;
                  localObject1 = localObject2;
                  k = jdField_a_of_type_AndroidTextFormatTime.monthDay;
                  localObject1 = localObject2;
                  jdField_a_of_type_AndroidTextFormatTime.set(Long.parseLong(localObject4[(localObject4.length - 1)]));
                  localObject1 = localObject2;
                  m = jdField_a_of_type_AndroidTextFormatTime.year;
                  localObject1 = localObject2;
                  n = jdField_a_of_type_AndroidTextFormatTime.month;
                  localObject1 = localObject2;
                  i1 = jdField_a_of_type_AndroidTextFormatTime.monthDay;
                  if ((i == m) && (j == n) && (k == i1))
                  {
                    i = 2;
                    if (!QLog.isColorLevel()) {
                      continue;
                    }
                    QLog.d(ReduFriendServlet.jdField_b_of_type_JavaLangString, 2, "step is:" + "has shown remark tip this day");
                    return 2;
                  }
                }
              }
              localObject1 = localObject2;
              if (!NetworkUtil.g(BaseApplication.getContext()))
              {
                localObject1 = localObject2;
                if (!NetworkUtil.d(BaseApplication.getContext()))
                {
                  i = 2;
                  if (!QLog.isColorLevel()) {
                    continue;
                  }
                  QLog.d(ReduFriendServlet.jdField_b_of_type_JavaLangString, 2, "step is:" + "my network is not wifi or 3g or 4g");
                  return 2;
                }
              }
              localObject1 = localObject2;
              localObject4 = a(paramQQAppInterface, (String)localObject3, MessageCache.a());
              if (localObject4 == null)
              {
                paramString = "there is no hot friend,need to pull";
                if (paramBoolean)
                {
                  localObject1 = paramString;
                  localObject2 = new NewIntent(paramQQAppInterface.a(), ReduFriendServlet.class);
                  localObject1 = paramString;
                  ((NewIntent)localObject2).putExtra("k_uin", (String)localObject3);
                  localObject1 = paramString;
                  paramQQAppInterface.startServlet((NewIntent)localObject2);
                  i = 3;
                  if (QLog.isColorLevel())
                  {
                    QLog.d(ReduFriendServlet.jdField_b_of_type_JavaLangString, 2, "step is:" + "there is no hot friend,need to pull");
                    return 3;
                  }
                }
                else
                {
                  i = 2;
                  if (QLog.isColorLevel())
                  {
                    QLog.d(ReduFriendServlet.jdField_b_of_type_JavaLangString, 2, "step is:" + "there is no hot friend,need to pull");
                    return 2;
                  }
                }
              }
              else
              {
                localObject1 = localObject2;
                localObject3 = new HashMap();
                i = 0;
                localObject1 = localObject2;
                if (i < localObject4.length)
                {
                  localObject1 = localObject2;
                  ((HashMap)localObject3).put(localObject4[i], localObject4[i]);
                  i += 1;
                }
                else
                {
                  localObject1 = localObject2;
                  if (((HashMap)localObject3).get(paramString) != null)
                  {
                    localObject1 = localObject2;
                    localObject3 = ((FriendManager)paramQQAppInterface.getManager(8)).c(paramString);
                    if (localObject3 == null)
                    {
                      localObject1 = localObject2;
                      paramQQAppInterface = "can not find friend,friendUin is:" + paramString;
                      i = 2;
                      if (!QLog.isColorLevel()) {
                        continue;
                      }
                      QLog.d(ReduFriendServlet.jdField_b_of_type_JavaLangString, 2, "step is:" + paramQQAppInterface);
                      return 2;
                    }
                  }
                  else
                  {
                    localObject1 = localObject2;
                    paramQQAppInterface = "friend does not exist in hot friend,friendUin is:" + paramString + ",hotFriend is:" + Arrays.toString((Object[])localObject4);
                    i = 2;
                    if (!QLog.isColorLevel()) {
                      continue;
                    }
                    QLog.d(ReduFriendServlet.jdField_b_of_type_JavaLangString, 2, "step is:" + paramQQAppInterface);
                    return 2;
                  }
                  localObject1 = localObject2;
                  if ((((Friends)localObject3).abilityBits & 1L) == 0L)
                  {
                    localObject1 = localObject2;
                    paramQQAppInterface = "friend abilityBits does not contain support voice flag,f.abilityBits is:" + ((Friends)localObject3).abilityBits;
                    i = 2;
                    if (QLog.isColorLevel())
                    {
                      QLog.d(ReduFriendServlet.jdField_b_of_type_JavaLangString, 2, "step is:" + paramQQAppInterface);
                      return 2;
                    }
                  }
                  else
                  {
                    localObject1 = localObject2;
                    i = ((Friends)localObject3).getNetWorkType();
                    if (i == 2)
                    {
                      i = 2;
                      if (!QLog.isColorLevel()) {
                        continue;
                      }
                      QLog.d(ReduFriendServlet.jdField_b_of_type_JavaLangString, 2, "step is:" + "");
                      return 2;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d(ReduFriendServlet.jdField_b_of_type_JavaLangString, 2, "step is:" + (String)localObject1);
    }
    throw paramQQAppInterface;
  }
  
  public static int a(List paramList, int paramInt1, int paramInt2, String paramString)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return -1;
    }
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      if (a((RecentEmotionData)paramList.get(i), paramInt1, paramInt2, paramString)) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public static long a(long paramLong, Time paramTime)
  {
    paramTime.set(paramLong);
    int i = paramTime.year;
    int j = paramTime.month;
    paramTime.set(0, 0, 0, paramTime.monthDay, j, i);
    return paramTime.toMillis(false);
  }
  
  public static long a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    long l2 = paramQQAppInterface.a().b(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int);
    if (paramSessionInfo.jdField_a_of_type_Int == 1)
    {
      if (l2 == -1L) {
        return paramSessionInfo.jdField_a_of_type_Long;
      }
      if (l2 != paramSessionInfo.jdField_a_of_type_Long)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.sendGroupMsgReadConfirm", 2, "groupUin is " + paramSessionInfo.jdField_a_of_type_JavaLangString + ", shmsgseq  is " + l2);
        }
        try
        {
          paramQQAppInterface.a().a(Long.valueOf(paramSessionInfo.jdField_a_of_type_JavaLangString).longValue(), l2);
          return l2;
        }
        catch (Exception paramQQAppInterface)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.sendGroupMsgReadConfirm", 2, "sendReadConfirm" + paramQQAppInterface);
          }
          paramSessionInfo.jdField_a_of_type_Long = l2;
          return l2;
        }
      }
    }
    if (paramSessionInfo.jdField_a_of_type_Int == 3000)
    {
      if (l2 == -1L) {
        return paramSessionInfo.jdField_a_of_type_Long;
      }
      if (l2 != paramSessionInfo.jdField_a_of_type_Long)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.sendDisMsgReadConfirm", 2, "disUin is " + paramSessionInfo.jdField_a_of_type_JavaLangString + ", shmsgseq  is " + l2);
        }
        paramQQAppInterface.a().b(Long.valueOf(paramSessionInfo.jdField_a_of_type_JavaLangString).longValue(), l2);
        paramSessionInfo.jdField_a_of_type_Long = l2;
        return l2;
      }
    }
    long l1;
    if (MsgProxyUtils.a(paramSessionInfo.jdField_a_of_type_Int))
    {
      if (l2 == -1L) {
        return paramSessionInfo.jdField_a_of_type_Long;
      }
      if ((l2 != 0L) && (l2 != paramSessionInfo.jdField_a_of_type_Long)) {
        if (paramSessionInfo.jdField_a_of_type_Int == 1006)
        {
          if (paramSessionInfo.f == null) {
            break label591;
          }
          l1 = Long.valueOf(paramSessionInfo.f).longValue();
        }
      }
    }
    for (;;)
    {
      if (l1 != -1L)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.sendMsgReadedReport", 2, "msgReadedReportUin is " + l1 + ", shmsgseq  is " + l2);
        }
        ArrayList localArrayList = new ArrayList();
        if (paramSessionInfo.jdField_a_of_type_Int == 1024)
        {
          byte[] arrayOfByte = paramQQAppInterface.a().d(paramSessionInfo.jdField_a_of_type_JavaLangString);
          if (arrayOfByte != null)
          {
            if (QLog.isDevelopLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 4, "Readcomfirmed------->Sig:" + HexUtil.a(arrayOfByte) + ",length:" + arrayOfByte.length);
            }
            localArrayList.add(new UinPairReadInfo(l1, l2, 0L, arrayOfByte));
          }
        }
        for (;;)
        {
          paramQQAppInterface.a().c(localArrayList);
          paramSessionInfo.jdField_a_of_type_Long = l2;
          return l2;
          l1 = Long.valueOf(paramSessionInfo.jdField_a_of_type_JavaLangString).longValue();
          break;
          if (QLog.isDevelopLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 4, "Readcomfirmed------->crmSig is null:");
          }
          localArrayList.add(new UinPairReadInfo(l1, l2, 0L, null));
          continue;
          localArrayList.add(new UinPairReadInfo(l1, l2, 0L, null));
        }
      }
      return paramSessionInfo.jdField_a_of_type_Long;
      label591:
      l1 = -1L;
    }
  }
  
  private static long a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, int paramInt, ArrayList paramArrayList)
  {
    paramArrayList = StructMsgHelper.a(paramArrayList);
    String str = paramQQAppInterface.a();
    int i = MobileQQService.jdField_c_of_type_Int;
    MobileQQService.jdField_c_of_type_Int = i + 1;
    long l = i;
    paramSessionInfo = MessageRecordFactory.a(paramQQAppInterface, str, paramSessionInfo.jdField_a_of_type_JavaLangString, str, paramSessionInfo.jdField_a_of_type_Int, l, paramArrayList);
    paramSessionInfo.msgUid = MessageUtils.a(paramInt);
    if (!MessageHandlerUtils.a(paramQQAppInterface, paramSessionInfo, false)) {
      paramQQAppInterface.a().b(paramSessionInfo, paramSessionInfo.selfuin);
    }
    return paramSessionInfo.uniseq;
  }
  
  public static long a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, MessageForPic paramMessageForPic)
  {
    long l2 = 0L;
    long l1 = l2;
    if (paramSessionInfo != null)
    {
      l1 = l2;
      if (paramMessageForPic != null)
      {
        paramSessionInfo = MessageRecordFactory.a(paramMessageForPic);
        ((SVIPHandler)paramQQAppInterface.a(12)).a(paramSessionInfo);
        paramQQAppInterface.a().a(paramSessionInfo, paramQQAppInterface.a());
        l1 = paramSessionInfo.uniseq;
      }
    }
    return l1;
  }
  
  public static long a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString)
  {
    MessageRecord localMessageRecord = a(paramQQAppInterface, paramString, paramSessionInfo, -3);
    long l = 0L;
    if (localMessageRecord != null) {
      l = localMessageRecord.uniseq;
    }
    if (l != -1L) {
      a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_Int, paramSessionInfo.jdField_a_of_type_JavaLangString, paramString, l, true);
    }
    return l;
  }
  
  public static long a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, long paramLong, int paramInt2)
  {
    if (paramString1 != null)
    {
      paramString1 = TransfileUtile.a(paramString1, paramString3, paramString4, paramLong, paramInt2);
      paramString3 = MessageRecordFactory.a(-20000);
      paramString3.selfuin = paramQQAppInterface.a();
      paramString3.frienduin = paramString2;
      paramString3.senderuin = paramQQAppInterface.a();
      paramString3.msg = paramString1;
      paramString3.msgtype = -20000;
      paramString3.isread = true;
      paramString3.issend = 1;
      paramString3.istroop = paramInt1;
      ((SVIPHandler)paramQQAppInterface.a(12)).a(paramString3);
      paramQQAppInterface.a().a(paramString3, paramQQAppInterface.a());
      return paramString3.uniseq;
    }
    return 0L;
  }
  
  private static ChatMessage a(ChatAdapter1 paramChatAdapter1)
  {
    paramChatAdapter1 = paramChatAdapter1.a();
    if ((paramChatAdapter1 == null) || (paramChatAdapter1.isEmpty())) {
      return null;
    }
    return (ChatMessage)paramChatAdapter1.get(paramChatAdapter1.size() - 1);
  }
  
  public static MessageRecord a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    if (MsgProxyUtils.a(paramSessionInfo.jdField_a_of_type_Int))
    {
      paramQQAppInterface = paramQQAppInterface.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int);
      if ((paramQQAppInterface != null) && (!paramQQAppInterface.isEmpty()))
      {
        int i = paramQQAppInterface.size() - 1;
        while (i >= 0)
        {
          paramSessionInfo = (MessageRecord)paramQQAppInterface.get(i);
          if (!MsgUtils.b(paramSessionInfo.issend)) {
            return paramSessionInfo;
          }
          i -= 1;
        }
      }
    }
    return null;
  }
  
  public static MessageRecord a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, MessageForPtt paramMessageForPtt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramSessionInfo != null)
    {
      localObject1 = localObject2;
      if (paramMessageForPtt != null)
      {
        localObject1 = MessageRecordFactory.a(paramMessageForPtt);
        ((SVIPHandler)paramQQAppInterface.a(12)).a((MessageRecord)localObject1);
        paramQQAppInterface.a().a((MessageRecord)localObject1, paramQQAppInterface.a());
      }
    }
    return localObject1;
  }
  
  public static MessageRecord a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString1, String paramString2)
  {
    if (paramSessionInfo == null) {}
    while (paramString1 == null) {
      return null;
    }
    paramSessionInfo = MessageRecordFactory.a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_b_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int);
    paramSessionInfo.path = paramString1;
    paramSessionInfo.size = 0L;
    paramSessionInfo.type = 1;
    paramSessionInfo.isRead = true;
    paramSessionInfo.serial();
    ((SVIPHandler)paramQQAppInterface.a(12)).a(paramSessionInfo);
    paramQQAppInterface.a().a(paramSessionInfo, paramQQAppInterface.a());
    return paramSessionInfo;
  }
  
  public static MessageRecord a(QQAppInterface paramQQAppInterface, String paramString, SessionInfo paramSessionInfo, int paramInt)
  {
    int i = 0;
    if ((!TextUtils.isEmpty(paramString)) && (paramSessionInfo != null))
    {
      int j = paramSessionInfo.jdField_a_of_type_Int;
      byte[] arrayOfByte = new byte[3];
      PkgTools.a(paramString.length(), arrayOfByte, 0, 3, "utf-8");
      paramSessionInfo = MessageRecordFactory.a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_b_of_type_JavaLangString, j);
      paramSessionInfo.url = paramString;
      paramSessionInfo.fileSize = paramInt;
      paramSessionInfo.itemType = 2;
      paramInt = i;
      if (SttManager.a(j))
      {
        paramInt = i;
        if (SttManager.a(paramQQAppInterface)) {
          paramInt = 1;
        }
      }
      paramSessionInfo.sttAbility = paramInt;
      paramSessionInfo.longPttVipFlag = MessageUtils.a(paramQQAppInterface, paramQQAppInterface.a());
      paramSessionInfo.serial();
      ((SVIPHandler)paramQQAppInterface.a(12)).a(paramSessionInfo);
      paramQQAppInterface.a().a(paramSessionInfo, paramQQAppInterface.a());
      return paramSessionInfo;
    }
    return null;
  }
  
  public static String a(String paramString)
  {
    return "voice_shown_hot_friend_tip_bar_" + paramString;
  }
  
  public static JSONObject a(NewestFeedInfo paramNewestFeedInfo)
  {
    if (paramNewestFeedInfo == null) {
      return null;
    }
    paramNewestFeedInfo.strTitle = paramNewestFeedInfo.strTitle.replaceAll("\\[em\\]e\\d{1,}\\[/em\\]", "[表情]");
    paramNewestFeedInfo.strSummary = paramNewestFeedInfo.strSummary.replaceAll("\\[em\\]e\\d{1,}\\[/em\\]", "[表情]");
    paramNewestFeedInfo.strContent = paramNewestFeedInfo.strContent.replaceAll("\\[em\\]e\\d{1,}\\[/em\\]", "[表情]");
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("appid", paramNewestFeedInfo.uAppid);
      localJSONObject.put("title", paramNewestFeedInfo.strTitle);
      localJSONObject.put("actionUrl", paramNewestFeedInfo.strJmpUrl);
      localJSONObject.put("content", paramNewestFeedInfo.strContent);
      localJSONObject.put("coverImageUrl", paramNewestFeedInfo.strImgUrl);
      localJSONObject.put("fromuin", paramNewestFeedInfo.uHostUin);
      localJSONObject.put("imageCount", paramNewestFeedInfo.uImgCount);
      localJSONObject.put("lbsinfo", paramNewestFeedInfo.strLBSInfo);
      localJSONObject.put("summery", paramNewestFeedInfo.strSummary);
      localJSONObject.put("time", paramNewestFeedInfo.uTime);
      return localJSONObject;
    }
    catch (JSONException paramNewestFeedInfo) {}
    return null;
  }
  
  public static void a()
  {
    if (jdField_a_of_type_JavaUtilHashMap != null) {
      jdField_a_of_type_JavaUtilHashMap.clear();
    }
  }
  
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    paramString3 = SubString.a(paramString4, 45, "UTF-8", "...");
    paramString4 = SubString.a(paramString5, 90, "UTF-8", "...");
    paramString5 = "我在这里，点击查看：http://maps.google.com/maps?q=" + paramString1 + "," + paramString2 + "&iwloc=A&hl=zh-CN (" + paramString4 + ")";
    paramContext = paramContext.getResources().getString(2131561419);
    paramString1 = "mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=com.tencent.biz.PoiMapActivity&type=sharedmap&lat=" + paramString1 + "&lon=" + paramString2 + "&title=" + paramString3 + "&loc=" + paramString4 + "&dpid=" + paramString6;
    paramContext = new AbsShareMsg.Builder(StructMsgForGeneralShare.class).c(32).a(paramContext).b(paramString5).a("plugin", paramString1, paramString1, paramString1, paramString1).a();
    paramString1 = StructMsgElementFactory.a(2);
    paramString1.a("http://pub.idqqimg.com/pc/misc/lbsshare_icon.jpg", paramString3, paramString4);
    paramContext.addItem(paramString1);
    a(paramQQAppInterface, paramSessionInfo, paramContext);
  }
  
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    paramQQAppInterface = new cfw(paramContext, paramQQAppInterface, paramChatMessage);
    paramChatMessage = (InputMethodManager)paramContext.getSystemService("input_method");
    boolean bool = paramChatMessage.isActive();
    if (((paramContext instanceof Activity)) && (bool)) {
      paramChatMessage.hideSoftInputFromWindow(((Activity)paramContext).getWindow().getDecorView().getWindowToken(), 0);
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        new Handler(paramContext.getMainLooper()).postDelayed(paramQQAppInterface, 60L);
        return;
      }
      paramQQAppInterface.run();
      return;
    }
  }
  
  public static void a(ChatActivity paramChatActivity, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, List paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceTipMsg", 2, "showDiscChatFreqCallBarIfNeeded() =====>");
    }
    String str1 = "";
    if (paramList != null) {}
    for (;;)
    {
      int j;
      int k;
      try
      {
        if (paramSessionInfo.jdField_a_of_type_Int != 3000)
        {
          if (QLog.isColorLevel()) {
            QLog.d("VoiceTipMsg", 2, "showDiscChatFreqCallBarIfNeeded() <=====, step is:" + "curType != disscusion");
          }
          return;
        }
        if (paramList.size() < 10)
        {
          paramChatActivity = "msgList size < 10, size = " + paramList.size();
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("VoiceTipMsg", 2, "showDiscChatFreqCallBarIfNeeded() <=====, step is:" + paramChatActivity);
          return;
        }
        long l1 = Long.valueOf(paramSessionInfo.jdField_a_of_type_JavaLangString).longValue();
        if (paramQQAppInterface.a().a(l1))
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("VoiceTipMsg", 2, "showDiscChatFreqCallBarIfNeeded() <=====, step is:" + "current discussion is on voice chating");
          return;
        }
        paramSessionInfo = "voice_disc_chat_freq_bar_show_count" + paramQQAppInterface.a();
        SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("free_call", 0);
        int m = localSharedPreferences.getInt(paramSessionInfo, 0);
        if (m >= 3)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("VoiceTipMsg", 2, "showDiscChatFreqCallBarIfNeeded() <=====, step is:" + "show times >= 3,just return");
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("VoiceTipMsg", 2, "discChatFreqBarShowCount : " + m);
        }
        l1 = MessageCache.a() * 1000L;
        jdField_a_of_type_AndroidTextFormatTime.set(l1);
        i = jdField_a_of_type_AndroidTextFormatTime.year;
        j = jdField_a_of_type_AndroidTextFormatTime.month;
        k = jdField_a_of_type_AndroidTextFormatTime.monthDay;
        jdField_a_of_type_AndroidTextFormatTime.set(0, 0, 20, k, j, i);
        long l2 = jdField_a_of_type_AndroidTextFormatTime.toMillis(false);
        jdField_a_of_type_AndroidTextFormatTime.set(0, 0, 23, k, j, i);
        long l3 = jdField_a_of_type_AndroidTextFormatTime.toMillis(false);
        if ((l1 < l2) || (l1 > l3))
        {
          paramChatActivity = "current time not in " + 20 + "-" + 23;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("VoiceTipMsg", 2, "showDiscChatFreqCallBarIfNeeded() <=====, step is:" + paramChatActivity);
          return;
        }
        String str2 = "voice_disc_chat_freq_bar_show_time" + paramQQAppInterface.a();
        Object localObject1 = localSharedPreferences.getString(str2, null);
        Object localObject2;
        if (QLog.isColorLevel())
        {
          localObject2 = i + "-" + j + "-" + k;
          QLog.d("VoiceTipMsg", 2, "currDate is:" + (String)localObject2 + ",curr hour is:" + jdField_a_of_type_AndroidTextFormatTime.hour + ",discPttFreqTipMsgInsertTime is:" + (String)localObject1);
        }
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          jdField_a_of_type_AndroidTextFormatTime.set(Long.parseLong((String)localObject1));
          int n = jdField_a_of_type_AndroidTextFormatTime.year;
          int i1 = jdField_a_of_type_AndroidTextFormatTime.month;
          int i2 = jdField_a_of_type_AndroidTextFormatTime.monthDay;
          if ((i == n) && (j == i1) && (k == i2))
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("VoiceTipMsg", 2, "showDiscChatFreqCallBarIfNeeded() <=====, step is:" + "already show discuss ppt frequent bar this day");
            return;
          }
        }
        localObject1 = localSharedPreferences.getString("start_group_audio_time" + paramQQAppInterface.a(), null);
        if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (l1 - Long.parseLong((String)localObject1) <= 600000L))
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("VoiceTipMsg", 2, "showDiscChatFreqCallBarIfNeeded() <=====, step is:" + "has startGroupAudio in less 10 mins, just return");
          return;
        }
        l2 = (l1 - 600000L) / 1000L;
        j = paramList.size();
        i = 0;
        localObject1 = new HashSet();
        k = j - 1;
        if (k >= 0)
        {
          localObject2 = (ChatMessage)paramList.get(k);
          j = i;
          if (((ChatMessage)localObject2).time < l2) {
            break label1201;
          }
          j = i;
          if (!MsgProxyUtils.f(((ChatMessage)localObject2).msgtype)) {
            break label1201;
          }
          j = i;
          if (((ChatMessage)localObject2).extraflag != 0) {
            break label1201;
          }
          j = i + 1;
          ((HashSet)localObject1).add(((ChatMessage)localObject2).senderuin);
          break label1201;
        }
        j = ((HashSet)localObject1).size();
        if (QLog.isColorLevel()) {
          QLog.d("VoiceTipMsg", 2, "basicMsgNum : " + i + ", msgUinNum : " + j);
        }
        if ((i < 10) || (j < 2)) {
          break label1195;
        }
        if (paramChatActivity.d())
        {
          i = m + 1;
          paramChatActivity = localSharedPreferences.edit();
          paramChatActivity.putString(str2, String.valueOf(l1)).putInt(paramSessionInfo, i);
          paramChatActivity.commit();
          paramChatActivity = "show discuss chat frequent bar success, discChatFreqBarShowCount=" + i;
        }
      }
      finally
      {
        paramQQAppInterface = str1;
        if (QLog.isColorLevel()) {
          QLog.d("VoiceTipMsg", 2, "showDiscChatFreqCallBarIfNeeded() <=====, step is:" + paramQQAppInterface);
        }
      }
      try
      {
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8003EFF", "0X8003EFF", 0, 0, "", "", "", "");
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("VoiceTipMsg", 2, "showDiscChatFreqCallBarIfNeeded() <=====, step is:" + paramChatActivity);
        return;
      }
      finally
      {
        paramQQAppInterface = paramChatActivity;
        paramChatActivity = paramSessionInfo;
      }
      paramChatActivity = "show discuss chat frequent bar not allowed";
      continue;
      label1195:
      paramChatActivity = "";
      continue;
      label1201:
      k -= 1;
      int i = j;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, String paramString1, String paramString2, long paramLong, boolean paramBoolean)
  {
    if ((paramInt == 1001) && (!paramQQAppInterface.b(paramString1))) {
      paramQQAppInterface.a().a(paramString1, paramInt, paramString2, paramLong);
    }
    do
    {
      TransferRequest localTransferRequest;
      do
      {
        do
        {
          return;
          if ((paramInt != 0) || (a(paramQQAppInterface, paramString1, paramInt, paramLong))) {
            break;
          }
          if (paramBoolean)
          {
            StreamDataManager.a(paramQQAppInterface, paramString1, paramString2, paramLong);
            return;
          }
        } while (StreamDataManager.b(paramString2) < 1);
        StreamDataManager.a(paramString2, paramQQAppInterface, paramString1, paramLong);
        return;
        localTransferRequest = new TransferRequest();
        localTransferRequest.jdField_a_of_type_JavaLangString = paramQQAppInterface.getAccount();
        localTransferRequest.jdField_b_of_type_JavaLangString = paramString1;
        localTransferRequest.jdField_a_of_type_Int = paramInt;
        localTransferRequest.jdField_b_of_type_Int = 2;
        localTransferRequest.jdField_a_of_type_Long = paramLong;
        localTransferRequest.jdField_a_of_type_Boolean = true;
        localTransferRequest.g = paramString2;
        localTransferRequest.jdField_d_of_type_Int = 1002;
        localTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramQQAppInterface.a().a(paramString1, paramInt, paramLong);
        paramQQAppInterface.a().a(localTransferRequest);
      } while ((localTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == null) || (!(localTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForPtt)));
      paramQQAppInterface = (MessageForPtt)localTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    } while ((!paramQQAppInterface.c2cViaOffline) || (paramQQAppInterface.timeLength > 0));
    paramQQAppInterface.timeLength = QQRecorder.a(paramString2);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    if (!ChatActivityUtils.a(paramQQAppInterface, paramSessionInfo)) {}
    do
    {
      do
      {
        return;
      } while ((ChatActivityUtils.a(paramContext, paramSessionInfo)) || (CrmUtils.b(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString)));
      if (QLog.isDevelopLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 4, "single way insert " + paramSessionInfo.jdField_a_of_type_JavaLangString);
      }
      ChatActivityUtils.b(paramContext, paramSessionInfo);
      paramContext = MessageRecordFactory.a(-2019);
      long l = MessageCache.a();
      paramContext.init(paramQQAppInterface.a(), paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_JavaLangString, "", l, -2019, paramSessionInfo.jdField_a_of_type_Int, l);
      paramContext.isread = true;
    } while (MessageHandlerUtils.a(paramQQAppInterface, paramContext, false));
    paramQQAppInterface.a().a(paramContext, paramContext.selfuin);
    ReportController.b(paramQQAppInterface, "CliOper", "", paramSessionInfo.jdField_a_of_type_JavaLangString, "Manage_stranger", "Manage_str_aio_exp", 0, 0, "", "", "", "");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, long paramLong)
  {
    paramContext = paramQQAppInterface.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramLong);
    if ((paramContext != null) && (paramContext.isSendFromLocal())) {
      paramQQAppInterface.a().d(paramQQAppInterface.a().a(paramContext.frienduin, paramContext.uniseq));
    }
    paramQQAppInterface.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramLong);
    paramContext = MessageRecordFactory.a(paramContext);
    paramQQAppInterface.a().a(paramContext, null);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, Intent paramIntent, String paramString, ForwardFileInfo paramForwardFileInfo)
  {
    if (!paramIntent.getBooleanExtra("not_forward", false)) {}
    do
    {
      return;
      paramQQAppInterface.a().a(paramForwardFileInfo.b(), paramForwardFileInfo.e(), paramForwardFileInfo.a(), Long.parseLong(paramSessionInfo.jdField_a_of_type_JavaLangString), paramSessionInfo.jdField_a_of_type_Int);
    } while (!paramIntent.getBooleanExtra("not_forward", false));
    paramIntent.removeExtra("not_forward");
    paramIntent.getExtras().remove("not_forward");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, Emoticon paramEmoticon)
  {
    if (paramEmoticon == null) {
      Toast.makeText(paramContext, "emoticon is null.", 0).show();
    }
    do
    {
      return;
      if (((paramEmoticon.jobType == 0) || (paramEmoticon.jobType == 2)) && (!paramEmoticon.hasEncryptKey()))
      {
        Toast.makeText(paramContext, "emoticon Encrypt Key is null.", 0).show();
        return;
      }
      paramContext = ((EmoticonManager)paramQQAppInterface.getManager(12)).a(paramEmoticon.epId);
    } while (paramContext == null);
    MarkFaceMessage localMarkFaceMessage = new MarkFaceMessage();
    localMarkFaceMessage.cSubType = paramContext.type;
    localMarkFaceMessage.sbufID = EmosmUtils.eId2Byte(paramEmoticon.eId, paramEmoticon.jobType);
    localMarkFaceMessage.dwTabID = Integer.valueOf(paramEmoticon.epId).intValue();
    localMarkFaceMessage.sbfKey = paramEmoticon.encryptKey.getBytes();
    localMarkFaceMessage.imageWidth = paramEmoticon.width;
    localMarkFaceMessage.imageHeight = paramEmoticon.height;
    localMarkFaceMessage.faceName = paramEmoticon.name;
    if (paramEmoticon.isSound) {
      localMarkFaceMessage.mediaType = 1;
    }
    if (paramEmoticon.jobType == 1) {
      localMarkFaceMessage.mediaType = 2;
    }
    if (1 == paramContext.type) {
      localMarkFaceMessage.cSubType = 3;
    }
    if ((paramEmoticon.jobType == 2) && (paramEmoticon.magicValue != null)) {
      localMarkFaceMessage.mobileparam = paramEmoticon.magicValue.getBytes();
    }
    paramContext = MessageRecordFactory.a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_b_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, localMarkFaceMessage);
    paramContext.sendFaceName = paramEmoticon.name;
    paramQQAppInterface.a().a(paramContext, null);
    a(paramQQAppInterface, paramEmoticon);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, Emoticon paramEmoticon, long paramLong)
  {
    paramContext = paramQQAppInterface.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramLong);
    if (paramContext != null)
    {
      paramQQAppInterface.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramLong);
      paramContext = MessageRecordFactory.a(paramContext);
      paramQQAppInterface.a().a(paramContext, null);
      a(paramQQAppInterface, paramEmoticon);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d(jdField_a_of_type_JavaLangString, 2, "reSendEmosmMessage : mr is null.");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, String paramString)
  {
    if (paramString == null) {
      return;
    }
    ImageUtil.a(-1L, paramSessionInfo.jdField_a_of_type_Int, true, "image_send_prepare", "ChatActivity.sendCustomEmotion");
    if (!FileUtils.b(paramString))
    {
      ChatActivityUtils.a(paramContext, 2131561457, 0);
      ImageUtil.a(-1L, paramSessionInfo.jdField_a_of_type_Int, true, "image_send_prepared_failed", "ChatActivity.sendCustomEmotion");
      return;
    }
    paramContext = new PicUploadInfo.Builder();
    paramContext.a(paramString);
    paramContext.d(1006);
    paramContext.d(paramSessionInfo.jdField_a_of_type_JavaLangString);
    paramContext.c(TranDbRecord.PicDbRecord.e);
    paramContext.e(paramSessionInfo.jdField_b_of_type_JavaLangString);
    paramContext.c(paramQQAppInterface.a());
    paramContext.e(paramSessionInfo.jdField_a_of_type_Int);
    paramSessionInfo = PicBusiManager.a(1, 1006);
    paramSessionInfo.a(paramContext.a());
    PicBusiManager.a(paramSessionInfo, paramQQAppInterface);
    new cfs(paramQQAppInterface, paramString).execute(new Void[0]);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, String paramString, int paramInt, long paramLong)
  {
    if (!NetworkUtil.e(BaseApplication.getContext()))
    {
      ChatActivityUtils.a(paramContext, 2131562452, 0);
      return;
    }
    paramSessionInfo = paramQQAppInterface.a().a(paramString, paramInt, paramLong);
    if (paramSessionInfo == null)
    {
      ChatActivityUtils.a(paramContext, 2131561435, 0);
      return;
    }
    if (paramSessionInfo.isSendFromLocal()) {
      paramQQAppInterface.a().d(paramQQAppInterface.a().a(paramSessionInfo.frienduin, paramSessionInfo.uniseq));
    }
    paramContext = StructMsgFactory.a(paramSessionInfo.msgData);
    paramQQAppInterface.a().a(paramString, paramInt, paramLong);
    if ((paramContext instanceof StructMsgForImageShare))
    {
      StructMsgForImageShare.resendAndUploadImageShare(paramQQAppInterface, paramSessionInfo, (StructMsgForImageShare)paramContext);
      return;
    }
    paramContext = MessageRecordFactory.a(paramSessionInfo);
    paramQQAppInterface.a().a(paramContext, null);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, String paramString, long paramLong)
  {
    paramContext = paramQQAppInterface.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramLong);
    if (paramContext != null)
    {
      long l = paramContext.msgseq;
      if (paramContext.isSendFromLocal()) {
        paramQQAppInterface.a().d(paramQQAppInterface.a().a(paramContext.frienduin, paramContext.uniseq));
      }
    }
    paramQQAppInterface.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramLong);
    paramContext = MessageRecordFactory.a(paramContext);
    paramQQAppInterface.a().a(paramContext, null);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, String paramString1, String paramString2, String paramString3, long paramLong, int paramInt, String paramString4)
  {
    if (FileUtils.b(paramString1)) {
      ForwardSendPicUtil.a(paramQQAppInterface, paramString1, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramSessionInfo.jdField_b_of_type_JavaLangString, false, paramContext);
    }
    long l1;
    long l2;
    do
    {
      do
      {
        return;
        l1 = a(paramQQAppInterface, paramString1, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramString2, paramString3, paramLong, paramInt);
        paramContext = paramQQAppInterface.a().a(paramString3, paramLong);
        if (QLog.isColorLevel()) {
          QLog.d("streamptt", 2, "ChatActivity.handleForwardData forwardPic wait for download1,uniseq:" + l1 + ",filePath:" + paramString1 + ",forwardImageOrgServerpath:" + paramString2 + ",forwardImageOrgItemId:" + paramLong + ",processor:" + paramContext);
        }
      } while ((paramContext == null) || (!(paramContext instanceof BaseTransProcessor)));
      paramContext = (BaseTransProcessor)paramContext;
      l2 = paramContext.c();
      if (QLog.isColorLevel()) {
        QLog.d("streamptt", 2, "ChatActivity.handleForwardData forwardPic wait for download2,msgId:" + l1 + ",filePath:" + paramString1 + ",get download process status:" + l2);
      }
    } while ((l2 != 2000L) && (l2 != 2001L) && (l2 != 2002L));
    paramQQAppInterface.a().a(l1, paramString4, paramQQAppInterface, paramSessionInfo.jdField_a_of_type_Int, paramSessionInfo.jdField_a_of_type_JavaLangString, paramString1, paramString2, paramString3, paramLong, paramInt);
    paramContext.a().o = paramString4;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, String paramString, ArrayList paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SendMsgBtn", 2, " sendMessage start currenttime:" + System.currentTimeMillis());
    }
    if ((paramString == null) || (paramString.length() == 0)) {}
    do
    {
      return;
      a(paramQQAppInterface, paramSessionInfo, paramString, paramArrayList);
      new cft(paramQQAppInterface, paramString).execute(new Void[0]);
      paramQQAppInterface.a().f(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int);
    } while (!QLog.isColorLevel());
    QLog.d("SendMsgBtn", 2, " sendMessage end currenttime:" + System.currentTimeMillis());
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, List paramList)
  {
    Object localObject1 = PreferenceManager.getDefaultSharedPreferences(paramContext).getString("single_way_friend_list", "");
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      return;
    }
    for (;;)
    {
      try
      {
        localObject1 = new JSONArray((String)localObject1);
        paramList = paramList.iterator();
        if (!paramList.hasNext()) {
          break;
        }
        String str = (String)paramList.next();
        int i = 0;
        if (i < ((JSONArray)localObject1).length())
        {
          Object localObject2 = ((JSONArray)localObject1).getJSONObject(i);
          if ((((JSONObject)localObject2).has("uin")) && (((JSONObject)localObject2).has("type")) && (((JSONObject)localObject2).getString("uin").equals(MsgProxyUtils.a(str))))
          {
            localObject2 = paramQQAppInterface.a().a(str, 0);
            ChatActivityUtils.a(paramContext, str, 0);
            localObject2 = ((List)localObject2).iterator();
            if (((Iterator)localObject2).hasNext())
            {
              MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject2).next();
              if (localMessageRecord.msgtype != -2019) {
                continue;
              }
              paramQQAppInterface.a().a(localMessageRecord, false);
              continue;
            }
          }
          i += 1;
        }
      }
      catch (JSONException paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
        return;
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    Iterator localIterator = TestStructMsg.a().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (AbsStructMsg)localIterator.next();
      String str = paramQQAppInterface.a();
      int i = MobileQQService.jdField_c_of_type_Int;
      MobileQQService.jdField_c_of_type_Int = i + 1;
      long l = i;
      localObject = MessageRecordFactory.a(paramQQAppInterface, str, paramSessionInfo.jdField_a_of_type_JavaLangString, str, paramSessionInfo.jdField_a_of_type_Int, l, (AbsStructMsg)localObject);
      if (!MessageHandlerUtils.a(paramQQAppInterface, (MessageRecord)localObject, false)) {
        paramQQAppInterface.a().b((MessageRecord)localObject, ((MessageRecord)localObject).selfuin);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, Intent paramIntent)
  {
    if (paramIntent == null) {}
    ArrayList localArrayList;
    do
    {
      return;
      localArrayList = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    } while ((localArrayList == null) || (localArrayList.isEmpty()));
    try
    {
      int i = Integer.valueOf(paramIntent.getStringExtra("key_upload_client_key")).intValue();
      long l = a(paramQQAppInterface, paramSessionInfo, i, localArrayList);
      ((TroopQZoneUploadAlbumHandler)paramQQAppInterface.a(30)).a(i, paramSessionInfo.jdField_a_of_type_JavaLangString, l);
      return;
    }
    catch (NumberFormatException paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, ChatAdapter1 paramChatAdapter1)
  {
    if (paramSessionInfo.jdField_a_of_type_Int != 0) {
      return;
    }
    Object localObject = a(paramChatAdapter1);
    int i;
    if ((localObject != null) && ((NetConnInfoCenter.getServerTime() - ((ChatMessage)localObject).time) * 1000L <= 604800000L))
    {
      i = 1;
      label41:
      if ((localObject != null) && (((ChatMessage)localObject).msgtype != -2015) && (i != 0)) {
        break label190;
      }
      if (localObject != null) {
        break label192;
      }
      i = 0;
      label68:
      if (i != 0) {
        break label220;
      }
      if (localObject == null) {
        break label222;
      }
    }
    label190:
    label192:
    label220:
    label222:
    for (long l = ((ChatMessage)localObject).time;; l = 0L)
    {
      localObject = new NewIntent(paramQQAppInterface.getApplication(), QZoneFeedsServlet.class);
      ((NewIntent)localObject).putExtra("selfuin", Long.valueOf(paramQQAppInterface.a()));
      ((NewIntent)localObject).putExtra("hostuin", new long[] { Long.valueOf(paramSessionInfo.jdField_a_of_type_JavaLangString).longValue() });
      ((NewIntent)localObject).putExtra("lasttime", l);
      jdField_a_of_type_Cfz.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 = paramChatAdapter1;
      jdField_a_of_type_Cfz.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
      jdField_a_of_type_Cfz.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
      paramQQAppInterface.registObserver(jdField_a_of_type_Cfz);
      paramQQAppInterface.startServlet((NewIntent)localObject);
      return;
      i = 0;
      break label41;
      break;
      if (i != 0)
      {
        if (((ChatMessage)localObject).msgtype != -2015)
        {
          i = 1;
          break label68;
        }
        i = 0;
        break label68;
      }
      i = 0;
      break label68;
      break;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, ChatAdapter1 paramChatAdapter1, long paramLong)
  {
    Object localObject = (FriendManager)paramQQAppInterface.getManager(8);
    if ((paramSessionInfo.jdField_a_of_type_Int != 1) || (((FriendManager)localObject).f(paramSessionInfo.jdField_a_of_type_JavaLangString))) {}
    label150:
    for (;;)
    {
      return;
      int i = 0;
      if (i < paramChatAdapter1.getCount())
      {
        localObject = (ChatMessage)paramChatAdapter1.getItem(i);
        if ((localObject == null) || (MsgProxyUtils.i(((ChatMessage)localObject).msgtype))) {}
      }
      for (long l = ((ChatMessage)localObject).shmsgseq;; l = 0L)
      {
        if (l <= 1L + paramLong) {
          break label150;
        }
        paramChatAdapter1 = paramQQAppInterface.a();
        localObject = (MessageForTroopUnreadTips)MessageRecordFactory.a(-4009);
        ((MessageForTroopUnreadTips)localObject).init(paramChatAdapter1, paramSessionInfo.jdField_a_of_type_JavaLangString, paramChatAdapter1, "", MessageCache.a(), -4009, 1, 0L);
        paramQQAppInterface.a().a((MessageRecord)localObject, paramChatAdapter1);
        return;
        i += 1;
        break;
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, MessageForFunnyFace paramMessageForFunnyFace)
  {
    paramQQAppInterface.a().a(paramMessageForFunnyFace.frienduin, paramMessageForFunnyFace.msgtype, paramMessageForFunnyFace.uniseq);
    paramSessionInfo = MessageRecordFactory.a(paramMessageForFunnyFace);
    paramQQAppInterface.a().a(paramSessionInfo, null);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, AbsStructMsg paramAbsStructMsg)
  {
    switch (paramSessionInfo.jdField_a_of_type_Int)
    {
    }
    for (String str1 = paramQQAppInterface.a();; str1 = paramSessionInfo.jdField_b_of_type_JavaLangString)
    {
      String str2 = paramQQAppInterface.a();
      String str3 = paramSessionInfo.jdField_a_of_type_JavaLangString;
      int i = paramSessionInfo.jdField_a_of_type_Int;
      int j = MobileQQService.jdField_c_of_type_Int;
      MobileQQService.jdField_c_of_type_Int = j + 1;
      paramSessionInfo = MessageRecordFactory.a(paramQQAppInterface, str2, str3, str1, i, j, paramAbsStructMsg);
      paramQQAppInterface.a().a(paramSessionInfo, null);
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString)
  {
    int i = Math.abs(new Random().nextInt());
    int j = MobileQQService.jdField_c_of_type_Int;
    MobileQQService.jdField_c_of_type_Int = j + 1;
    a(paramQQAppInterface, paramSessionInfo, paramString, j, 1010, false, (byte)1, (byte)0, (short)0, i, null);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString, int paramInt, long paramLong)
  {
    if (paramLong != -1L)
    {
      Object localObject = paramQQAppInterface.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramLong);
      if ((localObject instanceof MessageForPtt))
      {
        localObject = (MessageForPtt)localObject;
        ((MessageForPtt)localObject).url = paramString;
        ((MessageForPtt)localObject).fileSize = paramInt;
        ((MessageForPtt)localObject).isread = false;
        ((MessageForPtt)localObject).itemType = 2;
        ((MessageForPtt)localObject).serial();
        paramQQAppInterface.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramLong, ((MessageForPtt)localObject).msgData);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString, long paramLong, int paramInt1, boolean paramBoolean, byte paramByte1, byte paramByte2, short paramShort, int paramInt2, ArrayList paramArrayList)
  {
    b(paramQQAppInterface, paramSessionInfo, paramString, paramLong, paramInt1, paramBoolean, paramByte1, paramByte2, paramShort, paramInt2, paramArrayList);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString1, String paramString2)
  {
    if (paramSessionInfo == null) {}
    while (paramString1 == null) {
      return;
    }
    paramSessionInfo = MessageRecordFactory.a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_b_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int);
    paramSessionInfo.path = paramString1;
    paramSessionInfo.size = 0L;
    paramSessionInfo.type = 1;
    paramSessionInfo.isRead = true;
    paramSessionInfo.serial();
    ((SVIPHandler)paramQQAppInterface.a(12)).a(paramSessionInfo);
    paramQQAppInterface.a().a(paramSessionInfo, paramQQAppInterface.a());
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString1, String paramString2, String paramString3)
  {
    a(paramQQAppInterface, paramSessionInfo, "我在这里，点击查看：http://maps.google.com/maps?q=" + paramString1 + "," + paramString2 + "&iwloc=A&hl=zh-CN (" + paramString3 + ")");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString, ArrayList paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SendMsgBtn", 2, " createTextMessageToshow start currenttime:" + System.currentTimeMillis());
    }
    int i = MobileQQService.jdField_c_of_type_Int;
    MobileQQService.jdField_c_of_type_Int = i + 1;
    long l = i;
    ArrayList localArrayList = new ArrayList();
    paramArrayList = Utils.a(paramString, 560, 20, paramArrayList, localArrayList);
    boolean bool;
    short s2;
    Random localRandom;
    short s1;
    label196:
    int j;
    label311:
    String str;
    if (paramArrayList.size() > 1)
    {
      bool = true;
      s2 = 0;
      localRandom = new Random();
      if (QLog.isColorLevel()) {
        QLog.d("SendMsgBtn", 2, " createTextMessageToshow step 1 seq = " + l + " partAtInfoArrayLists.size() = " + localArrayList.size() + " partArray.size() = " + paramArrayList.size() + " isDivide = " + bool + " currenttime:" + System.currentTimeMillis());
      }
      if (bool)
      {
        s1 = (short)(byte)(int)l;
        i = 0;
        s2 = s1;
        if (paramQQAppInterface.a().a(paramQQAppInterface.getAccount(), paramSessionInfo.jdField_a_of_type_Int, s1))
        {
          if (i <= 10) {
            break label439;
          }
          s2 = (short)(byte)paramQQAppInterface.a().a(paramQQAppInterface.getAccount(), paramSessionInfo.jdField_a_of_type_Int);
        }
        paramQQAppInterface.a().a(paramQQAppInterface.getAccount(), paramSessionInfo.jdField_a_of_type_Int, s2);
      }
      if (QLog.isColorLevel()) {
        QLog.d("SendMsgBtn", 2, " createTextMessageToshow step 2 currenttime:" + System.currentTimeMillis());
      }
      j = Math.abs(localRandom.nextInt());
      i = 0;
      if (i >= paramArrayList.size()) {
        break label465;
      }
      str = (String)paramArrayList.get(i);
      if (localArrayList.size() <= i) {
        break label460;
      }
    }
    label439:
    label460:
    for (paramString = (ArrayList)localArrayList.get(i);; paramString = null)
    {
      if ((paramSessionInfo.jdField_a_of_type_Int == 3000) || (paramSessionInfo.jdField_a_of_type_Int == 1)) {
        j = Math.abs(localRandom.nextInt());
      }
      a(paramQQAppInterface, paramSessionInfo, str, l, -1000, bool, (byte)paramArrayList.size(), (byte)i, s2, j, paramString);
      int k = MobileQQService.jdField_c_of_type_Int;
      MobileQQService.jdField_c_of_type_Int = k + 1;
      l = k;
      i += 1;
      break label311;
      bool = false;
      break;
      s1 = (short)(byte)Math.abs(localRandom.nextInt());
      i += 1;
      break label196;
    }
    label465:
    if (QLog.isColorLevel()) {
      QLog.d("SendMsgBtn", 2, " createTextMessageToshow step 3 currenttime:" + System.currentTimeMillis());
    }
    if (QLog.isColorLevel()) {
      QLog.d("SendMsgBtn", 2, " createTextMessageToshow end currenttime:" + System.currentTimeMillis());
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, List paramList)
  {
    int i;
    int j;
    int k;
    boolean bool2;
    boolean bool3;
    boolean bool4;
    boolean bool5;
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("VoiceTipMsg", 2, "insertChatFrequentVoiceCallTipIfNeeded() is called");
      }
      if ((paramList == null) || (paramList.size() < 10)) {}
      for (;;)
      {
        return;
        long l1 = MessageCache.a() * 1000L;
        jdField_a_of_type_AndroidTextFormatTime.set(l1);
        i = jdField_a_of_type_AndroidTextFormatTime.year;
        j = jdField_a_of_type_AndroidTextFormatTime.month;
        k = jdField_a_of_type_AndroidTextFormatTime.monthDay;
        String str1 = "voice_chat_freq_tip_msg_insert_time" + paramQQAppInterface.a();
        SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("free_call", 0);
        Object localObject = localSharedPreferences.getString(str1, "");
        String str2;
        if (QLog.isColorLevel())
        {
          str2 = i + "-" + j + "-" + k;
          QLog.d("VoiceTipMsg", 2, "currDate is:" + str2 + ",curr hour is:" + jdField_a_of_type_AndroidTextFormatTime.hour + ",chatFreqTipMsgInsertTime is:" + (String)localObject);
        }
        int m;
        int n;
        int i1;
        if ((localObject != null) && (((String)localObject).trim().length() > 0))
        {
          jdField_a_of_type_AndroidTextFormatTime.set(Long.parseLong((String)localObject));
          m = jdField_a_of_type_AndroidTextFormatTime.year;
          n = jdField_a_of_type_AndroidTextFormatTime.month;
          i1 = jdField_a_of_type_AndroidTextFormatTime.monthDay;
          if ((i == m) && (j == n) && (k == i1)) {
            return;
          }
        }
        localObject = localSharedPreferences.getString("voice_keyword_tip_msg_insert_time" + paramQQAppInterface.a(), "");
        if (QLog.isColorLevel()) {
          QLog.d("VoiceTipMsg", 2, "multiKeywordTipMsgInsertTime is:" + (String)localObject);
        }
        if ((localObject != null) && (((String)localObject).length() > 0))
        {
          localObject = ((String)localObject).split("\\|");
          jdField_a_of_type_AndroidTextFormatTime.set(Long.parseLong(localObject[(localObject.length - 1)]));
          m = jdField_a_of_type_AndroidTextFormatTime.year;
          n = jdField_a_of_type_AndroidTextFormatTime.month;
          i1 = jdField_a_of_type_AndroidTextFormatTime.monthDay;
          if ((i == m) && (j == n) && (k == i1)) {
            return;
          }
        }
        if (!NetworkUtil.g(BaseApplication.getContext())) {
          return;
        }
        localObject = ((FriendManager)paramQQAppInterface.getManager(8)).c(paramSessionInfo.jdField_a_of_type_JavaLangString);
        if (localObject == null)
        {
          paramQQAppInterface = "can not obtain friend by uin " + paramSessionInfo.jdField_a_of_type_JavaLangString;
          if (QLog.isColorLevel()) {
            QLog.d("VoiceTipMsg", 2, "step is:" + paramQQAppInterface);
          }
        }
        else
        {
          if ((((Friends)localObject).abilityBits & 1L) == 0L) {
            return;
          }
          m = ((Friends)localObject).getNetWorkType();
          if (m == 2) {
            return;
          }
          jdField_a_of_type_AndroidTextFormatTime.set(0, 0, 20, k, j, i);
          long l2 = jdField_a_of_type_AndroidTextFormatTime.toMillis(false);
          jdField_a_of_type_AndroidTextFormatTime.set(0, 0, 23, k, j, i);
          long l3 = jdField_a_of_type_AndroidTextFormatTime.toMillis(false);
          if ((l1 < l2) || (l1 > l3))
          {
            paramQQAppInterface = "current time not in " + 20 + "-" + 23;
            if (QLog.isColorLevel()) {
              QLog.d("VoiceTipMsg", 2, "step is:" + paramQQAppInterface);
            }
          }
          else
          {
            l2 = (l1 - 600000L) / 1000L;
            i = paramList.size();
            j = 0;
            bool2 = false;
            bool3 = false;
            boolean bool1 = false;
            i -= 1;
            if (i >= 0)
            {
              localObject = (ChatMessage)paramList.get(i);
              if (((ChatMessage)localObject).time >= l2)
              {
                bool4 = bool3;
                bool5 = bool2;
                k = j;
                if (MsgProxyUtils.f(((ChatMessage)localObject).msgtype))
                {
                  bool4 = bool3;
                  bool5 = bool2;
                  k = j;
                  if (((ChatMessage)localObject).extraflag == 0)
                  {
                    if (((ChatMessage)localObject).isSend()) {
                      break label1426;
                    }
                    bool2 = true;
                    break label1390;
                  }
                }
                label1014:
                if (!MsgProxyUtils.g(((ChatMessage)localObject).msgtype)) {
                  break;
                }
                bool1 = true;
                break;
              }
            }
            if ((j >= 10) && (bool2) && (bool3) && (!bool1))
            {
              paramList = QQOperateManager.a(paramQQAppInterface);
              bool1 = paramList.b(paramSessionInfo.jdField_a_of_type_Int, 2);
              if (bool1) {
                return;
              }
              localObject = MessageRecordFactory.a(-1014);
              l2 = MessageCache.a();
              str2 = paramQQAppInterface.a();
              ((MessageRecord)localObject).init(str2, paramSessionInfo.jdField_a_of_type_JavaLangString, str2, "", l2, -1014, paramSessionInfo.jdField_a_of_type_Int, l2);
              ((MessageRecord)localObject).isread = true;
              paramQQAppInterface.a().a((MessageRecord)localObject, ((MessageRecord)localObject).selfuin);
              if ((paramSessionInfo.jdField_a_of_type_Int == 0) || (paramSessionInfo.jdField_a_of_type_Int == 3000)) {
                paramList.a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_Int, 2);
              }
              paramSessionInfo = localSharedPreferences.edit();
              paramSessionInfo.putString(str1, String.valueOf(l1));
              paramSessionInfo.commit();
              ReportController.b(paramQQAppInterface, "CliOper", "", "", "Two_call", "Msg_call_tips", 0, 0, "", "", "", "");
            }
            for (paramQQAppInterface = "insert chat frequent tip msg success"; QLog.isColorLevel(); paramQQAppInterface = "sendRecvMsgNum is:" + j + ",hasOneRecv is:" + bool2 + ",hasOneSend is:" + bool3 + ",hasVideoMsg is:" + bool1)
            {
              QLog.d("VoiceTipMsg", 2, "step is:" + paramQQAppInterface);
              return;
            }
          }
        }
      }
    }
    finally
    {
      if (QLog.isColorLevel()) {
        QLog.d("VoiceTipMsg", 2, "step is:" + "");
      }
    }
    for (;;)
    {
      label1390:
      k = j + 1;
      bool4 = bool3;
      bool5 = bool2;
      break label1014;
      i -= 1;
      bool3 = bool4;
      bool2 = bool5;
      j = k;
      break;
      label1426:
      bool3 = true;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      paramArrayOfByte = StructMsgFactory.a(paramArrayOfByte);
      if (paramArrayOfByte != null)
      {
        str = paramQQAppInterface.a();
        i = MobileQQService.jdField_c_of_type_Int;
        MobileQQService.jdField_c_of_type_Int = i + 1;
        l = i;
        paramSessionInfo = MessageRecordFactory.a(paramQQAppInterface, str, paramSessionInfo.jdField_a_of_type_JavaLangString, str, paramSessionInfo.jdField_a_of_type_Int, l, paramArrayOfByte);
        paramQQAppInterface.a().a(paramSessionInfo, null);
      }
    }
    while (!QLog.isColorLevel())
    {
      String str;
      int i;
      long l;
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.d("structMsg", 2, "forward structMsg msgobj is null");
      return;
    }
    QLog.d("structMsg", 2, "forward structMsg data is null");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    paramQQAppInterface.a().a(paramChatMessage.frienduin, paramChatMessage.istroop, paramChatMessage.uniseq);
    if (paramChatMessage.isSendFromLocal()) {
      paramQQAppInterface.a().d(paramQQAppInterface.a().a(paramChatMessage.frienduin, paramChatMessage.uniseq));
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, CharSequence paramCharSequence)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SendMsgBtn", 2, " decodeToSaveEmoIndex start currenttime:" + System.currentTimeMillis());
    }
    if (paramCharSequence == null) {
      return;
    }
    Object localObject1;
    ArrayList localArrayList;
    int j;
    int i;
    label111:
    Object localObject3;
    int k;
    RecentEmotionData localRecentEmotionData;
    if ((paramCharSequence instanceof QQText))
    {
      localObject1 = (QQText)paramCharSequence;
      paramCharSequence.length();
      paramCharSequence = paramQQAppInterface.a().createEntityManager();
      localArrayList = new ArrayList();
      localObject2 = (QQText.EmotcationSpan[])((QQText)localObject1).getSpans(0, ((QQText)localObject1).length(), QQText.EmotcationSpan.class);
      localObject1 = new ArrayList();
      j = localObject2.length;
      i = 0;
      if (i >= j) {
        break label314;
      }
      localObject3 = localObject2[i];
      k = ((QQText.EmotcationSpan)localObject3).a();
      if (((QQText.EmotcationSpan)localObject3).jdField_a_of_type_Boolean) {
        break label237;
      }
      localObject3 = "0," + k;
      if (!((ArrayList)localObject1).contains(localObject3))
      {
        localRecentEmotionData = new RecentEmotionData();
        a(localRecentEmotionData, paramQQAppInterface.a(), 0, 0, k, null);
        localArrayList.add(localRecentEmotionData);
        ((ArrayList)localObject1).add(localObject3);
      }
    }
    for (;;)
    {
      i += 1;
      break label111;
      localObject1 = new QQText(paramCharSequence.toString(), 3);
      break;
      label237:
      localObject3 = "4," + k;
      if (!((ArrayList)localObject1).contains(localObject3))
      {
        localRecentEmotionData = new RecentEmotionData();
        a(localRecentEmotionData, paramQQAppInterface.a(), 0, 4, k, null);
        localArrayList.add(localRecentEmotionData);
        ((ArrayList)localObject1).add(localObject3);
      }
    }
    label314:
    Object localObject2 = paramCharSequence.a();
    for (;;)
    {
      try
      {
        ((EntityTransaction)localObject2).a();
        paramQQAppInterface = paramCharSequence.a(RecentEmotionData.class, false, null, null, null, null, null, null);
        if (paramQQAppInterface != null) {
          break label805;
        }
        paramQQAppInterface = new ArrayList();
        k = 0;
        i = 0;
        if (paramQQAppInterface.size() > 0)
        {
          j = 0;
          k = i;
          if (j < paramQQAppInterface.size())
          {
            localObject3 = (RecentEmotionData)paramQQAppInterface.get(j);
            if (((ArrayList)localObject1).contains(((RecentEmotionData)localObject3).type + "," + ((RecentEmotionData)localObject3).emoIndex))
            {
              paramCharSequence.b((Entity)localObject3);
              paramQQAppInterface.remove(localObject3);
              j -= 1;
              break label808;
            }
            if (((RecentEmotionData)localObject3).emoId <= i) {
              break label802;
            }
            i = ((RecentEmotionData)localObject3).emoId;
            break label808;
          }
        }
        i = 0;
        localObject1 = new ArrayList();
        j = 0;
        if (j < 8)
        {
          int m = localArrayList.size() - 1 - j;
          if (m >= 0)
          {
            ((List)localObject1).add((RecentEmotionData)localArrayList.get(m));
            i += 1;
            break label815;
          }
        }
        else
        {
          j = paramQQAppInterface.size() + i - 8;
          if (j > 0)
          {
            i = 0;
            if (i < paramQQAppInterface.size())
            {
              if (i >= j) {
                break label822;
              }
              paramCharSequence.b((RecentEmotionData)paramQQAppInterface.get(i));
              break label822;
            }
          }
          i = ((List)localObject1).size() - 1;
          if (i >= 0)
          {
            paramQQAppInterface = (RecentEmotionData)((List)localObject1).get(i);
            k += 1;
            paramQQAppInterface.emoId = k;
            paramCharSequence.a(paramQQAppInterface);
            i -= 1;
            continue;
          }
          ((EntityTransaction)localObject2).c();
          return;
        }
      }
      catch (Exception paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "add Recent Emoticon error", paramQQAppInterface);
        }
        return;
      }
      finally
      {
        if (QLog.isColorLevel()) {
          QLog.d("SendMsgBtn", 2, " decodeToSaveEmoIndex end currenttime:" + System.currentTimeMillis());
        }
        ((EntityTransaction)localObject2).b();
        paramCharSequence.a();
      }
      break label815;
      label802:
      break label808;
      label805:
      continue;
      label808:
      j += 1;
      continue;
      label815:
      j += 1;
      continue;
      label822:
      i += 1;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    EntityManager localEntityManager = paramQQAppInterface.a().createEntityManager();
    List localList = localEntityManager.a(RecentEmotionData.class, false, null, null, null, null, null, null);
    Object localObject = localList;
    if (localList == null) {
      localObject = new ArrayList();
    }
    if (a((List)localObject, 3, 0, paramString) < 0) {
      b(paramQQAppInterface, localEntityManager, 3, 0, paramString, (List)localObject);
    }
    localEntityManager.a();
  }
  
  public static void a(RecentEmotionData paramRecentEmotionData, String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2)
  {
    paramRecentEmotionData.uin = paramString1;
    paramRecentEmotionData.emoId = paramInt1;
    paramRecentEmotionData.type = paramInt2;
    paramRecentEmotionData.emoIndex = paramInt3;
    paramRecentEmotionData.emoPath = paramString2;
  }
  
  public static void a(QQCustomMenu paramQQCustomMenu, Context paramContext, int paramInt)
  {
    if ((!AppSetting.m) && (paramInt == 0)) {
      return;
    }
    paramQQCustomMenu.a(2131234872, paramContext.getString(2131562749));
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, MessageForLongMsg paramMessageForLongMsg)
  {
    paramContext = paramMessageForLongMsg.longMsgFragmentList;
    if ((paramContext == null) || (paramContext.isEmpty())) {
      return false;
    }
    paramContext = paramContext.iterator();
    while (paramContext.hasNext())
    {
      paramMessageForLongMsg = (MessageRecord)paramContext.next();
      if (paramMessageForLongMsg.extraflag == 32768)
      {
        if (paramMessageForLongMsg.isSendFromLocal()) {
          paramQQAppInterface.a().d(paramQQAppInterface.a().a(paramMessageForLongMsg.frienduin, paramMessageForLongMsg.uniseq));
        }
        paramQQAppInterface.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramMessageForLongMsg.uniseq);
        if (paramMessageForLongMsg.msgtype == -1000)
        {
          paramMessageForLongMsg = MessageRecordFactory.a(paramMessageForLongMsg);
          paramQQAppInterface.a().a(paramMessageForLongMsg, null);
        }
      }
    }
    return true;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Emoticon paramEmoticon)
  {
    new cfy(paramQQAppInterface, paramEmoticon).execute(new Void[0]);
    return true;
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, long paramLong)
  {
    paramQQAppInterface = paramQQAppInterface.a().a(paramString, paramInt, paramLong);
    if ((paramQQAppInterface != null) && ((paramQQAppInterface instanceof MessageForPtt))) {
      return ((MessageForPtt)paramQQAppInterface).c2cViaOffline;
    }
    return false;
  }
  
  public static boolean a(RecentEmotionData paramRecentEmotionData, int paramInt1, int paramInt2, String paramString)
  {
    if (paramRecentEmotionData == null) {}
    do
    {
      do
      {
        do
        {
          return false;
        } while (paramRecentEmotionData.type != paramInt1);
        if ((paramInt1 == 3) && (paramString != null) && (paramString.equalsIgnoreCase(paramRecentEmotionData.emoPath))) {
          return true;
        }
      } while (paramRecentEmotionData.emoIndex != paramInt2);
      if ((paramRecentEmotionData.emoPath == null) && (paramString == null)) {
        return true;
      }
    } while ((paramRecentEmotionData.emoPath == null) || (paramString == null) || (!paramRecentEmotionData.emoPath.equalsIgnoreCase(paramString)));
    return true;
  }
  
  public static Object[] a(QQAppInterface paramQQAppInterface, String paramString)
  {
    Object localObject1 = paramQQAppInterface.a();
    Object localObject2 = (String)localObject1 + "_" + paramString;
    if (QLog.isColorLevel()) {
      QLog.d(ReduFriendServlet.jdField_b_of_type_JavaLangString, 2, "shouldShowRemarkVoiceCallBar() is called,mapKey is:" + (String)localObject2);
    }
    long l1 = System.currentTimeMillis();
    for (;;)
    {
      try
      {
        arrayOfObject = new Object[2];
        arrayOfObject[0] = Boolean.FALSE;
        arrayOfObject[1] = "";
        localObject3 = VoiceNotifyConfigHelper.a().a(1);
        if (localObject3 == null)
        {
          l2 = System.currentTimeMillis();
          if (QLog.isColorLevel()) {
            QLog.d(ReduFriendServlet.jdField_b_of_type_JavaLangString, 2, "step is:" + "not fulfill load remark config " + ",cost time is:" + (l2 - l1));
          }
          return arrayOfObject;
        }
        if (QLog.isColorLevel()) {
          QLog.d(ReduFriendServlet.jdField_b_of_type_JavaLangString, 2, "shortPeriod is:" + ((VoiceNotifyRules)localObject3).e + ",shortPeriodFrequency is:" + ((VoiceNotifyRules)localObject3).jdField_d_of_type_Int + ",longPeriod is:" + ((VoiceNotifyRules)localObject3).g + ",longPeriodFrequency is:" + ((VoiceNotifyRules)localObject3).f);
        }
        if (d.get(localObject2) != null)
        {
          localObject1 = (Integer)e.get(localObject2);
          if ((localObject1 == null) || (((Integer)localObject1).intValue() <= 3))
          {
            localObject2 = ((FriendManager)paramQQAppInterface.getManager(8)).c(paramString);
            if (localObject2 == null)
            {
              g(paramQQAppInterface, paramString);
              paramQQAppInterface = "can not find friend,friendUin is:" + paramString;
              l2 = System.currentTimeMillis();
              if (QLog.isColorLevel()) {
                QLog.d(ReduFriendServlet.jdField_b_of_type_JavaLangString, 2, "step is:" + paramQQAppInterface + ",cost time is:" + (l2 - l1));
              }
              return arrayOfObject;
            }
            if (!((VoiceNotifyRules)localObject3).jdField_a_of_type_Boolean)
            {
              g(paramQQAppInterface, paramString);
              l2 = System.currentTimeMillis();
              if (QLog.isColorLevel()) {
                QLog.d(ReduFriendServlet.jdField_b_of_type_JavaLangString, 2, "step is:" + "server require not show remark tip" + ",cost time is:" + (l2 - l1));
              }
              return arrayOfObject;
            }
            if ((((VoiceNotifyRules)localObject3).jdField_a_of_type_JavaUtilArrayList == null) || (((VoiceNotifyRules)localObject3).jdField_a_of_type_JavaUtilArrayList.size() == 0))
            {
              g(paramQQAppInterface, paramString);
              paramQQAppInterface = "config is wrong,ruleItems is:" + ((VoiceNotifyRules)localObject3).jdField_a_of_type_JavaUtilArrayList;
              l2 = System.currentTimeMillis();
              if (QLog.isColorLevel()) {
                QLog.d(ReduFriendServlet.jdField_b_of_type_JavaLangString, 2, "step is:" + paramQQAppInterface + ",cost time is:" + (l2 - l1));
              }
              return arrayOfObject;
            }
            localObject1 = a((Friends)localObject2, (VoiceNotifyRules)localObject3);
            if (((Boolean)localObject1[0]).booleanValue())
            {
              paramQQAppInterface = "contain keyword in remark,can show remark tip";
              arrayOfObject[0] = localObject1[0];
              arrayOfObject[1] = localObject1[1];
              l2 = System.currentTimeMillis();
              if (QLog.isColorLevel()) {
                QLog.d(ReduFriendServlet.jdField_b_of_type_JavaLangString, 2, "step is:" + paramQQAppInterface + ",cost time is:" + (l2 - l1));
              }
              return arrayOfObject;
            }
            g(paramQQAppInterface, paramString);
            paramQQAppInterface = "does not contain keyword in remark,remark is:" + ((Friends)localObject2).remark;
            continue;
          }
          g(paramQQAppInterface, paramString);
          paramQQAppInterface = "find true flag from memory but enterAIOTimes is too large,enterAIOTimes is:" + localObject1 + ",MAX_ENTER_TIMES is:" + 3;
          l2 = System.currentTimeMillis();
          if (QLog.isColorLevel()) {
            QLog.d(ReduFriendServlet.jdField_b_of_type_JavaLangString, 2, "step is:" + paramQQAppInterface + ",cost time is:" + (l2 - l1));
          }
          return arrayOfObject;
        }
        if (!((VoiceNotifyRules)localObject3).jdField_a_of_type_Boolean)
        {
          l2 = System.currentTimeMillis();
          if (QLog.isColorLevel()) {
            QLog.d(ReduFriendServlet.jdField_b_of_type_JavaLangString, 2, "step is:" + "server require not show remark tip" + ",cost time is:" + (l2 - l1));
          }
          return arrayOfObject;
        }
        if ((((VoiceNotifyRules)localObject3).jdField_a_of_type_JavaUtilArrayList == null) || (((VoiceNotifyRules)localObject3).jdField_a_of_type_JavaUtilArrayList.size() == 0))
        {
          paramQQAppInterface = "remark config is wrong,ruleItems is:" + ((VoiceNotifyRules)localObject3).jdField_a_of_type_JavaUtilArrayList;
          l2 = System.currentTimeMillis();
          if (QLog.isColorLevel()) {
            QLog.d(ReduFriendServlet.jdField_b_of_type_JavaLangString, 2, "step is:" + paramQQAppInterface + ",cost time is:" + (l2 - l1));
          }
          return arrayOfObject;
        }
        Friends localFriends = ((FriendManager)paramQQAppInterface.getManager(8)).c(paramString);
        if (localFriends == null)
        {
          paramQQAppInterface = "can not find friend,friendUin is:" + paramString;
          l2 = System.currentTimeMillis();
          if (QLog.isColorLevel()) {
            QLog.d(ReduFriendServlet.jdField_b_of_type_JavaLangString, 2, "step is:" + paramQQAppInterface + ",cost time is:" + (l2 - l1));
          }
          return arrayOfObject;
        }
        if ((localFriends.abilityBits & 1L) == 0L)
        {
          paramQQAppInterface = "friend abilityBits does not contain support voice flag,f.abilityBits is:" + localFriends.abilityBits;
          l2 = System.currentTimeMillis();
          if (QLog.isColorLevel()) {
            QLog.d(ReduFriendServlet.jdField_b_of_type_JavaLangString, 2, "step is:" + paramQQAppInterface + ",cost time is:" + (l2 - l1));
          }
          return arrayOfObject;
        }
        localObject2 = BaseApplication.getContext().getSharedPreferences("free_call", 0);
        paramString = ((SharedPreferences)localObject2).getString("voice_hot_friend_tip_show_time" + (String)localObject1, "");
        l2 = MessageCache.a() * 1000L;
        jdField_a_of_type_AndroidTextFormatTime.set(l2);
        int i = jdField_a_of_type_AndroidTextFormatTime.year;
        int j = jdField_a_of_type_AndroidTextFormatTime.month;
        int k = jdField_a_of_type_AndroidTextFormatTime.monthDay;
        if (QLog.isColorLevel())
        {
          str1 = i + "-" + j + "-" + k;
          QLog.d(ReduFriendServlet.jdField_b_of_type_JavaLangString, 2, "currDate is:" + str1 + ",hotFriendTipShowTime is:" + paramString);
        }
        if ((paramString != null) && (paramString.length() > 0))
        {
          jdField_a_of_type_AndroidTextFormatTime.set(Long.parseLong(paramString));
          int m = jdField_a_of_type_AndroidTextFormatTime.year;
          int n = jdField_a_of_type_AndroidTextFormatTime.month;
          int i1 = jdField_a_of_type_AndroidTextFormatTime.monthDay;
          if ((i == m) && (j == n) && (k == i1))
          {
            l2 = System.currentTimeMillis();
            if (QLog.isColorLevel()) {
              QLog.d(ReduFriendServlet.jdField_b_of_type_JavaLangString, 2, "step is:" + "already shown hot friend tip" + ",cost time is:" + (l2 - l1));
            }
            return arrayOfObject;
          }
        }
        String str1 = "voice_remark_tip_show_time" + (String)localObject1;
        str2 = ((SharedPreferences)localObject2).getString(str1, "");
        if (QLog.isColorLevel()) {
          QLog.d(ReduFriendServlet.jdField_b_of_type_JavaLangString, 2, "multiRemarkTipShowTime is:" + str2);
        }
        localObject1 = null;
        paramString = (String)localObject1;
        if (str2 != null)
        {
          paramString = (String)localObject1;
          if (str2.trim().length() > 0) {
            paramString = str2.split("\\|");
          }
        }
        localObject1 = a(paramString, ((VoiceNotifyRules)localObject3).e, ((VoiceNotifyRules)localObject3).jdField_d_of_type_Int, ((VoiceNotifyRules)localObject3).g, ((VoiceNotifyRules)localObject3).f, ReduFriendServlet.jdField_b_of_type_JavaLangString);
        if (((Boolean)localObject1[0]).booleanValue())
        {
          paramQQAppInterface = (String)localObject1[1];
          l2 = System.currentTimeMillis();
          if (QLog.isColorLevel()) {
            QLog.d(ReduFriendServlet.jdField_b_of_type_JavaLangString, 2, "step is:" + paramQQAppInterface + ",cost time is:" + (l2 - l1));
          }
          return arrayOfObject;
        }
        localObject3 = a(localFriends, (VoiceNotifyRules)localObject3);
        if (!((Boolean)localObject3[0]).booleanValue())
        {
          paramQQAppInterface = "does not contain keyword in remark,remark is:" + localFriends.remark;
          l2 = System.currentTimeMillis();
          if (QLog.isColorLevel()) {
            QLog.d(ReduFriendServlet.jdField_b_of_type_JavaLangString, 2, "step is:" + paramQQAppInterface + ",cost time is:" + (l2 - l1));
          }
          return arrayOfObject;
        }
        localObject1 = (String)localObject3[1];
        if ((localObject1 == null) || (((String)localObject1).trim().length() == 0))
        {
          l2 = System.currentTimeMillis();
          if (QLog.isColorLevel()) {
            QLog.d(ReduFriendServlet.jdField_b_of_type_JavaLangString, 2, "step is:" + "remark tip is empty,the config is illegal" + ",cost time is:" + (l2 - l1));
          }
          return arrayOfObject;
        }
        localObject1 = String.valueOf(l2);
        if (paramString == null) {
          break label2093;
        }
        if (paramString.length == 0)
        {
          break label2093;
          localObject1 = ((SharedPreferences)localObject2).edit();
          ((SharedPreferences.Editor)localObject1).putString(str1, paramString);
          ((SharedPreferences.Editor)localObject1).commit();
          paramString = "can show remark tip,storeRemarkTipShowTime is:" + paramString;
        }
      }
      finally
      {
        Object[] arrayOfObject;
        Object localObject3;
        String str2;
        paramString = "";
        long l2 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d(ReduFriendServlet.jdField_b_of_type_JavaLangString, 2, "step is:" + paramString + ",cost time is:" + (l2 - l1));
        }
      }
      try
      {
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "Two_call", "Tc_optips_blue", 0, 0, "", "", "", "");
        arrayOfObject[0] = localObject3[0];
        arrayOfObject[1] = localObject3[1];
        l2 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d(ReduFriendServlet.jdField_b_of_type_JavaLangString, 2, "step is:" + paramString + ",cost time is:" + (l2 - l1));
        }
        return arrayOfObject;
      }
      finally {}
      if (paramString.length < 5)
      {
        paramString = str2 + "|" + (String)localObject1;
      }
      else
      {
        paramString = str2.substring(str2.indexOf("|") + 1) + "|" + (String)localObject1;
        continue;
        label2093:
        paramString = (String)localObject1;
      }
    }
  }
  
  public static Object[] a(Friends paramFriends, VoiceNotifyRules paramVoiceNotifyRules)
  {
    if (QLog.isColorLevel()) {
      QLog.d(ReduFriendServlet.jdField_b_of_type_JavaLangString, 2, "containKeywordInRemark() is called");
    }
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Boolean.FALSE;
    arrayOfObject[1] = "";
    if (QLog.isColorLevel()) {
      QLog.d(ReduFriendServlet.jdField_b_of_type_JavaLangString, 2, "remark is:" + paramFriends.remark);
    }
    if ((paramFriends.remark == null) || (paramFriends.remark.trim().length() == 0)) {
      return arrayOfObject;
    }
    paramVoiceNotifyRules = paramVoiceNotifyRules.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (paramVoiceNotifyRules.hasNext())
    {
      VoiceNotifyRules.RuleItem localRuleItem = (VoiceNotifyRules.RuleItem)paramVoiceNotifyRules.next();
      if (paramFriends.remark.contains(localRuleItem.jdField_a_of_type_JavaLangString))
      {
        arrayOfObject[0] = Boolean.TRUE;
        arrayOfObject[1] = localRuleItem.jdField_b_of_type_JavaLangString;
        if (QLog.isColorLevel()) {
          QLog.d(ReduFriendServlet.jdField_b_of_type_JavaLangString, 2, "containKeywordInRemark ==> catch!");
        }
        return arrayOfObject;
      }
    }
    return arrayOfObject;
  }
  
  private static Object[] a(List paramList, VoiceNotifyRules paramVoiceNotifyRules, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceTipMsg", 2, "containKeywordInMsg() is called");
    }
    long l = System.currentTimeMillis();
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = Boolean.FALSE;
    arrayOfObject[1] = "";
    arrayOfObject[2] = "";
    if (jdField_a_of_type_JavaUtilHashMap == null) {
      jdField_a_of_type_JavaUtilHashMap = new HashMap();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if (QLog.isColorLevel())
    {
      localStringBuilder.append("minTime=");
      localStringBuilder.append(paramLong);
    }
    for (;;)
    {
      int i;
      ChatMessage localChatMessage;
      try
      {
        int j = paramList.size();
        i = 0;
        if (i >= j) {
          break label556;
        }
        localChatMessage = (ChatMessage)paramList.get(i);
        if (localChatMessage.msgtype != -1000) {
          break label611;
        }
        if ((localChatMessage.extraflag == 0) && (localChatMessage.time >= paramLong) && (!TextUtils.isEmpty(localChatMessage.msg)))
        {
          Object localObject = Long.valueOf(localChatMessage.uniseq);
          if (jdField_a_of_type_JavaUtilHashMap.get(localObject) == null)
          {
            jdField_a_of_type_JavaUtilHashMap.put(localObject, Boolean.TRUE);
            if (QLog.isColorLevel())
            {
              localStringBuilder.append(",indexOfMsg=");
              localStringBuilder.append(localChatMessage.uniseq);
            }
            localObject = paramVoiceNotifyRules.jdField_a_of_type_JavaUtilArrayList.iterator();
            if (((Iterator)localObject).hasNext())
            {
              VoiceNotifyRules.RuleItem localRuleItem = (VoiceNotifyRules.RuleItem)((Iterator)localObject).next();
              if (!localChatMessage.msg.contains(localRuleItem.jdField_a_of_type_JavaLangString)) {
                continue;
              }
              arrayOfObject[0] = Boolean.TRUE;
              arrayOfObject[1] = localRuleItem.jdField_b_of_type_JavaLangString;
              arrayOfObject[2] = localRuleItem.jdField_c_of_type_JavaLangString;
              if (QLog.isColorLevel())
              {
                localStringBuilder.append(",containKeywordMsg=");
                localStringBuilder.append(localChatMessage.uniseq);
              }
              return arrayOfObject;
            }
          }
        }
        else if (QLog.isColorLevel())
        {
          localStringBuilder.append(",uniseq=");
          localStringBuilder.append(localChatMessage.uniseq);
          if (localChatMessage.extraflag != 0)
          {
            localStringBuilder.append(",extraflag=");
            localStringBuilder.append(localChatMessage.extraflag);
          }
          else if (localChatMessage.time < paramLong)
          {
            localStringBuilder.append(",time=");
            localStringBuilder.append(localChatMessage.time);
          }
        }
      }
      finally
      {
        if (QLog.isColorLevel()) {
          QLog.d("VoiceTipMsg", 2, "index of keyword cost time is:" + (System.currentTimeMillis() - l) + ",index of keyword from msg log is:" + localStringBuilder.toString());
        }
      }
      if (TextUtils.isEmpty(localChatMessage.msg))
      {
        localStringBuilder.append(",isEmpty=true");
      }
      else
      {
        localStringBuilder.append(",reason=other");
        break label611;
        label556:
        if (QLog.isColorLevel()) {
          QLog.d("VoiceTipMsg", 2, "index of keyword cost time is:" + (System.currentTimeMillis() - l) + ",index of keyword from msg log is:" + localStringBuilder.toString());
        }
        return arrayOfObject;
      }
      label611:
      i += 1;
    }
  }
  
  private static Object[] a(String[] paramArrayOfString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(paramString, 2, "dateArray is:" + Arrays.toString(paramArrayOfString) + ",shortPeriod is:" + paramInt1 + ",shortPeriodFrequence is:" + paramInt2 + ",longPeriod is:" + paramInt3 + ",longPeriodFrequence is:" + paramInt4);
    }
    int i = paramInt1;
    if (paramInt1 <= 0) {
      i = 1;
    }
    paramInt1 = paramInt2;
    if (paramInt2 < 0) {
      paramInt1 = 0;
    }
    paramInt2 = paramInt3;
    if (paramInt3 <= 0) {
      paramInt2 = 1;
    }
    paramInt3 = paramInt4;
    if (paramInt4 < 0) {
      paramInt3 = 0;
    }
    paramString = new Object[2];
    paramString[0] = Boolean.FALSE;
    paramString[1] = "";
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {
      return paramString;
    }
    long l1 = a(MessageCache.a() * 1000L, jdField_a_of_type_AndroidTextFormatTime);
    long l2 = paramInt2 - 1;
    long l3 = i - 1;
    int m = 0;
    int j = 0;
    paramInt4 = 0;
    while (paramInt4 < paramArrayOfString.length)
    {
      long l4 = Long.parseLong(paramArrayOfString[paramInt4]);
      int k = m;
      if (l4 >= l1 - l2 * 86400000L) {
        k = m + 1;
      }
      m = j;
      if (l4 >= l1 - l3 * 86400000L) {
        m = j + 1;
      }
      paramInt4 += 1;
      j = m;
      m = k;
    }
    if ((j < paramInt1) && (m < paramInt3)) {
      return paramString;
    }
    paramString[0] = Boolean.TRUE;
    paramString[1] = ("shown remark tip " + j + " times in " + i + " day," + m + " times in " + paramInt2 + " day");
    return paramString;
  }
  
  public static String[] a(QQAppInterface paramQQAppInterface, String paramString, long paramLong)
  {
    paramQQAppInterface = BaseApplication.getContext().getSharedPreferences("free_call", 0);
    long l = Long.parseLong(paramQQAppInterface.getString(b(paramString), "-1"));
    if (Math.abs(paramLong - l) >= 86400000L)
    {
      if (QLog.isColorLevel()) {
        QLog.d(ReduFriendServlet.jdField_b_of_type_JavaLangString, 2, "currTime is:" + paramLong + ",pullHotFriendTimeLong is:" + l + ",need to pull hot friend");
      }
      return null;
    }
    return paramQQAppInterface.getString(c(paramString), "").split("\\|");
  }
  
  private static long b(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    if (paramSessionInfo.jdField_a_of_type_Int == 0)
    {
      paramQQAppInterface = ((FriendManager)paramQQAppInterface.getManager(8)).c(paramSessionInfo.jdField_a_of_type_JavaLangString);
      if (paramQQAppInterface != null) {
        return paramQQAppInterface.richTime;
      }
    }
    return 0L;
  }
  
  public static String b(String paramString)
  {
    return "free_call_pull_hot_friend_time_" + paramString;
  }
  
  public static void b(ChatActivity paramChatActivity, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, List paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceTipMsg", 2, "insertDiscPttFreqCallTipIfNeeded() =====>");
    }
    String str = "";
    if (paramList != null) {}
    int i;
    int j;
    int k;
    for (;;)
    {
      try
      {
        if (paramSessionInfo.jdField_a_of_type_Int != 3000)
        {
          if (QLog.isColorLevel()) {
            QLog.d("VoiceTipMsg", 2, "insertDiscPttFreqCallTipIfNeeded() <=====, step is:" + "curType != disscusion");
          }
          return;
        }
      }
      finally
      {
        try
        {
          long l1;
          SharedPreferences localSharedPreferences;
          Object localObject1;
          Object localObject2;
          int m;
          int n;
          int i1;
          long l2;
          ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8003F01", "0X8003F01", 0, 0, "", "", "", "");
          paramChatActivity = "insert discuss ppt frequent tip msg success";
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("VoiceTipMsg", 2, "insertDiscPttFreqCallTipIfNeeded() <=====, step is:" + paramChatActivity);
          return;
        }
        finally
        {
          paramQQAppInterface = "insert discuss ppt frequent tip msg success";
        }
        paramChatActivity = finally;
        paramQQAppInterface = str;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("VoiceTipMsg", 2, "insertDiscPttFreqCallTipIfNeeded() <=====, step is:" + paramQQAppInterface);
      }
      if (!NetworkUtil.g(paramQQAppInterface.getApplication()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("VoiceTipMsg", 2, "insertDiscPttFreqCallTipIfNeeded() <=====, step is:" + "not wifi");
        }
      }
      else if (paramList.size() < 5)
      {
        paramChatActivity = "msgList size < 5, size = " + paramList.size();
        if (QLog.isColorLevel()) {
          QLog.d("VoiceTipMsg", 2, "insertDiscPttFreqCallTipIfNeeded() <=====, step is:" + paramChatActivity);
        }
      }
      else if (paramChatActivity.c())
      {
        if (QLog.isColorLevel()) {
          QLog.d("VoiceTipMsg", 2, "insertDiscPttFreqCallTipIfNeeded() <=====, step is:" + "multiVideoStatus bar is visible,return");
        }
      }
      else
      {
        l1 = Long.valueOf(paramSessionInfo.jdField_a_of_type_JavaLangString).longValue();
        if (paramQQAppInterface.a().a(l1))
        {
          if (QLog.isColorLevel()) {
            QLog.d("VoiceTipMsg", 2, "insertDiscPttFreqCallTipIfNeeded() <=====, step is:" + "current discussion is on voice chating");
          }
        }
        else
        {
          l1 = MessageCache.a() * 1000L;
          jdField_a_of_type_AndroidTextFormatTime.set(l1);
          i = jdField_a_of_type_AndroidTextFormatTime.year;
          j = jdField_a_of_type_AndroidTextFormatTime.month;
          k = jdField_a_of_type_AndroidTextFormatTime.monthDay;
          paramChatActivity = "voice_disc_ptt_freq_tip_msg_insert_time" + paramQQAppInterface.a();
          localSharedPreferences = BaseApplication.getContext().getSharedPreferences("free_call", 0);
          localObject1 = localSharedPreferences.getString(paramChatActivity, null);
          if (QLog.isColorLevel())
          {
            localObject2 = i + "-" + j + "-" + k;
            QLog.d("VoiceTipMsg", 2, "currDate is:" + (String)localObject2 + ",curr hour is:" + jdField_a_of_type_AndroidTextFormatTime.hour + ",discPttFreqTipMsgInsertTime is:" + (String)localObject1);
          }
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            jdField_a_of_type_AndroidTextFormatTime.set(Long.parseLong((String)localObject1));
            m = jdField_a_of_type_AndroidTextFormatTime.year;
            n = jdField_a_of_type_AndroidTextFormatTime.month;
            i1 = jdField_a_of_type_AndroidTextFormatTime.monthDay;
            if ((i == m) && (j == n) && (k == i1))
            {
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.d("VoiceTipMsg", 2, "insertDiscPttFreqCallTipIfNeeded() <=====, step is:" + "already insert discuss ppt frequent tip msg this day");
              return;
            }
          }
          localObject1 = localSharedPreferences.getString("start_group_audio_time" + paramQQAppInterface.a(), null);
          if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (l1 - Long.parseLong((String)localObject1) <= 600000L))
          {
            if (QLog.isColorLevel()) {
              QLog.d("VoiceTipMsg", 2, "insertDiscPttFreqCallTipIfNeeded() <=====, step is:" + "has startGroupAudio in less 10 mins, just return");
            }
          }
          else
          {
            l2 = (l1 - 600000L) / 1000L;
            j = paramList.size();
            i = 0;
            localObject1 = new HashSet();
            k = j - 1;
          }
        }
      }
    }
    for (;;)
    {
      if (k >= 0)
      {
        localObject2 = (ChatMessage)paramList.get(k);
        j = i;
        if (((ChatMessage)localObject2).time >= l2)
        {
          j = i;
          if (((ChatMessage)localObject2).msgtype == -2002)
          {
            j = i;
            if (((ChatMessage)localObject2).extraflag == 0)
            {
              j = i + 1;
              ((HashSet)localObject1).add(((ChatMessage)localObject2).senderuin);
            }
          }
        }
      }
      else
      {
        j = ((HashSet)localObject1).size();
        if (QLog.isColorLevel()) {
          QLog.d("VoiceTipMsg", 2, "pttMsgNum : " + i + ", msgUinNum : " + j);
        }
        if ((i >= 5) && (j >= 2))
        {
          paramList = QQOperateManager.a(paramQQAppInterface);
          boolean bool = paramList.b(paramSessionInfo.jdField_a_of_type_Int, 2);
          if (bool)
          {
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("VoiceTipMsg", 2, "insertDiscPttFreqCallTipIfNeeded() <=====, step is:" + "");
            return;
          }
          localObject1 = MessageRecordFactory.a(-1016);
          l2 = MessageCache.a();
          localObject2 = paramQQAppInterface.a();
          ((MessageRecord)localObject1).init((String)localObject2, paramSessionInfo.jdField_a_of_type_JavaLangString, (String)localObject2, paramQQAppInterface.getApplication().getString(2131563103), l2, -1017, 3000, l2);
          ((MessageRecord)localObject1).isread = true;
          paramQQAppInterface.a().a((MessageRecord)localObject1, ((MessageRecord)localObject1).selfuin);
          if ((paramSessionInfo.jdField_a_of_type_Int == 0) || (paramSessionInfo.jdField_a_of_type_Int == 3000)) {
            paramList.a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_Int, 2);
          }
          paramSessionInfo = localSharedPreferences.edit();
          paramSessionInfo.putString(paramChatActivity, String.valueOf(l1));
          paramSessionInfo.commit();
        }
        for (;;)
        {
          paramChatActivity = "";
        }
      }
      k -= 1;
      i = j;
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    int i = MobileQQService.jdField_c_of_type_Int;
    MobileQQService.jdField_c_of_type_Int = i + 1;
    long l = i;
    String str = paramQQAppInterface.a();
    paramSessionInfo = MessageRecordFactory.a(str, paramSessionInfo.jdField_a_of_type_JavaLangString, str, paramSessionInfo.jdField_a_of_type_Int, l);
    paramQQAppInterface.a().a(paramSessionInfo, null);
    if ((paramContext instanceof ChatActivity)) {
      ((ChatActivity)paramContext).a(paramSessionInfo);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.shakemsg", 2, "create new shake message,shmsgseq is:" + paramSessionInfo.shmsgseq + ",msgUid is:" + paramSessionInfo.msgUid + ",time is:" + System.currentTimeMillis());
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, Intent paramIntent, String paramString, ForwardFileInfo paramForwardFileInfo)
  {
    if ((paramForwardFileInfo != null) && (paramForwardFileInfo.a() == 10006) && (paramSessionInfo.jdField_a_of_type_Int == 1)) {
      a(paramQQAppInterface, paramContext, paramSessionInfo, paramIntent, paramString, paramForwardFileInfo);
    }
    for (;;)
    {
      return;
      if (paramIntent.getBooleanExtra("isFromShare", false))
      {
        if (!paramIntent.getBooleanExtra("sendMultiple", false))
        {
          if (paramSessionInfo.jdField_a_of_type_Int == 1)
          {
            paramQQAppInterface.a().a(paramString, paramSessionInfo.jdField_a_of_type_JavaLangString);
            return;
          }
          paramQQAppInterface.a().a(paramString, paramSessionInfo.jdField_b_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, true);
        }
      }
      else if (paramIntent.getBooleanExtra("not_forward", false))
      {
        if ((paramQQAppInterface.a().b(paramForwardFileInfo.b()) == null) && (QLog.isColorLevel())) {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "there has a Bug!,sissionId[" + paramForwardFileInfo.b() + "]");
        }
        switch (paramForwardFileInfo.a())
        {
        }
        while (paramIntent.getBooleanExtra("not_forward", false))
        {
          paramIntent.removeExtra("not_forward");
          paramIntent.getExtras().remove("not_forward");
          return;
          if ((FileManagerUtil.a()) && (paramForwardFileInfo.d() > 5242880L))
          {
            FMDialogUtil.a(paramContext, 2131558759, 2131558756, new cfu(paramSessionInfo, paramQQAppInterface, paramForwardFileInfo));
          }
          else if (paramSessionInfo.jdField_a_of_type_Int == 1)
          {
            paramQQAppInterface.a().a(paramForwardFileInfo.a(), paramSessionInfo.jdField_a_of_type_JavaLangString);
          }
          else
          {
            paramQQAppInterface.a().a(paramForwardFileInfo.a(), paramSessionInfo.jdField_b_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, true);
            continue;
            if (paramSessionInfo.jdField_a_of_type_Int == 1)
            {
              if (!TextUtils.isEmpty(paramForwardFileInfo.a())) {
                paramQQAppInterface.a().a(paramForwardFileInfo.a(), paramSessionInfo.jdField_a_of_type_JavaLangString);
              } else {
                paramQQAppInterface.a().a(paramForwardFileInfo.b(), paramSessionInfo.jdField_a_of_type_JavaLangString);
              }
            }
            else
            {
              paramString = paramQQAppInterface.a().a(paramForwardFileInfo.b());
              paramContext = paramQQAppInterface.a();
              if ((paramSessionInfo.jdField_a_of_type_Int == 1004) || (paramSessionInfo.jdField_a_of_type_Int == 1000)) {
                paramContext = paramSessionInfo.jdField_b_of_type_JavaLangString;
              }
              paramContext = paramQQAppInterface.a().a(paramString, paramContext, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int);
              if (paramString.peerType == 3000)
              {
                if (paramSessionInfo.jdField_a_of_type_Int == 0) {
                  paramQQAppInterface.a().b(paramContext, 21);
                } else if (paramSessionInfo.jdField_a_of_type_Int == 3000) {
                  paramQQAppInterface.a().b(paramContext, 22);
                }
              }
              else
              {
                paramQQAppInterface.a().a(paramContext, paramSessionInfo.jdField_a_of_type_Int);
                continue;
                paramContext = paramQQAppInterface.a().a(paramForwardFileInfo.b());
                paramQQAppInterface.a().b(paramContext, paramSessionInfo.jdField_b_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int);
                continue;
                if ((FileManagerUtil.a()) && (paramForwardFileInfo.d() > 5242880L) && (paramForwardFileInfo.c() == 3)) {
                  FMDialogUtil.a(paramContext, 2131558759, 2131558756, new cfv(paramSessionInfo, paramForwardFileInfo, paramQQAppInterface));
                } else if (paramSessionInfo.jdField_a_of_type_Int == 1)
                {
                  if (!TextUtils.isEmpty(paramForwardFileInfo.a())) {
                    paramQQAppInterface.a().a(paramForwardFileInfo.a(), paramSessionInfo.jdField_a_of_type_JavaLangString);
                  } else {
                    paramQQAppInterface.a().a(paramForwardFileInfo.b(), paramSessionInfo.jdField_a_of_type_JavaLangString);
                  }
                }
                else {
                  paramQQAppInterface.a().a(paramForwardFileInfo.b(), paramSessionInfo.jdField_b_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, true);
                }
              }
            }
          }
        }
      }
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, String paramString)
  {
    a(paramQQAppInterface, paramContext, paramSessionInfo, paramString, null);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    Friends localFriends;
    RichStatus localRichStatus;
    if (paramSessionInfo.jdField_a_of_type_Int == 0)
    {
      localFriends = ((FriendManager)paramQQAppInterface.getManager(8)).c(paramSessionInfo.jdField_a_of_type_JavaLangString);
      if (localFriends == null) {
        break label920;
      }
      localRichStatus = localFriends.getRichStatus();
      if (localFriends.richTime != 0L) {
        break label66;
      }
      if (QLog.isColorLevel()) {
        QLog.d("AIOSign", 2, "richTime is 0,do not insert this sign msg");
      }
    }
    label66:
    long l;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("AIOSign", 2, "richTime is:" + localFriends.richTime);
      }
      l = System.currentTimeMillis() - localFriends.richTime * 1000L;
      if ((l > 604800000L) || (l < 0L)) {
        break label875;
      }
      l = paramQQAppInterface.a().e(paramSessionInfo.jdField_a_of_type_JavaLangString);
      if (localFriends.richTime > l) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d(jdField_a_of_type_JavaLangString, 2, "----------insertSignMsgIfNeeded feedTime<=lastTime friendUin: " + paramSessionInfo.jdField_a_of_type_JavaLangString + " feedTime: " + localFriends.richTime + " lastfeedTime: " + localFriends.richTime);
    return;
    Object localObject1 = new JSONObject();
    for (;;)
    {
      int i;
      try
      {
        ((JSONObject)localObject1).put("ver", "1.0");
        ((JSONObject)localObject1).put("time", String.valueOf(localFriends.richTime));
        if ((localRichStatus.jdField_c_of_type_JavaLangString != null) && (localRichStatus.jdField_c_of_type_JavaLangString.trim().length() > 0))
        {
          ((JSONObject)localObject1).put("aid", String.valueOf(localRichStatus.jdField_b_of_type_Int));
          ((JSONObject)localObject1).put("actiontext", localRichStatus.jdField_c_of_type_JavaLangString);
        }
        if ((localRichStatus.jdField_d_of_type_JavaLangString != null) && (localRichStatus.jdField_d_of_type_JavaLangString.trim().length() > 0))
        {
          ((JSONObject)localObject1).put("did", String.valueOf(localRichStatus.jdField_c_of_type_Int));
          ((JSONObject)localObject1).put("datatext", localRichStatus.jdField_d_of_type_JavaLangString);
        }
        ((JSONObject)localObject1).put("loctextpos", String.valueOf(localRichStatus.jdField_d_of_type_Int));
        if ((localRichStatus.jdField_a_of_type_JavaUtilArrayList != null) && (localRichStatus.jdField_a_of_type_JavaUtilArrayList.size() > 0))
        {
          int j = localRichStatus.jdField_a_of_type_JavaUtilArrayList.size();
          localObject2 = new JSONArray();
          i = 0;
          if (i < j)
          {
            String str = (String)localRichStatus.jdField_a_of_type_JavaUtilArrayList.get(i);
            if ((str == null) || (str.trim().length() <= 0)) {
              break label957;
            }
            ((JSONArray)localObject2).put(str);
            break label957;
          }
          if (((JSONArray)localObject2).length() > 0) {
            ((JSONObject)localObject1).put("plaintext", localObject2);
          }
        }
        if ((localRichStatus.e != null) && (localRichStatus.e.trim().length() > 0)) {
          ((JSONObject)localObject1).put("loctext", localRichStatus.e);
        }
        if (((JSONObject)localObject1).length() > 3) {
          break label652;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 2, "sign is empty,rs.actionText is:" + localRichStatus.jdField_c_of_type_JavaLangString + ",rs.dataText is:" + localRichStatus.jdField_d_of_type_JavaLangString + ",rs.plainText is:" + localRichStatus.jdField_a_of_type_JavaUtilArrayList + ",rs.locationText is:" + localRichStatus.e);
        return;
      }
      catch (JSONException paramQQAppInterface) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(jdField_a_of_type_JavaLangString, 2, "insertSignMsgIfNeeded failed,error msg is:" + paramQQAppInterface.getMessage(), paramQQAppInterface);
      return;
      label652:
      localObject1 = ((JSONObject)localObject1).toString();
      Object localObject2 = MessageRecordFactory.a(-1034);
      l = paramQQAppInterface.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int);
      ((MessageRecord)localObject2).init(paramQQAppInterface.a(), paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_JavaLangString, (String)localObject1, l, -1034, paramSessionInfo.jdField_a_of_type_Int, l);
      ((MessageRecord)localObject2).isread = true;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "----------addFriendFeedMsg  friendUin: " + paramSessionInfo.jdField_a_of_type_JavaLangString + " msgTime: " + ((MessageRecord)localObject2).time);
      }
      if (!MessageHandlerUtils.a(paramQQAppInterface, (MessageRecord)localObject2, false)) {
        paramQQAppInterface.a().a((MessageRecord)localObject2, ((MessageRecord)localObject2).selfuin);
      }
      paramQQAppInterface.a().e(paramSessionInfo.jdField_a_of_type_JavaLangString, localFriends.richTime);
      if ((localRichStatus.jdField_c_of_type_JavaLangString != null) && (localRichStatus.jdField_c_of_type_JavaLangString.trim().length() > 0)) {}
      for (paramSessionInfo = String.valueOf(localRichStatus.jdField_b_of_type_Int);; paramSessionInfo = "normalsign")
      {
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "Rich_status", "card_exposure_aio", 0, 0, "", "", paramSessionInfo, "");
        return;
      }
      label875:
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("AIOSign", 2, "intervalTime is:" + l / 86400000L + ",do not insert this sign msg");
      return;
      label920:
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("AIOSign", 2, "f is null,insert sign msg failed,curFriendUin is:" + paramSessionInfo.jdField_a_of_type_JavaLangString);
      return;
      label957:
      i += 1;
    }
  }
  
  private static void b(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, AIONewestFeedRsp paramAIONewestFeedRsp, ChatAdapter1 paramChatAdapter1)
  {
    if ((paramAIONewestFeedRsp.uOpuin != Long.valueOf(paramQQAppInterface.a()).longValue()) || (paramAIONewestFeedRsp.uFeedInfos == null) || (paramAIONewestFeedRsp.uFeedInfos.isEmpty())) {}
    label157:
    do
    {
      Object localObject;
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              paramAIONewestFeedRsp = (NewestFeedInfo)paramAIONewestFeedRsp.uFeedInfos.get(0);
            } while (paramAIONewestFeedRsp == null);
            localObject = a(paramAIONewestFeedRsp);
          } while (localObject == null);
          localObject = ((JSONObject)localObject).toString();
          l = b(paramQQAppInterface, paramSessionInfo);
          paramChatAdapter1 = a(paramChatAdapter1);
          if (paramChatAdapter1 == null) {
            break label157;
          }
          if (paramChatAdapter1.msgtype != -2015) {
            break;
          }
          paramQQAppInterface.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramChatAdapter1.uniseq, (String)localObject);
          paramQQAppInterface = paramQQAppInterface.a(ChatActivity.class);
        } while (paramQQAppInterface == null);
        paramQQAppInterface.sendEmptyMessage(18);
        return;
      } while ((paramChatAdapter1.msgtype == -1034) && (paramAIONewestFeedRsp.uTime < l));
      paramChatAdapter1 = MessageRecordFactory.a(-2015);
      long l = paramAIONewestFeedRsp.uTime;
      paramChatAdapter1.init(paramQQAppInterface.a(), String.valueOf(paramAIONewestFeedRsp.uHostUin), String.valueOf(paramAIONewestFeedRsp.uHostUin), (String)localObject, l, -2015, paramSessionInfo.jdField_a_of_type_Int, l);
      paramChatAdapter1.isread = true;
    } while (MessageHandlerUtils.a(paramQQAppInterface, paramChatAdapter1, false));
    paramQQAppInterface.a().a(paramChatAdapter1, paramChatAdapter1.selfuin);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString, long paramLong, int paramInt1, boolean paramBoolean, byte paramByte1, byte paramByte2, short paramShort, int paramInt2, ArrayList paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SendMsgBtn", 2, " createMsgQueueAndSend start currenttime:" + System.currentTimeMillis() + " sessionInfo.entrance:" + paramSessionInfo.jdField_c_of_type_Int);
    }
    String str1 = "";
    if (paramString != null) {
      str1 = MessageUtils.a(paramString, true, paramArrayList);
    }
    if (QLog.isColorLevel()) {
      QLog.d("SendMsgBtn", 2, " createMsgQueueAndSend step 1  currenttime:" + System.currentTimeMillis());
    }
    paramInt1 = (int)MessageCache.a();
    String str2 = paramQQAppInterface.a();
    long l = MessageUtils.a(paramInt2);
    if ((paramSessionInfo.jdField_a_of_type_Int == 1004) || (paramSessionInfo.jdField_a_of_type_Int == 1020) || (paramSessionInfo.jdField_a_of_type_Int == 1000)) {
      paramString = paramSessionInfo.jdField_b_of_type_JavaLangString;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SendMsgBtn", 2, " createMsgQueueAndSend step 2 time = " + paramInt1 + " selfUin = " + str2 + " senderUin = " + paramString + " msgUid = " + l + " currenttime:" + System.currentTimeMillis());
      }
      ChatMessage localChatMessage = (ChatMessage)MessageRecordFactory.a(-1000);
      localChatMessage.init(str2, paramSessionInfo.jdField_a_of_type_JavaLangString, paramString, str1, paramInt1, -1000, paramSessionInfo.jdField_a_of_type_Int, paramLong);
      localChatMessage.longMsgCount = paramByte1;
      localChatMessage.longMsgIndex = paramByte2;
      localChatMessage.longMsgId = paramShort;
      localChatMessage.isread = true;
      localChatMessage.msgUid = l;
      localChatMessage.shmsgseq = MessageUtils.a(paramLong, paramSessionInfo.jdField_a_of_type_Int);
      localChatMessage.issend = 1;
      localChatMessage.mAnimFlag = true;
      paramString = (MessageForText)localChatMessage;
      paramString.msgVia = paramSessionInfo.jdField_c_of_type_Int;
      if (paramArrayList != null) {
        paramString.atInfoList = paramArrayList;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SendMsgBtn", 2, " createMsgQueueAndSend step 3  currenttime:" + System.currentTimeMillis());
      }
      paramQQAppInterface.a().a(localChatMessage, null);
      if (QLog.isColorLevel()) {
        QLog.d("SendMsgBtn", 2, " createMsgQueueAndSend end currenttime:" + System.currentTimeMillis());
      }
      return;
      if (paramSessionInfo.jdField_a_of_type_Int == 1006) {
        paramString = paramSessionInfo.e;
      } else {
        paramString = str2;
      }
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    FileManagerEntity localFileManagerEntity;
    if ((paramChatMessage instanceof MessageForFile))
    {
      localFileManagerEntity = paramQQAppInterface.a().a(paramChatMessage.uniseq, paramChatMessage.frienduin, paramChatMessage.istroop);
      if ((localFileManagerEntity == null) && (QLog.isColorLevel())) {
        QLog.w(jdField_a_of_type_JavaLangString, 2, "why FileManagerEntity is null?! may be is old data!");
      }
      if (paramChatMessage.isSendFromLocal()) {
        paramQQAppInterface.a().d(paramQQAppInterface.a().a(paramChatMessage.frienduin, paramChatMessage.uniseq));
      }
      if (localFileManagerEntity != null)
      {
        if (localFileManagerEntity.cloudType != 0) {
          break label145;
        }
        paramQQAppInterface.a().a(localFileManagerEntity.nSessionId);
      }
    }
    for (;;)
    {
      paramQQAppInterface.a().b(localFileManagerEntity);
      if ((localFileManagerEntity != null) && (localFileManagerEntity.bDelInAio) && (localFileManagerEntity.bDelInFM) && (localFileManagerEntity.cloudType == 0)) {
        paramQQAppInterface.a().d(localFileManagerEntity.nSessionId);
      }
      return;
      label145:
      paramQQAppInterface.a().a(localFileManagerEntity.nSessionId);
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString)
  {
    String str1 = paramQQAppInterface.a();
    String str2 = str1 + "_" + paramString;
    if (QLog.isColorLevel()) {
      QLog.d(ReduFriendServlet.jdField_b_of_type_JavaLangString, 2, "afterShowHotFriendTip() is called,mapKey is:" + str2);
    }
    Object localObject = BaseApplication.getContext().getSharedPreferences("free_call", 0);
    String str3 = a(str1);
    boolean bool = ((SharedPreferences)localObject).getBoolean(str3, false);
    if (bool) {
      if (QLog.isColorLevel()) {
        QLog.d(ReduFriendServlet.jdField_b_of_type_JavaLangString, 2, "shownHotFriendTip is:" + bool + ",not need to save value");
      }
    }
    do
    {
      return;
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putBoolean(str3, true);
      long l = MessageCache.a();
      ((SharedPreferences.Editor)localObject).putString("voice_hot_friend_tip_show_time" + str1, String.valueOf(l * 1000L));
      ((SharedPreferences.Editor)localObject).commit();
      b.put(str2, Boolean.TRUE);
      c(paramQQAppInterface, paramString);
    } while (!QLog.isColorLevel());
    QLog.d(ReduFriendServlet.jdField_b_of_type_JavaLangString, 2, "shownHotFriendTip is:" + bool + ",need to save value");
  }
  
  private static boolean b(QQAppInterface paramQQAppInterface, EntityManager paramEntityManager, int paramInt1, int paramInt2, String paramString, List paramList)
  {
    int i = 0;
    if (paramList.size() == 0)
    {
      localRecentEmotionData = new RecentEmotionData();
      a(localRecentEmotionData, paramQQAppInterface.a(), 0, paramInt1, paramInt2, paramString);
      paramEntityManager.a(localRecentEmotionData);
      paramList.add(localRecentEmotionData);
      return true;
    }
    int j = paramList.size();
    if (j == 8)
    {
      while (i < j - 1)
      {
        paramQQAppInterface = (RecentEmotionData)paramList.get(i);
        paramQQAppInterface.type = ((RecentEmotionData)paramList.get(i + 1)).type;
        paramQQAppInterface.emoIndex = ((RecentEmotionData)paramList.get(i + 1)).emoIndex;
        paramQQAppInterface.emoPath = ((RecentEmotionData)paramList.get(i + 1)).emoPath;
        paramEntityManager.a(paramQQAppInterface);
        i += 1;
      }
      paramQQAppInterface = (RecentEmotionData)paramList.get(j - 1);
      a(paramQQAppInterface, paramQQAppInterface.uin, paramQQAppInterface.emoId, paramInt1, paramInt2, paramString);
      paramEntityManager.a(paramQQAppInterface);
      paramList.add(paramQQAppInterface);
      return true;
    }
    RecentEmotionData localRecentEmotionData = new RecentEmotionData();
    a(localRecentEmotionData, paramQQAppInterface.a(), j, paramInt1, paramInt2, paramString);
    paramEntityManager.b(localRecentEmotionData);
    paramList.add(localRecentEmotionData);
    return true;
  }
  
  public static String c(String paramString)
  {
    return "free_call_hot_friend_" + paramString;
  }
  
  public static void c(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    MessageRecord localMessageRecord = MessageRecordFactory.a(-4005);
    long l = MessageCache.a();
    localMessageRecord.init(paramQQAppInterface.a(), paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_JavaLangString, BaseApplicationImpl.getContext().getString(2131562087), l, -4005, paramSessionInfo.jdField_a_of_type_Int, l);
    localMessageRecord.isread = true;
    if (!MessageHandlerUtils.a(paramQQAppInterface, localMessageRecord, false)) {
      paramQQAppInterface.a().a(localMessageRecord, localMessageRecord.selfuin);
    }
  }
  
  public static void c(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = paramQQAppInterface.a();
    paramQQAppInterface = paramQQAppInterface + "_" + paramString;
    if (QLog.isColorLevel()) {
      QLog.d(ReduFriendServlet.jdField_b_of_type_JavaLangString, 2, "incrementHotFriendEnterAIOTimes() is called,mapKey is:" + paramQQAppInterface);
    }
    if (b.get(paramQQAppInterface) != null)
    {
      paramString = (Integer)c.get(paramQQAppInterface);
      if (paramString == null)
      {
        c.put(paramQQAppInterface, Integer.valueOf(1));
        if (QLog.isColorLevel()) {
          QLog.d(ReduFriendServlet.jdField_b_of_type_JavaLangString, 2, "shownHotFriendTip flag exist,beforeTimes is:" + paramString);
        }
      }
    }
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        return;
        c.put(paramQQAppInterface, Integer.valueOf(paramString.intValue() + 1));
      }
    }
    QLog.d(ReduFriendServlet.jdField_b_of_type_JavaLangString, 2, "shownHotFriendTip flag does not exist,not increment time");
  }
  
  public static void d(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    Object localObject1 = new EventItem(18, null);
    ((EventItem)localObject1).eventType = 538052865;
    Object localObject2 = new JceOutputStream();
    ((JceOutputStream)localObject2).setServerEncoding("utf-8");
    ((EventItem)localObject1).writeTo((JceOutputStream)localObject2);
    localObject1 = new String(((JceOutputStream)localObject2).toByteArray());
    localObject2 = paramQQAppInterface.a();
    paramSessionInfo = paramSessionInfo.jdField_a_of_type_JavaLangString;
    paramQQAppInterface = paramQQAppInterface.e();
    int i = MobileQQService.jdField_c_of_type_Int;
    MobileQQService.jdField_c_of_type_Int = i + 1;
    ((MessageHandler)localObject2).a(paramSessionInfo, (String)localObject1, (byte)18, paramQQAppInterface, i, -1L);
  }
  
  public static void d(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(ReduFriendServlet.jdField_b_of_type_JavaLangString, 2, "removeShownHotFriendTipFlag() is called");
    }
    paramQQAppInterface = paramQQAppInterface.a();
    paramQQAppInterface = paramQQAppInterface + "_" + paramString;
    b.remove(paramQQAppInterface);
  }
  
  public static void e(QQAppInterface paramQQAppInterface, String paramString)
  {
    String str = paramQQAppInterface.a();
    str = str + "_" + paramString;
    if (QLog.isColorLevel()) {
      QLog.d(ReduFriendServlet.jdField_b_of_type_JavaLangString, 2, "afterShowRemarkTip() is called,mapKey is:" + str);
    }
    if (d.get(str) == null)
    {
      d.put(str, Boolean.TRUE);
      f(paramQQAppInterface, paramString);
    }
  }
  
  public static void f(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = paramQQAppInterface.a();
    paramQQAppInterface = paramQQAppInterface + "_" + paramString;
    if (QLog.isColorLevel()) {
      QLog.d(ReduFriendServlet.jdField_b_of_type_JavaLangString, 2, "incrementRemarkEnterAIOTimes() is called,mapKey is:" + paramQQAppInterface);
    }
    if (d.get(paramQQAppInterface) != null)
    {
      paramString = (Integer)e.get(paramQQAppInterface);
      if (paramString == null)
      {
        e.put(paramQQAppInterface, Integer.valueOf(1));
        if (QLog.isColorLevel()) {
          QLog.d(ReduFriendServlet.jdField_b_of_type_JavaLangString, 2, "shownRemarkTip flag exist,beforeTimes is:" + paramString);
        }
      }
    }
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        return;
        e.put(paramQQAppInterface, Integer.valueOf(paramString.intValue() + 1));
      }
    }
    QLog.d(ReduFriendServlet.jdField_b_of_type_JavaLangString, 2, "shownRemarkTip flag does not exist,not increment time");
  }
  
  public static void g(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(ReduFriendServlet.jdField_b_of_type_JavaLangString, 2, "removeShownRemarkTipFlag() is called");
    }
    paramQQAppInterface = paramQQAppInterface.a();
    paramQQAppInterface = paramQQAppInterface + "_" + paramString;
    d.remove(paramQQAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatActivityFacade
 * JD-Core Version:    0.7.0.1
 */