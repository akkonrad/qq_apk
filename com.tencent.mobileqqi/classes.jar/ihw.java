import android.os.Parcel;
import android.os.Parcelable.Creator;
import cooperation.qzone.remote.RecvMsg;

public final class ihw
  implements Parcelable.Creator
{
  public RecvMsg a(Parcel paramParcel)
  {
    return new RecvMsg(paramParcel);
  }
  
  public RecvMsg[] a(int paramInt)
  {
    return new RecvMsg[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     ihw
 * JD-Core Version:    0.7.0.1
 */