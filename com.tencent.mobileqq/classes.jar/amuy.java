import android.os.Parcel;
import android.os.Parcelable.Creator;
import cooperation.qzone.model.VideoUrl;

public final class amuy
  implements Parcelable.Creator
{
  public VideoUrl a(Parcel paramParcel)
  {
    VideoUrl localVideoUrl = new VideoUrl();
    localVideoUrl.jdField_a_of_type_JavaLangString = paramParcel.readString();
    localVideoUrl.jdField_a_of_type_Int = paramParcel.readInt();
    return localVideoUrl;
  }
  
  public VideoUrl[] a(int paramInt)
  {
    return new VideoUrl[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amuy
 * JD-Core Version:    0.7.0.1
 */