import android.os.Handler;
import com.tencent.mobileqq.activity.aio.rebuild.BusinessCmrTmpChatPie;
import com.tencent.mobileqq.app.MessageObserver;

public class vri
  extends MessageObserver
{
  public vri(BusinessCmrTmpChatPie paramBusinessCmrTmpChatPie) {}
  
  protected void e(boolean paramBoolean)
  {
    super.e(paramBoolean);
    this.a.a.sendEmptyMessage(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vri
 * JD-Core Version:    0.7.0.1
 */