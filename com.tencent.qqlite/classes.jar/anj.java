import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.ForwardOperations;
import com.tencent.mobileqq.widget.QQToast;

public class anj
  extends Handler
{
  public anj(ForwardOperations paramForwardOperations) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 0) {
      QQToast.a(this.a.a, "网络异常", 0).a();
    }
    while (1 != paramMessage.what) {
      return;
    }
    this.a.a.setResult(-1);
    this.a.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     anj
 * JD-Core Version:    0.7.0.1
 */