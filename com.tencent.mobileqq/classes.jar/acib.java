import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendGroupFragment;
import com.tencent.mobileqq.extendfriend.pulltorefresh.extras.PullToRefreshRecyclerView;
import com.tencent.mobileqq.utils.NetworkUtil;

public class acib
  implements Runnable
{
  public acib(ExtendFriendGroupFragment paramExtendFriendGroupFragment) {}
  
  public void run()
  {
    if (NetworkUtil.g(ExtendFriendGroupFragment.a(this.a)))
    {
      if (ExtendFriendGroupFragment.a(this.a) != null)
      {
        ExtendFriendGroupFragment.a(this.a).setRefreshing();
        ExtendFriendGroupFragment.a(this.a).a(0, true);
      }
      return;
    }
    ExtendFriendGroupFragment.a(this.a, this.a.getString(2131437530), 1);
    ExtendFriendGroupFragment.a(this.a).a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acib
 * JD-Core Version:    0.7.0.1
 */