package com.tencent.biz.eqq;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.biz.ProtoServlet;
import com.tencent.biz.bmqq.util.BmqqSegmentUtil;
import com.tencent.biz.pubaccount.AccountDetail.activity.EqqAccountDetailActivity;
import com.tencent.biz.pubaccount.PublicAccountServlet;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.PlusPanelUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.EqqDetailDataManager;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.EqqDetail;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.FollowRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.GetEqqDetailInfoRequest;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.qidian.QidianManager;
import com.tencent.qidian.QidianProfileCardActivity;
import com.tencent.qidian.controller.QidianHandler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.regex.Pattern;
import kmb;
import kmc;
import kmd;
import kme;
import mqq.app.NewIntent;
import mqq.manager.Manager;
import mqq.manager.TicketManager;
import mqq.observer.BusinessObserver;
import mqq.os.MqqHandler;

public class CrmUtils
{
  public static final Pattern a;
  public static final boolean a;
  
  static
  {
    jdField_a_of_type_JavaUtilRegexPattern = Pattern.compile("QQ语音");
    jdField_a_of_type_Boolean = a();
  }
  
  public static int a(QQAppInterface paramQQAppInterface, String paramString)
  {
    int j = 0;
    Object localObject = (PublicAccountDataManager)paramQQAppInterface.getManager(55);
    int i = j;
    if (localObject != null)
    {
      localObject = ((PublicAccountDataManager)localObject).c(paramString);
      if (localObject != null) {
        break label69;
      }
      paramQQAppInterface = (EqqDetailDataManager)paramQQAppInterface.getManager(68);
      if (paramQQAppInterface == null) {
        break label84;
      }
      paramQQAppInterface = paramQQAppInterface.a(paramString);
      if ((paramQQAppInterface == null) || (paramQQAppInterface.certifiedGrade <= 0)) {
        break label84;
      }
      i = 2130839751;
    }
    for (;;)
    {
      return i;
      label69:
      i = j;
      if (((PublicAccountInfo)localObject).certifiedGrade > 0L)
      {
        return 2130839751;
        label84:
        i = 0;
      }
    }
  }
  
  /* Error */
  public static int a(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: ldc 63
    //   5: invokevirtual 69	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   8: astore_0
    //   9: iconst_0
    //   10: istore_1
    //   11: iload_1
    //   12: istore_3
    //   13: iload_2
    //   14: aload_0
    //   15: arraylength
    //   16: if_icmpge +51 -> 67
    //   19: iload_1
    //   20: i2l
    //   21: lstore 4
    //   23: iconst_3
    //   24: iload_2
    //   25: isub
    //   26: i2l
    //   27: lstore 6
    //   29: aload_0
    //   30: iload_2
    //   31: aaload
    //   32: invokestatic 75	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   35: lstore 8
    //   37: lload 4
    //   39: ldc2_w 76
    //   42: lload 6
    //   44: lload 8
    //   46: lmul
    //   47: lxor
    //   48: ladd
    //   49: l2i
    //   50: istore_1
    //   51: iload_2
    //   52: iconst_1
    //   53: iadd
    //   54: istore_2
    //   55: goto -44 -> 11
    //   58: astore_0
    //   59: iconst_0
    //   60: istore_1
    //   61: aload_0
    //   62: invokevirtual 80	java/lang/Exception:printStackTrace	()V
    //   65: iload_1
    //   66: istore_3
    //   67: iload_3
    //   68: ireturn
    //   69: astore_0
    //   70: goto -9 -> 61
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	paramString	String
    //   10	56	1	i	int
    //   1	54	2	j	int
    //   12	56	3	k	int
    //   21	17	4	l1	long
    //   27	16	6	l2	long
    //   35	10	8	l3	long
    // Exception table:
    //   from	to	target	type
    //   2	9	58	java/lang/Exception
    //   13	19	69	java/lang/Exception
    //   29	37	69	java/lang/Exception
  }
  
  public static Intent a(Context paramContext, Intent paramIntent, String paramString, boolean paramBoolean1, int paramInt1, boolean paramBoolean2, int paramInt2)
  {
    try
    {
      bool = ((QidianManager)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(164)).c(paramString, false);
      if (bool) {
        if (paramIntent == null)
        {
          paramIntent = new Intent(paramContext, QidianProfileCardActivity.class);
          if (!TextUtils.isEmpty(paramString)) {
            paramIntent.putExtra("uin", paramString);
          }
          paramIntent.putExtra("AllInOne", new ProfileActivity.AllInOne(paramString, 19));
          paramIntent.putExtra("need_finish", paramBoolean1);
          paramIntent.putExtra("uintype", 1024);
          paramIntent.addFlags(67108864);
          if (paramInt1 != -1) {
            paramIntent.putExtra("source", paramInt1);
          }
        }
      }
      try
      {
        AppInterface localAppInterface = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
        switch (paramInt1)
        {
        }
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
          continue;
          if ((paramContext instanceof Activity)) {
            ((Activity)paramContext).startActivityForResult(paramIntent, paramInt2);
          }
        }
      }
      if (paramBoolean2)
      {
        if (paramInt2 != -1) {
          break label266;
        }
        paramContext.startActivity(paramIntent);
        if ((paramContext instanceof Activity)) {
          ((Activity)paramContext).overridePendingTransition(2131034132, 2131034133);
        }
      }
      return paramIntent;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        boolean bool = false;
        continue;
        paramIntent.setClassName(paramContext, QidianProfileCardActivity.class.getName());
        continue;
        if (paramIntent == null)
        {
          paramIntent = new Intent(paramContext, EqqAccountDetailActivity.class);
        }
        else
        {
          paramIntent.setClassName(paramContext, EqqAccountDetailActivity.class.getName());
          continue;
          PublicAccountHandler.a(localException, paramString, "Pb_account_lifeservice", "mp_msg_sys_2", "detail");
        }
      }
    }
  }
  
  public static InputStream a(Bitmap paramBitmap)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream);
    return new ByteArrayInputStream(localByteArrayOutputStream.toByteArray());
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString)
  {
    String str = "";
    if (!TextUtils.isEmpty(paramString)) {
      if (QidianManager.b(paramQQAppInterface, paramString))
      {
        paramQQAppInterface = ((FriendsManager)paramQQAppInterface.getManager(50)).a(paramString);
        if (paramQQAppInterface == null) {
          break label190;
        }
        paramQQAppInterface = paramQQAppInterface.getFriendName();
      }
    }
    for (;;)
    {
      return paramQQAppInterface;
      Object localObject = paramQQAppInterface.getManager(55);
      if (localObject != null)
      {
        localObject = ((PublicAccountDataManager)localObject).c(paramString);
        if (localObject != null) {
          return ((PublicAccountInfo)localObject).name;
        }
        paramQQAppInterface = paramQQAppInterface.getManager(68);
        if (paramQQAppInterface != null)
        {
          paramQQAppInterface = ((EqqDetailDataManager)paramQQAppInterface).a(paramString);
          if (paramQQAppInterface != null) {
            return paramQQAppInterface.name;
          }
          paramQQAppInterface = str;
          if (QLog.isColorLevel())
          {
            QLog.d("CrmUtils", 2, String.format("We can't find %s from EqqCache", new Object[] { paramString }));
            return "";
          }
        }
        else
        {
          paramQQAppInterface = str;
          if (QLog.isColorLevel())
          {
            QLog.e("CrmUtils", 2, "Get EqqDetailDataManager error");
            return "";
          }
        }
      }
      else
      {
        paramQQAppInterface = str;
        if (QLog.isColorLevel())
        {
          QLog.e("CrmUtils", 2, "Get PublicAccountDataManager error");
          return "";
          paramQQAppInterface = str;
          if (QLog.isColorLevel())
          {
            QLog.d("CrmUtils", 2, "We can't get name, because uin is null");
            return "";
            label190:
            paramQQAppInterface = "";
          }
        }
      }
    }
  }
  
  private static void a(int paramInt, QQProgressDialog paramQQProgressDialog)
  {
    b(paramInt, paramQQProgressDialog);
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    Toast.makeText(paramContext, paramInt, 0).show();
  }
  
  public static void a(Context paramContext, String paramString)
  {
    try
    {
      paramContext = paramContext.getSharedPreferences(paramString + "_customer_transfer_sharepreference", 0).edit();
      paramContext.clear();
      paramContext.commit();
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    if (!jdField_a_of_type_Boolean) {
      if (QLog.isDevelopLevel()) {
        QLog.d("IVR_TS_CrmUtils", 4, "Don't support sharp");
      }
    }
    do
    {
      return;
      if ((VcSystemInfo.c()) && (VcSystemInfo.d()))
      {
        ActionSheet localActionSheet = ActionSheet.a(paramContext);
        localActionSheet.b(2131433828);
        localActionSheet.c(2131433015);
        localActionSheet.a(new kme(localActionSheet, paramQQAppInterface, paramContext, paramSessionInfo));
        localActionSheet.show();
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("CrmUtils", 2, String.format("We needn't show video action sheet, because Sharp Audio is not supported", new Object[0]));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, String paramString)
  {
    QQProgressDialog localQQProgressDialog = null;
    if (QLog.isDevelopLevel()) {
      QLog.d("IVR_TS_CrmUtils", 4, ">>>ivrAudio2(), ts=" + System.currentTimeMillis());
    }
    if (QidianManager.b(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString)) {
      c(paramQQAppInterface, paramContext, paramSessionInfo, paramString);
    }
    for (;;)
    {
      return;
      Object localObject = (PublicAccountDataManager)paramQQAppInterface.getManager(55);
      mobileqq_mp.GetEqqDetailInfoRequest localGetEqqDetailInfoRequest;
      if (localObject != null)
      {
        localObject = ((PublicAccountDataManager)localObject).c(paramSessionInfo.jdField_a_of_type_JavaLangString);
        if (localObject == null)
        {
          localObject = (EqqDetailDataManager)paramQQAppInterface.getManager(68);
          if (localObject != null)
          {
            localObject = ((EqqDetailDataManager)localObject).a(paramSessionInfo.jdField_a_of_type_JavaLangString);
            if (localObject == null)
            {
              if (QLog.isDevelopLevel()) {
                QLog.d("IVR_TS_CrmUtils", 4, ">>>begin getDetail, ts=" + System.currentTimeMillis());
              }
              if ((paramContext instanceof Activity)) {
                localQQProgressDialog = new QQProgressDialog(paramContext, paramContext.getResources().getDimensionPixelSize(2131558448));
              }
              if (localQQProgressDialog != null) {
                localQQProgressDialog.setCanceledOnTouchOutside(true);
              }
              if (QLog.isColorLevel()) {
                QLog.d("CrmUtils", 2, "sendDetailInfoRequest");
              }
              localObject = new NewIntent(paramContext.getApplicationContext(), ProtoServlet.class);
              ((NewIntent)localObject).putExtra("cmd", "EqqAccountSvc.get_eqq_detail");
              localGetEqqDetailInfoRequest = new mobileqq_mp.GetEqqDetailInfoRequest();
              localGetEqqDetailInfoRequest.version.set(2);
              localGetEqqDetailInfoRequest.seqno.set(0);
            }
          }
        }
      }
      try
      {
        localGetEqqDetailInfoRequest.eqq_id.set((int)Long.parseLong(paramSessionInfo.jdField_a_of_type_JavaLangString));
        label280:
        ((NewIntent)localObject).putExtra("data", localGetEqqDetailInfoRequest.toByteArray());
        ((NewIntent)localObject).setObserver(new kmc(paramContext, paramQQAppInterface, localQQProgressDialog, paramSessionInfo, paramString));
        paramQQAppInterface.startServlet((NewIntent)localObject);
        try
        {
          if ((!(paramContext instanceof Activity)) || (((Activity)paramContext).isFinishing())) {
            continue;
          }
          a(2131430029, localQQProgressDialog);
          return;
        }
        catch (Exception paramQQAppInterface)
        {
          return;
        }
        b(paramQQAppInterface, paramContext, paramSessionInfo, null, (EqqDetail)localObject, paramString);
        return;
        a(paramContext, 2131430033);
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X80049DF", "GetDetailFalse", 0, 0, "", "", "", "");
        return;
        b(paramQQAppInterface, paramContext, paramSessionInfo, (PublicAccountInfo)localObject, null, paramString);
        return;
        a(paramContext, 2131430033);
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X80049DF", "GetDetailFalse", 0, 0, "", "", "", "");
        return;
      }
      catch (Exception localException)
      {
        break label280;
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, int paramInt, BusinessObserver paramBusinessObserver)
  {
    mobileqq_mp.GetEqqDetailInfoRequest localGetEqqDetailInfoRequest;
    if (!c(paramQQAppInterface, paramString, paramInt))
    {
      paramContext = new NewIntent(paramContext.getApplicationContext(), ProtoServlet.class);
      paramContext.putExtra("cmd", "EqqAccountSvc.get_eqq_detail");
      localGetEqqDetailInfoRequest = new mobileqq_mp.GetEqqDetailInfoRequest();
      localGetEqqDetailInfoRequest.version.set(2);
      localGetEqqDetailInfoRequest.seqno.set(0);
    }
    try
    {
      localGetEqqDetailInfoRequest.eqq_id.set((int)Long.parseLong(paramString));
      label75:
      paramContext.putExtra("data", localGetEqqDetailInfoRequest.toByteArray());
      paramContext.setObserver(paramBusinessObserver);
      paramQQAppInterface.startServlet(paramContext);
      return;
    }
    catch (Exception paramString)
    {
      break label75;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2)
  {
    if (!jdField_a_of_type_Boolean)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("IVR_TS_CrmUtils", 4, "Don't support sharp");
      }
      return;
    }
    SessionInfo localSessionInfo = new SessionInfo();
    localSessionInfo.jdField_a_of_type_Int = 1024;
    localSessionInfo.d = paramString2;
    localSessionInfo.jdField_a_of_type_JavaLangString = paramString1;
    a(paramQQAppInterface, paramContext, localSessionInfo);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("IVR_TS_CrmUtils", 4, ">>>ivrAudio1(), ts=" + System.currentTimeMillis());
    }
    SessionInfo localSessionInfo = new SessionInfo();
    localSessionInfo.jdField_a_of_type_Int = 1024;
    localSessionInfo.d = paramString1;
    localSessionInfo.jdField_a_of_type_JavaLangString = paramString2;
    a(paramQQAppInterface, paramContext, localSessionInfo, paramString3);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, EqqDetail paramEqqDetail)
  {
    ThreadManager.getFileThreadHandler().post(new kmb(paramQQAppInterface, paramEqqDetail));
  }
  
  public static boolean a()
  {
    boolean bool = true;
    new VcSystemInfo();
    VcSystemInfo.a();
    int i = VcSystemInfo.f();
    long l = VcSystemInfo.c();
    int j = Build.VERSION.SDK_INT;
    if ((i < 3) || (l / 1000L < 800L) || (j < 9))
    {
      if (QLog.isColorLevel()) {
        QLog.d("CrmUtils", 2, "User don't support sharp!");
      }
      bool = false;
    }
    return bool;
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt & 0x1) != 0;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface == null) || (paramString == null)) {
      return false;
    }
    paramQQAppInterface = (PublicAccountDataManager)paramQQAppInterface.getManager(55);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.c(paramString);
      if ((paramQQAppInterface != null) && (paramQQAppInterface.extendType == 2)) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    long l1 = System.currentTimeMillis();
    if (QLog.isDevelopLevel()) {
      QLog.d("IVR_TS_CrmUtils", 4, ">>>hasIvrAbility(), ts=" + l1);
    }
    boolean bool2;
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("CrmUtils", 2, "app is null or uin is empty");
      }
      bool2 = false;
      return bool2;
    }
    boolean bool1;
    if (paramInt == 1024)
    {
      Object localObject = paramQQAppInterface.getManager(55);
      if (localObject != null)
      {
        localObject = ((PublicAccountDataManager)localObject).c(paramString);
        if (localObject != null) {}
        for (bool1 = ((PublicAccountInfo)localObject).hasIvrAbility();; bool1 = paramQQAppInterface.hasIvrAbility())
        {
          if (QLog.isColorLevel()) {
            QLog.d("CrmUtils", 2, String.format("Check %s hasIvrAbility end, the result is %b", new Object[] { paramString, Boolean.valueOf(bool1) }));
          }
          long l2 = System.currentTimeMillis();
          bool2 = bool1;
          if (!QLog.isDevelopLevel()) {
            break;
          }
          QLog.d("IVR_TS_CrmUtils", 4, "<<<hasIvrAbility(), ts=" + l2);
          QLog.d("IVR_TS_CrmUtils", 4, String.format("hasIvrAbility(), cost=%dms", new Object[] { Long.valueOf(l2 - l1) }));
          return bool1;
          if (QLog.isColorLevel()) {
            QLog.d("CrmUtils", 2, String.format("We cant find %s in public account cache", new Object[] { paramString }));
          }
          paramQQAppInterface = paramQQAppInterface.getManager(68);
          if (paramQQAppInterface == null) {
            break label309;
          }
          paramQQAppInterface = ((EqqDetailDataManager)paramQQAppInterface).a(paramString);
          if (paramQQAppInterface == null) {
            break label278;
          }
        }
        label278:
        if (QLog.isColorLevel()) {
          QLog.d("CrmUtils", 2, String.format("We can't find %s from EqqCache", new Object[] { paramString }));
        }
      }
    }
    for (;;)
    {
      bool1 = false;
      break;
      label309:
      if (QLog.isColorLevel())
      {
        QLog.e("CrmUtils", 2, "Get EqqDetailDataManager error");
        continue;
        if (QLog.isColorLevel())
        {
          QLog.e("CrmUtils", 2, "Get PublicAccountDataManager error");
          continue;
          if (QLog.isColorLevel()) {
            QLog.d("CrmUtils", 2, String.format("uin %s isn't crmqq or now session type isn't crm", new Object[] { paramString }));
          }
        }
      }
    }
  }
  
  public static int b(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface != null) && (BmqqSegmentUtil.a(paramString)) && (BmqqSegmentUtil.b(paramString)))
    {
      paramQQAppInterface = (FriendsManager)paramQQAppInterface.getManager(50);
      if ((paramQQAppInterface != null) && (paramQQAppInterface.b(paramString))) {
        return 0;
      }
      return 1025;
    }
    return 1024;
  }
  
  public static String b(QQAppInterface paramQQAppInterface, String paramString)
  {
    String str = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      if (!QidianManager.b(paramQQAppInterface, paramString)) {
        break label25;
      }
      str = QidianManager.a(paramQQAppInterface, paramString);
    }
    label25:
    do
    {
      do
      {
        Object localObject;
        do
        {
          do
          {
            return str;
            localObject = paramQQAppInterface.getManager(55);
            str = paramString;
          } while (localObject == null);
          localObject = ((PublicAccountDataManager)localObject).c(paramString);
          if (localObject == null) {
            break;
          }
          str = paramString;
        } while (((PublicAccountInfo)localObject).extendType != 2);
        return ((PublicAccountInfo)localObject).name;
        paramQQAppInterface = paramQQAppInterface.getManager(68);
        str = paramString;
      } while (paramQQAppInterface == null);
      paramQQAppInterface = ((EqqDetailDataManager)paramQQAppInterface).a(paramString);
      str = paramString;
    } while (paramQQAppInterface == null);
    return paramQQAppInterface.name;
  }
  
  private static void b(int paramInt, QQProgressDialog paramQQProgressDialog)
  {
    if (paramQQProgressDialog != null)
    {
      paramQQProgressDialog.c(paramInt);
      paramQQProgressDialog.show();
    }
  }
  
  private static void b(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, PublicAccountInfo paramPublicAccountInfo, EqqDetail paramEqqDetail, String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("IVR_TS_CrmUtils", 4, ">>>ivrAudio3(), ts=" + System.currentTimeMillis());
    }
    boolean bool;
    int i;
    if (paramPublicAccountInfo != null)
    {
      bool = paramPublicAccountInfo.hasIvrAbility();
      i = 1;
    }
    for (;;)
    {
      if (bool)
      {
        if (i != 0) {
          break label321;
        }
        if (QLog.isDevelopLevel()) {
          QLog.d("IVR_TS_CrmUtils", 4, ">>>begin follow, ts=" + System.currentTimeMillis());
        }
        paramPublicAccountInfo = null;
        if ((paramContext instanceof Activity)) {
          paramPublicAccountInfo = new QQProgressDialog(paramContext, paramContext.getResources().getDimensionPixelSize(2131558448));
        }
        if (paramPublicAccountInfo != null) {
          paramPublicAccountInfo.setCanceledOnTouchOutside(true);
        }
        NewIntent localNewIntent = new NewIntent(paramContext.getApplicationContext(), PublicAccountServlet.class);
        localNewIntent.putExtra("cmd", "follow");
        mobileqq_mp.FollowRequest localFollowRequest = new mobileqq_mp.FollowRequest();
        localFollowRequest.uin.set((int)Long.parseLong(paramEqqDetail.uin));
        localFollowRequest.account_type.set(2);
        localNewIntent.putExtra("data", localFollowRequest.toByteArray());
        localNewIntent.setObserver(new kmd(paramContext, paramQQAppInterface, paramPublicAccountInfo, paramEqqDetail, paramSessionInfo, paramString));
        paramQQAppInterface.startServlet(localNewIntent);
      }
      try
      {
        if (((paramContext instanceof Activity)) && (!((Activity)paramContext).isFinishing())) {
          a(2131430029, paramPublicAccountInfo);
        }
        label257:
        if (QLog.isColorLevel()) {
          QLog.d("CrmUtils", 2, "follow exit");
        }
        do
        {
          return;
          if (paramEqqDetail != null)
          {
            bool = paramEqqDetail.hasIvrAbility();
            if (paramEqqDetail.followType != 0)
            {
              i = 1;
              break;
            }
            i = 0;
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.w("CrmUtils", 2, "Both PublicAccountInfo and EqqDetail is NULL!");
        return;
        label321:
        c(paramQQAppInterface, paramContext, paramSessionInfo, paramString);
        return;
      }
      catch (Exception paramQQAppInterface)
      {
        break label257;
      }
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2)
  {
    Object localObject = (TicketManager)paramQQAppInterface.getManager(2);
    if (localObject == null) {}
    for (localObject = null; (localObject == null) || (((String)localObject).length() == 0); localObject = ((TicketManager)localObject).getStweb(paramQQAppInterface.getCurrentAccountUin()))
    {
      new QQToastNotifier(paramContext).a(2131435795, paramContext.getResources().getDimensionPixelSize(2131558448), 0, 1);
      return;
    }
    paramString1 = String.format("http://ptlogin2.qq.com/qidian_client?pt_clientver=5428&pt_src=1&clientuin=%s&clientkey=%s&keyindex=19&jump=30&kfuin=%s&kfext=%s&buildver=1.0.0.0&inter=1&_wv=1027", new Object[] { paramQQAppInterface.getCurrentAccountUin(), localObject, paramString1, paramString2 });
    if (QLog.isColorLevel()) {
      QLog.d("CrmUtils", 2, "enterLightTalk() url = " + paramString1);
    }
    paramString2 = new Intent(paramContext, QQBrowserActivity.class);
    paramString2.putExtra("uin", paramQQAppInterface.getCurrentAccountUin());
    paramString2.putExtra("url", paramString1);
    paramString2.putExtra("hide_more_button", true);
    paramContext.startActivity(paramString2);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, EqqDetail paramEqqDetail)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CrmUtils", 2, "saveCache");
    }
    EqqDetailDataManager localEqqDetailDataManager = (EqqDetailDataManager)paramQQAppInterface.getManager(68);
    if (localEqqDetailDataManager != null) {
      localEqqDetailDataManager.a(paramEqqDetail);
    }
    if ((paramEqqDetail != null) && (paramEqqDetail.followType == 1))
    {
      paramQQAppInterface = (PublicAccountDataManager)paramQQAppInterface.getManager(55);
      if (paramQQAppInterface != null) {
        paramQQAppInterface.a(PublicAccountInfo.createPublicAccount(paramEqqDetail, 0L));
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("CrmUtils", 2, "saveCache exit");
    }
  }
  
  private static void b(QQProgressDialog paramQQProgressDialog)
  {
    if ((paramQQProgressDialog != null) && (paramQQProgressDialog.isShowing())) {
      paramQQProgressDialog.dismiss();
    }
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface == null) || (paramString == null)) {
      return false;
    }
    Object localObject = (PublicAccountDataManager)paramQQAppInterface.getManager(55);
    if (localObject != null)
    {
      localObject = ((PublicAccountDataManager)localObject).c(paramString);
      if ((localObject != null) && (((PublicAccountInfo)localObject).extendType == 2)) {
        return true;
      }
    }
    paramQQAppInterface = (EqqDetailDataManager)paramQQAppInterface.getManager(68);
    return (paramQQAppInterface != null) && (paramQQAppInterface.a(paramString) != null);
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1024)) {
      return false;
    }
    Object localObject;
    boolean bool1;
    if (!TextUtils.isEmpty(paramString))
    {
      localObject = paramQQAppInterface.getManager(55);
      if (localObject != null)
      {
        localObject = ((PublicAccountDataManager)localObject).c(paramString);
        if (localObject != null)
        {
          if (((PublicAccountInfo)localObject).extendType != 2) {
            break label125;
          }
          bool1 = true;
          bool2 = bool1;
          if (!bool1)
          {
            bool2 = bool1;
            if (paramInt == 0)
            {
              bool2 = c(paramQQAppInterface, paramString);
              if (!QidianManager.b(paramQQAppInterface, paramString)) {}
            }
          }
        }
      }
    }
    for (boolean bool2 = false;; bool2 = false)
    {
      return bool2;
      localObject = paramQQAppInterface.getManager(68);
      if ((localObject != null) && (((EqqDetailDataManager)localObject).a(paramString) != null))
      {
        bool1 = true;
        break;
      }
      label125:
      bool1 = false;
      break;
    }
  }
  
  private static void c(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("IVR_TS_CrmUtils", 4, ">>>startVideo(), ts=" + System.currentTimeMillis());
    }
    String str = paramSessionInfo.jdField_a_of_type_JavaLangString;
    if ((paramQQAppInterface.c()) && (str != null) && (str.equals(paramQQAppInterface.a().c()))) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8004628", "0X8004628", 0, 0, "", "", "", "");
      }
      if (paramSessionInfo.jdField_a_of_type_Int != 1008) {
        paramSessionInfo.jdField_a_of_type_Int = 1024;
      }
      PlusPanelUtils.a(paramQQAppInterface, paramContext, paramSessionInfo, true, paramString, null);
      return;
    }
  }
  
  public static void c(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2)
  {
    if (!((FriendsManager)paramQQAppInterface.getManager(50)).b(paramString2)) {}
    for (;;)
    {
      return;
      try
      {
        if (!paramContext.getSharedPreferences(paramString1 + "_customer_transfer_sharepreference", 0).getBoolean(paramString1 + "_" + paramString2, false))
        {
          ((QidianHandler)paramQQAppInterface.a(85)).a(Long.valueOf(paramString1).longValue(), Long.valueOf(paramString2).longValue());
          return;
        }
      }
      catch (Exception paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
      }
    }
  }
  
  public static boolean c(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (!BmqqSegmentUtil.a(paramString)) {
      return false;
    }
    paramQQAppInterface = ((FriendsManager)paramQQAppInterface.getManager(50)).a(paramString);
    if ((paramQQAppInterface != null) && (a(paramQQAppInterface.cSpecialFlag))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private static boolean c(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    boolean bool2;
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("CrmUtils", 2, "app is null or uin is empty");
      }
      bool2 = false;
      return bool2;
    }
    boolean bool1;
    if (paramInt == 1024)
    {
      Manager localManager = paramQQAppInterface.getManager(55);
      if (localManager != null)
      {
        if (((PublicAccountDataManager)localManager).c(paramString) != null) {}
        for (bool1 = true;; bool1 = true)
        {
          bool2 = bool1;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("CrmUtils", 2, String.format("Check %s isContainUinInfo end, the result is %b", new Object[] { paramString, Boolean.valueOf(bool1) }));
          return bool1;
          if (QLog.isColorLevel()) {
            QLog.d("CrmUtils", 2, String.format("We cant find %s in public account cache", new Object[] { paramString }));
          }
          paramQQAppInterface = paramQQAppInterface.getManager(68);
          if (paramQQAppInterface == null) {
            break label187;
          }
          if (((EqqDetailDataManager)paramQQAppInterface).a(paramString) == null) {
            break label157;
          }
        }
        label157:
        if (QLog.isColorLevel()) {
          QLog.d("CrmUtils", 2, String.format("We can't find %s from EqqCache", new Object[] { paramString }));
        }
      }
    }
    for (;;)
    {
      bool1 = false;
      break;
      label187:
      if (QLog.isColorLevel())
      {
        QLog.e("CrmUtils", 2, "Get EqqDetailDataManager error");
        continue;
        if (QLog.isColorLevel())
        {
          QLog.e("CrmUtils", 2, "Get PublicAccountDataManager error");
          continue;
          if (QLog.isColorLevel()) {
            QLog.d("CrmUtils", 2, String.format("uin %s isn't crmqq or now session type isn't crm", new Object[] { paramString }));
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.eqq.CrmUtils
 * JD-Core Version:    0.7.0.1
 */