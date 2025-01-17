package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.adapter.RecommendFriendAdapter;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.MayknowRecommendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import toi;
import toj;

public class RecommendFriendActivity
  extends BaseActivity
{
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private RecommendFriendAdapter jdField_a_of_type_ComTencentMobileqqAdapterRecommendFriendAdapter;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new toi(this);
  private MayknowRecommendManager jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private TextView b;
  private TextView c;
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130968612);
    int i = getIntent().getIntExtra("EntranceId", 0);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131362840));
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setFitsSystemWindows(true);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setPadding(0, ImmersiveUtils.a(this), 0, 0);
    }
    this.c = ((TextView)findViewById(2131362864));
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131362863));
    this.jdField_a_of_type_ComTencentMobileqqAdapterRecommendFriendAdapter = new RecommendFriendAdapter(this, this.app, this.jdField_a_of_type_ComTencentWidgetXListView, i);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363381));
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131433963);
    setTitle(getString(2131433963));
    this.b = ((TextView)findViewById(2131363245));
    this.b.setVisibility(0);
    this.b.setText(2131433698);
    this.b.setOnClickListener(new toj(this));
    this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager = ((MayknowRecommendManager)this.app.getManager(158));
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager.a();
    if (paramBundle.size() > 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqAdapterRecommendFriendAdapter.a(paramBundle);
      this.c.setVisibility(8);
      return true;
    }
    this.c.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager.b();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterRecommendFriendAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqAdapterRecommendFriendAdapter.X_();
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterRecommendFriendAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqAdapterRecommendFriendAdapter.b();
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterRecommendFriendAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqAdapterRecommendFriendAdapter.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RecommendFriendActivity
 * JD-Core Version:    0.7.0.1
 */