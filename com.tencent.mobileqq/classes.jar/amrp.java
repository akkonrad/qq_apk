import com.tencent.mobileqq.app.QQAppInterface;
import cooperation.qzone.plugin.QZonePluginManager;

public final class amrp
  implements Runnable
{
  public amrp(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    QZonePluginManager localQZonePluginManager = (QZonePluginManager)this.a.getManager(174);
    if (localQZonePluginManager != null) {
      localQZonePluginManager.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amrp
 * JD-Core Version:    0.7.0.1
 */