package com.tencent.biz.qqstory.takevideo.doodle.ui.doodle;

import android.annotation.TargetApi;
import android.graphics.PointF;
import android.opengl.GLES20;
import android.opengl.GLES30;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.Frame;
import com.tencent.mobileqq.shortvideo.ptvfilter.utils.VideoFilterUtil;

public class PersonalityUtils
{
  public static double a(PointF paramPointF1, PointF paramPointF2)
  {
    return Math.sqrt((paramPointF1.x - paramPointF2.x) * (paramPointF1.x - paramPointF2.x) + (paramPointF1.y - paramPointF2.y) * (paramPointF1.y - paramPointF2.y));
  }
  
  public static void a()
  {
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    GLES20.glClear(16640);
    GLES20.glFlush();
  }
  
  @TargetApi(18)
  public static void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      GLES20.glDisable(3042);
      return;
    case 1: 
      GLES20.glEnable(3042);
      GLES20.glBlendFunc(1, 771);
      GLES20.glBlendEquation(32774);
      return;
    case 2: 
      GLES20.glEnable(3042);
      GLES20.glBlendFunc(770, 771);
      GLES30.glBlendEquation(32776);
      return;
    }
    GLES20.glEnable(3042);
    GLES20.glBlendFuncSeparate(1, 771, 1, 1);
    GLES20.glBlendEquation(32774);
  }
  
  public static void a(BaseFilter paramBaseFilter, Frame paramFrame1, Frame paramFrame2, int paramInt1, int paramInt2, int paramInt3)
  {
    Frame localFrame = new Frame(paramFrame1.getFBO(), paramFrame1.getTextureId(), paramInt2, paramInt3);
    VideoFilterUtil.a(true);
    GLES20.glBlendEquation(32774);
    GLES20.glBindFramebuffer(36160, paramFrame1.getFBO());
    GLES20.glViewport(0, 0, paramInt2, paramInt3);
    paramFrame2.bindFrame(paramInt1, paramInt2, paramInt3, 1.0D);
    paramBaseFilter.RenderProcess(paramFrame2.getTextureId(), paramInt2, paramInt3, paramFrame1.getTextureId(), 1.0D, localFrame);
    VideoFilterUtil.a(false);
  }
  
  public static void a(Frame paramFrame, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    paramFrame.bindFrame(paramInt1, paramInt2, paramInt3, 1.0D);
    GLES20.glBindFramebuffer(36160, paramFrame.getFBO());
    GLES20.glViewport(0, 0, paramInt2, paramInt3);
    if (paramBoolean) {
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.PersonalityUtils
 * JD-Core Version:    0.7.0.1
 */