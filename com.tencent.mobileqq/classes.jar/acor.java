import com.tencent.mobileqq.filemanager.activity.UniformDownloadActivity;
import com.tencent.widget.ActionSheet.OnDismissListener;

public class acor
  implements ActionSheet.OnDismissListener
{
  public acor(UniformDownloadActivity paramUniformDownloadActivity) {}
  
  public void onDismiss()
  {
    this.a.finish();
    this.a.overridePendingTransition(0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acor
 * JD-Core Version:    0.7.0.1
 */