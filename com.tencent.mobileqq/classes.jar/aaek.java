import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo.NativeSoRes;

public final class aaek
  implements Parcelable.Creator
{
  public ARCommonConfigInfo.NativeSoRes a(Parcel paramParcel)
  {
    return new ARCommonConfigInfo.NativeSoRes(paramParcel);
  }
  
  public ARCommonConfigInfo.NativeSoRes[] a(int paramInt)
  {
    return new ARCommonConfigInfo.NativeSoRes[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaek
 * JD-Core Version:    0.7.0.1
 */