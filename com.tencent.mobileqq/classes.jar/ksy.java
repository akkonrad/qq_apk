import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import mqq.util.WeakReference;

public class ksy
  extends FriendListObserver
{
  WeakReference a;
  
  public ksy(AccountDetailActivity paramAccountDetailActivity)
  {
    this.a = new WeakReference(paramAccountDetailActivity);
  }
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    AccountDetailActivity localAccountDetailActivity = (AccountDetailActivity)this.a.get();
    if (localAccountDetailActivity == null) {}
    while ((localAccountDetailActivity.j) || (!paramBoolean) || (!paramString.equals(localAccountDetailActivity.d))) {
      return;
    }
    localAccountDetailActivity.N();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ksy
 * JD-Core Version:    0.7.0.1
 */