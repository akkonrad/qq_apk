import com.tencent.mobileqq.filemanager.activity.delDownloadFile.QfileLocalFileDelAppTabView;
import com.tencent.mobileqq.filemanager.settings.FMSettings;
import com.tencent.mobileqq.filemanager.util.FileCategoryUtil;
import java.util.HashMap;

public class acqh
  implements Runnable
{
  public acqh(QfileLocalFileDelAppTabView paramQfileLocalFileDelAppTabView) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    FileCategoryUtil.a(false, FMSettings.a().b(), ".apk", "", localHashMap, this.a);
    String str = FMSettings.a().a();
    if (str != null) {
      FileCategoryUtil.a(false, str, ".apk", "", localHashMap, null);
    }
    FileCategoryUtil.a(localHashMap);
    QfileLocalFileDelAppTabView.a(this.a, new acqi(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acqh
 * JD-Core Version:    0.7.0.1
 */