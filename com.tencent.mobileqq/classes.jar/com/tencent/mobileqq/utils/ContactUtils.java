package com.tencent.mobileqq.utils;

import akbz;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.av.gaudio.AVPhoneUserInfo;
import com.tencent.av.gaudio.AVPhoneUserInfo.TelInfo;
import com.tencent.av.utils.PstnUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.device.utils.SmartDeviceUtil;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.contact.OnlineStatusIconHelper;
import com.tencent.mobileqq.app.ContactFacade;
import com.tencent.mobileqq.app.ContactSorter;
import com.tencent.mobileqq.app.ContactSorter.NamePriorityComparator;
import com.tencent.mobileqq.app.ContactSorter.PhoneNameComparator;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.EqqDetailDataManager;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.DateNickNameInfo;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.EqqDetail;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.util.FetchBuddyAndTroopNameHelper;
import com.tencent.mobileqq.util.TroopSystemMsgUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.Constants.PropertiesKey;
import mqq.app.MobileQQ;

public class ContactUtils
{
  public static int a;
  public static String a;
  public static int b;
  public static String b;
  public static int c;
  public static String c;
  private static String d;
  
  static
  {
    jdField_a_of_type_JavaLangString = "troop_mem_nick_update_target";
    jdField_a_of_type_Int = -1;
    jdField_b_of_type_Int = 1;
    jdField_c_of_type_Int = 2;
    jdField_b_of_type_JavaLangString = "uni_seq";
  }
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return -1;
    case 0: 
    case 1005: 
    case 1023: 
    case 1025: 
      return 0;
    case 1008: 
    case 1024: 
      return 8;
    case 3: 
    case 4: 
    case 1006: 
      return 3;
    case 2: 
    case 1000: 
    case 1020: 
      return 1;
    case 1001: 
    case 1002: 
    case 1003: 
    case 1009: 
    case 10002: 
    case 10004: 
      return 4;
    case 1021: 
      return 5;
    case 1004: 
      return 2;
    case 1: 
      return 6;
    case 3000: 
      return 7;
    }
    return 10;
  }
  
  public static int a(int paramInt1, int paramInt2)
  {
    int i = 4;
    switch (paramInt1)
    {
    default: 
      paramInt1 = 0;
      if ((paramInt2 == 69378) || (paramInt2 == 73474) || (paramInt2 == 73730)) {
        i = 0;
      }
      break;
    }
    while ((paramInt1 != 0) && (paramInt1 != 6) && (paramInt1 != 4) && (OnlineStatusIconHelper.a().a(paramInt2)))
    {
      return i;
      paramInt1 = 8;
      break;
      paramInt1 = 4;
      break;
      paramInt1 = 0;
      break;
      paramInt1 = 1;
      break;
      paramInt1 = 0;
      break;
      paramInt1 = 2;
      break;
      paramInt1 = 3;
      break;
      paramInt1 = 7;
      break;
      paramInt1 = 4;
      break;
      paramInt1 = 0;
      break;
    }
    return paramInt1;
  }
  
  public static int a(QQAppInterface paramQQAppInterface, String paramString)
  {
    DiscussionManager localDiscussionManager = (DiscussionManager)paramQQAppInterface.getManager(52);
    int i;
    if (localDiscussionManager == null)
    {
      QLog.i("ContactUtils", 1, " === dm is null or info is null ====");
      i = 0;
    }
    int j;
    do
    {
      do
      {
        return i;
        j = localDiscussionManager.a(paramString);
        paramQQAppInterface = PstnUtils.a(paramQQAppInterface, paramString, 3000);
        i = j;
      } while (paramQQAppInterface == null);
      i = j;
    } while (paramQQAppInterface.size() <= 0);
    return j + paramQQAppInterface.size();
  }
  
  public static int a(Friends paramFriends)
  {
    switch (a(paramFriends.detalStatusFlag, paramFriends.iTermType))
    {
    case 5: 
    case 6: 
    default: 
      return (int)paramFriends.getLastLoginType() + 20;
    case 1: 
      return 2;
    case 2: 
    case 7: 
      return 1;
    }
    return 0;
  }
  
  public static int a(Friends paramFriends, QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (FriendListHandler)paramQQAppInterface.a(1);
    int i = a(paramFriends.detalStatusFlag, paramFriends.iTermType);
    if ((i != 0) && (i != 6))
    {
      OnlineStatusIconHelper localOnlineStatusIconHelper = OnlineStatusIconHelper.a();
      if (1 == localOnlineStatusIconHelper.a(paramFriends.iTermType, 0))
      {
        if (paramQQAppInterface.d()) {
          return 2;
        }
        return 3;
      }
      if (2 == localOnlineStatusIconHelper.a(paramFriends.iTermType, 0)) {
        return 1;
      }
      if (3 == localOnlineStatusIconHelper.a(paramFriends.iTermType, 0)) {
        return 0;
      }
      if (paramQQAppInterface.d()) {
        return 2;
      }
      return 3;
    }
    if (paramFriends.showLoginClient == 1L) {
      return 2;
    }
    if (paramFriends.showLoginClient == 3L) {
      return 0;
    }
    if (paramFriends.showLoginClient == 2L) {
      return 1;
    }
    return 3;
  }
  
  private static int a(String paramString)
  {
    byte[] arrayOfByte = new byte[0];
    try
    {
      paramString = paramString.getBytes("utf-8");
      return paramString.length;
    }
    catch (UnsupportedEncodingException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = arrayOfByte;
      }
    }
  }
  
  public static String a()
  {
    return jdField_c_of_type_JavaLangString;
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "2G在线";
    case 1: 
      return "WiFi在线";
    case 2: 
      return "2G在线";
    case 3: 
      return "3G在线";
    case 4: 
      return "4G在线";
    case 5: 
      return "电脑在线";
    case 6: 
      return "平板在线";
    case 7: 
      return "手表在线";
    case 8: 
      return "BMW QQ在线";
    case 9: 
      return "车载QQ在线";
    case 100: 
      return "iPhone在线";
    case 101: 
      return "手机在线";
    case 10: 
      return "TIM在线";
    }
    return "手机在线";
  }
  
  private static String a(int paramInt, String paramString, Friends paramFriends, PhoneContact paramPhoneContact)
  {
    switch (paramInt)
    {
    case 1: 
    case 2: 
    default: 
      return "";
    }
    if (paramFriends != null)
    {
      if (!TextUtils.isEmpty(paramFriends.remark)) {
        return paramFriends.remark;
      }
      return paramFriends.name;
    }
    return paramString;
  }
  
  private static String a(int paramInt, String paramString1, String paramString2)
  {
    String str;
    if (paramInt <= 0)
    {
      str = "";
      return str;
    }
    if (paramString1 != null) {}
    for (;;)
    {
      str = paramString1;
      if (TextUtils.isEmpty(paramString2)) {
        break;
      }
      StringBuilder localStringBuilder = new StringBuilder().append(paramString1);
      if (paramString1.length() != 0) {}
      for (str = "、";; str = "")
      {
        str = str + paramString2;
        if (a(str) > paramInt) {
          break;
        }
        return str;
      }
      str = paramString2;
      if (paramString1.length() != 0) {
        str = "、" + paramString2;
      }
      int j = a(paramString1);
      paramString2 = new StringBuilder();
      int i = 0;
      while (i < str.length())
      {
        int k = str.codePointAt(i);
        int m = Character.charCount(k);
        i += m;
        paramString2.appendCodePoint(k);
        if (a(paramString2.toString()) > paramInt - j) {
          paramString2.delete(paramString2.length() - m, paramString2.length());
        }
      }
      paramString2 = paramString2.toString();
      str = paramString1;
      if (paramString2.equals("、")) {
        break;
      }
      return paramString1 + paramString2;
      paramString1 = "";
    }
  }
  
  public static String a(Context paramContext, DiscussionInfo paramDiscussionInfo)
  {
    String str = "";
    if (paramDiscussionInfo != null) {
      str = paramDiscussionInfo.discussionName;
    }
    if (str != null)
    {
      paramDiscussionInfo = str;
      if (str.length() != 0) {}
    }
    else
    {
      paramDiscussionInfo = paramContext.getResources().getString(2131434000);
    }
    return paramDiscussionInfo;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, int paramInt, String paramString1, String paramString2)
  {
    String str = "";
    if (paramInt == 1) {
      str = e(paramQQAppInterface, paramString1, paramString2);
    }
    while (paramInt != 3000) {
      return str;
    }
    return c(paramQQAppInterface, paramString1, paramString2);
  }
  
  public static String a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    paramQQAppInterface = (DiscussionManager)paramQQAppInterface.getManager(52);
    if (paramQQAppInterface != null) {}
    for (paramQQAppInterface = paramQQAppInterface.a(paramString);; paramQQAppInterface = null) {
      return a(paramContext, paramQQAppInterface);
    }
  }
  
  public static String a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, boolean paramBoolean, String paramString)
  {
    try
    {
      switch (paramSessionInfo.jdField_a_of_type_Int)
      {
      }
      String str;
      for (;;)
      {
        if (paramBoolean)
        {
          return paramQQAppInterface.getCurrentNickname();
          return a(paramQQAppInterface, paramString, paramSessionInfo.jdField_a_of_type_JavaLangString, 1, 0);
          return c(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString, paramString);
        }
        str = paramSessionInfo.d;
        if (str == null) {}
      }
      return str;
    }
    catch (Exception paramQQAppInterface)
    {
      try
      {
        if (str.length() != 0) {
          break label107;
        }
        paramQQAppInterface = a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString, "", 0, 0);
        return paramQQAppInterface;
      }
      catch (Exception paramQQAppInterface)
      {
        return str;
      }
      paramQQAppInterface = paramQQAppInterface;
      return paramString;
    }
  }
  
  public static String a(QQAppInterface paramQQAppInterface, DiscussionMemberInfo paramDiscussionMemberInfo)
  {
    String str1 = paramDiscussionMemberInfo.memberUin;
    if (!TextUtils.isEmpty(paramDiscussionMemberInfo.inteRemark)) {}
    for (str1 = paramDiscussionMemberInfo.inteRemark;; str1 = paramDiscussionMemberInfo.memberName)
    {
      String str2 = str1;
      if (TextUtils.isEmpty(str1)) {
        str2 = k(paramQQAppInterface, paramDiscussionMemberInfo.memberUin);
      }
      return str2;
    }
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = ((FriendsManager)paramQQAppInterface.getManager(50)).c(paramString);
    if (paramQQAppInterface != null) {
      paramString = paramQQAppInterface.getFriendNick();
    }
    return paramString;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    String str;
    if (paramInt == 1) {
      str = i(paramQQAppInterface, paramString);
    }
    do
    {
      return str;
      if (3000 == paramInt) {
        return d(paramQQAppInterface, paramString);
      }
      if (paramInt == 0) {
        break;
      }
      str = paramString;
    } while (1024 != paramInt);
    return a(paramQQAppInterface, paramString);
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    Friends localFriends = ((FriendsManager)paramQQAppInterface.getManager(50)).a(paramString2);
    if ((localFriends == null) || (!localFriends.isFriend()))
    {
      paramQQAppInterface = ((DiscussionManager)paramQQAppInterface.getManager(52)).a(paramString1, paramString2);
      if (paramQQAppInterface == null) {
        break label75;
      }
      paramQQAppInterface = paramQQAppInterface.inteRemark;
    }
    for (;;)
    {
      if ((paramQQAppInterface == null) || (paramQQAppInterface.trim().length() == 0))
      {
        return paramString2;
        paramQQAppInterface = localFriends.name;
      }
      else
      {
        return paramQQAppInterface;
        label75:
        paramQQAppInterface = "";
      }
    }
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    if (paramInt == 1) {
      return e(paramQQAppInterface, paramString2, paramString1);
    }
    return c(paramQQAppInterface, paramString2, paramString1);
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    Object localObject = (ContactFacade)paramQQAppInterface.getManager(53);
    DiscussionManager localDiscussionManager = (DiscussionManager)paramQQAppInterface.getManager(52);
    localObject = (FriendsManager)paramQQAppInterface.getManager(50);
    TroopManager localTroopManager = (TroopManager)paramQQAppInterface.getManager(51);
    if ((localObject != null) && (paramInt1 != 1) && (paramInt1 != 7) && (paramInt1 != 6) && (paramInt1 != 2) && (paramInt1 != 5)) {}
    for (localObject = ((FriendsManager)localObject).c(paramString1);; localObject = null)
    {
      switch (paramInt1)
      {
      case 5: 
      case 9: 
      default: 
        if ((localObject != null) && (!TextUtils.isEmpty(((Friends)localObject).name))) {
          paramQQAppInterface = ((Friends)localObject).name;
        }
        break;
      }
      for (;;)
      {
        if (TextUtils.isEmpty(paramQQAppInterface))
        {
          return paramString1;
          paramQQAppInterface = a(paramInt2, paramString1, (Friends)localObject, ((PhoneContactManager)paramQQAppInterface.getManager(10)).a(paramString1));
          continue;
          paramQQAppInterface = b(paramQQAppInterface, paramString1, 1008);
          continue;
          switch (paramInt2)
          {
          case 1: 
          case 2: 
          default: 
            paramQQAppInterface = paramString1;
            break;
          case 0: 
          case 3: 
            paramQQAppInterface = localTroopManager.a(paramString2, paramString1);
            continue;
            paramQQAppInterface = c(paramQQAppInterface, paramString2, paramString1);
            continue;
            paramQQAppInterface = b(paramInt2, paramString1, (Friends)localObject, ((PhoneContactManager)paramQQAppInterface.getManager(10)).a(paramString1));
            continue;
            paramQQAppInterface = c(paramInt2, paramString1, (Friends)localObject, ((PhoneContactManager)paramQQAppInterface.getManager(10)).a(paramString1));
            continue;
            paramQQAppInterface = a(paramQQAppInterface.getApp(), localDiscussionManager.a(paramString1));
            continue;
            paramQQAppInterface = localTroopManager.a(paramString1);
            if (paramQQAppInterface == null) {
              break label375;
            }
            paramQQAppInterface = paramQQAppInterface.getTroopName();
            continue;
            paramQQAppInterface = f(paramQQAppInterface, paramString1);
            break;
          }
        }
        else
        {
          return paramQQAppInterface;
          label375:
          paramQQAppInterface = null;
        }
      }
    }
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, long paramLong, String paramString3, Map paramMap)
  {
    if (((0x40 & paramLong) >>> 6 == 1L) && ((paramLong & 0x20000000) != 536870912L) && ((paramMap == null) || (paramMap.size() == 0))) {
      if (QLog.isColorLevel()) {
        QLog.d("ContactUtils", 2, "setDiscussionNameAndCompareName, info is null. disUin=" + paramString1);
      }
    }
    while (!a(paramQQAppInterface, paramLong, paramString3)) {
      return paramString3;
    }
    return a(paramQQAppInterface, paramString2, paramMap);
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, MessageRecord paramMessageRecord)
  {
    String str = null;
    if (paramMessageRecord != null) {
      str = paramMessageRecord.getExtInfoFromExtStr("troop_msg_nickname");
    }
    paramMessageRecord = str;
    if (TextUtils.isEmpty(str)) {
      paramMessageRecord = c(paramQQAppInterface, paramString1, paramString2);
    }
    return paramMessageRecord;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, boolean paramBoolean, Bundle paramBundle)
  {
    if ((paramString1 == null) || ("".equals(paramString1)) || (paramString2 == null) || ("".equals(paramString2)) || (paramString3 == null) || ("".equals(paramString3)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ContactUtils", 2, StringUtil.a(new Object[] { "getTroopNickName()", paramString1, paramString2, paramString3, Boolean.valueOf(paramBoolean), paramBundle }));
      }
      localObject1 = "";
    }
    boolean bool;
    do
    {
      return localObject1;
      localObject1 = g(paramQQAppInterface, paramString2, paramString1);
      bool = a((String)localObject1, paramString1);
      if (QLog.isColorLevel()) {
        QLog.d("ContactUtils", 2, StringUtil.a(new Object[] { "getTroopNickName()", paramString1, paramString2, paramString3, Boolean.valueOf(paramBoolean), localObject1 }));
      }
    } while (bool);
    TroopMemberInfo localTroopMemberInfo = DBUtils.a().a(paramQQAppInterface, paramString2, paramString1);
    Object localObject2;
    if (localTroopMemberInfo != null)
    {
      localObject2 = localTroopMemberInfo.troopnick;
      localObject1 = localObject2;
      if (b((String)localObject2)) {}
    }
    for (Object localObject1 = localTroopMemberInfo.friendnick;; localObject1 = null)
    {
      localObject2 = localObject1;
      if (!b((String)localObject1))
      {
        if (paramBoolean) {
          ((ContactFacade)paramQQAppInterface.getManager(53)).a().a(paramString1, paramString2, paramString3, paramBundle);
        }
        localObject2 = paramString1;
      }
      localObject1 = localObject2;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ContactUtils", 2, StringUtil.a(new Object[] { "getTroopNickName()", paramString1, paramString2, paramString3, Boolean.valueOf(paramBoolean), localObject2 }));
      return localObject2;
    }
  }
  
  private static String a(QQAppInterface paramQQAppInterface, String paramString, Map paramMap)
  {
    Object localObject = "";
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString)) || (paramMap == null) || (paramMap.size() == 0))
    {
      paramString = (String)localObject;
      if (QLog.isColorLevel())
      {
        QLog.i("ContactUtils", 2, " === getDiscussionCombinedName app is null or ownerUin is null or members is null or members size is 0 ====");
        paramString = (String)localObject;
      }
      return paramString;
    }
    localObject = new ContactSorter.NamePriorityComparator(paramQQAppInterface, paramString, paramQQAppInterface.getCurrentAccountUin());
    ArrayList localArrayList = new ArrayList(paramMap.values());
    for (paramString = "";; paramString = paramMap)
    {
      if (localArrayList.size() <= 0) {
        return paramString;
      }
      paramMap = (DiscussionMemberInfo)Collections.min(localArrayList, (Comparator)localObject);
      localArrayList.remove(paramMap);
      paramMap = a(48, paramString, a(paramMap, paramQQAppInterface));
      paramString = paramMap;
      if (paramMap.length() >= 47) {
        break;
      }
    }
    return paramString;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    if ((paramString == null) || ("".equals(paramString))) {
      paramQQAppInterface = "";
    }
    do
    {
      return paramQQAppInterface;
      localObject1 = a(paramQQAppInterface, paramString, 1);
      if (!a((String)localObject1, paramString)) {
        break;
      }
      paramQQAppInterface = (QQAppInterface)localObject1;
    } while (!QLog.isColorLevel());
    QLog.d("ContactUtils", 2, StringUtil.a(new Object[] { "getTroopName()", paramString, Boolean.valueOf(paramBoolean) }));
    return localObject1;
    Object localObject1 = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    Object localObject2 = (TroopInfo)((EntityManager)localObject1).a(TroopInfo.class, paramString);
    ((EntityManager)localObject1).a();
    if (localObject2 != null) {}
    for (localObject2 = ((TroopInfo)localObject2).getTroopName();; localObject2 = null)
    {
      localObject1 = localObject2;
      if (!b((String)localObject2)) {
        localObject1 = TroopSystemMsgUtil.a(paramQQAppInterface.getApp(), paramString);
      }
      localObject2 = localObject1;
      if (!b((String)localObject1))
      {
        if (paramBoolean) {
          ((ContactFacade)paramQQAppInterface.getManager(53)).a().a(paramString);
        }
        localObject2 = paramString;
      }
      paramQQAppInterface = (QQAppInterface)localObject2;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ContactUtils", 2, StringUtil.a(new Object[] { "getTroopName()", paramString, Boolean.valueOf(paramBoolean) }));
      return localObject2;
    }
  }
  
  public static String a(DiscussionMemberInfo paramDiscussionMemberInfo, QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = ((FriendsManager)paramQQAppInterface.getManager(50)).a(paramDiscussionMemberInfo.memberUin);
    if ((paramQQAppInterface != null) && (paramQQAppInterface.isFriend())) {}
    for (Object localObject = paramQQAppInterface.getFriendNick();; localObject = paramDiscussionMemberInfo.inteRemark)
    {
      paramQQAppInterface = (QQAppInterface)localObject;
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        paramQQAppInterface = paramDiscussionMemberInfo.memberName;
      }
      localObject = paramQQAppInterface;
      if (TextUtils.isEmpty(paramQQAppInterface)) {
        localObject = paramDiscussionMemberInfo.memberUin;
      }
      return localObject;
    }
  }
  
  @Deprecated
  public static String a(Friends paramFriends)
  {
    return paramFriends.getFriendNickWithAlias();
  }
  
  private static String a(Friends paramFriends, String paramString)
  {
    String str;
    if ((paramFriends.remark != null) && (paramFriends.remark.length() > 0)) {
      str = paramFriends.remark;
    }
    do
    {
      return str;
      if (paramString == null) {
        break;
      }
      str = paramString;
    } while (paramString.length() > 0);
    if ((paramFriends.name != null) && (paramFriends.name.length() > 0)) {
      return paramFriends.name;
    }
    return paramFriends.uin;
  }
  
  public static String a(PhoneContact paramPhoneContact)
  {
    String str2 = paramPhoneContact.strTermDesc;
    String str1 = str2;
    if (!TextUtils.isEmpty(str2))
    {
      str1 = str2;
      if (!a(paramPhoneContact)) {
        str1 = str2 + c(paramPhoneContact.getNetWorkType());
      }
    }
    return str1;
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    return paramString.trim().substring(0, 1).toUpperCase();
  }
  
  public static void a()
  {
    jdField_c_of_type_JavaLangString = null;
  }
  
  public static void a(int paramInt)
  {
    String str = null;
    switch (paramInt)
    {
    }
    for (;;)
    {
      jdField_c_of_type_JavaLangString = str;
      return;
      str = "0X80068AA";
      continue;
      str = "0X80068AB";
      continue;
      str = "0X80068AC";
      continue;
      str = "0X80068AD";
      continue;
      str = "0X80068AE";
      continue;
      str = "0X80068AF";
      continue;
      str = "0X80068B0";
      continue;
      str = "0X80068B1";
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString1.equals("")) || (paramString2 == null) || (paramString2.equals(""))) {
      return;
    }
    ((PhoneContactManager)paramQQAppInterface.getManager(10)).c(paramString1, paramString2);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, ContactUtils.OnGetTroopMemberNameCallback paramOnGetTroopMemberNameCallback)
  {
    ThreadManager.post(new akbz(paramQQAppInterface, paramString1, paramString2, paramOnGetTroopMemberNameCallback), 5, null, false);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, long paramLong, String paramString)
  {
    if (d == null) {
      d = paramQQAppInterface.getApp().getString(2131433304);
    }
    return (((0x40 & paramLong) >>> 6 == 1L) && ((0x20000000 & paramLong) >>> 29 == 1L)) || (paramString == null) || (paramString.matches(d)) || (paramString.length() == 0);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, DiscussionInfo paramDiscussionInfo)
  {
    return a(paramQQAppInterface, paramDiscussionInfo.DiscussionFlag, paramDiscussionInfo.discussionName);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = ((DiscussionManager)paramQQAppInterface.getManager(52)).a(paramString);
    if (paramQQAppInterface != null) {
      return paramQQAppInterface.isDiscussHrMeeting();
    }
    return false;
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, String paramString, DiscussionInfo paramDiscussionInfo, Map paramMap)
  {
    if ((paramDiscussionInfo == null) || (paramMap == null) || (paramMap.size() == 0)) {
      return false;
    }
    paramDiscussionInfo.discussionName = a(paramQQAppInterface, paramDiscussionInfo.ownerUin, paramMap);
    return true;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString, DiscussionInfo paramDiscussionInfo, Map paramMap, boolean paramBoolean)
  {
    if (paramDiscussionInfo == null) {
      if (QLog.isColorLevel()) {
        QLog.d("ContactUtils", 2, "setDiscussionNameAndCompareName, info is null. disUin=" + paramString);
      }
    }
    for (;;)
    {
      return false;
      if (QLog.isColorLevel()) {
        QLog.d("ContactUtils", 2, "setDiscussionNameAndCompareName, Flag =" + paramDiscussionInfo.DiscussionFlag + " disUin=" + paramString);
      }
      if ((!paramDiscussionInfo.hasRenamed()) && ((paramDiscussionInfo.DiscussionFlag & 0x20000000) >>> 29 == 1L) && ((paramMap == null) || (paramMap.size() == 0)))
      {
        if (QLog.isColorLevel())
        {
          QLog.d("ContactUtils", 2, "setDiscussionNameAndCompareName no need disUin=" + paramString);
          return false;
        }
      }
      else
      {
        if (a(paramQQAppInterface, paramDiscussionInfo)) {}
        for (boolean bool = a(paramQQAppInterface, paramString, paramDiscussionInfo, paramMap); (paramBoolean) || (bool) || (paramDiscussionInfo.mCompareSpell == null) || (paramDiscussionInfo.mCompareSpell.length() == 0); bool = false)
        {
          ContactSorter.a(paramDiscussionInfo);
          paramDiscussionInfo.DiscussionFlag &= 0xDFFFFFFF;
          return true;
        }
      }
    }
  }
  
  public static boolean a(Friends paramFriends)
  {
    return ((paramFriends.iTermType == 0) && (paramFriends.eNetwork == 0)) || ((a(paramFriends.detalStatusFlag, paramFriends.iTermType) == 0) && (!TextUtils.isEmpty(paramFriends.strTermDesc)) && (paramFriends.strTermDesc.contains("TIM")));
  }
  
  public static boolean a(PhoneContact paramPhoneContact)
  {
    return (paramPhoneContact.iTermType == 0) && (paramPhoneContact.eNetworkType == 0);
  }
  
  public static boolean a(String paramString)
  {
    return Pattern.compile("[\\u4E00-\\u9FA5]+").matcher(paramString).find();
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    return (b(paramString1)) && (!paramString1.equals(paramString2)) && (paramString2 != null);
  }
  
  public static String b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "2G网络";
    case 1: 
      return "WIFI网络";
    case 2: 
      return "2G网络";
    case 3: 
      return "3G网络";
    case 4: 
      return "4G网络";
    case 5: 
      return "电脑在线";
    case 6: 
      return "平板在线";
    case 7: 
      return "手表在线";
    case 8: 
      return "宝马在线";
    case 9: 
      return "车载在线";
    case 100: 
      return "iPhone在线";
    case 101: 
      return "手机在线";
    }
    return "TIM在线";
  }
  
  private static String b(int paramInt, String paramString, Friends paramFriends, PhoneContact paramPhoneContact)
  {
    String str;
    switch (paramInt)
    {
    case 1: 
    case 2: 
    default: 
      str = "";
    }
    do
    {
      do
      {
        do
        {
          return str;
          str = paramString;
        } while (paramPhoneContact == null);
        return paramPhoneContact.name;
        if ((paramFriends != null) && (paramFriends.isFriend()))
        {
          if (!TextUtils.isEmpty(paramFriends.remark)) {}
          for (paramString = paramFriends.remark;; paramString = paramFriends.name) {
            return paramString;
          }
        }
        if (paramPhoneContact != null) {
          return paramPhoneContact.name;
        }
        str = paramString;
      } while (paramFriends == null);
      str = paramString;
    } while (TextUtils.isEmpty(paramFriends.name));
    return paramFriends.name;
  }
  
  public static String b(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = ((FriendsManager)paramQQAppInterface.getManager(50)).c(paramString);
    if (paramQQAppInterface != null) {
      paramString = paramQQAppInterface.getFriendName();
    }
    return paramString;
  }
  
  public static String b(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    Object localObject1 = (DiscussionManager)paramQQAppInterface.getManager(52);
    localObject1 = (FriendsManager)paramQQAppInterface.getManager(50);
    Object localObject2 = (PublicAccountDataManager)paramQQAppInterface.getManager(55);
    if (paramInt == 1) {
      paramQQAppInterface = i(paramQQAppInterface, paramString);
    }
    do
    {
      do
      {
        return paramQQAppInterface;
        if (3000 == paramInt) {
          return a(paramQQAppInterface, paramQQAppInterface.getApp(), paramString);
        }
        if ((1008 != paramInt) && (1024 != paramInt)) {
          break;
        }
        if (QidianManager.b(paramQQAppInterface, paramString)) {
          return QidianManager.a(paramQQAppInterface, paramString);
        }
        localObject1 = ((PublicAccountDataManager)localObject2).b(paramString);
        if ((localObject1 != null) && (((PublicAccountInfo)localObject1).name != null)) {
          return ((PublicAccountInfo)localObject1).name;
        }
        localObject1 = ((PublicAccountDataManager)localObject2).a(paramString);
        if ((localObject1 != null) && (((AccountDetail)localObject1).name != null)) {
          return ((AccountDetail)localObject1).name;
        }
        localObject1 = ((EqqDetailDataManager)paramQQAppInterface.getManager(68)).a(paramString);
        paramQQAppInterface = paramString;
      } while (localObject1 == null);
      paramQQAppInterface = paramString;
    } while (((EqqDetail)localObject1).name == null);
    return ((EqqDetail)localObject1).name;
    if (paramInt == 1006)
    {
      paramQQAppInterface = (PhoneContactManager)paramQQAppInterface.getManager(10);
      localObject2 = paramQQAppInterface.c(paramString);
      if (localObject2 != null) {
        return ((PhoneContact)localObject2).name;
      }
      localObject2 = paramQQAppInterface.a(paramString);
      if (localObject2 == null) {
        break label295;
      }
      paramQQAppInterface = ((FriendsManager)localObject1).c((String)localObject2);
      if (paramQQAppInterface == null) {
        break label295;
      }
    }
    label295:
    for (localObject1 = a(paramQQAppInterface);; localObject1 = null)
    {
      paramQQAppInterface = paramString;
      if (localObject1 == null) {
        break;
      }
      paramQQAppInterface = paramString;
      if (((String)localObject1).equals(localObject2)) {
        break;
      }
      return localObject1;
      if ((paramInt == 9500) || (paramInt == 9501)) {
        return SmartDeviceUtil.a(((SmartDeviceProxyMgr)paramQQAppInterface.a(51)).a(Long.parseLong(paramString)));
      }
      return a(paramQQAppInterface, paramString);
    }
  }
  
  public static String b(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    Friends localFriends = ((FriendsManager)paramQQAppInterface.getManager(50)).a(paramString2);
    if ((localFriends != null) && (!TextUtils.isEmpty(localFriends.remark))) {
      paramString2 = localFriends.remark;
    }
    TroopMemberInfo localTroopMemberInfo;
    do
    {
      do
      {
        return paramString2;
        localTroopMemberInfo = ((TroopManager)paramQQAppInterface.getManager(51)).b(paramString1, paramString2);
        if (localTroopMemberInfo == null) {
          break label151;
        }
        if (!TextUtils.isEmpty(localTroopMemberInfo.troopnick)) {
          return localTroopMemberInfo.troopnick;
        }
        if ((localFriends != null) && (!TextUtils.isEmpty(localFriends.name))) {
          return localFriends.name;
        }
        if (!paramString2.equals(paramQQAppInterface.getCurrentAccountUin())) {
          break;
        }
      } while (TextUtils.isEmpty(localTroopMemberInfo.friendnick));
      return localTroopMemberInfo.friendnick;
      if (!TextUtils.isEmpty(localTroopMemberInfo.autoremark)) {
        return localTroopMemberInfo.autoremark;
      }
    } while (TextUtils.isEmpty(localTroopMemberInfo.friendnick));
    return localTroopMemberInfo.friendnick;
    label151:
    ((TroopHandler)paramQQAppInterface.a(20)).a(Long.parseLong(paramString1), Long.parseLong(paramString2));
    return paramString2;
  }
  
  public static String b(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    Object localObject;
    if ((paramString == null) || ("".equals(paramString))) {
      localObject = "";
    }
    String str;
    label186:
    label195:
    label204:
    label207:
    do
    {
      return localObject;
      FriendsManager localFriendsManager = (FriendsManager)paramQQAppInterface.getManager(50);
      if (localFriendsManager != null)
      {
        localObject = localFriendsManager.c(paramString);
        if (localObject != null)
        {
          if (!((Friends)localObject).isFriend()) {
            break label195;
          }
          if ((((Friends)localObject).remark == null) || ("".equals(((Friends)localObject).remark))) {
            break label186;
          }
          str = ((Friends)localObject).remark;
        }
      }
      for (;;)
      {
        localObject = str;
        if (a(str, paramString)) {
          break;
        }
        str = a(paramQQAppInterface, paramString);
        localObject = str;
        if (a(str, paramString)) {
          break;
        }
        if ((localFriendsManager == null) || (a(str, paramString))) {
          break label204;
        }
        localObject = localFriendsManager.a(paramString);
        if (localObject == null) {
          break label204;
        }
        str = ((Card)localObject).strNick;
        localObject = str;
        if (str == null) {
          break label207;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ContactUtils", 2, StringUtil.a(new Object[] { "getBuddyName()", paramString, Boolean.valueOf(paramBoolean) }));
        }
        return str;
        str = ((Friends)localObject).name;
        continue;
        str = ((Friends)localObject).name;
      }
      localObject = str;
      if (a((String)localObject, paramString)) {
        break;
      }
      localObject = (PublicAccountDataManager)paramQQAppInterface.getManager(55);
      if (localObject == null) {
        break;
      }
      localObject = ((PublicAccountDataManager)localObject).c(paramString);
      if (localObject == null) {
        break;
      }
      str = ((PublicAccountInfo)localObject).name;
      if (!a(str, paramString)) {
        break;
      }
      localObject = str;
    } while (!QLog.isColorLevel());
    QLog.d("ContactUtils", 2, StringUtil.a(new Object[] { "getBuddyName()", paramString, Boolean.valueOf(paramBoolean) }));
    return str;
    if (paramBoolean) {
      ((ContactFacade)paramQQAppInterface.getManager(53)).a().b(paramString);
    }
    return paramString;
  }
  
  public static String b(Friends paramFriends)
  {
    String str2 = paramFriends.strTermDesc;
    String str1 = str2;
    if (!TextUtils.isEmpty(str2))
    {
      str1 = str2;
      if (!a(paramFriends)) {
        str1 = str2 + c(paramFriends.getNetWorkType());
      }
    }
    return str1;
  }
  
  private static String b(Friends paramFriends, String paramString)
  {
    String str;
    if ((paramFriends.remark != null) && (paramFriends.remark.length() > 0)) {
      str = paramFriends.remark;
    }
    do
    {
      return str;
      if (paramString == null) {
        break;
      }
      str = paramString;
    } while (paramString.length() > 0);
    if ((paramFriends.name != null) && (paramFriends.name.length() > 0)) {
      return paramFriends.name;
    }
    return "";
  }
  
  public static String b(String paramString)
  {
    String str;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    do
    {
      return str;
      str = paramString;
    } while (paramString.length() < 3);
    return paramString.substring(0, 3);
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, DiscussionInfo paramDiscussionInfo)
  {
    return (a(paramQQAppInterface, paramDiscussionInfo)) || (paramDiscussionInfo.mCompareSpell == null) || (paramDiscussionInfo.mCompareSpell.length() == 0);
  }
  
  private static boolean b(String paramString)
  {
    return (paramString != null) && (!"".equals(paramString));
  }
  
  private static String c(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 2: 
      return " - 2G";
    case 3: 
      return " - 3G";
    case 4: 
      return " - 4G";
    }
    return " - WiFi";
  }
  
  private static String c(int paramInt, String paramString, Friends paramFriends, PhoneContact paramPhoneContact)
  {
    switch (paramInt)
    {
    case 1: 
    case 2: 
    default: 
      return "";
    }
    if ((paramFriends != null) && (paramFriends.isFriend()))
    {
      if (!TextUtils.isEmpty(paramFriends.remark)) {
        return paramFriends.remark;
      }
      return paramFriends.name;
    }
    if (paramPhoneContact != null) {
      return paramPhoneContact.name;
    }
    if ((paramFriends != null) && (!TextUtils.isEmpty(paramFriends.name))) {
      return paramFriends.name;
    }
    return paramString;
  }
  
  public static String c(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = ((DiscussionManager)paramQQAppInterface.getManager(52)).a(paramString);
    if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramQQAppInterface.discussionName))) {
      return paramQQAppInterface.discussionName;
    }
    return null;
  }
  
  public static String c(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    FriendsManager localFriendsManager = (FriendsManager)paramQQAppInterface.getManager(50);
    Object localObject1 = (DiscussionManager)paramQQAppInterface.getManager(52);
    if (paramString2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ContactUtils", 2, "getDiscussionMemberShowName uin is null");
      }
      paramQQAppInterface = "";
      return paramQQAppInterface;
    }
    Object localObject2 = ((DiscussionManager)localObject1).a(paramString1);
    if ((localObject2 != null) && (((DiscussionInfo)localObject2).isDiscussHrMeeting())) {}
    for (boolean bool = true;; bool = false)
    {
      localObject2 = localFriendsManager.a(paramString2);
      if ((localObject2 != null) && (((Friends)localObject2).isFriend()) && (!bool))
      {
        if (!TextUtils.isEmpty(((Friends)localObject2).remark)) {
          return ((Friends)localObject2).remark;
        }
        if (!TextUtils.isEmpty(((Friends)localObject2).name)) {
          return ((Friends)localObject2).name;
        }
        paramQQAppInterface = paramString2;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ContactUtils", 2, "getDiscussionMemberShowName is friend but no name.");
        return paramString2;
      }
      localObject1 = ((DiscussionManager)localObject1).a(paramString1);
      if (localObject1 != null)
      {
        localObject2 = (DiscussionMemberInfo)((Map)localObject1).get(paramString2);
        if (localObject2 != null)
        {
          localObject1 = ((DiscussionMemberInfo)localObject2).inteRemark;
          localObject2 = ((DiscussionMemberInfo)localObject2).memberName;
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            if (QLog.isDevelopLevel()) {
              QLog.w("ContactUtils", 1, "getDiscussionMemberShowName, discussionShowName[" + Utils.a((String)localObject1) + "], discussionUin[" + paramString1 + "], memberUin[" + paramString2 + "], bIsDiscHrMeeting[" + bool + "]");
            }
            if (localObject1 != null)
            {
              paramString1 = (String)localObject1;
              if (((String)localObject1).trim().length() != 0) {}
            }
            else
            {
              if (!bool) {
                break label319;
              }
              paramString1 = QAVHrMeeting.a();
            }
          }
        }
      }
      for (;;)
      {
        return paramString1;
        localObject1 = localObject2;
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          break;
        }
        localObject1 = null;
        break;
        label319:
        paramString1 = localFriendsManager.c(paramString2);
        if (paramString1 != null)
        {
          paramString1 = paramString1.name;
        }
        else
        {
          ((FriendListHandler)paramQQAppInterface.a(1)).a(paramString2, false);
          paramString1 = paramString2;
        }
      }
    }
  }
  
  public static String c(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    if ((paramString == null) || ("".equals(paramString)))
    {
      paramQQAppInterface = "";
      return paramQQAppInterface;
    }
    Object localObject1 = (FriendsManager)paramQQAppInterface.getManager(50);
    if (localObject1 != null)
    {
      Object localObject2 = ((FriendsManager)localObject1).c(paramString);
      if (localObject2 != null)
      {
        localObject2 = ((Friends)localObject2).name;
        if (localObject2 != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ContactUtils", 2, StringUtil.a(new Object[] { "FriendEntity getBuddyNickName()", paramString, Boolean.valueOf(paramBoolean) }));
          }
          return localObject2;
        }
      }
    }
    if (localObject1 != null) {}
    for (localObject1 = ((FriendsManager)localObject1).a(paramString);; localObject1 = null)
    {
      if (localObject1 != null)
      {
        localObject1 = ((Card)localObject1).strNick;
        if (localObject1 != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ContactUtils", 2, StringUtil.a(new Object[] { "FriendCard getBuddyNickName()", paramString, Boolean.valueOf(paramBoolean) }));
          }
          return localObject1;
        }
      }
      if (paramBoolean) {
        ((ContactFacade)paramQQAppInterface.getManager(53)).a().b(paramString);
      }
      paramQQAppInterface = paramString;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ContactUtils", 2, StringUtil.a(new Object[] { "getBuddyNickName()", paramString, Boolean.valueOf(paramBoolean) }));
      return paramString;
    }
  }
  
  public static String c(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return "";
    }
    int m = paramString.length();
    int k = 0;
    int j = 0;
    char c1 = '\000';
    while (k < m)
    {
      int i = paramString.charAt(k);
      if (k == 0) {
        c1 = i;
      }
      if (k == 1) {
        j = i;
      }
      if ((i >= 19968) && (i <= 40869)) {
        return String.valueOf(i);
      }
      k += 1;
    }
    if ((c1 >= '!') && (c1 <= '~'))
    {
      if ((j >= 33) && (j <= 126)) {
        return String.valueOf(new char[] { c1, j });
      }
      return String.valueOf(c1);
    }
    return "?";
  }
  
  public static String d(QQAppInterface paramQQAppInterface, String paramString)
  {
    DiscussionInfo localDiscussionInfo = ((DiscussionManager)paramQQAppInterface.getManager(52)).a(paramString);
    paramQQAppInterface = paramString;
    if (localDiscussionInfo != null)
    {
      paramQQAppInterface = paramString;
      if (!TextUtils.isEmpty(localDiscussionInfo.discussionName)) {
        paramQQAppInterface = localDiscussionInfo.discussionName;
      }
    }
    return paramQQAppInterface;
  }
  
  public static String d(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(51);
    paramString2 = paramQQAppInterface.c(paramString2);
    if (paramString2 == null) {
      return paramString1;
    }
    return paramQQAppInterface.a(paramString2, paramString1);
  }
  
  public static String e(QQAppInterface paramQQAppInterface, String paramString)
  {
    int j = 0;
    int i = 1;
    Object localObject2 = (DiscussionManager)paramQQAppInterface.getManager(52);
    if (localObject2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ContactUtils", 2, " ===getPstnDiscussionName dm is null ====");
      }
      localObject2 = "";
      return localObject2;
    }
    Object localObject1 = ((DiscussionManager)localObject2).a(paramString);
    if (localObject1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ContactUtils", 2, " ===getPstnDiscussionName info is null ====");
      }
      i = 0;
    }
    if ((i != 0) && (((DiscussionInfo)localObject1).hasRenamed())) {
      return a(BaseApplicationImpl.getContext(), (DiscussionInfo)localObject1);
    }
    localObject2 = ((DiscussionManager)localObject2).a(paramString);
    if (i != 0) {}
    for (localObject1 = a(paramQQAppInterface, ((DiscussionInfo)localObject1).ownerUin, (Map)localObject2);; localObject1 = "")
    {
      localObject2 = localObject1;
      if (((String)localObject1).length() >= 47) {
        break;
      }
      Object localObject3 = (PhoneContactManager)paramQQAppInterface.getManager(10);
      List localList = PstnUtils.a(paramQQAppInterface, paramString, 3000);
      localObject2 = localObject1;
      if (localList == null) {
        break;
      }
      localObject2 = localObject1;
      if (localList.size() == 0) {
        break;
      }
      ArrayList localArrayList = new ArrayList();
      i = j;
      if (i < localList.size())
      {
        localObject2 = ((AVPhoneUserInfo)localList.get(i)).telInfo.mobile;
        paramString = ((PhoneContactManager)localObject3).b((String)localObject2);
        paramQQAppInterface = "?";
        if (paramString != null) {
          if (!TextUtils.isEmpty(paramString.name))
          {
            paramString = paramString.name;
            paramQQAppInterface = paramString;
            if (paramString.equals(localObject2)) {
              paramQQAppInterface = b(paramString);
            }
          }
        }
        for (;;)
        {
          localArrayList.add(paramQQAppInterface);
          i += 1;
          break;
          if (!TextUtils.isEmpty(paramString.mobileNo))
          {
            paramQQAppInterface = b(paramString.mobileNo);
            continue;
            paramQQAppInterface = b((String)localObject2);
          }
        }
      }
      localObject3 = new ContactSorter.PhoneNameComparator();
      paramQQAppInterface = (QQAppInterface)localObject1;
      if (localArrayList != null)
      {
        paramQQAppInterface = (QQAppInterface)localObject1;
        if (localArrayList.size() > 0)
        {
          paramQQAppInterface = (QQAppInterface)localObject1;
          if (QLog.isColorLevel())
          {
            QLog.i("ContactUtils", 2, " ===getPstnDiscussionName phoneNames: " + localArrayList.toString());
            paramQQAppInterface = (QQAppInterface)localObject1;
          }
        }
      }
      do
      {
        localObject2 = paramQQAppInterface;
        if (localArrayList.size() <= 0) {
          break;
        }
        paramString = (String)Collections.min(localArrayList, (Comparator)localObject3);
        localArrayList.remove(paramString);
        paramString = a(48, paramQQAppInterface, paramString);
        paramQQAppInterface = paramString;
      } while (paramString.length() < 47);
      return paramString;
    }
  }
  
  public static String e(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    TroopManager localTroopManager = (TroopManager)paramQQAppInterface.getManager(51);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ContactUtils", 2, "getTroopMemberNameWithoutRemark uin is null");
      }
      return "";
    }
    TroopMemberInfo localTroopMemberInfo = localTroopManager.b(paramString1, paramString2);
    paramQQAppInterface = ((FriendsManager)paramQQAppInterface.getManager(50)).a(paramString2);
    if ((localTroopMemberInfo != null) && (!TextUtils.isEmpty(localTroopMemberInfo.troopnick))) {
      paramQQAppInterface = localTroopMemberInfo.troopnick;
    }
    for (;;)
    {
      if ((paramQQAppInterface != null) && (paramQQAppInterface.equals(paramString2)))
      {
        paramString1 = localTroopManager.a(paramString1);
        if ((paramString1 != null) && (paramString1.isQidianPrivateTroop()))
        {
          return "群成员";
          if ((paramQQAppInterface != null) && (paramQQAppInterface.isFriend()))
          {
            paramQQAppInterface = paramQQAppInterface.name;
            continue;
          }
          if ((localTroopMemberInfo == null) || (TextUtils.isEmpty(localTroopMemberInfo.friendnick))) {
            break label165;
          }
          paramQQAppInterface = localTroopMemberInfo.friendnick;
          continue;
        }
      }
      return paramQQAppInterface;
      label165:
      paramQQAppInterface = "";
    }
  }
  
  public static String f(QQAppInterface paramQQAppInterface, String paramString)
  {
    FriendsManager localFriendsManager = (FriendsManager)paramQQAppInterface.getManager(50);
    String str2 = localFriendsManager.b(paramString);
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
    {
      Card localCard = localFriendsManager.a(paramString);
      str1 = str2;
      if (localCard != null)
      {
        str1 = str2;
        if (!TextUtils.isEmpty(localCard.strCampusName))
        {
          str1 = localCard.strCampusName;
          localFriendsManager.c(paramString, str1);
        }
      }
    }
    if (TextUtils.isEmpty(str1)) {
      ((ContactFacade)paramQQAppInterface.getManager(53)).a().d(paramString);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ContactUtils", 2, String.format(Locale.getDefault(), "getCampusCirCleRealName uin: %s, name: %s", new Object[] { Utils.b(paramString), Utils.b(str1) }));
    }
    return str1;
  }
  
  public static String f(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    Friends localFriends = ((FriendsManager)paramQQAppInterface.getManager(50)).a(paramString2);
    if ((localFriends != null) && (localFriends.isFriend()) && (!TextUtils.isEmpty(localFriends.remark))) {
      return localFriends.remark;
    }
    return g(paramQQAppInterface, paramString1, paramString2);
  }
  
  public static String g(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = (PhoneContactManager)paramQQAppInterface.getManager(10);
    if (paramQQAppInterface != null) {
      return paramQQAppInterface.a(paramString);
    }
    return "";
  }
  
  public static String g(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    Object localObject = (FriendsManager)paramQQAppInterface.getManager(50);
    TroopManager localTroopManager = (TroopManager)paramQQAppInterface.getManager(51);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ContactUtils", 2, "getTroopMemberName uin is null");
      }
      paramQQAppInterface = "";
      return paramQQAppInterface;
    }
    localObject = ((FriendsManager)localObject).a(paramString2);
    TroopMemberInfo localTroopMemberInfo = localTroopManager.b(paramString1, paramString2);
    if ((localTroopMemberInfo != null) && (!TextUtils.isEmpty(localTroopMemberInfo.troopnick))) {
      paramQQAppInterface = localTroopMemberInfo.troopnick;
    }
    for (;;)
    {
      localObject = paramQQAppInterface;
      if (TextUtils.isEmpty(paramQQAppInterface)) {
        localObject = paramString2;
      }
      paramQQAppInterface = (QQAppInterface)localObject;
      if (localObject == null) {
        break;
      }
      paramQQAppInterface = (QQAppInterface)localObject;
      if (!((String)localObject).equals(paramString2)) {
        break;
      }
      paramString1 = localTroopManager.a(paramString1);
      paramQQAppInterface = (QQAppInterface)localObject;
      if (paramString1 == null) {
        break;
      }
      paramQQAppInterface = (QQAppInterface)localObject;
      if (!paramString1.isQidianPrivateTroop()) {
        break;
      }
      return "群成员";
      if ((localObject != null) && (((Friends)localObject).isFriend()) && (!TextUtils.isEmpty(((Friends)localObject).remark))) {
        paramQQAppInterface = ((Friends)localObject).remark;
      } else if ((localObject != null) && (((Friends)localObject).isFriend())) {
        paramQQAppInterface = ((Friends)localObject).name;
      } else if (localTroopMemberInfo != null)
      {
        if (paramString2.equals(paramQQAppInterface.getCurrentAccountUin())) {
          paramQQAppInterface = paramQQAppInterface.getCurrentNickname();
        } else if (!TextUtils.isEmpty(localTroopMemberInfo.autoremark)) {
          paramQQAppInterface = localTroopMemberInfo.autoremark;
        } else {
          paramQQAppInterface = localTroopMemberInfo.friendnick;
        }
      }
      else {
        paramQQAppInterface = null;
      }
    }
  }
  
  public static String h(QQAppInterface paramQQAppInterface, String paramString)
  {
    return ((PhoneContactManager)paramQQAppInterface.getManager(10)).b(paramString);
  }
  
  public static String h(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    if (paramQQAppInterface == null) {
      return "";
    }
    paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(51);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ContactUtils", 2, "getTroopMemberNick uin is null");
      }
      return "";
    }
    paramQQAppInterface = paramQQAppInterface.b(paramString1, paramString2);
    if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramQQAppInterface.troopnick))) {
      return paramQQAppInterface.troopnick;
    }
    return "";
  }
  
  public static String i(QQAppInterface paramQQAppInterface, String paramString)
  {
    Object localObject = ((HotChatManager)paramQQAppInterface.getManager(59)).a(paramString);
    if (localObject != null) {
      paramQQAppInterface = ((HotChatInfo)localObject).name + "热聊";
    }
    do
    {
      do
      {
        return paramQQAppInterface;
        localObject = ((TroopManager)paramQQAppInterface.getManager(51)).a(paramString);
        paramQQAppInterface = paramString;
      } while (localObject == null);
      paramQQAppInterface = paramString;
    } while (((TroopInfo)localObject).getTroopName() == null);
    return ((TroopInfo)localObject).getTroopName();
  }
  
  public static String j(QQAppInterface paramQQAppInterface, String paramString)
  {
    Object localObject = null;
    if (paramString == null) {
      paramString = null;
    }
    label91:
    label94:
    for (;;)
    {
      return paramString;
      String str = paramQQAppInterface.getApplication().getProperty(Constants.PropertiesKey.nickName.toString() + paramString);
      if (TextUtils.isEmpty(str))
      {
        paramQQAppInterface = (FriendsManager)paramQQAppInterface.getManager(50);
        if (paramQQAppInterface == null)
        {
          paramQQAppInterface = localObject;
          if (paramQQAppInterface == null) {
            break label91;
          }
        }
      }
      for (paramQQAppInterface = paramQQAppInterface.name;; paramQQAppInterface = str)
      {
        if (TextUtils.isEmpty(paramQQAppInterface)) {
          break label94;
        }
        return paramQQAppInterface;
        paramQQAppInterface = paramQQAppInterface.c(paramString);
        break;
      }
    }
  }
  
  public static String k(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = (FriendsManager)paramQQAppInterface.getManager(50);
    Object localObject = paramQQAppInterface.c(paramString);
    if ((localObject != null) && (!TextUtils.isEmpty(((Friends)localObject).name))) {
      paramQQAppInterface = ((Friends)localObject).name;
    }
    do
    {
      do
      {
        return paramQQAppInterface;
        localObject = paramQQAppInterface.a(paramString);
        paramQQAppInterface = paramString;
      } while (localObject == null);
      paramQQAppInterface = paramString;
    } while (TextUtils.isEmpty(((Card)localObject).strNick));
    return ((Card)localObject).strNick;
  }
  
  public static String l(QQAppInterface paramQQAppInterface, String paramString)
  {
    Friends localFriends = ((FriendsManager)paramQQAppInterface.getManager(50)).c(paramString);
    paramQQAppInterface = (PhoneContactManager)paramQQAppInterface.getManager(10);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.a(paramString);
      if (paramQQAppInterface == null) {}
    }
    for (paramQQAppInterface = paramQQAppInterface.name;; paramQQAppInterface = null)
    {
      if (localFriends != null) {
        paramString = a(localFriends, paramQQAppInterface);
      }
      return paramString;
    }
  }
  
  public static String m(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramString = ((FriendsManager)paramQQAppInterface.getManager(50)).c(paramString);
    paramQQAppInterface = (PhoneContactManager)paramQQAppInterface.getManager(10);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.a("");
      if (paramQQAppInterface == null) {}
    }
    for (paramQQAppInterface = paramQQAppInterface.name;; paramQQAppInterface = null)
    {
      if (paramString != null) {
        return b(paramString, paramQQAppInterface);
      }
      return "";
    }
  }
  
  public static String n(QQAppInterface paramQQAppInterface, String paramString)
  {
    Friends localFriends = ((FriendsManager)paramQQAppInterface.getManager(50)).c(paramString);
    paramQQAppInterface = (PhoneContactManager)paramQQAppInterface.getManager(10);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.a(paramString);
      if (paramQQAppInterface == null) {}
    }
    for (paramQQAppInterface = paramQQAppInterface.name;; paramQQAppInterface = null)
    {
      if (localFriends != null)
      {
        if ((localFriends.remark != null) && (localFriends.remark.length() > 0)) {
          paramString = localFriends.remark;
        }
      }
      else {
        return paramString;
      }
      if ((localFriends.name != null) && (localFriends.name.length() > 0)) {
        return localFriends.name;
      }
      if ((paramQQAppInterface != null) && (paramQQAppInterface.length() > 0)) {
        return paramQQAppInterface;
      }
      return localFriends.uin;
    }
  }
  
  public static String o(QQAppInterface paramQQAppInterface, String paramString)
  {
    String str = ((TroopManager)paramQQAppInterface.getManager(51)).c(paramString);
    if (str == null) {
      return paramString;
    }
    return b(paramQQAppInterface, str, 1);
  }
  
  public static String p(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      paramQQAppInterface = "";
    }
    Friends localFriends;
    do
    {
      do
      {
        do
        {
          return paramQQAppInterface;
          localFriends = ((FriendsManager)paramQQAppInterface.getManager(50)).a(paramString);
          paramQQAppInterface = paramString;
        } while (localFriends == null);
        paramQQAppInterface = paramString;
      } while (!localFriends.isFriend());
      if (!TextUtils.isEmpty(localFriends.remark)) {
        return localFriends.remark;
      }
      paramQQAppInterface = paramString;
    } while (TextUtils.isEmpty(localFriends.name));
    return localFriends.name;
  }
  
  public static String q(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramString == null) || ("".equals(paramString)))
    {
      localObject = "";
      return localObject;
    }
    long l = 0L;
    Object localObject = ((FriendsManager)paramQQAppInterface.getManager(50)).a(paramString);
    String str;
    if (localObject != null)
    {
      str = ((DateNickNameInfo)localObject).nickName;
      l = ((DateNickNameInfo)localObject).lastUpdateTime;
    }
    for (;;)
    {
      if (str != null)
      {
        localObject = str;
        if (Math.abs(System.currentTimeMillis() - l) < 86400000L) {
          break;
        }
      }
      if (str == null) {
        str = "";
      }
      for (;;)
      {
        ((ContactFacade)paramQQAppInterface.getManager(53)).a().c(paramString);
        return str;
      }
      str = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.utils.ContactUtils
 * JD-Core Version:    0.7.0.1
 */