package com.tencent.mobileqq.activity.aio.item;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.immersion.stickersampleapp.HapticManager;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.PokeBigResHandler;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.FitSystemWindowsRelativeLayout;
import mqq.util.WeakReference;
import vky;
import vkz;
import vla;
import vlb;
import vlc;
import vld;
import vle;
import vlf;
import vlh;

public class UnlimitedBladeWorks
  extends RelativeLayout
  implements GreatMoveCombolEffectView.GreateMoveListener
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private CustomFrameAnimationDrawable jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable;
  private UnlimitedBladeWorks.UnlimitedState jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks$UnlimitedState;
  private MessageForPoke jdField_a_of_type_ComTencentMobileqqDataMessageForPoke;
  private String jdField_a_of_type_JavaLangString = "chat_item_for_qqultnew";
  private WeakReference jdField_a_of_type_MqqUtilWeakReference;
  private vlf jdField_a_of_type_Vlf;
  private vlh jdField_a_of_type_Vlh;
  private boolean jdField_a_of_type_Boolean;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private CustomFrameAnimationDrawable jdField_b_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable;
  private boolean jdField_b_of_type_Boolean;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private boolean jdField_c_of_type_Boolean;
  
  public UnlimitedBladeWorks(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public UnlimitedBladeWorks(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public UnlimitedBladeWorks(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    LayoutInflater.from(paramContext).inflate(2130971704, this, true);
  }
  
  private AnimationSet a(int paramInt)
  {
    int i = 0;
    AnimationSet localAnimationSet = new AnimationSet(false);
    long l = 0L;
    int[] arrayOfInt = new int[8];
    int[] tmp23_21 = arrayOfInt;
    tmp23_21[0] = 80;
    int[] tmp28_23 = tmp23_21;
    tmp28_23[1] = 120;
    int[] tmp33_28 = tmp28_23;
    tmp33_28[2] = 120;
    int[] tmp38_33 = tmp33_28;
    tmp38_33[3] = 120;
    int[] tmp43_38 = tmp38_33;
    tmp43_38[4] = 120;
    int[] tmp48_43 = tmp43_38;
    tmp48_43[5] = 80;
    int[] tmp53_48 = tmp48_43;
    tmp53_48[6] = 80;
    int[] tmp59_53 = tmp53_48;
    tmp59_53[7] = 80;
    tmp59_53;
    int j = arrayOfInt.length;
    while (i < j)
    {
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, AIOUtils.a(new int[] { paramInt * 5, paramInt * -12, paramInt * 15, paramInt * -15, paramInt * 12, paramInt * -8, paramInt * 6, paramInt * 0 }[i], getResources()), 0.0F, AIOUtils.a(new int[] { paramInt * 1, paramInt * -3, paramInt * 2, paramInt * -2, paramInt * 1, paramInt * -1, paramInt * 1, paramInt * 0 }[i], getResources()));
      localTranslateAnimation.setDuration(arrayOfInt[i]);
      localTranslateAnimation.setStartOffset(l);
      localAnimationSet.addAnimation(localTranslateAnimation);
      l += arrayOfInt[i];
      i += 1;
    }
    return localAnimationSet;
  }
  
  @TargetApi(17)
  private void a(int paramInt)
  {
    if ((this.jdField_a_of_type_MqqUtilWeakReference != null) && (this.jdField_a_of_type_MqqUtilWeakReference.get() != null))
    {
      Activity localActivity = (Activity)this.jdField_a_of_type_MqqUtilWeakReference.get();
      localActivity.runOnUiThread(new vld(this, localActivity, paramInt));
    }
  }
  
  @TargetApi(17)
  private void d()
  {
    if ((this.jdField_a_of_type_MqqUtilWeakReference != null) && (this.jdField_a_of_type_MqqUtilWeakReference.get() != null))
    {
      Activity localActivity = (Activity)this.jdField_a_of_type_MqqUtilWeakReference.get();
      localActivity.runOnUiThread(new vle(this, localActivity));
    }
  }
  
  private void e()
  {
    int[] arrayOfInt = new int[2];
    this.jdField_b_of_type_AndroidWidgetImageView.getLocationOnScreen(arrayOfInt);
    int i = arrayOfInt[0];
    int j = arrayOfInt[1];
    PokeItemAnimationManager.a().a(10);
    if ((this.jdField_a_of_type_MqqUtilWeakReference != null) && (this.jdField_a_of_type_MqqUtilWeakReference.get() != null))
    {
      ((FitSystemWindowsRelativeLayout)((ViewGroup)((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getWindow().getDecorView()).getChildAt(0).findViewById(2131363491)).a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPoke, this.jdField_a_of_type_Boolean, this);
      if (QLog.isColorLevel()) {
        QLog.d("fangdazhao", 2, "[x :" + i + ", y : " + j + "]");
      }
    }
  }
  
  public CustomFrameAnimationDrawable a()
  {
    String str = PokeBigResHandler.c + "/dazhao/dazhao2_motion/dazhao2_motion_";
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inSampleSize = 1;
    ((BitmapFactory.Options)localObject).inMutable = true;
    try
    {
      localObject = ImageUtil.a(str + "01.png", (BitmapFactory.Options)localObject);
      localObject = new CustomFrameAnimationDrawable(getResources(), (Bitmap)localObject, PokeItemAnimationManager.a().a);
      ((CustomFrameAnimationDrawable)localObject).h();
      i = 0;
      for (;;)
      {
        if (i >= 23) {
          break label208;
        }
        if (i + 1 >= 10) {
          break;
        }
        ((CustomFrameAnimationDrawable)localObject).a(i, 40, str + "0" + (i + 1) + ".png");
        i += 1;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      CustomFrameAnimationDrawable localCustomFrameAnimationDrawable;
      for (;;)
      {
        int i;
        if (QLog.isColorLevel()) {
          QLog.d("UnlimitedBladeWorks", 2, localOutOfMemoryError.toString());
        }
        localCustomFrameAnimationDrawable = null;
        continue;
        localCustomFrameAnimationDrawable.a(i, 40, str + (i + 1) + ".png");
      }
      label208:
      localCustomFrameAnimationDrawable.a();
      localCustomFrameAnimationDrawable.g();
      return localCustomFrameAnimationDrawable;
    }
  }
  
  public UnlimitedBladeWorks.UnlimitedState a()
  {
    UnlimitedBladeWorks.UnlimitedState localUnlimitedState = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks$UnlimitedState;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable.e();
    localUnlimitedState.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable.a();
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator.isRunning())
    {
      localUnlimitedState.jdField_a_of_type_Long = this.jdField_a_of_type_AndroidAnimationValueAnimator.getCurrentPlayTime();
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(null);
    }
    for (;;)
    {
      this.jdField_b_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable.e();
      localUnlimitedState.jdField_b_of_type_Int = this.jdField_b_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable.a();
      return localUnlimitedState;
      localUnlimitedState.jdField_a_of_type_Long = -1L;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks$UnlimitedState.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks$UnlimitedState.jdField_a_of_type_Boolean = false;
    d();
    if (this.jdField_a_of_type_Vlh != null) {
      this.jdField_a_of_type_Vlh.a();
    }
  }
  
  public void a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, float paramFloat)
  {
    this.jdField_c_of_type_Boolean = paramBoolean2;
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131375404));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131375405));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131375406));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable = b();
    this.jdField_b_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable = a();
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable);
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable.a(paramBoolean1);
    this.jdField_b_of_type_AndroidWidgetImageView.clearAnimation();
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inSampleSize = 1;
    localOptions.inMutable = true;
    try
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = ImageUtil.a(PokeBigResHandler.d, localOptions);
      if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = PokeItemHelper.a(this.jdField_a_of_type_AndroidGraphicsBitmap);
      }
      this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramContext);
      setParams(this.jdField_a_of_type_Boolean);
      if (paramBoolean2) {
        ThreadManager.postImmediately(new vky(this), null, true);
      }
      this.jdField_a_of_type_Vlf = new vlf(this, null);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable.a(new vkz(this));
      this.jdField_b_of_type_Boolean = true;
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("UnlimitedBladeWorks", 2, localOutOfMemoryError.toString());
        }
        this.jdField_a_of_type_AndroidGraphicsBitmap = null;
      }
    }
  }
  
  public void a(MessageForPoke paramMessageForPoke, float paramFloat)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForPoke = paramMessageForPoke;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks$UnlimitedState = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPoke.mUnlimitedState;
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  public void a(MessageForPoke paramMessageForPoke, boolean paramBoolean, float paramFloat)
  {
    if ((paramFloat == 2.0F) && (GreatMoveCombolEffectView.jdField_a_of_type_Boolean == true))
    {
      ((FitSystemWindowsRelativeLayout)((ViewGroup)((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getWindow().getDecorView()).getChildAt(0).findViewById(2131363491)).a().a(paramMessageForPoke, this);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks$UnlimitedState = paramMessageForPoke.mUnlimitedState;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks$UnlimitedState.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks$UnlimitedState.jdField_b_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.d("fangdazhao", 2, "[" + this.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks$UnlimitedState.jdField_a_of_type_Int + "," + this.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks$UnlimitedState.jdField_a_of_type_Long + "," + this.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks$UnlimitedState.jdField_b_of_type_Int + "]");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks$UnlimitedState.jdField_a_of_type_Int < 23)
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(0);
      this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(null);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks$UnlimitedState.jdField_a_of_type_Int);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(null);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable.a(new vlb(this));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable.d();
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks$UnlimitedState.jdField_a_of_type_Int >= 23) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks$UnlimitedState.jdField_a_of_type_Int < 29))
    {
      this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(null);
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks$UnlimitedState.jdField_a_of_type_Int);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks$UnlimitedState.jdField_a_of_type_Long != -1L) {
          break label347;
        }
        this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable.a(null);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable.d();
        return;
        this.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
        break;
        label347:
        this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
        this.jdField_a_of_type_AndroidAnimationValueAnimator.setCurrentPlayTime(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks$UnlimitedState.jdField_a_of_type_Long);
      }
    }
    int i = ((Integer)this.jdField_a_of_type_AndroidAnimationValueAnimator.getAnimatedValue()).intValue();
    if (i > 0)
    {
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
        this.jdField_a_of_type_AndroidAnimationValueAnimator.setCurrentPlayTime(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks$UnlimitedState.jdField_a_of_type_Long);
        return;
        this.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
      }
    }
    if ((i <= 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks$UnlimitedState.jdField_b_of_type_Int >= 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks$UnlimitedState.jdField_b_of_type_Int < 9))
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(0);
      this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_b_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable);
      this.jdField_b_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable.a(new vlc(this));
      this.jdField_b_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable.a(paramBoolean);
      this.jdField_b_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks$UnlimitedState.jdField_b_of_type_Int);
      this.jdField_b_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable.d();
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
    this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(0);
    this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_b_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable);
    if (this.jdField_a_of_type_Vlh != null)
    {
      this.jdField_a_of_type_Vlh.a();
      if (this.jdField_c_of_type_Boolean) {
        HapticManager.a().c(this.jdField_a_of_type_Int);
      }
      this.jdField_a_of_type_Int = 0;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks$UnlimitedState.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks$UnlimitedState.jdField_b_of_type_Boolean = true;
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public CustomFrameAnimationDrawable b()
  {
    String str = PokeBigResHandler.c + "/dazhao/daozhao_motion/dazhao_motion_";
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inSampleSize = 1;
    ((BitmapFactory.Options)localObject).inMutable = true;
    try
    {
      localObject = ImageUtil.a(str + "01.png", (BitmapFactory.Options)localObject);
      localObject = new CustomFrameAnimationDrawable(getResources(), (Bitmap)localObject, PokeItemAnimationManager.a().a);
      ((CustomFrameAnimationDrawable)localObject).h();
      i = 0;
      for (;;)
      {
        if (i >= 29) {
          break label209;
        }
        if (i + 1 >= 10) {
          break;
        }
        ((CustomFrameAnimationDrawable)localObject).a(i, 40, str + "0" + (i + 1) + ".png");
        i += 1;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      CustomFrameAnimationDrawable localCustomFrameAnimationDrawable;
      for (;;)
      {
        int i;
        if (QLog.isColorLevel()) {
          QLog.d("UnlimitedBladeWorks", 2, localOutOfMemoryError.toString());
        }
        localCustomFrameAnimationDrawable = null;
        continue;
        localCustomFrameAnimationDrawable.a(i, 40, str + (i + 1) + ".png");
      }
      label209:
      localCustomFrameAnimationDrawable.a();
      localCustomFrameAnimationDrawable.g();
      return localCustomFrameAnimationDrawable;
    }
  }
  
  public void b()
  {
    int i = ScreenUtil.jdField_a_of_type_Int;
    int j = ScreenUtil.a(142.0F);
    int k = (int)(ScreenUtil.jdField_a_of_type_Int - ScreenUtil.a(142.0F) * this.jdField_a_of_type_Float);
    float f = k * 1.0F / (i - j);
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator != null)
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
      this.jdField_a_of_type_AndroidAnimationValueAnimator.removeAllListeners();
    }
    this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofInt(new int[] { k, -ScreenUtil.a(80.0F) });
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new vla(this));
    if (this.jdField_a_of_type_Vlf == null) {
      this.jdField_a_of_type_Vlf = new vlf(this, null);
    }
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(this.jdField_a_of_type_Vlf);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration((f * 600.0F));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setTarget(this.jdField_b_of_type_AndroidWidgetImageView);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setInterpolator(new LinearInterpolator());
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.i("placeholder", 2, "SHOW_PLACEHOLDER Unlimited");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks$UnlimitedState.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks$UnlimitedState.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks$UnlimitedState.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks$UnlimitedState.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks$UnlimitedState.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable);
    this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(null);
    this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(null);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable.c();
    if (this.jdField_c_of_type_Boolean) {
      this.jdField_a_of_type_Int = HapticManager.a().a(this.jdField_a_of_type_JavaLangString, 2);
    }
  }
  
  public void setEndListener(vlh paramvlh)
  {
    this.jdField_a_of_type_Vlh = paramvlh;
  }
  
  public void setMirror(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean == paramBoolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = paramBoolean;
    RelativeLayout.LayoutParams localLayoutParams;
    if (paramBoolean)
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      localLayoutParams.addRule(9, -1);
      localLayoutParams.addRule(11, 0);
      this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetImageView.getLayoutParams();
      localLayoutParams.addRule(9, 0);
      localLayoutParams.addRule(11, -1);
      this.jdField_c_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
      localLayoutParams.addRule(9, 0);
      localLayoutParams.addRule(11, -1);
      localLayoutParams.leftMargin = 0;
      localLayoutParams.rightMargin = AIOUtils.a(100.0F, getResources());
      this.jdField_b_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable.a(paramBoolean);
      this.jdField_b_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable.a(paramBoolean);
      return;
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      localLayoutParams.addRule(9, 0);
      localLayoutParams.addRule(11, -1);
      this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetImageView.getLayoutParams();
      localLayoutParams.addRule(9, -1);
      localLayoutParams.addRule(11, 0);
      this.jdField_c_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
      localLayoutParams.addRule(9, -1);
      localLayoutParams.addRule(11, 0);
      localLayoutParams.rightMargin = 0;
      localLayoutParams.leftMargin = AIOUtils.a(100.0F, getResources());
      this.jdField_b_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
    }
  }
  
  public void setParams(boolean paramBoolean)
  {
    RelativeLayout.LayoutParams localLayoutParams;
    if (paramBoolean == true)
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      localLayoutParams.addRule(9, -1);
      localLayoutParams.addRule(11, 0);
      localLayoutParams.height = ((int)(ScreenUtil.a(90.0F) * this.jdField_a_of_type_Float));
      localLayoutParams.width = ((int)(ScreenUtil.a(90.0F) * this.jdField_a_of_type_Float));
      this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetImageView.getLayoutParams();
      localLayoutParams.addRule(9, 0);
      localLayoutParams.addRule(11, -1);
      localLayoutParams.height = ((int)(ScreenUtil.a(90.0F) * this.jdField_a_of_type_Float));
      localLayoutParams.width = ((int)(ScreenUtil.a(90.0F) * this.jdField_a_of_type_Float));
      this.jdField_c_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
      localLayoutParams.addRule(9, 0);
      localLayoutParams.addRule(11, -1);
      localLayoutParams.height = ((int)(ScreenUtil.a(34.0F) * this.jdField_a_of_type_Float));
      localLayoutParams.width = ((int)(ScreenUtil.a(48.0F) * this.jdField_a_of_type_Float));
      localLayoutParams.leftMargin = 0;
      localLayoutParams.rightMargin = AIOUtils.a(100.0F, getResources());
      this.jdField_b_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
    }
    for (;;)
    {
      b();
      return;
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      localLayoutParams.addRule(9, 0);
      localLayoutParams.addRule(11, -1);
      localLayoutParams.height = ((int)(ScreenUtil.a(90.0F) * this.jdField_a_of_type_Float));
      localLayoutParams.width = ((int)(ScreenUtil.a(90.0F) * this.jdField_a_of_type_Float));
      this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetImageView.getLayoutParams();
      localLayoutParams.addRule(9, -1);
      localLayoutParams.addRule(11, 0);
      localLayoutParams.height = ((int)(ScreenUtil.a(90.0F) * this.jdField_a_of_type_Float));
      localLayoutParams.width = ((int)(ScreenUtil.a(90.0F) * this.jdField_a_of_type_Float));
      this.jdField_c_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
      localLayoutParams.addRule(9, -1);
      localLayoutParams.addRule(11, 0);
      localLayoutParams.height = ((int)(ScreenUtil.a(34.0F) * this.jdField_a_of_type_Float));
      localLayoutParams.width = ((int)(ScreenUtil.a(48.0F) * this.jdField_a_of_type_Float));
      localLayoutParams.rightMargin = 0;
      localLayoutParams.leftMargin = AIOUtils.a(100.0F, getResources());
      this.jdField_b_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.UnlimitedBladeWorks
 * JD-Core Version:    0.7.0.1
 */