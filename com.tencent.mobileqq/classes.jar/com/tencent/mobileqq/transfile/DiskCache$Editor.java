package com.tencent.mobileqq.transfile;

import java.io.File;
import java.io.IOException;

public class DiskCache$Editor
{
  File jdField_a_of_type_JavaIoFile;
  private String jdField_a_of_type_JavaLangString;
  
  DiskCache$Editor(DiskCache paramDiskCache, String paramString)
  {
    if (!paramDiskCache.jdField_a_of_type_JavaIoFile.exists()) {
      paramDiskCache.jdField_a_of_type_JavaIoFile.mkdirs();
    }
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaIoFile = new File(paramDiskCache.jdField_a_of_type_JavaIoFile, paramString + ".tmp");
  }
  
  File a()
  {
    File localFile = this.jdField_a_of_type_ComTencentMobileqqTransfileDiskCache.a(this.jdField_a_of_type_JavaLangString);
    if (localFile.exists()) {
      return localFile;
    }
    if ((!this.jdField_a_of_type_JavaIoFile.exists()) || (this.jdField_a_of_type_JavaIoFile.length() <= 0L))
    {
      this.jdField_a_of_type_JavaIoFile.delete();
      throw new IOException("write 0 length file or null File");
    }
    this.jdField_a_of_type_JavaIoFile.renameTo(localFile);
    return localFile;
  }
  
  void a(boolean paramBoolean)
  {
    if ((!paramBoolean) || (this.jdField_a_of_type_JavaIoFile.length() <= 0L)) {
      this.jdField_a_of_type_JavaIoFile.delete();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.DiskCache.Editor
 * JD-Core Version:    0.7.0.1
 */