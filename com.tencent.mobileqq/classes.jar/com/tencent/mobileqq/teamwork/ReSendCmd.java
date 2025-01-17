package com.tencent.mobileqq.teamwork;

import aimd;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.List;

public class ReSendCmd
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new aimd();
  int jdField_a_of_type_Int;
  String jdField_a_of_type_JavaLangString = "";
  List jdField_a_of_type_JavaUtilList;
  int jdField_b_of_type_Int;
  String jdField_b_of_type_JavaLangString = "";
  int c;
  int d;
  int e;
  int f = 0;
  
  public ReSendCmd() {}
  
  public ReSendCmd(Parcel paramParcel)
  {
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_b_of_type_Int = paramParcel.readInt();
    this.c = paramParcel.readInt();
    this.d = paramParcel.readInt();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.e = paramParcel.readInt();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    paramParcel.readStringList(this.jdField_a_of_type_JavaUtilList);
    this.f = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("urlSrcType : ").append(this.f).append(" | padUrl : ").append(this.jdField_a_of_type_JavaLangString);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeInt(this.c);
    paramParcel.writeInt(this.d);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeInt(this.e);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeStringList(this.jdField_a_of_type_JavaUtilList);
    paramParcel.writeInt(this.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.ReSendCmd
 * JD-Core Version:    0.7.0.1
 */