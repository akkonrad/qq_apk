import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;

public final class yum
  implements Runnable
{
  public yum(DownloadTask paramDownloadTask) {}
  
  public void run()
  {
    DownloaderFactory.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yum
 * JD-Core Version:    0.7.0.1
 */