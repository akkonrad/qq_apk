import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;

public class yan
  implements View.OnClickListener
{
  public yan(SelectMemberActivity paramSelectMemberActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.a.f == 27)
    {
      this.a.a.putParcelableArrayListExtra("result_set", this.a.i);
      ((InputMethodManager)this.a.getSystemService("input_method")).hideSoftInputFromWindow(this.a.getWindow().peekDecorView().getWindowToken(), 0);
      this.a.setResult(-1, this.a.a);
    }
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     yan
 * JD-Core Version:    0.7.0.1
 */