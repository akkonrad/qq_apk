import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.conditionsearch.SearchResultActivity;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;

public class abrc
  implements OverScrollViewListener
{
  public abrc(SearchResultActivity paramSearchResultActivity) {}
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    SearchResultActivity.a(this.a).c(SearchResultActivity.a(this.a));
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    SearchResultActivity.a(this.a).a(SearchResultActivity.a(this.a));
    if (NetworkUtil.d(this.a)) {
      SearchResultActivity.c(this.a);
    }
    for (;;)
    {
      SearchResultActivity.a(this.a, System.currentTimeMillis());
      return true;
      SearchResultActivity.a(this.a).a(1);
      paramView = Message.obtain();
      paramView.what = 3;
      SearchResultActivity.a(this.a).sendMessageDelayed(paramView, 1000L);
    }
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    SearchResultActivity.a(this.a).b(SearchResultActivity.a(this.a));
  }
  
  public void c(int paramInt, View paramView, ListView paramListView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abrc
 * JD-Core Version:    0.7.0.1
 */