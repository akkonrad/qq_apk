package com.tencent.biz.eqq;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.biz.ProtoServlet;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.pubaccount.PublicAccountServlet;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.EqqDetailDataManager;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EqqDetail;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.ConfigGroupInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.ConfigInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.FollowRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.GetEqqAccountDetailInfoResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.GetEqqDetailInfoRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.SetFunctionFlagRequset;
import com.tencent.mobileqq.mp.mobileqq_mp.UnFollowRequest;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ShareMsgHelper;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.Switch;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lx;
import ly;
import lz;
import ma;
import mb;
import mc;
import md;
import me;
import mf;
import mg;
import mh;
import mi;
import mj;
import mk;
import ml;
import mm;
import mn;
import mo;
import mq;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import mr;
import ms;
import mt;
import mu;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class EnterpriseDetailActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  static final int jdField_b_of_type_Int = 1;
  private static final int jdField_c_of_type_Int = 0;
  private static final int jdField_d_of_type_Int = 1;
  public static final String d = "need_finish";
  private static final int e = 2;
  private static final int f = 3;
  float jdField_a_of_type_Float;
  public int a;
  View jdField_a_of_type_AndroidViewView;
  public Button a;
  public ImageView a;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver;
  public PublicAccountHandler a;
  public QQAppInterface a;
  public EqqDetail a;
  public mobileqq_mp.GetEqqAccountDetailInfoResponse a;
  QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  public ActionSheet a;
  public String a;
  NewIntent jdField_a_of_type_MqqAppNewIntent;
  BusinessObserver jdField_a_of_type_MqqObserverBusinessObserver;
  public boolean a;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  public String b;
  NewIntent jdField_b_of_type_MqqAppNewIntent;
  BusinessObserver jdField_b_of_type_MqqObserverBusinessObserver;
  boolean jdField_b_of_type_Boolean = true;
  LinearLayout jdField_c_of_type_AndroidWidgetLinearLayout;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  String jdField_c_of_type_JavaLangString;
  NewIntent jdField_c_of_type_MqqAppNewIntent;
  BusinessObserver jdField_c_of_type_MqqObserverBusinessObserver;
  public boolean c;
  BusinessObserver jdField_d_of_type_MqqObserverBusinessObserver;
  protected boolean d;
  protected String e;
  public boolean e;
  protected String f;
  public boolean f;
  public boolean g = false;
  boolean h = false;
  private boolean i = false;
  
  public EnterpriseDetailActivity()
  {
    this.jdField_a_of_type_JavaLangString = "Q.enterprise.EnterpriseDetailActivity";
    this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail = null;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentWidgetActionSheet = null;
    this.jdField_a_of_type_Int = 0;
    this.jdField_e_of_type_Boolean = true;
    this.jdField_f_of_type_Boolean = false;
  }
  
  private ViewGroup a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "createGroupLayout");
    }
    LinearLayout localLinearLayout = new LinearLayout(this);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "createGroupLayout exit");
    }
    return localLinearLayout;
  }
  
  private void a(ViewGroup paramViewGroup, mobileqq_mp.ConfigInfo paramConfigInfo, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "addDetailItem");
    }
    int j = (int)(10.0F * this.jdField_a_of_type_Float);
    int k = (int)(15.0F * this.jdField_a_of_type_Float);
    Object localObject2 = super.getLayoutInflater();
    Object localObject4 = null;
    Object localObject1;
    Object localObject3;
    if (paramConfigInfo.type.get() == 3)
    {
      localObject1 = paramConfigInfo.content.get();
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = ((LayoutInflater)localObject2).inflate(2130903216, null);
        if (paramConfigInfo.event_id.get() != 7) {
          break label346;
        }
        ((View)localObject2).setOnClickListener(new lz(this));
        localObject3 = localObject4;
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      label116:
      ((TextView)((View)localObject1).findViewById(2131296934)).setText(paramConfigInfo.title.get());
      localObject2 = new LinearLayout.LayoutParams(-1, -2);
      switch (paramInt)
      {
      default: 
        ((LinearLayout.LayoutParams)localObject2).setMargins(0, j, 0, j);
        ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        if (paramConfigInfo.type.get() == 5)
        {
          ((View)localObject1).setBackgroundResource(2130839380);
          label216:
          if (paramConfigInfo.state_id.get() != 5) {
            break label1218;
          }
          paramViewGroup.addView((View)localObject3);
          localObject2 = getString(2131362461);
          if (paramConfigInfo.state.get() != 1) {
            break label1207;
          }
          paramViewGroup = getString(2131363620);
          label259:
          ((View)localObject1).setContentDescription(String.format((String)localObject2, new Object[] { paramViewGroup }));
          label277:
          if (paramConfigInfo.type.get() != 4) {
            break label1227;
          }
          ((View)localObject1).setPadding(k, k, k, k);
        }
        break;
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "addDetailItem exit");
        }
        return;
        localObject2 = ((LayoutInflater)localObject2).inflate(2130903346, null);
        ((TextView)((View)localObject2).findViewById(2131296569)).setText((CharSequence)localObject1);
        break;
        label346:
        if (paramConfigInfo.event_id.get() == 8)
        {
          localObject1 = paramConfigInfo.content.get();
          if (Pattern.compile("[\\d-]+?").matcher((CharSequence)localObject1).matches()) {
            ((View)localObject2).setOnClickListener(new ma(this, paramConfigInfo));
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Biz_card", "Biz_card_call", 0, 0, this.jdField_b_of_type_JavaLangString, "", "", "");
          localObject1 = localObject2;
          localObject3 = localObject4;
          break label116;
        }
        localObject1 = localObject2;
        localObject3 = localObject4;
        if (paramConfigInfo.event_id.get() != 9) {
          break label116;
        }
        ((View)localObject2).setOnClickListener(new mb(this));
        localObject1 = localObject2;
        localObject3 = localObject4;
        break label116;
        if (paramConfigInfo.type.get() == 1)
        {
          if (paramConfigInfo.content.has())
          {
            localObject1 = ((LayoutInflater)localObject2).inflate(2130903346, null);
            ((TextView)((View)localObject1).findViewById(2131296569)).setText(paramConfigInfo.content.get());
          }
          for (;;)
          {
            if (!paramConfigInfo.url.has()) {
              break label1243;
            }
            ((View)localObject1).setOnClickListener(new mc(this, paramConfigInfo.url.get()));
            localObject3 = localObject4;
            break;
            localObject1 = ((LayoutInflater)localObject2).inflate(2130903216, null);
          }
        }
        if (paramConfigInfo.type.get() == 2)
        {
          if (paramConfigInfo.state_id.get() == 5)
          {
            localObject1 = ((LayoutInflater)localObject2).inflate(2130903665, null);
            localObject2 = ((View)localObject1).findViewById(2131298862);
            ((TextView)((View)localObject1).findViewById(2131298863)).setVisibility(0);
            label642:
            localObject3 = (Switch)((View)localObject2).findViewById(2131296954);
            ((Switch)localObject3).setContentDescription(paramConfigInfo.title.get());
            if (paramConfigInfo.state.get() != 1) {
              break label730;
            }
            ((Switch)localObject3).setChecked(true);
          }
          for (;;)
          {
            ((Switch)localObject3).setOnCheckedChangeListener(new md(this, paramConfigInfo, (Switch)localObject3, (View)localObject2));
            localObject3 = localObject1;
            localObject1 = localObject2;
            break;
            localObject2 = ((LayoutInflater)localObject2).inflate(2130903665, null);
            localObject1 = null;
            break label642;
            label730:
            ((Switch)localObject3).setChecked(false);
          }
        }
        if (paramConfigInfo.type.get() == 4)
        {
          localObject1 = ((LayoutInflater)localObject2).inflate(2130903168, null);
          ((TextView)((View)localObject1).findViewById(2131296569)).setText(paramConfigInfo.content.get());
          localObject3 = localObject4;
          break label116;
        }
        if (paramConfigInfo.type.get() == 5)
        {
          localObject1 = ((LayoutInflater)localObject2).inflate(2130903272, null);
          localObject2 = paramConfigInfo.url.get();
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            ((View)localObject1).findViewById(2131297433).setVisibility(0);
            ((View)localObject1).setOnClickListener(new me(this, (String)localObject2));
          }
          for (boolean bool = true;; bool = false)
          {
            try
            {
              localObject2 = new JSONObject(paramConfigInfo.content.get());
              localObject3 = ((JSONObject)localObject2).getString("content");
              ((TextView)((View)localObject1).findViewById(2131296569)).setText((CharSequence)localObject3);
              localObject3 = ((JSONObject)localObject2).getJSONArray("pic_list");
              localObject2 = ((JSONObject)localObject2).getJSONArray("thumb_list");
              a(bool, (LinearLayout)((View)localObject1).findViewById(2131297432), (JSONArray)localObject3, (JSONArray)localObject2);
              localObject3 = localObject4;
            }
            catch (JSONException localJSONException)
            {
              if (QLog.isColorLevel()) {
                QLog.d(this.jdField_a_of_type_JavaLangString, 2, "RICH_PIC_TEXT:pic json error!");
              }
              localJSONException.printStackTrace();
              localObject3 = localObject4;
            }
            break;
            ((View)localObject1).findViewById(2131297433).setVisibility(8);
          }
        }
        localObject1 = localJSONException.inflate(2130903168, null);
        localObject3 = localObject4;
        break label116;
        localJSONException.setMargins(0, j, 0, j);
        ((View)localObject1).setLayoutParams(localJSONException);
        if (paramConfigInfo.type.get() == 5)
        {
          ((View)localObject1).setBackgroundResource(2130839380);
          break label216;
        }
        ((View)localObject1).setBackgroundResource(2130837942);
        break label216;
        localJSONException.setMargins(0, j, 0, 0);
        ((View)localObject1).setLayoutParams(localJSONException);
        if (paramConfigInfo.type.get() == 5)
        {
          ((View)localObject1).setBackgroundResource(2130839385);
          break label216;
        }
        ((View)localObject1).setBackgroundResource(2130837945);
        break label216;
        localJSONException.setMargins(0, 0, 0, j);
        ((View)localObject1).setLayoutParams(localJSONException);
        if (paramConfigInfo.type.get() == 5)
        {
          ((View)localObject1).setBackgroundResource(2130839380);
          break label216;
        }
        ((View)localObject1).setBackgroundResource(2130837944);
        break label216;
        if (paramConfigInfo.type.get() == 5)
        {
          ((View)localObject1).setBackgroundResource(2130839385);
          break label216;
        }
        ((View)localObject1).setBackgroundResource(2130837945);
        break label216;
        ((View)localObject1).setBackgroundResource(2130837942);
        break label216;
        label1207:
        paramViewGroup = getString(2131363621);
        break label259;
        label1218:
        paramViewGroup.addView((View)localObject1);
        break label277;
        label1227:
        ((View)localObject1).setPadding(k, j, k, j);
      }
      label1243:
      localObject3 = localObject4;
    }
  }
  
  private void a(EqqDetail paramEqqDetail)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "saveCache");
    }
    Object localObject = (EqqDetailDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(54);
    if (localObject != null) {
      ((EqqDetailDataManager)localObject).a(paramEqqDetail);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail == null) || (this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.getId() == -1L)) {
      this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail = paramEqqDetail;
    }
    if ((paramEqqDetail != null) && (paramEqqDetail.followType == 1))
    {
      localObject = (PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(48);
      if (localObject != null) {
        ((PublicAccountDataManager)localObject).a(PublicAccountInfo.createPublicAccount(paramEqqDetail, 0L));
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "saveCache exit");
    }
  }
  
  private void a(mobileqq_mp.ConfigGroupInfo paramConfigGroupInfo, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "addGroup");
    }
    ViewGroup localViewGroup = a();
    paramConfigGroupInfo = paramConfigGroupInfo.config_info.get();
    int m = paramConfigGroupInfo.size();
    int k = 0;
    if (k < m)
    {
      int j;
      if (m > 1) {
        if (k == 0) {
          j = 1;
        }
      }
      for (;;)
      {
        a(localViewGroup, (mobileqq_mp.ConfigInfo)paramConfigGroupInfo.get(k), j);
        if (k != m - 1) {}
        k += 1;
        break;
        if (k == m - 1)
        {
          j = 2;
        }
        else
        {
          j = 3;
          continue;
          if (m > 2)
          {
            if (paramInt1 == 1) {
              j = 1;
            } else if (paramInt1 == paramInt2 - 1) {
              j = 2;
            } else {
              j = 3;
            }
          }
          else {
            j = 0;
          }
        }
      }
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localViewGroup);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "addGroup exit");
    }
  }
  
  private void a(mobileqq_mp.ConfigInfo paramConfigInfo, Switch paramSwitch)
  {
    boolean bool = true;
    if (paramConfigInfo.state.get() == 1) {}
    for (;;)
    {
      this.jdField_e_of_type_Boolean = false;
      paramSwitch.setChecked(bool);
      return;
      bool = false;
    }
  }
  
  private void a(mobileqq_mp.ConfigInfo paramConfigInfo, Switch paramSwitch, boolean paramBoolean)
  {
    int j = 1;
    b(2131362448);
    NewIntent localNewIntent = new NewIntent(super.getApplicationContext(), PublicAccountServlet.class);
    localNewIntent.putExtra("cmd", "set_function_flag");
    mobileqq_mp.SetFunctionFlagRequset localSetFunctionFlagRequset = new mobileqq_mp.SetFunctionFlagRequset();
    localSetFunctionFlagRequset.version.set(1);
    try
    {
      long l = Long.parseLong(this.jdField_b_of_type_JavaLangString);
      localSetFunctionFlagRequset.uin.set((int)l);
      int k = paramConfigInfo.state_id.get();
      if (paramBoolean) {}
      for (;;)
      {
        localSetFunctionFlagRequset.type.set(k);
        localSetFunctionFlagRequset.value.set(j);
        localSetFunctionFlagRequset.account_type.set(2);
        localNewIntent.putExtra("data", localSetFunctionFlagRequset.toByteArray());
        this.jdField_d_of_type_MqqObserverBusinessObserver = new ms(this, paramConfigInfo, paramSwitch, j, paramBoolean);
        localNewIntent.setObserver(this.jdField_d_of_type_MqqObserverBusinessObserver);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
        this.jdField_a_of_type_Int += 1;
        return;
        j = 2;
      }
      return;
    }
    catch (Exception paramConfigInfo) {}
  }
  
  private void a(String paramString)
  {
    Intent localIntent = new Intent(this, PublicAccountBrowser.class);
    paramString = paramString.replace("${puin}", this.jdField_b_of_type_JavaLangString).replace("${uin}", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).replace("${sid}", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getSid());
    localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    localIntent.putExtra("url", paramString);
    localIntent.putExtra("puin", this.jdField_b_of_type_JavaLangString);
    if (this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail != null) {
      localIntent.putExtra("source_name", this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.name);
    }
    super.startActivity(localIntent);
  }
  
  private void b(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetButton.postDelayed(new lx(this, paramInt), 500L);
  }
  
  private void b(EqqDetail paramEqqDetail)
  {
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    localEntityManager.b(paramEqqDetail);
    localEntityManager.a();
  }
  
  private void b(mobileqq_mp.ConfigInfo paramConfigInfo, Switch paramSwitch, boolean paramBoolean)
  {
    this.g = true;
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 0);
    localQQCustomDialog.setCanceledOnTouchOutside(false);
    String str = paramConfigInfo.confirm_tips.get();
    if (3 == paramConfigInfo.state_id.get())
    {
      str = String.format(getString(2131361934), new Object[] { this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.name });
      localQQCustomDialog.setOnCancelListener(new mt(this, paramConfigInfo, paramSwitch));
    }
    localQQCustomDialog.setTitle("温馨提示");
    localQQCustomDialog.setMessage(str);
    paramConfigInfo = new mu(this, paramConfigInfo, paramSwitch, paramBoolean);
    localQQCustomDialog.setNegativeButton("取消", paramConfigInfo);
    localQQCustomDialog.setPositiveButton("确定", paramConfigInfo);
    try
    {
      localQQCustomDialog.show();
      label133:
      if (0 != 0) {}
      return;
    }
    catch (Exception paramConfigInfo)
    {
      break label133;
    }
  }
  
  private void b(String paramString)
  {
    this.g = true;
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 0);
    localQQCustomDialog.setCanceledOnTouchOutside(false);
    localQQCustomDialog.setMessage(paramString);
    paramString = new ly(this, paramString);
    localQQCustomDialog.setNegativeButton("取消", paramString);
    localQQCustomDialog.setPositiveButton("呼叫", paramString);
    try
    {
      localQQCustomDialog.show();
      label54:
      if (0 != 0) {}
      return;
    }
    catch (Exception paramString)
    {
      break label54;
    }
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "initView");
    }
    super.setContentView(2130903294);
    this.jdField_a_of_type_Float = super.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131297563));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131296456));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131297560));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131296989));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131297561));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131297558));
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131297557);
    this.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(2130838800, 0, 0, 0);
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131297564));
    super.setTitle(2131362439);
    this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131296952));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, super.getTitleBarHeight());
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCanceledOnTouchOutside(true);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131297562));
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.j.setText("");
    this.p.setVisibility(0);
    this.p.setImageResource(2130837758);
    this.p.setOnClickListener(this);
    this.p.setContentDescription(getResources().getString(2131362577));
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "initView exit");
    }
  }
  
  private void c(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(paramInt);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    }
  }
  
  private void c(EqqDetail paramEqqDetail)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "update");
    }
    a(paramEqqDetail);
    this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler.a();
    if (this.jdField_a_of_type_Boolean)
    {
      m();
      n();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "update exit");
      }
      return;
      m();
    }
  }
  
  private boolean c()
  {
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail = ((EqqDetail)localEntityManager.a(EqqDetail.class, this.jdField_b_of_type_JavaLangString));
    localEntityManager.a();
    if (this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail == null) {
      return false;
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$GetEqqAccountDetailInfoResponse = new mobileqq_mp.GetEqqAccountDetailInfoResponse();
      this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$GetEqqAccountDetailInfoResponse.mergeFrom(this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.accountData);
      this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.groupInfoList = this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$GetEqqAccountDetailInfoResponse.config_group_info.get();
      label85:
      return true;
    }
    catch (Exception localException)
    {
      break label85;
    }
  }
  
  private void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "init");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)super.getAppRuntime());
    Intent localIntent = super.getIntent();
    if (localIntent != null) {
      this.jdField_b_of_type_JavaLangString = localIntent.getStringExtra("uin");
    }
    if (this.jdField_b_of_type_JavaLangString == null) {
      return;
    }
    this.jdField_e_of_type_JavaLangString = localIntent.getStringExtra("extvalue");
    this.jdField_f_of_type_JavaLangString = localIntent.getStringExtra("exttype");
    if (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString))
    {
      if (!"2".equals(this.jdField_f_of_type_JavaLangString)) {
        break label144;
      }
      this.jdField_c_of_type_Boolean = true;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler = ((PublicAccountHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(10));
      c();
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "init exit");
      return;
      label144:
      if ("1".equals(this.jdField_f_of_type_JavaLangString)) {
        this.jdField_d_of_type_Boolean = true;
      }
    }
  }
  
  private void e()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("isNeedFinish", true);
    setResult(-1, localIntent);
    finish();
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "unfollow");
    }
    b(2131362449);
    if (this.jdField_c_of_type_MqqAppNewIntent != null) {
      this.jdField_c_of_type_MqqAppNewIntent.setObserver(null);
    }
    this.jdField_c_of_type_MqqAppNewIntent = new NewIntent(super.getApplicationContext(), PublicAccountServlet.class);
    this.jdField_c_of_type_MqqAppNewIntent.putExtra("cmd", "unfollow");
    mobileqq_mp.UnFollowRequest localUnFollowRequest = new mobileqq_mp.UnFollowRequest();
    localUnFollowRequest.uin.set((int)Long.parseLong(this.jdField_b_of_type_JavaLangString));
    localUnFollowRequest.account_type.set(2);
    this.jdField_c_of_type_MqqAppNewIntent.putExtra("data", localUnFollowRequest.toByteArray());
    this.jdField_c_of_type_MqqObserverBusinessObserver = new mi(this);
    this.jdField_c_of_type_MqqAppNewIntent.setObserver(this.jdField_c_of_type_MqqObserverBusinessObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(this.jdField_c_of_type_MqqAppNewIntent);
    this.jdField_a_of_type_Int += 1;
    PublicAccountUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "unfollow exit");
    }
  }
  
  private void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "follow");
    }
    this.jdField_f_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidWidgetButton.postDelayed(new mn(this), 3000L);
    b(2131362450);
    ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).a(this.jdField_b_of_type_JavaLangString);
    this.jdField_b_of_type_MqqAppNewIntent = new NewIntent(super.getApplicationContext(), PublicAccountServlet.class);
    this.jdField_b_of_type_MqqAppNewIntent.putExtra("cmd", "follow");
    mobileqq_mp.FollowRequest localFollowRequest = new mobileqq_mp.FollowRequest();
    if ((!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) && (this.jdField_d_of_type_Boolean)) {
      localFollowRequest.ext.set(this.jdField_e_of_type_JavaLangString);
    }
    localFollowRequest.uin.set((int)Long.parseLong(this.jdField_b_of_type_JavaLangString));
    localFollowRequest.account_type.set(2);
    this.jdField_b_of_type_MqqAppNewIntent.putExtra("data", localFollowRequest.toByteArray());
    this.jdField_b_of_type_MqqObserverBusinessObserver = new mo(this);
    this.jdField_b_of_type_MqqAppNewIntent.setObserver(this.jdField_b_of_type_MqqObserverBusinessObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(this.jdField_b_of_type_MqqAppNewIntent);
    this.jdField_a_of_type_Int += 1;
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "follow exit");
    }
  }
  
  private void h()
  {
    Resources localResources;
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet == null)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.a(this, 2131624120);
      localResources = super.getResources();
      if (this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail != null) {
        break label138;
      }
    }
    label138:
    for (String str = "";; str = this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.name)
    {
      str = String.format(localResources.getString(2131362443, new Object[] { str }), new Object[0]);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(str);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(2131362440, 3);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.d(2131362801);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnDismissListener(new mq(this));
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(new mr(this));
      if (!this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())
      {
        this.i = false;
        this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
      }
      return;
    }
  }
  
  private void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "initData");
    }
    boolean bool;
    if (!c())
    {
      bool = true;
      this.jdField_a_of_type_Boolean = bool;
      if (!this.jdField_a_of_type_Boolean) {
        break label72;
      }
      c(2131362448);
      o();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "initData exit");
      }
      return;
      bool = false;
      break;
      label72:
      m();
      o();
    }
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.certifiedGrade == 0) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.name);
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.displayNumber != null) && (this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.displayNumber.length() > 0))
      {
        this.jdField_c_of_type_JavaLangString = String.format(super.getResources().getString(2131362438), new Object[] { this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.displayNumber });
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_c_of_type_JavaLangString);
      }
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_b_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable((Drawable)localObject);
      if (this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new mk(this);
        addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      }
      k();
      return;
      localObject = getResources().getDrawable(2130838357);
      ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getIntrinsicWidth(), ((Drawable)localObject).getIntrinsicHeight());
      localObject = new ImageSpan((Drawable)localObject, 1);
      SpannableString localSpannableString = new SpannableString(this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.name + "[certified]");
      int j = this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.name.length();
      int k = this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.name.length();
      localSpannableString.setSpan(localObject, j, "[certified]".length() + k, 17);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(localSpannableString);
    }
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.followType == 1)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131362440);
      this.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this, 2131624044);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setText(2131362437);
    this.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this, 2131624044);
  }
  
  private void l()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    if (this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.groupInfoList != null)
    {
      int k = this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.groupInfoList.size();
      int j = 0;
      while (j < k)
      {
        a((mobileqq_mp.ConfigGroupInfo)this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.groupInfoList.get(j), j, k);
        j += 1;
      }
    }
  }
  
  private void m()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "updateView");
    }
    j();
    l();
    this.jdField_c_of_type_AndroidWidgetLinearLayout.invalidate();
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "updateView exit");
    }
  }
  
  private void n()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  private void o()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("crmtest", 4, "sendDetailInfoRequest, ts=" + System.currentTimeMillis());
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "sendDetailInfoRequest");
    }
    if (this.jdField_a_of_type_MqqAppNewIntent != null) {
      this.jdField_a_of_type_MqqAppNewIntent.setObserver(null);
    }
    this.jdField_a_of_type_MqqAppNewIntent = new NewIntent(super.getApplicationContext(), ProtoServlet.class);
    this.jdField_a_of_type_MqqAppNewIntent.putExtra("cmd", "EqqAccountSvc.get_eqq_detail");
    mobileqq_mp.GetEqqDetailInfoRequest localGetEqqDetailInfoRequest = new mobileqq_mp.GetEqqDetailInfoRequest();
    localGetEqqDetailInfoRequest.version.set(2);
    if (this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail != null) {
      localGetEqqDetailInfoRequest.seqno.set(this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.seqno);
    }
    try
    {
      for (;;)
      {
        localGetEqqDetailInfoRequest.eqq_id.set((int)Long.parseLong(this.jdField_b_of_type_JavaLangString));
        label151:
        this.jdField_a_of_type_MqqAppNewIntent.putExtra("data", localGetEqqDetailInfoRequest.toByteArray());
        this.jdField_a_of_type_MqqObserverBusinessObserver = new ml(this);
        this.jdField_a_of_type_MqqAppNewIntent.setObserver(this.jdField_a_of_type_MqqObserverBusinessObserver);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(this.jdField_a_of_type_MqqAppNewIntent);
        this.jdField_a_of_type_Int += 1;
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "sendDetailInfoRequest exit");
        }
        return;
        localGetEqqDetailInfoRequest.seqno.set(0);
      }
    }
    catch (Exception localException)
    {
      break label151;
    }
  }
  
  private void p()
  {
    boolean bool = super.getIntent().getBooleanExtra("need_finish", false);
    if (this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail == null) {
      return;
    }
    if (bool)
    {
      finish();
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.followType == 1)
    {
      localIntent = new Intent(this, ChatActivity.class);
      localIntent.putExtra("chat_subType", 1);
      localIntent.putExtra("cSpecialFlag", getIntent().getExtras().getInt("cSpecialFlag"));
      localIntent.putExtra("uin", this.jdField_b_of_type_JavaLangString);
      localIntent.putExtra("uintype", 0);
      localIntent.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.name);
      startActivity(localIntent);
      return;
    }
    Intent localIntent = new Intent(this, ChatActivity.class);
    localIntent.putExtra("chat_subType", 1);
    localIntent.putExtra("uin", this.jdField_b_of_type_JavaLangString);
    localIntent.putExtra("uintype", 1024);
    localIntent.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.name);
    startActivity(localIntent);
  }
  
  public void a(int paramInt)
  {
    Toast.makeText(this, paramInt, 0).show();
  }
  
  public void a(int paramInt, JSONArray paramJSONArray)
  {
    ArrayList localArrayList = new ArrayList();
    int j = 0;
    for (;;)
    {
      if (j < paramJSONArray.length()) {
        try
        {
          localArrayList.add(paramJSONArray.getString(j));
          j += 1;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            localJSONException.printStackTrace();
          }
        }
      }
    }
    paramJSONArray = new Intent(this, TroopAvatarWallPreviewActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putInt("index", paramInt);
    localBundle.putStringArrayList("seqNum", localArrayList);
    localBundle.putBoolean("IS_EDIT", false);
    localBundle.putBoolean("is_use_path", true);
    localBundle.putBoolean("is_show_action", false);
    paramJSONArray.putExtras(localBundle);
    startActivity(paramJSONArray);
  }
  
  public void a(boolean paramBoolean, LinearLayout paramLinearLayout, JSONArray paramJSONArray1, JSONArray paramJSONArray2)
  {
    int n = paramJSONArray2.length();
    if (n <= 0) {
      return;
    }
    if (paramBoolean) {}
    for (int j = getWindow().getWindowManager().getDefaultDisplay().getWidth() - getResources().getDimensionPixelSize(2131493040); n == 1; j = getWindow().getWindowManager().getDefaultDisplay().getWidth() - getResources().getDimensionPixelSize(2131493041))
    {
      localObject = new ImageView(this);
      ((ImageView)localObject).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      ((ImageView)localObject).setMaxWidth(j);
      ((ImageView)localObject).setMaxHeight(j);
      ((ImageView)localObject).setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
      ((ImageView)localObject).setOnClickListener(new mf(this, paramJSONArray1));
      try
      {
        paramJSONArray1 = URLDrawable.getDrawable(paramJSONArray2.getString(0));
        ((ImageView)localObject).setImageDrawable(paramJSONArray1);
        paramLinearLayout.addView((View)localObject);
        paramJSONArray1.setURLDrawableListener(new mg(this, (ImageView)localObject));
        return;
      }
      catch (JSONException paramLinearLayout)
      {
        paramLinearLayout.printStackTrace();
        return;
      }
    }
    int i1 = (int)(2.0F * this.jdField_a_of_type_Float);
    int m = (j - i1 * 2) / 3;
    Object localObject = new GridView(this);
    ((GridView)localObject).setColumnWidth(m);
    ((GridView)localObject).setHorizontalSpacing(i1);
    ((GridView)localObject).setVerticalSpacing(i1);
    ((GridView)localObject).setSelector(new ColorDrawable(0));
    int k;
    if (n == 4)
    {
      ((GridView)localObject).setNumColumns(2);
      ((GridView)localObject).setAdapter(new mh(this, n, paramJSONArray2, m));
      ((GridView)localObject).setOnItemClickListener(new mj(this, paramJSONArray1));
      k = j;
      if (n == 4) {
        k = m * 2 + i1;
      }
      if (n <= 6) {
        break label365;
      }
      j = m * 3 + i1 * 2;
    }
    for (;;)
    {
      ((GridView)localObject).setLayoutParams(new LinearLayout.LayoutParams(k, j));
      paramLinearLayout.addView((View)localObject);
      return;
      ((GridView)localObject).setNumColumns(3);
      break;
      label365:
      j = m;
      if (n >= 4) {
        j = m * 2 + i1;
      }
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    do
    {
      do
      {
        return super.dispatchTouchEvent(paramMotionEvent);
      } while (!this.jdField_f_of_type_Boolean);
      this.h = true;
      return true;
    } while (!this.h);
    this.h = false;
    return true;
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidWidgetButton) {
      if (this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail != null) {}
    }
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.followType != 1)
      {
        g();
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Biz_card", "Biz_card_follow", 0, 0, this.jdField_b_of_type_JavaLangString, "", "", "");
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
        this.jdField_a_of_type_AndroidWidgetButton.postDelayed(new mm(this), 1000L);
        return;
        h();
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Biz_card", "Biz_card_disfollow", 0, 0, this.jdField_b_of_type_JavaLangString, "", "", "");
      }
      if (paramView == this.jdField_a_of_type_AndroidViewView)
      {
        p();
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Biz_card", "Biz_card_talk", 0, 0, this.jdField_b_of_type_JavaLangString, "2", "", "");
        return;
      }
    } while ((paramView != this.p) || (this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail == null));
    ShareMsgHelper.a(this, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.name, this.jdField_c_of_type_JavaLangString, "http://s.p.qq.com/pub/get_face?img_type=3&uin=" + this.jdField_b_of_type_JavaLangString, "http://s.p.qq.com/mpmobile/card/index.html?puin=" + this.jdField_b_of_type_JavaLangString, ContactUtils.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()), 2);
    PublicAccountHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_JavaLangString, "Pb_account_lifeservice", "mp_msg_sys_10", "pbshare_click");
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    d();
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    paramMenu.add("menu");
    return super.onCreateOptionsMenu(paramMenu);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
    if (this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = null;
    }
    if (this.jdField_a_of_type_MqqAppNewIntent != null) {
      this.jdField_a_of_type_MqqAppNewIntent.setObserver(null);
    }
    if (this.jdField_c_of_type_MqqAppNewIntent != null) {
      this.jdField_c_of_type_MqqAppNewIntent.setObserver(null);
    }
    if (this.jdField_b_of_type_MqqAppNewIntent != null) {
      this.jdField_b_of_type_MqqAppNewIntent.setObserver(null);
    }
  }
  
  public boolean onMenuOpened(int paramInt, Menu paramMenu)
  {
    if (this.jdField_b_of_type_Boolean) {}
    return false;
  }
  
  public void onResume()
  {
    super.onResume();
    if ((this.jdField_b_of_type_JavaLangString != null) && (!this.g)) {
      i();
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("crmtest", 4, "detail activity opened, ts=" + System.currentTimeMillis());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.biz.eqq.EnterpriseDetailActivity
 * JD-Core Version:    0.7.0.1
 */