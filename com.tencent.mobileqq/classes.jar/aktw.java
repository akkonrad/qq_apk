import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.widget.DraggableGridView;
import com.tencent.widget.ListView;

public class aktw
  extends Handler
{
  public aktw(DraggableGridView paramDraggableGridView, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    DraggableGridView.c(this.a, paramMessage.arg1);
    DraggableGridView.a(this.a).smoothScrollBy(DraggableGridView.d(this.a), 0);
    DraggableGridView.a(this.a, (int)DraggableGridView.a(this.a), (int)DraggableGridView.b(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aktw
 * JD-Core Version:    0.7.0.1
 */