package com.tencent.mobileqq.portal;

import agmf;
import agmg;
import agmh;
import agmi;
import agmj;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.nineoldandroids.animation.ValueAnimator;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FormalView
  extends RelativeLayout
  implements Handler.Callback
{
  private static final int[] jdField_a_of_type_ArrayOfInt = new int[0];
  public int a;
  public long a;
  private Context jdField_a_of_type_AndroidContentContext;
  private AnimationDrawable jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View jdField_a_of_type_AndroidViewView;
  private AnimationSet jdField_a_of_type_AndroidViewAnimationAnimationSet;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  ValueAnimator jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator = null;
  private FlakeView jdField_a_of_type_ComTencentMobileqqPortalFlakeView;
  public HongbaoCaidanRainView a;
  private ImageAlphaSwitchView jdField_a_of_type_ComTencentMobileqqPortalImageAlphaSwitchView;
  private ImageShakeAnimView jdField_a_of_type_ComTencentMobileqqPortalImageShakeAnimView;
  private ImageSwitchAnimView jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnimView;
  private PortalManager jdField_a_of_type_ComTencentMobileqqPortalPortalManager;
  private ProgressViewYellow jdField_a_of_type_ComTencentMobileqqPortalProgressViewYellow;
  private StrokeTextView jdField_a_of_type_ComTencentMobileqqPortalStrokeTextView;
  private String jdField_a_of_type_JavaLangString = "";
  public List a;
  public Map a;
  public boolean a;
  private int jdField_b_of_type_Int = -1;
  public long b;
  private View jdField_b_of_type_AndroidViewView;
  private AnimationSet jdField_b_of_type_AndroidViewAnimationAnimationSet;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private StrokeTextView jdField_b_of_type_ComTencentMobileqqPortalStrokeTextView;
  public List b;
  public boolean b;
  private int jdField_c_of_type_Int = -1;
  private long jdField_c_of_type_Long;
  private View jdField_c_of_type_AndroidViewView;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private StrokeTextView jdField_c_of_type_ComTencentMobileqqPortalStrokeTextView;
  public List c;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = -1;
  private long jdField_d_of_type_Long;
  private View jdField_d_of_type_AndroidViewView;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private StrokeTextView jdField_d_of_type_ComTencentMobileqqPortalStrokeTextView;
  private ImageView jdField_e_of_type_AndroidWidgetImageView;
  private StrokeTextView jdField_e_of_type_ComTencentMobileqqPortalStrokeTextView;
  private ImageView jdField_f_of_type_AndroidWidgetImageView;
  private StrokeTextView jdField_f_of_type_ComTencentMobileqqPortalStrokeTextView;
  private ImageView g;
  private ImageView h;
  
  public FormalView(Context paramContext)
  {
    super(paramContext);
    this.jdField_c_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    LayoutInflater.from(paramContext).inflate(2130970358, this, true);
    paramContext = Typeface.createFromAsset(this.jdField_a_of_type_AndroidContentContext.getAssets(), "fonts/HuNan-CC.ttf");
    this.jdField_d_of_type_ComTencentMobileqqPortalStrokeTextView = ((StrokeTextView)findViewById(2131370210));
    this.jdField_d_of_type_ComTencentMobileqqPortalStrokeTextView.setTypeface(paramContext);
    this.jdField_d_of_type_ComTencentMobileqqPortalStrokeTextView.setInnerTextColor(-13490398);
    this.jdField_d_of_type_ComTencentMobileqqPortalStrokeTextView.setStrokeColor(-1);
    this.jdField_d_of_type_ComTencentMobileqqPortalStrokeTextView.setStrokeSize(AIOUtils.a(4.0F, getResources()));
    this.jdField_d_of_type_ComTencentMobileqqPortalStrokeTextView.setStrokeEnable(true);
    this.jdField_d_of_type_ComTencentMobileqqPortalStrokeTextView.setShadow(AIOUtils.a(2.0F, getResources()), 0.0F, AIOUtils.a(1.0F, getResources()), 1073741824);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131370208));
    this.jdField_e_of_type_ComTencentMobileqqPortalStrokeTextView = ((StrokeTextView)findViewById(2131370212));
    this.jdField_e_of_type_ComTencentMobileqqPortalStrokeTextView.setTypeface(paramContext);
    this.jdField_e_of_type_ComTencentMobileqqPortalStrokeTextView.setInnerTextColor(-13490398);
    this.jdField_e_of_type_ComTencentMobileqqPortalStrokeTextView.setStrokeColor(-1);
    this.jdField_e_of_type_ComTencentMobileqqPortalStrokeTextView.setStrokeSize(AIOUtils.a(4.0F, getResources()));
    this.jdField_e_of_type_ComTencentMobileqqPortalStrokeTextView.setStrokeEnable(true);
    this.jdField_e_of_type_ComTencentMobileqqPortalStrokeTextView.setShadowLayer(AIOUtils.a(2.0F, getResources()), 0.0F, AIOUtils.a(1.0F, getResources()), 1711276032);
    this.jdField_a_of_type_ComTencentMobileqqPortalStrokeTextView = ((StrokeTextView)findViewById(2131370211));
    this.jdField_a_of_type_ComTencentMobileqqPortalStrokeTextView.setInnerTextColor(-6413557);
    this.jdField_a_of_type_ComTencentMobileqqPortalStrokeTextView.setStrokeEnable(false);
    this.jdField_a_of_type_ComTencentMobileqqPortalStrokeTextView.setShadow(AIOUtils.a(4.0F, getResources()), 0.0F, 0.0F, -135991);
    this.jdField_a_of_type_ComTencentMobileqqPortalStrokeTextView.setTypeface(Typeface.defaultFromStyle(1));
    this.jdField_f_of_type_ComTencentMobileqqPortalStrokeTextView = ((StrokeTextView)findViewById(2131370213));
    this.jdField_f_of_type_ComTencentMobileqqPortalStrokeTextView.setInnerTextColor(-6413557);
    this.jdField_f_of_type_ComTencentMobileqqPortalStrokeTextView.setStrokeEnable(false);
    this.jdField_f_of_type_ComTencentMobileqqPortalStrokeTextView.setShadow(AIOUtils.a(4.0F, getResources()), 0.0F, 0.0F, -135991);
    this.jdField_f_of_type_ComTencentMobileqqPortalStrokeTextView.setTypeface(Typeface.defaultFromStyle(1));
    this.jdField_f_of_type_ComTencentMobileqqPortalStrokeTextView.setText("连刷更容易得红包！");
    this.jdField_b_of_type_ComTencentMobileqqPortalStrokeTextView = ((StrokeTextView)findViewById(2131370206));
    this.jdField_b_of_type_ComTencentMobileqqPortalStrokeTextView.setInnerTextColor(Color.parseColor("#9E230B"));
    this.jdField_b_of_type_ComTencentMobileqqPortalStrokeTextView.setStrokeColor(Color.parseColor("#FBEACD"));
    this.jdField_b_of_type_ComTencentMobileqqPortalStrokeTextView.setStrokeSize(AIOUtils.a(2.0F, getResources()));
    this.jdField_b_of_type_ComTencentMobileqqPortalStrokeTextView.setTextSize(1, 24.0F);
    this.jdField_b_of_type_ComTencentMobileqqPortalStrokeTextView.setStrokeEnable(true);
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131370214));
    this.jdField_c_of_type_ComTencentMobileqqPortalStrokeTextView = ((StrokeTextView)findViewById(2131370207));
    this.jdField_c_of_type_ComTencentMobileqqPortalStrokeTextView.setInnerTextColor(Color.parseColor("#9E230B"));
    this.jdField_c_of_type_ComTencentMobileqqPortalStrokeTextView.setStrokeColor(Color.parseColor("#FBEACD"));
    this.jdField_c_of_type_ComTencentMobileqqPortalStrokeTextView.setStrokeSize(AIOUtils.a(2.0F, getResources()));
    this.jdField_c_of_type_ComTencentMobileqqPortalStrokeTextView.setStrokeEnable(true);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131370209));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131370196));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131370195);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370194));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370197));
    paramContext = Typeface.createFromAsset(this.jdField_a_of_type_AndroidContentContext.getAssets(), "fonts/DS-DIGIB.TTF");
    this.jdField_a_of_type_AndroidWidgetTextView.setTypeface(paramContext);
    this.jdField_a_of_type_AndroidWidgetTextView.setGravity(17);
    this.jdField_c_of_type_Int = AIOUtils.a(70.0F, getResources());
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131370192));
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131370193));
    this.jdField_d_of_type_Int = getResources().getDimensionPixelSize(2131559601);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131370201);
    this.jdField_a_of_type_ComTencentMobileqqPortalProgressViewYellow = ((ProgressViewYellow)findViewById(2131363562));
    this.jdField_a_of_type_ComTencentMobileqqPortalImageAlphaSwitchView = ((ImageAlphaSwitchView)findViewById(2131370205));
    this.jdField_a_of_type_ComTencentMobileqqPortalImageAlphaSwitchView.setGravity(17);
    this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131370204));
    this.jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnimView = ((ImageSwitchAnimView)findViewById(2131370203));
    this.jdField_c_of_type_AndroidViewView = findViewById(2131370202);
    this.jdField_d_of_type_AndroidViewView = findViewById(2131370198);
    this.g = ((ImageView)findViewById(2131370199));
    this.h = ((ImageView)findViewById(2131370200));
    int i = AIOUtils.a(342.0F, getResources());
    AIOUtils.a(164.0F, getResources());
    this.jdField_b_of_type_Int = AIOUtils.a(40.0F, getResources());
    paramContext = new RelativeLayout.LayoutParams(i, AIOUtils.a(180.0F, getResources()));
    paramContext.addRule(14);
    paramContext.topMargin = (-this.jdField_b_of_type_Int);
    addView(this.jdField_a_of_type_ComTencentMobileqqPortalImageShakeAnimView, 0, paramContext);
    this.jdField_a_of_type_ComTencentMobileqqPortalFlakeView = new FlakeView(this.jdField_a_of_type_AndroidContentContext, false);
    addView(this.jdField_a_of_type_ComTencentMobileqqPortalFlakeView, 0, new RelativeLayout.LayoutParams(-1, -1));
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager = ((PortalManager)((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app.getManager(78));
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable == null)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable = new AnimationDrawable();
      int i = 0;
      try
      {
        while (i < jdField_a_of_type_ArrayOfInt.length)
        {
          this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.addFrame(getResources().getDrawable(jdField_a_of_type_ArrayOfInt[i]), 30);
          i += 1;
        }
        this.jdField_d_of_type_ComTencentMobileqqPortalStrokeTextView.clearAnimation();
      }
      catch (Throwable localThrowable)
      {
        this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.setOneShot(false);
        this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable);
        this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.start();
      }
    }
    this.jdField_d_of_type_ComTencentMobileqqPortalStrokeTextView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetImageView.clearAnimation();
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqPortalFlakeView.a();
    b(false);
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(4);
    this.jdField_d_of_type_ComTencentMobileqqPortalStrokeTextView.clearAnimation();
    this.jdField_d_of_type_ComTencentMobileqqPortalStrokeTextView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetImageView.clearAnimation();
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqPortalStrokeTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    if (this.jdField_a_of_type_Int != 1) {
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
    }
    a();
    this.jdField_b_of_type_ComTencentMobileqqPortalStrokeTextView.setVisibility(0);
    this.jdField_b_of_type_ComTencentMobileqqPortalStrokeTextView.setTextSize(1, 24.0F);
    if (!TextUtils.isEmpty(paramString2)) {
      if (paramInt <= 0)
      {
        this.jdField_b_of_type_ComTencentMobileqqPortalStrokeTextView.setText("本轮活动已结束");
        this.jdField_c_of_type_ComTencentMobileqqPortalStrokeTextView.setVisibility(0);
        this.jdField_c_of_type_ComTencentMobileqqPortalStrokeTextView.setText("下轮时间：" + paramString2);
      }
    }
    for (;;)
    {
      f();
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      if (this.jdField_a_of_type_Int == 1) {
        this.jdField_d_of_type_AndroidViewView.setVisibility(0);
      }
      this.jdField_a_of_type_ComTencentMobileqqPortalProgressViewYellow.a(0L, 1L);
      paramString1 = (ViewGroup.MarginLayoutParams)this.jdField_c_of_type_AndroidViewView.getLayoutParams();
      paramString1.leftMargin = (getResources().getDisplayMetrics().widthPixels - AIOUtils.a(81.0F, getResources()));
      this.jdField_c_of_type_AndroidViewView.setLayoutParams(paramString1);
      this.jdField_b_of_type_Boolean = false;
      return;
      this.jdField_b_of_type_ComTencentMobileqqPortalStrokeTextView.setText("本轮共刷" + paramInt + "次");
      break;
      if (paramInt <= 0)
      {
        this.jdField_b_of_type_ComTencentMobileqqPortalStrokeTextView.setText(paramString1);
        this.jdField_c_of_type_ComTencentMobileqqPortalStrokeTextView.setVisibility(4);
      }
      else
      {
        this.jdField_b_of_type_ComTencentMobileqqPortalStrokeTextView.setText("本轮共刷" + paramInt + "次");
        this.jdField_c_of_type_ComTencentMobileqqPortalStrokeTextView.setVisibility(0);
        this.jdField_c_of_type_ComTencentMobileqqPortalStrokeTextView.setText(paramString1);
      }
    }
  }
  
  public void a(int paramInt, String paramString, boolean paramBoolean)
  {
    long l = System.currentTimeMillis();
    if (l - this.jdField_b_of_type_Long <= 500L) {
      if (QLog.isColorLevel()) {
        QLog.d("FormalView", 2, "combo, no network last time = " + this.jdField_b_of_type_Long);
      }
    }
    do
    {
      return;
      this.jdField_b_of_type_ComTencentMobileqqPortalStrokeTextView.setVisibility(8);
      this.jdField_c_of_type_ComTencentMobileqqPortalStrokeTextView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      b(false);
      if (l - this.jdField_c_of_type_Long > 600L)
      {
        this.jdField_c_of_type_Long = l;
        this.jdField_a_of_type_ComTencentMobileqqPortalImageShakeAnimView.a();
      }
    } while (System.currentTimeMillis() - this.jdField_d_of_type_Long < 500L);
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if (this.jdField_a_of_type_AndroidViewAnimationAnimationSet == null)
    {
      this.jdField_a_of_type_AndroidViewAnimationAnimationSet = new AnimationSet(true);
      localObject1 = new AlphaAnimation(0.0F, 1.0F);
      localObject2 = new ScaleAnimation(2.4F, 1.0F, 2.4F, 1.0F, 1, 0.5F, 1, 0.5F);
      localObject3 = new OvershootInterpolator(1.0F);
      this.jdField_a_of_type_AndroidViewAnimationAnimationSet.setInterpolator((Interpolator)localObject3);
      this.jdField_a_of_type_AndroidViewAnimationAnimationSet.addAnimation((Animation)localObject1);
      this.jdField_a_of_type_AndroidViewAnimationAnimationSet.addAnimation((Animation)localObject2);
      this.jdField_a_of_type_AndroidViewAnimationAnimationSet.setDuration(400L);
      this.jdField_a_of_type_AndroidViewAnimationAnimationSet.setFillAfter(true);
    }
    this.jdField_a_of_type_AndroidViewAnimationAnimationSet.reset();
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_c_of_type_Boolean = false;
    if (this.jdField_c_of_type_JavaUtilList.contains(Integer.valueOf(paramInt)))
    {
      this.jdField_c_of_type_Boolean = true;
      this.jdField_d_of_type_ComTencentMobileqqPortalStrokeTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqPortalStrokeTextView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      localObject1 = (PortalManager.ComboNumber)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
      if (localObject1 == null)
      {
        this.jdField_c_of_type_Boolean = false;
        QLog.d("FormalView", 1, "combo, get CN from map return null, combo=" + paramInt);
      }
    }
    else
    {
      if (this.jdField_c_of_type_Boolean) {
        break label836;
      }
      this.jdField_c_of_type_Boolean = false;
      this.jdField_d_of_type_ComTencentMobileqqPortalStrokeTextView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqPortalStrokeTextView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      if (paramInt != 1) {
        break label770;
      }
      this.jdField_d_of_type_ComTencentMobileqqPortalStrokeTextView.setText("继续刷");
      label433:
      this.jdField_c_of_type_AndroidWidgetImageView.clearAnimation();
      this.jdField_d_of_type_ComTencentMobileqqPortalStrokeTextView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimationSet);
      label451:
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentMobileqqPortalStrokeTextView.setText(paramString);
      }
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      paramString = this.jdField_a_of_type_AndroidOsHandler;
      if (!this.jdField_c_of_type_Boolean) {
        break label890;
      }
    }
    label770:
    label836:
    label890:
    for (l = 2000L;; l = 800L)
    {
      paramString.sendEmptyMessageDelayed(1, l);
      this.jdField_b_of_type_Boolean = true;
      return;
      localObject2 = PortalManager.a(((PortalManager.ComboNumber)localObject1).numberImageMD5, null);
      if (localObject2 == null)
      {
        this.jdField_c_of_type_Boolean = false;
        QLog.d("FormalView", 1, "combo, get bmp from PM return null, combo=" + paramInt);
      }
      for (;;)
      {
        localObject2 = BaseApplicationImpl.getApplication().getFilesDir() + PortalManager.jdField_a_of_type_JavaLangString + ((PortalManager.ComboNumber)localObject1).flowerImageMD5;
        localObject3 = BaseApplicationImpl.getApplication().getFilesDir() + PortalManager.jdField_a_of_type_JavaLangString + ((PortalManager.ComboNumber)localObject1).flowerImage2MD5;
        this.jdField_a_of_type_ComTencentMobileqqPortalFlakeView.a(30, new String[] { localObject2, localObject3 });
        if (this.jdField_a_of_type_ComTencentMobileqqPortalHongbaoCaidanRainView != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqPortalHongbaoCaidanRainView.a(new String[] { localObject2, localObject3 });
          this.jdField_a_of_type_ComTencentMobileqqPortalFlakeView.setShowFullScreenCaidan(l, 2000L);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager != null) {
          this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager.b(3);
        }
        ReportController.b(((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app, "dc01440", "", "", "0X80078A9", "0X80078A9", 0, 0, ((PortalManager.ComboNumber)localObject1).number + "", "", "", "");
        break;
        this.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject2);
      }
      if (paramInt < 10)
      {
        this.jdField_d_of_type_ComTencentMobileqqPortalStrokeTextView.setText(paramInt + "连刷");
        break label433;
      }
      this.jdField_d_of_type_ComTencentMobileqqPortalStrokeTextView.setText("x" + paramInt);
      break label433;
      this.jdField_d_of_type_ComTencentMobileqqPortalStrokeTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqPortalStrokeTextView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_d_of_type_ComTencentMobileqqPortalStrokeTextView.clearAnimation();
      this.jdField_c_of_type_AndroidWidgetImageView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimationSet);
      this.jdField_d_of_type_Long = System.currentTimeMillis();
      break label451;
    }
  }
  
  public void a(long paramLong1, long paramLong2, CharSequence paramCharSequence)
  {
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqPortalProgressViewYellow.a(paramLong1, paramLong2);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    if (this.jdField_a_of_type_Int == 1) {
      this.jdField_d_of_type_AndroidViewView.setVisibility(0);
    }
    String str = paramCharSequence.toString();
    if (!this.jdField_a_of_type_JavaLangString.equals(str))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramCharSequence);
      this.jdField_a_of_type_JavaLangString = str;
    }
    int i = getResources().getDisplayMetrics().widthPixels;
    int j = AIOUtils.a(81.0F, getResources());
    paramCharSequence = (ViewGroup.MarginLayoutParams)this.jdField_c_of_type_AndroidViewView.getLayoutParams();
    paramCharSequence.leftMargin = ((int)((i - j) * (paramLong2 - paramLong1) / paramLong2));
    this.jdField_c_of_type_AndroidViewView.setLayoutParams(paramCharSequence);
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPortalHongbaoCaidanRainView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqPortalHongbaoCaidanRainView = new HongbaoCaidanRainView(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_ComTencentMobileqqPortalHongbaoCaidanRainView.setId(2131362346);
      this.jdField_a_of_type_ComTencentMobileqqPortalHongbaoCaidanRainView.setClickable(false);
      this.jdField_a_of_type_ComTencentMobileqqPortalHongbaoCaidanRainView.a(getResources().getDisplayMetrics().widthPixels, AIOUtils.a(40.0F, getResources()), 0.5F, 150.0F, AIOUtils.a(250.0F, getResources()), AIOUtils.a(3.0F, getResources()), AIOUtils.a(150.0F, getResources()), getResources().getDisplayMetrics().heightPixels);
    }
    Object localObject1 = paramViewGroup;
    if (((ViewGroup)localObject1).getId() == 2131364934) {
      localObject2 = localObject1;
    }
    label130:
    do
    {
      paramViewGroup = ((ViewGroup)localObject2).findViewById(2131362346);
      if (paramViewGroup != null) {
        ((ViewGroup)localObject2).removeView(paramViewGroup);
      }
      ((ViewGroup)localObject2).addView(this.jdField_a_of_type_ComTencentMobileqqPortalHongbaoCaidanRainView, new RelativeLayout.LayoutParams(getResources().getDisplayMetrics().widthPixels, getResources().getDisplayMetrics().heightPixels));
      return;
      localObject2 = paramViewGroup;
    } while (((ViewGroup)localObject1).getId() == 16908306);
    if (((ViewGroup)localObject1).getParent() != null) {}
    for (Object localObject2 = (ViewGroup)((ViewGroup)localObject1).getParent();; localObject2 = null)
    {
      localObject1 = localObject2;
      if (localObject2 != null) {
        break;
      }
      localObject2 = paramViewGroup;
      break label130;
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FormalView", 2, "showResult, msg=" + paramString);
    }
    if ((!"网络不给力，请检查网络是否可用！".equals(paramString)) && (System.currentTimeMillis() - this.jdField_d_of_type_Long < 500L)) {
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqPortalStrokeTextView.setVisibility(8);
    this.jdField_c_of_type_ComTencentMobileqqPortalStrokeTextView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_d_of_type_ComTencentMobileqqPortalStrokeTextView.clearAnimation();
    this.jdField_d_of_type_ComTencentMobileqqPortalStrokeTextView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetImageView.clearAnimation();
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    if ("网络不给力，请检查网络是否可用！".equals(paramString))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqPortalStrokeTextView.setVisibility(8);
      this.jdField_b_of_type_ComTencentMobileqqPortalStrokeTextView.setVisibility(0);
      this.jdField_b_of_type_ComTencentMobileqqPortalStrokeTextView.setTextSize(1, 21.0F);
      this.jdField_b_of_type_ComTencentMobileqqPortalStrokeTextView.setText(paramString);
      this.jdField_b_of_type_Long = System.currentTimeMillis();
    }
    for (;;)
    {
      this.jdField_b_of_type_Boolean = false;
      b(false);
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqPortalStrokeTextView.setVisibility(0);
      this.jdField_b_of_type_ComTencentMobileqqPortalStrokeTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqPortalStrokeTextView.setText(paramString);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqPortalFlakeView.a(paramBoolean);
  }
  
  public void b()
  {
    this.jdField_b_of_type_ComTencentMobileqqPortalStrokeTextView.setVisibility(8);
    this.jdField_c_of_type_ComTencentMobileqqPortalStrokeTextView.setVisibility(8);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(4);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_d_of_type_AndroidViewView.setVisibility(8);
    e();
  }
  
  public void b(boolean paramBoolean)
  {
    if ((paramBoolean) && (QLog.isColorLevel())) {
      QLog.d("FormalView", 2, "readyGo, show=" + paramBoolean);
    }
    View localView = findViewById(2131370212);
    if (paramBoolean)
    {
      if (this.jdField_b_of_type_AndroidViewAnimationAnimationSet == null)
      {
        AnimationSet localAnimationSet = new AnimationSet(true);
        AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
        ScaleAnimation localScaleAnimation = new ScaleAnimation(1.8F, 1.0F, 1.85F, 1.0F, 1, 0.5F, 1, 0.5F);
        localAnimationSet.setInterpolator(new OvershootInterpolator(1.0F));
        localAnimationSet.addAnimation(localAlphaAnimation);
        localAnimationSet.addAnimation(localScaleAnimation);
        localAnimationSet.setDuration(400L);
        localAnimationSet.setFillAfter(true);
        localAnimationSet.setAnimationListener(new agmf(this, localView));
        this.jdField_b_of_type_AndroidViewAnimationAnimationSet = localAnimationSet;
      }
      localView.startAnimation(this.jdField_b_of_type_AndroidViewAnimationAnimationSet);
    }
    do
    {
      return;
      localView.clearAnimation();
      localView.setVisibility(8);
    } while (this.jdField_f_of_type_ComTencentMobileqqPortalStrokeTextView == null);
    this.jdField_f_of_type_ComTencentMobileqqPortalStrokeTextView.setVisibility(8);
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqPortalFlakeView.b();
  }
  
  @TargetApi(11)
  public void d()
  {
    this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator = ValueAnimator.ofInt(new int[] { 0, 1000 });
    this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.addUpdateListener(new agmg(this));
    this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.addListener(new agmh(this));
    this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.setDuration(300L);
    this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
    this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.start();
  }
  
  public void e()
  {
    this.jdField_a_of_type_Boolean = false;
    ((RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqPortalImageShakeAnimView.getLayoutParams()).topMargin = (-this.jdField_b_of_type_Int);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidWidgetImageView.getLayoutParams();
    localLayoutParams.leftMargin = 0;
    this.jdField_d_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
    localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_e_of_type_AndroidWidgetImageView.getLayoutParams();
    localLayoutParams.rightMargin = 0;
    this.jdField_e_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
    localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams();
    localLayoutParams.topMargin = this.jdField_d_of_type_Int;
    this.jdField_b_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
  }
  
  public void f()
  {
    this.jdField_a_of_type_Boolean = true;
    ((RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqPortalImageShakeAnimView.getLayoutParams()).topMargin = 0;
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidWidgetImageView.getLayoutParams();
    localLayoutParams.leftMargin = (-this.jdField_c_of_type_Int);
    this.jdField_d_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
    localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_e_of_type_AndroidWidgetImageView.getLayoutParams();
    localLayoutParams.rightMargin = (-this.jdField_c_of_type_Int);
    this.jdField_e_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
    localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams();
    localLayoutParams.topMargin = 0;
    this.jdField_b_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator != null) {}
    try
    {
      if (this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.isRunning()) {
        this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.cancel();
      }
      this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      localThrowable.printStackTrace();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      if (this.jdField_b_of_type_Boolean) {
        h();
      }
    }
  }
  
  public void setBackground(Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    if ((paramBitmap1 == null) || (paramBitmap2 != null))
    {
      paramBitmap1 = getBackground();
      if ((paramBitmap1 == null) || (!(paramBitmap1 instanceof BitmapDrawable)) || (((BitmapDrawable)paramBitmap1).getBitmap() != paramBitmap2)) {}
    }
    else
    {
      return;
    }
    super.setBackgroundDrawable(new BitmapDrawable(getResources(), paramBitmap2));
  }
  
  public void setCloudBmp(Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    if ((paramBitmap1 == null) || (paramBitmap2 == null))
    {
      QLog.d("PortalManager", 1, "FormalView setCloudBmp, left or right is null");
      return;
    }
    this.jdField_d_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap1);
    this.jdField_e_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap2);
  }
  
  public void setComboNumberList(List paramList)
  {
    this.jdField_b_of_type_JavaUtilList = paramList;
    this.jdField_c_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilMap.clear();
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    Collections.sort(paramList, new agmj(null));
    int i = 0;
    while (i < paramList.size())
    {
      PortalManager.ComboNumber localComboNumber = (PortalManager.ComboNumber)paramList.get(i);
      if (localComboNumber != null)
      {
        this.jdField_c_of_type_JavaUtilList.add(Integer.valueOf(localComboNumber.number));
        this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(localComboNumber.number), localComboNumber);
        if (QLog.isColorLevel()) {
          QLog.d("FormalView", 2, "setComboNumberList, index=" + i + ", p=" + localComboNumber.toString());
        }
      }
      i += 1;
    }
    ThreadManager.postImmediately(new agmi(this, paramList), null, true);
  }
  
  public void setHBSpeed(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqPortalFlakeView.setHonhBaoSpeed(paramInt);
  }
  
  public void setLogoConfigList(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    if ((paramList != null) && (QLog.isColorLevel()))
    {
      int i = 0;
      while (i < paramList.size())
      {
        PortalManager.LogoConfig localLogoConfig = (PortalManager.LogoConfig)paramList.get(i);
        if (localLogoConfig != null) {
          QLog.d("FormalView", 2, "setLogoConfigList, index=" + i + ", p=" + localLogoConfig.toString());
        }
        i += 1;
      }
    }
  }
  
  public void setProgressLogo(Bitmap paramBitmap, boolean paramBoolean)
  {
    Bitmap localBitmap = null;
    if (QLog.isColorLevel()) {
      QLog.d("FormalView", 2, "setProgressLogo, bmp=" + paramBitmap + ", needSwitch=" + paramBoolean);
    }
    if (paramBitmap != null)
    {
      if (this.jdField_a_of_type_Int == 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnimView.setLogo(paramBitmap);
        return;
      }
      if (paramBoolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnimView.a(paramBitmap);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnimView.setLogo(paramBitmap);
      return;
    }
    if (this.jdField_a_of_type_Int == 1) {
      paramBitmap = getResources().getDrawable(2130842637);
    }
    for (;;)
    {
      if ((paramBitmap instanceof SkinnableBitmapDrawable)) {
        localBitmap = ((SkinnableBitmapDrawable)paramBitmap).getBitmap();
      }
      for (;;)
      {
        if (localBitmap == null) {
          break label189;
        }
        if (this.jdField_a_of_type_Int != 1) {
          break label191;
        }
        this.jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnimView.setLogo(localBitmap);
        return;
        if ((this.jdField_a_of_type_Int != 2) && (this.jdField_a_of_type_Int != 3)) {
          break label213;
        }
        paramBitmap = getResources().getDrawable(2130842585);
        break;
        if ((paramBitmap instanceof BitmapDrawable)) {
          localBitmap = ((BitmapDrawable)paramBitmap).getBitmap();
        }
      }
      label189:
      break;
      label191:
      if (paramBoolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnimView.a(localBitmap);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnimView.setLogo(localBitmap);
      return;
      label213:
      paramBitmap = null;
    }
  }
  
  public void setProgressNameBitmap(Bitmap paramBitmap1, Bitmap paramBitmap2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FormalView", 2, "setProgressNameBitmap, name=" + paramBitmap1 + ", bg=" + paramBitmap2 + ", needSwitch=" + paramBoolean);
    }
    if (paramBitmap1 == null) {
      return;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqPortalImageAlphaSwitchView.a(paramBitmap1);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqPortalImageAlphaSwitchView.setImage(paramBitmap1);
  }
  
  public void setSmallIcon(Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FormalView", 2, "setSmallIcon, icon=" + paramBitmap1 + ", name=" + paramBitmap2 + ", mode=" + this.jdField_a_of_type_Int);
    }
    this.h.setImageBitmap(paramBitmap2);
    this.g.setImageBitmap(paramBitmap1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.portal.FormalView
 * JD-Core Version:    0.7.0.1
 */