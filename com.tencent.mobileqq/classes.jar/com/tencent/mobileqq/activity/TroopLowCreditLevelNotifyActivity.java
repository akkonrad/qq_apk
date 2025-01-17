package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.troop.TroopFileProxyActivity;
import java.util.List;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xaf4.oidb_0xaf4.AppInfo;
import tencent.im.oidb.cmd0xaf4.oidb_0xaf4.RspBody;
import tyw;
import tyx;

public class TroopLowCreditLevelNotifyActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  public Context a;
  protected Button a;
  protected ImageView a;
  protected LinearLayout a;
  protected TextView a;
  protected TroopObserver a;
  protected QQProgressDialog a;
  public String a;
  public View[] a;
  public boolean[] a;
  protected TextView b;
  protected String b;
  protected TextView c;
  protected TextView d;
  
  public TroopLowCreditLevelNotifyActivity()
  {
    this.jdField_a_of_type_ArrayOfAndroidViewView = new View[4];
    this.jdField_a_of_type_ArrayOfBoolean = new boolean[4];
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new tyx(this);
  }
  
  private String a(String paramString, long paramLong)
  {
    String str = this.app.getCurrentAccountUin();
    Object localObject = (TroopManager)this.app.getManager(51);
    if (localObject != null)
    {
      localObject = ((TroopManager)localObject).a(this.jdField_a_of_type_JavaLangString);
      if (localObject != null) {
        if ((((TroopInfo)localObject).dwAdditionalFlag & 1L) == 1L) {
          localObject = "0";
        }
      }
    }
    for (;;)
    {
      paramString = paramString.replace("$GCODE$", this.jdField_a_of_type_JavaLangString).replace("$CLIENTVER$", "android7.6.3").replace("$UIN$", str).replace("$LANG$", "zh_CN").replace("$GROUPAPPID$", Long.toString(paramLong)).replace("$ROLE$", (CharSequence)localObject).replace("$ENTERSOURCE$", "1");
      return paramString + "&credit=1";
      if ((((TroopInfo)localObject).dwCmdUinUinFlag & 1L) == 1L) {
        localObject = "1";
      } else {
        localObject = "2";
      }
    }
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidContentContext = this;
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131363867));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363690));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131364631));
    this.c = ((TextView)findViewById(2131375313));
    this.d = ((TextView)findViewById(2131375314));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131366347));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131375315));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    setTitle(2131430678);
    this.c.setText(2131430679);
    this.d.setText(2131430680);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_JavaLangString);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
    a(2131430681, 2131430687, this.jdField_a_of_type_ArrayOfBoolean[0], 0);
    a(2131430682, 2131430687, this.jdField_a_of_type_ArrayOfBoolean[1], 1);
    a(2131430683, 2131430686, this.jdField_a_of_type_ArrayOfBoolean[2], 2);
    a(2131430684, 2131430685, this.jdField_a_of_type_ArrayOfBoolean[3], 3);
    Bitmap localBitmap = this.app.a(this.jdField_a_of_type_JavaLangString, (byte)3, false, false);
    if (localBitmap != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
    }
    while (b())
    {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      return;
      localBitmap = ImageUtil.a();
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
    }
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
  }
  
  public oidb_0xaf4.AppInfo a(long paramLong)
  {
    Object localObject1 = ((TroopManager)this.app.getManager(51)).a(this.jdField_a_of_type_JavaLangString);
    if (localObject1 != null) {}
    for (;;)
    {
      try
      {
        localObject2 = new oidb_0xaf4.RspBody();
        ((oidb_0xaf4.RspBody)localObject2).mergeFrom((byte[])localObject1);
        localObject2 = ((oidb_0xaf4.RspBody)localObject2).infos.get();
        if (localObject2 == null) {
          break label168;
        }
        if (((List)localObject2).size() != 0) {
          break label174;
        }
      }
      catch (Exception localException)
      {
        Object localObject2;
        long l;
        if (!QLog.isColorLevel()) {
          break label166;
        }
        QLog.e("troop.credit.TroopLowCreditLevelNotifyActivity", 2, "getAppInfo: " + paramLong + ", " + localException.toString());
      }
      label166:
      label168:
      oidb_0xaf4.AppInfo localAppInfo;
      if (i < ((List)localObject2).size())
      {
        localObject1 = (oidb_0xaf4.AppInfo)((List)localObject2).get(i);
        l = ((oidb_0xaf4.AppInfo)localObject1).appid.get();
        if (l != paramLong) {
          i += 1;
        }
      }
      else
      {
        return null;
        localAppInfo = null;
      }
      return localAppInfo;
      label174:
      int i = 0;
    }
  }
  
  public void a()
  {
    Object localObject = (TroopManager)this.app.getManager(51);
    int i;
    int j;
    if (localObject != null)
    {
      localObject = ((TroopManager)localObject).a(this.jdField_a_of_type_JavaLangString);
      if (localObject != null) {
        if ((((TroopInfo)localObject).dwAdditionalFlag & 1L) == 1L)
        {
          i = 1;
          if ((((TroopInfo)localObject).dwCmdUinUinFlag & 1L) != 1L) {
            break label130;
          }
          j = 1;
        }
      }
    }
    for (;;)
    {
      label56:
      if ((i == 0) && (j == 0))
      {
        localObject = DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230).setTitle(getString(2131434781)).setMessage("错误，仅群主和管理员能访问");
        ((QQCustomDialog)localObject).setPositiveButton(2131430693, new tyw(this));
        ((QQCustomDialog)localObject).setNegativeButton("", null);
        ((QQCustomDialog)localObject).setCancelable(false);
        ((QQCustomDialog)localObject).show();
      }
      label130:
      do
      {
        return;
        i = 0;
        break;
        j = 0;
        break label56;
        localObject = (TroopHandler)this.app.a(20);
      } while (localObject == null);
      if (QLog.isColorLevel()) {
        QLog.i("troop.credit.act", 2, "getTroopCreditInfo:" + this.jdField_a_of_type_JavaLangString);
      }
      ((TroopHandler)localObject).d(this.jdField_a_of_type_JavaLangString, true);
      c();
      return;
      j = 0;
      i = 0;
    }
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130971671, null);
    TextView localTextView1 = (TextView)localView.findViewById(2131365321);
    TextView localTextView2 = (TextView)localView.findViewById(2131375312);
    TextView localTextView3 = (TextView)localView.findViewById(2131369199);
    localTextView1.setText(paramInt1);
    localTextView2.setText(paramInt2);
    if (paramBoolean) {
      localTextView3.setVisibility(0);
    }
    for (;;)
    {
      localView.setOnClickListener(this);
      this.jdField_a_of_type_ArrayOfAndroidViewView[paramInt3] = localView;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView);
      return;
      localTextView3.setVisibility(8);
    }
  }
  
  public void a(oidb_0xaf4.AppInfo paramAppInfo)
  {
    Intent localIntent = new Intent(this, QQBrowserActivity.class);
    paramAppInfo = a(paramAppInfo.url.get(), paramAppInfo.appid.get());
    localIntent.putExtra("url", paramAppInfo);
    localIntent.putExtra("webStyle", "noBottomBar");
    localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
    startActivityForResult(localIntent, 1001);
    if (QLog.isColorLevel()) {
      QLog.i("troop.credit.TroopLowCreditLevelNotifyActivity", 2, "openTroopAnnounce:" + paramAppInfo);
    }
  }
  
  public boolean a()
  {
    this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("troopUin");
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      return false;
    }
    Object localObject = (TroopManager)this.app.getManager(51);
    if (localObject != null)
    {
      localObject = ((TroopManager)localObject).a(this.jdField_a_of_type_JavaLangString);
      if (localObject != null)
      {
        this.jdField_b_of_type_JavaLangString = ((TroopInfo)localObject).getTroopName();
        if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
          this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
        }
      }
      localObject = getSharedPreferences("sp_tp_credit_md_stat_" + this.app.getCurrentAccountUin(), 0).getString(this.jdField_a_of_type_JavaLangString, "");
    }
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("troop.credit.TroopLowCreditLevelNotifyActivity", 2, "initParams, modifyStatusJson:" + (String)localObject);
      }
      localObject = new JSONObject((String)localObject);
      this.jdField_a_of_type_ArrayOfBoolean[0] = ((JSONObject)localObject).optBoolean("TROOP_INFO_ITEM");
      this.jdField_a_of_type_ArrayOfBoolean[1] = ((JSONObject)localObject).optBoolean("TROOP_ANNOUNCE_ITEM");
      this.jdField_a_of_type_ArrayOfBoolean[2] = ((JSONObject)localObject).optBoolean("TROOP_FILE_ITEM");
      this.jdField_a_of_type_ArrayOfBoolean[3] = ((JSONObject)localObject).optBoolean("TROOP_ALBUM_ITEM");
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("troop.credit.TroopLowCreditLevelNotifyActivity", 2, "initParams:" + localException.toString());
        }
      }
    }
    return true;
    return false;
  }
  
  public void b()
  {
    try
    {
      SharedPreferences.Editor localEditor = getSharedPreferences("sp_tp_credit_md_stat_" + this.app.getCurrentAccountUin(), 0).edit();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("TROOP_INFO_ITEM", this.jdField_a_of_type_ArrayOfBoolean[0]);
      localJSONObject.put("TROOP_ANNOUNCE_ITEM", this.jdField_a_of_type_ArrayOfBoolean[1]);
      localJSONObject.put("TROOP_FILE_ITEM", this.jdField_a_of_type_ArrayOfBoolean[2]);
      localJSONObject.put("TROOP_ALBUM_ITEM", this.jdField_a_of_type_ArrayOfBoolean[3]);
      localEditor.putString(this.jdField_a_of_type_JavaLangString, localJSONObject.toString());
      localEditor.commit();
      if (QLog.isColorLevel()) {
        QLog.i("troop.credit.TroopLowCreditLevelNotifyActivity", 2, "saveStatus:" + localJSONObject.toString());
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("troop.credit.TroopLowCreditLevelNotifyActivity", 2, "saveStatus:" + localException.toString());
    }
  }
  
  public boolean b()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfBoolean.length)
    {
      if (this.jdField_a_of_type_ArrayOfBoolean[i] == 0) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  protected void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131430695);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(getTitleBarHeight());
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = -1;
    if (paramInt2 == -1) {
      switch (paramInt1)
      {
      default: 
        paramInt1 = i;
      }
    }
    for (;;)
    {
      if (paramInt1 >= 0)
      {
        this.jdField_a_of_type_ArrayOfAndroidViewView[paramInt1].findViewById(2131369199).setVisibility(0);
        this.jdField_a_of_type_ArrayOfBoolean[paramInt1] = true;
      }
      if (!b()) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      return;
      paramInt1 = 0;
      continue;
      paramInt1 = 1;
      continue;
      paramInt1 = 2;
      continue;
      paramInt1 = 3;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.i("troop.credit.TroopLowCreditLevelNotifyActivity", 2, "doOnCreate:" + this.jdField_a_of_type_JavaLangString + "," + this.jdField_b_of_type_JavaLangString);
    }
    if (!a())
    {
      finish();
      return false;
    }
    super.setContentView(2130971672);
    e();
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    a();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    b();
  }
  
  public void onClick(View paramView)
  {
    Object localObject;
    if (paramView.getId() == 2131375315)
    {
      paramView = "http://qqweb.qq.com/m/business/qunlevel/index.html?gc=" + this.jdField_a_of_type_JavaLangString + "&from=0&_wv=1027";
      localObject = new Intent(this, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("startOpenPageTime", System.currentTimeMillis());
      ((Intent)localObject).putExtra("url", paramView);
      startActivity((Intent)localObject);
    }
    label348:
    label351:
    for (;;)
    {
      return;
      if (paramView == this.jdField_a_of_type_ArrayOfAndroidViewView[0])
      {
        paramView = (TroopManager)this.app.getManager(51);
        if (paramView == null) {
          break label348;
        }
      }
      for (paramView = paramView.a(this.jdField_a_of_type_JavaLangString);; paramView = null)
      {
        if (paramView == null) {
          break label351;
        }
        localObject = TroopInfoActivity.a(this.jdField_a_of_type_JavaLangString, 28, paramView.troopLat, paramView.troopLon, 0, "");
        ((Bundle)localObject).putInt("troop_type_ex", paramView.troopTypeExt);
        TroopInfoActivity.a(this, (Bundle)localObject, 1000);
        return;
        if (paramView == this.jdField_a_of_type_ArrayOfAndroidViewView[1])
        {
          paramView = a(1101236949L);
          if (paramView != null)
          {
            a(paramView);
            return;
          }
          if (QLog.isColorLevel()) {
            QLog.i("troop.credit.TroopLowCreditLevelNotifyActivity", 2, "onClick, appInfo for announce is null, req from server");
          }
          c();
          paramView = (TroopHandler)this.app.a(20);
          if (paramView == null) {
            break;
          }
          paramView.a(this.jdField_a_of_type_JavaLangString, false, 0, 1);
          return;
        }
        if (paramView == this.jdField_a_of_type_ArrayOfAndroidViewView[2])
        {
          paramView = new Intent();
          paramView.putExtra(TroopFileProxyActivity.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString);
          paramView.putExtra("param_from", 1000);
          TroopFileProxyActivity.a(this, paramView, 1002, this.app.getCurrentAccountUin());
          return;
        }
        if (paramView != this.jdField_a_of_type_ArrayOfAndroidViewView[3]) {
          break;
        }
        paramView = QZoneHelper.UserInfo.a();
        paramView.jdField_a_of_type_JavaLangString = this.app.getCurrentAccountUin();
        paramView.jdField_b_of_type_JavaLangString = this.app.getCurrentNickname();
        QZoneHelper.a(this, paramView, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, 3, 1003, "qunnotice");
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopLowCreditLevelNotifyActivity
 * JD-Core Version:    0.7.0.1
 */