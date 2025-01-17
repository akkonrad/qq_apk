package com.tencent.mobileqq.ark;

import aauf;
import aaug;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticonview.EmoticonPagerRadioGroup;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import java.util.ArrayList;

public class ArkAppManagerPanel
  extends RelativeLayout
  implements ViewPager.OnPageChangeListener, View.OnClickListener, ArkMessageServerLogic.IRequestArkAppListHandler
{
  private int jdField_a_of_type_Int = 0;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public ArkPanelPagerAdapter a;
  private EmoticonPagerRadioGroup jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup;
  private QQViewPager jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager;
  private LinearLayout b;
  
  public ArkAppManagerPanel(Context paramContext)
  {
    super(paramContext);
  }
  
  public ArkAppManagerPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      this.jdField_a_of_type_Int = paramInt;
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.b.setVisibility(8);
      return;
    case 1: 
      this.jdField_a_of_type_Int = paramInt;
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.b.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.b.setVisibility(0);
  }
  
  public void a(BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseChatPie.a();
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager = ((QQViewPager)findViewById(2131363035));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup = ((EmoticonPagerRadioGroup)findViewById(2131363036));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.setViewPager(this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager);
    this.jdField_a_of_type_ComTencentMobileqqArkArkPanelPagerAdapter = new ArkPanelPagerAdapter(BaseApplicationImpl.getContext());
    this.jdField_a_of_type_ComTencentMobileqqArkArkPanelPagerAdapter.a(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqArkArkPanelPagerAdapter);
    setPagerChangedListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131362727));
    this.b = ((LinearLayout)findViewById(2131363300));
    this.b.setOnClickListener(this);
    a(0);
    paramBaseChatPie = getResources().getDrawable(2130845947);
    if ((paramBaseChatPie instanceof BitmapDrawable)) {
      paramBaseChatPie = ((BitmapDrawable)paramBaseChatPie).getBitmap();
    }
    for (;;)
    {
      paramBaseChatPie = new BitmapDrawable(paramBaseChatPie);
      if (paramBaseChatPie != null)
      {
        paramBaseChatPie.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        paramBaseChatPie.setDither(true);
        setBackgroundDrawable(paramBaseChatPie);
      }
      for (;;)
      {
        ArkMessageServerLogic.a(this);
        return;
        if (!(paramBaseChatPie instanceof SkinnableBitmapDrawable)) {
          break label220;
        }
        paramBaseChatPie = ((SkinnableBitmapDrawable)paramBaseChatPie).getBitmap();
        break;
        if (QLog.isColorLevel()) {
          QLog.d("ArkAppManagerPanel", 2, "ArkAppManagerPanel background is null:");
        }
      }
      label220:
      paramBaseChatPie = null;
    }
  }
  
  public void a(ArrayList paramArrayList)
  {
    this.jdField_a_of_type_ComTencentMobileqqArkArkPanelPagerAdapter.a(paramArrayList);
    a(1);
    if (this.jdField_a_of_type_ComTencentMobileqqArkArkPanelPagerAdapter.getCount() > 1) {}
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.a(this.jdField_a_of_type_ComTencentMobileqqArkArkPanelPagerAdapter.getCount(), false);
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqArkArkPanelPagerAdapter.notifyDataSetChanged();
        post(new aauf(this));
        return;
      }
      catch (Exception paramArrayList)
      {
        QLog.d("ArkAppManagerPanel", 2, "exception=" + paramArrayList);
        continue;
      }
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.setVisibility(4);
    }
  }
  
  public void b(ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() <= 0))
    {
      a(2);
      return;
    }
    int j = paramArrayList.size() - 7;
    if (j > 0)
    {
      int i = 0;
      while (i < j)
      {
        paramArrayList.remove(paramArrayList.size() - 1);
        i += 1;
      }
    }
    ArkAppManagerPanel.ArkAppPanelData localArkAppPanelData = new ArkAppManagerPanel.ArkAppPanelData();
    localArkAppPanelData.jdField_a_of_type_Boolean = true;
    localArkAppPanelData.jdField_a_of_type_JavaLangString = null;
    localArkAppPanelData.b = getResources().getString(2131433926);
    paramArrayList.add(localArkAppPanelData);
    ArkAppCenter.a().postToMainThread(new aaug(this, paramArrayList));
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Int == 1)
    {
      paramView = (ArkPanelPagerAdapter.ViewHolder)paramView.getTag();
      if (!TextUtils.isEmpty(paramView.jdField_a_of_type_JavaLangString))
      {
        str = "mqqapi://lightapp/open?app=" + paramView.jdField_a_of_type_JavaLangString;
        JumpParser.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getContext(), str).b();
        ((ArkAppHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(95)).b(paramView.jdField_a_of_type_JavaLangString);
        ArkAppDataReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView.jdField_a_of_type_JavaLangString, "ArkPanelAppIconClick", 1, 0, 0L, 0L, 0L, null, null);
      }
    }
    while (this.jdField_a_of_type_Int != 2)
    {
      String str;
      return;
      paramView = new Intent(getContext(), QQBrowserActivity.class);
      paramView.putExtra("url", "http://ti.qq.com/ark/aioplus/index.html");
      getContext().startActivity(paramView);
      ArkAppDataReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "com.tencent.ark.panel.more", "ArkPanelMoreIconClick", 1, 0, 0L, 0L, 0L, null, null);
      return;
    }
    a(0);
    ArkMessageServerLogic.a(this);
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt) {}
  
  public void setPagerChangedListener(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.setPagerChangedListener(paramOnPageChangeListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAppManagerPanel
 * JD-Core Version:    0.7.0.1
 */