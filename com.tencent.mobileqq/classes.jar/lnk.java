import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyAtlasViewPagerAdapter;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyAtlasFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyAtlasFragment.ReportEventListener;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoySwipeView.OnSlidingFinishListener;

public class lnk
  implements ReadInJoySwipeView.OnSlidingFinishListener
{
  public lnk(ReadInJoyAtlasFragment paramReadInJoyAtlasFragment) {}
  
  public void a()
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("exitType", 2);
    localBundle.putSerializable("lastShowImageModel", this.a.a.a());
    ReadInJoyAtlasFragment.a(this.a).a(-2, localBundle);
    ReadInJoyAtlasFragment.b(this.a, true);
    ReadInJoyAtlasFragment.a(this.a).finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lnk
 * JD-Core Version:    0.7.0.1
 */