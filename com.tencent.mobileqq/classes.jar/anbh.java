import cooperation.qzone.video.QzoneLiveVideoGpuProxyActivity;
import cooperation.qzone.video.QzoneLiveVideoPluginProxyActivity;
import cooperation.qzone.video.QzoneLiveVideoTransparentActivity;

public class anbh
{
  public static Class a(String paramString)
  {
    if (QzoneLiveVideoPluginProxyActivity.a(QzoneLiveVideoPluginProxyActivity.a(), paramString)) {
      return QzoneLiveVideoTransparentActivity.class;
    }
    return QzoneLiveVideoGpuProxyActivity.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anbh
 * JD-Core Version:    0.7.0.1
 */