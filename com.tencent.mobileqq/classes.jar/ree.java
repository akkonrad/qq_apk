import com.tencent.mobileqq.Doraemon.AppInfo;
import com.tencent.mobileqq.Doraemon.impl.DefaultDoraemonAPIManager;
import com.tencent.mobileqq.Doraemon.impl.DefaultDoraemonAppInfoHelper.OnGetAppInfo;

public class ree
  implements DefaultDoraemonAppInfoHelper.OnGetAppInfo
{
  public ree(DefaultDoraemonAPIManager paramDefaultDoraemonAPIManager) {}
  
  public void a(AppInfo paramAppInfo)
  {
    if (paramAppInfo != null)
    {
      DefaultDoraemonAPIManager.a(this.a, paramAppInfo);
      DefaultDoraemonAPIManager.a(this.a, true);
      return;
    }
    DefaultDoraemonAPIManager.b(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ree
 * JD-Core Version:    0.7.0.1
 */