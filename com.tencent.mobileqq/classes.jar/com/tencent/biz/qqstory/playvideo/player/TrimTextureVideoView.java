package com.tencent.biz.qqstory.playvideo.player;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer.OnSeekCompleteListener;
import android.util.AttributeSet;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper.IMediaPlayer;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper.IMediaPlayer.OnSeekCompleteListener;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.TakeVideoUtils;
import nph;
import npi;
import npj;

public class TrimTextureVideoView
  extends TextureVideoView
  implements MediaPlayer.OnSeekCompleteListener, IMediaPlayer.OnSeekCompleteListener
{
  public static int h;
  private TrimTextureVideoView.OnPlayRecycleListener a;
  protected Runnable a;
  private IMediaPlayer.OnSeekCompleteListener b;
  protected Runnable b;
  protected boolean h;
  public int i;
  public boolean i;
  protected int j;
  protected boolean j;
  protected int k;
  public boolean k;
  public int l;
  protected int m;
  public int n;
  public int o;
  public int p;
  public int q;
  
  public TrimTextureVideoView(Context paramContext)
  {
    super(paramContext);
    this.jdField_j_of_type_Boolean = true;
    this.jdField_k_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangRunnable = new nph(this);
    this.jdField_b_of_type_JavaLangRunnable = new npi(this);
    d();
  }
  
  public TrimTextureVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_j_of_type_Boolean = true;
    this.jdField_k_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangRunnable = new nph(this);
    this.jdField_b_of_type_JavaLangRunnable = new npi(this);
    d();
  }
  
  public TrimTextureVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_j_of_type_Boolean = true;
    this.jdField_k_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangRunnable = new nph(this);
    this.jdField_b_of_type_JavaLangRunnable = new npi(this);
    d();
  }
  
  private void d()
  {
    int i1 = jdField_h_of_type_Int + 1;
    jdField_h_of_type_Int = i1;
    this.jdField_i_of_type_Int = i1;
    setOnErrorListener(new npj(this));
    super.setOnSeekCompleteListener(this);
  }
  
  public int a()
  {
    return this.jdField_k_of_type_Int;
  }
  
  protected IMediaPlayer a()
  {
    if (this.jdField_k_of_type_Boolean) {
      return new com.tencent.biz.qqstory.playvideo.player.mediaplayer.MediaPlayer();
    }
    return super.a();
  }
  
  public void a()
  {
    SLog.a(this.jdField_a_of_type_JavaLangString, "[%d]stopPlayback()", Integer.valueOf(this.jdField_i_of_type_Int));
    super.a();
  }
  
  public void a(IMediaPlayer paramIMediaPlayer)
  {
    this.jdField_j_of_type_Boolean = true;
    if ((this.jdField_j_of_type_Int != 0) && (this.l != 0))
    {
      int i1 = super.getCurrentPosition();
      if (i1 < this.l)
      {
        SLog.a(this.jdField_a_of_type_JavaLangString, "It need adjust start time,startTime=%s,currentPos=%s", Integer.valueOf(this.jdField_j_of_type_Int), Integer.valueOf(i1));
        this.jdField_k_of_type_Int = i1;
      }
    }
    if (this.jdField_b_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer$OnSeekCompleteListener != null) {
      this.jdField_b_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer$OnSeekCompleteListener.a(paramIMediaPlayer);
    }
    c();
  }
  
  public void a(boolean paramBoolean)
  {
    SLog.a(this.jdField_a_of_type_JavaLangString, "[%d]resumePlay(%b)", Integer.valueOf(this.jdField_i_of_type_Int), Boolean.valueOf(paramBoolean));
    if ((paramBoolean) || (!super.isPlaying()))
    {
      this.m = this.jdField_j_of_type_Int;
      super.seekTo(this.m);
      this.jdField_j_of_type_Boolean = false;
      if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTrimTextureVideoView$OnPlayRecycleListener != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTrimTextureVideoView$OnPlayRecycleListener.c();
      }
    }
    super.start();
  }
  
  @TargetApi(14)
  public boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.jdField_k_of_type_Boolean) && (com.tencent.biz.qqstory.playvideo.player.mediaplayer.MediaPlayer.b())) {}
    for (int i1 = 0 + paramInt1;; i1 = 0)
    {
      float f1;
      float f2;
      if (((paramInt1 % 180 > 0) && (paramInt2 < paramInt3)) || ((paramInt1 % 180 == 0) && (paramInt2 > paramInt3)))
      {
        setRotation(i1 + 90);
        f1 = 1.0F / TakeVideoUtils.a(getResources());
        f2 = Math.min(paramInt3, paramInt2) * 1.0F / Math.max(paramInt3, paramInt2);
        setScaleX(Math.max(f1, f2));
        setScaleY(Math.max(f1, f2));
        SLog.a(this.jdField_a_of_type_JavaLangString, "adjustRotation([rotation]%d, [width]%d, [height]%d), need rotate!", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3));
        return true;
      }
      if (i1 != 0)
      {
        setRotation(i1);
        f1 = 1.0F / TakeVideoUtils.a(getResources());
        f2 = Math.min(paramInt3, paramInt2) * 1.0F / Math.max(paramInt3, paramInt2);
        setScaleX(Math.max(f1, f2));
        setScaleY(Math.max(f1, f2));
        SLog.a(this.jdField_a_of_type_JavaLangString, "adjustRotation([rotation]%d, [width]%d, [height]%d), need rotate! but return false", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3));
        return false;
      }
      SLog.a(this.jdField_a_of_type_JavaLangString, "adjustRotation([rotation]%d, [width]%d, [height]%d), no need rotate!", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3));
      return false;
    }
  }
  
  public int b()
  {
    return this.jdField_j_of_type_Int;
  }
  
  @TargetApi(14)
  public void b()
  {
    SLog.a(this.jdField_a_of_type_JavaLangString, "[%d]pausePlay()", Integer.valueOf(this.jdField_i_of_type_Int));
    this.m = super.getCurrentPosition();
    removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    super.pause();
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_h_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer == null) {
      return;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer.a(0.0F, 0.0F);
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer.a(1.0F, 1.0F);
  }
  
  public int c()
  {
    return this.l;
  }
  
  @TargetApi(14)
  public void c()
  {
    if (this.l != 0)
    {
      removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      postDelayed(this.jdField_b_of_type_JavaLangRunnable, this.l - this.jdField_j_of_type_Int);
    }
  }
  
  @TargetApi(14)
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.jdField_i_of_type_Boolean = true;
    SLog.a(this.jdField_a_of_type_JavaLangString, "[%d]onAttachedToWindow! schedule!", Integer.valueOf(this.jdField_i_of_type_Int));
    post(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  @TargetApi(14)
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.jdField_i_of_type_Boolean = false;
    SLog.a(this.jdField_a_of_type_JavaLangString, "[%d]onDetachedFromWindow! cancel schedule!", Integer.valueOf(this.jdField_i_of_type_Int));
    removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  @Deprecated
  public void onSeekComplete(android.media.MediaPlayer paramMediaPlayer)
  {
    if ((this.jdField_j_of_type_Int != 0) && (this.l != 0))
    {
      int i1 = super.getCurrentPosition();
      if (i1 < this.l)
      {
        SLog.a(this.jdField_a_of_type_JavaLangString, "It need adjust start time,startTime=%s,currentPos=%s", Integer.valueOf(this.jdField_j_of_type_Int), Integer.valueOf(i1));
        this.jdField_k_of_type_Int = i1;
      }
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    SLog.a(this.jdField_a_of_type_JavaLangString, "onSizeChanged(%d, %d, %d, %d)", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4));
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    super.onSurfaceTextureAvailable(paramSurfaceTexture, paramInt1, paramInt2);
    b(this.jdField_h_of_type_Boolean);
  }
  
  public void setOnRecyclePlayListener(TrimTextureVideoView.OnPlayRecycleListener paramOnPlayRecycleListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTrimTextureVideoView$OnPlayRecycleListener = paramOnPlayRecycleListener;
  }
  
  public void setOnSeekCompleteListener(IMediaPlayer.OnSeekCompleteListener paramOnSeekCompleteListener)
  {
    this.jdField_b_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer$OnSeekCompleteListener = paramOnSeekCompleteListener;
  }
  
  public void setPlayRange(int paramInt1, int paramInt2)
  {
    SLog.a(this.jdField_a_of_type_JavaLangString, "[%d]setPlayRange(%d, %d)", Integer.valueOf(this.jdField_i_of_type_Int), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
    if ((isPlaying()) && ((paramInt1 != this.jdField_j_of_type_Int) || (paramInt2 != this.l)))
    {
      super.seekTo(this.jdField_j_of_type_Int);
      this.jdField_j_of_type_Boolean = false;
    }
    this.jdField_j_of_type_Int = paramInt1;
    this.jdField_k_of_type_Int = paramInt1;
    this.l = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.TrimTextureVideoView
 * JD-Core Version:    0.7.0.1
 */