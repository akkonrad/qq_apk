package com.tencent.mobileqq.activity.aio;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.os.Environment;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import btb;
import btc;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.thridappshare.ThridAppShareHelper;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ScreenShot;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.emoticonview.EmoticonPagerRadioGroup;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.fileAssistantReportData;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.servlet.GameCenterManagerImp;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.EnterConfigManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.widget.ActionSheet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class PlusPanel
  extends RelativeLayout
  implements View.OnClickListener
{
  private long jdField_a_of_type_Long = -1L;
  private ViewPager jdField_a_of_type_AndroidSupportV4ViewViewPager;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  public PanelAdapter a;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private EmoticonPagerRadioGroup jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup;
  ArrayList jdField_a_of_type_JavaUtilArrayList;
  HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private final int[] jdField_a_of_type_ArrayOfInt = { 2131363159, 2130837696 };
  String[] jdField_a_of_type_ArrayOfJavaLangString = { "chat_tool_secretfile", "chat_tool_audio", "chat_tool_gaudio" };
  private final int[][] jdField_a_of_type_Array2dOfInt = { this.jdField_a_of_type_ArrayOfInt, this.b };
  private final int[] b = { 2131363160, 2130837690 };
  private final int[] c = { 2131363166, 2130837693 };
  private final int[] d = { 2131362967, 2130837698 };
  private final int[] e = { 2131362968, 2130837698 };
  private final int[] f = { 2131363037, 2130837695 };
  private final int[] g = { 2131362969, 2130837699 };
  
  public PlusPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private boolean a(String paramString)
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().getSharedPreferences("QQLite", 0);
    if (paramString.equals("chat_tool_audio")) {
      return localSharedPreferences.getBoolean(paramString, true);
    }
    if (paramString.equals("chat_tool_gaudio")) {
      return localSharedPreferences.getBoolean(paramString, true);
    }
    return localSharedPreferences.getBoolean(paramString + "_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), true);
  }
  
  private void c()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfJavaLangString.length)
    {
      this.jdField_a_of_type_JavaUtilHashMap.put(this.jdField_a_of_type_ArrayOfJavaLangString[i], Boolean.valueOf(a(this.jdField_a_of_type_ArrayOfJavaLangString[i])));
      i += 1;
    }
  }
  
  private void d()
  {
    ThridAppShareHelper.a().b();
  }
  
  public void a()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(Arrays.asList(this.jdField_a_of_type_Array2dOfInt));
    Object localObject;
    label71:
    PlusPanel.PluginData localPluginData;
    int j;
    if (i == 3000)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(this.d);
      this.jdField_a_of_type_JavaUtilArrayList.add(this.c);
      d();
      localObject = new ArrayList();
      i = 0;
      if (i >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
        break label867;
      }
      int[] arrayOfInt = (int[])this.jdField_a_of_type_JavaUtilArrayList.get(i);
      localPluginData = new PlusPanel.PluginData();
      localPluginData.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().getResources().getDrawable(arrayOfInt[1]);
      localPluginData.jdField_a_of_type_Int = arrayOfInt[1];
      localPluginData.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().getResources().getString(arrayOfInt[0]);
      GameCenterManagerImp localGameCenterManagerImp = (GameCenterManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11);
      if (localGameCenterManagerImp != null)
      {
        if (localGameCenterManagerImp.a("999999.100004") == -1) {
          break label851;
        }
        j = 1;
      }
      label189:
      if (arrayOfInt != this.g) {
        break label856;
      }
    }
    label851:
    label856:
    for (localPluginData.b = "抖一抖按钮";; localPluginData.b = "")
    {
      ((ArrayList)localObject).add(localPluginData);
      i += 1;
      break label71;
      if (i == 1)
      {
        localObject = (FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
        if ((localObject != null) && (((FriendManager)localObject).f(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
        {
          this.jdField_a_of_type_JavaUtilArrayList.add(this.c);
          break;
        }
        this.jdField_a_of_type_JavaUtilArrayList.add(this.e);
        this.jdField_a_of_type_JavaUtilArrayList.add(this.c);
        d();
        break;
      }
      if ((i == 0) || (ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
      {
        if ((1024 == this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) && (CrmUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
        {
          if (CrmUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) {}
          this.jdField_a_of_type_JavaUtilArrayList.add(this.c);
          break;
        }
        this.jdField_a_of_type_JavaUtilArrayList.add(this.d);
        EnterConfigManager.a(BaseApplication.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
        this.jdField_a_of_type_JavaUtilArrayList.add(this.c);
        this.jdField_a_of_type_JavaUtilArrayList.add(this.g);
        if ((ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) || ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount() != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount().equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))) {}
        for (;;)
        {
          d();
          break;
          if (ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo))
          {
            this.jdField_a_of_type_JavaUtilArrayList.remove(this.d);
            this.jdField_a_of_type_JavaUtilArrayList.remove(this.c);
            this.jdField_a_of_type_JavaUtilArrayList.remove(this.g);
            this.jdField_a_of_type_JavaUtilArrayList.add(this.c);
          }
        }
      }
      if ((i == 1000) || (i == 1004) || (i == 1006))
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(this.d);
        this.jdField_a_of_type_JavaUtilArrayList.add(this.c);
        break;
      }
      if (i == 1020)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(this.c);
        break;
      }
      if ((i == 1009) || (i == 1023) || (i == 1024))
      {
        if (CrmUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) {}
        this.jdField_a_of_type_JavaUtilArrayList.add(this.c);
        break;
      }
      if (i == 1005)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(this.c);
        break;
      }
      if (i == 1003)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(this.c);
        break;
      }
      if (i == 1001)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(this.c);
        break;
      }
      if (i == 1022)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(this.c);
        break;
      }
      if (i == 6000)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(this.d);
        break;
      }
      if (i == 1025)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(this.c);
        this.jdField_a_of_type_JavaUtilArrayList.add(this.d);
        break;
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(this.c);
      break;
      j = 0;
      break label189;
    }
    label867:
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelAdapter.a((ArrayList)localObject);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelAdapter.getCount() > 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelAdapter.getCount(), false);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelAdapter.notifyDataSetChanged();
      post(new btb(this));
      return;
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.setVisibility(4);
    }
  }
  
  public void a(BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseChatPie.a();
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager = ((ViewPager)findViewById(2131296554));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup = ((EmoticonPagerRadioGroup)findViewById(2131296555));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.setViewPager(this.jdField_a_of_type_AndroidSupportV4ViewViewPager);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelAdapter = new PanelAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a());
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelAdapter.a(this);
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelAdapter);
    paramBaseChatPie = getResources().getDrawable(2130839328);
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
        a();
        return;
        if (!(paramBaseChatPie instanceof SkinnableBitmapDrawable)) {
          break label195;
        }
        paramBaseChatPie = ((SkinnableBitmapDrawable)paramBaseChatPie).getBitmap();
        break;
        if (QLog.isColorLevel()) {
          QLog.d("AIOAudioPanel", 2, "PlusPanle background is null:");
        }
      }
      label195:
      paramBaseChatPie = null;
    }
  }
  
  void a(String paramString)
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().getSharedPreferences("QQLite", 0);
    if (paramString.equals("chat_tool_audio")) {
      localSharedPreferences.edit().putBoolean(paramString, false).commit();
    }
    for (;;)
    {
      c();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelAdapter.notifyDataSetChanged();
      return;
      if (paramString.equals("chat_tool_gaudio")) {
        localSharedPreferences.edit().putBoolean(paramString, false).commit();
      } else {
        localSharedPreferences.edit().putBoolean(paramString + "_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), false).commit();
      }
    }
  }
  
  public void b()
  {
    a();
  }
  
  public void onClick(View paramView)
  {
    int i;
    switch (((PanelAdapter.ViewHolder)paramView.getTag()).jdField_a_of_type_Int)
    {
    case 2130837691: 
    case 2130837692: 
    case 2130837694: 
    case 2130837695: 
    default: 
      return;
    case 2130837690: 
      if (AudioHelper.a(0))
      {
        ChatActivityUtils.b(getContext());
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      PlusPanelUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), 1);
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().setCanLock(false);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800407A", "0X800407A", 0, 0, "", "", "", "");
      return;
    case 2130837696: 
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.V();
      paramView = ScreenShot.a();
      if (paramView != null)
      {
        ActionSheet localActionSheet = ActionSheet.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), 2131624119);
        String[] arrayOfString = getResources().getStringArray(2131230722);
        int j = arrayOfString.length;
        i = 0;
        while (i < j)
        {
          localActionSheet.c(arrayOfString[i]);
          i += 1;
        }
        localActionSheet.d(2131362790);
        localActionSheet.a(new btc(this, paramView, localActionSheet));
        localActionSheet.show();
      }
      for (;;)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004079", "0X8004079", 0, 0, "", "", "", "");
        return;
        PlusPanelUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null)
        {
          paramView = (TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(17);
          if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)) {
            paramView.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true);
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().setCanLock(false);
        }
      }
    case 2130837693: 
      PlusPanelUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a());
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().setCanLock(false);
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800407F", "0X800407F", 0, 0, "", "", "", "");
      return;
    case 2130837698: 
      if (Environment.getExternalStorageState().equals("mounted"))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800407E", "0X800407E", 0, 0, "", "", "", "");
          PlusPanelUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
        }
        while (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().setCanLock(false);
          return;
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800407C", "0X800407C", 0, 0, "", "", "", "");
          paramView = new FileManagerReporter.fileAssistantReportData();
          paramView.b = "send_file";
          paramView.jdField_a_of_type_Int = 1;
          FileManagerReporter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramView);
          PlusPanelUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
        }
      }
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), 2131363011, 1).b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().getResources().getDimensionPixelSize(2131492887));
      return;
    case 2130837699: 
      if (this.jdField_a_of_type_Long == -1L) {
        i = 1;
      }
      break;
    }
    for (;;)
    {
      if (i != 0)
      {
        ChatActivityFacade.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
        this.jdField_a_of_type_Long = System.currentTimeMillis();
      }
      for (;;)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004081", "0X8004081", 0, 0, "", "", "", "");
        return;
        if (System.currentTimeMillis() - this.jdField_a_of_type_Long >= 10000L) {
          break label881;
        }
        i = 0;
        break;
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), "歇一会再发送窗口抖动吧", 0).a();
      }
      a("chat_tool_remind");
      PlusPanelUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a() != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().setCanLock(false);
      }
      b();
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004080", "0X8004080", 0, 0, "", "", "", "");
      return;
      label881:
      i = 1;
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction() & 0xFF;
    if (i == 0) {
      getParent().requestDisallowInterceptTouchEvent(true);
    }
    for (;;)
    {
      return super.onInterceptTouchEvent(paramMotionEvent);
      if ((i == 1) || (i == 3)) {
        getParent().requestDisallowInterceptTouchEvent(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.PlusPanel
 * JD-Core Version:    0.7.0.1
 */