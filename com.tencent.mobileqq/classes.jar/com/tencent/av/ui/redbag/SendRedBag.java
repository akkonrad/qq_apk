package com.tencent.av.ui.redbag;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.redpacket.AVRedPacketDataCollector;
import com.tencent.mobileqq.activity.qwallet.SendHbActivity;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import kfp;
import org.json.JSONException;
import org.json.JSONObject;

public class SendRedBag
  extends BaseRedBag
{
  public kfp a;
  public int b = 2;
  public int c = 1;
  public String g;
  
  SendRedBag(AVRedBagMgr paramAVRedBagMgr)
  {
    super(paramAVRedBagMgr);
  }
  
  public void a()
  {
    QLog.w(this.i, 1, "SendRedBag, cancel");
    Intent localIntent = new Intent("com.qwallet.report");
    Bundle localBundle = new Bundle();
    localBundle.putString("from", "video");
    localIntent.putExtra("type", 999);
    localIntent.putExtra("params", localBundle);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getBaseContext().sendBroadcast(localIntent);
    this.b = 4;
    a("cancel");
  }
  
  void a(String paramString)
  {
    RedBagReport.a(this.c);
    RedBagReport.b(this.b);
    if (this.b == 0) {}
    for (boolean bool = true;; bool = false)
    {
      AVRedPacketDataCollector.a(bool, paramString, String.valueOf(this.b));
      if (this.jdField_a_of_type_Kfp != null)
      {
        this.jdField_a_of_type_Kfp.a(this);
        this.jdField_a_of_type_Kfp = null;
      }
      return;
    }
  }
  
  public boolean a(int paramInt, Intent paramIntent)
  {
    boolean bool2 = false;
    this.b = 3;
    String str = this.i;
    Object localObject = new StringBuilder().append("SendRedBag_onResult, resultCode[").append(paramInt).append("], intent[");
    boolean bool1;
    if (paramIntent != null)
    {
      bool1 = true;
      QLog.w(str, 1, bool1 + "]");
      if (paramIntent == null) {
        break label257;
      }
      AudioHelper.a("发红包", paramIntent.getExtras());
      str = String.valueOf(paramIntent.getExtras().get("result"));
      localObject = paramIntent.getStringExtra("retmsg");
      paramIntent = paramIntent.getStringExtra("data");
    }
    for (;;)
    {
      try
      {
        if (!TextUtils.isEmpty(paramIntent)) {
          this.g = new JSONObject(paramIntent).getString("send_listid");
        }
        if ("-11001".equals(str)) {
          this.b = 4;
        }
        QLog.w(this.i, 1, "SendRedBag_onResult, result[" + str + "], data[" + paramIntent + "], retmsg[" + (String)localObject + "], send_listid[" + this.g + "], mErrorType[" + this.b + "]");
        bool1 = "0".equals(str);
        if (bool1) {
          this.b = 0;
        }
        paramIntent = str;
        a(paramIntent);
        return bool1;
        bool1 = false;
      }
      catch (Exception localException)
      {
        continue;
      }
      label257:
      paramIntent = "null";
      bool1 = bool2;
    }
  }
  
  public boolean a(VideoAppInterface paramVideoAppInterface, int paramInt, Activity paramActivity, kfp paramkfp)
  {
    this.b = 2;
    long l1 = RedBagUtil.a(paramVideoAppInterface);
    if (l1 == 0L) {
      return false;
    }
    long l2 = a(paramVideoAppInterface);
    if (l2 == 0L) {
      return false;
    }
    if (paramActivity == null)
    {
      QLog.w(this.i, 1, "SendRedBag, Activity为空");
      return false;
    }
    String str = a(paramVideoAppInterface);
    paramVideoAppInterface = b(paramVideoAppInterface);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("recv_uin", l2);
      localJSONObject.put("recv_name", paramVideoAppInterface);
      localJSONObject.put("bus_type", 2);
      localJSONObject.put("channel", "16384");
      localJSONObject.put("total_num", "2");
      Intent localIntent = new Intent(BaseApplication.getContext(), SendHbActivity.class);
      localIntent.putExtra("userId", l1);
      localIntent.putExtra("userName", str);
      if (paramInt == 2)
      {
        localIntent.putExtra("app_info", "appid#0|bargainor_id#0|channel#bqredpacket2");
        localIntent.putExtra("come_from", 2);
        localIntent.putExtra("extra_data", localJSONObject.toString());
        localIntent.setFlags(536870912);
        paramActivity.startActivityForResult(localIntent, 801);
        if (QLog.isDevelopLevel()) {
          QLog.w(this.i, 4, "SendRedBag, userId[" + l1 + "], userName[" + str + "], recv_name[" + paramVideoAppInterface + "], recv_uin[" + l2 + "], fromType[" + paramInt + "]");
        }
        this.jdField_a_of_type_Kfp = paramkfp;
        this.b = 1;
        this.c = paramInt;
        RedBagReport.i();
        return true;
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
        continue;
        localJSONException.putExtra("app_info", "appid#0|bargainor_id#0|channel#bqredpacket1");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.ui.redbag.SendRedBag
 * JD-Core Version:    0.7.0.1
 */