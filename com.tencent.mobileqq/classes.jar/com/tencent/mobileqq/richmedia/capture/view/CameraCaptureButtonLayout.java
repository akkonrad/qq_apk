package com.tencent.mobileqq.richmedia.capture.view;

import ahky;
import ahkz;
import ahla;
import ahlb;
import ahlc;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.shortvideo.util.VideoAnimation;
import com.tencent.mobileqq.widget.CircleProgress;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class CameraCaptureButtonLayout
  extends RelativeLayout
{
  private float jdField_a_of_type_Float = 10000.0F;
  private int jdField_a_of_type_Int = AIOUtils.a(45.0F, getResources());
  private long jdField_a_of_type_Long;
  private ObjectAnimator jdField_a_of_type_AndroidAnimationObjectAnimator;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private Handler jdField_a_of_type_AndroidOsHandler = new ahlc(this);
  private View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new ahlb(this);
  private View jdField_a_of_type_AndroidViewView;
  public ImageView a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private CameraCaptureButtonLayout.CaptureButtonListener jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureButtonLayout$CaptureButtonListener;
  private CameraCaptureButtonLayout.CaptureButtonListenerInterceptor jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureButtonLayout$CaptureButtonListenerInterceptor;
  private CameraCaptureButtonLayout.CaptureButtonProgressInterceptor jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureButtonLayout$CaptureButtonProgressInterceptor;
  private CameraCaptureView jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView;
  private CircleProgress jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress;
  public AtomicBoolean a;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = AIOUtils.a(70.0F, getResources());
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  public AtomicBoolean b;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = 1;
  private boolean jdField_c_of_type_Boolean;
  
  public CameraCaptureButtonLayout(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    e();
  }
  
  public CameraCaptureButtonLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    e();
  }
  
  private void a(float paramFloat)
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    localLayoutParams.width = ((int)(this.jdField_a_of_type_Int * paramFloat));
    localLayoutParams.height = ((int)(this.jdField_a_of_type_Int * paramFloat));
    localLayoutParams.addRule(13);
    this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
    localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.getLayoutParams();
    localLayoutParams.width = ((int)(this.jdField_b_of_type_Int * paramFloat));
    localLayoutParams.height = ((int)(this.jdField_b_of_type_Int * paramFloat));
    localLayoutParams.addRule(13);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setLayoutParams(localLayoutParams);
  }
  
  private void e()
  {
    LayoutInflater.from(getContext()).inflate(2130970344, this, true);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131369000);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369521));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370134));
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress = ((CircleProgress)findViewById(2131369008));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369007));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369522));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setBgAndProgressColor(100, getResources().getColor(2131492969), 100, getResources().getColor(2131493308));
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setStrokeWidth(4.5F);
  }
  
  @TargetApi(11)
  private void f()
  {
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    VideoAnimation.a(this.jdField_b_of_type_AndroidWidgetImageView, 0.1F, 1.0F, 0.1F, 1.2F, 400, null);
    this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F, 1.1333F });
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(400L);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new ahkz(this));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(new ahla(this));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
  }
  
  @TargetApi(11)
  private void g()
  {
    if (this.jdField_b_of_type_AndroidWidgetImageView != null)
    {
      Animation localAnimation = this.jdField_b_of_type_AndroidWidgetImageView.getAnimation();
      if (localAnimation != null)
      {
        localAnimation.cancel();
        localAnimation.setAnimationListener(null);
      }
      this.jdField_b_of_type_AndroidWidgetImageView.clearAnimation();
    }
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator != null) {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
    }
  }
  
  private void h()
  {
    a(1.0F);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setProgress(0.0F);
    this.jdField_b_of_type_AndroidWidgetTextView.setText("");
    this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(true);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private void i()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureButtonLayout$CaptureButtonProgressInterceptor;
    if (localObject != null)
    {
      this.jdField_a_of_type_Boolean = ((CameraCaptureButtonLayout.CaptureButtonProgressInterceptor)localObject).a(this.jdField_b_of_type_AndroidWidgetTextView, this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress, this.jdField_a_of_type_Long, this.jdField_a_of_type_Float);
      if (this.jdField_a_of_type_Boolean) {
        j();
      }
      return;
    }
    long l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    boolean bool;
    if ((float)l >= this.jdField_a_of_type_Float)
    {
      bool = true;
      label72:
      this.jdField_a_of_type_Boolean = bool;
      if (!this.jdField_a_of_type_Boolean) {
        break label186;
      }
    }
    label186:
    for (int i = 100;; i = (int)((float)l / this.jdField_a_of_type_Float * 100.0F))
    {
      localObject = (int)l / 1000 + "秒";
      this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setProgress(i);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("CameraCaptureLayout", 2, "updateProgress percent:" + i + ", time:" + (String)localObject);
      break;
      bool = false;
      break label72;
    }
  }
  
  private void j()
  {
    if (!this.jdField_c_of_type_Boolean) {
      return;
    }
    if ((this.jdField_c_of_type_Int == 3) || (this.jdField_c_of_type_Int == 1))
    {
      this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(5);
      g();
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
      }
    }
    for (;;)
    {
      this.jdField_c_of_type_Boolean = false;
      return;
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      if (this.jdField_c_of_type_Int == 1)
      {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
        continue;
        if (this.jdField_c_of_type_Int == 2) {
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
        }
      }
    }
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.clearAnimation();
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  public void a(CameraCaptureButtonLayout.CaptureButtonListener paramCaptureButtonListener, CameraCaptureView paramCameraCaptureView)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView = paramCameraCaptureView;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureButtonLayout$CaptureButtonListener = paramCaptureButtonListener;
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      this.jdField_a_of_type_AndroidAnimationObjectAnimator = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetTextView, "alpha", new float[] { 1.0F, 0.0F });
      this.jdField_a_of_type_AndroidAnimationObjectAnimator.setStartDelay(2500L);
      this.jdField_a_of_type_AndroidAnimationObjectAnimator.setDuration(500L);
      this.jdField_a_of_type_AndroidAnimationObjectAnimator.addListener(new ahky(this));
      this.jdField_a_of_type_AndroidAnimationObjectAnimator.start();
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    float f = this.jdField_a_of_type_AndroidViewView.getHeight();
    ObjectAnimator localObjectAnimator;
    if (paramBoolean) {
      localObjectAnimator = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidViewView, "translationY", new float[] { 0.0F, f });
    }
    for (ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 0.7F, 1.0F, 0.7F, 1, 0.5F, 1, 0.5F);; localScaleAnimation = new ScaleAnimation(0.7F, 1.0F, 0.7F, 1.0F, 1, 0.5F, 1, 0.5F))
    {
      localScaleAnimation.setDuration(paramInt);
      localScaleAnimation.setFillAfter(true);
      localObjectAnimator.setDuration(paramInt).start();
      this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(localScaleAnimation);
      this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.startAnimation(localScaleAnimation);
      return;
      localObjectAnimator = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidViewView, "translationY", new float[] { f, 0.0F });
    }
  }
  
  public void b()
  {
    h();
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public void c()
  {
    this.jdField_b_of_type_Boolean = false;
    b();
  }
  
  public void d()
  {
    this.jdField_b_of_type_Boolean = true;
    j();
  }
  
  public void setButtonListenerInterceptor(CameraCaptureButtonLayout.CaptureButtonListenerInterceptor paramCaptureButtonListenerInterceptor)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureButtonLayout$CaptureButtonListenerInterceptor = paramCaptureButtonListenerInterceptor;
  }
  
  public void setCaptureButtonProgressInterceptor(CameraCaptureButtonLayout.CaptureButtonProgressInterceptor paramCaptureButtonProgressInterceptor)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureButtonLayout$CaptureButtonProgressInterceptor = paramCaptureButtonProgressInterceptor;
  }
  
  public void setFunctionFlag(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void setMaxDuration(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  public void setRecordTipsWording(String paramString)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.CameraCaptureButtonLayout
 * JD-Core Version:    0.7.0.1
 */