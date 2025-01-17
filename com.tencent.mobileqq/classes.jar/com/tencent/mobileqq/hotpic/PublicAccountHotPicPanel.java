package com.tencent.mobileqq.hotpic;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.widget.XPanelContainer;

@TargetApi(15)
public class PublicAccountHotPicPanel
  extends HotPicMainPanel
{
  PublicAccountGifListener a;
  
  public PublicAccountHotPicPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  @TargetApi(14)
  public void a(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, PanelIconLinearLayout paramPanelIconLinearLayout, XPanelContainer paramXPanelContainer)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout = paramPanelIconLinearLayout;
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer = paramXPanelContainer;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = new SessionInfo();
    this.jdField_a_of_type_AndroidViewView = findViewById(2131362727);
    this.c = findViewById(2131362992);
    this.b = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130968640, null);
    this.b.setVisibility(8);
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager = ((ViewPager)findViewById(2131362990));
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTab = ((HotPicTab)findViewById(2131362991));
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTab.setOnItemClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a = 1008;
  }
  
  public void c() {}
  
  public void d() {}
  
  public void setPublicAccountGifListener(PublicAccountGifListener paramPublicAccountGifListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqHotpicPublicAccountGifListener = paramPublicAccountGifListener;
    HotPicManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramPublicAccountGifListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.PublicAccountHotPicPanel
 * JD-Core Version:    0.7.0.1
 */