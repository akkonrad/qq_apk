import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.activity.aio.AIOInputTypeHelper;
import com.tencent.mobileqq.app.QQAppInterface;

public final class ujj
  implements Runnable
{
  public ujj(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    AIOInputTypeHelper.a(this.a).edit().putBoolean("ptt_guide_have_show", false).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ujj
 * JD-Core Version:    0.7.0.1
 */