package com.tencent.biz.qqstory.model;

import com.tencent.biz.qqstory.base.BaseEvent;
import com.tencent.biz.qqstory.database.LiveVideoEntry;
import java.util.ArrayList;
import java.util.List;

public class DefaultPlayerVideoListSynchronizer$PlayerVideoListEvent
  extends BaseEvent
{
  public int a;
  public long a;
  public LiveVideoEntry a;
  public String a;
  public List a;
  public boolean a;
  public long b;
  public String b;
  public List b;
  public boolean b;
  public String c;
  public boolean c;
  
  public DefaultPlayerVideoListSynchronizer$PlayerVideoListEvent()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public String toString()
  {
    return "PlayerVideoListEvent{context='" + this.jdField_a_of_type_JavaLangString + '\'' + ", uid='" + this.jdField_b_of_type_JavaLangString + '\'' + ", label='" + this.jdField_c_of_type_JavaLangString + '\'' + ", topicId=" + this.jdField_a_of_type_Long + ", mStoryVideoItems=" + this.jdField_a_of_type_JavaUtilList + ", totalTime=" + this.jdField_b_of_type_Long + ", videoCount=" + this.jdField_a_of_type_Int + ", isFromCache=" + this.jdField_a_of_type_Boolean + ", isEnd=" + this.jdField_b_of_type_Boolean + ", interactStatus=" + this.jdField_c_of_type_Boolean + ", liveVideoInfo=" + this.jdField_a_of_type_ComTencentBizQqstoryDatabaseLiveVideoEntry + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.DefaultPlayerVideoListSynchronizer.PlayerVideoListEvent
 * JD-Core Version:    0.7.0.1
 */