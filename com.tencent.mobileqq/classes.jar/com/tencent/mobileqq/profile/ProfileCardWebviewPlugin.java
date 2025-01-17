package com.tencent.mobileqq.profile;

import agpj;
import agpk;
import agpm;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emosm.Client.onRemoteRespObserver;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebUiMethodInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import com.tencent.widget.ActionSheet;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

public class ProfileCardWebviewPlugin
  extends VasWebviewJsPlugin
{
  public int a;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new agpj(this);
  private DownloaderFactory jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory;
  ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet = null;
  public List a;
  public AtomicInteger a;
  private boolean jdField_a_of_type_Boolean;
  private final int b;
  public AtomicInteger b;
  private final int c = 1;
  private final int d = 2;
  
  public ProfileCardWebviewPlugin()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(-1);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
    this.jdField_b_of_type_Int = 0;
    this.mPluginNameSpace = "card";
  }
  
  private void a(int paramInt)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.tencent.mobileqq.action.closeWeb");
      this.mRuntime.a().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter, "com.tencent.msg.permission.pushnotify", null);
    }
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      d();
      c();
      ReportController.b(null, "CliOper", "", "", "card_mall", "0X80066CA", 0, 0, "1", "", "", "");
      return;
    case 1: 
      e();
      c();
      ReportController.b(null, "CliOper", "", "", "card_mall", "0X80066CA", 0, 0, "2", "", "", "");
      return;
    }
    c();
    ReportController.b(null, "CliOper", "", "", "card_mall", "0X80066CA", 0, 0, "3", "", "", "");
  }
  
  private void b()
  {
    c();
    this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.c(this.mRuntime.a());
    this.jdField_a_of_type_ComTencentWidgetActionSheet.c(this.mRuntime.a().getResources().getString(2131436160));
    this.jdField_a_of_type_ComTencentWidgetActionSheet.c(this.mRuntime.a().getResources().getString(2131436158));
    this.jdField_a_of_type_ComTencentWidgetActionSheet.c(this.mRuntime.a().getResources().getString(2131433015));
    this.jdField_a_of_type_ComTencentWidgetActionSheet.a(new agpm(this));
    this.jdField_a_of_type_ComTencentWidgetActionSheet.setCanceledOnTouchOutside(true);
    try
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
      ReportController.b(null, "CliOper", "", "", "card_mall", "0X80066C9", 0, 0, "", "", "", "");
      return;
    }
    catch (Exception localException) {}
  }
  
  /* Error */
  private void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 50	com/tencent/mobileqq/profile/ProfileCardWebviewPlugin:jdField_a_of_type_ComTencentWidgetActionSheet	Lcom/tencent/widget/ActionSheet;
    //   4: ifnull +25 -> 29
    //   7: aload_0
    //   8: getfield 50	com/tencent/mobileqq/profile/ProfileCardWebviewPlugin:jdField_a_of_type_ComTencentWidgetActionSheet	Lcom/tencent/widget/ActionSheet;
    //   11: invokevirtual 165	com/tencent/widget/ActionSheet:isShowing	()Z
    //   14: ifeq +15 -> 29
    //   17: aload_0
    //   18: getfield 50	com/tencent/mobileqq/profile/ProfileCardWebviewPlugin:jdField_a_of_type_ComTencentWidgetActionSheet	Lcom/tencent/widget/ActionSheet;
    //   21: invokevirtual 168	com/tencent/widget/ActionSheet:dismiss	()V
    //   24: aload_0
    //   25: aconst_null
    //   26: putfield 50	com/tencent/mobileqq/profile/ProfileCardWebviewPlugin:jdField_a_of_type_ComTencentWidgetActionSheet	Lcom/tencent/widget/ActionSheet;
    //   29: return
    //   30: astore_1
    //   31: aload_0
    //   32: aconst_null
    //   33: putfield 50	com/tencent/mobileqq/profile/ProfileCardWebviewPlugin:jdField_a_of_type_ComTencentWidgetActionSheet	Lcom/tencent/widget/ActionSheet;
    //   36: return
    //   37: astore_1
    //   38: aload_0
    //   39: aconst_null
    //   40: putfield 50	com/tencent/mobileqq/profile/ProfileCardWebviewPlugin:jdField_a_of_type_ComTencentWidgetActionSheet	Lcom/tencent/widget/ActionSheet;
    //   43: aload_1
    //   44: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	45	0	this	ProfileCardWebviewPlugin
    //   30	1	1	localException	Exception
    //   37	7	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   17	24	30	java/lang/Exception
    //   17	24	37	finally
  }
  
  private void d()
  {
    sendRemoteReq(DataFactory.a("selectPhoto", "", this.mOnRemoteResp.key, new Bundle()), false, false);
  }
  
  private void e()
  {
    sendRemoteReq(DataFactory.a("takePhoto", "", this.mOnRemoteResp.key, new Bundle()), false, false);
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return -1;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() < 0)
    {
      if (this.jdField_a_of_type_JavaUtilList.size() > 0)
      {
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
        return 0;
      }
      return -1;
    }
    if ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() >= this.jdField_a_of_type_JavaUtilList.size()) || (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() < 0))
    {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(-1);
      return -2;
    }
    int i = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() + 1;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(i);
      if (((VipProfileCardDownLoadInfo)this.jdField_a_of_type_JavaUtilList.get(i)).g == VipProfileCardDownLoadInfo.jdField_a_of_type_JavaLangInteger) {
        return 0;
      }
      i += 1;
    }
    return -1;
  }
  
  public void a()
  {
    if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 1) {}
    String str3;
    String str2;
    String str4;
    boolean bool;
    for (;;)
    {
      return;
      try
      {
        if (a() == 0)
        {
          Object localObject = (VipProfileCardDownLoadInfo)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
          String str1 = ((VipProfileCardDownLoadInfo)localObject).jdField_a_of_type_JavaLangString;
          str3 = ((VipProfileCardDownLoadInfo)localObject).jdField_b_of_type_JavaLangString;
          str2 = ((VipProfileCardDownLoadInfo)localObject).jdField_c_of_type_JavaLangString;
          str4 = ((VipProfileCardDownLoadInfo)localObject).jdField_d_of_type_JavaLangString;
          bool = ((VipProfileCardDownLoadInfo)localObject).jdField_a_of_type_Boolean;
          if (((VipProfileCardDownLoadInfo)localObject).jdField_b_of_type_Boolean)
          {
            ((VipProfileCardDownLoadInfo)localObject).jdField_b_of_type_Boolean = false;
            this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(1);
            localObject = DataFactory.a("card_download_wzry_template", str4, this.mOnRemoteResp.key, new Bundle());
            ((Bundle)localObject).putString("image_url", str1);
            ((Bundle)localObject).putString("wzHeroUrl", str2);
            sendRemoteReq((Bundle)localObject, false, false);
            return;
          }
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
    }
    a(localException, str3, str2, str4, bool);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ProfileCardWebviewPlugin", 2, "method:" + paramString1 + ", json:" + paramString2);
    }
    callJs(paramString1, new String[] { paramString2 });
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    ThreadManager.post(new agpk(this, paramString2, paramBoolean, paramString4, paramString3, paramString1), 8, null, false);
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((paramString2 == null) || (!paramString2.equalsIgnoreCase("card"))) {
      return false;
    }
    Object localObject2;
    Object localObject1;
    long l1;
    String str;
    try
    {
      paramString1 = new JSONObject(paramVarArgs[0]);
      if (paramString1 == null) {
        return false;
      }
    }
    catch (JSONException paramJsBridgeListener)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("ProfileCardWebviewPlugin", 2, "Failed to parse json str,json=" + paramVarArgs[0]);
        }
        paramString1 = null;
      }
      if (QLog.isColorLevel()) {
        QLog.i("ProfileCardWebviewPlugin", 2, "method:" + paramString3 + ", json:" + paramString1.toString());
      }
      paramJsBridgeListener = "callback";
      localObject2 = new JSONObject();
      paramVarArgs = new JSONObject();
      localObject1 = this.mRuntime.a().getApplicationContext();
      try
      {
        paramString2 = paramString1.optString("callback");
        paramJsBridgeListener = paramString2;
        if (paramString3.equals("getInfo"))
        {
          paramJsBridgeListener = paramString2;
          sendRemoteReq(DataFactory.a("card_getinfo", paramString2, this.mOnRemoteResp.key, new Bundle()), false, false);
        }
        else
        {
          paramJsBridgeListener = paramString2;
          if (paramString3.equals("setSummaryCard"))
          {
            paramJsBridgeListener = paramString2;
            paramString3 = DataFactory.a("card_setSummaryCard", paramString2, this.mOnRemoteResp.key, new Bundle());
            paramJsBridgeListener = paramString2;
            paramString3.putInt("styleId", paramString1.getInt("styleId"));
            paramJsBridgeListener = paramString2;
            paramString3.putInt("bgId", paramString1.getInt("bgId"));
            paramJsBridgeListener = paramString2;
            paramString3.putString("extInfo", paramString1.optString("extInfo"));
            paramJsBridgeListener = paramString2;
            sendRemoteReq(paramString3, false, false);
          }
        }
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        try
        {
          paramVarArgs.put("result", -1);
          paramVarArgs.put("message", "ProfileCardWebviewPlugin Exception");
          a(paramJsBridgeListener, paramVarArgs.toString());
        }
        catch (JSONException paramJsBridgeListener)
        {
          paramJsBridgeListener.printStackTrace();
        }
        paramJsBridgeListener = paramString2;
        if (paramString3.equals("download"))
        {
          paramJsBridgeListener = paramString2;
          paramString3 = paramString1.getString("image_url");
          paramJsBridgeListener = paramString2;
          localObject2 = paramString1.optString("dynamicZip");
          paramJsBridgeListener = paramString2;
          if (ProfileCardUtil.a((Context)localObject1, paramString3))
          {
            paramJsBridgeListener = paramString2;
            if (QLog.isColorLevel())
            {
              paramJsBridgeListener = paramString2;
              QLog.d("ProfileCardWebviewPlugin", 2, "handleJsRequest bg exists, dynamicZip = " + (String)localObject2);
            }
            paramJsBridgeListener = paramString2;
            if (TextUtils.isEmpty((CharSequence)localObject2))
            {
              paramJsBridgeListener = paramString2;
              paramVarArgs.put("result", 0);
              paramJsBridgeListener = paramString2;
              paramVarArgs.put("message", "local has");
              paramJsBridgeListener = paramString2;
              a(paramString2, paramVarArgs.toString());
              return true;
            }
            paramJsBridgeListener = paramString2;
            if (ProfileCardUtil.b((Context)localObject1, (String)localObject2))
            {
              paramJsBridgeListener = paramString2;
              paramVarArgs.put("result", 0);
              paramJsBridgeListener = paramString2;
              paramVarArgs.put("message", "local has");
              paramJsBridgeListener = paramString2;
              a(paramString2, paramVarArgs.toString());
              return true;
            }
          }
          paramJsBridgeListener = paramString2;
          if (!NetworkUtil.d(this.mRuntime.a().getApplicationContext()))
          {
            paramJsBridgeListener = paramString2;
            paramVarArgs.put("result", -2);
            paramJsBridgeListener = paramString2;
            paramVarArgs.put("message", "no network");
            paramJsBridgeListener = paramString2;
            a(paramString2, paramVarArgs.toString());
            return true;
          }
          paramJsBridgeListener = paramString2;
          l1 = ProfileCardUtil.b();
          if (l1 < 102400)
          {
            paramJsBridgeListener = paramString2;
            if (QLog.isColorLevel())
            {
              paramJsBridgeListener = paramString2;
              QLog.d("ProfileCardWebviewPlugin", 2, "Insufficient SDCard space, reserved:" + 102400 + "|available:" + l1);
            }
            paramJsBridgeListener = paramString2;
            paramVarArgs.put("result", -3);
            paramJsBridgeListener = paramString2;
            paramVarArgs.put("message", "Insufficient SDCard space.");
            paramJsBridgeListener = paramString2;
            a(paramString2, paramVarArgs.toString());
            return true;
          }
          paramJsBridgeListener = paramString2;
          if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 1)
          {
            paramJsBridgeListener = paramString2;
            if (((VipProfileCardDownLoadInfo)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get())).g == VipProfileCardDownLoadInfo.jdField_d_of_type_JavaLangInteger)
            {
              paramJsBridgeListener = paramString2;
              if (((VipProfileCardDownLoadInfo)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get())).jdField_a_of_type_JavaLangString.equalsIgnoreCase(paramString3))
              {
                paramJsBridgeListener = paramString2;
                if (paramString1.getLong("id") == ((VipProfileCardDownLoadInfo)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get())).jdField_a_of_type_JavaLangLong.longValue())
                {
                  paramJsBridgeListener = paramString2;
                  ((VipProfileCardDownLoadInfo)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get())).g = VipProfileCardDownLoadInfo.jdField_b_of_type_JavaLangInteger;
                  paramJsBridgeListener = paramString2;
                  ((VipProfileCardDownLoadInfo)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get())).jdField_d_of_type_JavaLangString = paramString2;
                  return true;
                }
              }
            }
          }
          paramJsBridgeListener = paramString2;
          localObject1 = new VipProfileCardDownLoadInfo();
          paramJsBridgeListener = paramString2;
          ((VipProfileCardDownLoadInfo)localObject1).jdField_a_of_type_JavaLangLong = Long.valueOf(paramString1.getLong("id"));
          paramJsBridgeListener = paramString2;
          ((VipProfileCardDownLoadInfo)localObject1).jdField_a_of_type_JavaLangString = paramString3;
          paramJsBridgeListener = paramString2;
          ((VipProfileCardDownLoadInfo)localObject1).jdField_b_of_type_JavaLangString = ((String)localObject2);
          paramJsBridgeListener = paramString2;
          ((VipProfileCardDownLoadInfo)localObject1).jdField_d_of_type_JavaLangString = paramString2;
          paramJsBridgeListener = paramString2;
          ((VipProfileCardDownLoadInfo)localObject1).e = Integer.valueOf(0);
          paramJsBridgeListener = paramString2;
          ((VipProfileCardDownLoadInfo)localObject1).g = VipProfileCardDownLoadInfo.jdField_a_of_type_JavaLangInteger;
          paramJsBridgeListener = paramString2;
          this.jdField_a_of_type_JavaUtilList.add(localObject1);
          paramJsBridgeListener = paramString2;
          if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 0) {
            break label3474;
          }
          paramJsBridgeListener = paramString2;
          a();
          break label3474;
        }
        paramJsBridgeListener = paramString2;
        if (!paramString3.equals("queryDownloadInfo")) {
          break label1643;
        }
      }
      paramJsBridgeListener = paramString2;
      paramString3 = paramString1.getString("image_url");
      paramJsBridgeListener = paramString2;
      str = paramString1.optString("dynamicZip");
      paramJsBridgeListener = paramString2;
      if (!ProfileCardUtil.a((Context)localObject1, paramString3)) {
        break label1118;
      }
    }
    paramJsBridgeListener = paramString2;
    if (!TextUtils.isEmpty(str))
    {
      paramJsBridgeListener = paramString2;
      if (!ProfileCardUtil.b((Context)localObject1, str)) {}
    }
    else
    {
      paramJsBridgeListener = paramString2;
      ((JSONObject)localObject2).put("status", 3);
      paramJsBridgeListener = paramString2;
      ((JSONObject)localObject2).put("progress", 100);
      paramJsBridgeListener = paramString2;
      paramVarArgs.put("result", 0);
    }
    for (;;)
    {
      paramJsBridgeListener = paramString2;
      paramVarArgs.put("data", localObject2);
      paramJsBridgeListener = paramString2;
      a(paramString2, paramVarArgs.toString());
      break label3474;
      label1118:
      paramJsBridgeListener = paramString2;
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() >= 0) {
        break;
      }
      paramJsBridgeListener = paramString2;
      ((JSONObject)localObject2).put("status", 1);
      paramJsBridgeListener = paramString2;
      ((JSONObject)localObject2).put("progress", 0);
      paramJsBridgeListener = paramString2;
      paramVarArgs.put("result", 0);
    }
    paramJsBridgeListener = paramString2;
    int i = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
    paramJsBridgeListener = paramString2;
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      paramJsBridgeListener = paramString2;
      if (!((VipProfileCardDownLoadInfo)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangString.equalsIgnoreCase(paramString3)) {
        break label3476;
      }
      paramJsBridgeListener = paramString2;
      if (paramString1.getLong("id") != ((VipProfileCardDownLoadInfo)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangLong.longValue()) {
        break label3476;
      }
      paramJsBridgeListener = paramString2;
      if (((VipProfileCardDownLoadInfo)this.jdField_a_of_type_JavaUtilList.get(i)).g == VipProfileCardDownLoadInfo.jdField_d_of_type_JavaLangInteger) {
        break label3476;
      }
      paramJsBridgeListener = paramString2;
      if (QLog.isColorLevel())
      {
        paramJsBridgeListener = paramString2;
        QLog.i("ProfileCardWebviewPlugin", 2, "mIndex:" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() + ",id:" + ((VipProfileCardDownLoadInfo)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangLong + "status:" + ((VipProfileCardDownLoadInfo)this.jdField_a_of_type_JavaUtilList.get(i)).g);
      }
      paramJsBridgeListener = paramString2;
      if (((VipProfileCardDownLoadInfo)this.jdField_a_of_type_JavaUtilList.get(i)).g != VipProfileCardDownLoadInfo.jdField_a_of_type_JavaLangInteger)
      {
        paramJsBridgeListener = paramString2;
        if (((VipProfileCardDownLoadInfo)this.jdField_a_of_type_JavaUtilList.get(i)).g != VipProfileCardDownLoadInfo.jdField_b_of_type_JavaLangInteger) {
          break label1548;
        }
      }
      paramJsBridgeListener = paramString2;
      ((JSONObject)localObject2).put("status", 2);
      paramJsBridgeListener = paramString2;
      ((JSONObject)localObject2).put("progress", ((VipProfileCardDownLoadInfo)this.jdField_a_of_type_JavaUtilList.get(i)).e);
    }
    for (;;)
    {
      paramJsBridgeListener = paramString2;
      paramVarArgs.put("result", ((VipProfileCardDownLoadInfo)this.jdField_a_of_type_JavaUtilList.get(i)).f);
      paramJsBridgeListener = paramString2;
      if (i < this.jdField_a_of_type_JavaUtilList.size()) {
        break;
      }
      paramJsBridgeListener = paramString2;
      ((JSONObject)localObject2).put("status", 1);
      paramJsBridgeListener = paramString2;
      ((JSONObject)localObject2).put("progress", 0);
      paramJsBridgeListener = paramString2;
      paramVarArgs.put("result", 0);
      break;
      label1548:
      paramJsBridgeListener = paramString2;
      if (((VipProfileCardDownLoadInfo)this.jdField_a_of_type_JavaUtilList.get(i)).g == VipProfileCardDownLoadInfo.jdField_c_of_type_JavaLangInteger)
      {
        paramJsBridgeListener = paramString2;
        ((JSONObject)localObject2).put("status", 1);
        paramJsBridgeListener = paramString2;
        ((JSONObject)localObject2).put("progress", ((VipProfileCardDownLoadInfo)this.jdField_a_of_type_JavaUtilList.get(i)).e);
      }
      else
      {
        paramJsBridgeListener = paramString2;
        ((JSONObject)localObject2).put("status", 1);
        paramJsBridgeListener = paramString2;
        ((JSONObject)localObject2).put("progress", 0);
      }
    }
    label1643:
    paramJsBridgeListener = paramString2;
    label1877:
    int j;
    label2598:
    int k;
    if (paramString3.equals("preview"))
    {
      paramJsBridgeListener = paramString2;
      paramString3 = new Intent(this.mRuntime.a(), VipProfileCardPreviewActivity.class);
      paramJsBridgeListener = paramString2;
      paramString3.putExtra("preview", paramString1.toString());
      paramJsBridgeListener = paramString2;
      super.startActivityForResult(paramString3, (byte)1);
      paramJsBridgeListener = paramString2;
      paramVarArgs.put("result", 0);
      paramJsBridgeListener = paramString2;
      paramVarArgs.put("message", "ok");
      paramJsBridgeListener = paramString2;
      a(paramString2, paramVarArgs.toString());
    }
    else
    {
      paramJsBridgeListener = paramString2;
      if (paramString3.equals("getTime"))
      {
        paramJsBridgeListener = paramString2;
        paramVarArgs.put("data", NetConnInfoCenter.getServerTimeMillis());
        paramJsBridgeListener = paramString2;
        paramVarArgs.put("result", 0);
        paramJsBridgeListener = paramString2;
        paramVarArgs.put("message", "");
        paramJsBridgeListener = paramString2;
        a(paramString2, paramVarArgs.toString());
      }
      else
      {
        paramJsBridgeListener = paramString2;
        if (paramString3.equals("cancelDownload"))
        {
          paramJsBridgeListener = paramString2;
          paramString3 = paramString1.getString("image_url");
          paramJsBridgeListener = paramString2;
          l1 = paramString1.getLong("id");
          paramJsBridgeListener = paramString2;
          if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == -1)
          {
            paramJsBridgeListener = paramString2;
            this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
          }
          paramJsBridgeListener = paramString2;
          i = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
          paramJsBridgeListener = paramString2;
          if (i < this.jdField_a_of_type_JavaUtilList.size())
          {
            paramJsBridgeListener = paramString2;
            if (((VipProfileCardDownLoadInfo)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangLong.longValue() != l1) {
              break label3485;
            }
            paramJsBridgeListener = paramString2;
            if (!((VipProfileCardDownLoadInfo)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangString.equalsIgnoreCase(paramString3)) {
              break label3485;
            }
            paramJsBridgeListener = paramString2;
            if (((VipProfileCardDownLoadInfo)this.jdField_a_of_type_JavaUtilList.get(i)).g == VipProfileCardDownLoadInfo.jdField_d_of_type_JavaLangInteger) {
              break label3485;
            }
            paramJsBridgeListener = paramString2;
            ((VipProfileCardDownLoadInfo)this.jdField_a_of_type_JavaUtilList.get(i)).g = VipProfileCardDownLoadInfo.jdField_d_of_type_JavaLangInteger;
            paramJsBridgeListener = paramString2;
            paramVarArgs.put("result", 0);
            paramJsBridgeListener = paramString2;
            paramVarArgs.put("message", "ok");
          }
          paramJsBridgeListener = paramString2;
          if (i == this.jdField_a_of_type_JavaUtilList.size())
          {
            paramJsBridgeListener = paramString2;
            paramVarArgs.put("result", -2);
            paramJsBridgeListener = paramString2;
            paramVarArgs.put("message", "cancel download fail， bgId:" + l1);
          }
          paramJsBridgeListener = paramString2;
          a(paramString2, paramVarArgs.toString());
          paramJsBridgeListener = paramString2;
          paramString1 = new JSONObject();
          paramJsBridgeListener = paramString2;
          try
          {
            paramString1.put("result", -1);
            paramJsBridgeListener = paramString2;
            paramString1.put("message", "cancel download bgUrl:" + ((VipProfileCardDownLoadInfo)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangString);
            paramJsBridgeListener = paramString2;
            a(((VipProfileCardDownLoadInfo)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_d_of_type_JavaLangString, paramString1.toString());
          }
          catch (JSONException paramString1)
          {
            paramJsBridgeListener = paramString2;
            paramString1.printStackTrace();
          }
        }
        else
        {
          paramJsBridgeListener = paramString2;
          if (paramString3.equals("report"))
          {
            paramJsBridgeListener = paramString2;
            paramString3 = DataFactory.a("card_getVipInfo", paramString2, this.mOnRemoteResp.key, new Bundle());
            paramJsBridgeListener = paramString2;
            paramString3.putString("op_name", paramString1.getString("op_name"));
            paramJsBridgeListener = paramString2;
            paramString3.putString("ext1", paramString1.getString("ext1"));
            paramJsBridgeListener = paramString2;
            paramString3.putString("ext2", paramString1.getString("ext2"));
            paramJsBridgeListener = paramString2;
            paramString3.putString("ext3", paramString1.getString("ext3"));
            paramJsBridgeListener = paramString2;
            sendRemoteReq(paramString3, false, false);
          }
          else
          {
            paramJsBridgeListener = paramString2;
            if (paramString3.equals("openView"))
            {
              paramJsBridgeListener = paramString2;
              paramString1 = paramString1.getString("ADTAG");
              paramJsBridgeListener = paramString2;
              paramString3 = this.mRuntime.a();
              if (paramString3 != null)
              {
                paramJsBridgeListener = paramString2;
                localObject1 = new Intent(paramString3, QQBrowserActivity.class);
                paramJsBridgeListener = paramString2;
                ((Intent)localObject1).putExtra("uin", this.mRuntime.a().getAccount());
                paramJsBridgeListener = paramString2;
                ((Intent)localObject1).putExtra("isShowAd", false);
                paramJsBridgeListener = paramString2;
                ((Intent)localObject1).putExtra("startOpenPageTime", System.currentTimeMillis());
                paramJsBridgeListener = paramString2;
                ((Intent)localObject1).putExtra("url", IndividuationUrlHelper.a(paramString3, "card", paramString1));
                paramJsBridgeListener = paramString2;
                paramString3.startActivity((Intent)localObject1);
              }
            }
            else
            {
              paramJsBridgeListener = paramString2;
              if (paramString3.equals("clickPhotoWall"))
              {
                paramJsBridgeListener = paramString2;
                paramString1 = this.mRuntime.a(this.mRuntime.a());
                if (paramString1 != null)
                {
                  paramJsBridgeListener = paramString2;
                  if ((paramString1 instanceof WebUiUtils.WebUiMethodInterface))
                  {
                    paramJsBridgeListener = paramString2;
                    paramString1 = ((WebUiUtils.WebUiMethodInterface)paramString1).b();
                    paramJsBridgeListener = paramString2;
                    if (TextUtils.isEmpty(paramString1)) {
                      break label2598;
                    }
                    paramJsBridgeListener = paramString2;
                    if (!paramString1.contains("entryId")) {
                      break label2598;
                    }
                    paramJsBridgeListener = paramString2;
                  }
                }
                for (this.jdField_a_of_type_Int = URLUtil.a(URLUtil.a(paramString1), "entryId", 2);; this.jdField_a_of_type_Int = 2)
                {
                  paramJsBridgeListener = paramString2;
                  paramString1 = this.mRuntime.a().getAccount();
                  paramJsBridgeListener = paramString2;
                  paramString3 = QZoneHelper.UserInfo.a();
                  paramJsBridgeListener = paramString2;
                  paramString3.jdField_a_of_type_JavaLangString = paramString1;
                  paramJsBridgeListener = paramString2;
                  QZoneHelper.a(this.mRuntime.a(), paramString3, null, paramString1, getRequestCode((byte)2));
                  break;
                  paramJsBridgeListener = paramString2;
                }
              }
              paramJsBridgeListener = paramString2;
              if (paramString3.equals("uploadBackground"))
              {
                paramJsBridgeListener = paramString2;
                b();
                paramJsBridgeListener = paramString2;
                paramVarArgs.put("result", 0);
                paramJsBridgeListener = paramString2;
                paramVarArgs.put("message", "ok");
                paramJsBridgeListener = paramString2;
                a(paramString2, paramVarArgs.toString());
              }
              else
              {
                paramJsBridgeListener = paramString2;
                if (paramString3.equals("setGameHonour"))
                {
                  paramJsBridgeListener = paramString2;
                  paramString3 = DataFactory.a("card_set_custom_honor", paramString2, this.mOnRemoteResp.key, new Bundle());
                  paramJsBridgeListener = paramString2;
                  paramString3.putString("honor_data", paramString1.toString());
                  paramJsBridgeListener = paramString2;
                  sendRemoteReq(paramString3, false, false);
                }
                else
                {
                  paramJsBridgeListener = paramString2;
                  if (paramString3.equals("downloadWzResource"))
                  {
                    paramJsBridgeListener = paramString2;
                    l1 = paramString1.optLong("id");
                    paramJsBridgeListener = paramString2;
                    localObject2 = paramString1.optString("bgUrl");
                    paramJsBridgeListener = paramString2;
                    paramString1.optString("dynamicZip");
                    paramJsBridgeListener = paramString2;
                    paramString3 = paramString1.optString("wzHeroUrl");
                    paramJsBridgeListener = paramString2;
                    if (!VipWZRYTemplateHelper.a(paramString1.optInt("styleId"))) {
                      break label3494;
                    }
                    paramJsBridgeListener = paramString2;
                    if (!VipWZRYTemplateHelper.a((Context)localObject1, "cardWZ.zip")) {
                      break label3494;
                    }
                    i = 1;
                    label2820:
                    paramJsBridgeListener = paramString2;
                    if (TextUtils.isEmpty((CharSequence)localObject2)) {
                      break label3500;
                    }
                    paramJsBridgeListener = paramString2;
                    if (!ProfileCardUtil.a((Context)localObject1, (String)localObject2)) {
                      break label3500;
                    }
                    j = 1;
                    label2845:
                    paramJsBridgeListener = paramString2;
                    if (TextUtils.isEmpty(paramString3)) {
                      break label3506;
                    }
                    paramJsBridgeListener = paramString2;
                    if (!ProfileCardUtil.a((Context)localObject1, paramString3)) {
                      break label3506;
                    }
                    k = 1;
                    label2870:
                    if ((i != 0) && (j != 0))
                    {
                      bool = true;
                      paramJsBridgeListener = paramString2;
                      if (!TextUtils.isEmpty(paramString3))
                      {
                        paramJsBridgeListener = paramString2;
                        bool = ProfileCardUtil.a((Context)localObject1, paramString3);
                      }
                      if (bool)
                      {
                        paramJsBridgeListener = paramString2;
                        paramVarArgs.put("result", 0);
                        paramJsBridgeListener = paramString2;
                        paramVarArgs.put("progress", 100);
                        paramJsBridgeListener = paramString2;
                        callJs(paramString2, new String[] { paramVarArgs.toString() });
                        return true;
                      }
                    }
                    paramJsBridgeListener = paramString2;
                    if (!NetworkUtil.d(this.mRuntime.a().getApplicationContext()))
                    {
                      paramJsBridgeListener = paramString2;
                      paramVarArgs.put("result", -2);
                      paramJsBridgeListener = paramString2;
                      paramVarArgs.put("message", "no network");
                      paramJsBridgeListener = paramString2;
                      a(paramString2, paramVarArgs.toString());
                      return true;
                    }
                    paramJsBridgeListener = paramString2;
                    long l2 = ProfileCardUtil.b();
                    if (l2 < 102400)
                    {
                      paramJsBridgeListener = paramString2;
                      if (QLog.isColorLevel())
                      {
                        paramJsBridgeListener = paramString2;
                        QLog.d("ProfileCardWebviewPlugin", 2, "Insufficient SDCard space, reserved:" + 102400 + "|available:" + l2);
                      }
                      paramJsBridgeListener = paramString2;
                      paramVarArgs.put("result", -3);
                      paramJsBridgeListener = paramString2;
                      paramVarArgs.put("message", "Insufficient SDCard space.");
                      paramJsBridgeListener = paramString2;
                      a(paramString2, paramVarArgs.toString());
                      return true;
                    }
                    paramJsBridgeListener = paramString2;
                    if (!this.jdField_a_of_type_JavaUtilList.isEmpty())
                    {
                      paramJsBridgeListener = paramString2;
                      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() >= 0)
                      {
                        paramJsBridgeListener = paramString2;
                        if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() < this.jdField_a_of_type_JavaUtilList.size())
                        {
                          paramJsBridgeListener = paramString2;
                          paramString1 = (VipProfileCardDownLoadInfo)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
                          paramJsBridgeListener = paramString2;
                          if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 1)
                          {
                            paramJsBridgeListener = paramString2;
                            if (paramString1.g.equals(VipProfileCardDownLoadInfo.jdField_d_of_type_JavaLangInteger))
                            {
                              paramJsBridgeListener = paramString2;
                              if (paramString1.jdField_a_of_type_JavaLangString.equalsIgnoreCase((String)localObject2))
                              {
                                paramJsBridgeListener = paramString2;
                                if (l1 == paramString1.jdField_a_of_type_JavaLangLong.longValue())
                                {
                                  paramJsBridgeListener = paramString2;
                                  paramString1.g = VipProfileCardDownLoadInfo.jdField_b_of_type_JavaLangInteger;
                                  paramJsBridgeListener = paramString2;
                                  paramString1.jdField_d_of_type_JavaLangString = paramString2;
                                  return true;
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                    paramJsBridgeListener = paramString2;
                    localObject1 = new VipProfileCardDownLoadInfo();
                    paramJsBridgeListener = paramString2;
                    ((VipProfileCardDownLoadInfo)localObject1).jdField_a_of_type_JavaLangLong = Long.valueOf(l1);
                    paramJsBridgeListener = paramString2;
                    ((VipProfileCardDownLoadInfo)localObject1).jdField_a_of_type_JavaLangString = ((String)localObject2);
                    paramJsBridgeListener = paramString2;
                    ((VipProfileCardDownLoadInfo)localObject1).jdField_d_of_type_JavaLangString = paramString2;
                    if (k == 0) {
                      break label3512;
                    }
                    paramString1 = null;
                    label3312:
                    paramJsBridgeListener = paramString2;
                    ((VipProfileCardDownLoadInfo)localObject1).jdField_c_of_type_JavaLangString = paramString1;
                    if (i != 0) {
                      break label3518;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    label3474:
    label3476:
    label3485:
    label3494:
    label3500:
    label3506:
    label3512:
    label3518:
    for (boolean bool = true;; bool = false)
    {
      paramJsBridgeListener = paramString2;
      ((VipProfileCardDownLoadInfo)localObject1).jdField_b_of_type_Boolean = bool;
      paramJsBridgeListener = paramString2;
      ((VipProfileCardDownLoadInfo)localObject1).jdField_a_of_type_Boolean = true;
      paramJsBridgeListener = paramString2;
      ((VipProfileCardDownLoadInfo)localObject1).e = Integer.valueOf(0);
      paramJsBridgeListener = paramString2;
      ((VipProfileCardDownLoadInfo)localObject1).g = VipProfileCardDownLoadInfo.jdField_a_of_type_JavaLangInteger;
      paramJsBridgeListener = paramString2;
      this.jdField_a_of_type_JavaUtilList.add(localObject1);
      paramJsBridgeListener = paramString2;
      if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 0)
      {
        paramJsBridgeListener = paramString2;
        a();
        break label3474;
        paramJsBridgeListener = paramString2;
        if (paramString3.equals("setSwitchOfKingGlory"))
        {
          paramJsBridgeListener = paramString2;
          i = paramString1.optInt("status");
          paramJsBridgeListener = paramString2;
          paramString1 = new Bundle();
          paramJsBridgeListener = paramString2;
          paramString1.putInt("status", i);
          paramJsBridgeListener = paramString2;
          sendRemoteReq(DataFactory.a("ipc_plateofking_switch", paramString2, this.mOnRemoteResp.key, paramString1), false, false);
        }
        else
        {
          return false;
        }
      }
      return true;
      i += 1;
      break;
      i += 1;
      break label1877;
      i = 0;
      break label2820;
      j = 0;
      break label2845;
      k = 0;
      break label2870;
      paramString1 = paramString3;
      break label3312;
    }
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCardWebviewPlugin", 2, "ProfileCardWebviewPlugin onActivityResult,requestCode = " + paramByte + ", resultCode = " + paramInt + ", data = " + paramIntent);
    }
    if (paramInt != -1) {}
    while (paramIntent == null) {
      return;
    }
    if ((paramByte == 1) || (paramByte == 2)) {}
    try
    {
      if (this.jdField_a_of_type_Int != 0)
      {
        Object localObject2 = paramIntent.getStringExtra("uin");
        Object localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = this.mRuntime.a().getCurrentAccountUin();
        }
        localObject2 = new Intent(this.mRuntime.a(), FriendProfileCardActivity.class);
        ((Intent)localObject2).putExtra("AllInOne", new ProfileActivity.AllInOne((String)localObject1, 0));
        this.mRuntime.a().startActivity((Intent)localObject2);
      }
      paramIntent.putExtra("closeSpecialLogic", true);
      this.mRuntime.a().setResult(-1, paramIntent);
      this.mRuntime.a().finish();
      return;
    }
    catch (Exception paramIntent)
    {
      paramIntent.printStackTrace();
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory = new DownloaderFactory(this.mRuntime.a());
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory.onDestroy();
    try
    {
      if (this.jdField_a_of_type_Boolean) {
        this.mRuntime.a().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ProfileCardWebviewPlugin", 2, "unregister receiver exception:" + localException.toString());
    }
  }
  
  protected void onResponse(Bundle paramBundle)
  {
    if (paramBundle != null) {
      for (;;)
      {
        JSONObject localJSONObject;
        String str2;
        String str1;
        Bundle localBundle;
        try
        {
          if (paramBundle.getInt("respkey", 0) != this.mOnRemoteResp.key) {
            break;
          }
          localObject = new JSONObject();
          localJSONObject = new JSONObject();
          str2 = paramBundle.getString("cmd");
          str1 = paramBundle.getString("callbackid");
          localBundle = paramBundle.getBundle("response");
          if (str2 == null) {
            break;
          }
          if ("card_getinfo".equals(str2))
          {
            long l1 = localBundle.getLong("currentId");
            long l2 = localBundle.getLong("styleId");
            int j = localBundle.getInt("result");
            i = 0;
            if ((l2 == ProfileCardTemplate.e) || (l2 == ProfileCardTemplate.a) || (l2 == ProfileCardTemplate.g)) {
              break label494;
            }
            ((JSONObject)localObject).put("currentId", l1);
            ((JSONObject)localObject).put("styleId", l2);
            ((JSONObject)localObject).put("isPhotoWall", i);
            localJSONObject.put("data", localObject);
            localJSONObject.put("result", j);
            a(str1, localJSONObject.toString());
            return;
          }
          if ("card_setSummaryCard".equals(str2))
          {
            i = localBundle.getInt("result");
            paramBundle = localBundle.getString("message");
            localJSONObject.put("result", i);
            localJSONObject.put("message", paramBundle);
            a(str1, localJSONObject.toString());
            return;
          }
        }
        catch (Exception paramBundle)
        {
          paramBundle.printStackTrace();
          return;
        }
        if ("card_getVipInfo".equals(str2))
        {
          ReportController.b(null, "P_CliOper", "Vip_SummaryCard", "", paramBundle.getString("op_name"), paramBundle.getString("op_name"), 0, 0, paramBundle.getString("ext1"), paramBundle.getString("ext2"), paramBundle.getString("ext3"), localBundle.getString("vip_info"));
          localJSONObject.put("result", 0);
          localJSONObject.put("message", "ok");
          a(str1, localJSONObject.toString());
          return;
        }
        if (("selectPhoto".equals(str2)) || ("takePhoto".equals(str2)) || (!"card_download_wzry_template".equals(str2))) {
          break;
        }
        int i = localBundle.getInt("result");
        Object localObject = localBundle.getString("message");
        if (i != 0)
        {
          localJSONObject.put("result", -1);
          localJSONObject.put("message", localObject);
          a(str1, localJSONObject.toString());
          this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
          return;
        }
        a(paramBundle.getString("image_url"), "", paramBundle.getString("wzHeroUrl"), str1, true);
        return;
        label494:
        i = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.profile.ProfileCardWebviewPlugin
 * JD-Core Version:    0.7.0.1
 */