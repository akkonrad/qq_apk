import com.tencent.open.downloadnew.DownloadListener;
import com.tencent.open.downloadnew.DownloadManager;

public final class fea
  implements Runnable
{
  public fea(DownloadListener paramDownloadListener) {}
  
  public void run()
  {
    DownloadManager.a().b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     fea
 * JD-Core Version:    0.7.0.1
 */