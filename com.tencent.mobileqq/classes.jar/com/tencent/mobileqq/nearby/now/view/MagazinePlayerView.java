package com.tencent.mobileqq.nearby.now.view;

import aewy;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.now.ActCallBack;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.nearby.now.utils.ImageLoader;
import com.tencent.qphone.base.util.QLog;

public class MagazinePlayerView
  extends VideoPlayerView
{
  public ActCallBack a;
  public VideoData a;
  private String b = "MagazinePlayerView";
  private long d;
  
  public MagazinePlayerView(Context paramContext, ActCallBack paramActCallBack, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowActCallBack = paramActCallBack;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData == null)
    {
      QLog.w(this.b, 2, "pasue mShortVideoInfo is null!!");
      return;
    }
    super.a();
  }
  
  public void a(RelativeLayout paramRelativeLayout, VideoData paramVideoData, PlayResultListener paramPlayResultListener)
  {
    if (QLog.isColorLevel()) {
      QLog.i(this.b, 2, "play() called with: rootView = [" + paramRelativeLayout + "], videoData = [" + paramVideoData + "]");
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData = paramVideoData;
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewPlayResultListener = paramPlayResultListener;
    if (paramVideoData.a == 1)
    {
      a(paramRelativeLayout);
      this.d = 0L;
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      d();
      ImageLoader.a().a(this.jdField_a_of_type_AndroidWidgetImageView, paramVideoData.c, new ColorDrawable(0), new ColorDrawable(0), null);
      this.jdField_a_of_type_AndroidOsHandler.post(new aewy(this));
      return;
    }
    super.a(paramRelativeLayout, paramVideoData, paramPlayResultListener);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData == null) {}
    while (this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.a == 1) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowActCallBack != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowActCallBack.b();
    }
    super.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.MagazinePlayerView
 * JD-Core Version:    0.7.0.1
 */