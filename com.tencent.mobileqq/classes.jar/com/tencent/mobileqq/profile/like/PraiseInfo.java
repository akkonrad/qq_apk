package com.tencent.mobileqq.profile.like;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.TextUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

public class PraiseInfo
{
  public int a;
  public Bitmap a;
  public String a;
  public int b;
  public Bitmap b;
  public String b;
  public Bitmap c;
  public String c;
  public String d;
  public String e;
  
  public PraiseInfo(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public static PraiseInfo a(int paramInt, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return null;
      try
      {
        paramString = a(paramString);
        if (TextUtils.isEmpty(paramString)) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("PraiseInfo", 2, "content:" + paramString);
        }
        paramString = new JSONObject(paramString);
        PraiseInfo localPraiseInfo = new PraiseInfo(paramInt);
        localPraiseInfo.jdField_a_of_type_JavaLangString = paramString.optString("name");
        localPraiseInfo.jdField_b_of_type_JavaLangString = paramString.optString("text");
        if (paramString.has("color"))
        {
          String str = paramString.optString("color").trim();
          paramString = str;
          if (str.startsWith("0x")) {
            paramString = str.substring(2);
          }
        }
        try
        {
          localPraiseInfo.jdField_b_of_type_Int = Color.parseColor("#" + paramString);
          return localPraiseInfo;
        }
        catch (Exception paramString)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("PraiseInfo", 2, "color invalid");
            }
          }
        }
        return null;
      }
      catch (JSONException paramString)
      {
        QLog.e("PraiseInfo", 1, "parsePraiseInfo failed with JsonException.", paramString);
        return null;
      }
      catch (IOException paramString)
      {
        QLog.e("PraiseInfo", 1, "parsePraiseInfo failed with IOException.", paramString);
      }
    }
  }
  
  private static String a(String paramString)
  {
    try
    {
      paramString = FileUtils.b(new File(paramString));
      return paramString;
    }
    catch (OutOfMemoryError paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PraiseInfo", 2, paramString.getMessage());
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.profile.like.PraiseInfo
 * JD-Core Version:    0.7.0.1
 */