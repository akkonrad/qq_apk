package com.tencent.gdtad.views.canvas.components.form;

import android.text.TextUtils;
import com.tencent.gdtad.log.GdtLog;

public class GdtCanvasFormError
{
  public int a;
  public String a;
  public int b = -1;
  
  public GdtCanvasFormError(int paramInt1, int paramInt2, String paramString)
  {
    this.jdField_a_of_type_Int = 3;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public String toString()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      GdtLog.d("GdtCanvasFormError", "toString error");
      return null;
    }
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      GdtLog.d("GdtCanvasFormError", "toString error");
      return null;
    case 5: 
      return "请填写" + this.jdField_a_of_type_JavaLangString;
    }
    return "请填写正确的" + this.jdField_a_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.gdtad.views.canvas.components.form.GdtCanvasFormError
 * JD-Core Version:    0.7.0.1
 */