package com.tencent.mobileqq.bubble;

import android.graphics.Rect;
import java.util.Arrays;

public class BubbleInfo$CommonAttrs
{
  public int a;
  public Rect a;
  public AnimationConfig a;
  public String a;
  public boolean a;
  public String[] a;
  public int b;
  public String b;
  public boolean b;
  public int c = 50;
  public int d = -1;
  public int e = 1;
  
  public BubbleInfo$CommonAttrs()
  {
    this.jdField_b_of_type_Int = 1;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_ArrayOfJavaLangString = new String[0];
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public String toString()
  {
    return "CommonAttrs [key=" + this.jdField_b_of_type_JavaLangString + ", mRect=" + this.jdField_a_of_type_AndroidGraphicsRect + ", count=" + this.jdField_a_of_type_Int + ", duration=" + this.c + ", align=" + this.d + ", mBigImgPath=" + this.jdField_a_of_type_JavaLangString + ", repeatCount=" + this.jdField_b_of_type_Int + ", mAnimationPath=" + Arrays.toString(this.jdField_a_of_type_ArrayOfJavaLangString) + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.BubbleInfo.CommonAttrs
 * JD-Core Version:    0.7.0.1
 */