import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;

class aecc
  implements Runnable
{
  aecc(aecb paramaecb) {}
  
  public void run()
  {
    BaseApplicationImpl.getApplication().getRuntime().getPreferences().edit().putInt("pic_light_reply_version_new", 0).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aecc
 * JD-Core Version:    0.7.0.1
 */