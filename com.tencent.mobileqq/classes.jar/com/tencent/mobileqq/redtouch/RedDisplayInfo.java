package com.tencent.mobileqq.redtouch;

import ahfm;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.List;

public class RedDisplayInfo
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new ahfm();
  private RedTypeInfo a;
  public ArrayList a;
  
  public RedTypeInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTypeInfo;
  }
  
  public List a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a(RedTypeInfo paramRedTypeInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTypeInfo = paramRedTypeInfo;
  }
  
  public void a(ArrayList paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeList(this.jdField_a_of_type_JavaUtilArrayList);
    paramParcel.writeSerializable(this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTypeInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.redtouch.RedDisplayInfo
 * JD-Core Version:    0.7.0.1
 */