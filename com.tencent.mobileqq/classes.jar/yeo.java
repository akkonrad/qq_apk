import android.os.Message;
import android.widget.TextView;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import mqq.os.MqqHandler;

public class yeo
  extends MqqHandler
{
  public yeo(ShortVideoPreviewActivity paramShortVideoPreviewActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    paramMessage = ShortVideoUtils.a(paramMessage.arg1);
    this.a.c.setText(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     yeo
 * JD-Core Version:    0.7.0.1
 */