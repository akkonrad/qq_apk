package com.tencent.biz.qqstory.base.preload;

import android.annotation.TargetApi;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryConstant;
import com.tencent.biz.qqstory.base.download.DownloadUrlManager;
import com.tencent.biz.qqstory.base.download.DownloadUrlManager.DownloadUrlQueryResult;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.transfile.HttpNetReq;
import java.util.HashMap;
import java.util.Map;

@TargetApi(14)
public class DownloadTask
{
  public int a;
  public long a;
  public AsyncFileDownloader.DownloadResult a;
  public AsyncFileDownloader.InnerDownloader a;
  public MessageForShortVideo a;
  public HttpNetReq a;
  public String a;
  public Map a;
  public boolean a;
  public int b;
  public long b;
  public String b;
  public boolean b;
  public int c;
  public String c;
  public boolean c;
  public int d;
  public String d;
  public int e;
  public String e;
  public int f;
  public String f;
  
  public DownloadTask()
  {
    this.jdField_d_of_type_Int = -1;
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_f_of_type_Int = 1;
  }
  
  public static DownloadTask a(String paramString, int paramInt)
  {
    DownloadUrlManager.DownloadUrlQueryResult localDownloadUrlQueryResult = ((DownloadUrlManager)SuperManager.a(28)).a(paramString, paramInt);
    paramString = a(paramString, localDownloadUrlQueryResult.jdField_b_of_type_JavaLangString, paramInt, false);
    paramString.jdField_a_of_type_Boolean = localDownloadUrlQueryResult.jdField_a_of_type_Boolean;
    paramString.jdField_e_of_type_Int = localDownloadUrlQueryResult.c;
    return paramString;
  }
  
  public static DownloadTask a(String paramString, int paramInt, boolean paramBoolean)
  {
    DownloadUrlManager.DownloadUrlQueryResult localDownloadUrlQueryResult = ((DownloadUrlManager)SuperManager.a(28)).a(paramString, paramInt);
    paramString = a(paramString, localDownloadUrlQueryResult.jdField_b_of_type_JavaLangString, paramInt, paramBoolean);
    paramString.jdField_a_of_type_Boolean = localDownloadUrlQueryResult.jdField_a_of_type_Boolean;
    paramString.jdField_e_of_type_Int = localDownloadUrlQueryResult.c;
    return paramString;
  }
  
  private static DownloadTask a(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    DownloadTask localDownloadTask = new DownloadTask();
    StoryVideoItem localStoryVideoItem = ((StoryManager)SuperManager.a(5)).a(paramString1);
    if ((localStoryVideoItem != null) && (localStoryVideoItem.isMine()))
    {
      localDownloadTask.jdField_e_of_type_JavaLangString = FileCacheUtils.a(paramString1, localStoryVideoItem.mCreateTime, paramInt, false, false);
      localDownloadTask.jdField_f_of_type_JavaLangString = FileCacheUtils.a(paramString1, localStoryVideoItem.mCreateTime, paramInt, true, false);
      localDownloadTask.jdField_b_of_type_Int = 0;
      localDownloadTask.jdField_b_of_type_JavaLangString = paramString1;
      localDownloadTask.jdField_a_of_type_Int = paramInt;
      localDownloadTask.jdField_a_of_type_JavaLangString = a(paramString1, paramInt);
      if (!paramBoolean) {
        break label159;
      }
    }
    label159:
    for (paramString1 = "";; paramString1 = paramString2)
    {
      localDownloadTask.jdField_c_of_type_JavaLangString = paramString1;
      if (paramBoolean) {
        paramString2 = "";
      }
      localDownloadTask.jdField_d_of_type_JavaLangString = paramString2;
      localDownloadTask.jdField_c_of_type_Boolean = paramBoolean;
      return localDownloadTask;
      localDownloadTask.jdField_e_of_type_JavaLangString = FileCacheUtils.a(paramString1, paramInt, false, false);
      localDownloadTask.jdField_f_of_type_JavaLangString = FileCacheUtils.a(paramString1, paramInt, true, false);
      break;
    }
  }
  
  public static String a(String paramString, int paramInt)
  {
    return paramInt + "_" + paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof DownloadTask))
    {
      paramObject = (DownloadTask)paramObject;
      if ((TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramObject.jdField_a_of_type_JavaLangString)) && (TextUtils.equals(this.jdField_c_of_type_JavaLangString, paramObject.jdField_c_of_type_JavaLangString)) && (TextUtils.equals(this.jdField_e_of_type_JavaLangString, paramObject.jdField_e_of_type_JavaLangString))) {
        return true;
      }
    }
    return false;
  }
  
  public String toString()
  {
    return "DownloadTask{vid='" + this.jdField_b_of_type_JavaLangString + '\'' + ", fileType=" + QQStoryConstant.a(this.jdField_a_of_type_Int) + ", status=" + this.jdField_b_of_type_Int + ", downloadUrl='" + this.jdField_d_of_type_JavaLangString + '\'' + ", localPath='" + this.jdField_e_of_type_JavaLangString + '\'' + ", localTmpPath='" + this.jdField_f_of_type_JavaLangString + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.preload.DownloadTask
 * JD-Core Version:    0.7.0.1
 */