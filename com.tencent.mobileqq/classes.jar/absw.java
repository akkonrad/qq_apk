import com.tencent.mobileqq.config.splashlogo.ConfigServlet;
import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.paster.QIMPasterConfigManager;
import dov.com.qq.im.capture.util.ConfigSimplifier.ConfigDownloadCallback;

public class absw
  implements ConfigSimplifier.ConfigDownloadCallback
{
  public absw(ConfigServlet paramConfigServlet) {}
  
  public void a(String paramString)
  {
    ((QIMPasterConfigManager)QIMManager.a(1)).a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     absw
 * JD-Core Version:    0.7.0.1
 */