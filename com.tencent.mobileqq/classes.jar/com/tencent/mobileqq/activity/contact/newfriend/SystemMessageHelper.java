package com.tencent.mobileqq.activity.contact.newfriend;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.KplRoleInfo.WZRYUIinfo;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class SystemMessageHelper
{
  public static boolean a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, long paramLong, int paramInt1, int paramInt2, Intent paramIntent)
  {
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "Verify_msg", "Verify_msg_prof", 0, 0, "", "", "", "");
    if (QLog.isColorLevel()) {
      QLog.d("SystemMessageHelper", 2, "openProfileCard | sourceId = " + paramInt2);
    }
    paramQQAppInterface = (FriendsManager)paramQQAppInterface.getManager(50);
    if (paramQQAppInterface != null) {}
    for (boolean bool = paramQQAppInterface.b(paramString);; bool = false)
    {
      if (bool) {
        if (ProfileActivity.e(paramInt2))
        {
          paramQQAppInterface = new ProfileActivity.AllInOne(paramString, 91);
          paramQQAppInterface.h = 109;
          ProfileActivity.b(paramContext, paramQQAppInterface);
        }
      }
      for (;;)
      {
        return true;
        paramQQAppInterface = new ProfileActivity.AllInOne(paramString, 1);
        break;
        if (ProfileActivity.e(paramInt2))
        {
          paramQQAppInterface = new ProfileActivity.AllInOne(paramString, 92);
          paramQQAppInterface.h = 112;
          paramQQAppInterface.i = paramInt2;
          paramQQAppInterface.jdField_d_of_type_Int = 1;
          if (paramInt1 == 6) {
            paramQQAppInterface.jdField_d_of_type_Int = 0;
          }
          ProfileActivity.b(paramContext, paramQQAppInterface);
        }
        else
        {
          Bundle localBundle = null;
          paramQQAppInterface = localBundle;
          if (paramIntent != null)
          {
            paramQQAppInterface = localBundle;
            if (paramIntent.hasExtra("param_wzry_data")) {
              paramQQAppInterface = (KplRoleInfo.WZRYUIinfo)paramIntent.getSerializableExtra("param_wzry_data");
            }
          }
          switch (paramInt1)
          {
          default: 
            if ((paramInt2 != 3007) && (paramInt2 != 3019) && (paramInt2 != 2007) && (paramInt2 != 4007) && (paramInt2 != 2019)) {
              break label838;
            }
            paramQQAppInterface = new ProfileActivity.AllInOne(paramString, 25);
            paramQQAppInterface.h = 109;
            if ((paramInt2 != 3007) && (paramInt2 != 2007) && (paramInt2 != 4007)) {
              break;
            }
          }
          for (paramQQAppInterface.h = 14;; paramQQAppInterface.h = 15) {
            do
            {
              paramString = new Bundle();
              paramString.putInt("param_mode", 3);
              paramString.putParcelable("sysInfoExtres", paramIntent);
              NearbyPeopleProfileActivity.a(paramContext, paramQQAppInterface, paramString);
              break;
              if ((paramInt2 == 3007) || (paramInt2 == 3019) || (paramInt2 == 2007) || (paramInt2 == 2019) || (paramInt2 == 4007))
              {
                paramQQAppInterface = new ProfileActivity.AllInOne(paramString, 28);
                paramQQAppInterface.h = 109;
                if ((paramInt2 == 3007) || (paramInt2 == 2007) || (paramInt2 == 4007)) {}
                for (paramQQAppInterface.h = 14;; paramQQAppInterface.h = 15) {
                  do
                  {
                    paramString = new Bundle();
                    paramString.putInt("param_mode", 3);
                    paramString.putParcelable("sysInfoExtres", paramIntent);
                    NearbyPeopleProfileActivity.a(paramContext, paramQQAppInterface, paramString);
                    break;
                  } while ((paramInt2 != 3019) && (paramInt2 != 2019));
                }
              }
              paramString = new ProfileActivity.AllInOne(paramString, 28);
              paramString.h = 109;
              paramString.i = paramInt2;
              paramString.jdField_d_of_type_JavaLangString = String.valueOf(paramLong);
              localBundle = new Bundle();
              localBundle.putParcelable("sysInfoExtres", paramIntent);
              if (paramQQAppInterface != null) {
                paramString.a.putSerializable("param_wzry_data", paramQQAppInterface);
              }
              ProfileActivity.a(paramContext, paramString, localBundle);
              break;
              if ((paramInt2 == 3007) || (paramInt2 == 3019) || (paramInt2 == 2007) || (paramInt2 == 4007) || (paramInt2 == 2019))
              {
                paramQQAppInterface = new ProfileActivity.AllInOne(paramString, 25);
                paramQQAppInterface.h = 109;
                if ((paramInt2 == 3007) || (paramInt2 == 2007) || (paramInt2 == 4007)) {}
                for (paramQQAppInterface.h = 14;; paramQQAppInterface.h = 15) {
                  do
                  {
                    paramString = new Bundle();
                    paramString.putInt("param_mode", 3);
                    paramString.putParcelable("sysInfoExtres", paramIntent);
                    NearbyPeopleProfileActivity.a(paramContext, paramQQAppInterface, paramString);
                    break;
                  } while ((paramInt2 != 3019) && (paramInt2 != 2019));
                }
              }
              paramQQAppInterface = new ProfileActivity.AllInOne(paramString, 25);
              paramQQAppInterface.h = 109;
              paramQQAppInterface.i = paramInt2;
              paramQQAppInterface.jdField_d_of_type_JavaLangString = String.valueOf(paramLong);
              paramQQAppInterface.jdField_d_of_type_Int = 1;
              paramString = new Bundle();
              paramString.putParcelable("sysInfoExtres", paramIntent);
              ProfileActivity.a(paramContext, paramQQAppInterface, paramString);
              break;
            } while ((paramInt2 != 3019) && (paramInt2 != 2019));
          }
          label838:
          paramString = new ProfileActivity.AllInOne(paramString, 25);
          paramString.h = 109;
          paramString.jdField_d_of_type_Int = 1;
          if (paramInt1 == 6) {
            paramString.jdField_d_of_type_Int = 0;
          }
          localBundle = new Bundle();
          localBundle.putParcelable("sysInfoExtres", paramIntent);
          if (paramQQAppInterface != null) {
            paramString.a.putSerializable("param_wzry_data", paramQQAppInterface);
          }
          ProfileActivity.a(paramContext, paramString, localBundle);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.SystemMessageHelper
 * JD-Core Version:    0.7.0.1
 */