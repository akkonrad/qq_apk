package com.tencent.biz.qqstory.network.response;

import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetEmoticonPackList;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.EmoticonPack;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class GetEmojiPackInfoListResponse
  extends BaseResponse
{
  public final long a;
  public final String a;
  public final List a;
  public final boolean a;
  public final byte[] a;
  
  public GetEmojiPackInfoListResponse(qqstory_service.RspGetEmoticonPackList paramRspGetEmoticonPackList, byte[] paramArrayOfByte, long paramLong)
  {
    super(paramRspGetEmoticonPackList.result);
    boolean bool;
    ArrayList localArrayList;
    if (paramRspGetEmoticonPackList.is_end.get() != 0)
    {
      bool = true;
      this.jdField_a_of_type_Boolean = bool;
      this.jdField_a_of_type_JavaLangString = paramRspGetEmoticonPackList.next_cookie.get().toStringUtf8();
      localArrayList = new ArrayList();
      paramRspGetEmoticonPackList = paramRspGetEmoticonPackList.pack_list.get();
      if (paramRspGetEmoticonPackList != null) {
        paramRspGetEmoticonPackList = paramRspGetEmoticonPackList.iterator();
      }
    }
    else
    {
      for (;;)
      {
        if (!paramRspGetEmoticonPackList.hasNext()) {
          break label151;
        }
        GetEmojiPackInfoListResponse.EmojiPack localEmojiPack = new GetEmojiPackInfoListResponse.EmojiPack((qqstory_struct.EmoticonPack)paramRspGetEmoticonPackList.next());
        if (localEmojiPack.a())
        {
          localArrayList.add(localEmojiPack);
          continue;
          bool = false;
          break;
        }
        SLog.d("GetEmojiPackInfoListResponse", "found invalid data we ignore it : " + localEmojiPack);
      }
    }
    label151:
    this.jdField_a_of_type_JavaUtilList = Collections.unmodifiableList(localArrayList);
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_ArrayOfByte = new byte[paramArrayOfByte.length];
    System.arraycopy(paramArrayOfByte, 0, this.jdField_a_of_type_ArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public String toString()
  {
    return "GetEmojiPackInfoListResponse{mEmojiPackList.size=" + this.jdField_a_of_type_JavaUtilList.size() + ", mIsEnd=" + this.jdField_a_of_type_Boolean + ", mNextCookie='" + this.jdField_a_of_type_JavaLangString + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.response.GetEmojiPackInfoListResponse
 * JD-Core Version:    0.7.0.1
 */