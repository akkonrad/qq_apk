package com.tencent.biz.qqstory.playvideo.player.mediaplayer;

import android.os.Build.VERSION;

public class MediaPlayer$VideoRenderTimingMode
{
  public static boolean a(int paramInt)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    switch (paramInt)
    {
    default: 
      bool1 = false;
    case 3: 
    case 1: 
      do
      {
        return bool1;
        bool1 = bool2;
      } while (Build.VERSION.SDK_INT >= 21);
      return false;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.mediaplayer.MediaPlayer.VideoRenderTimingMode
 * JD-Core Version:    0.7.0.1
 */