import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.WindowManager;
import com.tencent.mobileqq.troop.widget.MediaControllerX;

public class hcv
  implements View.OnLayoutChangeListener
{
  public hcv(MediaControllerX paramMediaControllerX) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    MediaControllerX.a(this.a);
    if (MediaControllerX.a(this.a)) {
      MediaControllerX.a(this.a).updateViewLayout(MediaControllerX.a(this.a), MediaControllerX.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     hcv
 * JD-Core Version:    0.7.0.1
 */