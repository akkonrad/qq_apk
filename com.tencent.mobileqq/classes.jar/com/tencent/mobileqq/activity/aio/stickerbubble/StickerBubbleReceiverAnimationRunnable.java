package com.tencent.mobileqq.activity.aio.stickerbubble;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.apollo.script.SpriteCommFunc;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import wce;

public class StickerBubbleReceiverAnimationRunnable
  implements StickerBubbleAnimationViewHolder.AnimationViewCallback, Runnable
{
  public static volatile boolean a;
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View jdField_a_of_type_AndroidViewView;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Runnable jdField_a_of_type_JavaLangRunnable = new wce(this);
  private String jdField_a_of_type_JavaLangString;
  private int[] jdField_a_of_type_ArrayOfInt;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  private boolean d;
  private boolean e;
  private boolean f;
  private boolean g;
  
  public StickerBubbleReceiverAnimationRunnable(QQAppInterface paramQQAppInterface, int paramInt, @NonNull View paramView, @NonNull String paramString)
  {
    this.jdField_a_of_type_AndroidContentContext = paramQQAppInterface.getApp().getApplicationContext();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_JavaLangString = paramString;
    if (!SpriteCommFunc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {}
    for (boolean bool = true;; bool = false)
    {
      this.d = bool;
      StickerBubbleAnimationViewHolder.a().a(this);
      return;
    }
  }
  
  @NonNull
  private int[] a()
  {
    int m = 0;
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (this.jdField_a_of_type_Int * 80 < 5000) {
      return StickerBubbleAnimationHelper.a((QQAppInterface)localObject);
    }
    localObject = StickerBubbleAnimationHelper.a((QQAppInterface)localObject);
    int n = localObject.length;
    int j = 0;
    for (int i = 0; j < n; i = k)
    {
      k = i;
      if (localObject[j] <= this.jdField_a_of_type_Int) {
        k = i + 1;
      }
      j += 1;
    }
    localObject = new int[i];
    int k = 62 / i;
    j = m;
    while (j < i)
    {
      localObject[j] = ((j + 1) * k);
      j += 1;
    }
    return localObject;
  }
  
  public void a()
  {
    jdField_a_of_type_Boolean = false;
    if (AIOUtils.jdField_b_of_type_Int > 0) {
      AIOUtils.jdField_b_of_type_Int -= 1;
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    StickerBubbleAnimationHelper.a(this, this.jdField_a_of_type_AndroidViewView);
    this.f = false;
    this.jdField_b_of_type_Boolean = true;
    jdField_a_of_type_Boolean = false;
    AIOUtils.jdField_b_of_type_Int = 0;
    if (this.d)
    {
      SpriteCommFunc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "StickerBubble", false);
      this.e = true;
    }
  }
  
  public void run()
  {
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    jdField_a_of_type_Boolean = true;
    if ((this.d) && (!this.e))
    {
      SpriteCommFunc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "StickerBubble", true);
      this.e = true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("StickerBubbleRunnable", 2, "showReceiveAnimationView from runnable");
    }
    StickerBubbleAnimationView localStickerBubbleAnimationView = StickerBubbleAnimationViewHolder.a().b((ViewGroup)this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidContentContext);
    if (!this.c)
    {
      localStickerBubbleAnimationView.bringToFront();
      this.c = true;
    }
    if (this.jdField_a_of_type_ArrayOfInt == null) {
      this.jdField_a_of_type_ArrayOfInt = a();
    }
    this.jdField_b_of_type_Int += 1;
    if ((this.jdField_b_of_type_Int > this.jdField_a_of_type_Int) || (this.jdField_b_of_type_Int * 80 > 5000))
    {
      if (QLog.isColorLevel()) {
        QLog.d("StickerBubbleRunnable", 2, "Sticker bubble receiver animation sending finished " + this);
      }
      this.g = true;
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
      return;
    }
    if (this.jdField_b_of_type_Int == 2)
    {
      StickerBubbleAnimationHelper.b(this, this.jdField_a_of_type_AndroidViewView);
      this.f = true;
      this.g = false;
    }
    localStickerBubbleAnimationView.a(StickerBubbleAnimationHelper.a(this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().widthPixels, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_Int, this.jdField_a_of_type_ArrayOfInt));
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this, 80L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleReceiverAnimationRunnable
 * JD-Core Version:    0.7.0.1
 */