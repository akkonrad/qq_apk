package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.app.utils.PokeBigResHandler;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import vaa;

public class GreatMoveCombolEffectView
  extends View
  implements Runnable
{
  public static boolean a;
  int jdField_a_of_type_Int = 0;
  private Context jdField_a_of_type_AndroidContentContext;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint(6);
  Handler jdField_a_of_type_AndroidOsHandler;
  private ChatAdapter1 jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1;
  GreatMoveCombolEffectView.DecodeRunnable jdField_a_of_type_ComTencentMobileqqActivityAioItemGreatMoveCombolEffectView$DecodeRunnable;
  GreatMoveCombolEffectView.GreateMoveListener jdField_a_of_type_ComTencentMobileqqActivityAioItemGreatMoveCombolEffectView$GreateMoveListener;
  private ChatXListView jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
  private MessageForPoke jdField_a_of_type_ComTencentMobileqqDataMessageForPoke;
  ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private Vector jdField_a_of_type_JavaUtilVector = new Vector();
  int jdField_b_of_type_Int = 0;
  Handler jdField_b_of_type_AndroidOsHandler;
  public ArrayList b;
  boolean jdField_b_of_type_Boolean = false;
  
  public GreatMoveCombolEffectView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public GreatMoveCombolEffectView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public GreatMoveCombolEffectView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    a(paramContext);
  }
  
  private GivingHeartItemBuilder.Holder a()
  {
    View localView;
    if ((this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 != null))
    {
      int i = AIOUtils.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPoke.uniseq, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1);
      localView = AIOUtils.a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, i + 1);
      if (localView != null) {}
    }
    else
    {
      return null;
    }
    return (GivingHeartItemBuilder.Holder)AIOUtils.a(localView);
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    if ((this.jdField_a_of_type_AndroidContentContext instanceof FragmentActivity))
    {
      paramContext = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a();
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView = paramContext.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 = paramContext.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1;
    }
    setOnTouchListener(new vaa(this));
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    d();
    paramContext = new HandlerThread("decode");
    paramContext.start();
    this.jdField_b_of_type_AndroidOsHandler = new Handler(paramContext.getLooper());
  }
  
  private void a(GreatMoveCombolEffectView.GreateMoveListener paramGreateMoveListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGreatMoveCombolEffectView$GreateMoveListener = paramGreateMoveListener;
  }
  
  private void d()
  {
    String str = PokeBigResHandler.b + "/dazhao_caidan/dazhao_caidan_";
    int i = 0;
    if (i < 37)
    {
      if (i + 1 < 10) {
        a(str + "0" + (i + 1) + ".png", 30);
      }
      for (;;)
      {
        i += 1;
        break;
        a(str + (i + 1) + ".png", 30);
      }
    }
  }
  
  public Bitmap a()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_b_of_type_JavaUtilArrayList != null)
    {
      localObject1 = localObject2;
      if (this.jdField_b_of_type_JavaUtilArrayList.size() > 0) {
        localObject1 = (Bitmap)this.jdField_b_of_type_JavaUtilArrayList.remove(0);
      }
    }
    return localObject1;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this);
    this.jdField_b_of_type_AndroidOsHandler.post(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGreatMoveCombolEffectView$DecodeRunnable);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGreatMoveCombolEffectView$DecodeRunnable = null;
    setVisibility(8);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGreatMoveCombolEffectView$GreateMoveListener != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGreatMoveCombolEffectView$GreateMoveListener.a();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGreatMoveCombolEffectView$GreateMoveListener = null;
    }
  }
  
  public void a(MessageForPoke paramMessageForPoke, GreatMoveCombolEffectView.GreateMoveListener paramGreateMoveListener)
  {
    if ((jdField_a_of_type_Boolean) && (paramMessageForPoke != this.jdField_a_of_type_ComTencentMobileqqDataMessageForPoke)) {
      return;
    }
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this);
    this.jdField_a_of_type_AndroidOsHandler.post(this);
    paramMessageForPoke = (GreatMoveCombolEffectView.OneFrame)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int);
    try
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = ImageUtil.a(paramMessageForPoke.jdField_a_of_type_JavaLangString, null);
      return;
    }
    catch (OutOfMemoryError paramMessageForPoke)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GreatMoveCombolEffectView", 2, paramMessageForPoke.toString());
      }
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    }
  }
  
  public void a(MessageForPoke paramMessageForPoke, boolean paramBoolean, GreatMoveCombolEffectView.GreateMoveListener paramGreateMoveListener)
  {
    if (jdField_a_of_type_Boolean)
    {
      paramGreateMoveListener.a();
      return;
    }
    a(paramGreateMoveListener);
    setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForPoke = paramMessageForPoke;
    this.jdField_b_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this);
    this.jdField_a_of_type_AndroidOsHandler.post(this);
    paramMessageForPoke = (GreatMoveCombolEffectView.OneFrame)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int);
    try
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = ImageUtil.a(paramMessageForPoke.jdField_a_of_type_JavaLangString, null);
      jdField_a_of_type_Boolean = true;
      return;
    }
    catch (OutOfMemoryError paramMessageForPoke)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("GreatMoveCombolEffectView", 2, paramMessageForPoke.toString());
        }
        this.jdField_a_of_type_AndroidGraphicsBitmap = null;
      }
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    GreatMoveCombolEffectView.OneFrame localOneFrame = new GreatMoveCombolEffectView.OneFrame(this);
    localOneFrame.jdField_a_of_type_JavaLangString = paramString;
    localOneFrame.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaUtilArrayList.add(localOneFrame);
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 = null;
    a();
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()))
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    }
    Iterator localIterator;
    if (this.jdField_b_of_type_JavaUtilArrayList.size() > 0)
    {
      localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        ((Bitmap)localIterator.next()).recycle();
      }
      this.jdField_b_of_type_JavaUtilArrayList.clear();
    }
    if (this.jdField_a_of_type_JavaUtilVector.size() > 0)
    {
      localIterator = this.jdField_a_of_type_JavaUtilVector.iterator();
      while (localIterator.hasNext()) {
        ((Bitmap)localIterator.next()).recycle();
      }
      this.jdField_a_of_type_JavaUtilVector.clear();
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForPoke == null) {}
    do
    {
      int i;
      int j;
      do
      {
        return;
        localObject1 = a();
        if (localObject1 == null)
        {
          a();
          return;
        }
        localObject2 = new int[2];
        ((GivingHeartItemBuilder.Holder)localObject1).b.getLocationOnScreen((int[])localObject2);
        i = localObject2[1];
        j = ((GivingHeartItemBuilder.Holder)localObject1).b.getLayoutParams().height / 2;
        super.draw(paramCanvas);
      } while ((this.jdField_a_of_type_AndroidGraphicsBitmap == null) || (this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()));
      int k = this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
      int m = this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
      int n = getWidth();
      int i1 = getHeight();
      if (this.jdField_b_of_type_Boolean)
      {
        paramCanvas.save();
        paramCanvas.scale(-1.0F, 1.0F, n / 2, i1 / 2);
      }
      float f = n * 1.0F / k;
      paramCanvas.translate(0.0F, -((int)(m * f / 2.0F - (j + i)) + 50));
      Object localObject1 = new Rect(0, 0, k, m);
      Object localObject2 = new Rect(0, 0, n, (int)(m * f));
      paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, (Rect)localObject1, (Rect)localObject2, this.jdField_a_of_type_AndroidGraphicsPaint);
    } while (!this.jdField_b_of_type_Boolean);
    paramCanvas.restore();
  }
  
  public void run()
  {
    int i = this.jdField_a_of_type_Int + 1;
    if ((i < 37) && (jdField_a_of_type_Boolean))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGreatMoveCombolEffectView$DecodeRunnable == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGreatMoveCombolEffectView$DecodeRunnable = new GreatMoveCombolEffectView.DecodeRunnable(this, this.jdField_b_of_type_JavaUtilArrayList);
      }
      GreatMoveCombolEffectView.OneFrame localOneFrame = (GreatMoveCombolEffectView.OneFrame)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      this.jdField_b_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGreatMoveCombolEffectView$DecodeRunnable);
      this.jdField_b_of_type_AndroidOsHandler.post(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGreatMoveCombolEffectView$DecodeRunnable);
      this.jdField_a_of_type_Int += 1;
      Bitmap localBitmap;
      if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()))
      {
        localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
        if (this.jdField_a_of_type_JavaUtilVector.size() > 2) {
          break label156;
        }
        this.jdField_a_of_type_JavaUtilVector.add(localBitmap);
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidGraphicsBitmap = a();
        invalidate();
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this, localOneFrame.jdField_a_of_type_Int);
        return;
        label156:
        localBitmap.recycle();
      }
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.GreatMoveCombolEffectView
 * JD-Core Version:    0.7.0.1
 */