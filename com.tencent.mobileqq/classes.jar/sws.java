import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ViewSwitcher.ViewFactory;
import com.tencent.mobileqq.activity.Leba;

public class sws
  implements ViewSwitcher.ViewFactory
{
  public sws(Leba paramLeba) {}
  
  public View makeView()
  {
    ImageView localImageView = new ImageView(this.a.a());
    localImageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    localImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
    return localImageView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sws
 * JD-Core Version:    0.7.0.1
 */