package com.tencent.biz.qqstory.takevideo;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Message;
import android.support.annotation.NonNull;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.biz.qqstory.playvideo.player.TrimTextureVideoView;
import com.tencent.biz.qqstory.playvideo.player.TrimTextureVideoView.OnPlayRecycleListener;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper.IMediaPlayer;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper.IMediaPlayer.OnPreparedListener;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.takevideo.localmedia.demos.MediaCodecThumbnailGenerator;
import com.tencent.biz.qqstory.takevideo.publish.GenerateContext;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.richmedia.QQStoryFlowCallback;
import com.tencent.mobileqq.shortvideo.widget.ImageViewVideoPlayer.IMPFrameListener;
import com.tencent.mobileqq.shortvideo.widget.ImageViewVideoPlayer.IMPlayerEndListener;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.List;
import ocz;
import oda;
import odb;

@TargetApi(14)
public class EditLocalVideoPlayer
  extends EditVideoPart
  implements TrimTextureVideoView.OnPlayRecycleListener, IMediaPlayer.OnPreparedListener, EditVideoPlayerExport, ImageViewVideoPlayer.IMPFrameListener, ImageViewVideoPlayer.IMPlayerEndListener
{
  protected int a;
  public ImageView a;
  public TextView a;
  protected TrimTextureVideoView a;
  protected MediaCodecThumbnailGenerator a;
  protected String a;
  protected boolean a;
  public EditLocalVideoPlayer.PlayerContext[] a;
  protected int b;
  protected boolean b;
  
  public EditLocalVideoPlayer(@NonNull EditVideoPartManager paramEditVideoPartManager)
  {
    super(paramEditVideoPartManager);
  }
  
  public void L_() {}
  
  public void M_()
  {
    super.M_();
  }
  
  public long a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_ArrayOfComTencentBizQqstoryTakevideoEditLocalVideoPlayer$PlayerContext.length)) {
      throw new IllegalArgumentException("getDurationOfFragment 传入了错误的index: " + paramInt);
    }
    EditLocalVideoPlayer.PlayerContext localPlayerContext = this.jdField_a_of_type_ArrayOfComTencentBizQqstoryTakevideoEditLocalVideoPlayer$PlayerContext[paramInt];
    return localPlayerContext.jdField_b_of_type_Int - localPlayerContext.jdField_a_of_type_Int;
  }
  
  public Bitmap a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_ArrayOfComTencentBizQqstoryTakevideoEditLocalVideoPlayer$PlayerContext.length)) {
      throw new IllegalArgumentException("getDurationOfFragment 传入了错误的index: " + paramInt);
    }
    EditLocalVideoPlayer.PlayerContext localPlayerContext = this.jdField_a_of_type_ArrayOfComTencentBizQqstoryTakevideoEditLocalVideoPlayer$PlayerContext[paramInt];
    if (localPlayerContext.c.isRecycled()) {
      SLog.e("Q.qqstory.record.EditLocalVideoPlayer", "自己的bitmap被外边recycle了!");
    }
    return localPlayerContext.c;
  }
  
  protected Bitmap a(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return null;
    }
    return Bitmap.createBitmap(paramBitmap);
  }
  
  public List a()
  {
    EditLocalVideoPlayer.PlayerContext[] arrayOfPlayerContext = new EditLocalVideoPlayer.PlayerContext[this.jdField_a_of_type_ArrayOfComTencentBizQqstoryTakevideoEditLocalVideoPlayer$PlayerContext.length];
    int i = 0;
    while (i < arrayOfPlayerContext.length)
    {
      arrayOfPlayerContext[i] = EditLocalVideoPlayer.PlayerContext.a(this.jdField_a_of_type_ArrayOfComTencentBizQqstoryTakevideoEditLocalVideoPlayer$PlayerContext[i], a(this.jdField_a_of_type_ArrayOfComTencentBizQqstoryTakevideoEditLocalVideoPlayer$PlayerContext[i].c));
      i += 1;
    }
    return Arrays.asList(arrayOfPlayerContext);
  }
  
  public void a()
  {
    super.a();
    if ((!this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a.d()) || (!this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a.b())) {
      return;
    }
    Object localObject = (EditLocalVideoSource)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource;
    int k = ((EditLocalVideoSource)localObject).jdField_a_of_type_Int;
    int m = ((EditLocalVideoSource)localObject).jdField_b_of_type_Int;
    long l = ((EditLocalVideoSource)localObject).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration;
    int n = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a.c();
    this.jdField_a_of_type_ArrayOfComTencentBizQqstoryTakevideoEditLocalVideoPlayer$PlayerContext = new EditLocalVideoPlayer.PlayerContext[n];
    SLog.a("Q.qqstory.record.EditLocalVideoPlayer", "onCreate EditSource fragmentCount is %d", Integer.valueOf(n));
    int i = 0;
    int j = k;
    while (i < n)
    {
      this.jdField_a_of_type_ArrayOfComTencentBizQqstoryTakevideoEditLocalVideoPlayer$PlayerContext[i] = new EditLocalVideoPlayer.PlayerContext(i, null);
      EditLocalVideoPlayer.PlayerContext localPlayerContext = this.jdField_a_of_type_ArrayOfComTencentBizQqstoryTakevideoEditLocalVideoPlayer$PlayerContext[i];
      localPlayerContext.jdField_a_of_type_Int = j;
      localPlayerContext.jdField_b_of_type_Int = Math.min(j + 10000, m);
      if (i == n - 1) {
        localPlayerContext.jdField_b_of_type_Int = m;
      }
      j += 10000;
      i += 1;
    }
    this.jdField_a_of_type_Int = ((EditLocalVideoSource)localObject).jdField_a_of_type_Int;
    this.jdField_b_of_type_Int = ((EditLocalVideoSource)localObject).jdField_b_of_type_Int;
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTrimTextureVideoView = ((TrimTextureVideoView)a(2131364407));
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTrimTextureVideoView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131364452));
    this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131364349));
    this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    if (QQStoryFlowCallback.a != null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(QQStoryFlowCallback.a);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      SLog.b("Q.qqstory.record.EditLocalVideoPlayer", "onCreate mBackgroundImage.setImageBitmap()");
    }
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTrimTextureVideoView.setOnRecyclePlayListener(this);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTrimTextureVideoView.setOnPreparedListener(this);
    if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a.jdField_a_of_type_Int != 10) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a.jdField_a_of_type_Int != 12)) {
      this.jdField_b_of_type_Boolean = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTrimTextureVideoView.a(((EditLocalVideoSource)localObject).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.rotation, ((EditLocalVideoSource)localObject).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaWidth, ((EditLocalVideoSource)localObject).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaHeight);
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a();
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTrimTextureVideoView.setVideoPath(this.jdField_a_of_type_JavaLangString);
      localObject = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a.a("extra_upload_temp_directory");
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoLocalmediaDemosMediaCodecThumbnailGenerator = new MediaCodecThumbnailGenerator();
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoLocalmediaDemosMediaCodecThumbnailGenerator.a();
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoLocalmediaDemosMediaCodecThumbnailGenerator.a(this.jdField_a_of_type_JavaLangString, (String)localObject, this.jdField_b_of_type_Boolean, 480, k, 10000, n, true, new ocz(this), new oda(this, l, m));
      StoryReportor.a("video_edit", "edit_local", 0, 0, new String[0]);
      a(EditVideoPlayerExport.class, this);
      return;
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTrimTextureVideoView.setCenterInside(true);
      this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
    }
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2, float paramFloat) {}
  
  public void a(int paramInt, @NonNull GenerateContext paramGenerateContext)
  {
    if ((paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource))
    {
      paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.hasFragments = true;
      SLog.b("Q.qqstory.record.EditLocalVideoPlayer", "editVideoPrePublish(%d) -> %s", Integer.valueOf(paramInt), this.jdField_a_of_type_ArrayOfComTencentBizQqstoryTakevideoEditLocalVideoPlayer$PlayerContext[paramInt]);
      paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoNeedRotate = this.jdField_b_of_type_Boolean;
      paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoRangeStart = this.jdField_a_of_type_ArrayOfComTencentBizQqstoryTakevideoEditLocalVideoPlayer$PlayerContext[paramInt].jdField_a_of_type_Int;
      paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoRangeEnd = this.jdField_a_of_type_ArrayOfComTencentBizQqstoryTakevideoEditLocalVideoPlayer$PlayerContext[paramInt].jdField_b_of_type_Int;
    }
  }
  
  public void a(int paramInt, Object paramObject)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTrimTextureVideoView == null) {
      return;
    }
    switch (paramInt)
    {
    case 10: 
    case 2: 
    case 5: 
    case 7: 
    case 8: 
    case 9: 
    default: 
      b(false);
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTrimTextureVideoView.b();
  }
  
  public void a(int paramInt, byte[] paramArrayOfByte) {}
  
  public void a(Bitmap paramBitmap) {}
  
  public void a(Bitmap paramBitmap, boolean paramBoolean) {}
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ArrayOfComTencentBizQqstoryTakevideoEditLocalVideoPlayer$PlayerContext[this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a()].jdField_a_of_type_Boolean = paramBoolean;
    b(false);
  }
  
  protected boolean a(Message paramMessage)
  {
    if (paramMessage.what == 3)
    {
      switch (paramMessage.arg1)
      {
      default: 
        return true;
      case 1: 
        b(false);
        return true;
      case 2: 
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTrimTextureVideoView.b();
        return true;
      }
      b(true);
      return true;
    }
    int i;
    if (paramMessage.what == 6)
    {
      i = paramMessage.arg2;
      if ((this.jdField_a_of_type_ArrayOfComTencentBizQqstoryTakevideoEditLocalVideoPlayer$PlayerContext == null) || (i >= this.jdField_a_of_type_ArrayOfComTencentBizQqstoryTakevideoEditLocalVideoPlayer$PlayerContext.length) || (this.jdField_a_of_type_ArrayOfComTencentBizQqstoryTakevideoEditLocalVideoPlayer$PlayerContext[i].jdField_b_of_type_Boolean))
      {
        SLog.e("Q.qqstory.record.EditLocalVideoPlayer", "Error! PlayerContext is illegal %s index=%d", new Object[] { Arrays.toString(this.jdField_a_of_type_ArrayOfComTencentBizQqstoryTakevideoEditLocalVideoPlayer$PlayerContext), Integer.valueOf(i) });
        return false;
      }
      b(true);
      return true;
    }
    if (paramMessage.what == 7)
    {
      i = paramMessage.arg1;
      if ((this.jdField_a_of_type_ArrayOfComTencentBizQqstoryTakevideoEditLocalVideoPlayer$PlayerContext == null) || (i >= this.jdField_a_of_type_ArrayOfComTencentBizQqstoryTakevideoEditLocalVideoPlayer$PlayerContext.length))
      {
        SLog.e("Q.qqstory.record.EditLocalVideoPlayer", "Error! PlayerContext is illegal %s index=%d", new Object[] { Arrays.toString(this.jdField_a_of_type_ArrayOfComTencentBizQqstoryTakevideoEditLocalVideoPlayer$PlayerContext), Integer.valueOf(i) });
        return false;
      }
      this.jdField_a_of_type_ArrayOfComTencentBizQqstoryTakevideoEditLocalVideoPlayer$PlayerContext[i].jdField_b_of_type_Boolean = true;
      SLog.b("Q.qqstory.record.EditLocalVideoPlayer", "PlayerContext %d Deleted!", Integer.valueOf(i));
      return true;
    }
    return false;
  }
  
  public void a_(IMediaPlayer paramIMediaPlayer)
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.postDelayed(new odb(this), 300L);
    }
    SLog.a("Q.qqstory.record.EditLocalVideoPlayer", "onPrepared %s", this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a());
    this.jdField_a_of_type_Boolean = true;
    b(true);
  }
  
  public void aa_() {}
  
  public void b(int paramInt) {}
  
  protected void b(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTrimTextureVideoView == null) || (!this.jdField_a_of_type_Boolean)) {
      return;
    }
    int i = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a();
    if ((this.jdField_a_of_type_ArrayOfComTencentBizQqstoryTakevideoEditLocalVideoPlayer$PlayerContext == null) || (i >= this.jdField_a_of_type_ArrayOfComTencentBizQqstoryTakevideoEditLocalVideoPlayer$PlayerContext.length) || (this.jdField_a_of_type_ArrayOfComTencentBizQqstoryTakevideoEditLocalVideoPlayer$PlayerContext[i].jdField_b_of_type_Boolean))
    {
      SLog.e("Q.qqstory.record.EditLocalVideoPlayer", "Error! resumePlay(%b): PlayerContext is illegal %s index=%d", new Object[] { Boolean.valueOf(paramBoolean), Arrays.toString(this.jdField_a_of_type_ArrayOfComTencentBizQqstoryTakevideoEditLocalVideoPlayer$PlayerContext), Integer.valueOf(i) });
      return;
    }
    EditLocalVideoPlayer.PlayerContext localPlayerContext = this.jdField_a_of_type_ArrayOfComTencentBizQqstoryTakevideoEditLocalVideoPlayer$PlayerContext[i];
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTrimTextureVideoView.setPlayRange(localPlayerContext.jdField_a_of_type_Int, localPlayerContext.jdField_b_of_type_Int);
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTrimTextureVideoView.b(localPlayerContext.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTrimTextureVideoView.a(true);
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTrimTextureVideoView.b(localPlayerContext.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTrimTextureVideoView.a(false);
  }
  
  public void c()
  {
    EditMusicExport localEditMusicExport = (EditMusicExport)a(EditMusicExport.class);
    if (localEditMusicExport != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("zivonchen", 2, "onPlayRecycle()");
      }
      localEditMusicExport.b();
    }
  }
  
  public void d()
  {
    super.d();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoLocalmediaDemosMediaCodecThumbnailGenerator.b();
  }
  
  public void e() {}
  
  public void f()
  {
    super.f();
    b(false);
  }
  
  public void g()
  {
    super.g();
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTrimTextureVideoView == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTrimTextureVideoView.b();
  }
  
  public void h()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(Message.obtain(null, 8));
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTrimTextureVideoView == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTrimTextureVideoView.b();
  }
  
  public void j()
  {
    b(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditLocalVideoPlayer
 * JD-Core Version:    0.7.0.1
 */