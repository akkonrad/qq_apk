import com.tencent.biz.pubaccount.readinjoy.model.UserOperationModule.Ox978RespCallBack;
import com.tencent.biz.pubaccount.readinjoy.proteus.listeners.OnTopicRecommendHeaderFollowClickListener;
import com.tencent.mobileqq.app.ThreadManager;

public class lsw
  implements UserOperationModule.Ox978RespCallBack
{
  public lsw(OnTopicRecommendHeaderFollowClickListener paramOnTopicRecommendHeaderFollowClickListener) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    if ((paramBoolean) && (paramInt == 2)) {
      ThreadManager.post(new lsx(this), 5, null, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lsw
 * JD-Core Version:    0.7.0.1
 */