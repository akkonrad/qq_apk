import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.util.ProfileParams.CurLoginUsr;

public final class mux
  implements Parcelable.Creator
{
  public ProfileParams.CurLoginUsr a(Parcel paramParcel)
  {
    return new ProfileParams.CurLoginUsr(paramParcel.readString(), paramParcel.readString());
  }
  
  public ProfileParams.CurLoginUsr[] a(int paramInt)
  {
    return new ProfileParams.CurLoginUsr[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mux
 * JD-Core Version:    0.7.0.1
 */