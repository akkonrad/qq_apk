import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.conditionsearch.ConditionSearchFriendActivity;
import com.tencent.mobileqq.widget.QQToast;

public class abqm
  extends Handler
{
  public abqm(ConditionSearchFriendActivity paramConditionSearchFriendActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    if ((paramMessage.what == 1000) && ((this.a.j == 1) || (this.a.j == 2)))
    {
      this.a.a();
      QQToast.a(this.a, 2131437298, 0).b(this.a.getTitleBarHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abqm
 * JD-Core Version:    0.7.0.1
 */