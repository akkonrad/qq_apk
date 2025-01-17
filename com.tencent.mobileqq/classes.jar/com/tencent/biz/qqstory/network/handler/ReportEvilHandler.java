package com.tencent.biz.qqstory.network.handler;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.network.request.ReportEvilRequest;
import com.tencent.biz.qqstory.network.response.ReportEvilResponse;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;

public class ReportEvilHandler
  implements CmdTaskManger.CommandCallback
{
  public void a(@NonNull ReportEvilRequest paramReportEvilRequest, @Nullable ReportEvilResponse paramReportEvilResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    paramReportEvilRequest = new ReportEvilHandler.ReportEvent(this, paramErrorMessage, paramReportEvilRequest.b, paramReportEvilRequest.jdField_c_of_type_JavaLangString, paramReportEvilRequest.jdField_c_of_type_Int);
    Dispatchers.get().dispatch(paramReportEvilRequest);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.ReportEvilHandler
 * JD-Core Version:    0.7.0.1
 */