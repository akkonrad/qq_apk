import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.nearby.now.model.VideoData;

public final class aetu
  implements Parcelable.Creator
{
  public VideoData a(Parcel paramParcel)
  {
    return new VideoData(paramParcel);
  }
  
  public VideoData[] a(int paramInt)
  {
    return new VideoData[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aetu
 * JD-Core Version:    0.7.0.1
 */