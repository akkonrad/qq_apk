import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.data.Setting;

public final class abvi
  implements Parcelable.Creator
{
  public Setting a(Parcel paramParcel)
  {
    Setting localSetting = new Setting();
    localSetting.readFromParcel(paramParcel);
    return localSetting;
  }
  
  public Setting[] a(int paramInt)
  {
    return new Setting[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abvi
 * JD-Core Version:    0.7.0.1
 */