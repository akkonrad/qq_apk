import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.intervideo.od.LoadingUI;
import com.tencent.mobileqq.intervideo.od.LoadingUI.Event;

public class advj
  implements View.OnClickListener
{
  public advj(LoadingUI paramLoadingUI) {}
  
  public void onClick(View paramView)
  {
    if (LoadingUI.a(this.a) != null) {
      LoadingUI.a(this.a).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     advj
 * JD-Core Version:    0.7.0.1
 */