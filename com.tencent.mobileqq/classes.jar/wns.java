import android.os.Handler;
import com.tencent.mobileqq.activity.contacts.fragment.PhoneContactFragment;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;

public class wns
  implements Runnable
{
  public wns(PhoneContactFragment paramPhoneContactFragment) {}
  
  public void run()
  {
    if (PhoneContactFragment.a(this.a) == null) {
      PhoneContactFragment.a(this.a, (PhoneContactManagerImp)this.a.a.getManager(10));
    }
    boolean bool = PhoneContactFragment.a(this.a).f();
    PhoneContactFragment.a(this.a).post(new wnt(this, bool));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wns
 * JD-Core Version:    0.7.0.1
 */