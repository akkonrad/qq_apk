import android.os.Parcel;
import android.os.Parcelable.Creator;
import cooperation.qzone.music.BroadcastAudio;

public final class amve
  implements Parcelable.Creator
{
  public BroadcastAudio a(Parcel paramParcel)
  {
    return new BroadcastAudio(paramParcel);
  }
  
  public BroadcastAudio[] a(int paramInt)
  {
    return new BroadcastAudio[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amve
 * JD-Core Version:    0.7.0.1
 */