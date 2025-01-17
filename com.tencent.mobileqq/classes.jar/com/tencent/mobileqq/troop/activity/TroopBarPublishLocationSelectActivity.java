package com.tencent.mobileqq.troop.activity;

import aiyg;
import aiyh;
import aiyk;
import aiyl;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.activity.Contacts.OverScrollViewTag;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.troop.data.TroopBarPOI;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import com.tencent.mobileqq.troop.utils.TroopBarUtils;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopBarPublishLocationSelectActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, HttpWebCgiAsyncTask.Callback, AdapterView.OnItemClickListener
{
  public long a;
  protected Drawable a;
  public Handler a;
  protected View a;
  protected SosoInterface.OnLocationListener a;
  protected TroopBarPublishLocationSelectActivity.LocationAdapter a;
  public final TroopBarPOI a;
  protected PullRefreshHeader a;
  public XListView a;
  public ArrayList a;
  protected boolean a;
  protected TroopBarPOI b;
  protected TroopBarPOI c;
  
  public TroopBarPublishLocationSelectActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI = new TroopBarPOI("-1", "", "不显示", 0, "", 0, "");
    this.jdField_a_of_type_AndroidOsHandler = new aiyk(this);
  }
  
  public static final void a(BaseActivity paramBaseActivity, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, HttpWebCgiAsyncTask.Callback paramCallback)
  {
    Bundle localBundle1 = new Bundle();
    localBundle1.putString("lat", String.valueOf(paramInt1));
    localBundle1.putString("lon", String.valueOf(paramInt2));
    localBundle1.putString("num", String.valueOf(50));
    localBundle1.putString("start", String.valueOf(paramInt3));
    Bundle localBundle2 = new Bundle();
    if (paramBoolean) {
      localBundle2.putBoolean("refresh_all_poi", paramBoolean);
    }
    TroopBarUtils.a(paramBaseActivity, localBundle1, "https://buluo.qq.com/cgi-bin/bar/user/poilist", 3, localBundle2, paramCallback);
  }
  
  protected void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)LayoutInflater.from(this).inflate(2130969239, this.jdField_a_of_type_ComTencentWidgetXListView, false));
    Contacts.OverScrollViewTag localOverScrollViewTag = new Contacts.OverScrollViewTag();
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.setTag(localOverScrollViewTag);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverscrollHeader(getResources().getDrawable(2130838590));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollListener(new aiyh(this));
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader != null)
    {
      Contacts.OverScrollViewTag localOverScrollViewTag = (Contacts.OverScrollViewTag)this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.getTag();
      if (localOverScrollViewTag != null)
      {
        localOverScrollViewTag.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1001, 800L);
        if (paramInt == 0) {
          this.jdField_a_of_type_Long = System.currentTimeMillis();
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(paramInt);
      }
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    b(true);
    if (this.b != null)
    {
      a(this, this.b.b, this.b.a, paramInt, paramBoolean, this);
      return;
    }
    b();
  }
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return;
    }
    this.c = ((TroopBarPOI)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishLocationSelectActivity$LocationAdapter.notifyDataSetChanged();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.equals(this.c)) {}
    for (paramAdapterView = null;; paramAdapterView = this.c)
    {
      paramView = new Intent();
      paramView.putExtra("key_selected_poi", paramAdapterView);
      setResult(-1, paramView);
      finish();
      return;
    }
  }
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    b(false);
    if (paramJSONObject != null) {}
    for (;;)
    {
      boolean bool;
      try
      {
        if (paramJSONObject.optInt("isend", -1) != 1) {
          break label337;
        }
        bool = true;
        a(bool);
        localJSONArray = paramJSONObject.getJSONArray("poilist");
        if (this.jdField_a_of_type_JavaUtilArrayList == null) {
          this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        }
        if ((paramBundle != null) && (paramBundle.getBoolean("refresh_all_poi"))) {
          this.jdField_a_of_type_JavaUtilArrayList.clear();
        }
        if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
          break label332;
        }
        this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI);
      }
      catch (JSONException paramBundle)
      {
        JSONArray localJSONArray;
        if (!QLog.isColorLevel()) {
          break label212;
        }
        QLog.d("TroopBar", 2, paramBundle.toString());
      }
      if (paramInt < localJSONArray.length())
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(new TroopBarPOI(localJSONArray.getJSONObject(paramInt)));
        paramInt += 1;
      }
      else
      {
        if (this.jdField_a_of_type_JavaUtilArrayList.size() > 1)
        {
          paramBundle = (TroopBarPOI)this.jdField_a_of_type_JavaUtilArrayList.get(1);
          this.b = paramBundle;
          this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishLocationSelectActivity$LocationAdapter.notifyDataSetChanged();
          return;
          label212:
          if (paramJSONObject.optInt("isend", -1) == 1) {
            break;
          }
          paramInt = paramJSONObject.optInt("retcode", -1);
          if (paramInt == 0) {
            break label274;
          }
          QQToast.a(this, 1, getString(2131430309, new Object[] { Integer.valueOf(paramInt) }), 0).b(getTitleBarHeight());
          return;
        }
        paramBundle = null;
        continue;
        label274:
        QQToast.a(this, 1, getString(2131430309, new Object[] { Integer.valueOf(paramJSONObject.optInt("errno", -1)) }), 0).b(getTitleBarHeight());
        return;
        QQToast.a(this, 1, 2131430308, 0).b(getTitleBarHeight());
        return;
        label332:
        paramInt = 0;
        continue;
        label337:
        bool = false;
      }
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    TextView localTextView = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363944);
    if (paramBoolean)
    {
      localTextView.setText(2131434350);
      return;
    }
    localTextView.setText(2131434346);
  }
  
  protected void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener = new aiyl(this, 0, true, true, 0L, false, false, "QLifeCommentActivity");
    SosoInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener);
  }
  
  protected void b(boolean paramBoolean)
  {
    if (paramBoolean) {
      if ((this.centerView != null) && (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null))
      {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130838596);
        this.centerView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, null, null);
        ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).start();
      }
    }
    while ((this.centerView == null) || (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)) {
      return;
    }
    ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).stop();
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
    this.centerView.setCompoundDrawables(null, null, null, null);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_ComTencentWidgetXListView = new XListView(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(getResources().getDrawable(2130839270));
    this.jdField_a_of_type_ComTencentWidgetXListView.setDividerHeight(1);
    setContentView(this.jdField_a_of_type_ComTencentWidgetXListView);
    setTitle(2131430334);
    this.rightViewImg.setImageResource(2130840556);
    this.rightViewImg.setVisibility(0);
    this.rightViewImg.setOnClickListener(this);
    paramBundle = getIntent();
    this.jdField_a_of_type_JavaUtilArrayList = paramBundle.getParcelableArrayListExtra("current_location_list");
    this.jdField_a_of_type_Boolean = paramBundle.getBooleanExtra("Transparent_Bg", false);
    this.c = ((TroopBarPOI)paramBundle.getParcelableExtra("key_selected_poi"));
    if (this.c == null) {
      this.c = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI;
    }
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList.isEmpty())
      {
        paramBundle = null;
        this.b = paramBundle;
        this.jdField_a_of_type_JavaUtilArrayList.add(0, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI);
      }
    }
    else
    {
      if (!this.jdField_a_of_type_Boolean) {
        break label402;
      }
      this.jdField_a_of_type_ComTencentWidgetXListView.setBackgroundResource(17170445);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this).inflate(2130969239, null);
      a();
      paramBundle = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363301);
      TextView localTextView1 = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363944);
      TextView localTextView2 = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363945);
      ProgressBar localProgressBar = (ProgressBar)this.jdField_a_of_type_AndroidViewView.findViewById(2131363049);
      localTextView1.setTextColor(-8355712);
      localTextView1.setText(2131434346);
      localTextView2.setVisibility(8);
      paramBundle.setVisibility(8);
      localProgressBar.setVisibility(8);
      this.jdField_a_of_type_ComTencentWidgetXListView.addFooterView(this.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(new aiyg(this));
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishLocationSelectActivity$LocationAdapter = new TroopBarPublishLocationSelectActivity.LocationAdapter(this, this, this.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishLocationSelectActivity$LocationAdapter);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(this);
      a(0, true);
      return true;
      paramBundle = (TroopBarPOI)this.jdField_a_of_type_JavaUtilArrayList.get(0);
      break;
      label402:
      this.jdField_a_of_type_ComTencentWidgetXListView.setBackgroundResource(2130838214);
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener != null) {
      SosoInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    a(0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopBarPublishLocationSelectActivity
 * JD-Core Version:    0.7.0.1
 */