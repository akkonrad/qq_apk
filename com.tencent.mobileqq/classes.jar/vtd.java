import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.HotReactiveHelper;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class vtd
  implements Runnable
{
  public vtd(FriendChatPie paramFriendChatPie) {}
  
  public void run()
  {
    FriendsManager localFriendsManager = (FriendsManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
    ExtensionInfo localExtensionInfo = localFriendsManager.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, false);
    if (localExtensionInfo == null) {}
    do
    {
      return;
      bool1 = localFriendsManager.d();
    } while (bool1);
    int i = localFriendsManager.b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, localExtensionInfo, bool1);
    int j = localFriendsManager.c(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, localExtensionInfo, bool1);
    int k = localFriendsManager.d(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, localExtensionInfo, bool1);
    long l1 = localExtensionInfo.lastChatTime;
    long l2 = localExtensionInfo.lastpraiseTime;
    long l3 = localExtensionInfo.lastQzoneVisitTime;
    int m = HotReactiveHelper.b();
    boolean bool1 = HotReactiveHelper.a(m, l1 * 1000L);
    boolean bool2 = HotReactiveHelper.a(m, l2 * 1000L);
    boolean bool3 = HotReactiveHelper.a(m, l3 * 1000L);
    m = localExtensionInfo.isGrayTipRemind;
    int n = localExtensionInfo.isGrayTipMultiRemind;
    int i1 = localFriendsManager.i;
    if (QLog.isColorLevel()) {
      QLog.d("reactivetip", 2, "checkReactiveGraytip isRemind=" + m + "isMultiRemind" + n + "praiseNeedRemind=" + bool2 + "chatNeedRemind=" + bool1 + "maxRemindTime=" + i1);
    }
    String str;
    if ((bool2) && (bool1) && (bool3) && (i != 0) && (j != 0) && (k != 0))
    {
      if (!this.a.a("hot_friend_graytip_pcq_All_remind_times", Boolean.valueOf(true), n, 1, true, localExtensionInfo, i1)) {
        break label947;
      }
      str = HotReactiveHelper.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 54);
      i = 26;
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(str)) {
        this.a.a(str, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
      }
      localFriendsManager.a(localExtensionInfo);
      ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007779", "0X8007779", i, 0, "", "", "", "");
      return;
      if ((bool2) && (bool1) && (i != 0) && (j != 0))
      {
        if (this.a.a("hot_friend_graytip_priaseandchat_remind_times", Boolean.valueOf(true), n, 4096, true, localExtensionInfo, i1))
        {
          str = HotReactiveHelper.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 51);
          i = 23;
        }
      }
      else if ((bool2) && (bool3) && (j != 0) && (k != 0))
      {
        if (this.a.a("hot_friend_graytip_priaseandqzone_remind_times", Boolean.valueOf(true), n, 16, true, localExtensionInfo, i1))
        {
          str = HotReactiveHelper.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 53);
          i = 25;
        }
      }
      else if ((bool1) && (bool3) && (i != 0) && (k != 0))
      {
        if (this.a.a("hot_friend_graytip_chatandqzone_remind_times", Boolean.valueOf(true), n, 256, true, localExtensionInfo, i1))
        {
          str = HotReactiveHelper.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 52);
          i = 24;
        }
      }
      else if (bool2)
      {
        if (j == 2)
        {
          if (this.a.a("hot_friend_graytip_priasedown_remind_times", Boolean.valueOf(false), m, 1, bool2, localExtensionInfo, i1))
          {
            str = HotReactiveHelper.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 45);
            i = 20;
          }
        }
        else if ((j == 1) && (this.a.a("hot_friend_graytip_priasedis_remind_times", Boolean.valueOf(false), m, 16, bool2, localExtensionInfo, i1)))
        {
          str = HotReactiveHelper.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 46);
          i = 19;
        }
      }
      else if (bool1)
      {
        if (i == 2)
        {
          if (this.a.a("hot_friend_graytip_chatdown_remind_times", Boolean.valueOf(false), m, 256, bool1, localExtensionInfo, i1))
          {
            str = HotReactiveHelper.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 47);
            i = 18;
          }
        }
        else if ((i == 1) && (this.a.a("hot_friend_graytip_chatdis_remind_times", Boolean.valueOf(false), m, 4096, bool1, localExtensionInfo, i1)))
        {
          str = HotReactiveHelper.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 48);
          i = 17;
        }
      }
      else if (bool3) {
        if (k == 2)
        {
          if (this.a.a("hot_friend_graytip_qzonedown_remind_times", Boolean.valueOf(false), m, 65536, bool3, localExtensionInfo, i1))
          {
            str = HotReactiveHelper.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 49);
            i = 22;
          }
        }
        else if ((k == 1) && (this.a.a("hot_friend_graytip_qzonedis_remind_times", Boolean.valueOf(false), m, 1048576, bool3, localExtensionInfo, i1)))
        {
          str = HotReactiveHelper.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 50);
          i = 21;
          continue;
        }
      }
      label947:
      i = 0;
      str = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vtd
 * JD-Core Version:    0.7.0.1
 */