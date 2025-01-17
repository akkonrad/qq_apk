package com.tencent.biz.qqstory.msgTabNode.network;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfo;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodePullVideoBasicInfoSegment;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeVidListPullSegment;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.reactive.Stream;
import net;
import nev;

public class MsgTabVideoPreloaderDataProvider
{
  private int jdField_a_of_type_Int = 1;
  private boolean jdField_a_of_type_Boolean = true;
  private boolean b = true;
  
  public void a(@NonNull MsgTabNodeInfo paramMsgTabNodeInfo, MsgTabVideoPreloaderDataProvider.DataProviderListener paramDataProviderListener)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.b)
      {
        if (QLog.isColorLevel()) {
          QLog.i("MsgTabVideoPreloaderDataProvider", 2, "下载vidList和VideoInfo");
        }
        Stream.of(paramMsgTabNodeInfo).map(new MsgTabNodeVidListPullSegment(false)).map(new MsgTabNodePullVideoBasicInfoSegment(null)).subscribe(new net(this, paramDataProviderListener, paramMsgTabNodeInfo));
      }
    }
    else {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("MsgTabVideoPreloaderDataProvider", 2, "只加载vidList");
    }
    Stream.of(paramMsgTabNodeInfo).map(new MsgTabNodeVidListPullSegment(false)).subscribe(new nev(this, paramDataProviderListener, paramMsgTabNodeInfo));
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void b(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.network.MsgTabVideoPreloaderDataProvider
 * JD-Core Version:    0.7.0.1
 */