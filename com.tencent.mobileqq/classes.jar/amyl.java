import android.os.Parcel;
import android.os.Parcelable.Creator;
import cooperation.qzone.remote.SendMsg;

public final class amyl
  implements Parcelable.Creator
{
  public SendMsg a(Parcel paramParcel)
  {
    return new SendMsg(paramParcel);
  }
  
  public SendMsg[] a(int paramInt)
  {
    return new SendMsg[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amyl
 * JD-Core Version:    0.7.0.1
 */