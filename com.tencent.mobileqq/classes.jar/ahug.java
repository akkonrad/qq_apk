import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.search.presenter.ContactSearchResultPresenter;
import com.tencent.mobileqq.search.presenter.ContactSearchResultPresenter.OnActionListener;

public class ahug
  implements View.OnClickListener
{
  public ahug(ContactSearchResultPresenter paramContactSearchResultPresenter) {}
  
  public void onClick(View paramView)
  {
    ContactSearchResultPresenter.a(this.a).a(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ahug
 * JD-Core Version:    0.7.0.1
 */