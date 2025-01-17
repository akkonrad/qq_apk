package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.now.NowLiveManager;
import com.tencent.biz.qqstory.base.QQStoryManager;
import com.tencent.biz.qqstory.base.QQStoryObserver;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabStoryNodeConfigManager;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.common.config.AppSetting;
import com.tencent.device.qfind.QFindBLEScanMgr;
import com.tencent.device.utils.SmartDeviceReport;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituManager;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ark.API.ArkAppModuleReg.ModuleQQ;
import com.tencent.mobileqq.ark.ArkAiAppCenter;
import com.tencent.mobileqq.doutu.DoutuManager;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.mobileqq.magicface.view.MagicfaceViewController;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.now.enter.NowEnterManager;
import com.tencent.mobileqq.pic.PreDownloadStrategyBeta;
import com.tencent.mobileqq.qcall.PstnManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.ArrayList;
import mqq.app.MobileQQ;
import rkz;
import rla;
import rlb;
import rlc;
import rld;
import rle;
import rlf;
import rlg;
import rlh;
import rli;
import rlj;
import rlk;
import rll;
import rlm;
import rln;
import rlo;
import rlp;
import rlq;
import rlr;
import rls;
import rlt;
import rlu;
import rlv;
import rlw;
import rlx;
import rly;
import rlz;
import rma;
import rmb;

public class AssistantSettingActivity
  extends IphoneTitleBarActivity
  implements CompoundButton.OnCheckedChangeListener
{
  public Handler a;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private final QQStoryObserver jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver = new rlt(this);
  private CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new rls(this);
  public FormSwitchItem a;
  public QQProgressDialog a;
  private String jdField_a_of_type_JavaLangString = "";
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  public FormSwitchItem b;
  private View jdField_c_of_type_AndroidViewView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  FormSwitchItem jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private View jdField_d_of_type_AndroidViewView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  FormSwitchItem jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private View jdField_e_of_type_AndroidViewView;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  FormSwitchItem jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private View jdField_f_of_type_AndroidViewView;
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  FormSwitchItem jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  FormSwitchItem g;
  FormSwitchItem h;
  FormSwitchItem i;
  FormSwitchItem j;
  FormSwitchItem k;
  FormSwitchItem l;
  FormSwitchItem m;
  FormSwitchItem n;
  FormSwitchItem o;
  FormSwitchItem p;
  FormSwitchItem q;
  private FormSwitchItem r;
  private FormSwitchItem s;
  private FormSwitchItem t;
  private FormSwitchItem u;
  private FormSwitchItem v;
  
  public AssistantSettingActivity()
  {
    this.jdField_a_of_type_AndroidOsHandler = new rlr(this);
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)super.findViewById(2131363339));
    this.jdField_c_of_type_AndroidViewView = super.findViewById(2131363332);
    this.jdField_d_of_type_AndroidViewView = super.findViewById(2131363333);
    if (!QQStoryManager.j())
    {
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
      ((FormSimpleItem)this.jdField_c_of_type_AndroidViewView).setBgType(0);
    }
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)super.findViewById(2131363329));
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)super.findViewById(2131363330));
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)super.findViewById(2131363343));
    this.h = ((FormSwitchItem)super.findViewById(2131363344));
    this.i = ((FormSwitchItem)super.findViewById(2131363345));
    this.j = ((FormSwitchItem)super.findViewById(2131363346));
    this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)super.findViewById(2131363331));
    this.g = ((FormSwitchItem)super.findViewById(2131363342));
    this.k = ((FormSwitchItem)super.findViewById(2131363348));
    this.l = ((FormSwitchItem)super.findViewById(2131363347));
    this.jdField_b_of_type_AndroidViewView = super.findViewById(2131363327);
    this.jdField_e_of_type_AndroidViewView = super.findViewById(2131363328);
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131363326);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.m = ((FormSwitchItem)super.findViewById(2131363334));
    this.n = ((FormSwitchItem)super.findViewById(2131363335));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131363336));
    this.o = ((FormSwitchItem)super.findViewById(2131363349));
    this.p = ((FormSwitchItem)super.findViewById(2131363352));
    this.r = ((FormSwitchItem)super.findViewById(2131363337));
    this.jdField_f_of_type_AndroidViewView = super.findViewById(2131363353);
    this.t = ((FormSwitchItem)super.findViewById(2131363350));
    Object localObject = this.app.getApp().getSharedPreferences("sticker_pref", 0);
    this.u = ((FormSwitchItem)super.findViewById(2131363354));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131363355));
    this.v = ((FormSwitchItem)super.findViewById(2131363358));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131363359));
    this.q = ((FormSwitchItem)findViewById(2131363356));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363357));
    this.q.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    this.s = ((FormSwitchItem)findViewById(2131363360));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363361));
    String str;
    label603:
    label619:
    label633:
    boolean bool1;
    if (EmojiStickerManager.a())
    {
      str = this.app.c();
      this.t.setChecked(((SharedPreferences)localObject).getBoolean("sticker_switch_" + str, true));
      this.t.setOnCheckedChangeListener(new rkz(this, (SharedPreferences)localObject, str));
      localObject = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.fontCfg.name(), "-1");
      if (QLog.isColorLevel()) {
        QLog.d("IphoneTitleBarActivity", 2, "current fontSetting dpcValue=" + (String)localObject);
      }
      if ((!"1".equals(localObject)) || (!FontSettingManager.b())) {
        break label2083;
      }
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      if (PreDownloadStrategyBeta.c != 0L) {
        break label2142;
      }
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
      if (!MagicfaceViewController.a()) {
        break label2154;
      }
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131363340));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363341));
      if (QFindBLEScanMgr.a()) {
        break label2166;
      }
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      bool1 = SettingCloneUtil.readValue(this, null, super.getString(2131433581), "qqsetting_screenshot_key", false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool1);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new rlv(this));
      if (this.jdField_c_of_type_AndroidViewView != null) {
        this.jdField_c_of_type_AndroidViewView.setOnClickListener(new rlw(this));
      }
      if (this.jdField_d_of_type_AndroidViewView != null) {
        this.jdField_d_of_type_AndroidViewView.setOnClickListener(new rlx(this));
      }
      bool1 = SettingCloneUtil.readValue(this, null, getString(2131433572), "qqsetting_auto_receive_pic_key", true);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool1);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new rly(this));
      bool1 = SettingCloneUtil.readValue(this, null, getString(2131433572), "qqsetting_auto_receive_magic_face_key", true);
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool1);
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new rlz(this));
      bool1 = SettingCloneUtil.readValue(this, null, getString(2131433626), "qqsetting_enter_sendmsg_key", false);
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool1);
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new rma(this));
      bool1 = SettingCloneUtil.readValue(this, null, null, "qqsetting_clear_memory_key", true);
      this.j.setChecked(bool1);
      this.j.setOnCheckedChangeListener(new rmb(this));
      bool1 = ConfigHandler.a(this.app, false);
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool1);
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new rla(this));
      bool1 = SettingCloneUtil.readValue(this, null, getString(2131436020), "qqsetting_notify_icon_key", false);
      this.g.setChecked(bool1);
      this.g.setOnCheckedChangeListener(new rlb(this));
      b();
      this.k.setChecked(this.app.a().jdField_a_of_type_Boolean);
      this.k.setText(getText(2131434101));
      this.k.setContentDescription("在底部栏展示日迹功能");
      this.k.setOnCheckedChangeListener(new rlc(this));
      this.k.setBackgroundResource(2130838623);
      this.k.setVisibility(0);
      if ((QQStoryManager.j()) && (this.app.a().jdField_a_of_type_Char != '0') && (this.app.a().jdField_a_of_type_Char != '1')) {
        break label2237;
      }
      this.k.setVisibility(8);
      label1118:
      PstnManager localPstnManager = (PstnManager)this.app.getManager(142);
      if (localPstnManager.a() == 1)
      {
        this.m.setVisibility(0);
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
        localObject = this.app.getApplication().getResources().getString(2131438410);
        str = localPstnManager.a("pstn_c2c_trans_setting_wording");
        FormSwitchItem localFormSwitchItem = this.m;
        if (!TextUtils.isEmpty(str)) {
          break label2255;
        }
        label1199:
        localFormSwitchItem.setText((CharSequence)localObject);
        this.m.setChecked(localPstnManager.a());
        this.m.setOnCheckedChangeListener(new rld(this, localPstnManager));
        if (localPstnManager.d() == 1)
        {
          this.n.setVisibility(0);
          localObject = this.app.getApplication().getResources().getString(2131438413);
          str = localPstnManager.a("pstn_multi_trans_setting_wording");
          localFormSwitchItem = this.n;
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            break label2261;
          }
          label1291:
          localFormSwitchItem.setText((CharSequence)localObject);
          this.n.setChecked(localPstnManager.b());
          this.n.setOnCheckedChangeListener(new rle(this, localPstnManager));
        }
      }
      if (!SharedPreUtils.c(getApplicationContext(), this.app.getCurrentAccountUin())) {
        break label2267;
      }
      this.o.setVisibility(8);
      label1352:
      localObject = (FlashChatManager)this.app.getManager(216);
      if ((localObject != null) && (((FlashChatManager)localObject).c()))
      {
        bool1 = ((FlashChatManager)localObject).b();
        this.p.setVisibility(0);
        this.p.setChecked(bool1);
        this.p.setOnCheckedChangeListener(new rlg(this));
      }
      bool1 = ReadInJoyHelper.f();
      if (!bool1) {
        break label2309;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131433554);
      label1431:
      this.q.setChecked(bool1);
      this.q.setOnCheckedChangeListener(new rlh(this));
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(new rli(this));
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(new rlj(this));
      this.jdField_e_of_type_AndroidViewView.setOnClickListener(new rll(this));
      if (SharedPreUtils.al(getApplication(), this.app.getCurrentAccountUin()) == 1)
      {
        this.r.setVisibility(0);
        findViewById(2131363338).setVisibility(0);
        ((LinearLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.getLayoutParams()).setMargins(0, 0, 0, 0);
        ThreadManager.post(new rlm(this), 5, null, true);
        this.r.setOnCheckedChangeListener(this);
      }
      localObject = ArkAppModuleReg.ModuleQQ.a(this.app.getCurrentAccountUin());
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        this.jdField_f_of_type_AndroidViewView.setVisibility(0);
        this.jdField_f_of_type_AndroidViewView.setOnClickListener(new rln(this, (ArrayList)localObject));
      }
      localObject = (DoutuManager)this.app.getManager(213);
      if ((!((DoutuManager)localObject).a()) || (!((DoutuManager)localObject).d())) {
        break label2322;
      }
      this.u.setVisibility(0);
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
      bool1 = ((DoutuManager)localObject).b();
      this.u.setChecked(bool1);
      this.u.setContentDescription("斗图功能");
      this.u.setOnCheckedChangeListener(new rlo(this, (DoutuManager)localObject));
      label1704:
      if (!ZhituManager.a(this.app).a()) {
        break label2343;
      }
      this.v.setVisibility(0);
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
      bool1 = ZhituManager.a(this.app).b();
      this.v.setChecked(bool1);
      this.v.setContentDescription("智图功能");
      this.v.setChecked(bool1);
      this.v.setOnCheckedChangeListener(new rlp(this));
      label1785:
      localObject = (NowEnterManager)this.app.getManager(264);
      bool1 = ((NowEnterManager)localObject).c();
      boolean bool2 = ((NowEnterManager)localObject).d();
      if ((!bool1) || (!bool2)) {
        break label2364;
      }
      this.s.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      bool1 = ((NowEnterManager)localObject).e();
      this.s.setChecked(bool1);
      this.s.setOnCheckedChangeListener(new rlq(this, (NowEnterManager)localObject));
    }
    for (;;)
    {
      if (AppSetting.b)
      {
        this.jdField_b_of_type_AndroidViewView.setContentDescription("流量统计");
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription("摇动手机截屏");
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription("加入寻找丢失儿童项目");
        this.jdField_c_of_type_AndroidViewView.setContentDescription("空间图片浏览模式");
        this.jdField_d_of_type_AndroidViewView.setContentDescription("日迹自动播放");
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription("非Wi-Fi环境下自动接收图片");
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription("回车键发送消息");
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription("WiFi下自动在后台下载新版本");
        this.g.setContentDescription("系统通知栏显示QQ图标");
        this.i.setContentDescription("有可用QQ WiFi时通知我");
        this.j.setContentDescription("内存低时自动清理内存");
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131434060));
        this.r.setContentDescription(getString(2131434068));
        this.jdField_f_of_type_AndroidViewView.setContentDescription(getString(2131438818));
        this.q.setContentDescription(getString(2131439095));
        this.v.setContentDescription("智能匹配图片");
        this.s.setContentDescription(getString(2131439190));
      }
      return;
      this.t.setVisibility(8);
      super.findViewById(2131363351).setVisibility(8);
      break;
      label2083:
      if ("0".equals(localObject))
      {
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        FontSettingManager.b(this);
        break label603;
      }
      if (FontSettingManager.a())
      {
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        break label603;
      }
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      FontSettingManager.b(this);
      break label603;
      label2142:
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
      break label619;
      label2154:
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
      break label633;
      label2166:
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      if (SettingCloneUtil.readValueForInt(BaseApplication.getContext(), this.app.getCurrentAccountUin(), null, "qqsetting_antilost_key", 0) == 1) {}
      for (bool1 = true;; bool1 = false)
      {
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool1);
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new rlk(this));
        break;
      }
      label2237:
      StoryReportor.a("dynamic_more", "exp_storyset", 0, 0, new String[0]);
      break label1118;
      label2255:
      localObject = str;
      break label1199;
      label2261:
      localObject = str;
      break label1291;
      label2267:
      bool1 = ArkAiAppCenter.a(this.app);
      this.o.setVisibility(0);
      this.o.setChecked(bool1);
      this.o.setOnCheckedChangeListener(new rlf(this));
      break label1352;
      label2309:
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131433553);
      break label1431;
      label2322:
      this.u.setVisibility(8);
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
      break label1704;
      label2343:
      this.v.setVisibility(8);
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
      break label1785;
      label2364:
      this.s.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  private void a(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton.setOnCheckedChangeListener(null);
    paramCompoundButton.setChecked(paramBoolean);
    paramCompoundButton.setOnCheckedChangeListener(this);
  }
  
  private void a(boolean paramBoolean)
  {
    try
    {
      BluetoothAdapter localBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
      if (localBluetoothAdapter == null)
      {
        QQToast.a(this, 2131438177, 100).a();
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(false);
        return;
      }
    }
    catch (Exception localException)
    {
      Object localObject;
      for (;;)
      {
        localObject = null;
      }
      CardHandler localCardHandler = (CardHandler)this.app.a(2);
      if (paramBoolean) {}
      for (short s1 = 1;; s1 = 0)
      {
        localCardHandler.a(s1);
        if (!paramBoolean) {
          break;
        }
        if (!localObject.isEnabled()) {
          localObject.enable();
        }
        SmartDeviceReport.a(this.app, 0L, "QFIND_BluetoothBtnClick", 1, 0, 0);
        return;
      }
      SmartDeviceReport.a(this.app, 0L, "QFIND_BluetoothBtnClick", 0, 0, 0);
    }
  }
  
  private void b()
  {
    Object localObject = (MsgTabStoryNodeConfigManager)this.app.getManager(251);
    if ((((MsgTabStoryNodeConfigManager)localObject).b) && (((MsgTabStoryNodeConfigManager)localObject).c))
    {
      this.l.setVisibility(0);
      this.l.setChecked(((MsgTabStoryNodeConfigManager)localObject).d);
      this.l.setText("在消息顶部展示日迹");
      this.l.setOnCheckedChangeListener(new rlu(this, (MsgTabStoryNodeConfigManager)localObject));
      if (((MsgTabStoryNodeConfigManager)localObject).d) {}
      for (localObject = "1";; localObject = "2")
      {
        StoryReportor.a("msg_tab", "exp_set", 0, 0, new String[] { "2", localObject });
        return;
      }
    }
    this.l.setVisibility(8);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2130968709);
    if (!this.app.isLogin())
    {
      paramBundle = new Intent();
      paramBundle.setClass(this, LoginActivity.class);
      paramBundle.addFlags(262144);
      startActivity(paramBundle);
      super.finish();
      return false;
    }
    super.setTitle(2131433579);
    this.jdField_a_of_type_JavaLangString = this.app.getCurrentAccountUin();
    super.setVolumeControlStream(3);
    a();
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    addObserver(this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver);
    return true;
  }
  
  protected void doOnDestroy()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      super.dismissDialog(1);
    }
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    removeObserver(this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver);
    super.doOnDestroy();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool2 = true;
    boolean bool1;
    if (paramCompoundButton == this.r.a())
    {
      if (!NetworkUtil.d(this))
      {
        QQToast.a(getApplicationContext(), 2131436066, 1).a();
        if (paramBoolean) {
          break label73;
        }
        bool1 = true;
        a(paramCompoundButton, bool1);
      }
      paramCompoundButton = (CardHandler)this.app.a(2);
      if (paramBoolean) {
        break label78;
      }
    }
    label73:
    label78:
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      paramCompoundButton.h(paramBoolean);
      return;
      bool1 = false;
      break;
    }
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return super.onCreateDialog(paramInt);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, super.getTitleBarHeight());
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(getString(2131434045));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(true);
    return this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  }
  
  protected String setLastActivityName()
  {
    return super.getString(2131433579);
  }
  
  public boolean showPreview()
  {
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      super.getWindow().addFlags(67108864);
    }
    return super.showPreview();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AssistantSettingActivity
 * JD-Core Version:    0.7.0.1
 */