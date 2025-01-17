package com.tencent.mobileqq.prediction;

import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import com.tencent.mobileqq.shortvideo.ShortVideoPreDownloader;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class PredictionReporter$EvaluatorInfo
{
  public int a;
  public long a;
  public boolean a;
  public int b;
  public long b;
  public boolean b;
  public boolean c;
  
  public PredictionReporter$EvaluatorInfo(QQAppInterface paramQQAppInterface, MessageForShortVideo paramMessageForShortVideo, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_Int = NetworkUtil.a(BaseApplication.getContext());
    this.jdField_a_of_type_Boolean = ShortVideoPreDownloader.a(paramQQAppInterface, paramMessageForShortVideo);
    if (paramMessageForShortVideo.videoAttr == 1) {}
    for (;;)
    {
      this.c = bool;
      paramQQAppInterface = (FriendsManager)paramQQAppInterface.getManager(50);
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface = paramQQAppInterface.c(String.valueOf(paramMessageForShortVideo.senderuin));
        if (paramQQAppInterface != null) {
          this.jdField_b_of_type_Boolean = paramQQAppInterface.isFriend();
        }
      }
      this.jdField_a_of_type_Long = paramLong1;
      this.jdField_b_of_type_Long = paramLong2;
      return;
      bool = false;
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder("doReport:");
      ((StringBuilder)localObject).append("mMsgViewedInAIOTime=").append(this.jdField_a_of_type_Long).append("|");
      ((StringBuilder)localObject).append("mMsgClickedTime=").append(this.jdField_b_of_type_Long).append("|");
      ((StringBuilder)localObject).append("mViewNetType=").append(this.jdField_a_of_type_Int).append("|");
      ((StringBuilder)localObject).append("mClickNetType=").append(this.jdField_b_of_type_Int).append("|");
      ((StringBuilder)localObject).append("mAutoDownload=").append(this.jdField_a_of_type_Boolean).append("|");
      ((StringBuilder)localObject).append("mIsFriend=").append(this.jdField_b_of_type_Boolean).append("|");
      ((StringBuilder)localObject).append("mIsHotVideo=").append(this.c).append("|");
      QLog.i("ShortVideoPredictionEvaluator", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new HashMap();
    ((HashMap)localObject).put(BaseConstants.RDM_NoChangeFailCode, "");
    ((HashMap)localObject).put("viewed_time", String.valueOf(this.jdField_a_of_type_Long));
    ((HashMap)localObject).put("click_time", String.valueOf(this.jdField_b_of_type_Long));
    ((HashMap)localObject).put("view_net", String.valueOf(this.jdField_a_of_type_Int));
    ((HashMap)localObject).put("click_net", String.valueOf(this.jdField_b_of_type_Int));
    ((HashMap)localObject).put("auto_download", String.valueOf(this.jdField_a_of_type_Boolean));
    ((HashMap)localObject).put("is_friend", String.valueOf(this.jdField_b_of_type_Boolean));
    ((HashMap)localObject).put("is_hot", String.valueOf(this.c));
    if (this.jdField_b_of_type_Long > 0L) {}
    for (boolean bool = true;; bool = false)
    {
      StatisticCollector.a(BaseApplication.getContext()).a(null, "actVideoMessageTime", bool, 0L, 0L, (HashMap)localObject, "");
      return;
    }
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_b_of_type_Long == 0L)
    {
      this.jdField_b_of_type_Long = paramLong;
      this.jdField_b_of_type_Int = NetworkUtil.a(BaseApplication.getContext());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.prediction.PredictionReporter.EvaluatorInfo
 * JD-Core Version:    0.7.0.1
 */