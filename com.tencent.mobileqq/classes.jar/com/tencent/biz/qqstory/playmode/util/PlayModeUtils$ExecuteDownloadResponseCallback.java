package com.tencent.biz.qqstory.playmode.util;

import android.os.SystemClock;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.FileUtils;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegExecuteResponseCallback;
import com.tencent.qphone.base.util.BaseApplication;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;
import java.io.File;

public class PlayModeUtils$ExecuteDownloadResponseCallback
  implements FFmpegExecuteResponseCallback
{
  public long a;
  public StoryVideoItem a;
  public String a;
  public String b;
  
  public PlayModeUtils$ExecuteDownloadResponseCallback(String paramString1, StoryVideoItem paramStoryVideoItem, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = paramStoryVideoItem;
    this.b = paramString2;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
    PlayModeUtils.DownloadStatusChangeEvent localDownloadStatusChangeEvent = new PlayModeUtils.DownloadStatusChangeEvent(this.b, 0, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
    Dispatchers.get().dispatch(localDownloadStatusChangeEvent);
  }
  
  public void a(String paramString)
  {
    paramString = new PlayModeUtils.DownloadStatusChangeEvent(this.b, 2, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
    paramString.b = this.jdField_a_of_type_JavaLangString;
    Dispatchers.get().dispatch(paramString);
    long l1 = SystemClock.uptimeMillis();
    long l2 = this.jdField_a_of_type_Long;
    long l3 = this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoDuration;
    StoryReportor.a("play_video", "down_suc", 0, 0, new String[] { "", "", "", this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
    StoryReportor.a("play_video", "down_watermark_time", 0, 0, new String[] { String.valueOf(l1 - l2), String.valueOf(l3) });
    StoryReportor.a("play_video", "down_watermark", 0, 0, new String[0]);
    FileUtils.a(BaseApplication.getContext(), new File(this.jdField_a_of_type_JavaLangString));
  }
  
  public void a(boolean paramBoolean) {}
  
  public void b(String paramString)
  {
    paramString = new PlayModeUtils.DownloadStatusChangeEvent(this.b, 3, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
    Dispatchers.get().dispatch(paramString);
    StoryReportor.a("play_video", "down_fail", 0, 0, new String[] { "", "", "", this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
    StoryReportor.a("play_video", "down_watermark", 0, 1, new String[0]);
  }
  
  public void c(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.util.PlayModeUtils.ExecuteDownloadResponseCallback
 * JD-Core Version:    0.7.0.1
 */