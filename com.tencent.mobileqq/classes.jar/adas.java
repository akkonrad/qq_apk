import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.filemanager.data.OfflineFileInfo;

public final class adas
  implements Parcelable.Creator
{
  public OfflineFileInfo a(Parcel paramParcel)
  {
    return new OfflineFileInfo(paramParcel);
  }
  
  public OfflineFileInfo[] a(int paramInt)
  {
    return new OfflineFileInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adas
 * JD-Core Version:    0.7.0.1
 */