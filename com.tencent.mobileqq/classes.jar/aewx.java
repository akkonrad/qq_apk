import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.nearby.now.model.Comments;
import com.tencent.mobileqq.nearby.now.view.CommentsAdapter;
import com.tencent.mobileqq.nearby.now.view.presenter.CommentsPresenter;
import java.util.List;

public class aewx
  implements View.OnClickListener
{
  public aewx(CommentsAdapter paramCommentsAdapter) {}
  
  public void onClick(View paramView)
  {
    CommentsAdapter.a(this.a).a.clear();
    CommentsAdapter.a(this.a).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aewx
 * JD-Core Version:    0.7.0.1
 */