package com.tencent.open.agent;

import alcb;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.open.agent.datamodel.FriendDataManager;
import com.tencent.open.base.LogUtility;
import com.tencent.widget.XListView;

public class GroupListOpenFrame
  extends OpenFrame
{
  protected EditText a;
  protected TextView a;
  protected GroupListOpenFrame.GroupListAdapter a;
  protected RecommendListManager a;
  protected XListView a;
  protected TextView b;
  
  public GroupListOpenFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentOpenAgentRecommendListManager.b();
    LogUtility.c("GroupListOpenFrame", "-->onResume()");
    super.a();
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    LogUtility.c("GroupListOpenFrame", "-->onCreate()");
    super.setContentView(2130971570);
    this.jdField_a_of_type_ComTencentOpenAgentGroupListOpenFrame$GroupListAdapter = new GroupListOpenFrame.GroupListAdapter(this);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)super.findViewById(2131366744));
    paramBundle = (LinearLayout)super.a().getLayoutInflater().inflate(2130969261, null);
    paramBundle.findViewById(2131368321).setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramBundle.findViewById(2131365801));
    this.b = ((TextView)paramBundle.findViewById(2131365808));
    this.jdField_a_of_type_ComTencentOpenAgentRecommendListManager = ((RecommendListManager)paramBundle.findViewById(2131365802));
    this.jdField_a_of_type_ComTencentOpenAgentRecommendListManager.setActivity(this.jdField_a_of_type_ComTencentOpenAgentFriendChooser);
    this.jdField_a_of_type_ComTencentOpenAgentRecommendListManager.a();
    this.jdField_a_of_type_ComTencentWidgetXListView.setSelector(2131492924);
    this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView(paramBundle);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentOpenAgentGroupListOpenFrame$GroupListAdapter);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)paramBundle.findViewById(2131368322));
    this.jdField_a_of_type_AndroidWidgetEditText.setOnTouchListener(new alcb(this));
  }
  
  public void a(String paramString)
  {
    this.b.setText(paramString);
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    LogUtility.c("GroupListOpenFrame", "-->onStart()");
    this.jdField_a_of_type_ComTencentOpenAgentFriendChooser.a(false, true, "", this.jdField_a_of_type_ComTencentOpenAgentFriendChooser.getString(2131428609));
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentOpenAgentDatamodelFriendDataManager.a() == 0)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentOpenAgentRecommendListManager.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentOpenAgentGroupListOpenFrame$GroupListAdapter.notifyDataSetChanged();
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_ComTencentOpenAgentRecommendListManager.setVisibility(0);
      this.jdField_a_of_type_ComTencentOpenAgentRecommendListManager.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.open.agent.GroupListOpenFrame
 * JD-Core Version:    0.7.0.1
 */