package com.tencent.biz.qqstory.troop.memories;

import android.os.Handler;
import com.tencent.biz.qqstory.network.handler.GetFeedFeatureHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class TroopStoryMemoriesListAdapter$GetFeedFeatureHelper
  implements Runnable
{
  final int jdField_a_of_type_Int = 500;
  Handler jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
  List jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public void run()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("TroopStoryMemoriesListAdapter", 2, "start to send GetFeedFeature request: " + this.jdField_a_of_type_JavaUtilList);
    }
    GetFeedFeatureHandler.a(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.troop.memories.TroopStoryMemoriesListAdapter.GetFeedFeatureHelper
 * JD-Core Version:    0.7.0.1
 */