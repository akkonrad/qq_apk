import android.os.Parcel;
import android.os.Parcelable.Creator;
import cooperation.qzone.model.ImageTagInfo;

public final class amup
  implements Parcelable.Creator
{
  public ImageTagInfo a(Parcel paramParcel)
  {
    return new ImageTagInfo(paramParcel, null);
  }
  
  public ImageTagInfo[] a(int paramInt)
  {
    return new ImageTagInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amup
 * JD-Core Version:    0.7.0.1
 */