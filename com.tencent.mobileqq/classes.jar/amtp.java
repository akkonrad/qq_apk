import android.os.Parcel;
import android.os.Parcelable.Creator;
import cooperation.qzone.UndealCount.QZoneCountUserInfo;

public final class amtp
  implements Parcelable.Creator
{
  public QZoneCountUserInfo a(Parcel paramParcel)
  {
    return new QZoneCountUserInfo(paramParcel);
  }
  
  public QZoneCountUserInfo[] a(int paramInt)
  {
    return new QZoneCountUserInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amtp
 * JD-Core Version:    0.7.0.1
 */