import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.LocalVideoFileView;

public class dum
  implements View.OnClickListener
{
  public dum(LocalVideoFileView paramLocalVideoFileView) {}
  
  public void onClick(View paramView)
  {
    if (LocalVideoFileView.b(this.a).getRequestedOrientation() != 0)
    {
      LocalVideoFileView.b(this.a).setRequestedOrientation(0);
      LocalVideoFileView.a(this.a).setBackgroundResource(2130838599);
      return;
    }
    LocalVideoFileView.b(this.a).setRequestedOrientation(1);
    LocalVideoFileView.a(this.a).setBackgroundResource(2130838602);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dum
 * JD-Core Version:    0.7.0.1
 */