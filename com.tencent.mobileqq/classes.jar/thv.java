import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mobileqq.activity.PublicAccountListActivity;

public class thv
  implements View.OnTouchListener
{
  public thv(PublicAccountListActivity paramPublicAccountListActivity, InputMethodManager paramInputMethodManager) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(paramView.getWindowToken(), 0);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     thv
 * JD-Core Version:    0.7.0.1
 */