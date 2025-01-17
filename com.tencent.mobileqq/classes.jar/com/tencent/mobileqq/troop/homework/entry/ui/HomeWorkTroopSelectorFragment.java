package com.tencent.mobileqq.troop.homework.entry.ui;

import ajgl;
import ajgm;
import ajgn;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import mqq.os.MqqHandler;

public class HomeWorkTroopSelectorFragment
  extends IphoneTitleBarFragment
  implements Runnable
{
  private ajgn jdField_a_of_type_Ajgn;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TroopInfo jdField_a_of_type_ComTencentMobileqqDataTroopInfo;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private String jdField_a_of_type_JavaLangString = "";
  private List jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  
  public static void a(Activity paramActivity, String paramString, ArrayList paramArrayList)
  {
    Intent localIntent = new Intent();
    if (!TextUtils.isEmpty(paramString)) {
      localIntent.putExtra("HomeWorkTroopSelectorFragment:my_troop_uin", paramString);
    }
    if (paramArrayList != null) {
      localIntent.putExtra("HomeWorkTroopSelectorFragment:select_troop_uin", paramArrayList);
    }
    PublicFragmentActivity.a(paramActivity, localIntent, HomeWorkTroopSelectorFragment.class, 263);
  }
  
  private void a(List paramList)
  {
    if (this.jdField_a_of_type_ComTencentWidgetListView != null)
    {
      this.jdField_a_of_type_Ajgn = new ajgn(getActivity(), paramList, this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo, this.jdField_a_of_type_JavaUtilList);
      this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(this.jdField_a_of_type_Ajgn);
    }
  }
  
  protected int a()
  {
    return 2130969916;
  }
  
  protected void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_ComTencentWidgetListView = ((ListView)this.e.findViewById(2131368462));
    this.jdField_a_of_type_ComTencentWidgetListView.setDivider(null);
    this.jdField_a_of_type_ComTencentWidgetListView.setDividerHeight(0);
    if (getActivity() == null) {}
    for (paramLayoutInflater = null;; paramLayoutInflater = (QQAppInterface)getActivity().getAppInterface())
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramLayoutInflater;
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
        break;
      }
      getActivity().finish();
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    b(2131430644, new ajgl(this));
    a("我管理的群");
    paramLayoutInflater = getArguments();
    if (paramLayoutInflater != null)
    {
      this.jdField_a_of_type_JavaLangString = paramLayoutInflater.getString("HomeWorkTroopSelectorFragment:my_troop_uin");
      if (this.jdField_a_of_type_JavaLangString == null) {
        this.jdField_a_of_type_JavaLangString = "";
      }
      this.jdField_a_of_type_JavaUtilList = paramLayoutInflater.getStringArrayList("HomeWorkTroopSelectorFragment:select_troop_uin");
      if (this.jdField_a_of_type_JavaUtilList == null) {
        this.jdField_a_of_type_JavaUtilList = new ArrayList();
      }
    }
    ThreadManager.postImmediately(this, null, true);
  }
  
  public boolean d()
  {
    this.jdField_a_of_type_Boolean = false;
    return super.d();
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    TroopManager localTroopManager;
    Object localObject1;
    do
    {
      do
      {
        do
        {
          return;
          localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
        } while (localTroopManager == null);
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(-2);
      } while (localObject1 == null);
      localObject1 = (String[])((HashMap)localObject1).get(Integer.valueOf(-2));
      if (this.jdField_a_of_type_JavaLangString == null) {
        this.jdField_a_of_type_JavaLangString = "";
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = localTroopManager.a(this.jdField_a_of_type_JavaLangString);
      }
    } while (localObject1 == null);
    LinkedList localLinkedList = new LinkedList();
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      Object localObject2 = localObject1[i];
      if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!this.jdField_a_of_type_JavaLangString.equals(localObject2)))
      {
        localObject2 = localTroopManager.a((String)localObject2);
        if ((localObject2 != null) && (((((TroopInfo)localObject2).dwAdditionalFlag & 1L) == 1L) || ((((TroopInfo)localObject2).dwCmdUinUinFlag & 1L) == 1L))) {
          localLinkedList.add(localObject2);
        }
      }
      i += 1;
    }
    ThreadManager.getUIHandler().post(new ajgm(this, localLinkedList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.entry.ui.HomeWorkTroopSelectorFragment
 * JD-Core Version:    0.7.0.1
 */