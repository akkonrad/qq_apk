package com.tencent.biz.pubaccount.readinjoy.proteus.data;

import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyDisplayUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import java.net.URL;
import org.json.JSONObject;

public class ReadInjoy_small_video_cell
{
  public static JSONObject a(BaseArticleInfo paramBaseArticleInfo)
  {
    JSONObject localJSONObject1 = new JSONObject();
    Object localObject = new JSONObject();
    ((JSONObject)localObject).put("small_video_icon", "public_account_video_profile");
    localJSONObject1.put("id_small_video_icon", localObject);
    localObject = new JSONObject();
    ((JSONObject)localObject).put("small_video_cover", "public_account_small_video_mengceng");
    localJSONObject1.put("id_small_video_cover", localObject);
    JSONObject localJSONObject2 = new JSONObject();
    if (paramBaseArticleInfo.mSinglePicture != null) {}
    for (localObject = paramBaseArticleInfo.mSinglePicture.getPath();; localObject = null)
    {
      localJSONObject2.put("article_small_imge_url", localObject);
      localJSONObject1.put("id_article_small_imge", localJSONObject2);
      localObject = new JSONObject();
      ((JSONObject)localObject).put("small_video_duration", ReadInJoyDisplayUtils.a(paramBaseArticleInfo.mVideoDuration));
      localJSONObject1.put("id_small_video_duration", localObject);
      Util.a(paramBaseArticleInfo, localJSONObject1, true);
      Util.a(paramBaseArticleInfo, localJSONObject1);
      Util.b(paramBaseArticleInfo, localJSONObject1);
      Util.c(paramBaseArticleInfo, localJSONObject1);
      Util.e(paramBaseArticleInfo, localJSONObject1);
      Util.d(paramBaseArticleInfo, localJSONObject1);
      localJSONObject1.put("style_ID", "ReadInjoy_small_cell");
      Util.a(localJSONObject1, paramBaseArticleInfo);
      return localJSONObject1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.data.ReadInjoy_small_video_cell
 * JD-Core Version:    0.7.0.1
 */