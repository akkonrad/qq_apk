package com.tencent.biz.qqstory.network.request;

import android.os.Bundle;
import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.network.response.CommonResponse;
import com.tencent.mobileqq.pb.MessageMicro;

public class CommonRequest
  extends NetworkRequest
{
  public final Bundle a;
  public final MessageMicro a;
  public final String a;
  
  public CommonRequest(String paramString, MessageMicro paramMessageMicro, Bundle paramBundle)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqPbMessageMicro = paramMessageMicro;
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
  }
  
  public BaseResponse a(byte[] paramArrayOfByte)
  {
    return new CommonResponse(paramArrayOfByte);
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  protected byte[] a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqPbMessageMicro.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.CommonRequest
 * JD-Core Version:    0.7.0.1
 */