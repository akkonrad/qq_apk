import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ar.arengine.ARMarkerResourceManager;
import com.tencent.mobileqq.widget.QQToast;

public class aahp
  implements Runnable
{
  public aahp(ARMarkerResourceManager paramARMarkerResourceManager) {}
  
  public void run()
  {
    QQToast.a(BaseApplicationImpl.getContext(), 1, "场景识别不支持特征追踪！", 1).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aahp
 * JD-Core Version:    0.7.0.1
 */