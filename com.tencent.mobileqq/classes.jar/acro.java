import com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileAppTabView;
import com.tencent.mobileqq.filemanager.settings.FMSettings;
import com.tencent.mobileqq.filemanager.util.FileCategoryUtil;
import java.util.HashMap;

public class acro
  implements Runnable
{
  public acro(QfileLocalFileAppTabView paramQfileLocalFileAppTabView) {}
  
  public void run()
  {
    FileCategoryUtil.a(this.a.a, this.a);
    HashMap localHashMap = new HashMap();
    FileCategoryUtil.a(true, FMSettings.a().b(), ".apk", "", localHashMap, this.a);
    String str = FMSettings.a().a();
    if (str != null) {
      FileCategoryUtil.a(true, str, ".apk", "", localHashMap, null);
    }
    FileCategoryUtil.a(localHashMap);
    QfileLocalFileAppTabView.a(this.a, new acrp(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acro
 * JD-Core Version:    0.7.0.1
 */