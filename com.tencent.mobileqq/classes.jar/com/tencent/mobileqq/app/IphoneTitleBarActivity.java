package com.tencent.mobileqq.app;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import zfv;

public class IphoneTitleBarActivity
  extends FragmentActivity
{
  public static final String HIDE_TITLE_LEFT_ARROW = "hide_title_left_arrow";
  public static final int LAYER_TYPE_SOFTWARE = 1;
  protected static final String TAG = "IphoneTitleBarActivity";
  private Drawable ad;
  @Deprecated
  public TextView centerView;
  private boolean isRightHighlightButton;
  @Deprecated
  public TextView leftView;
  @Deprecated
  public TextView leftViewNotBack;
  public View mContentView;
  protected int mContentViewID = -1;
  public float mDensity;
  @Deprecated
  public ImageView mLeftBackIcon;
  @Deprecated
  public TextView mLeftBackText;
  private RelativeLayout mLoadingParent;
  private ImageView mLoadingView;
  public boolean mNeedTitleBarTrans;
  private Drawable[] mOldDrawables;
  private int mOldPadding;
  @Deprecated
  public View mTitleContainer;
  public boolean mUseOptimizMode;
  protected View.OnClickListener onBackListeger = new zfv(this);
  @Deprecated
  public TextView rightHighLView;
  @Deprecated
  public ImageView rightViewImg;
  @Deprecated
  public TextView rightViewText;
  @Deprecated
  public RelativeLayout titleRoot;
  public ViewGroup vg;
  
  public static void setLayerType(View paramView)
  {
    if (paramView == null) {}
    while (Build.VERSION.SDK_INT <= 10) {
      return;
    }
    paramView.setLayerType(0, null);
  }
  
  public void enableLeftBtn(boolean paramBoolean)
  {
    if (this.leftViewNotBack != null) {
      this.leftViewNotBack.setEnabled(paramBoolean);
    }
  }
  
  public void enableRightHighlight(boolean paramBoolean)
  {
    if ((this.rightHighLView == null) || (!this.isRightHighlightButton)) {
      return;
    }
    if (paramBoolean)
    {
      this.rightViewText.setVisibility(8);
      this.rightHighLView.setVisibility(0);
      return;
    }
    this.rightViewText.setVisibility(0);
    this.rightHighLView.setVisibility(8);
  }
  
  public View getRightTextView()
  {
    this.rightViewText = ((TextView)findViewById(2131363428));
    setLayerType(this.rightViewText);
    return this.rightViewText;
  }
  
  public String getTextTitle()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.centerView != null)
    {
      localObject1 = localObject2;
      if ((this.centerView instanceof TextView))
      {
        CharSequence localCharSequence = this.centerView.getText();
        localObject1 = localObject2;
        if (localCharSequence != null) {
          localObject1 = localCharSequence.toString();
        }
      }
    }
    return localObject1;
  }
  
  public View getTitleBarView()
  {
    return findViewById(2131363244);
  }
  
  public void hideTitleBar()
  {
    try
    {
      this.mTitleContainer = findViewById(2131363244);
      this.mTitleContainer.setVisibility(8);
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public void init(Intent paramIntent)
  {
    ((FrameLayout)findViewById(16908290)).setForeground(getResources().getDrawable(2130845874));
    if (this.leftView == null)
    {
      this.vg = ((ViewGroup)findViewById(2131363244));
      onCreateLeftView();
    }
    try
    {
      if ((paramIntent.getBooleanExtra("hide_title_left_arrow", false)) && (this.leftView != null)) {
        this.leftView.setBackgroundDrawable(null);
      }
      onCreateCenterView();
      onCreateRightView();
      setLeftViewName(paramIntent);
      return;
    }
    catch (Exception paramIntent)
    {
      QLog.d("IphoneTitleBarActivity", 1, "", paramIntent);
    }
  }
  
  public boolean isTitleProgressShowing()
  {
    if ((this.mUseOptimizMode) && (this.mLoadingParent != null))
    {
      if ((this.mLoadingView == null) || (this.mLoadingView.getVisibility() == 8)) {}
    }
    else {
      while (this.ad != null) {
        return true;
      }
    }
    return false;
  }
  
  public boolean onBackEvent()
  {
    finish();
    return false;
  }
  
  public View onCreateCenterView()
  {
    this.centerView = ((TextView)findViewById(2131363381));
    return this.centerView;
  }
  
  protected View onCreateLeftView()
  {
    this.leftView = ((TextView)findViewById(2131363245));
    this.leftView.setOnClickListener(this.onBackListeger);
    this.mLeftBackText = ((TextView)findViewById(2131363995));
    this.mLeftBackIcon = ((ImageView)findViewById(2131363994));
    if ((this.mLeftBackText != null) && (this.mLeftBackIcon != null))
    {
      this.mLeftBackText.setOnClickListener(this.onBackListeger);
      this.mLeftBackIcon.setOnClickListener(this.onBackListeger);
    }
    return this.leftView;
  }
  
  public View onCreateRightView()
  {
    this.rightViewText = ((TextView)findViewById(2131363428));
    this.rightViewImg = ((ImageView)findViewById(2131363474));
    return this.rightViewText;
  }
  
  @TargetApi(11)
  public void removeWebViewLayerType()
  {
    if (Build.VERSION.SDK_INT == 16) {
      this.vg.setLayerType(0, null);
    }
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(7);
  }
  
  public void setClickableTitle(CharSequence paramCharSequence, View.OnClickListener paramOnClickListener)
  {
    setTitle(paramCharSequence);
    if ((this.centerView != null) && ((this.centerView instanceof TextView)))
    {
      paramCharSequence = this.centerView;
      if (paramOnClickListener == null) {
        break label47;
      }
    }
    label47:
    for (boolean bool = true;; bool = false)
    {
      paramCharSequence.setClickable(bool);
      this.centerView.setOnClickListener(paramOnClickListener);
      return;
    }
  }
  
  @TargetApi(14)
  public void setContentView(int paramInt)
  {
    if (!this.mNeedStatusTrans)
    {
      super.setContentView(paramInt);
      this.mContentViewID = paramInt;
      getWindow().setFeatureInt(7, 2130968832);
    }
    do
    {
      if (this.mTitleContainer != null) {
        this.mTitleContainer.setVisibility(0);
      }
      this.mDensity = getResources().getDisplayMetrics().density;
      init(getIntent());
      return;
      Object localObject2 = LayoutInflater.from(this);
      Object localObject1 = ((LayoutInflater)localObject2).inflate(2130968837, null);
      try
      {
        localObject2 = ((LayoutInflater)localObject2).inflate(paramInt, (ViewGroup)localObject1, false);
        this.titleRoot = ((RelativeLayout)((View)localObject1).findViewById(2131364019));
        if (ImmersiveUtils.isSupporImmersive() == 1)
        {
          this.titleRoot.setFitsSystemWindows(true);
          this.titleRoot.setPadding(0, ImmersiveUtils.a(this), 0, 0);
        }
        localObject1 = new RelativeLayout.LayoutParams(-1, -1);
        ((RelativeLayout.LayoutParams)localObject1).addRule(3, 2131363244);
        this.titleRoot.addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
        this.mContentView = ((View)localObject2);
        super.setContentView(this.titleRoot);
        i = 0;
      }
      catch (InflateException localInflateException)
      {
        for (;;)
        {
          localInflateException.printStackTrace();
          i = 1;
        }
      }
      catch (RuntimeException localRuntimeException)
      {
        for (;;)
        {
          localRuntimeException.printStackTrace();
          int i = 1;
        }
      }
    } while (i == 0);
    if (QLog.isColorLevel()) {
      QLog.e("IphoneTitleBarActivity", 2, "layout with merge ,use framelayout to immersive" + getComponentName());
    }
    super.setContentView(paramInt);
    this.mContentViewID = paramInt;
    getWindow().setFeatureInt(7, 2130968832);
    if (this.mTitleContainer != null) {
      this.mTitleContainer.setVisibility(0);
    }
    this.mDensity = getResources().getDisplayMetrics().density;
    init(getIntent());
  }
  
  @TargetApi(14)
  public void setContentView(View paramView)
  {
    this.mContentView = paramView;
    this.mDensity = getResources().getDisplayMetrics().density;
    if (!this.mNeedStatusTrans)
    {
      super.setContentView(paramView);
      getWindow().setFeatureInt(7, 2130968832);
    }
    for (;;)
    {
      if (this.mTitleContainer != null) {
        this.mTitleContainer.setVisibility(0);
      }
      init(getIntent());
      return;
      this.titleRoot = ((RelativeLayout)LayoutInflater.from(this).inflate(2130968837, null).findViewById(2131364019));
      if (ImmersiveUtils.isSupporImmersive() == 1)
      {
        this.titleRoot.setFitsSystemWindows(true);
        this.titleRoot.setPadding(0, ImmersiveUtils.a(this), 0, 0);
      }
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      localLayoutParams.addRule(3, 2131363244);
      this.titleRoot.addView(paramView, localLayoutParams);
      super.setContentView(this.titleRoot);
    }
  }
  
  public View setContentViewB(int paramInt)
  {
    BounceScrollView localBounceScrollView = (BounceScrollView)View.inflate(this, 2130968726, null);
    View localView = View.inflate(this, paramInt, null);
    localBounceScrollView.addView(localView);
    setContentView(localBounceScrollView);
    return localView;
  }
  
  public void setContentViewC(int paramInt)
  {
    this.mContentViewID = paramInt;
    super.setContentView(paramInt);
  }
  
  @TargetApi(14)
  public void setContentViewNoTitle(int paramInt)
  {
    this.mContentViewID = paramInt;
    this.mDensity = getResources().getDisplayMetrics().density;
    View localView = LayoutInflater.from(this).inflate(paramInt, null, false);
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      localView.setFitsSystemWindows(true);
      localView.setPadding(0, ImmersiveUtils.a(this), 0, 0);
    }
    super.setContentView(localView);
    getWindow().setFeatureInt(7, 2130968865);
    try
    {
      this.mTitleContainer = ((View)findViewById(2131364092).getParent());
      this.mTitleContainer.setVisibility(8);
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public void setContentViewNoTitle(View paramView)
  {
    if (paramView == null) {
      return;
    }
    this.mDensity = getResources().getDisplayMetrics().density;
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1)) {
      ImmersiveUtils.a(paramView, true);
    }
    super.setContentView(paramView);
    getWindow().setFeatureInt(7, 2130968865);
    try
    {
      this.mTitleContainer = ((View)findViewById(2131364092).getParent());
      this.mTitleContainer.setVisibility(8);
      return;
    }
    catch (Throwable paramView) {}
  }
  
  public String setLastActivityName()
  {
    if ((this.centerView == null) || (this.centerView.getText() == null) || (this.centerView.getText().length() == 0)) {
      return getString(2131433698);
    }
    return this.centerView.getText().toString();
  }
  
  public void setLeftButton(int paramInt, View.OnClickListener paramOnClickListener)
  {
    this.leftView.setVisibility(8);
    this.leftViewNotBack = ((TextView)findViewById(2131363473));
    setLayerType(this.leftViewNotBack);
    this.leftViewNotBack.setVisibility(0);
    this.leftViewNotBack.setText(paramInt);
    if (paramOnClickListener == null)
    {
      this.leftViewNotBack.setOnClickListener(this.onBackListeger);
      return;
    }
    this.leftViewNotBack.setOnClickListener(paramOnClickListener);
  }
  
  public void setLeftButton(String paramString, View.OnClickListener paramOnClickListener)
  {
    this.leftView.setVisibility(8);
    this.leftViewNotBack = ((TextView)findViewById(2131363473));
    setLayerType(this.leftViewNotBack);
    this.leftViewNotBack.setVisibility(0);
    this.leftViewNotBack.setText(paramString);
    if (paramOnClickListener == null)
    {
      this.leftViewNotBack.setOnClickListener(this.onBackListeger);
      return;
    }
    this.leftViewNotBack.setOnClickListener(paramOnClickListener);
  }
  
  public void setLeftViewName(int paramInt)
  {
    if ((this.leftView != null) && ((this.leftView instanceof TextView)))
    {
      if (this.leftViewNotBack != null) {
        this.leftViewNotBack.setVisibility(8);
      }
      String str2 = getString(paramInt);
      TextView localTextView = this.leftView;
      String str1;
      if (str2 != null)
      {
        str1 = str2;
        if (!"".equals(str2)) {}
      }
      else
      {
        str1 = getString(2131433698);
      }
      localTextView.setText(str1);
      localTextView.setVisibility(0);
      if (AppSetting.b)
      {
        str2 = this.leftView.getText().toString();
        str1 = str2;
        if (!str2.contains(getString(2131433698))) {
          str1 = getString(2131433698) + str2;
        }
        this.leftView.setContentDescription(str1);
      }
    }
  }
  
  public void setLeftViewName(Intent paramIntent)
  {
    if ((this.leftView != null) && ((this.leftView instanceof TextView)) && (paramIntent != null) && (paramIntent.getExtras() != null)) {
      if (this.leftViewNotBack != null) {
        this.leftViewNotBack.setVisibility(8);
      }
    }
    try
    {
      TextView localTextView = this.leftView;
      Object localObject = paramIntent.getExtras().getString("leftViewText");
      int i = paramIntent.getExtras().getInt("individuation_url_type");
      paramIntent = (Intent)localObject;
      if (i >= 40300)
      {
        paramIntent = (Intent)localObject;
        if (i <= 40313)
        {
          paramIntent = (Intent)localObject;
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            paramIntent = (Intent)localObject;
            if (((String)localObject).contains("消息")) {
              paramIntent = getString(2131433698);
            }
          }
        }
      }
      localObject = paramIntent;
      if (paramIntent == null) {
        localObject = getString(2131433698);
      }
      localTextView.setText((CharSequence)localObject);
      localTextView.setVisibility(0);
      if (AppSetting.b)
      {
        localObject = this.leftView.getText().toString();
        paramIntent = (Intent)localObject;
        if (!((String)localObject).contains(getString(2131433698))) {
          paramIntent = getString(2131433698) + (String)localObject;
        }
        this.leftView.setContentDescription(paramIntent);
      }
      return;
    }
    catch (Exception paramIntent) {}
  }
  
  public void setRightButton(int paramInt, View.OnClickListener paramOnClickListener)
  {
    this.isRightHighlightButton = false;
    this.rightViewText.setVisibility(0);
    this.rightViewText.setText(paramInt);
    this.rightViewText.setEnabled(true);
    if (paramOnClickListener != null) {
      this.rightViewText.setOnClickListener(paramOnClickListener);
    }
    if (AppSetting.b) {
      this.rightViewText.setContentDescription(this.rightViewText.getText() + "按钮");
    }
  }
  
  public void setRightHighlightButton(int paramInt, View.OnClickListener paramOnClickListener)
  {
    this.isRightHighlightButton = true;
    if (this.rightViewText != null)
    {
      this.rightViewText.setVisibility(0);
      this.rightViewText.setText(paramInt);
      this.rightViewText.setEnabled(false);
      this.rightHighLView = ((TextView)getLayoutInflater().inflate(2130968840, null));
      setLayerType(this.rightHighLView);
      this.rightHighLView.setText(paramInt);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(11, 1);
      localLayoutParams.addRule(15, 1);
      localLayoutParams.rightMargin = ((int)(8.0F * this.mDensity));
      this.vg.addView(this.rightHighLView, localLayoutParams);
      this.rightHighLView.setVisibility(8);
      if (paramOnClickListener != null) {
        this.rightHighLView.setOnClickListener(paramOnClickListener);
      }
    }
  }
  
  @TargetApi(11)
  public void setRightViewTextDisable(int paramInt)
  {
    if (paramInt == 0)
    {
      this.rightViewText.setEnabled(false);
      if (Build.VERSION.SDK_INT >= 11) {
        this.rightViewText.setAlpha(0.5F);
      }
    }
    do
    {
      return;
      this.rightViewText.setEnabled(true);
    } while (Build.VERSION.SDK_INT < 11);
    this.rightViewText.setAlpha(1.0F);
  }
  
  public void setTitle(int paramInt)
  {
    setTitle(getString(paramInt));
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    if ((this.centerView != null) && ((this.centerView instanceof TextView)))
    {
      this.centerView.setText(paramCharSequence);
      super.setTitle(paramCharSequence);
    }
  }
  
  public void setTitle(CharSequence paramCharSequence, String paramString)
  {
    if ((this.centerView != null) && ((this.centerView instanceof TextView)))
    {
      TextView localTextView = this.centerView;
      localTextView.setText(paramCharSequence);
      if (AppSetting.b) {
        localTextView.setContentDescription(paramString);
      }
      super.setTitle(paramString);
    }
  }
  
  public void showContentViewTitle(boolean paramBoolean)
  {
    try
    {
      View localView = (View)findViewById(2131363244).getParent();
      if (paramBoolean) {}
      for (int i = 0;; i = 8)
      {
        localView.setVisibility(i);
        return;
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public boolean startTitleProgress()
  {
    if (this.centerView == null) {
      return false;
    }
    Object localObject1;
    if (this.mUseOptimizMode)
    {
      localObject1 = (RelativeLayout)findViewById(2131363380);
      if (this.centerView.getVisibility() == 0)
      {
        localObject1 = this.centerView;
        localObject2 = this.centerView.getParent();
        if ((this.mLoadingParent != null) && (this.mLoadingParent != localObject2))
        {
          if ((this.mLoadingView != null) && (this.mLoadingView.getParent() == this.mLoadingParent))
          {
            this.mLoadingParent.removeView(this.mLoadingView);
            this.mLoadingView = null;
          }
          this.mLoadingParent = null;
        }
        if ((this.mLoadingParent == null) && ((localObject2 instanceof RelativeLayout))) {
          this.mLoadingParent = ((RelativeLayout)localObject2);
        }
        localObject2 = localObject1;
        if (localObject1 != null)
        {
          localObject2 = localObject1;
          if (this.mLoadingView != null)
          {
            int i = ((View)localObject1).getId();
            RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.mLoadingView.getLayoutParams();
            localObject2 = localObject1;
            if (localLayoutParams.getRules()[0] != i)
            {
              localObject2 = (RelativeLayout.LayoutParams)((View)localObject1).getLayoutParams();
              ((RelativeLayout.LayoutParams)localObject2).rightMargin = 0;
              ((RelativeLayout.LayoutParams)localObject2).leftMargin = 0;
              ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
              localLayoutParams.addRule(0, i);
              this.mLoadingView.setLayoutParams(localLayoutParams);
            }
          }
        }
      }
    }
    for (Object localObject2 = localObject1;; localObject2 = null)
    {
      if ((this.mUseOptimizMode) && (this.mLoadingParent != null))
      {
        if ((this.mLoadingView != null) && (this.mLoadingView.getVisibility() == 0)) {
          break label521;
        }
        if (this.mLoadingView == null)
        {
          localObject1 = (RelativeLayout.LayoutParams)((View)localObject2).getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject1).rightMargin = 0;
          ((RelativeLayout.LayoutParams)localObject1).leftMargin = 0;
          ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
          this.mLoadingView = new ImageView(this);
          this.mLoadingView.setId(2131365708);
          localObject1 = new RelativeLayout.LayoutParams(-2, -2);
          ((RelativeLayout.LayoutParams)localObject1).addRule(0, ((View)localObject2).getId());
          ((RelativeLayout.LayoutParams)localObject1).addRule(15);
          ((RelativeLayout.LayoutParams)localObject1).rightMargin = ((int)(7.0F * DeviceInfoUtil.a()));
          this.mLoadingParent.addView(this.mLoadingView, (ViewGroup.LayoutParams)localObject1);
          localObject1 = getActivity().getResources().getDrawable(2130838598);
          this.mLoadingView.setImageDrawable((Drawable)localObject1);
          if ((localObject1 instanceof Animatable)) {
            ((Animatable)localObject1).start();
          }
        }
        if (this.mLoadingView.getVisibility() != 0) {
          this.mLoadingView.setVisibility(0);
        }
        return true;
        if ((localObject1 == null) || (((RelativeLayout)localObject1).getVisibility() != 0)) {
          break label523;
        }
        localObject2 = ((RelativeLayout)localObject1).getParent();
        break;
      }
      if (this.ad == null)
      {
        this.ad = getResources().getDrawable(2130838598);
        this.mOldDrawables = this.centerView.getCompoundDrawables();
        this.mOldPadding = this.centerView.getCompoundDrawablePadding();
        this.centerView.setCompoundDrawablePadding(10);
        this.centerView.setCompoundDrawablesWithIntrinsicBounds(this.ad, this.mOldDrawables[1], this.mOldDrawables[2], this.mOldDrawables[3]);
        ((Animatable)this.ad).start();
        return true;
      }
      label521:
      return false;
      label523:
      localObject2 = null;
      localObject1 = null;
      break;
    }
  }
  
  public boolean stopTitleProgress()
  {
    if ((this.mUseOptimizMode) && (this.mLoadingParent != null))
    {
      if ((this.mLoadingView != null) && (this.mLoadingView.getVisibility() != 8))
      {
        this.mLoadingView.setVisibility(8);
        return true;
      }
    }
    else if (this.ad != null)
    {
      ((Animatable)this.ad).stop();
      this.ad = null;
      this.centerView.setCompoundDrawablePadding(this.mOldPadding);
      this.centerView.setCompoundDrawablesWithIntrinsicBounds(this.mOldDrawables[0], this.mOldDrawables[1], this.mOldDrawables[2], this.mOldDrawables[3]);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.IphoneTitleBarActivity
 * JD-Core Version:    0.7.0.1
 */