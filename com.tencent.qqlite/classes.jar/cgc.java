import android.os.Handler;
import com.tencent.mobileqq.activity.phone.BindNumberActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;

public class cgc
  extends ContactBindObserver
{
  public cgc(BindNumberActivity paramBindNumberActivity) {}
  
  protected void b(boolean paramBoolean)
  {
    super.b(paramBoolean);
    BindNumberActivity localBindNumberActivity = this.a;
    if (paramBoolean)
    {
      this.a.a.c();
      BindNumberActivity.a(this.a).sendEmptyMessage(3);
    }
    for (;;)
    {
      this.a.app.unRegistObserver(BindNumberActivity.a(this.a));
      BindNumberActivity.a(this.a, null);
      return;
      this.a.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cgc
 * JD-Core Version:    0.7.0.1
 */