package cooperation.qqpim;

import amqs;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class QQPimTipsInfo
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new amqs();
  public byte a;
  public int a;
  public String a;
  public int b;
  
  public QQPimTipsInfo() {}
  
  private QQPimTipsInfo(Parcel paramParcel)
  {
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_Byte = paramParcel.readByte();
    this.b = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeByte(this.jdField_a_of_type_Byte);
    paramParcel.writeInt(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qqpim.QQPimTipsInfo
 * JD-Core Version:    0.7.0.1
 */