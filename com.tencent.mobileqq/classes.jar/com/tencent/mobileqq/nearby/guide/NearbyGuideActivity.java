package com.tencent.mobileqq.nearby.guide;

import aepw;
import aepx;
import aepy;
import aepz;
import aeqb;
import aeqe;
import aeqf;
import aeqg;
import aeqh;
import aeqi;
import aeqj;
import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.CycleInterpolator;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.photo.PhotoCropActivity;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.NearbyFakeActivity;
import com.tencent.mobileqq.nearby.NearbyProcessMonitor;
import com.tencent.mobileqq.nearby.NearbySPUtil;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.nearby.business.NearbyCardHandler;
import com.tencent.mobileqq.nearby.business.NearbyCardObserver;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.compress.CompressOperator;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.NearbyPeoplePhotoUploadProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.util.FaceDrawable.OnLoadingStateChangeListener;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.MonitorSizeChangeRelativeLayout;
import com.tencent.mobileqq.widget.MonitorSizeChangeRelativeLayout.ICallback;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.InputMethodUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.CustomImgView;
import com.tencent.widget.immersive.SystemBarCompact;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.model.PhotoInfo;
import java.util.ArrayList;
import tencent.im.oidb.cmd0x5ea.UpdatePhotoList.HeadInfo;

public class NearbyGuideActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback, TextWatcher, View.OnClickListener, Animation.AnimationListener, TextView.OnEditorActionListener, FaceDrawable.OnLoadingStateChangeListener, MonitorSizeChangeRelativeLayout.ICallback
{
  int jdField_a_of_type_Int;
  public Dialog a;
  Intent jdField_a_of_type_AndroidContentIntent;
  public Handler a;
  View jdField_a_of_type_AndroidViewView;
  Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  Button jdField_a_of_type_AndroidWidgetButton;
  public EditText a;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  public ScrollView a;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public NearbyCardHandler a;
  NearbyCardObserver jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardObserver = new aepz(this);
  TransProcessorHandler jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler = new aepw(this);
  MonitorSizeChangeRelativeLayout jdField_a_of_type_ComTencentMobileqqWidgetMonitorSizeChangeRelativeLayout;
  QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  CustomImgView jdField_a_of_type_ComTencentWidgetCustomImgView;
  public String a;
  public ArrayList a;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int = 0;
  View jdField_b_of_type_AndroidViewView;
  Animation jdField_b_of_type_AndroidViewAnimationAnimation;
  public Button b;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  NearbyCardObserver jdField_b_of_type_ComTencentMobileqqNearbyBusinessNearbyCardObserver = new aeqb(this);
  String jdField_b_of_type_JavaLangString;
  boolean jdField_b_of_type_Boolean = false;
  int jdField_c_of_type_Int = 0;
  View jdField_c_of_type_AndroidViewView;
  Animation jdField_c_of_type_AndroidViewAnimationAnimation;
  boolean jdField_c_of_type_Boolean = false;
  Animation jdField_d_of_type_AndroidViewAnimationAnimation;
  boolean jdField_d_of_type_Boolean = true;
  Animation jdField_e_of_type_AndroidViewAnimationAnimation;
  boolean jdField_e_of_type_Boolean = false;
  
  public NearbyGuideActivity()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidAppDialog = null;
  }
  
  TopGestureLayout a()
  {
    ViewGroup localViewGroup = (ViewGroup)getWindow().getDecorView();
    View localView = localViewGroup.getChildAt(0);
    Object localObject = localViewGroup;
    if (localView != null)
    {
      localObject = localViewGroup;
      if ((localView instanceof DragFrameLayout)) {
        localObject = (ViewGroup)localView;
      }
    }
    localObject = ((ViewGroup)localObject).getChildAt(0);
    if ((localObject instanceof TopGestureLayout)) {
      return (TopGestureLayout)localObject;
    }
    return null;
  }
  
  void a()
  {
    this.jdField_a_of_type_Int = getTitleBarHeight();
    this.jdField_a_of_type_AndroidContentIntent = getIntent();
    if (getIntent() == null)
    {
      NearbyProcessMonitor.b(2);
      NearbyFakeActivity.a(this, new Intent(this, NearbyActivity.class));
      finish();
    }
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    if (!((Boolean)NearbySPUtil.a(this.app.getAccount(), "nearby_people_disclaimer_ok_5.8.0", Boolean.valueOf(false))).booleanValue()) {
      a(0L);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.a(new Class[] { NearbyPeoplePhotoUploadProcessor.class });
      this.app.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
      return;
      b(0L);
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt1 == paramInt3) && (paramInt2 > 0) && (paramInt4 > 0) && (paramInt2 < paramInt4)) {
      this.jdField_a_of_type_AndroidWidgetScrollView.postDelayed(new aeqf(this), 300L);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    QQToast.a(BaseApplication.getContext(), paramInt, paramString, 0).b(this.jdField_a_of_type_Int);
  }
  
  void a(long paramLong)
  {
    this.jdField_c_of_type_Boolean = true;
    this.jdField_b_of_type_Int = 1;
    d();
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this).inflate(2130970418, null);
      if (Build.VERSION.SDK_INT >= 9) {
        this.jdField_a_of_type_AndroidViewView.setOverScrollMode(2);
      }
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131370466));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      e("0X8005901");
    }
    if (this.jdField_a_of_type_AndroidViewView.getParent() == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetMonitorSizeChangeRelativeLayout.addView(this.jdField_a_of_type_AndroidViewView, new RelativeLayout.LayoutParams(-1, -1));
    }
    if (paramLong > 0L)
    {
      if (this.jdField_a_of_type_AndroidViewAnimationAnimation == null)
      {
        this.jdField_a_of_type_AndroidViewAnimationAnimation = new AlphaAnimation(0.0F, 1.0F);
        this.jdField_a_of_type_AndroidViewAnimationAnimation.setDuration(400L);
        this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(this);
      }
      this.jdField_a_of_type_AndroidViewView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
    }
  }
  
  public void a(Drawable paramDrawable)
  {
    if (this.jdField_a_of_type_ComTencentWidgetCustomImgView != null)
    {
      Drawable localDrawable = this.jdField_a_of_type_ComTencentWidgetCustomImgView.a();
      this.jdField_a_of_type_ComTencentWidgetCustomImgView.setImageDrawable(paramDrawable);
      if ((localDrawable != paramDrawable) && ((localDrawable instanceof FaceDrawable))) {
        ((FaceDrawable)localDrawable).a();
      }
    }
  }
  
  void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isDevelopLevel()) {
        QLog.e("NearbyGuideActivity", 2, "uploadPhoto filePath is empty.");
      }
      return;
    }
    paramString = new CompressInfo(paramString, 0);
    paramString.f = 0;
    CompressOperator.a(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby_people_card.upload_local_photo", 2, "Q.nearby_people_card..uploadPhoto(), img_path = " + paramString.e);
    }
    if (!StringUtil.a(paramString.e))
    {
      TransferRequest localTransferRequest = new TransferRequest();
      localTransferRequest.jdField_a_of_type_Boolean = true;
      localTransferRequest.i = paramString.e;
      localTransferRequest.jdField_b_of_type_Int = 8;
      this.app.a().a(localTransferRequest);
      return;
    }
    l();
    a(1, "上传头像失败");
    a(true, null);
  }
  
  public void a(ArrayList paramArrayList)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("key_is_nearby_people_card", true);
    localBundle.putShort("key_new_profile_modified_flag", (short)1);
    localBundle.putString("key_new_nickname", this.jdField_b_of_type_JavaLangString);
    NearbyCardHandler localNearbyCardHandler = (NearbyCardHandler)this.app.a(60);
    if (localNearbyCardHandler != null) {
      ThreadManager.post(new aeqh(this, paramArrayList, localNearbyCardHandler, localBundle), 5, null, true);
    }
    while (!QLog.isDevelopLevel()) {
      return;
    }
    QLog.i("NearbyGuideActivity", 4, "NearbyCardHandler is null");
  }
  
  public void a(boolean paramBoolean)
  {
    NearbyProcessMonitor.b(2);
    Intent localIntent = new Intent(this, NearbyActivity.class);
    localIntent.putExtra("ENTER_TIME", System.currentTimeMillis());
    localIntent.putExtra("FROM_WHERE", getIntent().getIntExtra("FROM_WHERE", -1));
    localIntent.putExtra("SHOW_EDIT_TIP", paramBoolean);
    localIntent.putExtra("IS_HAS_REDTOUCH", this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("IS_HAS_REDTOUCH", false));
    localIntent.putExtra("RANK_BANNER_PUSH", this.jdField_a_of_type_AndroidContentIntent.getStringExtra("RANK_BANNER_PUSH"));
    startActivity(localIntent);
    overridePendingTransition(17432576, 17432577);
    finish();
  }
  
  public void a(boolean paramBoolean, int paramInt, ArrayList paramArrayList)
  {
    int i;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("handleImportQZonePhotoList ").append(paramBoolean).append(" ").append(paramInt).append(" ");
      if (paramArrayList == null)
      {
        i = -1;
        QLog.i("NearbyGuideActivity", 2, i);
      }
    }
    else
    {
      if ((!paramBoolean) || ((paramInt != 0) && (paramInt != 1))) {
        break label353;
      }
      if (paramInt != 0) {
        break label327;
      }
      if (paramArrayList != null) {
        break label211;
      }
      paramInt = 0;
      label88:
      localArrayList = new ArrayList();
      i = 0;
      label100:
      if (i >= paramInt) {
        break label227;
      }
      localObject = (UpdatePhotoList.HeadInfo)paramArrayList.get(i);
      if ((localObject != null) && (((UpdatePhotoList.HeadInfo)localObject).uint32_headid.has()) && (((UpdatePhotoList.HeadInfo)localObject).uint32_headid.get() >= 0))
      {
        localArrayList.add(Integer.valueOf(((UpdatePhotoList.HeadInfo)localObject).uint32_headid.get()));
        if (i == 0) {
          if (!((UpdatePhotoList.HeadInfo)localObject).str_headurl.has()) {
            break label219;
          }
        }
      }
    }
    label211:
    label219:
    for (Object localObject = ((UpdatePhotoList.HeadInfo)localObject).str_headurl.get();; localObject = "")
    {
      this.jdField_a_of_type_JavaLangString = ((String)localObject);
      i += 1;
      break label100;
      i = paramArrayList.size();
      break;
      paramInt = paramArrayList.size();
      break label88;
    }
    label227:
    l();
    if (localArrayList.size() <= 0) {
      c("导入失败");
    }
    label327:
    while (paramInt != 1)
    {
      ArrayList localArrayList;
      return;
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilArrayList.addAll(localArrayList);
      a(2, "导入成功");
      a(false, null);
      paramArrayList = this.app.getCurrentNickname();
      this.jdField_a_of_type_AndroidWidgetEditText.setText(paramArrayList);
      if (paramArrayList.length() > 0) {
        this.jdField_a_of_type_AndroidWidgetEditText.setSelection(paramArrayList.length());
      }
      this.jdField_a_of_type_Boolean = true;
      this.jdField_b_of_type_Boolean = true;
      c();
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 2000L);
    return;
    label353:
    l();
    c("导入失败");
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (!paramBoolean)
    {
      a(FaceDrawable.a(this.app, 200, this.app.getCurrentAccountUin(), 3, this));
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2, 3000L);
      return;
    }
    if (TextUtils.isEmpty(paramString))
    {
      a(getResources().getDrawable(2130842750));
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    }
    ThreadManager.postImmediately(new aeqi(this, paramString), null, true);
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    NearbyUtils.a(this.jdField_a_of_type_AndroidWidgetEditText, 36);
    c();
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetMonitorSizeChangeRelativeLayout = ((MonitorSizeChangeRelativeLayout)findViewById(2131362892));
    a();
    this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardObserver, true);
    this.app.addObserver(this.jdField_b_of_type_ComTencentMobileqqNearbyBusinessNearbyCardObserver, true);
  }
  
  @TargetApi(9)
  void b(long paramLong)
  {
    this.jdField_b_of_type_Int = 2;
    d();
    TopGestureLayout localTopGestureLayout = a();
    if (localTopGestureLayout != null) {
      localTopGestureLayout.setInterceptTouchFlag(false);
    }
    if (this.jdField_a_of_type_AndroidWidgetScrollView == null)
    {
      this.jdField_a_of_type_AndroidWidgetScrollView = ((ScrollView)LayoutInflater.from(this).inflate(2130970431, null));
      if (Build.VERSION.SDK_INT >= 9) {
        this.jdField_a_of_type_AndroidWidgetScrollView.setOverScrollMode(2);
      }
      this.jdField_a_of_type_AndroidWidgetScrollView.findViewById(2131361792).setOnClickListener(this);
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetScrollView.findViewById(2131370506);
      this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetScrollView.findViewById(2131370510);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetScrollView.findViewById(2131370505));
      this.jdField_a_of_type_ComTencentWidgetCustomImgView = ((CustomImgView)this.jdField_a_of_type_AndroidWidgetScrollView.findViewById(2131370508));
      this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidWidgetScrollView.findViewById(2131370511));
      this.jdField_b_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidWidgetScrollView.findViewById(2131370512));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetScrollView.findViewById(2131370513));
      this.jdField_a_of_type_ComTencentWidgetCustomImgView.setBackground(getResources().getDrawable(2130842448));
      this.jdField_a_of_type_ComTencentWidgetCustomImgView.setImageDrawable(getResources().getDrawable(2130842750));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetScrollView.findViewById(2131370509));
      this.jdField_a_of_type_AndroidWidgetEditText.setSelection(0);
      this.jdField_a_of_type_AndroidWidgetEditText.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetEditText.setOnEditorActionListener(this);
      this.jdField_b_of_type_AndroidWidgetButton.setText(2131438179);
      this.jdField_b_of_type_AndroidWidgetButton.setContentDescription(getString(2131438179));
      if (this.jdField_a_of_type_Boolean) {
        break label530;
      }
    }
    label530:
    for (boolean bool = true;; bool = false)
    {
      a(bool, this.jdField_a_of_type_JavaLangString);
      c();
      e("0X8005903");
      this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetMonitorSizeChangeRelativeLayout.setCallBack(this);
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentWidgetCustomImgView.setOnClickListener(this);
      int i = ((Integer)NearbySPUtil.a(this.app.getAccount(), "qq_avatar_type", Integer.valueOf(-1))).intValue();
      if (QLog.isColorLevel()) {
        QLog.i("NearbyGuideActivity", 2, "qqAvatarType is: " + i);
      }
      if (i != 1)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText("");
        this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(null);
      }
      if (this.jdField_a_of_type_AndroidWidgetScrollView.getParent() == null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetMonitorSizeChangeRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetScrollView, new RelativeLayout.LayoutParams(-1, -1));
      }
      if (paramLong <= 0L) {
        break;
      }
      if (this.jdField_a_of_type_AndroidViewAnimationAnimation == null)
      {
        this.jdField_a_of_type_AndroidViewAnimationAnimation = new AlphaAnimation(0.0F, 1.0F);
        this.jdField_a_of_type_AndroidViewAnimationAnimation.setDuration(400L);
        this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(this);
      }
      this.jdField_a_of_type_AndroidWidgetScrollView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(5, 100L);
  }
  
  public void b(String paramString)
  {
    QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.a();
    localUserInfo.jdField_a_of_type_JavaLangString = this.app.getCurrentAccountUin();
    localUserInfo.jdField_b_of_type_JavaLangString = this.app.getCurrentNickname();
    Bundle localBundle = new Bundle();
    ArrayList localArrayList = new ArrayList();
    PhotoInfo localPhotoInfo = new PhotoInfo();
    localPhotoInfo.d = paramString;
    localArrayList.add(localPhotoInfo);
    localBundle.putSerializable("picturelist", localArrayList);
    localBundle.putInt("curindex", 0);
    localBundle.putInt("mode", 0);
    localBundle.putBoolean("need_clear_cache", true);
    QZoneHelper.b(this, localUserInfo, localBundle, 6);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  void c()
  {
    String str1 = this.jdField_b_of_type_AndroidWidgetButton.getText().toString();
    String str2 = getString(2131438179);
    if ((str2 != null) && (str2.equals(str1)))
    {
      this.jdField_b_of_type_AndroidWidgetButton.setEnabled(true);
      return;
    }
    if (this.jdField_a_of_type_AndroidWidgetEditText.getText() == null) {}
    for (str1 = "";; str1 = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString())
    {
      this.jdField_b_of_type_JavaLangString = str1;
      this.jdField_b_of_type_JavaLangString = NearbyUtils.a(this.jdField_b_of_type_JavaLangString);
      if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
        break;
      }
      this.jdField_b_of_type_AndroidWidgetButton.setEnabled(false);
      return;
    }
    if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (!this.jdField_a_of_type_Boolean))
    {
      this.jdField_b_of_type_AndroidWidgetButton.setEnabled(false);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetButton.setEnabled(true);
  }
  
  public void c(String paramString)
  {
    QQToast.a(BaseApplication.getContext(), paramString, 0).b(this.jdField_a_of_type_Int);
  }
  
  void d()
  {
    int i = getResources().getColor(2131493284);
    if (this.mTitleContainer == null) {
      this.mTitleContainer = findViewById(2131363244);
    }
    this.mTitleContainer.setBackgroundColor(i);
    if (this.mSystemBarComp != null) {
      this.mSystemBarComp.setStatusColor(i);
    }
    if ((this.centerView instanceof TextView)) {
      this.centerView.setTextColor(-1);
    }
    if ((this.leftView instanceof TextView))
    {
      this.leftView.setTextColor(-1);
      this.leftView.setBackgroundResource(2130842877);
      this.leftView.setOnClickListener(this);
    }
    if (this.jdField_b_of_type_Int == 1)
    {
      this.rightViewImg.setVisibility(8);
      this.rightViewText.setVisibility(8);
      setTitle("附近");
      if ((this.leftView instanceof TextView))
      {
        String str1 = null;
        if (getIntent() != null) {
          str1 = getIntent().getExtras().getString("leftViewText");
        }
        String str2 = str1;
        if (TextUtils.isEmpty(str1)) {
          str2 = getString(2131432414);
        }
        this.leftView.setText(str2);
      }
      return;
    }
    setTitle("先介绍一下自己");
    if ((this.leftView instanceof TextView)) {
      this.leftView.setText(2131432414);
    }
    this.rightViewText.setVisibility(0);
    this.rightViewImg.setVisibility(8);
    this.rightViewText.setText("跳过");
    this.rightViewText.setTextColor(-1);
    this.rightViewText.setOnClickListener(this);
  }
  
  public void d(String paramString)
  {
    if (isFinishing()) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(paramString);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        return;
      } while ((paramInt2 != -1) || (paramIntent == null));
      str = paramIntent.getStringExtra("key_cover_selected_img_path");
    } while (StringUtil.a(str));
    paramIntent = new Intent(this, PhotoCropActivity.class);
    paramIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", getClass().getName());
    paramIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    paramIntent.putExtra("PhotoConst.EDIT_MASK_SHAPE_TYPE", 0);
    paramIntent.putExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", false);
    paramIntent.putExtra("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", true);
    paramIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", str);
    String str = AppConstants.aJ + this.app.getCurrentAccountUin() + "/" + "nearby_people_photo/";
    paramIntent.putExtra("PhotoConst.TARGET_PATH", str + System.currentTimeMillis() + ".jpg");
    paramIntent.putExtra("PhotoConst.CLIP_WIDTH", 640);
    paramIntent.putExtra("PhotoConst.CLIP_HEIGHT", 640);
    paramIntent.putExtra("PhotoConst.TARGET_WIDTH", 640);
    paramIntent.putExtra("PhotoConst.TARGET_HEIGHT", 640);
    paramIntent.putExtra("PhotoConst.QZONE_COVER_CROP_LEFT_TITLE", "返回");
    startActivity(paramIntent);
  }
  
  public void doOnBackPressed()
  {
    if (this.jdField_a_of_type_Boolean) {
      k();
    }
    super.doOnBackPressed();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    boolean bool = super.doOnCreate(paramBundle);
    setContentView(2130970430);
    b();
    getWindow().setBackgroundDrawable(null);
    return bool;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardObserver);
    removeObserver(this.jdField_b_of_type_ComTencentMobileqqNearbyBusinessNearbyCardObserver);
    g();
    if ((this.jdField_a_of_type_AndroidOsHandler != null) && (this.jdField_a_of_type_AndroidOsHandler.hasMessages(1))) {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    }
    a(null);
    NearbyProcessMonitor.c(2);
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    if (paramIntent == null) {
      return;
    }
    this.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
    if (QLog.isColorLevel()) {
      QLog.e("NearbyGuideActivity", 2, "doOnNewIntent path is: " + this.jdField_a_of_type_JavaLangString);
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      a(true, this.jdField_a_of_type_JavaLangString);
      if (this.jdField_a_of_type_Boolean)
      {
        k();
        this.jdField_a_of_type_Boolean = false;
      }
      if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
        break label119;
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(-1));
    }
    for (;;)
    {
      c();
      return;
      label119:
      this.jdField_a_of_type_JavaUtilArrayList.set(0, Integer.valueOf(-1));
    }
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (this.jdField_d_of_type_Boolean))
    {
      this.jdField_d_of_type_Boolean = false;
      NearbyProcessMonitor.a(this.app.getAccount(), 2);
    }
  }
  
  void e()
  {
    InputMethodUtil.b(this.jdField_a_of_type_AndroidWidgetEditText);
    if (this.jdField_a_of_type_Boolean)
    {
      a(2, "导入成功");
      this.jdField_a_of_type_AndroidWidgetEditText.setText(this.app.getCurrentNickname());
      c();
      return;
    }
    if (!NetworkUtil.d(this.app.getApp()))
    {
      c("网络异常，请先检查网络设置");
      return;
    }
    m();
  }
  
  public void e(String paramString)
  {
    ThreadManager.post(new aepy(this, paramString), 5, null, true);
  }
  
  public void f()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    localActionSheet.c("手机相册");
    localActionSheet.c("空间相册");
    localActionSheet.c(2131433015);
    localActionSheet.a(new aeqg(this, localActionSheet));
    localActionSheet.show();
  }
  
  void g()
  {
    this.app.a().b(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
  }
  
  public void h()
  {
    Intent localIntent = new Intent(this, PhotoListActivity.class);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", getClass().getName());
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", getPackageName());
    localIntent.putExtra("PhotoConst.EDIT_MASK_SHAPE_TYPE", 0);
    localIntent.putExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", false);
    localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", true);
    localIntent.putExtra("PhotoConst.IS_SINGLE_NEED_EDIT", true);
    localIntent.putExtra("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", true);
    localIntent.putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
    String str = AppConstants.aJ + this.app.getCurrentAccountUin() + "/" + "nearby_people_photo/";
    localIntent.putExtra("PhotoConst.TARGET_PATH", str + System.currentTimeMillis() + ".jpg");
    localIntent.putExtra("PhotoConst.CLIP_WIDTH", 640);
    localIntent.putExtra("PhotoConst.CLIP_HEIGHT", 640);
    localIntent.putExtra("PhotoConst.TARGET_WIDTH", 640);
    localIntent.putExtra("PhotoConst.TARGET_HEIGHT", 640);
    startActivity(localIntent);
    AlbumUtil.a(this, false, true);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    label535:
    for (;;)
    {
      return false;
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardHandler == null) {
        this.jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardHandler = ((NearbyCardHandler)this.app.a(60));
      }
      this.jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardHandler.b();
      return false;
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
      if ((paramMessage.obj instanceof Bitmap)) {
        a(new BitmapDrawable(getResources(), (Bitmap)paramMessage.obj));
      }
      j();
      return false;
      this.jdField_e_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(4);
      this.jdField_b_of_type_AndroidViewView.clearAnimation();
      this.jdField_c_of_type_AndroidViewView.clearAnimation();
      this.jdField_a_of_type_AndroidWidgetEditText.clearAnimation();
      int i = (int)(this.mDensity * 15.0F + 0.5F);
      int j = (int)(this.mDensity * 15.0F + 0.5F);
      this.jdField_b_of_type_AndroidViewView.setPadding(0, i, 0, j);
      i = (int)(this.mDensity * 5.0F + 0.5F);
      j = (int)(this.mDensity * 5.0F + 0.5F);
      this.jdField_c_of_type_AndroidViewView.setPadding(0, i, 0, j);
      this.jdField_b_of_type_AndroidWidgetButton.setText(2131436752);
      this.jdField_b_of_type_AndroidWidgetButton.setContentDescription(getString(2131436752));
      c();
      if (QLog.isDevelopLevel())
      {
        NearbyUtils.a("NearbyGuideActivity", "MSG_ANIM_END", new Object[] { Integer.valueOf(this.jdField_c_of_type_Int), Integer.valueOf(paramMessage.arg1) });
        return false;
        if (QLog.isDevelopLevel()) {
          NearbyUtils.a("NearbyGuideActivity", "MSG_TIP_ANIM", new Object[] { this.jdField_b_of_type_AndroidWidgetTextView });
        }
        if (this.jdField_b_of_type_AndroidWidgetTextView != null)
        {
          paramMessage = new TranslateAnimation(0.0F, 0.0F, 0.0F, -25.0F);
          paramMessage.setInterpolator(new CycleInterpolator(2.0F));
          paramMessage.setFillAfter(false);
          paramMessage.setDuration(1300L);
          this.jdField_b_of_type_AndroidWidgetTextView.startAnimation(paramMessage);
          return false;
          if (QLog.isDevelopLevel()) {
            NearbyUtils.a("NearbyGuideActivity", "MSG_FADEOUT_END", new Object[] { Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqWidgetMonitorSizeChangeRelativeLayout.getChildCount()) });
          }
          paramMessage = null;
          if (this.jdField_b_of_type_Int == 1)
          {
            paramMessage = this.jdField_a_of_type_AndroidWidgetScrollView;
            i = 0;
          }
          for (;;)
          {
            if ((paramMessage == null) || (i >= this.jdField_a_of_type_ComTencentMobileqqWidgetMonitorSizeChangeRelativeLayout.getChildCount())) {
              break label535;
            }
            if (this.jdField_a_of_type_ComTencentMobileqqWidgetMonitorSizeChangeRelativeLayout.getChildAt(i) == paramMessage)
            {
              if (QLog.isDevelopLevel()) {
                NearbyUtils.a("NearbyGuideActivity", "MSG_FADEOUT_END", new Object[] { "find child index", Integer.valueOf(i) });
              }
              this.jdField_a_of_type_ComTencentMobileqqWidgetMonitorSizeChangeRelativeLayout.removeViewAt(i);
              return false;
              if (this.jdField_b_of_type_Int != 2) {
                break;
              }
              paramMessage = this.jdField_a_of_type_AndroidViewView;
              break;
            }
            i += 1;
          }
        }
      }
    }
  }
  
  public void i()
  {
    QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.a();
    localUserInfo.jdField_a_of_type_JavaLangString = this.app.getCurrentAccountUin();
    localUserInfo.jdField_b_of_type_JavaLangString = this.app.getCurrentNickname();
    Bundle localBundle = new Bundle();
    localBundle.putString("key_title", getString(2131432705));
    localBundle.putInt("key_personal_album_enter_model", 2);
    localBundle.putBoolean("show_album", false);
    localBundle.putBoolean("key_need_change_to_jpg", true);
    QZoneHelper.a(this, localUserInfo, localBundle, 10);
  }
  
  void j()
  {
    if ((this.jdField_a_of_type_AndroidWidgetEditText != null) && (this.jdField_a_of_type_AndroidWidgetEditText.getVisibility() != 0))
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setVisibility(0);
      this.jdField_c_of_type_Int = 0;
      this.jdField_e_of_type_Boolean = true;
      if (this.jdField_d_of_type_AndroidViewAnimationAnimation == null)
      {
        this.jdField_d_of_type_AndroidViewAnimationAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, -(int)(this.mDensity * 5.0F + 0.5F));
        this.jdField_d_of_type_AndroidViewAnimationAnimation.setDuration(1300);
        this.jdField_d_of_type_AndroidViewAnimationAnimation.setFillAfter(true);
        this.jdField_d_of_type_AndroidViewAnimationAnimation.setAnimationListener(this);
      }
      this.jdField_c_of_type_AndroidViewView.startAnimation(this.jdField_d_of_type_AndroidViewAnimationAnimation);
      if (this.jdField_e_of_type_AndroidViewAnimationAnimation == null)
      {
        this.jdField_e_of_type_AndroidViewAnimationAnimation = new AlphaAnimation(0.5F, 1.0F);
        this.jdField_e_of_type_AndroidViewAnimationAnimation.setDuration(1300);
        this.jdField_e_of_type_AndroidViewAnimationAnimation.setAnimationListener(this);
        this.jdField_e_of_type_AndroidViewAnimationAnimation.setFillAfter(true);
      }
      this.jdField_a_of_type_AndroidWidgetEditText.startAnimation(this.jdField_e_of_type_AndroidViewAnimationAnimation);
      if (this.jdField_c_of_type_AndroidViewAnimationAnimation == null)
      {
        this.jdField_c_of_type_AndroidViewAnimationAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, -(int)(this.mDensity * 25.0F + 0.5F));
        this.jdField_c_of_type_AndroidViewAnimationAnimation.setDuration(1300);
        this.jdField_c_of_type_AndroidViewAnimationAnimation.setAnimationListener(this);
        this.jdField_c_of_type_AndroidViewAnimationAnimation.setFillAfter(true);
      }
      this.jdField_b_of_type_AndroidViewView.startAnimation(this.jdField_c_of_type_AndroidViewAnimationAnimation);
      Message localMessage = Message.obtain();
      localMessage.arg1 = 1;
      localMessage.what = 4;
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, 1310);
    }
  }
  
  void k()
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardHandler.a(new ArrayList());
  }
  
  public void l()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) && (!isFinishing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  void m()
  {
    this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this, 2131437733, getString(2131437734), 2131437736, 2131437735, new aeqj(this), new aepx(this), false, true);
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (!isFinishing())) {
      this.jdField_a_of_type_AndroidAppDialog.show();
    }
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (paramAnimation == this.jdField_a_of_type_AndroidViewAnimationAnimation) {
      if (this.jdField_b_of_type_Int == 2) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(5, 100L);
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (paramAnimation == this.jdField_b_of_type_AndroidViewAnimationAnimation)
            {
              this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(6);
              return;
            }
            if (paramAnimation != this.jdField_d_of_type_AndroidViewAnimationAnimation) {
              break;
            }
            this.jdField_c_of_type_Int |= 0x1;
          } while ((this.jdField_c_of_type_Int & 0x7) != 7);
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
          return;
          if (paramAnimation != this.jdField_c_of_type_AndroidViewAnimationAnimation) {
            break;
          }
          this.jdField_c_of_type_Int |= 0x2;
        } while ((this.jdField_c_of_type_Int & 0x7) != 7);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
        return;
      } while (paramAnimation != this.jdField_e_of_type_AndroidViewAnimationAnimation);
      this.jdField_c_of_type_Int |= 0x4;
    } while ((this.jdField_c_of_type_Int & 0x7) != 7);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
  
  public void onClick(View paramView)
  {
    int i = 2;
    if (paramView == this.leftView) {
      if (this.jdField_b_of_type_Int == 2) {
        if (this.jdField_c_of_type_Boolean)
        {
          if (this.jdField_a_of_type_AndroidWidgetEditText != null) {
            ((InputMethodManager)this.jdField_a_of_type_AndroidWidgetEditText.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_a_of_type_AndroidWidgetEditText.getWindowToken(), 0);
          }
          if (this.jdField_b_of_type_AndroidViewAnimationAnimation == null)
          {
            this.jdField_b_of_type_AndroidViewAnimationAnimation = new AlphaAnimation(1.0F, 0.0F);
            this.jdField_b_of_type_AndroidViewAnimationAnimation.setDuration(400L);
            this.jdField_b_of_type_AndroidViewAnimationAnimation.setAnimationListener(this);
          }
          this.jdField_a_of_type_AndroidWidgetScrollView.startAnimation(this.jdField_b_of_type_AndroidViewAnimationAnimation);
          a(400L);
        }
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if (this.jdField_a_of_type_Boolean) {
            k();
          }
          finish();
          return;
        } while (this.jdField_b_of_type_Int != 1);
        if (this.jdField_a_of_type_Boolean) {
          k();
        }
        finish();
        return;
        if (paramView != this.rightViewText) {
          break;
        }
      } while (this.jdField_b_of_type_Int != 2);
      if (this.jdField_a_of_type_Boolean) {
        k();
      }
      a(false);
      NearbySPUtil.a(this.app.getAccount(), "sp_key_user_skip_guide", Boolean.valueOf(true));
      e("0X8005D91");
      return;
      if (paramView == this.jdField_a_of_type_AndroidWidgetTextView)
      {
        e();
        e("0X8005908");
        return;
      }
      if (paramView != this.jdField_b_of_type_AndroidWidgetButton) {
        break;
      }
    } while (this.jdField_e_of_type_Boolean);
    paramView = this.jdField_b_of_type_AndroidWidgetButton.getText().toString();
    String str = getString(2131438179);
    if ((str != null) && (str.equals(paramView)))
    {
      f();
      return;
    }
    if (!NetworkUtil.d(this.app.getApp()))
    {
      c("网络异常，请先检查网络设置");
      return;
    }
    d("正在保存");
    if (((Integer)this.jdField_a_of_type_JavaUtilArrayList.get(0)).intValue() == -1)
    {
      a(this.jdField_a_of_type_JavaLangString);
      label342:
      if (!this.jdField_b_of_type_Boolean) {
        break label629;
      }
      if ((this.jdField_b_of_type_JavaLangString.equals(this.app.getCurrentNickname())) && (this.jdField_a_of_type_Boolean)) {}
    }
    label629:
    for (i = 3;; i = 1)
    {
      ReportController.b(this.app, "CliOper", "", "", "0X8005D92", "0X8005D92", i, 0, "", "", "", "");
      return;
      a(this.jdField_a_of_type_JavaUtilArrayList);
      break label342;
      if (paramView == this.jdField_a_of_type_ComTencentWidgetCustomImgView)
      {
        if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
        {
          f();
          return;
        }
        paramView = (ActionSheet)ActionSheetHelper.a(this, null);
        paramView.c("查看大图");
        paramView.c("更换头像");
        paramView.c(2131433015);
        paramView.a(new aeqe(this, paramView));
        paramView.show();
        return;
      }
      if (paramView == this.jdField_a_of_type_AndroidWidgetButton)
      {
        NearbySPUtil.a(this.app.getAccount(), "nearby_people_disclaimer_ok_5.8.0", Boolean.valueOf(true));
        if (this.jdField_b_of_type_AndroidViewAnimationAnimation == null)
        {
          this.jdField_b_of_type_AndroidViewAnimationAnimation = new AlphaAnimation(1.0F, 0.0F);
          this.jdField_b_of_type_AndroidViewAnimationAnimation.setDuration(400L);
          this.jdField_b_of_type_AndroidViewAnimationAnimation.setAnimationListener(this);
        }
        this.jdField_a_of_type_AndroidViewView.startAnimation(this.jdField_b_of_type_AndroidViewAnimationAnimation);
        b(400L);
        e("0X8005902");
        return;
      }
      if ((paramView.getId() != 2131361792) || (this.jdField_a_of_type_AndroidWidgetEditText == null)) {
        break;
      }
      ((InputMethodManager)this.jdField_a_of_type_AndroidWidgetEditText.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_a_of_type_AndroidWidgetEditText.getWindowToken(), 0);
      return;
    }
  }
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (QLog.isDevelopLevel()) {
      NearbyUtils.a("NearbyGuideActivity", "onEditorAction", new Object[] { Integer.valueOf(paramInt) });
    }
    if (paramInt == 6)
    {
      if (TextUtils.isEmpty(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString())) {
        c("请输入昵称");
      }
    }
    else {
      return true;
    }
    onClick(this.jdField_b_of_type_AndroidWidgetButton);
    return true;
  }
  
  public void onLoadingStateChanged(int paramInt1, int paramInt2)
  {
    if ((paramInt2 == 1) || (paramInt2 == 2)) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramCharSequence.length() == 0) {
      this.jdField_a_of_type_AndroidWidgetEditText.setSelection(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.guide.NearbyGuideActivity
 * JD-Core Version:    0.7.0.1
 */