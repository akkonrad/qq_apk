package com.tencent.mobileqq.troop.activity;

import aitj;
import aitk;
import aitl;
import aitm;
import aitn;
import aito;
import aitp;
import aitq;
import aitt;
import aitu;
import aitv;
import aitw;
import aitx;
import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.LightingColorFilter;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.Editable.Factory;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemEmoticonPanel;
import com.tencent.mobileqq.hotpic.HotPicData;
import com.tencent.mobileqq.hotpic.HotPicPageView.OnHotPicItemClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tribe.TribePostTitlePrefixPanelController;
import com.tencent.mobileqq.tribe.view.TEditText;
import com.tencent.mobileqq.tribe.view.TribeTitlePrefixPanelView.TitlePrefixItem;
import com.tencent.mobileqq.troop.data.AudioInfo;
import com.tencent.mobileqq.troop.data.MediaInfo;
import com.tencent.mobileqq.troop.data.TroopBarPOI;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import com.tencent.mobileqq.troop.utils.TribeUtils;
import com.tencent.mobileqq.troop.utils.TroopBarUtils;
import com.tencent.mobileqq.troop.utils.TroopBarUtils.PublishDataCacheEntity;
import com.tencent.mobileqq.troop.widget.PublishItemBar;
import com.tencent.mobileqq.troop.widget.PublishItemContainer;
import com.tencent.mobileqq.troop.widget.TribeHotPicPanel;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.widget.InputMethodLinearLayout;
import com.tencent.mobileqq.widget.InputMethodLinearLayout.onSizeChangeListenner;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.InputMethodUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ScrollView;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.manager.TicketManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class AbsPublishActivity
  extends IphoneTitleBarActivity
  implements TextWatcher, View.OnClickListener, View.OnFocusChangeListener, View.OnTouchListener, AdapterView.OnItemClickListener, EmoticonCallback, HotPicPageView.OnHotPicItemClickListener, HttpWebCgiAsyncTask.Callback, InputMethodLinearLayout.onSizeChangeListenner
{
  public static Editable.Factory a;
  protected int a;
  protected long a;
  protected BroadcastReceiver a;
  public Uri a;
  public Handler a;
  protected View a;
  protected EditText a;
  protected FrameLayout a;
  public ImageButton a;
  protected ImageView a;
  protected LinearLayout a;
  protected ListView a;
  public RelativeLayout a;
  protected TextView a;
  public BaseActivity a;
  protected SosoInterface.OnLocationListener a;
  public SystemEmoticonPanel a;
  public TEditText a;
  public ExtendGridView a;
  public TroopBarImagePreviewAdapter a;
  protected TroopBarPublishUtils.AudioUploadTask a;
  protected TroopBarPublishUtils.PicUploadThread a;
  public AudioInfo a;
  public TroopBarPOI a;
  public PublishItemBar a;
  public PublishItemContainer a;
  public TribeHotPicPanel a;
  protected InputMethodLinearLayout a;
  public QQProgressDialog a;
  protected ActionSheet a;
  public ScrollView a;
  protected Boolean a;
  protected String a;
  public ArrayList a;
  public JSONObject a;
  protected boolean a;
  protected int b;
  protected long b;
  public View b;
  protected EditText b;
  protected FrameLayout b;
  protected LinearLayout b;
  public TextView b;
  public TEditText b;
  protected QQProgressDialog b;
  protected String b;
  protected ArrayList b;
  protected boolean b;
  public int c;
  public View c;
  protected TextView c;
  public String c;
  protected boolean c;
  public int d;
  public View d;
  protected String d;
  public boolean d;
  protected int e;
  protected String e;
  public boolean e;
  protected int f;
  protected String f;
  protected boolean f;
  protected int g;
  protected String g;
  protected boolean g;
  public int h;
  protected String h;
  public boolean h;
  protected int i;
  protected String i;
  protected boolean i;
  protected int j;
  protected String j;
  protected boolean j;
  protected int k;
  protected String k;
  protected boolean k;
  protected int l;
  protected String l;
  protected boolean l;
  protected int m;
  protected String m;
  protected boolean m;
  int n;
  protected String n;
  protected boolean n;
  protected String o;
  public String p;
  public String q;
  public String r = "";
  protected String s;
  protected String t = "";
  
  static
  {
    jdField_a_of_type_AndroidTextEditable$Factory = new aitk();
  }
  
  public AbsPublishActivity()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_a_of_type_Boolean = true;
    this.jdField_f_of_type_JavaLangString = "https://upload.buluo.qq.com/cgi-bin/bar/upload/image";
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_f_of_type_Boolean = true;
    this.jdField_c_of_type_Int = 9;
    this.jdField_g_of_type_Boolean = true;
    this.jdField_h_of_type_Boolean = true;
    this.jdField_i_of_type_Boolean = true;
    this.jdField_j_of_type_Boolean = true;
    this.jdField_l_of_type_Boolean = true;
    this.jdField_j_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new aitp(this);
    this.jdField_a_of_type_AndroidOsHandler = new aitq(this);
    this.jdField_n_of_type_Int = 0;
  }
  
  public static String a(JSONArray paramJSONArray, String paramString)
  {
    if (!android.text.TextUtils.isEmpty(paramString))
    {
      JSONArray localJSONArray = paramJSONArray;
      if (paramJSONArray == null) {
        localJSONArray = new JSONArray();
      }
      paramJSONArray = new JSONObject();
      paramJSONArray.put("imagePath", paramString);
      localJSONArray.put(paramJSONArray);
      return localJSONArray.toString();
    }
    return null;
  }
  
  protected int a()
  {
    return 2131430347;
  }
  
  public Animation a(float paramFloat1, float paramFloat2)
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(paramFloat1, paramFloat2);
    localAlphaAnimation.setDuration(200L);
    localAlphaAnimation.setFillAfter(true);
    return localAlphaAnimation;
  }
  
  protected String a(TribeTitlePrefixPanelView.TitlePrefixItem paramTitlePrefixItem, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText == null) {}
    String str;
    int i1;
    do
    {
      return null;
      if (paramTitlePrefixItem == null) {
        return TroopBarUtils.a(this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText);
      }
      str = TroopBarUtils.a(this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText);
      i1 = paramTitlePrefixItem.jdField_a_of_type_JavaLangString.length() + paramTitlePrefixItem.jdField_b_of_type_JavaLangString.length() + paramTitlePrefixItem.jdField_c_of_type_JavaLangString.length() + paramString.length();
    } while (str.length() <= i1);
    return str.substring(i1, str.length());
  }
  
  @SuppressLint({"NewApi"})
  protected void a()
  {
    setContentView(2130969468);
    getTitleBarView().setBackgroundColor(-1);
    setLeftButton(2131433015, null);
    this.leftViewNotBack.setTextColor(-16777216);
    setRightButton(2131430318, this);
    this.rightViewText.setTextColor(-16777216);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      getWindow().addFlags(67108864);
      this.mSystemBarComp = new SystemBarCompact(this, true, -1);
      this.mSystemBarComp.init();
    }
    if (AppSetting.jdField_b_of_type_Boolean)
    {
      this.leftViewNotBack.setContentDescription(getString(2131430335));
      this.rightViewText.setContentDescription(getString(2131430336));
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodLinearLayout = ((InputMethodLinearLayout)findViewById(2131365636));
    this.jdField_a_of_type_ComTencentWidgetScrollView = ((ScrollView)findViewById(2131363689));
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131366638));
    Object localObject = getResources().getDisplayMetrics();
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131366607));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131368612);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368613));
    this.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth(((DisplayMetrics)localObject).widthPixels / 2);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368615));
    this.jdField_b_of_type_AndroidWidgetTextView.setMaxWidth(((DisplayMetrics)localObject).widthPixels / 2);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131368616));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368614));
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)findViewById(2131366620));
    this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText = ((TEditText)findViewById(2131366616));
    this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText = ((TEditText)findViewById(2131366618));
    this.jdField_b_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131366617));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131366615));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131366619));
    this.jdField_b_of_type_AndroidViewView = findViewById(2131366622);
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityExtendGridView = ((ExtendGridView)findViewById(2131366623));
    this.jdField_b_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131366614));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131366635));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131366637));
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer = ((PublishItemContainer)findViewById(2131366621));
    this.jdField_c_of_type_AndroidViewView = findViewById(2131366624);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemBar = ((PublishItemBar)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131366639));
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemBar.setCallback(this.jdField_a_of_type_AndroidOsHandler);
    if (this.jdField_i_of_type_Int == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemBar.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setBackgroundColor(-1);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.setVisibility(8);
      if (!this.jdField_h_of_type_Boolean) {
        break label787;
      }
      this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText.setOnTouchListener(this);
      this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText.setOnFocusChangeListener(this);
    }
    for (;;)
    {
      localObject = getResources().getDisplayMetrics();
      if ((localObject != null) && (((DisplayMetrics)localObject).heightPixels <= 800)) {
        this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.setMinLines(3);
      }
      this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.addTextChangedListener(this);
      this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.setOnTouchListener(this);
      this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.setOnFocusChangeListener(this);
      this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.setFilters(new InputFilter[] { new aitw(this) });
      this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodLinearLayout.setOnSizeChangedListenner(this);
      this.jdField_a_of_type_ComTencentWidgetScrollView.setOnTouchListener(this);
      this.jdField_a_of_type_ComTencentWidgetScrollView.setOverScrollMode(2);
      a(this, this);
      localObject = getResources().getDrawable(2130841211);
      ((Drawable)localObject).setColorFilter(new LightingColorFilter(0, -10591367));
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds((Drawable)localObject, null, null, null);
      if (this.jdField_b_of_type_AndroidWidgetTextView != null)
      {
        localObject = getResources().getDrawable(2130841216);
        ((Drawable)localObject).setColorFilter(new LightingColorFilter(0, -18432));
        this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds((Drawable)localObject, null, null, null);
      }
      j();
      if (!android.text.TextUtils.isEmpty(this.o)) {
        this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.setText(this.o);
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemBar.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemBar.a(this.jdField_i_of_type_Int);
      break;
      label787:
      this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText.setVisibility(8);
    }
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    case 3: 
    default: 
      return;
    case 0: 
      Resources localResources = getResources();
      paramInt = (int)localResources.getDimension(2131558846);
      int i1 = (int)localResources.getDimension(2131558847);
      if (this.jdField_i_of_type_Int == 0) {}
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemBar.a(this.jdField_i_of_type_Int);
        if ((this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTribeHotPicPanel != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTribeHotPicPanel.isShown())) {
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemBar.a(5, 1);
        }
        this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.setPadding(this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.getPaddingLeft(), this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.getPaddingTop(), this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.getPaddingRight(), paramInt);
        e();
        return;
        paramInt = paramInt + i1 + localResources.getDrawable(2130840565).getIntrinsicHeight();
      }
    case 1: 
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemBar.a(1);
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTribeHotPicPanel != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTribeHotPicPanel.isShown())) {
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemBar.a(5, 1);
      }
      this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.setPadding(this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.getPaddingLeft(), this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.getPaddingTop(), this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.getPaddingRight(), 0);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.a();
      return;
    case 2: 
      this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.setPadding(this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.getPaddingLeft(), this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.getPaddingTop(), this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.getPaddingRight(), 0);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemBar.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.setVisibility(0);
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.setPadding(this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.getPaddingLeft(), this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.getPaddingTop(), this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.getPaddingRight(), 0);
  }
  
  public abstract void a(int paramInt1, int paramInt2);
  
  protected void a(int paramInt, Handler paramHandler)
  {
    runOnUiThread(new aitu(this));
    if (((TicketManager)this.app.getManager(2)).getSkey(this.app.getCurrentAccountUin()) != null) {
      switch (paramInt)
      {
      }
    }
    while (!QLog.isColorLevel())
    {
      return;
      ThreadManager.post(new TroopBarPublishUtils.PicUploadThread(this, paramHandler, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_f_of_type_JavaLangString), 8, null, true);
      return;
    }
    QLog.w("IphoneTitleBarActivity", 2, "startUploadImage skey is null!!!!!!!!!!!!!!!");
  }
  
  protected void a(int paramInt, MediaInfo paramMediaInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.a(paramInt, paramMediaInfo);
    a(paramInt);
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    if ((paramMediaInfo instanceof AudioInfo)) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo = ((AudioInfo)paramMediaInfo);
    }
  }
  
  protected void a(int paramInt, String... paramVarArgs)
  {
    int i1 = 0;
    Object localObject = "";
    switch (paramInt)
    {
    default: 
      paramVarArgs = (String[])localObject;
      paramInt = i1;
      label41:
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramVarArgs);
      if (AppSetting.jdField_b_of_type_Boolean) {
        if (paramInt == 0) {
          break label200;
        }
      }
      break;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(paramVarArgs);
      return;
      paramVarArgs = getString(2131430357);
      paramInt = i1;
      break label41;
      String str = getString(2131432507);
      localObject = str;
      if (paramVarArgs == null) {
        break;
      }
      localObject = str;
      if (paramVarArgs.length <= 0) {
        break;
      }
      QQToast.a(this, paramVarArgs[0], 1).b(getTitleBarHeight());
      paramVarArgs = str;
      paramInt = i1;
      break label41;
      paramVarArgs = getString(2131432506);
      paramInt = i1;
      break label41;
      if ((paramVarArgs != null) && (paramVarArgs.length > 0) && (!android.text.TextUtils.isEmpty(paramVarArgs[0])))
      {
        if (android.text.TextUtils.isEmpty(paramVarArgs[0]))
        {
          a(3, new String[0]);
          return;
        }
        paramVarArgs = paramVarArgs[0];
        paramInt = 1;
        break label41;
      }
      a(0, new String[0]);
      return;
      label200:
      paramVarArgs = getString(2131430340);
    }
  }
  
  abstract void a(View paramView, int paramInt, long paramLong);
  
  protected void a(BaseActivity paramBaseActivity, HttpWebCgiAsyncTask.Callback paramCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener = new aitl(this, 0, true, true, this.jdField_n_of_type_Int, false, false, "AbsPublish", paramBaseActivity, paramCallback);
    SosoInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener);
    a(2, new String[0]);
  }
  
  public void a(BaseActivity paramBaseActivity, String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentWidgetActionSheet != null) && (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())) {
      return;
    }
    paramString = ActionSheet.a(paramBaseActivity);
    paramString.a(2131436158, 1);
    paramString.a(2131436160, 1);
    paramString.c(2131433015);
    paramString.a(new aitv(this, paramBaseActivity, paramString));
    paramString.show();
    this.jdField_a_of_type_ComTencentWidgetActionSheet = paramString;
  }
  
  public void a(EmoticonInfo paramEmoticonInfo)
  {
    if (((paramEmoticonInfo instanceof SystemAndEmojiEmoticonInfo)) && (this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText != null)) {
      ((SystemAndEmojiEmoticonInfo)paramEmoticonInfo).a(this.app, this, this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText, null);
    }
  }
  
  public void a(EmoticonInfo paramEmoticonInfo1, EmoticonInfo paramEmoticonInfo2, Drawable paramDrawable) {}
  
  public void a(String paramString)
  {
    if (!android.text.TextUtils.isEmpty(paramString)) {
      try
      {
        paramString = new JSONArray(paramString);
        if ((paramString != null) && (paramString.length() > 0))
        {
          int i1 = 0;
          while (i1 < paramString.length())
          {
            JSONObject localJSONObject = paramString.optJSONObject(i1);
            if (localJSONObject != null) {
              a(this.jdField_a_of_type_AndroidOsHandler, localJSONObject.optString("imagePath"));
            }
            i1 += 1;
          }
        }
        return;
      }
      catch (JSONException paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.d("IphoneTitleBarActivity", 2, QLog.getStackTraceString(paramString));
        }
      }
    }
  }
  
  void a(JSONObject paramJSONObject)
  {
    this.jdField_a_of_type_Boolean = paramJSONObject.optBoolean("needCategory");
    this.jdField_a_of_type_Int = paramJSONObject.optInt("minTitleLength", 4);
    this.jdField_b_of_type_Int = paramJSONObject.optInt("maxTitleLength", 25);
    this.jdField_d_of_type_JavaLangString = paramJSONObject.optString("titlePlaceholder", this.jdField_d_of_type_JavaLangString);
    if (this.jdField_d_of_type_Int == 2) {
      this.jdField_c_of_type_JavaLangString = "sbarindex";
    }
    if (!android.text.TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      if (!this.jdField_a_of_type_JavaLangString.equals("topicFrom")) {
        break label150;
      }
      this.jdField_c_of_type_JavaLangString = String.valueOf(0);
    }
    for (;;)
    {
      l();
      com.tencent.biz.common.util.ImageUtil.a((String)null, 0);
      paramJSONObject = new IntentFilter();
      paramJSONObject.addAction("key_photo_delete_action");
      paramJSONObject.addAction("key_audio_delete_action");
      paramJSONObject.addAction("key_audio_play_action");
      registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramJSONObject);
      return;
      label150:
      if (this.jdField_a_of_type_JavaLangString.equals("sbarindex")) {
        this.jdField_c_of_type_JavaLangString = "sbarindex";
      } else {
        this.jdField_c_of_type_JavaLangString = String.valueOf(1);
      }
    }
  }
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    if (isFinishing()) {
      return;
    }
    switch (paramInt)
    {
    default: 
      return;
    }
    if (paramJSONObject != null) {}
    for (;;)
    {
      try
      {
        paramJSONObject = paramJSONObject.getJSONArray("poilist");
        if (this.jdField_b_of_type_JavaUtilArrayList == null)
        {
          this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
          break label226;
          if (paramInt < paramJSONObject.length())
          {
            this.jdField_b_of_type_JavaUtilArrayList.add(new TroopBarPOI(paramJSONObject.getJSONObject(paramInt)));
            paramInt += 1;
            continue;
          }
        }
        else
        {
          this.jdField_b_of_type_JavaUtilArrayList.clear();
        }
      }
      catch (JSONException paramJSONObject)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopBar", 2, paramJSONObject.toString());
        }
        if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI != null)
        {
          if (android.text.TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.jdField_c_of_type_JavaLangString))
          {
            paramJSONObject = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.jdField_d_of_type_JavaLangString;
            a(1, new String[] { paramJSONObject });
            return;
            if (this.jdField_b_of_type_JavaUtilArrayList.size() <= 0) {
              continue;
            }
            this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI = ((TroopBarPOI)this.jdField_b_of_type_JavaUtilArrayList.get(0));
            continue;
          }
          paramJSONObject = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.jdField_c_of_type_JavaLangString;
          continue;
        }
        a(0, new String[0]);
        return;
      }
      a(3, new String[0]);
      return;
      label226:
      paramInt = 0;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    b(paramBoolean);
  }
  
  protected boolean a()
  {
    if (this.jdField_d_of_type_Boolean) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopBar", 2, "publish restore key = " + this.jdField_m_of_type_JavaLangString);
    }
    if (android.text.TextUtils.isEmpty(this.jdField_m_of_type_JavaLangString)) {
      return false;
    }
    TroopBarUtils.PublishDataCacheEntity localPublishDataCacheEntity = (TroopBarUtils.PublishDataCacheEntity)TroopBarUtils.a.get(this.jdField_m_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.d("TroopBar", 2, "publish restore key = " + this.jdField_m_of_type_JavaLangString + ", data = " + localPublishDataCacheEntity);
    }
    TroopBarUtils.a.clear();
    if (localPublishDataCacheEntity == null) {
      return false;
    }
    if (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0) {
      this.jdField_a_of_type_JavaUtilArrayList = localPublishDataCacheEntity.jdField_a_of_type_JavaUtilArrayList;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI = localPublishDataCacheEntity.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI;
    this.jdField_b_of_type_JavaUtilArrayList = localPublishDataCacheEntity.jdField_b_of_type_JavaUtilArrayList;
    this.jdField_e_of_type_JavaLangString = localPublishDataCacheEntity.jdField_c_of_type_JavaLangString;
    this.jdField_l_of_type_JavaLangString = localPublishDataCacheEntity.jdField_d_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo = localPublishDataCacheEntity.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo;
    this.jdField_d_of_type_JavaLangString = localPublishDataCacheEntity.jdField_a_of_type_JavaLangString;
    this.jdField_k_of_type_JavaLangString = localPublishDataCacheEntity.jdField_b_of_type_JavaLangString;
    if ((android.text.TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) || (this.jdField_b_of_type_Int <= 0))
    {
      this.jdField_a_of_type_Int = 4;
      this.jdField_b_of_type_Int = 25;
      this.jdField_d_of_type_JavaLangString = getString(2131430315, new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.jdField_b_of_type_Int) });
    }
    if ((android.text.TextUtils.isEmpty(this.jdField_k_of_type_JavaLangString)) || (this.jdField_e_of_type_Int < 0) || (this.jdField_f_of_type_Int <= 0))
    {
      this.jdField_e_of_type_Int = 10;
      this.jdField_f_of_type_Int = 700;
      this.jdField_k_of_type_JavaLangString = getString(2131430316, new Object[] { Integer.valueOf(this.jdField_e_of_type_Int), Integer.valueOf(this.jdField_f_of_type_Int) });
    }
    return true;
  }
  
  public boolean a(int paramInt)
  {
    Object localObject = null;
    if ((this.jdField_k_of_type_Int & paramInt) == paramInt)
    {
      switch (paramInt)
      {
      }
      while (localObject != null)
      {
        QQToast.a(this, (CharSequence)localObject, 0).b(getTitleBarHeight());
        return true;
        localObject = getString(2131430492, new Object[] { this.jdField_n_of_type_JavaLangString });
        continue;
        localObject = getString(2131430491, new Object[] { this.jdField_n_of_type_JavaLangString });
      }
    }
    return false;
  }
  
  protected boolean a(int paramInt, boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (;;)
    {
      return true;
      String str = null;
      if (((paramInt & 0x1) == 1) && (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)) {
        str = getString(2131430495, new Object[] { getString(2131430480) });
      }
      while (str != null)
      {
        QQToast.a(this, str, 0).b(getTitleBarHeight());
        return false;
        if (((paramInt & 0x2) == 2) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo == null)) {
          str = getString(2131430495, new Object[] { getString(2131430478) });
        } else if ((paramInt & 0x4) == 4) {
          str = getString(2131430495, new Object[] { getString(2131430479) });
        } else if ((paramInt & 0x8) == 8) {
          str = getString(2131430495, new Object[] { getString(2131430481) });
        }
      }
    }
  }
  
  protected boolean a(Handler paramHandler, String paramString)
  {
    if (android.text.TextUtils.isEmpty(paramString)) {
      QQToast.a(this, getString(2131430493), 1).b(getTitleBarHeight());
    }
    while (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return false;
    }
    if (this.jdField_a_of_type_JavaUtilArrayList.size() >= 9)
    {
      QQToast.a(this, getString(2131432401, new Object[] { Integer.valueOf(9) }), 1).b(getTitleBarHeight());
      return false;
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(paramString);
    Message localMessage = paramHandler.obtainMessage(1005);
    localMessage.obj = paramString;
    paramHandler.sendMessage(localMessage);
    return true;
  }
  
  protected boolean a(Handler paramHandler, ArrayList paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 9))
    {
      QQToast.a(this, getString(2131432401, new Object[] { Integer.valueOf(9) }), 1).b(getTitleBarHeight());
      return false;
    }
    if (paramArrayList != this.jdField_a_of_type_JavaUtilArrayList)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      if (paramArrayList != null) {
        this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
      }
    }
    for (;;)
    {
      paramHandler.sendMessage(paramHandler.obtainMessage(1005));
      return true;
      this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    }
  }
  
  public boolean a(View paramView, String paramString, HotPicData paramHotPicData)
  {
    if (android.text.TextUtils.isEmpty(paramString)) {
      QLog.e("IphoneTitleBarActivity", 1, "AbsPublishActivity.onItemClick() filePath is empty. " + paramString);
    }
    do
    {
      return true;
      com.tencent.mobileqq.utils.ImageUtil.a(this, paramString);
      a(this.jdField_a_of_type_AndroidOsHandler, paramString);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PicUploadThread != null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PicUploadThread.jdField_a_of_type_Boolean = true;
      }
    } while (!this.jdField_f_of_type_Boolean);
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PicUploadThread = new TroopBarPublishUtils.PicUploadThread(this, null, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_f_of_type_JavaLangString);
    ThreadManager.post(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PicUploadThread, 8, null, true);
    return true;
  }
  
  public boolean a(EmoticonInfo paramEmoticonInfo)
  {
    return true;
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = TroopBarUtils.a(this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText);
    int i1;
    if (paramEditable == null)
    {
      i1 = 0;
      if ((this.jdField_f_of_type_Int <= 0) || (i1 <= this.jdField_f_of_type_Int)) {
        break label100;
      }
      if (this.jdField_c_of_type_AndroidWidgetTextView.getVisibility() != 0) {
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setText(String.valueOf(this.jdField_f_of_type_Int - i1));
    }
    for (;;)
    {
      if ((Build.DISPLAY.equals("moonlight-diyroms' ROMS")) && (this.jdField_a_of_type_ComTencentWidgetScrollView != null)) {
        this.jdField_a_of_type_ComTencentWidgetScrollView.scrollTo(0, 0);
      }
      return;
      i1 = paramEditable.length();
      break;
      label100:
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(null);
    }
  }
  
  public void b()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText != null) {
      com.tencent.mobileqq.text.TextUtils.a(this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText);
    }
  }
  
  protected void b(int paramInt)
  {
    this.jdField_i_of_type_Int = paramInt;
    if (this.jdField_i_of_type_Int == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemBar.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemBar.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemBar.a(this.jdField_i_of_type_Int);
  }
  
  public void b(EmoticonInfo paramEmoticonInfo) {}
  
  protected void b(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetImageButton.setImageResource(2130841212);
      this.jdField_a_of_type_AndroidWidgetImageButton.setContentDescription(getString(2131430341));
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void c() {}
  
  public void c(int paramInt)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDimensionPixelSize(2131558448));
    }
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(paramInt);
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(false);
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  public void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(a());
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    }
    while ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) || (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
  }
  
  protected void d()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("audio_max_length", this.jdField_h_of_type_Int);
    if (this.r != null)
    {
      localIntent.putExtra("from", "publish");
      localIntent.putExtra("bid", this.r);
      localIntent.putExtra("fromflag", this.jdField_c_of_type_JavaLangString);
    }
    PublicFragmentActivity.Launcher.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localIntent, PublicTransFragmentActivity.class, AudioRecordFragment.class, 1003);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == 0) {}
    do
    {
      do
      {
        do
        {
          return;
          switch (paramInt1)
          {
          default: 
            return;
          }
        } while (this.jdField_a_of_type_AndroidNetUri == null);
        paramIntent = com.tencent.mobileqq.utils.ImageUtil.b(this, this.jdField_a_of_type_AndroidNetUri);
        com.tencent.mobileqq.utils.ImageUtil.a(this, paramIntent);
        a(this.jdField_a_of_type_AndroidOsHandler, paramIntent);
        if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PicUploadThread != null) {
          this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PicUploadThread.jdField_a_of_type_Boolean = true;
        }
      } while (!this.jdField_f_of_type_Boolean);
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PicUploadThread = new TroopBarPublishUtils.PicUploadThread(this, null, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_f_of_type_JavaLangString);
      ThreadManager.post(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PicUploadThread, 8, null, true);
      return;
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI = ((TroopBarPOI)paramIntent.getParcelableExtra("key_selected_poi"));
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI != null)
      {
        if (android.text.TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.jdField_c_of_type_JavaLangString)) {}
        for (paramIntent = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.jdField_d_of_type_JavaLangString;; paramIntent = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.jdField_c_of_type_JavaLangString)
        {
          a(1, new String[] { paramIntent });
          return;
        }
      }
      a(0, new String[0]);
      return;
      a(2, (AudioInfo)paramIntent.getSerializableExtra("audio_info"));
    } while (this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo == null);
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$AudioUploadTask = new TroopBarPublishUtils.AudioUploadTask(this, this.jdField_a_of_type_AndroidOsHandler, "https://upload.buluo.qq.com/cgi-bin/bar/upload/meida", this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo.path);
    ThreadManager.post(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$AudioUploadTask, 5, null, true);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = this;
    this.jdField_n_of_type_Boolean = true;
    paramBundle = getIntent().getExtras();
    if (paramBundle == null)
    {
      QQToast.a(this, 1, getString(2131430309, new Object[] { Integer.valueOf(990) }), 0).b(getTitleBarHeight());
      finish();
      return false;
    }
    paramBundle = paramBundle.getString("options");
    if (QLog.isColorLevel()) {
      QLog.d("IphoneTitleBarActivity", 2, "publish option: " + paramBundle);
    }
    for (;;)
    {
      try
      {
        paramBundle = new JSONObject(paramBundle);
        this.jdField_d_of_type_Int = paramBundle.optInt("groupType", 1);
        this.jdField_g_of_type_JavaLangString = paramBundle.optString("barTitle");
        this.jdField_h_of_type_JavaLangString = paramBundle.optString("selectTitle");
        this.jdField_i_of_type_JavaLangString = paramBundle.optString("selectContent");
        this.jdField_j_of_type_JavaLangString = paramBundle.optString("selectUrl");
        this.jdField_e_of_type_Int = paramBundle.optInt("minContentLength", 10);
        this.jdField_f_of_type_Int = paramBundle.optInt("maxContentLength", 700);
        this.jdField_k_of_type_JavaLangString = paramBundle.optString("contentPlaceholder", this.jdField_k_of_type_JavaLangString);
        this.t = getString(2131430326, new Object[] { Integer.valueOf(this.jdField_f_of_type_Int) });
        this.o = paramBundle.optString("content", null);
        this.jdField_k_of_type_Boolean = paramBundle.optBoolean("photoOrContent");
        this.jdField_g_of_type_Boolean = paramBundle.optBoolean("needDestination", true);
        this.jdField_h_of_type_Boolean = paramBundle.optBoolean("needTitle", true);
        this.jdField_i_of_type_Boolean = paramBundle.optBoolean("needLocation", true);
        this.jdField_j_of_type_Boolean = paramBundle.optBoolean("needFace", true);
        this.jdField_l_of_type_Boolean = paramBundle.optBoolean("isReply", true);
        this.jdField_f_of_type_Boolean = paramBundle.optBoolean("isPreUpload", true);
        this.jdField_a_of_type_JavaLangString = paramBundle.optString("from", "");
        this.jdField_b_of_type_JavaLangString = paramBundle.optString("topicFrom", String.valueOf(2));
        this.s = paramBundle.optString("groupUin", "");
        this.jdField_g_of_type_Int = paramBundle.optInt("flag");
        if (paramBundle.optInt("recordTimeLimit") == 0)
        {
          i1 = 60000;
          this.jdField_h_of_type_Int = i1;
          if (paramBundle.optInt("requireType", 0) == 0) {
            break label616;
          }
          bool = true;
          this.jdField_m_of_type_Boolean = bool;
          if (!"barindex".equals(this.jdField_a_of_type_JavaLangString)) {
            break label621;
          }
          i1 = 1;
          this.jdField_i_of_type_Int = paramBundle.optInt("optionType", i1);
          this.jdField_m_of_type_JavaLangString = paramBundle.optString("cacheKey");
          this.jdField_j_of_type_Int = paramBundle.optInt("defaultCategory", 0);
          this.jdField_c_of_type_Int = paramBundle.optInt("maxPhotoCount", 9);
          this.jdField_k_of_type_Int = paramBundle.optInt("forbiddenType", 0);
          this.jdField_n_of_type_JavaLangString = paramBundle.optString("forbiddenMsg", getString(2131430490));
          a(paramBundle);
          if (this.jdField_j_of_type_Int == 0) {
            a();
          }
          a(paramBundle.optString("image_list", null));
          a();
          return true;
        }
      }
      catch (Exception paramBundle)
      {
        QQToast.a(this, 1, getString(2131430309, new Object[] { Integer.valueOf(999) }), 0).b(getTitleBarHeight());
        finish();
        return false;
      }
      int i1 = paramBundle.optInt("recordTimeLimit") * 1000;
      continue;
      label616:
      boolean bool = false;
      continue;
      label621:
      i1 = 0;
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.c();
    try
    {
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      if (!this.jdField_e_of_type_Boolean) {
        i();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText != null) {
        this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText.removeTextChangedListener(this);
      }
      if (this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText != null) {
        this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.removeTextChangedListener(this);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarImagePreviewAdapter != null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarImagePreviewAdapter.b();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener != null) {
        SosoInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener);
      }
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("AbsPublishActivity", 4, "unregisterReceiver(mItemDeleteReceiver) exception");
        }
      }
    }
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    if (paramIntent != null)
    {
      paramIntent = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
      if (paramIntent != null)
      {
        a(this.jdField_a_of_type_AndroidOsHandler, paramIntent);
        if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PicUploadThread != null) {
          this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PicUploadThread.jdField_a_of_type_Boolean = true;
        }
        if (this.jdField_f_of_type_Boolean) {
          break label54;
        }
      }
    }
    return;
    label54:
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PicUploadThread = new TroopBarPublishUtils.PicUploadThread(this, null, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_f_of_type_JavaLangString);
    ThreadManager.post(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PicUploadThread, 8, null, true);
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.c();
    this.jdField_n_of_type_Boolean = false;
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.c();
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1001);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1003);
    }
  }
  
  public void e()
  {
    Object localObject = a(1.0F, 0.0F);
    Animation localAnimation = a(0.0F, 1.0F);
    ((Animation)localObject).setAnimationListener(new aitj(this, localAnimation));
    localAnimation.setAnimationListener(new aitm(this));
    if (this.jdField_b_of_type_AndroidViewView.getVisibility() == 0) {
      this.jdField_b_of_type_AndroidViewView.startAnimation((Animation)localObject);
    }
    for (int i1 = this.jdField_b_of_type_AndroidViewView.getMeasuredHeight();; i1 = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.getMeasuredHeight())
    {
      int i2 = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemBar.getMeasuredHeight();
      localObject = new TranslateAnimation(0.0F, 0.0F, 0.0F, ((ViewGroup.MarginLayoutParams)this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemBar.getLayoutParams()).bottomMargin + i2 - i1);
      ((TranslateAnimation)localObject).setDuration(200L);
      ((TranslateAnimation)localObject).setFillAfter(true);
      this.jdField_c_of_type_AndroidViewView.startAnimation((Animation)localObject);
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.getVisibility() != 0);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.startAnimation((Animation)localObject);
    }
  }
  
  protected void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageButton.setImageResource(2130841212);
    this.jdField_a_of_type_AndroidWidgetImageButton.setContentDescription(getString(2131430341));
  }
  
  public void finish()
  {
    super.finish();
    if (this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText != null) {
      InputMethodUtil.b(this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText);
    }
    overridePendingTransition(0, 2131034122);
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTribeHotPicPanel == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTribeHotPicPanel = ((TribeHotPicPanel)LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).inflate(2130971644, null));
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTribeHotPicPanel.a(this.app, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this);
      this.jdField_b_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTribeHotPicPanel, -1, DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 250.0F));
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTribeHotPicPanel.f();
    TribeUtils.a("pub_page_new", "exp_gif", 0, 0, new String[] { "", "" });
  }
  
  public void h()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemBar.a(5, 0);
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTribeHotPicPanel != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTribeHotPicPanel.isShown())) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTribeHotPicPanel.a(false);
    }
  }
  
  protected void i()
  {
    int i2 = 0;
    if (this.jdField_d_of_type_Boolean) {}
    TroopBarUtils.PublishDataCacheEntity localPublishDataCacheEntity;
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("TroopBar", 2, "publish save key = " + this.jdField_m_of_type_JavaLangString);
      }
      if (!android.text.TextUtils.isEmpty(this.jdField_m_of_type_JavaLangString))
      {
        localPublishDataCacheEntity = new TroopBarUtils.PublishDataCacheEntity();
        Object localObject;
        int i1;
        if (this.jdField_a_of_type_JavaUtilArrayList != null)
        {
          localObject = new ArrayList();
          i1 = 0;
          while (i1 < this.jdField_a_of_type_JavaUtilArrayList.size())
          {
            ((ArrayList)localObject).add(this.jdField_a_of_type_JavaUtilArrayList.get(i1));
            i1 += 1;
          }
          localPublishDataCacheEntity.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)localObject);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI != null)
        {
          localPublishDataCacheEntity.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI = new TroopBarPOI(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI);
          if (this.jdField_b_of_type_JavaUtilArrayList != null)
          {
            localObject = new ArrayList();
            i1 = i2;
            while (i1 < this.jdField_b_of_type_JavaUtilArrayList.size())
            {
              ((ArrayList)localObject).add(new TroopBarPOI((TroopBarPOI)this.jdField_b_of_type_JavaUtilArrayList.get(i1)));
              i1 += 1;
            }
            localPublishDataCacheEntity.jdField_b_of_type_JavaUtilArrayList = ((ArrayList)localObject);
          }
        }
        localPublishDataCacheEntity.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
        localPublishDataCacheEntity.jdField_b_of_type_Int = this.jdField_b_of_type_Int;
        localPublishDataCacheEntity.jdField_a_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
        localPublishDataCacheEntity.jdField_c_of_type_Int = this.jdField_e_of_type_Int;
        localPublishDataCacheEntity.jdField_d_of_type_Int = this.jdField_f_of_type_Int;
        localPublishDataCacheEntity.jdField_b_of_type_JavaLangString = this.jdField_k_of_type_JavaLangString;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo != null) {}
        try
        {
          localPublishDataCacheEntity.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo = ((AudioInfo)this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo.clone());
          if ((this instanceof TroopBarPublishActivity))
          {
            localObject = (TroopBarPublishActivity)this;
            localPublishDataCacheEntity.jdField_c_of_type_JavaLangString = a(((TroopBarPublishActivity)localObject).jdField_a_of_type_ComTencentMobileqqTribeViewTribeTitlePrefixPanelView$TitlePrefixItem, ((TroopBarPublishActivity)localObject).K);
            localPublishDataCacheEntity.jdField_d_of_type_JavaLangString = this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.getEditableText().toString();
            TroopBarUtils.a.put(this.jdField_m_of_type_JavaLangString, localPublishDataCacheEntity);
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("TroopBar", 2, "publish save key = " + this.jdField_m_of_type_JavaLangString + ", data = " + localPublishDataCacheEntity);
          }
        }
        catch (CloneNotSupportedException localCloneNotSupportedException)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e("IphoneTitleBarActivity", 2, QLog.getStackTraceString(localCloneNotSupportedException));
            }
          }
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText != null) {}
    for (String str = this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText.getEditableText().toString();; str = null)
    {
      localPublishDataCacheEntity.jdField_c_of_type_JavaLangString = str;
      break;
    }
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  protected void j()
  {
    Object localObject2 = null;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemBar != null) {
      b(this.jdField_i_of_type_Int);
    }
    label124:
    Object localObject1;
    if ((this.jdField_i_of_type_Int & 0x1) == 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityExtendGridView.setNumColumns(5);
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityExtendGridView.setOnItemClickListener(this);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarImagePreviewAdapter != null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarImagePreviewAdapter.b();
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarImagePreviewAdapter = new TroopBarImagePreviewAdapter(this, this.jdField_a_of_type_ComTencentMobileqqTroopActivityExtendGridView);
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityExtendGridView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarImagePreviewAdapter);
      if (!this.jdField_j_of_type_Boolean) {
        break label416;
      }
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel = TroopBarPublishUtils.a(this, this.jdField_a_of_type_AndroidWidgetFrameLayout, this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText, this);
      this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      if (!this.jdField_i_of_type_Boolean) {
        break label428;
      }
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      label155:
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText.setHint(this.jdField_d_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText.setFilters(new InputFilter[] { new InputFilter.LengthFilter(this.jdField_b_of_type_Int), new aitx(this) });
      TEditText localTEditText;
      if (this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText.getText().length() <= 0)
      {
        localTEditText = this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText;
        if (android.text.TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) {
          break label440;
        }
        localObject1 = this.jdField_e_of_type_JavaLangString;
        label253:
        localTEditText.setText((CharSequence)localObject1);
      }
      this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.setHint(this.jdField_k_of_type_JavaLangString);
      if (this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.getText().length() <= 0)
      {
        localTEditText = this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText;
        localObject1 = localObject2;
        if (!android.text.TextUtils.isEmpty(this.jdField_l_of_type_JavaLangString)) {
          localObject1 = this.jdField_l_of_type_JavaLangString;
        }
        localTEditText.setText((CharSequence)localObject1);
      }
      if ((this.jdField_i_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI != null))
      {
        if (!android.text.TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.jdField_c_of_type_JavaLangString)) {
          break label445;
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.jdField_d_of_type_JavaLangString;
        label346:
        a(1, new String[] { localObject1 });
      }
      if (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0) {
        break label456;
      }
      a(this.jdField_a_of_type_AndroidOsHandler, this.jdField_a_of_type_JavaUtilArrayList);
      a(1);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo != null) {
        a(2, this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo);
      }
      return;
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      break;
      label416:
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
      break label124;
      label428:
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      break label155;
      label440:
      localObject1 = null;
      break label253;
      label445:
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.jdField_c_of_type_JavaLangString;
      break label346;
      label456:
      a(0);
    }
  }
  
  public abstract void k();
  
  protected void l()
  {
    switch (this.jdField_j_of_type_Int)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while ((this.jdField_i_of_type_Int & 0x2) != 2);
        d();
        return;
      } while ((this.jdField_i_of_type_Int & 0x1) != 1);
      this.jdField_a_of_type_AndroidNetUri = TroopBarPublishUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      return;
    } while ((this.jdField_i_of_type_Int & 0x1) != 1);
    TroopBarPublishUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_c_of_type_Int);
  }
  
  public void m()
  {
    if ((this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  protected boolean onBackEvent()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.getVisibility() == 0))
    {
      f();
      return true;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.c();
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    int i1 = 2;
    switch (paramView.getId())
    {
    }
    label206:
    label372:
    label379:
    do
    {
      do
      {
        return;
        this.jdField_c_of_type_Boolean = this.jdField_b_of_type_Boolean;
        paramView = new Intent(this, TroopBarPublishLocationSelectActivity.class);
        paramView.putParcelableArrayListExtra("current_location_list", this.jdField_b_of_type_JavaUtilArrayList);
        paramView.putExtra("key_selected_poi", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI);
        startActivityForResult(paramView, 1002);
        overridePendingTransition(2131034132, 2131034133);
        return;
        this.jdField_c_of_type_Boolean = this.jdField_b_of_type_Boolean;
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI = null;
        a(0, new String[0]);
        if ((this.jdField_b_of_type_AndroidWidgetTextView != null) && (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() == 0)) {
          if (!android.text.TextUtils.isEmpty(this.r)) {
            break label206;
          }
        }
        for (paramView = "0";; paramView = this.r)
        {
          ReportController.b(null, "dc00899", "pub_page_new", "", "pub_page", "del_place", i1, 0, paramView, "", "", "");
          return;
          i1 = 1;
          break;
        }
        paramView = new Intent(this, QQBrowserActivity.class);
        Object localObject = new StringBuilder().append("https://buluo.qq.com/mobile/publish_tribe.html?_wv=1027&timestamp=").append(this.jdField_b_of_type_Long).append("&optionType=");
        int i2;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer == null)
        {
          i2 = 0;
          paramView.putExtra("url", i2);
          startActivityForResult(paramView, 1004);
          if (!android.text.TextUtils.isEmpty(this.r)) {
            break label372;
          }
          paramView = "choose_tribe";
          if ((this.jdField_b_of_type_AndroidWidgetTextView == null) || (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() != 0)) {
            break label379;
          }
          if (!android.text.TextUtils.isEmpty(this.r)) {
            break label384;
          }
        }
        for (localObject = "0";; localObject = this.r)
        {
          ReportController.b(null, "dc00899", "pub_page_new", "", "pub_page", paramView, i1, 0, (String)localObject, "", "", "");
          return;
          i2 = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.a();
          break;
          paramView = "change_tribe";
          break label302;
          i1 = 1;
          break label319;
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.c();
        if ((this.jdField_d_of_type_Int == 2) && ((this instanceof TroopBarPublishActivity))) {
          TroopBarUtils.a("Grp_talk", "pub_talk", "Clk_pub", this.s, this.jdField_b_of_type_JavaLangString, "", "");
        }
        k();
        return;
      } while (System.currentTimeMillis() - this.jdField_a_of_type_Long < 500L);
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      h();
    } while (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel == null);
    label302:
    label319:
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.getVisibility() == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.setVisibility(8);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new aitn(this), 200L);
      return;
    }
    label384:
    InputMethodUtil.b(this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new aito(this), 200L);
  }
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    this.jdField_d_of_type_AndroidViewView = paramView;
    if (paramView == this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText) {
      if (paramBoolean)
      {
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() == 8) {
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        }
        if (!this.jdField_b_of_type_Boolean) {
          this.jdField_a_of_type_AndroidOsHandler.postDelayed(new aitt(this), 200L);
        }
      }
    }
    while (paramView != this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText)
    {
      return;
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    a(paramView, paramInt, paramLong);
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      return false;
      if ((this instanceof TroopBarPublishActivity))
      {
        paramView = (TroopBarPublishActivity)this;
        if ((paramView.jdField_a_of_type_ComTencentMobileqqTribeTribePostTitlePrefixPanelController != null) && (paramView.jdField_a_of_type_ComTencentMobileqqTribeTribePostTitlePrefixPanelController.a()))
        {
          paramView.jdField_a_of_type_ComTencentMobileqqTribeTribePostTitlePrefixPanelController.b();
          paramView.e(true);
          return true;
        }
      }
      if ((1 == paramMotionEvent.getAction()) && (!this.jdField_b_of_type_Boolean) && (((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.getVisibility() == 0)) || ((this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTribeHotPicPanel != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTribeHotPicPanel.isShown()))))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel != null) {
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.setVisibility(8);
        }
        h();
        return false;
        if ((this instanceof TroopBarPublishActivity))
        {
          paramView = (TroopBarPublishActivity)this;
          if ((paramView.jdField_a_of_type_ComTencentMobileqqTribeTribePostTitlePrefixPanelController != null) && (paramView.jdField_a_of_type_ComTencentMobileqqTribeTribePostTitlePrefixPanelController.a()))
          {
            paramView.jdField_a_of_type_ComTencentMobileqqTribeTribePostTitlePrefixPanelController.b();
            paramView.e(true);
            return true;
          }
        }
        if ((paramMotionEvent.getAction() == 2) && (this.jdField_b_of_type_Boolean))
        {
          if ((this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText != null) && (this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText.hasFocus())) {
            InputMethodUtil.b(this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText);
          }
          if (this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText != null) {
            InputMethodUtil.b(this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText);
          }
        }
      }
    }
  }
  
  public void setting() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.AbsPublishActivity
 * JD-Core Version:    0.7.0.1
 */