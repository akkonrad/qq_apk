import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.util.SearchConfigManager;
import mqq.os.MqqHandler;

public final class xke
  implements Runnable
{
  public xke(MqqHandler paramMqqHandler) {}
  
  public void run()
  {
    SearchConfigManager.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
    if (SearchConfigManager.isConfigLoaded) {
      this.a.sendEmptyMessage(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xke
 * JD-Core Version:    0.7.0.1
 */