import android.content.Context;
import android.content.res.Resources;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.TroopRequestActivity;
import com.tencent.mobileqq.app.StrangerObserver;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.widget.QQToast;

public class ucy
  extends StrangerObserver
{
  public ucy(TroopRequestActivity paramTroopRequestActivity) {}
  
  public void a(boolean paramBoolean, PBRepeatMessageField paramPBRepeatMessageField)
  {
    if (this.a.isFinishing()) {
      return;
    }
    if (paramBoolean)
    {
      QQToast.a(this.a.getApplicationContext(), 2, this.a.getApplicationContext().getResources().getString(2131436918), 0).a();
      this.a.c.setVisibility(8);
      return;
    }
    QQToast.a(this.a.getApplicationContext(), 1, this.a.getApplicationContext().getResources().getString(2131436917), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ucy
 * JD-Core Version:    0.7.0.1
 */