import com.tencent.biz.pubaccount.readinjoy.model.AdvertisementInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import java.util.Comparator;

public class lot
  implements Comparator
{
  public lot(AdvertisementInfoModule paramAdvertisementInfoModule) {}
  
  public int a(AdvertisementInfo paramAdvertisementInfo1, AdvertisementInfo paramAdvertisementInfo2)
  {
    return paramAdvertisementInfo1.mAdKdPos - paramAdvertisementInfo2.mAdKdPos;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lot
 * JD-Core Version:    0.7.0.1
 */