package com.tencent.device.qfind;

import java.util.List;

public class PeerInfo
{
  private static int d;
  public int a;
  public long a;
  public String a;
  public List a;
  public boolean a;
  public byte[] a;
  public int b;
  public long b;
  public String b;
  public boolean b;
  public int c;
  public boolean c;
  
  public PeerInfo()
  {
    d += 1;
    this.jdField_a_of_type_Int = d;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Int = 0;
    this.jdField_b_of_type_Long = 0L;
    this.c = 0;
  }
  
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString.replaceAll(":", "") + "0000";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.device.qfind.PeerInfo
 * JD-Core Version:    0.7.0.1
 */