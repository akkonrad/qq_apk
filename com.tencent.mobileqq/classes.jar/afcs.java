import com.tencent.mobileqq.app.ConditionSearchManager.IConfigListener;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditBasePanel;

public class afcs
  implements ConditionSearchManager.IConfigListener
{
  public afcs(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity) {}
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if ((paramBoolean) && (paramInt == 2))
    {
      if ((NearbyPeopleProfileActivity.a(this.a) == null) || (this.a.e != 1)) {
        break label41;
      }
      NearbyPeopleProfileActivity.a(this.a).d();
    }
    label41:
    while (NearbyPeopleProfileActivity.a(this.a) == null) {
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afcs
 * JD-Core Version:    0.7.0.1
 */