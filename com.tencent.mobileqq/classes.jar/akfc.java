import android.view.KeyEvent;
import com.tencent.mobileqq.activity.qwallet.widget.MyLinearLayout.DispatchKeyEventListener;
import com.tencent.mobileqq.utils.QQCustomDialogWtihInputAndChoose;

public class akfc
  implements MyLinearLayout.DispatchKeyEventListener
{
  public akfc(QQCustomDialogWtihInputAndChoose paramQQCustomDialogWtihInputAndChoose) {}
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 1) && (this.a.b))
    {
      this.a.a();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akfc
 * JD-Core Version:    0.7.0.1
 */