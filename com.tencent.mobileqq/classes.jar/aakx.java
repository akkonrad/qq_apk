import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.ar.model.ArVideoResourceInfo;

public final class aakx
  implements Parcelable.Creator
{
  public ArVideoResourceInfo a(Parcel paramParcel)
  {
    return new ArVideoResourceInfo(paramParcel);
  }
  
  public ArVideoResourceInfo[] a(int paramInt)
  {
    return new ArVideoResourceInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aakx
 * JD-Core Version:    0.7.0.1
 */