import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.nearby.now.utils.NowVideoReporter;
import com.tencent.mobileqq.nearby.now.view.viewmodel.PlayOperationViewModel;

public class afar
  implements View.OnClickListener
{
  public afar(PlayOperationViewModel paramPlayOperationViewModel) {}
  
  public void onClick(View paramView)
  {
    this.a.c(paramView);
    new NowVideoReporter().h("video").i("playpage_like_click").b().a(this.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afar
 * JD-Core Version:    0.7.0.1
 */