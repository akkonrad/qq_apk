import com.tencent.open.downloadnew.DownloadListener;
import com.tencent.open.downloadnew.DownloadManager;

public final class fdz
  implements Runnable
{
  public fdz(DownloadListener paramDownloadListener) {}
  
  public void run()
  {
    DownloadManager.a().a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     fdz
 * JD-Core Version:    0.7.0.1
 */