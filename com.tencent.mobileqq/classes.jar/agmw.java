import android.os.CountDownTimer;
import android.widget.TextView;
import com.tencent.mobileqq.portal.PrepareView;

public class agmw
  extends CountDownTimer
{
  public agmw(PrepareView paramPrepareView, long paramLong1, long paramLong2)
  {
    super(paramLong1, paramLong2);
  }
  
  public void onFinish()
  {
    PrepareView.a(this.a).setText("00");
    PrepareView.b(this.a).setText("00");
    this.a.a();
  }
  
  public void onTick(long paramLong)
  {
    int j = (int)(paramLong / 1000L);
    int i = j / 60;
    j %= 60;
    String str1 = Integer.toString(i);
    String str2 = Integer.toString(j);
    if (i < 10) {
      str1 = "0" + Integer.toString(i);
    }
    if (j < 10) {
      str2 = "0" + Integer.toString(j);
    }
    PrepareView.a(this.a).setText(str1);
    PrepareView.b(this.a).setText(str2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agmw
 * JD-Core Version:    0.7.0.1
 */