package com.tencent.biz.qqstory.utils.ffmpeg;

import java.util.ArrayList;

final class FFmpegUtils$3
  extends ArrayList
{
  FFmpegUtils$3(String paramString1, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, String paramString2)
  {
    add(this.val$inputFilePath);
    add(Integer.valueOf(this.val$start));
    add(Integer.valueOf(this.val$duration));
    add(Integer.valueOf(this.val$bitrate));
    add(Boolean.valueOf(this.val$isMute));
    add(this.val$outputFilePath);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.ffmpeg.FFmpegUtils.3
 * JD-Core Version:    0.7.0.1
 */