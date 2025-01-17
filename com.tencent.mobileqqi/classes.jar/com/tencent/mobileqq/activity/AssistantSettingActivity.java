package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.view.View;
import cau;
import cav;
import caw;
import cax;
import cay;
import caz;
import cba;
import cbb;
import cbc;
import cbd;
import cbe;
import cbf;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.magicface.view.MagicfaceViewController;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.pic.PreDownloadStrategyAlpha;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class AssistantSettingActivity
  extends IphoneTitleBarActivity
{
  public static int a = 0;
  public static final String a = "setting_aio_realtime_bg_open";
  static final int jdField_b_of_type_Int = 1;
  static final int jdField_c_of_type_Int = 1000;
  static final int jdField_d_of_type_Int = 0;
  static final int jdField_e_of_type_Int = 1;
  public Handler a;
  private View jdField_a_of_type_AndroidViewView;
  private FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  public QQProgressDialog a;
  private View jdField_b_of_type_AndroidViewView;
  private FormSwitchItem jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private String jdField_b_of_type_JavaLangString = "";
  private View jdField_c_of_type_AndroidViewView;
  private FormSwitchItem jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private FormSwitchItem jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private FormSwitchItem jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private FormSwitchItem f;
  private FormSwitchItem g;
  private FormSwitchItem h;
  private FormSwitchItem i;
  
  static
  {
    jdField_a_of_type_Int = 0;
  }
  
  public AssistantSettingActivity()
  {
    this.jdField_a_of_type_AndroidOsHandler = new cay(this);
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131231144));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131231140));
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131231141));
    this.d = ((FormSwitchItem)findViewById(2131231146));
    this.e = ((FormSwitchItem)findViewById(2131231147));
    this.i = ((FormSwitchItem)findViewById(2131231148));
    this.f = ((FormSwitchItem)findViewById(2131231143));
    this.g = ((FormSwitchItem)findViewById(2131231142));
    this.h = ((FormSwitchItem)findViewById(2131231145));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131231138);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131231137);
    this.jdField_c_of_type_AndroidViewView = findViewById(2131231139);
    if (PredownloadTest.a) {
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
    }
    if (PreDownloadStrategyAlpha.c == 0L)
    {
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
      if (!MagicfaceViewController.a()) {
        break label672;
      }
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
      boolean bool = SettingCloneUtil.readValue(this, null, getString(2131563409), "qqsetting_screenshot_key", false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new cau(this));
      bool = SettingCloneUtil.readValue(this, null, getString(2131563423), "qqsetting_auto_receive_pic_key", true);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new caz(this));
      bool = SettingCloneUtil.readValue(this, null, getString(2131563423), "qqsetting_auto_receive_magic_face_key", true);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new cba(this));
      bool = SettingCloneUtil.readValue(this, null, getString(2131563426), "qqsetting_enter_sendmsg_key", false);
      this.d.setChecked(bool);
      this.d.setOnCheckedChangeListener(new cbb(this));
      bool = SettingCloneUtil.readValue(this, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), null, "qqsetting_all_contacts_key", false);
      this.e.setChecked(bool);
      this.e.setOnCheckedChangeListener(new cbc(this));
      bool = SettingCloneUtil.readValue(this, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), null, "qqsetting_msg_lockscreen_key", true);
      this.i.setChecked(bool);
      this.i.setOnCheckedChangeListener(new cbd(this));
      this.g.setVisibility(8);
      bool = PreferenceManager.getDefaultSharedPreferences(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApplication()).getBoolean("setting_aio_realtime_bg_open" + this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), false);
      this.f.setChecked(bool);
      this.f.setOnCheckedChangeListener(new cbe(this));
      bool = SettingCloneUtil.readValue(this, null, getString(2131563427), "qqsetting_notify_icon_key", false);
      this.h.setChecked(bool);
      this.h.setOnCheckedChangeListener(new cbf(this));
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(new cav(this));
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(new caw(this));
      this.jdField_c_of_type_AndroidViewView.setOnClickListener(new cax(this));
      this.jdField_a_of_type_AndroidViewView.setContentDescription("流量统计");
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription("摇动手机截屏");
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription("2G/3G/4G下自动接收图片");
      this.d.setContentDescription("回车键发送消息");
      this.g.setContentDescription("WiFi下自动在后台下载新版本");
      this.e.setContentDescription("联系人列表按字母排列");
      this.h.setContentDescription("系统通知栏显示QQ图标");
      this.i.setContentDescription("锁屏界面显示未读消息提醒");
      return;
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
      break;
      label672:
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
    }
  }
  
  protected String a_()
  {
    return getString(2131562380);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903094);
    setTitle(2131562380);
    this.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
    setVolumeControlStream(3);
    d();
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
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, d());
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(getString(2131561702));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(true);
    return this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AssistantSettingActivity
 * JD-Core Version:    0.7.0.1
 */