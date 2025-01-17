package com.tencent.mobileqq.profile.view;

import agrm;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.atomic.AtomicBoolean;

public class ProfileHeaderView$UpdateProfileSetCardTask
  implements Runnable
{
  WeakReference a;
  
  ProfileHeaderView$UpdateProfileSetCardTask(ProfileHeaderView paramProfileHeaderView)
  {
    this.a = new WeakReference(paramProfileHeaderView);
  }
  
  public void run()
  {
    ProfileHeaderView localProfileHeaderView = (ProfileHeaderView)this.a.get();
    if (localProfileHeaderView != null) {
      for (;;)
      {
        try
        {
          Object localObject1 = localProfileHeaderView.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo;
          QQAppInterface localQQAppInterface = localProfileHeaderView.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          long l1 = ((ProfileCardInfo)localObject1).jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId;
          long l2 = ((ProfileCardInfo)localObject1).jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentBgId;
          int i = ((ProfileCardInfo)localObject1).jdField_a_of_type_ComTencentMobileqqDataCard.templateRet;
          Object localObject2 = ((ProfileCardInfo)localObject1).jdField_a_of_type_ComTencentMobileqqDataCard.getBgTypeArray();
          SharedPreferences localSharedPreferences = localQQAppInterface.getApp().getSharedPreferences("ProfileCardTips" + localQQAppInterface.getCurrentAccountUin(), 0);
          String str = ((ProfileCardInfo)localObject1).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
          if ((ProfileCardUtil.d((ArrayList)localObject2)) || (((ProfileCardInfo)localObject1).jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentBgId == 160L))
          {
            localProfileHeaderView.h &= 0xFFFFFFFD;
            localProfileHeaderView.b.set(true);
            if (QLog.isColorLevel()) {
              QLog.d(ProfileHeaderView.jdField_a_of_type_JavaLangString, 2, "updateSetCardBar isSpecilaBg");
            }
            if (!localProfileHeaderView.b.get()) {
              break;
            }
            ProfileHeaderView.a(localProfileHeaderView);
            return;
          }
          if ((str == null) || (l2 <= 0L) || (l1 <= 0L) || (i != 0)) {
            break label450;
          }
          localObject1 = new SimpleDateFormat("yyyyMMdd").format(new Date(System.currentTimeMillis()));
          localObject2 = ((FriendsManager)localQQAppInterface.getManager(50)).a(localQQAppInterface.getCurrentAccountUin());
          if (localObject2 != null)
          {
            l1 = ((Card)localObject2).lCurrentBgId;
            localObject2 = localSharedPreferences.getString(String.valueOf(l2), "");
            if (QLog.isColorLevel()) {
              QLog.d(ProfileHeaderView.jdField_a_of_type_JavaLangString, 2, "updateSetCardBar today=" + (String)localObject1 + ",userLastAccessDay=" + (String)localObject2 + ",friendBackgroundId=" + l2 + ",myBackgroundId=" + l1);
            }
            if ((TextUtils.isEmpty((CharSequence)localObject1)) || (((String)localObject1).equals(localObject2)) || (l1 == l2)) {
              break label438;
            }
            localSharedPreferences.edit().putString(String.valueOf(l2), (String)localObject1).commit();
            localProfileHeaderView.h |= 0x2;
            localQQAppInterface.runOnUiThread(new agrm(this, localProfileHeaderView));
            continue;
          }
          l1 = 0L;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          return;
        }
        continue;
        label438:
        localException.b.set(true);
        continue;
        label450:
        localException.b.set(true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.ProfileHeaderView.UpdateProfileSetCardTask
 * JD-Core Version:    0.7.0.1
 */