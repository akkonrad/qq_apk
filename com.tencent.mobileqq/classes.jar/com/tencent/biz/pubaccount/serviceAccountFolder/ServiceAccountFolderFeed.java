package com.tencent.biz.pubaccount.serviceAccountFolder;

import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.subscript.SubscriptionFeed;
import com.tencent.biz.pubaccount.subscript.SubscriptionFeedItem;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.recent.TimeManager;
import com.tencent.mobileqq.activity.recent.data.RecentItemChatMsgData;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class ServiceAccountFolderFeed
{
  public int a;
  public long a;
  public MessageRecord a;
  public CharSequence a;
  public String a;
  public boolean a;
  public int b;
  public long b;
  @notColumn
  public CharSequence b;
  public String b;
  public boolean b;
  public int c;
  public String c;
  public int d;
  public String d;
  @notColumn
  public int e;
  
  public ServiceAccountFolderFeed()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_d_of_type_Int = BaseApplicationImpl.getApplication().getResources().getColor(2131494288);
    this.jdField_b_of_type_Long = 0L;
  }
  
  public static ServiceAccountFolderFeed a(QQAppInterface paramQQAppInterface, SubscriptionFeed paramSubscriptionFeed)
  {
    ServiceAccountFolderFeed localServiceAccountFolderFeed = new ServiceAccountFolderFeed();
    localServiceAccountFolderFeed.jdField_a_of_type_Boolean = false;
    localServiceAccountFolderFeed.jdField_a_of_type_JavaLangString = paramSubscriptionFeed.jdField_a_of_type_JavaLangString;
    localServiceAccountFolderFeed.jdField_b_of_type_Int = paramSubscriptionFeed.jdField_b_of_type_Int;
    localServiceAccountFolderFeed.jdField_c_of_type_Int = 0;
    localServiceAccountFolderFeed.jdField_a_of_type_Long = paramSubscriptionFeed.jdField_a_of_type_Long;
    localServiceAccountFolderFeed.jdField_b_of_type_JavaLangString = TimeManager.a().a(paramSubscriptionFeed.jdField_a_of_type_JavaLangString, paramSubscriptionFeed.jdField_a_of_type_Long);
    String str2 = TroopBarAssistantManager.a().a(paramSubscriptionFeed.jdField_a_of_type_JavaLangString);
    String str1 = str2;
    if ("".equals(str2)) {
      str1 = paramSubscriptionFeed.jdField_a_of_type_JavaLangString;
    }
    localServiceAccountFolderFeed.jdField_c_of_type_JavaLangString = str1;
    if (paramSubscriptionFeed.jdField_a_of_type_JavaUtilList.size() > 0) {
      localServiceAccountFolderFeed.jdField_a_of_type_JavaLangCharSequence = ((SubscriptionFeedItem)paramSubscriptionFeed.jdField_a_of_type_JavaUtilList.get(0)).jdField_b_of_type_JavaLangString;
    }
    localServiceAccountFolderFeed.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramQQAppInterface.a().b(paramSubscriptionFeed.jdField_a_of_type_JavaLangString, 1008);
    localServiceAccountFolderFeed.jdField_d_of_type_JavaLangString = ServiceAccountFolderManager.a(paramQQAppInterface, paramSubscriptionFeed.jdField_a_of_type_JavaLangString);
    a(paramQQAppInterface, localServiceAccountFolderFeed);
    b(paramQQAppInterface, localServiceAccountFolderFeed);
    c(paramQQAppInterface, localServiceAccountFolderFeed);
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderFeed", 2, "createFromSubscriptionFeed->" + localServiceAccountFolderFeed.toString());
    }
    return localServiceAccountFolderFeed;
  }
  
  public static ServiceAccountFolderFeed a(QQAppInterface paramQQAppInterface, RecentUser paramRecentUser)
  {
    paramRecentUser = new RecentItemChatMsgData(paramRecentUser);
    paramRecentUser.a(paramQQAppInterface, paramQQAppInterface.getApplication());
    ServiceAccountFolderFeed localServiceAccountFolderFeed = new ServiceAccountFolderFeed();
    localServiceAccountFolderFeed.jdField_a_of_type_Boolean = true;
    localServiceAccountFolderFeed.jdField_a_of_type_JavaLangString = paramRecentUser.a();
    localServiceAccountFolderFeed.jdField_b_of_type_Int = paramRecentUser.jdField_c_of_type_Int;
    localServiceAccountFolderFeed.jdField_c_of_type_Int = paramRecentUser.jdField_d_of_type_Int;
    localServiceAccountFolderFeed.jdField_a_of_type_Long = paramRecentUser.jdField_a_of_type_Long;
    localServiceAccountFolderFeed.jdField_b_of_type_JavaLangString = paramRecentUser.jdField_c_of_type_JavaLangString;
    localServiceAccountFolderFeed.jdField_b_of_type_Long = paramRecentUser.a();
    localServiceAccountFolderFeed.jdField_c_of_type_JavaLangString = paramRecentUser.jdField_b_of_type_JavaLangString;
    localServiceAccountFolderFeed.jdField_a_of_type_JavaLangCharSequence = paramRecentUser.jdField_c_of_type_JavaLangCharSequence;
    localServiceAccountFolderFeed.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramQQAppInterface.a().b(localServiceAccountFolderFeed.jdField_a_of_type_JavaLangString, 1008);
    localServiceAccountFolderFeed.jdField_d_of_type_JavaLangString = ServiceAccountFolderManager.a(paramQQAppInterface, localServiceAccountFolderFeed.jdField_a_of_type_JavaLangString);
    a(paramQQAppInterface, localServiceAccountFolderFeed);
    b(paramQQAppInterface, localServiceAccountFolderFeed);
    c(paramQQAppInterface, localServiceAccountFolderFeed);
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderFeed", 2, "createFromRecentUser->" + localServiceAccountFolderFeed.toString());
    }
    return localServiceAccountFolderFeed;
  }
  
  private static void a(QQAppInterface paramQQAppInterface, ServiceAccountFolderFeed paramServiceAccountFolderFeed)
  {
    paramQQAppInterface = (PublicAccountDataManager)paramQQAppInterface.getManager(55);
    if (paramQQAppInterface != null)
    {
      PublicAccountInfo localPublicAccountInfo = paramQQAppInterface.b(paramServiceAccountFolderFeed.jdField_a_of_type_JavaLangString);
      if (localPublicAccountInfo == null) {
        break label75;
      }
      if (!TextUtils.isEmpty(localPublicAccountInfo.name)) {
        paramServiceAccountFolderFeed.jdField_c_of_type_JavaLangString = localPublicAccountInfo.name;
      }
      paramServiceAccountFolderFeed.jdField_b_of_type_Boolean = localPublicAccountInfo.isVisible();
      if (localPublicAccountInfo.certifiedGrade <= 0L) {
        break label69;
      }
      paramServiceAccountFolderFeed.jdField_c_of_type_Int = 2130839751;
    }
    label69:
    label75:
    do
    {
      return;
      paramServiceAccountFolderFeed.jdField_c_of_type_Int = 0;
      return;
      paramQQAppInterface = paramQQAppInterface.a(paramServiceAccountFolderFeed.jdField_a_of_type_JavaLangString);
    } while (paramQQAppInterface == null);
    if (!TextUtils.isEmpty(paramQQAppInterface.name)) {
      paramServiceAccountFolderFeed.jdField_c_of_type_JavaLangString = paramQQAppInterface.name;
    }
    if (1 == paramQQAppInterface.showFlag) {}
    for (boolean bool = true;; bool = false)
    {
      paramServiceAccountFolderFeed.jdField_b_of_type_Boolean = bool;
      if (paramQQAppInterface.certifiedGrade <= 0) {
        break;
      }
      paramServiceAccountFolderFeed.jdField_c_of_type_Int = 2130839751;
      return;
    }
    paramServiceAccountFolderFeed.jdField_c_of_type_Int = 0;
  }
  
  private static void b(QQAppInterface paramQQAppInterface, ServiceAccountFolderFeed paramServiceAccountFolderFeed)
  {
    int i = paramQQAppInterface.a().f(paramServiceAccountFolderFeed.jdField_a_of_type_JavaLangString, 1008);
    if (paramServiceAccountFolderFeed.jdField_b_of_type_Int > 0)
    {
      if ((paramServiceAccountFolderFeed.jdField_b_of_type_Int != 1) || (i <= 0)) {
        break label40;
      }
      paramServiceAccountFolderFeed.jdField_a_of_type_Int = 2;
    }
    label40:
    do
    {
      return;
      paramServiceAccountFolderFeed.jdField_a_of_type_Int = 1;
    } while (i <= 0);
    paramServiceAccountFolderFeed.jdField_b_of_type_Int -= 1;
  }
  
  private static void c(QQAppInterface paramQQAppInterface, ServiceAccountFolderFeed paramServiceAccountFolderFeed)
  {
    paramQQAppInterface = paramQQAppInterface.a();
    if (paramQQAppInterface != null)
    {
      paramServiceAccountFolderFeed.jdField_b_of_type_JavaLangCharSequence = null;
      paramQQAppInterface = paramQQAppInterface.a(paramServiceAccountFolderFeed.jdField_a_of_type_JavaLangString, 1008);
      if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramQQAppInterface.getSummary())))
      {
        if (paramServiceAccountFolderFeed.jdField_a_of_type_Long != paramQQAppInterface.getTime()) {
          break label58;
        }
        paramServiceAccountFolderFeed.e = 4;
      }
    }
    label58:
    while ((paramServiceAccountFolderFeed.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && (paramQQAppInterface.getTime() <= paramServiceAccountFolderFeed.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time)) {
      return;
    }
    paramServiceAccountFolderFeed.e = 4;
    paramServiceAccountFolderFeed.jdField_a_of_type_Long = paramQQAppInterface.getTime();
    paramServiceAccountFolderFeed.jdField_b_of_type_JavaLangString = TimeManager.a().a(paramServiceAccountFolderFeed.jdField_a_of_type_JavaLangString, paramQQAppInterface.getTime());
    paramServiceAccountFolderFeed.jdField_a_of_type_JavaLangCharSequence = paramQQAppInterface.getSummary();
  }
  
  public final boolean a()
  {
    return (this.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_Int == 4);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ServiceAccountFolderFeed content->");
    localStringBuilder.append("mIsCreateFromMessageTab:" + this.jdField_a_of_type_Boolean);
    localStringBuilder.append(", mUin:" + this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", mUnreadFlag:" + this.jdField_a_of_type_Int);
    localStringBuilder.append(", mUnreadNum:" + this.jdField_b_of_type_Int);
    localStringBuilder.append(", mAuthenIconId:" + this.jdField_c_of_type_Int);
    localStringBuilder.append(", mShowTime:" + this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(", mTitleName:" + this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append(", mMsgBrief:" + this.jdField_a_of_type_JavaLangCharSequence);
    localStringBuilder.append(", mMsgExtraInfo:" + this.jdField_d_of_type_JavaLangString);
    localStringBuilder.append(", mDraft:" + this.jdField_b_of_type_JavaLangCharSequence);
    localStringBuilder.append(", mStatus:" + this.e);
    localStringBuilder.append(", mDisplayTime:" + this.jdField_a_of_type_Long);
    localStringBuilder.append(", mOperationTime:" + this.jdField_b_of_type_Long);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderFeed
 * JD-Core Version:    0.7.0.1
 */