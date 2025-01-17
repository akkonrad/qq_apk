package com.tencent.mobileqq.werewolves;

import akrw;
import akrx;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;

public class WereWolvesLoadingView
  extends FrameLayout
{
  int jdField_a_of_type_Int;
  public Handler a;
  View jdField_a_of_type_AndroidViewView;
  public TextView a;
  WereWolvesLoadingView.LoadingCallback jdField_a_of_type_ComTencentMobileqqWerewolvesWereWolvesLoadingView$LoadingCallback;
  public Runnable a;
  boolean jdField_a_of_type_Boolean;
  public int b;
  public View b;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  Runnable jdField_b_of_type_JavaLangRunnable = new akrx(this);
  public boolean b;
  
  public WereWolvesLoadingView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangRunnable = new akrw(this);
    this.jdField_b_of_type_Boolean = false;
    a();
  }
  
  public WereWolvesLoadingView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangRunnable = new akrw(this);
    this.jdField_b_of_type_Boolean = false;
    a();
  }
  
  void a()
  {
    this.jdField_b_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2130969120, this);
    this.jdField_a_of_type_Int = findViewById(2131365266).getLayoutParams().width;
    this.jdField_a_of_type_AndroidViewView = findViewById(2131363562);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363566));
    setProgress(0);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131362728));
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ColorDrawable localColorDrawable = new ColorDrawable(Color.parseColor("#323e6f"));
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localColorDrawable;
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localColorDrawable;
    localObject = URLDrawable.getDrawable("http://pub.idqqimg.com/pc/misc/nearby_game_room_bg.jpg", (URLDrawable.URLDrawableOptions)localObject);
    this.jdField_b_of_type_AndroidViewView.setBackgroundDrawable((Drawable)localObject);
  }
  
  public void b()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_b_of_type_JavaLangRunnable, 10L);
  }
  
  public void c()
  {
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void setComplete(WereWolvesLoadingView.LoadingCallback paramLoadingCallback)
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    this.jdField_a_of_type_ComTencentMobileqqWerewolvesWereWolvesLoadingView$LoadingCallback = paramLoadingCallback;
    this.jdField_a_of_type_AndroidOsHandler.post(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void setProgress(int paramInt)
  {
    int i;
    if (paramInt < 0)
    {
      i = 0;
      paramInt = this.jdField_a_of_type_Int * i / 100;
      if (paramInt == 0) {
        break label129;
      }
      ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidViewView.getLayoutParams();
      localLayoutParams.width = paramInt;
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
    }
    for (;;)
    {
      this.jdField_b_of_type_Int = i;
      this.jdField_b_of_type_AndroidWidgetTextView.setText(String.format("%d%%", new Object[] { Integer.valueOf(i) }));
      if (this.jdField_b_of_type_Int < 100) {
        break label141;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqWerewolvesWereWolvesLoadingView$LoadingCallback != null) && (!this.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_ComTencentMobileqqWerewolvesWereWolvesLoadingView$LoadingCallback.a();
        this.jdField_a_of_type_Boolean = true;
      }
      return;
      i = paramInt;
      if (paramInt <= 100) {
        break;
      }
      i = 100;
      break;
      label129:
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    label141:
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void setTips(String paramString)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.werewolves.WereWolvesLoadingView
 * JD-Core Version:    0.7.0.1
 */