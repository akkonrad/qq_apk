package com.tencent.biz.qqstory.playmode.util;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.tencent.biz.qqstory.takevideo.tag.TagItem.TagInfoBase;
import com.tencent.mobileqq.activity.QQBrowserActivity;

public final class StoryTagUtil
{
  public static void a(Context paramContext)
  {
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("url", "https://story.now.qq.com/mobile/qim/transfer.html?_wv=16777219");
    paramContext.startActivity(localIntent);
  }
  
  public static void a(Context paramContext, String paramString)
  {
    if (a(paramContext, paramString))
    {
      b(paramContext, paramString);
      return;
    }
    a(paramContext);
  }
  
  public static boolean a(Context paramContext, TagItem.TagInfoBase paramTagInfoBase)
  {
    if (paramTagInfoBase == null) {
      return false;
    }
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("url", String.format("%s?tag_id=%s&tag_type=%s&_wv=3&_nav_alpha=0&_bid=2910", new Object[] { "http://story.now.qq.com/mobile/tag/index.html", String.valueOf(paramTagInfoBase.jdField_a_of_type_Long), String.valueOf(paramTagInfoBase.jdField_a_of_type_Int) }));
    paramContext.startActivity(localIntent);
    return a(paramContext, String.valueOf(paramTagInfoBase.jdField_a_of_type_Long), String.valueOf(paramTagInfoBase.jdField_a_of_type_Int));
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    boolean bool = false;
    PackageManager localPackageManager = paramContext.getPackageManager();
    paramContext = null;
    try
    {
      paramString = localPackageManager.getPackageInfo(paramString, 0);
      paramContext = paramString;
    }
    catch (PackageManager.NameNotFoundException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
    if (paramContext != null) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return false;
    }
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("url", String.format("%s?tag_id=%s&tag_type=%s&_wv=3&_nav_alpha=0&_bid=2910", new Object[] { "http://story.now.qq.com/mobile/tag/index.html", String.valueOf(paramString1), String.valueOf(paramString2) }));
    paramContext.startActivity(localIntent);
    return true;
  }
  
  public static void b(Context paramContext, String paramString)
  {
    paramString = paramContext.getPackageManager().getLaunchIntentForPackage(paramString);
    if (paramString != null) {
      paramContext.startActivity(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.util.StoryTagUtil
 * JD-Core Version:    0.7.0.1
 */