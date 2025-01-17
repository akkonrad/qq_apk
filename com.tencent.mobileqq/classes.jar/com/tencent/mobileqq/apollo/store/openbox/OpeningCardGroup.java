package com.tencent.mobileqq.apollo.store.openbox;

import android.content.Context;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.util.List;

public class OpeningCardGroup
  extends MultilScreenlLayout
  implements Handler.Callback
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private AnimationSet jdField_a_of_type_AndroidViewAnimationAnimationSet;
  private IApolloOpenBoxListener jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxIApolloOpenBoxListener;
  private WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
  private int b;
  
  public OpeningCardGroup(Context paramContext, IApolloOpenBoxListener paramIApolloOpenBoxListener)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxIApolloOpenBoxListener = paramIApolloOpenBoxListener;
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    int j = super.getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = super.getChildAt(i);
      float f = this.jdField_a_of_type_Float;
      int k = localView.getLeft();
      int m = localView.getWidth() / 2;
      AnimationSet localAnimationSet = new AnimationSet(false);
      Object localObject = new ScaleAnimation(1.0F, f, 1.0F, f, 1, 0.5F, 1, 0.5F);
      ((ScaleAnimation)localObject).setDuration(400L);
      localAnimationSet.addAnimation((Animation)localObject);
      localAnimationSet.setFillAfter(true);
      localObject = new TranslateAnimation(0.0F, paramInt2 * i + paramInt1 - (k + m), 0.0F, paramInt3 - this.jdField_a_of_type_Int);
      ((TranslateAnimation)localObject).setDuration(400L);
      localAnimationSet.addAnimation((Animation)localObject);
      localView.clearAnimation();
      localView.startAnimation(localAnimationSet);
      i += 1;
    }
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(15);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(15, 400L);
  }
  
  public void a(int paramInt1, int paramInt2, ApolloBoxData paramApolloBoxData)
  {
    if ((paramApolloBoxData == null) || (paramApolloBoxData.b == null)) {
      return;
    }
    int j = Math.min(super.getChildCount(), paramApolloBoxData.b.size());
    int i = 0;
    while (i < j)
    {
      View localView = super.getChildAt(i);
      localView.clearAnimation();
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localView.getLayoutParams();
      localLayoutParams.width = paramInt1;
      localLayoutParams.height = paramInt2;
      if ((localView instanceof ApolloCardLayout)) {
        ((ApolloCardLayout)localView).a(1, (ApolloBoxData.ApolloBoxDataItem)paramApolloBoxData.b.get(i), paramInt1, paramInt2);
      }
      i += 1;
    }
    super.clearAnimation();
    super.setLayoutStyle(1);
  }
  
  public void a(List paramList1, List paramList2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.removeAllViews();
    super.clearAnimation();
    super.setLayoutStyle(0);
    super.setCurrentFrame(0);
    paramInt4 = (int)(paramInt3 * 0.706F);
    int i = paramInt4 * 760 / 530;
    int j = Math.min(paramList2.size(), paramList1.size());
    this.jdField_a_of_type_Float = 1.0F;
    this.b = paramInt1;
    this.jdField_a_of_type_Int = paramInt2;
    if (j == 1)
    {
      this.jdField_a_of_type_Float = 1.818182F;
      paramInt4 = (int)(paramInt4 * 0.55F);
      i = (int)(i * 0.55F);
      paramList2 = (ApolloCardLayout)paramList2.get(0);
      paramList2.a(2, (ApolloBoxData.ApolloBoxDataItem)paramList1.get(0), paramInt4, i);
      paramList1 = new FrameLayout.LayoutParams(paramInt4, i);
      paramList1.leftMargin = (paramInt3 - paramInt1 - paramInt4 / 2);
      paramList1.topMargin = (paramInt2 - i / 2);
      paramList2.clearAnimation();
      super.addView(paramList2, paramList1);
      return;
    }
    if (j == 2)
    {
      this.jdField_a_of_type_Float = 1.818182F;
      paramInt4 = (int)(paramInt4 * 0.55F);
      i = (int)(i * 0.55F);
      j = (int)(paramInt3 * 0.016F);
      localApolloCardLayout = (ApolloCardLayout)paramList2.get(0);
      localApolloCardLayout.a(2, (ApolloBoxData.ApolloBoxDataItem)paramList1.get(0), paramInt4, i);
      localLayoutParams = new FrameLayout.LayoutParams(paramInt4, i);
      paramInt1 = paramInt3 - paramInt1 - j / 2 - paramInt4;
      paramInt2 -= i / 2;
      localLayoutParams.leftMargin = paramInt1;
      localLayoutParams.topMargin = paramInt2;
      localApolloCardLayout.clearAnimation();
      super.addView(localApolloCardLayout, localLayoutParams);
      paramList2 = (ApolloCardLayout)paramList2.get(1);
      paramList2.a(2, (ApolloBoxData.ApolloBoxDataItem)paramList1.get(1), paramInt4, i);
      paramList1 = new FrameLayout.LayoutParams(paramInt4, i);
      paramList1.leftMargin = (paramInt4 + (paramInt1 + j));
      paramList1.topMargin = paramInt2;
      paramList2.clearAnimation();
      super.addView(paramList2, paramList1);
      return;
    }
    if (j == 3)
    {
      this.jdField_a_of_type_Float = 2.631579F;
      paramInt4 = (int)(paramInt4 * 0.38F);
      i = (int)(i * 0.38F);
      localApolloCardLayout = (ApolloCardLayout)paramList2.get(0);
      localApolloCardLayout.a(3, (ApolloBoxData.ApolloBoxDataItem)paramList1.get(0), paramInt4, i);
      localLayoutParams = new FrameLayout.LayoutParams(paramInt4, i);
      paramInt1 = paramInt3 - paramInt1 - 0 - paramInt4 * 3 / 2;
      paramInt2 -= i / 2;
      localLayoutParams.leftMargin = paramInt1;
      localLayoutParams.topMargin = paramInt2;
      localApolloCardLayout.clearAnimation();
      super.addView(localApolloCardLayout, localLayoutParams);
      localApolloCardLayout = (ApolloCardLayout)paramList2.get(1);
      localApolloCardLayout.a(3, (ApolloBoxData.ApolloBoxDataItem)paramList1.get(1), paramInt4, i);
      localLayoutParams = new FrameLayout.LayoutParams(paramInt4, i);
      paramInt1 = paramInt1 + 0 + paramInt4;
      localLayoutParams.leftMargin = paramInt1;
      localLayoutParams.topMargin = paramInt2;
      localApolloCardLayout.clearAnimation();
      super.addView(localApolloCardLayout, localLayoutParams);
      paramList2 = (ApolloCardLayout)paramList2.get(2);
      paramList2.a(3, (ApolloBoxData.ApolloBoxDataItem)paramList1.get(2), paramInt4, i);
      paramList1 = new FrameLayout.LayoutParams(paramInt4, i);
      paramList1.leftMargin = (paramInt4 + (paramInt1 + 0));
      paramList1.topMargin = paramInt2;
      paramList2.clearAnimation();
      super.addView(paramList2, paramList1);
      return;
    }
    this.jdField_a_of_type_Float = 3.571429F;
    paramInt4 = (int)(paramInt4 * 0.28F);
    i = (int)(i * 0.28F);
    j = (int)(paramInt3 * 0.008F);
    ApolloCardLayout localApolloCardLayout = (ApolloCardLayout)paramList2.get(0);
    localApolloCardLayout.a(4, (ApolloBoxData.ApolloBoxDataItem)paramList1.get(0), paramInt4, i);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(paramInt4, i);
    paramInt3 = paramInt3 - paramInt1 - j * 3 / 2 - paramInt4 * 2;
    paramInt1 = paramInt2 - i / 2;
    localLayoutParams.leftMargin = paramInt3;
    localLayoutParams.topMargin = paramInt1;
    localApolloCardLayout.clearAnimation();
    super.addView(localApolloCardLayout, localLayoutParams);
    localApolloCardLayout = (ApolloCardLayout)paramList2.get(1);
    localApolloCardLayout.a(4, (ApolloBoxData.ApolloBoxDataItem)paramList1.get(1), paramInt4, i);
    localLayoutParams = new FrameLayout.LayoutParams(paramInt4, i);
    paramInt2 = paramInt3 + j + paramInt4;
    localLayoutParams.leftMargin = paramInt2;
    localLayoutParams.topMargin = paramInt1;
    localApolloCardLayout.clearAnimation();
    super.addView(localApolloCardLayout, localLayoutParams);
    localApolloCardLayout = (ApolloCardLayout)paramList2.get(2);
    localApolloCardLayout.a(4, (ApolloBoxData.ApolloBoxDataItem)paramList1.get(2), paramInt4, i);
    localLayoutParams = new FrameLayout.LayoutParams(paramInt4, i);
    paramInt2 = paramInt2 + j + paramInt4;
    localLayoutParams.leftMargin = paramInt2;
    localLayoutParams.topMargin = paramInt1;
    localApolloCardLayout.clearAnimation();
    super.addView(localApolloCardLayout, localLayoutParams);
    paramList2 = (ApolloCardLayout)paramList2.get(3);
    paramList2.a(4, (ApolloBoxData.ApolloBoxDataItem)paramList1.get(3), paramInt4, i);
    paramList1 = new FrameLayout.LayoutParams(paramInt4, i);
    paramList1.leftMargin = (paramInt4 + (paramInt2 + j));
    paramList1.topMargin = paramInt1;
    paramList2.clearAnimation();
    super.addView(paramList2, paramList1);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeCallbacksAndMessages(null);
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxIApolloOpenBoxListener = null;
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxMultilScreenlLayout$OnClickScrollLayoutListener = null;
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidViewAnimationAnimationSet == null)
    {
      this.jdField_a_of_type_AndroidViewAnimationAnimationSet = new AnimationSet(true);
      ScaleAnimation localScaleAnimation = new ScaleAnimation(0.0F, 0.25F, 0.0F, 0.25F, 1, 0.5F, 1, 0.5F);
      localScaleAnimation.setDuration(150L);
      this.jdField_a_of_type_AndroidViewAnimationAnimationSet.addAnimation(localScaleAnimation);
      localScaleAnimation = new ScaleAnimation(1.0F, 4.0F, 1.0F, 4.0F, 1, 0.5F, 1, 0.5F);
      localScaleAnimation.setDuration(150L);
      localScaleAnimation.setStartOffset(450L);
      this.jdField_a_of_type_AndroidViewAnimationAnimationSet.addAnimation(localScaleAnimation);
    }
    this.jdField_a_of_type_AndroidViewAnimationAnimationSet.reset();
    super.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimationSet);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage == null) {}
    do
    {
      return false;
      switch (paramMessage.what)
      {
      default: 
        return false;
      case 15: 
        if (QLog.isColorLevel()) {
          QLog.d("ApolloCardWindow", 2, "MSG_CODE_ANIMATION_END");
        }
        break;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxIApolloOpenBoxListener == null);
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxIApolloOpenBoxListener.a(10, 0, 0);
    return false;
    super.setVisibility(8);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.openbox.OpeningCardGroup
 * JD-Core Version:    0.7.0.1
 */