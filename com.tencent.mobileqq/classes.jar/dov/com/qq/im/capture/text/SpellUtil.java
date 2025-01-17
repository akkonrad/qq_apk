package dov.com.qq.im.capture.text;

import java.util.Arrays;

public class SpellUtil
{
  public static String a;
  private static final int[] a;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 0, 64, 91, 96, 123, 8543, 8576, 12295, 19967, 40870, 65295, 65306, 65312, 65339, 65344, 65371, 2147483647 };
    jdField_a_of_type_JavaLangString = "[a-zA-Z0-9\\u4e00-\\u9fa5]";
  }
  
  public static int a(char paramChar)
  {
    if (b(paramChar)) {
      return 3;
    }
    switch (Arrays.binarySearch(jdField_a_of_type_ArrayOfInt, paramChar))
    {
    default: 
      if (Character.isHighSurrogate(paramChar)) {
        return 2;
      }
      break;
    case -16: 
    case -14: 
    case -12: 
    case -10: 
    case -7: 
    case -5: 
    case -3: 
    case 5: 
      return 0;
    }
    return 1;
  }
  
  public static int a(String paramString)
  {
    return Character.codePointCount(paramString, 0, paramString.length());
  }
  
  public static boolean a(char paramChar)
  {
    return ("" + paramChar).matches("[^\\x00-\\xff]");
  }
  
  private static boolean b(char paramChar)
  {
    return (paramChar >= '0') && (paramChar <= '9');
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.text.SpellUtil
 * JD-Core Version:    0.7.0.1
 */