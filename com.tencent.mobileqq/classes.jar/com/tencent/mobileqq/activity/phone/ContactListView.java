package com.tencent.mobileqq.activity.phone;

import MyCarrier.Carrier;
import SecurityAccountServer.RespondQueryQQBindingStat;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.ProfileActivity.CardContactInfo;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.adapter.ContactBindedAdapter;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.forward.ForwardAbility.ForwardAbilityType;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.forward.ForwardOptionBuilder;
import com.tencent.mobileqq.forward.ForwardShareCardOption;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.mybusiness.MyBusinessManager;
import com.tencent.mobileqq.qcall.QCallDetailActivity;
import com.tencent.mobileqq.search.activity.ContactSearchComponentActivity;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.IndexView.OnIndexChangedListener;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ListView;
import com.tencent.widget.XListView;
import cooperation.qqpim.QQPimGetTipsInfoIPC;
import cooperation.qqpim.QQPimGetTipsInfoIPC.IGetQQPimTipsCallBack;
import cooperation.qqpim.QQPimTipsInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import mqq.app.AppRuntime;
import wtu;
import wtv;
import wtw;
import wtx;
import wty;
import wtz;
import wua;
import wub;
import wuc;
import wud;

@SuppressLint({"ViewConstructor"})
public class ContactListView
  extends BaseActivityView
  implements Handler.Callback, View.OnClickListener, FaceDecoder.DecodeTaskCompletionListener, IndexView.OnIndexChangedListener, AbsListView.OnScrollListener
{
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#" };
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Handler jdField_a_of_type_AndroidOsHandler;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new wtu(this);
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  public ContactBindedAdapter a;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new wtv(this);
  public ForwardBaseOption a;
  private FaceDecoder jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder;
  private IndexView jdField_a_of_type_ComTencentMobileqqWidgetIndexView;
  ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private QQPimGetTipsInfoIPC.IGetQQPimTipsCallBack jdField_a_of_type_CooperationQqpimQQPimGetTipsInfoIPC$IGetQQPimTipsCallBack = new wtz(this);
  public ArrayList a;
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  List jdField_a_of_type_JavaUtilList;
  wua jdField_a_of_type_Wua;
  private wub jdField_a_of_type_Wub;
  public wud a;
  private boolean jdField_a_of_type_Boolean;
  public int b;
  private ImageView b;
  public List b;
  private int jdField_c_of_type_Int = 0;
  private View jdField_c_of_type_AndroidViewView;
  private List jdField_c_of_type_JavaUtilList;
  private View jdField_d_of_type_AndroidViewView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private View e;
  private View f;
  
  public ContactListView(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    a(2130969160);
    if (QLog.isColorLevel()) {
      QLog.i("ContactListView", 2, "ContactListView()");
    }
    this.jdField_a_of_type_Wud = new wud(this);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131365445));
    if (paramInt != 2)
    {
      this.jdField_d_of_type_AndroidViewView = b();
      this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView(this.jdField_d_of_type_AndroidViewView);
    }
    a("P_CliOper", "QQwangting", "txl_show_bluebar", "show_bluebar");
    a(false);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView = ((IndexView)findViewById(2131365446));
  }
  
  private View a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ContactListView", 2, "generateMergeContactsView()");
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800670F", "0X800670F", 0, 0, "", "", "", "");
    if (this.e == null) {
      this.e = LayoutInflater.from(getContext()).inflate(2130971628, this.jdField_a_of_type_ComTencentWidgetXListView, false);
    }
    this.e.findViewById(2131375215).setOnClickListener(new wtx(this));
    this.e.findViewById(2131375212).setOnClickListener(new wty(this));
    if (!TextUtils.isEmpty(paramString)) {
      ((TextView)this.e.findViewById(2131375214)).setText(paramString);
    }
    return this.e;
  }
  
  private QQAppInterface a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface))) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  private void a(View paramView)
  {
    paramView = (wuc)paramView.getTag();
    Object localObject1 = paramView.jdField_a_of_type_ComTencentMobileqqDataPhoneContact;
    int i = paramView.jdField_a_of_type_Int;
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (i == 2)
    {
      paramView = "0";
      ReportController.b((QQAppInterface)localObject2, "CliOper", "", "", "Mobile_contacts", "Clk_addlist_msg", 0, 0, paramView, "", "", "");
      if (i != 2) {
        break label215;
      }
      paramView = AIOUtils.a(new Intent(getContext(), SplashActivity.class), null);
      paramView.putExtra("uin", ((PhoneContact)localObject1).uin);
      localObject2 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
      if (localObject2 != null)
      {
        localObject1 = ((FriendsManager)localObject2).c(String.valueOf(((PhoneContact)localObject1).uin));
        if (localObject1 != null)
        {
          paramView.putExtra("cSpecialFlag", ((Friends)localObject1).cSpecialFlag);
          paramView.putExtra("uinname", ((Friends)localObject1).getFriendNickWithAlias());
          if ((CrmUtils.a(((Friends)localObject1).cSpecialFlag)) || (QidianManager.b(((Friends)localObject1).cSpecialFlag))) {
            paramView.putExtra("chat_subType", 1);
          }
        }
      }
      paramView.putExtra("entrance", 3);
      paramView.putExtra("uintype", 0);
      a(paramView);
    }
    label215:
    while (i != 3)
    {
      return;
      paramView = "1";
      break;
    }
    paramView = ((PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10)).a();
    localObject2 = paramView.nationCode + paramView.mobileNo;
    paramView = AIOUtils.a(new Intent(getContext(), SplashActivity.class), null);
    paramView.putExtra("entrance", 3);
    paramView.putExtra("uin", ((PhoneContact)localObject1).nationCode + ((PhoneContact)localObject1).mobileCode);
    paramView.putExtra("phonenum", (String)localObject2);
    paramView.putExtra("uintype", 1006);
    paramView.putExtra("uinname", ((PhoneContact)localObject1).name);
    localObject2 = new ProfileActivity.AllInOne(((PhoneContact)localObject1).nationCode + ((PhoneContact)localObject1).mobileCode, 31);
    ((ProfileActivity.AllInOne)localObject2).jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    ((ProfileActivity.AllInOne)localObject2).jdField_h_of_type_JavaLangString = ((PhoneContact)localObject1).nickName;
    ((ProfileActivity.AllInOne)localObject2).k = ((PhoneContact)localObject1).name;
    ((ProfileActivity.AllInOne)localObject2).jdField_a_of_type_JavaUtilArrayList.add(new ProfileActivity.CardContactInfo(((PhoneContact)localObject1).name, ((PhoneContact)localObject1).mobileCode, ((PhoneContact)localObject1).nationCode));
    ((ProfileActivity.AllInOne)localObject2).d = ((PhoneContact)localObject1).ability;
    ((ProfileActivity.AllInOne)localObject2).g = 3;
    ((ProfileActivity.AllInOne)localObject2).jdField_h_of_type_Int = 59;
    paramView.putExtra("AIO_INFO", (Parcelable)localObject2);
    a(paramView);
  }
  
  private void a(ListView paramListView, String paramString, Bitmap paramBitmap)
  {
    int j;
    int i;
    if (this.jdField_c_of_type_Int == 0)
    {
      j = paramListView.getChildCount();
      i = 0;
    }
    for (;;)
    {
      if (i < j)
      {
        wuc localwuc = (wuc)paramListView.getChildAt(i).getTag();
        if ((localwuc != null) && (paramString.equals(localwuc.jdField_a_of_type_JavaLangString))) {
          localwuc.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
        }
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
  
  private void a(QQPimTipsInfo paramQQPimTipsInfo)
  {
    if (QLog.isColorLevel())
    {
      QLog.i("ContactListView", 2, "refreshBlueBarTipsUi() tipsType " + paramQQPimTipsInfo.jdField_a_of_type_Int);
      QLog.i("ContactListView", 2, "refreshBlueBarTipsUi() tipsString " + paramQQPimTipsInfo.jdField_a_of_type_JavaLangString);
      QLog.i("ContactListView", 2, "refreshBlueBarTipsUi() repeatContactNum " + paramQQPimTipsInfo.jdField_b_of_type_Int);
      QLog.i("ContactListView", 2, "refreshBlueBarTipsUi() mTextViewQQPimTips " + this.jdField_d_of_type_AndroidWidgetTextView.getClass().hashCode());
    }
    if (paramQQPimTipsInfo.jdField_a_of_type_Int == 0)
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
      this.jdField_d_of_type_AndroidWidgetTextView.setText("");
    }
    while (paramQQPimTipsInfo.jdField_a_of_type_Int == 3)
    {
      a(true, paramQQPimTipsInfo.jdField_a_of_type_JavaLangString);
      return;
      if ((paramQQPimTipsInfo.jdField_a_of_type_Int == 1) || (paramQQPimTipsInfo.jdField_a_of_type_Int == 2) || (paramQQPimTipsInfo.jdField_a_of_type_Int == 4))
      {
        if (TextUtils.isEmpty(paramQQPimTipsInfo.jdField_a_of_type_JavaLangString)) {
          this.jdField_d_of_type_AndroidWidgetTextView.setText("");
        }
        for (;;)
        {
          if (paramQQPimTipsInfo.jdField_a_of_type_Byte <= 0) {
            break label245;
          }
          this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          break;
          this.jdField_d_of_type_AndroidWidgetTextView.setText(paramQQPimTipsInfo.jdField_a_of_type_JavaLangString);
        }
        label245:
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
      }
    }
    a(false, null);
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramString2, "", paramString3, paramString4, 0, 0, "", "", "", "");
  }
  
  private void a(wuc paramwuc, String paramString, int paramInt)
  {
    Bitmap localBitmap2 = this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(paramInt, paramString);
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null)
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a()) {
        this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(paramString, paramInt, false);
      }
      if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
        this.jdField_a_of_type_AndroidGraphicsBitmap = ImageUtil.a();
      }
      localBitmap1 = this.jdField_a_of_type_AndroidGraphicsBitmap;
    }
    paramwuc.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap1);
    paramwuc.jdField_a_of_type_JavaLangString = paramString;
  }
  
  private void a(boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = getContext().getSharedPreferences("contact_bind_info_global", 0);
    SharedPreferences.Editor localEditor;
    if (localSharedPreferences != null)
    {
      localEditor = localSharedPreferences.edit();
      if (!paramBoolean) {
        break label51;
      }
    }
    label51:
    for (int i = 3;; i = localSharedPreferences.getInt("business_show_count", 0) + 1)
    {
      localEditor.putInt("business_show_count", i);
      localEditor.commit();
      return;
    }
  }
  
  private void a(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ContactListView", 2, "initBlueTipsBar()");
    }
    if (paramBoolean) {
      paramString = a(paramString);
    }
    for (;;)
    {
      if (paramString != null)
      {
        this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView(paramString);
        if (this.jdField_d_of_type_AndroidViewView != null)
        {
          this.jdField_a_of_type_ComTencentWidgetXListView.removeHeaderView(this.jdField_d_of_type_AndroidViewView);
          this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView(this.jdField_d_of_type_AndroidViewView);
        }
      }
      return;
      if ((b()) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_ComTencentWidgetXListView != null))
      {
        paramString = ((MyBusinessManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(48)).a();
        if ((paramString != null) && (!TextUtils.isEmpty(paramString.carrierURL))) {}
        for (int i = 0;; i = 8)
        {
          if (i != 0) {
            break label139;
          }
          paramString = c();
          break;
        }
      }
      label139:
      paramString = null;
    }
  }
  
  private View b()
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80066FE", "0X80066FE", 0, 0, "", "", "", "");
    View localView = LayoutInflater.from(getContext()).inflate(2130971627, this.jdField_a_of_type_ComTencentWidgetXListView, false);
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131375210));
    if (QLog.isColorLevel()) {
      QLog.i("ContactListView", 2, "generateBackupContactsView() " + this.jdField_d_of_type_AndroidWidgetTextView.getClass().hashCode());
    }
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131375211));
    localView.setOnClickListener(new wtw(this));
    return localView;
  }
  
  private void b(View paramView)
  {
    Object localObject = (wuc)paramView.getTag();
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    int j;
    int i;
    if (((wuc)localObject).jdField_a_of_type_Int == 2)
    {
      paramView = "0";
      ReportController.b(localQQAppInterface, "CliOper", "", "", "Mobile_contacts", "Clk_addlist_call", 0, 0, paramView, "", "", "");
      paramView = ((wuc)localObject).jdField_a_of_type_ComTencentMobileqqDataPhoneContact;
      j = ((wuc)localObject).jdField_a_of_type_Int;
      i = 0;
      if (j != 2) {
        break label170;
      }
      i = 0;
    }
    for (;;)
    {
      localObject = paramView.nationCode + paramView.mobileCode;
      ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getContext(), i, paramView.uin, paramView.name, (String)localObject, true, null, true, true, null, "from_internal");
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Two_call", "Two_call_launch", 0, 0, "9", "", "", "");
      return;
      paramView = "1";
      break;
      label170:
      if (j == 3) {
        i = 1006;
      }
    }
  }
  
  private boolean b()
  {
    SharedPreferences localSharedPreferences = getContext().getSharedPreferences("contact_bind_info_global", 0);
    return (localSharedPreferences == null) || (localSharedPreferences.getInt("business_show_count", 0) < 3);
  }
  
  private View c()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ContactListView", 2, "generateBusinessView()");
    }
    if (this.f == null) {
      this.f = LayoutInflater.from(getContext()).inflate(2130970294, this.jdField_a_of_type_ComTencentWidgetXListView, false);
    }
    this.f.findViewById(2131369975).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.f.findViewById(2131369973).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.f.setVisibility(0);
    return this.f;
  }
  
  private void c(View paramView)
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800474C", "0X800474C", 0, 0, "", "", "", "");
    PhoneContact localPhoneContact = ((wuc)paramView.getTag()).jdField_a_of_type_ComTencentMobileqqDataPhoneContact;
    a(AddFriendLogicActivity.a(getContext(), 2, localPhoneContact.nationCode + localPhoneContact.mobileCode, null, 3006, 3, localPhoneContact.name, null, null, "手机联系人", null));
    if (this.jdField_a_of_type_Int != 3) {}
    for (;;)
    {
      return;
      paramView = paramView.getTag(2131362290);
      if (paramView != null)
      {
        int i = ((Integer)paramView).intValue();
        if (i < 5)
        {
          paramView = null;
          switch (i)
          {
          }
          while (paramView != null)
          {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", paramView, paramView, 0, 0, "", "", "", "");
            return;
            paramView = "0X80068B7";
            continue;
            paramView = "0X80068B8";
            continue;
            paramView = "0X80068B9";
            continue;
            paramView = "0X80068BA";
            continue;
            paramView = "0X80068BB";
          }
        }
      }
    }
  }
  
  private void d(View paramView)
  {
    Object localObject = (wuc)paramView.getTag();
    if ((localObject == null) || (((wuc)localObject).jdField_a_of_type_ComTencentMobileqqDataPhoneContact == null)) {
      return;
    }
    PhoneContact localPhoneContact = ((wuc)localObject).jdField_a_of_type_ComTencentMobileqqDataPhoneContact;
    int i = ((wuc)localObject).jdField_a_of_type_Int;
    if (this.jdField_a_of_type_Int == 2)
    {
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption instanceof ForwardShareCardOption;
      label129:
      Bundle localBundle;
      if ((i == 2) && (!bool))
      {
        paramView = new Bundle();
        paramView.putString("uin", localPhoneContact.uin);
        paramView.putInt("uintype", 0);
        paramView.putString("uinname", localPhoneContact.name);
        this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().putExtras(paramView);
        this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a(ForwardAbility.ForwardAbilityType.b.intValue(), paramView);
        if (!bool) {
          break label259;
        }
        localBundle = new Bundle();
        localObject = localPhoneContact.mobileCode;
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          break label261;
        }
        paramView = localPhoneContact.mobileNo;
        label164:
        if (TextUtils.isEmpty(localPhoneContact.uin)) {
          break label289;
        }
      }
      label259:
      label261:
      label289:
      for (bool = true;; bool = false)
      {
        localBundle.putBoolean("bindContact", bool);
        localBundle.putString("uin", paramView);
        localBundle.putInt("uintype", 1006);
        localBundle.putString("uinname", localPhoneContact.name);
        this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().putExtras(localBundle);
        this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a(ForwardAbility.ForwardAbilityType.h.intValue(), localBundle);
        return;
        if (i != 3) {
          break label129;
        }
        bool = true;
        break label129;
        break;
        i = ((String)localObject).indexOf("|");
        paramView = (View)localObject;
        if (i <= -1) {
          break label164;
        }
        paramView = ((String)localObject).substring(0, i);
        break label164;
      }
    }
    if (this.jdField_a_of_type_Int == 0)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (i == 2)
      {
        paramView = "0";
        ReportController.b((QQAppInterface)localObject, "CliOper", "", "", "Mobile_contacts", "Clk_addlist_prof", 0, 0, paramView, "", "", "");
        label343:
        paramView = getContext();
        localObject = new Intent(paramView, QCallDetailActivity.class);
        ((Intent)localObject).putExtra("contactID", localPhoneContact.contactID);
        switch (i)
        {
        default: 
          ((Intent)localObject).putExtra("uin", localPhoneContact.mobileNo);
          ((Intent)localObject).putExtra("uintype", 56938);
          ((Intent)localObject).putExtra("uinname", localPhoneContact.name);
        }
      }
    }
    for (;;)
    {
      ((Intent)localObject).putExtra("entrance", "Call");
      paramView.startActivity((Intent)localObject);
      return;
      paramView = "1";
      break;
      if (this.jdField_a_of_type_Int != 3) {
        break label343;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800474B", "0X800474B", 0, 0, "", "", "", "");
      paramView = paramView.getTag(2131362290);
      if (paramView == null) {
        break label343;
      }
      int j = ((Integer)paramView).intValue();
      if (j >= 5) {
        break label343;
      }
      paramView = null;
      switch (j)
      {
      }
      while (paramView != null)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", paramView, paramView, 0, 0, "", "", "", "");
        break;
        paramView = "0X80068B2";
        continue;
        paramView = "0X80068B3";
        continue;
        paramView = "0X80068B4";
        continue;
        paramView = "0X80068B5";
        continue;
        paramView = "0X80068B6";
      }
      ((Intent)localObject).putExtra("uin", localPhoneContact.uin);
      ((Intent)localObject).putExtra("uintype", 0);
      ((Intent)localObject).putExtra("uinname", localPhoneContact.nickName);
      continue;
      ((Intent)localObject).putExtra("uin", localPhoneContact.nationCode + localPhoneContact.mobileCode);
      ((Intent)localObject).putExtra("uintype", 1006);
      ((Intent)localObject).putExtra("uinname", localPhoneContact.name);
    }
  }
  
  private void m()
  {
    int j = 256;
    if (this.jdField_a_of_type_Int == 3) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800474D", "0X800474D", 0, 0, "", "", "", "");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication();
    int i = 561243;
    if ((this.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Int == 5))
    {
      j = 768;
      i = 561246;
      ContactSearchComponentActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, null, 3, j, i);
      return;
    }
    if (this.jdField_a_of_type_Int == 2) {
      if (!(this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption instanceof ForwardShareCardOption)) {
        break label139;
      }
    }
    label139:
    for (i = 32768;; i = 256)
    {
      j = i;
      i = 561248;
      break;
      if (this.jdField_a_of_type_Int == 3)
      {
        i = 561247;
        break;
      }
      j = 0;
      break;
    }
  }
  
  public View a()
  {
    View localView = LayoutInflater.from(getContext()).inflate(2130969161, null);
    wuc localwuc = new wuc(null);
    localwuc.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131365447));
    localwuc.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131365448));
    localwuc.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131365449));
    localwuc.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131365450));
    localwuc.jdField_a_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131365451));
    localwuc.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    localwuc.jdField_b_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131365452));
    localwuc.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    localwuc.jdField_c_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131365454));
    localwuc.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(this);
    localwuc.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131365453));
    localwuc.jdField_a_of_type_AndroidViewView = localView.findViewById(2131365455);
    if (this.jdField_a_of_type_Int == 3)
    {
      localwuc.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      localwuc.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
      localwuc.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    for (;;)
    {
      localView.setTag(localwuc);
      return localView;
      localwuc.jdField_c_of_type_AndroidWidgetButton.setVisibility(8);
      localwuc.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  protected void a()
  {
    super.a();
    if (QLog.isColorLevel()) {
      QLog.i("ContactListView", 2, "onStart()");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setHandler(ContactListView.class, this.jdField_a_of_type_Wud);
    if (this.jdField_a_of_type_Int == 2) {
      this.jdField_b_of_type_AndroidWidgetTextView.setText("手机通讯录");
    }
    int i;
    for (;;)
    {
      if (this.jdField_a_of_type_Wub == null)
      {
        this.jdField_a_of_type_Wub = new wub(this, null);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Wub);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      j();
      i = this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.c();
      if ((this.jdField_a_of_type_Int != 2) || (!(this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption instanceof ForwardShareCardOption))) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b();
      return;
      if ((this.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Int == 5)) {
        this.jdField_b_of_type_AndroidWidgetTextView.setText("通讯录");
      } else if (this.jdField_a_of_type_Int == 3) {
        this.jdField_b_of_type_AndroidWidgetTextView.setText("手机联系人");
      }
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (i != 0) {}
    for (boolean bool = true;; bool = false)
    {
      localTextView.setEnabled(bool);
      break;
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if (QLog.isColorLevel()) {
      QLog.i("ContactListView", 2, "onActivityResult() ");
    }
    Object localObject;
    if (paramInt1 == 1) {
      if (paramInt2 == 2)
      {
        localObject = new Intent(getContext(), BindNumberActivity.class);
        ((Intent)localObject).putExtra("kNeedUnbind", true);
        a((Intent)localObject);
        if (paramInt2 != -1) {}
      }
    }
    switch (paramInt1)
    {
    default: 
    case 561247: 
      do
      {
        return;
        if (paramInt2 == 0)
        {
          int i = this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.c();
          if ((i != 1) && (i != 5)) {
            break;
          }
          a(new Intent(getContext(), PhoneLaunchActivity.class));
          break;
        }
        if (paramInt2 == 4002)
        {
          f();
          break;
        }
        a(new Intent(getContext(), PhoneLaunchActivity.class));
        break;
        if (paramInt1 != 1000) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.a(true, false);
        break;
      } while (paramIntent == null);
      localObject = paramIntent.getStringExtra("contactSearchResultUin");
      paramInt1 = paramIntent.getIntExtra("contactSearchResultUinType", 0);
      String str1 = paramIntent.getStringExtra("contactSearchResultName");
      long l = paramIntent.getLongExtra("contactSearchResultPhoneContactOriginBinder", -1L);
      String str2 = paramIntent.getStringExtra("contactSearchResultPhoneContactMobileCode");
      String str3 = paramIntent.getStringExtra("contactSearchResultPhoneContactNationCode");
      paramInt2 = paramIntent.getIntExtra("contactSearchResultPhoneContactAbility", -1);
      paramIntent = null;
      if (paramInt1 == 1006) {
        if (l == 3L)
        {
          paramInt1 = 32;
          paramIntent = new ProfileActivity.AllInOne((String)localObject, paramInt1);
          paramIntent.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
          paramIntent.k = str1;
          paramIntent.jdField_a_of_type_JavaUtilArrayList.add(new ProfileActivity.CardContactInfo(str1, str2, str3));
          paramIntent.d = paramInt2;
          paramIntent.g = 3;
        }
      }
      for (;;)
      {
        ProfileActivity.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramIntent);
        return;
        paramInt1 = 31;
        break;
        if (paramInt1 == 0) {
          paramIntent = new ProfileActivity.AllInOne((String)localObject, 1);
        }
      }
    }
    SearchUtils.a(paramIntent, this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption);
  }
  
  protected void a(Intent paramIntent, PhoneInnerFrame paramPhoneInnerFrame)
  {
    super.a(paramIntent, paramPhoneInnerFrame);
    if (QLog.isColorLevel()) {
      QLog.i("ContactListView", 2, "onCreate()");
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.c();
    boolean bool;
    if ((this.jdField_a_of_type_Int != 2) || ((i != 1) && (i != 2) && (i != 6) && (i != 7) && (i != 3)))
    {
      this.jdField_c_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2130971517, this.jdField_a_of_type_ComTencentWidgetXListView, false);
      this.jdField_c_of_type_AndroidViewView.findViewById(2131368321).setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_c_of_type_AndroidViewView.findViewById(2131368322));
      this.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(false);
      this.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(false);
      this.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView(this.jdField_c_of_type_AndroidViewView);
      bool = true;
      if ((this.jdField_a_of_type_Int == 2) && (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null)) {
        this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption = ForwardOptionBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      }
      if ((this.jdField_a_of_type_Int != 0) && (this.jdField_a_of_type_Int != 2) && (this.jdField_a_of_type_Int != 5)) {
        break label365;
      }
      if (this.jdField_c_of_type_AndroidViewView != null) {
        this.jdField_c_of_type_AndroidViewView.setPadding(0, 0, 40, 0);
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null)
      {
        paramIntent = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getStringArrayExtra("key_reserved_mobile");
        if ((paramIntent != null) && (paramIntent.length > 0)) {
          this.jdField_c_of_type_JavaUtilList = Arrays.asList(paramIntent);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this);
      if ((this.jdField_a_of_type_Int != 2) && (this.jdField_a_of_type_Wud != null)) {
        this.jdField_a_of_type_Wud.sendEmptyMessageDelayed(5, 1000L);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setIndex(jdField_a_of_type_ArrayOfJavaLangString, bool, false, false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setOnIndexChangedListener(this);
      this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.a(true, false);
      return;
      bool = false;
      break;
      label365:
      this.jdField_a_of_type_ComTencentMobileqqAdapterContactBindedAdapter = new ContactBindedAdapter(getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetXListView, this.jdField_b_of_type_JavaUtilList);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqAdapterContactBindedAdapter);
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(8);
    }
  }
  
  public void a(View paramView, PhoneContact paramPhoneContact, boolean paramBoolean)
  {
    wuc localwuc = (wuc)paramView.getTag();
    if (paramBoolean)
    {
      localwuc.jdField_b_of_type_AndroidWidgetTextView.setText(String.format("%s(%s)", new Object[] { paramPhoneContact.name, paramPhoneContact.mobileNo }));
      localwuc.jdField_a_of_type_JavaLangString = null;
      localwuc.jdField_a_of_type_ComTencentMobileqqDataPhoneContact = paramPhoneContact;
      if (!TextUtils.isEmpty(paramPhoneContact.uin)) {
        break label215;
      }
      localwuc.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      localwuc.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      localwuc.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      localwuc.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
      localwuc.jdField_a_of_type_Int = 1;
      localwuc.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840189);
      paramPhoneContact = ContactUtils.a(paramPhoneContact.name);
      localwuc.jdField_a_of_type_AndroidWidgetTextView.setText(paramPhoneContact);
      if (!ContactUtils.a(paramPhoneContact)) {
        break label192;
      }
      localwuc.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, paramView.getResources().getDimensionPixelSize(2131558467));
      label166:
      localwuc.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    label192:
    label215:
    label499:
    do
    {
      do
      {
        return;
        localwuc.jdField_b_of_type_AndroidWidgetTextView.setText(paramPhoneContact.name);
        break;
        localwuc.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, paramView.getResources().getDimensionPixelSize(2131558468));
        break label166;
        localwuc.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        localwuc.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        if ((this.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Int == 5))
        {
          localwuc.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          localwuc.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
        }
        localwuc.jdField_a_of_type_AndroidWidgetButton.setTag(localwuc);
        localwuc.jdField_b_of_type_AndroidWidgetButton.setTag(localwuc);
        localwuc.jdField_a_of_type_AndroidWidgetButton.setContentDescription("向" + paramPhoneContact.name + "发消息");
        localwuc.jdField_b_of_type_AndroidWidgetButton.setContentDescription("向" + paramPhoneContact.name + "发起语音通话");
        if (!paramPhoneContact.uin.equals("0"))
        {
          localwuc.jdField_a_of_type_Int = 2;
          a(localwuc, paramPhoneContact.uin, 1);
          localwuc.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          return;
        }
        localwuc.jdField_a_of_type_Int = 3;
        a(localwuc, paramPhoneContact.nationCode + paramPhoneContact.mobileCode, 11);
        if (this.jdField_a_of_type_Int != 5) {
          break label543;
        }
        if (!paramPhoneContact.isHiden) {
          break label499;
        }
        localwuc.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      } while (!AppSetting.b);
      paramView.setContentDescription(paramPhoneContact.name + "，已隐藏");
      return;
      localwuc.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    } while (!AppSetting.b);
    paramView.setContentDescription(paramPhoneContact.name + "，未隐藏");
    return;
    label543:
    localwuc.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
    if (paramInt != 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a();
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.c();
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a()) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b();
    }
    int j = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
    paramInt = 0;
    label52:
    Bitmap localBitmap;
    if (paramInt < j)
    {
      paramAbsListView = (wuc)this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(paramInt).getTag();
      if ((paramAbsListView != null) && (!TextUtils.isEmpty(paramAbsListView.jdField_a_of_type_JavaLangString)))
      {
        int i = 1;
        if (paramAbsListView.jdField_a_of_type_Int == 3) {
          i = 11;
        }
        localBitmap = this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(i, paramAbsListView.jdField_a_of_type_JavaLangString);
        if (localBitmap != null) {
          break label140;
        }
        this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(paramAbsListView.jdField_a_of_type_JavaLangString, i, false);
      }
    }
    for (;;)
    {
      paramInt += 1;
      break label52;
      break;
      label140:
      paramAbsListView.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  protected void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ContactListView", 2, "onResume()");
    }
    super.b();
    ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(getWindowToken(), 0);
    if (this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.c() != 9)
    {
      if (!NetworkUtil.d(getContext())) {
        break label97;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.e()) {
        a(2131434453, 0L, false);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.a(true, true);
    h();
    return;
    label97:
    a(2131434613, 3000L);
  }
  
  public void b(String paramString)
  {
    if ("$".equals(paramString))
    {
      this.jdField_a_of_type_ComTencentWidgetXListView.setSelection(0);
      return;
    }
    XListView localXListView = this.jdField_a_of_type_ComTencentWidgetXListView;
    int i = this.jdField_a_of_type_ComTencentWidgetXListView.getHeaderViewsCount();
    localXListView.setSelection(((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(paramString)).intValue() + i);
  }
  
  protected void d()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ContactListView", 2, "onStop()");
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.c();
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.d();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeHandler(ContactListView.class);
    i();
    g();
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet != null)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.cancel();
      this.jdField_a_of_type_ComTencentWidgetActionSheet = null;
    }
    if (this.jdField_a_of_type_Wub != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Wub);
      this.jdField_a_of_type_Wub = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    super.d();
  }
  
  protected void e()
  {
    QQPimGetTipsInfoIPC.a().a();
    if (this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption != null) {
      this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.s();
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(7);
    }
    super.e();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(7);
      paramMessage = new ArrayList();
      paramMessage.add(this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.a(this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.a(), true));
      paramMessage.add(new ArrayList());
      this.jdField_a_of_type_JavaUtilList = paramMessage;
      this.jdField_a_of_type_Wud.sendEmptyMessage(8);
    }
  }
  
  public void j()
  {
    int i;
    if ((this.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_Int == 5))
    {
      i = this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.c();
      if (QLog.isColorLevel()) {
        QLog.d("ContactListView", 2, "the load contact mode is retype=" + this.jdField_a_of_type_Int + ", state=" + i);
      }
      if ((i == 1) || (i == 2) || (i == 6) || (i == 7) || (i == 3)) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(7);
      }
    }
    do
    {
      do
      {
        return;
        k();
        return;
      } while (this.jdField_a_of_type_Int != 3);
      i = this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.a(this.jdField_c_of_type_JavaUtilList);
    } while (!QLog.isColorLevel());
    QLog.d("ContactListView", 2, "load contact friend result: " + i);
  }
  
  void k()
  {
    boolean bool;
    ArrayList localArrayList;
    if ((this.jdField_a_of_type_Int == 2) && ((this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption instanceof ForwardShareCardOption)))
    {
      bool = true;
      if ((this.jdField_a_of_type_Int != 5) && (!bool)) {
        break label84;
      }
      localArrayList = new ArrayList();
      localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.b(bool));
      localArrayList.add(new ArrayList());
    }
    label84:
    for (this.jdField_a_of_type_JavaUtilList = localArrayList;; this.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.e())
    {
      l();
      return;
      bool = false;
      break;
    }
  }
  
  public void l()
  {
    if (this.jdField_a_of_type_Wua == null)
    {
      this.jdField_a_of_type_Wua = new wua(this, null);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Wua);
    }
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      this.jdField_a_of_type_Wud.sendEmptyMessageDelayed(1, 1000L);
      return;
    }
    this.jdField_a_of_type_JavaUtilHashMap = new LinkedHashMap();
    Object localObject1 = jdField_a_of_type_ArrayOfJavaLangString;
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      localObject2 = localObject1[i];
      this.jdField_a_of_type_JavaUtilHashMap.put(localObject2, Integer.valueOf(0));
      i += 1;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = "*";
    Iterator localIterator = ((List)this.jdField_a_of_type_JavaUtilList.get(0)).iterator();
    while (localIterator.hasNext())
    {
      PhoneContact localPhoneContact = (PhoneContact)localIterator.next();
      Object localObject3 = localPhoneContact.pinyinFirst;
      localObject1 = localObject3;
      if (this.jdField_a_of_type_JavaUtilHashMap.get(localObject3) == null)
      {
        localObject1 = "#";
        localPhoneContact.pinyinFirst = "#";
      }
      localObject3 = localObject2;
      if (!((String)localObject2).equals(localObject1))
      {
        localArrayList.add(null);
        localObject3 = localObject1;
      }
      localArrayList.add(localPhoneContact);
      this.jdField_a_of_type_JavaUtilHashMap.put(localObject1, Integer.valueOf(((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(localObject1)).intValue() + 1));
      localObject2 = localObject3;
    }
    localObject1 = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    i = 0;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      j = ((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(localObject2)).intValue();
      if (j == 0) {
        break label492;
      }
    }
    label492:
    for (j = j + i + 1;; j = i)
    {
      this.jdField_a_of_type_JavaUtilHashMap.put(localObject2, Integer.valueOf(i));
      i = j;
      break;
      if (this.jdField_a_of_type_Int == 0)
      {
        localObject1 = (List)this.jdField_a_of_type_JavaUtilList.get(1);
        if (((List)localObject1).size() > 0)
        {
          this.jdField_a_of_type_JavaUtilHashMap.put("未启用通讯录的联系人", Integer.valueOf(localArrayList.size()));
          localArrayList.add(null);
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (PhoneContact)((Iterator)localObject1).next();
            ((PhoneContact)localObject2).pinyinFirst = "未启用通讯录的联系人";
            localArrayList.add(localObject2);
          }
        }
      }
      this.jdField_a_of_type_JavaUtilArrayList = localArrayList;
      this.jdField_b_of_type_Int = this.jdField_a_of_type_JavaUtilArrayList.size();
      if (this.jdField_b_of_type_Int > 10) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(0);
      }
      for (;;)
      {
        this.jdField_a_of_type_Wua.notifyDataSetChanged();
        return;
        this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(8);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(getWindowToken(), 0);
    switch (paramView.getId())
    {
    default: 
      d(paramView);
      return;
    case 2131368322: 
      m();
      return;
    case 2131363428: 
      if (this.jdField_a_of_type_Int == 2)
      {
        f();
        return;
      }
      paramView = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent();
      Intent localIntent = new Intent(getContext(), SettingActivity2.class);
      if (paramView.hasExtra("kSrouce")) {
        localIntent.putExtra("kSrouce", paramView.getIntExtra("kSrouce", 6));
      }
      a(localIntent, 1);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Moblie_contacts", "Moblie_contacts_setting", 0, 0, "", "", "", "");
      return;
    case 2131365451: 
      a(paramView);
      return;
    case 2131365452: 
      b(paramView);
      return;
    }
    c(paramView);
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((paramBitmap == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    a(this.jdField_a_of_type_ComTencentWidgetXListView, paramString, paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.ContactListView
 * JD-Core Version:    0.7.0.1
 */