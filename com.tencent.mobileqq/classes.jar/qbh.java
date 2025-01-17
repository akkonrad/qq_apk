import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.os.Message;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.device.JNICallCenter.DataPoint;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.datadef.MsgPack;
import com.tencent.device.datadef.ProductInfo;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.device.file.DeviceAVFileMsgObserver;
import com.tencent.device.msg.activities.DeviceTipActivity;
import com.tencent.device.msg.data.DevSingleStructMsgProcessor;
import com.tencent.device.msg.data.DeviceComnFileMsgProcessor;
import com.tencent.device.msg.data.DeviceGroupChatMsgProcessor;
import com.tencent.device.msg.data.DeviceMsgHandle;
import com.tencent.device.msg.data.MessageForDevLittleVideo;
import com.tencent.device.utils.SmartDeviceReport;
import com.tencent.device.utils.SmartDeviceUtil;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageForDeviceFile;
import com.tencent.mobileqq.data.MessageForDeviceSingleStruct;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import cooperation.smartdevice.SmartDevicePluginDownloadActivity;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class qbh
  extends BroadcastReceiver
{
  public qbh(DeviceMsgHandle paramDeviceMsgHandle) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    long l1;
    if (paramIntent.getAction().equalsIgnoreCase("SmartDevice_DeviceUnBindRst"))
    {
      paramContext = paramIntent.getExtras();
      l1 = paramContext.getLong("deviceopdin", 0L);
      if (paramContext.getInt("deviceoprstcode", 0) == 0) {
        this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(Long.valueOf(l1).toString(), 9501);
      }
    }
    label1141:
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
                  for (;;)
                  {
                    return;
                    if (paramIntent.getAction().equalsIgnoreCase("tencent.av.v2q.StartVideoChat"))
                    {
                      if (paramIntent.getStringExtra("peerUin") != null) {}
                      for (l1 = Long.parseLong(paramIntent.getStringExtra("peerUin"));; l1 = 0L)
                      {
                        paramContext = Long.valueOf(l1);
                        if (paramContext.longValue() == 0L) {
                          break;
                        }
                        DeviceMsgHandle.a(this.a).add(paramContext);
                        return;
                      }
                    }
                    int i;
                    if (paramIntent.getAction().equalsIgnoreCase("SmartDevice_DeviceAdminUnbind"))
                    {
                      paramContext = Long.valueOf(paramIntent.getExtras().getLong("deviceopdin", 0L));
                      if (DeviceMsgHandle.a(this.a).contains(paramContext) != true)
                      {
                        this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramContext.toString(), 9501);
                        return;
                      }
                      if (paramContext.longValue() != 0L) {
                        DeviceMsgHandle.b(this.a).add(paramContext);
                      }
                    }
                    else if (paramIntent.getAction().equalsIgnoreCase("tencent.av.v2q.StopVideoChat"))
                    {
                      i = paramIntent.getIntExtra("stopReason", 0);
                      paramContext = paramIntent.getStringExtra("selfUin");
                      if (paramIntent.getStringExtra("peerUin") != null) {}
                      for (l1 = Long.parseLong(paramIntent.getStringExtra("peerUin"));; l1 = 0L)
                      {
                        paramIntent = Long.valueOf(l1);
                        if ((i != 0) || (paramContext != null) || (paramIntent.longValue() == 0L) || (!DeviceMsgHandle.b(this.a).contains(paramIntent))) {
                          break;
                        }
                        this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramIntent.toString(), 9501);
                        DeviceMsgHandle.b(this.a).remove(paramIntent);
                        return;
                      }
                      if (paramIntent.longValue() != 0L) {
                        DeviceMsgHandle.a(this.a).remove(paramIntent);
                      }
                    }
                    else if (paramIntent.getAction().equalsIgnoreCase("SmartDevice_receiveDPMsg"))
                    {
                      localObject1 = (DataPoint)paramIntent.getExtras().getParcelable("dataPoint");
                      if (localObject1 == null)
                      {
                        if (!QLog.isColorLevel()) {
                          continue;
                        }
                        QLog.d(DeviceMsgHandle.jdField_a_of_type_JavaLangString, 2, "dp is null in DeviceMsgHandler::onreceive");
                        return;
                      }
                      paramIntent = ((SmartDeviceProxyMgr)this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(51)).a(((DataPoint)localObject1).mDin);
                      i = 0;
                      if (paramIntent != null) {
                        i = paramIntent.productId;
                      }
                      if ((11015 == ((DataPoint)localObject1).mProperityId) || (((DataPoint)localObject1).mProperityId == 11008) || (((DataPoint)localObject1).mProperityId == 11012)) {
                        if (QLog.isColorLevel()) {
                          QLog.d(DeviceMsgHandle.jdField_a_of_type_JavaLangString, 2, "device info pid is 0; dp.mDin = " + ((DataPoint)localObject1).mDin);
                        }
                      }
                      for (;;)
                      {
                        if (10004 == ((DataPoint)localObject1).mProperityId)
                        {
                          this.a.jdField_a_of_type_ComTencentDeviceMsgDataDevSingleStructMsgProcessor.a((DataPoint)localObject1);
                          if (DeviceMsgHandle.a(this.a, ((DataPoint)localObject1).mValue)) {
                            break;
                          }
                          DeviceMsgHandle.a(this.a);
                          return;
                          if ((i == 0) && (((DataPoint)localObject1).mDin > 4294967295L))
                          {
                            if (!QLog.isColorLevel()) {
                              break;
                            }
                            QLog.d(DeviceMsgHandle.jdField_a_of_type_JavaLangString, 2, "device info pid is 0; dp.mDin = " + ((DataPoint)localObject1).mDin);
                            return;
                          }
                        }
                      }
                      if ((10012 == ((DataPoint)localObject1).mProperityId) || (11015 == ((DataPoint)localObject1).mProperityId))
                      {
                        this.a.jdField_a_of_type_ComTencentDeviceMsgDataDevSingleStructMsgProcessor.a((DataPoint)localObject1);
                        if (DeviceMsgHandle.a(this.a, ((DataPoint)localObject1).mValue)) {
                          continue;
                        }
                        DeviceMsgHandle.a(this.a);
                        return;
                      }
                      if (11016 == ((DataPoint)localObject1).mProperityId) {
                        for (;;)
                        {
                          try
                          {
                            paramContext = new JSONObject(((DataPoint)localObject1).mValue);
                            l1 = paramContext.optLong("din");
                            if (paramContext.optInt("flag") == 0)
                            {
                              paramContext = this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(Conversation.class);
                              if (paramContext != null)
                              {
                                paramIntent = paramContext.obtainMessage(1134060);
                                paramIntent.obj = Long.valueOf(l1);
                                paramContext.sendMessage(paramIntent);
                              }
                              QLog.d(DeviceMsgHandle.jdField_a_of_type_JavaLangString, 2, "PID_MSG_PROXY JSON :" + ((DataPoint)localObject1).mValue);
                              return;
                            }
                          }
                          catch (Exception paramContext)
                          {
                            paramContext.printStackTrace();
                            return;
                          }
                          paramContext = paramContext.optString("remark", " ");
                          paramIntent = this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(Conversation.class);
                          if (paramIntent != null)
                          {
                            localObject2 = paramIntent.obtainMessage(1134059);
                            ((Message)localObject2).obj = new Pair(Long.valueOf(l1), paramContext);
                            paramIntent.sendMessage((Message)localObject2);
                          }
                        }
                      }
                      if ((10003 == ((DataPoint)localObject1).mProperityId) || (10013 == ((DataPoint)localObject1).mProperityId))
                      {
                        this.a.jdField_a_of_type_ComTencentDeviceFileDeviceAVFileMsgObserver.a((DataPoint)localObject1);
                        SmartDeviceReport.a(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, ((DataPoint)localObject1).mDin, "Usr_AIO_ReceiveMsg", 2, 0, i);
                        if (DeviceMsgHandle.a(this.a, ((DataPoint)localObject1).mValue)) {
                          continue;
                        }
                        DeviceMsgHandle.a(this.a);
                        return;
                      }
                      if (10007 == ((DataPoint)localObject1).mProperityId)
                      {
                        for (;;)
                        {
                          try
                          {
                            paramContext = new JSONObject(((DataPoint)localObject1).mValue);
                            paramIntent = paramContext.optString("ext_cmd", " ");
                            paramContext = paramContext.optString("gray_flag", "");
                          }
                          catch (Exception paramIntent)
                          {
                            try
                            {
                              if (("OPT_DEV_AUTH_CONFIRM".equals(paramIntent)) || ("OPT_DEV_AUTH_REQ".equals(paramIntent))) {
                                break;
                              }
                              bool = "TEXT_OF_11012".equals(paramIntent);
                              if (bool) {
                                break;
                              }
                              if ((TextUtils.isEmpty(paramContext)) || (!paramContext.equals("1"))) {
                                break label1141;
                              }
                              try
                              {
                                paramContext = new JSONObject(((DataPoint)localObject1).mValue);
                                paramContext.optLong("msg_time", MessageCache.a());
                                paramContext = paramContext.optString("text", " ");
                                this.a.a(String.valueOf(((DataPoint)localObject1).mDin), paramContext, MessageCache.a(), true, false, true);
                                return;
                              }
                              catch (Exception paramContext) {}
                              if (!QLog.isColorLevel()) {
                                break;
                              }
                              QLog.d(DeviceMsgHandle.jdField_a_of_type_JavaLangString, 2, "onRecvRawTextMsg parse from json error:" + paramContext.getMessage());
                              return;
                            }
                            catch (Exception paramIntent)
                            {
                              for (;;)
                              {
                                boolean bool;
                                Object localObject4;
                                Object localObject3;
                                int j;
                                long l2;
                                String str1;
                                String str2;
                                Object localObject5;
                                String str3;
                                int k;
                                long l3;
                                continue;
                                paramContext = "";
                                continue;
                                paramContext = "";
                              }
                            }
                            paramIntent = paramIntent;
                            paramContext = "";
                          }
                          paramIntent.printStackTrace();
                        }
                        this.a.a((DataPoint)localObject1);
                        SmartDeviceReport.a(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, ((DataPoint)localObject1).mDin, "Usr_AIO_ReceiveMsg", 1, 0, i);
                        if (DeviceMsgHandle.a(this.a, ((DataPoint)localObject1).mValue)) {
                          continue;
                        }
                        DeviceMsgHandle.a(this.a);
                        return;
                      }
                      if ((10011 == ((DataPoint)localObject1).mProperityId) || (10010 == ((DataPoint)localObject1).mProperityId))
                      {
                        this.a.jdField_a_of_type_ComTencentDeviceMsgDataDeviceGroupChatMsgProcessor.a((DataPoint)localObject1);
                        if (DeviceMsgHandle.a(this.a, ((DataPoint)localObject1).mValue)) {
                          continue;
                        }
                        DeviceMsgHandle.a(this.a);
                        return;
                      }
                      if (10009 == ((DataPoint)localObject1).mProperityId)
                      {
                        try
                        {
                          localObject4 = new JSONObject(((DataPoint)localObject1).mValue);
                          l1 = ((JSONObject)localObject4).getLong("from_uin");
                          if ((!TextUtils.isEmpty(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) && (String.valueOf(l1).equals(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
                            continue;
                          }
                          paramContext = ((JSONObject)localObject4).optString("media_key", "");
                          paramIntent = ((JSONObject)localObject4).optString("cover_key", "");
                          localObject2 = ((JSONObject)localObject4).optString("fkey2", "");
                          localObject3 = ((JSONObject)localObject4).optString("ckey2", "");
                          i = ((JSONObject)localObject4).optInt("duration", 0);
                          j = ((JSONObject)localObject4).optInt("csz_file_size", 0);
                          l2 = ((JSONObject)localObject4).getLong("to_din");
                          localObject4 = (MessageForDevLittleVideo)MessageRecordFactory.a(-4509);
                          ((MessageForDevLittleVideo)localObject4).msgtype = -4509;
                          ((MessageForDevLittleVideo)localObject4).istroop = 9501;
                          ((MessageForDevLittleVideo)localObject4).issend = 0;
                          ((MessageForDevLittleVideo)localObject4).isread = false;
                          ((MessageForDevLittleVideo)localObject4).selfuin = this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
                          ((MessageForDevLittleVideo)localObject4).senderuin = Long.toString(l1);
                          ((MessageForDevLittleVideo)localObject4).frienduin = Long.toString(l2);
                          ((MessageForDevLittleVideo)localObject4).videoFileStatus = 2001;
                          ((MessageForDevLittleVideo)localObject4).time = MessageCache.a();
                          ((MessageForDevLittleVideo)localObject4).msg = (ContactUtils.b(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, ((MessageForDevLittleVideo)localObject4).senderuin, true) + ": [视频]");
                          ((MessageForDevLittleVideo)localObject4).extStr = "device_groupchat";
                          ((MessageForDevLittleVideo)localObject4).thumbFileKey = paramIntent;
                          ((MessageForDevLittleVideo)localObject4).videoFileKey = paramContext;
                          ((MessageForDevLittleVideo)localObject4).fileKey2 = ((String)localObject2);
                          ((MessageForDevLittleVideo)localObject4).coverkey2 = ((String)localObject3);
                          ((MessageForDevLittleVideo)localObject4).videoFileTime = i;
                          ((MessageForDevLittleVideo)localObject4).videoFileSize = j;
                          ((MessageForDevLittleVideo)localObject4).videoFileFormat = 2;
                          ((MessageForDevLittleVideo)localObject4).videoFileProgress = 0;
                          ((MessageForDevLittleVideo)localObject4).serial();
                          this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a((MessageRecord)localObject4, this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
                          if (DeviceMsgHandle.a(this.a, ((DataPoint)localObject1).mValue)) {
                            continue;
                          }
                          DeviceMsgHandle.a(this.a);
                          return;
                        }
                        catch (JSONException paramContext) {}
                        if (!QLog.isColorLevel()) {
                          continue;
                        }
                        QLog.d(DeviceMsgHandle.jdField_a_of_type_JavaLangString, 2, "getString from json error:" + paramContext.getMessage());
                        return;
                      }
                      if (((DataPoint)localObject1).mProperityId == 10008)
                      {
                        try
                        {
                          if ((!TextUtils.isEmpty(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) && (String.valueOf(((DataPoint)localObject1).mDin).equals(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
                            continue;
                          }
                          paramIntent = new JSONObject(((DataPoint)localObject1).mValue);
                          paramContext = paramIntent.optString("senderDin", " ");
                          l1 = paramIntent.optLong("msg_time", MessageCache.a());
                          paramIntent = paramIntent.optString("text", " ");
                          l2 = ((DataPoint)localObject1).mDin;
                          DeviceMsgHandle.a(this.a, l2, paramContext, paramIntent, l1, true);
                          if (DeviceMsgHandle.a(this.a, ((DataPoint)localObject1).mValue)) {
                            continue;
                          }
                          DeviceMsgHandle.a(this.a);
                          return;
                        }
                        catch (Exception paramContext) {}
                        if (!QLog.isColorLevel()) {
                          continue;
                        }
                        QLog.d(DeviceMsgHandle.jdField_a_of_type_JavaLangString, 2, "onRecvRawTextMsg parse from json error:" + paramContext.getMessage());
                        return;
                      }
                      if (((DataPoint)localObject1).mProperityId != 10014) {}
                    }
                    try
                    {
                      if (!DeviceTipActivity.a)
                      {
                        localObject2 = new JSONObject(((DataPoint)localObject1).mValue);
                        paramContext = String.valueOf(((DataPoint)localObject1).mDin);
                        paramIntent = ((JSONObject)localObject2).optString("digest", "");
                        l2 = ((JSONObject)localObject2).optLong("appear_time", MessageCache.a());
                        localObject2 = SettingCloneUtil.readValue(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), null, "account_login_success_time", "");
                        l1 = 0L;
                        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
                          l1 = Long.valueOf((String)localObject2).longValue();
                        }
                        if (QLog.isColorLevel())
                        {
                          QLog.d(DeviceMsgHandle.jdField_a_of_type_JavaLangString, 2, "ReceiveDoorTip appear_time= " + l2 + " : serverTime = " + MessageCache.a() + " loginTimeStr= " + (String)localObject2);
                          i = (int)(MessageCache.a() - l2);
                          QQToast.a(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), "该消息时间距当前时间已超过" + i + "秒", 1).a();
                        }
                        if (l1 - l2 > 1L)
                        {
                          if (QLog.isColorLevel()) {
                            QQToast.a(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), "该消息是手Q登录前" + (l1 - l2) + "秒下发的", 1).a();
                          }
                          this.a.a(paramContext, "你有一条未接响铃消息", l2, "");
                          return;
                        }
                        if (MessageCache.a() - l2 <= 30L)
                        {
                          localObject2 = new Intent(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), DeviceTipActivity.class);
                          ((Intent)localObject2).setFlags(268435456);
                          ((Intent)localObject2).putExtra("uin", paramContext);
                          ((Intent)localObject2).putExtra("digest", paramIntent);
                          this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp().startActivity((Intent)localObject2);
                        }
                      }
                      if (DeviceMsgHandle.a(this.a, ((DataPoint)localObject1).mValue)) {
                        continue;
                      }
                      DeviceMsgHandle.a(this.a);
                      return;
                    }
                    catch (Exception paramContext) {}
                    if (((DataPoint)localObject1).mProperityId == 1600006)
                    {
                      try
                      {
                        paramContext = new JSONObject(((DataPoint)localObject1).mValue);
                        paramIntent = paramContext.optString("digest", "");
                        l1 = paramContext.optLong("msg_time", MessageCache.a());
                        if ((paramIntent != null) && (!TextUtils.isEmpty(paramIntent.trim()))) {
                          this.a.a(Long.toString(((DataPoint)localObject1).mDin), paramIntent, l1, null);
                        }
                      }
                      catch (Exception paramContext)
                      {
                        for (;;)
                        {
                          if (QLog.isColorLevel()) {
                            QLog.d(DeviceMsgHandle.jdField_a_of_type_JavaLangString, 2, "onRecvRawTextMsg parse from json error:" + paramContext.getMessage());
                          }
                        }
                      }
                      if (DeviceMsgHandle.a(this.a, ((DataPoint)localObject1).mValue)) {
                        continue;
                      }
                      DeviceMsgHandle.a(this.a);
                      return;
                    }
                    if (((DataPoint)localObject1).mProperityId == 10004)
                    {
                      try
                      {
                        paramIntent = new JSONObject(((DataPoint)localObject1).mValue);
                        paramIntent.optLong("msgSeq", 0L);
                        localObject2 = paramIntent.optString("latitude");
                        localObject3 = paramIntent.optString("longitude");
                        localObject4 = paramIntent.optString("title");
                        str1 = paramIntent.optString("summary");
                        str2 = paramIntent.optString("dianpingId");
                        l1 = paramIntent.optLong("msg_time", MessageCache.a());
                        DeviceMsgHandle.a(this.a, paramContext, Long.toString(((DataPoint)localObject1).mDin), (String)localObject2, (String)localObject3, (String)localObject4, str1, str2, l1);
                        if (DeviceMsgHandle.a(this.a, ((DataPoint)localObject1).mValue)) {
                          continue;
                        }
                        DeviceMsgHandle.a(this.a);
                        return;
                      }
                      catch (Exception paramContext) {}
                      if (QLog.isColorLevel()) {
                        QLog.d(DeviceMsgHandle.jdField_a_of_type_JavaLangString, 2, "onRecvRawTextMsg parse from json error:" + paramContext.getMessage());
                      }
                    }
                    else if (((DataPoint)localObject1).mProperityId == 11010)
                    {
                      try
                      {
                        localObject5 = new JSONObject(((DataPoint)localObject1).mValue);
                        paramContext = ((JSONObject)localObject5).optString("prompt", "");
                        paramIntent = ((JSONObject)localObject5).getString("app");
                        localObject2 = ((JSONObject)localObject5).getString("view");
                        localObject3 = ((JSONObject)localObject5).optString("desc", "");
                        localObject4 = ((JSONObject)localObject5).optString("ver", "");
                        str1 = ((JSONObject)localObject5).optString("meta", "");
                        str2 = ((JSONObject)localObject5).optString("config", "");
                        str3 = ((JSONObject)localObject5).optString("compatibleText", "");
                        localObject5 = new SessionInfo();
                        ((SessionInfo)localObject5).jdField_a_of_type_JavaLangString = Long.toString(((DataPoint)localObject1).mDin);
                        ((SessionInfo)localObject5).b = "";
                        ((SessionInfo)localObject5).jdField_a_of_type_Int = 9501;
                        paramContext = new ArkAppMessage(paramContext, paramIntent, (String)localObject3, (String)localObject2, (String)localObject4, str1, str2, str3);
                        paramContext = MessageRecordFactory.a(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, ((SessionInfo)localObject5).jdField_a_of_type_JavaLangString, ((SessionInfo)localObject5).b, ((SessionInfo)localObject5).jdField_a_of_type_Int, paramContext);
                        paramContext.istroop = 9501;
                        paramContext.issend = 0;
                        paramContext.isread = false;
                        paramContext.selfuin = this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
                        paramContext.senderuin = Long.toString(((DataPoint)localObject1).mDin);
                        paramContext.frienduin = Long.toString(((DataPoint)localObject1).mDin);
                        this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramContext, this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
                        if (DeviceMsgHandle.a(this.a, ((DataPoint)localObject1).mValue)) {
                          continue;
                        }
                        DeviceMsgHandle.a(this.a);
                        return;
                      }
                      catch (Exception paramContext)
                      {
                        return;
                      }
                    }
                    else if ((((DataPoint)localObject1).mProperityId == 11008) || (((DataPoint)localObject1).mProperityId == 11012))
                    {
                      try
                      {
                        paramContext = new JSONObject(((DataPoint)localObject1).mValue);
                        SmartDeviceUtil.a(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramContext, String.valueOf(((DataPoint)localObject1).mDin));
                        if (DeviceMsgHandle.a(this.a, ((DataPoint)localObject1).mValue)) {
                          continue;
                        }
                        DeviceMsgHandle.a(this.a);
                        return;
                      }
                      catch (Exception paramContext)
                      {
                        paramContext.printStackTrace();
                      }
                      if (QLog.isColorLevel()) {
                        QLog.d(DeviceMsgHandle.jdField_a_of_type_JavaLangString, 2, "auth_request_structmsg:" + paramContext.getMessage());
                      }
                    }
                    else if (((DataPoint)localObject1).mProperityId == 700154)
                    {
                      try
                      {
                        paramIntent = new JSONObject(new JSONObject(((DataPoint)localObject1).mValue).optString("text"));
                        i = paramIntent.optInt("roomId");
                        paramContext = paramIntent.optString("sessionId");
                        j = paramIntent.optInt("cTime");
                        k = paramIntent.optInt("cmd");
                        if (QLog.isColorLevel()) {
                          QLog.d(DeviceMsgHandle.jdField_a_of_type_JavaLangString, 2, "openav roomId:" + i + ",sessionId:" + paramContext + ", cTime: " + j + ", cmd:" + k);
                        }
                        if (k != 1) {
                          continue;
                        }
                        paramIntent = new Intent(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), SmartDevicePluginDownloadActivity.class);
                        paramIntent.addFlags(268435456);
                        paramIntent.putExtra("KEY_OPENAV_ROOM_ID", i);
                        paramIntent.putExtra("device_id", String.valueOf(((DataPoint)localObject1).mDin));
                        paramIntent.putExtra("KEY_OPENAV_RECEIVE", true);
                        paramIntent.putExtra("KEY_OPENAV_SESSION_ID", paramContext);
                        paramIntent.putExtra("KEY_OPENAV_CTIME", j);
                        this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp().startActivity(paramIntent);
                        return;
                      }
                      catch (Exception paramContext)
                      {
                        paramContext.printStackTrace();
                        return;
                      }
                      if (paramIntent.getAction().equalsIgnoreCase("SmartDevice_sendCCDataPointMsgResult"))
                      {
                        paramContext = (MsgPack)paramIntent.getExtras().get("msgpack");
                        l1 = paramContext.uRecvUin;
                        bool = paramContext.bSendResult;
                        i = paramContext.dwMsgSequence;
                        if (bool)
                        {
                          DeviceMsgHandle.a(this.a, String.valueOf(l1), i);
                          return;
                        }
                        DeviceMsgHandle.b(this.a, String.valueOf(l1), i);
                        return;
                      }
                      if (paramIntent.getAction().equalsIgnoreCase("SmartDevice_OnMiniFileTransferProgress"))
                      {
                        paramContext = paramIntent.getExtras();
                        l1 = paramContext.getLong("cookie", 0L);
                        l2 = paramContext.getLong("progress", 0L);
                        l3 = paramContext.getLong("total", 0L);
                        i = 0;
                        if ((l1 != 0L) && (this.a.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(l1)))) {
                          paramContext = (MessageRecord)this.a.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(l1));
                        }
                        for (;;)
                        {
                          if ((!(paramContext instanceof MessageForDevLittleVideo)) || (i == 0)) {
                            break label3589;
                          }
                          paramContext = (MessageForDevLittleVideo)paramContext;
                          paramContext.videoFileStatus = 2002;
                          paramContext.videoFileProgress = ((int)((float)l2 * 1.0D / (float)l3) * 100);
                          paramContext.serial();
                          this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramContext.frienduin, paramContext.istroop, paramContext.uniseq, paramContext.msgData);
                          this.a.a().b(paramContext, (float)((float)l2 * 1.0D / (float)l3));
                          return;
                          if ((l1 == 0L) || (!this.a.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(l1)))) {
                            break;
                          }
                          paramContext = (MessageRecord)this.a.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(l1));
                          i = 1;
                        }
                      }
                      else
                      {
                        if (paramIntent.getAction().equalsIgnoreCase("SmartDevice_OnMiniFileTransferComplete"))
                        {
                          paramIntent = paramIntent.getExtras();
                          j = paramIntent.getInt("err_code", -1);
                          l1 = paramIntent.getLong("cookie", 0L);
                          i = 0;
                          if ((l1 != 0L) && (this.a.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(l1))))
                          {
                            paramContext = (MessageRecord)this.a.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(l1));
                            if (j != 0) {
                              break label4130;
                            }
                            localObject1 = paramIntent.getString("filepath");
                            paramIntent = new File((String)localObject1);
                            paramIntent = AppConstants.aJ + "/smart_device/" + paramIntent.getName();
                            FileUtils.b((String)localObject1, paramIntent);
                            if (!(paramContext instanceof MessageForDeviceFile)) {
                              break label3956;
                            }
                            paramContext = (MessageForDeviceFile)paramContext;
                            paramContext.filePath = paramIntent;
                            paramContext.srcFileName = FileManagerUtil.a(paramIntent);
                            paramContext.fileSize = FileManagerUtil.a(paramIntent);
                            paramContext.msg = (ContactUtils.b(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramContext.senderuin, true) + ": " + this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131437830));
                            paramContext.serial();
                            this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramContext.frienduin, paramContext.istroop, paramContext.uniseq, paramContext.msgData);
                            this.a.a().a(paramContext, Boolean.valueOf(true));
                          }
                          for (;;)
                          {
                            this.a.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(l1));
                            this.a.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(l1));
                            return;
                            if ((l1 == 0L) || (!this.a.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(l1)))) {
                              break;
                            }
                            paramContext = (MessageRecord)this.a.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(l1));
                            i = 1;
                            break label3675;
                            if ((paramContext instanceof MessageForDevLittleVideo))
                            {
                              paramContext = (MessageForDevLittleVideo)paramContext;
                              if (i != 0)
                              {
                                paramContext.videoFileName = paramIntent;
                                paramContext.videoFileStatus = 2003;
                                paramContext.serial();
                                this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramContext.frienduin, paramContext.istroop, paramContext.uniseq, paramContext.msgData);
                                this.a.a().b(paramContext, Boolean.valueOf(true));
                              }
                              else
                              {
                                paramContext.mThumbFilePath = paramIntent;
                                try
                                {
                                  localObject1 = new BitmapFactory.Options();
                                  ((BitmapFactory.Options)localObject1).inJustDecodeBounds = true;
                                  BitmapFactory.decodeFile(paramIntent, (BitmapFactory.Options)localObject1);
                                  ((BitmapFactory.Options)localObject1).inJustDecodeBounds = false;
                                  paramContext.thumbWidth = ((BitmapFactory.Options)localObject1).outWidth;
                                  paramContext.thumbHeight = ((BitmapFactory.Options)localObject1).outHeight;
                                  paramContext.serial();
                                  this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramContext.frienduin, paramContext.istroop, paramContext.uniseq, paramContext.msgData);
                                }
                                catch (OutOfMemoryError paramIntent)
                                {
                                  for (;;)
                                  {
                                    paramIntent.printStackTrace();
                                  }
                                }
                                if ((paramContext instanceof MessageForDeviceFile))
                                {
                                  paramContext = (MessageForDeviceFile)paramContext;
                                  this.a.a().a(paramContext, Boolean.valueOf(false));
                                }
                                else if (((paramContext instanceof MessageForDevLittleVideo)) && (i != 0))
                                {
                                  paramContext = (MessageForDevLittleVideo)paramContext;
                                  paramContext.videoFileProgress = 0;
                                  paramContext.videoFileStatus = 2005;
                                  paramContext.serial();
                                  this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramContext.frienduin, paramContext.istroop, paramContext.uniseq, paramContext.msgData);
                                  this.a.a().b(paramContext, Boolean.valueOf(false));
                                }
                              }
                            }
                          }
                        }
                        if (paramIntent.getAction().equalsIgnoreCase("SmartDevice_DeviceVasFlagChange"))
                        {
                          paramIntent = paramIntent.getExtras();
                          if (paramIntent != null)
                          {
                            i = paramIntent.getInt("Flag", 0);
                            l1 = paramIntent.getLong("Din", 0L);
                            localObject1 = (SmartDeviceProxyMgr)this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
                            localObject2 = ((SmartDeviceProxyMgr)localObject1).a(l1);
                            paramIntent = "";
                            if (localObject2 != null) {
                              paramIntent = ((DeviceInfo)localObject2).serialNum;
                            }
                            paramIntent = PreferenceManager.getDefaultSharedPreferences(paramContext).getString(paramIntent, "");
                            if (!StringUtil.a(paramIntent))
                            {
                              paramContext = paramIntent;
                              if (!paramIntent.equals("0")) {}
                            }
                            else
                            {
                              paramIntent = this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131435619).split(":")[0];
                              paramContext = paramIntent;
                              if (((DeviceInfo)localObject2).isAdmin != 1)
                              {
                                ((SmartDeviceProxyMgr)localObject1).a(((DeviceInfo)localObject2).productId, ((DeviceInfo)localObject2).serialNum);
                                paramContext = paramIntent;
                              }
                            }
                            if ((i == 1) && (((DeviceInfo)localObject2).isAdmin != 1))
                            {
                              com.tencent.mobileqq.activity.aio.rebuild.DeviceMsgChatPie.S = true;
                              paramContext = paramContext + this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131437846);
                              this.a.a(l1 + "", paramContext, MessageCache.a(), true, false, 1);
                              return;
                            }
                            if ((i == 0) && (((DeviceInfo)localObject2).isAdmin != 1))
                            {
                              com.tencent.mobileqq.activity.aio.rebuild.DeviceMsgChatPie.S = false;
                              paramContext = paramContext + this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131437847);
                              this.a.a(l1 + "", paramContext, MessageCache.a(), true, false, true);
                            }
                          }
                        }
                        else if (paramIntent.getAction().equalsIgnoreCase("SmartDevice_QueryIsDeviceBinded"))
                        {
                          paramIntent = paramIntent.getExtras();
                          if (paramIntent != null)
                          {
                            l1 = paramIntent.getLong("AdminBinderUin", 0L);
                            paramIntent = paramIntent.getString("DeviceSerialNum");
                            localObject1 = ContactUtils.b(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, l1 + "", true);
                            PreferenceManager.getDefaultSharedPreferences(paramContext).edit().putString(paramIntent, (String)localObject1).commit();
                          }
                        }
                        else
                        {
                          if (!paramIntent.getAction().equalsIgnoreCase("DeviceSomebodyJoin")) {
                            break;
                          }
                          paramContext = paramIntent.getExtras();
                          localObject2 = Long.valueOf(paramContext.getLong("deviceopdin", 0L));
                          localObject3 = Long.valueOf(paramContext.getLong("deviceopuin", 0L));
                          paramContext = (SmartDeviceProxyMgr)this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
                          paramIntent = paramContext.a(((Long)localObject2).longValue());
                          if (paramIntent != null)
                          {
                            localObject1 = paramContext.a(paramIntent.productId);
                            if (localObject1 != null)
                            {
                              if (paramContext.a(((Long)localObject2).longValue()).booleanValue()) {}
                              for (paramContext = "已加入群聊"; !TextUtils.isEmpty(paramContext); paramContext = " 已接受设备授权，开始使用" + ((ProductInfo)localObject1).deviceName)
                              {
                                localObject1 = ContactUtils.b(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, Long.toString(((Long)localObject3).longValue()), true);
                                paramIntent = (Intent)localObject1;
                                if (TextUtils.isEmpty((CharSequence)localObject1)) {
                                  paramIntent = String.valueOf(localObject3);
                                }
                                paramContext = paramIntent + paramContext;
                                this.a.a(localObject2 + "", paramContext, MessageCache.a(), true, false, true);
                                return;
                                if (paramIntent.isAdmin != 1) {
                                  break label6213;
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                  if ((!paramIntent.getAction().equalsIgnoreCase("DeviceSomebodyQuit")) && (!paramIntent.getAction().equalsIgnoreCase("DeviceSomebodyReject"))) {
                    break label5139;
                  }
                  paramContext = paramIntent.getExtras();
                  localObject2 = Long.valueOf(paramContext.getLong("deviceopdin", 0L));
                  localObject3 = Long.valueOf(paramContext.getLong("deviceopuin", 0L));
                  paramContext = (SmartDeviceProxyMgr)this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
                  paramIntent = paramContext.a(((Long)localObject2).longValue());
                } while ((paramIntent == null) || (paramContext.a(paramIntent.productId) == null));
                if (!paramContext.a(((Long)localObject2).longValue()).booleanValue()) {
                  break label6206;
                }
                paramContext = "已退出群聊";
              } while (TextUtils.isEmpty(paramContext));
              localObject1 = ContactUtils.b(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, Long.toString(((Long)localObject3).longValue()), true);
              paramIntent = (Intent)localObject1;
              if (TextUtils.isEmpty((CharSequence)localObject1)) {
                paramIntent = String.valueOf(localObject3);
              }
              paramContext = paramIntent + paramContext;
              this.a.a(localObject2 + "", paramContext, MessageCache.a(), true, false, true);
              return;
              if (!"SmartDevice_DeviceBindRst".equals(paramIntent.getAction())) {
                break;
              }
            } while (paramIntent.getExtras().getInt("deviceoprstcode") != 0);
            localObject1 = (SmartDeviceProxyMgr)this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
            l1 = paramIntent.getExtras().getLong("deviceopdin", 0L);
          } while ((localObject1 != null) && (((SmartDeviceProxyMgr)localObject1).a(l1, 13)));
          if (EquipmentLockImpl.a().a(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramContext) != 0) {
            this.a.a(l1 + "", "【重要！设备安全提醒】\n\n为防止QQ号被盗/丢失手机，导致设备被人恶意控制\n请点这里开启QQ设备锁\n\n\n查看QQ设备锁介绍", MessageCache.a(), "device_lock_msg");
          }
          localObject2 = ((SmartDeviceProxyMgr)localObject1).a(l1);
          paramIntent = "";
          if (localObject2 != null) {
            paramIntent = ((DeviceInfo)localObject2).serialNum;
          }
          paramIntent = PreferenceManager.getDefaultSharedPreferences(paramContext).getString(paramIntent, "");
          if (!StringUtil.a(paramIntent))
          {
            paramContext = paramIntent;
            if (!paramIntent.equals("0")) {}
          }
          else
          {
            paramIntent = this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131435619).split(":")[0];
            paramContext = paramIntent;
            if (localObject2 != null)
            {
              paramContext = paramIntent;
              if (((DeviceInfo)localObject2).isAdmin != 1)
              {
                ((SmartDeviceProxyMgr)localObject1).a(((DeviceInfo)localObject2).productId, ((DeviceInfo)localObject2).serialNum);
                paramContext = paramIntent;
              }
            }
          }
        } while ((localObject2 == null) || (((DeviceInfo)localObject2).isAdmin == 1) || (!((SmartDeviceProxyMgr)localObject1).a(l1).booleanValue()));
        paramContext = paramContext + this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131437846);
        this.a.a(l1 + "", paramContext, MessageCache.a(), true, false, 1);
        return;
        if (!"On_OccupyMicrophoneNotify_Push".equals(paramIntent.getAction())) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d(DeviceMsgHandle.jdField_a_of_type_JavaLangString, 2, "DeviceMsghandle intent.getExtras() : " + paramIntent.getExtras());
        }
        paramContext = paramIntent.getExtras();
        paramIntent = Long.valueOf(paramContext.getLong("din", 0L));
        paramContext = paramContext.getString("uin");
      } while ((paramIntent.longValue() == 0L) || (TextUtils.isEmpty(paramContext)));
      localObject1 = ContactUtils.b(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramContext, true);
      if ((TextUtils.isEmpty((CharSequence)localObject1)) || (paramContext.equals(localObject1))) {}
      for (paramContext = "其他人已经处理了响铃通知";; paramContext = (String)localObject1 + "已经处理了响铃通知")
      {
        this.a.a(String.valueOf(paramIntent), paramContext, MessageCache.a(), "");
        DeviceMsgHandle.a(this.a);
        return;
      }
      if ("SmartDevice_sendToAIO_Capture".equals(paramIntent.getAction()))
      {
        paramIntent = paramIntent.getExtras();
        paramContext = paramIntent.getString("uin");
        localObject1 = paramIntent.getString("path");
        try
        {
          localObject2 = new JSONObject();
          ((JSONObject)localObject2).put("msg_time", MessageCache.a());
          ((JSONObject)localObject2).put("guidewords", "查看详情");
          ((JSONObject)localObject2).put("appear_time", MessageCache.a());
          ((JSONObject)localObject2).put("digest", "拍摄了一张新照片，快去看看吧");
          ((JSONObject)localObject2).put("title", "有拍摄的新照片，快去看看吧");
          paramIntent = (MessageForDeviceSingleStruct)MessageRecordFactory.a(-4502);
          paramIntent.msgtype = -4502;
          paramIntent.istroop = 9501;
          paramIntent.issend = 0;
          paramIntent.isread = false;
          paramIntent.selfuin = this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
          paramIntent.senderuin = paramContext;
          paramIntent.frienduin = paramContext;
          paramIntent.strCoverPath = ((String)localObject1);
          paramIntent.strMediaPath = ((String)localObject1);
          paramIntent.strMediaFileName = FileManagerUtil.a((String)localObject1);
          paramIntent.parseFromJson(((JSONObject)localObject2).toString());
          paramIntent.msg = paramIntent.strDigest;
          paramIntent.nMediaFileStatus = 5;
          paramIntent.nDataType = 1;
          paramContext = new ArrayList();
          paramContext.add(paramIntent);
          DeviceMsgHandle.a(this.a, paramContext);
          return;
        }
        catch (Exception paramContext)
        {
          return;
        }
      }
    } while (!"SmartDevice_sendToAIO_Mp4".equals(paramIntent.getAction()));
    label3589:
    label3675:
    label3956:
    localObject3 = paramIntent.getExtras();
    label4130:
    paramContext = ((Bundle)localObject3).getString("uin");
    label5139:
    paramIntent = ((Bundle)localObject3).getString("path");
    Object localObject1 = ((Bundle)localObject3).getString("imagepath");
    Object localObject2 = ((Bundle)localObject3).getString("digest");
    localObject4 = ((Bundle)localObject3).getString("title");
    try
    {
      localObject3 = new JSONObject();
      ((JSONObject)localObject3).put("msg_time", MessageCache.a());
      ((JSONObject)localObject3).put("guidewords", "查看详情");
      ((JSONObject)localObject3).put("appear_time", MessageCache.a());
      ((JSONObject)localObject3).put("digest", localObject2);
      ((JSONObject)localObject3).put("title", localObject4);
      ((JSONObject)localObject3).put("data_type", "VIDEO");
      ((JSONObject)localObject3).put("cover_url", localObject1);
      localObject2 = (MessageForDeviceSingleStruct)MessageRecordFactory.a(-4502);
      ((MessageForDeviceSingleStruct)localObject2).msgtype = -4502;
      ((MessageForDeviceSingleStruct)localObject2).istroop = 9501;
      ((MessageForDeviceSingleStruct)localObject2).issend = 0;
      ((MessageForDeviceSingleStruct)localObject2).isread = false;
      ((MessageForDeviceSingleStruct)localObject2).selfuin = this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      ((MessageForDeviceSingleStruct)localObject2).senderuin = paramContext;
      ((MessageForDeviceSingleStruct)localObject2).frienduin = paramContext;
      ((MessageForDeviceSingleStruct)localObject2).strCoverPath = ((String)localObject1);
      ((MessageForDeviceSingleStruct)localObject2).strMediaPath = paramIntent;
      ((MessageForDeviceSingleStruct)localObject2).nDataType = 2;
      ((MessageForDeviceSingleStruct)localObject2).strMediaFileName = FileManagerUtil.a(paramIntent);
      ((MessageForDeviceSingleStruct)localObject2).nMediaFileSize = FileUtils.a(paramIntent);
      ((MessageForDeviceSingleStruct)localObject2).nMediaFileStatus = 5;
      ((MessageForDeviceSingleStruct)localObject2).parseFromJson(((JSONObject)localObject3).toString());
      ((MessageForDeviceSingleStruct)localObject2).msg = ((MessageForDeviceSingleStruct)localObject2).strDigest;
      paramContext = new ArrayList();
      paramContext.add(localObject2);
      DeviceMsgHandle.a(this.a, paramContext);
      return;
    }
    catch (Exception paramContext) {}
    label6206:
    label6213:
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     qbh
 * JD-Core Version:    0.7.0.1
 */