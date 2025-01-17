package com.tencent.mobileqq.apollo.utils;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsShareMsg.Builder;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.StructMsgElementFactory;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import com.tencent.widget.ActionSheetAdapter;
import cooperation.qzone.QZoneShareManager;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import ywi;
import ywj;

public class ApolloGameShare
  implements DialogInterface.OnDismissListener, Handler.Callback, AdapterView.OnItemClickListener, ActionSheet.OnButtonClickListener
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  public Handler a;
  private ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  private WeakReference jdField_b_of_type_JavaLangRefWeakReference;
  private String c;
  private String d;
  private String e;
  private String f;
  private String g;
  
  public ApolloGameShare(Context paramContext, AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    try
    {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference((Activity)paramContext);
      this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramAppInterface);
      return;
    }
    catch (Throwable paramContext)
    {
      QLog.i("ApolloGameShare", 1, "[ApolloGameShare], errInfo->" + paramContext.getMessage());
    }
  }
  
  private int a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameShare", 2, "[parseShareParm],jsonStr:" + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {
      return -1;
    }
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        if (paramString.has("title")) {
          this.jdField_a_of_type_JavaLangString = paramString.getString("title");
        }
        this.f = ("[分享]" + this.jdField_a_of_type_JavaLangString);
        if (paramString.has("summary")) {
          this.jdField_b_of_type_JavaLangString = paramString.getString("summary");
        }
        if (paramString.has("detailUrl")) {
          this.c = paramString.getString("detailUrl");
        }
        if (paramString.has("picUrl")) {
          this.d = paramString.getString("picUrl");
        }
        if (paramString.has("gameVersion")) {
          this.e = paramString.getString("gameVersion");
        }
        if (paramString.has("gameId")) {
          this.jdField_a_of_type_Int = paramString.getInt("gameId");
        }
        if (paramString.has("roomId")) {
          this.jdField_b_of_type_Long = paramString.getLong("roomId");
        }
        if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(this.c)) || (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) || (TextUtils.isEmpty(this.c))) {
          break;
        }
        if (this.jdField_b_of_type_JavaLangRefWeakReference != null)
        {
          paramString = (AppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get();
          if (paramString != null)
          {
            paramString = paramString.getCurrentAccountUin();
            this.c = (this.c + "&gameId=" + this.jdField_a_of_type_Int + "&roomId=" + this.jdField_b_of_type_Long + "&gameVersion=" + this.e + "&uin=" + paramString);
            if (QLog.isColorLevel()) {
              QLog.d("ApolloGameShare", 2, "[mDetailUrl]:" + this.c);
            }
            return 0;
          }
        }
      }
      catch (Exception paramString)
      {
        QLog.i("ApolloGameShare", 1, "[showShareDialog], errInfo->" + paramString.getMessage());
        return -3;
      }
      paramString = "";
    }
    return -2;
  }
  
  private AppInterface a()
  {
    if (this.jdField_b_of_type_JavaLangRefWeakReference == null) {
      return null;
    }
    return (AppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get();
  }
  
  private void a(int paramInt)
  {
    ThreadManager.post(new ywj(this, paramInt), 5, null, true);
  }
  
  private void b()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("title", this.jdField_a_of_type_JavaLangString);
    localBundle.putString("desc", this.jdField_b_of_type_JavaLangString);
    localBundle.putString("detail_url", this.c);
    Object localObject = new ArrayList(1);
    ((ArrayList)localObject).add(this.d);
    localBundle.putStringArrayList("image_url", (ArrayList)localObject);
    localBundle.putLong("req_share_id", 0L);
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {}
    for (localObject = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();; localObject = null)
    {
      if (this.jdField_b_of_type_JavaLangRefWeakReference != null) {}
      for (AppInterface localAppInterface = (AppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get();; localAppInterface = null)
      {
        if ((localObject != null) && (localAppInterface != null) && (QZoneShareManager.a(localAppInterface, (Context)localObject, localBundle, null)))
        {
          localObject = a();
          if (localObject != null) {
            break label172;
          }
        }
        label172:
        for (int i = -1;; i = ApolloUtil.b(((BaseChatPie)localObject).a.jdField_a_of_type_Int))
        {
          VipUtils.a(a(), "cmshow", "Apollo", "share_url_succeed", i, 1, new String[] { Integer.toString(this.jdField_a_of_type_Int) });
          return;
        }
      }
    }
  }
  
  private void c()
  {
    Object localObject1 = new AbsShareMsg.Builder(StructMsgForGeneralShare.class).b(96).a(this.f).c(this.c).a("厘米秀", null).b("web", "https://cmshow.qq.com/apollo/html/intro.html?_wv=1027&_bid=2326", "https://cmshow.qq.com/apollo/html/intro.html?_wv=1027&_bid=2326", "https://cmshow.qq.com/apollo/html/intro.html?_wv=1027&_bid=2326", "https://cmshow.qq.com/apollo/html/intro.html?_wv=1027&_bid=2326").a();
    Object localObject2 = StructMsgElementFactory.a(2);
    ((AbsStructMsgItem)localObject2).a(this.d, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
    ((AbsShareMsg)localObject1).addItem((AbsStructMsgElement)localObject2);
    localObject2 = new Intent();
    ((Intent)localObject2).putExtra("forward_type", -3);
    ((Intent)localObject2).putExtra("stuctmsg_bytes", ((AbsShareMsg)localObject1).getBytes());
    ((Intent)localObject2).putExtra("cmshow_game_id", this.jdField_a_of_type_Int);
    ((Intent)localObject2).putExtra("forwardDirect", true);
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      localObject1 = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localObject1 != null) {
        ForwardBaseOption.a((Activity)localObject1, (Intent)localObject2, 14002);
      }
    }
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    a();
  }
  
  public BaseChatPie a()
  {
    Object localObject;
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {
      localObject = null;
    }
    for (;;)
    {
      return localObject;
      localObject = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localObject == null) {
        return null;
      }
      try
      {
        localObject = ((FragmentActivity)localObject).getChatFragment().a();
        if (localObject != null)
        {
          int i = ((BaseChatPie)localObject).g();
          if (i < 7) {}
        }
        else
        {
          return null;
        }
      }
      catch (Throwable localThrowable) {}
    }
    return null;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet != null) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    }
  }
  
  public void a(String paramString)
  {
    ActionSheetAdapter localActionSheetAdapter = null;
    int i = a(paramString);
    if (i < 0)
    {
      QLog.i("ApolloGameShare", 1, "[showShareDialog], errInfo->parse err or param err, ret:" + i);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(ActionSheetAdapter.a(0));
    localArrayList.add(ActionSheetAdapter.a(1));
    localArrayList.add(ActionSheetAdapter.a(2));
    localArrayList.add(ActionSheetAdapter.a(3));
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {}
    for (paramString = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();; paramString = null)
    {
      if (paramString != null)
      {
        localActionSheetAdapter = new ActionSheetAdapter(paramString);
        localActionSheetAdapter.a(localArrayList);
      }
      if ((this.jdField_a_of_type_ComTencentWidgetActionSheet == null) && (paramString != null)) {
        this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheetAdapter.a(paramString, localActionSheetAdapter, this, this, this, false);
      }
      if ((this.jdField_a_of_type_ComTencentWidgetActionSheet != null) && (!this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing()))
      {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnDismissListener(this);
        this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
      }
      paramString = a();
      if (paramString == null) {}
      for (i = -1;; i = ApolloUtil.b(paramString.a.jdField_a_of_type_Int))
      {
        VipUtils.a(a(), "cmshow", "Apollo", "share_panel_open", i, 0, new String[] { Integer.toString(this.jdField_a_of_type_Int) });
        return;
      }
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    ActionSheetAdapter localActionSheetAdapter = null;
    ArrayList localArrayList;
    try
    {
      paramString = new JSONObject(paramString).optString("path");
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        QLog.e("ApolloGameShare", 2, "showSharePic parse err=" + paramString.toString());
        paramString = null;
      }
      localArrayList = new ArrayList();
      localArrayList.add(ActionSheetAdapter.a(1));
      localArrayList.add(ActionSheetAdapter.a(0));
      if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    }
    for (Activity localActivity = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();; localActivity = null)
    {
      if (localActivity != null)
      {
        localActionSheetAdapter = new ActionSheetAdapter(localActivity);
        localActionSheetAdapter.a(localArrayList);
      }
      if ((this.jdField_a_of_type_ComTencentWidgetActionSheet == null) && (localActivity != null))
      {
        paramString = ApolloRender.getSandBoxPathByRealGameId(paramInt, paramString);
        if (QLog.isColorLevel()) {
          QLog.d("ApolloGameShare", 2, new Object[] { "share pic:", paramString });
        }
        this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheetAdapter.a(localActivity, localActionSheetAdapter, new ywi(this, paramString), this, this, false);
      }
      if ((this.jdField_a_of_type_ComTencentWidgetActionSheet == null) || (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())) {
        break;
      }
      this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnDismissListener(this);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
      return;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    Object localObject;
    Bundle localBundle;
    ArrayList localArrayList;
    switch (paramMessage.what)
    {
    default: 
    case 1: 
      do
      {
        do
        {
          do
          {
            return false;
            if (this.jdField_a_of_type_ComTencentWidgetActionSheet != null) {
              this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
            }
          } while (this.jdField_b_of_type_JavaLangRefWeakReference == null);
          localObject = (AppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get();
        } while (localObject == null);
        paramMessage = (String)paramMessage.obj;
        if (!TextUtils.isEmpty(paramMessage)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("ApolloGameShare", 1, "onItemClick share QZone apolloImage no file");
      return false;
      localBundle = new Bundle();
      localArrayList = new ArrayList();
    }
    for (;;)
    {
      try
      {
        localArrayList.add(URLDecoder.decode(paramMessage));
        localBundle.putStringArrayList("images", localArrayList);
        localBundle.putString("summary", "厘米秀");
        localBundle.putInt("req_type", 7);
        localBundle.putBoolean("key_need_save_draft", false);
        if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {
          break label332;
        }
        paramMessage = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (paramMessage == null) {
          break;
        }
        QZoneShareManager.a((AppInterface)localObject, paramMessage, localBundle, this, 15);
        return false;
      }
      catch (Exception paramMessage)
      {
        QLog.d("ApolloGameShare", 2, "publishToQzone:" + paramMessage.getMessage());
        return false;
      }
      if (this.jdField_a_of_type_ComTencentWidgetActionSheet != null) {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      }
      localObject = (String)paramMessage.obj;
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        QLog.e("ApolloGameShare", 1, "onItemClick share QQ apolloImage no file");
        return false;
      }
      if (!new File((String)localObject).exists())
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("ApolloGameShare", 1, "onItemClick share QQ apolloImage no file");
        return false;
      }
      if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {}
      for (paramMessage = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get(); paramMessage != null; paramMessage = null)
      {
        ApolloUtil.a(paramMessage, (String)localObject, null, 1);
        return false;
      }
      break;
      label332:
      paramMessage = null;
    }
  }
  
  public void onDismiss(DialogInterface paramDialogInterface) {}
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    long l = System.currentTimeMillis();
    if (l - this.jdField_a_of_type_Long < 1000L) {
      return;
    }
    this.jdField_a_of_type_Long = l;
    a();
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameShare", 2, new Object[] { "click type:", Long.valueOf(paramLong) });
    }
    if (paramLong == 1L)
    {
      b();
      paramInt = 1;
    }
    for (;;)
    {
      paramAdapterView = a();
      if (paramAdapterView == null) {}
      for (int i = -1;; i = ApolloUtil.b(paramAdapterView.a.jdField_a_of_type_Int))
      {
        VipUtils.a(a(), "cmshow", "Apollo", "send_game_share", i, paramInt, new String[] { Integer.toString(this.jdField_a_of_type_Int) });
        return;
        if (paramLong == 0L)
        {
          c();
          paramInt = 0;
          break;
        }
        if (paramLong == 2L)
        {
          paramInt = 3;
          a(1);
          break;
        }
        if (paramLong != 3L) {
          break label186;
        }
        paramInt = 4;
        a(2);
        break;
      }
      label186:
      paramInt = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloGameShare
 * JD-Core Version:    0.7.0.1
 */