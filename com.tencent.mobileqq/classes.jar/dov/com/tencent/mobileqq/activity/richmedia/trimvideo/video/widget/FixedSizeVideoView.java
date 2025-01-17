package dov.com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget;

import android.content.Context;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.VideoView;
import aohw;
import aohx;

public class FixedSizeVideoView
  extends VideoView
  implements Handler.Callback
{
  private int jdField_a_of_type_Int = -1;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
  public FixedSizeVideoView.OnTrimVDPlayCompelteListener a;
  private int b;
  private int c;
  
  public FixedSizeVideoView(Context paramContext)
  {
    super(paramContext);
    super.setOnCompletionListener(new aohw(this));
  }
  
  public FixedSizeVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    super.setOnCompletionListener(new aohx(this));
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      if (this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView$OnTrimVDPlayCompelteListener != null) {
        this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView$OnTrimVDPlayCompelteListener.a(this, this.c, this.jdField_a_of_type_Int);
      }
    }
  }
  
  public void pause()
  {
    super.pause();
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
  }
  
  public void setOnCompletionListener(MediaPlayer.OnCompletionListener paramOnCompletionListener)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setOnFixVDPlayCompelteListener(FixedSizeVideoView.OnTrimVDPlayCompelteListener paramOnTrimVDPlayCompelteListener)
  {
    if (paramOnTrimVDPlayCompelteListener != null) {
      this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView$OnTrimVDPlayCompelteListener = paramOnTrimVDPlayCompelteListener;
    }
  }
  
  public void setPlayDuration(int paramInt)
  {
    setPlayDuration(0, paramInt);
  }
  
  public void setPlayDuration(int paramInt1, int paramInt2)
  {
    try
    {
      int i = getDuration();
      if (paramInt1 >= i) {
        return;
      }
      int j = paramInt2 + paramInt1;
      this.b = j;
      if (j > i) {
        this.b = i;
      }
      this.c = paramInt1;
      this.jdField_a_of_type_Int = paramInt2;
      seekTo(paramInt1);
      return;
    }
    catch (Exception localException) {}
  }
  
  public void start()
  {
    int i = getCurrentPosition();
    i = this.b - i;
    if (i >= 0)
    {
      super.start();
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.FixedSizeVideoView
 * JD-Core Version:    0.7.0.1
 */