import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.util.BinderWarpper;

public final class alzh
  implements Parcelable.Creator
{
  public BinderWarpper a(Parcel paramParcel)
  {
    return new BinderWarpper(paramParcel.readStrongBinder());
  }
  
  public BinderWarpper[] a(int paramInt)
  {
    return new BinderWarpper[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     alzh
 * JD-Core Version:    0.7.0.1
 */