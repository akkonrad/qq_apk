import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.gdtad.views.canvas.framework.GdtCanvasScrollView;

public class qmg
  implements View.OnTouchListener
{
  public qmg(GdtCanvasScrollView paramGdtCanvasScrollView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    do
    {
      return false;
    } while (GdtCanvasScrollView.a(this.a));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     qmg
 * JD-Core Version:    0.7.0.1
 */