import android.content.res.Resources;
import android.os.Handler;
import com.tencent.av.ui.BaseCallbackUI;
import com.tencent.av.ui.CallbackWaitingActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class jqv
  implements Runnable
{
  public jqv(CallbackWaitingActivity paramCallbackWaitingActivity) {}
  
  public void run()
  {
    this.a.a.a.removeCallbacksAndMessages(null);
    DialogUtil.b(this.a, 230, this.a.getResources().getString(2131429577), this.a.getResources().getString(2131429578), 2131428676, 2131428676, null, new jqw(this)).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jqv
 * JD-Core Version:    0.7.0.1
 */