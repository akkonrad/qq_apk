package com.tencent.tmassistantbase.util;

final class s
  extends ThreadLocal<char[]>
{
  protected char[] a()
  {
    return new char[1024];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tmassistantbase.util.s
 * JD-Core Version:    0.7.0.1
 */