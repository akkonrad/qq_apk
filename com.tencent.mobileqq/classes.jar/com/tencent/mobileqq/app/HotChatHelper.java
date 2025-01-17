package com.tencent.mobileqq.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.message.AddMessageHelper;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsShareMsg.Builder;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.StructMsgElementFactory;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneShareManager;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import zey;
import zez;
import zfa;
import zfb;
import zfc;
import zfd;
import zfe;

public class HotChatHelper
{
  public static Dialog a(Activity paramActivity, View.OnClickListener paramOnClickListener)
  {
    paramActivity = new Dialog(paramActivity, 2131624516);
    paramActivity.setContentView(2130970366);
    Button localButton1 = (Button)paramActivity.findViewById(2131370248);
    Button localButton2 = (Button)paramActivity.findViewById(2131370250);
    localButton1.setOnClickListener(new zey(paramActivity));
    paramActivity.setCanceledOnTouchOutside(true);
    localButton2.setOnClickListener(paramOnClickListener);
    paramActivity.show();
    return paramActivity;
  }
  
  public static Bitmap a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      for (;;)
      {
        return null;
        try
        {
          paramString = new File(paramString);
          if (paramString.exists())
          {
            BitmapFactory.Options localOptions = new BitmapFactory.Options();
            localOptions.inJustDecodeBounds = true;
            BitmapManager.a(paramString.getAbsolutePath(), localOptions);
            int i = localOptions.outWidth;
            if (i > 150) {
              localOptions.inSampleSize = (i / 150);
            }
            localOptions.inJustDecodeBounds = false;
            paramString = BitmapManager.a(paramString.getAbsolutePath(), localOptions);
            return paramString;
          }
        }
        catch (OutOfMemoryError paramString)
        {
          if (QLog.isColorLevel())
          {
            QLog.d("HotChatHelper", 2, "makeShareBitmap", paramString);
            return null;
          }
        }
        catch (Throwable paramString) {}
      }
    } while (!QLog.isColorLevel());
    QLog.d("HotChatHelper", 2, "makeShareBitmap", paramString);
    return null;
  }
  
  public static QQCustomDialog a(QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    int i = paramActivity.getRequestedOrientation();
    paramActivity.setRequestedOrientation(1);
    paramQQAppInterface = DialogUtil.a(paramActivity, 0, 2130969489, paramActivity.getString(2131437336), null, paramActivity.getString(2131437767), paramActivity.getString(2131437766), new zez(paramActivity, paramQQAppInterface), new zfa(paramQQAppInterface));
    paramQQAppInterface.setOnDismissListener(new zfb(paramActivity, i));
    paramQQAppInterface.getBtnight().setTypeface(Typeface.DEFAULT_BOLD);
    paramQQAppInterface.setMessageCount(paramActivity.getString(2131437337));
    paramQQAppInterface.setPreviewImage(paramActivity.getResources().getDrawable(2130840600), true, 1);
    paramQQAppInterface.show();
    return paramQQAppInterface;
  }
  
  public static QQCustomDialog a(HotChatInfo paramHotChatInfo, DialogInterface.OnClickListener paramOnClickListener)
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if ((paramHotChatInfo == null) || (localBaseActivity == null) || (localBaseActivity.isFinishing())) {
      return null;
    }
    int i = localBaseActivity.getRequestedOrientation();
    localBaseActivity.setRequestedOrientation(1);
    paramHotChatInfo = DialogUtil.b(localBaseActivity, 230, localBaseActivity.getString(2131437339), localBaseActivity.getString(2131437338), 2131433015, 2131433519, paramOnClickListener, new zfc());
    paramOnClickListener = (TextView)paramHotChatInfo.findViewById(2131362776);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 17;
    paramOnClickListener.setLayoutParams(localLayoutParams);
    paramHotChatInfo.setOnDismissListener(new zfd(localBaseActivity, i));
    paramHotChatInfo.show();
    return paramHotChatInfo;
  }
  
  public static String a(String paramString, int paramInt)
  {
    return "http://play.mobile.qq.com/play/mqqplay/hotchat/hotchat_share.html?_wv=1027&adtag=android&hotnamecode=" + paramString + "&newly_created=" + paramInt;
  }
  
  public static void a(int paramInt, QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    paramString5 = new ShareActionSheetBuilder(paramBaseActivity);
    paramString5.a(paramBaseActivity.getString(2131433100));
    paramString5.a(a(paramBaseActivity));
    paramString5.a(new zfe(paramString5, paramInt, paramQQAppInterface, paramBaseActivity, paramString1, paramString6, paramString3, paramString4, paramString7, paramString2, paramString8));
    try
    {
      paramString5.a();
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ShareActionSheet", 2, "actionSheet.show exception=" + paramQQAppInterface);
    }
  }
  
  public static void a(BaseActivity paramBaseActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    long l = System.currentTimeMillis();
    paramBaseActivity = null;
    if (!TextUtils.isEmpty(paramString6)) {
      paramBaseActivity = a(paramString6);
    }
    paramString1 = paramBaseActivity;
    if (paramBaseActivity == null) {
      paramString1 = BitmapManager.b(BaseApplicationImpl.getApplication().getResources(), 2130842645);
    }
    WXShareHelper.a().b(String.valueOf(l), paramString2, paramString1, paramString3, paramString5);
  }
  
  public static void a(BaseActivity paramBaseActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 69;; i = 65)
    {
      paramString4 = new AbsShareMsg.Builder(StructMsgForGeneralShare.class).b(i).a(paramString2).a("web", paramString4, paramString5, null, null).a("邀请加入热聊", null).a();
      paramString5 = StructMsgElementFactory.a(2);
      paramString1 = paramString6;
      if (TextUtils.isEmpty(paramString6)) {
        paramString1 = "http://sqimg.qq.com/qq_product_operations/playqq/anonymous/image/reliao0714.png";
      }
      paramString5.a(paramString1, paramString2, paramString3, 0);
      paramString4.addItem(paramString5);
      paramString1 = new Intent();
      paramString1.putExtra("forward_type", -3);
      paramString1.putExtra("stuctmsg_bytes", paramString4.getBytes());
      ForwardBaseOption.a(paramBaseActivity, paramString1, 3);
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, HotChatInfo paramHotChatInfo)
  {
    if (paramHotChatInfo == null) {}
    do
    {
      return;
      if (paramHotChatInfo.state == 1)
      {
        a(paramQQAppInterface, paramHotChatInfo, paramQQAppInterface.getApp().getString(2131437333), true);
        return;
      }
      a(paramQQAppInterface, paramHotChatInfo, paramQQAppInterface.getApp().getString(2131437323), true);
      RecentUserProxy localRecentUserProxy = paramQQAppInterface.a().a();
      RecentUser localRecentUser = localRecentUserProxy.a(paramHotChatInfo.troopUin, 1);
      if (localRecentUser != null) {
        localRecentUserProxy.b(localRecentUser);
      }
    } while (paramHotChatInfo.state != 0);
    paramHotChatInfo.state = 4;
    paramQQAppInterface = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    paramQQAppInterface.a(paramHotChatInfo);
    paramQQAppInterface.a();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, HotChatInfo paramHotChatInfo, String paramString, boolean paramBoolean)
  {
    if ((paramHotChatInfo == null) || (paramHotChatInfo.isGameRoom)) {
      return;
    }
    AddMessageHelper.a(paramQQAppInterface, paramHotChatInfo.troopUin, paramString, 1, paramBoolean, false);
  }
  
  public static void a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord != null) {
      paramMessageRecord.saveExtInfoToExtStr("hotchat_flash_pic", "true");
    }
  }
  
  public static void a(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    if (paramMessageRecord.msgtype == -2000) {
      paramMessageRecord.saveExtInfoToExtStr("hotchat_flash_pic", paramBoolean + "");
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.hotchat", 4, "setFlashPicFlag,troopUin:" + paramMessageRecord.frienduin + ",isReaded:" + paramBoolean + ",msgType:" + paramMessageRecord.msgtype);
    }
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramMessageRecord != null) {
      if (paramMessageRecord.msgtype != -2000)
      {
        bool1 = bool2;
        if (paramMessageRecord.msgtype != -2006) {}
      }
      else
      {
        bool1 = bool2;
        if (!TextUtils.isEmpty(paramMessageRecord.getExtInfoFromExtStr("hotchat_flash_pic"))) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static List[] a(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.jdField_a_of_type_JavaLangString = paramContext.getString(2131430108);
    localActionSheetItem.jdField_b_of_type_Int = 2130838336;
    localActionSheetItem.jdField_a_of_type_Boolean = true;
    localActionSheetItem.c = 2;
    localActionSheetItem.jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.jdField_a_of_type_JavaLangString = paramContext.getString(2131430114);
    localActionSheetItem.jdField_b_of_type_Int = 2130838337;
    localActionSheetItem.jdField_a_of_type_Boolean = true;
    localActionSheetItem.c = 3;
    localActionSheetItem.jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.jdField_a_of_type_JavaLangString = paramContext.getString(2131430126);
    localActionSheetItem.jdField_b_of_type_Int = 2130838340;
    localActionSheetItem.c = 9;
    localActionSheetItem.jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.jdField_a_of_type_JavaLangString = paramContext.getString(2131430127);
    localActionSheetItem.jdField_b_of_type_Int = 2130838334;
    localActionSheetItem.c = 10;
    localActionSheetItem.jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localActionSheetItem);
    return (List[])new ArrayList[] { localArrayList };
  }
  
  private static void b(BaseActivity paramBaseActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)paramBaseActivity.getAppRuntime();
    ArrayList localArrayList = new ArrayList();
    String str = paramString5;
    if (TextUtils.isEmpty(paramString5)) {
      str = "http://sqimg.qq.com/qq_product_operations/playqq/anonymous/image/reliao0714.png";
    }
    localArrayList.add(str);
    paramString5 = new Bundle();
    paramString5.putString("title", paramString1);
    paramString5.putString("desc", paramString3);
    paramString5.putLong("req_share_id", 0L);
    paramString5.putString("detail_url", paramString4);
    paramString5.putString("url", paramString4);
    paramString5.putStringArrayList("image_url", localArrayList);
    paramString1 = paramString2;
    if (paramString2.startsWith("邀请加入QQ热聊：")) {
      paramString1 = paramString2 + "。立即加入，一起热聊！";
    }
    paramString5.putString("troop_wording", paramString1);
    paramString5.putString("bizname", "JoinTroopLink");
    QZoneShareManager.a(localQQAppInterface, paramBaseActivity, paramString5, null);
  }
  
  public static void b(BaseActivity paramBaseActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    long l = System.currentTimeMillis();
    paramBaseActivity = null;
    if (!TextUtils.isEmpty(paramString6)) {
      paramBaseActivity = a(paramString6);
    }
    paramString1 = paramBaseActivity;
    if (paramBaseActivity == null) {
      paramString1 = BitmapManager.b(BaseApplicationImpl.getApplication().getResources(), 2130842645);
    }
    if (paramString2.startsWith("邀请加入QQ热聊：")) {}
    for (paramBaseActivity = paramString2 + "。立即加入，一起热聊！";; paramBaseActivity = paramString2)
    {
      WXShareHelper.a().a(String.valueOf(l), paramBaseActivity, paramString1, paramString3, paramString5);
      return;
    }
  }
  
  public static boolean b(MessageRecord paramMessageRecord)
  {
    try
    {
      boolean bool = Boolean.valueOf(paramMessageRecord.getExtInfoFromExtStr("hotchat_flash_pic")).booleanValue();
      return bool;
    }
    catch (Exception paramMessageRecord)
    {
      paramMessageRecord.printStackTrace();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.HotChatHelper
 * JD-Core Version:    0.7.0.1
 */