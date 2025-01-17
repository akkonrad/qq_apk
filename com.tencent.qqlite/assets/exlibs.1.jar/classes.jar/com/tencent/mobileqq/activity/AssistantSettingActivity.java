package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.pic.PreDownloadStrategyAlpha;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import cooperation.qzone.LocalMultiProcConfig;
import xy;
import xz;
import ya;
import yb;
import yc;
import yd;
import ye;
import yf;
import yg;

public class AssistantSettingActivity
  extends IphoneTitleBarActivity
{
  public static int a = 0;
  static final int jdField_b_of_type_Int = 1;
  static final int jdField_c_of_type_Int = 1000;
  static final int jdField_d_of_type_Int = 0;
  static final int jdField_e_of_type_Int = 1;
  public Handler a;
  private View jdField_a_of_type_AndroidViewView;
  private FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  public QQProgressDialog a;
  private String jdField_a_of_type_JavaLangString = "";
  private View jdField_b_of_type_AndroidViewView;
  private FormSwitchItem jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private FormSwitchItem jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private FormSwitchItem jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private FormSwitchItem jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private FormSwitchItem f;
  
  static
  {
    jdField_a_of_type_Int = 0;
  }
  
  public AssistantSettingActivity()
  {
    this.jdField_a_of_type_AndroidOsHandler = new yg(this);
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131296592));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131296590));
    this.c = ((FormSwitchItem)findViewById(2131296594));
    this.f = ((FormSwitchItem)findViewById(2131296595));
    this.d = ((FormSwitchItem)findViewById(2131296591));
    this.e = ((FormSwitchItem)findViewById(2131296593));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131296588);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131296589);
    if (PredownloadTest.a) {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    }
    if (PreDownloadStrategyAlpha.g == 0L) {
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
    }
    for (;;)
    {
      boolean bool = SettingCloneUtil.readValue(this, null, getString(2131363064), "qqsetting_screenshot_key", false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new xy(this));
      LocalMultiProcConfig.a(getString(2131363294), false);
      bool = SettingCloneUtil.readValue(this, null, getString(2131363062), "qqsetting_auto_receive_pic_key", true);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new xz(this));
      bool = SettingCloneUtil.readValue(this, null, getString(2131363081), "qqsetting_enter_sendmsg_key", false);
      this.c.setChecked(bool);
      this.c.setOnCheckedChangeListener(new ya(this));
      bool = SettingCloneUtil.readValue(this, null, null, "qqsetting_clear_memory_key", true);
      this.f.setChecked(bool);
      this.f.setOnCheckedChangeListener(new yb(this));
      bool = ConfigHandler.a(this.app, false);
      this.d.setChecked(bool);
      this.d.setOnCheckedChangeListener(new yc(this));
      bool = SettingCloneUtil.readValue(this, null, getString(2131364002), "qqsetting_notify_icon_key", false);
      this.e.setChecked(bool);
      this.e.setOnCheckedChangeListener(new yd(this));
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(new ye(this));
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(new yf(this));
      this.jdField_a_of_type_AndroidViewView.setContentDescription("流量统计");
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription("摇动手机截屏");
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription("2G/3G/4G下自动接收图片");
      this.c.setContentDescription("回车键发送消息");
      this.d.setContentDescription("WiFi下自动在后台下载新版本");
      this.e.setContentDescription("系统通知栏显示QQ图标");
      this.f.setContentDescription("内存低时自动清理内存");
      return;
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
    }
  }
  
  protected String b_()
  {
    return getString(2131363063);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903071);
    setTitle(2131363063);
    this.jdField_a_of_type_JavaLangString = this.app.a();
    setVolumeControlStream(3);
    c();
    return true;
  }
  
  protected void doOnDestroy()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      dismissDialog(1);
    }
    super.doOnDestroy();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return super.onCreateDialog(paramInt);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(getString(2131363262));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.d(true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(true);
    return this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AssistantSettingActivity
 * JD-Core Version:    0.7.0.1
 */