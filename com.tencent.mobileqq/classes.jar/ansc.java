import android.os.Parcel;
import android.os.Parcelable.Creator;
import dov.com.tencent.biz.qqstory.takevideo.EditRecordVideoSource;

public final class ansc
  implements Parcelable.Creator
{
  public EditRecordVideoSource a(Parcel paramParcel)
  {
    return new EditRecordVideoSource(paramParcel);
  }
  
  public EditRecordVideoSource[] a(int paramInt)
  {
    return new EditRecordVideoSource[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ansc
 * JD-Core Version:    0.7.0.1
 */