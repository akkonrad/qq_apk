import android.hardware.SensorManager;
import com.tencent.mobileqq.profile.view.ShakeImageView;

public class agsf
  implements Runnable
{
  public agsf(ShakeImageView paramShakeImageView) {}
  
  public void run()
  {
    ShakeImageView.a(this.a, ShakeImageView.a(this.a).getDefaultSensor(9));
    if (ShakeImageView.a(this.a) != null) {
      ShakeImageView.a(this.a).registerListener(this.a, ShakeImageView.a(this.a), 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agsf
 * JD-Core Version:    0.7.0.1
 */