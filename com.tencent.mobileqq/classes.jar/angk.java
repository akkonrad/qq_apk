import com.tencent.open.wadl.WLog;
import cooperation.wadl.ipc.WadlProxyServiceManager;

public class angk
  implements Runnable
{
  public angk(WadlProxyServiceManager paramWadlProxyServiceManager) {}
  
  public void run()
  {
    WLog.b("WadlProxyServiceManager", "##@failed to lauch servie: reset mServiceConnecting status.");
    this.a.a = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     angk
 * JD-Core Version:    0.7.0.1
 */