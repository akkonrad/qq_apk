import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.TroopFileDetailBrowserActivity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.qphone.base.util.QLog;

public class adcf
  extends FMObserver
{
  public adcf(TroopFileDetailBrowserActivity paramTroopFileDetailBrowserActivity) {}
  
  protected void a(long paramLong, boolean paramBoolean, int paramInt, String paramString)
  {
    if (!paramBoolean) {
      if ((paramString != null) && (paramString.length() > 0)) {
        FileManagerUtil.a(paramString);
      }
    }
    do
    {
      do
      {
        do
        {
          return;
        } while ((this.a.b == null) || (this.a.app == null));
        if (this.a.b.b() == paramLong) {
          break;
        }
      } while (!QLog.isDevelopLevel());
      QLog.d("FileBrowserActivity<FileAssistant>", 4, "difference nSessionId");
      return;
    } while (this.a.app.a().b(paramLong) != null);
    QLog.e("FileBrowserActivity<FileAssistant>", 1, "OnTroopFileCopyToC2cDisc->,but entity is null SessionId[" + paramLong + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adcf
 * JD-Core Version:    0.7.0.1
 */