package com.tencent.biz.pubaccount.readinjoy.view.fastweb.video;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import mps;

public class FastWebVideoInfo$ChannelInfo
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new mps();
  public int a;
  public String a;
  public int b;
  public String b;
  public int c;
  public String c;
  
  public FastWebVideoInfo$ChannelInfo() {}
  
  public FastWebVideoInfo$ChannelInfo(Parcel paramParcel)
  {
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_b_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.jdField_c_of_type_JavaLangString = paramParcel.readString();
    this.jdField_c_of_type_Int = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_c_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.video.FastWebVideoInfo.ChannelInfo
 * JD-Core Version:    0.7.0.1
 */