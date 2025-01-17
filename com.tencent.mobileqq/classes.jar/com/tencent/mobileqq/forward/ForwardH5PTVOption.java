package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ForwardH5PTVOption
  extends ForwardBaseOption
{
  protected ResultReceiver a;
  
  public ForwardH5PTVOption(Intent paramIntent)
  {
    super(paramIntent);
    this.jdField_b_of_type_Boolean = true;
  }
  
  public List a(List paramList)
  {
    ArrayList localArrayList = new ArrayList();
    FriendsManager localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
    int i = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("choose_friend_h5_type", 0);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      RecentUser localRecentUser = (RecentUser)paramList.next();
      if ((localRecentUser != null) && ((localRecentUser.type != 1006) || (a(ForwardAbility.ForwardAbilityType.h))) && (localRecentUser.type != 9501) && (localRecentUser.type != 6004) && (localRecentUser.type != 7000)) {
        if ((localRecentUser.type == 0) && (!Utils.a(localRecentUser.uin)) && (!Utils.c(localRecentUser.uin)) && (!CrmUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRecentUser.uin, localRecentUser.type)))
        {
          if ((localFriendsManager != null) && (localFriendsManager.b(localRecentUser.uin)) && ((i == 1) || (i == 13))) {
            localArrayList.add(localRecentUser);
          }
        }
        else if (localRecentUser.type == 1)
        {
          if ((i == 4) || (i == 13) || (i == 12)) {
            localArrayList.add(localRecentUser);
          }
        }
        else if ((localRecentUser.type == 3000) && ((i == 8) || (i == 13) || (i == 12))) {
          localArrayList.add(localRecentUser);
        }
      }
    }
    return localArrayList;
  }
  
  protected void a()
  {
    this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("choose_friend_is_qqfriends", true);
    this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("choose_friend_is_contacts", false);
    int i = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("choose_friend_h5_type", 0);
    if (QLog.isColorLevel()) {
      QLog.d("h5ptv", 2, "bType=" + i);
    }
    if ((i == 1) && (j())) {
      this.jdField_a_of_type_JavaUtilSet.add(jdField_b_of_type_JavaLangInteger);
    }
    if (i == 4) {
      this.jdField_a_of_type_JavaUtilSet.add(c);
    }
    if (i == 8) {
      this.jdField_a_of_type_JavaUtilSet.add(d);
    }
    if (i == 13)
    {
      this.jdField_a_of_type_JavaUtilSet.add(jdField_b_of_type_JavaLangInteger);
      this.jdField_a_of_type_JavaUtilSet.add(c);
      this.jdField_a_of_type_JavaUtilSet.add(d);
    }
    if (i == 12)
    {
      this.jdField_a_of_type_JavaUtilSet.add(c);
      this.jdField_a_of_type_JavaUtilSet.add(d);
    }
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
      return;
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    ArrayList localArrayList4 = new ArrayList();
    paramInt = paramBundle.getInt("uintype", -1);
    if ((paramInt == 0) || (paramInt == 1004))
    {
      localArrayList1.add(paramBundle.getString("uin"));
      localArrayList2.add("");
      localArrayList3.add(paramBundle.getString("uinname"));
      localArrayList4.add("1");
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidOsResultReceiver != null)
      {
        paramBundle = new Bundle();
        paramBundle.putStringArrayList("choose_friend_uins", localArrayList1);
        paramBundle.putStringArrayList("choose_friend_phones", localArrayList2);
        paramBundle.putStringArrayList("choose_friend_names", localArrayList3);
        paramBundle.putStringArrayList("choose_friend_types", localArrayList4);
        this.jdField_a_of_type_AndroidOsResultReceiver.send(0, paramBundle);
      }
      if (this.jdField_a_of_type_AndroidAppActivity == null) {
        break;
      }
      this.jdField_a_of_type_AndroidAppActivity.setResult(1);
      this.jdField_a_of_type_AndroidAppActivity.finish();
      return;
      if (paramInt == 1006)
      {
        localArrayList1.add("");
        localArrayList2.add(paramBundle.getString("uin"));
        localArrayList3.add(paramBundle.getString("uinname"));
        localArrayList4.add("2");
      }
      else if (paramInt == 1)
      {
        localArrayList1.add(paramBundle.getString("uin"));
        localArrayList2.add("");
        localArrayList3.add(paramBundle.getString("uinname"));
        localArrayList4.add("4");
      }
      else if (paramInt == 3000)
      {
        localArrayList1.add(paramBundle.getString("uin"));
        localArrayList2.add("");
        localArrayList3.add(paramBundle.getString("uinname"));
        localArrayList4.add("8");
      }
    }
  }
  
  public boolean a()
  {
    super.a();
    this.jdField_a_of_type_AndroidOsResultReceiver = ((ResultReceiver)this.jdField_a_of_type_AndroidContentIntent.getParcelableExtra("choose_friend_callback"));
    return true;
  }
  
  public String b()
  {
    String str2 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("choose_friend_title");
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "选择好友";
    }
    return str1;
  }
  
  public boolean d()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardH5PTVOption
 * JD-Core Version:    0.7.0.1
 */