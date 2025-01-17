package com.tencent.ttpic.util;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnSeekCompleteListener;
import android.media.MediaRecorder;
import android.media.MediaRecorder.OnErrorListener;
import android.net.Uri;
import java.io.IOException;

public class AudioUtils
{
  private static AudioManager sManager;
  
  public static Player createPlayer(Context paramContext, String paramString, boolean paramBoolean)
  {
    if (paramString.startsWith("assets://")) {
      return createPlayerFromAssets(paramContext, VideoUtil.getRealPath(paramString), paramBoolean);
    }
    return createPlayerFromUri(paramContext, paramString, paramBoolean);
  }
  
  public static Player createPlayerFromAssets(Context paramContext, String paramString, boolean paramBoolean)
  {
    try
    {
      localPlayer = new Player();
      destroyPlayer(paramContext);
    }
    catch (IOException paramContext)
    {
      try
      {
        paramContext = paramContext.getAssets().openFd(paramString);
        localPlayer.setDataSource(paramContext.getFileDescriptor(), paramContext.getStartOffset(), paramContext.getLength());
        paramContext.close();
        preparePlayer(localPlayer, paramBoolean);
        return localPlayer;
      }
      catch (IOException paramContext)
      {
        for (;;)
        {
          Player localPlayer;
          paramContext = localPlayer;
        }
      }
      paramContext = paramContext;
      paramContext = null;
    }
    return null;
  }
  
  public static Player createPlayerFromUri(Context paramContext, String paramString, boolean paramBoolean)
  {
    Object localObject = null;
    try
    {
      localPlayer = new Player();
      destroyPlayer(paramContext);
    }
    catch (Exception paramContext)
    {
      try
      {
        localPlayer.setDataSource(paramContext, Uri.parse(paramString));
        preparePlayer(localPlayer, paramBoolean);
        return localPlayer;
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          Player localPlayer;
          paramContext = localPlayer;
        }
      }
      paramContext = paramContext;
      paramContext = localObject;
    }
    return null;
  }
  
  public static Recorder createRecorder(String paramString)
  {
    Object localObject = null;
    try
    {
      localRecorder = new Recorder();
      destroyRecorder(paramString);
    }
    catch (Exception paramString)
    {
      try
      {
        localRecorder.setOutputFile(paramString);
        localRecorder.setAudioSource(1);
        localRecorder.setAudioChannels(1);
        localRecorder.setAudioSamplingRate(44100);
        localRecorder.setAudioEncodingBitRate(96000);
        localRecorder.setOutputFormat(2);
        localRecorder.setAudioEncoder(3);
        localRecorder.setOnErrorListener(new MediaRecorder.OnErrorListener()
        {
          public void onError(MediaRecorder paramAnonymousMediaRecorder, int paramAnonymousInt1, int paramAnonymousInt2)
          {
            AudioUtils.destroyRecorder((AudioUtils.Recorder)paramAnonymousMediaRecorder);
          }
        });
        localRecorder.prepare();
        return localRecorder;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          Recorder localRecorder;
          paramString = localRecorder;
        }
      }
      paramString = paramString;
      paramString = localObject;
    }
    return paramString;
  }
  
  public static void destroyPlayer(Player paramPlayer)
  {
    if (paramPlayer != null)
    {
      paramPlayer.stop();
      paramPlayer.reset();
      paramPlayer.release();
    }
  }
  
  public static void destroyRecorder(Recorder paramRecorder)
  {
    if (paramRecorder != null)
    {
      paramRecorder.stop();
      paramRecorder.reset();
      paramRecorder.release();
    }
  }
  
  private static AudioManager getAudioManager(Context paramContext)
  {
    if (sManager == null) {
      sManager = (AudioManager)paramContext.getSystemService("audio");
    }
    return sManager;
  }
  
  public static int getMaxVolume(Context paramContext)
  {
    return getAudioManager(paramContext).getStreamMaxVolume(3);
  }
  
  public static int getVolume(Context paramContext)
  {
    return getAudioManager(paramContext).getStreamVolume(3);
  }
  
  public static boolean isSilentMode(Context paramContext)
  {
    switch (getAudioManager(paramContext).getRingerMode())
    {
    case 2: 
    default: 
      return false;
    case 0: 
      return true;
    }
    return true;
  }
  
  private boolean isSupportedAudioSamplingRate(int paramInt)
  {
    return AudioRecord.getMinBufferSize(paramInt, 16, 2) > 0;
  }
  
  private static void preparePlayer(Player paramPlayer, boolean paramBoolean)
    throws IOException
  {
    paramPlayer.setAudioStreamType(3);
    paramPlayer.setLooping(paramBoolean);
    paramPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
    {
      public void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
      {
        AudioUtils.Player.access$002((AudioUtils.Player)paramAnonymousMediaPlayer, false);
      }
    });
    paramPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener()
    {
      public boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AudioUtils.destroyPlayer((AudioUtils.Player)paramAnonymousMediaPlayer);
        return true;
      }
    });
    paramPlayer.prepare();
  }
  
  public static void seekPlayer(Player paramPlayer, int paramInt)
  {
    if (paramPlayer != null)
    {
      paramPlayer.setOnSeekCompleteListener(new MediaPlayer.OnSeekCompleteListener()
      {
        public void onSeekComplete(MediaPlayer paramAnonymousMediaPlayer)
        {
          ((AudioUtils.Player)paramAnonymousMediaPlayer).start();
        }
      });
      paramPlayer.seekTo(paramInt);
    }
  }
  
  public static void setMute(Context paramContext, boolean paramBoolean)
  {
    getAudioManager(paramContext).setStreamMute(3, paramBoolean);
  }
  
  public static void setVolume(Context paramContext, int paramInt)
  {
    getAudioManager(paramContext).setStreamVolume(3, Math.min(Math.max(paramInt, 0), getMaxVolume(paramContext)), 8);
  }
  
  public static void startPlayer(Player paramPlayer, boolean paramBoolean)
  {
    if (paramPlayer != null)
    {
      if (paramBoolean)
      {
        paramPlayer.setOnSeekCompleteListener(new MediaPlayer.OnSeekCompleteListener()
        {
          public void onSeekComplete(MediaPlayer paramAnonymousMediaPlayer)
          {
            ((AudioUtils.Player)paramAnonymousMediaPlayer).start();
          }
        });
        paramPlayer.seekTo(0);
      }
    }
    else {
      return;
    }
    paramPlayer.start();
  }
  
  public static void startRecorder(Recorder paramRecorder)
  {
    if (paramRecorder != null) {
      paramRecorder.start();
    }
  }
  
  public static void stopPlayer(Player paramPlayer)
  {
    if (paramPlayer != null) {
      paramPlayer.pause();
    }
  }
  
  public static class Player
    extends MediaPlayer
  {
    private boolean isPlaying;
    
    public boolean isPlaying()
    {
      return this.isPlaying;
    }
    
    public void pause()
    {
      if (!this.isPlaying) {
        return;
      }
      try
      {
        super.pause();
        this.isPlaying = false;
        return;
      }
      catch (Exception localException) {}
    }
    
    public void release()
    {
      try
      {
        super.release();
        this.isPlaying = false;
        return;
      }
      catch (Exception localException) {}
    }
    
    public void reset()
    {
      try
      {
        super.reset();
        this.isPlaying = false;
        return;
      }
      catch (Exception localException) {}
    }
    
    public void seekTo(int paramInt)
    {
      try
      {
        super.seekTo(paramInt);
        return;
      }
      catch (Exception localException) {}
    }
    
    public void start()
    {
      if (this.isPlaying) {
        return;
      }
      try
      {
        super.start();
        this.isPlaying = true;
        return;
      }
      catch (Exception localException) {}
    }
    
    public void stop()
    {
      try
      {
        super.stop();
        this.isPlaying = false;
        return;
      }
      catch (Exception localException) {}
    }
  }
  
  public static class Recorder
    extends MediaRecorder
  {
    private boolean isRecording;
    
    public boolean isRecording()
    {
      return this.isRecording;
    }
    
    public void release()
    {
      try
      {
        super.release();
        this.isRecording = false;
        return;
      }
      catch (Exception localException) {}
    }
    
    public void reset()
    {
      if (!this.isRecording) {
        return;
      }
      try
      {
        super.reset();
        this.isRecording = false;
        return;
      }
      catch (Exception localException) {}
    }
    
    public void start()
    {
      if (this.isRecording) {
        return;
      }
      try
      {
        super.start();
        this.isRecording = true;
        return;
      }
      catch (Exception localException) {}
    }
    
    public void stop()
    {
      if (!this.isRecording) {
        return;
      }
      try
      {
        super.stop();
        this.isRecording = false;
        return;
      }
      catch (Exception localException) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.util.AudioUtils
 * JD-Core Version:    0.7.0.1
 */