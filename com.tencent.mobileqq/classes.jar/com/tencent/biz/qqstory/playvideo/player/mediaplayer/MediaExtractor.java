package com.tencent.biz.qqstory.playvideo.player.mediaplayer;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaFormat;
import android.net.Uri;
import java.nio.ByteBuffer;
import java.util.Map;

public class MediaExtractor
{
  private android.media.MediaExtractor a;
  
  public MediaExtractor()
  {
    a();
  }
  
  public final int a()
  {
    return this.a.getTrackCount();
  }
  
  public int a(ByteBuffer paramByteBuffer, int paramInt)
  {
    return this.a.readSampleData(paramByteBuffer, paramInt);
  }
  
  public long a()
  {
    return this.a.getSampleTime();
  }
  
  @TargetApi(16)
  public MediaFormat a(int paramInt)
  {
    MediaFormat localMediaFormat = this.a.getTrackFormat(paramInt);
    if (localMediaFormat.getString("mime").startsWith("video/")) {
      localMediaFormat.setFloat("mpx-dar", localMediaFormat.getInteger("width") / localMediaFormat.getInteger("height"));
    }
    return localMediaFormat;
  }
  
  @TargetApi(16)
  protected void a()
  {
    if (this.a != null) {
      this.a.release();
    }
    this.a = new android.media.MediaExtractor();
  }
  
  public void a(int paramInt)
  {
    this.a.selectTrack(paramInt);
  }
  
  public void a(long paramLong, int paramInt)
  {
    this.a.seekTo(paramLong, paramInt);
  }
  
  public final void a(Context paramContext, Uri paramUri, Map paramMap)
  {
    this.a.setDataSource(paramContext, paramUri, paramMap);
  }
  
  public boolean a()
  {
    return this.a.advance();
  }
  
  public int b()
  {
    return this.a.getSampleTrackIndex();
  }
  
  public long b()
  {
    return this.a.getCachedDuration();
  }
  
  public void b()
  {
    this.a.release();
  }
  
  public boolean b()
  {
    return this.a.hasCacheReachedEndOfStream();
  }
  
  public boolean c()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.mediaplayer.MediaExtractor
 * JD-Core Version:    0.7.0.1
 */