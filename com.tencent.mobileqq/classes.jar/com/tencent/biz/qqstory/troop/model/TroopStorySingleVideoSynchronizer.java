package com.tencent.biz.qqstory.troop.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.download.DownloadUrlManager;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.model.DefaultPlayerVideoListSynchronizer;
import com.tencent.biz.qqstory.model.DefaultPlayerVideoListSynchronizer.PlayerVideoListEvent;
import com.tencent.biz.qqstory.model.DefaultPlayerVideoListSynchronizer.RetryableSynchronizer;
import com.tencent.biz.qqstory.model.IVidToVideoInfoPuller.OnFinishCallBack;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.request.GetVideoFullInfoListRequest;
import com.tencent.biz.qqstory.network.response.GetVideoFullInfoListResponse;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;
import onz;
import ooa;

public class TroopStorySingleVideoSynchronizer
  extends DefaultPlayerVideoListSynchronizer
  implements CmdTaskManger.CommandCallback, DefaultPlayerVideoListSynchronizer.RetryableSynchronizer
{
  IVidToVideoInfoPuller.OnFinishCallBack jdField_a_of_type_ComTencentBizQqstoryModelIVidToVideoInfoPuller$OnFinishCallBack;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  String jdField_a_of_type_JavaLangString;
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  String jdField_b_of_type_JavaLangString;
  boolean jdField_b_of_type_Boolean = false;
  
  public TroopStorySingleVideoSynchronizer(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
  }
  
  public void a(@NonNull GetVideoFullInfoListRequest paramGetVideoFullInfoListRequest, @Nullable GetVideoFullInfoListResponse paramGetVideoFullInfoListResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.troopstory.singleSync", 2, "onResp code=" + paramErrorMessage.errorCode);
    }
    paramGetVideoFullInfoListRequest = new StoryVideoItem();
    paramGetVideoFullInfoListRequest.mVid = this.jdField_b_of_type_JavaLangString;
    paramGetVideoFullInfoListRequest.mStoryType = 2;
    if ((paramGetVideoFullInfoListResponse != null) && (paramErrorMessage.isSuccess()))
    {
      paramGetVideoFullInfoListRequest = paramGetVideoFullInfoListResponse.jdField_a_of_type_JavaUtilList.iterator();
      while (paramGetVideoFullInfoListRequest.hasNext())
      {
        paramErrorMessage = (StoryVideoItem)paramGetVideoFullInfoListRequest.next();
        if (this.jdField_b_of_type_JavaLangString.equals(paramErrorMessage.mVid)) {
          if (paramErrorMessage.mErrorCode != 0) {
            break;
          }
        }
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        ((DownloadUrlManager)SuperManager.a(28)).a(paramGetVideoFullInfoListResponse.b);
        a(paramGetVideoFullInfoListResponse.jdField_a_of_type_JavaUtilList, false);
        return;
      }
      this.jdField_b_of_type_Boolean = true;
      if (paramGetVideoFullInfoListResponse == null) {}
      for (paramGetVideoFullInfoListRequest = new ArrayList();; paramGetVideoFullInfoListRequest = paramGetVideoFullInfoListResponse.jdField_a_of_type_JavaUtilList)
      {
        a(paramGetVideoFullInfoListRequest, false);
        return;
      }
    }
  }
  
  public void a(String paramString, IVidToVideoInfoPuller.OnFinishCallBack paramOnFinishCallBack)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.troopstory.singleSync", 2, "retry storyId=" + paramString);
    }
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentBizQqstoryModelIVidToVideoInfoPuller$OnFinishCallBack = paramOnFinishCallBack;
    paramOnFinishCallBack = new GetVideoFullInfoListRequest();
    paramOnFinishCallBack.jdField_a_of_type_JavaUtilList.add(paramString);
    CmdTaskManger.a().a(paramOnFinishCallBack, this);
  }
  
  protected void a(String paramString, StoryVideoItem paramStoryVideoItem)
  {
    if ((paramStoryVideoItem != null) && (!TextUtils.isEmpty(paramStoryVideoItem.mVideoUrl)) && (!TextUtils.isEmpty(paramStoryVideoItem.mVideoThumbnailUrl)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.troopstory.singleSync", 2, "url exist");
      }
      ThreadManager.getUIHandler().post(new onz(this, paramStoryVideoItem));
      return;
    }
    if ((paramStoryVideoItem != null) && (!TextUtils.isEmpty(paramStoryVideoItem.mLocalVideoPath)) && (new File(paramStoryVideoItem.mLocalVideoPath).exists()) && (!TextUtils.isEmpty(paramStoryVideoItem.mVideoLocalThumbnailPath)) && (new File(paramStoryVideoItem.mVideoLocalThumbnailPath).exists()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.troopstory.singleSync", 2, "localPath exist");
      }
      ThreadManager.getUIHandler().post(new ooa(this, paramStoryVideoItem));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.troopstory.singleSync", 2, "need send storyId=" + paramString);
    }
    paramStoryVideoItem = new GetVideoFullInfoListRequest();
    paramStoryVideoItem.jdField_a_of_type_JavaUtilList.add(paramString);
    CmdTaskManger.a().a(paramStoryVideoItem, this);
  }
  
  public void a(List paramList, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryModelIVidToVideoInfoPuller$OnFinishCallBack == null)
    {
      DefaultPlayerVideoListSynchronizer.PlayerVideoListEvent localPlayerVideoListEvent = new DefaultPlayerVideoListSynchronizer.PlayerVideoListEvent();
      localPlayerVideoListEvent.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      localPlayerVideoListEvent.jdField_a_of_type_Boolean = paramBoolean;
      localPlayerVideoListEvent.jdField_b_of_type_Boolean = true;
      localPlayerVideoListEvent.jdField_a_of_type_JavaUtilList.addAll(paramList);
      localPlayerVideoListEvent.jdField_a_of_type_Int = paramList.size();
      Dispatchers.get().dispatch(localPlayerVideoListEvent);
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryModelIVidToVideoInfoPuller$OnFinishCallBack.a(paramList, this.jdField_b_of_type_Boolean);
    this.jdField_a_of_type_ComTencentBizQqstoryModelIVidToVideoInfoPuller$OnFinishCallBack = null;
  }
  
  public boolean a(@NonNull StoryVideoItem paramStoryVideoItem)
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  protected void b(int paramInt)
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true)) {
      return;
    }
    StoryVideoItem localStoryVideoItem = ((StoryManager)SuperManager.a(5)).a(this.jdField_b_of_type_JavaLangString);
    a(this.jdField_b_of_type_JavaLangString, localStoryVideoItem);
  }
  
  public boolean isValidate()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.troop.model.TroopStorySingleVideoSynchronizer
 * JD-Core Version:    0.7.0.1
 */