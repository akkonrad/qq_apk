import com.tencent.mobileqq.apollo.tmg_opensdk.AVEngineWalper;
import com.tencent.mobileqq.apollo.tmg_opensdk.TMG_Downloader.TMG_Downloader_DownloadEvent;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class yvc
  extends TMG_Downloader.TMG_Downloader_DownloadEvent
{
  public yvc(AVEngineWalper paramAVEngineWalper) {}
  
  public void a(int paramInt) {}
  
  public void a(int paramInt, String paramString)
  {
    if (paramInt == 0) {
      ThreadManager.getUIHandler().post(new yvd(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yvc
 * JD-Core Version:    0.7.0.1
 */