package com.tencent.biz.qqstory.network.handler;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.network.BatchNetHandler;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;
import java.util.ArrayList;
import java.util.List;

public class GetUserGroupUnionIDHandler
  extends BatchNetHandler
  implements CmdTaskManger.CommandCallback
{
  public List a = new ArrayList();
  
  public GetUserGroupUnionIDHandler(String paramString)
  {
    this.a.add(paramString);
  }
  
  public void a()
  {
    GetUserGroupUnionIDHandler.GetUserGroupUnionIDRequest localGetUserGroupUnionIDRequest = new GetUserGroupUnionIDHandler.GetUserGroupUnionIDRequest();
    localGetUserGroupUnionIDRequest.c = 1;
    localGetUserGroupUnionIDRequest.a = this.a;
    CmdTaskManger.a().a(localGetUserGroupUnionIDRequest, this);
  }
  
  public void a(@NonNull GetUserGroupUnionIDHandler.GetUserGroupUnionIDRequest paramGetUserGroupUnionIDRequest, @Nullable GetUserGroupUnionIDHandler.GetUserGroupUnionIDResponse paramGetUserGroupUnionIDResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    paramGetUserGroupUnionIDRequest = new GetUserGroupUnionIDHandler.GetUserGroupUnionIDEvent(paramErrorMessage);
    if ((paramErrorMessage.isSuccess()) && (paramGetUserGroupUnionIDResponse != null) && (paramGetUserGroupUnionIDResponse.a != null))
    {
      paramGetUserGroupUnionIDRequest.a = paramGetUserGroupUnionIDResponse.a;
      b();
    }
    for (;;)
    {
      Dispatchers.get().dispatch(paramGetUserGroupUnionIDRequest);
      return;
      c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.GetUserGroupUnionIDHandler
 * JD-Core Version:    0.7.0.1
 */