package com.tencent.mobileqq.activity.aio.qwallet;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.widget.AnimationView;
import com.tencent.mobileqq.widget.AnimationView.Player;
import java.lang.ref.WeakReference;

public final class ScrollPlayer
  extends AnimationView.Player
{
  public static boolean a;
  
  public ScrollPlayer(AnimationView paramAnimationView)
  {
    super(paramAnimationView);
  }
  
  public static void a(boolean paramBoolean)
  {
    jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void a(AnimationView paramAnimationView)
  {
    reset();
    this.jdField_a_of_type_JavaLangRefWeakReference.clear();
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramAnimationView);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      if (jdField_a_of_type_Boolean)
      {
        paramMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1);
        this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramMessage, 500L);
      }
      else
      {
        a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.qwallet.ScrollPlayer
 * JD-Core Version:    0.7.0.1
 */