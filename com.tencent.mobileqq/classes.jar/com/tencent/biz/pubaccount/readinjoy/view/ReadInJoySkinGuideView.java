package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;
import com.tencent.qphone.base.util.QLog;
import mjg;

public class ReadInJoySkinGuideView
  extends RelativeLayout
{
  private int a;
  public MediaPlayer a;
  public SpriteGLView a;
  protected boolean a;
  
  public ReadInJoySkinGuideView(Context paramContext, QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = 2;
    LayoutInflater.from(getContext()).inflate(2130971483, this);
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView = ((SpriteGLView)findViewById(2131374899));
    setClickable(true);
    if (260 == paramInt) {
      this.jdField_a_of_type_Int = 1;
    }
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.b = true;
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.post(new mjg(this, paramQQAppInterface, paramString2, paramOnClickListener1, paramString1, paramOnClickListener2, paramContext));
  }
  
  public void a()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.n();
    }
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null) {}
    try
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
      this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("ReadInJoySkinGuideView", 2, QLog.getStackTraceString(localException));
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null) {}
    try
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.pause();
      this.jdField_a_of_type_AndroidMediaMediaPlayer.seekTo(0);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("ReadInJoySkinGuideView", 2, QLog.getStackTraceString(localException));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoySkinGuideView
 * JD-Core Version:    0.7.0.1
 */