package com.tencent.biz.qqstory.model.item;

import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class StoryVideoItem$InteractPasterLayout
{
  public int a;
  private final String a;
  public final String[] a;
  public int b;
  public int c;
  public int d;
  public int e;
  public int f;
  public int g;
  public final int h;
  
  private StoryVideoItem$InteractPasterLayout(JSONObject paramJSONObject)
  {
    int j;
    try
    {
      this.jdField_a_of_type_JavaLangString = paramJSONObject.toString();
      this.jdField_a_of_type_Int = paramJSONObject.getInt("t");
      this.h = paramJSONObject.getJSONObject("a").getInt("r");
      JSONArray localJSONArray = paramJSONObject.getJSONObject("a").getJSONArray("ss");
      this.b = localJSONArray.getInt(0);
      this.c = localJSONArray.getInt(1);
      localJSONArray = paramJSONObject.getJSONObject("a").getJSONArray("ls");
      this.d = localJSONArray.getInt(0);
      this.e = localJSONArray.getInt(1);
      localJSONArray = paramJSONObject.getJSONObject("a").getJSONArray("lp");
      this.f = localJSONArray.getInt(0);
      this.g = localJSONArray.getInt(1);
      paramJSONObject = paramJSONObject.getJSONArray("c");
      j = paramJSONObject.length();
      if (j < 1) {
        throw new IllegalArgumentException("content length should more than 1");
      }
    }
    catch (JSONException paramJSONObject)
    {
      throw new IllegalArgumentException(paramJSONObject);
    }
    this.jdField_a_of_type_ArrayOfJavaLangString = new String[j];
    while (i < j)
    {
      this.jdField_a_of_type_ArrayOfJavaLangString[i] = paramJSONObject.optString(i, "(NULL)");
      i += 1;
    }
  }
  
  public static InteractPasterLayout a(@Nullable String paramString)
  {
    try
    {
      paramString = a(new JSONObject(paramString));
      return paramString;
    }
    catch (JSONException paramString)
    {
      SLog.a("StoryVideoItem.PollLayout", "fromJson()", paramString);
      return null;
    }
    catch (NullPointerException paramString)
    {
      SLog.a("StoryVideoItem.PollLayout", "fromJson()", paramString);
    }
    return null;
  }
  
  public static InteractPasterLayout a(JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject = new InteractPasterLayout(paramJSONObject);
      return paramJSONObject;
    }
    catch (IllegalArgumentException paramJSONObject)
    {
      SLog.a("StoryVideoItem.PollLayout", "fromJson()", paramJSONObject);
    }
    return null;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public String toString()
  {
    return "PollLayout{type=" + this.jdField_a_of_type_Int + ", screenWidth=" + this.b + ", screenHeight=" + this.c + ", layoutWidth=" + this.d + ", layoutHeight=" + this.e + ", layoutCenterX=" + this.f + ", layoutCenterY=" + this.g + ", rotation=" + this.h + ", contents=" + Arrays.toString(this.jdField_a_of_type_ArrayOfJavaLangString) + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.item.StoryVideoItem.InteractPasterLayout
 * JD-Core Version:    0.7.0.1
 */