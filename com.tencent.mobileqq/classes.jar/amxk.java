import android.text.TextUtils;
import com.tencent.component.network.downloader.strategy.IPConfigStrategy;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import common.config.service.QzoneConfig.QzoneConfigChangeListener;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class amxk
  extends IPConfigStrategy
  implements QzoneConfig.QzoneConfigChangeListener
{
  private Map jdField_a_of_type_JavaUtilMap = new HashMap();
  private ReadWriteLock jdField_a_of_type_JavaUtilConcurrentLocksReadWriteLock = new ReentrantReadWriteLock();
  
  public amxk()
  {
    b();
    QzoneConfig.getInstance().addListener(this);
  }
  
  private void a(Map paramMap, String paramString1, String paramString2)
  {
    if ((paramMap == null) || (paramString1 == null) || (paramString2 == null)) {
      return;
    }
    String str = paramString1 + "||" + paramString2;
    paramString1 = QzoneConfig.getInstance().getConfig(paramString1, paramString2);
    if (QLog.isColorLevel()) {
      QLog.d("QZonePluginDownloadIPStracyConfig", 2, "addConfigItem, key=" + str + ", content=" + paramString1);
    }
    paramMap.put(str, paramString1);
  }
  
  private void a(Map paramMap, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if ((paramMap == null) || (paramString1 == null) || (paramString2 == null)) {
      return;
    }
    Object localObject = null;
    paramString4 = QzoneConfig.getInstance().getConfig(paramString1, paramString3, paramString4);
    paramString3 = paramString1 + "||" + paramString2;
    paramString2 = QzoneConfig.getInstance().getConfig(paramString1, paramString2);
    paramString1 = localObject;
    if (!TextUtils.isEmpty(paramString2))
    {
      paramString1 = localObject;
      if (!TextUtils.isEmpty(paramString4)) {
        paramString1 = paramString2.replace("ips", paramString4);
      }
    }
    if (TextUtils.isEmpty(paramString1))
    {
      paramMap.put(paramString3, paramString2);
      return;
    }
    paramMap.put(paramString3, paramString1);
  }
  
  private void b()
  {
    this.jdField_a_of_type_JavaUtilMap.clear();
    a(this.jdField_a_of_type_JavaUtilMap, "PhotoSvrList", "DownloadDirectIP");
    a(this.jdField_a_of_type_JavaUtilMap, "ExtraConfig", "photo_masterIplist");
    a(this.jdField_a_of_type_JavaUtilMap, "PhotoABSvrList", "DownloadDirectIP_a");
    a(this.jdField_a_of_type_JavaUtilMap, "ExtraConfig", "photo_masterIplist_a");
    a(this.jdField_a_of_type_JavaUtilMap, "PhotoABSvrList", "DownloadDirectIP_b");
    a(this.jdField_a_of_type_JavaUtilMap, "ExtraConfig", "photo_masterIplist_b");
    a(this.jdField_a_of_type_JavaUtilMap, "VideoSvrList", "DownloadDirectIPVideo");
    a(this.jdField_a_of_type_JavaUtilMap, "ExtraConfig", "video_masterIplist");
    a(this.jdField_a_of_type_JavaUtilMap, "PhotoSvrList", "optimumip_qzvv", "video_host_qzvv", "qzvv.video.qq.com");
    a(this.jdField_a_of_type_JavaUtilMap, "PhotoSvrList", "qzpb.qq.com", "video_host_qzpb", "qzpb.qq.com");
    super.a(this.jdField_a_of_type_JavaUtilMap);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QzoneIPStracyConfig", 2, "QzoneIPStracyConfig receive change");
    }
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amxk
 * JD-Core Version:    0.7.0.1
 */