import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import com.tencent.mobileqq.troop.activity.TroopBarPublishActivity;

public class aiye
  implements TextWatcher
{
  public aiye(TroopBarPublishActivity paramTroopBarPublishActivity) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((!TextUtils.isEmpty(this.a.H)) && (paramInt1 > 0) && (paramInt1 < this.a.H.length() + 1) && (paramInt2 > paramInt3))
    {
      this.a.d(false);
      return;
    }
    TroopBarPublishActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiye
 * JD-Core Version:    0.7.0.1
 */