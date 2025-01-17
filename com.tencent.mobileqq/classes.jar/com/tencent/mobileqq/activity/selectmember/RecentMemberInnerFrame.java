package com.tencent.mobileqq.activity.selectmember;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.search.fragment.ContactSearchFragment;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import xzz;
import yaa;

public class RecentMemberInnerFrame
  extends SelectMemberInnerFrame
  implements View.OnClickListener
{
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private FriendsManager jdField_a_of_type_ComTencentMobileqqAppFriendsManager;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  private xzz jdField_a_of_type_Xzz;
  
  public RecentMemberInnerFrame(Context paramContext)
  {
    super(paramContext);
  }
  
  public RecentMemberInnerFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RecentMemberInnerFrame(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void g()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    if (localObject1 != null)
    {
      Object localObject2 = ((RecentUserProxy)localObject1).a(true);
      if (localObject2 != null)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          RecentUser localRecentUser = (RecentUser)((Iterator)localObject2).next();
          if (localRecentUser != null) {
            try
            {
              if ((localRecentUser.type == 0) && (Long.parseLong(localRecentUser.uin) >= 10000L) && (!localRecentUser.uin.equals(localObject1)) && (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.h.contains(localRecentUser.uin)))
              {
                Friends localFriends = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(localRecentUser.uin);
                if ((localFriends != null) && (localFriends.isFriend())) {
                  this.jdField_a_of_type_JavaUtilList.add(localRecentUser);
                }
              }
            }
            catch (NumberFormatException localNumberFormatException) {}
          }
        }
      }
    }
  }
  
  public ContactSearchFragment a()
  {
    return ((SelectMemberInnerFrame)this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.getChildAt(1)).a();
  }
  
  public String a()
  {
    return "-1";
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    setContentView(2130971570);
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50));
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131366744));
    this.jdField_a_of_type_ComTencentWidgetXListView.setSelector(2131492924);
    paramBundle = (RelativeLayout)this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getLayoutInflater().inflate(2130971517, this.jdField_a_of_type_ComTencentWidgetXListView, false);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)paramBundle.findViewById(2131368322));
    ((Button)paramBundle.findViewById(2131368321)).setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView(paramBundle);
    g();
    this.jdField_a_of_type_Xzz = new xzz(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Xzz);
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(true, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131435991), "最近联系人");
    if (this.jdField_a_of_type_Xzz != null) {
      this.jdField_a_of_type_Xzz.notifyDataSetChanged();
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Xzz != null) {
      this.jdField_a_of_type_Xzz.X_();
    }
    super.d();
  }
  
  public void f()
  {
    this.jdField_a_of_type_Xzz.notifyDataSetChanged();
  }
  
  public void onClick(View paramView)
  {
    yaa localyaa = (yaa)paramView.getTag();
    if ((localyaa != null) && (localyaa.jdField_a_of_type_JavaLangString != null) && (localyaa.jdField_a_of_type_AndroidWidgetCheckBox != null) && (localyaa.jdField_a_of_type_AndroidWidgetTextView != null) && (localyaa.jdField_a_of_type_AndroidWidgetCheckBox.isEnabled()))
    {
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(localyaa.jdField_a_of_type_JavaLangString, localyaa.jdField_a_of_type_AndroidWidgetTextView.getText().toString(), 0, "-1");
      localyaa.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(bool);
      if (AppSetting.b)
      {
        if (!localyaa.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
          break label130;
        }
        paramView.setContentDescription(localyaa.jdField_a_of_type_AndroidWidgetTextView.getText().toString() + "已选中,双击取消");
      }
    }
    return;
    label130:
    paramView.setContentDescription(localyaa.jdField_a_of_type_AndroidWidgetTextView.getText().toString() + "未选中,双击选中");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.RecentMemberInnerFrame
 * JD-Core Version:    0.7.0.1
 */