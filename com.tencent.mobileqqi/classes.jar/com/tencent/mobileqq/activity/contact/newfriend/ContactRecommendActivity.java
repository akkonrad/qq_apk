package com.tencent.mobileqq.activity.contact.newfriend;

import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import ejf;
import ejg;

public class ContactRecommendActivity
  extends IphoneTitleBarActivity
{
  private static final String jdField_a_of_type_JavaLangString = "ContactRecommendActivity";
  private static final boolean jdField_a_of_type_Boolean = true;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private BaseNewFriendView.INewFriendContext jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView$INewFriendContext;
  private RecommendListView jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendRecommendListView;
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView$INewFriendContext = new ejf(this);
  }
  
  private void f()
  {
    j(2130837729);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(this);
    Object localObject = new FrameLayout.LayoutParams(-1, -1);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    setContentView(this.jdField_a_of_type_AndroidWidgetFrameLayout);
    setTitle(2131562732);
    this.k.setVisibility(8);
    b(2131562931, new ejg(this));
    d(true);
    localObject = getIntent();
    ((Intent)localObject).putExtra("key_work_mode", 1);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendRecommendListView = new RecommendListView(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendRecommendListView.a((Intent)localObject, this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView$INewFriendContext);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendRecommendListView);
  }
  
  public void d()
  {
    Intent localIntent = new Intent(this, SplashActivity.class);
    localIntent.putExtra("tab_index", 0);
    localIntent.addFlags(67108864);
    startActivity(localIntent);
    overridePendingTransition(2130968617, 0);
    finish();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    e();
    f();
    return true;
  }
  
  protected void doOnDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendRecommendListView.h();
    super.doOnDestroy();
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendRecommendListView.d();
  }
  
  protected void doOnStop()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendRecommendListView.g();
    super.doOnStop();
  }
  
  public void onBackPressed()
  {
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.ContactRecommendActivity
 * JD-Core Version:    0.7.0.1
 */