import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.activity.aio.item.ThumbItemBuilder;

public class viz
  extends Handler
{
  public viz(ThumbItemBuilder paramThumbItemBuilder, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == ThumbItemBuilder.a) {
      this.a.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     viz
 * JD-Core Version:    0.7.0.1
 */