import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import com.tencent.mobileqq.nearby.now.view.ShortVideoCommentsView;

public class aexd
  implements View.OnTouchListener
{
  public aexd(ShortVideoCommentsView paramShortVideoCommentsView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 0) || (paramMotionEvent.getAction() == 2)) {
      ShortVideoCommentsView.a(this.a).setTextColor(2130706432);
    }
    for (;;)
    {
      return false;
      ShortVideoCommentsView.a(this.a).setTextColor(-16777216);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aexd
 * JD-Core Version:    0.7.0.1
 */