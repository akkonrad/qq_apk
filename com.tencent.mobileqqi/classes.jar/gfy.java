import android.widget.TextView;
import com.tencent.mobileqq.maproam.activity.RoamingActivity;
import com.tencent.mobileqq.maproam.activity.RoamingActivity.GetAddressTaskListener;
import com.tencent.mobileqq.maproam.widget.RoamLocalSearchBar;

public class gfy
  implements RoamingActivity.GetAddressTaskListener
{
  public gfy(RoamingActivity paramRoamingActivity) {}
  
  public void a(String paramString)
  {
    this.a.b.startAnimation(this.a.c);
    if ((paramString != null) && (paramString.length() > 0)) {
      this.a.a.a(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     gfy
 * JD-Core Version:    0.7.0.1
 */