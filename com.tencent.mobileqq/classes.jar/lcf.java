import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyBaseDeliverActivity;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverUGCActivity;
import com.tencent.mobileqq.hotpic.HotPicData;
import com.tencent.mobileqq.hotpic.PublicAccountGifListener;

public class lcf
  implements PublicAccountGifListener
{
  public lcf(ReadInJoyBaseDeliverActivity paramReadInJoyBaseDeliverActivity) {}
  
  public void a(HotPicData paramHotPicData)
  {
    if ((this.a instanceof ReadInJoyDeliverUGCActivity)) {
      ((ReadInJoyDeliverUGCActivity)this.a).a(paramHotPicData);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lcf
 * JD-Core Version:    0.7.0.1
 */