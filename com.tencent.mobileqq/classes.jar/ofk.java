import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;

public final class ofk
  implements Parcelable.Creator
{
  public EditVideoParams a(Parcel paramParcel)
  {
    return new EditVideoParams(paramParcel);
  }
  
  public EditVideoParams[] a(int paramInt)
  {
    return new EditVideoParams[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ofk
 * JD-Core Version:    0.7.0.1
 */