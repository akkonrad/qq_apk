import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.businessCard.data.CardUinInfo;

public final class aboj
  implements Parcelable.Creator
{
  public CardUinInfo a(Parcel paramParcel)
  {
    return new CardUinInfo(paramParcel);
  }
  
  public CardUinInfo[] a(int paramInt)
  {
    return new CardUinInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aboj
 * JD-Core Version:    0.7.0.1
 */