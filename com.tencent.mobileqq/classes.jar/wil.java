import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.contact.addcontact.PublicView;
import com.tencent.widget.XListView;
import java.lang.ref.WeakReference;

public class wil
  extends Handler
{
  private WeakReference a;
  
  public wil(PublicView paramPublicView)
  {
    this.a = new WeakReference(paramPublicView);
  }
  
  public void handleMessage(Message paramMessage)
  {
    PublicView localPublicView = (PublicView)this.a.get();
    if (localPublicView == null) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      PublicView.a(localPublicView).springBackOverScrollHeaderView();
      return;
    case 2: 
      PublicView.a(localPublicView).springBackOverScrollHeaderView();
      PublicView.a(localPublicView, 1, 2131434349);
      return;
    case 3: 
      PublicView.a(localPublicView, true);
      return;
    }
    PublicView.b(localPublicView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wil
 * JD-Core Version:    0.7.0.1
 */