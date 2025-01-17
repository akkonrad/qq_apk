package com.tencent.mobileqq.managers;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Looper;
import android.text.SpannableString;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.graytip.UniteGrayTipUtil;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.vip.CUKingCardHelper;
import com.tencent.mobileqq.vip.CUKingCardHelper.CUKingCustomDialogInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;
import mqq.manager.Manager;

public class CUOpenCardGuideMng
  implements Manager
{
  public static final String[] a;
  final CUOpenCardGuideMng.GuideConfigData a;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "entry_setting", "entry_aio_video", "entry_file", "entry_chat_audio", "entry_chat_video", "entry_kandian_video" };
  }
  
  public CUOpenCardGuideMng(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqManagersCUOpenCardGuideMng$GuideConfigData = new CUOpenCardGuideMng.GuideConfigData(paramQQAppInterface.getAccount());
  }
  
  public static CharSequence a(Context paramContext, QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    if (paramQQAppInterface != null) {}
    for (;;)
    {
      try
      {
        localObject1 = (CUOpenCardGuideMng)paramQQAppInterface.getManager(220);
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
          if (((CUOpenCardGuideMng)localObject1).a())
          {
            localObject1 = ((CUOpenCardGuideMng)localObject1).a(paramInt);
            i = 0;
            j = i;
            localObject2 = paramString;
            if (localObject1 != null)
            {
              j = i;
              localObject2 = paramString;
            }
          }
        }
      }
      catch (Exception paramQQAppInterface)
      {
        Object localObject1;
        i = 0;
      }
      try
      {
        if (!TextUtils.isEmpty(((CUOpenCardGuideMng.GuideEntry)localObject1).jdField_a_of_type_JavaLangString))
        {
          j = i;
          localObject2 = paramString;
          if (!TextUtils.isEmpty(((CUOpenCardGuideMng.GuideEntry)localObject1).b))
          {
            j = i;
            localObject2 = paramString;
            if (((CUOpenCardGuideMng.GuideEntry)localObject1).jdField_a_of_type_JavaLangString.contains(((CUOpenCardGuideMng.GuideEntry)localObject1).b))
            {
              j = i;
              localObject2 = paramString;
              if (!TextUtils.isEmpty(((CUOpenCardGuideMng.GuideEntry)localObject1).c))
              {
                String str = String.format("%s\n%s", new Object[] { paramString, ((CUOpenCardGuideMng.GuideEntry)localObject1).jdField_a_of_type_JavaLangString });
                localObject2 = new SpannableString(str);
                j = str.indexOf(((CUOpenCardGuideMng.GuideEntry)localObject1).b);
                int k = ((CUOpenCardGuideMng.GuideEntry)localObject1).b.length();
                ((SpannableString)localObject2).setSpan(new CUOpenCardGuideMng.CUOpenCardClickableSpan(paramContext, ((CUOpenCardGuideMng.GuideEntry)localObject1).c, paramQQAppInterface.c(), paramInt), j, k + j, 17);
                j = i;
              }
            }
          }
        }
        if (QLog.isColorLevel()) {
          QLog.i("CUOpenCardGuideMng", 2, String.format(Locale.getDefault(), "getGuideEntry entry: %d retCode: %d context: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(j), paramContext }));
        }
        return localObject2;
      }
      catch (Exception paramQQAppInterface)
      {
        break label301;
      }
      localObject1 = null;
      int i = 3;
      continue;
      localObject1 = ((CUOpenCardGuideMng)localObject1).a(paramInt);
      i = 0;
      continue;
      label301:
      int j = i;
      Object localObject2 = paramString;
      if (QLog.isColorLevel())
      {
        QLog.i("CUOpenCardGuideMng", 2, "getGuideEnty", paramQQAppInterface);
        j = i;
        localObject2 = paramString;
        continue;
        j = 0;
        localObject2 = paramString;
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt, boolean paramBoolean, String paramString2)
  {
    int i = NetworkUtil.a(BaseApplicationImpl.getApplication().getApplicationContext());
    Object localObject1 = null;
    long l2 = 0L;
    long l1 = 0L;
    CUKingCardHelper.CUKingCustomDialogInfo localCUKingCustomDialogInfo;
    if (i != 1)
    {
      l2 = SharedPreUtils.f(paramQQAppInterface.getApp(), paramQQAppInterface.c());
      l1 = System.currentTimeMillis();
      localCUKingCustomDialogInfo = CUKingCardHelper.a(paramString2, true, false);
      if (QLog.isColorLevel()) {
        QLog.d("CUOpenCardGuideMng", 2, "WL_DEBUG addCallGrayTip info.mPopUpType = " + localCUKingCustomDialogInfo.jdField_a_of_type_Int + ", info.mGuideJumpUrl = " + localCUKingCustomDialogInfo.jdField_a_of_type_JavaLangString);
      }
      paramString2 = (CUOpenCardGuideMng)paramQQAppInterface.getManager(220);
      if (paramString2 == null) {
        break label619;
      }
      if (!paramBoolean) {
        break label576;
      }
      paramString2 = paramString2.a(4);
    }
    for (;;)
    {
      String[] arrayOfString2;
      String[] arrayOfString1;
      Bundle localBundle;
      Object localObject3;
      Object localObject2;
      if ((paramString2 != null) && (!TextUtils.isEmpty(paramString2.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramString2.b)) && (!TextUtils.isEmpty(localCUKingCustomDialogInfo.jdField_a_of_type_JavaLangString)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("CUOpenCardGuideMng", 2, "WL_DEBUG addCallGrayTip entry.tip = " + paramString2.jdField_a_of_type_JavaLangString + ", entry.keyWord = " + paramString2.b);
        }
        arrayOfString2 = paramString2.jdField_a_of_type_JavaLangString.split("\\|");
        arrayOfString1 = paramString2.b.split("\\|");
        localBundle = null;
        localObject3 = null;
        localObject1 = localObject3;
        localObject2 = localBundle;
        if (arrayOfString2.length >= 2)
        {
          localObject1 = localObject3;
          localObject2 = localBundle;
          if (arrayOfString1.length >= 2)
          {
            if (localCUKingCustomDialogInfo.jdField_a_of_type_Int != 2) {
              break label587;
            }
            localObject2 = arrayOfString2[0];
            localObject1 = arrayOfString1[0];
          }
        }
      }
      for (;;)
      {
        if ((localObject2 != null) && (localObject1 != null))
        {
          localBundle = new Bundle();
          localBundle.putInt("key_action", 1);
          localBundle.putString("textColor", "#00a5e0");
          localBundle.putString("key_action_DATA", localCUKingCustomDialogInfo.jdField_a_of_type_JavaLangString);
          int j = ((String)localObject2).indexOf((String)localObject1);
          int k = ((String)localObject1).length();
          localObject1 = new UniteGrayTipParam(paramString1, paramQQAppInterface.c(), (String)localObject2, paramInt, -5020, 3145729, MessageCache.a());
          localObject2 = new MessageForUniteGrayTip();
          if (j >= 0) {
            ((UniteGrayTipParam)localObject1).a(j, k + j, localBundle);
          }
          ((MessageForUniteGrayTip)localObject2).initGrayTipMsg(paramQQAppInterface, (UniteGrayTipParam)localObject1);
          UniteGrayTipUtil.a(paramQQAppInterface, (MessageForUniteGrayTip)localObject2);
          ReportController.b(null, "dc00898", "", "", "0X800812A", "0X800812A", 0, 0, "", "", "", "");
          SharedPreUtils.f(paramQQAppInterface.getApp(), paramQQAppInterface.c(), System.currentTimeMillis());
        }
        localObject1 = paramString2;
        if (QLog.isColorLevel()) {
          QLog.i("CUOpenCardGuideMng", 2, "addCallGrayTip, friendUin= " + paramString1 + ",isVideoMsg=" + paramBoolean + ",netType=" + i + ",uinType=" + paramInt + ",lastAlertTime=" + l2 + ",currentTime=" + l1 + ",entry=" + localObject1);
        }
        return;
        label576:
        paramString2 = paramString2.a(3);
        break;
        label587:
        localObject1 = localObject3;
        localObject2 = localBundle;
        if (localCUKingCustomDialogInfo.jdField_a_of_type_Int == 3)
        {
          localObject2 = arrayOfString2[1];
          localObject1 = arrayOfString1[1];
        }
      }
      label619:
      paramString2 = null;
    }
  }
  
  public CUOpenCardGuideMng.GuideEntry a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CUOpenCardGuideMng", 2, String.format(Locale.getDefault(), "getGuideEntry entry: %d, isInit: %b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.jdField_a_of_type_ComTencentMobileqqManagersCUOpenCardGuideMng$GuideConfigData.jdField_a_of_type_Boolean) }));
    }
    this.jdField_a_of_type_ComTencentMobileqqManagersCUOpenCardGuideMng$GuideConfigData.a();
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_ComTencentMobileqqManagersCUOpenCardGuideMng$GuideConfigData.b)
    {
      localObject1 = localObject2;
      if (paramInt >= 0)
      {
        localObject1 = localObject2;
        if (paramInt < this.jdField_a_of_type_ComTencentMobileqqManagersCUOpenCardGuideMng$GuideConfigData.jdField_a_of_type_ArrayOfComTencentMobileqqManagersCUOpenCardGuideMng$GuideEntry.length) {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqManagersCUOpenCardGuideMng$GuideConfigData.jdField_a_of_type_ArrayOfComTencentMobileqqManagersCUOpenCardGuideMng$GuideEntry[paramInt];
        }
      }
    }
    return localObject1;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqManagersCUOpenCardGuideMng$GuideConfigData.a();
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CUOpenCardGuideMng", 2, String.format(Locale.getDefault(), "onGetConfig isInit: %b, config: %s", new Object[] { Boolean.valueOf(this.jdField_a_of_type_ComTencentMobileqqManagersCUOpenCardGuideMng$GuideConfigData.jdField_a_of_type_Boolean), paramString }));
    }
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    paramString = BaseApplicationImpl.getApplication().getSharedPreferences("ChinaUnicomPhoneCard" + this.jdField_a_of_type_ComTencentMobileqqManagersCUOpenCardGuideMng$GuideConfigData.jdField_a_of_type_JavaLangString, 4).edit();
    paramString.putString("config_content", str);
    paramString.commit();
    this.jdField_a_of_type_ComTencentMobileqqManagersCUOpenCardGuideMng$GuideConfigData.a(str);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqManagersCUOpenCardGuideMng$GuideConfigData.jdField_a_of_type_Boolean;
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.i("CUOpenCardGuideMng", 2, "onDestroy");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.managers.CUOpenCardGuideMng
 * JD-Core Version:    0.7.0.1
 */