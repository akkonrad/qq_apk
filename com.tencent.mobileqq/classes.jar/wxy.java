import NS_MOBILE_PHOTO.get_albumlist_num_rsp;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.observer.QZoneObserver;
import mqq.app.AppRuntime;

public class wxy
  extends QZoneObserver
{
  protected void b(boolean paramBoolean, Bundle paramBundle)
  {
    paramBundle = paramBundle.getSerializable("data");
    if ((paramBoolean) && (paramBundle != null) && ((paramBundle instanceof get_albumlist_num_rsp))) {
      PhotoListActivity.f = ((get_albumlist_num_rsp)paramBundle).album_num;
    }
    BaseApplicationImpl.getApplication().getRuntime().unRegistObserver(PhotoListActivity.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wxy
 * JD-Core Version:    0.7.0.1
 */