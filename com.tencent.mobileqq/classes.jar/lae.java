import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.ecshopassit.RecentShopParcel;

public final class lae
  implements Parcelable.Creator
{
  public RecentShopParcel a(Parcel paramParcel)
  {
    return new RecentShopParcel(paramParcel);
  }
  
  public RecentShopParcel[] a(int paramInt)
  {
    return new RecentShopParcel[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lae
 * JD-Core Version:    0.7.0.1
 */