import android.view.View;
import android.widget.ListView;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.nearby.now.model.Comments;
import com.tencent.mobileqq.nearby.now.view.ShortVideoCommentsView;
import java.util.List;

public class aexi
  implements Runnable
{
  public aexi(ShortVideoCommentsView paramShortVideoCommentsView) {}
  
  public void run()
  {
    int i = UITools.b(this.a.getContext());
    if (ShortVideoCommentsView.a() * this.a.a.a.size() + ShortVideoCommentsView.b(this.a).getMeasuredHeight() >= i)
    {
      ShortVideoCommentsView.a(this.a).setSelectionFromTop(1, ShortVideoCommentsView.a() + ShortVideoCommentsView.b(this.a).getMeasuredHeight());
      return;
    }
    ShortVideoCommentsView.a(this.a).setSelection(this.a.a.a.size() + 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aexi
 * JD-Core Version:    0.7.0.1
 */