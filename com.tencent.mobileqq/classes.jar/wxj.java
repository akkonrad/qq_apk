import android.os.AsyncTask;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.activity.photo.PhotoListActivity.QueryPhotoTask;

public class wxj
  implements Runnable
{
  public wxj(PhotoListActivity paramPhotoListActivity) {}
  
  public void run()
  {
    if (this.a.a == null)
    {
      this.a.a = new PhotoListActivity.QueryPhotoTask(this.a);
      this.a.a.execute(new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wxj
 * JD-Core Version:    0.7.0.1
 */