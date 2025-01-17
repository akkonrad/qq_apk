package com.tencent.av.ui;

import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.SimpleOnScaleGestureListener;
import com.tencent.qphone.base.util.QLog;

public class VideoLayerUI$ScaleGestureListener
  extends ScaleGestureDetector.SimpleOnScaleGestureListener
{
  public VideoLayerUI$ScaleGestureListener(VideoLayerUI paramVideoLayerUI) {}
  
  public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "onScale");
    }
    if (VideoLayerUI.a(this.a) < 0) {
      VideoLayerUI.a(this.a, (int)paramScaleGestureDetector.getFocusX());
    }
    if (VideoLayerUI.b(this.a) < 0) {
      VideoLayerUI.b(this.a, (int)paramScaleGestureDetector.getFocusY());
    }
    float f = paramScaleGestureDetector.getScaleFactor();
    this.a.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].a(f, VideoLayerUI.a(this.a), VideoLayerUI.b(this.a));
    return true;
  }
  
  public void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "onScaleEnd");
    }
    float f1 = this.a.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].c();
    float f2 = this.a.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].a();
    float f3 = this.a.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].b();
    if (f1 < f2) {
      VideoLayerUI.a(this.a, this.a.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0], f2 / f1, 60L);
    }
    while (f1 <= f3) {
      return;
    }
    VideoLayerUI.a(this.a, this.a.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0], f3 / f1, 60L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.ui.VideoLayerUI.ScaleGestureListener
 * JD-Core Version:    0.7.0.1
 */