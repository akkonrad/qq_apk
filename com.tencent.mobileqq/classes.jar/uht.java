import android.view.animation.Interpolator;
import com.tencent.mobileqq.activity.VisitorsActivity;

public class uht
  implements Interpolator
{
  public uht(VisitorsActivity paramVisitorsActivity) {}
  
  public float getInterpolation(float paramFloat)
  {
    if (paramFloat <= 0.3333333F) {
      return 0.0F;
    }
    return (paramFloat - 0.3333333F) * 1.5F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uht
 * JD-Core Version:    0.7.0.1
 */