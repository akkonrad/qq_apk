import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.DiscussionInfoCardActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class cnx
  extends Handler
{
  public cnx(DiscussionInfoCardActivity paramDiscussionInfoCardActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      if ((DiscussionInfoCardActivity.a(this.a) != null) && (DiscussionInfoCardActivity.a(this.a).isShowing())) {
        DiscussionInfoCardActivity.a(this.a).dismiss();
      }
      paramMessage = new Intent();
      paramMessage.putExtra("isNeedFinish", true);
      this.a.setResult(-1, paramMessage);
      this.a.finish();
      return;
    } while ((DiscussionInfoCardActivity.a(this.a) == null) || (!DiscussionInfoCardActivity.a(this.a).isShowing()) || (this.a.isFinishing()));
    DiscussionInfoCardActivity.a(this.a).dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cnx
 * JD-Core Version:    0.7.0.1
 */