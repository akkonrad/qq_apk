package com.tencent.wxop.stat.common;

import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

class n
  implements FileFilter
{
  public boolean accept(File paramFile)
  {
    return Pattern.matches("cpu[0-9]", paramFile.getName());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.wxop.stat.common.n
 * JD-Core Version:    0.7.0.1
 */