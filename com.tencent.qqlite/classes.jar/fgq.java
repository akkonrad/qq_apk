import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadSDKClient;

public class fgq
  implements Runnable
{
  public fgq(DownloadManager paramDownloadManager, String paramString) {}
  
  public void run()
  {
    try
    {
      this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager.a().pauseDownloadTask(this.jdField_a_of_type_JavaLangString);
      return;
    }
    catch (Exception localException)
    {
      LogUtility.c(DownloadManager.jdField_a_of_type_JavaLangString, "downloadSDKClient>>>", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     fgq
 * JD-Core Version:    0.7.0.1
 */