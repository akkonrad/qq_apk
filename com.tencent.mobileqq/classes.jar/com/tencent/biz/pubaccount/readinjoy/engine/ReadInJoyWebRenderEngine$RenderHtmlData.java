package com.tencent.biz.pubaccount.readinjoy.engine;

import android.os.SystemClock;

public class ReadInJoyWebRenderEngine$RenderHtmlData
{
  final long a;
  public final String a;
  long b;
  public final String b;
  
  ReadInJoyWebRenderEngine$RenderHtmlData(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
  }
  
  ReadInJoyWebRenderEngine$RenderHtmlData(String paramString1, String paramString2, long paramLong)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
    this.jdField_b_of_type_Long = paramLong;
  }
  
  boolean a()
  {
    if (this.jdField_b_of_type_Long > 0L) {
      if (SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long <= this.jdField_b_of_type_Long) {}
    }
    while (SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long > 300000L)
    {
      return true;
      return false;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyWebRenderEngine.RenderHtmlData
 * JD-Core Version:    0.7.0.1
 */