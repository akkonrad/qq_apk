import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.view.QuickPinyinEditText;

public class ahsc
  implements View.OnClickListener
{
  public ahsc(UniteSearchActivity paramUniteSearchActivity) {}
  
  public void onClick(View paramView)
  {
    UniteSearchActivity.e = 1;
    this.a.a.setText("");
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ahsc
 * JD-Core Version:    0.7.0.1
 */