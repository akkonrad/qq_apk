import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mobileqq.activity.VerifyCodeActivity;

public class bry
  implements TextWatcher
{
  public bry(VerifyCodeActivity paramVerifyCodeActivity) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (paramEditable.length() >= 4)
    {
      VerifyCodeActivity.c(this.a, true);
      return;
    }
    VerifyCodeActivity.d(this.a, false);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     bry
 * JD-Core Version:    0.7.0.1
 */